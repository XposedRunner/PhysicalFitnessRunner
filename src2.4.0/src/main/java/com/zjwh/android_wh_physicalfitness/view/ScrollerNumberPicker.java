package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import java.util.ArrayList;
import java.util.Iterator;

public class ScrollerNumberPicker extends View {
    private static final int O0000oo = 5;
    private static final int O0000oo0 = 1;
    Handler O000000o = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ScrollerNumberPicker.this.invalidate();
            }
        }
    };
    private float O00000Oo;
    private boolean O00000o = false;
    private float O00000o0;
    private ArrayList<O000000o> O00000oO = new ArrayList();
    private ArrayList<String> O00000oo = new ArrayList();
    private int O0000O0o;
    private long O0000OOo = 0;
    private int O0000Oo = 100;
    private long O0000Oo0 = 200;
    private Paint O0000OoO;
    private int O0000Ooo = -16777216;
    private int O0000o = -16777216;
    private float O0000o0 = 16.0f;
    private float O0000o00 = 12.0f;
    private int O0000o0O = 40;
    private int O0000o0o = 7;
    private float O0000oO = 48.0f;
    private int O0000oO0 = -65536;
    private O00000Oo O0000oOO;
    private boolean O0000oOo = true;
    private boolean O0000ooO = false;
    private boolean O0000ooo = false;

    private class O000000o {
        public int O000000o = 0;
        public String O00000Oo = "";
        public int O00000o = 0;
        public int O00000o0 = 0;
        public int O00000oO = 0;
        private Paint O0000O0o;
        private Rect O0000OOo;

        public void O000000o(int i) {
            this.O00000oO = i;
        }

        public void O000000o(Canvas canvas) {
            if (this.O0000O0o == null) {
                this.O0000O0o = new Paint();
                this.O0000O0o.setAntiAlias(true);
            }
            if (this.O0000OOo == null) {
                this.O0000OOo = new Rect();
            }
            if (O00000Oo()) {
                this.O0000O0o.setColor(ScrollerNumberPicker.this.O0000oO0);
                int i = (O00000o0() > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : (O00000o0() == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : -1));
                this.O0000O0o.setTextSize(ScrollerNumberPicker.this.O0000o00);
            } else {
                this.O0000O0o.setColor(ScrollerNumberPicker.this.O0000o);
                this.O0000O0o.setTextSize(ScrollerNumberPicker.this.O0000o00);
            }
            this.O0000O0o.getTextBounds(this.O00000Oo, 0, this.O00000Oo.length(), this.O0000OOo);
            if (O000000o()) {
                canvas.drawText(this.O00000Oo, (((float) this.O00000o0) + (ScrollerNumberPicker.this.O00000Oo / 2.0f)) - ((float) (this.O0000OOo.width() / 2)), (float) (((this.O00000o + this.O00000oO) + (ScrollerNumberPicker.this.O0000o0O / 2)) + (this.O0000OOo.height() / 2)), this.O0000O0o);
            }
        }

        public boolean O000000o() {
            return ((float) (this.O00000o + this.O00000oO)) <= ScrollerNumberPicker.this.O00000o0 && ((this.O00000o + this.O00000oO) + (ScrollerNumberPicker.this.O0000o0O / 2)) + (this.O0000OOo.height() / 2) >= 0;
        }

        public void O00000Oo(int i) {
            this.O00000oO = 0;
            this.O00000o += i;
        }

        public boolean O00000Oo() {
            boolean z = true;
            if (((float) (this.O00000o + this.O00000oO)) >= ((ScrollerNumberPicker.this.O00000o0 / 2.0f) - ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) + 2.0f && ((float) (this.O00000o + this.O00000oO)) <= ((ScrollerNumberPicker.this.O00000o0 / 2.0f) + ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) - 2.0f) {
                return true;
            }
            if (((float) ((this.O00000o + this.O00000oO) + ScrollerNumberPicker.this.O0000o0O)) >= ((ScrollerNumberPicker.this.O00000o0 / 2.0f) - ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) + 2.0f && ((float) ((this.O00000o + this.O00000oO) + ScrollerNumberPicker.this.O0000o0O)) <= ((ScrollerNumberPicker.this.O00000o0 / 2.0f) + ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) - 2.0f) {
                return true;
            }
            if (((float) (this.O00000o + this.O00000oO)) > ((ScrollerNumberPicker.this.O00000o0 / 2.0f) - ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) + 2.0f || ((float) ((this.O00000o + this.O00000oO) + ScrollerNumberPicker.this.O0000o0O)) < ((ScrollerNumberPicker.this.O00000o0 / 2.0f) + ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) - 2.0f) {
                z = false;
            }
            return z;
        }

        public float O00000o0() {
            return ((ScrollerNumberPicker.this.O00000o0 / 2.0f) - ((float) (ScrollerNumberPicker.this.O0000o0O / 2))) - ((float) (this.O00000o + this.O00000oO));
        }
    }

    public interface O00000Oo {
        void O000000o(int i, String str);

        void O00000Oo(int i, String str);
    }

    public ScrollerNumberPicker(Context context) {
        super(context);
        O000000o(context, null);
        O00000o();
    }

    public ScrollerNumberPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
        O00000o();
    }

    public ScrollerNumberPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
        O00000o();
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPicker);
        this.O0000o0O = (int) obtainStyledAttributes.getDimension(9, 32.0f);
        this.O0000o00 = obtainStyledAttributes.getDimension(6, 14.0f);
        this.O0000o0 = obtainStyledAttributes.getDimension(8, 22.0f);
        this.O0000o0o = obtainStyledAttributes.getInt(1, 7);
        this.O0000o = obtainStyledAttributes.getColor(5, -16777216);
        this.O0000oO0 = obtainStyledAttributes.getColor(7, -65536);
        this.O0000Ooo = obtainStyledAttributes.getColor(2, -16777216);
        this.O0000oO = obtainStyledAttributes.getDimension(3, 48.0f);
        this.O0000ooO = obtainStyledAttributes.getBoolean(4, false);
        this.O0000oOo = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        this.O00000o0 = (float) (this.O0000o0o * this.O0000o0O);
    }

    private synchronized void O000000o(Canvas canvas) {
        if (!this.O0000ooo) {
            try {
                Iterator it = this.O00000oO.iterator();
                while (it.hasNext()) {
                    ((O000000o) it.next()).O000000o(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
        return;
    }

    private synchronized void O00000Oo(final int i) {
        new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (i < ScrollerNumberPicker.this.O0000o0O * 5) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ScrollerNumberPicker.this.O00000o(i > 0 ? i : i * -1);
                    i += 10;
                }
                ScrollerNumberPicker.this.O00000oO(i > 0 ? i - 10 : (i * -1) + 10);
                ScrollerNumberPicker.this.O00000o0();
            }
        }).start();
    }

    private void O00000Oo(Canvas canvas) {
        if (this.O0000OoO == null) {
            this.O0000OoO = new Paint();
            this.O0000OoO.setColor(this.O0000Ooo);
            this.O0000OoO.setAntiAlias(true);
            this.O0000OoO.setStrokeWidth(1.0f);
        }
        canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, ((this.O00000o0 / 2.0f) - ((float) (this.O0000o0O / 2))) + 2.0f, this.O00000Oo, ((this.O00000o0 / 2.0f) - ((float) (this.O0000o0O / 2))) + 2.0f, this.O0000OoO);
        canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, ((this.O00000o0 / 2.0f) + ((float) (this.O0000o0O / 2))) - 2.0f, this.O00000Oo, ((this.O00000o0 / 2.0f) + ((float) (this.O0000o0O / 2))) - 2.0f, this.O0000OoO);
    }

    private void O00000o() {
        this.O0000ooo = true;
        this.O00000oO.clear();
        for (int i = 0; i < this.O00000oo.size(); i++) {
            O000000o o000000o = new O000000o();
            o000000o.O000000o = i;
            o000000o.O00000Oo = (String) this.O00000oo.get(i);
            o000000o.O00000o0 = 0;
            o000000o.O00000o = this.O0000o0O * i;
            this.O00000oO.add(o000000o);
        }
        this.O0000ooo = false;
    }

    private void O00000o(int i) {
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            ((O000000o) it.next()).O000000o(i);
        }
        Message message = new Message();
        message.what = 1;
        this.O000000o.sendMessage(message);
    }

    private void O00000o0() {
        try {
            if (this.O0000ooO) {
                Iterator it = this.O00000oO.iterator();
                while (it.hasNext()) {
                    if (((O000000o) it.next()).O00000Oo()) {
                        return;
                    }
                }
                int O00000o0 = (int) ((O000000o) this.O00000oO.get(0)).O00000o0();
                if (O00000o0 < 0) {
                    O0000O0o(O00000o0);
                } else {
                    O0000O0o((int) ((O000000o) this.O00000oO.get(this.O00000oO.size() - 1)).O00000o0());
                }
                it = this.O00000oO.iterator();
                while (it.hasNext()) {
                    O000000o o000000o = (O000000o) it.next();
                    if (o000000o.O00000Oo()) {
                        if (this.O0000oOO != null) {
                            this.O0000oOO.O000000o(o000000o.O000000o, o000000o.O00000Oo);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O00000o0(int i) {
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            ((O000000o) it.next()).O000000o(i);
        }
        invalidate();
    }

    private void O00000o0(Canvas canvas) {
        LinearGradient linearGradient = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.O0000oO, 15921906, 15921906, TileMode.MIRROR);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        Canvas canvas2 = canvas;
        canvas2.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.O00000Oo, this.O0000oO, paint);
        linearGradient = new LinearGradient(CropImageView.DEFAULT_ASPECT_RATIO, this.O00000o0 - this.O0000oO, CropImageView.DEFAULT_ASPECT_RATIO, this.O00000o0, 15921906, 15921906, TileMode.MIRROR);
        paint = new Paint();
        paint.setShader(linearGradient);
        canvas2.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, this.O00000o0 - this.O0000oO, this.O00000Oo, this.O00000o0, paint);
    }

    private void O00000oO() {
        if (this.O0000oOO != null) {
            Iterator it = this.O00000oO.iterator();
            while (it.hasNext()) {
                O000000o o000000o = (O000000o) it.next();
                if (o000000o.O00000Oo()) {
                    this.O0000oOO.O00000Oo(o000000o.O000000o, o000000o.O00000Oo);
                }
            }
        }
    }

    private void O00000oO(int i) {
        int i2 = 0;
        int i3;
        if (i > 0) {
            i3 = 0;
            while (i3 < this.O00000oO.size()) {
                if (((O000000o) this.O00000oO.get(i3)).O00000Oo()) {
                    i2 = (int) ((O000000o) this.O00000oO.get(i3)).O00000o0();
                    if (this.O0000oOO != null) {
                        this.O0000oOO.O000000o(((O000000o) this.O00000oO.get(i3)).O000000o, ((O000000o) this.O00000oO.get(i3)).O00000Oo);
                    }
                } else {
                    i3++;
                }
            }
        } else {
            i3 = this.O00000oO.size() - 1;
            while (i3 >= 0) {
                if (((O000000o) this.O00000oO.get(i3)).O00000Oo()) {
                    i2 = (int) ((O000000o) this.O00000oO.get(i3)).O00000o0();
                    if (this.O0000oOO != null) {
                        this.O0000oOO.O000000o(((O000000o) this.O00000oO.get(i3)).O000000o, ((O000000o) this.O00000oO.get(i3)).O00000Oo);
                    }
                } else {
                    i3--;
                }
            }
        }
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            ((O000000o) it.next()).O00000Oo(i);
        }
        O00000oo(i2);
        Message message = new Message();
        message.what = 1;
        this.O000000o.sendMessage(message);
    }

    private synchronized void O00000oo(final int i) {
        new Thread(new Runnable() {
            public void run() {
                Iterator it;
                int i = -1;
                int i2 = i > 0 ? i : i * -1;
                if (i > 0) {
                    i = 1;
                }
                while (true) {
                    i2--;
                    if (i2 <= 0) {
                        break;
                    }
                    it = ScrollerNumberPicker.this.O00000oO.iterator();
                    while (it.hasNext()) {
                        ((O000000o) it.next()).O00000Oo(1 * i);
                    }
                    Message message = new Message();
                    message.what = 1;
                    ScrollerNumberPicker.this.O000000o.sendMessage(message);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                it = ScrollerNumberPicker.this.O00000oO.iterator();
                while (it.hasNext()) {
                    ((O000000o) it.next()).O00000Oo(i2 * i);
                }
                Message message2 = new Message();
                message2.what = 1;
                ScrollerNumberPicker.this.O000000o.sendMessage(message2);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                Iterator it2 = ScrollerNumberPicker.this.O00000oO.iterator();
                while (it2.hasNext()) {
                    O000000o o000000o = (O000000o) it2.next();
                    if (o000000o.O00000Oo()) {
                        if (ScrollerNumberPicker.this.O0000oOO != null) {
                            ScrollerNumberPicker.this.O0000oOO.O000000o(o000000o.O000000o, o000000o.O00000Oo);
                            return;
                        }
                        return;
                    }
                }
            }
        }).start();
    }

    private void O0000O0o(int i) {
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            ((O000000o) it.next()).O00000Oo(i);
        }
        Message message = new Message();
        message.what = 1;
        this.O000000o.sendMessage(message);
    }

    public String O000000o(int i) {
        return this.O00000oO == null ? "" : ((O000000o) this.O00000oO.get(i)).O00000Oo;
    }

    public boolean O000000o() {
        return this.O00000o;
    }

    public boolean O00000Oo() {
        return this.O0000oOo;
    }

    public int getListSize() {
        return this.O00000oO == null ? 0 : this.O00000oO.size();
    }

    public int getSelected() {
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            O000000o o000000o = (O000000o) it.next();
            if (o000000o.O00000Oo()) {
                return o000000o.O000000o;
            }
        }
        return -1;
    }

    public String getSelectedText() {
        Iterator it = this.O00000oO.iterator();
        while (it.hasNext()) {
            O000000o o000000o = (O000000o) it.next();
            if (o000000o.O00000Oo()) {
                return o000000o.O00000Oo;
            }
        }
        return "";
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        O00000Oo(canvas);
        O000000o(canvas);
        O00000o0(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.O00000Oo == CropImageView.DEFAULT_ASPECT_RATIO) {
            this.O00000Oo = (float) getWidth();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.O00000Oo = (float) getWidth();
        if (this.O00000Oo != CropImageView.DEFAULT_ASPECT_RATIO) {
            setMeasuredDimension(getWidth(), this.O0000o0o * this.O0000o0O);
            this.O00000Oo = (float) getWidth();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.O0000oOo) {
            return true;
        }
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.O00000o = true;
                this.O0000O0o = (int) motionEvent.getY();
                this.O0000OOo = System.currentTimeMillis();
                break;
            case 1:
                int i = y - this.O0000O0o;
                if (i <= 0) {
                    i *= -1;
                }
                if (System.currentTimeMillis() - this.O0000OOo >= this.O0000Oo0 || i <= this.O0000Oo) {
                    O00000oO(y - this.O0000O0o);
                } else {
                    O00000Oo(y - this.O0000O0o);
                }
                O00000o0();
                this.O00000o = false;
                break;
            case 2:
                O00000o0(y - this.O0000O0o);
                O00000oO();
                break;
        }
        return true;
    }

    public void setData(ArrayList<String> arrayList) {
        if (!arrayList.isEmpty()) {
            this.O00000oo = arrayList;
            O00000o();
        }
    }

    public void setDefault(int i) {
        O0000O0o((int) ((O000000o) this.O00000oO.get(i)).O00000o0());
    }

    public void setEnable(boolean z) {
        this.O0000oOo = z;
    }

    public void setOnSelectListener(O00000Oo o00000Oo) {
        this.O0000oOO = o00000Oo;
    }
}
