package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private ArrayList<GLAnimation> mAnimations = new ArrayList();
    private boolean mDirty;
    private int mFlags = 0;
    private boolean mHasAlpha;
    private long mLastEnd;
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z) {
        setFlag(16, z);
        init();
    }

    private void init() {
        this.mStartTime = 0;
    }

    private void setFlag(int i, boolean z) {
        if (z) {
            this.mFlags = i | this.mFlags;
            return;
        }
        this.mFlags = (i ^ -1) & this.mFlags;
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        boolean z = false;
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if ((this.mFlags & 128) == 0) {
            z = true;
        }
        if (z && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            this.mDuration = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else {
            this.mLastEnd = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mDuration = this.mLastEnd - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    public GLAnimationSet clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList();
        int size = this.mAnimations.size();
        ArrayList arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            gLAnimationSet.mAnimations.add(((GLAnimation) arrayList.get(i)).clone());
        }
        return gLAnimationSet;
    }

    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList arrayList = this.mAnimations;
        long j = 0;
        for (size--; size >= 0; size--) {
            long computeDurationHint = ((GLAnimation) arrayList.get(size)).computeDurationHint();
            if (computeDurationHint > j) {
                j = computeDurationHint;
            }
        }
        return j;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    public long getDuration() {
        ArrayList arrayList = this.mAnimations;
        int size = arrayList.size();
        int i = 0;
        if (((this.mFlags & 32) == 32 ? 1 : 0) != 0) {
            return this.mDuration;
        }
        long j = 0;
        while (i < size) {
            j = Math.max(j, ((GLAnimation) arrayList.get(i)).getDuration());
            i++;
        }
        return j;
    }

    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList arrayList = this.mAnimations;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.min(j, ((GLAnimation) arrayList.get(i)).getStartTime());
        }
        return j;
    }

    public boolean getTransformation(long j, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z = true;
        boolean z2 = false;
        boolean z3 = z2;
        for (size--; size >= 0; size--) {
            GLAnimation gLAnimation = (GLAnimation) arrayList.get(size);
            gLTransformation2.clear();
            z3 = gLAnimation.getTransformation(j, gLTransformation, getScaleFactor()) || z3;
            z2 = z2 || gLAnimation.hasStarted();
            z = gLAnimation.hasEnded() && z;
        }
        if (z2) {
            try {
                if (!this.mStarted) {
                    if (this.mListener != null) {
                        this.mListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z != this.mEnded) {
            if (this.mListener != null) {
                this.mListener.onAnimationEnd();
            }
            this.mEnded = z;
        }
        return z3;
    }

    public boolean hasAlpha() {
        if (this.mDirty) {
            int i = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList arrayList = this.mAnimations;
            while (i < size) {
                if (((GLAnimation) arrayList.get(i)).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                }
                i++;
            }
        }
        return this.mHasAlpha;
    }

    public void initialize() {
        super.initialize();
        int i = 1;
        int i2 = (this.mFlags & 32) == 32 ? 1 : 0;
        int i3 = (this.mFlags & 1) == 1 ? 1 : 0;
        int i4 = (this.mFlags & 2) == 2 ? 1 : 0;
        int i5 = (this.mFlags & 4) == 4 ? 1 : 0;
        int i6 = (this.mFlags & 16) == 16 ? 1 : 0;
        if ((this.mFlags & 8) != 8) {
            i = 0;
        }
        if (i6 != 0) {
            ensureInterpolator();
        }
        ArrayList arrayList = this.mAnimations;
        int size = arrayList.size();
        long j = this.mDuration;
        boolean z = this.mFillAfter;
        boolean z2 = this.mFillBefore;
        int i7 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        int i8 = i;
        long j2 = this.mStartOffset;
        int i9 = 0;
        while (i9 < size) {
            int i10;
            int i11;
            ArrayList arrayList2 = arrayList;
            GLAnimation gLAnimation = (GLAnimation) arrayList.get(i9);
            if (i2 != 0) {
                gLAnimation.setDuration(j);
            }
            if (i3 != 0) {
                gLAnimation.setFillAfter(z);
            }
            if (i4 != 0) {
                gLAnimation.setFillBefore(z2);
            }
            if (i5 != 0) {
                gLAnimation.setRepeatMode(i7);
            }
            if (i6 != 0) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (i8 != 0) {
                i10 = i2;
                i11 = i3;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j2);
            } else {
                i10 = i2;
                i11 = i3;
            }
            gLAnimation.initialize();
            i9++;
            arrayList = arrayList2;
            i2 = i10;
            i3 = i11;
        }
    }

    public void reset() {
        super.reset();
    }

    public void restrictDuration(long j) {
        super.restrictDuration(j);
        ArrayList arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((GLAnimation) arrayList.get(i)).restrictDuration(j);
        }
    }

    public void scaleCurrentDuration(float f) {
        ArrayList arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((GLAnimation) arrayList.get(i)).scaleCurrentDuration(f);
        }
    }

    public void setDuration(long j) {
        this.mFlags |= 32;
        super.setDuration(j);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    public void setFillAfter(boolean z) {
        this.mFlags |= 1;
        super.setFillAfter(z);
    }

    public void setFillBefore(boolean z) {
        this.mFlags |= 2;
        super.setFillBefore(z);
    }

    public void setRepeatMode(int i) {
        this.mFlags |= 4;
        super.setRepeatMode(i);
    }

    public void setStartOffset(long j) {
        this.mFlags |= 8;
        super.setStartOffset(j);
    }

    public void setStartTime(long j) {
        super.setStartTime(j);
        int size = this.mAnimations.size();
        ArrayList arrayList = this.mAnimations;
        for (int i = 0; i < size; i++) {
            ((GLAnimation) arrayList.get(i)).setStartTime(j);
        }
    }

    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }
}
