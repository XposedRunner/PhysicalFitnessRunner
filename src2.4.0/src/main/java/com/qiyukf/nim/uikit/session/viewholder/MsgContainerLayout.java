package com.qiyukf.nim.uikit.session.viewholder;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class MsgContainerLayout extends FrameLayout {
    private b a = null;

    public MsgContainerLayout(Context context) {
        super(context);
    }

    public MsgContainerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MsgContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MsgContainerLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.onDetached();
        }
    }
}
