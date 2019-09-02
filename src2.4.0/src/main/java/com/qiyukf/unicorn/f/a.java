package com.qiyukf.unicorn.f;

import android.os.Handler;
import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.YSFUserInfo;
import com.qiyukf.unicorn.b.b;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.e;
import com.qiyukf.unicorn.f.a.e.r;
import com.qiyukf.unicorn.h.c;
import com.qiyukf.unicorn.j.g;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private String a = b.g();
    private AtomicBoolean b = new AtomicBoolean(false);
    private Handler c = com.qiyukf.basesdk.c.a.b();
    private RequestCallback<Void> d;
    private int e = 1;
    private a f = new a(this, (byte) 0);
    private Observer<StatusCode> g = new Observer<StatusCode>() {
        public final /* synthetic */ void onEvent(Object obj) {
            StatusCode statusCode = (StatusCode) obj;
            if (statusCode == StatusCode.LOGINED) {
                a.this.e = 0;
                a.this.c.removeCallbacks(a.this.f);
                a.this.b.set(false);
                d.h().b();
                d.g().g();
                com.qiyukf.unicorn.g.b.a();
                a.j(a.this);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - b.r() >= LogBuilder.MAX_INTERVAL) {
                    c.a(new r(d.c()), c.a(), true);
                    b.a(currentTimeMillis);
                }
                return;
            }
            if (statusCode.wontAutoLogin()) {
                a.this.a((a.this.e * 10) * 1000);
            }
        }
    };
    private Observer<CustomNotification> h = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            e attachment = ((CustomNotification) obj).getAttachment();
            if (attachment.getCmdId() == 41) {
                if (((com.qiyukf.unicorn.f.a.d.b) attachment).a() == 1) {
                    a.this.b(200);
                    return;
                }
                a.this.b(414);
            }
        }
    };
    private Runnable i = new Runnable() {
        public final void run() {
            a.this.b(408);
        }
    };

    /* renamed from: com.qiyukf.unicorn.f.a$3 */
    class AnonymousClass3 extends com.qiyukf.unicorn.j.a<Void, b> {
        final /* synthetic */ String a;

        AnonymousClass3(String str, String str2) {
            this.a = str2;
            super(str);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object a() {
            return c.a(this.a, b.d());
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void a(Object obj) {
            b bVar = (b) obj;
            if (a.this.b.get()) {
                if (bVar == null || bVar.a() == null) {
                    a.this.a((a.this.e * 10) * 1000);
                } else {
                    a.b(bVar.a());
                    if (bVar.b()) {
                        ((AuthService) NIMClient.getService(AuthService.class)).openLocalCache(bVar.a().getAccount());
                    }
                    com.qiyukf.nim.uikit.b.a(bVar.a().getAccount());
                    ((AuthService) NIMClient.getService(AuthService.class)).login(bVar.a()).setCallback(new RequestCallbackWrapper<LoginInfo>() {
                        public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                            if (i == 200) {
                                a.d();
                            }
                        }
                    });
                    ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(0);
                    com.qiyukf.unicorn.g.b.a(false);
                }
            }
        }
    }

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void run() {
            new AnonymousClass3("Unicorn-HTTP", d.d()).a(new Void[0]);
            a.this.e = a.this.e + 1;
        }
    }

    public a() {
        ((AuthServiceObserver) NIMClient.getService(AuthServiceObserver.class)).observeOnlineStatus(this.g, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.h, true);
        if (b() == null) {
            a(0);
            String q = b.q();
            if (!TextUtils.isEmpty(q)) {
                JSONObject a = com.qiyukf.basesdk.c.b.a(q);
                if (a != null) {
                    com.qiyukf.basesdk.c.b.e(a, "foreignid");
                    a();
                }
            }
            return;
        }
        d();
    }

    private void a(int i) {
        b.e();
        b(null);
        this.b.set(true);
        this.c.removeCallbacks(this.f);
        this.c.postDelayed(this.f, (long) i);
    }

    static /* synthetic */ void a(a aVar, String str, String str2) {
        aVar.a = str;
        b.f(str);
        if (!TextUtils.isEmpty(str)) {
            b.a(str, str2);
        }
        if (d.e().isPullMessageFromServer) {
            g.a(Boolean.valueOf(true));
        }
    }

    private boolean a(final YSFUserInfo ySFUserInfo) {
        String str = ySFUserInfo.data;
        boolean z = TextUtils.isEmpty(str) || com.qiyukf.basesdk.c.b.b(str) != null;
        if (z) {
            if (TextUtils.isEmpty(ySFUserInfo.userId)) {
                ySFUserInfo.userId = this.a;
            }
            com.qiyukf.unicorn.f.a.e.b bVar = new com.qiyukf.unicorn.f.a.e.b();
            bVar.a(ySFUserInfo.userId);
            bVar.c(ySFUserInfo.authToken);
            bVar.b(ySFUserInfo.data);
            final String toJson = bVar.toJson(true);
            b.o(toJson);
            if (!a()) {
                return true;
            }
            c.a(bVar, c.a(), false).setCallback(new RequestCallbackWrapper<Void>() {
                public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                    if (i == 200) {
                        if (TextUtils.isEmpty(a.this.a) && !TextUtils.isEmpty(ySFUserInfo.userId)) {
                            String c = b.c(ySFUserInfo.userId);
                            if (!TextUtils.isEmpty(c)) {
                                ((MsgService) NIMClient.getService(MsgService.class)).migrateMessages(c, com.qiyukf.nim.uikit.b.b(), true);
                            }
                        }
                        if (toJson.equals(b.q())) {
                            b.o(null);
                        }
                        a.a(a.this, ySFUserInfo.userId, com.qiyukf.nim.uikit.b.b());
                        b.g(ySFUserInfo.data);
                    }
                    if (TextUtils.isEmpty(ySFUserInfo.authToken) || !(TextUtils.isEmpty(ySFUserInfo.authToken) || i == 200)) {
                        a.this.b(i);
                    }
                }
            });
            return true;
        }
        com.qiyukf.basesdk.a.a.a("AM", "user data is not json array");
        return false;
    }

    public static LoginInfo b() {
        LoginInfo loginInfo = new LoginInfo(b.a(), b.b());
        com.qiyukf.nim.uikit.b.a(loginInfo.getAccount());
        return loginInfo.valid() ? loginInfo : null;
    }

    private void b(int i) {
        RequestCallback requestCallback = this.d;
        this.d = null;
        if (requestCallback != null) {
            this.c.removeCallbacks(this.i);
            if (i == 200) {
                requestCallback.onSuccess(null);
            } else {
                requestCallback.onFailed(i);
            }
        }
    }

    private static void b(LoginInfo loginInfo) {
        String str;
        if (loginInfo == null) {
            str = null;
            b.a(null);
        } else {
            b.a(loginInfo.getAccount());
            str = loginInfo.getToken();
        }
        b.b(str);
    }

    private static void d() {
        d.a();
        d.h().a();
    }

    static /* synthetic */ void j(a aVar) {
        String q = b.q();
        if (!TextUtils.isEmpty(q)) {
            JSONObject a = com.qiyukf.basesdk.c.b.a(q);
            if (a != null) {
                YSFUserInfo ySFUserInfo = new YSFUserInfo();
                ySFUserInfo.userId = com.qiyukf.basesdk.c.b.e(a, "foreignid");
                ySFUserInfo.authToken = com.qiyukf.basesdk.c.b.e(a, "authToken");
                ySFUserInfo.data = com.qiyukf.basesdk.c.b.e(a, "userinfo");
                aVar.a(ySFUserInfo);
            }
        }
    }

    public final boolean a() {
        if (com.qiyukf.nimlib.b.e() != null) {
            return true;
        }
        if (!this.b.get()) {
            a(0);
        }
        return false;
    }

    public final boolean a(YSFUserInfo ySFUserInfo, RequestCallback<Void> requestCallback) {
        int i = 0;
        if (ySFUserInfo == null) {
            if (this.b.compareAndSet(true, false)) {
                this.c.removeCallbacks(this.f);
            }
            if (!TextUtils.isEmpty(this.a)) {
                d.g().f();
                this.c.postDelayed(new Runnable() {
                    public final void run() {
                        ((AuthService) NIMClient.getService(AuthService.class)).logout();
                        a.b(null);
                        com.qiyukf.nimlib.d.a(StatusCode.UNLOGIN);
                        a.this.a = null;
                        b.e();
                        b.f(null);
                        b.g(null);
                        d.h().c();
                        a.this.a(0);
                    }
                }, 100);
            }
            if (requestCallback != null) {
                requestCallback.onSuccess(null);
            }
            return true;
        }
        String str;
        String str2;
        String str3 = ySFUserInfo.userId;
        if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(str3)) {
            str = "AM";
            str2 = "anonymous user can not update user info";
        } else if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(str3) || str3.equals(this.a)) {
            if (requestCallback != null) {
                this.c.postDelayed(this.i, 45000);
                this.d = requestCallback;
            }
            Object jSONObject = new JSONObject();
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "key", "sdk_version");
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "value", "46");
            com.qiyukf.basesdk.c.b.a((JSONObject) jSONObject, "hidden", Boolean.valueOf(true));
            JSONArray b = com.qiyukf.basesdk.c.b.b(ySFUserInfo.data);
            JSONArray jSONArray = new JSONArray();
            if (b != null) {
                while (i < b.length()) {
                    Object b2 = com.qiyukf.basesdk.c.b.b(b, i);
                    if (!"sdk_version".equals(com.qiyukf.basesdk.c.b.e(b2, "key"))) {
                        com.qiyukf.basesdk.c.b.a(jSONArray, b2);
                    }
                    i++;
                }
            }
            com.qiyukf.basesdk.c.b.a(jSONArray, jSONObject);
            ySFUserInfo.data = jSONArray.toString();
            str2 = b.h();
            if (TextUtils.isEmpty(this.a) || !TextUtils.equals(str2, ySFUserInfo.data)) {
                return a(ySFUserInfo);
            }
            b(200);
            return true;
        } else {
            str = "AM";
            str2 = "should logout first before switch userId";
        }
        com.qiyukf.basesdk.a.a.a(str, str2);
        return false;
    }
}
