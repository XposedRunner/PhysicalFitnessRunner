package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.BarChartPoint;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class BarChart extends View {
    private Paint O000000o;
    private Paint O00000Oo;
    private Paint O00000o;
    private Paint O00000o0;
    private DashPathEffect O00000oO;
    private Path O00000oo;
    private SimpleDateFormat O0000O0o;
    private SimpleDateFormat O0000OOo;
    private float O0000Oo = 10.0f;
    private float O0000Oo0 = 15.0f;
    private float O0000OoO = 15.0f;
    private int O0000Ooo = -7829368;
    private int O0000o = -7829368;
    private float O0000o0 = 5.0f;
    private int O0000o00 = -1;
    private int O0000o0O = -7829368;
    private int O0000o0o = -1;
    private String O0000oO = "公里";
    private String O0000oO0 = "本柱状图仅展示近7天运动数据";
    private String O0000oOO;
    private float O0000oOo;
    private float O0000oo;
    private float O0000oo0;
    private float O0000ooO;
    private float O0000ooo;
    private List<BarChartPoint> O000O00o;
    private boolean O00oOooO;
    private boolean O00oOooo;

    public BarChart(Context context) {
        super(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("单位:");
        stringBuilder.append(this.O0000oO);
        this.O0000oOO = stringBuilder.toString();
        this.O0000oOo = 20.0f;
        this.O0000oo0 = 14.0f;
        this.O0000oo = 20.0f;
        this.O0000ooO = 24.0f;
        O000000o(null);
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("单位:");
        stringBuilder.append(this.O0000oO);
        this.O0000oOO = stringBuilder.toString();
        this.O0000oOo = 20.0f;
        this.O0000oo0 = 14.0f;
        this.O0000oo = 20.0f;
        this.O0000ooO = 24.0f;
        O000000o(attributeSet);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("单位:");
        stringBuilder.append(this.O0000oO);
        this.O0000oOO = stringBuilder.toString();
        this.O0000oOo = 20.0f;
        this.O0000oo0 = 14.0f;
        this.O0000oo = 20.0f;
        this.O0000ooO = 24.0f;
        O000000o(attributeSet);
    }

    private float O000000o(float f) {
        return (f * getContext().getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    private void O000000o(Canvas canvas, float f, float f2) {
        this.O00000Oo.setColor(this.O0000o0O);
        this.O00000Oo.setTextSize(this.O0000oOo);
        canvas.drawText(this.O0000oO0, CropImageView.DEFAULT_ASPECT_RATIO, (this.O0000oOo + f2) / 2.0f, this.O00000Oo);
        this.O00000Oo.setTextSize(this.O0000oo0);
        canvas.drawText(this.O0000oOO, f - this.O00000Oo.measureText(this.O0000oOO), (f2 + this.O0000oOo) / 2.0f, this.O00000Oo);
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BarChart);
            this.O0000OoO = obtainStyledAttributes.getDimension(2, 15.0f);
            this.O0000o0O = obtainStyledAttributes.getColor(8, -16776961);
            this.O0000o0o = obtainStyledAttributes.getColor(9, -1);
            this.O0000Ooo = obtainStyledAttributes.getColor(0, -16776961);
            this.O0000o00 = obtainStyledAttributes.getColor(1, -1);
            this.O0000o0 = obtainStyledAttributes.getDimension(4, 5.0f);
            this.O0000o = obtainStyledAttributes.getColor(5, -7829368);
            this.O0000oO0 = obtainStyledAttributes.getString(10);
            this.O0000oO = obtainStyledAttributes.getString(11);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("单位:");
            stringBuilder.append(this.O0000oO);
            this.O0000oOO = stringBuilder.toString();
            this.O0000oOo = obtainStyledAttributes.getDimension(12, 20.0f);
            this.O0000oo0 = obtainStyledAttributes.getDimension(6, 14.0f);
            this.O0000oo = obtainStyledAttributes.getDimension(3, 20.0f);
            this.O0000ooO = obtainStyledAttributes.getDimension(7, 24.0f);
            obtainStyledAttributes.recycle();
        }
        this.O000000o = new Paint();
        this.O000000o.setAntiAlias(true);
        this.O000000o.setStrokeWidth(0.5f);
        this.O000000o.setStyle(Style.STROKE);
        this.O000000o.setColor(this.O0000o);
        this.O00000Oo = new Paint();
        this.O00000Oo.setAntiAlias(true);
        this.O00000Oo.setColor(this.O0000o0O);
        this.O00000o = new Paint();
        this.O00000o.setAntiAlias(true);
        this.O00000o.setColor(this.O0000o0o);
        this.O00000o.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        this.O00000o.setTextSize(this.O0000ooO);
        this.O00000o0 = new Paint();
        this.O00000o0.setAntiAlias(true);
        this.O00000o0.setColor(this.O0000Ooo);
        this.O00000o0.setStrokeWidth(this.O0000OoO);
        this.O00000o0.setStyle(Style.STROKE);
        this.O00000o0.setStrokeCap(Cap.ROUND);
        this.O00000oO = new DashPathEffect(new float[]{this.O0000o0, this.O0000o0, this.O0000o0, this.O0000o0, this.O0000o0}, 1.0f);
        this.O00000oo = new Path();
        this.O0000O0o = new SimpleDateFormat(O000O0o0.O00000Oo, Locale.getDefault());
        this.O0000OOo = new SimpleDateFormat("dd", Locale.getDefault());
        this.O0000Oo0 = O000000o(7.0f);
        this.O0000Oo = O000000o(5.0f);
    }

    private void O00000Oo(Canvas canvas, float f, float f2) {
        canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, f2, f, f2 + 1.0f, this.O000000o);
        this.O000000o.setPathEffect(this.O00000oO);
        for (int i = 2; i < 5; i++) {
            float f3 = ((float) i) * f2;
            this.O00000oo.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, f3);
            this.O00000oo.lineTo(f, f3);
        }
        canvas.drawPath(this.O00000oo, this.O000000o);
        this.O000000o.setPathEffect(null);
        float f4 = f2 * 5.0f;
        canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, f4, f, f4 + 1.0f, this.O000000o);
    }

    private void O00000o(Canvas canvas, float f, float f2) {
        this.O00000Oo.setTextSize(this.O0000oo);
        int i = 0;
        while (i < 7) {
            Calendar instance = Calendar.getInstance();
            instance.add(5, i - 6);
            String format = i == 0 ? this.O0000O0o.format(instance.getTime()) : this.O0000OOo.format(instance.getTime());
            float measureText = this.O00000Oo.measureText(format);
            Paint paint = this.O00000Oo;
            int i2 = (this.O000O00o == null || this.O000O00o.size() <= 0 || !((BarChartPoint) this.O000O00o.get(i)).isSelected()) ? this.O0000o0O : this.O0000o0o;
            paint.setColor(i2);
            canvas.drawText(format, ((0.5f + ((float) i)) * f) - (measureText / 2.0f), (this.O0000oo / 2.0f) + f2, this.O00000Oo);
            i++;
        }
    }

    private float O00000o0(Canvas canvas, float f, float f2) {
        this.O00000Oo.setColor(this.O0000o0O);
        this.O00000Oo.setTextSize(this.O0000oo0);
        float f3 = CropImageView.DEFAULT_ASPECT_RATIO;
        int i = 2;
        while (i < 5) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((5 - i) * 2);
            stringBuilder.append(this.O0000oO);
            String stringBuilder2 = stringBuilder.toString();
            float measureText = this.O00000Oo.measureText(stringBuilder2);
            canvas.drawText(stringBuilder2, f - measureText, (((float) i) * f2) - this.O0000Oo, this.O00000Oo);
            i++;
            f3 = measureText;
        }
        return f3;
    }

    private void O00000oO(Canvas canvas, float f, float f2) {
        float f3 = (f2 + this.O0000Oo0) + this.O0000ooO;
        float f4 = 5.0f * f2;
        float f5 = (f4 - this.O0000Oo0) - f3;
        for (int i = 0; i < this.O000O00o.size(); i++) {
            BarChartPoint barChartPoint = (BarChartPoint) this.O000O00o.get(i);
            if (barChartPoint.getScore() == CropImageView.DEFAULT_ASPECT_RATIO) {
                barChartPoint.setLocation(new Rect());
            } else {
                float score = ((1.0f - (barChartPoint.getScore() / 7.5f)) * f5) + f3;
                if (barChartPoint.getScore() >= 7.5f) {
                    score = f3;
                } else if (barChartPoint.getScore() <= 2.0f) {
                    score += this.O0000Oo0;
                }
                if (score >= (f4 - this.O0000Oo0) - 1.0f) {
                    score = (f4 - this.O0000Oo0) - 1.0f;
                }
                float f6 = (f / 2.0f) + (((float) i) * f);
                Rect rect = new Rect(Math.round(f6 - this.O0000OoO), Math.round(score), Math.round(this.O0000OoO + f6), Math.round(f4 - this.O0000Oo0));
                barChartPoint.setLocation(new Rect(Math.round(f6 - this.O0000OoO), Math.round(f2), Math.round(f6 + this.O0000OoO), Math.round(6.0f * f2)));
                this.O00000o0.setColor(barChartPoint.isSelected() ? this.O0000o00 : this.O0000Ooo);
                canvas.drawLine(((float) rect.left) + this.O0000OoO, (float) rect.top, ((float) rect.right) - this.O0000OoO, (float) rect.bottom, this.O00000o0);
                if (barChartPoint.isSelected()) {
                    String format = new DecimalFormat("#0.00").format((double) barChartPoint.getScore());
                    canvas.drawText(format, (((float) rect.left) + this.O0000OoO) - (this.O00000o.measureText(format) / 2.0f), ((float) rect.top) - this.O0000Oo0, this.O00000o);
                }
            }
            Canvas canvas2 = canvas;
        }
    }

    public int getBarNormalColor() {
        return this.O0000Ooo;
    }

    public int getBarSelectedColor() {
        return this.O0000o00;
    }

    public float getBarWidth() {
        return this.O0000OoO;
    }

    public float getDashWidth() {
        return this.O0000o0;
    }

    public int getLineColor() {
        return this.O0000o;
    }

    public List<BarChartPoint> getPoints() {
        return this.O000O00o;
    }

    public float getTextBottomSize() {
        return this.O0000oo;
    }

    public int getTextNormalColor() {
        return this.O0000o0O;
    }

    public float getTextRightSize() {
        return this.O0000oo0;
    }

    public int getTextSelectedColor() {
        return this.O0000o0o;
    }

    public float getTextSelectedSize() {
        return this.O0000ooO;
    }

    public float getTextTitleSize() {
        return this.O0000oOo;
    }

    public String getTitle() {
        return this.O0000oO0;
    }

    public String getUnitText() {
        return this.O0000oO;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        float f = (float) width;
        float f2 = (float) (height / 6);
        O000000o(canvas, f, f2);
        O00000Oo(canvas, f, f2);
        this.O0000ooo = O00000o0(canvas, f, f2);
        O00000o(canvas, (f - this.O0000ooo) / 7.0f, (float) ((height * 11) / 12));
        if (this.O000O00o != null && this.O000O00o.size() == 7) {
            O00000oO(canvas, (f - this.O0000ooo) / 7.0f, f2);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O000O00o == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                for (BarChartPoint barChartPoint : this.O000O00o) {
                    if (barChartPoint.getLocation() != null && barChartPoint.getLocation().contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()))) {
                        this.O00oOooO = true;
                        break;
                    }
                }
                break;
            case 1:
                for (BarChartPoint barChartPoint2 : this.O000O00o) {
                    if (!this.O00oOooO || barChartPoint2.getLocation() == null || !barChartPoint2.getLocation().contains(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()))) {
                        barChartPoint2.setSelected(false);
                    } else if (!barChartPoint2.isSelected()) {
                        barChartPoint2.setSelected(true);
                        this.O00oOooo = true;
                    }
                }
                this.O00oOooO = false;
                if (this.O00oOooo) {
                    this.O00oOooo = false;
                    invalidate();
                    break;
                }
                break;
        }
        return true;
    }

    public void setBarNormalColor(int i) {
        this.O0000Ooo = i;
    }

    public void setBarSelectedColor(int i) {
        this.O0000o00 = i;
    }

    public void setBarWidth(float f) {
        this.O0000OoO = f;
    }

    public void setDashWidth(float f) {
        this.O0000o0 = f;
    }

    public void setLineColor(int i) {
        this.O0000o = i;
    }

    public void setPoints(List<BarChartPoint> list) {
        this.O000O00o = list;
        invalidate();
    }

    public void setTextBottomSize(float f) {
        this.O0000oo = f;
    }

    public void setTextNormalColor(int i) {
        this.O0000o0O = i;
    }

    public void setTextRightSize(float f) {
        this.O0000oo0 = f;
    }

    public void setTextSelectedColor(int i) {
        this.O0000o0o = i;
    }

    public void setTextSelectedSize(float f) {
        this.O0000ooO = f;
    }

    public void setTextTitleSize(float f) {
        this.O0000oOo = f;
    }

    public void setTitle(String str) {
        this.O0000oO0 = str;
    }

    public void setUnitText(String str) {
        this.O0000oO = str;
    }
}
