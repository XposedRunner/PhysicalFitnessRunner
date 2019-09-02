package com.umeng.commonsdk.proguard;

/* compiled from: TTransportException */
public class ax extends p {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1;
    protected int f = 0;

    public ax(int i) {
        this.f = i;
    }

    public ax(int i, String str) {
        super(str);
        this.f = i;
    }

    public ax(int i, String str, Throwable th) {
        super(str, th);
        this.f = i;
    }

    public ax(int i, Throwable th) {
        super(th);
        this.f = i;
    }

    public ax(String str) {
        super(str);
    }

    public ax(String str, Throwable th) {
        super(str, th);
    }

    public ax(Throwable th) {
        super(th);
    }

    public int a() {
        return this.f;
    }
}
