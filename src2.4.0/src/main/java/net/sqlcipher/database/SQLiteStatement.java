package net.sqlcipher.database;

import android.os.SystemClock;

public class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str) {
        super(sQLiteDatabase, str);
    }

    private final native long native_1x1_long();

    private final native String native_1x1_string();

    private final native void native_execute();

    public void execute() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("database ");
            stringBuilder.append(this.mDatabase.getPath());
            stringBuilder.append(" already closed");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public long executeInsert() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                long lastInsertRow = this.mDatabase.lastChangeCount() > 0 ? this.mDatabase.lastInsertRow() : -1;
                releaseReference();
                this.mDatabase.unlock();
                return lastInsertRow;
            } catch (Throwable th) {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("database ");
            stringBuilder.append(this.mDatabase.getPath());
            stringBuilder.append(" already closed");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public int executeUpdateDelete() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                native_execute();
                int lastChangeCount = this.mDatabase.lastChangeCount();
                return lastChangeCount;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("database ");
            stringBuilder.append(this.mDatabase.getPath());
            stringBuilder.append(" already closed");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public long simpleQueryForLong() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                long native_1x1_long = native_1x1_long();
                return native_1x1_long;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("database ");
            stringBuilder.append(this.mDatabase.getPath());
            stringBuilder.append(" already closed");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public String simpleQueryForString() {
        if (this.mDatabase.isOpen()) {
            SystemClock.uptimeMillis();
            this.mDatabase.lock();
            acquireReference();
            try {
                String native_1x1_string = native_1x1_string();
                return native_1x1_string;
            } finally {
                releaseReference();
                this.mDatabase.unlock();
            }
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("database ");
            stringBuilder.append(this.mDatabase.getPath());
            stringBuilder.append(" already closed");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
