package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDebug.DbStats;

public class SQLiteDatabase extends SQLiteClosable {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "3.5.6";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap();
    private static int sQueryLogTimeInMillis;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    public interface LibraryLoader {
        void loadLibraries(String... strArr);
    }

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery);
    }

    private static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        SyncUpdateInfo(String str, String str2, String str3) {
            this.masterTable = str;
            this.deletedTable = str2;
            this.foreignKey = str3;
        }
    }

    private SQLiteDatabase(String str, CursorFactory cursorFactory, int i, DatabaseErrorHandler databaseErrorHandler) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0;
        this.mLockAcquiredThreadTime = 0;
        this.mLastLockMessageTime = 0;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = MAX_SQL_CACHE_SIZE;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (str == null) {
            throw new IllegalArgumentException("path should not be null");
        }
        this.mFlags = i;
        this.mPath = str;
        this.mSlowQueryThreshold = -1;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mFactory = cursorFactory;
        this.mPrograms = new WeakHashMap();
        this.mErrorHandler = databaseErrorHandler;
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        this(str, cursorFactory, i, null);
        openDatabaseInternal(cArr, null);
    }

    public SQLiteDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(str, cursorFactory, i, null);
        openDatabaseInternal(cArr, sQLiteDatabaseHook);
    }

    private void checkLockHoldTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.mLockAcquiredWallTime;
        if ((j >= 2000 || Log.isLoggable(TAG, 2) || elapsedRealtime - this.mLastLockMessageTime >= 20000) && j > 300) {
            int threadCpuTimeNanos = (int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000);
            if (threadCpuTimeNanos > 100 || j > 2000) {
                this.mLastLockMessageTime = elapsedRealtime;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("lock held on ");
                stringBuilder.append(this.mPath);
                stringBuilder.append(" for ");
                stringBuilder.append(j);
                stringBuilder.append("ms. Thread time was ");
                stringBuilder.append(threadCpuTimeNanos);
                stringBuilder.append("ms");
                String stringBuilder2 = stringBuilder.toString();
                if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING_STACK_TRACE) {
                    Log.d(TAG, stringBuilder2, new Exception());
                } else {
                    Log.d(TAG, stringBuilder2);
                }
            }
        }
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        for (Entry key : this.mPrograms.entrySet()) {
            SQLiteClosable sQLiteClosable = (SQLiteClosable) key.getKey();
            if (sQLiteClosable != null) {
                sQLiteClosable.onAllReferencesReleasedFromContainer();
            }
        }
    }

    private boolean containsNull(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return false;
        }
        for (char c : cArr) {
            if (c == 0) {
                return true;
            }
        }
        return false;
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, String str) {
        return openDatabase(MEMORY, str == null ? null : str.toCharArray(), cursorFactory, 268435456);
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory, char[] cArr) {
        return openDatabase(MEMORY, cArr, cursorFactory, 268435456);
    }

    private native void dbclose();

    private native void dbopen(String str, int i);

    private void deallocCachedSqlStatements() {
        synchronized (this.mCompiledQueries) {
            for (SQLiteCompiledSql releaseSqlStatement : this.mCompiledQueries.values()) {
                releaseSqlStatement.releaseSqlStatement();
            }
            this.mCompiledQueries.clear();
        }
    }

    private native void enableSqlProfiling(String str);

    private native void enableSqlTracing(String str);

    public static String findEditTable(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Invalid tables");
        }
        int indexOf = str.indexOf(32);
        int indexOf2 = str.indexOf(44);
        return (indexOf <= 0 || (indexOf >= indexOf2 && indexOf2 >= 0)) ? (indexOf2 <= 0 || (indexOf2 >= indexOf && indexOf >= 0)) ? str : str.substring(0, indexOf2) : str.substring(0, indexOf);
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList arrayList = new ArrayList();
        synchronized (sActiveDatabases) {
            arrayList.addAll(sActiveDatabases.keySet());
        }
        return arrayList;
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase sQLiteDatabase) {
        if (!sQLiteDatabase.isOpen()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = sQLiteDatabase.rawQuery("pragma database_list;", null);
        while (rawQuery.moveToNext()) {
            arrayList.add(new Pair(rawQuery.getString(1), rawQuery.getString(2)));
        }
        rawQuery.close();
        return arrayList;
    }

    private byte[] getBytes(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        ByteBuffer encode = Charset.forName("UTF-8").encode(CharBuffer.wrap(cArr));
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    static ArrayList<DbStats> getDbStats() {
        ArrayList arrayList = new ArrayList();
        Iterator it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) it.next();
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.isOpen()) {
                    int native_getDbLookaside = sQLiteDatabase.native_getDbLookaside();
                    String path = sQLiteDatabase.getPath();
                    int lastIndexOf = path.lastIndexOf("/");
                    path = path.substring(lastIndexOf != -1 ? lastIndexOf + 1 : 0);
                    ArrayList attachedDbs = getAttachedDbs(sQLiteDatabase);
                    if (attachedDbs != null) {
                        int i = native_getDbLookaside;
                        for (native_getDbLookaside = 0; native_getDbLookaside < attachedDbs.size(); native_getDbLookaside++) {
                            String str;
                            Pair pair = (Pair) attachedDbs.get(native_getDbLookaside);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append((String) pair.first);
                            stringBuilder.append(".page_count;");
                            long pragmaVal = getPragmaVal(sQLiteDatabase, stringBuilder.toString());
                            if (native_getDbLookaside == 0) {
                                str = path;
                            } else {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("  (attached) ");
                                stringBuilder2.append((String) pair.first);
                                String stringBuilder3 = stringBuilder2.toString();
                                if (((String) pair.second).trim().length() > 0) {
                                    int lastIndexOf2 = ((String) pair.second).lastIndexOf("/");
                                    StringBuilder stringBuilder4 = new StringBuilder();
                                    stringBuilder4.append(stringBuilder3);
                                    stringBuilder4.append(" : ");
                                    stringBuilder4.append(((String) pair.second).substring(lastIndexOf2 != -1 ? lastIndexOf2 + 1 : 0));
                                    stringBuilder3 = stringBuilder4.toString();
                                }
                                str = stringBuilder3;
                                i = 0;
                            }
                            if (pragmaVal > 0) {
                                arrayList.add(new DbStats(str, pragmaVal, sQLiteDatabase.getPageSize(), i));
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private String getPathForLogs() {
        if (this.mPathForLogs != null) {
            return this.mPathForLogs;
        }
        if (this.mPath == null) {
            return null;
        }
        if (this.mPath.indexOf(64) == -1) {
            this.mPathForLogs = this.mPath;
        } else {
            this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        }
        return this.mPathForLogs;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030  */
    private static long getPragmaVal(net.sqlcipher.database.SQLiteDatabase r4, java.lang.String r5) {
        /*
        r0 = r4.isOpen();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r4 = 0;
        return r4;
    L_0x0009:
        r0 = 0;
        r1 = new net.sqlcipher.database.SQLiteStatement;	 Catch:{ all -> 0x002d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002d }
        r2.<init>();	 Catch:{ all -> 0x002d }
        r3 = "PRAGMA ";
        r2.append(r3);	 Catch:{ all -> 0x002d }
        r2.append(r5);	 Catch:{ all -> 0x002d }
        r5 = r2.toString();	 Catch:{ all -> 0x002d }
        r1.<init>(r4, r5);	 Catch:{ all -> 0x002d }
        r4 = r1.simpleQueryForLong();	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x0029;
    L_0x0026:
        r1.close();
    L_0x0029:
        return r4;
    L_0x002a:
        r4 = move-exception;
        r0 = r1;
        goto L_0x002e;
    L_0x002d:
        r4 = move-exception;
    L_0x002e:
        if (r0 == 0) goto L_0x0033;
    L_0x0030:
        r0.close();
    L_0x0033:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getPragmaVal(net.sqlcipher.database.SQLiteDatabase, java.lang.String):long");
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ").format(Long.valueOf(System.currentTimeMillis()));
    }

    private native void key(byte[] bArr) throws SQLException;

    private void keyDatabase(SQLiteDatabaseHook sQLiteDatabaseHook, Runnable runnable) {
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.preKey(this);
        }
        if (runnable != null) {
            runnable.run();
        }
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.postKey(this);
        }
        if (SQLiteDebug.DEBUG_SQL_CACHE) {
            this.mTimeOpened = getTime();
        }
        try {
            Cursor rawQuery = rawQuery("select count(*) from sqlite_master;", new String[0]);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                rawQuery.getInt(0);
                rawQuery.close();
            }
        } catch (RuntimeException e) {
            Log.e(TAG, e.getMessage(), e);
            throw e;
        }
    }

    private native void key_mutf8(char[] cArr) throws SQLException;

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A:{Catch:{ all -> 0x008b }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A:{Catch:{ all -> 0x008b }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e A:{SYNTHETIC, Splitter:B:44:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A:{Catch:{ IOException -> 0x0092 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008e A:{SYNTHETIC, Splitter:B:44:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0096 A:{Catch:{ IOException -> 0x0092 }} */
    private static void loadICUData(android.content.Context r5, java.io.File r6) {
        /*
        r0 = new java.io.File;
        r1 = "icu";
        r0.<init>(r6, r1);
        r6 = new java.io.File;
        r1 = "icudt46l.dat";
        r6.<init>(r0, r1);
        r1 = 0;
        r2 = r0.exists();	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
        if (r2 != 0) goto L_0x0018;
    L_0x0015:
        r0.mkdirs();	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
    L_0x0018:
        r0 = r6.exists();	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
        if (r0 != 0) goto L_0x004f;
    L_0x001e:
        r0 = new java.util.zip.ZipInputStream;	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
        r5 = r5.getAssets();	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
        r2 = "icudt46l.zip";
        r5 = r5.open(r2);	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
        r0.<init>(r5);	 Catch:{ Exception -> 0x0073, all -> 0x0070 }
        r0.getNextEntry();	 Catch:{ Exception -> 0x004d }
        r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x004d }
        r5.<init>(r6);	 Catch:{ Exception -> 0x004d }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x0048, all -> 0x0044 }
    L_0x0039:
        r2 = r0.read(r1);	 Catch:{ Exception -> 0x0048, all -> 0x0044 }
        if (r2 <= 0) goto L_0x0051;
    L_0x003f:
        r3 = 0;
        r5.write(r1, r3, r2);	 Catch:{ Exception -> 0x0048, all -> 0x0044 }
        goto L_0x0039;
    L_0x0044:
        r6 = move-exception;
        r1 = r5;
        r5 = r6;
        goto L_0x008c;
    L_0x0048:
        r1 = move-exception;
        r4 = r1;
        r1 = r5;
        r5 = r4;
        goto L_0x0075;
    L_0x004d:
        r5 = move-exception;
        goto L_0x0075;
    L_0x004f:
        r5 = r1;
        r0 = r5;
    L_0x0051:
        if (r0 == 0) goto L_0x0059;
    L_0x0053:
        r0.close();	 Catch:{ IOException -> 0x0057 }
        goto L_0x0059;
    L_0x0057:
        r5 = move-exception;
        goto L_0x0062;
    L_0x0059:
        if (r5 == 0) goto L_0x006f;
    L_0x005b:
        r5.flush();	 Catch:{ IOException -> 0x0057 }
        r5.close();	 Catch:{ IOException -> 0x0057 }
        goto L_0x006f;
    L_0x0062:
        r6 = "Database";
        r0 = "Error in closing streams IO streams after expanding ICU dat file";
        android.util.Log.e(r6, r0, r5);
        r6 = new java.lang.RuntimeException;
        r6.<init>(r5);
        throw r6;
    L_0x006f:
        return;
    L_0x0070:
        r5 = move-exception;
        r0 = r1;
        goto L_0x008c;
    L_0x0073:
        r5 = move-exception;
        r0 = r1;
    L_0x0075:
        r2 = "Database";
        r3 = "Error copying icu dat file";
        android.util.Log.e(r2, r3, r5);	 Catch:{ all -> 0x008b }
        r2 = r6.exists();	 Catch:{ all -> 0x008b }
        if (r2 == 0) goto L_0x0085;
    L_0x0082:
        r6.delete();	 Catch:{ all -> 0x008b }
    L_0x0085:
        r6 = new java.lang.RuntimeException;	 Catch:{ all -> 0x008b }
        r6.<init>(r5);	 Catch:{ all -> 0x008b }
        throw r6;	 Catch:{ all -> 0x008b }
    L_0x008b:
        r5 = move-exception;
    L_0x008c:
        if (r0 == 0) goto L_0x0094;
    L_0x008e:
        r0.close();	 Catch:{ IOException -> 0x0092 }
        goto L_0x0094;
    L_0x0092:
        r5 = move-exception;
        goto L_0x009d;
    L_0x0094:
        if (r1 == 0) goto L_0x00aa;
    L_0x0096:
        r1.flush();	 Catch:{ IOException -> 0x0092 }
        r1.close();	 Catch:{ IOException -> 0x0092 }
        goto L_0x00aa;
    L_0x009d:
        r6 = "Database";
        r0 = "Error in closing streams IO streams after expanding ICU dat file";
        android.util.Log.e(r6, r0, r5);
        r6 = new java.lang.RuntimeException;
        r6.<init>(r5);
        throw r6;
    L_0x00aa:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.loadICUData(android.content.Context, java.io.File):void");
    }

    public static synchronized void loadLibs(Context context) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir());
        }
    }

    public static synchronized void loadLibs(Context context, File file) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, file, new LibraryLoader() {
                public void loadLibraries(String... strArr) {
                    for (String loadLibrary : strArr) {
                        System.loadLibrary(loadLibrary);
                    }
                }
            });
        }
    }

    public static synchronized void loadLibs(Context context, File file, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            libraryLoader.loadLibraries("sqlcipher");
        }
    }

    public static synchronized void loadLibs(Context context, LibraryLoader libraryLoader) {
        synchronized (SQLiteDatabase.class) {
            loadLibs(context, context.getFilesDir(), libraryLoader);
        }
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        }
    }

    private void markTableSyncable(String str, String str2, String str3, String str4) {
        lock();
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT _sync_dirty FROM ");
            stringBuilder.append(str3);
            stringBuilder.append(" LIMIT 0");
            native_execSQL(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT ");
            stringBuilder.append(str2);
            stringBuilder.append(" FROM ");
            stringBuilder.append(str);
            stringBuilder.append(" LIMIT 0");
            native_execSQL(stringBuilder.toString());
            SyncUpdateInfo syncUpdateInfo = new SyncUpdateInfo(str3, str4, str2);
            synchronized (this.mSyncUpdateInfo) {
                this.mSyncUpdateInfo.put(str, syncUpdateInfo);
            }
        } finally {
            unlock();
        }
    }

    private native int native_getDbLookaside();

    private native void native_key(char[] cArr) throws SQLException;

    private native void native_rawExecSQL(String str);

    private native void native_rekey(String str) throws SQLException;

    private native int native_status(int i, boolean z);

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i) {
        return openDatabase(str, str2, cursorFactory, i, null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, i, sQLiteDatabaseHook, null);
    }

    public static SQLiteDatabase openDatabase(String str, String str2, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, i, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i) {
        return openDatabase(str, cArr, cursorFactory, i, null, null);
    }

    public static SQLiteDatabase openDatabase(String str, char[] cArr, CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, i, sQLiteDatabaseHook, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A:{SYNTHETIC} */
    public static net.sqlcipher.database.SQLiteDatabase openDatabase(java.lang.String r6, char[] r7, net.sqlcipher.database.SQLiteDatabase.CursorFactory r8, int r9, net.sqlcipher.database.SQLiteDatabaseHook r10, net.sqlcipher.DatabaseErrorHandler r11) {
        /*
        if (r11 == 0) goto L_0x0003;
    L_0x0002:
        goto L_0x0008;
    L_0x0003:
        r11 = new net.sqlcipher.DefaultDatabaseErrorHandler;
        r11.<init>();
    L_0x0008:
        r0 = 0;
        r1 = new net.sqlcipher.database.SQLiteDatabase;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0014 }
        r1.<init>(r6, r8, r9, r11);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0014 }
        r1.openDatabaseInternal(r7, r10);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0012 }
        goto L_0x0037;
    L_0x0012:
        r2 = move-exception;
        goto L_0x0016;
    L_0x0014:
        r2 = move-exception;
        r1 = r0;
    L_0x0016:
        r3 = "Database";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Calling error handler for corrupt database ";
        r4.append(r5);
        r4.append(r6);
        r4 = r4.toString();
        android.util.Log.e(r3, r4, r2);
        r11.onCorruption(r1);
        r1 = new net.sqlcipher.database.SQLiteDatabase;
        r1.<init>(r6, r8, r9, r11);
        r1.openDatabaseInternal(r7, r10);
    L_0x0037:
        r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_STATEMENTS;
        if (r7 == 0) goto L_0x003e;
    L_0x003b:
        r1.enableSqlTracing(r6);
    L_0x003e:
        r7 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_TIME;
        if (r7 == 0) goto L_0x0045;
    L_0x0042:
        r1.enableSqlProfiling(r6);
    L_0x0045:
        r6 = sActiveDatabases;
        monitor-enter(r6);
        r7 = sActiveDatabases;	 Catch:{ all -> 0x004f }
        r7.put(r1, r0);	 Catch:{ all -> 0x004f }
        monitor-exit(r6);	 Catch:{ all -> 0x004f }
        return r1;
    L_0x004f:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x004f }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.openDatabase(java.lang.String, char[], net.sqlcipher.database.SQLiteDatabase$CursorFactory, int, net.sqlcipher.database.SQLiteDatabaseHook, net.sqlcipher.DatabaseErrorHandler):net.sqlcipher.database.SQLiteDatabase");
    }

    private void openDatabaseInternal(final char[] cArr, SQLiteDatabaseHook sQLiteDatabaseHook) {
        final byte[] bytes = getBytes(cArr);
        dbopen(this.mPath, this.mFlags);
        int i = 0;
        int length;
        byte b;
        try {
            keyDatabase(sQLiteDatabaseHook, new Runnable() {
                public void run() {
                    if (bytes != null && bytes.length > 0) {
                        SQLiteDatabase.this.key(bytes);
                    }
                }
            });
            if (bytes != null && bytes.length > 0) {
                length = bytes.length;
                while (i < length) {
                    b = bytes[i];
                    i++;
                }
            }
        } catch (RuntimeException e) {
            if (containsNull(cArr)) {
                keyDatabase(sQLiteDatabaseHook, new Runnable() {
                    public void run() {
                        if (cArr != null) {
                            SQLiteDatabase.this.key_mutf8(cArr);
                        }
                    }
                });
                if (bytes != null && bytes.length > 0) {
                    rekey(bytes);
                }
                if (bytes != null && bytes.length > 0) {
                    length = bytes.length;
                    while (i < length) {
                        b = bytes[i];
                        i++;
                    }
                    return;
                }
                return;
            }
            throw e;
        } catch (Throwable th) {
            dbclose();
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            if (bytes != null && bytes.length > 0) {
                int length2 = bytes.length;
                while (i < length2) {
                    byte b2 = bytes[i];
                    i++;
                }
            }
        }
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory) {
        return openOrCreateDatabase(file, str, cursorFactory, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openOrCreateDatabase(file, str, cursorFactory, sQLiteDatabaseHook, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, String str, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openOrCreateDatabase(file == null ? null : file.getPath(), str, cursorFactory, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory) {
        return openDatabase(str, str2, cursorFactory, 268435456, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, str2, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, String str2, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, str2 == null ? null : str2.toCharArray(), cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory) {
        return openDatabase(str, cArr, cursorFactory, 268435456, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook);
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, char[] cArr, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        return openDatabase(str, cArr, cursorFactory, 268435456, sQLiteDatabaseHook, databaseErrorHandler);
    }

    private native void rekey(byte[] bArr) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String str);

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
            checkLockHoldTime();
        }
        this.mLock.unlock();
    }

    private boolean yieldIfContendedHelper(boolean z, long j) {
        if (this.mLock.getQueueLength() == 0) {
            this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
            this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            return false;
        }
        setTransactionSuccessful();
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionListener;
        endTransaction();
        if (z && isDbLockedByCurrentThread()) {
            throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
        }
        if (j > 0) {
            while (j > 0) {
                try {
                    Thread.sleep(j < 1000 ? j : 1000);
                } catch (InterruptedException unused) {
                    Thread.interrupted();
                }
                long j2 = j - 1000;
                if (this.mLock.getQueueLength() == 0) {
                    break;
                }
                j = j2;
            }
        }
        beginTransactionWithListener(sQLiteTransactionListener);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void addSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.put(sQLiteClosable, null);
        } finally {
            unlock();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:22:0x00b3, code skipped:
            return;
     */
    public void addToCompiledQueries(java.lang.String r4, net.sqlcipher.database.SQLiteCompiledSql r5) {
        /*
        r3 = this;
        r0 = r3.mMaxSqlCacheSize;
        if (r0 != 0) goto L_0x002b;
    L_0x0004:
        r5 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;
        if (r5 == 0) goto L_0x002a;
    L_0x0008:
        r5 = "Database";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "|NOT adding_sql_to_cache|";
        r0.append(r1);
        r1 = r3.getPath();
        r0.append(r1);
        r1 = "|";
        r0.append(r1);
        r0.append(r4);
        r4 = r0.toString();
        android.util.Log.v(r5, r4);
    L_0x002a:
        return;
    L_0x002b:
        r0 = r3.mCompiledQueries;
        monitor-enter(r0);
        r1 = r3.mCompiledQueries;	 Catch:{ all -> 0x00b4 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x00b4 }
        r1 = (net.sqlcipher.database.SQLiteCompiledSql) r1;	 Catch:{ all -> 0x00b4 }
        if (r1 == 0) goto L_0x003a;
    L_0x0038:
        monitor-exit(r0);	 Catch:{ all -> 0x00b4 }
        return;
    L_0x003a:
        r1 = r3.mCompiledQueries;	 Catch:{ all -> 0x00b4 }
        r1 = r1.size();	 Catch:{ all -> 0x00b4 }
        r2 = r3.mMaxSqlCacheSize;	 Catch:{ all -> 0x00b4 }
        if (r1 != r2) goto L_0x0079;
    L_0x0044:
        r5 = r3.mCacheFullWarnings;	 Catch:{ all -> 0x00b4 }
        r1 = 1;
        r5 = r5 + r1;
        r3.mCacheFullWarnings = r5;	 Catch:{ all -> 0x00b4 }
        if (r5 != r1) goto L_0x00b2;
    L_0x004c:
        r5 = "Database";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b4 }
        r1.<init>();	 Catch:{ all -> 0x00b4 }
        r2 = "Reached MAX size for compiled-sql statement cache for database ";
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r2 = r3.getPath();	 Catch:{ all -> 0x00b4 }
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r2 = "; i.e., NO space for this sql statement in cache: ";
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r1.append(r4);	 Catch:{ all -> 0x00b4 }
        r4 = ". Please change your sql statements to use '?' for ";
        r1.append(r4);	 Catch:{ all -> 0x00b4 }
        r4 = "bindargs, instead of using actual values";
        r1.append(r4);	 Catch:{ all -> 0x00b4 }
        r4 = r1.toString();	 Catch:{ all -> 0x00b4 }
        android.util.Log.w(r5, r4);	 Catch:{ all -> 0x00b4 }
        goto L_0x00b2;
    L_0x0079:
        r1 = r3.mCompiledQueries;	 Catch:{ all -> 0x00b4 }
        r1.put(r4, r5);	 Catch:{ all -> 0x00b4 }
        r5 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;	 Catch:{ all -> 0x00b4 }
        if (r5 == 0) goto L_0x00b2;
    L_0x0082:
        r5 = "Database";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b4 }
        r1.<init>();	 Catch:{ all -> 0x00b4 }
        r2 = "|adding_sql_to_cache|";
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r2 = r3.getPath();	 Catch:{ all -> 0x00b4 }
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r2 = "|";
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r2 = r3.mCompiledQueries;	 Catch:{ all -> 0x00b4 }
        r2 = r2.size();	 Catch:{ all -> 0x00b4 }
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r2 = "|";
        r1.append(r2);	 Catch:{ all -> 0x00b4 }
        r1.append(r4);	 Catch:{ all -> 0x00b4 }
        r4 = r1.toString();	 Catch:{ all -> 0x00b4 }
        android.util.Log.v(r5, r4);	 Catch:{ all -> 0x00b4 }
    L_0x00b2:
        monitor-exit(r0);	 Catch:{ all -> 0x00b4 }
        return;
    L_0x00b4:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00b4 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.addToCompiledQueries(java.lang.String, net.sqlcipher.database.SQLiteCompiledSql):void");
    }

    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        lockForced();
        if (isOpen()) {
            try {
                if (this.mLock.getHoldCount() <= 1) {
                    execSQL("BEGIN EXCLUSIVE;");
                    this.mTransactionListener = sQLiteTransactionListener;
                    this.mTransactionIsSuccessful = true;
                    this.mInnerTransactionIsSuccessful = false;
                    if (sQLiteTransactionListener != null) {
                        sQLiteTransactionListener.onBegin();
                    }
                } else if (this.mInnerTransactionIsSuccessful) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");
                    Log.e(TAG, "beginTransaction() failed", illegalStateException);
                    throw illegalStateException;
                }
            } catch (RuntimeException e) {
                execSQL("ROLLBACK;");
                throw e;
            } catch (Throwable th) {
                unlockForced();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public void changePassword(String str) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (str != null) {
            byte[] bytes = getBytes(str.toCharArray());
            rekey(bytes);
            for (byte b : bytes) {
            }
        }
    }

    public void changePassword(char[] cArr) throws SQLiteException {
        if (!isOpen()) {
            throw new SQLiteException("database not open");
        } else if (cArr != null) {
            byte[] bytes = getBytes(cArr);
            rekey(bytes);
            for (byte b : bytes) {
            }
        }
    }

    public void close() {
        if (isOpen()) {
            lock();
            try {
                closeClosable();
                onAllReferencesReleased();
            } finally {
                unlock();
            }
        }
    }

    public SQLiteStatement compileStatement(String str) throws SQLException {
        lock();
        SQLiteStatement isOpen = isOpen();
        if (isOpen == true) {
            try {
                isOpen = new SQLiteStatement(this, str);
                return isOpen;
            } finally {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0074  */
    public int delete(java.lang.String r4, java.lang.String r5, java.lang.String[] r6) {
        /*
        r3 = this;
        r3.lock();
        r0 = r3.isOpen();
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r4 = new java.lang.IllegalStateException;
        r5 = "database not open";
        r4.<init>(r5);
        throw r4;
    L_0x0011:
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r1.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r2 = "DELETE FROM ";
        r1.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r1.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r4 = android.text.TextUtils.isEmpty(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        if (r4 != 0) goto L_0x0037;
    L_0x0025:
        r4 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r4.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r2 = " WHERE ";
        r4.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r4.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r4 = r4.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        goto L_0x0039;
    L_0x0037:
        r4 = "";
    L_0x0039:
        r1.append(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r4 = r1.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        r4 = r3.compileStatement(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x006d }
        if (r6 == 0) goto L_0x005b;
    L_0x0046:
        r5 = r6.length;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0057, all -> 0x0053 }
        r0 = 0;
    L_0x0048:
        if (r0 >= r5) goto L_0x005b;
    L_0x004a:
        r1 = r0 + 1;
        r0 = r6[r0];	 Catch:{ SQLiteDatabaseCorruptException -> 0x0057, all -> 0x0053 }
        net.sqlcipher.DatabaseUtils.bindObjectToProgram(r4, r1, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0057, all -> 0x0053 }
        r0 = r1;
        goto L_0x0048;
    L_0x0053:
        r5 = move-exception;
        r0 = r4;
        r4 = r5;
        goto L_0x0072;
    L_0x0057:
        r5 = move-exception;
        r0 = r4;
        r4 = r5;
        goto L_0x006e;
    L_0x005b:
        r4.execute();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0057, all -> 0x0053 }
        r5 = r3.lastChangeCount();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0057, all -> 0x0053 }
        if (r4 == 0) goto L_0x0067;
    L_0x0064:
        r4.close();
    L_0x0067:
        r3.unlock();
        return r5;
    L_0x006b:
        r4 = move-exception;
        goto L_0x0072;
    L_0x006d:
        r4 = move-exception;
    L_0x006e:
        r3.onCorruption();	 Catch:{ all -> 0x006b }
        throw r4;	 Catch:{ all -> 0x006b }
    L_0x0072:
        if (r0 == 0) goto L_0x0077;
    L_0x0074:
        r0.close();
    L_0x0077:
        r3.unlock();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.delete(java.lang.String, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0063 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:38|39) */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            android.util.Log.d(TAG, "exception during rollback, maybe the DB previously performed an auto-rollback");
     */
    public void endTransaction() {
        /*
        r4 = this;
        r0 = r4.isOpen();
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "database not open";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = r4.mLock;
        r0 = r0.isHeldByCurrentThread();
        if (r0 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new java.lang.IllegalStateException;
        r1 = "no transaction pending";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r0 = 0;
        r1 = r4.mInnerTransactionIsSuccessful;	 Catch:{ all -> 0x0070 }
        r2 = 0;
        if (r1 == 0) goto L_0x0027;
    L_0x0024:
        r4.mInnerTransactionIsSuccessful = r2;	 Catch:{ all -> 0x0070 }
        goto L_0x0029;
    L_0x0027:
        r4.mTransactionIsSuccessful = r2;	 Catch:{ all -> 0x0070 }
    L_0x0029:
        r1 = r4.mLock;	 Catch:{ all -> 0x0070 }
        r1 = r1.getHoldCount();	 Catch:{ all -> 0x0070 }
        r3 = 1;
        if (r1 == r3) goto L_0x0038;
    L_0x0032:
        r4.mTransactionListener = r0;
        r4.unlockForced();
        return;
    L_0x0038:
        r1 = r4.mTransactionListener;	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x0050;
    L_0x003c:
        r1 = r4.mTransactionIsSuccessful;	 Catch:{ RuntimeException -> 0x004c }
        if (r1 == 0) goto L_0x0046;
    L_0x0040:
        r1 = r4.mTransactionListener;	 Catch:{ RuntimeException -> 0x004c }
        r1.onCommit();	 Catch:{ RuntimeException -> 0x004c }
        goto L_0x0050;
    L_0x0046:
        r1 = r4.mTransactionListener;	 Catch:{ RuntimeException -> 0x004c }
        r1.onRollback();	 Catch:{ RuntimeException -> 0x004c }
        goto L_0x0050;
    L_0x004c:
        r1 = move-exception;
        r4.mTransactionIsSuccessful = r2;	 Catch:{ all -> 0x0070 }
        goto L_0x0051;
    L_0x0050:
        r1 = r0;
    L_0x0051:
        r2 = r4.mTransactionIsSuccessful;	 Catch:{ all -> 0x0070 }
        if (r2 == 0) goto L_0x005b;
    L_0x0055:
        r1 = "COMMIT;";
        r4.execSQL(r1);	 Catch:{ all -> 0x0070 }
        goto L_0x006a;
    L_0x005b:
        r2 = "ROLLBACK;";
        r4.execSQL(r2);	 Catch:{ SQLException -> 0x0063 }
        if (r1 == 0) goto L_0x006a;
    L_0x0062:
        throw r1;	 Catch:{ SQLException -> 0x0063 }
    L_0x0063:
        r1 = "Database";
        r2 = "exception during rollback, maybe the DB previously performed an auto-rollback";
        android.util.Log.d(r1, r2);	 Catch:{ all -> 0x0070 }
    L_0x006a:
        r4.mTransactionListener = r0;
        r4.unlockForced();
        return;
    L_0x0070:
        r1 = move-exception;
        r4.mTransactionListener = r0;
        r4.unlockForced();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.endTransaction():void");
    }

    public void execSQL(String str) throws SQLException {
        SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            try {
                native_execSQL(str);
                unlock();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x004d  */
    public void execSQL(java.lang.String r4, java.lang.Object[] r5) throws net.sqlcipher.SQLException {
        /*
        r3 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r4 = new java.lang.IllegalArgumentException;
        r5 = "Empty bindArgs";
        r4.<init>(r5);
        throw r4;
    L_0x000a:
        android.os.SystemClock.uptimeMillis();
        r3.lock();
        r0 = r3.isOpen();
        if (r0 != 0) goto L_0x001e;
    L_0x0016:
        r4 = new java.lang.IllegalStateException;
        r5 = "database not open";
        r4.<init>(r5);
        throw r4;
    L_0x001e:
        r0 = 0;
        r4 = r3.compileStatement(r4);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0046 }
        if (r5 == 0) goto L_0x0037;
    L_0x0025:
        r0 = r5.length;	 Catch:{ SQLiteDatabaseCorruptException -> 0x0034, all -> 0x0032 }
        r1 = 0;
    L_0x0027:
        if (r1 >= r0) goto L_0x0037;
    L_0x0029:
        r2 = r1 + 1;
        r1 = r5[r1];	 Catch:{ SQLiteDatabaseCorruptException -> 0x0034, all -> 0x0032 }
        net.sqlcipher.DatabaseUtils.bindObjectToProgram(r4, r2, r1);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0034, all -> 0x0032 }
        r1 = r2;
        goto L_0x0027;
    L_0x0032:
        r5 = move-exception;
        goto L_0x004b;
    L_0x0034:
        r5 = move-exception;
        r0 = r4;
        goto L_0x0047;
    L_0x0037:
        r4.execute();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0034, all -> 0x0032 }
        if (r4 == 0) goto L_0x003f;
    L_0x003c:
        r4.close();
    L_0x003f:
        r3.unlock();
        return;
    L_0x0043:
        r5 = move-exception;
        r4 = r0;
        goto L_0x004b;
    L_0x0046:
        r5 = move-exception;
    L_0x0047:
        r3.onCorruption();	 Catch:{ all -> 0x0043 }
        throw r5;	 Catch:{ all -> 0x0043 }
    L_0x004b:
        if (r4 == 0) goto L_0x0050;
    L_0x004d:
        r4.close();
    L_0x0050:
        r3.unlock();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.execSQL(java.lang.String, java.lang.Object[]):void");
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        if (isOpen()) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("close() was never explicitly called on database '");
            stringBuilder.append(this.mPath);
            stringBuilder.append("' ");
            Log.e(str, stringBuilder.toString(), this.mStackTrace);
            closeClosable();
            onAllReferencesReleased();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:16:0x0037, code skipped:
            if (r3 == false) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:17:0x0039, code skipped:
            r5.mNumCacheHits++;
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code skipped:
            r5.mNumCacheMisses++;
     */
    /* JADX WARNING: Missing block: B:20:0x0046, code skipped:
            if (net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE == false) goto L_0x00a8;
     */
    /* JADX WARNING: Missing block: B:21:0x0048, code skipped:
            r0 = TAG;
            r2 = new java.lang.StringBuilder();
            r2.append("|cache_stats|");
            r2.append(getPath());
            r2.append("|");
            r2.append(r5.mCompiledQueries.size());
            r2.append("|");
            r2.append(r5.mNumCacheHits);
            r2.append("|");
            r2.append(r5.mNumCacheMisses);
            r2.append("|");
            r2.append(r3);
            r2.append("|");
            r2.append(r5.mTimeOpened);
            r2.append("|");
            r2.append(r5.mTimeClosed);
            r2.append("|");
            r2.append(r6);
            android.util.Log.v(r0, r2.toString());
     */
    /* JADX WARNING: Missing block: B:22:0x00a8, code skipped:
            return r1;
     */
    public net.sqlcipher.database.SQLiteCompiledSql getCompiledStatementForSql(java.lang.String r6) {
        /*
        r5 = this;
        r0 = r5.mCompiledQueries;
        monitor-enter(r0);
        r1 = r5.mMaxSqlCacheSize;	 Catch:{ all -> 0x00a9 }
        if (r1 != 0) goto L_0x0028;
    L_0x0007:
        r6 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;	 Catch:{ all -> 0x00a9 }
        if (r6 == 0) goto L_0x0025;
    L_0x000b:
        r6 = "Database";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a9 }
        r1.<init>();	 Catch:{ all -> 0x00a9 }
        r2 = "|cache NOT found|";
        r1.append(r2);	 Catch:{ all -> 0x00a9 }
        r2 = r5.getPath();	 Catch:{ all -> 0x00a9 }
        r1.append(r2);	 Catch:{ all -> 0x00a9 }
        r1 = r1.toString();	 Catch:{ all -> 0x00a9 }
        android.util.Log.v(r6, r1);	 Catch:{ all -> 0x00a9 }
    L_0x0025:
        r6 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x00a9 }
        return r6;
    L_0x0028:
        r1 = r5.mCompiledQueries;	 Catch:{ all -> 0x00a9 }
        r1 = r1.get(r6);	 Catch:{ all -> 0x00a9 }
        r1 = (net.sqlcipher.database.SQLiteCompiledSql) r1;	 Catch:{ all -> 0x00a9 }
        r2 = 1;
        if (r1 == 0) goto L_0x0035;
    L_0x0033:
        r3 = r2;
        goto L_0x0036;
    L_0x0035:
        r3 = 0;
    L_0x0036:
        monitor-exit(r0);	 Catch:{ all -> 0x00a9 }
        if (r3 == 0) goto L_0x003f;
    L_0x0039:
        r0 = r5.mNumCacheHits;
        r0 = r0 + r2;
        r5.mNumCacheHits = r0;
        goto L_0x0044;
    L_0x003f:
        r0 = r5.mNumCacheMisses;
        r0 = r0 + r2;
        r5.mNumCacheMisses = r0;
    L_0x0044:
        r0 = net.sqlcipher.database.SQLiteDebug.DEBUG_SQL_CACHE;
        if (r0 == 0) goto L_0x00a8;
    L_0x0048:
        r0 = "Database";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "|cache_stats|";
        r2.append(r4);
        r4 = r5.getPath();
        r2.append(r4);
        r4 = "|";
        r2.append(r4);
        r4 = r5.mCompiledQueries;
        r4 = r4.size();
        r2.append(r4);
        r4 = "|";
        r2.append(r4);
        r4 = r5.mNumCacheHits;
        r2.append(r4);
        r4 = "|";
        r2.append(r4);
        r4 = r5.mNumCacheMisses;
        r2.append(r4);
        r4 = "|";
        r2.append(r4);
        r2.append(r3);
        r3 = "|";
        r2.append(r3);
        r3 = r5.mTimeOpened;
        r2.append(r3);
        r3 = "|";
        r2.append(r3);
        r3 = r5.mTimeClosed;
        r2.append(r3);
        r3 = "|";
        r2.append(r3);
        r2.append(r6);
        r6 = r2.toString();
        android.util.Log.v(r0, r6);
    L_0x00a8:
        return r1;
    L_0x00a9:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00a9 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getCompiledStatementForSql(java.lang.String):net.sqlcipher.database.SQLiteCompiledSql");
    }

    public synchronized int getMaxSqlCacheSize() {
        return this.mMaxSqlCacheSize;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    public long getMaximumSize() {
        /*
        r7 = this;
        r7.lock();
        r0 = r7.isOpen();
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = new java.lang.IllegalStateException;
        r1 = "database not open";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r0 = 0;
        r1 = new net.sqlcipher.database.SQLiteStatement;	 Catch:{ all -> 0x0030 }
        r2 = "PRAGMA max_page_count;";
        r1.<init>(r7, r2);	 Catch:{ all -> 0x0030 }
        r2 = r1.simpleQueryForLong();	 Catch:{ all -> 0x002b }
        r4 = r7.getPageSize();	 Catch:{ all -> 0x002b }
        r2 = r2 * r4;
        if (r1 == 0) goto L_0x0027;
    L_0x0024:
        r1.close();
    L_0x0027:
        r7.unlock();
        return r2;
    L_0x002b:
        r0 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0031;
    L_0x0030:
        r1 = move-exception;
    L_0x0031:
        if (r0 == 0) goto L_0x0036;
    L_0x0033:
        r0.close();
    L_0x0036:
        r7.unlock();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getMaximumSize():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    public long getPageSize() {
        /*
        r5 = this;
        r5.lock();
        r0 = r5.isOpen();
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = new java.lang.IllegalStateException;
        r1 = "database not open";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r0 = 0;
        r1 = new net.sqlcipher.database.SQLiteStatement;	 Catch:{ all -> 0x002b }
        r2 = "PRAGMA page_size;";
        r1.<init>(r5, r2);	 Catch:{ all -> 0x002b }
        r2 = r1.simpleQueryForLong();	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();
    L_0x0022:
        r5.unlock();
        return r2;
    L_0x0026:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x002c;
    L_0x002b:
        r1 = move-exception;
    L_0x002c:
        if (r0 == 0) goto L_0x0031;
    L_0x002e:
        r0.close();
    L_0x0031:
        r5.unlock();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getPageSize():long");
    }

    public final String getPath() {
        return this.mPath;
    }

    public Map<String, String> getSyncedTables() {
        HashMap hashMap;
        synchronized (this.mSyncUpdateInfo) {
            hashMap = new HashMap();
            for (String str : this.mSyncUpdateInfo.keySet()) {
                SyncUpdateInfo syncUpdateInfo = (SyncUpdateInfo) this.mSyncUpdateInfo.get(str);
                if (syncUpdateInfo.deletedTable != null) {
                    hashMap.put(str, syncUpdateInfo.deletedTable);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    public int getVersion() {
        /*
        r5 = this;
        r5.lock();
        r0 = r5.isOpen();
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r0 = new java.lang.IllegalStateException;
        r1 = "database not open";
        r0.<init>(r1);
        throw r0;
    L_0x0011:
        r0 = 0;
        r1 = new net.sqlcipher.database.SQLiteStatement;	 Catch:{ all -> 0x002c }
        r2 = "PRAGMA user_version;";
        r1.<init>(r5, r2);	 Catch:{ all -> 0x002c }
        r2 = r1.simpleQueryForLong();	 Catch:{ all -> 0x0027 }
        r0 = (int) r2;
        if (r1 == 0) goto L_0x0023;
    L_0x0020:
        r1.close();
    L_0x0023:
        r5.unlock();
        return r0;
    L_0x0027:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x002d;
    L_0x002c:
        r1 = move-exception;
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();
    L_0x0032:
        r5.unlock();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.getVersion():int");
    }

    public boolean inTransaction() {
        return this.mLock.getHoldCount() > 0;
    }

    public long insert(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 0);
        } catch (SQLException e) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error inserting <redacted values> into ");
            stringBuilder.append(str);
            Log.e(str3, stringBuilder.toString(), e);
            return -1;
        }
    }

    public long insertOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x012a  */
    public long insertWithOnConflict(java.lang.String r6, java.lang.String r7, android.content.ContentValues r8, int r9) {
        /*
        r5 = this;
        r0 = r5.isOpen();
        if (r0 != 0) goto L_0x000e;
    L_0x0006:
        r6 = new java.lang.IllegalStateException;
        r7 = "database not open";
        r6.<init>(r7);
        throw r6;
    L_0x000e:
        r0 = new java.lang.StringBuilder;
        r1 = 152; // 0x98 float:2.13E-43 double:7.5E-322;
        r0.<init>(r1);
        r1 = "INSERT";
        r0.append(r1);
        r1 = CONFLICT_VALUES;
        r9 = r1[r9];
        r0.append(r9);
        r9 = " INTO ";
        r0.append(r9);
        r0.append(r6);
        r9 = new java.lang.StringBuilder;
        r1 = 40;
        r9.<init>(r1);
        r2 = 0;
        r3 = 0;
        if (r8 == 0) goto L_0x0074;
    L_0x0034:
        r4 = r8.size();
        if (r4 <= 0) goto L_0x0074;
    L_0x003a:
        r7 = r8.valueSet();
        r8 = r7.iterator();
        r0.append(r1);
        r1 = r2;
    L_0x0046:
        r4 = r8.hasNext();
        if (r4 == 0) goto L_0x006e;
    L_0x004c:
        if (r1 == 0) goto L_0x0058;
    L_0x004e:
        r1 = ", ";
        r0.append(r1);
        r1 = ", ";
        r9.append(r1);
    L_0x0058:
        r1 = r8.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getKey();
        r1 = (java.lang.String) r1;
        r0.append(r1);
        r1 = 63;
        r9.append(r1);
        r1 = 1;
        goto L_0x0046;
    L_0x006e:
        r8 = 41;
        r0.append(r8);
        goto L_0x0093;
    L_0x0074:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r1 = "(";
        r8.append(r1);
        r8.append(r7);
        r7 = ") ";
        r8.append(r7);
        r7 = r8.toString();
        r0.append(r7);
        r7 = "NULL";
        r9.append(r7);
        r7 = r3;
    L_0x0093:
        r8 = " VALUES(";
        r0.append(r8);
        r0.append(r9);
        r8 = ");";
        r0.append(r8);
        r5.lock();
        r8 = r0.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0123 }
        r8 = r5.compileStatement(r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0123 }
        if (r7 == 0) goto L_0x00cc;
    L_0x00ad:
        r9 = r7.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r7 = r7.iterator();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
    L_0x00b5:
        if (r2 >= r9) goto L_0x00cc;
    L_0x00b7:
        r0 = r7.next();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r2 = r2 + 1;
        r0 = r0.getValue();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        net.sqlcipher.DatabaseUtils.bindObjectToProgram(r8, r2, r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        goto L_0x00b5;
    L_0x00c7:
        r6 = move-exception;
        goto L_0x0128;
    L_0x00c9:
        r6 = move-exception;
        r3 = r8;
        goto L_0x0124;
    L_0x00cc:
        r8.execute();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r0 = r5.lastInsertRow();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r2 = -1;
        r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r7 != 0) goto L_0x00f0;
    L_0x00d9:
        r7 = "Database";
        r9 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r9.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r2 = "Error inserting <redacted values> using <redacted sql> into ";
        r9.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r9.append(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r6 = r9.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        android.util.Log.e(r7, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        goto L_0x0117;
    L_0x00f0:
        r7 = "Database";
        r9 = 2;
        r7 = android.util.Log.isLoggable(r7, r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        if (r7 == 0) goto L_0x0117;
    L_0x00f9:
        r7 = "Database";
        r9 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r9.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r2 = "Inserting row ";
        r9.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r9.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r2 = " from <redacted values> using <redacted sql> into ";
        r9.append(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r9.append(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        r6 = r9.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
        android.util.Log.v(r7, r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00c9, all -> 0x00c7 }
    L_0x0117:
        if (r8 == 0) goto L_0x011c;
    L_0x0119:
        r8.close();
    L_0x011c:
        r5.unlock();
        return r0;
    L_0x0120:
        r6 = move-exception;
        r8 = r3;
        goto L_0x0128;
    L_0x0123:
        r6 = move-exception;
    L_0x0124:
        r5.onCorruption();	 Catch:{ all -> 0x0120 }
        throw r6;	 Catch:{ all -> 0x0120 }
    L_0x0128:
        if (r8 == 0) goto L_0x012d;
    L_0x012a:
        r8.close();
    L_0x012d:
        r5.unlock();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.insertWithOnConflict(java.lang.String, java.lang.String, android.content.ContentValues, int):long");
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return !this.mLock.isHeldByCurrentThread() && this.mLock.isLocked();
    }

    public boolean isInCompiledSqlCache(String str) {
        boolean containsKey;
        synchronized (this.mCompiledQueries) {
            containsKey = this.mCompiledQueries.containsKey(str);
        }
        return containsKey;
    }

    public boolean isOpen() {
        return this.mNativeHandle != 0;
    }

    public boolean isReadOnly() {
        return (this.mFlags & 1) == 1;
    }

    public native int lastChangeCount();

    public native long lastInsertRow();

    /* Access modifiers changed, original: 0000 */
    public void lock() {
        if (this.mLockingEnabled) {
            this.mLock.lock();
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
                this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
            }
        }
    }

    public void markTableSyncable(String str, String str2) {
        if (isOpen()) {
            markTableSyncable(str, "_id", str, str2);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public void markTableSyncable(String str, String str2, String str3) {
        if (isOpen()) {
            markTableSyncable(str, str2, str3, null);
            return;
        }
        throw new SQLiteException("database not open");
    }

    public native void native_execSQL(String str) throws SQLException;

    public native void native_setLocale(String str, int i);

    public boolean needUpgrade(int i) {
        return i > getVersion();
    }

    /* Access modifiers changed, original: protected */
    public void onAllReferencesReleased() {
        if (isOpen()) {
            if (SQLiteDebug.DEBUG_SQL_CACHE) {
                this.mTimeClosed = getTime();
            }
            dbclose();
            synchronized (sActiveDatabases) {
                sActiveDatabases.remove(this);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void onCorruption() {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calling error handler for corrupt database (detected) ");
        stringBuilder.append(this.mPath);
        Log.e(str, stringBuilder.toString());
        this.mErrorHandler.onCorruption(this);
    }

    public void purgeFromCompiledSqlCache(String str) {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.remove(str);
        }
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, null);
    }

    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return query(false, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return queryWithFactory(null, z, str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    public Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (isOpen()) {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), strArr2, findEditTable(str));
        }
        throw new IllegalStateException("database not open");
    }

    public void rawExecSQL(String str) {
        SystemClock.uptimeMillis();
        lock();
        if (isOpen()) {
            try {
                native_rawExecSQL(str);
                unlock();
            } catch (SQLiteDatabaseCorruptException e) {
                onCorruption();
                throw e;
            } catch (Throwable th) {
                unlock();
            }
        } else {
            throw new IllegalStateException("database not open");
        }
    }

    public Cursor rawQuery(String str, String[] strArr) {
        return rawQueryWithFactory(null, str, strArr, null);
    }

    public Cursor rawQuery(String str, String[] strArr, int i, int i2) {
        CursorWrapper cursorWrapper = (CursorWrapper) rawQueryWithFactory(null, str, strArr, null);
        ((SQLiteCursor) cursorWrapper.getWrappedCursor()).setLoadStyle(i, i2);
        return cursorWrapper;
    }

    public Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, String[] strArr, String str2) {
        long currentTimeMillis;
        StringBuilder stringBuilder;
        if (isOpen()) {
            long j = 0;
            int i = -1;
            if (this.mSlowQueryThreshold != -1) {
                j = System.currentTimeMillis();
            }
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2);
            if (cursorFactory == null) {
                try {
                    cursorFactory = this.mFactory;
                } catch (Throwable th) {
                    if (this.mSlowQueryThreshold != -1) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                        if (currentTimeMillis >= ((long) this.mSlowQueryThreshold)) {
                            str = TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("query (");
                            stringBuilder.append(currentTimeMillis);
                            stringBuilder.append(" ms): ");
                            stringBuilder.append(sQLiteDirectCursorDriver.toString());
                            stringBuilder.append(", args are <redacted>, count is ");
                            stringBuilder.append(-1);
                            Log.v(str, stringBuilder.toString());
                        }
                    }
                }
            }
            Cursor query = sQLiteDirectCursorDriver.query(cursorFactory, strArr);
            if (this.mSlowQueryThreshold != -1) {
                if (query != null) {
                    i = query.getCount();
                }
                currentTimeMillis = System.currentTimeMillis() - j;
                if (currentTimeMillis >= ((long) this.mSlowQueryThreshold)) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("query (");
                    stringBuilder.append(currentTimeMillis);
                    stringBuilder.append(" ms): ");
                    stringBuilder.append(sQLiteDirectCursorDriver.toString());
                    stringBuilder.append(", args are <redacted>, count is ");
                    stringBuilder.append(i);
                    Log.v(str, stringBuilder.toString());
                }
            }
            return new CrossProcessCursorWrapper(query);
        }
        throw new IllegalStateException("database not open");
    }

    /* Access modifiers changed, original: 0000 */
    public void removeSQLiteClosable(SQLiteClosable sQLiteClosable) {
        lock();
        try {
            this.mPrograms.remove(sQLiteClosable);
        } finally {
            unlock();
        }
    }

    public long replace(String str, String str2, ContentValues contentValues) {
        try {
            return insertWithOnConflict(str, str2, contentValues, 5);
        } catch (SQLException e) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error inserting <redacted values> into ");
            stringBuilder.append(str);
            Log.e(str3, stringBuilder.toString(), e);
            return -1;
        }
    }

    public long replaceOrThrow(String str, String str2, ContentValues contentValues) throws SQLException {
        return insertWithOnConflict(str, str2, contentValues, 5);
    }

    public void resetCompiledSqlCache() {
        synchronized (this.mCompiledQueries) {
            this.mCompiledQueries.clear();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void rowUpdated(String str, long j) {
        SyncUpdateInfo syncUpdateInfo;
        synchronized (this.mSyncUpdateInfo) {
            syncUpdateInfo = (SyncUpdateInfo) this.mSyncUpdateInfo.get(str);
        }
        if (syncUpdateInfo != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE ");
            stringBuilder.append(syncUpdateInfo.masterTable);
            stringBuilder.append(" SET _sync_dirty=1 WHERE _id=(SELECT ");
            stringBuilder.append(syncUpdateInfo.foreignKey);
            stringBuilder.append(" FROM ");
            stringBuilder.append(str);
            stringBuilder.append(" WHERE _id=");
            stringBuilder.append(j);
            stringBuilder.append(")");
            execSQL(stringBuilder.toString());
        }
    }

    public void setLocale(Locale locale) {
        lock();
        try {
            native_setLocale(locale.toString(), this.mFlags);
        } finally {
            unlock();
        }
    }

    public void setLockingEnabled(boolean z) {
        this.mLockingEnabled = z;
    }

    public synchronized void setMaxSqlCacheSize(int i) {
        if (i > MAX_SQL_CACHE_SIZE || i < 0) {
            throw new IllegalStateException("expected value between 0 and 250");
        } else if (i < this.mMaxSqlCacheSize) {
            throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");
        } else {
            this.mMaxSqlCacheSize = i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004e  */
    public long setMaximumSize(long r9) {
        /*
        r8 = this;
        r8.lock();
        r0 = r8.isOpen();
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r9 = new java.lang.IllegalStateException;
        r10 = "database not open";
        r9.<init>(r10);
        throw r9;
    L_0x0011:
        r0 = 0;
        r1 = r8.getPageSize();	 Catch:{ all -> 0x004b }
        r3 = r9 / r1;
        r9 = r9 % r1;
        r5 = 0;
        r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x0024;
    L_0x001f:
        r9 = 1;
        r5 = r3 + r9;
        r3 = r5;
    L_0x0024:
        r9 = new net.sqlcipher.database.SQLiteStatement;	 Catch:{ all -> 0x004b }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r10.<init>();	 Catch:{ all -> 0x004b }
        r5 = "PRAGMA max_page_count = ";
        r10.append(r5);	 Catch:{ all -> 0x004b }
        r10.append(r3);	 Catch:{ all -> 0x004b }
        r10 = r10.toString();	 Catch:{ all -> 0x004b }
        r9.<init>(r8, r10);	 Catch:{ all -> 0x004b }
        r3 = r9.simpleQueryForLong();	 Catch:{ all -> 0x0048 }
        r3 = r3 * r1;
        if (r9 == 0) goto L_0x0044;
    L_0x0041:
        r9.close();
    L_0x0044:
        r8.unlock();
        return r3;
    L_0x0048:
        r10 = move-exception;
        r0 = r9;
        goto L_0x004c;
    L_0x004b:
        r10 = move-exception;
    L_0x004c:
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.close();
    L_0x0051:
        r8.unlock();
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.setMaximumSize(long):long");
    }

    public void setPageSize(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA page_size = ");
        stringBuilder.append(j);
        execSQL(stringBuilder.toString());
    }

    public void setTransactionSuccessful() {
        if (!isOpen()) {
            throw new IllegalStateException("database not open");
        } else if (!this.mLock.isHeldByCurrentThread()) {
            throw new IllegalStateException("no transaction pending");
        } else if (this.mInnerTransactionIsSuccessful) {
            throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
        } else {
            this.mInnerTransactionIsSuccessful = true;
        }
    }

    public void setVersion(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PRAGMA user_version = ");
        stringBuilder.append(i);
        execSQL(stringBuilder.toString());
    }

    public int status(int i, boolean z) {
        return native_status(i, z);
    }

    /* Access modifiers changed, original: 0000 */
    public void unlock() {
        if (this.mLockingEnabled) {
            if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING && this.mLock.getHoldCount() == 1) {
                checkLockHoldTime();
            }
            this.mLock.unlock();
        }
    }

    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        return updateWithOnConflict(str, contentValues, str2, strArr, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x010b  */
    public int updateWithOnConflict(java.lang.String r5, android.content.ContentValues r6, java.lang.String r7, java.lang.String[] r8, int r9) {
        /*
        r4 = this;
        if (r6 == 0) goto L_0x0112;
    L_0x0002:
        r0 = r6.size();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x0112;
    L_0x000a:
        r0 = new java.lang.StringBuilder;
        r1 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r0.<init>(r1);
        r1 = "UPDATE ";
        r0.append(r1);
        r1 = CONFLICT_VALUES;
        r9 = r1[r9];
        r0.append(r9);
        r0.append(r5);
        r9 = " SET ";
        r0.append(r9);
        r6 = r6.valueSet();
        r9 = r6.iterator();
    L_0x002d:
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x0053;
    L_0x0033:
        r1 = r9.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getKey();
        r1 = (java.lang.String) r1;
        r0.append(r1);
        r1 = "=?";
        r0.append(r1);
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x002d;
    L_0x004d:
        r1 = ", ";
        r0.append(r1);
        goto L_0x002d;
    L_0x0053:
        r9 = android.text.TextUtils.isEmpty(r7);
        if (r9 != 0) goto L_0x0061;
    L_0x0059:
        r9 = " WHERE ";
        r0.append(r9);
        r0.append(r7);
    L_0x0061:
        r4.lock();
        r7 = r4.isOpen();
        if (r7 != 0) goto L_0x0072;
    L_0x006a:
        r5 = new java.lang.IllegalStateException;
        r6 = "database not open";
        r5.<init>(r6);
        throw r5;
    L_0x0072:
        r7 = 0;
        r9 = r0.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x0104, SQLException -> 0x00ec }
        r9 = r4.compileStatement(r9);	 Catch:{ SQLiteDatabaseCorruptException -> 0x0104, SQLException -> 0x00ec }
        r7 = r6.size();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r6 = r6.iterator();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r0 = 0;
        r1 = 1;
        r2 = r1;
        r1 = r0;
    L_0x0087:
        if (r1 >= r7) goto L_0x009b;
    L_0x0089:
        r3 = r6.next();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r3 = r3.getValue();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        net.sqlcipher.DatabaseUtils.bindObjectToProgram(r9, r2, r3);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r2 = r2 + 1;
        r1 = r1 + 1;
        goto L_0x0087;
    L_0x009b:
        if (r8 == 0) goto L_0x00aa;
    L_0x009d:
        r6 = r8.length;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
    L_0x009e:
        if (r0 >= r6) goto L_0x00aa;
    L_0x00a0:
        r7 = r8[r0];	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r9.bindString(r2, r7);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r2 = r2 + 1;
        r0 = r0 + 1;
        goto L_0x009e;
    L_0x00aa:
        r9.execute();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r6 = r4.lastChangeCount();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r7 = "Database";
        r8 = 2;
        r7 = android.util.Log.isLoggable(r7, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        if (r7 == 0) goto L_0x00d8;
    L_0x00ba:
        r7 = "Database";
        r8 = new java.lang.StringBuilder;	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r8.<init>();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r0 = "Updated ";
        r8.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r8.append(r6);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r0 = " rows using <redacted values> and <redacted sql> for ";
        r8.append(r0);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r8.append(r5);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        r8 = r8.toString();	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
        android.util.Log.v(r7, r8);	 Catch:{ SQLiteDatabaseCorruptException -> 0x00e6, SQLException -> 0x00e3, all -> 0x00e1 }
    L_0x00d8:
        if (r9 == 0) goto L_0x00dd;
    L_0x00da:
        r9.close();
    L_0x00dd:
        r4.unlock();
        return r6;
    L_0x00e1:
        r5 = move-exception;
        goto L_0x0109;
    L_0x00e3:
        r6 = move-exception;
        r7 = r9;
        goto L_0x00ed;
    L_0x00e6:
        r5 = move-exception;
        r7 = r9;
        goto L_0x0105;
    L_0x00e9:
        r5 = move-exception;
        r9 = r7;
        goto L_0x0109;
    L_0x00ec:
        r6 = move-exception;
    L_0x00ed:
        r8 = "Database";
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r9.<init>();	 Catch:{ all -> 0x00e9 }
        r0 = "Error updating <redacted values> using <redacted sql> for ";
        r9.append(r0);	 Catch:{ all -> 0x00e9 }
        r9.append(r5);	 Catch:{ all -> 0x00e9 }
        r5 = r9.toString();	 Catch:{ all -> 0x00e9 }
        android.util.Log.e(r8, r5);	 Catch:{ all -> 0x00e9 }
        throw r6;	 Catch:{ all -> 0x00e9 }
    L_0x0104:
        r5 = move-exception;
    L_0x0105:
        r4.onCorruption();	 Catch:{ all -> 0x00e9 }
        throw r5;	 Catch:{ all -> 0x00e9 }
    L_0x0109:
        if (r9 == 0) goto L_0x010e;
    L_0x010b:
        r9.close();
    L_0x010e:
        r4.unlock();
        throw r5;
    L_0x0112:
        r5 = new java.lang.IllegalArgumentException;
        r6 = "Empty values";
        r5.<init>(r6);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteDatabase.updateWithOnConflict(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[], int):int");
    }

    @Deprecated
    public boolean yieldIfContended() {
        return !isOpen() ? false : yieldIfContendedHelper(false, -1);
    }

    public boolean yieldIfContendedSafely() {
        return !isOpen() ? false : yieldIfContendedHelper(true, -1);
    }

    public boolean yieldIfContendedSafely(long j) {
        return !isOpen() ? false : yieldIfContendedHelper(true, j);
    }
}
