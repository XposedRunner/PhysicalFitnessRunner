package com.qiyukf.nim.uikit.session.module.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class MessageBottomContainer extends FrameLayout {
    private boolean a = false;
    private boolean b = false;

    public MessageBottomContainer(Context context) {
        super(context);
        a();
    }

    public MessageBottomContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MessageBottomContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @TargetApi(21)
    public MessageBottomContainer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    public final void a() {
        if (!isInEditMode() && getHeight() != d.a()) {
            post(new Runnable() {
                public final void run() {
                    LayoutParams layoutParams = MessageBottomContainer.this.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new LayoutParams(-1, d.a());
                    } else {
                        layoutParams.height = d.a();
                    }
                    MessageBottomContainer.this.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final void b() {
        this.b = true;
    }

    public final void c() {
        super.setVisibility(0);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        if (this.b) {
            setVisibility(8);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i = makeMeasureSpec;
        }
        super.onMeasure(i, i2);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.b = false;
        }
        if (i != getVisibility()) {
            if (!this.a || i != 0) {
                super.setVisibility(i);
            }
        }
    }
}
