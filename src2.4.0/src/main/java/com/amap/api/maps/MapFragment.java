package com.amap.api.maps;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
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

public class MapFragment extends Fragment {
    private AMap a;
    private IMapFragmentDelegate b;

    static {
        C.i(7);
    }

    public MapFragment() {
        a(getActivity());
    }

    private void a(Context context) {
        if (context != null) {
            oO0O000o.O000000o().O00000Oo(context.getApplicationContext(), OOo000.O00000oO());
        }
    }

    public static native MapFragment newInstance();

    public static MapFragment newInstance(AMapOptions aMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public AMap getMap() {
        IMapFragmentDelegate mapFragmentDelegate = getMapFragmentDelegate();
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            IAMap map = mapFragmentDelegate.getMap();
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
    public IMapFragmentDelegate getMapFragmentDelegate() {
        if (this.b == null) {
            try {
                this.b = (IMapFragmentDelegate) oO0O000o.O000000o().O000000o(getActivity(), OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(0)});
                if (this.b == null) {
                    this.b = (IMapFragmentDelegate) oO00o000.O000000o(getActivity(), OOo000.O00000oO(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", cf.class, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(0)});
                }
            } catch (Throwable unused) {
            }
            if (this.b == null) {
                this.b = new cf(0);
                this.b.setContext(getActivity());
            }
        }
        return this.b;
    }

    public native void onAttach(Activity activity);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getMapFragmentDelegate().onCreate(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return getMapFragmentDelegate().onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.a = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    public void onDestroyView() {
        try {
            getMapFragmentDelegate().onDestroyView();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate().onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onPause() {
        super.onPause();
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onResume() {
        super.onResume();
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    public native void setArguments(Bundle bundle);

    public native void setUserVisibleHint(boolean z);
}
