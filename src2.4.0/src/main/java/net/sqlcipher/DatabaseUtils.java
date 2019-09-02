package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final char[] HEX_DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = new String[]{"count(*)"};
    private static Collator mColl;

    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL;
        private SQLiteStatement mInsertStatement;
        private SQLiteStatement mPreparedStatement;
        private SQLiteStatement mReplaceStatement;
        private final String mTableName;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        private void buildSQL() throws net.sqlcipher.SQLException {
            /*
            r9 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.DatabaseUtils$InsertHelper.buildSQL():void");
        }

        private SQLiteStatement getStatement(boolean z) throws SQLException {
            return null;
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: null in method: net.sqlcipher.DatabaseUtils.InsertHelper.insertInternal(android.content.ContentValues, boolean):long, dex: 
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:254)
            	at jadx.core.ProcessClass.process(ProcessClass.java:29)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            Caused by: java.lang.NullPointerException
            	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:325)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:107)
            	... 10 more
            */
        private synchronized long insertInternal(android.content.ContentValues r1, boolean r2) {
            /*
            r0 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.DatabaseUtils$InsertHelper.insertInternal(android.content.ContentValues, boolean):long");
        }

        public void bind(int i, double d) {
        }

        public void bind(int i, float f) {
        }

        public void bind(int i, int i2) {
        }

        public void bind(int i, long j) {
        }

        public void bind(int i, String str) {
        }

        public void bind(int i, boolean z) {
        }

        public void bind(int i, byte[] bArr) {
        }

        public void bindNull(int i) {
        }

        public void close() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0003
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public long execute() {
            /*
            r5 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.DatabaseUtils$InsertHelper.execute():long");
        }

        public int getColumnIndex(String str) {
            return 0;
        }

        public long insert(ContentValues contentValues) {
            return 0;
        }

        public void prepareForInsert() {
        }

        public void prepareForReplace() {
        }

        public long replace(ContentValues contentValues) {
            return 0;
        }
    }

    public static void appendEscapedSQLString(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\'') {
                    stringBuilder.append('\'');
                }
                stringBuilder.append(charAt);
            }
        } else {
            stringBuilder.append(str);
        }
        stringBuilder.append('\'');
    }

    public static final void appendValueToSql(StringBuilder stringBuilder, Object obj) {
        if (obj == null) {
            stringBuilder.append("NULL");
        } else if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(stringBuilder, obj.toString());
        } else if (((Boolean) obj).booleanValue()) {
            stringBuilder.append('1');
        } else {
            stringBuilder.append('0');
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
        } else if (obj instanceof Number) {
            sQLiteProgram.bindLong(i, ((Number) obj).longValue());
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i, 1);
            } else {
                sQLiteProgram.bindLong(i, 0);
            }
        } else if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i, obj.toString());
        }
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(") AND (");
        stringBuilder.append(str2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Double) null);
        } else {
            contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        }
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndexOrThrow)));
        }
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorDoubleToContentValues(cursor, str, contentValues, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c A:{SYNTHETIC} */
    public static void cursorFillWindow(net.sqlcipher.Cursor r5, int r6, android.database.CursorWindow r7) {
        /*
        if (r6 < 0) goto L_0x0080;
    L_0x0002:
        r0 = r5.getCount();
        if (r6 < r0) goto L_0x000a;
    L_0x0008:
        goto L_0x0080;
    L_0x000a:
        r0 = r5.getPosition();
        r1 = r5.getColumnCount();
        r7.clear();
        r7.setStartPosition(r6);
        r7.setNumColumns(r1);
        r2 = r5.moveToPosition(r6);
        if (r2 == 0) goto L_0x007c;
    L_0x0021:
        r2 = r7.allocRow();
        if (r2 != 0) goto L_0x0028;
    L_0x0027:
        goto L_0x007c;
    L_0x0028:
        r2 = 0;
    L_0x0029:
        if (r2 >= r1) goto L_0x0074;
    L_0x002b:
        r3 = r5.getType(r2);
        r4 = 4;
        if (r3 == r4) goto L_0x005c;
    L_0x0032:
        switch(r3) {
            case 0: goto L_0x0057;
            case 1: goto L_0x004e;
            case 2: goto L_0x0045;
            default: goto L_0x0035;
        };
    L_0x0035:
        r3 = r5.getString(r2);
        if (r3 == 0) goto L_0x0040;
    L_0x003b:
        r3 = r7.putString(r3, r6, r2);
        goto L_0x006b;
    L_0x0040:
        r3 = r7.putNull(r6, r2);
        goto L_0x006b;
    L_0x0045:
        r3 = r5.getDouble(r2);
        r3 = r7.putDouble(r3, r6, r2);
        goto L_0x006b;
    L_0x004e:
        r3 = r5.getLong(r2);
        r3 = r7.putLong(r3, r6, r2);
        goto L_0x006b;
    L_0x0057:
        r3 = r7.putNull(r6, r2);
        goto L_0x006b;
    L_0x005c:
        r3 = r5.getBlob(r2);
        if (r3 == 0) goto L_0x0067;
    L_0x0062:
        r3 = r7.putBlob(r3, r6, r2);
        goto L_0x006b;
    L_0x0067:
        r3 = r7.putNull(r6, r2);
    L_0x006b:
        if (r3 != 0) goto L_0x0071;
    L_0x006d:
        r7.freeLastRow();
        goto L_0x0074;
    L_0x0071:
        r2 = r2 + 1;
        goto L_0x0029;
    L_0x0074:
        r6 = r6 + 1;
        r2 = r5.moveToNext();
        if (r2 != 0) goto L_0x0021;
    L_0x007c:
        r5.moveToPosition(r0);
        return;
    L_0x0080:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.DatabaseUtils.cursorFillWindow(net.sqlcipher.Cursor, int, android.database.CursorWindow):void");
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndexOrThrow)));
        }
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorIntToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Integer) null);
        } else {
            contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        }
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndexOrThrow)));
        }
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorLongToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, (Long) null);
        } else {
            contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        }
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Long.valueOf(cursor.getLong(columnIndexOrThrow)));
        }
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        int i = 0;
        while (i < length) {
            if (abstractWindowedCursor == null || !abstractWindowedCursor.isBlob(i)) {
                contentValues.put(columnNames[i], cursor.getString(i));
            } else {
                contentValues.put(columnNames[i], cursor.getBlob(i));
            }
            i++;
        }
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, Short.valueOf(cursor.getShort(columnIndexOrThrow)));
        }
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        cursorStringToContentValues(cursor, str, contentValues, str);
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(str);
        if (!cursor.isNull(columnIndexOrThrow)) {
            contentValues.put(str, cursor.getString(columnIndexOrThrow));
        }
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i) {
        insertHelper.bind(i, cursor.getString(cursor.getColumnIndexOrThrow(str)));
    }

    public static void dumpCurrentRow(Cursor cursor) {
        dumpCurrentRow(cursor, System.out);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        String[] columnNames = cursor.getColumnNames();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(cursor.getPosition());
        stringBuilder.append(" {");
        printStream.println(stringBuilder.toString());
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            String string;
            try {
                string = cursor.getString(i);
            } catch (SQLiteException unused) {
                string = "<unprintable>";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("   ");
            stringBuilder2.append(columnNames[i]);
            stringBuilder2.append('=');
            stringBuilder2.append(string);
            printStream.println(stringBuilder2.toString());
        }
        printStream.println("}");
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder stringBuilder) {
        String[] columnNames = cursor.getColumnNames();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append(cursor.getPosition());
        stringBuilder2.append(" {\n");
        stringBuilder.append(stringBuilder2.toString());
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            String string;
            try {
                string = cursor.getString(i);
            } catch (SQLiteException unused) {
                string = "<unprintable>";
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("   ");
            stringBuilder3.append(columnNames[i]);
            stringBuilder3.append('=');
            stringBuilder3.append(string);
            stringBuilder3.append("\n");
            stringBuilder.append(stringBuilder3.toString());
        }
        stringBuilder.append("}\n");
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder();
        dumpCurrentRow(cursor, stringBuilder);
        return stringBuilder.toString();
    }

    public static void dumpCursor(Cursor cursor) {
        dumpCursor(cursor, System.out);
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(">>>>> Dumping cursor ");
        stringBuilder.append(cursor);
        printStream.println(stringBuilder.toString());
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
    }

    public static void dumpCursor(Cursor cursor, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(">>>>> Dumping cursor ");
        stringBuilder2.append(cursor);
        stringBuilder2.append("\n");
        stringBuilder.append(stringBuilder2.toString());
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, stringBuilder);
            }
            cursor.moveToPosition(position);
        }
        stringBuilder.append("<<<<<\n");
    }

    public static String dumpCursorToString(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder();
        dumpCursor(cursor, stringBuilder);
        return stringBuilder.toString();
    }

    private static char[] encodeHex(byte[] bArr, char[] cArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(240 & bArr[i]) >>> 4];
            i2 = i3 + 1;
            cArr2[i3] = cArr[15 & bArr[i]];
            i++;
        }
        return cArr2;
    }

    public static String getCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        try {
            return new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] getCollationKeyInBytes(String str) {
        if (mColl == null) {
            mColl = Collator.getInstance();
            mColl.setStrength(0);
        }
        return mColl.getCollationKey(str).toByteArray();
    }

    public static String getHexCollationKey(String str) {
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        return new String(encodeHex(collationKeyInBytes, HEX_DIGITS_LOWER), 0, getKeyLen(collationKeyInBytes) * 2);
    }

    private static int getKeyLen(byte[] bArr) {
        return bArr[bArr.length + -1] != (byte) 0 ? bArr.length : bArr.length - 1;
    }

    public static int getTypeOfObject(Object obj) {
        return obj == null ? 0 : obj instanceof byte[] ? 4 : ((obj instanceof Float) || (obj instanceof Double)) ? 2 : ((obj instanceof Long) || (obj instanceof Integer)) ? 1 : 3;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            long longForQuery = longForQuery(compileStatement, strArr);
            return longForQuery;
        } finally {
            compileStatement.close();
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                bindObjectToProgram(sQLiteStatement, i2, strArr[i]);
                i = i2;
            }
        }
        return sQLiteStatement.simpleQueryForLong();
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        long j = sQLiteDatabase;
        Cursor query = j.query(str, countProjection, null, null, null, null, null);
        try {
            query.moveToFirst();
            j = query.getLong(0);
            return j;
        } finally {
            query.close();
        }
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt != 0) {
            readExceptionFromParcel(parcel, parcel.readString(), readInt);
        }
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i) {
        switch (i) {
            case 2:
                throw new IllegalArgumentException(str);
            case 3:
                throw new UnsupportedOperationException(str);
            case 4:
                throw new SQLiteAbortException(str);
            case 5:
                throw new SQLiteConstraintException(str);
            case 6:
                throw new SQLiteDatabaseCorruptException(str);
            case 7:
                throw new SQLiteFullException(str);
            case 8:
                throw new SQLiteDiskIOException(str);
            case 9:
                throw new SQLiteException(str);
            default:
                parcel.readException(i, str);
                return;
        }
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) throws FileNotFoundException {
        int readInt = parcel.readInt();
        if (readInt != 0) {
            String readString = parcel.readString();
            if (readInt == 1) {
                throw new FileNotFoundException(readString);
            }
            readExceptionFromParcel(parcel, readString, readInt);
        }
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) throws OperationApplicationException {
        int readInt = parcel.readInt();
        if (readInt != 0) {
            String readString = parcel.readString();
            if (readInt == 10) {
                throw new OperationApplicationException(readString);
            }
            readExceptionFromParcel(parcel, readString, readInt);
        }
    }

    public static String sqlEscapeString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        appendEscapedSQLString(stringBuilder, str);
        return stringBuilder.toString();
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            str = stringForQuery(compileStatement, strArr);
            return str;
        } finally {
            compileStatement.close();
        }
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                bindObjectToProgram(sQLiteStatement, i2, strArr[i]);
                i = i2;
            }
        }
        return sQLiteStatement.simpleQueryForString();
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exception) {
        int i;
        Object obj = 1;
        if (exception instanceof FileNotFoundException) {
            obj = null;
            i = 1;
        } else if (exception instanceof IllegalArgumentException) {
            i = 2;
        } else if (exception instanceof UnsupportedOperationException) {
            i = 3;
        } else if (exception instanceof SQLiteAbortException) {
            i = 4;
        } else if (exception instanceof SQLiteConstraintException) {
            i = 5;
        } else if (exception instanceof SQLiteDatabaseCorruptException) {
            i = 6;
        } else if (exception instanceof SQLiteFullException) {
            i = 7;
        } else if (exception instanceof SQLiteDiskIOException) {
            i = 8;
        } else if (exception instanceof SQLiteException) {
            i = 9;
        } else if (exception instanceof OperationApplicationException) {
            i = 10;
        } else {
            parcel.writeException(exception);
            Log.e(TAG, "Writing exception to parcel", exception);
            return;
        }
        parcel.writeInt(i);
        parcel.writeString(exception.getMessage());
        if (obj != null) {
            Log.e(TAG, "Writing exception to parcel", exception);
        }
    }
}
