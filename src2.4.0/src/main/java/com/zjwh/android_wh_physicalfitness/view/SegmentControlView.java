package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import java.lang.reflect.Field;

public class SegmentControlView extends View {
    private static final float O000000o = 0.95f;
    private static final int O00000Oo = -1;
    private static final int O00000o = -13850209;
    private static final int O00000o0 = -13850209;
    private static final int O00000oO = -1;
    private static final int O00000oo = -1;
    private static final int O0000O0o = -13850209;
    private static final int O0000OOo = -13850209;
    private static final int O0000Oo = 2;
    private static final int O0000Oo0 = 16;
    private static final int O0000OoO = 0;
    private static final int O0000Ooo = 0;
    private static final int O0000o0 = 12;
    private static final int O0000o00 = 16;
    private static final boolean O0000o0O = false;
    private int O0000o = -13850209;
    private String[] O0000o0o = null;
    private int O0000oO = -1;
    private int O0000oO0 = -1;
    private int[] O0000oOO;
    private int O0000oOo = -13850209;
    private int O0000oo = 2;
    private int O0000oo0 = -13850209;
    private int O0000ooO = 0;
    private int O0000ooo = 0;
    private int O000O00o = 12;
    private boolean O000O0OO = false;
    private O00000Oo O000O0Oo;
    private Paint O000O0o;
    private Paint O000O0o0;
    private Paint O000O0oO;
    private RectF O000O0oo;
    private float O000OO;
    private RectF O000OO00;
    private Path O000OO0o;
    private int O000OOOo = -1;
    private ViewPager O000OOo;
    private int O000OOo0 = -1;
    private int O000OOoO = -1;
    private float O000OOoo = CropImageView.DEFAULT_ASPECT_RATIO;
    private float O00oOoOo = CropImageView.DEFAULT_ASPECT_RATIO;
    private int O00oOooO = 0;
    private int O00oOooo = 16;

    public interface O00000Oo {
        void O000000o(int i);
    }

    private class O000000o implements OnPageChangeListener {
        private O000000o() {
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (SegmentControlView.this.O000O0OO) {
                SegmentControlView.this.O00oOooO = i;
                SegmentControlView.this.O000OOoO = i;
                SegmentControlView.this.O000OOoo = f;
                SegmentControlView.this.invalidate();
            }
        }

        public void onPageSelected(int i) {
            if (!SegmentControlView.this.O000O0OO) {
                SegmentControlView.this.setSelectedIndex(i);
            }
        }
    }

    public SegmentControlView(Context context) {
        super(context);
        O00000Oo();
    }

    public SegmentControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
        O00000Oo();
    }

    public SegmentControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
        O00000Oo();
    }

    private float O000000o(FontMetrics fontMetrics) {
        return fontMetrics == null ? CropImageView.DEFAULT_ASPECT_RATIO : Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private int O000000o(float f, float f2) {
        if (!this.O000O0oo.contains(f, f2)) {
            return -1;
        }
        int i = 0;
        while (i < this.O0000o0o.length) {
            if (this.O000O0oo.left + (((float) i) * this.O00oOoOo) <= f && f < this.O000O0oo.left + (((float) (i + 1)) * this.O00oOoOo)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private int O000000o(float f, int i, int i2) {
        int i3 = (i & -16777216) >>> 24;
        int i4 = (i & 16711680) >>> 16;
        int i5 = (i & 65280) >>> 8;
        i = (i & 255) >>> 0;
        return ((int) (((float) i) + (((float) (((i2 & 255) >>> 0) - i)) * f))) | (((((int) (((float) i3) + (((float) (((-16777216 & i2) >>> 24) - i3)) * f))) << 24) | (((int) (((float) i4) + (((float) (((16711680 & i2) >>> 16) - i4)) * f))) << 16)) | (((int) (((float) i5) + (((float) (((65280 & i2) >>> 8) - i5)) * f))) << 8));
    }

    private int O000000o(int i, float f) {
        return ((int) (((float) ((i & 255) >>> 0)) * f)) | (((((-16777216 & i) >>> 24) << 24) | (((int) (((float) ((16711680 & i) >>> 16)) * f)) << 16)) | (((int) (((float) ((65280 & i) >>> 8)) * f)) << 8));
    }

    private int O000000o(int i, Paint paint) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return i;
        }
        int O000000o = ((O000000o(this.O0000o0o, paint) + (this.O00oOooo * 2)) + (this.O0000oo * 2)) * this.O0000o0o.length;
        if (O000000o < this.O0000ooO * 2) {
            O000000o = this.O0000ooO * 2;
        }
        O000000o += getPaddingLeft() + getPaddingRight();
        return mode == Integer.MIN_VALUE ? Math.min(O000000o, i) : O000000o;
    }

    private static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private int O000000o(String str, Paint paint) {
        return !TextUtils.isEmpty(str) ? (int) (paint.measureText(str) + 0.5f) : -1;
    }

    private int O000000o(String[] strArr, Paint paint) {
        int i = 0;
        if (strArr == null) {
            return 0;
        }
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            if (str != null) {
                i2 = Math.max(O000000o(str, paint), i2);
            }
            i++;
        }
        return i2;
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentControlView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.O0000o = obtainStyledAttributes.getColor(index, -13850209);
                } else if (index == 0) {
                    this.O0000oO0 = obtainStyledAttributes.getColor(index, -1);
                } else if (index == 11) {
                    this.O0000oO = obtainStyledAttributes.getColor(index, -1);
                } else if (index == 10) {
                    this.O0000oOo = obtainStyledAttributes.getColor(index, -13850209);
                } else if (index == 2) {
                    this.O0000oo0 = obtainStyledAttributes.getColor(index, -13850209);
                } else if (index == 12) {
                    this.O0000ooo = obtainStyledAttributes.getDimensionPixelSize(index, O000000o(getContext(), 16.0f));
                } else if (index == 9) {
                    this.O0000o0o = O000000o(obtainStyledAttributes.getTextArray(index));
                } else if (index == 4) {
                    this.O0000oo = obtainStyledAttributes.getDimensionPixelSize(index, 2);
                } else if (index == 3) {
                    this.O0000ooO = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 8) {
                    this.O00oOooO = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == 6) {
                    this.O00oOooo = obtainStyledAttributes.getDimensionPixelSize(index, 16);
                } else if (index == 7) {
                    this.O000O00o = obtainStyledAttributes.getDimensionPixelSize(index, 12);
                } else if (index == 5) {
                    this.O000O0OO = obtainStyledAttributes.getBoolean(index, false);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void O000000o(Canvas canvas) {
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < this.O0000o0o.length) {
            float f = (float) i;
            float f2 = this.O000O0oo.left + (this.O00oOoOo * f);
            this.O000OO0o.reset();
            if (i == 0) {
                this.O000OO0o.moveTo(this.O000O0oo.left, this.O000O0oo.top + ((float) this.O0000ooO));
                this.O000OO00.offsetTo(this.O000O0oo.left, this.O000O0oo.top);
                this.O000OO0o.arcTo(this.O000OO00, 180.0f, 90.0f);
                this.O000OO0o.lineTo(this.O000O0oo.left + this.O00oOoOo, this.O000O0oo.top);
                this.O000OO0o.lineTo(this.O000O0oo.left + this.O00oOoOo, this.O000O0oo.bottom);
                this.O000OO0o.lineTo(this.O000O0oo.left + ((float) this.O0000ooO), this.O000O0oo.bottom);
                this.O000OO00.offsetTo(this.O000O0oo.left, this.O000O0oo.bottom - ((float) (2 * this.O0000ooO)));
                this.O000OO0o.arcTo(this.O000OO00, 90.0f, 90.0f);
            } else if (i == this.O0000o0o.length - 1) {
                this.O000OO0o.moveTo(this.O000O0oo.left + (this.O00oOoOo * f), this.O000O0oo.top);
                this.O000OO0o.lineTo(this.O000O0oo.right - ((float) this.O0000ooO), this.O000O0oo.top);
                this.O000OO00.offsetTo(this.O000O0oo.right - ((float) (this.O0000ooO * 2)), this.O000O0oo.top);
                this.O000OO0o.arcTo(this.O000OO00, 270.0f, 90.0f);
                this.O000OO0o.lineTo(this.O000O0oo.right, this.O000O0oo.bottom - ((float) this.O0000ooO));
                this.O000OO00.offsetTo(this.O000O0oo.right - ((float) (this.O0000ooO * 2)), this.O000O0oo.bottom - ((float) (2 * this.O0000ooO)));
                this.O000OO0o.arcTo(this.O000OO00, CropImageView.DEFAULT_ASPECT_RATIO, 90.0f);
                this.O000OO0o.lineTo(this.O000O0oo.left + (f * this.O00oOoOo), this.O000O0oo.bottom);
            } else {
                this.O000OO0o.moveTo(f2, this.O000O0oo.top);
                this.O000OO0o.lineTo(this.O00oOoOo + f2, this.O000O0oo.top);
                this.O000OO0o.lineTo(this.O00oOoOo + f2, this.O000O0oo.bottom);
                this.O000OO0o.lineTo(f2, this.O000O0oo.bottom);
            }
            this.O000OO0o.close();
            if (!this.O000O0OO) {
                if (i == this.O00oOooO) {
                    i2 = this.O0000o;
                    i3 = this.O0000oO;
                } else {
                    i2 = this.O0000oO0;
                    i3 = this.O0000oOo;
                }
            }
            if (this.O000O0OO) {
                if (this.O000OOoo != CropImageView.DEFAULT_ASPECT_RATIO) {
                    if (i == this.O000OOoO) {
                        i2 = O000000o(this.O000OOoo, this.O0000o, this.O0000oO0);
                        i3 = O000000o(this.O000OOoo, this.O0000oO, this.O0000oOo);
                    } else if (i == this.O000OOoO + 1) {
                        i2 = O000000o(this.O000OOoo, this.O0000oO0, this.O0000o);
                        i3 = O000000o(this.O000OOoo, this.O0000oOo, this.O0000oO);
                    } else {
                        i2 = this.O0000oO0;
                        i3 = this.O0000oOo;
                    }
                } else if (i == this.O00oOooO) {
                    i2 = this.O0000o;
                    i3 = this.O0000oO;
                    if (this.O0000oOO != null) {
                        i3 = this.O0000oOO[i];
                    }
                } else {
                    i2 = this.O0000oO0;
                    i3 = this.O0000oOo;
                }
            }
            this.O000O0o.setColor(i2);
            if (this.O000OOo0 == i) {
                this.O000O0o.setColor(O000000o(i2, (float) O000000o));
            }
            canvas.drawPath(this.O000OO0o, this.O000O0o);
            canvas.drawPath(this.O000OO0o, this.O000O0oO);
            this.O000O0o0.setColor(i3);
            canvas.drawText(this.O0000o0o[i], f2 + (this.O00oOoOo / 2.0f), this.O000O0oo.centerY() + this.O000OO, this.O000O0o0);
            i++;
        }
    }

    private void O000000o(String[] strArr) {
        if (strArr == null || strArr.length < 2) {
            throw new IllegalArgumentException("SegmentControlView's content text array'length should larger than 1");
        }
    }

    private boolean O000000o(ViewPager viewPager) {
        if (viewPager == null) {
            return false;
        }
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mOnPageChangeListener");
            if (declaredField == null) {
                return false;
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager);
            return obj != null && (obj instanceof O000000o);
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean O000000o(String[] strArr, String[] strArr2) {
        if (strArr == null && strArr2 == null) {
            return true;
        }
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        int i = 0;
        while (i < strArr.length) {
            if ((strArr[i] != null || strArr2[i] != null) && (strArr[i] == null || !strArr[i].equals(strArr2[i]))) {
                return false;
            }
            i++;
        }
        return true;
    }

    private String[] O000000o(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return null;
        }
        String[] strArr = new String[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = charSequenceArr[i].toString();
        }
        return strArr;
    }

    private int O00000Oo(int i, Paint paint) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return i;
        }
        int O00000Oo = (O00000Oo(this.O0000o0o, paint) + (this.O000O00o * 2)) + (this.O0000oo * 2);
        if (O00000Oo < this.O0000ooO * 2) {
            O00000Oo = this.O0000ooO * 2;
        }
        O00000Oo += getPaddingTop() + getPaddingBottom();
        return mode == Integer.MIN_VALUE ? Math.min(O00000Oo, i) : O00000Oo;
    }

    private int O00000Oo(String str, Paint paint) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    private int O00000Oo(String[] strArr, Paint paint) {
        int i = 0;
        if (strArr == null) {
            return 0;
        }
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            if (str != null) {
                i2 = Math.max(O00000Oo(str, paint), i2);
            }
            i++;
        }
        return i2;
    }

    private void O00000Oo() {
        this.O000O0oo = new RectF();
        this.O000OO00 = new RectF();
        this.O000OO0o = new Path();
        if (this.O0000ooo == 0) {
            this.O0000ooo = O000000o(getContext(), 16.0f);
        }
        this.O000O0o0 = new Paint();
        this.O000O0o0.setAntiAlias(true);
        this.O000O0o0.setTextAlign(Align.CENTER);
        this.O000O0o0.setTextSize((float) this.O0000ooo);
        this.O000O0o = new Paint();
        this.O000O0o.setAntiAlias(true);
        this.O000O0o.setStyle(Style.FILL);
        this.O000O0oO = new Paint();
        this.O000O0oO.setAntiAlias(true);
        this.O000O0oO.setStyle(Style.STROKE);
        this.O000O0oO.setStrokeWidth((float) this.O0000oo);
        this.O000O0oO.setColor(this.O0000oo0);
        this.O000OO = O000000o(this.O000O0o0.getFontMetrics());
        setClickable(true);
    }

    private boolean O00000Oo(String[] strArr) {
        return strArr == null || strArr.length == 0;
    }

    public void O000000o() {
        invalidate();
    }

    public void O000000o(int i, int i2) {
        this.O0000oOo = i;
        this.O0000oO = i2;
        invalidate();
    }

    public void O00000Oo(int i, int i2) {
        this.O0000oO0 = i;
        this.O0000o = i2;
        invalidate();
    }

    public int getCount() {
        return this.O0000o0o == null ? 0 : this.O0000o0o.length;
    }

    public boolean getGradient() {
        return this.O000O0OO;
    }

    public int getSelectedIndex() {
        return this.O00oOooO;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!O00000Oo(this.O0000o0o)) {
            O000000o(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(O000000o(i, this.O000O0o0), O00000Oo(i2, this.O000O0o0));
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O000O0oo.left = (float) getPaddingLeft();
        this.O000O0oo.top = (float) getPaddingTop();
        this.O000O0oo.right = (float) (i - getPaddingRight());
        this.O000O0oo.bottom = (float) (i2 - getPaddingBottom());
        float ceil = (float) Math.ceil((double) (this.O0000oo / 2));
        this.O000O0oo.inset(ceil, ceil);
        if (this.O0000o0o != null && this.O0000o0o.length > 0) {
            this.O00oOoOo = this.O000O0oo.width() / ((float) this.O0000o0o.length);
        }
        this.O000OO00.left = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O000OO00.top = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O000OO00.right = (float) (this.O0000ooO * 2);
        this.O000OO00.bottom = (float) (2 * this.O0000ooO);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.O000OOOo = this.O000OOo0;
        switch (motionEvent.getAction()) {
            case 0:
                this.O000OOo0 = O000000o(motionEvent.getX(), motionEvent.getY());
                if (this.O000OOOo != this.O000OOo0) {
                    invalidate();
                    break;
                }
                break;
            case 1:
                this.O000OOo0 = O000000o(motionEvent.getX(), motionEvent.getY());
                if (this.O000OOo0 != -1) {
                    if (!(this.O000O0Oo == null || this.O00oOooO == this.O000OOo0)) {
                        this.O000O0Oo.O000000o(this.O000OOo0);
                    }
                    this.O00oOooO = this.O000OOo0;
                }
                this.O000OOo0 = -1;
                if (!(this.O000O0OO && O000000o(this.O000OOo))) {
                    invalidate();
                    break;
                }
            case 2:
                this.O000OOo0 = O000000o(motionEvent.getX(), motionEvent.getY());
                if (this.O000OOOo != this.O000OOo0) {
                    invalidate();
                    break;
                }
                break;
            case 3:
                this.O000OOo0 = -1;
                invalidate();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFrameColor(int i) {
        this.O0000oo0 = i;
        invalidate();
    }

    public void setFrameWidth(int i) {
        this.O0000oo = i;
        requestLayout();
        invalidate();
    }

    public void setGradient(boolean z) {
        if (this.O000O0OO != z) {
            this.O000O0OO = z;
        }
    }

    public void setOnSegmentChangedListener(O00000Oo o00000Oo) {
        this.O000O0Oo = o00000Oo;
    }

    public void setSelectedIndex(int i) {
        if (this.O00oOooO != i) {
            this.O00oOooO = i;
            if (this.O000O0Oo != null) {
                this.O000O0Oo.O000000o(this.O00oOooO);
            }
            if (!this.O000O0OO || !O000000o(this.O000OOo)) {
                invalidate();
            }
        }
    }

    public void setTextColors(int[] iArr) {
        this.O0000oOO = iArr;
        invalidate();
    }

    public void setTextSize(int i) {
        if (this.O0000ooo != i) {
            this.O0000ooo = i;
            this.O000O0o0.setTextSize((float) i);
            this.O000OO = O000000o(this.O000O0o0.getFontMetrics());
            requestLayout();
            invalidate();
        }
    }

    public void setTexts(String[] strArr) {
        O000000o(strArr);
        if (strArr == null || strArr.length < 2) {
            throw new IllegalArgumentException("SegmentControlView's content text array'length should larger than 1");
        } else if (!O000000o(this.O0000o0o, strArr)) {
            this.O0000o0o = strArr;
            this.O00oOoOo = this.O000O0oo.width() / ((float) strArr.length);
            requestLayout();
            invalidate();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        this.O000OOo = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new O000000o());
        }
    }
}
