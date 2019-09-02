package com.zjwh.map.gaode;

import android.app.Notification;
import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zjwh.sw.map.O00000Oo;

/* compiled from: GaoDeLocationHelper */
public class O0000Oo {
    public static final int O000000o = 123456789;
    private AMapLocationClient O00000Oo = null;
    private AMapLocationListener O00000o;
    private Notification O00000o0;

    public void O000000o() {
        if (this.O00000Oo != null) {
            this.O00000Oo.stopLocation();
            this.O00000Oo.unRegisterLocationListener(this.O00000o);
            this.O00000Oo.onDestroy();
            this.O00000Oo = null;
        }
    }

    public void O000000o(final Context context, AMapLocationClientOption aMapLocationClientOption, final AMapLocationListener aMapLocationListener, boolean z) {
        this.O00000Oo = new AMapLocationClient(context);
        if (z) {
            if (this.O00000o0 == null) {
                this.O00000o0 = new Notification();
            }
            this.O00000Oo.enableBackgroundLocation(O000000o, this.O00000o0);
        }
        this.O00000Oo.setLocationOption(aMapLocationClientOption);
        this.O00000o = new AMapLocationListener() {
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null && O0000Oo.this.O00000Oo != null && O0000Oo.this.O00000Oo.isStarted()) {
                    com.zjwh.sw.map.O00000Oo.O000000o(context, aMapLocation.getLatitude(), aMapLocation.getLongitude());
                    if (aMapLocationListener != null) {
                        aMapLocationListener.onLocationChanged(aMapLocation);
                    }
                }
            }
        };
        this.O00000Oo.setLocationListener(this.O00000o);
        this.O00000Oo.startLocation();
    }
}
