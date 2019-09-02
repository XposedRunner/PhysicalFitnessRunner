package com.amap.api.mapcore.util;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: MapLocClientUtils */
public final class av {
    at O000000o = null;

    private static AMapLocationClientOption O000000o(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setInterval(inner_3dMap_locationOption.getInterval());
        AMapLocationMode aMapLocationMode = AMapLocationMode.Hight_Accuracy;
        switch (inner_3dMap_locationOption.getLocationMode()) {
            case Battery_Saving:
                aMapLocationMode = AMapLocationMode.Battery_Saving;
                break;
            case Device_Sensors:
                aMapLocationMode = AMapLocationMode.Device_Sensors;
                break;
            default:
                aMapLocationMode = AMapLocationMode.Hight_Accuracy;
                break;
        }
        aMapLocationClientOption.setLocationMode(aMapLocationMode);
        aMapLocationClientOption.setOnceLocation(inner_3dMap_locationOption.isOnceLocation());
        aMapLocationClientOption.setNeedAddress(inner_3dMap_locationOption.isNeedAddress());
        return aMapLocationClientOption;
    }

    public static void O000000o(Object obj, Inner_3dMap_locationOption inner_3dMap_locationOption) {
        if (obj != null) {
            ((AMapLocationClient) obj).setLocationOption(O000000o(inner_3dMap_locationOption));
        }
    }

    public final void O000000o(Object obj, Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (this.O000000o == null) {
            this.O000000o = new at();
        }
        this.O000000o.O000000o(inner_3dMap_locationListener);
        ((AMapLocationClient) obj).setLocationListener(this.O000000o);
    }
}
