package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private Map<String, Integer> mColumnNameMap;
    private String[] mColumns;
    private int mCount = -1;
    private int mCursorState;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    private int mInitialRead = Integer.MAX_VALUE;
    private ReentrantLock mLock;
    private int mMaxRead = Integer.MAX_VALUE;
    protected MainThreadNotificationHandler mNotificationHandler;
    private boolean mPendingData;
    private SQLiteQuery mQuery;
    private Throwable mStackTrace;

    protected class MainThreadNotificationHandler extends Handler {
        protected MainThreadNotificationHandler() {
        }

        public void handleMessage(Message message) {
            SQLiteCursor.this.notifyDataSetChange();
        }
    }

    private final class QueryThread implements Runnable {
        private final int mThreadState;

        QueryThread(int i) {
            this.mThreadState = i;
        }

        private void sendMessage() {
            if (SQLiteCursor.this.mNotificationHandler != null) {
                SQLiteCursor.this.mNotificationHandler.sendEmptyMessage(1);
                SQLiteCursor.this.mPendingData = false;
                return;
            }
            SQLiteCursor.this.mPendingData = true;
        }

        /* JADX WARNING: Missing block: B:12:?, code skipped:
            net.sqlcipher.database.SQLiteCursor.access$502(r4.this$0, r1);
            sendMessage();
     */
        public void run() {
            /*
            r4 = this;
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mWindow;
            r1 = android.os.Process.myTid();
            r2 = 10;
            android.os.Process.setThreadPriority(r1, r2);
        L_0x000f:
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mLock;
            r1.lock();
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mCursorState;
            r2 = r4.mThreadState;
            if (r1 == r2) goto L_0x002c;
        L_0x0022:
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mLock;
            r0.unlock();
            goto L_0x0083;
        L_0x002c:
            r1 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r1 = r1.mQuery;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r2 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r2 = r2.mMaxRead;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r3 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r3 = r3.mCount;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r1 = r1.fillWindow(r0, r2, r3);	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            if (r1 == 0) goto L_0x007a;
        L_0x0044:
            r2 = -1;
            if (r1 != r2) goto L_0x0066;
        L_0x0047:
            r1 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r2 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r2 = r2.mCount;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r3 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r3 = r3.mMaxRead;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r2 = r2 + r3;
            r1.mCount = r2;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r4.sendMessage();	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mLock;
            r1.unlock();
            goto L_0x000f;
        L_0x0066:
            r0 = net.sqlcipher.database.SQLiteCursor.this;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r0.mCount = r1;	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            r4.sendMessage();	 Catch:{ Exception -> 0x007a, all -> 0x006f }
            goto L_0x007a;
        L_0x006f:
            r0 = move-exception;
            r1 = net.sqlcipher.database.SQLiteCursor.this;
            r1 = r1.mLock;
            r1.unlock();
            throw r0;
        L_0x007a:
            r0 = net.sqlcipher.database.SQLiteCursor.this;
            r0 = r0.mLock;
            r0.unlock();
        L_0x0083:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCursor$QueryThread.run():void");
        }
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        int i = 0;
        this.mCursorState = 0;
        this.mLock = null;
        this.mPendingData = false;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mColumnNameMap = null;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int columnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[columnCountLocked];
            while (i < columnCountLocked) {
                str = this.mQuery.columnNameLocked(i);
                this.mColumns[i] = str;
                if ("_id".equals(str)) {
                    this.mRowIdColumnIndex = i;
                }
                i++;
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    private void fillWindow(int i) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = i + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    private void queryThreadLock() {
        if (this.mLock != null) {
            this.mLock.lock();
        }
    }

    private void queryThreadUnlock() {
        if (this.mLock != null) {
            this.mLock.unlock();
        }
    }

    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (supportsUpdates()) {
            synchronized (this.mUpdatedRows) {
                if (map != null) {
                    try {
                        this.mUpdatedRows.putAll(map);
                    } catch (Throwable th) {
                    }
                }
                if (this.mUpdatedRows.size() == 0) {
                    return true;
                }
                this.mDatabase.beginTransaction();
                StringBuilder stringBuilder = new StringBuilder(128);
                for (Entry entry : this.mUpdatedRows.entrySet()) {
                    Map map2 = (Map) entry.getValue();
                    Long l = (Long) entry.getKey();
                    if (l != null) {
                        if (map2 != null) {
                            if (map2.size() != 0) {
                                long longValue = l.longValue();
                                Iterator it = map2.entrySet().iterator();
                                stringBuilder.setLength(0);
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("UPDATE ");
                                stringBuilder2.append(this.mEditTable);
                                stringBuilder2.append(" SET ");
                                stringBuilder.append(stringBuilder2.toString());
                                Object[] objArr = new Object[map2.size()];
                                int i = 0;
                                while (it.hasNext()) {
                                    Entry entry2 = (Entry) it.next();
                                    stringBuilder.append((String) entry2.getKey());
                                    stringBuilder.append("=?");
                                    objArr[i] = entry2.getValue();
                                    if (it.hasNext()) {
                                        stringBuilder.append(", ");
                                    }
                                    i++;
                                }
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(" WHERE ");
                                stringBuilder3.append(this.mColumns[this.mRowIdColumnIndex]);
                                stringBuilder3.append('=');
                                stringBuilder3.append(longValue);
                                stringBuilder.append(stringBuilder3.toString());
                                stringBuilder.append(';');
                                this.mDatabase.execSQL(stringBuilder.toString(), objArr);
                                this.mDatabase.rowUpdated(this.mEditTable, longValue);
                            }
                        }
                    }
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("null rowId or values found! rowId = ");
                    stringBuilder4.append(l);
                    stringBuilder4.append(", values = ");
                    stringBuilder4.append(map2);
                    throw new IllegalStateException(stringBuilder4.toString());
                }
                this.mDatabase.setTransactionSuccessful();
                this.mDatabase.endTransaction();
                this.mUpdatedRows.clear();
                onChange(true);
                return true;
            }
        }
        Log.e(TAG, "commitUpdates not supported on this cursor, did you include the _id column?");
        return false;
    }

    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    public boolean deleteRow() {
        checkPosition();
        boolean z = false;
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            Log.e(TAG, "Could not delete row because either the row ID column is not available or ithas not been read.");
            return false;
        }
        boolean z2;
        this.mDatabase.lock();
        try {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            String str = this.mEditTable;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mColumns[this.mRowIdColumnIndex]);
            stringBuilder.append("=?");
            sQLiteDatabase.delete(str, stringBuilder.toString(), new String[]{this.mCurrentRowID.toString()});
            z2 = true;
        } catch (SQLException unused) {
            z2 = false;
        }
        try {
            int i = this.mPos;
            requery();
            moveToPosition(i);
            if (!z2) {
                return z;
            }
            onChange(true);
            return true;
        } finally {
            z = this.mDatabase;
            z.unlock();
        }
    }

    public void fillWindow(int i, android.database.CursorWindow cursorWindow) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow.setStartPosition(i);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCount == -1) {
            this.mCount = i + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        try {
            if (this.mWindow != null) {
                int length = this.mQuery.mSql.length();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Finalizing a Cursor that has not been deactivated or closed. database = ");
                stringBuilder.append(this.mDatabase.getPath());
                stringBuilder.append(", table = ");
                stringBuilder.append(this.mEditTable);
                stringBuilder.append(", query = ");
                String str2 = this.mQuery.mSql;
                if (length > 100) {
                    length = 100;
                }
                stringBuilder.append(str2.substring(0, length));
                Log.e(str, stringBuilder.toString(), this.mStackTrace);
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public int getColumnIndex(String str) {
        Object str2;
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i = 0; i < length; i++) {
                hashMap.put(strArr[i], Integer.valueOf(i));
            }
            this.mColumnNameMap = hashMap;
        }
        int lastIndexOf = str2.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exception = new Exception();
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("requesting column name with table name -- ");
            stringBuilder.append(str2);
            Log.e(str3, stringBuilder.toString(), exception);
            str2 = str2.substring(lastIndexOf + 1);
        }
        Integer num = (Integer) this.mColumnNameMap.get(str2);
        return num != null ? num.intValue() : -1;
    }

    public String[] getColumnNames() {
        return this.mColumns;
    }

    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public boolean onMove(int i, int i2) {
        if (this.mWindow == null || i2 < this.mWindow.getStartPosition() || i2 >= this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            fillWindow(i2);
        }
        return true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler();
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
                queryThreadUnlock();
            } catch (Throwable th) {
                queryThreadUnlock();
            }
        }
    }

    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            if (this.mWindow != null) {
                this.mWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            this.mQuery.requery();
            queryThreadUnlock();
            this.mDatabase.unlock();
            return super.requery();
        } catch (Throwable th) {
            this.mDatabase.unlock();
        }
    }

    public void setLoadStyle(int i, int i2) {
        this.mMaxRead = i2;
        this.mInitialRead = i;
        this.mLock = new ReentrantLock(true);
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                this.mCount = -1;
            } finally {
                queryThreadUnlock();
            }
        }
        this.mWindow = cursorWindow;
    }

    public boolean supportsUpdates() {
        return TextUtils.isEmpty(this.mEditTable) ^ 1;
    }
}
