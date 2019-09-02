package cn.jpush.android;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a.l;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.c;
import cn.jpush.android.service.e;

public final class b {
    public static int a(Context context) {
        return MultiSpHelper.getInt(context, "notification_num", JPushInterface.a);
    }

    public static String a(Context context, int i) {
        StringBuilder stringBuilder = new StringBuilder("pluginPlatformRegid");
        stringBuilder.append(i);
        return MultiSpHelper.getString(context, stringBuilder.toString(), null);
    }

    public static void a(Context context, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("pluginPlatformRegid");
        stringBuilder.append(i);
        MultiSpHelper.commitString(context, stringBuilder.toString(), str);
    }

    public static void a(Context context, int i, boolean z) {
        if (z) {
            int b = l.b();
            if (i < b) {
                c.a(context, b - i);
            }
            MultiSpHelper.commitInt(context, "notification_num", i);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 2);
        bundle.putInt("notification_maxnum", i);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (z || JCoreInterface.canCallDirect()) {
            StringBuilder stringBuilder = new StringBuilder("jpush_save_custom_builder");
            stringBuilder.append(str);
            MultiSpHelper.commitString(context, stringBuilder.toString(), str2);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 1);
        bundle.putString("notification_buidler_id", str);
        bundle.putString("notification_buidler", str2);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void a(Context context, String str, boolean z) {
        if (z || JCoreInterface.canCallDirect()) {
            MultiSpHelper.commitString(context, "setting_silence_push_time", str);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 4);
        bundle.putString("silence_push_time", str);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static String b(Context context) {
        return MultiSpHelper.getString(context, "setting_push_time", "");
    }

    public static void b(Context context, int i, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("pluginPlatformRegidupload");
        stringBuilder.append(i);
        MultiSpHelper.commitBoolean(context, stringBuilder.toString(), z);
    }

    public static void b(Context context, String str, boolean z) {
        if (z || JCoreInterface.canCallDirect()) {
            MultiSpHelper.commitString(context, "setting_push_time", str);
            return;
        }
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 3);
        bundle.putString("enable_push_time", str);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static boolean b(Context context, int i) {
        StringBuilder stringBuilder = new StringBuilder("pluginPlatformRegidupload");
        stringBuilder.append(i);
        return MultiSpHelper.getBoolean(context, stringBuilder.toString(), false);
    }
}
