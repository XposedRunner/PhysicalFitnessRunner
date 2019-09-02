package com.umeng.socialize;

public class SocializeException extends RuntimeException {
    private static final long b = 1;
    protected int a = 5000;
    private String c = "";

    public SocializeException(int i, String str) {
        super(str);
        this.a = i;
        this.c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.c = str;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.c = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getMessage() {
        return this.c;
    }
}
