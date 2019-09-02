package com.baidu.location.indoor;

import com.baidu.location.BDLocation;

class s implements Runnable {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public void run() {
        if (!(this.a.j == null || this.a.a == null)) {
            BDLocation bDLocation = new BDLocation(this.a.c);
            bDLocation.setLatitude(this.a.j.getLatitude());
            bDLocation.setLongitude(this.a.j.getLongitude());
            this.a.a.a(bDLocation);
        }
        this.a.m.postDelayed(this.a.o, this.a.b);
    }
}
