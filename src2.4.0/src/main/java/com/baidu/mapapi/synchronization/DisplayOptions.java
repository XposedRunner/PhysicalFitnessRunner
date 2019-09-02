package com.baidu.mapapi.synchronization;

import android.view.View;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;
import java.util.ArrayList;
import java.util.List;

public final class DisplayOptions {
    private static final String a = "DisplayOptions";
    private View A;
    private View B;
    private View C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private List<BitmapDescriptor> R;
    private BitmapDescriptor b;
    private boolean c;
    private boolean d;
    private int e;
    private BitmapDescriptor f;
    private boolean g;
    private boolean h;
    private int i;
    private BitmapDescriptor j;
    private boolean k;
    private boolean l;
    private int m;
    private BitmapDescriptor n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private boolean s;
    private int t;
    private BitmapDescriptor u;
    private BitmapDescriptor v;
    private BitmapDescriptor w;
    private BitmapDescriptor x;
    private BitmapDescriptor y;
    private int z;

    public DisplayOptions() {
        this.e = 6;
        this.i = 7;
        this.k = true;
        this.l = true;
        this.m = 8;
        this.q = 10;
        this.t = 5;
        this.D = true;
        this.E = true;
        this.F = 6;
        this.G = true;
        this.H = true;
        this.I = 7;
        this.J = true;
        this.K = true;
        this.L = 8;
        this.M = 50;
        this.N = 50;
        this.O = 50;
        this.P = 50;
        this.R = new ArrayList();
        this.b = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Start.png");
        this.c = true;
        this.d = true;
        this.f = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_End.png");
        this.g = true;
        this.h = true;
        this.j = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Car.png");
        this.k = true;
        this.l = true;
        this.n = BitmapDescriptorFactory.fromAssetWithDpi("SDK_Default_Icon_Passenger.png");
        this.o = true;
        this.p = true;
        this.r = true;
        this.s = true;
        this.u = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Smooth.png");
        this.v = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Slow.png");
        this.w = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_Congestion.png");
        this.x = BitmapDescriptorFactory.fromAsset("SDK_Default_Traffic_Texture_SevereCongestion.png");
        this.y = BitmapDescriptorFactory.fromAsset("SDK_Default_Route_Texture_Bule_Arrow.png");
        this.z = 22;
    }

    public boolean get3DCarMarkerEnable() {
        return this.Q;
    }

    public List<BitmapDescriptor> get3DCarMarkerIconList() {
        return this.R;
    }

    public BitmapDescriptor getCarIcon() {
        return this.j;
    }

    public View getCarInfoWindowView() {
        return this.A;
    }

    public int getCarPositionInfoWindowZIndex() {
        return this.L;
    }

    public int getCarPositionMarkerZIndex() {
        return this.m;
    }

    public BitmapDescriptor getEndPositionIcon() {
        return this.f;
    }

    public View getEndPositionInfoWindowView() {
        return this.C;
    }

    public int getEndPositionInfoWindowZIndex() {
        return this.I;
    }

    public int getEndPositionMarkerZIndex() {
        return this.i;
    }

    public int getPaddingBottom() {
        return this.P;
    }

    public int getPaddingLeft() {
        return this.M;
    }

    public int getPaddingRight() {
        return this.N;
    }

    public int getPaddingTop() {
        return this.O;
    }

    public BitmapDescriptor getPassengerIcon() {
        return this.n;
    }

    public int getPassengerMarkerZIndex() {
        return this.q;
    }

    public int getRouteLineWidth() {
        return this.z;
    }

    public int getRouteLineZIndex() {
        return this.t;
    }

    public BitmapDescriptor getStartPositionIcon() {
        return this.b;
    }

    public View getStartPositionInfoWindowView() {
        return this.B;
    }

    public int getStartPositionInfoWindowZIndex() {
        return this.F;
    }

    public int getStartPositionMarkerZIndex() {
        return this.e;
    }

    public List<BitmapDescriptor> getTrafficTextureList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.y);
        arrayList.add(this.u);
        arrayList.add(this.v);
        arrayList.add(this.w);
        arrayList.add(this.x);
        return arrayList;
    }

    public boolean isShowCarInfoWindow() {
        return this.J;
    }

    public boolean isShowCarMarker() {
        return this.k;
    }

    public boolean isShowCarMarkerInSpan() {
        return this.l;
    }

    public boolean isShowEndPositionInfoWindow() {
        return this.G;
    }

    public boolean isShowEndPositionMarker() {
        return this.g;
    }

    public boolean isShowEndPositionMarkerInSpan() {
        return this.h;
    }

    public boolean isShowPassengerIcon() {
        return this.o;
    }

    public boolean isShowPassengerIconInSpan() {
        return this.p;
    }

    public boolean isShowRoutePlan() {
        return this.r;
    }

    public boolean isShowRoutePlanInSpan() {
        return this.s;
    }

    public boolean isShowStartPositionInfoWindow() {
        return this.D;
    }

    public boolean isShowStartPositionMarker() {
        return this.c;
    }

    public boolean isShowStartPositionMarkerInSpan() {
        return this.d;
    }

    public DisplayOptions set3DCarMarkerEnable(boolean z) {
        this.Q = z;
        return this;
    }

    public DisplayOptions set3DCarMarkerIconList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            this.R = null;
            return this;
        }
        this.R.addAll(list);
        return this;
    }

    public DisplayOptions setCarIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("CarIcon descriptor is null");
        }
        this.j = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setCarInfoWindowView(View view) {
        this.A = view;
        return this;
    }

    public DisplayOptions setCarPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.L = i;
        return this;
    }

    public DisplayOptions setCarPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.m = i;
        return this;
    }

    public DisplayOptions setCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("CongestionTrafficTexture descriptor is null");
        }
        this.w = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setEndPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("EndPositionIcon descriptor is null");
        }
        this.f = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setEndPositionInfoWindowView(View view) {
        this.C = view;
        return this;
    }

    public DisplayOptions setEndPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.I = i;
        return this;
    }

    public DisplayOptions setEndPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.i = i;
        return this;
    }

    public DisplayOptions setMapViewPadding(int i, int i2, int i3, int i4) {
        if (i < 0 || i3 < 0 || i2 < 0 || i4 < 0) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Padding param is invalid. paddingLeft = ");
            stringBuilder.append(i);
            stringBuilder.append("; paddingRight = ");
            stringBuilder.append(i3);
            stringBuilder.append("; paddingTop = ");
            stringBuilder.append(i2);
            stringBuilder.append("; paddingBottom = ");
            stringBuilder.append(i4);
            a.b(str, stringBuilder.toString());
        }
        if (i < 0) {
            i = 30;
        }
        this.M = i;
        if (i2 < 0) {
            i2 = 30;
        }
        this.O = i2;
        if (i3 < 0) {
            i3 = 30;
        }
        this.N = i3;
        if (i4 < 0) {
            i4 = 50;
        }
        this.P = i4;
        return this;
    }

    public DisplayOptions setPassengerIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("PassengerIcon descriptor is null");
        }
        this.n = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setPassengerMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.q = i;
        return this;
    }

    public DisplayOptions setRouteLineWidth(int i) {
        int i2 = 5;
        if (i >= 5) {
            i2 = 40;
            if (i <= 40) {
                this.z = i;
                return this;
            }
        }
        this.z = i2;
        return this;
    }

    public DisplayOptions setRouteLineZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.t = i;
        return this;
    }

    public DisplayOptions setSevereCongestionTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SevereCongestionTrafficTexture descriptor is null");
        }
        this.x = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setSlowTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SlowTrafficTexture descriptor is null");
        }
        this.v = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setSmoothTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("SmoothTrafficTexture descriptor is null");
        }
        this.u = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setStartPositionIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("StartPositionIcon descriptor is null");
        }
        this.b = bitmapDescriptor;
        return this;
    }

    public DisplayOptions setStartPositionInfoWindowView(View view) {
        this.B = view;
        return this;
    }

    public DisplayOptions setStartPositionInfoWindowZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.F = i;
        return this;
    }

    public DisplayOptions setStartPositionMarkerZIndex(int i) {
        if (i <= 1) {
            i = 2;
        }
        this.e = i;
        return this;
    }

    public DisplayOptions setUnknownTrafficTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("UnknownTrafficTexture descriptor is null");
        }
        this.y = bitmapDescriptor;
        return this;
    }

    public DisplayOptions showCarIcon(boolean z) {
        this.k = z;
        return this;
    }

    public DisplayOptions showCarIconInSpan(boolean z) {
        this.l = z;
        return this;
    }

    public DisplayOptions showCarInfoWindow(boolean z) {
        this.J = z;
        return this;
    }

    public DisplayOptions showCarInfoWindowInSpan(boolean z) {
        this.K = z;
        return this;
    }

    public DisplayOptions showEndPositionIcon(boolean z) {
        this.g = z;
        return this;
    }

    public DisplayOptions showEndPositionIconInSpan(boolean z) {
        this.h = z;
        return this;
    }

    public DisplayOptions showEndPositionInfoWindow(boolean z) {
        this.G = z;
        return this;
    }

    public DisplayOptions showEndPositionInfoWindowInSpan(boolean z) {
        this.H = z;
        return this;
    }

    public DisplayOptions showPassengereIcon(boolean z) {
        this.o = z;
        return this;
    }

    public DisplayOptions showPassengereIconInSpan(boolean z) {
        this.p = z;
        return this;
    }

    public DisplayOptions showRoutePlan(boolean z) {
        this.r = z;
        return this;
    }

    public DisplayOptions showRoutePlanInSpan(boolean z) {
        this.s = z;
        return this;
    }

    public DisplayOptions showStartPositionIcon(boolean z) {
        this.c = z;
        return this;
    }

    public DisplayOptions showStartPositionIconInSpan(boolean z) {
        this.d = z;
        return this;
    }

    public DisplayOptions showStartPositionInfoWindow(boolean z) {
        this.D = z;
        return this;
    }

    public DisplayOptions showStartPositionInfoWindowInSpan(boolean z) {
        this.E = z;
        return this;
    }
}
