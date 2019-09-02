package com.geetest.sdk.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.wireless.security.SecExceptionCode;
import com.geetest.sdk.O0OO00O;

public class GT3View extends View {
    private int O000000o;
    private Paint O00000Oo;
    private Path O00000o;
    private Paint O00000o0;
    private int O00000oO;
    private Context O00000oo;
    private int O0000O0o;
    private ValueAnimator O0000OOo;
    private O000000o O0000Oo0;

    public interface O000000o {
        void O000000o();
    }

    public GT3View(Context context) {
        super(context);
        O000000o(context);
    }

    public GT3View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public GT3View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        this.O00000oo = context;
        this.O00000o = new Path();
        this.O00000Oo = new Paint(1536);
        this.O00000Oo.setAntiAlias(true);
        this.O00000Oo.setColor(-8333653);
        this.O00000Oo.setStrokeWidth((float) O0OO00O.O000000o(context, 2.0f));
        this.O00000Oo.setStyle(Style.STROKE);
        this.O000000o = 1;
        this.O00000o0 = new Paint(1536);
        this.O00000o0.setAntiAlias(true);
        this.O00000o0.setColor(-8333653);
        this.O00000o0.setStrokeWidth((float) O0OO00O.O000000o(context, 3.0f));
        this.O00000o0.setStyle(Style.STROKE);
    }

    public final void O000000o() {
        this.O0000OOo = ValueAnimator.ofInt(new int[]{0, 255});
        this.O0000OOo.setDuration(700);
        this.O0000OOo.addUpdateListener(new O0000o(this));
        this.O0000OOo.start();
        this.O0000O0o = 0;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        this.O00000oO = O0OO00O.O000000o(this.O00000oo, 12.0f);
        postInvalidate();
        super.onDraw(canvas);
        if (this.O0000O0o <= 100) {
            this.O00000o0.setAlpha(this.O000000o);
            this.O00000o.moveTo((float) ((getWidth() / 2) - ((13 * this.O00000oO) / 22)), (float) ((getHeight() / 2) - ((this.O00000oO * 2) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) - ((this.O00000oO * 2) / 22)), (float) ((getHeight() / 2) + ((10 * this.O00000oO) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) + ((this.O00000oO * 22) / 22)), (float) ((getHeight() / 2) - ((16 * this.O00000oO) / 22)));
            canvas.drawPath(this.O00000o, this.O00000o0);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas.drawArc(new RectF((float) (-this.O00000oO), (float) (-this.O00000oO), (float) this.O00000oO, (float) this.O00000oO), 300.0f, (float) (-this.O0000O0o), false, this.O00000Oo);
            this.O0000O0o += 20;
        } else if (this.O0000O0o > 100 && this.O0000O0o <= 200) {
            this.O00000o0.setAlpha(this.O000000o);
            this.O00000o.moveTo((float) ((getWidth() / 2) - ((13 * this.O00000oO) / 22)), (float) ((getHeight() / 2) - ((this.O00000oO * 2) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) - ((this.O00000oO * 2) / 22)), (float) ((getHeight() / 2) + ((this.O00000oO * 10) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) + ((this.O00000oO * 22) / 22)), (float) ((getHeight() / 2) - ((16 * this.O00000oO) / 22)));
            canvas.drawPath(this.O00000o, this.O00000o0);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas.drawArc(new RectF((float) (-this.O00000oO), (float) (-this.O00000oO), (float) this.O00000oO, (float) this.O00000oO), 300.0f, (float) (-this.O0000O0o), false, this.O00000Oo);
            this.O0000O0o += 10;
        } else if (this.O0000O0o > 200 && this.O0000O0o <= SecExceptionCode.SEC_ERROR_STA_ENC) {
            this.O00000o0.setAlpha(this.O000000o);
            this.O00000o.moveTo((float) ((getWidth() / 2) - ((13 * this.O00000oO) / 22)), (float) ((getHeight() / 2) - ((this.O00000oO * 2) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) - ((this.O00000oO * 2) / 22)), (float) ((getHeight() / 2) + ((10 * this.O00000oO) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) + ((this.O00000oO * 22) / 22)), (float) ((getHeight() / 2) - ((16 * this.O00000oO) / 22)));
            canvas.drawPath(this.O00000o, this.O00000o0);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas.drawArc(new RectF((float) (-this.O00000oO), (float) (-this.O00000oO), (float) this.O00000oO, (float) this.O00000oO), 300.0f, (float) (-this.O0000O0o), false, this.O00000Oo);
            this.O0000O0o += 20;
        } else if (this.O0000O0o <= SecExceptionCode.SEC_ERROR_STA_ENC || this.O0000O0o >= 800) {
            this.O00000o.moveTo((float) ((getWidth() / 2) - ((13 * this.O00000oO) / 22)), (float) ((getHeight() / 2) - ((this.O00000oO * 2) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) - ((this.O00000oO * 2) / 22)), (float) ((getHeight() / 2) + ((10 * this.O00000oO) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) + ((this.O00000oO * 22) / 22)), (float) ((getHeight() / 2) - ((16 * this.O00000oO) / 22)));
            canvas.drawPath(this.O00000o, this.O00000o0);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas.drawArc(new RectF((float) (-this.O00000oO), (float) (-this.O00000oO), (float) this.O00000oO, (float) this.O00000oO), 300.0f, -300.0f, false, this.O00000Oo);
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.O000000o();
            }
        } else {
            this.O00000o0.setAlpha(this.O000000o);
            this.O00000o.moveTo((float) ((getWidth() / 2) - ((13 * this.O00000oO) / 22)), (float) ((getHeight() / 2) - ((this.O00000oO * 2) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) - ((this.O00000oO * 2) / 22)), (float) ((getHeight() / 2) + ((this.O00000oO * 10) / 22)));
            this.O00000o.lineTo((float) ((getWidth() / 2) + ((this.O00000oO * 22) / 22)), (float) ((getHeight() / 2) - ((16 * this.O00000oO) / 22)));
            canvas.drawPath(this.O00000o, this.O00000o0);
            canvas.translate((float) (getWidth() / 2), (float) (getHeight() / 2));
            canvas.drawArc(new RectF((float) (-this.O00000oO), (float) (-this.O00000oO), (float) this.O00000oO, (float) this.O00000oO), 300.0f, -300.0f, false, this.O00000Oo);
            this.O0000O0o += 10;
        }
    }

    public void setGtListener(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
    }
}
