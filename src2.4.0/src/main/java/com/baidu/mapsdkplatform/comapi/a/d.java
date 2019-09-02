package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import java.util.ArrayList;

public class d extends c {
    private Animator a = null;
    private long b = 0;
    private Interpolator c = null;
    private AnimationListener d = null;
    private int e = 0;
    private ArrayList<Animation> f = new ArrayList();

    @TargetApi(11)
    private ObjectAnimator b(Marker marker, Animation animation) {
        return animation instanceof AlphaAnimation ? ((a) animation.bdAnimation).a(marker) : animation instanceof RotateAnimation ? ((f) animation.bdAnimation).a(marker) : animation instanceof Transformation ? ((l) animation.bdAnimation).a(marker) : animation instanceof ScaleAnimation ? ((h) animation.bdAnimation).a(marker) : animation instanceof SingleScaleAnimation ? ((j) animation.bdAnimation).a(marker) : null;
    }

    @TargetApi(11)
    public void a() {
        if (this.a != null) {
            this.a.start();
        }
    }

    public void a(int i) {
    }

    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator != null) {
            animator.addListener(new e(this));
        }
    }

    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }

    public void a(AnimationListener animationListener) {
        this.d = animationListener;
    }

    public void a(Animation animation) {
        if (!this.f.contains(animation)) {
            this.f.add(animation);
        }
    }

    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        this.a = new AnimatorSet();
        ArrayList arrayList = this.f;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            Animation animation2 = (Animation) arrayList.get(i);
            if (animation2 != null) {
                ObjectAnimator b = b(marker, animation2);
                if (b != null) {
                    arrayList2.add(b);
                }
            }
        }
        if (this.b != 0) {
            this.a.setDuration(this.b);
        }
        if (this.c != null) {
            this.a.setInterpolator(this.c);
        }
        if (arrayList2.size() != 0) {
            if (this.e == 0) {
                ((AnimatorSet) this.a).playTogether(arrayList2);
            } else if (this.e == 1) {
                ((AnimatorSet) this.a).playSequentially(arrayList2);
            }
        }
        a(this.a);
    }

    @TargetApi(11)
    public void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    public void b(int i) {
    }

    public void c(int i) {
        this.e = i;
    }
}
