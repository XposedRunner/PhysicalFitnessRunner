package com.ximalaya.ting.android.opensdk.auth.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LoadingBar extends TextView {
    private static final int a = 100;
    private static final int b = -498622;
    private int c;
    private int d;
    private Paint e;
    private Handler f;
    private Runnable g = new Runnable() {
        public final void run() {
            LoadingBar.this.c = LoadingBar.this.c + 1;
            LoadingBar.this.a(LoadingBar.this.c);
        }
    };

    public LoadingBar(Context context) {
        super(context);
        a();
    }

    public LoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public LoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f = new Handler();
        this.e = new Paint();
        this.d = -498622;
    }

    private void b() {
        this.d = -498622;
    }

    private Rect getRect() {
        return new Rect(0, 0, (getLeft() + (((getRight() - getLeft()) * this.c) / 100)) - getLeft(), getBottom() - getTop());
    }

    public final void a(int i) {
        if (i < 7) {
            this.f.postDelayed(this.g, 70);
        } else {
            this.f.removeCallbacks(this.g);
            this.c = i;
        }
        invalidate();
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e.setColor(this.d);
        canvas.drawRect(getRect(), this.e);
    }
}
