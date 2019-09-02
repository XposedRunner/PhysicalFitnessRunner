package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class k implements AnimatorListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public void onAnimationCancel(Animator animator) {
        if (this.a.d != null) {
            this.a.d.onAnimationCancel();
        }
    }

    public void onAnimationEnd(Animator animator) {
        if (this.a.d != null) {
            this.a.d.onAnimationEnd();
        }
    }

    public void onAnimationRepeat(Animator animator) {
        if (this.a.d != null) {
            this.a.d.onAnimationRepeat();
        }
    }

    public void onAnimationStart(Animator animator) {
        if (this.a.d != null) {
            this.a.d.onAnimationStart();
        }
    }
}
