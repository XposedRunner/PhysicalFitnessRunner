package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.e.e;
import com.baidu.location.indoor.q.a;

class i implements a {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public void a(BDLocation bDLocation) {
        if (this.a.f()) {
            if (this.a.ae != null && System.currentTimeMillis() - this.a.ae.c > 20000 && System.currentTimeMillis() - this.a.ae.e < 10000) {
                bDLocation.setLocType(61);
                bDLocation.setFloor(null);
                bDLocation.setBuildingID(null);
                bDLocation.setBuildingName(null);
            }
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (e.a().j()) {
                String g = e.a().g();
                if (g != null) {
                    BDLocation bDLocation3 = new BDLocation(g);
                    bDLocation2.setLocType(61);
                    bDLocation2.setSatelliteNumber(bDLocation3.getSatelliteNumber());
                    bDLocation2.setSpeed(bDLocation3.getSpeed());
                    bDLocation2.setAltitude(bDLocation3.getAltitude());
                    bDLocation2.setDirection(bDLocation3.getDirection());
                }
            }
            this.a.a(bDLocation2, 29);
            this.a.af.a(bDLocation);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a.ae != null && currentTimeMillis - this.a.ae.c > StatisticConfig.MIN_UPLOAD_INTERVAL && currentTimeMillis - this.a.ae.e > StatisticConfig.MIN_UPLOAD_INTERVAL) {
            this.a.d();
        }
    }
}
