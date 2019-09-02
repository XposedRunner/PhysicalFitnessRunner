package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import com.yalantis.ucrop.view.CropImageView;

public class SocializeImageView extends ImageButton {
    public static int O000000o = 0;
    public static int O00000Oo = 1;
    public static int O00000o0 = 2;
    protected Paint O00000o;
    protected Paint O00000oO;
    private boolean O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private RectF O0000Ooo;
    private int O0000o00;

    public SocializeImageView(Context context) {
        super(context);
        O000000o();
    }

    public SocializeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public SocializeImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    @TargetApi(21)
    public SocializeImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        O000000o();
    }

    private void O000000o() {
        if (VERSION.SDK_INT < 16) {
            setBackgroundDrawable(null);
        } else {
            setBackground(null);
        }
        setClickable(false);
        setScaleType(ScaleType.CENTER_INSIDE);
    }

    private void O000000o(Canvas canvas, Paint paint) {
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        canvas.drawCircle(measuredWidth, measuredWidth, measuredWidth, paint);
    }

    private void O00000Oo(Canvas canvas, Paint paint) {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = new RectF();
            this.O0000Ooo.left = CropImageView.DEFAULT_ASPECT_RATIO;
            this.O0000Ooo.top = CropImageView.DEFAULT_ASPECT_RATIO;
            this.O0000Ooo.right = (float) getMeasuredWidth();
            this.O0000Ooo.bottom = (float) getMeasuredWidth();
        }
        canvas.drawRoundRect(this.O0000Ooo, (float) this.O0000o00, (float) this.O0000o00, paint);
    }

    /* Access modifiers changed, original: protected */
    public int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void O000000o(int i, int i2) {
        this.O0000OoO = i;
        if (i != O00000o0) {
            this.O0000o00 = 0;
            return;
        }
        this.O0000o00 = (int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void O00000Oo(int i, int i2) {
        this.O0000O0o = i;
        this.O0000OOo = i2;
        setPressEffectEnable(i2 != 0);
        if (this.O0000O0o != 0) {
            this.O00000o = new Paint();
            this.O00000o.setStyle(Style.FILL);
            this.O00000o.setAntiAlias(true);
            this.O00000o.setColor(i);
        }
        if (this.O0000OOo != 0) {
            this.O00000oO = new Paint();
            this.O00000oO.setStyle(Style.FILL);
            this.O00000oO.setAntiAlias(true);
            this.O00000oO.setColor(i2);
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.O0000Oo) {
            if (isPressed()) {
                if (O000000o != this.O0000OoO) {
                    this.O00000oo = true;
                    invalidate();
                } else if (this.O0000Oo0 != 0) {
                    setColorFilter(this.O0000Oo0, Mode.SRC_ATOP);
                }
            } else if (O000000o == this.O0000OoO) {
                clearColorFilter();
            } else {
                this.O00000oo = false;
                invalidate();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.O0000OoO == O000000o) {
            super.onDraw(canvas);
            return;
        }
        if (this.O00000oo) {
            if (this.O0000Oo && this.O00000oO != null) {
                if (this.O0000OoO == O00000Oo) {
                    O000000o(canvas, this.O00000oO);
                } else if (this.O0000OoO == O00000o0) {
                    O00000Oo(canvas, this.O00000oO);
                }
            }
        } else if (this.O0000OoO == O00000Oo) {
            O000000o(canvas, this.O00000o);
        } else if (this.O0000OoO == O00000o0) {
            O00000Oo(canvas, this.O00000o);
        }
        super.onDraw(canvas);
    }

    public void setBackgroundColor(int i) {
        O00000Oo(i, 0);
    }

    public void setBackgroundShape(int i) {
        O000000o(i, 0);
    }

    public void setPressEffectEnable(boolean z) {
        this.O0000Oo = z;
    }

    public void setPressedColor(int i) {
        setPressEffectEnable(i != 0);
        this.O0000Oo0 = i;
    }
}
