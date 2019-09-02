package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapsdkplatform.comapi.a.d;

public class AnimationSet extends Animation {
    public AnimationSet() {
        this.bdAnimation = new d();
    }

    public void addAnimation(Animation animation) {
        if (animation != null) {
            ((d) this.bdAnimation).a(animation);
        }
    }

    public void cancel() {
        this.bdAnimation.b();
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.bdAnimation.a(animationListener);
    }

    public void setAnimatorSetMode(int i) {
        this.bdAnimation.c(i);
    }

    public void setDuration(long j) {
        this.bdAnimation.a(j);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.bdAnimation.a(interpolator);
    }
}
