package cn.jiguang.a.a.a;

public final class b {
    private String a;
    private String b;
    private String c;
    private String d;

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return this.d;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final void d(String str) {
        this.d = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ArpInfo{ip_Addr='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", hw_type='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", flag='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", hw_addr='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
