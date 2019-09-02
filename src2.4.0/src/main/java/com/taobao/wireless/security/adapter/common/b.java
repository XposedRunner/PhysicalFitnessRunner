package com.taobao.wireless.security.adapter.common;

public class b {
    public String a;
    public int b;
    public String c;

    public b(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public b(String str, int i, Throwable th) {
        this.a = str;
        this.b = i;
        if (th != null) {
            this.c = th.toString();
        }
    }
}
