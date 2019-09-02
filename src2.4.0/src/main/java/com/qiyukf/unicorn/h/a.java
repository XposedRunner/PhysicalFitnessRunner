package com.qiyukf.unicorn.h;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.i.f;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.c.b;
import com.qiyukf.unicorn.f.a.e.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private Fragment a;
    private String b;
    private Map<String, IMMessage> c = new HashMap();
    private com.qiyukf.unicorn.ui.evaluate.a d;

    public static b a(String str) {
        b k = com.qiyukf.unicorn.b.b.k(str);
        return k == null ? b.a() : k;
    }

    public static void a(IMMessage iMMessage) {
        String sessionId = iMMessage.getSessionId();
        int i = com.qiyukf.unicorn.b.b.i(sessionId);
        if (i != -1 && i != 4) {
            MsgDirectionEnum direct = iMMessage.getDirect();
            if ((direct == MsgDirectionEnum.Out && i % 2 == 0) || (direct == MsgDirectionEnum.In && i % 2 == 1)) {
                com.qiyukf.unicorn.b.b.a(sessionId, i + 1);
            }
        }
    }

    public final void a() {
        this.a = null;
        this.b = null;
    }

    public final void a(long j, String str, long j2, boolean z) {
        c cVar = new c();
        cVar.a(-1);
        cVar.a(a(str));
        cVar.a("android");
        cVar.a(j2);
        IMMessage createCustomReceivedMessage = MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, null, cVar, j);
        com.qiyukf.nimlib.i.c.a((com.qiyukf.nimlib.i.a) createCustomReceivedMessage);
        com.qiyukf.unicorn.b.b.c(str, createCustomReceivedMessage.getUuid());
        if (z) {
            if (createCustomReceivedMessage.getSessionId().equals(this.b)) {
                if (this.d == null) {
                    a(this.a.getContext(), createCustomReceivedMessage);
                }
            } else if (!this.c.containsKey(createCustomReceivedMessage.getSessionId())) {
                this.c.put(createCustomReceivedMessage.getSessionId(), createCustomReceivedMessage);
            }
        }
    }

    public final void a(final Context context, final IMMessage iMMessage) {
        final com.qiyukf.unicorn.ui.evaluate.a aVar = new com.qiyukf.unicorn.ui.evaluate.a(context, (c) iMMessage.getAttachment());
        aVar.setCanceledOnTouchOutside(false);
        aVar.a(new com.qiyukf.unicorn.ui.evaluate.a.a() {
            public final void a(int i, List<String> list, String str) {
                aVar.a(false);
                aVar.b(true);
                a.this.a(iMMessage, i, str, (List) list, new RequestCallbackWrapper<Void>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        if (i == 200) {
                            aVar.cancel();
                            return;
                        }
                        if (aVar.isShowing()) {
                            aVar.a(true);
                            aVar.b(false);
                            g.a(context.getString(R.string.ysf_network_error));
                        }
                    }
                });
            }
        });
        aVar.show();
    }

    public final void a(Fragment fragment, String str) {
        this.a = fragment;
        this.b = str;
        if (this.c.containsKey(str)) {
            IMMessage iMMessage = (IMMessage) this.c.remove(str);
            if (this.d == null && iMMessage != null && (iMMessage.getAttachment() instanceof c)) {
                a(fragment.getContext(), iMMessage);
            }
        }
    }

    public final void a(IMMessage iMMessage, int i, String str, List<String> list, RequestCallbackWrapper<Void> requestCallbackWrapper) {
        final c cVar = (c) iMMessage.getAttachment();
        cVar.a(i);
        cVar.b(str);
        cVar.a((List) list);
        final String sessionId = iMMessage.getSessionId();
        final IMMessage queryLastMessage = ((MsgService) NIMClient.getService(MsgService.class)).queryLastMessage(sessionId, SessionTypeEnum.Ysf);
        final IMMessage iMMessage2 = iMMessage;
        final RequestCallbackWrapper<Void> requestCallbackWrapper2 = requestCallbackWrapper;
        c.a(cVar, sessionId, true).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                Void voidR = (Void) obj;
                if (i == 200) {
                    ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage2, true);
                    if (cVar.b() == com.qiyukf.unicorn.b.b.h(sessionId)) {
                        com.qiyukf.unicorn.b.b.b(sessionId, 2);
                        com.qiyukf.unicorn.b.b.a(sessionId, -1);
                        com.qiyukf.unicorn.b.b.c(sessionId, null);
                    }
                }
                if (com.qiyukf.unicorn.b.b.h(sessionId) == ((c) iMMessage2.getAttachment()).b() || iMMessage2.isTheSame(queryLastMessage)) {
                    com.qiyukf.unicorn.h.d.a h = d.g().h();
                    if (h != null) {
                        h.a(sessionId);
                    }
                }
                if (requestCallbackWrapper2 != null) {
                    requestCallbackWrapper2.onResult(i, voidR, th);
                }
            }
        });
    }

    public final void a(com.qiyukf.unicorn.ui.evaluate.a aVar) {
        this.d = aVar;
    }

    public final void a(final String str, int i, String str2, List<String> list, final RequestCallbackWrapper<Void> requestCallbackWrapper) {
        IMMessage a = f.a(com.qiyukf.unicorn.b.b.l(str));
        if (a != null) {
            a(a, i, str2, (List) list, (RequestCallbackWrapper) requestCallbackWrapper);
            return;
        }
        final c cVar = new c();
        cVar.a(i);
        cVar.a(a(str));
        cVar.b(str2);
        cVar.a("android");
        cVar.a(com.qiyukf.unicorn.b.b.h(str));
        cVar.a((List) list);
        c.a(cVar, str, false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                Void voidR = (Void) obj;
                if (i == 200) {
                    ((MsgService) NIMClient.getService(MsgService.class)).saveMessageToLocal(MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, cVar), true);
                    if (cVar.b() == com.qiyukf.unicorn.b.b.h(str)) {
                        com.qiyukf.unicorn.b.b.b(str, 2);
                        com.qiyukf.unicorn.b.b.a(str, -1);
                    }
                }
                com.qiyukf.unicorn.h.d.a h = d.g().h();
                if (h != null) {
                    h.a(str);
                }
                if (requestCallbackWrapper != null) {
                    requestCallbackWrapper.onResult(i, voidR, th);
                }
            }
        });
    }

    public final void a(String str, com.qiyukf.unicorn.f.a.d.c cVar) {
        if (com.qiyukf.unicorn.b.b.j(str) == 1) {
            a(System.currentTimeMillis(), str, cVar.a(), cVar.b());
        }
    }

    public final void b() {
        if (this.d != null && this.d.isShowing()) {
            this.d.cancel();
        }
    }
}
