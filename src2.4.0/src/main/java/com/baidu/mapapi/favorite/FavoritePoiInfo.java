package com.baidu.mapapi.favorite;

import com.baidu.mapapi.model.LatLng;

public class FavoritePoiInfo {
    String a;
    String b;
    LatLng c;
    String d;
    String e;
    String f;
    long g;

    public FavoritePoiInfo addr(String str) {
        this.d = str;
        return this;
    }

    public FavoritePoiInfo cityName(String str) {
        this.e = str;
        return this;
    }

    public String getAddr() {
        return this.d;
    }

    public String getCityName() {
        return this.e;
    }

    public String getID() {
        return this.a;
    }

    public String getPoiName() {
        return this.b;
    }

    public LatLng getPt() {
        return this.c;
    }

    public long getTimeStamp() {
        return this.g;
    }

    public String getUid() {
        return this.f;
    }

    public FavoritePoiInfo poiName(String str) {
        this.b = str;
        return this;
    }

    public FavoritePoiInfo pt(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public FavoritePoiInfo uid(String str) {
        this.f = str;
        return this;
    }
}
