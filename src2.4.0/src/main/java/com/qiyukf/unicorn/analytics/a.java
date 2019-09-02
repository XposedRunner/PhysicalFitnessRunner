package com.qiyukf.unicorn.analytics;

import android.content.Context;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a.c;
import com.qiyukf.nimlib.d;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import org.json.JSONObject;

public final class a {
    static final String a;
    private static Context b;

    private static abstract class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public abstract void a();

        public final void run() {
            try {
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    enum b {
        invite,
        crash,
        exception
    }

    static {
        String str = d.f() ? DeviceInfo.TAG_IMEI : d.g() ? "core" : null;
        StringBuilder stringBuilder = new StringBuilder("Analytics-");
        stringBuilder.append(str);
        a = stringBuilder.toString();
    }

    public static void a(Context context) {
        try {
            if (!a()) {
                b = context.getApplicationContext();
                com.qiyukf.basesdk.a.a.a(a, "init");
                if (d.g()) {
                    b.a(b);
                    String str = a;
                    StringBuilder stringBuilder = new StringBuilder("log analytics switch is ");
                    stringBuilder.append(b.a() ? "on" : "off");
                    com.qiyukf.basesdk.a.a.a(str, stringBuilder.toString());
                    if (b.b()) {
                        a(new a() {
                            public final void a() {
                                a.c();
                            }
                        });
                    }
                    AnalyticsService.a(context);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void a(Throwable th) {
        b(th, b.exception);
    }

    static void a(Throwable th, b bVar) {
        c a = com.qiyukf.basesdk.a.a.a();
        if (a != null) {
            String a2 = a.a();
            String a3 = com.qiyukf.basesdk.c.c.c.a(Log.getStackTraceString(th).trim());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a2);
            stringBuilder.append("analytics/");
            stringBuilder.append(a3);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            a2 = stringBuilder.toString();
            File file = new File(a2);
            if (!file.exists()) {
                file.mkdirs();
            }
            c.a(a2, th, bVar);
        }
    }

    static boolean a() {
        return b != null;
    }

    public static void b() {
        try {
            if (d.f()) {
                a(new a() {
                    public final void a() {
                        c.b();
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Throwable th) {
        b(th, b.crash);
    }

    private static void b(Throwable th, b bVar) {
        try {
            if (!a()) {
                return;
            }
            if (d.g() && bVar == b.crash) {
                a(th, bVar);
                return;
            }
            if (d.f() || (d.g() && bVar != b.crash)) {
                AnalyticsService.a(b, th, bVar);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    static /* synthetic */ void c() {
        JSONObject a = com.qiyukf.unicorn.f.c.a();
        if (a != null) {
            long c = com.qiyukf.basesdk.c.b.c(a, "distinctPeriod");
            float d = (float) com.qiyukf.basesdk.c.b.d(a, "samplingRate");
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("fetch config: ");
            stringBuilder.append(a.toString());
            com.qiyukf.basesdk.a.a.a(str, stringBuilder.toString());
            b.a(c);
            b.a(d);
            b.c();
        }
    }
}
