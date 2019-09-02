package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

public class RunOperateButton extends View {
    public static final int O000000o = 1;
    public static final int O00000Oo = 0;
    public static final int O00000o = 0;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 1;
    public static final int O00000oo = 2;
    private static final int O0000OOo = 1;
    private static final int O0000Oo0 = 2;
    Path O0000O0o = new Path();
    private float O0000Oo;
    private float O0000OoO;
    private float O0000Ooo;
    private float O0000o;
    private float O0000o0;
    private float O0000o00;
    private String O0000o0O = "";
    private float O0000o0o = 100.0f;
    private int O0000oO;
    private int O0000oO0;
    private float O0000oOO = 10.0f;
    private float O0000oOo;
    private int O0000oo;
    private float O0000oo0;
    private int O0000ooO;
    private int O0000ooo;
    private int O000O00o = 0;
    private RectF O000O0OO;
    private int O000O0Oo = 2;
    private Paint O000O0o;
    private Paint O000O0o0;
    private Paint O000O0oO;
    private Paint O000O0oo;
    private O000000o O000OO;
    private RectF O000OO00;
    private RectF O000OO0o;
    private O00000Oo O000OOOo;
    private Runnable O000OOo = new Runnable() {
        public void run() {
            RunOperateButton.this.O000O0Oo = 1;
            RunOperateButton.this.O0000Ooo = 1.0f + RunOperateButton.this.O0000Ooo;
            RunOperateButton.this.O0000o00 = RunOperateButton.this.O0000o00 - 1.0f;
            if (RunOperateButton.this.O0000Ooo - RunOperateButton.this.O0000o00 < RunOperateButton.this.O0000oOo * 2.0f) {
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000OOo, 15);
            } else {
                RunOperateButton.this.O000O0Oo = 2;
                RunOperateButton.this.O000OOo0.removeCallbacks(RunOperateButton.this.O000OOo);
            }
            RunOperateButton.this.postInvalidate();
        }
    };
    private Handler O000OOo0;
    private Runnable O000OOoO = new Runnable() {
        public void run() {
            RunOperateButton.this.O000O0Oo = 1;
            RunOperateButton.this.O0000Ooo = 1.0f + RunOperateButton.this.O0000Ooo;
            RunOperateButton.this.O0000o00 = RunOperateButton.this.O0000o00 - 1.0f;
            if (RunOperateButton.this.O0000Ooo - RunOperateButton.this.O0000o00 < (RunOperateButton.this.O0000oOo * 2.0f) + RunOperateButton.this.O0000oOO) {
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000OOoO, 8);
            } else {
                RunOperateButton.this.O000OOo0.removeCallbacks(RunOperateButton.this.O000OOoO);
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000Oo00, 8);
            }
            RunOperateButton.this.postInvalidate();
        }
    };
    private Runnable O000OOoo = new Runnable() {
        public void run() {
            RunOperateButton.this.O000O0Oo = 1;
            RunOperateButton.this.O0000Ooo = RunOperateButton.this.O0000Ooo - 1.0f;
            RunOperateButton.this.O0000o00 = 1.0f + RunOperateButton.this.O0000o00;
            if (RunOperateButton.this.O0000Ooo - RunOperateButton.this.O0000o00 > RunOperateButton.this.O0000oOo) {
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000OOoo, 15);
            } else {
                RunOperateButton.this.O000OOo0.removeCallbacks(RunOperateButton.this.O000OOoo);
                RunOperateButton.this.O000O0Oo = 2;
            }
            RunOperateButton.this.postInvalidate();
        }
    };
    private Runnable O000Oo0 = new Runnable() {
        public void run() {
            RunOperateButton.this.O000O0Oo = 1;
            if (RunOperateButton.this.O00oOooo == 0 && RunOperateButton.this.O0000o0 - RunOperateButton.this.O0000Ooo < RunOperateButton.this.O0000oOo) {
                RunOperateButton.this.O0000o0 = 1.0f + RunOperateButton.this.O0000o0;
                RunOperateButton.this.O0000Ooo = RunOperateButton.this.O0000Ooo - 1.0f;
                RunOperateButton.this.O0000o00 = RunOperateButton.this.O0000o00 - 1.0f;
                float O0000oO0 = RunOperateButton.this.O0000Oo - RunOperateButton.this.O0000o0;
                float O0000oO = RunOperateButton.this.O0000OoO - RunOperateButton.this.O0000o0;
                RunOperateButton.this.O000O0OO.set(O0000oO0, O0000oO, ((float) RunOperateButton.this.O0000oO0) - O0000oO0, ((float) RunOperateButton.this.O0000oO) - O0000oO);
            }
            if (RunOperateButton.this.O000OOOo != null) {
                RunOperateButton.this.O000OOOo.O000000o(RunOperateButton.this, RunOperateButton.this.O0000o);
            }
            if (RunOperateButton.this.O0000o < RunOperateButton.this.O0000o0o) {
                RunOperateButton.this.O0000o = 1.0f + RunOperateButton.this.O0000o;
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000Oo0, 15);
            } else {
                RunOperateButton.this.O000O0Oo = 2;
            }
            RunOperateButton.this.postInvalidate();
        }
    };
    private Runnable O000Oo00 = new Runnable() {
        public void run() {
            RunOperateButton.this.O000O0Oo = 1;
            RunOperateButton.this.O0000Ooo = RunOperateButton.this.O0000Ooo - 1.0f;
            RunOperateButton.this.O0000o00 = 1.0f + RunOperateButton.this.O0000o00;
            if (RunOperateButton.this.O0000Ooo - RunOperateButton.this.O0000o00 > RunOperateButton.this.O0000oOo) {
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000Oo00, 8);
            } else {
                RunOperateButton.this.O000OOo0.removeCallbacks(RunOperateButton.this.O000Oo00);
                RunOperateButton.this.O000O0Oo = 2;
                if (RunOperateButton.this.O000OO != null) {
                    RunOperateButton.this.O000OO.O000000o(RunOperateButton.this);
                }
            }
            RunOperateButton.this.postInvalidate();
        }
    };
    private Runnable O000Oo0O = new Runnable() {
        public void run() {
            RunOperateButton.this.O000O0Oo = 1;
            if (RunOperateButton.this.O0000o < RunOperateButton.this.O0000o0o) {
                RunOperateButton.this.O0000o = RunOperateButton.this.O0000o - 1.0f;
            }
            if (RunOperateButton.this.O0000o0 - RunOperateButton.this.O0000Ooo > CropImageView.DEFAULT_ASPECT_RATIO) {
                RunOperateButton.this.O0000o0 = RunOperateButton.this.O0000o0 - 1.0f;
                RunOperateButton.this.O0000Ooo = 1.0f + RunOperateButton.this.O0000Ooo;
                RunOperateButton.this.O0000o00 = 1.0f + RunOperateButton.this.O0000o00;
                float O0000oO0 = RunOperateButton.this.O0000Oo - RunOperateButton.this.O0000o0;
                float O0000oO = RunOperateButton.this.O0000OoO - RunOperateButton.this.O0000o0;
                RunOperateButton.this.O000O0OO.set(O0000oO0, O0000oO, ((float) RunOperateButton.this.O0000oO0) - O0000oO0, ((float) RunOperateButton.this.O0000oO) - O0000oO);
                RunOperateButton.this.O000OOo0.postDelayed(RunOperateButton.this.O000Oo0O, 15);
                RunOperateButton.this.postInvalidate();
                return;
            }
            RunOperateButton.this.O00000Oo();
        }
    };
    private Paint O00oOoOo;
    private int O00oOooO;
    private int O00oOooo = 1;

    public interface O000000o {
        void O000000o(View view);
    }

    public interface O00000Oo {
        void O000000o(RunOperateButton runOperateButton, float f);
    }

    public RunOperateButton(Context context) {
        super(context);
        O000000o(null);
    }

    public RunOperateButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public RunOperateButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int O000000o(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        return mode == 1073741824 ? i2 : mode == Integer.MIN_VALUE ? Math.min(i, i2) : i;
    }

    private void O000000o() {
        this.O00oOoOo = new Paint();
        this.O00oOoOo.setAntiAlias(true);
        this.O00oOoOo.setStyle(Style.FILL);
        this.O00oOoOo.setColor(this.O0000ooO);
        this.O000O0o0 = new Paint();
        this.O000O0o0.setAntiAlias(true);
        this.O000O0o0.setStrokeWidth((float) O000000o(1.0f));
        this.O000O0o0.setStyle(Style.STROKE);
        this.O000O0o0.setColor(this.O0000ooo);
        this.O000O0o = new Paint();
        this.O000O0o.setAntiAlias(true);
        this.O000O0o.setStyle(Style.FILL);
        this.O000O0o.setColor(this.O00oOooO);
        this.O000O0oO = new Paint();
        this.O000O0oO.setAntiAlias(true);
        this.O000O0oO.setStyle(Style.FILL);
        this.O000O0oO.setColor(this.O0000oo);
        this.O000O0oO.setTextSize(this.O0000oo0);
        this.O000O0oo = new Paint();
        this.O000O0oo.setAntiAlias(true);
        this.O000O0oo.setStyle(Style.FILL);
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RunOperateButton);
            this.O0000oOO = obtainStyledAttributes.getDimension(0, (float) O000000o(5.0f));
            this.O0000oOo = obtainStyledAttributes.getDimension(10, (float) O000000o(5.0f));
            this.O0000o0O = obtainStyledAttributes.getString(7);
            this.O0000oo0 = obtainStyledAttributes.getDimension(9, (float) O000000o(16.0f));
            this.O0000oo = obtainStyledAttributes.getColor(8, -1);
            this.O0000ooO = obtainStyledAttributes.getColor(1, -16776961);
            this.O0000ooo = obtainStyledAttributes.getColor(5, -16777216);
            this.O00oOooO = obtainStyledAttributes.getColor(2, -1);
            this.O00oOooo = obtainStyledAttributes.getInt(6, 1);
            this.O000O00o = obtainStyledAttributes.getInt(4, 0);
            this.O0000o0o = (float) obtainStyledAttributes.getInt(3, 60);
            obtainStyledAttributes.recycle();
        } else {
            this.O0000oOO = (float) O000000o(5.0f);
            this.O0000oOo = (float) O000000o(5.0f);
            this.O0000oo0 = (float) O000000o(16.0f);
            this.O0000oo = -1;
            this.O0000ooO = -16776961;
            this.O0000ooo = -16777216;
            this.O0000o0o = 60.0f;
        }
        this.O000OOo0 = new Handler();
        this.O000O0OO = new RectF();
        O000000o();
    }

    private boolean O000000o(MotionEvent motionEvent) {
        return CropImageView.DEFAULT_ASPECT_RATIO <= motionEvent.getX() && ((float) (getRight() - getLeft())) >= motionEvent.getX() && CropImageView.DEFAULT_ASPECT_RATIO <= motionEvent.getY() && ((float) (getBottom() - getTop())) >= motionEvent.getY();
    }

    private void O00000Oo() {
        this.O000O0Oo = 2;
        this.O0000Oo = ((float) this.O0000oO0) / 2.0f;
        this.O0000OoO = ((float) this.O0000oO) / 2.0f;
        float f;
        float f2;
        if (this.O00oOooo == 0) {
            this.O0000o = CropImageView.DEFAULT_ASPECT_RATIO;
            f = this.O0000Oo - this.O0000oOO;
            this.O0000Ooo = f;
            this.O0000o00 = f;
            this.O0000o0 = f;
            f = this.O0000Oo - this.O0000o0;
            f2 = this.O0000OoO - this.O0000o0;
            this.O000O0OO.set(f, f2, ((float) this.O0000oO0) - f, ((float) this.O0000oO) - f2);
            if (!(this.O000OOo0 == null || this.O000Oo0 == null)) {
                this.O000OOo0.removeCallbacks(this.O000Oo0);
            }
        } else if (this.O00oOooo == 2) {
            this.O0000o = CropImageView.DEFAULT_ASPECT_RATIO;
            this.O0000o0 = this.O0000Oo - this.O0000oOO;
            f = this.O0000o0 - this.O0000oOo;
            this.O0000o00 = f;
            this.O0000Ooo = f;
            f = this.O0000Oo - this.O0000o0;
            f2 = this.O0000OoO - this.O0000o0;
            this.O000O0OO.set(f, f2, ((float) this.O0000oO0) - f, ((float) this.O0000oO) - f2);
            if (!(this.O000OOo0 == null || this.O000Oo0 == null)) {
                this.O000OOo0.removeCallbacks(this.O000Oo0);
            }
        } else {
            this.O0000Ooo = this.O0000Oo - this.O0000oOO;
            this.O0000o00 = this.O0000Ooo - this.O0000oOo;
            if (this.O000OOo0 != null) {
                if (this.O000OOo != null) {
                    this.O000OOo0.removeCallbacks(this.O000OOo);
                }
                if (this.O000OOoO != null) {
                    this.O000OOo0.removeCallbacks(this.O000OOoO);
                }
                if (this.O000OOoo != null) {
                    this.O000OOo0.removeCallbacks(this.O000OOoo);
                }
                if (this.O000Oo00 != null) {
                    this.O000OOo0.removeCallbacks(this.O000Oo00);
                }
                this.O000OOo0.removeCallbacksAndMessages(null);
            }
        }
        postInvalidate();
    }

    public void draw(Canvas canvas) {
        float f;
        super.draw(canvas);
        if (this.O00oOooo == 0 || this.O00oOooo == 2) {
            f = this.O0000o / this.O0000o0o;
            canvas.drawCircle(this.O0000Oo, this.O0000OoO, this.O0000o0, this.O000O0o);
            canvas.drawArc(this.O000O0OO, -90.0f, f * 360.0f, true, this.O00oOoOo);
        }
        canvas.drawCircle(this.O0000Oo, this.O0000OoO, this.O0000Ooo, this.O00oOoOo);
        canvas.drawCircle(this.O0000Oo, this.O0000OoO, this.O0000o00, this.O000O0o0);
        switch (this.O000O00o) {
            case 1:
                f = (float) O000000o(5.5f);
                canvas.drawRoundRect(this.O000OO00, f, f, this.O000O0oo);
                canvas.drawRoundRect(this.O000OO0o, f, f, this.O000O0oo);
                return;
            case 2:
                canvas.drawPath(this.O0000O0o, this.O000O0oo);
                return;
            default:
                if (!TextUtils.isEmpty(this.O0000o0O)) {
                    FontMetrics fontMetrics = this.O000O0oO.getFontMetrics();
                    canvas.drawText(this.O0000o0O, this.O0000Oo - (this.O000O0oO.measureText(this.O0000o0O) / 2.0f), (((float) this.O0000oO) - ((((float) this.O0000oO) - (fontMetrics.bottom - fontMetrics.top)) / 2.0f)) - fontMetrics.bottom, this.O000O0oO);
                    return;
                }
                return;
        }
    }

    public int getBackgroundColor() {
        return this.O0000ooO;
    }

    public int getEmptyColor() {
        return this.O00oOooO;
    }

    public float getMaxCount() {
        return this.O0000o0o;
    }

    public int getStrokeColor() {
        return this.O0000ooo;
    }

    public String getText() {
        return this.O0000o0O;
    }

    public int getTextColor() {
        return this.O0000oo;
    }

    public float getTextSize() {
        return this.O0000oo0;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O0000oO0 = getWidth();
        this.O0000oO = getHeight();
        O00000Oo();
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        this.O0000oO0 = O000000o(O000000o(80.0f), i);
        this.O0000oO = O000000o(O000000o(80.0f), i2);
        setMeasuredDimension(this.O0000oO0, this.O0000oO);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.O000O00o == 1) {
            float O000000o = (((float) this.O0000oO0) / 2.0f) - ((float) O000000o(10.0f));
            float O000000o2 = (((float) this.O0000oO) / 2.0f) - ((float) O000000o(12.0f));
            float O000000o3 = (((float) this.O0000oO0) / 2.0f) + ((float) O000000o(10.0f));
            float O000000o4 = (((float) this.O0000oO) / 2.0f) + ((float) O000000o(12.0f));
            this.O000OO00 = new RectF(O000000o, O000000o2, ((float) O000000o(7.0f)) + O000000o, O000000o4);
            this.O000OO0o = new RectF(O000000o3 - ((float) O000000o(7.0f)), O000000o2, O000000o3, O000000o4);
            this.O000O0oo.setShader(new LinearGradient(this.O0000Oo, O000000o2, this.O0000Oo, O000000o4, new int[]{-11414561, -10176260}, null, TileMode.MIRROR));
        } else if (this.O000O00o == 2) {
            float O000000o5 = (((float) this.O0000oO0) / 2.0f) - ((float) O000000o(6.0f));
            float O000000o6 = (((float) this.O0000oO0) / 2.0f) + ((float) O000000o(12.0f));
            float O000000o7 = (((float) this.O0000oO) / 2.0f) - ((float) O000000o(9.0f));
            this.O0000O0o.moveTo(O000000o5, (((float) this.O0000oO) / 2.0f) + ((float) O000000o(9.0f)));
            this.O0000O0o.lineTo(O000000o5, O000000o7);
            this.O0000O0o.lineTo(O000000o6, ((float) this.O0000oO) / 2.0f);
            this.O0000O0o.close();
            this.O000O0oo.setShader(new LinearGradient(O000000o5, this.O0000OoO, O000000o6, this.O0000OoO, new int[]{-11414561, -10176260}, null, TileMode.MIRROR));
            this.O000O0oo.setStyle(Style.FILL_AND_STROKE);
            this.O000O0oo.setStrokeJoin(Join.ROUND);
            this.O000O0oo.setStrokeCap(Cap.ROUND);
            this.O000O0oo.setStrokeWidth((float) O000000o(4.0f));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    if (this.O000O0Oo != 1) {
                        this.O000OOo0.post(this.O00oOooo == 1 ? this.O000OOo : this.O000Oo0);
                        break;
                    }
                    return false;
                case 1:
                    break;
            }
        }
        if (this.O00oOooo == 0) {
            if (this.O000Oo0 != null) {
                this.O000OOo0.removeCallbacks(this.O000Oo0);
            }
            this.O000OOo0.post(this.O000Oo0O);
        } else if (this.O00oOooo == 2) {
            O00000Oo();
        } else {
            if (this.O000OOo != null) {
                this.O000OOo0.removeCallbacks(this.O000OOo);
            }
            float f = this.O0000Ooo - this.O0000o00;
            if (O000000o(motionEvent)) {
                this.O000OOo0.post(this.O000OOoO);
            } else if (f == 25.0f) {
                this.O000OOo0.post(this.O000OOoo);
            } else {
                this.O000OOo0.postDelayed(this.O000OOoo, (long) ((15.0f * (25.0f - f)) / 2.0f));
            }
        }
        return true;
    }

    public void setBackgroundColor(int i) {
        this.O0000ooO = i;
    }

    public void setEmptyColor(int i) {
        this.O00oOooO = i;
    }

    public void setMaxCount(float f) {
        this.O0000o0o = f;
    }

    public void setOnOperateClickListener(O000000o o000000o) {
        this.O000OO = o000000o;
    }

    public void setOnOperateProgressListener(O00000Oo o00000Oo) {
        this.O000OOOo = o00000Oo;
    }

    public void setStrokeColor(int i) {
        this.O0000ooo = i;
    }

    public void setText(String str) {
        this.O0000o0O = str;
    }

    public void setTextColor(int i) {
        this.O0000oo = i;
    }

    public void setTextSize(float f) {
        this.O0000oo0 = f;
    }
}
