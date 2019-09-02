package cn.jiguang.api;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.d.a.d;
import cn.jiguang.d.c;
import cn.jiguang.d.d.b;
import cn.jiguang.d.d.i;
import cn.jiguang.g.a.a;
import java.util.List;
import org.json.JSONObject;
import s.h.e.l.l.C;

public class JCoreInterface {
    public static String a = "cn.jpush.android.intent.DaemonService";

    static {
        C.i(0);
    }

    public static native void asyncExecute(Runnable runnable, int... iArr);

    public static boolean canCallDirect() {
        try {
            return a.c() && a.b().asBinder().pingBinder();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static native void execute(String str, Runnable runnable, int... iArr);

    public static native JSONObject fillBaseReport(JSONObject jSONObject, String str);

    public static native String getAccountId();

    public static native boolean getAesConfig();

    public static native String getAppKey();

    public static IBinder getBinderByType(String str, String str2) {
        if (a.c()) {
            try {
                return a.b().a(str, str2);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static native String getChannel();

    public static native String getCommonConfigAppkey();

    public static native boolean getConnectionState(Context context);

    public static native String getDaemonAction();

    public static native boolean getDebugMode();

    public static native String getDeviceId(Context context);

    public static native String getHttpConfig(Context context, String str);

    public static native int getJCoreSDKVersionInt();

    public static long getNextRid() {
        return !cn.jiguang.d.a.c(null) ? 0 : cn.jiguang.d.a.a.f();
    }

    public static native String getRegistrationID(Context context);

    public static long getReportTime() {
        return !cn.jiguang.d.a.c(null) ? System.currentTimeMillis() / 1000 : cn.jiguang.d.a.a.q();
    }

    public static native boolean getRuningFlag();

    public static native int getSid();

    public static native boolean getTestConn();

    public static long getUid() {
        return !cn.jiguang.d.a.c(null) ? 0 : d.c(null);
    }

    public static boolean init(Context context, boolean z) {
        return cn.jiguang.d.a.d(context);
    }

    public static void initAction(String str, Class<? extends JAction> cls) {
        b.a(str, cls.getName());
    }

    public static void initActionExtra(String str, Class<? extends JActionExtra> cls) {
        b.b(str, cls.getName());
    }

    public static void initCrashHandler(Context context) {
        execute("SDK_MAIN", new c(context, 2), new int[0]);
    }

    public static native boolean isServiceStoped(Context context);

    public static native boolean isTcpConnected();

    public static native boolean isValidRegistered();

    public static native void onFragmentPause(Context context, String str);

    public static native void onFragmentResume(Context context, String str);

    public static native void onKillProcess(Context context);

    public static native void onPause(Context context);

    public static native void onResume(Context context);

    public static native void processCtrlReport(int i);

    public static native void putSingleExecutor(String str);

    public static native void register(Context context);

    public static native void report(Context context, JSONObject jSONObject, boolean z);

    public static native boolean reportHttpData(Context context, Object obj, String str);

    public static void requestPermission(Context context) {
        String str;
        String str2;
        if (context == null) {
            str = "JCoreInterface";
            str2 = "[requestPermission] context was null";
        } else if (context instanceof Activity) {
            if (VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
                try {
                    List a = cn.jiguang.g.a.a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION", "android.permission.READ_PHONE_STATE"});
                    if (a != null && !a.isEmpty()) {
                        Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", new Class[]{String[].class, Integer.TYPE}).invoke(context, new Object[]{a.toArray(new String[a.size()]), Integer.valueOf(1)});
                        return;
                    }
                    return;
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder("#unexcepted - requestPermission e:");
                    stringBuilder.append(e.getMessage());
                    cn.jiguang.e.c.c("JCoreInterface", stringBuilder.toString());
                }
            }
            return;
        } else {
            str = "JCoreInterface";
            str2 = "[requestPermission] context must instanceof Activity";
        }
        cn.jiguang.e.c.c(str, str2);
    }

    public static void restart(Context context, String str, Bundle bundle, boolean z) {
        if (context == null) {
            cn.jiguang.e.c.c("JCoreInterface", "unexcepted - context was null");
            return;
        }
        try {
            bundle.putString("sdktype", str);
            i.a().b(context, z ? "intent.RESTOREPUSH" : "intent.INIT", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "restart failed", th);
        }
    }

    public static void sendAction(Context context, String str, Bundle bundle) {
        try {
            bundle.putString("sdktype", str);
            i.a().b(context, "run.action", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "sendAction failed", th);
        }
    }

    public static void sendData(Context context, String str, int i, byte[] bArr) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", str);
            bundle.putByteArray("datas", bArr);
            bundle.putInt("cmd", i);
            i.a().b(context, "senddata.action", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "sendData failed", th);
        }
    }

    public static void sendRequestData(Context context, String str, int i, byte[] bArr) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", str);
            bundle.putByteArray("datas", bArr);
            bundle.putInt("timeout", i);
            i.a().b(context, "sendrequestdata.action", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "sendRequestData failed", th);
        }
    }

    public static native void setAccountId(String str);

    public static native void setAnalysisAction(JAnalyticsAction jAnalyticsAction);

    public static native void setCanLaunchedStoppedService(boolean z);

    public static native void setDaemonAction(String str);

    public static native void setDebugMode(boolean z);

    public static native void setImLBSEnable(Context context, boolean z);

    public static native void setLocationReportDelay(Context context, long j);

    public static native void setLogEnable(boolean z);

    public static void setPowerSaveMode(Context context, boolean z) {
        if (cn.jiguang.d.a.c(null)) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("sdktype", cn.jiguang.d.a.a);
                bundle.putBoolean("key_power_save", z);
                i.a().b(context, "intent.power.save", bundle);
            } catch (Throwable th) {
                cn.jiguang.e.c.c("JCoreInterface", "setDozeAndPowerEnable to pushservice error", th);
            }
        } else if (context == null) {
            cn.jiguang.e.c.c("JCoreInterface", "context is null,setDozeAndPowerEnable failed");
        } else {
            d.d(context, z);
        }
    }

    public static native void setTestConn(boolean z);

    public static native void setTestConnIPPort(String str, int i);

    public static Bundle si(Context context, int i, Bundle bundle) {
        cn.jiguang.d.a.a(context);
        return cn.jiguang.d.d.a(context, i, bundle);
    }

    public static void stop(Context context, String str, Bundle bundle) {
        try {
            bundle.putString("sdktype", str);
            i.a().b(context, "intent.STOPPUSH", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "stop failed", th);
        }
    }

    public static native void stopCrashHandler(Context context);

    public static native void testCountryCode(String str);

    public static void triggerSceneCheck(Context context, int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("sdktype", cn.jiguang.d.a.a);
            bundle.putInt("key_trigger_scene", i);
            i.a().b(context, "cn.jpush.android.intent.check.notification.state", bundle);
        } catch (Throwable th) {
            cn.jiguang.e.c.c("JCoreInterface", "triggerSceneCheck to pushservice error", th);
        }
    }
}
