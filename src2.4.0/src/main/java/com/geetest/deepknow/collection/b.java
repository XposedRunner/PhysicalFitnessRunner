package com.geetest.deepknow.collection;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.c.a;
import com.geetest.deepknow.utils.d;
import com.geetest.deepknow.utils.f;
import com.geetest.geeguard.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LifeCallBacks */
public class b implements ActivityLifecycleCallbacks {
    private boolean a = false;
    private Integer b = Integer.valueOf(0);
    private d c;
    private Context d;
    private a e;
    private com.geetest.deepknow.c.b f;
    private final Handler g = new Handler();
    private com.geetest.deepknow.b.a h;
    private final List<View> i = new ArrayList();
    private WeakReference j = null;
    private String k;
    private String l;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private final Object p = new Object();

    public b(d dVar, Context context, a aVar, com.geetest.deepknow.c.b bVar, com.geetest.deepknow.b.a aVar2) {
        this.c = dVar;
        this.d = context;
        this.e = aVar;
        this.f = bVar;
        this.h = aVar2;
        this.o = false;
    }

    private DPCoverFrameLayout a(ViewGroup viewGroup) {
        return (DPCoverFrameLayout) JniLib1557756502.cL(this, viewGroup, Integer.valueOf(49));
    }

    private String a(View view, int i, View view2) {
        return (String) JniLib1557756502.cL(this, view, Integer.valueOf(i), view2, Integer.valueOf(50));
    }

    private void a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if ((viewGroup instanceof WebView) || (viewGroup instanceof AdapterView)) {
                b(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i));
            }
            return;
        }
        this.i.add(view);
    }

    private boolean a(String str) {
        return JniLib1557756502.cZ(this, str, Integer.valueOf(51));
    }

    private View b(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        for (View view : this.i) {
            if (view.isShown()) {
                view.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return view;
                }
            }
        }
        return null;
    }

    private void b() {
        JniLib1557756502.cV(this, Integer.valueOf(52));
    }

    private void b(View view, int i, View view2) {
        if (!"1".equals(view.getTag(R.id.deepknow_tag_view_ignored))) {
            if (TextUtils.isEmpty(f.a(this.d, com.geetest.deepknow.utils.a.a(view), ""))) {
                this.f.a(a(view, i, view2));
            } else {
                this.f.b(a(view, i, view2));
            }
        }
    }

    private void b(ViewGroup viewGroup) {
        JniLib1557756502.cV(this, viewGroup, Integer.valueOf(53));
    }

    private void c() {
        JniLib1557756502.cV(this, Integer.valueOf(54));
    }

    public View a(MotionEvent motionEvent) {
        return (View) JniLib1557756502.cL(this, motionEvent, Integer.valueOf(43));
    }

    public void a() {
        JniLib1557756502.cV(this, Integer.valueOf(44));
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        JniLib1557756502.cV(this, activity, bundle, Integer.valueOf(45));
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        JniLib1557756502.cV(this, activity, Integer.valueOf(46));
    }

    public void onActivityResumed(Activity activity) {
        JniLib1557756502.cV(this, activity, Integer.valueOf(47));
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        JniLib1557756502.cV(this, activity, bundle, Integer.valueOf(48));
    }

    public void onActivityStarted(Activity activity) {
        this.k = com.geetest.deepknow.utils.a.b(activity);
        this.l = com.geetest.deepknow.utils.a.a(activity);
        if (!this.m) {
            this.n = a(this.k);
            if (this.n) {
                this.h.a(200, activity);
            }
            this.j = new WeakReference(activity);
            View decorView = activity.getWindow().getDecorView();
            a(decorView);
            if (decorView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) decorView;
                if (!(viewGroup.getChildAt(0) instanceof DPCoverFrameLayout)) {
                    a(viewGroup);
                }
            }
        }
        synchronized (this.p) {
            if (this.b.intValue() == 0) {
                boolean booleanValue = ((Boolean) this.c.a()).booleanValue();
                if (booleanValue) {
                    this.c.a(Boolean.valueOf(false));
                    com.geetest.deepknow.e.b.a(this.d);
                }
                try {
                    c();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f.a(a.a(this.a, booleanValue, this.k, this.l));
                this.a = true;
            }
            this.b = Integer.valueOf(this.b.intValue() + 1);
        }
    }

    public void onActivityStopped(Activity activity) {
        synchronized (this.p) {
            this.b = Integer.valueOf(this.b.intValue() - 1);
            if (this.b.intValue() == 0) {
                b();
                this.f.a(a.a(this.k, this.l));
            }
        }
    }
}
