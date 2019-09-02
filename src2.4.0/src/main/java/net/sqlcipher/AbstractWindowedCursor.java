package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    /* Access modifiers changed, original: protected */
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                super.copyStringToBuffer(i, charArrayBuffer);
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i, charArrayBuffer);
    }

    public byte[] getBlob(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                byte[] bArr = (byte[]) getUpdatedField(i);
                return bArr;
            }
            return this.mWindow.getBlob(this.mPos, i);
        }
    }

    public double getDouble(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                double doubleValue = ((Number) getUpdatedField(i)).doubleValue();
                return doubleValue;
            }
            return this.mWindow.getDouble(this.mPos, i);
        }
    }

    public float getFloat(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                float floatValue = ((Number) getUpdatedField(i)).floatValue();
                return floatValue;
            }
            return this.mWindow.getFloat(this.mPos, i);
        }
    }

    public int getInt(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                i = ((Number) getUpdatedField(i)).intValue();
                return i;
            }
            return this.mWindow.getInt(this.mPos, i);
        }
    }

    public long getLong(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                long longValue = ((Number) getUpdatedField(i)).longValue();
                return longValue;
            }
            return this.mWindow.getLong(this.mPos, i);
        }
    }

    public short getShort(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                short shortValue = ((Number) getUpdatedField(i)).shortValue();
                return shortValue;
            }
            return this.mWindow.getShort(this.mPos, i);
        }
    }

    public String getString(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                String str = (String) getUpdatedField(i);
                return str;
            }
            return this.mWindow.getString(this.mPos, i);
        }
    }

    public int getType(int i) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i);
    }

    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    /* JADX WARNING: Missing block: B:13:0x001b, code skipped:
            return r3;
     */
    public boolean isBlob(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r0 = r2.mUpdatedRows;
        monitor-enter(r0);
        r1 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x001c;
    L_0x000c:
        r3 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0026 }
        if (r3 == 0) goto L_0x0019;
    L_0x0012:
        r3 = r3 instanceof byte[];	 Catch:{ all -> 0x0026 }
        if (r3 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0019;
    L_0x0017:
        r3 = 0;
        goto L_0x001a;
    L_0x0019:
        r3 = 1;
    L_0x001a:
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        return r3;
    L_0x001c:
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r3 = r0.isBlob(r1, r3);
        return r3;
    L_0x0026:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isBlob(int):boolean");
    }

    /* JADX WARNING: Missing block: B:14:0x001e, code skipped:
            return r3;
     */
    public boolean isFloat(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r0 = r2.mUpdatedRows;
        monitor-enter(r0);
        r1 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0029 }
        if (r1 == 0) goto L_0x001f;
    L_0x000c:
        r3 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0029 }
        if (r3 == 0) goto L_0x001c;
    L_0x0012:
        r1 = r3 instanceof java.lang.Float;	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r3 = r3 instanceof java.lang.Double;	 Catch:{ all -> 0x0029 }
        if (r3 == 0) goto L_0x001c;
    L_0x001a:
        r3 = 1;
        goto L_0x001d;
    L_0x001c:
        r3 = 0;
    L_0x001d:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        return r3;
    L_0x001f:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r3 = r0.isFloat(r1, r3);
        return r3;
    L_0x0029:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isFloat(int):boolean");
    }

    /* JADX WARNING: Missing block: B:14:0x001e, code skipped:
            return r3;
     */
    public boolean isLong(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r0 = r2.mUpdatedRows;
        monitor-enter(r0);
        r1 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0029 }
        if (r1 == 0) goto L_0x001f;
    L_0x000c:
        r3 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0029 }
        if (r3 == 0) goto L_0x001c;
    L_0x0012:
        r1 = r3 instanceof java.lang.Integer;	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r3 = r3 instanceof java.lang.Long;	 Catch:{ all -> 0x0029 }
        if (r3 == 0) goto L_0x001c;
    L_0x001a:
        r3 = 1;
        goto L_0x001d;
    L_0x001c:
        r3 = 0;
    L_0x001d:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        return r3;
    L_0x001f:
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r3 = r0.isLong(r1, r3);
        return r3;
    L_0x0029:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0029 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isLong(int):boolean");
    }

    /* JADX WARNING: Missing block: B:10:0x0016, code skipped:
            return r3;
     */
    public boolean isNull(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r0 = r2.mUpdatedRows;
        monitor-enter(r0);
        r1 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0021 }
        if (r1 == 0) goto L_0x0017;
    L_0x000c:
        r3 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0021 }
        if (r3 != 0) goto L_0x0014;
    L_0x0012:
        r3 = 1;
        goto L_0x0015;
    L_0x0014:
        r3 = 0;
    L_0x0015:
        monitor-exit(r0);	 Catch:{ all -> 0x0021 }
        return r3;
    L_0x0017:
        monitor-exit(r0);	 Catch:{ all -> 0x0021 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r3 = r0.isNull(r1, r3);
        return r3;
    L_0x0021:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0021 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isNull(int):boolean");
    }

    /* JADX WARNING: Missing block: B:13:0x001b, code skipped:
            return r3;
     */
    public boolean isString(int r3) {
        /*
        r2 = this;
        r2.checkPosition();
        r0 = r2.mUpdatedRows;
        monitor-enter(r0);
        r1 = r2.isFieldUpdated(r3);	 Catch:{ all -> 0x0026 }
        if (r1 == 0) goto L_0x001c;
    L_0x000c:
        r3 = r2.getUpdatedField(r3);	 Catch:{ all -> 0x0026 }
        if (r3 == 0) goto L_0x0019;
    L_0x0012:
        r3 = r3 instanceof java.lang.String;	 Catch:{ all -> 0x0026 }
        if (r3 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0019;
    L_0x0017:
        r3 = 0;
        goto L_0x001a;
    L_0x0019:
        r3 = 1;
    L_0x001a:
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        return r3;
    L_0x001c:
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        r0 = r2.mWindow;
        r1 = r2.mPos;
        r3 = r0.isString(r1, r3);
        return r3;
    L_0x0026:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0026 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.AbstractWindowedCursor.isString(int):boolean");
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mWindow.close();
        }
        this.mWindow = cursorWindow;
    }
}
