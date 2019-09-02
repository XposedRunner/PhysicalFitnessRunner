package com.zjwh.android_wh_physicalfitness.view.shimmer;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: Shimmer */
public class O000000o {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    private static final long O00000o = 3000;
    private static final int O00000o0 = -1;
    private static final long O00000oO = 0;
    private static final int O00000oo = 0;
    private int O0000O0o = -1;
    private long O0000OOo = O00000o;
    private int O0000Oo = 0;
    private long O0000Oo0 = 0;
    private AnimatorListener O0000OoO;
    private ObjectAnimator O0000Ooo;

    public int O000000o() {
        return this.O0000O0o;
    }

    public O000000o O000000o(int i) {
        this.O0000O0o = i;
        return this;
    }

    public O000000o O000000o(long j) {
        this.O0000OOo = j;
        return this;
    }

    public O000000o O000000o(AnimatorListener animatorListener) {
        this.O0000OoO = animatorListener;
        return this;
    }

    public <V extends View & O00000Oo> void O000000o(final V v) {
        if (!O0000O0o()) {
            final AnonymousClass1 anonymousClass1 = new Runnable() {
                public void run() {
                    ((O00000Oo) v).setShimmering(true);
                    float width = (float) v.getWidth();
                    int O000000o = O000000o.this.O0000Oo;
                    float f = CropImageView.DEFAULT_ASPECT_RATIO;
                    if (O000000o == 1) {
                        width = (float) v.getWidth();
                    } else {
                        f = width;
                        width = 0.0f;
                    }
                    O000000o.this.O0000Ooo = ObjectAnimator.ofFloat(v, "gradientX", new float[]{width, f});
                    O000000o.this.O0000Ooo.setRepeatCount(O000000o.this.O0000O0o);
                    O000000o.this.O0000Ooo.setDuration(O000000o.this.O0000OOo);
                    O000000o.this.O0000Ooo.setStartDelay(O000000o.this.O0000Oo0);
                    O000000o.this.O0000Ooo.addListener(new AnimatorListener() {
                        public void onAnimationCancel(Animator animator) {
                        }

                        public void onAnimationEnd(Animator animator) {
                            ((O00000Oo) v).setShimmering(false);
                            v.postInvalidateOnAnimation();
                            O000000o.this.O0000Ooo = null;
                        }

                        public void onAnimationRepeat(Animator animator) {
                        }

                        public void onAnimationStart(Animator animator) {
                        }
                    });
                    if (O000000o.this.O0000OoO != null) {
                        O000000o.this.O0000Ooo.addListener(O000000o.this.O0000OoO);
                    }
                    O000000o.this.O0000Ooo.start();
                }
            };
            O00000Oo o00000Oo = (O00000Oo) v;
            if (o00000Oo.O00000Oo()) {
                anonymousClass1.run();
            } else {
                o00000Oo.setAnimationSetupCallback(new com.zjwh.android_wh_physicalfitness.view.shimmer.O00000o0.O000000o() {
                    public void O000000o(View view) {
                        anonymousClass1.run();
                    }
                });
            }
        }
    }

    public long O00000Oo() {
        return this.O0000OOo;
    }

    public O000000o O00000Oo(int i) {
        if (i == 0 || i == 1) {
            this.O0000Oo = i;
            return this;
        }
        throw new IllegalArgumentException("The animation direction must be either ANIMATION_DIRECTION_LTR or ANIMATION_DIRECTION_RTL");
    }

    public O000000o O00000Oo(long j) {
        this.O0000Oo0 = j;
        return this;
    }

    public int O00000o() {
        return this.O0000Oo;
    }

    public long O00000o0() {
        return this.O0000Oo0;
    }

    public AnimatorListener O00000oO() {
        return this.O0000OoO;
    }

    public void O00000oo() {
        if (this.O0000Ooo != null) {
            this.O0000Ooo.cancel();
        }
    }

    public boolean O0000O0o() {
        return this.O0000Ooo != null && this.O0000Ooo.isRunning();
    }
}
