package com.qiyukf.nimlib.f.a;

import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import java.io.Serializable;

public final class b implements Serializable {
    public final StatusCode a;
    public final LoginInfo b;
    public final int c;

    public b(StatusCode statusCode, int i, LoginInfo loginInfo) {
        this.a = statusCode;
        this.c = i;
        this.b = loginInfo;
    }
}
