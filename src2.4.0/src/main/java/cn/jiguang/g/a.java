package cn.jiguang.g;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.x;
import cn.jiguang.d.h.e;
import cn.jiguang.d.h.f;
import cn.jiguang.e.c;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.DataProvider;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static int a = 1;
    private static List<String> b = null;
    private static final ArrayList<String> c = new ArrayList();
    private static final ArrayList<String> d = new ArrayList();
    private static final ArrayList<String> e;
    private static Boolean f = null;
    private static String g = "";
    private static PushReceiver h;

    static {
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add("358673013795895");
        b.add("004999010640000");
        b.add("00000000000000");
        b.add("000000000000000");
        c.add("android.permission.INTERNET");
        c.add("android.permission.ACCESS_NETWORK_STATE");
        d.add("android.permission.WAKE_LOCK");
        d.add("android.permission.VIBRATE");
        d.add("android.permission.CHANGE_WIFI_STATE");
        arrayList = new ArrayList();
        e = arrayList;
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        e.add("android.permission.ACCESS_COARSE_LOCATION");
        e.add("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS");
        e.add("android.permission.ACCESS_WIFI_STATE");
    }

    private static String A(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PrefsFile", 0);
        String string = sharedPreferences.getString("key", null);
        if (string != null) {
            return string;
        }
        string = UUID.randomUUID().toString();
        Editor edit = sharedPreferences.edit();
        edit.putString("key", string);
        edit.commit();
        return string;
    }

    private static boolean B(Context context) {
        try {
            if (h == null) {
                h = new PushReceiver();
                context.registerReceiver(h, new IntentFilter("android.intent.action.USER_PRESENT"));
                context.registerReceiver(h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                IntentFilter intentFilter2 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
                intentFilter2.addDataScheme("package");
                context.registerReceiver(h, intentFilter);
                context.registerReceiver(h, intentFilter2);
                intentFilter = new IntentFilter(JPushInterface.ACTION_NOTIFICATION_RECEIVED_PROXY);
                intentFilter.setPriority(1000);
                intentFilter.addCategory(context.getPackageName());
                context.registerReceiver(h, intentFilter);
                return true;
            }
            c.a("AndroidUtil", "has register in code");
            return true;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("Register PushReceiver in code  failed:");
            stringBuilder.append(th.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
            return false;
        }
    }

    public static int a(byte b) {
        return b & 255;
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            return null;
        }
        try {
            ActivityInfo[] activityInfoArr;
            int i = 0;
            int i2 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, i2);
            if (i2 == 4) {
                activityInfoArr = packageInfo.services;
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        activityInfoArr = packageInfo.activities;
                        break;
                    case 2:
                        activityInfoArr = packageInfo.receivers;
                        break;
                    default:
                        activityInfoArr = null;
                        break;
                }
            } else {
                activityInfoArr = packageInfo.providers;
            }
            if (activityInfoArr == null) {
                return null;
            }
            str = cls.getName();
            int length = activityInfoArr.length;
            while (i < length) {
                ComponentInfo componentInfo = activityInfoArr[i];
                if (str.equals(componentInfo.name)) {
                    return componentInfo;
                }
                i++;
            }
            return null;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasComponent error:");
            stringBuilder.append(th.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
        }
    }

    public static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File("/proc/cpuinfo").exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                CharSequence charSequence = null;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.contains("Processor")) {
                        int indexOf = readLine.indexOf(":");
                        if (indexOf >= 0 && indexOf < readLine.length() - 1) {
                            charSequence = readLine.substring(indexOf + 1).trim();
                        }
                        if (!(charSequence == null || stringBuffer.toString().contains(charSequence))) {
                            stringBuffer.append(charSequence);
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static String a(Context context) {
        if (context == null || context.getResources() == null) {
            return "0*0";
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return "0*0";
        }
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("*");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            char[] toCharArray = str.toCharArray();
            byte[] bArr = new byte[toCharArray.length];
            int i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                bArr[i2] = (byte) toCharArray[i2];
            }
            byte[] digest = instance.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                int i3 = digest[i] & 255;
                if (i3 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i3));
                i++;
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        try {
            bArr = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArr) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0039 */
    public static java.util.ArrayList<java.lang.String> a(java.lang.String[] r4) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0041 }
        r4 = r2.exec(r4);	 Catch:{ Exception -> 0x0041 }
        r2 = new java.io.BufferedReader;
        r3 = new java.io.InputStreamReader;
        r4 = r4.getInputStream();
        r3.<init>(r4);
        r2.<init>(r3);
    L_0x001c:
        r4 = r2.readLine();	 Catch:{ Exception -> 0x0039, all -> 0x002f }
        if (r4 == 0) goto L_0x0026;
    L_0x0022:
        r0.add(r4);	 Catch:{ Exception -> 0x0039, all -> 0x002f }
        goto L_0x001c;
    L_0x0026:
        r2.close();	 Catch:{ IOException -> 0x002a }
        return r0;
    L_0x002a:
        r4 = move-exception;
        r4.printStackTrace();
        return r0;
    L_0x002f:
        r4 = move-exception;
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0038;
    L_0x0034:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0038:
        throw r4;
    L_0x0039:
        r2.close();	 Catch:{ IOException -> 0x003d }
        return r1;
    L_0x003d:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0041:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.a(java.lang.String[]):java.util.ArrayList");
    }

    private static List<String> a(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null) {
                    String str2 = resolveInfo.activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        int i = 1;
                        if (!(TextUtils.isEmpty(str) || packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) == 0)) {
                            i = 0;
                        }
                        if (i != 0) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static List<String> a(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (!a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static JSONObject a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str2);
            x.a(null, jSONObject, str);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject a(String str, JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", jSONArray);
            x.a(null, jSONObject, str);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context, String str, int i) {
        if (!w(context)) {
            return;
        }
        if (a(context, PushReceiver.class)) {
            int i2;
            Notification notification;
            Intent intent = new Intent(context, PushReceiver.class);
            intent.setAction("cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY");
            intent.addCategory(context.getPackageName());
            intent.putExtra("debug_notification", true);
            intent.putExtra("toastText", str);
            intent.putExtra("type", -1);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            try {
                i2 = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 0).icon;
            } catch (Throwable th) {
                c.b("AndroidUtil", "failed to get application info and icon.", th);
                i2 = 17301586;
            }
            String str2 = "Jiguang提示：包名和AppKey不匹配";
            String str3 = "请到 Portal 上获取您的包名和AppKey并更新AndroidManifest相应字段";
            long currentTimeMillis = System.currentTimeMillis();
            if (VERSION.SDK_INT >= 11) {
                notification = new Builder(context.getApplicationContext()).setContentTitle(str2).setContentText(str3).setContentIntent(broadcast).setSmallIcon(i2).setTicker(str).setWhen(currentTimeMillis).getNotification();
                notification.flags = 34;
            } else {
                Notification notification2 = new Notification(i2, str, currentTimeMillis);
                notification2.flags = 34;
                try {
                    Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification2, new Object[]{context, str2, str3, broadcast});
                } catch (Exception unused) {
                }
                notification = notification2;
            }
            if (notification != null) {
                notificationManager.notify(str.hashCode(), notification);
            }
            return;
        }
        new Handler(Looper.getMainLooper()).post(new b(context, str));
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            c.d("AndroidUtil", "Bundle should not be null for sendBroadcast.");
            return;
        }
        Intent intent = new Intent(str);
        try {
            bundle.putString(JPushInterface.EXTRA_APP_KEY, cn.jiguang.d.a.b(context));
            intent.putExtras(bundle);
            String packageName = context.getPackageName();
            intent.addCategory(packageName);
            intent.setPackage(packageName);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("sendBroadcast error:");
            stringBuilder.append(th.getMessage());
            stringBuilder.append(",action:");
            stringBuilder.append(str);
            c.c("AndroidUtil", stringBuilder.toString());
            b(context, intent, null);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        if (str2 != null) {
            bundle.putString(str2, str3);
        }
        a(context, str, bundle);
    }

    private static boolean a(Context context, Class<?> cls) {
        boolean isEmpty;
        try {
            isEmpty = context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty() ^ true;
            if (!isEmpty) {
                try {
                    if (a(context, context.getPackageName(), (Class) cls) != null) {
                        return true;
                    }
                    isEmpty = false;
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return isEmpty;
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        throw new IllegalArgumentException("empty params");
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str2);
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.name.equals(str)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasReceiverIntentFilterPackage error:");
            stringBuilder.append(th.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasServiceIntentFilter error:");
            stringBuilder.append(th.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
            return false;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4) {
        return (i.a(str3) || i.a(str4)) ? str.equals(str2) : str.equals(str2) && str3.equalsIgnoreCase(str4);
    }

    public static long b(byte[] bArr) {
        long j = 0;
        if (bArr != null) {
            if (bArr.length < 6) {
                return 0;
            }
            int i = 0;
            while (i < 8) {
                i++;
                j = (j << 8) + ((long) (bArr[4 + i] & 255));
            }
        }
        return j;
    }

    private static ComponentInfo b(Context context, Class<?> cls) {
        try {
            List queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context, cls), 0);
            return queryIntentServices.isEmpty() ? a(context, context.getPackageName(), (Class) cls) : ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String b(Context context, String str) {
        String t = t(context);
        String u = !i.e(t) ? u(context) : t;
        return !i.e(u) ? str : u;
    }

    public static String b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b(Context context, Intent intent, String str) {
        str = intent.getAction();
        if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(str)) {
            List<String> a = a(context, intent, null);
            if (a.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder("sendBroadcast failed again: receiver not found, action:");
                stringBuilder.append(str);
                c.c("AndroidUtil", stringBuilder.toString());
            } else {
                for (String componentName : a) {
                    try {
                        Intent intent2 = (Intent) intent.clone();
                        intent2.setComponent(new ComponentName(context.getPackageName(), componentName));
                        if (TextUtils.isEmpty(null)) {
                            context.sendBroadcast(intent2);
                        } else {
                            context.sendBroadcast(intent2, null);
                        }
                    } catch (Exception e) {
                        StringBuilder stringBuilder2 = new StringBuilder("sendBroadcast failed again:");
                        stringBuilder2.append(e.getMessage());
                        stringBuilder2.append(", action:");
                        stringBuilder2.append(str);
                        c.c("AndroidUtil", stringBuilder2.toString());
                    }
                }
            }
        }
    }

    public static boolean b(Context context) {
        try {
            String h = h(context, PushService.class.getCanonicalName());
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static ProviderInfo c(Context context) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getApplicationContext(), DataProvider.class), 1, 1);
        } catch (Throwable unused) {
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            if (packageInfo == null || packageInfo.providers == null) {
                return null;
            }
            for (ProviderInfo providerInfo : packageInfo.providers) {
                if (providerInfo.name.equals(DataProvider.class.getName())) {
                    break;
                }
            }
            ProviderInfo providerInfo2 = null;
            if (providerInfo2 == null) {
                return null;
            }
            if (!providerInfo2.multiprocess) {
                return providerInfo2;
            }
            c.d("AndroidUtil", "DataProvider:should set multiprocess to false!");
            return null;
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static String c(Context context, String str) {
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return a(str.getBytes("utf-8"));
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static boolean c() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int d(String str) {
        String[] split = str.split("\\.");
        return ((Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8)) + Integer.parseInt(split[2]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    private static java.lang.String d() {
        /*
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0009, Exception -> 0x000d }
        r0 = r0.getPath();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0009, Exception -> 0x000d }
        goto L_0x000e;
    L_0x0009:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x000d:
        r0 = 0;
    L_0x000e:
        r1 = cn.jiguang.g.i.a(r0);
        if (r1 != 0) goto L_0x0025;
    L_0x0014:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = "/data/";
        r1.append(r0);
        r0 = r1.toString();
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.d():java.lang.String");
    }

    public static String d(Context context, String str) {
        String deviceId;
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            deviceId = null;
        }
        return i.d(deviceId) ? deviceId : str;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static String e() {
        String d = d();
        if (d == null) {
            d = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d);
            stringBuilder.append(".push_deviceid");
            d = stringBuilder.toString();
        }
        if (i.a(d)) {
            c.d("AndroidUtil", "get device id  sd card file path fail");
            return null;
        }
        File file = new File(d);
        if (file.exists()) {
            try {
                ArrayList a = f.a(new FileInputStream(file));
                if (a.size() > 0) {
                    return (String) a.get(0);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "Unknown";
            }
            String typeName = activeNetworkInfo.getTypeName();
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (typeName == null) {
                return "Unknown";
            }
            if (!i.a(subtypeName)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(typeName);
                stringBuilder.append(",");
                stringBuilder.append(subtypeName);
                typeName = stringBuilder.toString();
            }
            return typeName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    public static String e(Context context, String str) {
        try {
            if (a(context, "android.permission.READ_PHONE_STATE")) {
                return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    private static boolean e(String str) {
        if (!i.d(str) || str.length() < 10) {
            return false;
        }
        int i = 0;
        while (i < b.size()) {
            if (str.equals(b.get(i)) || str.startsWith((String) b.get(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A:{RETURN} */
    public static int f(android.content.Context r3) {
        /*
        r0 = -1;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new android.content.IntentFilter;
        r2 = "android.intent.action.BATTERY_CHANGED";
        r1.<init>(r2);
        r2 = 0;
        r3 = r3.registerReceiver(r2, r1);	 Catch:{ SecurityException -> 0x0016, Exception -> 0x0011 }
        goto L_0x001b;
    L_0x0011:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x001a;
    L_0x0016:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x001a:
        r3 = r2;
    L_0x001b:
        if (r3 != 0) goto L_0x001e;
    L_0x001d:
        return r0;
    L_0x001e:
        r1 = "status";
        r1 = r3.getIntExtra(r1, r0);
        r2 = 2;
        if (r1 == r2) goto L_0x002d;
    L_0x0027:
        r2 = 5;
        if (r1 != r2) goto L_0x002b;
    L_0x002a:
        goto L_0x002d;
    L_0x002b:
        r1 = 0;
        goto L_0x002e;
    L_0x002d:
        r1 = 1;
    L_0x002e:
        if (r1 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r1 = "plugged";
        r3 = r3.getIntExtra(r1, r0);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.f(android.content.Context):int");
    }

    private static String f(String str) {
        String d = d();
        if (i.a(d)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(".push_deviceid");
        f.a(new File(stringBuilder.toString()), str);
        return str;
    }

    public static void f(Context context, String str) {
        if (!i.a(str)) {
            n(context, str);
            l(context, str);
            d.a(context, str);
        }
    }

    private static int g(String str) {
        return (i.a(str) || Pattern.matches("[0]*", str)) ? 0 : Pattern.matches("[0-9]{15}", str) ? 1 : Pattern.matches("[a-f0-9A-F]{14}", str) ? 2 : 0;
    }

    public static ApplicationInfo g(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g(Context context) {
        String b = cn.jiguang.d.a.a.b(context);
        if (e(b)) {
            return b;
        }
        b = x(context);
        cn.jiguang.d.a.a.f(context, b);
        return b;
    }

    public static String h(Context context) {
        String string;
        String str = "";
        try {
            string = Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception | SecurityException unused) {
            string = str;
        }
        return i.d(string) ? string : "";
    }

    public static String h(Context context, String str) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128).processName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i(Context context) {
        String b = d.b(context);
        if (i.d(b)) {
            a = c.d - 1;
            return b;
        }
        b = m(context, b);
        if (i.d(b)) {
            a = c.b - 1;
            l(context, b);
            d.a(context, b);
            return b;
        }
        String str = null;
        if (c() && a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (VERSION.SDK_INT < 23 || (a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && a(context, "android.permission.READ_EXTERNAL_STORAGE")))) {
            str = e();
        }
        if (i.d(str)) {
            a = c.c - 1;
            n(context, str);
            d.a(context, str);
            return str;
        }
        b = "";
        if (VERSION.SDK_INT < 23) {
            b = d(context, str);
        }
        String h = h(context);
        str = b(context, "");
        String uuid = UUID.randomUUID().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(h);
        stringBuilder.append(str);
        stringBuilder.append(uuid);
        b = a(stringBuilder.toString());
        if (i.a(b)) {
            b = uuid;
        }
        d.a(context, b);
        a = c.a - 1;
        n(context, b);
        l(context, b);
        return b;
    }

    public static boolean i(Context context, String str) {
        if (i.a(str)) {
            return false;
        }
        try {
            if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean j(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        if (i.a(str)) {
            return false;
        }
        if (str.startsWith("/system/app/")) {
            return true;
        }
        if (str.startsWith("/data/app/")) {
        }
        return false;
    }

    private static boolean j(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("empty params");
        }
        try {
            context.getPackageManager().getPermissionInfo(str, 128);
            return true;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasPermissionDefined error:");
            stringBuilder.append(th.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
            return false;
        }
    }

    public static void k(Context context) {
        long g = (long) (cn.jiguang.d.a.a.g() * 1000);
        long currentTimeMillis = System.currentTimeMillis() + g;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        try {
            if (VERSION.SDK_INT >= 19) {
                alarmManager.setWindow(0, currentTimeMillis, 0, broadcast);
            } else {
                alarmManager.setInexactRepeating(0, currentTimeMillis, g, broadcast);
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("can't trigger alarm cause by exception:");
            stringBuilder.append(e.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
        }
    }

    private static boolean k(Context context, String str) {
        try {
            context.getPackageManager().getReceiverInfo(new ComponentName(context.getPackageName(), str), 128);
            return true;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasReceiver error:");
            stringBuilder.append(th.getMessage());
            c.c("AndroidUtil", stringBuilder.toString());
            return false;
        }
    }

    /* JADX WARNING: Missing block: B:16:0x0031, code skipped:
            return null;
     */
    private static java.lang.String l(android.content.Context r3, java.lang.String r4) {
        /*
        r0 = c();
        r1 = 0;
        if (r0 == 0) goto L_0x0031;
    L_0x0007:
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r0 = a(r3, r0);
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        if (r0 >= r2) goto L_0x001b;
    L_0x0016:
        r3 = f(r4);
        return r3;
    L_0x001b:
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r0 = a(r3, r0);
        if (r0 == 0) goto L_0x0031;
    L_0x0023:
        r0 = "android.permission.READ_EXTERNAL_STORAGE";
        r3 = a(r3, r0);
        if (r3 != 0) goto L_0x002c;
    L_0x002b:
        return r1;
    L_0x002c:
        r3 = f(r4);
        return r3;
    L_0x0031:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.l(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void l(Context context) {
        try {
            ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, AlarmReceiver.class), 0));
        } catch (Exception unused) {
        }
    }

    private static String m(Context context, String str) {
        if (a(context, "android.permission.WRITE_SETTINGS")) {
            try {
                return System.getString(context.getContentResolver(), "devcie_id_generated");
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Missing block: B:24:0x0063, code skipped:
            if (r4.equals(r2) != false) goto L_0x004f;
     */
    public static void m(android.content.Context r11) {
        /*
        r0 = cn.jiguang.d.a.a.s();
        r1 = r0.d();
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r1 = r0.a();
        r2 = r0.b();
        r0 = r0.c();
        r3 = "";
        r3 = d(r11, r3);
        r4 = h(r11);
        r5 = cn.jiguang.g.i.a(r4);
        if (r5 == 0) goto L_0x0029;
    L_0x0027:
        r4 = " ";
    L_0x0029:
        r5 = "";
        r5 = b(r11, r5);
        r6 = cn.jiguang.g.i.a(r5);
        if (r6 == 0) goto L_0x0037;
    L_0x0035:
        r5 = " ";
    L_0x0037:
        r6 = g(r1);
        r7 = g(r3);
        r8 = 0;
        r9 = 1;
        if (r6 == 0) goto L_0x0066;
    L_0x0043:
        if (r7 != 0) goto L_0x0046;
    L_0x0045:
        goto L_0x0066;
    L_0x0046:
        r10 = 2;
        if (r9 != r6) goto L_0x004b;
    L_0x0049:
        if (r10 == r7) goto L_0x004f;
    L_0x004b:
        if (r10 != r6) goto L_0x0051;
    L_0x004d:
        if (r9 != r7) goto L_0x0051;
    L_0x004f:
        r8 = r9;
        goto L_0x006a;
    L_0x0051:
        if (r6 != r7) goto L_0x006a;
    L_0x0053:
        r6 = r3.equals(r1);
        if (r6 == 0) goto L_0x0066;
    L_0x0059:
        r0 = r3.equals(r1);
        if (r0 == 0) goto L_0x006a;
    L_0x005f:
        r0 = r4.equals(r2);
        if (r0 == 0) goto L_0x006a;
    L_0x0065:
        goto L_0x004f;
    L_0x0066:
        r8 = a(r4, r2, r5, r0);
    L_0x006a:
        if (r8 != 0) goto L_0x006f;
    L_0x006c:
        n(r11);
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.m(android.content.Context):void");
    }

    private static String n(Context context, String str) {
        if (a(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (System.putString(context.getContentResolver(), "devcie_id_generated", str)) {
                    return str;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void n(Context context) {
        d.g(context);
        n(context, "");
        l(context, "");
        e.d().b(context);
    }

    public static boolean o(Context context) {
        String a = j.a(context, "ro.product.brand");
        String a2 = j.a(context, "ro.miui.ui.version.name");
        if (!(TextUtils.isEmpty(a) || !"Xiaomi".equals(a) || TextUtils.isEmpty(a2))) {
            String a3 = j.a(context, "ro.build.version.incremental");
            if (!TextUtils.isEmpty(a3) && a3.startsWith("V7.1")) {
                return false;
            }
        }
        return true;
    }

    public static double p(Context context) {
        double pow;
        int i;
        Point point = new Point();
        boolean z = context instanceof Activity;
        if (z) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else if (VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            pow = Math.pow((double) (((float) point.x) / displayMetrics.xdpi), 2.0d);
            i = point.y;
        } else {
            pow = Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d);
            i = displayMetrics.heightPixels;
        }
        return Math.sqrt(pow + Math.pow((double) (((float) i) / displayMetrics.ydpi), 2.0d));
    }

    public static boolean q(Context context) {
        if (f == null) {
            String str;
            try {
                context.getPackageManager().setComponentEnabledSetting(new ComponentName(context.getApplicationContext(), PushService.class), 1, 1);
            } catch (Throwable unused) {
            }
            ComponentInfo b = b(context, PushService.class);
            if (b != null) {
                f = Boolean.valueOf(true);
                str = b.processName;
            } else {
                f = Boolean.valueOf(false);
                str = "";
            }
            g = str;
        }
        return f.booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0133  */
    public static int r(android.content.Context r5) {
        /*
        r0 = "AndroidUtil";
        r1 = "action:checkValidManifest";
        cn.jiguang.e.c.a(r0, r1);
        r0 = cn.jiguang.d.d.f.a();
        r0 = r0.f();
        r1 = 0;
        if (r0 == 0) goto L_0x014e;
    L_0x0012:
        r0 = q(r5);
        if (r0 != 0) goto L_0x0033;
    L_0x0018:
        r5 = "AndroidUtil";
        r0 = new java.lang.StringBuilder;
        r1 = "AndroidManifest.xml missing required service: ";
        r0.<init>(r1);
        r1 = cn.jpush.android.service.PushService.class;
        r1 = r1.getCanonicalName();
        r0.append(r1);
        r0 = r0.toString();
        cn.jiguang.e.c.d(r5, r0);
        r5 = 4;
        return r5;
    L_0x0033:
        r0 = c(r5);
        if (r0 != 0) goto L_0x0054;
    L_0x0039:
        r5 = "AndroidUtil";
        r0 = new java.lang.StringBuilder;
        r1 = "AndroidManifest.xml missing required ContentProvider: ";
        r0.<init>(r1);
        r1 = cn.jpush.android.service.DataProvider.class;
        r1 = r1.getCanonicalName();
        r0.append(r1);
        r0 = r0.toString();
        cn.jiguang.e.c.d(r5, r0);
        r5 = 5;
        return r5;
    L_0x0054:
        r2 = g;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x006d;
    L_0x005c:
        r2 = g;
        r0 = r0.processName;
        r0 = r2.equals(r0);
        if (r0 != 0) goto L_0x006d;
    L_0x0066:
        r0 = "AndroidUtil";
        r2 = "We recommend DataProvider's process same as PushService";
        cn.jiguang.e.c.c(r0, r2);
    L_0x006d:
        r0 = cn.jpush.android.service.DaemonService.class;
        r0 = b(r5, r0);
        r2 = 1;
        if (r0 != 0) goto L_0x0093;
    L_0x0076:
        r0 = "AndroidUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "AndroidManifest.xml missing required service: ";
        r3.<init>(r4);
        r4 = cn.jpush.android.service.DaemonService.class;
        r4 = r4.getCanonicalName();
    L_0x0085:
        r3.append(r4);
        r3 = r3.toString();
        cn.jiguang.e.c.c(r0, r3);
        cn.jiguang.api.JCoreInterface.setCanLaunchedStoppedService(r1);
        goto L_0x00ae;
    L_0x0093:
        r0 = cn.jiguang.api.JCoreInterface.getDaemonAction();
        r0 = a(r5, r0, r2);
        if (r0 != 0) goto L_0x00ab;
    L_0x009d:
        r0 = "AndroidUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "AndroidManifest.xml missing intent filter for DaemonService: ";
        r3.<init>(r4);
        r4 = cn.jiguang.api.JCoreInterface.getDaemonAction();
        goto L_0x0085;
    L_0x00ab:
        cn.jiguang.api.JCoreInterface.setCanLaunchedStoppedService(r2);
    L_0x00ae:
        r0 = cn.jiguang.d.a.d.i(r5);
        if (r0 != 0) goto L_0x0118;
    L_0x00b4:
        cn.jiguang.d.b.a.a(r5, r2);
        r0 = cn.jpush.android.service.AlarmReceiver.class;
        r0 = a(r5, r0);
        if (r0 != 0) goto L_0x00da;
    L_0x00bf:
        r5 = "AndroidUtil";
        r0 = new java.lang.StringBuilder;
        r1 = "AndroidManifest.xml missing required receiver: ";
        r0.<init>(r1);
        r1 = cn.jpush.android.service.AlarmReceiver.class;
        r1 = r1.getCanonicalName();
        r0.append(r1);
        r0 = r0.toString();
        cn.jiguang.e.c.d(r5, r0);
        r5 = 7;
        return r5;
    L_0x00da:
        r0 = cn.jpush.android.service.PushReceiver.class;
        r0 = a(r5, r0);
        if (r0 != 0) goto L_0x0103;
    L_0x00e2:
        r0 = "AndroidUtil";
        r2 = new java.lang.StringBuilder;
        r3 = "AndroidManifest.xml missing required receiver: ";
        r2.<init>(r3);
        r3 = cn.jpush.android.service.PushReceiver.class;
        r3 = r3.getCanonicalName();
        r2.append(r3);
        r2 = r2.toString();
        cn.jiguang.e.c.d(r0, r2);
        r0 = B(r5);
        if (r0 != 0) goto L_0x0103;
    L_0x0101:
        r5 = 6;
        return r5;
    L_0x0103:
        r0 = cn.jpush.android.service.PushReceiver.class;
        r0 = r0.getCanonicalName();
        r2 = "android.intent.action.BOOT_COMPLETED";
        r0 = a(r5, r0, r2);
        if (r0 == 0) goto L_0x0118;
    L_0x0111:
        r0 = "AndroidUtil";
        r2 = "PushReceiver should not have intent filter -- android.intent.action.BOOT_COMPLETED, Please remove the intent filter in AndroidManifest.xml";
        cn.jiguang.e.c.c(r0, r2);
    L_0x0118:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r5.getPackageName();
        r0.append(r2);
        r2 = ".permission.JPUSH_MESSAGE";
        r0.append(r2);
        r0 = r0.toString();
        r2 = j(r5, r0);
        if (r2 != 0) goto L_0x0149;
    L_0x0133:
        r5 = "AndroidUtil";
        r1 = new java.lang.StringBuilder;
        r2 = "The permission should be defined - ";
        r1.<init>(r2);
        r1.append(r0);
        r0 = r1.toString();
        cn.jiguang.e.c.d(r5, r0);
        r5 = 8;
        return r5;
    L_0x0149:
        r2 = c;
        r2.add(r0);
    L_0x014e:
        r0 = c;
        r0 = r0.iterator();
    L_0x0154:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x017c;
    L_0x015a:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        r3 = a(r5, r2);
        if (r3 != 0) goto L_0x0154;
    L_0x0166:
        r5 = "AndroidUtil";
        r0 = new java.lang.StringBuilder;
        r1 = "The permissoin is required - ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        cn.jiguang.e.c.d(r5, r0);
        r5 = 9;
        return r5;
    L_0x017c:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        if (r0 >= r2) goto L_0x01a6;
    L_0x0182:
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r0 = a(r5, r0);
        if (r0 != 0) goto L_0x0194;
    L_0x018a:
        r5 = "AndroidUtil";
        r0 = "The permissoin is required - android.permission.WRITE_EXTERNAL_STORAGE";
        cn.jiguang.e.c.d(r5, r0);
        r5 = 10;
        return r5;
    L_0x0194:
        r0 = "android.permission.WRITE_SETTINGS";
        r0 = a(r5, r0);
        if (r0 != 0) goto L_0x01a6;
    L_0x019c:
        r5 = "AndroidUtil";
        r0 = "The permissoin is required - android.permission.WRITE_SETTINGS";
        cn.jiguang.e.c.d(r5, r0);
        r5 = 11;
        return r5;
    L_0x01a6:
        r0 = d;
        r0 = r0.iterator();
    L_0x01ac:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x01bc;
    L_0x01b2:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        a(r5, r2);
        goto L_0x01ac;
    L_0x01bc:
        r0 = e;
        r0 = r0.iterator();
    L_0x01c2:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x01d2;
    L_0x01c8:
        r2 = r0.next();
        r2 = (java.lang.String) r2;
        a(r5, r2);
        goto L_0x01c2;
    L_0x01d2:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.r(android.content.Context):int");
    }

    public static void s(Context context) {
        if (h != null && !k(context, PushReceiver.class.getCanonicalName())) {
            try {
                context.unregisterReceiver(h);
                h = null;
            } catch (Exception unused) {
            }
        }
    }

    private static String t(Context context) {
        String str = "";
        if (VERSION.SDK_INT < 23 && a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                return ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007b  */
    private static java.lang.String u(android.content.Context r10) {
        /*
        r0 = "";
        r1 = 0;
        r2 = "android.permission.ACCESS_WIFI_STATE";
        r2 = a(r10, r2);	 Catch:{ Exception -> 0x0078 }
        if (r2 == 0) goto L_0x001c;
    L_0x000b:
        r10 = r10.getApplicationContext();	 Catch:{ Exception -> 0x0078 }
        r2 = "wifi";
        r10 = r10.getSystemService(r2);	 Catch:{ Exception -> 0x0078 }
        r10 = (android.net.wifi.WifiManager) r10;	 Catch:{ Exception -> 0x0078 }
        r10 = r10.isWifiEnabled();	 Catch:{ Exception -> 0x0078 }
        goto L_0x001d;
    L_0x001c:
        r10 = r1;
    L_0x001d:
        r2 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Exception -> 0x0079 }
    L_0x0021:
        r3 = r2.hasMoreElements();	 Catch:{ Exception -> 0x0079 }
        if (r3 == 0) goto L_0x0079;
    L_0x0027:
        r3 = r2.nextElement();	 Catch:{ Exception -> 0x0079 }
        r3 = (java.net.NetworkInterface) r3;	 Catch:{ Exception -> 0x0079 }
        r4 = "wlan0";
        r5 = r3.getName();	 Catch:{ Exception -> 0x0079 }
        r4 = r4.equalsIgnoreCase(r5);	 Catch:{ Exception -> 0x0079 }
        if (r4 == 0) goto L_0x0021;
    L_0x0039:
        r3 = r3.getHardwareAddress();	 Catch:{ Exception -> 0x0079 }
        if (r3 == 0) goto L_0x0021;
    L_0x003f:
        r4 = r3.length;	 Catch:{ Exception -> 0x0079 }
        if (r4 == 0) goto L_0x0021;
    L_0x0042:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0079 }
        r2.<init>();	 Catch:{ Exception -> 0x0079 }
        r4 = r3.length;	 Catch:{ Exception -> 0x0079 }
        r5 = r1;
    L_0x0049:
        r6 = 1;
        if (r5 >= r4) goto L_0x0064;
    L_0x004c:
        r7 = r3[r5];	 Catch:{ Exception -> 0x0079 }
        r8 = java.util.Locale.ENGLISH;	 Catch:{ Exception -> 0x0079 }
        r9 = "%02x:";
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0079 }
        r7 = java.lang.Byte.valueOf(r7);	 Catch:{ Exception -> 0x0079 }
        r6[r1] = r7;	 Catch:{ Exception -> 0x0079 }
        r6 = java.lang.String.format(r8, r9, r6);	 Catch:{ Exception -> 0x0079 }
        r2.append(r6);	 Catch:{ Exception -> 0x0079 }
        r5 = r5 + 1;
        goto L_0x0049;
    L_0x0064:
        r3 = r2.length();	 Catch:{ Exception -> 0x0079 }
        if (r3 <= 0) goto L_0x0072;
    L_0x006a:
        r3 = r2.length();	 Catch:{ Exception -> 0x0079 }
        r3 = r3 - r6;
        r2.deleteCharAt(r3);	 Catch:{ Exception -> 0x0079 }
    L_0x0072:
        r2 = r2.toString();	 Catch:{ Exception -> 0x0079 }
        r0 = r2;
        goto L_0x0079;
    L_0x0078:
        r10 = r1;
    L_0x0079:
        if (r10 != 0) goto L_0x00ac;
    L_0x007b:
        r10 = cn.jiguang.d.a.a.p();
        r2 = android.text.TextUtils.isEmpty(r10);
        if (r2 != 0) goto L_0x00a8;
    L_0x0085:
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x00a8;
    L_0x008b:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r0.toLowerCase();
        r1.append(r2);
        r2 = android.os.Build.MODEL;
        r1.append(r2);
        r1 = r1.toString();
        r1 = a(r1);
        r1 = r10.equals(r1);
    L_0x00a8:
        if (r1 != 0) goto L_0x00ac;
    L_0x00aa:
        r0 = "";
    L_0x00ac:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.u(android.content.Context):java.lang.String");
    }

    private static String v(Context context) {
        try {
            String b = b(context, "");
            if (b == null || b.equals("")) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.toLowerCase());
            stringBuilder.append(Build.MODEL);
            return a(stringBuilder.toString());
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, Splitter:B:14:0x005b, ExcHandler: NameNotFoundException | Throwable (unused java.lang.Throwable)} */
    private static boolean w(android.content.Context r11) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = new javax.security.auth.x500.X500Principal;	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r3 = "CN=Android Debug,O=Android,C=US";
        r2.<init>(r3);	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r3 = 3;
        r3 = new java.lang.String[r3];	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r4 = "CN=Android Debug";
        r3[r1] = r4;	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r4 = "O=Android";
        r3[r0] = r4;	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r4 = "C=US";
        r5 = 2;
        r3[r5] = r4;	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r4 = r11.getPackageManager();	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r11 = r11.getPackageName();	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r6 = 64;
        r11 = r4.getPackageInfo(r11, r6);	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r11 = r11.signatures;	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r4 = "X.509";
        r4 = java.security.cert.CertificateFactory.getInstance(r4);	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r6 = r11.length;	 Catch:{ NameNotFoundException | Throwable -> 0x007c, NameNotFoundException | Throwable -> 0x007c }
        r7 = r1;
        r8 = r7;
    L_0x0032:
        if (r7 >= r6) goto L_0x007a;
    L_0x0034:
        r9 = r11[r7];	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r10 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r9 = r9.toByteArray();	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r10.<init>(r9);	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r9 = r4.generateCertificate(r10);	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r9 = (java.security.cert.X509Certificate) r9;	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r10 = r9.getSubjectX500Principal();	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        r10 = r10.equals(r2);	 Catch:{ NameNotFoundException | Throwable -> 0x007a, NameNotFoundException | Throwable -> 0x007a }
        if (r10 != 0) goto L_0x0078;
    L_0x004f:
        r8 = 0;
        r9 = r9.getSubjectX500Principal();	 Catch:{ Exception -> 0x0059 }
        r9 = r9.getName();	 Catch:{ Exception -> 0x0059 }
        r8 = r9;
    L_0x0059:
        if (r8 == 0) goto L_0x0074;
    L_0x005b:
        r9 = r3[r1];	 Catch:{ NameNotFoundException | Throwable -> 0x0078, NameNotFoundException | Throwable -> 0x0078 }
        r9 = r8.contains(r9);	 Catch:{ NameNotFoundException | Throwable -> 0x0078, NameNotFoundException | Throwable -> 0x0078 }
        if (r9 == 0) goto L_0x0074;
    L_0x0063:
        r9 = r3[r0];	 Catch:{ NameNotFoundException | Throwable -> 0x0078, NameNotFoundException | Throwable -> 0x0078 }
        r9 = r8.contains(r9);	 Catch:{ NameNotFoundException | Throwable -> 0x0078, NameNotFoundException | Throwable -> 0x0078 }
        if (r9 == 0) goto L_0x0074;
    L_0x006b:
        r9 = r3[r5];	 Catch:{ NameNotFoundException | Throwable -> 0x0078, NameNotFoundException | Throwable -> 0x0078 }
        r8 = r8.contains(r9);	 Catch:{ NameNotFoundException | Throwable -> 0x0078, NameNotFoundException | Throwable -> 0x0078 }
        if (r8 == 0) goto L_0x0074;
    L_0x0073:
        return r0;
    L_0x0074:
        r7 = r7 + 1;
        r8 = r10;
        goto L_0x0032;
    L_0x0078:
        r0 = r10;
        return r0;
    L_0x007a:
        r0 = r8;
        return r0;
    L_0x007c:
        r0 = r1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.a.w(android.content.Context):boolean");
    }

    private static String x(Context context) {
        try {
            String d = d(context, "");
            if (e(d)) {
                return d;
            }
            d = h(context);
            if (e(d) && !"9774d56d682e549c".equals(d.toLowerCase(Locale.getDefault()))) {
                return d;
            }
            d = v(context);
            if (!e(d)) {
                d = y(context);
                if (d == null) {
                    d = " ";
                }
            }
            return e(d) ? d : "";
        } catch (Exception unused) {
            String y = y(context);
            return e(y) ? y : "";
        }
    }

    private static String y(Context context) {
        String string = context.getSharedPreferences("PrefsFile", 0).getString("key", null);
        if (!i.a(string)) {
            return string;
        }
        if (!c()) {
            return A(context);
        }
        string = cn.jiguang.d.a.a.a(context);
        if (TextUtils.isEmpty(string)) {
            if (VERSION.SDK_INT >= 23 && (!a(context, "android.permission.WRITE_EXTERNAL_STORAGE") || !a(context, "android.permission.READ_EXTERNAL_STORAGE"))) {
                return A(context);
            }
            string = z(context);
        }
        return string;
    }

    private static String z(Context context) {
        String d = d();
        File file = null;
        if (d == null) {
            d = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d);
            stringBuilder.append(".push_udid");
            d = stringBuilder.toString();
        }
        if (!i.a(d)) {
            file = new File(d);
        }
        d = f.b(file);
        if (TextUtils.isEmpty(d)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(System.currentTimeMillis());
            d = i.b(UUID.nameUUIDFromBytes(stringBuilder2.toString().getBytes()).toString());
            cn.jiguang.d.a.a.e(context, d);
            f.a(file, d);
            return d;
        }
        cn.jiguang.d.a.a.e(context, d);
        return d;
    }
}
