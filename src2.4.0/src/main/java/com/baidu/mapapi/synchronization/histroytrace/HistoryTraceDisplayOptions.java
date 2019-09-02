package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;

public class HistoryTraceDisplayOptions {
    private BitmapDescriptor a = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");
    private BitmapDescriptor b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");
    private BitmapDescriptor c = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
    private BitmapDescriptor d = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Gray_Arrow.png");
    private int e = 22;
    private boolean f = true;
    private boolean g = true;
    private boolean h = false;
    private boolean i = true;
    private boolean j = true;
    private int k = 30;
    private int l = 30;
    private int m = 30;
    private int n = 30;

    public BitmapDescriptor getCarIcon() {
        return this.c;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.b;
    }

    public int getPaddingBottom() {
        return this.n;
    }

    public int getPaddingLeft() {
        return this.k;
    }

    public int getPaddingRight() {
        return this.l;
    }

    public int getPaddingTop() {
        return this.m;
    }

    public BitmapDescriptor getRouteLineTexture() {
        return this.d;
    }

    public int getRouteLineWidth() {
        return this.e;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.a;
    }

    public boolean isRouteLineRenderBySubSection() {
        return this.j;
    }

    public boolean isShowCarIcon() {
        return this.h;
    }

    public boolean isShowEndPositionIcon() {
        return this.g;
    }

    public boolean isShowRoutePlan() {
        return this.i;
    }

    public boolean isShowStartPositionIcon() {
        return this.f;
    }

    public HistoryTraceDisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        this.c = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.b = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingBottom(int i) {
        this.n = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingLeft(int i) {
        this.k = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingRight(int i) {
        this.l = i;
        return this;
    }

    public HistoryTraceDisplayOptions setPaddingTop(int i) {
        this.m = i;
        return this;
    }

    public void setRouteLineRenderBySubSection(boolean z) {
        this.j = z;
    }

    public HistoryTraceDisplayOptions setRouteLineTexture(BitmapDescriptor bitmapDescriptor) {
        this.d = bitmapDescriptor;
        return this;
    }

    public HistoryTraceDisplayOptions setRouteLineWidth(int i) {
        int i2 = 5;
        if (i >= 5) {
            i2 = 40;
            if (i <= 40) {
                this.e = i;
                return this;
            }
        }
        this.e = i2;
        return this;
    }

    public HistoryTraceDisplayOptions setShowCarIcon(boolean z) {
        this.h = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowEndPositionIcon(boolean z) {
        this.g = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowRoutePlan(boolean z) {
        this.i = z;
        return this;
    }

    public HistoryTraceDisplayOptions setShowStartPositionIcon(boolean z) {
        this.f = z;
        return this;
    }

    public HistoryTraceDisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        this.a = bitmapDescriptor;
        return this;
    }
}
