package com.umeng.commonsdk.proguard;

/* compiled from: TProtocolException */
public class aj extends p {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    private static final long h = 1;
    protected int g = 0;

    public aj(int i) {
        this.g = i;
    }

    public aj(int i, String str) {
        super(str);
        this.g = i;
    }

    public aj(int i, String str, Throwable th) {
        super(str, th);
        this.g = i;
    }

    public aj(int i, Throwable th) {
        super(th);
        this.g = i;
    }

    public aj(String str) {
        super(str);
    }

    public aj(String str, Throwable th) {
        super(str, th);
    }

    public aj(Throwable th) {
        super(th);
    }

    public int a() {
        return this.g;
    }
}
