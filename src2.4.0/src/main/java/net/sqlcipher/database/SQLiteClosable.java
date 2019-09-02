package net.sqlcipher.database;

public abstract class SQLiteClosable {
    private Object mLock = new Object();
    private int mReferenceCount = 1;

    private String getObjInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(" (");
        if (this instanceof SQLiteDatabase) {
            stringBuilder.append("database = ");
            stringBuilder.append(((SQLiteDatabase) this).getPath());
        } else if ((this instanceof SQLiteProgram) || (this instanceof SQLiteStatement) || (this instanceof SQLiteQuery)) {
            stringBuilder.append("mSql = ");
            stringBuilder.append(((SQLiteProgram) this).mSql);
        }
        stringBuilder.append(") ");
        return stringBuilder.toString();
    }

    public void acquireReference() {
        synchronized (this.mLock) {
            if (this.mReferenceCount <= 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("attempt to re-open an already-closed object: ");
                stringBuilder.append(getObjInfo());
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.mReferenceCount++;
        }
    }

    public abstract void onAllReferencesReleased();

    /* Access modifiers changed, original: protected */
    public void onAllReferencesReleasedFromContainer() {
    }

    public void releaseReference() {
        synchronized (this.mLock) {
            this.mReferenceCount--;
            if (this.mReferenceCount == 0) {
                onAllReferencesReleased();
            }
        }
    }

    public void releaseReferenceFromContainer() {
        synchronized (this.mLock) {
            this.mReferenceCount--;
            if (this.mReferenceCount == 0) {
                onAllReferencesReleasedFromContainer();
            }
        }
    }
}
