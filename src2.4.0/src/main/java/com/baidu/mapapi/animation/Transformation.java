package com.baidu.mapapi.animation;

import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.animation.Animation.RepeatMode;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.l;

public class Transformation extends Animation {
    public Transformation(Point... pointArr) {
        if (pointArr == null || pointArr.length == 0) {
            throw new NullPointerException("the points is null");
        }
        this.bdAnimation = new l(pointArr);
    }

    public Transformation(LatLng... latLngArr) {
        if (latLngArr == null || latLngArr.length == 0) {
            throw new NullPointerException("the latlngs is null");
        }
        this.bdAnimation = new l(latLngArr);
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
