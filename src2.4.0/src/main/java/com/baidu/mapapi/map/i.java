package com.baidu.mapapi.map;

class i implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ HeatMap d;

    i(HeatMap heatMap, int i, int i2, int i3) {
        this.d = heatMap;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public void run() {
        this.d.b(this.a, this.b, this.c);
    }
}
