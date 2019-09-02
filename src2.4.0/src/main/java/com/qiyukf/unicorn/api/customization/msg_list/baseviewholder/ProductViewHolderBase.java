package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.h.c;

public abstract class ProductViewHolderBase extends UnicornMessageViewHolder {
    public final void bindContentView(IMMessage iMMessage, Context context) {
        ProductAttachment productAttachment = (ProductAttachment) iMMessage.getAttachment();
        boolean z = true;
        if (!(productAttachment.getSendByUser() == 1 && iMMessage.getDirect() == MsgDirectionEnum.Out && d.g().e(iMMessage.getSessionId()) != 1)) {
            z = false;
        }
        bindTextMsgView(context, productAttachment, Boolean.valueOf(z));
    }

    public abstract void bindTextMsgView(Context context, ProductAttachment productAttachment, Boolean bool);

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    public final void onClickToSendByUser(ProductAttachment productAttachment) {
        int i;
        if (d.g().e(this.message.getSessionId()) == 1) {
            i = R.string.ysf_send_card_robot;
        } else if (c.b()) {
            productAttachment = productAttachment.clone();
            if (productAttachment != null) {
                productAttachment.setSendByUser(0);
                productAttachment.setActionText("");
                c.b(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, productAttachment));
            }
            return;
        } else {
            i = R.string.ysf_send_card_error;
        }
        g.b(i);
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }
}
