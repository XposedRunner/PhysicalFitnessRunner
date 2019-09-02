package cn.jpush.android.data;

public final class e {
    private long a;
    private int b;
    private int c;
    private int d;
    private String e;
    private long f;
    private long g;

    public e() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = 0;
        this.g = 0;
    }

    public final long a() {
        return this.a;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final void b(long j) {
        this.g = j;
    }

    public final int c() {
        return this.c;
    }

    public final void c(int i) {
        this.d = i;
    }

    public final void c(long j) {
        this.f = j;
    }

    public final String d() {
        return this.e;
    }

    public final long e() {
        return this.g;
    }

    public final long f() {
        return this.f;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LocalNotificationDBData [ln_id=");
        stringBuilder.append(this.a);
        stringBuilder.append(", ln_count=");
        stringBuilder.append(this.b);
        stringBuilder.append(", ln_remove=");
        stringBuilder.append(this.c);
        stringBuilder.append(", ln_type=");
        stringBuilder.append(this.d);
        stringBuilder.append(", ln_extra=");
        stringBuilder.append(this.e);
        stringBuilder.append(", ln_trigger_time=");
        stringBuilder.append(this.f);
        stringBuilder.append(", ln_add_time=");
        stringBuilder.append(this.g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
