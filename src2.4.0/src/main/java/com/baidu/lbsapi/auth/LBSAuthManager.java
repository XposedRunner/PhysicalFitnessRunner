package com.baidu.lbsapi.auth;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.22";
    private static Context a;
    private static m d;
    private static int e;
    private static Hashtable<String, LBSAuthManagerListener> f = new Hashtable();
    private static LBSAuthManager g;
    private c b = null;
    private e c = null;
    private final Handler h = new i(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        a = context;
        if (!(d == null || d.isAlive())) {
            d = null;
        }
        a.b("BaiduApiAuth SDK Version:1.0.22");
        d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARNING: Missing block: B:14:0x005b, code skipped:
            if (r0.format(java.lang.Long.valueOf(r5)).equals(r0.format(java.lang.Long.valueOf(r3))) == false) goto L_0x003e;
     */
    private int a(java.lang.String r13) {
        /*
        r12 = this;
        r0 = -1;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x008b }
        r1.<init>(r13);	 Catch:{ JSONException -> 0x008b }
        r13 = "status";
        r13 = r1.has(r13);	 Catch:{ JSONException -> 0x008b }
        if (r13 != 0) goto L_0x0013;
    L_0x000e:
        r13 = "status";
        r1.put(r13, r0);	 Catch:{ JSONException -> 0x008b }
    L_0x0013:
        r13 = "status";
        r13 = r1.getInt(r13);	 Catch:{ JSONException -> 0x008b }
        r0 = "current";
        r0 = r1.has(r0);	 Catch:{ JSONException -> 0x0086 }
        r2 = 601; // 0x259 float:8.42E-43 double:2.97E-321;
        if (r0 == 0) goto L_0x005e;
    L_0x0023:
        if (r13 != 0) goto L_0x005e;
    L_0x0025:
        r0 = "current";
        r3 = r1.getLong(r0);	 Catch:{ JSONException -> 0x0086 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0086 }
        r7 = r5 - r3;
        r7 = (double) r7;	 Catch:{ JSONException -> 0x0086 }
        r9 = 4704985352480227328; // 0x414b774000000000 float:0.0 double:3600000.0;
        r7 = r7 / r9;
        r9 = 4627448617123184640; // 0x4038000000000000 float:0.0 double:24.0;
        r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r0 < 0) goto L_0x0040;
    L_0x003e:
        r0 = r2;
        goto L_0x005f;
    L_0x0040:
        r0 = new java.text.SimpleDateFormat;	 Catch:{ JSONException -> 0x0086 }
        r7 = "yyyy-MM-dd";
        r0.<init>(r7);	 Catch:{ JSONException -> 0x0086 }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ JSONException -> 0x0086 }
        r5 = r0.format(r5);	 Catch:{ JSONException -> 0x0086 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ JSONException -> 0x0086 }
        r0 = r0.format(r3);	 Catch:{ JSONException -> 0x0086 }
        r0 = r5.equals(r0);	 Catch:{ JSONException -> 0x0086 }
        if (r0 != 0) goto L_0x005e;
    L_0x005d:
        goto L_0x003e;
    L_0x005e:
        r0 = r13;
    L_0x005f:
        r13 = "current";
        r13 = r1.has(r13);	 Catch:{ JSONException -> 0x008b }
        if (r13 == 0) goto L_0x008f;
    L_0x0067:
        r13 = 602; // 0x25a float:8.44E-43 double:2.974E-321;
        if (r0 != r13) goto L_0x008f;
    L_0x006b:
        r13 = "current";
        r3 = r1.getLong(r13);	 Catch:{ JSONException -> 0x008b }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x008b }
        r7 = r5 - r3;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = r7 / r3;
        r3 = (double) r7;
        r5 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r13 <= 0) goto L_0x008f;
    L_0x0084:
        r0 = r2;
        return r0;
    L_0x0086:
        r0 = move-exception;
        r11 = r0;
        r0 = r13;
        r13 = r11;
        goto L_0x008c;
    L_0x008b:
        r13 = move-exception;
    L_0x008c:
        r13.printStackTrace();
    L_0x008f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARNING: Missing block: B:48:0x0078, code skipped:
            if (r6 == null) goto L_0x008d;
     */
    /* JADX WARNING: Missing block: B:57:0x0088, code skipped:
            if (r6 == null) goto L_0x008d;
     */
    /* JADX WARNING: Missing block: B:58:0x008a, code skipped:
            r6.close();
     */
    /* JADX WARNING: Missing block: B:59:0x008d, code skipped:
            return null;
     */
    private java.lang.String a(int r6) throws java.io.IOException {
        /*
        r5 = this;
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r2 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r2.<init>();	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r3 = "/proc/";
        r2.append(r3);	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r2.append(r6);	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r6 = "/cmdline";
        r2.append(r6);	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r6 = r2.toString();	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r1.<init>(r6);	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r6 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r6.<init>(r1);	 Catch:{ FileNotFoundException -> 0x007b, IOException -> 0x006b, all -> 0x0058 }
        r1 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0054, all -> 0x004f }
        r1.<init>(r6);	 Catch:{ FileNotFoundException -> 0x0056, IOException -> 0x0054, all -> 0x004f }
        r2 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004b, all -> 0x0046 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x004d, IOException -> 0x004b, all -> 0x0046 }
        r3 = r2.readLine();	 Catch:{ FileNotFoundException -> 0x007e, IOException -> 0x006e, all -> 0x0040 }
        if (r2 == 0) goto L_0x0034;
    L_0x0031:
        r2.close();
    L_0x0034:
        if (r1 == 0) goto L_0x0039;
    L_0x0036:
        r1.close();
    L_0x0039:
        if (r6 == 0) goto L_0x003e;
    L_0x003b:
        r6.close();
    L_0x003e:
        r0 = r3;
        return r0;
    L_0x0040:
        r0 = move-exception;
        r4 = r2;
        r2 = r6;
        r6 = r0;
        r0 = r4;
        goto L_0x005b;
    L_0x0046:
        r2 = move-exception;
        r4 = r2;
        r2 = r6;
        r6 = r4;
        goto L_0x005b;
    L_0x004b:
        r2 = r0;
        goto L_0x006e;
    L_0x004d:
        r2 = r0;
        goto L_0x007e;
    L_0x004f:
        r1 = move-exception;
        r2 = r6;
        r6 = r1;
        r1 = r0;
        goto L_0x005b;
    L_0x0054:
        r1 = r0;
        goto L_0x006d;
    L_0x0056:
        r1 = r0;
        goto L_0x007d;
    L_0x0058:
        r6 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x005b:
        if (r0 == 0) goto L_0x0060;
    L_0x005d:
        r0.close();
    L_0x0060:
        if (r1 == 0) goto L_0x0065;
    L_0x0062:
        r1.close();
    L_0x0065:
        if (r2 == 0) goto L_0x006a;
    L_0x0067:
        r2.close();
    L_0x006a:
        throw r6;
    L_0x006b:
        r6 = r0;
        r1 = r6;
    L_0x006d:
        r2 = r1;
    L_0x006e:
        if (r2 == 0) goto L_0x0073;
    L_0x0070:
        r2.close();
    L_0x0073:
        if (r1 == 0) goto L_0x0078;
    L_0x0075:
        r1.close();
    L_0x0078:
        if (r6 == 0) goto L_0x008d;
    L_0x007a:
        goto L_0x008a;
    L_0x007b:
        r6 = r0;
        r1 = r6;
    L_0x007d:
        r2 = r1;
    L_0x007e:
        if (r2 == 0) goto L_0x0083;
    L_0x0080:
        r2.close();
    L_0x0083:
        if (r1 == 0) goto L_0x0088;
    L_0x0085:
        r1.close();
    L_0x0088:
        if (r6 == 0) goto L_0x008d;
    L_0x008a:
        r6.close();
    L_0x008d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(int):java.lang.String");
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        String str = null;
        try {
            str = a(myPid);
        } catch (IOException unused) {
        }
        return str != null ? str : a.getPackageName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Missing block: B:13:0x003b, code skipped:
            if (r5.equals("") != false) goto L_0x003d;
     */
    private java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = "";
        r1 = r5.getPackageName();
        r2 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0051 }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r5 = r5.getApplicationInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x0051 }
        r1 = r5.metaData;	 Catch:{ NameNotFoundException -> 0x0051 }
        if (r1 != 0) goto L_0x002b;
    L_0x0016:
        r5 = f;	 Catch:{ NameNotFoundException -> 0x0051 }
        r5 = r5.get(r6);	 Catch:{ NameNotFoundException -> 0x0051 }
        r5 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r5;	 Catch:{ NameNotFoundException -> 0x0051 }
        if (r5 == 0) goto L_0x0029;
    L_0x0020:
        r1 = "AndroidManifest.xml的application中没有meta-data标签";
        r1 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r1);	 Catch:{ NameNotFoundException -> 0x0051 }
        r5.onAuthResult(r2, r1);	 Catch:{ NameNotFoundException -> 0x0051 }
    L_0x0029:
        r5 = r0;
        return r5;
    L_0x002b:
        r5 = r5.metaData;	 Catch:{ NameNotFoundException -> 0x0051 }
        r1 = "com.baidu.lbsapi.API_KEY";
        r5 = r5.getString(r1);	 Catch:{ NameNotFoundException -> 0x0051 }
        if (r5 == 0) goto L_0x003d;
    L_0x0035:
        r0 = "";
        r0 = r5.equals(r0);	 Catch:{ NameNotFoundException -> 0x0052 }
        if (r0 == 0) goto L_0x0065;
    L_0x003d:
        r0 = f;	 Catch:{ NameNotFoundException -> 0x0052 }
        r0 = r0.get(r6);	 Catch:{ NameNotFoundException -> 0x0052 }
        r0 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r0;	 Catch:{ NameNotFoundException -> 0x0052 }
        if (r0 == 0) goto L_0x0065;
    L_0x0047:
        r1 = "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值";
        r1 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r1);	 Catch:{ NameNotFoundException -> 0x0052 }
        r0.onAuthResult(r2, r1);	 Catch:{ NameNotFoundException -> 0x0052 }
        return r5;
    L_0x0051:
        r5 = r0;
    L_0x0052:
        r0 = f;
        r6 = r0.get(r6);
        r6 = (com.baidu.lbsapi.auth.LBSAuthManagerListener) r6;
        if (r6 == 0) goto L_0x0065;
    L_0x005c:
        r0 = "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值";
        r0 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r0);
        r6.onAuthResult(r2, r0);
    L_0x0065:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A:{Catch:{ all -> 0x0008 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1 A:{Catch:{ all -> 0x0008 }} */
    private synchronized void a(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        monitor-enter(r6);
        if (r7 != 0) goto L_0x000b;
    L_0x0003:
        r7 = r6.e();	 Catch:{ all -> 0x0008 }
        goto L_0x000b;
    L_0x0008:
        r7 = move-exception;
        goto L_0x00c9;
    L_0x000b:
        r0 = r6.h;	 Catch:{ all -> 0x0008 }
        r0 = r0.obtainMessage();	 Catch:{ all -> 0x0008 }
        r1 = -1;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x006f }
        r2.<init>(r7);	 Catch:{ JSONException -> 0x006f }
        r7 = "status";
        r7 = r2.has(r7);	 Catch:{ JSONException -> 0x006f }
        if (r7 != 0) goto L_0x0024;
    L_0x001f:
        r7 = "status";
        r2.put(r7, r1);	 Catch:{ JSONException -> 0x006f }
    L_0x0024:
        r7 = "current";
        r7 = r2.has(r7);	 Catch:{ JSONException -> 0x006f }
        if (r7 != 0) goto L_0x0035;
    L_0x002c:
        r7 = "current";
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x006f }
        r2.put(r7, r3);	 Catch:{ JSONException -> 0x006f }
    L_0x0035:
        r7 = r2.toString();	 Catch:{ JSONException -> 0x006f }
        r6.c(r7);	 Catch:{ JSONException -> 0x006f }
        r7 = "current";
        r7 = r2.has(r7);	 Catch:{ JSONException -> 0x006f }
        if (r7 == 0) goto L_0x0049;
    L_0x0044:
        r7 = "current";
        r2.remove(r7);	 Catch:{ JSONException -> 0x006f }
    L_0x0049:
        r7 = "status";
        r7 = r2.getInt(r7);	 Catch:{ JSONException -> 0x006f }
        r0.what = r7;	 Catch:{ JSONException -> 0x006a }
        r1 = r2.toString();	 Catch:{ JSONException -> 0x006a }
        r0.obj = r1;	 Catch:{ JSONException -> 0x006a }
        r1 = new android.os.Bundle;	 Catch:{ JSONException -> 0x006a }
        r1.<init>();	 Catch:{ JSONException -> 0x006a }
        r2 = "listenerKey";
        r1.putString(r2, r8);	 Catch:{ JSONException -> 0x006a }
        r0.setData(r1);	 Catch:{ JSONException -> 0x006a }
        r1 = r6.h;	 Catch:{ JSONException -> 0x006a }
        r1.sendMessage(r0);	 Catch:{ JSONException -> 0x006a }
        goto L_0x008e;
    L_0x006a:
        r1 = move-exception;
        r5 = r1;
        r1 = r7;
        r7 = r5;
        goto L_0x0070;
    L_0x006f:
        r7 = move-exception;
    L_0x0070:
        r7.printStackTrace();	 Catch:{ all -> 0x0008 }
        r0.what = r1;	 Catch:{ all -> 0x0008 }
        r7 = new org.json.JSONObject;	 Catch:{ all -> 0x0008 }
        r7.<init>();	 Catch:{ all -> 0x0008 }
        r0.obj = r7;	 Catch:{ all -> 0x0008 }
        r7 = new android.os.Bundle;	 Catch:{ all -> 0x0008 }
        r7.<init>();	 Catch:{ all -> 0x0008 }
        r1 = "listenerKey";
        r7.putString(r1, r8);	 Catch:{ all -> 0x0008 }
        r0.setData(r7);	 Catch:{ all -> 0x0008 }
        r7 = r6.h;	 Catch:{ all -> 0x0008 }
        r7.sendMessage(r0);	 Catch:{ all -> 0x0008 }
    L_0x008e:
        r7 = d;	 Catch:{ all -> 0x0008 }
        if (r7 == 0) goto L_0x0097;
    L_0x0092:
        r7 = d;	 Catch:{ all -> 0x0008 }
        r7.c();	 Catch:{ all -> 0x0008 }
    L_0x0097:
        r7 = e;	 Catch:{ all -> 0x0008 }
        r7 = r7 + -1;
        e = r7;	 Catch:{ all -> 0x0008 }
        r7 = com.baidu.lbsapi.auth.a.a;	 Catch:{ all -> 0x0008 }
        if (r7 == 0) goto L_0x00b7;
    L_0x00a1:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0008 }
        r7.<init>();	 Catch:{ all -> 0x0008 }
        r8 = "httpRequest called mAuthCounter-- = ";
        r7.append(r8);	 Catch:{ all -> 0x0008 }
        r8 = e;	 Catch:{ all -> 0x0008 }
        r7.append(r8);	 Catch:{ all -> 0x0008 }
        r7 = r7.toString();	 Catch:{ all -> 0x0008 }
        com.baidu.lbsapi.auth.a.a(r7);	 Catch:{ all -> 0x0008 }
    L_0x00b7:
        r7 = e;	 Catch:{ all -> 0x0008 }
        if (r7 != 0) goto L_0x00c7;
    L_0x00bb:
        r7 = d;	 Catch:{ all -> 0x0008 }
        if (r7 == 0) goto L_0x00c7;
    L_0x00bf:
        r7 = d;	 Catch:{ all -> 0x0008 }
        r7.a();	 Catch:{ all -> 0x0008 }
        r7 = 0;
        d = r7;	 Catch:{ all -> 0x0008 }
    L_0x00c7:
        monitor-exit(r6);
        return;
    L_0x00c9:
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.LBSAuthManager.a(java.lang.String, java.lang.String):void");
    }

    private void a(boolean z, String str, Hashtable<String, String> hashtable, String str2) {
        String a = a(a, str2);
        if (a != null && !a.equals("")) {
            Object obj;
            Object str3;
            HashMap hashMap = new HashMap();
            hashMap.put(SocialConstants.PARAM_URL, "https://api.map.baidu.com/sdkcs/verify");
            a.a("url:https://api.map.baidu.com/sdkcs/verify");
            hashMap.put("output", "json");
            hashMap.put("ak", a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ak:");
            stringBuilder.append(a);
            a.a(stringBuilder.toString());
            hashMap.put("mcode", b.a(a));
            hashMap.put("from", "lbs_yunsdk");
            if (hashtable != null && hashtable.size() > 0) {
                for (Entry entry : hashtable.entrySet()) {
                    String str4 = (String) entry.getKey();
                    a = (String) entry.getValue();
                    if (!(TextUtils.isEmpty(str4) || TextUtils.isEmpty(a))) {
                        hashMap.put(str4, a);
                    }
                }
            }
            String str5 = "";
            try {
                str5 = CommonParam.a(a);
            } catch (Exception unused) {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("cuid:");
            stringBuilder2.append(str5);
            a.a(stringBuilder2.toString());
            if (TextUtils.isEmpty(str5)) {
                hashMap.put("cuid", "");
            } else {
                hashMap.put("cuid", str5);
            }
            hashMap.put("pcn", a.getPackageName());
            hashMap.put("version", VERSION);
            CharSequence charSequence = "";
            try {
                charSequence = b.c(a);
            } catch (Exception unused2) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("macaddr", "");
            } else {
                hashMap.put("macaddr", charSequence);
            }
            charSequence = "";
            try {
                charSequence = b.a();
            } catch (Exception unused3) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("language", "");
            } else {
                hashMap.put("language", charSequence);
            }
            if (z) {
                hashMap.put("force", z ? "1" : "0");
            }
            if (str3 == null) {
                obj = "from_service";
                str3 = "";
            } else {
                obj = "from_service";
            }
            hashMap.put(obj, str3);
            this.b = new c(a);
            this.b.a(hashMap, new k(this, str2));
        }
    }

    private void a(boolean z, String str, Hashtable<String, String> hashtable, String[] strArr, String str2) {
        String a = a(a, str2);
        if (a != null && !a.equals("")) {
            Object obj;
            Object str3;
            HashMap hashMap = new HashMap();
            hashMap.put(SocialConstants.PARAM_URL, "https://api.map.baidu.com/sdkcs/verify");
            hashMap.put("output", "json");
            hashMap.put("ak", a);
            hashMap.put("from", "lbs_yunsdk");
            if (hashtable != null && hashtable.size() > 0) {
                for (Entry entry : hashtable.entrySet()) {
                    String str4 = (String) entry.getKey();
                    a = (String) entry.getValue();
                    if (!(TextUtils.isEmpty(str4) || TextUtils.isEmpty(a))) {
                        hashMap.put(str4, a);
                    }
                }
            }
            CharSequence charSequence = "";
            try {
                charSequence = CommonParam.a(a);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("cuid", "");
            } else {
                hashMap.put("cuid", charSequence);
            }
            hashMap.put("pcn", a.getPackageName());
            hashMap.put("version", VERSION);
            charSequence = "";
            try {
                charSequence = b.c(a);
            } catch (Exception unused2) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("macaddr", "");
            } else {
                hashMap.put("macaddr", charSequence);
            }
            charSequence = "";
            try {
                charSequence = b.a();
            } catch (Exception unused3) {
            }
            if (TextUtils.isEmpty(charSequence)) {
                hashMap.put("language", "");
            } else {
                hashMap.put("language", charSequence);
            }
            if (z) {
                hashMap.put("force", z ? "1" : "0");
            }
            if (str3 == null) {
                obj = "from_service";
                str3 = "";
            } else {
                obj = "from_service";
            }
            hashMap.put(obj, str3);
            this.c = new e(a);
            this.c.a(hashMap, strArr, new l(this, str2));
        }
    }

    private boolean b(String str) {
        str = a(a, str);
        String str2 = "";
        Object string;
        try {
            JSONObject jSONObject = new JSONObject(e());
            if (!jSONObject.has("ak")) {
                return true;
            }
            string = jSONObject.getString("ak");
            return (str == null || string == null || str.equals(string)) ? false : true;
        } catch (JSONException e) {
            e.printStackTrace();
            string = str2;
        }
    }

    private void c(String str) {
        Context context = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("authStatus_");
        stringBuilder.append(a(a));
        context.getSharedPreferences(stringBuilder.toString(), 0).edit().putString("status", str).commit();
    }

    private void d() {
        synchronized (LBSAuthManager.class) {
            if (d == null) {
                d = new m("auth");
                d.start();
                while (d.a == null) {
                    try {
                        if (a.a) {
                            a.a("wait for create auth thread.");
                        }
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private String e() {
        Context context = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("authStatus_");
        stringBuilder.append(a(a));
        return context.getSharedPreferences(stringBuilder.toString(), 0).getString("status", "{\"status\":601}");
    }

    public static LBSAuthManager getInstance(Context context) {
        if (g == null) {
            synchronized (LBSAuthManager.class) {
                if (g == null) {
                    g = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            a = context;
        } else if (a.a) {
            a.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return g;
    }

    public int authenticate(boolean z, String str, Hashtable<String, String> hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        synchronized (LBSAuthManager.class) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("");
            String stringBuilder2 = stringBuilder.toString();
            if (lBSAuthManagerListener != null) {
                f.put(stringBuilder2, lBSAuthManagerListener);
            }
            String a = a(a, stringBuilder2);
            if (a != null) {
                if (!a.equals("")) {
                    e++;
                    if (a.a) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(" mAuthCounter  ++ = ");
                        stringBuilder3.append(e);
                        a.a(stringBuilder3.toString());
                    }
                    a = e();
                    if (a.a) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("getAuthMessage from cache:");
                        stringBuilder.append(a);
                        a.a(stringBuilder.toString());
                    }
                    int a2 = a(a);
                    if (a2 == 601) {
                        try {
                            c(new JSONObject().put("status", 602).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    d();
                    if (d != null) {
                        if (d.a != null) {
                            if (a.a) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("mThreadLooper.mHandler = ");
                                stringBuilder.append(d.a);
                                a.a(stringBuilder.toString());
                            }
                            d.a.post(new j(this, a2, z, stringBuilder2, str, hashtable));
                            return a2;
                        }
                    }
                    return -1;
                }
            }
            return 101;
        }
    }

    public String getCUID() {
        if (a == null) {
            return "";
        }
        String str = "";
        try {
            return CommonParam.a(a);
        } catch (Exception e) {
            if (a.a) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public String getKey() {
        if (a == null) {
            return "";
        }
        try {
            return getPublicKey(a);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        return a == null ? "" : b.a(a);
    }

    public String getPublicKey(Context context) throws NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }
}
