package com.qiyukf.unicorn.f.a.d;

import android.content.Context;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.c;
import com.qiyukf.unicorn.f.a.e;

@b(a = 65)
public class h extends e implements c {
    @a(a = "content")
    private String a;

    public final String a() {
        return this.a;
    }

    public final String a(Context context) {
        return com.qiyukf.unicorn.j.c.a(this.a);
    }

    public boolean countToUnread() {
        return true;
    }

    public String getContent(Context context) {
        return com.qiyukf.unicorn.j.c.a(this.a).replace("\n", " ");
    }
}
