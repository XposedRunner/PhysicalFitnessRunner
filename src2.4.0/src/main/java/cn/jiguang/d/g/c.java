package cn.jiguang.d.g;

public final class c {
    private static c a;
    private static final Object c = new Object();
    private a b;

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public final a b() {
        if (this.b == null) {
            this.b = new b();
        }
        return this.b;
    }
}
