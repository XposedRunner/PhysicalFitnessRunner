package com.qiyukf.nim.uikit.session.activity;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;

class WatchMessagePictureActivity$2 implements Observer<IMMessage> {
    final /* synthetic */ WatchMessagePictureActivity a;

    WatchMessagePictureActivity$2(WatchMessagePictureActivity watchMessagePictureActivity) {
        this.a = watchMessagePictureActivity;
    }

    public final /* synthetic */ void onEvent(Object obj) {
        IMMessage iMMessage = (IMMessage) obj;
        if (iMMessage.isTheSame(WatchMessagePictureActivity.d(this.a)) && !WatchMessagePictureActivity.e(this.a)) {
            if (iMMessage.getAttachStatus() == AttachStatusEnum.transferred && WatchMessagePictureActivity.a(iMMessage)) {
                WatchMessagePictureActivity.a(this.a, iMMessage);
                return;
            }
            if (iMMessage.getAttachStatus() == AttachStatusEnum.fail) {
                WatchMessagePictureActivity.b(this.a, iMMessage);
            }
        }
    }
}
