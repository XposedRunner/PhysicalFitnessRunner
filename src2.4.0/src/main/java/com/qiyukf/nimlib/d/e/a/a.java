package com.qiyukf.nimlib.d.e.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@TargetApi(14)
final class a implements ActivityLifecycleCallbacks {
    private static a a;
    private boolean b = true;
    private boolean c = false;
    private Handler d = new Handler();
    private Runnable e;
    private List<com.qiyukf.nimlib.d.e.a.b.a> f = new CopyOnWriteArrayList();

    a() {
    }

    @TargetApi(14)
    static void a(Context context) {
        String stringBuilder;
        if (VERSION.SDK_INT < 14 || context == null || !(context instanceof Application) || a != null) {
            StringBuilder stringBuilder2 = new StringBuilder("app can not register activity lifecycle callbacks, sdk version=");
            stringBuilder2.append(VERSION.SDK_INT);
            stringBuilder = stringBuilder2.toString();
        } else {
            a = new a();
            ((Application) context).registerActivityLifecycleCallbacks(a);
            stringBuilder = "app register activity lifecycle callbacks success";
        }
        com.qiyukf.nimlib.d.a.b.a.a(stringBuilder);
    }

    static void a(com.qiyukf.nimlib.d.e.a.b.a aVar) {
        if (!a() && aVar != null && !a.f.contains(aVar)) {
            a.f.add(aVar);
            com.qiyukf.nimlib.d.a.b.a.a("add AppForegroundObserver");
        }
    }

    private static boolean a() {
        return a == null;
    }

    static void b(Context context) {
        if (context != null && (context instanceof Application) && a != null) {
            ((Application) context).unregisterActivityLifecycleCallbacks(a);
            a.f.clear();
            a = null;
        }
    }

    static void b(com.qiyukf.nimlib.d.e.a.b.a aVar) {
        if (!a() && aVar != null) {
            a.f.remove(aVar);
            com.qiyukf.nimlib.d.a.b.a.a("remove AppForegroundObserver");
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        this.c = true;
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        } else {
            this.e = new Runnable() {
                public final void run() {
                    if (a.this.b && a.this.c) {
                        a.this.b = false;
                        com.qiyukf.nimlib.d.a.b.a.a("app in background");
                        for (com.qiyukf.nimlib.d.e.a.b.a b : a.this.f) {
                            try {
                                b.b();
                            } catch (Exception e) {
                                StringBuilder stringBuilder = new StringBuilder("AppForegroundObserver threw exception! e=");
                                stringBuilder.append(e.getMessage());
                                com.qiyukf.nimlib.d.a.b.a.a(stringBuilder.toString());
                            }
                        }
                    }
                }
            };
        }
        this.d.postDelayed(this.e, 500);
    }

    public final void onActivityResumed(Activity activity) {
        this.c = false;
        int i = this.b ^ 1;
        this.b = true;
        if (this.e != null) {
            this.d.removeCallbacks(this.e);
        }
        if (i != 0) {
            com.qiyukf.nimlib.d.a.b.a.a("app on foreground");
            for (com.qiyukf.nimlib.d.e.a.b.a a : this.f) {
                try {
                    a.a();
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder("AppForegroundObserver threw exception! e=");
                    stringBuilder.append(e.getMessage());
                    com.qiyukf.nimlib.d.a.b.a.a(stringBuilder.toString());
                }
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
