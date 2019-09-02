package com.qiyukf.nimlib.h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.d;
import com.qiyukf.nimlib.h.a.b.c;
import com.qiyukf.nimlib.h.d.a;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements a {
    private AtomicReference<StatusCode> a = new AtomicReference(StatusCode.UNLOGIN);
    private Context b;
    private com.qiyukf.nimlib.h.b.b c;
    private d d;
    private c e;
    private Handler f;
    private Runnable g = new Runnable() {
        public final void run() {
            if (b.this.a.get() == StatusCode.LOGINING && b.this.e != null) {
                com.qiyukf.nimlib.a.d.a.a a = com.qiyukf.nimlib.a.d.a.a.a(b.this.e.a(), ResponseCode.RES_ETIMEOUT);
                if (a != null) {
                    f.a().a(a);
                }
            }
        }
    };

    b() {
    }

    private void a(StatusCode statusCode) {
        if (this.a.get() != statusCode && !((StatusCode) this.a.get()).wontAutoLogin()) {
            if (statusCode.wontAutoLogin()) {
                this.d.a();
            }
            this.a.set(statusCode);
            this.d.a(statusCode);
            d.a(statusCode);
            com.qiyukf.nimlib.f.d.a(statusCode);
            StringBuilder stringBuilder = new StringBuilder("status change to: ");
            stringBuilder.append(statusCode);
            com.qiyukf.basesdk.a.a.d("AuthManager", stringBuilder.toString());
        }
    }

    private boolean d() {
        if (!e()) {
            return false;
        }
        this.c.a();
        a(StatusCode.CONNECTING);
        this.d.a(this.b);
        this.c.a(com.qiyukf.nimlib.h.b.b.a.a().b());
        return true;
    }

    private static boolean e() {
        LoginInfo e = com.qiyukf.nimlib.b.e();
        return e != null && e.valid();
    }

    private Handler f() {
        if (this.f == null) {
            this.f = new Handler(this.b.getMainLooper());
        }
        return this.f;
    }

    private static final String g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("PRODUCT", Build.PRODUCT);
            jSONObject.put("DEVICE", Build.DEVICE);
            jSONObject.put("MANUFACTURER", Build.MANUFACTURER);
            jSONObject.put("BRAND", Build.BRAND);
            jSONObject.put("MODEL", Build.MODEL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public final void a() {
        a(StatusCode.UNLOGIN);
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        this.b = null;
        this.c = null;
    }

    public final void a(int i) {
        StringBuilder stringBuilder = new StringBuilder("on connect change ");
        stringBuilder.append(i);
        com.qiyukf.basesdk.a.a.d("core", stringBuilder.toString());
        if (i != 0) {
            if (i == 2 && e()) {
                a(StatusCode.LOGINING);
                this.e = new c();
                c cVar = this.e;
                com.qiyukf.nimlib.h.c.b.b bVar = new com.qiyukf.nimlib.h.c.b.b();
                if (com.qiyukf.nimlib.b.c() != null) {
                    bVar.a(1, com.qiyukf.nimlib.b.c().intValue());
                }
                bVar.a(3, 1);
                bVar.a(19, com.qiyukf.nimlib.b.e().getAccount());
                bVar.a(18, com.qiyukf.nimlib.b.g());
                bVar.a(1000, com.qiyukf.nimlib.b.e().getToken());
                bVar.a(6, 16);
                bVar.a(25, com.qiyukf.nimlib.b.f());
                bVar.a(9, 1);
                stringBuilder = new StringBuilder();
                stringBuilder.append(Build.PRODUCT);
                stringBuilder.append("$$");
                stringBuilder.append(Build.MODEL);
                stringBuilder.append("$$");
                stringBuilder.append(VERSION.SDK_INT);
                bVar.a(4, stringBuilder.toString());
                bVar.a(13, e.a());
                String g = com.qiyukf.basesdk.c.d.c.g(this.b);
                if (!TextUtils.isEmpty(g)) {
                    bVar.a(5, g);
                }
                bVar.a(14, com.qiyukf.basesdk.c.d.c.j(this.b));
                g = com.qiyukf.nimlib.k.d.b.a();
                if (!TextUtils.isEmpty(g)) {
                    bVar.a(28, g);
                }
                g = com.qiyukf.nimlib.k.d.b.b();
                if (!TextUtils.isEmpty(g)) {
                    bVar.a(29, g);
                }
                bVar.a(31, com.qiyukf.nimlib.k.d.b.c());
                bVar.a(32, g());
                bVar.a(8, 1);
                cVar.a(bVar);
                f.a().a(this.e);
                f().removeCallbacks(this.g);
                f().postDelayed(this.g, StatisticConfig.MIN_UPLOAD_INTERVAL);
            }
            return;
        }
        boolean c = com.qiyukf.basesdk.c.d.c.c(this.b);
        StringBuilder stringBuilder2 = new StringBuilder("on connection broken, network connected=");
        stringBuilder2.append(c);
        com.qiyukf.basesdk.a.a.a("core", stringBuilder2.toString());
        a(c ? StatusCode.UNLOGIN : StatusCode.NET_BROKEN);
        if (!e()) {
            this.d.a();
        }
    }

    public final void a(int i, int i2) {
        StatusCode statusCode = StatusCode.KICKOUT;
        if (i == 2) {
            statusCode = StatusCode.FORBIDDEN;
        } else if (i == 3) {
            statusCode = StatusCode.KICK_BY_OTHER_CLIENT;
        }
        d.a(i2);
        com.qiyukf.nimlib.b.a(null);
        a(statusCode);
    }

    public final void a(Context context, com.qiyukf.nimlib.h.b.b bVar) {
        this.b = context;
        this.c = bVar;
        this.d = new d(this);
        if (e()) {
            a(com.qiyukf.nimlib.b.e());
        }
    }

    public final void a(LoginInfo loginInfo) {
        if (!((StatusCode) this.a.get()).logined()) {
            if (loginInfo == null || !loginInfo.valid()) {
                throw new IllegalArgumentException("LoginInfo is invalid!");
            }
            this.a.set(StatusCode.UNLOGIN);
            com.qiyukf.nimlib.b.a(loginInfo);
            d();
        }
    }

    public final void a(boolean z) {
        if (z) {
            com.qiyukf.nimlib.b.a(null);
        }
        f.a().a(new com.qiyukf.nimlib.h.a.b.d());
        a(StatusCode.UNLOGIN);
    }

    public final void b() {
        if (this.a.get() != StatusCode.LOGINING && this.a.get() != StatusCode.LOGINED) {
            d();
        }
    }

    public final void b(int i) {
        StatusCode statusCode;
        f().removeCallbacks(this.g);
        this.e = null;
        if (i != 200) {
            if (i != SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH) {
                if (i == 317) {
                    statusCode = StatusCode.VER_ERROR;
                } else if (i != 414) {
                    if (i != 417) {
                        if (i != SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED) {
                            if (i != 431) {
                                switch (i) {
                                    case SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED /*403*/:
                                        break;
                                    case 404:
                                        break;
                                }
                            }
                            statusCode = StatusCode.UNLOGIN;
                        }
                        statusCode = StatusCode.FORBIDDEN;
                    } else {
                        statusCode = StatusCode.KICKOUT;
                    }
                }
            }
            statusCode = StatusCode.PWD_ERROR;
        } else {
            statusCode = StatusCode.LOGINED;
        }
        if (statusCode.wontAutoLogin()) {
            this.c.a();
            com.qiyukf.nimlib.b.a(null);
        }
        a(statusCode);
    }

    public final void c() {
        com.qiyukf.basesdk.a.a.a("core", "on network unavailable");
        this.c.a();
        a(StatusCode.NET_BROKEN);
    }
}
