package com.qiyukf.unicorn.api.customization.msg_list;

import com.qiyukf.nim.uikit.session.viewholder.b;
import com.qiyukf.nim.uikit.session.viewholder.c;
import com.qiyukf.nim.uikit.session.viewholder.e;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.EvaluationViewHolderBase;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.ProductViewHolderBase;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.TextViewHolderBase;
import com.qiyukf.unicorn.api.customization.msg_list.baseviewholder.TipsViewHolderBase;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;

public class MsgCustomizationRegistry {
    @SafeVarargs
    public static void hideViewForMsgType(Class<? extends MsgAttachment>... clsArr) {
        for (Class a : clsArr) {
            c.a(a, e.class, false);
        }
    }

    public static void registerMessageHandlerFactory(MessageHandlerFactory messageHandlerFactory) {
        c.a(messageHandlerFactory);
    }

    public static void registerMessageViewHolder(Class<? extends b> cls) {
        if (TextViewHolderBase.class.isAssignableFrom(cls)) {
            c.a(MsgTypeEnum.text, (Class) cls);
        } else if (TipsViewHolderBase.class.isAssignableFrom(cls)) {
            c.a(MsgTypeEnum.tips, (Class) cls);
        } else if (EvaluationViewHolderBase.class.isAssignableFrom(cls)) {
            c.a(com.qiyukf.unicorn.f.a.e.c.class, cls, true);
        } else {
            if (ProductViewHolderBase.class.isAssignableFrom(cls)) {
                c.a(ProductAttachment.class, cls, true);
            }
        }
    }
}
