package com.qiyukf.basesdk.c.b.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;

public final class c implements LeadingMarginSpan {
    private final String a;
    private final int b;

    public c(TextPaint textPaint, int i) {
        this.a = Integer.toString(i).concat(". ");
        this.b = (int) textPaint.measureText(this.a);
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if ((charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(this) == i6) {
            canvas.drawText(this.a, (float) i, (float) i4, paint);
        }
    }

    public final int getLeadingMargin(boolean z) {
        return this.b;
    }
}
