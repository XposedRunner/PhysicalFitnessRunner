package com.amap.api.maps;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.cf;
import com.amap.api.mapcore.util.oO00o000;
import com.amap.api.mapcore.util.oO0O000o;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import s.h.e.l.l.C;

public class TextureMapView extends FrameLayout {
    private IMapFragmentDelegate a;
    private AMap b;
    private int c = 0;

    static {
        C.i(11);
    }

    public TextureMapView(Context context) {
        super(context);
        a(context);
        getMapFragmentDelegate().setContext(context);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
        this.c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.c);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        this.c = attributeSet.getAttributeIntValue(16842972, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.c);
    }

    public TextureMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        a(context);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }

    private void a(Context context) {
        if (context != null) {
            oO0O000o.O000000o().O00000Oo(context.getApplicationContext(), OOo000.O00000oO());
        }
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.b == null) {
                this.b = new AMap(map);
            }
            return this.b;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.a == null) {
            try {
                this.a = (IMapFragmentDelegate) oO0O000o.O000000o().O000000o(getContext(), OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                if (this.a == null) {
                    this.a = (IMapFragmentDelegate) oO00o000.O000000o(getContext(), OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                }
            } catch (Throwable unused) {
            }
            if (this.a == null) {
                this.a = new cf(1);
            }
        }
        return this.a;
    }

    public final void onCreate(Bundle bundle) {
        try {
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.b = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

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

    public native void setVisibility(int i);
}
