package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet {
    private float deltaValue;
    private boolean firstTime = true;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
    }

    public FloatKeyframeSet clone() {
        ArrayList arrayList = this.mKeyframes;
        int size = this.mKeyframes.size();
        FloatKeyframe[] floatKeyframeArr = new FloatKeyframe[size];
        for (int i = 0; i < size; i++) {
            floatKeyframeArr[i] = (FloatKeyframe) ((Keyframe) arrayList.get(i)).clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public float getFloatValue(float f) {
        FloatKeyframe floatKeyframe;
        FloatKeyframe floatKeyframe2;
        float floatValue;
        float floatValue2;
        float fraction;
        float fraction2;
        Interpolator interpolator;
        if (this.mNumKeyframes == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((FloatKeyframe) this.mKeyframes.get(0)).getFloatValue();
                this.lastValue = ((FloatKeyframe) this.mKeyframes.get(1)).getFloatValue();
                this.deltaValue = this.lastValue - this.firstValue;
            }
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
            return this.mEvaluator == null ? this.firstValue + (f * this.deltaValue) : ((Number) this.mEvaluator.evaluate(f, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
        } else if (f <= 0.0f) {
            floatKeyframe = (FloatKeyframe) this.mKeyframes.get(0);
            floatKeyframe2 = (FloatKeyframe) this.mKeyframes.get(1);
            floatValue = floatKeyframe.getFloatValue();
            floatValue2 = floatKeyframe2.getFloatValue();
            fraction = floatKeyframe.getFraction();
            fraction2 = floatKeyframe2.getFraction();
            interpolator = floatKeyframe2.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            f = (f - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? floatValue + (f * (floatValue2 - floatValue)) : ((Number) this.mEvaluator.evaluate(f, Float.valueOf(floatValue), Float.valueOf(floatValue2))).floatValue();
        } else if (f >= 1.0f) {
            floatKeyframe = (FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 2);
            floatKeyframe2 = (FloatKeyframe) this.mKeyframes.get(this.mNumKeyframes - 1);
            floatValue = floatKeyframe.getFloatValue();
            floatValue2 = floatKeyframe2.getFloatValue();
            fraction = floatKeyframe.getFraction();
            fraction2 = floatKeyframe2.getFraction();
            interpolator = floatKeyframe2.getInterpolator();
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            f = (f - fraction) / (fraction2 - fraction);
            return this.mEvaluator == null ? floatValue + (f * (floatValue2 - floatValue)) : ((Number) this.mEvaluator.evaluate(f, Float.valueOf(floatValue), Float.valueOf(floatValue2))).floatValue();
        } else {
            floatKeyframe2 = (FloatKeyframe) this.mKeyframes.get(0);
            int i = 1;
            while (i < this.mNumKeyframes) {
                FloatKeyframe floatKeyframe3 = (FloatKeyframe) this.mKeyframes.get(i);
                if (f < floatKeyframe3.getFraction()) {
                    Interpolator interpolator2 = floatKeyframe3.getInterpolator();
                    if (interpolator2 != null) {
                        f = interpolator2.getInterpolation(f);
                    }
                    f = (f - floatKeyframe2.getFraction()) / (floatKeyframe3.getFraction() - floatKeyframe2.getFraction());
                    fraction = floatKeyframe2.getFloatValue();
                    float floatValue3 = floatKeyframe3.getFloatValue();
                    return this.mEvaluator == null ? fraction + (f * (floatValue3 - fraction)) : ((Number) this.mEvaluator.evaluate(f, Float.valueOf(fraction), Float.valueOf(floatValue3))).floatValue();
                }
                i++;
                floatKeyframe2 = floatKeyframe3;
            }
            return ((Number) ((Keyframe) this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).floatValue();
        }
    }

    public Object getValue(float f) {
        return Float.valueOf(getFloatValue(f));
    }
}
