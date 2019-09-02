package com.qiyukf.nim.uikit.session.module.a;

import android.content.Context;
import com.qiyukf.nim.uikit.common.a.d;
import com.qiyukf.nim.uikit.common.a.e;
import com.qiyukf.nimlib.i.f;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.customization.msg_list.UnicornMessageHandler;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c extends d<IMMessage> {
    private a b;
    private Map<String, Float> c = new HashMap();
    private Set<String> d = new HashSet();
    private IMMessage e;

    public interface a {
        void a(com.qiyukf.nim.uikit.session.helper.d.a aVar);

        void a(IMMessage iMMessage);

        boolean a();

        void b();

        boolean b(IMMessage iMMessage);

        void c();

        void c(IMMessage iMMessage);
    }

    /* renamed from: com.qiyukf.nim.uikit.session.module.a.c$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MsgTypeEnum.values().length];

        static {
            try {
                a[MsgTypeEnum.notification.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public c(Context context, List<IMMessage> list, e eVar) {
        super(context, list, eVar);
    }

    private void a(IMMessage iMMessage, boolean z) {
        if (z) {
            this.d.add(iMMessage.getUuid());
        } else {
            this.d.remove(iMMessage.getUuid());
        }
    }

    private static boolean d(IMMessage iMMessage) {
        return AnonymousClass1.a[iMMessage.getMsgType().ordinal()] == 1;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(int i) {
        super.a(i);
        IMMessage iMMessage = (IMMessage) getItem(i);
        UnicornMessageHandler b = com.qiyukf.nim.uikit.session.viewholder.c.b(iMMessage);
        if (b != null) {
            boolean z = iMMessage.getStatus() == MsgStatusEnum.read;
            boolean onMessage = b.onMessage(this.a, iMMessage, z);
            if (!z && onMessage) {
                iMMessage.setStatus(MsgStatusEnum.read);
                f.b((com.qiyukf.nimlib.i.a) iMMessage);
            }
        }
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    /* JADX WARNING: Missing block: B:35:0x008f, code skipped:
            if (r5.e.isTheSame(r6) == false) goto L_0x0096;
     */
    public final void a(com.qiyukf.nimlib.sdk.msg.model.IMMessage r6) {
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r5.a();
        r0 = r0.iterator();
        r1 = 0;
        r2 = r1;
    L_0x000d:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0022;
    L_0x0013:
        r3 = r0.next();
        r3 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r3;
        r3 = r3.isTheSame(r6);
        if (r3 != 0) goto L_0x0022;
    L_0x001f:
        r2 = r2 + 1;
        goto L_0x000d;
    L_0x0022:
        r0 = r5.getCount();
        if (r2 >= r0) goto L_0x0099;
    L_0x0028:
        r0 = r5.a();
        r0.remove(r2);
        r0 = r5.c(r6);
        if (r0 == 0) goto L_0x0096;
    L_0x0035:
        r5.a(r6, r1);
        r0 = r5.getCount();
        r3 = 0;
        if (r0 <= 0) goto L_0x0094;
    L_0x003f:
        r0 = r5.getCount();
        r4 = 1;
        if (r2 != r0) goto L_0x0047;
    L_0x0046:
        r2 = r2 - r4;
    L_0x0047:
        r0 = r5.getItem(r2);
        r0 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r0;
        r2 = d(r0);
        if (r2 == 0) goto L_0x007e;
    L_0x0053:
        r5.a(r0, r1);
        r0 = r5.e;
        if (r0 == 0) goto L_0x0096;
    L_0x005a:
        r0 = r5.e;
        if (r0 == 0) goto L_0x0096;
    L_0x005e:
        r0 = r5.e;
        r6 = r0.isTheSame(r6);
        if (r6 == 0) goto L_0x0096;
    L_0x0066:
        r5.e = r3;
        r6 = r5.getCount();
        r6 = r6 - r4;
    L_0x006d:
        if (r6 < 0) goto L_0x0096;
    L_0x006f:
        r0 = r5.getItem(r6);
        r0 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r0;
        r1 = r5.c(r0);
        if (r1 != 0) goto L_0x0091;
    L_0x007b:
        r6 = r6 + -1;
        goto L_0x006d;
    L_0x007e:
        r5.a(r0, r4);
        r1 = r5.e;
        if (r1 == 0) goto L_0x0091;
    L_0x0085:
        r1 = r5.e;
        if (r1 == 0) goto L_0x0096;
    L_0x0089:
        r1 = r5.e;
        r6 = r1.isTheSame(r6);
        if (r6 == 0) goto L_0x0096;
    L_0x0091:
        r5.e = r0;
        goto L_0x0096;
    L_0x0094:
        r5.e = r3;
    L_0x0096:
        r5.notifyDataSetChanged();
    L_0x0099:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.a.c.a(com.qiyukf.nimlib.sdk.msg.model.IMMessage):void");
    }

    public final void a(IMMessage iMMessage, float f) {
        this.c.put(iMMessage.getUuid(), Float.valueOf(f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x000a A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Missing block: B:11:0x0033, code skipped:
            if ((r0.getTime() - r12.getTime()) < 300000) goto L_0x001e;
     */
    public final void a(java.util.List<com.qiyukf.nimlib.sdk.msg.model.IMMessage> r11, boolean r12, boolean r13) {
        /*
        r10 = this;
        if (r12 == 0) goto L_0x0004;
    L_0x0002:
        r12 = 0;
        goto L_0x0006;
    L_0x0004:
        r12 = r10.e;
    L_0x0006:
        r11 = r11.iterator();
    L_0x000a:
        r0 = r11.hasNext();
        if (r0 == 0) goto L_0x003f;
    L_0x0010:
        r0 = r11.next();
        r0 = (com.qiyukf.nimlib.sdk.msg.model.IMMessage) r0;
        r1 = d(r0);
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r10.a(r0, r3);
        goto L_0x0036;
    L_0x0022:
        if (r12 == 0) goto L_0x0038;
    L_0x0024:
        r4 = r12.getTime();
        r6 = r0.getTime();
        r8 = r6 - r4;
        r4 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x0038;
    L_0x0035:
        goto L_0x001e;
    L_0x0036:
        r2 = r3;
        goto L_0x003b;
    L_0x0038:
        r10.a(r0, r2);
    L_0x003b:
        if (r2 == 0) goto L_0x000a;
    L_0x003d:
        r12 = r0;
        goto L_0x000a;
    L_0x003f:
        if (r13 == 0) goto L_0x0043;
    L_0x0041:
        r10.e = r12;
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.module.a.c.a(java.util.List, boolean, boolean):void");
    }

    public final float b(IMMessage iMMessage) {
        Float f = (Float) this.c.get(iMMessage.getUuid());
        return f == null ? 0.0f : f.floatValue();
    }

    public final boolean c(IMMessage iMMessage) {
        return this.d.contains(iMMessage.getUuid());
    }

    public final a d() {
        return this.b;
    }
}
