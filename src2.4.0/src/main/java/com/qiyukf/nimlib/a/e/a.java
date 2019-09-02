package com.qiyukf.nimlib.a.e;

import android.text.TextUtils;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.d;
import com.qiyukf.nimlib.e.f;
import com.qiyukf.nimlib.e.h;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.sdk.auth.OnlineClient;
import com.qiyukf.unicorn.api.SavePowerConfig;

public class a extends h implements AuthService {
    public void changeSaverMode(int i) {
        c.a().a(i);
    }

    public int getKickedClientType() {
        return d.h();
    }

    public InvocationFuture<Void> kickOtherClient(OnlineClient onlineClient) {
        if (onlineClient instanceof com.qiyukf.nimlib.a.a) {
            com.qiyukf.nimlib.a.c.a aVar = new com.qiyukf.nimlib.a.c.c.a(((com.qiyukf.nimlib.a.a) onlineClient).a());
            aVar.a(h.b());
            c.a().a(aVar);
        }
        return null;
    }

    public AbortableFuture<LoginInfo> login(LoginInfo loginInfo) {
        c.a().a(h.b(), loginInfo);
        return new f<LoginInfo>(loginInfo) {
            public final boolean abort() {
                a.this.logout();
                return false;
            }
        };
    }

    public InvocationFuture<Void> logout() {
        c.a().c();
        com.qiyukf.nimlib.e.a.c(h.b().b(null));
        return null;
    }

    public boolean openLocalCache(String str) {
        return com.qiyukf.nimlib.c.c.a().b() ? true : TextUtils.isEmpty(str) ? false : com.qiyukf.nimlib.c.c.a().a(b.a(), str);
    }

    public void updateSavePowerConfig(SavePowerConfig savePowerConfig) {
        c.a().a(savePowerConfig);
    }
}
