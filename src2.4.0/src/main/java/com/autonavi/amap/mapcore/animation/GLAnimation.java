package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import s.h.e.l.l.C;

public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    boolean mCycleFlip = false;
    private boolean mDetachWallpaper = false;
    long mDuration = 500;
    boolean mEnded = false;
    boolean mFillAfter = false;
    boolean mFillBefore = true;
    boolean mFillEnabled = false;
    boolean mInitialized = false;
    Interpolator mInterpolator;
    AnimationListener mListener;
    private Handler mListenerHandler;
    private boolean mMore = true;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    private boolean mOneMoreTime = true;
    RectF mPreviousRegion = new RectF();
    GLTransformation mPreviousTransformation = new GLTransformation();
    RectF mRegion = new RectF();
    int mRepeatCount = 0;
    int mRepeatMode = 1;
    int mRepeated = 0;
    private float mScaleFactor = 1.0f;
    long mStartOffset;
    long mStartTime = -1;
    boolean mStarted = false;
    private int mZAdjustment;

    static {
        C.i(14);
    }

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private native void fireAnimationEnd();

    private native void fireAnimationRepeat();

    private native void fireAnimationStart();

    public native void applyTransformation(float f, GLTransformation gLTransformation);

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    public GLAnimation clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * ((long) (getRepeatCount() + 1));
    }

    public native void detach();

    public native void ensureInterpolator();

    public native int getBackgroundColor();

    public native boolean getDetachWallpaper();

    public long getDuration() {
        return this.mDuration;
    }

    public native boolean getFillAfter();

    public native boolean getFillBefore();

    public native Interpolator getInterpolator();

    public native void getInvalidateRegion(int i, int i2, int i3, int i4, RectF rectF, Transformation transformation);

    public native int getRepeatCount();

    public native int getRepeatMode();

    /* Access modifiers changed, original: protected */
    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j, GLTransformation gLTransformation) {
        if (this.mStartTime == -1) {
            this.mStartTime = j;
        }
        long startOffset = getStartOffset();
        long j2 = this.mDuration;
        float f = j2 != 0 ? ((float) (j - (this.mStartTime + startOffset))) / ((float) j2) : j < this.mStartTime ? 0.0f : 1.0f;
        int i = f >= 1.0f ? 1 : 0;
        this.mMore = i ^ 1;
        if (!this.mFillEnabled) {
            f = Math.max(Math.min(f, 1.0f), 0.0f);
        }
        boolean z = (f >= 0.0f || this.mFillBefore) && (f <= 1.0f || this.mFillAfter);
        if (z) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                f = Math.max(Math.min(f, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                f = 1.0f - f;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f), gLTransformation);
        }
        if (i != 0) {
            if (this.mRepeatCount != this.mRepeated) {
                if (this.mRepeatCount > 0) {
                    this.mRepeated++;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip ^= 1;
                }
                this.mStartTime = -1;
                this.mMore = true;
                fireAnimationRepeat();
            } else if (!this.mEnded) {
                this.mEnded = true;
                fireAnimationEnd();
            }
        }
        if (this.mMore || !this.mOneMoreTime) {
            return this.mMore;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public native boolean getTransformation(long j, GLTransformation gLTransformation, float f);

    public native int getZAdjustment();

    public native boolean hasAlpha();

    public native boolean hasEnded();

    public native boolean hasStarted();

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public void initializeInvalidateRegion(int i, int i2, int i3, int i4) {
        RectF rectF = this.mPreviousRegion;
        rectF.set((float) i, (float) i2, (float) i3, (float) i4);
        rectF.inset(-1.0f, -1.0f);
        if (this.mFillBefore) {
            applyTransformation(this.mInterpolator.getInterpolation(0.0f), this.mPreviousTransformation);
        }
    }

    public native boolean isFillEnabled();

    public native boolean isInitialized();

    public native void reset();

    /* Access modifiers changed, original: protected */
    public float resolveSize(int i, float f, int i2, int i3) {
        switch (i) {
            case 0:
                return f;
            case 1:
                return ((float) i2) * f;
            case 2:
                return ((float) i3) * f;
            default:
                return f;
        }
    }

    public void restrictDuration(long j) {
        if (this.mStartOffset > j) {
            this.mStartOffset = j;
            this.mDuration = 0;
            this.mRepeatCount = 0;
            return;
        }
        long j2 = this.mDuration + this.mStartOffset;
        if (j2 > j) {
            this.mDuration = j - this.mStartOffset;
            j2 = j;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0;
            this.mRepeatCount = 0;
            return;
        }
        if (this.mRepeatCount < 0 || ((long) this.mRepeatCount) > j || ((long) this.mRepeatCount) * j2 > j) {
            this.mRepeatCount = ((int) (j / j2)) - 1;
            if (this.mRepeatCount < 0) {
                this.mRepeatCount = 0;
            }
        }
    }

    public void scaleCurrentDuration(float f) {
        this.mDuration = (long) (((float) this.mDuration) * f);
        this.mStartOffset = (long) (((float) this.mStartOffset) * f);
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public native void setBackgroundColor(int i);

    public native void setDetachWallpaper(boolean z);

    public void setDuration(long j) {
        if (j < 0) {
            j = 0;
        }
        this.mDuration = j;
    }

    public native void setFillAfter(boolean z);

    public native void setFillBefore(boolean z);

    public native void setFillEnabled(boolean z);

    public native void setInterpolator(Context context, int i);

    public native void setInterpolator(Interpolator interpolator);

    public native void setListenerHandler(Handler handler);

    public native void setRepeatCount(int i);

    public native void setRepeatMode(int i);

    public void setStartOffset(long j) {
        this.mStartOffset = j;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public native void setZAdjustment(int i);

    public void start() {
        setStartTime(-1);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public native boolean willChangeBounds();

    public native boolean willChangeTransformationMatrix();
}
