package com.qiyukf.unicorn.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.c.d.c;
import com.qiyukf.basesdk.c.d.e;

public class AnalyticsService extends IntentService {
    public AnalyticsService() {
        super(a.a);
    }

    private void a() {
        if (c.f(this)) {
            c.a();
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, AnalyticsService.class);
        intent.setAction("com.qiyukf.action.AUTO_UPLOAD");
        e.a(context, intent);
        a.a(a.a, "try to upload log");
    }

    public static void a(Context context, Throwable th, b bVar) {
        Intent intent = new Intent(context, AnalyticsService.class);
        intent.setAction("com.qiyukf.action.AUTO_ERROR");
        intent.putExtra("com.qiyukf.extra.ERROR_MESSAGE", th);
        intent.putExtra("com.qiyukf.extra.ERROR_TYPE", bVar);
        e.a(context, intent);
        a.a(a.a, "try to save error log");
    }

    /* Access modifiers changed, original: protected */
    public void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            try {
                if (!TextUtils.isEmpty(intent.getAction())) {
                    if (!a.a()) {
                        a.e(a.a, "Analytics not init");
                    } else if (!b.a()) {
                    } else {
                        if (TextUtils.equals(intent.getAction(), "com.qiyukf.action.AUTO_ERROR")) {
                            a.a((Throwable) intent.getSerializableExtra("com.qiyukf.extra.ERROR_MESSAGE"), (b) intent.getSerializableExtra("com.qiyukf.extra.ERROR_TYPE"));
                            a();
                            return;
                        }
                        if (TextUtils.equals(intent.getAction(), "com.qiyukf.action.AUTO_UPLOAD")) {
                            a();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
