package com.baidu.mapapi.map;

import android.graphics.Point;

class g {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public g(double d, double d2, double d3, double d4) {
        this.a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public boolean a(double d, double d2) {
        return this.a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public boolean a(double d, double d2, double d3, double d4) {
        return d < this.c && this.a < d2 && d3 < this.d && this.b < d4;
    }

    public boolean a(Point point) {
        return a((double) point.x, (double) point.y);
    }

    public boolean a(g gVar) {
        return a(gVar.a, gVar.c, gVar.b, gVar.d);
    }

    public boolean b(g gVar) {
        return gVar.a >= this.a && gVar.c <= this.c && gVar.b >= this.b && gVar.d <= this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("minX: ");
        stringBuilder2.append(this.a);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" minY: ");
        stringBuilder2.append(this.b);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" maxX: ");
        stringBuilder2.append(this.c);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" maxY: ");
        stringBuilder2.append(this.d);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" midX: ");
        stringBuilder2.append(this.e);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(" midY: ");
        stringBuilder2.append(this.f);
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }
}
