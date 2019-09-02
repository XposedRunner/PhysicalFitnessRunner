package com.amap.api.maps.model.animation;

import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.animation.GLAnimation;

public abstract class Animation {
    public static final int FILL_MODE_BACKWARDS = 1;
    public static final int FILL_MODE_FORWARDS = 0;
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int a;
    public GLAnimation glAnimation;

    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();
    }

    public Animation() {
        this.a = 0;
        this.glAnimation = null;
        this.glAnimation = new GLAnimation();
    }

    private void a(boolean z) {
        if (this.glAnimation != null) {
            this.glAnimation.setFillEnabled(z);
        }
    }

    private void b(boolean z) {
        if (this.glAnimation != null) {
            this.glAnimation.setFillAfter(z);
        }
    }

    private void c(boolean z) {
        if (this.glAnimation != null) {
            this.glAnimation.setFillBefore(z);
        }
    }

    public int getFillMode() {
        return this.a;
    }

    public int getRepeatCount() {
        return this.glAnimation != null ? this.glAnimation.getRepeatCount() : 0;
    }

    public int getRepeatMode() {
        return this.glAnimation != null ? this.glAnimation.getRepeatMode() : 1;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.glAnimation.setAnimationListener(animationListener);
    }

    public abstract void setDuration(long j);

    public void setFillMode(int i) {
        this.a = i;
        if (this.a == 0) {
            b(true);
            c(false);
            a(false);
            return;
        }
        b(false);
        a(true);
        c(true);
    }

    public abstract void setInterpolator(Interpolator interpolator);

    public void setRepeatCount(int i) {
        if (this.glAnimation != null) {
            this.glAnimation.setRepeatCount(i);
        }
    }

    public void setRepeatMode(int i) {
        if (this.glAnimation != null) {
            this.glAnimation.setRepeatMode(i);
        }
    }
}
