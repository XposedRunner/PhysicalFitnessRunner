package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a;
import cn.jpush.android.api.DefaultPushNotificationBuilder;
import cn.jpush.android.api.c;
import cn.jpush.android.b;
import cn.jpush.android.c.d;
import cn.jpush.android.d.f;
import cn.jpush.client.android.BuildConfig;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceInterface {
    public static String a() {
        return BuildConfig.VERSION_NAME;
    }

    public static void a(Context context) {
        if (!d(context)) {
            JCoreInterface.restart(context, a.a, new Bundle(), false);
            d.a().a(context);
        }
    }

    public static void a(Context context, int i) {
        MultiSpHelper.commitInt(context, "service_stoped", 1);
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.STOPPUSH");
        bundle.putString("app", context.getPackageName());
        JCoreInterface.stop(context, a.a, bundle);
    }

    public static void a(Context context, Integer num, DefaultPushNotificationBuilder defaultPushNotificationBuilder) {
        if (context == null) {
            f.d("ServiceInterface", "Null context, please init JPush!");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num);
        b.a(context, stringBuilder.toString(), defaultPushNotificationBuilder.toString(), false);
    }

    public static void a(Context context, String str) {
        if (context != null && !d(context)) {
            b.a(context, str, false);
        }
    }

    public static void a(Context context, String str, Set<String> set, long j, cn.jpush.android.api.a aVar) {
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.ALIAS_TAGS");
        bundle.putString("alias", str);
        bundle.putStringArrayList("tags", set != null ? new ArrayList(set) : null);
        bundle.putLong("seq_id", j);
        str = "proto_type";
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append(aVar != null ? aVar.e : 0);
        bundle.putString(str, stringBuilder.toString());
        str = "protoaction_type";
        stringBuilder = new StringBuilder();
        if (aVar != null) {
            i = aVar.f;
        }
        stringBuilder.append(i);
        bundle.putString(str, stringBuilder.toString());
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static boolean a(Context context, int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("startHour", i);
            jSONObject.put("startMins", i2);
            jSONObject.put("endHour", i3);
            jSONObject.put("endtMins", i4);
            a(context, jSONObject.toString());
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static void b(Context context) {
        if (context == null) {
            f.c("ServiceInterface", "clearAllNotification - context is null!");
        } else {
            c.a(context.getApplicationContext(), false);
        }
    }

    public static void b(Context context, int i) {
        MultiSpHelper.commitInt(context, "service_stoped", 0);
        Bundle bundle = new Bundle();
        e.a(context, bundle, "intent.RESTOREPUSH");
        bundle.putString("app", context.getPackageName());
        JCoreInterface.restart(context, a.a, bundle, true);
    }

    public static void c(Context context, int i) {
        if (context == null) {
            f.c("ServiceInterface", "setNotificationNumber - context is null!");
        } else {
            b.a(context, i, false);
        }
    }

    public static boolean c(Context context) {
        return MultiSpHelper.getInt(context, "service_stoped", 0) > 0;
    }

    public static boolean d(Context context) {
        boolean c = c(context);
        if (c) {
            f.a("ServiceInterface", "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.");
        }
        return c;
    }
}
