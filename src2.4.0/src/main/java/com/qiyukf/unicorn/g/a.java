package com.qiyukf.unicorn.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.service.NimReceiver;
import com.qiyukf.unicorn.api.SavePowerConfig;
import com.qiyukf.unicorn.f.c;
import com.umeng.commonsdk.framework.UMModuleRegister;
import org.json.JSONObject;

public final class a {
    public static void a(final Context context, final boolean z) {
        new com.qiyukf.unicorn.j.a<Void, JSONObject>("Unicorn-HTTP") {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object a() {
                return c.a(b.g(), b.b(), d.a().g(), b.f(), d.a().i(), d.a().j());
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ void a(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                StringBuilder stringBuilder = new StringBuilder("query unread count: ");
                stringBuilder.append(jSONObject);
                com.qiyukf.basesdk.a.a.a("PowerSaver", stringBuilder.toString());
                if (jSONObject != null) {
                    int b = com.qiyukf.basesdk.c.b.b(jSONObject, "count");
                    int b2 = com.qiyukf.basesdk.c.b.b(jSONObject, UMModuleRegister.PUSH);
                    long c = com.qiyukf.basesdk.c.b.c(jSONObject, "user");
                    long c2 = com.qiyukf.basesdk.c.b.c(jSONObject, "app");
                    d.a().a(b2 == 1);
                    if (z) {
                        if (b > 0) {
                            c.a(context);
                        }
                        if (b2 == 1) {
                            SavePowerConfig f = d.a().f();
                            if (f != null && f.customPush) {
                                Context context = context;
                                Intent intent = new Intent(context, NimReceiver.class);
                                intent.setAction("com.qiyukf.unicorn.ACTION.CHECK_MESSAGE");
                                AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                                if (alarmManager != null) {
                                    PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, AMapEngineUtils.MAX_P20_WIDTH);
                                    if (broadcast != null) {
                                        alarmManager.cancel(broadcast);
                                    }
                                }
                            }
                        }
                    } else {
                        c.a(context).b();
                    }
                    d.a().c(c);
                    d.a().d(c2);
                }
                d.a().a(System.currentTimeMillis());
            }
        }.a(new Void[0]);
    }
}
