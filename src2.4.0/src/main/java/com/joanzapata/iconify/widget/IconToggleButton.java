package com.joanzapata.iconify.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import android.widget.ToggleButton;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.internal.HasOnViewAttachListener;
import com.joanzapata.iconify.internal.HasOnViewAttachListener.HasOnViewAttachListenerDelegate;
import com.joanzapata.iconify.internal.HasOnViewAttachListener.OnViewAttachListener;

public class IconToggleButton extends ToggleButton implements HasOnViewAttachListener {
    private HasOnViewAttachListenerDelegate delegate;

    public IconToggleButton(Context context) {
        super(context);
        init();
    }

    public IconToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IconToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setTransformationMethod(null);
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.delegate.onAttachedToWindow();
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.delegate.onDetachedFromWindow();
    }

    public void setOnViewAttachListener(OnViewAttachListener onViewAttachListener) {
        if (this.delegate == null) {
            this.delegate = new HasOnViewAttachListenerDelegate(this);
        }
        this.delegate.setOnViewAttachListener(onViewAttachListener);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(Iconify.compute(getContext(), charSequence, this), BufferType.NORMAL);
    }
}
