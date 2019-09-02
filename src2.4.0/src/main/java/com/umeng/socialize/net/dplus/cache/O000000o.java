package com.umeng.socialize.net.dplus.cache;

import android.util.Log;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O00000Oo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: AtomicFile */
public class O000000o {
    private final File O000000o;
    private final File O00000Oo;

    public O000000o(File file) {
        this.O000000o = file;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getPath());
        stringBuilder.append(".bak");
        this.O00000Oo = new File(stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    private static void O000000o(java.io.File r6, java.io.File r7) throws java.io.IOException {
        /*
        r0 = java.lang.System.currentTimeMillis();
        r2 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ all -> 0x0060 }
        r3.<init>(r6);	 Catch:{ all -> 0x0060 }
        r6 = new java.io.FileOutputStream;	 Catch:{ all -> 0x005d }
        r6.<init>(r7);	 Catch:{ all -> 0x005d }
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r7 = new byte[r7];	 Catch:{ all -> 0x005b }
    L_0x0013:
        r2 = r3.read(r7);	 Catch:{ all -> 0x005b }
        if (r2 <= 0) goto L_0x0034;
    L_0x0019:
        r4 = 0;
        r6.write(r7, r4, r2);	 Catch:{ all -> 0x005b }
        r4 = "AtomicFile";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005b }
        r5.<init>();	 Catch:{ all -> 0x005b }
        r5.append(r2);	 Catch:{ all -> 0x005b }
        r2 = "";
        r5.append(r2);	 Catch:{ all -> 0x005b }
        r2 = r5.toString();	 Catch:{ all -> 0x005b }
        android.util.Log.d(r4, r2);	 Catch:{ all -> 0x005b }
        goto L_0x0013;
    L_0x0034:
        if (r3 == 0) goto L_0x0039;
    L_0x0036:
        r3.close();
    L_0x0039:
        if (r6 == 0) goto L_0x003e;
    L_0x003b:
        r6.close();
    L_0x003e:
        r6 = "AtomicFile";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r2 = "comsum time:";
        r7.append(r2);
        r2 = java.lang.System.currentTimeMillis();
        r4 = r2 - r0;
        r7.append(r4);
        r7 = r7.toString();
        android.util.Log.d(r6, r7);
        return;
    L_0x005b:
        r7 = move-exception;
        goto L_0x0063;
    L_0x005d:
        r7 = move-exception;
        r6 = r2;
        goto L_0x0063;
    L_0x0060:
        r7 = move-exception;
        r6 = r2;
        r3 = r6;
    L_0x0063:
        if (r3 == 0) goto L_0x0068;
    L_0x0065:
        r3.close();
    L_0x0068:
        if (r6 == 0) goto L_0x006d;
    L_0x006a:
        r6.close();
    L_0x006d:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache.O000000o.O000000o(java.io.File, java.io.File):void");
    }

    static boolean O00000o0(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                O0000O0o.O000000o(O00000Oo.O000000o, e);
                return false;
            }
        }
        return true;
    }

    public File O000000o() {
        return this.O000000o;
    }

    public FileOutputStream O000000o(boolean z) throws IOException {
        if (this.O000000o.exists()) {
            if (this.O00000Oo.exists()) {
                this.O000000o.delete();
            } else if (this.O000000o.renameTo(this.O00000Oo)) {
                O000000o(this.O00000Oo, this.O000000o);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't rename file ");
                stringBuilder.append(this.O000000o);
                stringBuilder.append(" to backup file ");
                stringBuilder.append(this.O00000Oo);
                Log.w("AtomicFile", stringBuilder.toString());
            }
        }
        try {
            return new FileOutputStream(this.O000000o, z);
        } catch (FileNotFoundException e) {
            if (!this.O000000o.getParentFile().mkdirs()) {
                O0000O0o.O000000o(O00000Oo.O000000o, e);
            }
            try {
                return new FileOutputStream(this.O000000o, z);
            } catch (FileNotFoundException unused) {
                O0000O0o.O000000o(O00000Oo.O000000o, e);
                return null;
            }
        }
    }

    public void O000000o(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            O00000o0(fileOutputStream);
            try {
                fileOutputStream.close();
                this.O00000Oo.delete();
            } catch (IOException e) {
                O0000O0o.O000000o(O00000Oo.O000000o, e);
            }
        }
    }

    public void O00000Oo() {
        this.O000000o.delete();
        this.O00000Oo.delete();
    }

    public void O00000Oo(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            O00000o0(fileOutputStream);
            try {
                fileOutputStream.close();
                this.O000000o.delete();
                this.O00000Oo.renameTo(this.O000000o);
            } catch (IOException e) {
                O0000O0o.O000000o(O00000Oo.O000000o, e);
            }
        }
    }

    public byte[] O00000o() throws IOException {
        FileInputStream O00000o0 = O00000o0();
        try {
            byte[] bArr = new byte[O00000o0.available()];
            int i = 0;
            while (true) {
                int read = O00000o0.read(bArr, i, bArr.length - i);
                if (read <= 0) {
                    break;
                }
                i += read;
                read = O00000o0.available();
                if (read > bArr.length - i) {
                    byte[] bArr2 = new byte[(read + i)];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    bArr = bArr2;
                }
            }
            return bArr;
        } finally {
            O00000o0.close();
        }
    }

    public FileInputStream O00000o0() throws FileNotFoundException {
        if (this.O00000Oo.exists()) {
            this.O000000o.delete();
            this.O00000Oo.renameTo(this.O000000o);
        }
        return new FileInputStream(this.O000000o);
    }
}
