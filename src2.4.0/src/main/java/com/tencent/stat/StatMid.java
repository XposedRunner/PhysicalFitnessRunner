package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.k;

public class StatMid {
    private static StatLogger a = k.b();
    private static DeviceInfo b;

    static synchronized DeviceInfo a(Context context) {
        DeviceInfo b;
        synchronized (StatMid.class) {
            try {
                a a = a.a(context);
                DeviceInfo a2 = a(a.d(DeviceInfo.TAG_FLAG, null));
                StatLogger statLogger = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("get device info from internal storage:");
                stringBuilder.append(a2);
                statLogger.d(stringBuilder.toString());
                DeviceInfo a3 = a(a.f(DeviceInfo.TAG_FLAG, null));
                StatLogger statLogger2 = a;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("get device info from setting.system:");
                stringBuilder2.append(a3);
                statLogger2.d(stringBuilder2.toString());
                DeviceInfo a4 = a(a.b(DeviceInfo.TAG_FLAG, null));
                StatLogger statLogger3 = a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get device info from SharedPreference:");
                stringBuilder.append(a4);
                statLogger3.d(stringBuilder.toString());
                b = a(a4, a3, a2);
                if (b == null) {
                    b = new DeviceInfo();
                }
                b = n.a(context).b(context);
                if (b != null) {
                    b.d(b.getImei());
                    b.e(b.getMac());
                    b.b(b.getUserType());
                }
            } catch (Throwable th) {
                a.e(th);
            }
            b = b;
        }
        return b;
    }

    static DeviceInfo a(DeviceInfo deviceInfo, DeviceInfo deviceInfo2) {
        return (deviceInfo == null || deviceInfo2 == null) ? deviceInfo != null ? deviceInfo : deviceInfo2 != null ? deviceInfo2 : null : deviceInfo.a(deviceInfo2) >= 0 ? deviceInfo : deviceInfo2;
    }

    static DeviceInfo a(DeviceInfo deviceInfo, DeviceInfo deviceInfo2, DeviceInfo deviceInfo3) {
        return a(a(deviceInfo, deviceInfo2), a(deviceInfo2, deviceInfo3));
    }

    private static DeviceInfo a(String str) {
        return str != null ? DeviceInfo.a(k.d(str)) : null;
    }

    public static DeviceInfo getDeviceInfo(Context context) {
        if (context == null) {
            a.error((Object) "Context for StatConfig.getDeviceInfo is null.");
            return null;
        }
        if (b == null) {
            a(context);
        }
        return b;
    }

    public static String getMid(Context context) {
        if (b == null) {
            getDeviceInfo(context);
        }
        return b.getMid();
    }

    public static void updateDeviceInfo(Context context, String str) {
        try {
            getDeviceInfo(context);
            b.c(str);
            b.a(b.a() + 1);
            b.a(System.currentTimeMillis());
            str = b.c().toString();
            StatLogger statLogger = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("save DeviceInfo:");
            stringBuilder.append(str);
            statLogger.d(stringBuilder.toString());
            str = k.c(str).replace("\n", "");
            a a = a.a(context);
            a.c(DeviceInfo.TAG_FLAG, str);
            a.e(DeviceInfo.TAG_FLAG, str);
            a.a(DeviceInfo.TAG_FLAG, str);
        } catch (Throwable th) {
            a.e(th);
        }
    }
}
