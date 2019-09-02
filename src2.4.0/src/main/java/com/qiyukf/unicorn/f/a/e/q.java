package com.qiyukf.unicorn.f.a.e;

import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;

@b(a = 58)
public class q extends e {
    @a(a = "sessionid")
    private long a;
    @a(a = "msgType")
    private String b = "text";
    @a(a = "content")
    private String c;
    @a(a = "editTime")
    private long d;
    @a(a = "sendingRate")
    private String e;

    public final void a(float f) {
        this.e = String.valueOf(f);
    }

    public final void a(long j) {
        this.a = j;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(long j) {
        this.d = j;
    }
}
