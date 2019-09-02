package com.baidu.mapsdkplatform.comapi.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private static volatile g a;
    private boolean b = false;
    private boolean c = true;
    private final List<f> d = new ArrayList();
    private f e = null;
    private String f;

    private g() {
    }

    public static g a() {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g();
                }
            }
        }
        return a;
    }

    private boolean a(String str) {
        boolean createNewFile;
        Exception e;
        boolean z = false;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/test.0");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                file.delete();
            }
            createNewFile = file.createNewFile();
            try {
                if (file.exists()) {
                    file.delete();
                    return createNewFile;
                }
            } catch (Exception e2) {
                Exception exception = e2;
                z = createNewFile;
                e = exception;
                e.printStackTrace();
                createNewFile = z;
                return createNewFile;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            createNewFile = z;
            return createNewFile;
        }
        return createNewFile;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(14)
    private void c(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class});
            Class cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Method method4 = cls.getMethod("getPath", new Class[0]);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    String str = (String) method4.invoke(obj, new Object[0]);
                    if (str != null && str.length() > 0) {
                        if ("mounted".equals(method2.invoke(storageManager, new Object[]{str}))) {
                            int booleanValue = ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() ^ 1;
                            if (VERSION.SDK_INT <= 19 && a(str)) {
                                this.d.add(new f(str, booleanValue == 0, booleanValue != 0 ? "内置存储卡" : "外置存储卡", context));
                            } else if (VERSION.SDK_INT >= 19) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(str);
                                stringBuilder.append(File.separator);
                                stringBuilder.append("BaiduMapSDKNew");
                                if (new File(stringBuilder.toString()).exists() && str.equals(context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", ""))) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(str);
                                    stringBuilder2.append(File.separator);
                                    stringBuilder2.append("BaiduMapSDKNew");
                                    this.f = stringBuilder2.toString();
                                }
                            }
                        }
                    }
                }
                if (VERSION.SDK_INT >= 19) {
                    File[] externalFilesDirs = context.getExternalFilesDirs(null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.d);
                    for (int i = 0; i < externalFilesDirs.length; i++) {
                        if (externalFilesDirs[i] == null) {
                            break;
                        }
                        int i2;
                        String absolutePath = externalFilesDirs[i].getAbsolutePath();
                        for (f a : this.d) {
                            if (absolutePath.startsWith(a.a())) {
                                i2 = 1;
                                break;
                            }
                        }
                        i2 = 0;
                        String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                        if (!(str2 == null || i2 != 0 || absolutePath.indexOf(str2) == -1)) {
                            arrayList.add(new f(absolutePath, true, "外置存储卡", context));
                        }
                    }
                    this.d.clear();
                    this.d.addAll(arrayList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0107  */
    private void d(android.content.Context r10) {
        /*
        r9 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00fb }
        r4 = "/proc/mounts";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00fb }
        r4 = r3.exists();	 Catch:{ Exception -> 0x00fb }
        r5 = 32;
        r6 = 9;
        if (r4 == 0) goto L_0x0055;
    L_0x001c:
        r4 = new java.util.Scanner;	 Catch:{ Exception -> 0x00fb }
        r4.<init>(r3);	 Catch:{ Exception -> 0x00fb }
    L_0x0021:
        r3 = r4.hasNext();	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r3 == 0) goto L_0x0049;
    L_0x0027:
        r3 = r4.nextLine();	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r7 = "/dev/block/vold/";
        r7 = r3.startsWith(r7);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r7 == 0) goto L_0x0021;
    L_0x0033:
        r3 = r3.replace(r6, r5);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r7 = " ";
        r3 = r3.split(r7);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r3 == 0) goto L_0x0021;
    L_0x003f:
        r7 = r3.length;	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r7 <= 0) goto L_0x0021;
    L_0x0042:
        r7 = 1;
        r3 = r3[r7];	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r0.add(r3);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        goto L_0x0021;
    L_0x0049:
        r4.close();	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        goto L_0x0055;
    L_0x004d:
        r10 = move-exception;
        r2 = r4;
        goto L_0x0105;
    L_0x0051:
        r10 = move-exception;
        r2 = r4;
        goto L_0x00fc;
    L_0x0055:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00fb }
        r4 = "/system/etc/vold.fstab";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00fb }
        r4 = r3.exists();	 Catch:{ Exception -> 0x00fb }
        r7 = 0;
        if (r4 == 0) goto L_0x00a5;
    L_0x0063:
        r4 = new java.util.Scanner;	 Catch:{ Exception -> 0x00fb }
        r4.<init>(r3);	 Catch:{ Exception -> 0x00fb }
    L_0x0068:
        r3 = r4.hasNext();	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r3 == 0) goto L_0x00a2;
    L_0x006e:
        r3 = r4.nextLine();	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r8 = "dev_mount";
        r8 = r3.startsWith(r8);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r8 == 0) goto L_0x0068;
    L_0x007a:
        r3 = r3.replace(r6, r5);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r8 = " ";
        r3 = r3.split(r8);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r3 == 0) goto L_0x0068;
    L_0x0086:
        r8 = r3.length;	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r8 <= 0) goto L_0x0068;
    L_0x0089:
        r8 = 2;
        r3 = r3[r8];	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r8 = ":";
        r8 = r3.contains(r8);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        if (r8 == 0) goto L_0x009e;
    L_0x0094:
        r8 = ":";
        r8 = r3.indexOf(r8);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        r3 = r3.substring(r7, r8);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
    L_0x009e:
        r1.add(r3);	 Catch:{ Exception -> 0x0051, all -> 0x004d }
        goto L_0x0068;
    L_0x00a2:
        r4.close();	 Catch:{ Exception -> 0x0051, all -> 0x004d }
    L_0x00a5:
        r3 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x00fb }
        r3 = r3.getAbsolutePath();	 Catch:{ Exception -> 0x00fb }
        r4 = r9.d;	 Catch:{ Exception -> 0x00fb }
        r5 = new com.baidu.mapsdkplatform.comapi.util.f;	 Catch:{ Exception -> 0x00fb }
        r6 = "Auto";
        r5.<init>(r3, r7, r6, r10);	 Catch:{ Exception -> 0x00fb }
        r4.add(r5);	 Catch:{ Exception -> 0x00fb }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x00fb }
    L_0x00bd:
        r4 = r0.hasNext();	 Catch:{ Exception -> 0x00fb }
        if (r4 == 0) goto L_0x0104;
    L_0x00c3:
        r4 = r0.next();	 Catch:{ Exception -> 0x00fb }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x00fb }
        r5 = r1.contains(r4);	 Catch:{ Exception -> 0x00fb }
        if (r5 == 0) goto L_0x00bd;
    L_0x00cf:
        r5 = r4.equals(r3);	 Catch:{ Exception -> 0x00fb }
        if (r5 != 0) goto L_0x00bd;
    L_0x00d5:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x00fb }
        r5.<init>(r4);	 Catch:{ Exception -> 0x00fb }
        r6 = r5.exists();	 Catch:{ Exception -> 0x00fb }
        if (r6 == 0) goto L_0x00bd;
    L_0x00e0:
        r6 = r5.isDirectory();	 Catch:{ Exception -> 0x00fb }
        if (r6 == 0) goto L_0x00bd;
    L_0x00e6:
        r5 = r5.canWrite();	 Catch:{ Exception -> 0x00fb }
        if (r5 == 0) goto L_0x00bd;
    L_0x00ec:
        r5 = r9.d;	 Catch:{ Exception -> 0x00fb }
        r6 = new com.baidu.mapsdkplatform.comapi.util.f;	 Catch:{ Exception -> 0x00fb }
        r8 = "Auto";
        r6.<init>(r4, r7, r8, r10);	 Catch:{ Exception -> 0x00fb }
        r5.add(r6);	 Catch:{ Exception -> 0x00fb }
        goto L_0x00bd;
    L_0x00f9:
        r10 = move-exception;
        goto L_0x0105;
    L_0x00fb:
        r10 = move-exception;
    L_0x00fc:
        r10.printStackTrace();	 Catch:{ all -> 0x00f9 }
        if (r2 == 0) goto L_0x0104;
    L_0x0101:
        r2.close();
    L_0x0104:
        return;
    L_0x0105:
        if (r2 == 0) goto L_0x010a;
    L_0x0107:
        r2.close();
    L_0x010a:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.util.g.d(android.content.Context):void");
    }

    public void a(Context context) {
        if (!this.b) {
            this.b = true;
            try {
                if (VERSION.SDK_INT >= 14) {
                    c(context);
                } else {
                    d(context);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (this.d.size() > 0) {
                    f fVar = null;
                    int i = 0;
                    for (f fVar2 : this.d) {
                        if (new File(fVar2.b()).exists()) {
                            i++;
                            fVar = fVar2;
                        }
                    }
                    if (i == 0) {
                        this.e = b(context);
                        if (this.e == null) {
                            for (f fVar3 : this.d) {
                                if (a(context, fVar3)) {
                                    this.e = fVar3;
                                    break;
                                }
                            }
                        }
                    } else if (i != 1) {
                        this.e = b(context);
                    } else if (a(context, fVar)) {
                        this.e = fVar;
                    }
                    if (this.e == null) {
                        this.e = (f) this.d.get(0);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (this.e == null || !a(this.e.a())) {
                    this.c = false;
                    this.e = new f(context);
                    this.d.clear();
                    this.d.add(this.e);
                    return;
                }
                File file = new File(this.e.b());
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(this.e.c());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, ".nomedia");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public boolean a(Context context, f fVar) {
        String a = fVar.a();
        if (!a(a)) {
            return false;
        }
        Editor edit = context.getSharedPreferences("map_pref", 0).edit();
        edit.putString("PREFFERED_SD_CARD", a);
        return edit.commit();
    }

    public f b() {
        return this.e;
    }

    public f b(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string != null && string.length() > 0) {
            for (f fVar : this.d) {
                if (fVar.a().equals(string)) {
                    return fVar;
                }
            }
        }
        return null;
    }
}
