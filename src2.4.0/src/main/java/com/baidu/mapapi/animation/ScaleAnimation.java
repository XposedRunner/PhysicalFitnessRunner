package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.animation.Animation.RepeatMode;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.h;

public class ScaleAnimation extends Animation {
    public ScaleAnimation(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("the scales is null");
        }
        this.bdAnimation = new h(fArr);
    }

    public void cancel() {
        this.bdAnimation.b();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.bdAnimation.a(animationListener);
    }

    public void setDuration(long j) {
        this.bdAnimation.a(j);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.bdAnimation.a(interpolator);
    }

    public void setRepeatCount(int i) {
        this.bdAnimation.b(i);
    }

    public void setRepeatMode(RepeatMode repeatMode) {
        c cVar;
        int i;
        if (repeatMode == RepeatMode.RESTART) {
            cVar = this.bdAnimation;
            i = 1;
        } else if (repeatMode == RepeatMode.REVERSE) {
            cVar = this.bdAnimation;
            i = 2;
        } else {
            return;
        }
        cVar.a(i);
    }
}
