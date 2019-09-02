package com.zjwh.android_wh_physicalfitness.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

public class HomepageAppbarZoomBehavior extends Behavior {
    private static final float O00000oo = 2000.0f;
    private View O000000o;
    private View O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private float O0000O0o;
    private float O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private ValueAnimator O0000OoO;
    private ValueAnimator O0000Ooo;
    private float O0000o00;

    public HomepageAppbarZoomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void O000000o(AppBarLayout appBarLayout) {
        appBarLayout.setClipChildren(false);
        this.O00000o0 = appBarLayout.getHeight();
        this.O000000o = appBarLayout.findViewById(R.id.iv_layout);
        this.O00000Oo = appBarLayout.findViewById(R.id.rlPersonalInfo);
        this.O00000oO = this.O00000Oo.getTop();
        if (this.O000000o != null) {
            this.O00000o = this.O000000o.getHeight();
        }
    }

    private void O000000o(AppBarLayout appBarLayout, int i) {
        this.O0000O0o += (float) (-i);
        this.O0000O0o = Math.min(this.O0000O0o, O00000oo);
        this.O0000OOo = Math.max(1.0f, (this.O0000O0o / O00000oo) + 1.0f);
        ViewCompat.setScaleX(this.O000000o, this.O0000OOo);
        ViewCompat.setScaleY(this.O000000o, this.O0000OOo);
        this.O0000Oo0 = this.O00000o0 + ((int) (((float) (this.O00000o / 2)) * (this.O0000OOo - 1.0f)));
        ViewCompat.offsetTopAndBottom(this.O00000Oo, (this.O0000Oo0 - this.O00000o0) - this.O0000Oo);
        appBarLayout.setBottom(this.O0000Oo0);
        this.O0000Oo = this.O0000Oo0 - this.O00000o0;
    }

    private void O00000Oo(final AppBarLayout appBarLayout) {
        if (this.O0000O0o > CropImageView.DEFAULT_ASPECT_RATIO) {
            this.O0000O0o = CropImageView.DEFAULT_ASPECT_RATIO;
            this.O0000Oo = 0;
            this.O0000OoO = ValueAnimator.ofFloat(new float[]{this.O0000OOo, 1.0f}).setDuration(220);
            this.O0000OoO.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewCompat.setScaleX(HomepageAppbarZoomBehavior.this.O000000o, floatValue);
                    ViewCompat.setScaleY(HomepageAppbarZoomBehavior.this.O000000o, floatValue);
                    appBarLayout.setBottom((int) (((float) HomepageAppbarZoomBehavior.this.O0000Oo0) - (((float) (HomepageAppbarZoomBehavior.this.O0000Oo0 - HomepageAppbarZoomBehavior.this.O00000o0)) * valueAnimator.getAnimatedFraction())));
                }
            });
            this.O0000o00 = (float) this.O00000Oo.getTop();
            this.O0000OoO.start();
            this.O0000Ooo = ValueAnimator.ofFloat(new float[]{(float) this.O00000Oo.getTop(), (float) this.O00000oO}).setDuration(220);
            this.O0000Ooo.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ViewCompat.offsetTopAndBottom(HomepageAppbarZoomBehavior.this.O00000Oo, (int) (floatValue - HomepageAppbarZoomBehavior.this.O0000o00));
                    HomepageAppbarZoomBehavior.this.O0000o00 = floatValue;
                }
            });
            this.O0000Ooo.start();
        }
    }

    /* renamed from: O000000o */
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2) {
        return this.O000000o.getScaleY() > 1.0f || super.onNestedPreFling(coordinatorLayout, appBarLayout, view, f, f2);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        O000000o(appBarLayout);
        return onLayoutChild;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
        if (this.O000000o != null && appBarLayout.getBottom() >= this.O00000o0 && i2 < 0) {
            O000000o(appBarLayout, i2);
        } else if (this.O000000o != null && appBarLayout.getBottom() > this.O00000o0 && i2 > 0) {
            iArr[1] = i2;
            O000000o(appBarLayout, i2);
        } else if (this.O0000OoO == null || !this.O0000OoO.isRunning()) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i, i2, iArr);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
        return true;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
        O00000Oo(appBarLayout);
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view);
    }
}
