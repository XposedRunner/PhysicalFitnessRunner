package com.qiyukf.unicorn.f.a.d;

import android.content.Context;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;

@b(a = 6)
public class k extends e {
    @a(a = "sessionid")
    private long a;
    @a(a = "evaluate")
    private int b;
    @a(a = "evaluation_auto_popup")
    private int c;
    @a(a = "message")
    private String d;
    @a(a = "close_reason")
    private int e;

    public final long a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.c == 1;
    }

    public boolean countToUnread() {
        return true;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public String getContent(Context context) {
        return this.d;
    }
}
