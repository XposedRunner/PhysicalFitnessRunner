package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class e implements AnimatorListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
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
