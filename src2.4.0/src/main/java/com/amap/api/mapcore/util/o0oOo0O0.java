package com.amap.api.mapcore.util;

import android.location.Location;
import com.amap.api.maps.LocationSource.OnLocationChangedListener;

/* compiled from: AMapOnLocationChangedListener */
class o0oOo0O0 implements OnLocationChangedListener {
    Location O000000o;
    private ca O00000Oo;

    o0oOo0O0(ca caVar) {
        this.O00000Oo = caVar;
    }

    public void onLocationChanged(Location location) {
        this.O000000o = location;
        try {
            if (this.O00000Oo.isMyLocationEnabled()) {
                this.O00000Oo.O000000o(location);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
