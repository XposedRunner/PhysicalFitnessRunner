package android.support.design.widget;

import android.support.annotation.NonNull;
import android.view.animation.Interpolator;

class ValueAnimatorCompat {
    private final Impl mImpl;

    interface AnimatorUpdateListener {
        void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat);
    }

    interface AnimatorListener {
        void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat);

        void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat);
    }

    static class AnimatorListenerAdapter implements AnimatorListener {
        AnimatorListenerAdapter() {
        }

        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }
    }

    interface Creator {
        @NonNull
        ValueAnimatorCompat createAnimator();
    }

    static abstract class Impl {

        interface AnimatorUpdateListenerProxy {
            void onAnimationUpdate();
        }

        interface AnimatorListenerProxy {
            void onAnimationCancel();

            void onAnimationEnd();

            void onAnimationStart();
        }

        Impl() {
        }

        public abstract void addListener(AnimatorListenerProxy animatorListenerProxy);

        public abstract void addUpdateListener(AnimatorUpdateListenerProxy animatorUpdateListenerProxy);

        public abstract void cancel();

        public abstract void end();

        public abstract float getAnimatedFloatValue();

        public abstract float getAnimatedFraction();

        public abstract int getAnimatedIntValue();

        public abstract long getDuration();

        public abstract boolean isRunning();

        public abstract void setDuration(long j);

        public abstract void setFloatValues(float f, float f2);

        public abstract void setIntValues(int i, int i2);

        public abstract void setInterpolator(Interpolator interpolator);

        public abstract void start();
    }

    ValueAnimatorCompat(Impl impl) {
        this.mImpl = impl;
    }

    public void addListener(final AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mImpl.addListener(new AnimatorListenerProxy() {
                public void onAnimationCancel() {
                    animatorListener.onAnimationCancel(ValueAnimatorCompat.this);
                }

                public void onAnimationEnd() {
                    animatorListener.onAnimationEnd(ValueAnimatorCompat.this);
                }

                public void onAnimationStart() {
                    animatorListener.onAnimationStart(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.mImpl.addListener(null);
        }
    }

    public void addUpdateListener(final AnimatorUpdateListener animatorUpdateListener) {
        if (animatorUpdateListener != null) {
            this.mImpl.addUpdateListener(new AnimatorUpdateListenerProxy() {
                public void onAnimationUpdate() {
                    animatorUpdateListener.onAnimationUpdate(ValueAnimatorCompat.this);
                }
            });
        } else {
            this.mImpl.addUpdateListener(null);
        }
    }

    public void cancel() {
        this.mImpl.cancel();
    }

    public void end() {
        this.mImpl.end();
    }

    public float getAnimatedFloatValue() {
        return this.mImpl.getAnimatedFloatValue();
    }

    public float getAnimatedFraction() {
        return this.mImpl.getAnimatedFraction();
    }

    public int getAnimatedIntValue() {
        return this.mImpl.getAnimatedIntValue();
    }

    public long getDuration() {
        return this.mImpl.getDuration();
    }

    public boolean isRunning() {
        return this.mImpl.isRunning();
    }

    public void setDuration(long j) {
        this.mImpl.setDuration(j);
    }

    public void setFloatValues(float f, float f2) {
        this.mImpl.setFloatValues(f, f2);
    }

    public void setIntValues(int i, int i2) {
        this.mImpl.setIntValues(i, i2);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mImpl.setInterpolator(interpolator);
    }

    public void start() {
        this.mImpl.start();
    }
}
