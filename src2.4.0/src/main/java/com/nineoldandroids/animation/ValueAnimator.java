package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ValueAnimator extends Animator {
    static final int ANIMATION_FRAME = 1;
    static final int ANIMATION_START = 0;
    private static final long DEFAULT_FRAME_DELAY = 10;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    private static ThreadLocal<AnimationHandler> sAnimationHandler = new ThreadLocal();
    private static final ThreadLocal<ArrayList<ValueAnimator>> sAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* Access modifiers changed, original: protected */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final Interpolator sDefaultInterpolator = new AccelerateDecelerateInterpolator();
    private static final ThreadLocal<ArrayList<ValueAnimator>> sDelayedAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* Access modifiers changed, original: protected */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> sEndingAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* Access modifiers changed, original: protected */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static long sFrameDelay = 10;
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final ThreadLocal<ArrayList<ValueAnimator>> sPendingAnimations = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* Access modifiers changed, original: protected */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private static final ThreadLocal<ArrayList<ValueAnimator>> sReadyAnims = new ThreadLocal<ArrayList<ValueAnimator>>() {
        /* Access modifiers changed, original: protected */
        public ArrayList<ValueAnimator> initialValue() {
            return new ArrayList();
        }
    };
    private float mCurrentFraction = 0.0f;
    private int mCurrentIteration = 0;
    private long mDelayStartTime;
    private long mDuration = 300;
    boolean mInitialized = false;
    private Interpolator mInterpolator = sDefaultInterpolator;
    private boolean mPlayingBackwards = false;
    int mPlayingState = 0;
    private int mRepeatCount = 0;
    private int mRepeatMode = 1;
    private boolean mRunning = false;
    long mSeekTime = -1;
    private long mStartDelay = 0;
    long mStartTime;
    private boolean mStarted = false;
    private boolean mStartedDelay = false;
    private ArrayList<AnimatorUpdateListener> mUpdateListeners = null;
    PropertyValuesHolder[] mValues;
    HashMap<String, PropertyValuesHolder> mValuesMap;

    private static class AnimationHandler extends Handler {
        private AnimationHandler() {
        }

        /* synthetic */ AnimationHandler(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void handleMessage(Message message) {
            ArrayList arrayList;
            boolean z;
            int i;
            ValueAnimator valueAnimator;
            ArrayList arrayList2 = (ArrayList) ValueAnimator.sAnimations.get();
            ArrayList arrayList3 = (ArrayList) ValueAnimator.sDelayedAnims.get();
            int i2 = 0;
            switch (message.what) {
                case 0:
                    arrayList = (ArrayList) ValueAnimator.sPendingAnimations.get();
                    z = arrayList2.size() <= 0 && arrayList3.size() <= 0;
                    while (arrayList.size() > 0) {
                        ArrayList arrayList4 = (ArrayList) arrayList.clone();
                        arrayList.clear();
                        int size = arrayList4.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            ValueAnimator valueAnimator2 = (ValueAnimator) arrayList4.get(i3);
                            if (valueAnimator2.mStartDelay == 0) {
                                valueAnimator2.startAnimation();
                            } else {
                                arrayList3.add(valueAnimator2);
                            }
                        }
                    }
                    break;
                case 1:
                    z = true;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            arrayList = (ArrayList) ValueAnimator.sReadyAnims.get();
            ArrayList arrayList5 = (ArrayList) ValueAnimator.sEndingAnims.get();
            int size2 = arrayList3.size();
            for (i = 0; i < size2; i++) {
                valueAnimator = (ValueAnimator) arrayList3.get(i);
                if (valueAnimator.delayedAnimationFrame(currentAnimationTimeMillis)) {
                    arrayList.add(valueAnimator);
                }
            }
            size2 = arrayList.size();
            if (size2 > 0) {
                for (i = 0; i < size2; i++) {
                    valueAnimator = (ValueAnimator) arrayList.get(i);
                    valueAnimator.startAnimation();
                    valueAnimator.mRunning = true;
                    arrayList3.remove(valueAnimator);
                }
                arrayList.clear();
            }
            size2 = arrayList2.size();
            int i4 = 0;
            while (i4 < size2) {
                ValueAnimator valueAnimator3 = (ValueAnimator) arrayList2.get(i4);
                if (valueAnimator3.animationFrame(currentAnimationTimeMillis)) {
                    arrayList5.add(valueAnimator3);
                }
                if (arrayList2.size() == size2) {
                    i4++;
                } else {
                    size2--;
                    arrayList5.remove(valueAnimator3);
                }
            }
            if (arrayList5.size() > 0) {
                while (i2 < arrayList5.size()) {
                    ((ValueAnimator) arrayList5.get(i2)).endAnimation();
                    i2++;
                }
                arrayList5.clear();
            }
            if (!z) {
                return;
            }
            if (!arrayList2.isEmpty() || !arrayList3.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, ValueAnimator.sFrameDelay - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimator valueAnimator);
    }

    public static void clearAllAnimations() {
        ((ArrayList) sAnimations.get()).clear();
        ((ArrayList) sPendingAnimations.get()).clear();
        ((ArrayList) sDelayedAnims.get()).clear();
    }

    private boolean delayedAnimationFrame(long j) {
        if (this.mStartedDelay) {
            long j2 = j - this.mDelayStartTime;
            if (j2 > this.mStartDelay) {
                this.mStartTime = j - (j2 - this.mStartDelay);
                this.mPlayingState = 1;
                return true;
            }
        }
        this.mStartedDelay = true;
        this.mDelayStartTime = j;
        return false;
    }

    private void endAnimation() {
        ((ArrayList) sAnimations.get()).remove(this);
        ((ArrayList) sPendingAnimations.get()).remove(this);
        ((ArrayList) sDelayedAnims.get()).remove(this);
        this.mPlayingState = 0;
        if (this.mRunning && this.mListeners != null) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorListener) arrayList.get(i)).onAnimationEnd(this);
            }
        }
        this.mRunning = false;
        this.mStarted = false;
    }

    public static int getCurrentAnimationsCount() {
        return ((ArrayList) sAnimations.get()).size();
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static ValueAnimator ofFloat(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        return valueAnimator;
    }

    public static ValueAnimator ofInt(int... iArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iArr);
        return valueAnimator;
    }

    public static ValueAnimator ofObject(TypeEvaluator typeEvaluator, Object... objArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setObjectValues(objArr);
        valueAnimator.setEvaluator(typeEvaluator);
        return valueAnimator;
    }

    public static ValueAnimator ofPropertyValuesHolder(PropertyValuesHolder... propertyValuesHolderArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyValuesHolderArr);
        return valueAnimator;
    }

    public static void setFrameDelay(long j) {
        sFrameDelay = j;
    }

    private void start(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.mPlayingBackwards = z;
        this.mCurrentIteration = 0;
        this.mPlayingState = 0;
        this.mStarted = true;
        this.mStartedDelay = false;
        ((ArrayList) sPendingAnimations.get()).add(this);
        if (this.mStartDelay == 0) {
            setCurrentPlayTime(getCurrentPlayTime());
            this.mPlayingState = 0;
            this.mRunning = true;
            if (this.mListeners != null) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) arrayList.get(i)).onAnimationStart(this);
                }
            }
        }
        AnimationHandler animationHandler = (AnimationHandler) sAnimationHandler.get();
        if (animationHandler == null) {
            animationHandler = new AnimationHandler();
            sAnimationHandler.set(animationHandler);
        }
        animationHandler.sendEmptyMessage(0);
    }

    private void startAnimation() {
        initAnimation();
        ((ArrayList) sAnimations.get()).add(this);
        if (this.mStartDelay > 0 && this.mListeners != null) {
            ArrayList arrayList = (ArrayList) this.mListeners.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((AnimatorListener) arrayList.get(i)).onAnimationStart(this);
            }
        }
    }

    public void addUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners == null) {
            this.mUpdateListeners = new ArrayList();
        }
        this.mUpdateListeners.add(animatorUpdateListener);
    }

    /* Access modifiers changed, original: 0000 */
    public void animateValue(float f) {
        f = this.mInterpolator.getInterpolation(f);
        this.mCurrentFraction = f;
        int i = 0;
        for (PropertyValuesHolder calculateValue : this.mValues) {
            calculateValue.calculateValue(f);
        }
        if (this.mUpdateListeners != null) {
            int size = this.mUpdateListeners.size();
            while (i < size) {
                ((AnimatorUpdateListener) this.mUpdateListeners.get(i)).onAnimationUpdate(this);
                i++;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean animationFrame(long j) {
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            if (this.mSeekTime < 0) {
                this.mStartTime = j;
            } else {
                this.mStartTime = j - this.mSeekTime;
                this.mSeekTime = -1;
            }
        }
        boolean z = false;
        switch (this.mPlayingState) {
            case 1:
            case 2:
                float f = this.mDuration > 0 ? ((float) (j - this.mStartTime)) / ((float) this.mDuration) : 1.0f;
                if (f >= 1.0f) {
                    if (this.mCurrentIteration < this.mRepeatCount || this.mRepeatCount == -1) {
                        if (this.mListeners != null) {
                            int size = this.mListeners.size();
                            for (int i = 0; i < size; i++) {
                                ((AnimatorListener) this.mListeners.get(i)).onAnimationRepeat(this);
                            }
                        }
                        if (this.mRepeatMode == 2) {
                            this.mPlayingBackwards ^= 1;
                        }
                        this.mCurrentIteration += (int) f;
                        f %= 1.0f;
                        this.mStartTime += this.mDuration;
                    } else {
                        f = Math.min(f, 1.0f);
                        z = true;
                    }
                }
                if (this.mPlayingBackwards) {
                    f = 1.0f - f;
                }
                animateValue(f);
                break;
        }
        return z;
    }

    public void cancel() {
        if (this.mPlayingState != 0 || ((ArrayList) sPendingAnimations.get()).contains(this) || ((ArrayList) sDelayedAnims.get()).contains(this)) {
            if (this.mRunning && this.mListeners != null) {
                Iterator it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            endAnimation();
        }
    }

    public ValueAnimator clone() {
        int size;
        ValueAnimator valueAnimator = (ValueAnimator) super.clone();
        int i = 0;
        if (this.mUpdateListeners != null) {
            ArrayList arrayList = this.mUpdateListeners;
            valueAnimator.mUpdateListeners = new ArrayList();
            size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                valueAnimator.mUpdateListeners.add(arrayList.get(i2));
            }
        }
        valueAnimator.mSeekTime = -1;
        valueAnimator.mPlayingBackwards = false;
        valueAnimator.mCurrentIteration = 0;
        valueAnimator.mInitialized = false;
        valueAnimator.mPlayingState = 0;
        valueAnimator.mStartedDelay = false;
        PropertyValuesHolder[] propertyValuesHolderArr = this.mValues;
        if (propertyValuesHolderArr != null) {
            size = propertyValuesHolderArr.length;
            valueAnimator.mValues = new PropertyValuesHolder[size];
            valueAnimator.mValuesMap = new HashMap(size);
            while (i < size) {
                PropertyValuesHolder clone = propertyValuesHolderArr[i].clone();
                valueAnimator.mValues[i] = clone;
                valueAnimator.mValuesMap.put(clone.getPropertyName(), clone);
                i++;
            }
        }
        return valueAnimator;
    }

    public void end() {
        if (!((ArrayList) sAnimations.get()).contains(this) && !((ArrayList) sPendingAnimations.get()).contains(this)) {
            this.mStartedDelay = false;
            startAnimation();
        } else if (!this.mInitialized) {
            initAnimation();
        }
        if (this.mRepeatCount <= 0 || (this.mRepeatCount & 1) != 1) {
            animateValue(1.0f);
        } else {
            animateValue(0.0f);
        }
        endAnimation();
    }

    public float getAnimatedFraction() {
        return this.mCurrentFraction;
    }

    public Object getAnimatedValue() {
        return (this.mValues == null || this.mValues.length <= 0) ? null : this.mValues[0].getAnimatedValue();
    }

    public Object getAnimatedValue(String str) {
        PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) this.mValuesMap.get(str);
        return propertyValuesHolder != null ? propertyValuesHolder.getAnimatedValue() : null;
    }

    public long getCurrentPlayTime() {
        return (!this.mInitialized || this.mPlayingState == 0) ? 0 : AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public PropertyValuesHolder[] getValues() {
        return this.mValues;
    }

    /* Access modifiers changed, original: 0000 */
    public void initAnimation() {
        if (!this.mInitialized) {
            for (PropertyValuesHolder init : this.mValues) {
                init.init();
            }
            this.mInitialized = true;
        }
    }

    public boolean isRunning() {
        return this.mPlayingState == 1 || this.mRunning;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public void removeAllUpdateListeners() {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.clear();
            this.mUpdateListeners = null;
        }
    }

    public void removeUpdateListener(AnimatorUpdateListener animatorUpdateListener) {
        if (this.mUpdateListeners != null) {
            this.mUpdateListeners.remove(animatorUpdateListener);
            if (this.mUpdateListeners.size() == 0) {
                this.mUpdateListeners = null;
            }
        }
    }

    public void reverse() {
        this.mPlayingBackwards ^= 1;
        if (this.mPlayingState == 1) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis - (this.mDuration - (currentAnimationTimeMillis - this.mStartTime));
            return;
        }
        start(true);
    }

    public void setCurrentPlayTime(long j) {
        initAnimation();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mPlayingState != 1) {
            this.mSeekTime = j;
            this.mPlayingState = 2;
        }
        this.mStartTime = currentAnimationTimeMillis - j;
        animationFrame(currentAnimationTimeMillis);
    }

    public ValueAnimator setDuration(long j) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animators cannot have negative duration: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mDuration = j;
        return this;
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        if (typeEvaluator != null && this.mValues != null && this.mValues.length > 0) {
            this.mValues[0].setEvaluator(typeEvaluator);
        }
    }

    public void setFloatValues(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                setValues(PropertyValuesHolder.ofFloat("", fArr));
            } else {
                this.mValues[0].setFloatValues(fArr);
            }
            this.mInitialized = false;
        }
    }

    public void setIntValues(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                setValues(PropertyValuesHolder.ofInt("", iArr));
            } else {
                this.mValues[0].setIntValues(iArr);
            }
            this.mInitialized = false;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        if (interpolator != null) {
            this.mInterpolator = interpolator;
        } else {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setObjectValues(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            if (this.mValues == null || this.mValues.length == 0) {
                setValues(PropertyValuesHolder.ofObject("", (TypeEvaluator) null, objArr));
            } else {
                this.mValues[0].setObjectValues(objArr);
            }
            this.mInitialized = false;
        }
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
    }

    public void setRepeatMode(int i) {
        this.mRepeatMode = i;
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public void setValues(PropertyValuesHolder... propertyValuesHolderArr) {
        this.mValues = propertyValuesHolderArr;
        this.mValuesMap = new HashMap(r1);
        for (PropertyValuesHolder propertyValuesHolder : propertyValuesHolderArr) {
            this.mValuesMap.put(propertyValuesHolder.getPropertyName(), propertyValuesHolder);
        }
        this.mInitialized = false;
    }

    public void start() {
        start(false);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ValueAnimator@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        String stringBuilder2 = stringBuilder.toString();
        if (this.mValues != null) {
            for (PropertyValuesHolder propertyValuesHolder : this.mValues) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append("\n    ");
                stringBuilder3.append(propertyValuesHolder.toString());
                stringBuilder2 = stringBuilder3.toString();
            }
        }
        return stringBuilder2;
    }
}
