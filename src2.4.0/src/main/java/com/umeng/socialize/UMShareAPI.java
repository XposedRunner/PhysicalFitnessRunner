package com.umeng.socialize;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o0;
import com.umeng.socialize.utils.O0000o00.O00000o0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public class UMShareAPI {
    private static UMShareAPI a;
    private bp b;
    private UMShareConfig c = new UMShareConfig();

    private UMShareAPI(Context context) {
        O00000Oo.O000000o(context.getApplicationContext());
        this.b = new bp(context.getApplicationContext());
        if (a(context) != null && a(context).equals(O00000Oo.O00000Oo())) {
            new O000000o(context.getApplicationContext()).O00000o();
        }
    }

    private String a(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (!(activityManager == null || activityManager.getRunningAppProcesses() == null)) {
            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private boolean a(Activity activity, by byVar) {
        Method[] declaredMethods = activity.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            if (declaredMethods[i].getName().equals("onActivityResult")) {
                i2 = 1;
            }
            i++;
        }
        if (i2 == 0) {
            O0000O0o.O000000o(new String[]{O00000o0.O000000o, O0000o0.O0000o});
        }
        if (byVar == by.O0000O0o) {
            O0000O0o.O000000o(UmengTool.checkQQByself(activity));
            return true;
        } else if (byVar == by.O0000Oo0) {
            O0000O0o.O000000o(UmengTool.checkWxBySelf(activity));
            return true;
        } else if (byVar == by.O00000oO) {
            O0000O0o.O000000o(UmengTool.checkSinaBySelf(activity));
            return true;
        } else if (byVar == by.O0000o0) {
            O0000O0o.O000000o(UmengTool.checkFBByself(activity));
            return true;
        } else {
            if (byVar == by.O000O0oo) {
                O0000O0o.O000000o(UmengTool.checkVKByself(activity));
            }
            if (byVar == by.O0000ooo) {
                O0000O0o.O000000o(UmengTool.checkLinkin(activity));
            }
            if (byVar == by.O000O0o) {
                O0000O0o.O000000o(UmengTool.checkKakao(activity));
            }
            return true;
        }
    }

    public static UMShareAPI get(Context context) {
        if (a == null || a.b == null) {
            a = new UMShareAPI(context);
            O0000O0o.O00000Oo();
        }
        a.b.O000000o(context);
        return a;
    }

    public static void init(Context context, String str) {
        ce.O0000o0 = str;
        get(context);
    }

    public void deleteOauth(Activity activity, by byVar, UMAuthListener uMAuthListener) {
        if (activity != null) {
            a.b.O000000o(activity);
            new 2(this, activity, activity, byVar, uMAuthListener).O00000o();
            return;
        }
        O0000O0o.O000000o(O00000o0.O00000Oo);
    }

    @Deprecated
    public void doOauthVerify(Activity activity, by byVar, UMAuthListener uMAuthListener) {
        dh.O00000Oo();
        if (UMConfigure.getInitStatus()) {
            a.b.O000000o(activity);
            if (!O0000O0o.O000000o() || a(activity, byVar)) {
                if (activity != null) {
                    new 1(this, activity, activity, byVar, uMAuthListener).O00000o();
                } else {
                    O0000O0o.O000000o(O00000o0.O00000Oo);
                }
                return;
            }
            return;
        }
        O0000O0o.O00000o(O00000o0.O0000Ooo);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        dh.O000000o();
        if (UMConfigure.getInitStatus()) {
            WeakReference weakReference = new WeakReference(activity);
            if (O0000O0o.O000000o()) {
                if (a(activity, shareAction.getPlatform())) {
                    O0000o0.O000000o(shareAction.getPlatform());
                } else {
                    return;
                }
            }
            if (weakReference.get() == null || ((Activity) weakReference.get()).isFinishing()) {
                O0000O0o.O000000o(O00000o0.O00000Oo);
            } else {
                a.b.O000000o(activity);
                new 4(this, (Context) weakReference.get(), weakReference, shareAction, uMShareListener).O00000o();
            }
            return;
        }
        O0000O0o.O00000o(O00000o0.O0000Ooo);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        this.b.O000000o(activity, bundle, uMAuthListener);
    }

    public UMSSOHandler getHandler(by byVar) {
        return this.b != null ? this.b.O000000o(byVar) : null;
    }

    public void getPlatformInfo(Activity activity, by byVar, UMAuthListener uMAuthListener) {
        if (activity == null) {
            O0000O0o.O000000o(O00000o0.O00000Oo);
        } else if (UMConfigure.getInitStatus()) {
            dh.O00000Oo();
            if (O0000O0o.O000000o()) {
                if (a(activity, byVar)) {
                    O0000o0.O00000Oo(byVar);
                } else {
                    return;
                }
            }
            a.b.O000000o(activity);
            new 3(this, activity, activity, byVar, uMAuthListener).O00000o();
        } else {
            O0000O0o.O00000o(O00000o0.O0000Ooo);
        }
    }

    public String getversion(Activity activity, by byVar) {
        if (this.b != null) {
            return this.b.O00000o0(activity, byVar);
        }
        this.b = new bp(activity);
        return this.b.O00000o0(activity, byVar);
    }

    public boolean isAuthorize(Activity activity, by byVar) {
        if (this.b != null) {
            return this.b.O00000o(activity, byVar);
        }
        this.b = new bp(activity);
        return this.b.O00000o(activity, byVar);
    }

    public boolean isInstall(Activity activity, by byVar) {
        if (this.b != null) {
            return this.b.O000000o(activity, byVar);
        }
        this.b = new bp(activity);
        return this.b.O000000o(activity, byVar);
    }

    public boolean isSupport(Activity activity, by byVar) {
        if (this.b != null) {
            return this.b.O00000Oo(activity, byVar);
        }
        this.b = new bp(activity);
        return this.b.O00000Oo(activity, byVar);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.b != null) {
            this.b.O000000o(i, i2, intent);
        } else {
            O0000O0o.O000000o(O00000o0.O00000o0);
        }
        O0000O0o.O00000Oo(O00000o0.O000000o(i, i2));
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.b.O000000o(bundle);
    }

    public void release() {
        this.b.O000000o();
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        this.b.O000000o(uMShareConfig);
    }
}
