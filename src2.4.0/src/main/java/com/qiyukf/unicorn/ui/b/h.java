package com.qiyukf.unicorn.ui.b;

import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.YSFOptions;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.e.b;
import com.qiyukf.unicorn.f.a.d.o;
import com.qiyukf.unicorn.widget.a.a;
import com.qiyukf.unicorn.widget.a.g;
import java.util.List;

public class h extends a<b> {
    private static void b(IMMessage iMMessage, b bVar) {
        o oVar = (o) iMMessage.getAttachment();
        if (oVar.d()) {
            oVar.e();
            ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, true);
            d.g().a(iMMessage.getSessionId(), true, bVar, bVar == null ? 0 : bVar.a);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void a(Object obj) {
        b(this.message, (b) obj);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a() {
        return ((o) this.message.getAttachment()).d();
    }

    /* Access modifiers changed, original: protected|final */
    public final String b() {
        return ((o) this.message.getAttachment()).a();
    }

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        super.bindContentView();
        final IMMessage iMMessage = this.message;
        YSFOptions e = d.e();
        if (e.categoryDialogStyle > 0) {
            o oVar = (o) iMMessage.getAttachment();
            if (oVar.d() && !oVar.g()) {
                final List c = oVar.c();
                String[] strArr = new String[c.size()];
                for (int i = 0; i < c.size(); i++) {
                    strArr[i] = ((b) c.get(i)).c;
                }
                a aVar = new a(this.context, e.categoryDialogStyle == 1 ? 17 : 80);
                aVar.setTitle(oVar.a());
                aVar.a(strArr);
                aVar.a(new g.a() {
                    public final void a(int i) {
                        h.b(iMMessage, (b) c.get(i));
                    }
                });
                aVar.show();
                oVar.h();
                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, true);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final String c() {
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<b> d() {
        return ((o) this.message.getAttachment()).c();
    }
}
