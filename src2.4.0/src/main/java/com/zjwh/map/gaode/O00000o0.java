package com.zjwh.map.gaode;

import android.content.Context;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.baidu.mapapi.utils.CoordinateConverter.CoordType;
import defpackage.li;
import defpackage.lw;

/* compiled from: GaoDeChangeCampusControl */
public class O00000o0 implements li {
    private lw O000000o;
    private O0000Oo O00000Oo;

    public O00000o0(lw lwVar) {
        this.O000000o = lwVar;
    }

    public void O000000o() {
        if (this.O000000o != null) {
            this.O000000o = null;
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.O000000o();
            this.O00000Oo = null;
        }
    }

    public void O000000o(Context context) {
        this.O00000Oo = new O0000Oo();
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setOnceLocation(true);
        this.O00000Oo.O000000o(context, aMapLocationClientOption, new AMapLocationListener() {
            public void onLocationChanged(AMapLocation aMapLocation) {
                LatLng convert = new CoordinateConverter().from(CoordType.COMMON).coord(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())).convert();
                if (O00000o0.this.O000000o != null) {
                    O00000o0.this.O000000o.O000000o(aMapLocation.getLatitude(), aMapLocation.getLongitude(), convert.latitude, convert.longitude);
                }
            }
        }, false);
    }
}
