package com.mcxtzhang.swipemenulib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;

public class SwipeMenuLayout extends ViewGroup {
    private static final String O000000o = "zxt";
    private static boolean O0000o0;
    private static SwipeMenuLayout O0000o00;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private View O0000OOo;
    private boolean O0000Oo;
    private PointF O0000Oo0;
    private PointF O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o;
    private VelocityTracker O0000o0O;
    private Log O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private boolean O0000oOO;
    private ValueAnimator O0000oOo;
    private boolean O0000oo;
    private ValueAnimator O0000oo0;

    public SwipeMenuLayout(Context context) {
        this(context, null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = new PointF();
        this.O0000Oo = true;
        this.O0000OoO = new PointF();
        O000000o(context, attributeSet, i);
    }

    private void O000000o(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                if (marginLayoutParams.height == -1) {
                    int i4 = marginLayoutParams.width;
                    marginLayoutParams.width = childAt.getMeasuredWidth();
                    measureChildWithMargins(childAt, i2, 0, makeMeasureSpec, 0);
                    marginLayoutParams.width = i4;
                }
            }
        }
    }

    private void O000000o(Context context, AttributeSet attributeSet, int i) {
        this.O00000Oo = ViewConfiguration.get(context).getScaledTouchSlop();
        this.O00000o0 = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.O0000o = true;
        this.O0000oO0 = true;
        this.O0000oOO = true;
        int i2 = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout, i, 0);
        int indexCount = obtainStyledAttributes.getIndexCount();
        while (i2 < indexCount) {
            i = obtainStyledAttributes.getIndex(i2);
            if (i == R.styleable.SwipeMenuLayout_swipeEnable) {
                this.O0000o = obtainStyledAttributes.getBoolean(i, true);
            } else if (i == R.styleable.SwipeMenuLayout_ios) {
                this.O0000oO0 = obtainStyledAttributes.getBoolean(i, true);
            } else if (i == R.styleable.SwipeMenuLayout_leftSwipe) {
                this.O0000oOO = obtainStyledAttributes.getBoolean(i, true);
            }
            i2++;
        }
        obtainStyledAttributes.recycle();
    }

    private void O000000o(MotionEvent motionEvent) {
        if (this.O0000o0O == null) {
            this.O0000o0O = VelocityTracker.obtain();
        }
        this.O0000o0O.addMovement(motionEvent);
    }

    private void O0000O0o() {
        if (this.O0000o0O != null) {
            this.O0000o0O.clear();
            this.O0000o0O.recycle();
            this.O0000o0O = null;
        }
    }

    public static SwipeMenuLayout getViewCache() {
        return O0000o00;
    }

    public SwipeMenuLayout O000000o(boolean z) {
        this.O0000oO0 = z;
        return this;
    }

    public boolean O000000o() {
        return this.O0000o;
    }

    public SwipeMenuLayout O00000Oo(boolean z) {
        this.O0000oOO = z;
        return this;
    }

    public boolean O00000Oo() {
        return this.O0000oO0;
    }

    public void O00000o() {
        O0000o00 = this;
        if (this.O0000OOo != null) {
            this.O0000OOo.setLongClickable(false);
        }
        if (this.O0000oo0 != null && this.O0000oo0.isRunning()) {
            this.O0000oo0.cancel();
        }
        int[] iArr = new int[2];
        iArr[0] = getScrollX();
        iArr[1] = this.O0000oOO ? this.O00000oo : -this.O00000oo;
        this.O0000oOo = ValueAnimator.ofInt(iArr);
        this.O0000oOo.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.O0000oOo.setInterpolator(new OvershootInterpolator());
        this.O0000oOo.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SwipeMenuLayout.this.O0000oo = true;
            }
        });
        this.O0000oOo.setDuration(300).start();
    }

    public boolean O00000o0() {
        return this.O0000oOO;
    }

    public void O00000oO() {
        O0000o00 = null;
        if (this.O0000OOo != null) {
            this.O0000OOo.setLongClickable(true);
        }
        if (this.O0000oOo != null && this.O0000oOo.isRunning()) {
            this.O0000oOo.cancel();
        }
        this.O0000oo0 = ValueAnimator.ofInt(new int[]{getScrollX(), 0});
        this.O0000oo0.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SwipeMenuLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        });
        this.O0000oo0.setInterpolator(new AccelerateInterpolator());
        this.O0000oo0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SwipeMenuLayout.this.O0000oo = false;
            }
        });
        this.O0000oo0.setDuration(300).start();
    }

    public void O00000oo() {
        if (this == O0000o00) {
            if (this.O0000oOo != null && this.O0000oOo.isRunning()) {
                this.O0000oOo.cancel();
            }
            O0000o00.scrollTo(0, 0);
            O0000o00 = null;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.O0000o) {
            O000000o(motionEvent);
            VelocityTracker velocityTracker = this.O0000o0O;
            float xVelocity;
            switch (motionEvent.getAction()) {
                case 0:
                    this.O0000Ooo = false;
                    this.O0000Oo = true;
                    this.O0000oO = false;
                    if (!O0000o0) {
                        O0000o0 = true;
                        this.O0000Oo0.set(motionEvent.getRawX(), motionEvent.getRawY());
                        this.O0000OoO.set(motionEvent.getRawX(), motionEvent.getRawY());
                        if (O0000o00 != null) {
                            if (O0000o00 != this) {
                                O0000o00.O00000oO();
                                this.O0000oO = this.O0000oO0;
                            }
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        this.O00000o = motionEvent.getPointerId(0);
                        break;
                    }
                    return false;
                case 1:
                case 3:
                    if (Math.abs(motionEvent.getRawX() - this.O0000OoO.x) > ((float) this.O00000Oo)) {
                        this.O0000Ooo = true;
                    }
                    if (!this.O0000oO) {
                        velocityTracker.computeCurrentVelocity(1000, (float) this.O00000o0);
                        xVelocity = velocityTracker.getXVelocity(this.O00000o);
                        if (Math.abs(xVelocity) > 1000.0f) {
                            if (xVelocity < -1000.0f) {
                                if (this.O0000oOO) {
                                    O00000o();
                                } else {
                                    O00000oO();
                                }
                            } else if (this.O0000oOO) {
                                O00000oO();
                            } else {
                                O00000o();
                            }
                        } else if (Math.abs(getScrollX()) > this.O0000O0o) {
                            O00000o();
                        } else {
                            O00000oO();
                        }
                    }
                    O0000O0o();
                    O0000o0 = false;
                    break;
                case 2:
                    if (!this.O0000oO) {
                        xVelocity = this.O0000Oo0.x - motionEvent.getRawX();
                        if (Math.abs(xVelocity) > 10.0f || Math.abs(getScrollX()) > 10) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        if (Math.abs(xVelocity) > ((float) this.O00000Oo)) {
                            this.O0000Oo = false;
                        }
                        scrollBy((int) xVelocity, 0);
                        if (this.O0000oOO) {
                            if (getScrollX() < 0) {
                                scrollTo(0, 0);
                            }
                            if (getScrollX() > this.O00000oo) {
                                scrollTo(this.O00000oo, 0);
                            }
                        } else {
                            if (getScrollX() < (-this.O00000oo)) {
                                scrollTo(-this.O00000oo, 0);
                            }
                            if (getScrollX() > 0) {
                                scrollTo(0, 0);
                            }
                        }
                        this.O0000Oo0.set(motionEvent.getRawX(), motionEvent.getRawY());
                        break;
                    }
                    break;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        if (this == O0000o00) {
            O0000o00.O00000oO();
            O0000o00 = null;
        }
        super.onDetachedFromWindow();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (this.O0000oOO) {
                    if (getScrollX() > this.O00000Oo && motionEvent.getX() < ((float) (getWidth() - getScrollX()))) {
                        if (this.O0000Oo) {
                            O00000oO();
                        }
                        return true;
                    }
                } else if ((-getScrollX()) > this.O00000Oo && motionEvent.getX() > ((float) (-getScrollX()))) {
                    if (this.O0000Oo) {
                        O00000oO();
                    }
                    return true;
                }
                if (this.O0000Ooo) {
                    return true;
                }
                break;
            case 2:
                if (Math.abs(motionEvent.getRawX() - this.O0000OoO.x) > ((float) this.O00000Oo)) {
                    return true;
                }
                break;
        }
        return this.O0000oO ? true : super.onInterceptTouchEvent(motionEvent);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        i2 = 0;
        i = getPaddingLeft() + 0;
        i3 = getPaddingLeft() + 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                if (i2 == 0) {
                    childAt.layout(i, getPaddingTop(), childAt.getMeasuredWidth() + i, getPaddingTop() + childAt.getMeasuredHeight());
                    i += childAt.getMeasuredWidth();
                } else if (this.O0000oOO) {
                    childAt.layout(i, getPaddingTop(), childAt.getMeasuredWidth() + i, getPaddingTop() + childAt.getMeasuredHeight());
                    i += childAt.getMeasuredWidth();
                } else {
                    childAt.layout(i3 - childAt.getMeasuredWidth(), getPaddingTop(), i3, getPaddingTop() + childAt.getMeasuredHeight());
                    i3 -= childAt.getMeasuredWidth();
                }
            }
            i2++;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setClickable(true);
        int i3 = 0;
        this.O00000oo = 0;
        int childCount = getChildCount();
        boolean z = MeasureSpec.getMode(i2) != 1073741824;
        int i4 = 0;
        int i5 = i4;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
                this.O00000oO = Math.max(this.O00000oO, childAt.getMeasuredHeight());
                if (z && marginLayoutParams.height == -1) {
                    i5 = true;
                }
                if (i3 > 0) {
                    this.O00000oo += childAt.getMeasuredWidth();
                } else {
                    this.O0000OOo = childAt;
                    i4 = childAt.getMeasuredWidth();
                }
            }
            i3++;
        }
        setMeasuredDimension((getPaddingLeft() + getPaddingRight()) + i4, (this.O00000oO + getPaddingTop()) + getPaddingBottom());
        this.O0000O0o = (this.O00000oo * 4) / 10;
        if (i5 != 0) {
            O000000o(childCount, i);
        }
    }

    public boolean performLongClick() {
        return Math.abs(getScrollX()) > this.O00000Oo ? false : super.performLongClick();
    }

    public void setSwipeEnable(boolean z) {
        this.O0000o = z;
    }
}
