package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.model.LatLng;

public class PoiParaOption {
    String a;
    String b;
    LatLng c;
    int d;

    public PoiParaOption center(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public LatLng getCenter() {
        return this.c;
    }

    public String getKey() {
        return this.b;
    }

    public int getRadius() {
        return this.d;
    }

    public String getUid() {
        return this.a;
    }

    public PoiParaOption key(String str) {
        this.b = str;
        return this;
    }

    public PoiParaOption radius(int i) {
        this.d = i;
        return this;
    }

    public PoiParaOption uid(String str) {
        this.a = str;
        return this;
    }
}
