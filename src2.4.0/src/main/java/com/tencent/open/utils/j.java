package com.tencent.open.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jiguang.net.HttpUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.tencent.bugly.Bugly;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class j {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static int e = -1;
    private static String f = null;
    private static String g = "0123456789ABCDEF";

    /* compiled from: ProGuard */
    public static class a {
        public String a;
        public long b;
        public long c;

        public a(String str, int i) {
            this.a = str;
            this.b = (long) i;
            if (this.a != null) {
                this.c = (long) this.a.length();
            }
        }
    }

    private static char a(int i) {
        i &= 15;
        return i < 10 ? (char) (48 + i) : (char) (97 + (i - 10));
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        try {
            for (String split : str.split(HttpUtils.PARAMETERS_SEPARATOR)) {
                String[] split2 = split.split(HttpUtils.EQUAL_SIGN);
                if (split2.length == 2) {
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            return bundle;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE, str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString("detail", str9);
        bundle.putString("os_ver", VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.b.a.a(e.a()));
        bundle.putString("apn", com.tencent.open.b.a.b(e.a()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", Constants.SDK_VERSION);
        bundle.putString("packagename", e.b());
        bundle.putString("app_ver", d(e.a(), e.b()));
        return bundle;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString("app_id", str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        return bundle;
    }

    public static String a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            f.a("openSDK_LOG.Util", "getUserIp SocketException ", e);
        }
        return "";
    }

    public static final String a(Context context) {
        if (context != null) {
            CharSequence applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
            if (applicationLabel != null) {
                return applicationLabel.toString();
            }
        }
        return null;
    }

    public static final String a(String str, int i, String str2, String str3) {
        Exception e;
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str4 = HttpUtils.ENCODING_UTF_8;
        if (TextUtils.isEmpty(str2)) {
            str2 = str4;
        }
        try {
            if (str.getBytes(str2).length <= i) {
                return str;
            }
            int i2 = 0;
            int i3 = i2;
            while (i2 < str.length()) {
                int i4 = i2 + 1;
                i3 += str.substring(i2, i4).getBytes(str2).length;
                if (i3 > i) {
                    String substring = str.substring(0, i2);
                    try {
                        if (TextUtils.isEmpty(str3)) {
                            str = substring;
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(substring);
                            stringBuilder2.append(str3);
                            str = stringBuilder2.toString();
                        }
                        return str;
                    } catch (Exception e2) {
                        String str5 = substring;
                        e = e2;
                        str = str5;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Util.subString has exception: ");
                        stringBuilder.append(e.getMessage());
                        f.e("openSDK_LOG.Util", stringBuilder.toString());
                        return str;
                    }
                }
                i2 = i4;
            }
            return str;
        } catch (Exception e3) {
            e = e3;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Util.subString has exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.Util", stringBuilder.toString());
            return str;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String num = Integer.toString(b & 255, 16);
            if (num.length() == 1) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("0");
                stringBuilder2.append(num);
                num = stringBuilder2.toString();
            }
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
    /* JADX WARNING: Failed to process nested try/catch */
    public static org.json.JSONObject a(org.json.JSONObject r7, java.lang.String r8) {
        /*
        if (r7 != 0) goto L_0x0007;
    L_0x0002:
        r7 = new org.json.JSONObject;
        r7.<init>();
    L_0x0007:
        if (r8 == 0) goto L_0x0059;
    L_0x0009:
        r0 = "&";
        r8 = r8.split(r0);
        r0 = 0;
        r1 = r8.length;
        r2 = r0;
    L_0x0012:
        if (r2 >= r1) goto L_0x0059;
    L_0x0014:
        r3 = r8[r2];
        r4 = "=";
        r3 = r3.split(r4);
        r4 = r3.length;
        r5 = 2;
        if (r4 != r5) goto L_0x0056;
    L_0x0020:
        r4 = 1;
        r5 = r3[r0];	 Catch:{ Exception -> 0x0034 }
        r5 = java.net.URLDecoder.decode(r5);	 Catch:{ Exception -> 0x0034 }
        r3[r0] = r5;	 Catch:{ Exception -> 0x0034 }
        r5 = r3[r4];	 Catch:{ Exception -> 0x0034 }
        r5 = java.net.URLDecoder.decode(r5);	 Catch:{ Exception -> 0x0034 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0034 }
        goto L_0x0034;
    L_0x0032:
        r3 = move-exception;
        goto L_0x003c;
    L_0x0034:
        r5 = r3[r0];	 Catch:{ JSONException -> 0x0032 }
        r3 = r3[r4];	 Catch:{ JSONException -> 0x0032 }
        r7.put(r5, r3);	 Catch:{ JSONException -> 0x0032 }
        goto L_0x0056;
    L_0x003c:
        r4 = "openSDK_LOG.Util";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "decodeUrlToJson has exception: ";
        r5.append(r6);
        r3 = r3.getMessage();
        r5.append(r3);
        r3 = r5.toString();
        com.tencent.open.a.f.e(r4, r3);
    L_0x0056:
        r2 = r2 + 1;
        goto L_0x0012;
    L_0x0059:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.j.a(org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0022 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033 A:{SYNTHETIC, Splitter:B:19:0x0033} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A:{SYNTHETIC, Splitter:B:11:0x001a} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|12|13|14|15|16) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|12|13|14|15|16) */
    /* JADX WARNING: Missing block: B:17:0x0032, code skipped:
            return false;
     */
    public static boolean a(android.content.Context r4, java.lang.String r5) {
        /*
        r0 = 0;
        r1 = f(r4);	 Catch:{ Exception -> 0x0017 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r2 = "com.tencent.mtt";
        r3 = "com.tencent.mtt.MainActivity";
        a(r4, r2, r3, r5);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0042;
    L_0x000f:
        r2 = "com.android.browser";
        r3 = "com.android.browser.BrowserActivity";
        a(r4, r2, r3, r5);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0042;
    L_0x0017:
        r1 = r0;
    L_0x0018:
        if (r1 == 0) goto L_0x0033;
    L_0x001a:
        r1 = "com.android.browser";
        r2 = "com.android.browser.BrowserActivity";
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x0022 }
        goto L_0x0042;
    L_0x0022:
        r1 = "com.google.android.browser";
        r2 = "com.android.browser.BrowserActivity";
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x002a }
        goto L_0x0042;
    L_0x002a:
        r1 = "com.android.chrome";
        r2 = "com.google.android.apps.chrome.Main";
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x0032 }
        goto L_0x0042;
    L_0x0032:
        return r0;
    L_0x0033:
        r1 = "com.google.android.browser";
        r2 = "com.android.browser.BrowserActivity";
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x003b }
        goto L_0x0042;
    L_0x003b:
        r1 = "com.android.chrome";
        r2 = "com.google.android.apps.chrome.Main";
        a(r4, r1, r2, r5);	 Catch:{ Exception -> 0x0044 }
    L_0x0042:
        r4 = 1;
        return r4;
    L_0x0044:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.j.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean a(Context context, boolean z) {
        if (d(context) && h.a(context, Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        boolean z2 = false;
        if (z) {
            if (h.c(context, "4.1") >= 0 || h.a(context, Constants.PACKAGE_TIM) != null) {
                z2 = true;
            }
            return z2;
        }
        if (h.c(context, "4.1") >= 0 || h.a(context, Constants.PACKAGE_TIM) != null) {
            z2 = true;
        }
        return z2;
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            Bundle a = a(url.getQuery());
            a.putAll(a(url.getRef()));
            return a;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static void b(Context context, String str) {
        StringBuilder stringBuilder;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                b = packageInfo.versionName;
                a = b.substring(0, b.lastIndexOf(46));
                d = b.substring(b.lastIndexOf(46) + 1, b.length());
                e = packageInfo.versionCode;
            } catch (NameNotFoundException e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("getPackageInfo has exception: ");
                stringBuilder.append(e.getMessage());
                f.e("openSDK_LOG.Util", stringBuilder.toString());
            } catch (Exception e2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("getPackageInfo has exception: ");
                stringBuilder.append(e2.getMessage());
                f.e("openSDK_LOG.Util", stringBuilder.toString());
            }
        }
    }

    public static boolean b() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo isConnectedOrConnecting : allNetworkInfo) {
                if (isConnectedOrConnecting.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                if (lastKnownLocation == null) {
                    return "";
                }
                double latitude = lastKnownLocation.getLatitude();
                double longitude = lastKnownLocation.getLongitude();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(latitude);
                stringBuilder.append("*");
                stringBuilder.append(longitude);
                f = stringBuilder.toString();
                return f;
            }
        } catch (Exception e) {
            f.b("openSDK_LOG.Util", "getLocation>>>", e);
        }
        return "";
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", "http://"));
            JSONObject a = a(null, url.getQuery());
            a(a, url.getRef());
            return a;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return a;
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals(Bugly.SDK_IS_DEV)) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{online:");
            stringBuilder.append(str.charAt(str.length() - 2));
            stringBuilder.append("}");
            str = stringBuilder.toString();
        }
        return new JSONObject(str);
    }

    public static boolean d(Context context) {
        double sqrt;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sqrt = Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d));
        } catch (Throwable unused) {
            sqrt = 0.0d;
        }
        return sqrt > 6.5d;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        c = d(context, str);
        return c;
    }

    public static boolean e(Context context) {
        return h.c(context, "5.9.5") >= 0 || h.a(context, Constants.PACKAGE_TIM) != null;
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    public static String f(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(i(str));
            byte[] digest = instance.digest();
            if (digest == null) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : digest) {
                stringBuilder.append(a(i >>> 4));
                stringBuilder.append(a(i));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("encrypt has exception: ");
            stringBuilder2.append(e.getMessage());
            f.e("openSDK_LOG.Util", stringBuilder2.toString());
            return str;
        }
    }

    private static boolean f(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (h.a(str, "4.3") >= 0 && !str.startsWith("4.4")) {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null) {
                    try {
                        MessageDigest instance = MessageDigest.getInstance("MD5");
                        instance.update(signatureArr[0].toByteArray());
                        String a = a(instance.digest());
                        instance.reset();
                        if (a.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                            return true;
                        }
                    } catch (NoSuchAlgorithmException e) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("isQQBrowerAvailable has exception: ");
                        stringBuilder.append(e.getMessage());
                        f.e("openSDK_LOG.Util", stringBuilder.toString());
                    }
                }
            }
            return false;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean f(Context context, String str) {
        boolean z = !d(context) || h.a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z && h.a(context, Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        return z ? h.c(context, str) < 0 : z;
    }

    public static boolean g(Context context, String str) {
        boolean z = !d(context) || h.a(context, Constants.PACKAGE_QQ_PAD) == null;
        if (z && h.a(context, Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        return z ? h.c(context, str) < 0 : z;
    }

    public static final boolean g(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            z = true;
        }
        return z;
    }

    public static boolean h(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file != null && file.exists();
    }

    public static byte[] i(String str) {
        try {
            return str.getBytes(HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
