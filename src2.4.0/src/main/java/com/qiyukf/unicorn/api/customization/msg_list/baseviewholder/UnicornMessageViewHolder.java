package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import android.view.View;
import com.qiyukf.nim.uikit.session.viewholder.b;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;

public abstract class UnicornMessageViewHolder extends b {
    /* Access modifiers changed, original: protected|final */
    public final void bindContentView() {
        bindContentView(this.message, this.context);
    }

    public abstract void bindContentView(IMMessage iMMessage, Context context);

    /* Access modifiers changed, original: protected */
    public <T extends View> T findViewById(int i) {
        return super.findViewById(i);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getContentResId() {
        return getViewHolderResid();
    }

    public abstract int getViewHolderResid();

    /* Access modifiers changed, original: protected|final */
    public final void inflateContentView() {
        inflateFindView();
    }

    public abstract void inflateFindView();

    /* Access modifiers changed, original: protected */
    public boolean isMiddleItem() {
        return super.isMiddleItem();
    }

    /* Access modifiers changed, original: protected */
    public boolean isReceivedMessage() {
        return super.isReceivedMessage();
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return super.leftBackground();
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
        super.onItemClick();
    }

    /* Access modifiers changed, original: protected */
    public boolean onItemLongClick() {
        return super.onItemLongClick();
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return super.rightBackground();
    }

    /* Access modifiers changed, original: protected */
    public boolean showAvatar() {
        return super.showAvatar();
    }
}
