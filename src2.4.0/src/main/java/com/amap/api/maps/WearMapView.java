package com.amap.api.maps;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.cf;
import com.amap.api.mapcore.util.oO00o000;
import com.amap.api.mapcore.util.oO0O000o;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import s.h.e.l.l.C;

@TargetApi(20)
public class WearMapView extends ViewGroup {
    private static int f;
    private static int g;
    private final String a = WearMapView.class.getSimpleName();
    private IMapFragmentDelegate b;
    private AMap c;
    private View d;
    private SwipeDismissView e;
    private int h = 0;

    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    static {
        C.i(13);
    }

    public WearMapView(Context context) {
        super(context);
        getMapFragmentDelegate().setContext(context);
        a(context);
        b(context);
        c(context);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        this.h = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.h);
        b(context);
        c(context);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        this.h = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.h);
        b(context);
        c(context);
    }

    public WearMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        a(context);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
        b(context);
        c(context);
    }

    private void a(Context context) {
        if (context != null) {
            oO0O000o.O000000o().O00000Oo(context.getApplicationContext(), OOo000.O00000oO());
        }
    }

    private void a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        i = i > 0 ? MeasureSpec.makeMeasureSpec(i, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(i, i2 > 0 ? MeasureSpec.makeMeasureSpec(i2, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            if (defaultDisplay != null) {
                defaultDisplay.getSize(point);
            }
            f = point.x;
            g = point.y;
        }
    }

    private void c(Context context) {
        this.e = new SwipeDismissView(context, this);
        LayoutParams layoutParams = new LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f), g);
        this.e.setBackgroundColor(Color.argb(0, 0, 0, 0));
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        addView(this.e, layoutParams);
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.c == null) {
                this.c = new AMap(map);
            }
            return this.c;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.b == null) {
            try {
                this.b = (IMapFragmentDelegate) oO0O000o.O000000o().O000000o(getContext(), OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                if (this.b == null) {
                    this.b = (IMapFragmentDelegate) oO00o000.O000000o(getContext(), OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                }
            } catch (Throwable unused) {
            }
            if (this.b == null) {
                this.b = new cf(1);
            }
        }
        return this.b;
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.d = getMapFragmentDelegate().onCreateView(null, null, bundle);
            addView(this.d, 0, new LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public native void onDismiss();

    public native void onEnterAmbient(Bundle bundle);

    public native void onExitAmbient();

    public native void onLayout(boolean z, int i, int i2, int i3, int i4);

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public native void onMeasure(int i, int i2);

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public native void setLayerType(int i, Paint paint);

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        if (this.e != null) {
            this.e.setCallback(onDismissCallback);
        }
    }

    public native void setVisibility(int i);
}
