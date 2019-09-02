package com.qiyukf.unicorn;

import android.content.Context;
import android.os.Looper;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.SDKOptions;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;
import com.qiyukf.unicorn.api.UnicornImageLoader;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.api.YSFUserInfo;
import com.qiyukf.unicorn.apicloud.QYResUtils;
import com.qiyukf.unicorn.j.e;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d {
    private static boolean h;
    private static boolean i;
    private static final Object j = new Object();
    private static d k;
    private static List<a> l = new ArrayList();
    private Context a;
    private String b;
    private YSFOptions c;
    private UnicornImageLoader d;
    private com.qiyukf.unicorn.h.d e;
    private c f;
    private com.qiyukf.unicorn.f.a g;

    public interface a {
        void a();
    }

    private d() {
    }

    public static d a() {
        if (k != null) {
            return k;
        }
        throw new IllegalStateException("QIYU not initialized!");
    }

    public static d a(Context context, final String str, final YSFOptions ySFOptions, final UnicornImageLoader unicornImageLoader) {
        context = context.getApplicationContext();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(context, str, ySFOptions, unicornImageLoader);
        } else {
            e.b(new Runnable() {
                public final void run() {
                    d.c(context, str, ySFOptions, unicornImageLoader);
                    synchronized (d.j) {
                        d.j.notifyAll();
                    }
                }
            });
            try {
                synchronized (j) {
                    j.wait();
                }
            } catch (InterruptedException unused) {
                com.qiyukf.basesdk.a.a.e("QIYU", "init in background thread interrupt");
            }
        }
        return k;
    }

    public static void a(final Context context) {
        if (!i) {
            final com.qiyukf.unicorn.b.a a = com.qiyukf.unicorn.b.a.a(context);
            if (a != null) {
                e.b(new Runnable() {
                    public final void run() {
                        d.c(context, a.a(), a.b());
                    }
                });
            }
        }
    }

    public static void a(a aVar) {
        if (!l.contains(aVar)) {
            l.add(aVar);
        }
    }

    static /* synthetic */ void b(Context context, String str, YSFOptions ySFOptions) {
        StatusBarNotificationConfig statusBarNotificationConfig = ySFOptions.statusBarNotificationConfig;
        SDKOptions sDKOptions = new SDKOptions();
        sDKOptions.appKey = str;
        sDKOptions.statusBarNotificationConfig = statusBarNotificationConfig;
        sDKOptions.userInfoProvider = null;
        NIMClient.init(context, com.qiyukf.unicorn.f.a.b(), sDKOptions, ySFOptions.logSwitch);
    }

    private static void b(Context context, Throwable th) {
        com.qiyukf.basesdk.a.a.d("QIYU", "init error.", th);
        if (com.qiyukf.nimlib.d.f()) {
            com.qiyukf.unicorn.d.a.a(th);
        }
        com.qiyukf.unicorn.analytics.a.a(context);
        com.qiyukf.unicorn.analytics.a.a(th);
    }

    private static void b(YSFOptions ySFOptions) {
        if (ySFOptions != null && (com.qiyukf.nimlib.d.f() || com.qiyukf.nimlib.d.g())) {
            b.d().statusBarNotificationConfig = ySFOptions.statusBarNotificationConfig;
            c.a(ySFOptions.logSwitch);
            if (com.qiyukf.nimlib.d.f()) {
                k.c = ySFOptions;
            }
        }
    }

    public static void b(a aVar) {
        l.remove(aVar);
    }

    public static boolean b() {
        return i;
    }

    public static Context c() {
        return a().a;
    }

    private static void c(final Context context, final String str, final YSFOptions ySFOptions) {
        try {
            if (h) {
                com.qiyukf.basesdk.a.a.e("QIYU", "initialize has started");
                return;
            }
            h = true;
            com.qiyukf.nimlib.d.a(context);
            com.qiyukf.unicorn.j.d.a(context);
            com.qiyukf.unicorn.b.b.a(context, str);
            if (com.qiyukf.nimlib.d.f()) {
                g.a(context);
                com.qiyukf.basesdk.c.d.d.a(context);
                QYResUtils.init(context);
                d dVar = new d();
                k = dVar;
                dVar.a = context;
                k.b = str;
                k.c = ySFOptions == null ? YSFOptions.DEFAULT : ySFOptions;
            }
            e.a(new Runnable() {
                public final void run() {
                    try {
                        if (com.qiyukf.nimlib.d.f()) {
                            com.qiyukf.unicorn.b.a.a(context, str, ySFOptions);
                        }
                        d.b(context, str, ySFOptions == null ? YSFOptions.DEFAULT : ySFOptions);
                        if (com.qiyukf.nimlib.d.f()) {
                            d.a(d.k, context);
                            com.qiyukf.unicorn.d.a.a(null);
                            com.qiyukf.nimlib.d.d.a.c cVar = new com.qiyukf.nimlib.d.d.a.c();
                            cVar.b = false;
                            cVar.d = false;
                            cVar.c = false;
                            com.qiyukf.nimlib.d.a.d().a(context, new com.qiyukf.nimlib.d.d.a.b("qy", d.d(), "4.5.2"), cVar);
                        }
                        d.i = true;
                        e.b(new Runnable() {
                            public final void run() {
                                for (a aVar : d.l) {
                                    if (aVar != null) {
                                        aVar.a();
                                    }
                                }
                            }
                        });
                    } catch (Throwable th) {
                        d.b(context, th);
                    }
                }
            });
        } catch (Throwable th) {
            b(context, th);
        }
    }

    private static void c(Context context, String str, YSFOptions ySFOptions, final UnicornImageLoader unicornImageLoader) {
        try {
            if (i) {
                b(ySFOptions);
            } else {
                c(context, str, ySFOptions);
            }
            e.a(new Runnable() {
                public final void run() {
                    try {
                        if (com.qiyukf.nimlib.d.f()) {
                            d.k.d = unicornImageLoader;
                        }
                    } catch (Throwable th) {
                        com.qiyukf.basesdk.a.a.d("QIYU", "init error", th);
                    }
                }
            });
        } catch (Throwable th) {
            com.qiyukf.basesdk.a.a.d("QIYU", "init error", th);
        }
    }

    public static String d() {
        return a().b;
    }

    public static YSFOptions e() {
        return a().c;
    }

    public static UnicornImageLoader f() {
        return a().d;
    }

    public static com.qiyukf.unicorn.h.d g() {
        return a().e;
    }

    public static c h() {
        return k == null ? null : k.f;
    }

    public final void a(YSFOptions ySFOptions) {
        if (i && ySFOptions != null) {
            try {
                b(ySFOptions);
                if (com.qiyukf.nimlib.d.f()) {
                    com.qiyukf.unicorn.b.a.a(this.a, this.b, ySFOptions);
                }
            } catch (Throwable th) {
                com.qiyukf.basesdk.a.a.d("QIYU", "update options error.", th);
            }
        }
    }

    public final void a(final String str, final String str2) {
        new com.qiyukf.unicorn.j.a<Void, Void>("Unicorn-HTTP") {
            private Void b() {
                String d = com.qiyukf.unicorn.b.b.d();
                String d2 = d.d();
                String str = str;
                String str2 = str2;
                String str3 = "/webapi/user/accesshistory.action";
                HashMap hashMap = new HashMap(4);
                hashMap.put(LogBuilder.KEY_APPKEY, d2);
                hashMap.put("deviceid", d);
                hashMap.put("uri", str);
                hashMap.put("title", str2);
                try {
                    com.qiyukf.unicorn.f.b.a.a(str3, hashMap);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return null;
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object a() {
                return b();
            }
        }.a(new Void[0]);
    }

    public final boolean a(YSFUserInfo ySFUserInfo, RequestCallback<Void> requestCallback) {
        try {
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
            return this.g.a(ySFUserInfo, (RequestCallback) requestCallback);
        } catch (Throwable th) {
            com.qiyukf.basesdk.a.a.d("QIYU", "setUserInfo exception.", th);
            return false;
        }
    }

    public final boolean i() {
        return this.g.a();
    }
}
