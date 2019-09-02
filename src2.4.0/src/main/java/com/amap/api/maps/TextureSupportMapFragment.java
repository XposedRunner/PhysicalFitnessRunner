package com.amap.api.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.cf;
import com.amap.api.mapcore.util.oO00o000;
import com.amap.api.mapcore.util.oO0O000o;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import s.h.e.l.l.C;

public class TextureSupportMapFragment extends Fragment {
    private AMap a;
    private IMapFragmentDelegate b;

    static {
        C.i(12);
    }

    public TextureSupportMapFragment() {
        a(getActivity());
    }

    private IMapFragmentDelegate a() {
        return getMapFragmentDelegate(getActivity());
    }

    private void a(Context context) {
        if (context != null) {
            oO0O000o.O000000o().O00000Oo(context.getApplicationContext(), OOo000.O00000oO());
        }
    }

    public static native TextureSupportMapFragment newInstance();

    public static TextureSupportMapFragment newInstance(AMapOptions aMapOptions) {
        TextureSupportMapFragment textureSupportMapFragment = new TextureSupportMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        textureSupportMapFragment.setArguments(bundle);
        return textureSupportMapFragment;
    }

    public AMap getMap() {
        IMapFragmentDelegate a = a();
        if (a == null) {
            return null;
        }
        try {
            IAMap map = a.getMap();
            if (map == null) {
                return null;
            }
            if (this.a == null) {
                this.a = new AMap(map);
            }
            return this.a;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public IMapFragmentDelegate getMapFragmentDelegate(Context context) {
        if (this.b == null) {
            try {
                Context context2 = context;
                this.b = (IMapFragmentDelegate) oO0O000o.O000000o().O000000o(context2, OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                if (this.b == null) {
                    context2 = context;
                    this.b = (IMapFragmentDelegate) oO00o000.O000000o(context2, OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                }
            } catch (Throwable unused) {
            }
            if (this.b == null) {
                this.b = new cf(1);
                this.b.setContext(context);
            }
        }
        return this.b;
    }

    public native void onAttach(Activity activity);

    public native void onCreate(Bundle bundle);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return a().onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        try {
            a().onDestroy();
            this.a = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        try {
            a().onDestroyView();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate(activity).onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        try {
            a().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onPause() {
        super.onPause();
        try {
            a().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        try {
            a().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            a().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        try {
            super.setArguments(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public native void setUserVisibleHint(boolean z);
}
