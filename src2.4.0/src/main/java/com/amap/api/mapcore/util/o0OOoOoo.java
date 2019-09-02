package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.HashMap;

/* compiled from: ImageCache */
public class o0OOoOoo {
    private static final CompressFormat O000000o = CompressFormat.PNG;
    private oOo0o0oO O00000Oo;
    private O000000o O00000o;
    private OOO0oO<String, Bitmap> O00000o0;
    private final Object O00000oO = new Object();
    private boolean O00000oo = true;
    private HashMap<String, WeakReference<Bitmap>> O0000O0o;

    /* compiled from: ImageCache */
    public static class O000000o {
        public int O000000o = 5242880;
        public long O00000Oo = 10485760;
        public CompressFormat O00000o = o0OOoOoo.O000000o;
        public File O00000o0;
        public int O00000oO = 100;
        public boolean O00000oo = true;
        public boolean O0000O0o = true;
        public boolean O0000OOo = false;
        public String O0000Oo = null;
        public boolean O0000Oo0 = true;

        public O000000o(Context context, String str) {
            this.O0000Oo = str;
            this.O00000o0 = o0OOoOoo.O000000o(context, str, null);
        }

        public O000000o(Context context, String str, String str2) {
            this.O0000Oo = str;
            this.O00000o0 = o0OOoOoo.O000000o(context, str, str2);
        }

        public void O000000o(int i) {
            this.O000000o = i;
        }

        public void O000000o(long j) {
            if (j <= 0) {
                this.O0000O0o = false;
            }
            this.O00000Oo = j;
        }

        public void O000000o(String str) {
            this.O00000o0 = new File(str);
        }

        public void O000000o(boolean z) {
            this.O00000oo = z;
        }

        public void O00000Oo(String str) {
            this.O00000o0 = o0OOoOoo.O000000o(cf.O000000o, this.O0000Oo, str);
        }

        public void O00000Oo(boolean z) {
            this.O0000O0o = z;
        }
    }

    private o0OOoOoo(O000000o o000000o) {
        O00000Oo(o000000o);
    }

    public static int O000000o(Bitmap bitmap) {
        return OOo000.O00000o() ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static long O000000o(File file) {
        if (OOo000.O00000Oo()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    public static o0OOoOoo O000000o(O000000o o000000o) {
        return new o0OOoOoo(o000000o);
    }

    public static File O000000o(Context context) {
        try {
            if (OOo000.O000000o()) {
                return context.getExternalCacheDir();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/Android/data/");
            stringBuilder.append(context.getPackageName());
            stringBuilder.append("/cache/");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder3.append(stringBuilder2);
            return new File(stringBuilder3.toString());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File O000000o(Context context, String str, String str2) {
        File O000000o = O000000o(context);
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !O00000o()) && O000000o != null) ? O000000o.getPath() : context.getCacheDir().getPath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(File.separator);
            stringBuilder.append(str2);
        }
        return new File(stringBuilder.toString());
    }

    private static String O000000o(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(255 & b);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private void O00000Oo(O000000o o000000o) {
        this.O00000o = o000000o;
        if (this.O00000o.O00000oo) {
            if (OOo0000.O000000o()) {
                this.O0000O0o = new HashMap(64);
            }
            this.O00000o0 = new OOO0oO<String, Bitmap>(this.O00000o.O000000o) {
                /* Access modifiers changed, original: protected */
                /* renamed from: O000000o */
                public int O00000Oo(String str, Bitmap bitmap) {
                    int O000000o = o0OOoOoo.O000000o(bitmap);
                    return O000000o == 0 ? 1 : O000000o;
                }

                /* Access modifiers changed, original: protected */
                public void O000000o(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (OOo000.O00000o0() && o0OOoOoo.this.O0000O0o != null && bitmap != null && !bitmap.isRecycled()) {
                        o0OOoOoo.this.O0000O0o.put(str, new WeakReference(bitmap));
                    }
                }
            };
        }
        if (o000000o.O0000OOo) {
            O000000o();
        }
    }

    private void O00000Oo(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("not a readable directory: ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                O00000Oo(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("failed to delete file: ");
                stringBuilder2.append(file2);
                throw new IOException(stringBuilder2.toString());
            }
        }
    }

    public static boolean O00000o() {
        return OOo000.O00000Oo() ? Environment.isExternalStorageRemovable() : true;
    }

    public static String O00000o0(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("utf-8"));
            return O000000o(instance.digest());
        } catch (Throwable unused) {
            return String.valueOf(str.hashCode());
        }
    }

    public Bitmap O000000o(String str) {
        Bitmap bitmap;
        if (OOo000.O00000o0() && this.O0000O0o != null) {
            WeakReference weakReference = (WeakReference) this.O0000O0o.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
                this.O0000O0o.remove(str);
                if (bitmap == null && this.O00000o0 != null) {
                    bitmap = (Bitmap) this.O00000o0.O000000o((Object) str);
                }
                return (bitmap != null || bitmap.isRecycled()) ? null : bitmap;
            }
        }
        bitmap = null;
        bitmap = (Bitmap) this.O00000o0.O000000o((Object) str);
        if (bitmap != null) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A:{SYNTHETIC, Splitter:B:21:0x003d} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0049 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|(2:13|(1:15))(1:16)|17|18|19|(4:21|22|23|24)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
    public void O000000o() {
        /*
        r7 = this;
        r0 = r7.O00000oO;
        monitor-enter(r0);
        r1 = r7.O00000Oo;	 Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r1 = r7.O00000Oo;	 Catch:{ all -> 0x0058 }
        r1 = r1.O00000o();	 Catch:{ all -> 0x0058 }
        if (r1 == 0) goto L_0x004e;
    L_0x000f:
        r1 = r7.O00000o;	 Catch:{ all -> 0x0058 }
        r1 = r1.O00000o0;	 Catch:{ all -> 0x0058 }
        r2 = r7.O00000o;	 Catch:{ all -> 0x0058 }
        r2 = r2.O0000O0o;	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x004e;
    L_0x0019:
        if (r1 == 0) goto L_0x004e;
    L_0x001b:
        r2 = r1.exists();	 Catch:{ Throwable -> 0x0031 }
        if (r2 == 0) goto L_0x002e;
    L_0x0021:
        r2 = r7.O00000o;	 Catch:{ Throwable -> 0x0031 }
        r2 = r2.O0000Oo0;	 Catch:{ Throwable -> 0x0031 }
        if (r2 == 0) goto L_0x0031;
    L_0x0027:
        r7.O00000Oo(r1);	 Catch:{ Throwable -> 0x0031 }
        r1.mkdir();	 Catch:{ Throwable -> 0x0031 }
        goto L_0x0031;
    L_0x002e:
        r1.mkdirs();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        r2 = O000000o(r1);	 Catch:{ all -> 0x0058 }
        r4 = r7.O00000o;	 Catch:{ all -> 0x0058 }
        r4 = r4.O00000Oo;	 Catch:{ all -> 0x0058 }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x004e;
    L_0x003d:
        r2 = r7.O00000o;	 Catch:{ Throwable -> 0x0049 }
        r2 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0049 }
        r4 = 1;
        r1 = com.amap.api.mapcore.util.oOo0o0oO.O000000o(r1, r4, r4, r2);	 Catch:{ Throwable -> 0x0049 }
        r7.O00000Oo = r1;	 Catch:{ Throwable -> 0x0049 }
        goto L_0x004e;
    L_0x0049:
        r1 = r7.O00000o;	 Catch:{ all -> 0x0058 }
        r2 = 0;
        r1.O00000o0 = r2;	 Catch:{ all -> 0x0058 }
    L_0x004e:
        r1 = 0;
        r7.O00000oo = r1;	 Catch:{ all -> 0x0058 }
        r1 = r7.O00000oO;	 Catch:{ all -> 0x0058 }
        r1.notifyAll();	 Catch:{ all -> 0x0058 }
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0058:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOoOoo.O000000o():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A:{SYNTHETIC, Splitter:B:34:0x005d} */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|(2:34|35)|36|37) */
    /* JADX WARNING: Missing block: B:29:0x0054, code skipped:
            if (r1 != null) goto L_0x0056;
     */
    public void O000000o(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0069;
    L_0x0002:
        if (r6 == 0) goto L_0x0069;
    L_0x0004:
        r0 = r6.isRecycled();
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        goto L_0x0069;
    L_0x000b:
        r0 = r4.O00000o0;
        if (r0 == 0) goto L_0x0014;
    L_0x000f:
        r0 = r4.O00000o0;
        r0.O000000o(r5, r6);
    L_0x0014:
        r0 = r4.O00000oO;
        monitor-enter(r0);
        r1 = r4.O00000Oo;	 Catch:{ all -> 0x0066 }
        if (r1 == 0) goto L_0x0064;
    L_0x001b:
        r5 = O00000o0(r5);	 Catch:{ all -> 0x0066 }
        r1 = 0;
        r2 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
        r2 = r2.O000000o(r5);	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
        r3 = 0;
        if (r2 != 0) goto L_0x004d;
    L_0x0029:
        r2 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
        r5 = r2.O00000Oo(r5);	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
        if (r5 == 0) goto L_0x0054;
    L_0x0031:
        r2 = r5.O000000o(r3);	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
        r1 = r4.O00000o;	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r1 = r1.O00000o;	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r3 = r4.O00000o;	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r3 = r3.O00000oO;	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r6.compress(r1, r3, r2);	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r5.O000000o();	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r2.close();	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r1 = r2;
        goto L_0x0054;
    L_0x0048:
        r5 = move-exception;
        r1 = r2;
        goto L_0x005b;
    L_0x004b:
        r1 = r2;
        goto L_0x0061;
    L_0x004d:
        r5 = r2.O000000o(r3);	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
        r5.close();	 Catch:{ Throwable -> 0x0061, all -> 0x005a }
    L_0x0054:
        if (r1 == 0) goto L_0x0064;
    L_0x0056:
        r1.close();	 Catch:{ Throwable -> 0x0064 }
        goto L_0x0064;
    L_0x005a:
        r5 = move-exception;
    L_0x005b:
        if (r1 == 0) goto L_0x0060;
    L_0x005d:
        r1.close();	 Catch:{ Throwable -> 0x0060 }
    L_0x0060:
        throw r5;	 Catch:{ all -> 0x0066 }
    L_0x0061:
        if (r1 == 0) goto L_0x0064;
    L_0x0063:
        goto L_0x0056;
    L_0x0064:
        monitor-exit(r0);	 Catch:{ all -> 0x0066 }
        return;
    L_0x0066:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0066 }
        throw r5;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOoOoo.O000000o(java.lang.String, android.graphics.Bitmap):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0037 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|(3:13|14|(2:(1:17)(1:18)|19))|20|21) */
    public void O000000o(boolean r3) {
        /*
        r2 = this;
        r0 = com.amap.api.mapcore.util.OOo000.O00000o0();
        if (r0 == 0) goto L_0x000f;
    L_0x0006:
        r0 = r2.O0000O0o;
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r0 = r2.O0000O0o;
        r0.clear();
    L_0x000f:
        r0 = r2.O00000o0;
        if (r0 == 0) goto L_0x0018;
    L_0x0013:
        r0 = r2.O00000o0;
        r0.O000000o();
    L_0x0018:
        r0 = r2.O00000oO;
        monitor-enter(r0);
        r1 = r2.O00000Oo;	 Catch:{ all -> 0x0039 }
        if (r1 == 0) goto L_0x0037;
    L_0x001f:
        r1 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0037 }
        r1 = r1.O00000o();	 Catch:{ Throwable -> 0x0037 }
        if (r1 != 0) goto L_0x0037;
    L_0x0027:
        if (r3 == 0) goto L_0x002f;
    L_0x0029:
        r3 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0037 }
        r3.O00000oo();	 Catch:{ Throwable -> 0x0037 }
        goto L_0x0034;
    L_0x002f:
        r3 = r2.O00000Oo;	 Catch:{ Throwable -> 0x0037 }
        r3.close();	 Catch:{ Throwable -> 0x0037 }
    L_0x0034:
        r3 = 0;
        r2.O00000Oo = r3;	 Catch:{ Throwable -> 0x0037 }
    L_0x0037:
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        return;
    L_0x0039:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0039 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOoOoo.O000000o(boolean):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0007 A:{LOOP_START, SYNTHETIC, LOOP:0: B:2:0x0007->B:43:0x0007} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0007 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0049 A:{Catch:{ Throwable -> 0x0046, all -> 0x003e }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0042 A:{SYNTHETIC, Splitter:B:28:0x0042} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|(2:28|29)|30|31) */
    /* JADX WARNING: Missing block: B:22:0x0038, code skipped:
            if (r5 != null) goto L_0x003a;
     */
    public android.graphics.Bitmap O00000Oo(java.lang.String r5) {
        /*
        r4 = this;
        r5 = O00000o0(r5);
        r0 = r4.O00000oO;
        monitor-enter(r0);
    L_0x0007:
        r1 = r4.O00000oo;	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x0011;
    L_0x000b:
        r1 = r4.O00000oO;	 Catch:{ Throwable -> 0x0007 }
        r1.wait();	 Catch:{ Throwable -> 0x0007 }
        goto L_0x0007;
    L_0x0011:
        r1 = r4.O00000Oo;	 Catch:{ all -> 0x004c }
        r2 = 0;
        if (r1 == 0) goto L_0x004a;
    L_0x0016:
        r1 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0046, all -> 0x003e }
        r5 = r1.O000000o(r5);	 Catch:{ Throwable -> 0x0046, all -> 0x003e }
        if (r5 == 0) goto L_0x0037;
    L_0x001e:
        r1 = 0;
        r5 = r5.O000000o(r1);	 Catch:{ Throwable -> 0x0046, all -> 0x003e }
        if (r5 == 0) goto L_0x0038;
    L_0x0025:
        r1 = r5;
        r1 = (java.io.FileInputStream) r1;	 Catch:{ Throwable -> 0x0047, all -> 0x0035 }
        r1 = r1.getFD();	 Catch:{ Throwable -> 0x0047, all -> 0x0035 }
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r1 = com.amap.api.mapcore.util.OOOo.O000000o(r1, r3, r3, r4);	 Catch:{ Throwable -> 0x0047, all -> 0x0035 }
        r2 = r1;
        goto L_0x0038;
    L_0x0035:
        r1 = move-exception;
        goto L_0x0040;
    L_0x0037:
        r5 = r2;
    L_0x0038:
        if (r5 == 0) goto L_0x004a;
    L_0x003a:
        r5.close();	 Catch:{ Throwable -> 0x004a }
        goto L_0x004a;
    L_0x003e:
        r1 = move-exception;
        r5 = r2;
    L_0x0040:
        if (r5 == 0) goto L_0x0045;
    L_0x0042:
        r5.close();	 Catch:{ Throwable -> 0x0045 }
    L_0x0045:
        throw r1;	 Catch:{ all -> 0x004c }
    L_0x0046:
        r5 = r2;
    L_0x0047:
        if (r5 == 0) goto L_0x004a;
    L_0x0049:
        goto L_0x003a;
    L_0x004a:
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        return r2;
    L_0x004c:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004c }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOoOoo.O00000Oo(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|20) */
    public void O00000Oo() {
        /*
        r4 = this;
        r0 = com.amap.api.mapcore.util.OOo000.O00000o0();
        if (r0 == 0) goto L_0x000f;
    L_0x0006:
        r0 = r4.O0000O0o;
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        r0 = r4.O0000O0o;
        r0.clear();
    L_0x000f:
        r0 = r4.O00000o0;
        if (r0 == 0) goto L_0x0018;
    L_0x0013:
        r0 = r4.O00000o0;
        r0.O000000o();
    L_0x0018:
        r0 = r4.O00000oO;
        monitor-enter(r0);
        r1 = 1;
        r4.O00000oo = r1;	 Catch:{ all -> 0x0044 }
        r1 = r4.O00000Oo;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0042;
    L_0x0022:
        r1 = r4.O00000Oo;	 Catch:{ all -> 0x0044 }
        r1 = r1.O00000o();	 Catch:{ all -> 0x0044 }
        if (r1 != 0) goto L_0x0042;
    L_0x002a:
        r1 = 0;
        r2 = r4.O00000Oo;	 Catch:{ Throwable -> 0x003d }
        r2.close();	 Catch:{ Throwable -> 0x003d }
        r2 = com.amap.api.mapcore.util.cf.O000000o;	 Catch:{ Throwable -> 0x003d }
        r3 = r4.O00000o;	 Catch:{ Throwable -> 0x003d }
        r3 = r3.O0000Oo;	 Catch:{ Throwable -> 0x003d }
        r2 = O000000o(r2, r3, r1);	 Catch:{ Throwable -> 0x003d }
        r4.O00000Oo(r2);	 Catch:{ Throwable -> 0x003d }
    L_0x003d:
        r4.O00000Oo = r1;	 Catch:{ all -> 0x0044 }
        r4.O000000o();	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r0);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0044 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOoOoo.O00000Oo():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000c */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:5|6)|7|8) */
    public void O00000o0() {
        /*
        r2 = this;
        r0 = r2.O00000oO;
        monitor-enter(r0);
        r1 = r2.O00000Oo;	 Catch:{ all -> 0x000e }
        if (r1 == 0) goto L_0x000c;
    L_0x0007:
        r1 = r2.O00000Oo;	 Catch:{ Throwable -> 0x000c }
        r1.O00000oO();	 Catch:{ Throwable -> 0x000c }
    L_0x000c:
        monitor-exit(r0);	 Catch:{ all -> 0x000e }
        return;
    L_0x000e:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x000e }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOoOoo.O00000o0():void");
    }
}
