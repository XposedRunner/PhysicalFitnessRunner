package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import com.joanzapata.iconify.IconDrawable;
import com.zjwh.android_wh_physicalfitness.R;
import defpackage.lg;
import org.xutils.common.util.DensityUtil;

public class XEditText extends AppCompatEditText implements TextWatcher, OnFocusChangeListener, OnTouchListener {
    private static final String O000000o = "XEditText";
    private Rect O00000Oo = new Rect();
    private Drawable O00000o;
    private boolean O00000o0;
    private Rect O00000oO = new Rect();
    private Drawable O00000oo;
    private OnFocusChangeListener O0000O0o;
    private OnTouchListener O0000OOo;
    private O000000o O0000Oo0;

    public interface O000000o {
        void O000000o(View view);
    }

    public XEditText(Context context) {
        super(context);
    }

    public XEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet, 0);
    }

    public XEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet, i);
    }

    private void setClearIconVisible(boolean z) {
        this.O00000oo.setVisible(z, false);
        Drawable[] compoundDrawables = getCompoundDrawables();
        setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], z ? this.O00000oo : null, compoundDrawables[3]);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XEditText, i, 0);
        i = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            setRightDrawableResource(i);
        }
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        super.addTextChangedListener(this);
        if (!isInEditMode()) {
            this.O00000oo = new IconDrawable(context, lg.edit_clear).color(-5066062).sizeDp(16);
            this.O00000oo.setBounds(0, 0, this.O00000oo.getIntrinsicHeight(), this.O00000oo.getIntrinsicHeight());
            setClearIconVisible(false);
            setCompoundDrawablePadding(DensityUtil.dip2px(6.0f));
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000o != null) {
            getBackground().getPadding(this.O00000oO);
            Rect rect = this.O00000oO;
            int i = (int) (((double) rect.bottom) * 0.75d);
            int width = (canvas.getWidth() - this.O00000o.getIntrinsicWidth()) - rect.right;
            this.O00000o.setBounds(width, (canvas.getHeight() - this.O00000o.getIntrinsicHeight()) - i, canvas.getWidth() - rect.right, canvas.getHeight() - i);
            if ((getScrollX() | getScrollY()) == 0) {
                this.O00000o.draw(canvas);
                return;
            }
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.O00000o.draw(canvas);
            canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
        }
    }

    public void onFocusChange(View view, boolean z) {
        boolean z2 = false;
        if (z) {
            if (getText().length() > 0) {
                z2 = true;
            }
            setClearIconVisible(z2);
        } else {
            setClearIconVisible(false);
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.onFocusChange(view, z);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.O00000Oo.set(0, 0, getWidth(), getHeight());
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (isFocused()) {
            setClearIconVisible(charSequence.length() > 0);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z = true;
        if (!this.O00000oo.isVisible() || x <= (getWidth() - getPaddingRight()) - this.O00000oo.getIntrinsicWidth()) {
            if (this.O00000Oo != null) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.O00000o0 = this.O00000Oo.contains(x, y);
                        break;
                    case 1:
                        if (this.O00000o0 && this.O00000Oo.contains(x, y) && this.O0000Oo0 != null) {
                            this.O0000Oo0.O000000o(view);
                            break;
                        }
                }
            }
            if (this.O0000OOo == null || !this.O0000OOo.onTouch(view, motionEvent)) {
                z = false;
            }
            return z;
        }
        if (motionEvent.getAction() == 1) {
            setError(null);
            setText("");
        }
        return true;
    }

    public void setOnEditClickListener(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.O0000O0o = onFocusChangeListener;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.O0000OOo = onTouchListener;
    }

    public void setRightDrawable(Drawable drawable) {
        Drawable drawable2 = this.O00000o;
        this.O00000o = drawable;
        if (this.O00000o != null) {
            this.O00000o.setBounds(0, 0, this.O00000o.getIntrinsicWidth(), this.O00000o.getIntrinsicHeight());
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() + this.O00000o.getIntrinsicWidth(), getPaddingBottom());
            return;
        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() - drawable2.getIntrinsicWidth(), getPaddingBottom());
    }

    public void setRightDrawableResource(@DrawableRes int i) {
        setRightDrawable(ContextCompat.getDrawable(getContext(), i));
    }
}
