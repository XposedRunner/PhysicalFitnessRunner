package com.geetest.sdk.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.wireless.security.SecExceptionCode;
import com.geetest.sdk.O00O00o;
import com.geetest.sdk.O00O0OOo;
import com.geetest.sdk.O0OO00O;

public class GT3GeetestView extends View {
    private Paint O000000o;
    private Paint O00000Oo;
    private Paint O00000o;
    private Paint O00000o0;
    private Paint O00000oO;
    private Paint O00000oo;
    private Paint O0000O0o;
    private Paint O0000OOo;
    private Paint O0000Oo;
    private Paint O0000Oo0;
    private Paint O0000OoO;
    private Paint O0000Ooo;
    private int O0000o;
    private Path O0000o0;
    private float O0000o00;
    private O000000o O0000o0O;
    private int O0000o0o;
    private boolean O0000oO = false;
    private Context O0000oO0;
    private boolean O0000oOO = false;
    private boolean O0000oOo = false;
    private boolean O0000oo = false;
    private boolean O0000oo0 = false;
    private boolean O0000ooO = false;
    private boolean O0000ooo = false;
    private double O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private ValueAnimator O000O0o;
    private ValueAnimator O000O0o0;
    private int O000O0oO;
    private AnimatorSet O000O0oo;
    private int O00oOoOo;
    private boolean O00oOooO = false;
    private double O00oOooo;

    public interface O000000o {
        float O000000o();
    }

    public GT3GeetestView(Context context) {
        super(context);
        this.O0000oO0 = context;
    }

    public GT3GeetestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000oO0 = context;
    }

    public GT3GeetestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000oO0 = context;
    }

    public final void O000000o() {
        this.O0000ooo = true;
        this.O00oOooO = false;
        this.O0000ooO = false;
        this.O0000oO = false;
        this.O0000oOO = false;
        this.O0000oOo = false;
        this.O0000oo0 = false;
        this.O0000oo = false;
    }

    public final void O00000Oo() {
        this.O0000ooO = true;
        this.O0000oO = false;
        this.O0000oOO = false;
        this.O0000oOo = false;
        this.O0000oo0 = false;
        this.O0000oo = false;
        this.O0000ooo = false;
        this.O00oOooO = false;
    }

    public final void O00000o() {
        this.O0000oOO = true;
        this.O0000oO = false;
        this.O0000oOo = false;
        this.O0000oo0 = false;
        this.O0000oo = false;
        this.O0000ooO = false;
        this.O0000ooo = false;
        this.O00oOooO = false;
    }

    public final void O00000o0() {
        this.O00oOooo = 0.0d;
        this.O0000oO = true;
        this.O0000oOO = false;
        this.O0000oOo = false;
        this.O0000oo0 = false;
        this.O0000oo = false;
        this.O0000ooO = false;
        this.O0000ooo = false;
        this.O00oOooO = false;
    }

    public final void O00000oO() {
        this.O000O00o = 0.0d;
        this.O000O0OO = this.O0000o;
        this.O00oOoOo = this.O0000o0o;
        this.O0000oOO = false;
        this.O0000oO = false;
        this.O0000oOo = true;
        this.O0000ooO = false;
        this.O0000oo0 = false;
        this.O0000oo = false;
        this.O0000ooo = false;
        this.O00oOooO = false;
    }

    public final void O00000oo() {
        this.O0000oOO = false;
        this.O0000oO = false;
        this.O0000oOo = false;
        this.O0000ooO = false;
        this.O0000oo0 = true;
        this.O0000oo = false;
        this.O0000ooo = false;
        this.O00oOooO = false;
        this.O00oOoOo = this.O0000o0o;
    }

    public final void O0000O0o() {
        this.O000O0o0 = ValueAnimator.ofInt(new int[]{0, SecExceptionCode.SEC_ERROR_STA_ENC});
        this.O000O0o0.setDuration(700);
        this.O000O0o0.addUpdateListener(new O0000o00(this));
        this.O000O0o = ValueAnimator.ofInt(new int[]{0, 255});
        this.O000O0o.setDuration(700);
        this.O000O0o.addUpdateListener(new O0000o0(this));
        this.O000O0oo = new AnimatorSet();
        this.O000O0oo.playTogether(new Animator[]{this.O000O0o0, this.O000O0o});
        this.O000O0oo.start();
        this.O0000oOO = false;
        this.O0000oO = false;
        this.O0000oOo = false;
        this.O0000ooO = false;
        this.O0000oo0 = false;
        this.O0000ooo = false;
        this.O00oOooO = false;
        this.O0000oo = true;
    }

    public final void O0000OOo() {
        this.O0000oOO = false;
        this.O0000oO = false;
        this.O0000oOo = false;
        this.O0000ooO = false;
        this.O0000oo0 = false;
        this.O0000ooo = false;
        this.O00oOooO = true;
        this.O0000oo = false;
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Canvas canvas2 = canvas;
        Context context = this.O0000oO0;
        O00O00o o00O00o = new O00O00o();
        this.O0000o = O0OO00O.O000000o(context, (float) O00O00o.O00000o0());
        context = this.O0000oO0;
        o00O00o = new O00O00o();
        this.O0000o0o = O0OO00O.O000000o(context, (float) O00O00o.O00000o());
        context = this.O0000oO0;
        o00O00o = new O00O00o();
        int O000000o = O0OO00O.O000000o(context, (float) O00O00o.O00000oO());
        Context context2 = this.O0000oO0;
        O00O00o o00O00o2 = new O00O00o();
        int O000000o2 = O0OO00O.O000000o(context2, (float) O00O00o.O00000oo());
        context2 = this.O0000oO0;
        o00O00o2 = new O00O00o();
        int O000000o3 = O0OO00O.O000000o(context2, (float) O00O00o.O0000O0o());
        context2 = this.O0000oO0;
        o00O00o2 = new O00O00o();
        int O000000o4 = O0OO00O.O000000o(context2, (float) O00O00o.O0000OOo());
        context2 = this.O0000oO0;
        o00O00o2 = new O00O00o();
        int O000000o5 = O0OO00O.O000000o(context2, (float) O00O00o.O00000Oo());
        this.O0000o0 = new Path();
        this.O000000o = new Paint(1536);
        this.O000000o.setAntiAlias(true);
        Paint paint = this.O000000o;
        O00O0OOo o00O0OOo = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000o0());
        this.O000000o.setStrokeWidth(1.0f);
        this.O000000o.setStyle(Style.FILL);
        this.O0000OoO = new Paint(1536);
        this.O0000OoO.setAntiAlias(true);
        paint = this.O0000OoO;
        O00O0OOo o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O0000O0o());
        this.O0000OoO.setStrokeWidth(1.0f);
        this.O0000OoO.setStyle(Style.FILL);
        this.O00000Oo = new Paint(1536);
        this.O00000Oo.setAntiAlias(true);
        paint = this.O00000Oo;
        o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000o());
        this.O00000Oo.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 1.0f));
        this.O00000Oo.setStyle(Style.STROKE);
        this.O00000o0 = new Paint(1536);
        this.O00000o0.setAntiAlias(true);
        paint = this.O00000o0;
        o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000o());
        this.O00000o0.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 2.0f));
        this.O00000o0.setStyle(Style.STROKE);
        this.O00000o = new Paint(1536);
        this.O00000o.setAntiAlias(true);
        paint = this.O00000o;
        o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000o());
        this.O00000o.setStrokeWidth(1.0f);
        this.O00000o.setStyle(Style.FILL);
        this.O00000oO = new Paint(1536);
        this.O00000oO.setAntiAlias(true);
        paint = this.O00000oO;
        o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000o());
        this.O00000oO.setStrokeWidth(1.0f);
        this.O00000oO.setStyle(Style.FILL);
        this.O00000oO.setAlpha(25);
        this.O0000OOo = new Paint(1536);
        this.O0000OOo.setAntiAlias(true);
        paint = this.O0000OOo;
        o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000oo());
        this.O0000OOo.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 2.0f));
        this.O0000OOo.setStyle(Style.FILL);
        this.O00000oo = new Paint(1536);
        this.O00000oo.setAntiAlias(true);
        paint = this.O00000oo;
        o00O0OOo2 = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000o());
        this.O00000oo.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 1.0f));
        this.O00000oo.setStyle(Style.FILL);
        this.O00000oo.setAlpha(50);
        this.O0000O0o = new Paint(1536);
        this.O0000O0o.setAntiAlias(true);
        paint = this.O0000O0o;
        o00O0OOo = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000Oo());
        this.O0000O0o.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 4.0f));
        this.O0000O0o.setStyle(Style.FILL);
        this.O0000Ooo = new Paint(1536);
        this.O0000Ooo.setAntiAlias(true);
        paint = this.O0000Ooo;
        o00O0OOo = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000Oo());
        this.O0000Ooo.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 2.0f));
        this.O0000Ooo.setStyle(Style.FILL);
        this.O0000Oo0 = new Paint(1536);
        this.O0000Oo0.setAntiAlias(true);
        paint = this.O0000Oo0;
        o00O0OOo = new O00O0OOo();
        paint.setColor(O00O0OOo.O00000oO());
        this.O0000Oo0.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 2.0f));
        this.O0000Oo0.setStyle(Style.STROKE);
        this.O0000Oo = new Paint(1536);
        this.O0000Oo.setAntiAlias(true);
        paint = this.O0000Oo;
        O00O0OOo o00O0OOo3 = new O00O0OOo();
        paint.setColor(O00O0OOo.O000000o());
        this.O0000Oo.setStrokeWidth((float) O0OO00O.O000000o(this.O0000oO0, 3.0f));
        this.O0000Oo.setStyle(Style.STROKE);
        postInvalidate();
        super.onDraw(canvas);
        if (this.O0000o0O != null) {
            this.O0000o00 = this.O0000o0O.O000000o();
        }
        if (this.O0000ooo) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O000000o);
        }
        if (this.O0000ooO) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O00000o);
        }
        if (this.O0000oO) {
            double abs = ((double) O000000o) + (((double) (this.O0000o0o - O000000o)) * Math.abs(Math.sin(this.O00oOooo)));
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O00000o);
            float f = (float) abs;
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f, this.O00000Oo);
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), f, this.O00000oO);
            this.O00oOooo += 0.05d;
        }
        if (this.O0000oOO) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O00000o);
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o0o, this.O00000Oo);
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o0o, this.O00000oO);
            canvas2.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas2.drawArc(new RectF((float) (-this.O0000o0o), (float) (-this.O0000o0o), (float) this.O0000o0o, (float) this.O0000o0o), this.O0000o00 - 90.0f, 45.0f, true, this.O00000oo);
        }
        if (this.O0000oOo) {
            if (this.O00oOoOo > 0) {
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O00000o);
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O00oOoOo, this.O00000Oo);
            } else if (this.O000O0OO < this.O0000o || this.O000O0OO > this.O0000o0o) {
                double abs2 = 0.0d + (((double) (this.O0000o0o << 1)) * Math.abs(Math.sin(this.O000O00o)));
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O00000o);
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o0o, this.O00000o0);
                canvas2.drawPoint(((float) getWidth()) / 2.0f, (float) ((getHeight() / 2) - this.O0000o0o), this.O0000O0o);
                canvas2.drawPoint((float) ((getWidth() / 2) - this.O0000o0o), (float) (getHeight() / 2), this.O0000O0o);
                canvas2.drawPoint((((float) getWidth()) / 2.0f) + ((float) this.O0000o0o), (float) (getHeight() / 2), this.O0000O0o);
                canvas2.drawPoint(((float) getWidth()) / 2.0f, (float) ((getHeight() / 2) + this.O0000o0o), this.O0000O0o);
                if (abs2 <= ((double) this.O0000o0o)) {
                    i = O000000o4;
                    i2 = O000000o5;
                    i3 = O000000o2;
                    i4 = O000000o3;
                    canvas2.drawLine((float) (((double) (getWidth() / 2)) - Math.sqrt(Math.pow((double) this.O0000o0o, 2.0d) - Math.pow(((double) this.O0000o0o) - abs2, 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.O0000o0o) - abs2)), (float) (((double) (getWidth() / 2)) + Math.sqrt(Math.pow((double) this.O0000o0o, 2.0d) - Math.pow(((double) this.O0000o0o) - abs2, 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.O0000o0o) - abs2)), this.O0000OOo);
                } else {
                    i3 = O000000o2;
                    i4 = O000000o3;
                    i = O000000o4;
                    i2 = O000000o5;
                    canvas2.drawLine((float) (((double) (getWidth() / 2)) - Math.sqrt(Math.pow((double) this.O0000o0o, 2.0d) - Math.pow(abs2 - ((double) this.O0000o0o), 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.O0000o0o) - abs2)), (float) (((double) (getWidth() / 2)) + Math.sqrt(Math.pow((double) this.O0000o0o, 2.0d) - Math.pow(abs2 - ((double) this.O0000o0o), 2.0d))), (float) (((double) (getHeight() / 2)) - (((double) this.O0000o0o) - abs2)), this.O0000OOo);
                }
                this.O000O00o += 0.05d;
                i5 = 2;
                this.O00oOoOo -= 2;
            } else {
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O0000o, this.O00000o);
                canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) this.O000O0OO, this.O00000Oo);
                this.O000O0OO += 2;
            }
            i3 = O000000o2;
            i4 = O000000o3;
            i = O000000o4;
            i2 = O000000o5;
            i5 = 2;
            this.O00oOoOo -= 2;
        } else {
            i3 = O000000o2;
            i4 = O000000o3;
            i = O000000o4;
            i2 = O000000o5;
            i5 = 2;
        }
        if (this.O0000oo0) {
            if (this.O00oOoOo >= 0) {
                canvas2.drawCircle((float) (getWidth() / i5), (float) (getHeight() / i5), (float) this.O00oOoOo, this.O00000Oo);
                canvas2.drawCircle((float) (getWidth() / i5), (float) (getHeight() / i5), (float) this.O0000o, this.O00000o);
            } else {
                float f2 = (float) i3;
                canvas2.drawCircle((float) (getWidth() / i5), (float) (getHeight() / i5), f2, this.O000000o);
                canvas2.drawCircle((float) ((getWidth() / i5) - this.O0000o), (float) (getHeight() / i5), f2, this.O000000o);
                canvas2.drawCircle((float) ((getWidth() / i5) + this.O0000o), (float) (getHeight() / i5), f2, this.O000000o);
            }
            this.O00oOoOo -= 5;
        }
        if (this.O0000oo) {
            this.O0000Oo.setAlpha(this.O000O0oO);
            int i6 = (2 * i4) / 22;
            this.O0000o0.moveTo((float) ((getWidth() / 2) - ((i4 * 13) / 22)), (float) ((getHeight() / 2) - i6));
            this.O0000o0.lineTo((float) ((getWidth() / 2) - i6), (float) ((getHeight() / 2) + ((i4 * 10) / 22)));
            this.O0000o0.lineTo((float) ((getWidth() / 2) + ((i4 * 22) / 22)), (float) ((getHeight() / 2) - ((i4 << 4) / 22)));
            canvas2.drawPath(this.O0000o0, this.O0000Oo);
            canvas2.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            O000000o = i4;
            float f3 = (float) (-O000000o);
            float f4 = (float) O000000o;
            canvas2.drawArc(new RectF(f3, f3, f4, f4), 300.0f, (float) (-this.O000O0Oo), false, this.O0000Oo0);
        }
        if (this.O00oOooO) {
            canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) i, this.O0000OoO);
            canvas2.drawLine((float) ((getWidth() / 2) - i2), (float) (getHeight() / 2), (float) ((getWidth() / 2) + i2), (float) (getHeight() / 2), this.O0000Ooo);
        }
    }

    public void setGtListener(O000000o o000000o) {
        this.O0000o0O = o000000o;
    }
}
