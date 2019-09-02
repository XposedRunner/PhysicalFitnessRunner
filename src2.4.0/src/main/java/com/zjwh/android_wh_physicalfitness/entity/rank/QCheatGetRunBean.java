package com.zjwh.android_wh_physicalfitness.entity.rank;

import com.zjwh.sw.map.entity.SWLatLng;

public class QCheatGetRunBean {
    private SWLatLng northEast;
    private SWLatLng southWest;
    private int unid;

    public QCheatGetRunBean(SWLatLng sWLatLng, SWLatLng sWLatLng2, int i) {
        this.northEast = sWLatLng;
        this.southWest = sWLatLng2;
        this.unid = i;
    }

    public SWLatLng getNorthEast() {
        return this.northEast;
    }

    public SWLatLng getSouthWest() {
        return this.southWest;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setNorthEast(SWLatLng sWLatLng) {
        this.northEast = sWLatLng;
    }

    public void setSouthWest(SWLatLng sWLatLng) {
        this.southWest = sWLatLng;
    }

    public void setUnid(int i) {
        this.unid = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QCheatGetRunBean{northEast=");
        stringBuilder.append(this.northEast);
        stringBuilder.append(", southWest=");
        stringBuilder.append(this.southWest);
        stringBuilder.append(", unid=");
        stringBuilder.append(this.unid);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
