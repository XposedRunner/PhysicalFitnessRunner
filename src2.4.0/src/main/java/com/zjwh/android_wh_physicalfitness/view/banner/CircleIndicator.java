package com.zjwh.android_wh_physicalfitness.view.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import java.util.ArrayList;
import java.util.List;

public class CircleIndicator extends View {
    private static final String O000000o = "CircleIndicator";
    private int O00000Oo = 0;
    private O000000o O00000o;
    private int O00000o0 = 0;
    private List<O000000o> O00000oO;
    private float O00000oo;

    private class O000000o {
        private float O00000Oo = CropImageView.DEFAULT_ASPECT_RATIO;
        private Drawable O00000o;
        private float O00000o0 = CropImageView.DEFAULT_ASPECT_RATIO;

        O000000o(Drawable drawable) {
            this.O00000o = drawable;
        }

        public Drawable O000000o() {
            return this.O00000o;
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(float f) {
            this.O00000Oo = f;
        }

        /* Access modifiers changed, original: 0000 */
        public float O00000Oo() {
            return this.O00000Oo;
        }

        /* Access modifiers changed, original: 0000 */
        public void O00000Oo(float f) {
            this.O00000o0 = f;
        }

        /* Access modifiers changed, original: 0000 */
        public float O00000o0() {
            return this.O00000o0;
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        O000000o();
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void O000000o() {
        this.O00000oO = new ArrayList();
        this.O00000Oo = O000000o(4.0f);
        this.O00000oo = (float) O000000o(4.0f);
    }

    private void O000000o(int i, float f) {
        if (this.O00000o0 > 1 && this.O00000o != null && this.O00000oO.size() != 0) {
            i %= this.O00000o0;
            if (this.O00000oO.size() - 1 != i || f == CropImageView.DEFAULT_ASPECT_RATIO) {
                this.O00000o.O000000o(((O000000o) this.O00000oO.get(i)).O00000Oo() + ((this.O00000oo + ((float) this.O00000Oo)) * f));
                invalidate();
            }
        }
    }

    private void O000000o(Canvas canvas, O000000o o000000o) {
        canvas.save();
        canvas.translate(o000000o.O00000Oo(), o000000o.O00000o0());
        o000000o.O000000o().draw(canvas);
        canvas.restore();
    }

    private void O00000Oo() {
        for (int i = 0; i < this.O00000o0; i++) {
            OvalShape ovalShape = new OvalShape();
            ovalShape.resize((float) this.O00000Oo, (float) this.O00000Oo);
            ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
            O000000o o000000o = new O000000o(shapeDrawable);
            Paint paint = shapeDrawable.getPaint();
            paint.setColor(ContextCompat.getColor(getContext(), R.color.banner_indicator_normal));
            paint.setAntiAlias(true);
            o000000o.O000000o((this.O00000oo + ((float) this.O00000Oo)) * ((float) i));
            this.O00000oO.add(o000000o);
        }
        requestLayout();
    }

    private void O00000o0() {
        OvalShape ovalShape = new OvalShape();
        ovalShape.resize((float) this.O00000Oo, (float) this.O00000Oo);
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        this.O00000o = new O000000o(shapeDrawable);
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.sport_green));
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
    }

    public void O000000o(ViewPager viewPager, int i) {
        this.O00000o0 = i;
        O00000Oo();
        O00000o0();
        viewPager.addOnPageChangeListener(new SimpleOnPageChangeListener() {
            public void onPageScrolled(int i, float f, int i2) {
                CircleIndicator.this.O000000o(i, f);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) getWidth(), (float) this.O00000Oo, null, 31);
        for (O000000o O000000o : this.O00000oO) {
            O000000o(canvas, O000000o);
        }
        if (this.O00000o != null) {
            O000000o(canvas, this.O00000o);
        }
        canvas.restoreToCount(saveLayer);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension((int) (((this.O00000oo + ((float) this.O00000Oo)) * ((float) this.O00000o0)) - this.O00000oo), this.O00000Oo);
    }
}
