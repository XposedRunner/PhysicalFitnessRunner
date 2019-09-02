package com.qiyukf.nim.uikit.session.activity;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;

class WatchVideoActivity$10 implements Observer<IMMessage> {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$10(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final /* synthetic */ void onEvent(Object obj) {
        IMMessage iMMessage = (IMMessage) obj;
        if (iMMessage.isTheSame(WatchVideoActivity.f(this.a)) && !WatchVideoActivity.j(this.a)) {
            if (iMMessage.getAttachStatus() == AttachStatusEnum.transferred && WatchVideoActivity.a(iMMessage)) {
                WatchVideoActivity.a(this.a, iMMessage);
                return;
            }
            if (iMMessage.getAttachStatus() == AttachStatusEnum.fail) {
                WatchVideoActivity.k(this.a);
            }
        }
    }
}
