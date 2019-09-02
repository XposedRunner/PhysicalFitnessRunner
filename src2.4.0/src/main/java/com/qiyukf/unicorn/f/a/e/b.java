package com.qiyukf.unicorn.f.a.e;

import android.text.TextUtils;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.e;

@com.qiyukf.unicorn.f.a.b.b(a = 52)
public final class b extends e {
    @a(a = "foreignid")
    private String a;
    @a(a = "authToken")
    private String b;
    @a(a = "userinfo")
    private String c;

    public final void a(String str) {
        this.a = str;
    }

    public final void b(String str) {
        this.c = str;
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.b = str;
    }
}
