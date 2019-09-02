package com.qiyukf.nimlib.e;

import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    transient b a = new b();
    transient c b = new c();
    private int c = a.a();
    private boolean d;
    private transient boolean e;

    private static final class a {
        private static AtomicInteger a = new AtomicInteger(0);

        public static int a() {
            return a.incrementAndGet();
        }
    }

    static final class b {
        String a;
        Object[] b;

        b() {
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(" uri: ");
            stringBuilder.append(this.a);
            return stringBuilder.toString();
        }
    }

    static final class c {
        int a;
        Object b;

        c() {
        }

        public final String toString() {
            if (this.a == 0) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder(", result: ");
            stringBuilder.append(this.a);
            return stringBuilder.toString();
        }
    }

    public final i a(int i) {
        this.b.a = i;
        return this;
    }

    public final i a(Object obj) {
        this.b.b = obj;
        return this;
    }

    public final i a(boolean z) {
        this.d = z;
        return this;
    }

    public final i a(Object[] objArr) {
        this.a.b = objArr;
        return this;
    }

    public final String a() {
        return this.a.a.substring(this.a.a.indexOf(47) + 1);
    }

    public final i b(Object obj) {
        this.b.a = 200;
        this.b.b = obj;
        return this;
    }

    public final i b(boolean z) {
        this.e = z;
        return this;
    }

    public final Object[] b() {
        return this.a.b;
    }

    public final int c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Transaction: [id: ");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append(this.a);
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
