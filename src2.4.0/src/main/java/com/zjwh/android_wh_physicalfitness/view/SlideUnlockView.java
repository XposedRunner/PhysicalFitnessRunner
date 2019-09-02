package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

public class SlideUnlockView extends View {
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    private static final String O00000oo = "SlideUnlockView";
    public int O000000o;
    Handler O00000oO;
    private Bitmap O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private float O0000OoO;
    private float O0000Ooo;
    private O000000o O0000o0;
    private boolean O0000o00;

    public interface O000000o {
        void O000000o(float f);

        void O000000o(boolean z);
    }

    public SlideUnlockView(Context context) {
        this(context, null);
    }

    public SlideUnlockView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideUnlockView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oO = new Handler() {
            public void handleMessage(Message message) {
                if (message.what == 0) {
                    if (SlideUnlockView.this.O0000OoO > CropImageView.DEFAULT_ASPECT_RATIO) {
                        SlideUnlockView.this.O0000OoO = SlideUnlockView.this.O0000OoO - ((((float) SlideUnlockView.this.O0000OOo) * 1.0f) / 50.0f);
                        SlideUnlockView.this.postInvalidate();
                        SlideUnlockView.this.O00000oO.sendEmptyMessageDelayed(0, 10);
                    } else {
                        SlideUnlockView.this.O00000oO.removeCallbacksAndMessages(null);
                        SlideUnlockView.this.O000000o = 1;
                        Log.i(SlideUnlockView.O00000oo, "state---lock.....");
                    }
                    if (SlideUnlockView.this.O0000o0 != null) {
                        SlideUnlockView.this.O0000o0.O000000o(SlideUnlockView.this.O0000OoO);
                    }
                }
            }
        };
        this.O000000o = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlideUnlockView);
        setSlideUnlockBlock(obtainStyledAttributes.getResourceId(0, R.drawable.run_lock_icon));
        obtainStyledAttributes.recycle();
        postInvalidate();
    }

    public void O000000o() {
        this.O000000o = 1;
        postInvalidate();
    }

    public boolean O000000o(float f, float f2, float f3, float f4) {
        f -= f2;
        f3 -= f4;
        return Math.sqrt((double) ((Math.abs(f) * Math.abs(f)) + (Math.abs(f3) * Math.abs(f3)))) <= ((double) (this.O0000Oo0 / 2));
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = (float) ((getHeight() - this.O0000Oo) / 2);
        switch (this.O000000o) {
            case 1:
                canvas.drawBitmap(this.O0000O0o, CropImageView.DEFAULT_ASPECT_RATIO, height, null);
                return;
            case 2:
                canvas.drawBitmap(this.O0000O0o, (float) (this.O0000OOo - this.O0000Oo0), height, null);
                return;
            case 3:
                if (this.O0000OoO < CropImageView.DEFAULT_ASPECT_RATIO) {
                    this.O0000OoO = CropImageView.DEFAULT_ASPECT_RATIO;
                } else if (this.O0000OoO > ((float) (this.O0000OOo - this.O0000Oo0))) {
                    this.O0000OoO = (float) (this.O0000OOo - this.O0000Oo0);
                }
                canvas.drawBitmap(this.O0000O0o, this.O0000OoO, height, null);
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000OOo = getWidth();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.O000000o != 3) {
                    this.O0000OoO = motionEvent.getX();
                    this.O0000Ooo = motionEvent.getY();
                    this.O0000o00 = O000000o((((float) this.O0000Oo0) * 1.0f) / 2.0f, this.O0000OoO, (((float) this.O0000Oo) * 1.0f) / 2.0f, this.O0000Ooo);
                    Log.i(O00000oo, "down......................");
                    postInvalidate();
                    break;
                }
                break;
            case 1:
                if (this.O000000o == 3) {
                    if (this.O0000OoO < ((float) ((this.O0000OOo - this.O0000Oo0) / 2))) {
                        this.O00000oO.sendEmptyMessageDelayed(0, 10);
                        if (this.O0000o0 != null) {
                            this.O0000o0.O000000o(false);
                        }
                    } else {
                        this.O000000o = 2;
                        if (this.O0000o0 != null) {
                            this.O0000o0.O000000o(true);
                        }
                    }
                    this.O0000o00 = false;
                    postInvalidate();
                    break;
                }
                break;
            case 2:
                if (this.O0000o00) {
                    this.O0000OoO = motionEvent.getX();
                    this.O0000Ooo = motionEvent.getY();
                    this.O000000o = 3;
                    Log.i(O00000oo, "move......................");
                    if (this.O0000o0 != null) {
                        this.O0000o0.O000000o(this.O0000OoO);
                    }
                    postInvalidate();
                    break;
                }
                break;
        }
        return true;
    }

    public void setOnUnLockListener(O000000o o000000o) {
        this.O0000o0 = o000000o;
    }

    public void setSlideUnlockBlock(int i) {
        this.O0000O0o = BitmapFactory.decodeResource(getResources(), i);
        this.O0000Oo0 = this.O0000O0o.getWidth();
        this.O0000Oo = this.O0000O0o.getHeight();
    }
}
