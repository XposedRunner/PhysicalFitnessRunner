package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: SPUtil */
public class t {
    private x O000000o;
    private kr O00000Oo;
    private String O00000o = "";
    private o0OO0o00 O00000o0;
    private List<y> O00000oO = new ArrayList();

    public t(Context context, o0OO0o00 o0oo0o00, kr krVar) {
        this.O00000o0 = o0oo0o00;
        this.O00000Oo = krVar;
        this.O000000o = new x(context, o0oo0o00);
    }

    public static String O000000o(Context context, String str) {
        if (context == null) {
            return o0OO00o0.O00000Oo(str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o0O0o000.O0000oo0(context));
        stringBuilder.append(str);
        return o0OO00o0.O00000Oo(stringBuilder.toString());
    }

    public static String O000000o(Context context, String str, String str2) {
        return (context == null || TextUtils.isEmpty(str2)) ? "" : o0OOOO00.O000000o(o0oO0O0o.O00000Oo(o0OOOO00.O00000oO(context.getSharedPreferences(str, 0).getString(str2, ""))));
    }

    public static Field O000000o(Class<?> cls, String str) throws NoSuchFieldException {
        Class cls2 = cls;
        while (cls2 != null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Field ");
        stringBuilder.append(str);
        stringBuilder.append(" not found in ");
        stringBuilder.append(cls);
        throw new NoSuchFieldException(stringBuilder.toString());
    }

    public static Field O000000o(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Field ");
        stringBuilder.append(str);
        stringBuilder.append(" not found in ");
        stringBuilder.append(obj.getClass());
        throw new NoSuchFieldException(stringBuilder.toString());
    }

    public static Method O000000o(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Method ");
        stringBuilder.append(str);
        stringBuilder.append(" with parameters ");
        stringBuilder.append(Arrays.asList(clsArr));
        stringBuilder.append(" not found in ");
        stringBuilder.append(obj.getClass());
        throw new NoSuchMethodException(stringBuilder.toString());
    }

    /* JADX WARNING: Missing block: B:10:0x0032, code skipped:
            return;
     */
    public static void O000000o(android.content.Context r1, java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
        if (r1 == 0) goto L_0x0032;
    L_0x0002:
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0032;
    L_0x0008:
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0032;
    L_0x000f:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r4 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r4);
        r4 = com.amap.api.mapcore.util.o0oO0O0o.O000000o(r4);
        r4 = com.amap.api.mapcore.util.o0OOOO00.O0000O0o(r4);
        r0 = 0;
        r1 = r1.getSharedPreferences(r2, r0);
        r1 = r1.edit();
        r1.putString(r3, r4);
        r1.commit();
        return;
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.t.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static void O000000o(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].isDirectory()) {
                        O000000o(listFiles[i]);
                    } else {
                        listFiles[i].delete();
                    }
                }
                return;
            }
            return;
        }
        file.delete();
    }

    public static void O000000o(Object obj, String str, int i) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (i > 0) {
            Field O000000o = O000000o(obj, str);
            Object[] objArr = (Object[]) O000000o.get(obj);
            int length = objArr.length - i;
            if (length > 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                System.arraycopy(objArr, i, objArr2, 0, length);
                O000000o.set(obj, objArr2);
            }
        }
    }

    public static void O000000o(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field O000000o = O000000o(obj, str);
        Object[] objArr2 = (Object[]) O000000o.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        O000000o.set(obj, objArr3);
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public static void O000000o(String str, x xVar) {
        Throwable th;
        if (O00000o0(new File(str))) {
            byte[] bArr = new byte[1024];
            ZipInputStream zipInputStream = null;
            FileInputStream fileInputStream;
            ZipInputStream zipInputStream2;
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    zipInputStream2 = new ZipInputStream(fileInputStream);
                    try {
                        for (ZipEntry nextEntry = zipInputStream2.getNextEntry(); nextEntry != null; nextEntry = zipInputStream2.getNextEntry()) {
                            String name = nextEntry.getName();
                            int i = (name == null || !name.endsWith(".so")) ? 0 : 1;
                            if (i != 0) {
                                File file = new File(xVar.O000000o(name));
                                O00000Oo(file);
                                new File(file.getParent()).mkdirs();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                while (true) {
                                    i = zipInputStream2.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.close();
                            }
                            zipInputStream2.closeEntry();
                        }
                        zipInputStream2.closeEntry();
                        zipInputStream2.close();
                        fileInputStream.close();
                        try {
                            zipInputStream2.closeEntry();
                            zipInputStream2.close();
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zipInputStream2.closeEntry();
                        zipInputStream2.close();
                        fileInputStream.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    zipInputStream.closeEntry();
                    zipInputStream.close();
                    fileInputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                zipInputStream2 = null;
                fileInputStream = zipInputStream2;
                zipInputStream2.closeEntry();
                zipInputStream2.close();
                fileInputStream.close();
                throw th;
            }
        }
    }

    public static void O000000o(String str, String str2) {
        O00000Oo(str, str2);
        O00000oO(str);
    }

    public static void O000000o(String str, String str2, String str3) {
        if (O00000o0(new File(str))) {
            byte[] bArr = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                while (nextEntry != null) {
                    String name = nextEntry.getName();
                    int i = (name == null || !name.equalsIgnoreCase("so.png")) ? 0 : 1;
                    if (i != 0 || w.O000000o(name)) {
                        name = w.O000000o(name) ? str2 : str3;
                        O0000OoO(name);
                        FileOutputStream fileOutputStream = new FileOutputStream(name);
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.close();
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    }
                }
                zipInputStream.closeEntry();
                zipInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void O000000o(Throwable th, String str) {
        ooOOOOoo.O00000o0(th, "po", str);
    }

    private static void O00000Oo(File file) throws IOException {
        if (!file.exists() || !file.isFile()) {
            if (file.exists()) {
                if (file.exists() && !file.isFile()) {
                    file.delete();
                    file.createNewFile();
                }
                return;
            }
            file.createNewFile();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0058 */
    public static void O00000Oo(java.lang.String r3, java.lang.String r4) {
        /*
        r0 = O0000O0o(r3);
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r4 = r3.getAbsolutePath();	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        O0000OoO(r4);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r4 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r4.<init>(r1);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r1 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0058, all -> 0x0045 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0058, all -> 0x0045 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new byte[r3];	 Catch:{ Throwable -> 0x0043, all -> 0x0041 }
    L_0x0027:
        r0 = r4.read(r3);	 Catch:{ Throwable -> 0x0043, all -> 0x0041 }
        if (r0 <= 0) goto L_0x0032;
    L_0x002d:
        r2 = 0;
        r1.write(r3, r2, r0);	 Catch:{ Throwable -> 0x0043, all -> 0x0041 }
        goto L_0x0027;
    L_0x0032:
        r1.flush();	 Catch:{ Throwable -> 0x0043, all -> 0x0041 }
        r4.close();	 Catch:{ IOException -> 0x003c }
        r1.close();	 Catch:{ IOException -> 0x003c }
        return;
    L_0x003c:
        r3 = move-exception;
        r3.printStackTrace();
        return;
    L_0x0041:
        r3 = move-exception;
        goto L_0x0047;
    L_0x0043:
        r0 = r1;
        goto L_0x0058;
    L_0x0045:
        r3 = move-exception;
        r1 = r0;
    L_0x0047:
        r0 = r4;
        goto L_0x004b;
    L_0x0049:
        r3 = move-exception;
        r1 = r0;
    L_0x004b:
        r0.close();	 Catch:{ IOException -> 0x0052 }
        r1.close();	 Catch:{ IOException -> 0x0052 }
        goto L_0x0056;
    L_0x0052:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0056:
        throw r3;
    L_0x0057:
        r4 = r0;
    L_0x0058:
        r4.close();	 Catch:{ IOException -> 0x005f }
        r0.close();	 Catch:{ IOException -> 0x005f }
        return;
    L_0x005f:
        r3 = move-exception;
        r3.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.t.O00000Oo(java.lang.String, java.lang.String):void");
    }

    public static void O00000o(String str) {
        File file = new File(str);
        if (file.exists()) {
            O000000o(file);
        }
    }

    public static boolean O00000o(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        O0000O0o(str2);
        return str.equals(o0OO00o0.O000000o(str2));
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0058 */
    public static void O00000o0(java.lang.String r4, java.lang.String r5) {
        /*
        r0 = O0000O0o(r4);
        if (r0 == 0) goto L_0x0063;
    L_0x0006:
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r1.<init>(r4);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r5 = r2.getAbsolutePath();	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        O0000OoO(r5);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r5 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r5.<init>(r1);	 Catch:{ Throwable -> 0x0057, all -> 0x0049 }
        r1 = 32;
        r1 = new byte[r1];	 Catch:{ Throwable -> 0x0058, all -> 0x0047 }
        r5.read(r1);	 Catch:{ Throwable -> 0x0058, all -> 0x0047 }
        r1 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x0058, all -> 0x0047 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0058, all -> 0x0047 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Throwable -> 0x0045, all -> 0x0042 }
    L_0x002d:
        r2 = r5.read(r0);	 Catch:{ Throwable -> 0x0045, all -> 0x0042 }
        if (r2 <= 0) goto L_0x0038;
    L_0x0033:
        r3 = 0;
        r1.write(r0, r3, r2);	 Catch:{ Throwable -> 0x0045, all -> 0x0042 }
        goto L_0x002d;
    L_0x0038:
        r1.flush();	 Catch:{ Throwable -> 0x0045, all -> 0x0042 }
        r5.close();	 Catch:{ IOException -> 0x005f }
        r1.close();	 Catch:{ IOException -> 0x005f }
        goto L_0x0063;
    L_0x0042:
        r4 = move-exception;
        r0 = r1;
        goto L_0x004b;
    L_0x0045:
        r0 = r1;
        goto L_0x0058;
    L_0x0047:
        r4 = move-exception;
        goto L_0x004b;
    L_0x0049:
        r4 = move-exception;
        r5 = r0;
    L_0x004b:
        r5.close();	 Catch:{ IOException -> 0x0052 }
        r0.close();	 Catch:{ IOException -> 0x0052 }
        goto L_0x0056;
    L_0x0052:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0056:
        throw r4;
    L_0x0057:
        r5 = r0;
    L_0x0058:
        r5.close();	 Catch:{ IOException -> 0x005f }
        r0.close();	 Catch:{ IOException -> 0x005f }
        goto L_0x0063;
    L_0x005f:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0063:
        O00000oO(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.t.O00000o0(java.lang.String, java.lang.String):void");
    }

    private static boolean O00000o0(File file) {
        return file.exists();
    }

    public static void O00000oO(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void O00000oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                if (!file.exists()) {
                    file.mkdirs();
                } else if (file.exists() && !file.isDirectory()) {
                    file.delete();
                    file.mkdirs();
                }
            }
        }
    }

    public static boolean O0000O0o(String str) {
        return O00000o0(new File(str));
    }

    private static String O0000OOo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder;
        if (!str.startsWith("lib")) {
            stringBuilder = new StringBuilder("lib");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        if (!str.endsWith(".so")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".so");
            str = stringBuilder.toString();
        }
        return str;
    }

    private int O0000Oo(String str) {
        String O0000OOo = O0000OOo(str);
        x xVar = this.O000000o;
        str = (xVar == null || TextUtils.isEmpty(str)) ? "" : xVar.O00000Oo(O0000OOo(str));
        y O000000o = this.O00000Oo.O000000o(O0000OOo);
        File file = new File(str);
        Object obj = (!file.exists() || file.isDirectory()) ? null : 1;
        if (obj == null) {
            return 1001;
        }
        this.O00000oO.add(O000000o);
        try {
            System.load(str);
            try {
                O000000o();
            } catch (Throwable unused) {
            }
            return 1000;
        } catch (Throwable unused2) {
            return 1001;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0008 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(1:4)|5|6|7) */
    /* JADX WARNING: Missing block: B:10:0x000d, code skipped:
            return false;
     */
    private boolean O0000Oo0(java.lang.String r3) {
        /*
        r2 = this;
        r0 = 1;
        r1 = r2.O00000o0(r3);	 Catch:{ Throwable -> 0x0008 }
        if (r1 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        java.lang.System.loadLibrary(r3);	 Catch:{ Throwable -> 0x000c }
        return r0;
    L_0x000c:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.t.O0000Oo0(java.lang.String):boolean");
    }

    private static void O0000OoO(String str) throws IOException {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            O00000oo(file.getParentFile().getAbsolutePath());
            O00000Oo(file);
        }
    }

    public void O000000o() {
        if (this.O00000oO != null && this.O00000oO.size() != 0) {
            boolean z = z.O000000o;
        }
    }

    public boolean O00000Oo(String str) {
        try {
            return this.O00000o0 == null ? false : O0000Oo0(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean O00000o0(String str) {
        return O0000Oo(str) == 1000;
    }
}
