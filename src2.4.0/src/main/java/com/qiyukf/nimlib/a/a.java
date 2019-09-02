package com.qiyukf.nimlib.a;

import android.text.TextUtils;
import com.qiyukf.nimlib.h.c.b.b;
import com.qiyukf.nimlib.sdk.auth.OnlineClient;

public final class a implements OnlineClient {
    private static final long serialVersionUID = 1;
    private int a;
    private String b;
    private int c;
    private String d;
    private String e;
    private String f;

    public static a a(b bVar) {
        a aVar = new a();
        aVar.a = bVar.b(3);
        aVar.b = bVar.a(4);
        aVar.c = bVar.b(109);
        aVar.d = bVar.a(103);
        aVar.e = bVar.a(102);
        aVar.f = bVar.a(13);
        return aVar;
    }

    public final String a() {
        return this.f;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        return TextUtils.equals(this.f, ((a) obj).f);
    }

    public final String getClientIp() {
        return this.d;
    }

    public final int getClientType() {
        return this.a;
    }

    public final int getLoginTime() {
        return this.c;
    }

    public final String getOs() {
        return this.b;
    }
}
