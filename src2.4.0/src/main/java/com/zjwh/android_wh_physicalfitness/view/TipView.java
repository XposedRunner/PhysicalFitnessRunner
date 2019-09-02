package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import defpackage.kz;
import java.util.ArrayList;
import java.util.List;

public class TipView extends View {
    private static final int O000000o = 1;
    private static final int O00000Oo = 2;
    private int O00000o;
    private int O00000o0 = 2;
    private int O00000oO = O000000o(6.0f);
    private Paint O00000oo;
    private Paint O0000O0o;
    private Path O0000OOo;
    private int O0000Oo = O000000o(55.0f);
    private int O0000Oo0 = O000000o(5.0f);
    private int O0000OoO = O000000o(38.0f);
    private int O0000Ooo = O000000o(40.0f);
    private List<Rect> O0000o = new ArrayList();
    private int O0000o0;
    private int O0000o00 = O000000o(6.0f);
    private int O0000o0O;
    private List<O0000O0o> O0000o0o = new ArrayList();
    private int O0000oO = -1;
    private O00000Oo O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private int O0000oo0;

    public static class O000000o {
        private O00000Oo O000000o;
        private Context O00000Oo;
        private List<O0000O0o> O00000o = new ArrayList();
        private ViewGroup O00000o0;
        private int O00000oO = -1;
        private int O00000oo;
        private int O0000O0o;
        private int O0000OOo;

        public O000000o(Context context, ViewGroup viewGroup, int i, int i2, int i3) {
            this.O00000Oo = context;
            this.O00000o0 = viewGroup;
            this.O00000oo = i;
            this.O0000O0o = i2;
            this.O0000OOo = i3;
        }

        public O000000o O000000o(int i) {
            this.O00000oO = i;
            return this;
        }

        public O000000o O000000o(O0000O0o o0000O0o) {
            this.O00000o.add(o0000O0o);
            return this;
        }

        public O000000o O000000o(O00000Oo o00000Oo) {
            this.O000000o = o00000Oo;
            return this;
        }

        public O000000o O000000o(List<O0000O0o> list) {
            this.O00000o.addAll(list);
            return this;
        }

        public TipView O000000o() {
            TipView tipView = new TipView(this.O00000Oo, this.O00000o0, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O00000o);
            tipView.setOnItemClickListener(this.O000000o);
            tipView.setSeparateLineColor(this.O00000oO);
            return tipView;
        }
    }

    public interface O00000Oo {
        void O000000o();

        void O000000o(String str, int i);
    }

    public TipView(Context context, ViewGroup viewGroup, int i, int i2, int i3, List<O0000O0o> list) {
        super(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TipView() called with: x = [");
        stringBuilder.append(i);
        stringBuilder.append("], y = [");
        stringBuilder.append(i2);
        stringBuilder.append("]");
        kz.O000000o("TAG", stringBuilder.toString());
        this.O0000oOO = i;
        this.O0000oOo = i2;
        this.O0000oo0 = i3;
        O00000Oo();
        setTipItemList(list);
        O000000o(viewGroup);
        O00000o0();
    }

    private float O000000o(Paint paint) {
        FontMetrics fontMetrics = paint.getFontMetrics();
        return (fontMetrics.bottom - fontMetrics.descent) - fontMetrics.ascent;
    }

    private float O000000o(String str, Paint paint) {
        return paint.measureText(str);
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private String O000000o(String str) {
        int length = str.length();
        String str2 = "";
        while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.substring(0, length));
            stringBuilder.append("...");
            if (O000000o(stringBuilder.toString(), this.O00000oo) > ((float) (this.O0000Oo - O000000o(10.0f)))) {
                length--;
                str2 = "...";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str.substring(0, length));
                stringBuilder.append(str2);
                return stringBuilder.toString();
            }
        }
    }

    private void O000000o(Canvas canvas) {
        this.O0000o.clear();
        this.O0000OOo.reset();
        if (this.O0000oO != -1) {
            this.O0000O0o.setColor(-12303292);
        } else {
            this.O0000O0o.setColor(-16777216);
        }
        this.O0000OOo.moveTo((float) this.O0000oOO, (float) this.O0000Ooo);
        this.O0000OOo.lineTo((float) (this.O0000oOO - this.O0000o00), (float) this.O0000o0);
        this.O0000OOo.lineTo((float) (this.O0000oOO + this.O0000o00), (float) this.O0000o0);
        canvas.drawPath(this.O0000OOo, this.O0000O0o);
        if (this.O0000o0o.size() == 1) {
            this.O0000OOo.reset();
            this.O0000OOo.moveTo((float) ((this.O0000o0O + this.O0000Oo) - this.O00000oO), (float) this.O0000o0);
            this.O0000OOo.lineTo((float) (this.O0000o0O + this.O00000oO), (float) this.O0000o0);
            this.O0000OOo.quadTo((float) this.O0000o0O, (float) this.O0000o0, (float) this.O0000o0O, (float) (this.O0000o0 + this.O00000oO));
            this.O0000OOo.lineTo((float) this.O0000o0O, (float) ((this.O0000o0 + this.O0000OoO) - this.O00000oO));
            this.O0000OOo.quadTo((float) this.O0000o0O, (float) (this.O0000o0 + this.O0000OoO), (float) (this.O0000o0O + this.O00000oO), (float) (this.O0000o0 + this.O0000OoO));
            this.O0000OOo.lineTo((float) ((this.O0000o0O + this.O0000Oo) - this.O00000oO), (float) (this.O0000o0 + this.O0000OoO));
            this.O0000OOo.quadTo((float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 + this.O0000OoO), (float) (this.O0000o0O + this.O0000Oo), (float) ((this.O0000o0 + this.O0000OoO) - this.O00000oO));
            this.O0000OOo.lineTo((float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 + this.O00000oO));
            this.O0000OOo.quadTo((float) (this.O0000o0O + this.O0000Oo), (float) this.O0000o0, (float) ((this.O0000o0O + this.O0000Oo) - this.O00000oO), (float) this.O0000o0);
            canvas.drawPath(this.O0000OOo, this.O00000oo);
            this.O0000o.add(new Rect(this.O0000o0O - ((this.O0000o0o.size() - 1) * this.O0000Oo), this.O0000o0, (this.O0000o0O - ((this.O0000o0o.size() - 1) * this.O0000Oo)) + this.O0000Oo, this.O0000o0 + this.O0000OoO));
        } else {
            int i = 0;
            while (i < this.O0000o0o.size()) {
                if (this.O0000oO == i) {
                    this.O00000oo.setColor(-12303292);
                } else {
                    this.O00000oo.setColor(-16777216);
                }
                if (i == 0) {
                    this.O0000OOo.reset();
                    this.O0000OOo.moveTo((float) (this.O0000o0O + this.O0000Oo), (float) this.O0000o0);
                    this.O0000OOo.lineTo((float) (this.O0000o0O + this.O00000oO), (float) this.O0000o0);
                    this.O0000OOo.quadTo((float) this.O0000o0O, (float) this.O0000o0, (float) this.O0000o0O, (float) (this.O0000o0 + this.O00000oO));
                    this.O0000OOo.lineTo((float) this.O0000o0O, (float) ((this.O0000o0 + this.O0000OoO) - this.O00000oO));
                    this.O0000OOo.quadTo((float) this.O0000o0O, (float) (this.O0000o0 + this.O0000OoO), (float) (this.O0000o0O + this.O00000oO), (float) (this.O0000o0 + this.O0000OoO));
                    this.O0000OOo.lineTo((float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 + this.O0000OoO));
                    canvas.drawPath(this.O0000OOo, this.O00000oo);
                    this.O00000oo.setColor(this.O00000o);
                    canvas.drawLine((float) (this.O0000o0O + this.O0000Oo), (float) this.O0000o0, (float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 + this.O0000OoO), this.O00000oo);
                } else if (i == this.O0000o0o.size() - 1) {
                    this.O0000OOo.reset();
                    this.O0000OOo.moveTo((float) (this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))), (float) this.O0000o0);
                    this.O0000OOo.lineTo((float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo) - this.O00000oO), (float) this.O0000o0);
                    this.O0000OOo.quadTo((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) this.O0000o0, (float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) (this.O0000o0 + this.O00000oO));
                    this.O0000OOo.lineTo((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) ((this.O0000o0 + this.O0000OoO) - this.O00000oO));
                    this.O0000OOo.quadTo((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) (this.O0000o0 + this.O0000OoO), (float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo) - this.O00000oO), (float) (this.O0000o0 + this.O0000OoO));
                    this.O0000OOo.lineTo((float) (this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))), (float) (this.O0000o0 + this.O0000OoO));
                    canvas.drawPath(this.O0000OOo, this.O00000oo);
                } else {
                    int i2 = i + 1;
                    canvas.drawRect((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)), (float) this.O0000o0, (float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)) + this.O0000Oo), (float) (this.O0000o0 + this.O0000OoO), this.O00000oo);
                    this.O00000oo.setColor(this.O00000o);
                    canvas.drawLine((float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)) + this.O0000Oo), (float) this.O0000o0, (float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)) + this.O0000Oo), (float) (this.O0000o0 + this.O0000OoO), this.O00000oo);
                }
                i++;
                this.O0000o.add(new Rect((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i) * this.O0000Oo), this.O0000o0, ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i) * this.O0000Oo)) + this.O0000Oo, this.O0000o0 + this.O0000OoO));
            }
        }
        O00000o0(canvas);
    }

    private void O000000o(ViewGroup viewGroup) {
        viewGroup.addView(this, new LayoutParams(-1, -1));
    }

    private boolean O000000o(PointF pointF, Rect rect) {
        return pointF.x >= ((float) rect.left) && pointF.x <= ((float) rect.right) && pointF.y >= ((float) rect.top) && pointF.y <= ((float) rect.bottom);
    }

    private int O00000Oo(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void O00000Oo() {
        this.O0000OOo = new Path();
        this.O00000oo = new Paint();
        this.O00000oo.setAntiAlias(true);
        this.O00000oo.setStyle(Style.FILL);
        this.O00000oo.setTextSize((float) O00000Oo(14.0f));
        this.O0000O0o = new Paint();
        this.O0000O0o.setAntiAlias(true);
        this.O0000O0o.setStyle(Style.FILL);
        this.O0000O0o.setColor(-12303292);
    }

    private void O00000Oo(Canvas canvas) {
        this.O0000o.clear();
        this.O0000OOo.reset();
        if (this.O0000oO != -1) {
            this.O0000O0o.setColor(-12303292);
        } else {
            this.O0000O0o.setColor(-16777216);
        }
        this.O0000OOo.moveTo((float) this.O0000oOO, (float) this.O0000Ooo);
        this.O0000OOo.lineTo((float) (this.O0000oOO - this.O0000o00), (float) this.O0000o0);
        this.O0000OOo.lineTo((float) (this.O0000oOO + this.O0000o00), (float) this.O0000o0);
        canvas.drawPath(this.O0000OOo, this.O0000O0o);
        if (this.O0000o0o.size() == 1) {
            this.O0000OOo.reset();
            this.O0000OOo.moveTo((float) ((this.O0000o0O + this.O0000Oo) - this.O00000oO), (float) (this.O0000o0 - this.O0000OoO));
            this.O0000OOo.lineTo((float) (this.O0000o0O + this.O00000oO), (float) (this.O0000o0 - this.O0000OoO));
            this.O0000OOo.quadTo((float) this.O0000o0O, (float) (this.O0000o0 - this.O0000OoO), (float) this.O0000o0O, (float) ((this.O0000o0 - this.O0000OoO) + this.O00000oO));
            this.O0000OOo.lineTo((float) this.O0000o0O, (float) (this.O0000o0 - this.O00000oO));
            this.O0000OOo.quadTo((float) this.O0000o0O, (float) this.O0000o0, (float) (this.O0000o0O + this.O00000oO), (float) this.O0000o0);
            this.O0000OOo.lineTo((float) ((this.O0000o0O + this.O0000Oo) - this.O00000oO), (float) this.O0000o0);
            this.O0000OOo.quadTo((float) (this.O0000o0O + this.O0000Oo), (float) this.O0000o0, (float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 - this.O00000oO));
            this.O0000OOo.lineTo((float) (this.O0000o0O + this.O0000Oo), (float) ((this.O0000o0 - this.O0000OoO) + this.O00000oO));
            this.O0000OOo.quadTo((float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 - this.O0000OoO), (float) ((this.O0000o0O + this.O0000Oo) - this.O00000oO), (float) (this.O0000o0 - this.O0000OoO));
            canvas.drawPath(this.O0000OOo, this.O00000oo);
            this.O0000o.add(new Rect(this.O0000o0O - ((this.O0000o0o.size() - 1) * this.O0000Oo), this.O0000o0 - this.O0000OoO, (this.O0000o0O - ((this.O0000o0o.size() - 1) * this.O0000Oo)) + this.O0000Oo, this.O0000o0));
        } else {
            int i = 0;
            while (i < this.O0000o0o.size()) {
                if (this.O0000oO == i) {
                    this.O00000oo.setColor(-12303292);
                } else {
                    this.O00000oo.setColor(-16777216);
                }
                if (i == 0) {
                    this.O0000OOo.reset();
                    this.O0000OOo.moveTo((float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 - this.O0000OoO));
                    this.O0000OOo.lineTo((float) (this.O0000o0O + this.O00000oO), (float) (this.O0000o0 - this.O0000OoO));
                    this.O0000OOo.quadTo((float) this.O0000o0O, (float) (this.O0000o0 - this.O0000OoO), (float) this.O0000o0O, (float) ((this.O0000o0 - this.O0000OoO) + this.O00000oO));
                    this.O0000OOo.lineTo((float) this.O0000o0O, (float) (this.O0000o0 - this.O00000oO));
                    this.O0000OOo.quadTo((float) this.O0000o0O, (float) this.O0000o0, (float) (this.O0000o0O + this.O00000oO), (float) this.O0000o0);
                    this.O0000OOo.lineTo((float) (this.O0000o0O + this.O0000Oo), (float) this.O0000o0);
                    canvas.drawPath(this.O0000OOo, this.O00000oo);
                    this.O00000oo.setColor(this.O00000o);
                    canvas.drawLine((float) (this.O0000o0O + this.O0000Oo), (float) (this.O0000o0 - this.O0000OoO), (float) (this.O0000o0O + this.O0000Oo), (float) this.O0000o0, this.O00000oo);
                } else if (i == this.O0000o0o.size() - 1) {
                    this.O0000OOo.reset();
                    this.O0000OOo.moveTo((float) (this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))), (float) (this.O0000o0 - this.O0000OoO));
                    this.O0000OOo.lineTo((float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo) - this.O00000oO), (float) (this.O0000o0 - this.O0000OoO));
                    this.O0000OOo.quadTo((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) (this.O0000o0 - this.O0000OoO), (float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) ((this.O0000o0 - this.O0000OoO) + this.O00000oO));
                    this.O0000OOo.lineTo((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) (this.O0000o0 - this.O00000oO));
                    this.O0000OOo.quadTo((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo), (float) this.O0000o0, (float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) + this.O0000Oo) - this.O00000oO), (float) this.O0000o0);
                    this.O0000OOo.lineTo((float) (this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))), (float) this.O0000o0);
                    canvas.drawPath(this.O0000OOo, this.O00000oo);
                } else {
                    int i2 = i + 1;
                    canvas.drawRect((float) ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)), (float) (this.O0000o0 - this.O0000OoO), (float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)) + this.O0000Oo), (float) this.O0000o0, this.O00000oo);
                    this.O00000oo.setColor(this.O00000o);
                    canvas.drawLine((float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)) + this.O0000Oo), (float) (this.O0000o0 - this.O0000OoO), (float) (((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i2) * this.O0000Oo)) + this.O0000Oo), (float) this.O0000o0, this.O00000oo);
                }
                i++;
                this.O0000o.add(new Rect((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i) * this.O0000Oo), this.O0000o0 - this.O0000OoO, ((this.O0000o0O + (this.O0000Oo * (this.O0000o0o.size() - 1))) - ((this.O0000o0o.size() - i) * this.O0000Oo)) + this.O0000Oo, this.O0000o0));
            }
        }
        O00000o0(canvas);
    }

    private void O00000o() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    private void O00000o(Canvas canvas) {
        canvas.drawColor(0);
    }

    private void O00000o0() {
        int i = getResources().getDisplayMetrics().widthPixels;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("initView() called with: x = [");
        stringBuilder.append(this.O0000oOO);
        stringBuilder.append("], y = [");
        stringBuilder.append(this.O0000oOo);
        stringBuilder.append("]");
        kz.O000000o("TAG", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("initView mItemHeight: ");
        stringBuilder.append(this.O0000OoO);
        kz.O000000o("TAG", stringBuilder.toString());
        if (this.O0000oOo / 2 < this.O0000OoO) {
            this.O00000o0 = 1;
            this.O0000Ooo = this.O0000oOo + this.O0000oo0;
            this.O0000o0 = this.O0000Ooo + O000000o(7.0f);
        } else {
            this.O00000o0 = 2;
            this.O0000Ooo = this.O0000oOo;
            this.O0000o0 = this.O0000Ooo - O000000o(7.0f);
        }
        this.O0000o0O = this.O0000oOO - ((this.O0000Oo * this.O0000o0o.size()) / 2);
        if (this.O0000o0O < 0) {
            this.O0000o0O = this.O0000Oo0;
            if (this.O0000oOO - this.O00000oO <= this.O0000o0O) {
                this.O0000oOO = this.O0000o0O + (this.O00000oO * 2);
            }
        } else if (this.O0000o0O + (this.O0000Oo * this.O0000o0o.size()) > i) {
            this.O0000o0O -= ((this.O0000o0O + (this.O0000Oo * this.O0000o0o.size())) - i) + this.O0000Oo0;
            if (this.O0000oOO + this.O00000oO >= this.O0000o0O + (this.O0000Oo * this.O0000o0o.size())) {
                this.O0000oOO = (this.O0000o0O + (this.O0000Oo * this.O0000o0o.size())) - (this.O00000oO * 2);
            }
        }
    }

    private void O00000o0(Canvas canvas) {
        for (int i = 0; i < this.O0000o.size(); i++) {
            O0000O0o o0000O0o = (O0000O0o) this.O0000o0o.get(i);
            this.O00000oo.setColor(o0000O0o.O00000Oo());
            if (this.O00000o0 == 2) {
                canvas.drawText(o0000O0o.O000000o(), ((float) (((Rect) this.O0000o.get(i)).left + (this.O0000Oo / 2))) - (O000000o(o0000O0o.O000000o(), this.O00000oo) / 2.0f), ((float) (this.O0000o0 - (this.O0000OoO / 2))) + (O000000o(this.O00000oo) / 2.0f), this.O00000oo);
            } else if (this.O00000o0 == 1) {
                canvas.drawText(o0000O0o.O000000o(), ((float) (((Rect) this.O0000o.get(i)).left + (this.O0000Oo / 2))) - (O000000o(o0000O0o.O000000o(), this.O00000oo) / 2.0f), ((float) (((Rect) this.O0000o.get(i)).bottom - (this.O0000OoO / 2))) + (O000000o(this.O00000oo) / 2.0f), this.O00000oo);
            }
        }
    }

    private void setOnItemClickListener(O00000Oo o00000Oo) {
        this.O0000oO0 = o00000Oo;
    }

    public void O000000o() {
        this.O0000o.clear();
        this.O0000OOo.reset();
        this.O0000O0o.reset();
        this.O0000oOO = 0;
        this.O0000oOo = 0;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        O00000o(canvas);
        switch (this.O00000o0) {
            case 1:
                O000000o(canvas);
                return;
            case 2:
                O00000Oo(canvas);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Missing block: B:4:0x0010, code skipped:
            if (r1 >= r6.O0000o.size()) goto L_0x0048;
     */
    /* JADX WARNING: Missing block: B:6:0x0014, code skipped:
            if (r6.O0000oO0 == null) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:8:0x002f, code skipped:
            if (O000000o(new android.graphics.PointF(r7.getX(), r7.getY()), (android.graphics.Rect) r6.O0000o.get(r1)) == false) goto L_0x0045;
     */
    /* JADX WARNING: Missing block: B:9:0x0031, code skipped:
            r6.O0000oO0.O000000o(((com.zjwh.android_wh_physicalfitness.view.O0000O0o) r6.O0000o0o.get(r1)).O000000o(), r1);
            r6.O0000oO = -1;
     */
    /* JADX WARNING: Missing block: B:10:0x0045, code skipped:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:12:0x004a, code skipped:
            if (r6.O0000oO0 == null) goto L_0x0054;
     */
    /* JADX WARNING: Missing block: B:13:0x004c, code skipped:
            O000000o();
            r6.O0000oO0.O000000o();
     */
    /* JADX WARNING: Missing block: B:14:0x0054, code skipped:
            O00000o();
     */
    /* JADX WARNING: Missing block: B:15:0x0057, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:17:0x005e, code skipped:
            if (r1 >= r6.O0000o.size()) goto L_0x00af;
     */
    /* JADX WARNING: Missing block: B:19:0x0062, code skipped:
            if (r6.O0000oO0 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Missing block: B:21:0x007d, code skipped:
            if (O000000o(new android.graphics.PointF(r7.getX(), r7.getY()), (android.graphics.Rect) r6.O0000o.get(r1)) == false) goto L_0x00ac;
     */
    /* JADX WARNING: Missing block: B:22:0x007f, code skipped:
            r6.O0000oO = r1;
            postInvalidate(((android.graphics.Rect) r6.O0000o.get(r1)).left, ((android.graphics.Rect) r6.O0000o.get(r1)).top, ((android.graphics.Rect) r6.O0000o.get(r1)).right, ((android.graphics.Rect) r6.O0000o.get(r1)).bottom);
     */
    /* JADX WARNING: Missing block: B:23:0x00ac, code skipped:
            r1 = r1 + 1;
     */
    /* JADX WARNING: Missing block: B:24:0x00af, code skipped:
            return true;
     */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r0 = r7.getAction();
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 0: goto L_0x0058;
            case 1: goto L_0x000a;
            default: goto L_0x0009;
        };
    L_0x0009:
        return r2;
    L_0x000a:
        r0 = r6.O0000o;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0048;
    L_0x0012:
        r0 = r6.O0000oO0;
        if (r0 == 0) goto L_0x0045;
    L_0x0016:
        r0 = new android.graphics.PointF;
        r3 = r7.getX();
        r4 = r7.getY();
        r0.<init>(r3, r4);
        r3 = r6.O0000o;
        r3 = r3.get(r1);
        r3 = (android.graphics.Rect) r3;
        r0 = r6.O000000o(r0, r3);
        if (r0 == 0) goto L_0x0045;
    L_0x0031:
        r0 = r6.O0000oO0;
        r3 = r6.O0000o0o;
        r3 = r3.get(r1);
        r3 = (com.zjwh.android_wh_physicalfitness.view.O0000O0o) r3;
        r3 = r3.O000000o();
        r0.O000000o(r3, r1);
        r0 = -1;
        r6.O0000oO = r0;
    L_0x0045:
        r1 = r1 + 1;
        goto L_0x000a;
    L_0x0048:
        r7 = r6.O0000oO0;
        if (r7 == 0) goto L_0x0054;
    L_0x004c:
        r6.O000000o();
        r7 = r6.O0000oO0;
        r7.O000000o();
    L_0x0054:
        r6.O00000o();
        return r2;
    L_0x0058:
        r0 = r6.O0000o;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x00af;
    L_0x0060:
        r0 = r6.O0000oO0;
        if (r0 == 0) goto L_0x00ac;
    L_0x0064:
        r0 = new android.graphics.PointF;
        r3 = r7.getX();
        r4 = r7.getY();
        r0.<init>(r3, r4);
        r3 = r6.O0000o;
        r3 = r3.get(r1);
        r3 = (android.graphics.Rect) r3;
        r0 = r6.O000000o(r0, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x007f:
        r6.O0000oO = r1;
        r0 = r6.O0000o;
        r0 = r0.get(r1);
        r0 = (android.graphics.Rect) r0;
        r0 = r0.left;
        r3 = r6.O0000o;
        r3 = r3.get(r1);
        r3 = (android.graphics.Rect) r3;
        r3 = r3.top;
        r4 = r6.O0000o;
        r4 = r4.get(r1);
        r4 = (android.graphics.Rect) r4;
        r4 = r4.right;
        r5 = r6.O0000o;
        r5 = r5.get(r1);
        r5 = (android.graphics.Rect) r5;
        r5 = r5.bottom;
        r6.postInvalidate(r0, r3, r4, r5);
    L_0x00ac:
        r1 = r1 + 1;
        goto L_0x0058;
    L_0x00af:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.view.TipView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setSeparateLineColor(int i) {
        this.O00000o = i;
    }

    public void setTipItemList(List<O0000O0o> list) {
        this.O0000o0o.clear();
        for (O0000O0o o0000O0o : list) {
            if (TextUtils.isEmpty(o0000O0o.O000000o())) {
                o0000O0o.O000000o("");
            } else {
                o0000O0o.O000000o(O000000o(o0000O0o.O000000o()));
            }
            this.O0000o0o.add(o0000O0o);
        }
    }
}
