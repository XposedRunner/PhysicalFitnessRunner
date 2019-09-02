package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import cn.jiguang.net.HttpUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.e;
import java.util.Locale;

/* compiled from: ProGuard */
public class c {
    static String a;
    static String b;
    static String c;
    private static String d;
    private static String e;

    public static String a() {
        try {
            Context a = e.a();
            if (a == null) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo == null ? "" : connectionInfo.getMacAddress();
        } catch (SecurityException e) {
            f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e);
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        if (context == null) {
            return "";
        }
        d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(width);
            stringBuilder.append("x");
            stringBuilder.append(height);
            d = stringBuilder.toString();
        }
        return d;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static String b(Context context) {
        if (a != null && a.length() > 0) {
            return a;
        }
        if (context == null) {
            return "";
        }
        try {
            a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return a;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        if (b != null && b.length() > 0) {
            return b;
        }
        if (context == null) {
            return "";
        }
        try {
            b = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            return b;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        if (c != null && c.length() > 0) {
            return c;
        }
        if (context == null) {
            return "";
        }
        try {
            c = Secure.getString(context.getContentResolver(), "android_id");
            return c;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            if (e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("imei=");
                stringBuilder.append(b(context));
                stringBuilder.append('&');
                stringBuilder.append("model=");
                stringBuilder.append(Build.MODEL);
                stringBuilder.append('&');
                stringBuilder.append("os=");
                stringBuilder.append(VERSION.RELEASE);
                stringBuilder.append('&');
                stringBuilder.append("apilevel=");
                stringBuilder.append(VERSION.SDK_INT);
                stringBuilder.append('&');
                String b = a.b(context);
                if (b == null) {
                    b = "";
                }
                stringBuilder.append("network=");
                stringBuilder.append(b);
                stringBuilder.append('&');
                stringBuilder.append("sdcard=");
                stringBuilder.append(Environment.getExternalStorageState().equals("mounted"));
                stringBuilder.append('&');
                stringBuilder.append("display=");
                stringBuilder.append(displayMetrics.widthPixels);
                stringBuilder.append('*');
                stringBuilder.append(displayMetrics.heightPixels);
                stringBuilder.append('&');
                stringBuilder.append("manu=");
                stringBuilder.append(Build.MANUFACTURER);
                stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
                stringBuilder.append("wifi=");
                stringBuilder.append(a.e(context));
                e = stringBuilder.toString();
            }
            return e;
        } catch (Exception unused) {
            return null;
        }
    }
}
