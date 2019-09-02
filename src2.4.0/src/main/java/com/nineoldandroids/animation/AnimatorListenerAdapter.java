package com.nineoldandroids.animation;

import com.nineoldandroids.animation.Animator.AnimatorListener;
import s.h.e.l.l.C;

public abstract class AnimatorListenerAdapter implements AnimatorListener {
    static {
        C.i(23);
    }

    public native void onAnimationCancel(Animator animator);

    public native void onAnimationEnd(Animator animator);

    public native void onAnimationRepeat(Animator animator);

    public native void onAnimationStart(Animator animator);
}
