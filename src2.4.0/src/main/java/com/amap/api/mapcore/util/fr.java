package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/* compiled from: BlankView */
public class fr extends View {
    public static final int O000000o = Color.argb(255, 235, 235, 235);
    public static final int O00000Oo = Color.argb(255, 21, 21, 21);
    private Paint O00000o0 = new Paint();

    public fr(Context context) {
        super(context);
        this.O00000o0.setAntiAlias(true);
        this.O00000o0.setColor(O000000o);
    }

    public void O000000o(int i) {
        if (this.O00000o0 != null) {
            this.O00000o0.setColor(i);
        }
    }

    public void O000000o(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.O00000o0);
    }
}
