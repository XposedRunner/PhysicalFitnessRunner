package com.qiyukf.basesdk.c.b.a;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.qiyukf.basesdk.c.b.e;
import java.util.List;

public final class a extends ClickableSpan {
    private e a;
    private Context b;
    private List<String> c;
    private int d;

    public a(Context context, List<String> list, int i) {
        this.b = context;
        this.c = list;
        this.d = i;
    }

    public final void a(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        if (this.a != null) {
            this.a.a(this.b, this.c, this.d);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
