package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* compiled from: MapFragmentDelegateImp */
public class cf implements IMapFragmentDelegate {
    public static volatile Context O000000o;
    public int O00000Oo = 0;
    private int O00000o = 0;
    private IAMap O00000o0;
    private AMapOptions O00000oO;

    public cf(int i) {
        this.O00000o = i % 3;
    }

    private static void O000000o(Context context) {
        if (context != null) {
            O000000o = context.getApplicationContext();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions != null && this.O00000o0 != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.O00000o0.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
            }
            UiSettings aMapUiSettings = this.O00000o0.getAMapUiSettings();
            aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
            aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
            aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
            aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled());
            aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
            aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled());
            aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled());
            aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
            this.O00000o0.setMapType(aMapOptions.getMapType());
            this.O00000o0.setZOrderOnTop(aMapOptions.getZOrderOnTop());
        }
    }

    public IAMap getMap() throws RemoteException {
        if (this.O00000o0 == null) {
            if (O000000o == null) {
                Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
                return null;
            }
            int i = O000000o.getResources().getDisplayMetrics().densityDpi;
            if (i <= GlMapUtil.DEVICE_DISPLAY_DPI_LOW) {
                bu.O000000o = 0.5f;
            } else if (i <= GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL) {
                bu.O000000o = 0.8f;
            } else if (i <= GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) {
                bu.O000000o = 0.87f;
            } else if (i <= GlMapUtil.DEVICE_DISPLAY_DPI_HIGH) {
                bu.O000000o = 1.0f;
            } else if (i <= GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH) {
                bu.O000000o = 1.5f;
            } else if (i <= GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH) {
                bu.O000000o = 1.8f;
            } else {
                bu.O000000o = 0.9f;
            }
            if (this.O00000o == 0) {
                this.O00000o0 = new e(O000000o).O000000o();
            } else if (this.O00000o == 1) {
                this.O00000o0 = new f(O000000o).O000000o();
            } else {
                this.O00000o0 = new O0OOOo0(O000000o).O000000o();
            }
        }
        return this.O00000o0;
    }

    public boolean isReady() throws RemoteException {
        return false;
    }

    public void onCreate(Bundle bundle) throws RemoteException {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        if (O000000o == null && layoutInflater != null) {
            setContext(layoutInflater.getContext().getApplicationContext());
        }
        try {
            this.O00000o0 = getMap();
            this.O00000o0.setVisibilityEx(this.O00000Oo);
            if (this.O00000oO == null && bundle != null) {
                byte[] byteArray = bundle.getByteArray("MAP_OPTIONS");
                if (byteArray != null) {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(byteArray, 0, byteArray.length);
                    obtain.setDataPosition(0);
                    this.O00000oO = AMapOptions.CREATOR.createFromParcel(obtain);
                }
            }
            O000000o(this.O00000oO);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.O00000o0.getView();
    }

    public void onDestroy() throws RemoteException {
        if (this.O00000o0 != null) {
            this.O00000o0.clear();
            this.O00000o0.destroy();
            this.O00000o0 = null;
        }
    }

    public void onDestroyView() throws RemoteException {
    }

    public void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        setContext(activity.getApplicationContext());
        this.O00000oO = aMapOptions;
    }

    public void onLowMemory() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    public void onPause() throws RemoteException {
        if (this.O00000o0 != null) {
            this.O00000o0.onActivityPause();
        }
    }

    public void onResume() throws RemoteException {
        if (this.O00000o0 != null) {
            this.O00000o0.onActivityResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) throws RemoteException {
        if (this.O00000o0 != null) {
            if (this.O00000oO == null) {
                this.O00000oO = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                this.O00000oO = this.O00000oO.camera(getMap().getCameraPosition());
                this.O00000oO.writeToParcel(obtain, 0);
                bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    public void setContext(Context context) {
        O000000o(context);
    }

    public void setOptions(AMapOptions aMapOptions) {
        this.O00000oO = aMapOptions;
    }

    public void setVisibility(int i) {
        this.O00000Oo = i;
        if (this.O00000o0 != null) {
            this.O00000o0.setVisibilityEx(i);
        }
    }
}
