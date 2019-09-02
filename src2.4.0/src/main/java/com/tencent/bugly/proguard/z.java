package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
public class z {
    private static Map<String, String> a;
    private static boolean b;

    public static Context a(Context context) {
        if (context == null) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public static SharedPreferences a(String str, Context context) {
        return context != null ? context.getSharedPreferences(str, 0) : null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.canRead()) {
                    return b(file);
                }
            }
            return null;
        } catch (NullPointerException e) {
            x.a(e);
            return null;
        }
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static <T> T a(byte[] bArr, Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            Object createFromParcel = creator.createFromParcel(obtain);
            if (obtain != null) {
                obtain.recycle();
            }
            return createFromParcel;
        } catch (Throwable th) {
            if (obtain != null) {
                obtain.recycle();
            }
            throw th;
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0104 A:{SYNTHETIC, Splitter:B:61:0x0104} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A:{Catch:{ all -> 0x00b1 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dd A:{SYNTHETIC, Splitter:B:47:0x00dd} */
    public static java.lang.String a(android.content.Context r7, int r8, java.lang.String r9) {
        /*
        r0 = "android.permission.READ_LOGS";
        r7 = com.tencent.bugly.crashreport.common.info.AppInfo.a(r7, r0);
        r0 = 0;
        r1 = 0;
        if (r7 != 0) goto L_0x0012;
    L_0x000a:
        r7 = "no read_log permission!";
        r8 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.d(r7, r8);
        return r0;
    L_0x0012:
        r7 = 3;
        r2 = 2;
        r3 = 1;
        r4 = 4;
        if (r9 != 0) goto L_0x002b;
    L_0x0018:
        r9 = new java.lang.String[r4];
        r4 = "logcat";
        r9[r1] = r4;
        r4 = "-d";
        r9[r3] = r4;
        r3 = "-v";
        r9[r2] = r3;
        r2 = "threadtime";
        r9[r7] = r2;
        goto L_0x0046;
    L_0x002b:
        r5 = 6;
        r5 = new java.lang.String[r5];
        r6 = "logcat";
        r5[r1] = r6;
        r6 = "-d";
        r5[r3] = r6;
        r3 = "-v";
        r5[r2] = r3;
        r2 = "threadtime";
        r5[r7] = r2;
        r7 = "-s";
        r5[r4] = r7;
        r7 = 5;
        r5[r7] = r9;
        r9 = r5;
    L_0x0046:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x00b3 }
        r9 = r2.exec(r9);	 Catch:{ Throwable -> 0x00b3 }
        r0 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r3 = r9.getInputStream();	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
    L_0x0061:
        r2 = r0.readLine();	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        if (r2 == 0) goto L_0x0080;
    L_0x0067:
        r7.append(r2);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2 = "\n";
        r7.append(r2);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        if (r8 <= 0) goto L_0x0061;
    L_0x0071:
        r2 = r7.length();	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        if (r2 <= r8) goto L_0x0061;
    L_0x0077:
        r2 = r7.length();	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        r2 = r2 - r8;
        r7.delete(r1, r2);	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        goto L_0x0061;
    L_0x0080:
        r8 = r7.toString();	 Catch:{ Throwable -> 0x00ae, all -> 0x00ab }
        if (r9 == 0) goto L_0x00aa;
    L_0x0086:
        r7 = r9.getOutputStream();	 Catch:{ IOException -> 0x008e }
        r7.close();	 Catch:{ IOException -> 0x008e }
        goto L_0x0092;
    L_0x008e:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0092:
        r7 = r9.getInputStream();	 Catch:{ IOException -> 0x009a }
        r7.close();	 Catch:{ IOException -> 0x009a }
        goto L_0x009e;
    L_0x009a:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x009e:
        r7 = r9.getErrorStream();	 Catch:{ IOException -> 0x00a6 }
        r7.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00aa;
    L_0x00a6:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x00aa:
        return r8;
    L_0x00ab:
        r7 = move-exception;
        r0 = r9;
        goto L_0x0102;
    L_0x00ae:
        r8 = move-exception;
        r0 = r9;
        goto L_0x00b4;
    L_0x00b1:
        r7 = move-exception;
        goto L_0x0102;
    L_0x00b3:
        r8 = move-exception;
    L_0x00b4:
        r9 = com.tencent.bugly.proguard.x.a(r8);	 Catch:{ all -> 0x00b1 }
        if (r9 != 0) goto L_0x00bd;
    L_0x00ba:
        r8.printStackTrace();	 Catch:{ all -> 0x00b1 }
    L_0x00bd:
        r9 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
        r1 = "\n[error:";
        r9.<init>(r1);	 Catch:{ all -> 0x00b1 }
        r8 = r8.toString();	 Catch:{ all -> 0x00b1 }
        r9.append(r8);	 Catch:{ all -> 0x00b1 }
        r8 = "]";
        r9.append(r8);	 Catch:{ all -> 0x00b1 }
        r8 = r9.toString();	 Catch:{ all -> 0x00b1 }
        r7.append(r8);	 Catch:{ all -> 0x00b1 }
        r7 = r7.toString();	 Catch:{ all -> 0x00b1 }
        if (r0 == 0) goto L_0x0101;
    L_0x00dd:
        r8 = r0.getOutputStream();	 Catch:{ IOException -> 0x00e5 }
        r8.close();	 Catch:{ IOException -> 0x00e5 }
        goto L_0x00e9;
    L_0x00e5:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x00e9:
        r8 = r0.getInputStream();	 Catch:{ IOException -> 0x00f1 }
        r8.close();	 Catch:{ IOException -> 0x00f1 }
        goto L_0x00f5;
    L_0x00f1:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x00f5:
        r8 = r0.getErrorStream();	 Catch:{ IOException -> 0x00fd }
        r8.close();	 Catch:{ IOException -> 0x00fd }
        goto L_0x0101;
    L_0x00fd:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0101:
        return r7;
    L_0x0102:
        if (r0 == 0) goto L_0x0128;
    L_0x0104:
        r8 = r0.getOutputStream();	 Catch:{ IOException -> 0x010c }
        r8.close();	 Catch:{ IOException -> 0x010c }
        goto L_0x0110;
    L_0x010c:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0110:
        r8 = r0.getInputStream();	 Catch:{ IOException -> 0x0118 }
        r8.close();	 Catch:{ IOException -> 0x0118 }
        goto L_0x011c;
    L_0x0118:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x011c:
        r8 = r0.getErrorStream();	 Catch:{ IOException -> 0x0124 }
        r8.close();	 Catch:{ IOException -> 0x0124 }
        goto L_0x0128;
    L_0x0124:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0128:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(android.content.Context, int, java.lang.String):java.lang.String");
    }

    public static String a(Context context, String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        if (a == null) {
            a = new HashMap();
            ArrayList<String> a = a(context, new String[]{"/system/bin/sh", "-c", "getprop"});
            if (a != null && a.size() > 0) {
                x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String matcher : a) {
                    Matcher matcher2 = compile.matcher(matcher);
                    if (matcher2.find()) {
                        a.put(matcher2.group(1), matcher2.group(2));
                    }
                }
                x.b(z.class, "System properties number: %d.", Integer.valueOf(a.size()));
            }
        }
        return a.containsKey(str) ? (String) a.get(str) : "fail";
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x005a A:{SYNTHETIC, Splitter:B:33:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A:{SYNTHETIC, Splitter:B:25:0x004d} */
    public static java.lang.String a(java.io.File r5) {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0063;
    L_0x0003:
        r1 = r5.exists();
        if (r1 == 0) goto L_0x0063;
    L_0x0009:
        r1 = r5.canRead();
        if (r1 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0063;
    L_0x0010:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r1.<init>();	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r4 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r5 = "utf-8";
        r3.<init>(r4, r5);	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0046, all -> 0x0044 }
    L_0x0026:
        r5 = r2.readLine();	 Catch:{ Throwable -> 0x0042 }
        if (r5 == 0) goto L_0x0035;
    L_0x002c:
        r1.append(r5);	 Catch:{ Throwable -> 0x0042 }
        r5 = "\n";
        r1.append(r5);	 Catch:{ Throwable -> 0x0042 }
        goto L_0x0026;
    L_0x0035:
        r5 = r1.toString();	 Catch:{ Throwable -> 0x0042 }
        r2.close();	 Catch:{ Exception -> 0x003d }
        goto L_0x0041;
    L_0x003d:
        r0 = move-exception;
        com.tencent.bugly.proguard.x.a(r0);
    L_0x0041:
        return r5;
    L_0x0042:
        r5 = move-exception;
        goto L_0x0048;
    L_0x0044:
        r5 = move-exception;
        goto L_0x0058;
    L_0x0046:
        r5 = move-exception;
        r2 = r0;
    L_0x0048:
        com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x0056 }
        if (r2 == 0) goto L_0x0055;
    L_0x004d:
        r2.close();	 Catch:{ Exception -> 0x0051 }
        goto L_0x0055;
    L_0x0051:
        r5 = move-exception;
        com.tencent.bugly.proguard.x.a(r5);
    L_0x0055:
        return r0;
    L_0x0056:
        r5 = move-exception;
        r0 = r2;
    L_0x0058:
        if (r0 == 0) goto L_0x0062;
    L_0x005a:
        r0.close();	 Catch:{ Exception -> 0x005e }
        goto L_0x0062;
    L_0x005e:
        r0 = move-exception;
        com.tencent.bugly.proguard.x.a(r0);
    L_0x0062:
        throw r5;
    L_0x0063:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(java.io.File):java.lang.String");
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (!x.a(th2)) {
                th2.printStackTrace();
            }
            return "fail";
        }
    }

    public static String a(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            x.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c A:{Catch:{ all -> 0x0094 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0081 A:{SYNTHETIC, Splitter:B:39:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b A:{SYNTHETIC, Splitter:B:44:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0098 A:{SYNTHETIC, Splitter:B:52:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2 A:{SYNTHETIC, Splitter:B:57:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0098 A:{SYNTHETIC, Splitter:B:52:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a2 A:{SYNTHETIC, Splitter:B:57:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c A:{Catch:{ all -> 0x0094 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0081 A:{SYNTHETIC, Splitter:B:39:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b A:{SYNTHETIC, Splitter:B:44:0x008b} */
    public static java.util.ArrayList<java.lang.String> a(android.content.Context r4, java.lang.String[] r5) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r4 = com.tencent.bugly.crashreport.common.info.a.a(r4);
        r4 = r4.J();
        if (r4 == 0) goto L_0x001f;
    L_0x000f:
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = new java.lang.String;
        r0 = "unknown(low memory)";
        r5.<init>(r0);
        r4.add(r5);
        return r4;
    L_0x001f:
        r4 = 0;
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r5 = r1.exec(r5);	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r3 = r5.getInputStream();	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0073, all -> 0x0070 }
    L_0x0036:
        r2 = r1.readLine();	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
        if (r2 == 0) goto L_0x0040;
    L_0x003c:
        r0.add(r2);	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
        goto L_0x0036;
    L_0x0040:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
        r3 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
        r5 = r5.getErrorStream();	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
        r3.<init>(r5);	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x006d, all -> 0x006b }
    L_0x004e:
        r5 = r2.readLine();	 Catch:{ Throwable -> 0x0069 }
        if (r5 == 0) goto L_0x0058;
    L_0x0054:
        r0.add(r5);	 Catch:{ Throwable -> 0x0069 }
        goto L_0x004e;
    L_0x0058:
        r1.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0060;
    L_0x005c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0060:
        r2.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0068;
    L_0x0064:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0068:
        return r0;
    L_0x0069:
        r5 = move-exception;
        goto L_0x0076;
    L_0x006b:
        r5 = move-exception;
        goto L_0x0096;
    L_0x006d:
        r5 = move-exception;
        r2 = r4;
        goto L_0x0076;
    L_0x0070:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0096;
    L_0x0073:
        r5 = move-exception;
        r1 = r4;
        r2 = r1;
    L_0x0076:
        r0 = com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x0094 }
        if (r0 != 0) goto L_0x007f;
    L_0x007c:
        r5.printStackTrace();	 Catch:{ all -> 0x0094 }
    L_0x007f:
        if (r1 == 0) goto L_0x0089;
    L_0x0081:
        r1.close();	 Catch:{ IOException -> 0x0085 }
        goto L_0x0089;
    L_0x0085:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0089:
        if (r2 == 0) goto L_0x0093;
    L_0x008b:
        r2.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x0093;
    L_0x008f:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0093:
        return r4;
    L_0x0094:
        r5 = move-exception;
        r4 = r2;
    L_0x0096:
        if (r1 == 0) goto L_0x00a0;
    L_0x0098:
        r1.close();	 Catch:{ IOException -> 0x009c }
        goto L_0x00a0;
    L_0x009c:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x00a0:
        if (r4 == 0) goto L_0x00aa;
    L_0x00a2:
        r4.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00aa;
    L_0x00a6:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x00aa:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(android.content.Context, java.lang.String[]):java.util.ArrayList");
    }

    public static Map<String, String> a(int i, boolean z) {
        HashMap hashMap = new HashMap(12);
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread.currentThread().getId();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : allStackTraces.entrySet()) {
            int i2 = 0;
            stringBuilder.setLength(0);
            if (!(entry.getValue() == null || ((StackTraceElement[]) entry.getValue()).length == 0)) {
                StringBuilder stringBuilder2;
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                int length = stackTraceElementArr.length;
                while (i2 < length) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (i > 0 && stringBuilder.length() >= i) {
                        stringBuilder2 = new StringBuilder("\n[Stack over limit size :");
                        stringBuilder2.append(i);
                        stringBuilder2.append(" , has been cutted !]");
                        stringBuilder.append(stringBuilder2.toString());
                        break;
                    }
                    stringBuilder.append(stackTraceElement.toString());
                    stringBuilder.append("\n");
                    i2++;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(((Thread) entry.getKey()).getName());
                stringBuilder2.append("(");
                stringBuilder2.append(((Thread) entry.getKey()).getId());
                stringBuilder2.append(")");
                hashMap.put(stringBuilder2.toString(), stringBuilder.toString());
            }
        }
        return hashMap;
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        Map<String, PlugInBean> map = null;
        if (readBundle == null) {
            return null;
        }
        int i;
        StringBuilder stringBuilder;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        int i2 = 0;
        for (i = 0; i < intValue; i++) {
            stringBuilder = new StringBuilder("pluginKey");
            stringBuilder.append(i);
            arrayList.add(readBundle.getString(stringBuilder.toString()));
        }
        for (i = 0; i < intValue; i++) {
            stringBuilder = new StringBuilder("pluginVal");
            stringBuilder.append(i);
            stringBuilder.append("plugInId");
            String string = readBundle.getString(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("pluginVal");
            stringBuilder2.append(i);
            stringBuilder2.append("plugInUUID");
            String string2 = readBundle.getString(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder("pluginVal");
            stringBuilder3.append(i);
            stringBuilder3.append("plugInVersion");
            arrayList2.add(new PlugInBean(string, readBundle.getString(stringBuilder3.toString()), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            map = new HashMap(arrayList.size());
            while (i2 < arrayList.size()) {
                map.put(arrayList.get(i2), PlugInBean.class.cast(arrayList2.get(i2)));
                i2++;
            }
        } else {
            x.e("map plugin parcel error!", new Object[0]);
        }
        return map;
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        size = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder("pluginKey");
            stringBuilder.append(i);
            bundle.putString(stringBuilder.toString(), (String) arrayList.get(i));
        }
        while (size < arrayList.size()) {
            StringBuilder stringBuilder2 = new StringBuilder("pluginVal");
            stringBuilder2.append(size);
            stringBuilder2.append("plugInId");
            bundle.putString(stringBuilder2.toString(), ((PlugInBean) arrayList2.get(size)).a);
            stringBuilder2 = new StringBuilder("pluginVal");
            stringBuilder2.append(size);
            stringBuilder2.append("plugInUUID");
            bundle.putString(stringBuilder2.toString(), ((PlugInBean) arrayList2.get(size)).c);
            stringBuilder2 = new StringBuilder("pluginVal");
            stringBuilder2.append(size);
            stringBuilder2.append("plugInVersion");
            bundle.putString(stringBuilder2.toString(), ((PlugInBean) arrayList2.get(size)).b);
            size++;
        }
        parcel.writeBundle(bundle);
    }

    public static void a(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, obj);
        } catch (Exception unused) {
        }
    }

    public static boolean a(Context context, String str, long j) {
        x.c("[Util] try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir());
            stringBuilder.append(File.separator);
            stringBuilder.append(r1);
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                x.c("[Util] lock file(%s) is expired, unlock it", r1);
                b(context, str);
            }
            if (file.createNewFile()) {
                x.c("[Util] successfully locked file:%s (pid=%d | tid=%d)", r1, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            x.c("[Util] Failed to locked file:%s (pid=%d | tid=%d)", r1, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c5 A:{Catch:{ all -> 0x00e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ca A:{SYNTHETIC, Splitter:B:64:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4 A:{SYNTHETIC, Splitter:B:69:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8 A:{SYNTHETIC, Splitter:B:78:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f2 A:{SYNTHETIC, Splitter:B:83:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c5 A:{Catch:{ all -> 0x00e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ca A:{SYNTHETIC, Splitter:B:64:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4 A:{SYNTHETIC, Splitter:B:69:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8 A:{SYNTHETIC, Splitter:B:78:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f2 A:{SYNTHETIC, Splitter:B:83:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e8 A:{SYNTHETIC, Splitter:B:78:0x00e8} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f2 A:{SYNTHETIC, Splitter:B:83:0x00f2} */
    public static boolean a(java.io.File r5, java.io.File r6, int r7) {
        /*
        r7 = "rqdp{  ZF start}";
        r0 = 0;
        r1 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.c(r7, r1);
        if (r5 == 0) goto L_0x010b;
    L_0x000a:
        if (r6 == 0) goto L_0x010b;
    L_0x000c:
        r7 = r5.equals(r6);
        if (r7 == 0) goto L_0x0014;
    L_0x0012:
        goto L_0x010b;
    L_0x0014:
        r7 = r5.exists();
        if (r7 == 0) goto L_0x0103;
    L_0x001a:
        r7 = r5.canRead();
        if (r7 != 0) goto L_0x0022;
    L_0x0020:
        goto L_0x0103;
    L_0x0022:
        r7 = r6.getParentFile();	 Catch:{ Throwable -> 0x0043 }
        if (r7 == 0) goto L_0x0039;
    L_0x0028:
        r7 = r6.getParentFile();	 Catch:{ Throwable -> 0x0043 }
        r7 = r7.exists();	 Catch:{ Throwable -> 0x0043 }
        if (r7 != 0) goto L_0x0039;
    L_0x0032:
        r7 = r6.getParentFile();	 Catch:{ Throwable -> 0x0043 }
        r7.mkdirs();	 Catch:{ Throwable -> 0x0043 }
    L_0x0039:
        r7 = r6.exists();	 Catch:{ Throwable -> 0x0043 }
        if (r7 != 0) goto L_0x004d;
    L_0x003f:
        r6.createNewFile();	 Catch:{ Throwable -> 0x0043 }
        goto L_0x004d;
    L_0x0043:
        r7 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r7);
        if (r1 != 0) goto L_0x004d;
    L_0x004a:
        r7.printStackTrace();
    L_0x004d:
        r7 = r6.exists();
        if (r7 == 0) goto L_0x0102;
    L_0x0053:
        r7 = r6.canRead();
        if (r7 != 0) goto L_0x005b;
    L_0x0059:
        goto L_0x0102;
    L_0x005b:
        r7 = 0;
        r1 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x00bd, all -> 0x00b9 }
        r1.<init>(r5);	 Catch:{ Throwable -> 0x00bd, all -> 0x00b9 }
        r2 = new java.util.zip.ZipOutputStream;	 Catch:{ Throwable -> 0x00b5, all -> 0x00b2 }
        r3 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x00b5, all -> 0x00b2 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x00b5, all -> 0x00b2 }
        r4.<init>(r6);	 Catch:{ Throwable -> 0x00b5, all -> 0x00b2 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00b5, all -> 0x00b2 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00b5, all -> 0x00b2 }
        r6 = 8;
        r2.setMethod(r6);	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r6 = new java.util.zip.ZipEntry;	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r5 = r5.getName();	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r2.putNextEntry(r6);	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r5 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
    L_0x0085:
        r6 = r1.read(r5);	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        if (r6 <= 0) goto L_0x008f;
    L_0x008b:
        r2.write(r5, r0, r6);	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        goto L_0x0085;
    L_0x008f:
        r2.flush();	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r2.closeEntry();	 Catch:{ Throwable -> 0x00b0, all -> 0x00ae }
        r1.close();	 Catch:{ IOException -> 0x0099 }
        goto L_0x009d;
    L_0x0099:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x009d:
        r2.close();	 Catch:{ IOException -> 0x00a1 }
        goto L_0x00a5;
    L_0x00a1:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00a5:
        r5 = "rqdp{  ZF end}";
        r6 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.c(r5, r6);
        r5 = 1;
        return r5;
    L_0x00ae:
        r5 = move-exception;
        goto L_0x00e6;
    L_0x00b0:
        r5 = move-exception;
        goto L_0x00b7;
    L_0x00b2:
        r5 = move-exception;
        r2 = r7;
        goto L_0x00e6;
    L_0x00b5:
        r5 = move-exception;
        r2 = r7;
    L_0x00b7:
        r7 = r1;
        goto L_0x00bf;
    L_0x00b9:
        r5 = move-exception;
        r1 = r7;
        r2 = r1;
        goto L_0x00e6;
    L_0x00bd:
        r5 = move-exception;
        r2 = r7;
    L_0x00bf:
        r6 = com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x00e4 }
        if (r6 != 0) goto L_0x00c8;
    L_0x00c5:
        r5.printStackTrace();	 Catch:{ all -> 0x00e4 }
    L_0x00c8:
        if (r7 == 0) goto L_0x00d2;
    L_0x00ca:
        r7.close();	 Catch:{ IOException -> 0x00ce }
        goto L_0x00d2;
    L_0x00ce:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00d2:
        if (r2 == 0) goto L_0x00dc;
    L_0x00d4:
        r2.close();	 Catch:{ IOException -> 0x00d8 }
        goto L_0x00dc;
    L_0x00d8:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00dc:
        r5 = "rqdp{  ZF end}";
        r6 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.c(r5, r6);
        return r0;
    L_0x00e4:
        r5 = move-exception;
        r1 = r7;
    L_0x00e6:
        if (r1 == 0) goto L_0x00f0;
    L_0x00e8:
        r1.close();	 Catch:{ IOException -> 0x00ec }
        goto L_0x00f0;
    L_0x00ec:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00f0:
        if (r2 == 0) goto L_0x00fa;
    L_0x00f2:
        r2.close();	 Catch:{ IOException -> 0x00f6 }
        goto L_0x00fa;
    L_0x00f6:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00fa:
        r6 = "rqdp{  ZF end}";
        r7 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.c(r6, r7);
        throw r5;
    L_0x0102:
        return r0;
    L_0x0103:
        r5 = "rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}";
        r6 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.d(r5, r6);
        return r0;
    L_0x010b:
        r5 = "rqdp{  err ZF 1R!}";
        r6 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.d(r5, r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(java.io.File, java.io.File, int):boolean");
    }

    public static boolean a(Runnable runnable) {
        if (runnable != null) {
            w a = w.a();
            if (a != null) {
                return a.a(runnable);
            }
            String[] split = runnable.getClass().getName().split("\\.");
            if (a(runnable, split[split.length - 1]) != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A:{SYNTHETIC, Splitter:B:19:0x0035} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055 A:{SYNTHETIC, Splitter:B:26:0x0055} */
    public static synchronized byte[] a(int r6) {
        /*
        r6 = com.tencent.bugly.proguard.z.class;
        monitor-enter(r6);
        r0 = 16;
        r1 = 0;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r2 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r5 = "/dev/urandom";
        r4.<init>(r5);	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0026, all -> 0x0023 }
        r2.readFully(r0);	 Catch:{ Exception -> 0x0021 }
        r2.close();	 Catch:{ Exception -> 0x005b }
        monitor-exit(r6);
        return r0;
    L_0x0021:
        r0 = move-exception;
        goto L_0x0028;
    L_0x0023:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0053;
    L_0x0026:
        r0 = move-exception;
        r2 = r1;
    L_0x0028:
        r3 = "Failed to read from /dev/urandom : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0052 }
        r5 = 0;
        r4[r5] = r0;	 Catch:{ all -> 0x0052 }
        com.tencent.bugly.proguard.x.e(r3, r4);	 Catch:{ all -> 0x0052 }
        if (r2 == 0) goto L_0x0038;
    L_0x0035:
        r2.close();	 Catch:{ Exception -> 0x005b }
    L_0x0038:
        r0 = "AES";
        r0 = javax.crypto.KeyGenerator.getInstance(r0);	 Catch:{ Exception -> 0x005b }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r3 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x005b }
        r3.<init>();	 Catch:{ Exception -> 0x005b }
        r0.init(r2, r3);	 Catch:{ Exception -> 0x005b }
        r0 = r0.generateKey();	 Catch:{ Exception -> 0x005b }
        r0 = r0.getEncoded();	 Catch:{ Exception -> 0x005b }
        monitor-exit(r6);
        return r0;
    L_0x0052:
        r0 = move-exception;
    L_0x0053:
        if (r2 == 0) goto L_0x005d;
    L_0x0055:
        r2.close();	 Catch:{ Exception -> 0x005b }
        goto L_0x005d;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0069;
    L_0x005b:
        r0 = move-exception;
        goto L_0x005e;
    L_0x005d:
        throw r0;	 Catch:{ Exception -> 0x005b }
    L_0x005e:
        r2 = com.tencent.bugly.proguard.x.b(r0);	 Catch:{ all -> 0x0059 }
        if (r2 != 0) goto L_0x0067;
    L_0x0064:
        r0.printStackTrace();	 Catch:{ all -> 0x0059 }
    L_0x0067:
        monitor-exit(r6);
        return r1;
    L_0x0069:
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(int):byte[]");
    }

    @TargetApi(19)
    public static byte[] a(int i, byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            if (VERSION.SDK_INT >= 21) {
                if (!b) {
                    instance.init(i, secretKeySpec, new GCMParameterSpec(instance.getBlockSize() << 3, bArr2));
                    return instance.doFinal(bArr);
                }
            }
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            b = true;
            throw e;
        } catch (Exception e2) {
            if (!x.b(e2)) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055 A:{LOOP_START, LOOP:0: B:20:0x0055->B:22:0x005b, Catch:{ Throwable -> 0x0090 }} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0069 A:{SYNTHETIC, EDGE_INSN: B:73:0x0069->B:26:0x0069 ?: BREAK  , EDGE_INSN: B:73:0x0069->B:26:0x0069 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A:{LOOP_END, LOOP:1: B:23:0x005f->B:25:0x0065, Catch:{ Throwable -> 0x0090 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078 A:{SYNTHETIC, Splitter:B:28:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A:{Catch:{ all -> 0x00bc }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2 A:{SYNTHETIC, Splitter:B:48:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ac A:{SYNTHETIC, Splitter:B:53:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bf A:{SYNTHETIC, Splitter:B:61:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9 A:{SYNTHETIC, Splitter:B:66:0x00c9} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009d A:{Catch:{ all -> 0x00bc }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2 A:{SYNTHETIC, Splitter:B:48:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ac A:{SYNTHETIC, Splitter:B:53:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bf A:{SYNTHETIC, Splitter:B:61:0x00bf} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9 A:{SYNTHETIC, Splitter:B:66:0x00c9} */
    public static byte[] a(java.io.File r5, java.lang.String r6, java.lang.String r7) {
        /*
        r0 = "rqdp{  ZF start}";
        r1 = 0;
        r2 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r0, r2);
        r0 = 0;
        if (r5 == 0) goto L_0x002b;
    L_0x000b:
        r2 = r5.exists();	 Catch:{ Throwable -> 0x0026, all -> 0x0021 }
        if (r2 == 0) goto L_0x002b;
    L_0x0011:
        r2 = r5.canRead();	 Catch:{ Throwable -> 0x0026, all -> 0x0021 }
        if (r2 == 0) goto L_0x002b;
    L_0x0017:
        r7 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0026, all -> 0x0021 }
        r7.<init>(r5);	 Catch:{ Throwable -> 0x0026, all -> 0x0021 }
        r5 = r5.getName();	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        goto L_0x002d;
    L_0x0021:
        r5 = move-exception;
        r7 = r0;
        r3 = r7;
        goto L_0x00bd;
    L_0x0026:
        r5 = move-exception;
        r7 = r0;
        r3 = r7;
        goto L_0x0097;
    L_0x002b:
        r5 = r7;
        r7 = r0;
    L_0x002d:
        r2 = "UTF-8";
        r6 = r6.getBytes(r2);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r2.<init>(r6);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r6 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r6.<init>();	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r3 = new java.util.zip.ZipOutputStream;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r3.<init>(r6);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r4 = 8;
        r3.setMethod(r4);	 Catch:{ Throwable -> 0x0090 }
        r4 = new java.util.zip.ZipEntry;	 Catch:{ Throwable -> 0x0090 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0090 }
        r3.putNextEntry(r4);	 Catch:{ Throwable -> 0x0090 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ Throwable -> 0x0090 }
        if (r7 == 0) goto L_0x005f;
    L_0x0055:
        r4 = r7.read(r5);	 Catch:{ Throwable -> 0x0090 }
        if (r4 <= 0) goto L_0x005f;
    L_0x005b:
        r3.write(r5, r1, r4);	 Catch:{ Throwable -> 0x0090 }
        goto L_0x0055;
    L_0x005f:
        r4 = r2.read(r5);	 Catch:{ Throwable -> 0x0090 }
        if (r4 <= 0) goto L_0x0069;
    L_0x0065:
        r3.write(r5, r1, r4);	 Catch:{ Throwable -> 0x0090 }
        goto L_0x005f;
    L_0x0069:
        r3.closeEntry();	 Catch:{ Throwable -> 0x0090 }
        r3.flush();	 Catch:{ Throwable -> 0x0090 }
        r3.finish();	 Catch:{ Throwable -> 0x0090 }
        r5 = r6.toByteArray();	 Catch:{ Throwable -> 0x0090 }
        if (r7 == 0) goto L_0x0080;
    L_0x0078:
        r7.close();	 Catch:{ IOException -> 0x007c }
        goto L_0x0080;
    L_0x007c:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0080:
        r3.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x0088;
    L_0x0084:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0088:
        r6 = "rqdp{  ZF end}";
        r7 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r6, r7);
        return r5;
    L_0x0090:
        r5 = move-exception;
        goto L_0x0097;
    L_0x0092:
        r5 = move-exception;
        r3 = r0;
        goto L_0x00bd;
    L_0x0095:
        r5 = move-exception;
        r3 = r0;
    L_0x0097:
        r6 = com.tencent.bugly.proguard.x.a(r5);	 Catch:{ all -> 0x00bc }
        if (r6 != 0) goto L_0x00a0;
    L_0x009d:
        r5.printStackTrace();	 Catch:{ all -> 0x00bc }
    L_0x00a0:
        if (r7 == 0) goto L_0x00aa;
    L_0x00a2:
        r7.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00aa;
    L_0x00a6:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00aa:
        if (r3 == 0) goto L_0x00b4;
    L_0x00ac:
        r3.close();	 Catch:{ IOException -> 0x00b0 }
        goto L_0x00b4;
    L_0x00b0:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00b4:
        r5 = "rqdp{  ZF end}";
        r6 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r5, r6);
        return r0;
    L_0x00bc:
        r5 = move-exception;
    L_0x00bd:
        if (r7 == 0) goto L_0x00c7;
    L_0x00bf:
        r7.close();	 Catch:{ IOException -> 0x00c3 }
        goto L_0x00c7;
    L_0x00c3:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00c7:
        if (r3 == 0) goto L_0x00d1;
    L_0x00c9:
        r3.close();	 Catch:{ IOException -> 0x00cd }
        goto L_0x00d1;
    L_0x00cd:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00d1:
        r6 = "rqdp{  ZF end}";
        r7 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.x.c(r6, r7);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.a(java.io.File, java.lang.String, java.lang.String):byte[]");
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        String str = "[Util] Zip %d bytes data with type %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        x.c(str, objArr);
        try {
            ab a = aa.a(i);
            return a == null ? null : a.a(bArr);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(a(bArr, 2), 1, str);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        x.c("rqdp{  enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
        try {
            ag a = a.a(i);
            if (a == null) {
                return null;
            }
            a.a(str);
            return a.b(bArr);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / LogBuilder.MAX_INTERVAL) * LogBuilder.MAX_INTERVAL) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    private static BufferedReader b(File file) {
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
        } catch (Throwable th) {
            x.a(th);
            return null;
        }
    }

    public static String b(String str, String str2) {
        return (a.b() == null || a.b().E == null) ? "" : a.b().E.getString(str, str2);
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            return a(instance.digest());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        Map<String, String> map = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList stringArrayList2 = readBundle.getStringArrayList("values");
        int i = 0;
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            x.e("map parcel error!", new Object[0]);
        } else {
            map = new HashMap(stringArrayList.size());
            while (i < stringArrayList.size()) {
                map.put(stringArrayList.get(i), stringArrayList2.get(i));
                i++;
            }
        }
        return map;
    }

    public static void b(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Entry entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static void b(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }

    public static boolean b(Context context, String str) {
        x.c("[Util] try to unlock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir());
            stringBuilder.append(File.separator);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            x.c("[Util] successfully unlocked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            x.a(th);
            return false;
        }
    }

    public static byte[] b(int i, byte[] bArr, byte[] bArr2) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePublic);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            if (!x.b(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        String str = "[Util] Unzip %d bytes data with type %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i == 2 ? "Gzip" : "zip";
        x.c(str, objArr);
        try {
            ab a = aa.a(i);
            return a == null ? null : a.b(bArr);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, String str) {
        try {
            return b(b(bArr, 1, str), 2);
        } catch (Exception e) {
            if (!x.a(e)) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        try {
            ag a = a.a(i);
            if (a == null) {
                return null;
            }
            a.a(str);
            return a.a(bArr);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            x.d("encrytype %d %s", Integer.valueOf(i), str);
            return null;
        }
    }

    public static long c(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean c(String str) {
        boolean z = str == null || str.trim().length() <= 0;
        if (z) {
            return false;
        }
        if (str.length() > 255) {
            x.a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (!str.toLowerCase().startsWith("http")) {
            x.a("URL(%s) is not start with \"http\".", str);
            return false;
        } else if (str.toLowerCase().contains("qq.com")) {
            return true;
        } else {
            x.a("URL(%s) does not contain \"qq.com\".", str);
            return false;
        }
    }

    public static byte[] c(long j) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            return stringBuilder.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                stringBuffer.append(':');
            }
            String toHexString = Integer.toHexString(bArr[i] & 255);
            if (toHexString.length() == 1) {
                StringBuilder stringBuilder = new StringBuilder("0");
                stringBuilder.append(toHexString);
                toHexString = stringBuilder.toString();
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
