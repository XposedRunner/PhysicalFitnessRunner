package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {
    private int deltaValue;
    private boolean firstTime = true;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
    }

    public IntKeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        IntKeyframe[] intKeyframeArr = new IntKeyframe[size];
        for (int i = 0; i < size; i++) {
            intKeyframeArr[i] = (IntKeyframe) ((Keyframe) arrayList.get(i)).clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public int getIntValue(float f) {
        IntKeyframe intKeyframe;
        IntKeyframe intKeyframe2;
        int intValue;
        int intValue2;
        float fraction;
        float fraction2;
        Interpolator interpolator;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((IntKeyframe) this.mKeyframes.get(0)).getIntValue();
                this.lastValue = ((IntKeyframe) this.mKeyframes.get(1)).getIntValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator == null ? this.firstValue + ((int) (f * ((float) this.deltaValue))) : ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
        } else if (f <= 0.0f) {
            intKeyframe = (IntKeyframe) this.mKeyframes.get(0);
            intKeyframe2 = (IntKeyframe) this.mKeyframes.get(1);
            intValue = intKeyframe.getIntValue();
            intValue2 = intKeyframe2.getIntValue();
            fraction = intKeyframe.getFraction();
            fraction2 = intKeyframe2.getFraction();
            interpolator = intKeyframe2.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            f = (f - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? intValue + ((int) (f * ((float) (intValue2 - intValue)))) : ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(intValue), Integer.valueOf(intValue2))).intValue();
        } else if (f >= 1.0f) {
            intKeyframe = (IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            intKeyframe2 = (IntKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            intValue = intKeyframe.getIntValue();
            intValue2 = intKeyframe2.getIntValue();
            fraction = intKeyframe.getFraction();
            fraction2 = intKeyframe2.getFraction();
            interpolator = intKeyframe2.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            f = (f - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? intValue + ((int) (f * ((float) (intValue2 - intValue)))) : ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(intValue), Integer.valueOf(intValue2))).intValue();
        } else {
            intKeyframe2 = (IntKeyframe) this.mKeyframes.get(0);
            int i = 1;
            while (i < this.mNumKeyframes) {
                IntKeyframe intKeyframe3 = (IntKeyframe) this.mKeyframes.get(i);
                if (f < intKeyframe3.getFraction()) {
                    Interpolator interpolator2 = intKeyframe3.getInterpolator();
                    if (interpolator2 != null) {
                        f = interpolator2.getInterpolation(f);
                    }
                    f = (f - intKeyframe2.getFraction()) / (intKeyframe3.getFraction() - intKeyframe2.getFraction());
                    i = intKeyframe2.getIntValue();
                    int intValue3 = intKeyframe3.getIntValue();
                    return this.mEvaluator == null ? i + ((int) (f * ((float) (intValue3 - i)))) : ((Number) this.mEvaluator.evaluate(f, Integer.valueOf(i), Integer.valueOf(intValue3))).intValue();
                }
                i++;
                intKeyframe2 = intKeyframe3;
            }
            return ((Number) ((Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).intValue();
        }
    }

    public Object getValue(float f) {
        return Integer.valueOf(getIntValue(f));
    }
}
