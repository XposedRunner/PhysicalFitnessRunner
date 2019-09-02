package com.geetest.sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import cn.jiguang.net.HttpUtils;
import com.geetest.sdk.views.CoverFrameLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GT3MotionEvent */
public final class O000o implements ActivityLifecycleCallbacks {
    private final String O000000o = getClass().getSimpleName();
    private List<View> O00000Oo = new ArrayList();
    private Map<String, String> O00000o = new HashMap();
    private final List<String> O00000o0 = new ArrayList();
    private long O00000oO;
    private boolean O00000oo = true;

    private void O000000o(View view) {
        if (this.O00000oo) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    O000000o(viewGroup.getChildAt(i));
                }
            } else if (this.O00000oo && this.O00000Oo != null) {
                this.O00000Oo.add(view);
            }
        }
    }

    private View O00000o0(MotionEvent motionEvent) {
        try {
            int[] iArr = new int[2];
            if (this.O00000Oo == null) {
                O0OOO00.O000000o();
                return null;
            } else if (this.O00000Oo.size() == 0) {
                O0OOO00.O000000o();
                return null;
            } else {
                for (View view : this.O00000Oo) {
                    if (view != null && view.isShown()) {
                        view.getLocationOnScreen(iArr);
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
                        O0OOO00.O000000o();
                        if (contains) {
                            return view;
                        }
                    }
                }
                return null;
            }
        } catch (Exception e) {
            O0OOO00.O000000o(e.toString());
        }
    }

    public final View O000000o(MotionEvent motionEvent) {
        View O00000o0 = O00000o0(motionEvent);
        O0OOO00.O000000o();
        if (O00000o0 != null && this.O00000oo) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(new BigDecimal((double) motionEvent.getRawX()).setScale(0, 4));
            stringBuilder.append(",");
            stringBuilder.append(new BigDecimal((double) motionEvent.getRawY()).setScale(0, 4));
            stringBuilder.append(",");
            stringBuilder.append(System.currentTimeMillis() - this.O00000oO);
            this.O00000o.put("u", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(O00000o0.getId());
            stringBuilder2.append(",");
            stringBuilder2.append(O00000o0.getTop());
            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder2.append(O00000o0.getRight());
            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder2.append(O00000o0.getBottom());
            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder2.append(O00000o0.getLeft());
            stringBuilder2.append(",");
            stringBuilder2.append(O00000o0.getWidth());
            stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder2.append(O00000o0.getHeight());
            this.O00000o.put("v", stringBuilder2.toString());
            this.O00000o0.add(this.O00000o.toString());
            if (this.O00000o0.size() > 20) {
                this.O00000o0.remove(0);
            }
        }
        return O00000o0;
    }

    public final String O000000o() {
        if (this.O00000o0.toString() == null) {
            return null;
        }
        new StringBuilder("stringList: ").append(this.O00000o0.toString());
        O0OOO00.O000000o();
        new StringBuilder("stringList.size()-->").append(this.O00000o0.size());
        O0OOO00.O000000o();
        return this.O00000o0.toString();
    }

    public final View O00000Oo(MotionEvent motionEvent) {
        View O00000o0 = O00000o0(motionEvent);
        O0OOO00.O000000o();
        if (O00000o0 != null && this.O00000oo) {
            this.O00000o.clear();
            this.O00000oO = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(new BigDecimal((double) motionEvent.getRawX()).setScale(0, 4));
            stringBuilder.append(",");
            stringBuilder.append(new BigDecimal((double) motionEvent.getRawY()).setScale(0, 4));
            stringBuilder.append(",0");
            this.O00000o.put("d", stringBuilder.toString());
        }
        return O00000o0;
    }

    public final void O00000Oo() {
        this.O00000o0.clear();
        this.O00000oo = false;
        if (this.O00000Oo != null) {
            this.O00000Oo.clear();
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder("onActivityDestroyed-->");
        stringBuilder.append(activity.toString());
        O0OOO00.O000000o(stringBuilder.toString());
        ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
    }

    public final void onActivityPaused(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder("onActivityPaused-->");
        stringBuilder.append(activity.toString());
        O0OOO00.O000000o(stringBuilder.toString());
        this.O00000oo = false;
        if (this.O00000Oo != null) {
            this.O00000Oo.clear();
        }
        this.O00000o0.clear();
        ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
    }

    public final void onActivityResumed(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder("onActivityResumed-->");
        stringBuilder.append(activity.toString());
        O0OOO00.O000000o(stringBuilder.toString());
        this.O00000Oo = new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        if (this.O00000Oo != null) {
            this.O00000Oo.clear();
        }
        this.O00000o0.clear();
        O000000o(decorView);
        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            if (viewGroup.getChildCount() != 0 && !(viewGroup.getChildAt(0) instanceof CoverFrameLayout)) {
                CoverFrameLayout coverFrameLayout = new CoverFrameLayout(activity, viewGroup, this);
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
