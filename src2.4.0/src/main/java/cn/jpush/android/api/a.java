package cn.jpush.android.api;

import java.util.Set;

public final class a {
    public String a;
    public Set<String> b;
    public TagAliasCallback c;
    public int d;
    public int e = 0;
    public int f = 0;
    private long g;

    public a(int i, String str, long j, int i2, int i3) {
        this.d = i;
        this.a = str;
        this.g = j;
        this.e = i2;
        this.f = i3;
    }

    public a(int i, Set<String> set, long j, int i2, int i3) {
        this.d = i;
        this.b = set;
        this.g = j;
        this.e = i2;
        this.f = i3;
    }

    public a(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j, int i, int i2) {
        this.a = str;
        this.b = set;
        this.c = tagAliasCallback;
        this.g = j;
        this.e = i;
        this.f = i2;
    }

    public final boolean a(long j) {
        return this.e == 0 && System.currentTimeMillis() - this.g > StatisticConfig.MIN_UPLOAD_INTERVAL;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CallBackParams{sendTime=");
        stringBuilder.append(this.g);
        stringBuilder.append(", alias='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", tags=");
        stringBuilder.append(this.b);
        stringBuilder.append(", tagAliasCallBack=");
        stringBuilder.append(this.c);
        stringBuilder.append(", sequence=");
        stringBuilder.append(this.d);
        stringBuilder.append(", protoType=");
        stringBuilder.append(this.e);
        stringBuilder.append(", action=");
        stringBuilder.append(this.f);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
