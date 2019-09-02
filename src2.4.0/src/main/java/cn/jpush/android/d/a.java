package cn.jpush.android.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.net.HttpUtils;
import cn.jpush.android.a.e;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.b;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.open.SocialConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static Intent a(Context context, b bVar, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("isUpdateVersion", false);
        intent.putExtra("body", bVar);
        intent.setAction("cn.jpush.android.ui.PushActivity");
        intent.addCategory(context.getPackageName());
        intent.addFlags(536870912);
        if (!f(context) && VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        a(context, intent);
        return intent;
    }

    private static ComponentInfo a(Context context, String str, Class<?> cls) {
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
            f.c("AndroidUtil", stringBuilder.toString());
        }
    }

    public static String a(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append(",");
        stringBuilder.append(Integer.toString(VERSION.SDK_INT));
        String stringBuilder2 = stringBuilder.toString();
        String str2 = Build.MODEL;
        String a = i.a(context, "gsm.version.baseband", "baseband");
        String str3 = Build.DEVICE;
        Object channel = JCoreInterface.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = " ";
        }
        String e = e(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("androidSdkVersion", stringBuilder2);
            jSONObject.put("model", str2);
            jSONObject.put("baseband", a);
            jSONObject.put("device", str3);
            jSONObject.put(LogBuilder.KEY_CHANNEL, channel);
            jSONObject.put("network", e);
            jSONObject.put(SocialConstants.PARAM_URL, str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(2 * digest.length);
            for (byte b : digest) {
                stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
                stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static List<String> a(Context context, Intent intent, String str) {
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

    private static void a(Context context, Intent intent) {
        if (VERSION.SDK_INT < 21) {
            try {
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                    if (resolveInfo.activityInfo != null) {
                        String str = resolveInfo.activityInfo.name;
                        if (!TextUtils.isEmpty(str)) {
                            intent.setComponent(new ComponentName(context, str));
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, b bVar) {
        try {
            Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
            intent.putExtra(JPushInterface.EXTRA_APP_KEY, bVar.p);
            intent.putExtra(JPushInterface.EXTRA_MESSAGE, bVar.j);
            intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, bVar.k);
            intent.putExtra(JPushInterface.EXTRA_TITLE, bVar.m);
            intent.putExtra(JPushInterface.EXTRA_EXTRA, bVar.n);
            intent.putExtra(JPushInterface.EXTRA_MSG_ID, bVar.c);
            if (bVar.a()) {
                intent.putExtra(JPushInterface.EXTRA_RICHPUSH_FILE_PATH, bVar.I);
            }
            intent.addCategory(bVar.o);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", new Object[]{bVar.o}));
            if (bVar.e != (byte) 0) {
                e.a(bVar.c, "", bVar.e, PointerIconCompat.TYPE_ZOOM_IN, context);
            } else {
                e.a(bVar.c, PointerIconCompat.TYPE_ZOOM_IN, null, context);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            f.d("AndroidUtil", "Bundle should not be null for sendBroadcast.");
            return;
        }
        try {
            Intent intent = new Intent(str);
            bundle.putString(JPushInterface.EXTRA_APP_KEY, JCoreInterface.getAppKey());
            intent.putExtras(bundle);
            String packageName = context.getPackageName();
            intent.addCategory(packageName);
            intent.setPackage(packageName);
            context.sendBroadcast(intent, String.format(Locale.ENGLISH, "%s.permission.JPUSH_MESSAGE", new Object[]{packageName}));
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("sendBroadcast error:");
            stringBuilder.append(e.getMessage());
            stringBuilder.append(",action:");
            stringBuilder.append(str);
            f.c("AndroidUtil", stringBuilder.toString());
        }
    }

    public static void a(WebSettings webSettings) {
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName(HttpUtils.ENCODING_UTF_8);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        if (VERSION.SDK_INT >= 11) {
            webSettings.setDisplayZoomControls(false);
        }
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static void a(WebView webView) {
        try {
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            if (VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, Class<?> cls) {
        boolean isEmpty;
        Throwable th;
        StringBuilder stringBuilder;
        try {
            isEmpty = context.getPackageManager().queryBroadcastReceivers(new Intent(context, cls), 0).isEmpty() ^ true;
            if (!isEmpty) {
                try {
                    return a(context, context.getPackageName(), (Class) cls) != null;
                } catch (Throwable th2) {
                    th = th2;
                    stringBuilder = new StringBuilder("hasReceiverResolves error:");
                    stringBuilder.append(th.getMessage());
                    f.a("AndroidUtil", stringBuilder.toString());
                    return isEmpty;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            isEmpty = false;
            stringBuilder = new StringBuilder("hasReceiverResolves error:");
            stringBuilder.append(th.getMessage());
            f.a("AndroidUtil", stringBuilder.toString());
            return isEmpty;
        }
        return isEmpty;
    }

    public static boolean a(Context context, String str, boolean z) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return !packageManager.queryBroadcastReceivers(intent, 0).isEmpty();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasReceiverIntentFilter error:");
            stringBuilder.append(th.getMessage());
            f.a("AndroidUtil", stringBuilder.toString());
            return false;
        }
    }

    public static Intent b(Context context) {
        Intent launchIntentForPackage;
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getApplicationContext().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                f.c("AndroidUtil", "The package with the given name cannot be found!");
                return null;
            }
            launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage == null) {
                try {
                    f.c("AndroidUtil", "Can't get launch intent for this package!");
                    return null;
                } catch (Throwable unused) {
                    return launchIntentForPackage;
                }
            }
            int i = AMapEngineUtils.MAX_P20_WIDTH;
            if (VERSION.SDK_INT >= 11) {
                i = 268468224;
            }
            launchIntentForPackage.addFlags(i);
            return launchIntentForPackage;
        } catch (Throwable unused2) {
            launchIntentForPackage = null;
            return launchIntentForPackage;
        }
    }

    public static void b(Context context, Intent intent, String str) {
        String action = intent.getAction();
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action) || JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            List<String> a = a(context, intent, str);
            if (a.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder("sendBroadcast failed again: receiver not found, action:");
                stringBuilder.append(intent.getAction());
                f.c("AndroidUtil", stringBuilder.toString());
            } else {
                for (String componentName : a) {
                    try {
                        Intent intent2 = (Intent) intent.clone();
                        intent2.setComponent(new ComponentName(context.getPackageName(), componentName));
                        if (TextUtils.isEmpty(str)) {
                            context.sendBroadcast(intent2);
                        } else {
                            context.sendBroadcast(intent2, str);
                        }
                    } catch (Exception e) {
                        StringBuilder stringBuilder2 = new StringBuilder("sendBroadcast failed again:");
                        stringBuilder2.append(e.getMessage());
                        stringBuilder2.append(", action:");
                        stringBuilder2.append(intent.getAction());
                        f.c("AndroidUtil", stringBuilder2.toString());
                    }
                }
            }
        }
    }

    public static boolean b(Context context, Class<?> cls) {
        try {
            return !context.getPackageManager().queryIntentActivities(new Intent(context, cls), 0).isEmpty();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasActivityResolves error:");
            stringBuilder.append(th.getMessage());
            f.a("AndroidUtil", stringBuilder.toString());
            return false;
        }
    }

    public static boolean b(Context context, String str) {
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

    public static boolean c(Context context) {
        try {
            if (MultiSpHelper.getBoolean(context, "notification_enabled", true)) {
                String b = cn.jpush.android.b.b(context);
                if (TextUtils.isEmpty(b)) {
                    return true;
                }
                String[] split = b.split("_");
                String str = split[0];
                String str2 = split[1];
                char[] toCharArray = str.toCharArray();
                split = str2.split("\\^");
                Calendar instance = Calendar.getInstance();
                int i = instance.get(7);
                int i2 = instance.get(11);
                for (char valueOf : toCharArray) {
                    if (i == Integer.valueOf(String.valueOf(valueOf)).intValue() + 1) {
                        int intValue = Integer.valueOf(split[0]).intValue();
                        int intValue2 = Integer.valueOf(split[1]).intValue();
                        if (i2 >= intValue && i2 <= intValue2) {
                            return true;
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("Current time is out of the push time - ");
                stringBuilder.append(b);
                f.b("AndroidUtil", stringBuilder.toString());
                return false;
            }
            f.b("AndroidUtil", "Notification was disabled by JPushInterface.setPushTime !");
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean c(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            if (packageManager.queryIntentActivities(intent, 0).isEmpty()) {
                return false;
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("hasActivityIntentFilter error:");
            stringBuilder.append(th.getMessage());
            f.a("AndroidUtil", stringBuilder.toString());
        }
        return true;
    }

    public static void d(Context context, String str) {
        try {
            Intent b = b(context);
            if (b != null) {
                if (!TextUtils.isEmpty(str)) {
                    b.putExtra("extra", str);
                }
                context.startActivity(b);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("startMainActivity error:");
            stringBuilder.append(th.getMessage());
            f.a("AndroidUtil", stringBuilder.toString());
        }
    }

    public static boolean d(Context context) {
        String string = MultiSpHelper.getString(context, "setting_silence_push_time", "");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int optInt = jSONObject.optInt("startHour", -1);
            int optInt2 = jSONObject.optInt("startMins", -1);
            int optInt3 = jSONObject.optInt("endHour", -1);
            int optInt4 = jSONObject.optInt("endtMins", -1);
            if (optInt < 0 || optInt2 < 0 || optInt3 < 0 || optInt4 < 0 || optInt2 > 59 || optInt4 > 59 || optInt3 > 23 || optInt > 23) {
                return false;
            }
            Calendar instance = Calendar.getInstance();
            int i = instance.get(11);
            int i2 = instance.get(12);
            if (optInt < optInt3) {
                if ((i <= optInt || i >= optInt3) && ((i != optInt || i2 < optInt2) && (i != optInt3 || i2 > optInt4))) {
                    return false;
                }
            } else if (optInt == optInt3) {
                if (optInt2 >= optInt4) {
                    if (i == optInt && i2 > optInt4 && i2 < optInt2) {
                        return false;
                    }
                } else if (i != optInt || i2 < optInt2 || i2 > optInt4) {
                    return false;
                }
            } else if (optInt <= optInt3 || ((i <= optInt || i > 23) && ((i < 0 || i >= optInt3) && ((i != optInt || i2 < optInt2) && (i != optInt3 || i2 > optInt4))))) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder("Current time is in the range of silence time - ");
            stringBuilder.append(optInt);
            stringBuilder.append(":");
            stringBuilder.append(optInt2);
            stringBuilder.append(" ~ ");
            stringBuilder.append(optInt3);
            stringBuilder.append(":");
            stringBuilder.append(optInt4);
            f.b("AndroidUtil", stringBuilder.toString());
            return true;
        } catch (JSONException unused) {
        }
        return false;
    }

    private static String e(Context context) {
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
            if (!TextUtils.isEmpty(subtypeName)) {
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

    public static boolean e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
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

    private static boolean f(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
