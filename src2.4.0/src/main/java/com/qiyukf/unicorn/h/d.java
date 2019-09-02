package com.qiyukf.unicorn.h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.nim.uikit.session.viewholder.c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.ProductDetail;
import com.qiyukf.unicorn.api.event.entry.RequestStaffEntry;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.OnPushMessageListener;
import com.qiyukf.unicorn.api.msg.SessionStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.api.pop.POPManager;
import com.qiyukf.unicorn.e.e;
import com.qiyukf.unicorn.e.g;
import com.qiyukf.unicorn.e.i;
import com.qiyukf.unicorn.e.j;
import com.qiyukf.unicorn.e.k;
import com.qiyukf.unicorn.f.a.a.a.l;
import com.qiyukf.unicorn.f.a.d.m;
import com.qiyukf.unicorn.f.a.d.o;
import com.qiyukf.unicorn.f.a.e.n;
import com.qiyukf.unicorn.f.a.f;
import com.qiyukf.unicorn.ui.b.a.p;
import com.qiyukf.unicorn.ui.b.a.q;
import com.qiyukf.unicorn.ui.b.a.r;
import com.qiyukf.unicorn.ui.b.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private f a;
    private Map<String, k> b = new HashMap();
    private Map<String, Runnable> c = new HashMap();
    private ConsultSource d;
    private j e;
    private i f;
    private a g;
    private b h;
    private Map<String, com.qiyukf.unicorn.e.d> i = new HashMap();
    private a j;
    private Map<String, ProductDetail> k = new HashMap();
    private Map<String, List<com.qiyukf.unicorn.f.a.c.a>> l = new HashMap();
    private Map<String, g> m = new HashMap();
    private LongSparseArray<g> n = new LongSparseArray();
    private Map<String, Long> o = new HashMap();
    private Map<String, com.qiyukf.unicorn.e.a> p = new HashMap();
    private Map<String, Long> q = new HashMap();
    private Context r;
    private Map<String, e> s = new HashMap();
    private Handler t;
    private boolean u;
    private Observer<CustomNotification> v = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (customNotification.getSessionType() == SessionTypeEnum.Ysf) {
                com.qiyukf.unicorn.f.a.e attachment = customNotification.getAttachment();
                if (attachment != null) {
                    d.a(d.this, customNotification.getTime(), customNotification.getSessionId(), attachment);
                }
            }
        }
    };
    private Observer<IMMessage> w = new Observer<IMMessage>() {
        public final /* synthetic */ void onEvent(Object obj) {
            IMMessage iMMessage = (IMMessage) obj;
            if (iMMessage.getSessionType() == SessionTypeEnum.Ysf) {
                a.a(iMMessage);
            }
        }
    };
    private Observer<List<IMMessage>> x = new Observer<List<IMMessage>>() {
        public final /* synthetic */ void onEvent(Object obj) {
            List<IMMessage> list = (List) obj;
            if (((IMMessage) list.get(0)).getSessionType() == SessionTypeEnum.Ysf) {
                for (IMMessage iMMessage : list) {
                    if (iMMessage.getAttachment() instanceof com.qiyukf.unicorn.f.a.d.a) {
                        com.qiyukf.unicorn.f.a.d.a aVar = (com.qiyukf.unicorn.f.a.d.a) iMMessage.getAttachment();
                        d.this.e.a(aVar.b(), aVar.c(), aVar.k());
                        com.qiyukf.unicorn.b.b.m(aVar.b());
                        d.this.f.a(aVar.o());
                    }
                    d.this.h.a(iMMessage);
                    int a = c.a(iMMessage);
                    if (iMMessage.getDirect() == MsgDirectionEnum.In && !(iMMessage.getAttachment() instanceof o)) {
                        k kVar = (k) d.this.b.get(iMMessage.getSessionId());
                        if (a != 2) {
                            String o = kVar == null ? com.qiyukf.unicorn.b.b.o() : kVar.d;
                            if (TextUtils.isEmpty(o)) {
                                o = j.a(iMMessage.getSessionId());
                            }
                            iMMessage.setFromAccount(o);
                        }
                        ((MsgService) NIMClient.getService(MsgService.class)).updateMessage(iMMessage, false);
                    }
                    if (iMMessage.getAttachment() instanceof com.qiyukf.unicorn.f.a.d.i) {
                        long c = d.this.c(iMMessage.getSessionId());
                        if (c <= 0) {
                            c = d.this.f(iMMessage.getSessionId());
                        }
                        if (c > 0) {
                            ((com.qiyukf.unicorn.f.a.d.i) iMMessage.getAttachment()).a(c);
                            ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, false);
                        }
                    }
                }
                a.a((IMMessage) list.get(0));
            }
        }
    };

    public interface a {
        void a();

        void a(String str);

        void a(String str, com.qiyukf.unicorn.e.b bVar);
    }

    private static class b implements Runnable {
        private String a;

        private b(String str) {
            this.a = str;
        }

        /* synthetic */ b(String str, byte b) {
            this(str);
        }

        public final void run() {
            com.qiyukf.unicorn.f.a.d.a aVar = new com.qiyukf.unicorn.f.a.d.a();
            aVar.f();
            aVar.a(this.a);
            com.qiyukf.nimlib.e.b.a(MessageBuilder.createCustomNotification(aVar, this.a));
        }
    }

    public d(Context context) {
        this.t = new Handler(context.getMainLooper());
        this.a = f.a();
        this.b = new HashMap();
        this.e = new j();
        this.f = new i();
        this.g = new a();
        this.h = new b(this.f, this.e);
        ((MsgService) NIMClient.getService(MsgService.class)).registerCustomAttachmentParser(this.a);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.v, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeMsgStatus(this.w, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeReceiveMessage(this.x, true);
        c.a(com.qiyukf.unicorn.f.a.d.a.class, com.qiyukf.nim.uikit.session.viewholder.j.class);
        c.a(com.qiyukf.unicorn.f.a.e.a.class, com.qiyukf.unicorn.ui.b.g.class);
        c.a(com.qiyukf.unicorn.f.a.e.c.class, com.qiyukf.unicorn.ui.b.b.class);
        c.a(com.qiyukf.unicorn.f.a.d.i.class, com.qiyukf.unicorn.ui.b.e.class);
        c.a(o.class, h.class);
        c.a(n.class, com.qiyukf.unicorn.ui.b.f.class);
        c.a(ProductAttachment.class, com.qiyukf.unicorn.ui.b.c.class);
        c.a(com.qiyukf.unicorn.f.a.d.h.class, com.qiyukf.unicorn.ui.b.d.class);
        c.a(m.class, com.qiyukf.nim.uikit.session.viewholder.j.class);
        c.a(com.qiyukf.unicorn.f.a.d.k.class, com.qiyukf.nim.uikit.session.viewholder.j.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.a.class, com.qiyukf.unicorn.ui.b.a.c.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.b.class, com.qiyukf.unicorn.ui.b.a.d.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.g.class, com.qiyukf.unicorn.ui.b.a.k.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.j.class, com.qiyukf.unicorn.ui.b.a.n.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.k.class, com.qiyukf.unicorn.ui.b.a.o.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.m.class, q.class);
        c.a(l.class, p.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.n.class, r.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.f.class, com.qiyukf.unicorn.ui.b.a.h.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.i.class, com.qiyukf.unicorn.ui.b.a.l.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.e.class, com.qiyukf.unicorn.ui.b.a.f.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.c.class, com.qiyukf.unicorn.ui.b.a.g.class);
        c.a(com.qiyukf.unicorn.f.a.a.a.h.class, com.qiyukf.unicorn.ui.b.a.m.class);
        c.a(com.qiyukf.unicorn.a.a.a.a.b.b.class, com.qiyukf.unicorn.ui.b.a.j.class);
        c.a(com.qiyukf.unicorn.f.a.a.b.c.class, r.class);
        c.a(com.qiyukf.unicorn.f.a.a.b.a.class, com.qiyukf.unicorn.ui.b.a.i.class);
        c.a(com.qiyukf.unicorn.f.a.a.b.b.class, r.class);
    }

    private static IMMessage a(long j, String str) {
        return MessageBuilder.createEmptyMessage(str, SessionTypeEnum.Ysf, j);
    }

    private void a(final String str, long j) {
        com.qiyukf.unicorn.e.d dVar = (com.qiyukf.unicorn.e.d) this.i.get(str);
        if (dVar != null) {
            if (dVar.e == null) {
                dVar.e = new Runnable() {
                    public final void run() {
                        com.qiyukf.unicorn.f.a.e.g gVar = new com.qiyukf.unicorn.f.a.e.g();
                        gVar.a(com.qiyukf.unicorn.b.b.d());
                        c.a(gVar, str, false);
                    }
                };
            }
            this.t.removeCallbacks(dVar.e);
            this.t.postDelayed(dVar.e, j);
        }
    }

    private void a(String str, long j, com.qiyukf.unicorn.f.a.d.e eVar) {
        Collection a;
        Log.i("attachment:", eVar.a());
        Long valueOf = Long.valueOf(this.q.get(str) == null ? 0 : ((Long) this.q.get(str)).longValue());
        ArrayList<com.qiyukf.nimlib.i.a> arrayList = new ArrayList();
        if (valueOf.longValue() == 0) {
            a = com.qiyukf.nimlib.i.f.a((com.qiyukf.nimlib.i.a) a(j, str), QueryDirectionEnum.QUERY_OLD, 20, true);
        } else if (valueOf.longValue() <= j) {
            a = com.qiyukf.nimlib.i.f.a((com.qiyukf.nimlib.i.a) a(valueOf.longValue(), str), valueOf.longValue(), j);
        } else {
            return;
        }
        arrayList.addAll(a);
        for (com.qiyukf.nimlib.i.a aVar : arrayList) {
            if (aVar.getStatus() == MsgStatusEnum.unread && aVar.getTime() < j) {
                aVar.setStatus(MsgStatusEnum.read);
                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(aVar, true);
            }
        }
        this.q.put(str, Long.valueOf(j));
    }

    private void a(String str, com.qiyukf.unicorn.f.a.d.a aVar) {
        String str2 = str;
        Runnable runnable = (Runnable) this.c.remove(str2);
        if (runnable != null) {
            this.t.removeCallbacks(runnable);
        }
        this.b.remove(str2);
        int a = aVar.a();
        if (a == SecExceptionCode.SEC_ERROR_STA_STORE_INVALID_PARAM || a == SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE) {
            this.f.a(aVar.o());
        }
        if (a == 200) {
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
            k kVar = new k(aVar.e());
            kVar.d = aVar.b();
            kVar.e = aVar.c();
            kVar.f = aVar.d();
            kVar.g = aVar.i();
            kVar.h = aVar.j();
            kVar.b = aVar.l();
            kVar.c = aVar.m();
            this.b.put(str2, kVar);
            q(str);
            if (com.qiyukf.unicorn.d.h() != null) {
                com.qiyukf.unicorn.d.h().a(str2, SessionStatusEnum.IN_SESSION);
            }
            if (com.qiyukf.unicorn.b.b.h(str) != kVar.a) {
                com.qiyukf.unicorn.b.b.a(str2, kVar.a);
                int i = 0;
                com.qiyukf.unicorn.b.b.a(str2, 0);
                if (kVar.g != 1) {
                    i = 1;
                }
                com.qiyukf.unicorn.b.b.b(str2, i);
                com.qiyukf.unicorn.b.b.c(str2, null);
                com.qiyukf.unicorn.b.b.a(str2, aVar.n());
            }
            if (kVar.g != 1 && kVar.g == 0) {
                com.qiyukf.unicorn.i.b.a().b();
            }
            this.p.put(str2, aVar.p());
        } else {
            com.qiyukf.unicorn.c h;
            SessionStatusEnum sessionStatusEnum;
            if (a == SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE) {
                ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(1);
                this.i.put(str2, new com.qiyukf.unicorn.e.d(aVar.e(), aVar.g(), aVar.h(), aVar.q(), aVar.r(), aVar.s()));
                a(str2, 10000);
                q(str);
                h = com.qiyukf.unicorn.d.h();
                sessionStatusEnum = SessionStatusEnum.IN_QUEUE;
            } else {
                h = com.qiyukf.unicorn.d.h();
                sessionStatusEnum = SessionStatusEnum.NONE;
            }
            h.a(str2, sessionStatusEnum);
        }
        if (a == 200 || a == SecExceptionCode.SEC_ERROR_STA_STORE_INVALID_PARAM || a == SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE_DATA) {
            m(str);
        }
    }

    private void a(String str, boolean z, com.qiyukf.unicorn.e.b bVar, RequestStaffEntry requestStaffEntry) {
        b bVar2 = new b(str, (byte) 0);
        this.c.put(str, bVar2);
        this.t.postDelayed(bVar2, com.qiyukf.basesdk.c.d.c.b(com.qiyukf.unicorn.d.c()) ? 15000 : 3000);
        m(str);
        com.qiyukf.unicorn.f.a.e.j jVar = new com.qiyukf.unicorn.f.a.e.j();
        jVar.g(com.qiyukf.unicorn.d.c().getPackageName());
        jVar.a((int) z);
        if (this.d != null) {
            jVar.a(this.d.uri);
            jVar.b(this.d.title);
            jVar.c(this.d.custom);
            jVar.b(this.d.groupId);
            jVar.a(this.d.staffId);
            jVar.d(this.d.faqGroupId);
            jVar.b(this.d.robotFirst);
            jVar.c(this.d.vipLevel);
            jVar.e(this.d.robotId);
            if (!(requestStaffEntry == null || requestStaffEntry.getProductDetail() == null)) {
                this.d.productDetail = requestStaffEntry.getProductDetail();
            }
        }
        jVar.d("Android");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.BRAND);
        stringBuilder.append("$$");
        stringBuilder.append(VERSION.RELEASE);
        jVar.e(stringBuilder.toString());
        jVar.f(com.qiyukf.nimlib.b.h());
        jVar.a();
        if (bVar != null) {
            jVar.a(bVar.b());
            jVar.b(bVar.a());
            jVar.c(bVar.d);
        }
        if (requestStaffEntry != null) {
            jVar.a(requestStaffEntry.getUri());
            jVar.b(requestStaffEntry.getTitle());
            jVar.c(requestStaffEntry.getCustom());
            jVar.d(requestStaffEntry.getFaqGroupId());
            jVar.e(requestStaffEntry.getRobotId());
            jVar.c(requestStaffEntry.getEntryId());
            jVar.b(requestStaffEntry.isRobotFirst());
            jVar.c(requestStaffEntry.getVipLevel());
            jVar.e(requestStaffEntry.getRobotId());
            jVar.b(requestStaffEntry.getGroupId());
            jVar.a(requestStaffEntry.getStaffId());
        }
        c.a(jVar, str, false);
        this.b.remove(str);
        com.qiyukf.unicorn.d.h().a(str, SessionStatusEnum.NONE);
        if (this.j != null) {
            this.j.a(str, bVar);
        }
    }

    public static IMMessage i(String str) {
        IMMessage r = r(str);
        return (r == null || !((o) r.getAttachment()).d()) ? null : r;
    }

    private void i() {
        if (!this.u && this.b.size() == 0 && this.i.size() == 0) {
            ((AuthService) NIMClient.getService(AuthService.class)).changeSaverMode(0);
        }
    }

    private static void q(String str) {
        if (!com.qiyukf.unicorn.d.h().b(str)) {
            com.qiyukf.nimlib.i.a aVar = (com.qiyukf.nimlib.i.a) POPManager.queryLastMessage(str);
            if (aVar == null) {
                aVar = (com.qiyukf.nimlib.i.a) MessageBuilder.createEmptyMessage(str, SessionTypeEnum.Ysf, System.currentTimeMillis());
                aVar.setStatus(MsgStatusEnum.success);
                aVar.a(MsgTypeEnum.tips.getValue());
                aVar.setContent("");
            }
            com.qiyukf.nimlib.e.b.a(com.qiyukf.nimlib.i.g.a(aVar));
        }
    }

    private static IMMessage r(String str) {
        IMMessage a;
        try {
            a = com.qiyukf.nimlib.i.f.a(str, SessionTypeEnum.Ysf.getValue());
        } catch (Exception unused) {
            a = null;
        }
        return (a == null || !(a.getAttachment() instanceof o)) ? null : a;
    }

    public final int a(String str) {
        com.qiyukf.unicorn.e.d dVar = (com.qiyukf.unicorn.e.d) this.i.get(str);
        return dVar == null ? 0 : dVar.b;
    }

    public final j a() {
        return this.e;
    }

    public final void a(Context context) {
        this.r = context;
    }

    public final void a(ConsultSource consultSource) {
        this.d = consultSource;
    }

    public final void a(OnPushMessageListener onPushMessageListener) {
        this.h.a(onPushMessageListener);
    }

    public final void a(a aVar) {
        this.j = aVar;
    }

    public final void a(String str, ProductDetail productDetail) {
        this.k.put(str, productDetail);
    }

    public final void a(String str, List<com.qiyukf.unicorn.f.a.c.a> list) {
        this.l.put(str, list);
    }

    public final void a(String str, boolean z) {
        this.u = z;
        i();
        if (this.i.containsKey(str)) {
            if (z) {
                a(str, 0);
                return;
            }
            com.qiyukf.unicorn.e.d dVar = (com.qiyukf.unicorn.e.d) this.i.get(str);
            if (!(dVar == null || dVar.e == null)) {
                this.t.removeCallbacks(dVar.e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089  */
    /* JADX WARNING: Missing block: B:18:0x0074, code skipped:
            if (r11.b > 0) goto L_0x005a;
     */
    /* JADX WARNING: Missing block: B:23:0x0083, code skipped:
            if (a(r9) == 0) goto L_0x005a;
     */
    public final boolean a(final java.lang.String r9, final boolean r10, final com.qiyukf.unicorn.e.b r11, int r12) {
        /*
        r8 = this;
        r0 = android.text.TextUtils.isEmpty(r9);
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0086;
    L_0x0008:
        r0 = r8.d;
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        goto L_0x0086;
    L_0x000e:
        r0 = new com.qiyukf.unicorn.e.e;
        r0.<init>();
        r3 = r8.d;
        r3 = r3.staffId;
        r0.a(r3);
        r3 = r8.d;
        r3 = r3.groupId;
        r0.b(r3);
        r3 = r8.d;
        r3 = r3.robotId;
        r0.c(r3);
        r3 = r8.d;
        r3 = r3.robotFirst;
        r0.b(r3);
        r0.a(r10);
        r3 = r8.d;
        r3 = r3.faqGroupId;
        r0.d(r3);
        if (r11 == 0) goto L_0x0049;
    L_0x003b:
        r3 = r11.b();
        r0.a(r3);
        r3 = r11.a();
        r0.b(r3);
    L_0x0049:
        r3 = r8.s;
        r3 = r3.get(r9);
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x005c;
    L_0x0055:
        r3 = r8.s;
        r3.put(r9, r0);
    L_0x005a:
        r0 = r2;
        goto L_0x0087;
    L_0x005c:
        r0 = r8.b;
        r0 = r0.get(r9);
        r0 = (com.qiyukf.unicorn.e.k) r0;
        if (r0 == 0) goto L_0x0077;
    L_0x0066:
        r3 = r0.g;
        if (r3 != r2) goto L_0x0077;
    L_0x006a:
        if (r10 != 0) goto L_0x005a;
    L_0x006c:
        if (r11 == 0) goto L_0x0077;
    L_0x006e:
        r3 = r11.b;
        r5 = 0;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x0077;
    L_0x0076:
        goto L_0x005a;
    L_0x0077:
        if (r0 != 0) goto L_0x0086;
    L_0x0079:
        r0 = r8.g(r9);
        if (r0 != 0) goto L_0x0086;
    L_0x007f:
        r0 = r8.a(r9);
        if (r0 != 0) goto L_0x0086;
    L_0x0085:
        goto L_0x0076;
    L_0x0086:
        r0 = r1;
    L_0x0087:
        if (r0 == 0) goto L_0x0144;
    L_0x0089:
        r0 = com.qiyukf.unicorn.d.e();
        r0 = r0.sdkEvents;
        if (r0 == 0) goto L_0x0140;
    L_0x0091:
        r0 = com.qiyukf.unicorn.d.e();
        r0 = r0.sdkEvents;
        r0 = r0.eventProcessFactory;
        if (r0 == 0) goto L_0x0140;
    L_0x009b:
        r0 = new com.qiyukf.unicorn.api.event.entry.RequestStaffEntry;
        r0.<init>();
        r3 = r8.d;
        if (r3 == 0) goto L_0x00ea;
    L_0x00a4:
        r3 = r8.d;
        r3 = r3.uri;
        r0.setUri(r3);
        r3 = r8.d;
        r3 = r3.title;
        r0.setTitle(r3);
        r3 = r8.d;
        r3 = r3.custom;
        r0.setCustom(r3);
        r3 = r8.d;
        r3 = r3.groupId;
        r0.setGroupId(r3);
        r3 = r8.d;
        r3 = r3.staffId;
        r0.setStaffId(r3);
        r3 = r8.d;
        r3 = r3.faqGroupId;
        r0.setFaqGroupId(r3);
        r3 = r8.d;
        r3 = r3.robotFirst;
        r0.setRobotFirst(r3);
        r3 = r8.d;
        r3 = r3.vipLevel;
        r0.setVipLevel(r3);
        r3 = r8.d;
        r3 = r3.robotId;
        r0.setRobotId(r3);
        r3 = r8.d;
        r3 = r3.productDetail;
        r0.setProductDetail(r3);
    L_0x00ea:
        if (r11 == 0) goto L_0x0104;
    L_0x00ec:
        r3 = r11.a();
        r0.setGroupId(r3);
        r3 = r11.b();
        r0.setStaffId(r3);
        r3 = r11.c;
        r0.setLabel(r3);
        r3 = r11.d;
        r0.setEntryId(r3);
    L_0x0104:
        if (r9 != 0) goto L_0x0109;
    L_0x0106:
        r3 = "-1";
        goto L_0x010a;
    L_0x0109:
        r3 = r9;
    L_0x010a:
        r0.setShopId(r3);
        r0.setScenes(r12);
        r0.setHumanOnly(r10);
        r12 = r8.e(r9);
        if (r12 == 0) goto L_0x0124;
    L_0x0119:
        r12 = r8.e(r9);
        if (r12 == r2) goto L_0x0120;
    L_0x011f:
        goto L_0x0124;
    L_0x0120:
        r0.setRobot(r2);
        goto L_0x0127;
    L_0x0124:
        r0.setRobot(r1);
    L_0x0127:
        r12 = com.qiyukf.unicorn.d.e();
        r12 = r12.sdkEvents;
        r12 = r12.eventProcessFactory;
        r12 = r12.eventOf(r1);
        if (r12 == 0) goto L_0x013f;
    L_0x0135:
        r1 = r8.r;
        r3 = new com.qiyukf.unicorn.h.d$1;
        r3.<init>(r9, r10, r11);
        r12.onEvent(r0, r1, r3);
    L_0x013f:
        return r2;
    L_0x0140:
        r12 = 0;
        r8.a(r9, r10, r11, r12);
    L_0x0144:
        r9 = r8.g(r9);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.h.d.a(java.lang.String, boolean, com.qiyukf.unicorn.e.b, int):boolean");
    }

    public final com.qiyukf.unicorn.e.d b(String str) {
        return (com.qiyukf.unicorn.e.d) this.i.get(str);
    }

    public final i b() {
        return this.f;
    }

    public final void b(OnPushMessageListener onPushMessageListener) {
        this.h.b(onPushMessageListener);
    }

    public final long c(String str) {
        k kVar = (k) this.b.get(str);
        return kVar == null ? 0 : kVar.a;
    }

    public final a c() {
        return this.g;
    }

    public final long d(String str) {
        return ((Long) this.o.get(str)).longValue();
    }

    public final boolean d() {
        return (this.b.isEmpty() && this.i.isEmpty()) ? false : true;
    }

    public final int e(String str) {
        k kVar = (k) this.b.get(str);
        return kVar == null ? 0 : kVar.g;
    }

    public final Map<String, k> e() {
        return this.b;
    }

    public final long f(String str) {
        com.qiyukf.unicorn.e.d dVar = (com.qiyukf.unicorn.e.d) this.i.get(str);
        return dVar == null ? 0 : dVar.g;
    }

    public final void f() {
        com.qiyukf.unicorn.f.a.e.e eVar = new com.qiyukf.unicorn.f.a.e.e();
        eVar.a(com.qiyukf.unicorn.b.b.d());
        c.a(eVar, c.a(), false);
        g();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.p.clear();
        this.q.clear();
        this.l.clear();
        this.k.clear();
        this.t.removeCallbacks(null);
        this.s.clear();
        this.c.clear();
    }

    public final void g() {
        this.b.clear();
        this.t.removeCallbacks(null);
        this.i.clear();
    }

    public final boolean g(String str) {
        return this.c.containsKey(str);
    }

    public final SessionStatusEnum h(String str) {
        return this.b.containsKey(str) ? SessionStatusEnum.IN_SESSION : this.i.containsKey(str) ? SessionStatusEnum.IN_QUEUE : SessionStatusEnum.NONE;
    }

    public final a h() {
        return this.j;
    }

    public final g j(String str) {
        g gVar = (g) this.m.get(str);
        return gVar == null ? g.a : gVar;
    }

    public final g k(String str) {
        Long l = (Long) this.o.get(str);
        return l == null ? null : (g) this.n.get(l.longValue());
    }

    public final com.qiyukf.unicorn.e.a l(String str) {
        return Long.valueOf(c(str)).longValue() == 0 ? null : (com.qiyukf.unicorn.e.a) this.p.get(str);
    }

    public final void m(String str) {
        com.qiyukf.unicorn.e.d dVar = (com.qiyukf.unicorn.e.d) this.i.remove(str);
        if (dVar != null && dVar.e != null) {
            this.t.removeCallbacks(dVar.e);
        }
    }

    public final ProductDetail n(String str) {
        return (ProductDetail) this.k.get(str);
    }

    public final List<com.qiyukf.unicorn.f.a.c.a> o(String str) {
        return (List) this.l.get(str);
    }

    public final boolean p(String str) {
        k kVar = (k) this.b.get(str);
        return kVar != null && kVar.g == 1 && kVar.h == 1;
    }
}
