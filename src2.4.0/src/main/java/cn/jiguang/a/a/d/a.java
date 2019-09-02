package cn.jiguang.a.a.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.d.l;
import cn.jiguang.d.d.x;

@TargetApi(14)
public final class a implements ActivityLifecycleCallbacks {
    private static boolean a;
    private static int b;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (cn.jiguang.a.a.a != null) {
            cn.jiguang.a.a.a.dispatchStatus(activity, "onCreate");
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        if (cn.jiguang.a.a.a != null) {
            cn.jiguang.a.a.a.dispatchPause(activity);
        }
        if (!cn.jiguang.a.a.b) {
            b.a().b(activity);
            Context applicationContext = activity != null ? activity.getApplicationContext() : cn.jiguang.d.a.d;
            x.a(applicationContext);
            x.b(applicationContext);
        }
    }

    public final void onActivityResumed(Activity activity) {
        if (cn.jiguang.a.a.a != null) {
            cn.jiguang.a.a.a.dispatchResume(activity);
        }
        if (!cn.jiguang.a.a.b) {
            b.a().a((Context) activity);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (b == 0 && activity != null) {
            l.a((Context) activity, false);
            JCoreInterface.triggerSceneCheck(activity.getApplicationContext(), 1);
        }
        b++;
        if (cn.jiguang.a.a.a != null) {
            cn.jiguang.a.a.a.dispatchStatus(activity, "onStart");
        }
    }

    public final void onActivityStopped(Activity activity) {
        b--;
    }
}
