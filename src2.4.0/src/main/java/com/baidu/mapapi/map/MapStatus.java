package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.ab;

public final class MapStatus implements Parcelable {
    public static final Creator<MapStatus> CREATOR = new j();
    ab a;
    private double b;
    public final LatLngBounds bound;
    private double c;
    public final float overlook;
    public final float rotate;
    public final LatLng target;
    public final Point targetScreen;
    public WinRound winRound;
    public final float zoom;

    public static final class Builder {
        private float a = -2.14748365E9f;
        private LatLng b = null;
        private float c = -2.14748365E9f;
        private float d = -2.14748365E9f;
        private Point e = null;
        private LatLngBounds f = null;
        private double g = 0.0d;
        private double h = 0.0d;
        private final float i = 15.0f;

        public Builder(MapStatus mapStatus) {
            this.a = mapStatus.rotate;
            this.b = mapStatus.target;
            this.c = mapStatus.overlook;
            this.d = mapStatus.zoom;
            this.e = mapStatus.targetScreen;
            this.g = mapStatus.a();
            this.h = mapStatus.b();
        }

        private float a(float f) {
            return 15.0f == f ? 15.5f : f;
        }

        public MapStatus build() {
            return new MapStatus(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder overlook(float f) {
            this.c = f;
            return this;
        }

        public Builder rotate(float f) {
            this.a = f;
            return this;
        }

        public Builder target(LatLng latLng) {
            this.b = latLng;
            return this;
        }

        public Builder targetScreen(Point point) {
            this.e = point;
            return this;
        }

        public Builder zoom(float f) {
            this.d = a(f);
            return this;
        }
    }

    MapStatus(float f, LatLng latLng, float f2, float f3, Point point, double d, double d2, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.b = d;
        this.c = d2;
        this.bound = latLngBounds;
    }

    MapStatus(float f, LatLng latLng, float f2, float f3, Point point, LatLngBounds latLngBounds) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        if (this.target != null) {
            this.b = CoordUtil.ll2mc(this.target).getLongitudeE6();
            this.c = CoordUtil.ll2mc(this.target).getLatitudeE6();
        }
        this.bound = latLngBounds;
    }

    MapStatus(float f, LatLng latLng, float f2, float f3, Point point, ab abVar, double d, double d2, LatLngBounds latLngBounds, WinRound winRound) {
        this.rotate = f;
        this.target = latLng;
        this.overlook = f2;
        this.zoom = f3;
        this.targetScreen = point;
        this.a = abVar;
        this.b = d;
        this.c = d2;
        this.bound = latLngBounds;
        this.winRound = winRound;
    }

    protected MapStatus(Parcel parcel) {
        this.rotate = parcel.readFloat();
        this.target = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.overlook = parcel.readFloat();
        this.zoom = parcel.readFloat();
        this.targetScreen = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.bound = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
        this.b = parcel.readDouble();
        this.c = parcel.readDouble();
    }

    static MapStatus a(ab abVar) {
        ab abVar2 = abVar;
        if (abVar2 == null) {
            return null;
        }
        float f = (float) abVar2.b;
        double d = abVar2.e;
        double d2 = abVar2.d;
        LatLng mc2ll = CoordUtil.mc2ll(new GeoPoint(d, d2));
        float f2 = (float) abVar2.c;
        float f3 = abVar2.a;
        Point point = new Point(abVar2.f, abVar2.g);
        LatLng mc2ll2 = CoordUtil.mc2ll(new GeoPoint((double) abVar2.k.e.y, (double) abVar2.k.e.x));
        LatLng mc2ll3 = CoordUtil.mc2ll(new GeoPoint((double) abVar2.k.f.y, (double) abVar2.k.f.x));
        double d3 = d;
        LatLng mc2ll4 = CoordUtil.mc2ll(new GeoPoint((double) abVar2.k.h.y, (double) abVar2.k.h.x));
        LatLng mc2ll5 = CoordUtil.mc2ll(new GeoPoint((double) abVar2.k.g.y, (double) abVar2.k.g.x));
        com.baidu.mapapi.model.LatLngBounds.Builder builder = new com.baidu.mapapi.model.LatLngBounds.Builder();
        builder.include(mc2ll2);
        builder.include(mc2ll3);
        builder.include(mc2ll4);
        builder.include(mc2ll5);
        return new MapStatus(f, mc2ll, f2, f3, point, abVar2, d2, d3, builder.build(), abVar2.j);
    }

    /* Access modifiers changed, original: 0000 */
    public double a() {
        return this.b;
    }

    /* Access modifiers changed, original: 0000 */
    public double b() {
        return this.c;
    }

    /* Access modifiers changed, original: 0000 */
    public ab b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        if (this.rotate != -2.14748365E9f) {
            abVar.b = (int) this.rotate;
        }
        if (this.zoom != -2.14748365E9f) {
            abVar.a = this.zoom;
        }
        if (this.overlook != -2.14748365E9f) {
            abVar.c = (int) this.overlook;
        }
        if (this.target != null) {
            abVar.d = this.b;
            abVar.e = this.c;
        }
        if (this.targetScreen != null) {
            abVar.f = this.targetScreen.x;
            abVar.g = this.targetScreen.y;
        }
        return abVar;
    }

    /* Access modifiers changed, original: 0000 */
    public ab c() {
        return b(new ab());
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (this.target != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("target lat: ");
            stringBuilder.append(this.target.latitude);
            stringBuilder.append("\n");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("target lng: ");
            stringBuilder.append(this.target.longitude);
            stringBuilder.append("\n");
            stringBuilder2.append(stringBuilder.toString());
        }
        if (this.targetScreen != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("target screen x: ");
            stringBuilder.append(this.targetScreen.x);
            stringBuilder.append("\n");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("target screen y: ");
            stringBuilder.append(this.targetScreen.y);
            stringBuilder.append("\n");
            stringBuilder2.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("zoom: ");
        stringBuilder.append(this.zoom);
        stringBuilder.append("\n");
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("rotate: ");
        stringBuilder.append(this.rotate);
        stringBuilder.append("\n");
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("overlook: ");
        stringBuilder.append(this.overlook);
        stringBuilder.append("\n");
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.rotate);
        parcel.writeParcelable(this.target, i);
        parcel.writeFloat(this.overlook);
        parcel.writeFloat(this.zoom);
        parcel.writeParcelable(this.targetScreen, i);
        parcel.writeParcelable(this.bound, i);
        parcel.writeDouble(this.b);
        parcel.writeDouble(this.c);
    }
}
