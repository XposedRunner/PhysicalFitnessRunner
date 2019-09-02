package com.qiyukf.nim.uikit.session.module.input;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nim.uikit.session.emoji.EmoticonPickerView;

public class MessageRootLayout extends FrameLayout implements OnGlobalLayoutListener {
    private MessageBottomContainer a;
    private EmoticonPickerView b;
    private boolean c = false;
    private int d = -1;
    private int e = 0;
    private int f = 0;
    private int g = d.d();
    private int h = d.e();
    private int i = (this.g + this.h);

    public MessageRootLayout(Context context) {
        super(context);
        a();
    }

    public MessageRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MessageRootLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @TargetApi(21)
    public MessageRootLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    private <T extends View> T a(Class<T> cls, View view) {
        if (cls.isInstance(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                View a = a(cls, viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
                i++;
            }
        }
        return null;
    }

    private MessageBottomContainer a(View view) {
        if (this.a == null) {
            this.a = (MessageBottomContainer) a(MessageBottomContainer.class, view);
        }
        return this.a;
    }

    private void a() {
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    private void a(boolean z) {
        this.c = z;
        MessageBottomContainer a = a((View) this);
        if (a != null) {
            a.a(z);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.g = d.d();
        this.h = d.e();
        this.i = this.g + this.h;
    }

    public void onGlobalLayout() {
        int height = getHeight();
        if (this.f == 0) {
            this.f = height;
        } else if (this.f != height) {
            int abs = Math.abs(this.f - height);
            if (abs > this.i) {
                this.f = height;
                if (d.a(abs)) {
                    MessageBottomContainer a = a((View) this);
                    if (a != null) {
                        a.a();
                    }
                    if (this.b == null) {
                        this.b = (EmoticonPickerView) a(EmoticonPickerView.class, this);
                    }
                    EmoticonPickerView emoticonPickerView = this.b;
                    if (emoticonPickerView != null) {
                        emoticonPickerView.a();
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e != 0) {
            int abs = Math.abs(this.e - i4);
            z = (abs == 0 || abs == this.g || abs == this.h || abs == this.i) ? false : true;
            a(z);
        }
        if (this.e + this.i < i4) {
            this.e = i4;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpec.getSize(i);
        int size = MeasureSpec.getSize(i2);
        if (size >= 0) {
            if (this.d < 0) {
                this.d = size;
            } else {
                int i3 = this.d - size;
                this.d = size;
                if (i3 != 0) {
                    MessageBottomContainer a = a((View) this);
                    if (a != null) {
                        if (i3 > this.i) {
                            a.b();
                        } else if (i3 < (-this.i) && this.c) {
                            a.c();
                        }
                    }
                }
            }
        }
        super.onMeasure(i, i2);
    }
}
