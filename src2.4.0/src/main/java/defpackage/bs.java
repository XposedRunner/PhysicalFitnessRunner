package defpackage;

import android.os.Environment;
import android.text.TextUtils;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O00000o0;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00;
import java.io.File;
import java.io.IOException;

/* compiled from: FileUtil */
/* renamed from: bs */
public class bs {
    private static bs O00000Oo = new bs();
    private String O000000o = "";

    private bs() {
        try {
            this.O000000o = O00000Oo.O000000o().getCacheDir().getCanonicalPath();
        } catch (IOException e) {
            O0000O0o.O000000o(e);
        }
    }

    public static bs O000000o() {
        return O00000Oo == null ? new bs() : O00000Oo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0054 A:{SYNTHETIC, Splitter:B:36:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005c A:{Catch:{ IOException -> 0x0058 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006c A:{SYNTHETIC, Splitter:B:47:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0074 A:{Catch:{ IOException -> 0x0070 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0054 A:{SYNTHETIC, Splitter:B:36:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005c A:{Catch:{ IOException -> 0x0058 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006c A:{SYNTHETIC, Splitter:B:47:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0074 A:{Catch:{ IOException -> 0x0070 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006c A:{SYNTHETIC, Splitter:B:47:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0074 A:{Catch:{ IOException -> 0x0070 }} */
    public byte[] O000000o(java.io.File r6) {
        /*
        r5 = this;
        r0 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0047, all -> 0x0044 }
        r1.<init>(r6);	 Catch:{ Throwable -> 0x0047, all -> 0x0044 }
        r6 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x003f, all -> 0x003d }
        r6.<init>();	 Catch:{ Throwable -> 0x003f, all -> 0x003d }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x0038, all -> 0x0033 }
    L_0x000f:
        r2 = r1.read(r0);	 Catch:{ Throwable -> 0x0038, all -> 0x0033 }
        r3 = -1;
        if (r2 == r3) goto L_0x001b;
    L_0x0016:
        r3 = 0;
        r6.write(r0, r3, r2);	 Catch:{ Throwable -> 0x0038, all -> 0x0033 }
        goto L_0x000f;
    L_0x001b:
        r0 = r6.toByteArray();	 Catch:{ Throwable -> 0x0038, all -> 0x0033 }
        if (r1 == 0) goto L_0x0027;
    L_0x0021:
        r1.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0027;
    L_0x0025:
        r6 = move-exception;
        goto L_0x002d;
    L_0x0027:
        if (r6 == 0) goto L_0x0032;
    L_0x0029:
        r6.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0032;
    L_0x002d:
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r6);
    L_0x0032:
        return r0;
    L_0x0033:
        r0 = move-exception;
        r4 = r0;
        r0 = r6;
        r6 = r4;
        goto L_0x006a;
    L_0x0038:
        r0 = move-exception;
        r4 = r1;
        r1 = r6;
        r6 = r0;
        goto L_0x0042;
    L_0x003d:
        r6 = move-exception;
        goto L_0x006a;
    L_0x003f:
        r6 = move-exception;
        r4 = r1;
        r1 = r0;
    L_0x0042:
        r0 = r4;
        goto L_0x0049;
    L_0x0044:
        r6 = move-exception;
        r1 = r0;
        goto L_0x006a;
    L_0x0047:
        r6 = move-exception;
        r1 = r0;
    L_0x0049:
        r2 = com.umeng.socialize.utils.O0000o00.O0000OOo.O0000OOo;	 Catch:{ all -> 0x0066 }
        com.umeng.socialize.utils.O0000O0o.O000000o(r2, r6);	 Catch:{ all -> 0x0066 }
        r6 = com.umeng.socialize.utils.O00000o0.O000000o();	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x005a;
    L_0x0054:
        r0.close();	 Catch:{ IOException -> 0x0058 }
        goto L_0x005a;
    L_0x0058:
        r0 = move-exception;
        goto L_0x0060;
    L_0x005a:
        if (r1 == 0) goto L_0x0065;
    L_0x005c:
        r1.close();	 Catch:{ IOException -> 0x0058 }
        goto L_0x0065;
    L_0x0060:
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x0065:
        return r6;
    L_0x0066:
        r6 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x006a:
        if (r1 == 0) goto L_0x0072;
    L_0x006c:
        r1.close();	 Catch:{ IOException -> 0x0070 }
        goto L_0x0072;
    L_0x0070:
        r0 = move-exception;
        goto L_0x0078;
    L_0x0072:
        if (r0 == 0) goto L_0x007d;
    L_0x0074:
        r0.close();	 Catch:{ IOException -> 0x0070 }
        goto L_0x007d;
    L_0x0078:
        r1 = com.umeng.socialize.utils.O0000o00.O0000OOo.O00000o0;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x007d:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bs.O000000o(java.io.File):byte[]");
    }

    public File O00000Oo() throws IOException {
        File file = new File(O00000o0(), O00000o());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    public String O00000o() {
        return O0000Oo0.O00000oO(String.valueOf(System.currentTimeMillis()));
    }

    public File O00000o0() throws IOException {
        String canonicalPath;
        if (Environment.getExternalStorageDirectory() != null && !TextUtils.isEmpty(Environment.getExternalStorageDirectory().getCanonicalPath())) {
            canonicalPath = Environment.getExternalStorageDirectory().getCanonicalPath();
        } else if (TextUtils.isEmpty(this.O000000o)) {
            canonicalPath = O00000o0.O00000Oo();
            O0000O0o.O000000o(O0000o00.O00000Oo.O00000o0);
        } else {
            canonicalPath = this.O000000o;
            O0000O0o.O000000o(O0000o00.O00000Oo.O00000o0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(canonicalPath);
        stringBuilder.append(bt.O00000oo);
        File file = new File(stringBuilder.toString());
        if (!(file == null || file.exists())) {
            file.mkdirs();
        }
        return file;
    }
}
