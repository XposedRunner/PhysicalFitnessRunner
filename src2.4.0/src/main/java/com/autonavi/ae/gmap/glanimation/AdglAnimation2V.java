package com.autonavi.ae.gmap.glanimation;

import android.os.SystemClock;

public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i) {
        reset();
        this.duration = i;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
    }

    public void doAnimation(Object obj) {
        if (!this.isOver) {
            this.offsetTime = SystemClock.uptimeMillis() - this.startTime;
            float f = ((float) this.offsetTime) / ((float) this.duration);
            if (f > 1.0f) {
                this.isOver = true;
                f = 1.0f;
            } else if (f < 0.0f) {
                this.isOver = true;
                return;
            }
            if (this.v2Param != null) {
                this.v2Param.setNormalizedTime(f);
                this.curValue1 = this.v2Param.getCurXValue();
                this.curValue2 = this.v2Param.getCurYValue();
            }
        }
    }

    public double getCurValue(int i) {
        return i == 0 ? this.curValue1 : this.curValue2;
    }

    public double getEndValue(int i) {
        return i == 0 ? this.v2Param != null ? this.v2Param.getToXValue() : 0.0d : this.v2Param != null ? this.v2Param.getToYValue() : 0.0d;
    }

    public double getStartValue(int i) {
        return i == 0 ? this.v2Param != null ? this.v2Param.getFromXValue() : 0.0d : this.v2Param != null ? this.v2Param.getFromYValue() : 0.0d;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = 0.0d;
        this.curValue2 = 0.0d;
        if (this.v2Param != null) {
            this.v2Param.reset();
        }
    }
}
