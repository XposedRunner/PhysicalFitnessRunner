package net.sqlcipher.database;

import android.util.Log;

class SQLiteCompiledSql {
    private static final String TAG = "SQLiteCompiledSql";
    SQLiteDatabase mDatabase;
    private boolean mInUse = false;
    private String mSqlStmt = null;
    private Throwable mStackTrace = null;
    long nHandle = 0;
    long nStatement = 0;

    SQLiteCompiledSql(SQLiteDatabase sQLiteDatabase, String str) {
        if (sQLiteDatabase.isOpen()) {
            this.mDatabase = sQLiteDatabase;
            this.mSqlStmt = str;
            this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
            this.nHandle = sQLiteDatabase.mNativeHandle;
            compile(str, true);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("database ");
        stringBuilder.append(sQLiteDatabase.getPath());
        stringBuilder.append(" already closed");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void compile(String str, boolean z) {
        if (!this.mDatabase.isOpen()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("database ");
            stringBuilder.append(this.mDatabase.getPath());
            stringBuilder.append(" already closed");
            throw new IllegalStateException(stringBuilder.toString());
        } else if (z) {
            this.mDatabase.lock();
            try {
                native_compile(str);
            } finally {
                this.mDatabase.unlock();
            }
        }
    }

    private final native void native_compile(String str);

    private final native void native_finalize();

    /* Access modifiers changed, original: declared_synchronized */
    /* JADX WARNING: Missing block: B:13:0x002d, code skipped:
            return true;
     */
    public synchronized boolean acquire() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.mInUse;	 Catch:{ all -> 0x002e }
        if (r0 == 0) goto L_0x0008;
    L_0x0005:
        r0 = 0;
        monitor-exit(r5);
        return r0;
    L_0x0008:
        r0 = 1;
        r5.mInUse = r0;	 Catch:{ all -> 0x002e }
        r1 = net.sqlcipher.database.SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION;	 Catch:{ all -> 0x002e }
        if (r1 == 0) goto L_0x002c;
    L_0x000f:
        r1 = "SQLiteCompiledSql";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x002e }
        r2.<init>();	 Catch:{ all -> 0x002e }
        r3 = "Acquired DbObj (id#";
        r2.append(r3);	 Catch:{ all -> 0x002e }
        r3 = r5.nStatement;	 Catch:{ all -> 0x002e }
        r2.append(r3);	 Catch:{ all -> 0x002e }
        r3 = ") from DB cache";
        r2.append(r3);	 Catch:{ all -> 0x002e }
        r2 = r2.toString();	 Catch:{ all -> 0x002e }
        android.util.Log.v(r1, r2);	 Catch:{ all -> 0x002e }
    L_0x002c:
        monitor-exit(r5);
        return r0;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteCompiledSql.acquire():boolean");
    }

    /* Access modifiers changed, original: protected */
    public void finalize() throws Throwable {
        try {
            if (this.nStatement != 0) {
                if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("** warning ** Finalized DbObj (id#");
                    stringBuilder.append(this.nStatement);
                    stringBuilder.append(")");
                    Log.v(str, stringBuilder.toString());
                }
                int length = this.mSqlStmt.length();
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Releasing statement in a finalizer. Please ensure that you explicitly call close() on your cursor: ");
                String str3 = this.mSqlStmt;
                if (length > 100) {
                    length = 100;
                }
                stringBuilder2.append(str3.substring(0, length));
                Log.w(str2, stringBuilder2.toString(), this.mStackTrace);
                releaseSqlStatement();
                super.finalize();
            }
        } finally {
            super.finalize();
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void release() {
        if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Released DbObj (id#");
            stringBuilder.append(this.nStatement);
            stringBuilder.append(") back to DB cache");
            Log.v(str, stringBuilder.toString());
        }
        this.mInUse = false;
    }

    /* Access modifiers changed, original: 0000 */
    public void releaseSqlStatement() {
        if (this.nStatement != 0) {
            if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("closed and deallocated DbObj (id#");
                stringBuilder.append(this.nStatement);
                stringBuilder.append(")");
                Log.v(str, stringBuilder.toString());
            }
            try {
                this.mDatabase.lock();
                native_finalize();
                this.nStatement = 0;
            } finally {
                this.mDatabase.unlock();
            }
        }
    }
}
