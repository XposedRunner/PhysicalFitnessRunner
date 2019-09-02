package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream */
public class O000O0o0 extends FilterInputStream {
    private static final String O000000o = "BufferedIs";
    private volatile byte[] O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO = -1;
    private int O00000oo;

    /* compiled from: RecyclableBufferedInputStream */
    public static class O000000o extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public O000000o(String str) {
            super(str);
        }
    }

    public O000O0o0(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.O00000Oo = bArr;
    }

    private int O000000o(InputStream inputStream, byte[] bArr) throws IOException {
        int read;
        if (this.O00000oO == -1 || this.O00000oo - this.O00000oO >= this.O00000o) {
            read = inputStream.read(bArr);
            if (read > 0) {
                this.O00000oO = -1;
                this.O00000oo = 0;
                this.O00000o0 = read;
            }
            return read;
        }
        if (this.O00000oO == 0 && this.O00000o > bArr.length && this.O00000o0 == bArr.length) {
            int length = bArr.length * 2;
            if (length > this.O00000o) {
                length = this.O00000o;
            }
            if (Log.isLoggable(O000000o, 3)) {
                String str = O000000o;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("allocate buffer of length: ");
                stringBuilder.append(length);
                Log.d(str, stringBuilder.toString());
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.O00000Oo = bArr2;
            bArr = bArr2;
        } else if (this.O00000oO > 0) {
            System.arraycopy(bArr, this.O00000oO, bArr, 0, bArr.length - this.O00000oO);
        }
        this.O00000oo -= this.O00000oO;
        this.O00000oO = 0;
        this.O00000o0 = 0;
        read = inputStream.read(bArr, this.O00000oo, bArr.length - this.O00000oo);
        this.O00000o0 = read <= 0 ? this.O00000oo : this.O00000oo + read;
        return read;
    }

    private static IOException O00000Oo() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void O000000o() {
        this.O00000o = this.O00000Oo.length;
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.O00000Oo != null) {
            if (inputStream != null) {
            }
        }
        throw O00000Oo();
        return (this.O00000o0 - this.O00000oo) + inputStream.available();
    }

    public void close() throws IOException {
        this.O00000Oo = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i) {
        this.O00000o = Math.max(this.O00000o, i);
        this.O00000oO = this.O00000oo;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read() throws IOException {
        byte[] bArr = this.O00000Oo;
        InputStream inputStream = this.in;
        if (bArr != null) {
            if (inputStream != null) {
                if (this.O00000oo >= this.O00000o0 && O000000o(inputStream, bArr) == -1) {
                    return -1;
                }
                if (bArr != this.O00000Oo) {
                    bArr = this.O00000Oo;
                    if (bArr == null) {
                        throw O00000Oo();
                    }
                }
                if (this.O00000o0 - this.O00000oo <= 0) {
                    return -1;
                }
                int i = this.O00000oo;
                this.O00000oo = i + 1;
                return bArr[i] & 255;
            }
        }
        throw O00000Oo();
    }

    /* JADX WARNING: Missing block: B:27:0x0044, code skipped:
            return r2;
     */
    /* JADX WARNING: Missing block: B:39:0x005a, code skipped:
            return r4;
     */
    /* JADX WARNING: Missing block: B:46:0x0067, code skipped:
            return r4;
     */
    public synchronized int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.O00000Oo;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x000a;
    L_0x0005:
        r6 = O00000Oo();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x000a:
        if (r8 != 0) goto L_0x000f;
    L_0x000c:
        r6 = 0;
        monitor-exit(r5);
        return r6;
    L_0x000f:
        r1 = r5.in;	 Catch:{ all -> 0x009d }
        if (r1 != 0) goto L_0x0018;
    L_0x0013:
        r6 = O00000Oo();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x0018:
        r2 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r3 = r5.O00000o0;	 Catch:{ all -> 0x009d }
        if (r2 >= r3) goto L_0x0045;
    L_0x001e:
        r2 = r5.O00000o0;	 Catch:{ all -> 0x009d }
        r3 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r2 = r2 - r3;
        if (r2 < r8) goto L_0x0027;
    L_0x0025:
        r2 = r8;
        goto L_0x002c;
    L_0x0027:
        r2 = r5.O00000o0;	 Catch:{ all -> 0x009d }
        r3 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r2 = r2 - r3;
    L_0x002c:
        r3 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        java.lang.System.arraycopy(r0, r3, r6, r7, r2);	 Catch:{ all -> 0x009d }
        r3 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r3 = r3 + r2;
        r5.O00000oo = r3;	 Catch:{ all -> 0x009d }
        if (r2 == r8) goto L_0x0043;
    L_0x0038:
        r3 = r1.available();	 Catch:{ all -> 0x009d }
        if (r3 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0043;
    L_0x003f:
        r7 = r7 + r2;
        r2 = r8 - r2;
        goto L_0x0046;
    L_0x0043:
        monitor-exit(r5);
        return r2;
    L_0x0045:
        r2 = r8;
    L_0x0046:
        r3 = r5.O00000oO;	 Catch:{ all -> 0x009d }
        r4 = -1;
        if (r3 != r4) goto L_0x005b;
    L_0x004b:
        r3 = r0.length;	 Catch:{ all -> 0x009d }
        if (r2 < r3) goto L_0x005b;
    L_0x004e:
        r3 = r1.read(r6, r7, r2);	 Catch:{ all -> 0x009d }
        if (r3 != r4) goto L_0x008d;
    L_0x0054:
        if (r2 != r8) goto L_0x0057;
    L_0x0056:
        goto L_0x0059;
    L_0x0057:
        r4 = r8 - r2;
    L_0x0059:
        monitor-exit(r5);
        return r4;
    L_0x005b:
        r3 = r5.O000000o(r1, r0);	 Catch:{ all -> 0x009d }
        if (r3 != r4) goto L_0x0068;
    L_0x0061:
        if (r2 != r8) goto L_0x0064;
    L_0x0063:
        goto L_0x0066;
    L_0x0064:
        r4 = r8 - r2;
    L_0x0066:
        monitor-exit(r5);
        return r4;
    L_0x0068:
        r3 = r5.O00000Oo;	 Catch:{ all -> 0x009d }
        if (r0 == r3) goto L_0x0075;
    L_0x006c:
        r0 = r5.O00000Oo;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x0075;
    L_0x0070:
        r6 = O00000Oo();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x0075:
        r3 = r5.O00000o0;	 Catch:{ all -> 0x009d }
        r4 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r3 = r3 - r4;
        if (r3 < r2) goto L_0x007e;
    L_0x007c:
        r3 = r2;
        goto L_0x0083;
    L_0x007e:
        r3 = r5.O00000o0;	 Catch:{ all -> 0x009d }
        r4 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r3 = r3 - r4;
    L_0x0083:
        r4 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        java.lang.System.arraycopy(r0, r4, r6, r7, r3);	 Catch:{ all -> 0x009d }
        r4 = r5.O00000oo;	 Catch:{ all -> 0x009d }
        r4 = r4 + r3;
        r5.O00000oo = r4;	 Catch:{ all -> 0x009d }
    L_0x008d:
        r2 = r2 - r3;
        if (r2 != 0) goto L_0x0092;
    L_0x0090:
        monitor-exit(r5);
        return r8;
    L_0x0092:
        r4 = r1.available();	 Catch:{ all -> 0x009d }
        if (r4 != 0) goto L_0x009b;
    L_0x0098:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x009b:
        r7 = r7 + r3;
        goto L_0x0046;
    L_0x009d:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.O000O0o0.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.O00000Oo == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.O00000oO) {
            throw new O000000o("Mark has been invalidated");
        } else {
            this.O00000oo = this.O00000oO;
        }
    }

    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.O00000Oo;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw O00000Oo();
        } else if (j < 1) {
            return 0;
        } else {
            if (inputStream == null) {
                throw O00000Oo();
            } else if (((long) (this.O00000o0 - this.O00000oo)) >= j) {
                this.O00000oo = (int) (((long) this.O00000oo) + j);
                return j;
            } else {
                long j2 = (long) (this.O00000o0 - this.O00000oo);
                this.O00000oo = this.O00000o0;
                if (this.O00000oO == -1 || j > ((long) this.O00000o)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (O000000o(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    long j3 = j - j2;
                    if (((long) (this.O00000o0 - this.O00000oo)) >= j3) {
                        this.O00000oo = (int) (((long) this.O00000oo) + j3);
                        return j;
                    }
                    j2 = (j2 + ((long) this.O00000o0)) - ((long) this.O00000oo);
                    this.O00000oo = this.O00000o0;
                    return j2;
                }
            }
        }
    }
}
