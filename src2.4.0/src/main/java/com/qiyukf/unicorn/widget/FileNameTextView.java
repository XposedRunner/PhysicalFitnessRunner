package com.qiyukf.unicorn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.qiyukf.unicorn.R;

public class FileNameTextView extends View {
    private TextPaint a;
    private StaticLayout b;
    private String c;
    private int d;

    public FileNameTextView(Context context) {
        this(context, null);
    }

    public FileNameTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FileNameTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.FileNameTextView);
        this.c = obtainAttributes.getString(R.styleable.FileNameTextView_ysf_fntText);
        this.d = obtainAttributes.getInt(R.styleable.FileNameTextView_ysf_fntMaxLines, 1);
        int color = obtainAttributes.getColor(R.styleable.FileNameTextView_ysf_fntTextColor, -7829368);
        float dimension = obtainAttributes.getDimension(R.styleable.FileNameTextView_ysf_fntTextSize, (float) ((int) ((14.0f * getResources().getDisplayMetrics().scaledDensity) + 0.5f)));
        obtainAttributes.recycle();
        this.a = new TextPaint();
        this.a.setAntiAlias(true);
        this.a.setColor(color);
        this.a.setTextSize(dimension);
    }

    private StaticLayout a(int i, String str) {
        int lastIndexOf = str.lastIndexOf(46);
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() > 6) {
            substring = substring.substring(substring.length() - 6);
            lastIndexOf = str.length() - 6;
        }
        str = str.substring(0, lastIndexOf);
        lastIndexOf = 0;
        while (lastIndexOf < str.length()) {
            int i2 = lastIndexOf + 1;
            String substring2 = str.substring(0, i2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(substring2);
            stringBuilder.append("...");
            stringBuilder.append(substring);
            if (a(stringBuilder.toString(), i).getLineCount() > this.d) {
                str = str.substring(0, lastIndexOf);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("...");
                stringBuilder2.append(substring);
                return a(stringBuilder2.toString(), i);
            }
            lastIndexOf = i2;
        }
        return null;
    }

    private StaticLayout a(String str, int i) {
        return new StaticLayout(str, this.a, i, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    }

    public final void a(String str) {
        this.c = str;
        requestLayout();
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (!TextUtils.isEmpty(this.c) && this.b != null) {
            this.b.draw(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        i = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        i2 = MeasureSpec.getMode(i2);
        this.c = TextUtils.isEmpty(this.c) ? "" : this.c;
        StaticLayout a = a(this.c, size);
        if ((i == 0 || i == Integer.MIN_VALUE) && a.getLineCount() <= 1) {
            size = (int) Math.ceil((double) this.a.measureText(this.c));
        }
        if (i2 == 0 || i2 == Integer.MIN_VALUE) {
            i = a.getLineCount();
            if (i <= 0) {
                i = 1;
            } else if (i > this.d) {
                i = this.d;
            }
            FontMetrics fontMetrics = this.a.getFontMetrics();
            size2 = (int) Math.ceil((double) (((float) i) * (fontMetrics.descent - fontMetrics.ascent)));
        }
        setMeasuredDimension(size, size2);
        StaticLayout a2 = a(this.c, size);
        if (a2.getLineCount() <= this.d) {
            this.b = a2;
            return;
        }
        i = this.c.lastIndexOf(46);
        if (i < 0 || i >= this.c.length() - 1) {
            String str = this.c;
            size2 = 0;
            while (size2 < str.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                int i3 = size2 + 1;
                stringBuilder.append(str.substring(0, i3));
                stringBuilder.append("...");
                if (a(stringBuilder.toString(), size).getLineCount() > this.d) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str.substring(0, size2));
                    stringBuilder.append("...");
                    a2 = a(stringBuilder.toString(), size);
                    break;
                }
                size2 = i3;
            }
            a2 = null;
            this.b = a2;
            return;
        }
        this.b = a(size, this.c);
    }
}
