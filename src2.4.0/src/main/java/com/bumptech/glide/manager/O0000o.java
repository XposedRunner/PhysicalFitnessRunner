package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever */
public class O0000o implements Callback {
    static final String O000000o = "com.bumptech.glide.manager";
    private static final String O00000o = "RMRetriever";
    private static final O0000o O00000oO = new O0000o();
    private static final int O00000oo = 1;
    private static final int O0000O0o = 2;
    final Map<FragmentManager, O0000o0> O00000Oo = new HashMap();
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> O00000o0 = new HashMap();
    private volatile O00o000 O0000OOo;
    private final Handler O0000Oo0 = new Handler(Looper.getMainLooper(), this);

    O0000o() {
    }

    public static O0000o O000000o() {
        return O00000oO;
    }

    private O00o000 O00000Oo(Context context) {
        if (this.O0000OOo == null) {
            synchronized (this) {
                if (this.O0000OOo == null) {
                    this.O0000OOo = new O00o000(context.getApplicationContext(), new O00000Oo(), new O0000OOo());
                }
            }
        }
        return this.O0000OOo;
    }

    @TargetApi(17)
    private static void O00000Oo(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(11)
    public O00o000 O000000o(Activity activity) {
        if (oOOO000o.O00000o() || VERSION.SDK_INT < 11) {
            return O000000o(activity.getApplicationContext());
        }
        O00000Oo(activity);
        return O000000o((Context) activity, activity.getFragmentManager());
    }

    @TargetApi(17)
    public O00o000 O000000o(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (oOOO000o.O00000o() || VERSION.SDK_INT < 17) {
            return O000000o(fragment.getActivity().getApplicationContext());
        } else {
            return O000000o(fragment.getActivity(), fragment.getChildFragmentManager());
        }
    }

    public O00o000 O000000o(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (oOOO000o.O00000o0() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return O000000o((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return O000000o((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return O000000o(((ContextWrapper) context).getBaseContext());
            }
        }
        return O00000Oo(context);
    }

    /* Access modifiers changed, original: 0000 */
    @TargetApi(11)
    public O00o000 O000000o(Context context, FragmentManager fragmentManager) {
        O0000o0 O000000o = O000000o(fragmentManager);
        O00o000 O00000Oo = O000000o.O00000Oo();
        if (O00000Oo != null) {
            return O00000Oo;
        }
        O00000Oo = new O00o000(context, O000000o.O000000o(), O000000o.O00000o0());
        O000000o.O000000o(O00000Oo);
        return O00000Oo;
    }

    /* Access modifiers changed, original: 0000 */
    public O00o000 O000000o(Context context, android.support.v4.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment O000000o = O000000o(fragmentManager);
        O00o000 O00000Oo = O000000o.O00000Oo();
        if (O00000Oo != null) {
            return O00000Oo;
        }
        O00000Oo = new O00o000(context, O000000o.O000000o(), O000000o.O00000o0());
        O000000o.O000000o(O00000Oo);
        return O00000Oo;
    }

    public O00o000 O000000o(android.support.v4.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (oOOO000o.O00000o()) {
            return O000000o(fragment.getActivity().getApplicationContext());
        } else {
            return O000000o(fragment.getActivity(), fragment.getChildFragmentManager());
        }
    }

    public O00o000 O000000o(FragmentActivity fragmentActivity) {
        if (oOOO000o.O00000o()) {
            return O000000o(fragmentActivity.getApplicationContext());
        }
        O00000Oo((Activity) fragmentActivity);
        return O000000o((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    /* Access modifiers changed, original: 0000 */
    @TargetApi(17)
    public O0000o0 O000000o(FragmentManager fragmentManager) {
        O0000o0 o0000o0 = (O0000o0) fragmentManager.findFragmentByTag(O000000o);
        if (o0000o0 != null) {
            return o0000o0;
        }
        o0000o0 = (O0000o0) this.O00000Oo.get(fragmentManager);
        if (o0000o0 != null) {
            return o0000o0;
        }
        o0000o0 = new O0000o0();
        this.O00000Oo.put(fragmentManager, o0000o0);
        fragmentManager.beginTransaction().add(o0000o0, O000000o).commitAllowingStateLoss();
        this.O0000Oo0.obtainMessage(1, fragmentManager).sendToTarget();
        return o0000o0;
    }

    /* Access modifiers changed, original: 0000 */
    public SupportRequestManagerFragment O000000o(android.support.v4.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(O000000o);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        supportRequestManagerFragment = (SupportRequestManagerFragment) this.O00000o0.get(fragmentManager);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        android.support.v4.app.Fragment supportRequestManagerFragment2 = new SupportRequestManagerFragment();
        this.O00000o0.put(fragmentManager, supportRequestManagerFragment2);
        fragmentManager.beginTransaction().add(supportRequestManagerFragment2, O000000o).commitAllowingStateLoss();
        this.O0000Oo0.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment2;
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        Object remove;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                remove = this.O00000Oo.remove(obj);
                break;
            case 2:
                obj = (android.support.v4.app.FragmentManager) message.obj;
                remove = this.O00000o0.remove(obj);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && remove == null && Log.isLoggable(O00000o, 5)) {
            String str = O00000o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to remove expected request manager fragment, manager: ");
            stringBuilder.append(obj);
            Log.w(str, stringBuilder.toString());
        }
        return z;
    }
}
