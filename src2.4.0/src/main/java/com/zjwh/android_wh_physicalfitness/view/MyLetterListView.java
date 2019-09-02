package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zjwh.android_wh_physicalfitness.R;

public class MyLetterListView extends View {
    O000000o O000000o;
    String[] O00000Oo;
    Paint O00000o;
    int O00000o0;
    boolean O00000oO;

    public interface O000000o {
        void O000000o(String str);
    }

    public MyLetterListView(Context context) {
        super(context);
        this.O00000Oo = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.O00000o0 = -1;
        this.O00000o = new Paint();
        this.O00000oO = false;
        O000000o();
    }

    public MyLetterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000Oo = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.O00000o0 = -1;
        this.O00000o = new Paint();
        this.O00000oO = false;
        O000000o();
    }

    public MyLetterListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.O00000o0 = -1;
        this.O00000o = new Paint();
        this.O00000oO = false;
        O000000o();
    }

    private void O000000o() {
        this.O00000o.setColor(ContextCompat.getColor(getContext(), R.color.green));
        this.O00000o.setTypeface(Typeface.DEFAULT);
        this.O00000o.setTextSize((10.0f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        this.O00000o.setAntiAlias(true);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.O00000o0;
        O000000o o000000o = this.O000000o;
        int height = (int) ((y / ((float) getHeight())) * ((float) this.O00000Oo.length));
        switch (action) {
            case 0:
                this.O00000oO = true;
                if (i != height && o000000o != null && height > 0 && height < this.O00000Oo.length) {
                    o000000o.O000000o(this.O00000Oo[height]);
                    this.O00000o0 = height;
                    invalidate();
                    break;
                }
            case 1:
                this.O00000oO = false;
                this.O00000o0 = -1;
                invalidate();
                break;
            case 2:
                if (i != height && o000000o != null && height >= 0 && height < this.O00000Oo.length) {
                    o000000o.O000000o(this.O00000Oo[height]);
                    this.O00000o0 = height;
                    invalidate();
                    break;
                }
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O00000oO) {
            canvas.drawColor(Color.parseColor("#40000000"));
        }
        int height = getHeight();
        int width = getWidth();
        height /= this.O00000Oo.length;
        for (int i = 0; i < this.O00000Oo.length; i++) {
            canvas.drawText(this.O00000Oo[i], ((float) (width / 2)) - (this.O00000o.measureText(this.O00000Oo[i]) / 2.0f), (float) ((height * i) + height), this.O00000o);
            this.O00000o.setColor(ContextCompat.getColor(getContext(), R.color.green));
            if (i == this.O00000o0) {
                this.O00000o.setColor(Color.parseColor("#3399ff"));
                this.O00000o.setFakeBoldText(true);
            }
        }
    }

    public void setOnTouchingLetterChangedListener(O000000o o000000o) {
        this.O000000o = o000000o;
    }
}
