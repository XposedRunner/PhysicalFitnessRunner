package com.zjwh.map.gaode;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener;
import defpackage.lk;
import defpackage.lu;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GaoDeDownloadOfflineMapControl */
public class O0000O0o implements OfflineMapDownloadListener, lk {
    private OfflineMapManager O000000o;
    private lu O00000Oo;
    private O0000Oo O00000o0;

    public O0000O0o(Context context) {
        this.O000000o = new OfflineMapManager(context, this);
    }

    private OfflineMapCity O00000oO(String str) {
        ArrayList offlineMapCityList = this.O000000o.getOfflineMapCityList();
        if (offlineMapCityList != null && offlineMapCityList.size() > 0) {
            Iterator it = offlineMapCityList.iterator();
            while (it.hasNext()) {
                OfflineMapCity offlineMapCity = (OfflineMapCity) it.next();
                if (offlineMapCity.getCity().equals(str)) {
                    return offlineMapCity;
                }
            }
        }
        return null;
    }

    public void O000000o() {
        if (this.O000000o != null) {
            this.O000000o.destroy();
            this.O000000o = null;
        }
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o();
            this.O00000o0 = null;
        }
        this.O00000Oo = null;
    }

    public void O000000o(Context context) {
        this.O00000o0 = new O0000Oo();
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setOnceLocation(true);
        aMapLocationClientOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        this.O00000o0.O000000o(context, aMapLocationClientOption, new AMapLocationListener() {
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (O0000O0o.this.O00000Oo != null && aMapLocation != null) {
                    String city = aMapLocation.getCity();
                    O0000O0o.this.O00000Oo.O000000o(city);
                    OfflineMapCity O000000o = O0000O0o.this.O00000oO(city);
                    if (O000000o == null) {
                        O0000O0o.this.O00000o0(city);
                    } else {
                        O0000O0o.this.O00000Oo.O000000o(city, O000000o.getcompleteCode(), O000000o.getState() == 4);
                    }
                }
            }
        }, true);
    }

    public void O000000o(String str) {
        try {
            this.O000000o.downloadByCityName(str);
        } catch (AMapException e) {
            e.printStackTrace();
        }
    }

    public void O000000o(lu luVar) {
        this.O00000Oo = luVar;
    }

    public void O00000Oo(String str) {
        this.O000000o.pause();
    }

    public void O00000o(String str) {
        this.O000000o.remove(str);
    }

    public void O00000o0(String str) {
        if (!TextUtils.isEmpty(str)) {
            OfflineMapCity itemByCityName = this.O000000o.getItemByCityName(str);
            if (itemByCityName != null) {
                if (this.O00000Oo != null) {
                    this.O00000Oo.O000000o(itemByCityName.getCity(), itemByCityName.getSize());
                }
            } else if (this.O00000Oo != null) {
                this.O00000Oo.O000000o();
            }
        }
    }

    public void onCheckUpdate(boolean z, String str) {
    }

    public void onDownload(int i, int i2, String str) {
        if (this.O00000Oo != null) {
            this.O00000Oo.O000000o(i2, i);
        }
    }

    public void onRemove(boolean z, String str, String str2) {
    }
}
