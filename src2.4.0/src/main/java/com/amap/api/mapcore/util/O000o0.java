package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode;

/* compiled from: AMapLocationSource */
public class O000o0 implements LocationSource, Inner_3dMap_locationListener {
    boolean O000000o = false;
    long O00000Oo = 2000;
    private OnLocationChangedListener O00000o;
    private Bundle O00000o0 = null;
    private o0000000 O00000oO;
    private Inner_3dMap_locationOption O00000oo;
    private Context O0000O0o;

    public O000o0(Context context) {
        this.O0000O0o = context;
    }

    private void O000000o(boolean z) {
        if (!(this.O00000oo == null || this.O00000oO == null)) {
            this.O00000oO.O00000o0();
            this.O00000oO = new o0000000(this.O0000O0o);
            this.O00000oO.O000000o((Inner_3dMap_locationListener) this);
            this.O00000oo.setOnceLocation(z);
            if (!z) {
                this.O00000oo.setInterval(this.O00000Oo);
            }
            this.O00000oO.O000000o(this.O00000oo);
            this.O00000oO.O000000o();
        }
        this.O000000o = z;
    }

    public void O000000o(int i) {
        if (i == 1 || i == 0) {
            O000000o(true);
        } else {
            O000000o(false);
        }
    }

    public void O000000o(long j) {
        if (!(this.O00000oo == null || this.O00000oO == null || this.O00000oo.getInterval() == j)) {
            this.O00000oo.setInterval(j);
            this.O00000oO.O000000o(this.O00000oo);
        }
        this.O00000Oo = j;
    }

    public void activate(OnLocationChangedListener onLocationChangedListener) {
        this.O00000o = onLocationChangedListener;
        if (this.O00000oO == null) {
            this.O00000oO = new o0000000(this.O0000O0o);
            this.O00000oo = new Inner_3dMap_locationOption();
            this.O00000oO.O000000o((Inner_3dMap_locationListener) this);
            this.O00000oo.setInterval(this.O00000Oo);
            this.O00000oo.setOnceLocation(this.O000000o);
            this.O00000oo.setLocationMode(Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.O00000oO.O000000o(this.O00000oo);
            this.O00000oO.O000000o();
        }
    }

    public void deactivate() {
        this.O00000o = null;
        if (this.O00000oO != null) {
            this.O00000oO.O00000Oo();
            this.O00000oO.O00000o0();
        }
        this.O00000oO = null;
    }

    public void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.O00000o != null && inner_3dMap_location != null) {
                this.O00000o0 = inner_3dMap_location.getExtras();
                if (this.O00000o0 == null) {
                    this.O00000o0 = new Bundle();
                }
                this.O00000o0.putInt("errorCode", inner_3dMap_location.getErrorCode());
                this.O00000o0.putString(MyLocationStyle.ERROR_INFO, inner_3dMap_location.getErrorInfo());
                this.O00000o0.putInt(MyLocationStyle.LOCATION_TYPE, inner_3dMap_location.getLocationType());
                this.O00000o0.putFloat("Accuracy", inner_3dMap_location.getAccuracy());
                this.O00000o0.putString("AdCode", inner_3dMap_location.getAdCode());
                this.O00000o0.putString("Address", inner_3dMap_location.getAddress());
                this.O00000o0.putString("AoiName", inner_3dMap_location.getAoiName());
                this.O00000o0.putString("City", inner_3dMap_location.getCity());
                this.O00000o0.putString("CityCode", inner_3dMap_location.getCityCode());
                this.O00000o0.putString("Country", inner_3dMap_location.getCountry());
                this.O00000o0.putString("District", inner_3dMap_location.getDistrict());
                this.O00000o0.putString("Street", inner_3dMap_location.getStreet());
                this.O00000o0.putString("StreetNum", inner_3dMap_location.getStreetNum());
                this.O00000o0.putString("PoiName", inner_3dMap_location.getPoiName());
                this.O00000o0.putString("Province", inner_3dMap_location.getProvince());
                this.O00000o0.putFloat("Speed", inner_3dMap_location.getSpeed());
                this.O00000o0.putString("Floor", inner_3dMap_location.getFloor());
                this.O00000o0.putFloat("Bearing", inner_3dMap_location.getBearing());
                this.O00000o0.putString("BuildingId", inner_3dMap_location.getBuildingId());
                this.O00000o0.putDouble("Altitude", inner_3dMap_location.getAltitude());
                inner_3dMap_location.setExtras(this.O00000o0);
                this.O00000o.onLocationChanged(inner_3dMap_location);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
