package com.qiyukf.unicorn.f;

import com.qiyukf.nimlib.sdk.auth.LoginInfo;

public final class b {
    private LoginInfo a;
    private String b;
    private boolean c;
    private boolean d;

    public final LoginInfo a() {
        return this.a;
    }

    public final void a(LoginInfo loginInfo) {
        this.a = loginInfo;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean b() {
        return this.d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("auth: ");
        stringBuilder.append(this.a);
        stringBuilder.append("\r\nexchanges: ");
        stringBuilder.append(this.b);
        stringBuilder.append("\r\npush: ");
        stringBuilder.append(this.c);
        stringBuilder.append("\r\nisHisAccount: ");
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }
}
