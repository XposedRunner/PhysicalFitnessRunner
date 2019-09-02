package com.baidu.location.indoor;

import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.a.a;

class h implements BDLocationListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        if (this.a.f()) {
            if (!(bDLocation == null || this.a.Y == null)) {
                if (bDLocation.getAddrStr() == null && this.a.Y.getAddrStr() != null) {
                    bDLocation.setAddr(this.a.Y.getAddress());
                    bDLocation.setAddrStr(this.a.Y.getAddrStr());
                }
                if (bDLocation.getPoiList() == null && this.a.Y.getPoiList() != null) {
                    bDLocation.setPoiList(this.a.Y.getPoiList());
                }
                if (bDLocation.getLocationDescribe() == null && this.a.Y.getLocationDescribe() != null) {
                    bDLocation.setLocationDescribe(this.a.Y.getLocationDescribe());
                }
            }
            if (bDLocation != null) {
                bDLocation.setUserIndoorState(1);
                bDLocation.setIndoorNetworkState(this.a.X);
                a.a().a(bDLocation);
            }
            if (bDLocation != null && bDLocation.getNetworkLocationType().equals("ml")) {
                Message obtainMessage = this.a.a.obtainMessage(SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM);
                obtainMessage.obj = bDLocation;
                obtainMessage.sendToTarget();
            }
        }
    }
}
