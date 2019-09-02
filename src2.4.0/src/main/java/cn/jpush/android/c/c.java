package cn.jpush.android.c;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import cn.jpush.android.a;
import cn.jpush.android.a.e;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.d.f;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import org.json.JSONObject;

public final class c {
    public static b a(Context context, String str, String str2) {
        g gVar = new g();
        byte b = (byte) 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            gVar.c = jSONObject.optString("_jmsgid_");
            if (gVar.c.isEmpty()) {
                gVar.c = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            }
            gVar.e = (byte) jSONObject.optInt("rom_type");
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                gVar.v = optJSONObject.optString("n_content");
                gVar.u = optJSONObject.optString("n_title");
                gVar.n = optJSONObject.optString("n_extras");
                gVar.t = optJSONObject.optInt("n_flag", 1);
                jSONObject = optJSONObject.optJSONObject("rich_content");
                if (jSONObject != null) {
                    gVar.a(true);
                    gVar.a(jSONObject);
                    gVar.b = 3;
                } else {
                    gVar.b = 4;
                    gVar.S = -1;
                }
            } else {
                gVar.v = jSONObject.optString("n_content");
                gVar.u = jSONObject.optString("n_title");
                gVar.n = jSONObject.optString("n_extras");
                gVar.e = (byte) jSONObject.optInt("rom_type");
            }
            if (optInt != -1) {
                gVar.b = optInt;
            }
            gVar.q = 0;
            gVar.r = true;
            return gVar;
        } catch (Throwable unused) {
            str = "NO MSGID";
            if (!TextUtils.isEmpty(gVar.c)) {
                str = gVar.c;
                b = gVar.e;
            }
            e.a(str, str2, b, 996, context);
            return null;
        }
    }

    private static void a(Context context, b bVar, String str, int i) {
        if (!TextUtils.isEmpty(bVar.c)) {
            Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
            try {
                cn.jpush.android.api.c.a(intent, cn.jpush.android.api.c.a(bVar), i);
                intent.putExtra("sdktype", a.a);
                String packageName = TextUtils.isEmpty(bVar.o) ? context.getPackageName() : bVar.o;
                intent.addCategory(packageName);
                intent.setPackage(context.getPackageName());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(packageName);
                stringBuilder.append(".permission.JPUSH_MESSAGE");
                context.sendBroadcast(intent, stringBuilder.toString());
                e.a(bVar.c, str, bVar.e, 1000, context);
            } catch (Throwable th) {
                StringBuilder stringBuilder2 = new StringBuilder("onNotificationOpen sendBrocat error:");
                stringBuilder2.append(th.getMessage());
                f.c("PluginPlatformsNotificationHelper", stringBuilder2.toString());
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(context.getPackageName());
                stringBuilder3.append(".permission.JPUSH_MESSAGE");
                cn.jpush.android.d.a.b(context, intent, stringBuilder3.toString());
            }
        }
    }

    public static void a(Context context, String str, String str2, int i, byte b, boolean z) {
        String str3;
        if (context == null) {
            str3 = "PluginPlatformsNotificationHelper";
            str = "context was null";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "PluginPlatformsNotificationHelper";
            str = "content was null";
        } else {
            b a = a(context, str, str2);
            if (a == null) {
                str3 = "PluginPlatformsNotificationHelper";
                str = "entity was null";
            } else if (TextUtils.isEmpty(a.c)) {
                str3 = "PluginPlatformsNotificationHelper";
                str = "message id was empty";
            } else {
                a.e = b;
                if (z) {
                    if (a instanceof g) {
                        if (((g) a).S == -1) {
                            a(context, a, str2, i);
                            return;
                        }
                        Intent c = cn.jpush.android.api.c.c(context, a);
                        if (c != null) {
                            c.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                            context.getApplicationContext().startActivity(c);
                        }
                    }
                    return;
                }
                if (a instanceof g) {
                    cn.jpush.android.api.c.a(context, cn.jpush.android.api.c.a(a), i, null, context.getPackageName(), a);
                    e.a(a.c, str2, a.e, PointerIconCompat.TYPE_ZOOM_IN, context);
                }
                return;
            }
        }
        f.c(str3, str);
    }
}
