package com.qiyukf.unicorn.ui.activity;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.f.a.a.a.d;
import com.qiyukf.unicorn.f.a.a.b;
import com.qiyukf.unicorn.ui.b.a.g.a;

class CardPopupActivity$2 implements Observer<CustomNotification> {
    final /* synthetic */ CardPopupActivity a;

    CardPopupActivity$2(CardPopupActivity cardPopupActivity) {
        this.a = cardPopupActivity;
    }

    public final /* synthetic */ void onEvent(Object obj) {
        CustomNotification customNotification = (CustomNotification) obj;
        if (customNotification.getSessionType() == SessionTypeEnum.Ysf && (customNotification.getAttachment() instanceof b)) {
            b bVar = (b) customNotification.getAttachment();
            if (bVar.a() instanceof d) {
                CardPopupActivity.a(this.a);
                CardPopupActivity.b(this.a).setVisibility(8);
                d dVar = (d) bVar.a();
                this.a.setTitle(dVar.c());
                new a(CardPopupActivity.c(this.a)).a(dVar.d());
            }
        }
    }
}
