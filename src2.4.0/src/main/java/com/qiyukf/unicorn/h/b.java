package com.qiyukf.unicorn.h;

import com.qiyukf.unicorn.api.msg.OnPushMessageListener;
import com.qiyukf.unicorn.e.i;
import com.qiyukf.unicorn.e.j;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private i a;
    private List<OnPushMessageListener> b = new ArrayList();
    private j c;

    public b(i iVar, j jVar) {
        this.a = iVar;
        this.c = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x010a A:{LOOP_END, LOOP:0: B:25:0x0104->B:27:0x010a} */
    public final void a(com.qiyukf.nimlib.sdk.msg.model.IMMessage r7) {
        /*
        r6 = this;
        r0 = com.qiyukf.unicorn.h.c.a(r7);
        r1 = r7.getDirect();
        r2 = com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum.In;
        if (r1 != r2) goto L_0x0114;
    L_0x000c:
        r1 = 2;
        if (r0 != r1) goto L_0x0114;
    L_0x000f:
        r0 = r7.getExtension();
        r1 = "msgSessionId";
        r0 = com.qiyukf.basesdk.c.b.e(r0, r1);
        r1 = new com.qiyukf.unicorn.f.a.e.f;
        r2 = 1;
        r1.<init>(r0, r2);
        r3 = r7.getSessionId();
        com.qiyukf.unicorn.h.c.a(r1, r3, r2);
        com.qiyukf.unicorn.b.b.n(r0);
        r0 = r7.getExtension();
        if (r0 == 0) goto L_0x0044;
    L_0x002f:
        r1 = "shop";
        r0 = com.qiyukf.basesdk.c.b.f(r0, r1);
        if (r0 == 0) goto L_0x0044;
    L_0x0037:
        r1 = new com.qiyukf.unicorn.e.h;
        r1.<init>();
        r0 = r0.toString();
        r1.a(r0);
        goto L_0x0045;
    L_0x0044:
        r1 = 0;
    L_0x0045:
        if (r1 == 0) goto L_0x004c;
    L_0x0047:
        r0 = r6.a;
        r0.a(r1);
    L_0x004c:
        r0 = new com.qiyukf.unicorn.api.msg.PushMessageExtension;
        r0.<init>();
        r1 = r7.getExtension();
        r2 = "senderInfo";
        r2 = com.qiyukf.basesdk.c.b.f(r1, r2);
        if (r2 == 0) goto L_0x0080;
    L_0x005d:
        r3 = new com.qiyukf.unicorn.api.msg.PushMessageExtension$Sender;
        r3.<init>();
        r4 = "staffId";
        r4 = com.qiyukf.basesdk.c.b.e(r2, r4);
        r3.setId(r4);
        r4 = "staffIcon";
        r4 = com.qiyukf.basesdk.c.b.e(r2, r4);
        r3.setAvatar(r4);
        r4 = "staffName";
        r2 = com.qiyukf.basesdk.c.b.e(r2, r4);
        r3.setName(r2);
        r0.setSender(r3);
    L_0x0080:
        r2 = "action";
        r1 = com.qiyukf.basesdk.c.b.f(r1, r2);
        if (r1 == 0) goto L_0x00a2;
    L_0x0088:
        r2 = new com.qiyukf.unicorn.api.msg.PushMessageExtension$Action;
        r2.<init>();
        r3 = "label";
        r3 = com.qiyukf.basesdk.c.b.e(r1, r3);
        r2.setLabel(r3);
        r3 = "url";
        r1 = com.qiyukf.basesdk.c.b.e(r1, r3);
        r2.setUrl(r1);
        r0.setAction(r2);
    L_0x00a2:
        r1 = r0.getSender();
        if (r1 == 0) goto L_0x00f3;
    L_0x00a8:
        r1 = r0.getSender();
        r1 = r1.getId();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00f3;
    L_0x00b6:
        r1 = r6.c;
        r2 = r0.getSender();
        r2 = r2.getId();
        r3 = r0.getSender();
        r3 = r3.getName();
        r4 = r0.getSender();
        r4 = r4.getAvatar();
        r5 = r7.getUuid();
        r1.a(r2, r3, r4, r5);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r0.getSender();
        r2 = r2.getId();
        r1.append(r2);
        r2 = r7.getUuid();
        r1.append(r2);
        r1 = r1.toString();
        goto L_0x00fb;
    L_0x00f3:
        r1 = r7.getSessionId();
        r1 = com.qiyukf.unicorn.e.j.a(r1);
    L_0x00fb:
        r7.setFromAccount(r1);
        r1 = r6.b;
        r1 = r1.iterator();
    L_0x0104:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0114;
    L_0x010a:
        r2 = r1.next();
        r2 = (com.qiyukf.unicorn.api.msg.OnPushMessageListener) r2;
        r2.onReceive(r7, r0);
        goto L_0x0104;
    L_0x0114:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.h.b.a(com.qiyukf.nimlib.sdk.msg.model.IMMessage):void");
    }

    public final void a(OnPushMessageListener onPushMessageListener) {
        if (onPushMessageListener != null && !this.b.contains(onPushMessageListener)) {
            this.b.add(onPushMessageListener);
        }
    }

    public final void b(OnPushMessageListener onPushMessageListener) {
        this.b.remove(onPushMessageListener);
    }
}
