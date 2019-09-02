package com.qiyukf.unicorn.g;

import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.unicorn.f.a.e.h;
import com.qiyukf.unicorn.f.a.e.p;
import com.qiyukf.unicorn.h.c;

public final class b {
    public static void a() {
        if (!com.qiyukf.unicorn.b.b.n()) {
            String l = com.qiyukf.unicorn.b.b.l();
            if (!TextUtils.isEmpty(l)) {
                h hVar = new h();
                hVar.a(l);
                c.a(hVar, c.a(), true).setCallback(new RequestCallbackWrapper<Void>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        if (i == 200) {
                            com.qiyukf.unicorn.b.b.m();
                        }
                    }
                });
            }
        }
    }

    public static void a(final boolean z) {
        p pVar = new p();
        pVar.a(z);
        c.a(pVar, c.a(), true).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200 && z) {
                    ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(2);
                }
            }
        });
    }
}
