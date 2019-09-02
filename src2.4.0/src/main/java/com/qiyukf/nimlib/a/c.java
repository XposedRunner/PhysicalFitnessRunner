package com.qiyukf.nimlib.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.e;
import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.a.b.b;
import com.qiyukf.nimlib.a.f.d;
import com.qiyukf.nimlib.e.a;
import com.qiyukf.nimlib.e.i;
import com.qiyukf.nimlib.h.c.c.f;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.api.SavePowerConfig;
import java.util.ArrayList;

public class c {
    private static c f;
    private static long h;
    private d a = new d();
    private e b = new e("Response", e.c, false);
    private b c = new b(false, this.b, this.a);
    private com.qiyukf.nimlib.f.b d = new com.qiyukf.nimlib.f.b(com.qiyukf.nimlib.b.a());
    private i e;
    private StatusCode g = StatusCode.UNLOGIN;

    public static c a() {
        if (f == null) {
            synchronized (c.class) {
                if (f == null) {
                    f = new c();
                }
            }
        }
        return f;
    }

    public static void a(ArrayList<a> arrayList) {
        com.qiyukf.nimlib.d.a((ArrayList) arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AuthServiceObserver.class.getSimpleName());
        stringBuilder.append("/observeOtherClients");
        a.a(stringBuilder.toString(), arrayList);
    }

    private void e() {
        com.qiyukf.nimlib.b.a(null);
        com.qiyukf.nimlib.i.b.a().b();
        this.b.b();
        this.a.b();
        com.qiyukf.nimlib.c.c.a().c();
        b();
    }

    private synchronized void f() {
        if (!(TextUtils.isEmpty(com.qiyukf.nimlib.b.b()) || com.qiyukf.nimlib.c.c.a().b())) {
            com.qiyukf.nimlib.c.c.a().a(com.qiyukf.nimlib.b.a(), com.qiyukf.nimlib.b.b());
        }
    }

    public final com.qiyukf.nimlib.a.c.a a(com.qiyukf.nimlib.a.d.a aVar) {
        return this.a.c(aVar);
    }

    public final void a(int i) {
        this.d.a(i);
    }

    public final void a(com.qiyukf.nimlib.a.d.a.a aVar) {
        this.c.a(aVar);
    }

    public final void a(i iVar, LoginInfo loginInfo) {
        if (com.qiyukf.nimlib.d.e() == StatusCode.LOGINED) {
            iVar.b(com.qiyukf.nimlib.b.e());
            a.c(iVar);
            return;
        }
        com.qiyukf.nimlib.b.a(loginInfo);
        this.e = iVar;
        this.d.a(loginInfo);
    }

    public final void a(com.qiyukf.nimlib.f.a.a aVar) {
        com.qiyukf.nimlib.a.d.a.a aVar2 = new com.qiyukf.nimlib.a.d.a.a();
        aVar2.a = aVar.b();
        if (aVar.c() != null) {
            aVar2.b = new f(aVar.c());
        }
        this.c.a(aVar2);
    }

    public final void a(com.qiyukf.nimlib.f.a.b bVar) {
        com.qiyukf.nimlib.d.a(bVar.c);
        com.qiyukf.nimlib.b.a(bVar.b);
        StringBuilder stringBuilder = new StringBuilder("set status from ");
        stringBuilder.append(this.g);
        stringBuilder.append(" to ");
        stringBuilder.append(bVar.a);
        com.qiyukf.basesdk.a.a.a("uicore", stringBuilder.toString());
        if ((bVar.a != StatusCode.CONNECTING && bVar.a != StatusCode.LOGINING) || this.g != StatusCode.LOGINED) {
            com.qiyukf.nimlib.d.a(bVar.a);
            if (bVar.a.logined()) {
                f();
            } else if (bVar.a.wontAutoLogin()) {
                e();
            } else if (!(this.e == null || this.g.shouldReLogin() || !bVar.a.shouldReLogin())) {
                a((short) ResponseCode.RES_ECONNECTION);
            }
            if ((!this.g.logined() || bVar.a.logined()) && this.g != bVar.a && bVar.a == StatusCode.LOGINED) {
                this.a.c();
                com.qiyukf.nimlib.j.a.a().a(com.qiyukf.nimlib.b.a());
            }
            this.g = bVar.a;
            StatusCode statusCode = this.g;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(AuthServiceObserver.class.getSimpleName());
            stringBuilder2.append("/observeOnlineStatus");
            a.a(stringBuilder2.toString(), statusCode);
        }
    }

    public final void a(SavePowerConfig savePowerConfig) {
        this.d.a(savePowerConfig);
    }

    public final void a(short s) {
        if (this.e != null) {
            this.e.a((int) s);
            if (s == ResponseCode.RES_SUCCESS) {
                f();
                this.e.a(com.qiyukf.nimlib.b.e());
            } else {
                com.qiyukf.nimlib.b.a(null);
            }
            a.c(this.e);
            this.e = null;
        }
    }

    public final boolean a(com.qiyukf.nimlib.a.c.a aVar) {
        return a(aVar, com.qiyukf.nimlib.a.f.a.a);
    }

    public final boolean a(com.qiyukf.nimlib.a.c.a aVar, com.qiyukf.nimlib.a.f.a aVar2) {
        return a(new com.qiyukf.nimlib.a.f.b(aVar, aVar2));
    }

    public final boolean a(com.qiyukf.nimlib.a.f.c cVar) {
        boolean z = false;
        if (cVar == null) {
            return false;
        }
        com.qiyukf.nimlib.a.c.a b = cVar.b();
        b.a().a(b.a(false));
        if (com.qiyukf.nimlib.d.e() == StatusCode.LOGINED) {
            z = true;
        }
        boolean a = cVar.d() > 0 ? this.a.a(cVar) : z;
        d();
        if (z) {
            this.d.a(new com.qiyukf.nimlib.f.a.a(b));
        }
        if (!a) {
            cVar.a((short) ResponseCode.RES_ECONNECTION);
        }
        return a;
    }

    public final void b() {
        this.b.a();
        this.a.a();
        f();
    }

    public final void c() {
        this.e = null;
        this.d.a();
        com.qiyukf.nimlib.d.a(StatusCode.UNLOGIN);
        e();
    }

    public final void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - h > 10000) {
            h = elapsedRealtime;
            this.d.b();
        }
    }
}
