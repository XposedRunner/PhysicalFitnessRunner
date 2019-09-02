package com.baidu.android.bbalbs.common.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.system.ErrnoException;
import android.system.Os;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.baidu.android.bbalbs.common.a.d;
import com.tencent.stat.DeviceInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static final String a;
    private static b e;
    private final Context b;
    private int c = 0;
    private PublicKey d;

    private static class a {
        public ApplicationInfo a;
        public int b;
        public boolean c;
        public boolean d;

        private a() {
            this.b = 0;
            this.c = false;
            this.d = false;
        }

        /* synthetic */ a(c cVar) {
            this();
        }
    }

    private static class b {
        public String a;
        public String b;
        public int c;

        private b() {
            this.c = 2;
        }

        /* synthetic */ b(c cVar) {
            this();
        }

        public static b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                str = jSONObject.getString("deviceid");
                String string = jSONObject.getString("imei");
                int i = jSONObject.getInt(DeviceInfo.TAG_VERSION);
                if (!(TextUtils.isEmpty(str) || string == null)) {
                    b bVar = new b();
                    bVar.a = str;
                    bVar.b = string;
                    bVar.c = i;
                    return bVar;
                }
            } catch (JSONException e) {
                b.b(e);
            }
            return null;
        }

        public String a() {
            try {
                return new JSONObject().put("deviceid", this.a).put("imei", this.b).put(DeviceInfo.TAG_VERSION, this.c).toString();
            } catch (JSONException e) {
                b.b(e);
                return null;
            }
        }

        public String b() {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            str = new StringBuffer(str).reverse().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("|");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    static class c {
        static boolean a(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e) {
                b.b(e);
                return false;
            }
        }
    }

    static {
        String str = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{(byte) 77, (byte) 122, (byte) 65, (byte) 121, (byte) 77, (byte) 84, (byte) 73, (byte) 120, (byte) 77, (byte) 68, (byte) 73, (byte) 61}));
        String str2 = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{(byte) 90, (byte) 71, (byte) 108, (byte) 106, (byte) 100, (byte) 87, (byte) 82, (byte) 112, (byte) 89, (byte) 87, (byte) 73, (byte) 61}));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        a = stringBuilder.toString();
    }

    private b(Context context) {
        this.b = context.getApplicationContext();
        a();
    }

    public static String a(Context context) {
        return c(context).b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0035 A:{SYNTHETIC, Splitter:B:25:0x0035} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0041 A:{SYNTHETIC, Splitter:B:33:0x0041} */
    private static java.lang.String a(java.io.File r5) {
        /*
        r0 = 0;
        r1 = new java.io.FileReader;	 Catch:{ Exception -> 0x002e, all -> 0x002b }
        r1.<init>(r5);	 Catch:{ Exception -> 0x002e, all -> 0x002b }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5 = new char[r5];	 Catch:{ Exception -> 0x0029 }
        r2 = new java.io.CharArrayWriter;	 Catch:{ Exception -> 0x0029 }
        r2.<init>();	 Catch:{ Exception -> 0x0029 }
    L_0x000f:
        r3 = r1.read(r5);	 Catch:{ Exception -> 0x0029 }
        if (r3 <= 0) goto L_0x001a;
    L_0x0015:
        r4 = 0;
        r2.write(r5, r4, r3);	 Catch:{ Exception -> 0x0029 }
        goto L_0x000f;
    L_0x001a:
        r5 = r2.toString();	 Catch:{ Exception -> 0x0029 }
        if (r1 == 0) goto L_0x0028;
    L_0x0020:
        r1.close();	 Catch:{ Exception -> 0x0024 }
        return r5;
    L_0x0024:
        r0 = move-exception;
        b(r0);
    L_0x0028:
        return r5;
    L_0x0029:
        r5 = move-exception;
        goto L_0x0030;
    L_0x002b:
        r5 = move-exception;
        r1 = r0;
        goto L_0x003f;
    L_0x002e:
        r5 = move-exception;
        r1 = r0;
    L_0x0030:
        b(r5);	 Catch:{ all -> 0x003e }
        if (r1 == 0) goto L_0x003d;
    L_0x0035:
        r1.close();	 Catch:{ Exception -> 0x0039 }
        return r0;
    L_0x0039:
        r5 = move-exception;
        b(r5);
    L_0x003d:
        return r0;
    L_0x003e:
        r5 = move-exception;
    L_0x003f:
        if (r1 == 0) goto L_0x0049;
    L_0x0041:
        r1.close();	 Catch:{ Exception -> 0x0045 }
        goto L_0x0049;
    L_0x0045:
        r0 = move-exception;
        b(r0);
    L_0x0049:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.bbalbs.common.util.b.a(java.io.File):java.lang.String");
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            StringBuilder stringBuilder;
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                str = "0";
            } else {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(str);
            stringBuilder.append(toHexString);
            str = stringBuilder.toString();
        }
        return str.toLowerCase();
    }

    private List<a> a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (!(resolveInfo.activityInfo == null || resolveInfo.activityInfo.applicationInfo == null)) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a = com.baidu.android.bbalbs.common.a.b.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a));
                                a aVar = new a();
                                aVar.b = jSONObject.getInt("priority");
                                aVar.a = resolveInfo.activityInfo.applicationInfo;
                                if (this.b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    aVar.d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] a2 = a(com.baidu.android.bbalbs.common.a.b.a(string2.getBytes()), this.d);
                                            boolean z2 = a2 != null && Arrays.equals(a2, d.a(a));
                                            if (z2) {
                                                aVar.c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(aVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new c(this));
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A:{SYNTHETIC, Splitter:B:22:0x0034} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A:{SYNTHETIC, Splitter:B:13:0x0028} */
    private void a() {
        /*
        r4 = this;
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0031, all -> 0x0022 }
        r2 = com.baidu.android.bbalbs.common.util.a.a();	 Catch:{ Exception -> 0x0031, all -> 0x0022 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0031, all -> 0x0022 }
        r0 = "X.509";
        r0 = java.security.cert.CertificateFactory.getInstance(r0);	 Catch:{ Exception -> 0x0032, all -> 0x0020 }
        r0 = r0.generateCertificate(r1);	 Catch:{ Exception -> 0x0032, all -> 0x0020 }
        r0 = r0.getPublicKey();	 Catch:{ Exception -> 0x0032, all -> 0x0020 }
        r4.d = r0;	 Catch:{ Exception -> 0x0032, all -> 0x0020 }
        if (r1 == 0) goto L_0x003c;
    L_0x001c:
        r1.close();	 Catch:{ Exception -> 0x0038 }
        return;
    L_0x0020:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0022:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x0026:
        if (r1 == 0) goto L_0x0030;
    L_0x0028:
        r1.close();	 Catch:{ Exception -> 0x002c }
        goto L_0x0030;
    L_0x002c:
        r1 = move-exception;
        b(r1);
    L_0x0030:
        throw r0;
    L_0x0031:
        r1 = r0;
    L_0x0032:
        if (r1 == 0) goto L_0x003c;
    L_0x0034:
        r1.close();	 Catch:{ Exception -> 0x0038 }
        return;
    L_0x0038:
        r0 = move-exception;
        b(r0);
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.bbalbs.common.util.b.a():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051 A:{SYNTHETIC, Splitter:B:27:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005c A:{SYNTHETIC, Splitter:B:34:0x005c} */
    @android.annotation.SuppressLint({"NewApi"})
    private boolean a(java.lang.String r7) {
        /*
        r6 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 1;
        r2 = 0;
        r3 = 24;
        if (r0 < r3) goto L_0x000a;
    L_0x0008:
        r0 = r2;
        goto L_0x000b;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = 0;
        r4 = r6.b;	 Catch:{ Exception -> 0x004b }
        r5 = "libcuid.so";
        r4 = r4.openFileOutput(r5, r0);	 Catch:{ Exception -> 0x004b }
        r7 = r7.getBytes();	 Catch:{ Exception -> 0x0046, all -> 0x0043 }
        r4.write(r7);	 Catch:{ Exception -> 0x0046, all -> 0x0043 }
        r4.flush();	 Catch:{ Exception -> 0x0046, all -> 0x0043 }
        if (r4 == 0) goto L_0x0028;
    L_0x0020:
        r4.close();	 Catch:{ Exception -> 0x0024 }
        goto L_0x0028;
    L_0x0024:
        r7 = move-exception;
        b(r7);
    L_0x0028:
        if (r0 != 0) goto L_0x0042;
    L_0x002a:
        r7 = 436; // 0x1b4 float:6.11E-43 double:2.154E-321;
        r0 = new java.io.File;
        r1 = r6.b;
        r1 = r1.getFilesDir();
        r2 = "libcuid.so";
        r0.<init>(r1, r2);
        r0 = r0.getAbsolutePath();
        r7 = com.baidu.android.bbalbs.common.util.b.c.a(r0, r7);
        return r7;
    L_0x0042:
        return r1;
    L_0x0043:
        r7 = move-exception;
        r3 = r4;
        goto L_0x005a;
    L_0x0046:
        r7 = move-exception;
        r3 = r4;
        goto L_0x004c;
    L_0x0049:
        r7 = move-exception;
        goto L_0x005a;
    L_0x004b:
        r7 = move-exception;
    L_0x004c:
        b(r7);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x0059;
    L_0x0051:
        r3.close();	 Catch:{ Exception -> 0x0055 }
        return r2;
    L_0x0055:
        r7 = move-exception;
        b(r7);
    L_0x0059:
        return r2;
    L_0x005a:
        if (r3 == 0) goto L_0x0064;
    L_0x005c:
        r3.close();	 Catch:{ Exception -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r0 = move-exception;
        b(r0);
    L_0x0064:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.bbalbs.common.util.b.a(java.lang.String):boolean");
    }

    private boolean a(String str, String str2) {
        try {
            return System.putString(this.b.getContentResolver(), str, str2);
        } catch (Exception e) {
            b(e);
            return false;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0030, code skipped:
            return false;
     */
    private boolean a(java.lang.String[] r6, java.lang.String[] r7) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0030;
    L_0x0003:
        if (r7 == 0) goto L_0x0030;
    L_0x0005:
        r1 = r6.length;
        r2 = r7.length;
        if (r1 == r2) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = new java.util.HashSet;
        r1.<init>();
        r2 = r6.length;
        r3 = r0;
    L_0x0011:
        if (r3 >= r2) goto L_0x001b;
    L_0x0013:
        r4 = r6[r3];
        r1.add(r4);
        r3 = r3 + 1;
        goto L_0x0011;
    L_0x001b:
        r6 = new java.util.HashSet;
        r6.<init>();
        r2 = r7.length;
    L_0x0021:
        if (r0 >= r2) goto L_0x002b;
    L_0x0023:
        r3 = r7[r0];
        r6.add(r3);
        r0 = r0 + 1;
        goto L_0x0021;
    L_0x002b:
        r6 = r1.equals(r6);
        return r6;
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.bbalbs.common.util.b.a(java.lang.String[], java.lang.String[]):boolean");
    }

    private static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = a(d.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private b b() {
        boolean z;
        String str;
        String str2;
        List a = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
        int i = 0;
        int i2;
        if (a == null || a.size() == 0) {
            for (i2 = 0; i2 < 3; i2++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            a aVar = (a) a.get(0);
            z = aVar.c;
            if (!aVar.c) {
                for (i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        File file = new File(this.b.getFilesDir(), "libcuid.so");
        String str3 = null;
        b a2 = file.exists() ? b.a(f(a(file))) : null;
        if (a2 == null) {
            this.c |= 16;
            List<a> a3 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a3 != null) {
                str = "files";
                File filesDir = this.b.getFilesDir();
                if (!str.equals(filesDir.getName())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("fetal error:: app files dir name is unexpectedly :: ");
                    stringBuilder.append(filesDir.getAbsolutePath());
                    Log.e("DeviceId", stringBuilder.toString());
                    str = filesDir.getName();
                }
                for (a aVar2 : a3) {
                    if (!aVar2.d) {
                        File file2 = new File(new File(aVar2.a.dataDir, str), "libcuid.so");
                        if (file2.exists()) {
                            a2 = b.a(f(a(file2)));
                            if (a2 != null) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        if (a2 == null) {
            a2 = b.a(f(b("com.baidu.deviceid.v2")));
        }
        boolean c = c("android.permission.READ_EXTERNAL_STORAGE");
        if (a2 == null && c) {
            this.c |= 2;
            a2 = e();
        }
        if (a2 == null) {
            this.c |= 8;
            a2 = d();
        }
        if (a2 == null && c) {
            this.c |= 1;
            String h = h("");
            i = 1;
            str2 = h;
            a2 = d(h);
        } else {
            str2 = null;
        }
        if (a2 == null) {
            this.c |= 4;
            if (i == 0) {
                str2 = h("");
            }
            a2 = new b();
            String b = b(this.b);
            if (VERSION.SDK_INT < 23) {
                str = UUID.randomUUID().toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(b);
                stringBuilder2.append(str);
                b = stringBuilder2.toString();
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("com.baidu");
                stringBuilder3.append(b);
                b = stringBuilder3.toString();
            }
            a2.a = com.baidu.android.bbalbs.common.a.c.a(b.getBytes(), true);
            a2.b = str2;
        }
        File file3 = new File(this.b.getFilesDir(), "libcuid.so");
        if (!((this.c & 16) == 0 && file3.exists())) {
            if (TextUtils.isEmpty(null)) {
                str3 = e(a2.a());
            }
            a(str3);
        }
        c = c();
        if (c && ((this.c & 2) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = e(a2.a());
            }
            a("com.baidu.deviceid.v2", str3);
        }
        if (c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (!((this.c & 8) == 0 && file4.exists())) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = e(a2.a());
                }
                g(str3);
            }
        }
        if (c && ((1 & this.c) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid")))) {
            a("com.baidu.deviceid", a2.a);
        }
        if (c && !TextUtils.isEmpty(a2.b)) {
            File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if (!((this.c & 2) == 0 && file5.exists())) {
                b(a2.b, a2.a);
            }
        }
        return a2;
    }

    public static String b(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private String b(String str) {
        try {
            return System.getString(this.b.getContentResolver(), str);
        } catch (Exception e) {
            b(e);
            return null;
        }
    }

    private static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(str2);
            File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
            File file2 = new File(file, ".cuid");
            try {
                if (file.exists() && !file.isDirectory()) {
                    File file3;
                    Random random = new Random();
                    File parentFile = file.getParentFile();
                    String name = file.getName();
                    do {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(name);
                        stringBuilder2.append(random.nextInt());
                        stringBuilder2.append(".tmp");
                        file3 = new File(parentFile, stringBuilder2.toString());
                    } while (file3.exists());
                    file.renameTo(file3);
                    file3.delete();
                }
                file.mkdirs();
                FileWriter fileWriter = new FileWriter(file2, false);
                fileWriter.write(com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(a, a, stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException | Exception unused) {
            }
        }
    }

    private static void b(Throwable th) {
    }

    private static b c(Context context) {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    SystemClock.uptimeMillis();
                    e = new b(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return e;
    }

    private boolean c() {
        return c("android.permission.WRITE_SETTINGS");
    }

    private boolean c(String str) {
        return this.b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private b d() {
        CharSequence b = b("com.baidu.deviceid");
        String b2 = b("bd_setting_i");
        if (TextUtils.isEmpty(b2)) {
            b2 = h("");
            TextUtils.isEmpty(b2);
        }
        if (TextUtils.isEmpty(b)) {
            String b3 = b(this.b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("com.baidu");
            stringBuilder.append(b2);
            stringBuilder.append(b3);
            b = b(com.baidu.android.bbalbs.common.a.c.a(stringBuilder.toString().getBytes(), true));
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        b bVar = new b();
        bVar.a = b;
        bVar.b = b2;
        return bVar;
    }

    private b d(String str) {
        int i = VERSION.SDK_INT < 23 ? 1 : 0;
        if (i != 0 && TextUtils.isEmpty(str)) {
            return null;
        }
        int i2;
        CharSequence charSequence = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (file.exists()) {
            i2 = 0;
        } else {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            i2 = 1;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append("\r\n");
            }
            bufferedReader.close();
            String[] split = new String(com.baidu.android.bbalbs.common.a.a.b(a, a, com.baidu.android.bbalbs.common.a.b.a(stringBuilder.toString().getBytes()))).split(HttpUtils.EQUAL_SIGN);
            if (split != null && split.length == 2) {
                String str2;
                if (i != 0 && str.equals(split[0])) {
                    str2 = split[1];
                } else if (i == 0) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    str2 = split[1];
                }
                charSequence = str2;
            }
            if (i2 == 0) {
                b(str, charSequence);
            }
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        b bVar = new b();
        bVar.a = charSequence;
        bVar.b = str;
        return bVar;
    }

    private b e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String a = a(file);
            if (!TextUtils.isEmpty(a)) {
                try {
                    return b.a(new String(com.baidu.android.bbalbs.common.a.a.b(a, a, com.baidu.android.bbalbs.common.a.b.a(a.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(a, a, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            b(e);
            return "";
        }
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.a.a.b(a, a, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
        } catch (Exception e) {
            b(e);
            return "";
        }
    }

    private static void g(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file2 = new File(file, ".cuid2");
        try {
            if (file.exists() && !file.isDirectory()) {
                File file3;
                Random random = new Random();
                File parentFile = file.getParentFile();
                String name = file.getName();
                do {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(name);
                    stringBuilder.append(random.nextInt());
                    stringBuilder.append(".tmp");
                    file3 = new File(parentFile, stringBuilder.toString());
                } while (file3.exists());
                file.renameTo(file3);
                file3.delete();
            }
            file.mkdirs();
            FileWriter fileWriter = new FileWriter(file2, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    private String h(String str) {
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            Log.e("DeviceId", "Read IMEI failed", e);
        }
        str2 = i(str2);
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    private static String i(String str) {
        return (str == null || !str.contains(":")) ? str : "";
    }
}
