package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.a.c;

public abstract class Animation {
    public c bdAnimation;

    public interface AnimationListener {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    public enum RepeatMode {
        RESTART,
        REVERSE
    }

    protected Animation() {
    }

    public abstract void cancel();

    public abstract void setAnimationListener(AnimationListener animationListener);

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);
}
