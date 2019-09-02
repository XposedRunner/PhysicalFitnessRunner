package com.baidu.mapsdkplatform.comapi.synchronization.render;

import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLngBounds;

class c implements Runnable {
    final /* synthetic */ LatLngBounds a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ b f;

    c(b bVar, LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        this.f = bVar;
        this.a = latLngBounds;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void run() {
        this.f.b.setMapStatus(MapStatusUpdateFactory.newLatLngZoom(this.a, this.b, this.c, this.d, this.e));
    }
}
