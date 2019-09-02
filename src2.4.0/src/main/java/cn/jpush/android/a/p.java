package cn.jpush.android.a;

import java.util.ArrayList;

final class p {
    public int a;
    public int b;
    public long c;
    public ArrayList<String> d;
    public String e;
    public int f = -1;
    public int g = -1;
    public int h = 0;
    public int i = 0;
    final /* synthetic */ o j;

    public p(o oVar, int i, int i2, long j, ArrayList<String> arrayList, String str) {
        this.j = oVar;
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = arrayList;
        if (i == 1 && this.d == null) {
            this.d = new ArrayList();
        }
        this.e = str;
        this.i = 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TagAliasCacheBean{protoType=");
        stringBuilder.append(this.a);
        stringBuilder.append(", actionType=");
        stringBuilder.append(this.b);
        stringBuilder.append(", seqID=");
        stringBuilder.append(this.c);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.d);
        stringBuilder.append(", alias='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append(", totalPage=");
        stringBuilder.append(this.f);
        stringBuilder.append(", currPage=");
        stringBuilder.append(this.g);
        stringBuilder.append(", retryCount=");
        stringBuilder.append(this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
