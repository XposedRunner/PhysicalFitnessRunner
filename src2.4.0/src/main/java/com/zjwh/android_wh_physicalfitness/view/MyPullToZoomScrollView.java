package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.ecloud.pulltozoomview.PullToZoomBase;
import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;

public class MyPullToZoomScrollView extends PullToZoomBase<NestedScrollView> {
    private static final String O00000oo = PullToZoomScrollViewEx.class.getSimpleName();
    private static final Interpolator O0000o00 = new Interpolator() {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return 1.0f + (f * (((f * f) * f) * f));
        }
    };
    private boolean O0000O0o;
    private FrameLayout O0000OOo;
    private View O0000Oo;
    private RelativeLayout O0000Oo0;
    private int O0000OoO;
    private O00000Oo O0000Ooo;

    protected interface O000000o {
        void O000000o(int i, int i2, int i3, int i4);
    }

    protected class InternalScrollView extends NestedScrollView {
        private O000000o O00000Oo;

        public InternalScrollView(MyPullToZoomScrollView myPullToZoomScrollView, Context context) {
            this(context, null);
        }

        public InternalScrollView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* Access modifiers changed, original: protected */
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.O00000Oo != null) {
                this.O00000Oo.O000000o(i, i2, i3, i4);
            }
        }

        public void setOnScrollViewChangedListener(O000000o o000000o) {
            this.O00000Oo = o000000o;
        }
    }

    class O00000Oo implements Runnable {
        protected long O000000o;
        protected boolean O00000Oo = true;
        protected long O00000o;
        protected float O00000o0;

        O00000Oo() {
        }

        public void O000000o() {
            this.O00000Oo = true;
        }

        public void O000000o(long j) {
            if (MyPullToZoomScrollView.this.O00000o0 != null) {
                this.O00000o = SystemClock.currentThreadTimeMillis();
                this.O000000o = j;
                this.O00000o0 = ((float) MyPullToZoomScrollView.this.O0000OOo.getBottom()) / ((float) MyPullToZoomScrollView.this.O0000OoO);
                this.O00000Oo = false;
                MyPullToZoomScrollView.this.post(this);
            }
        }

        public boolean O00000Oo() {
            return this.O00000Oo;
        }

        public void run() {
            if (!(MyPullToZoomScrollView.this.O00000o0 == null || this.O00000Oo || ((double) this.O00000o0) <= 1.0d)) {
                float interpolation = this.O00000o0 - ((this.O00000o0 - 1.0f) * MyPullToZoomScrollView.O0000o00.getInterpolation((((float) SystemClock.currentThreadTimeMillis()) - ((float) this.O00000o)) / ((float) this.O000000o)));
                LayoutParams layoutParams = MyPullToZoomScrollView.this.O0000OOo.getLayoutParams();
                String O0000OOo = MyPullToZoomScrollView.O00000oo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ScalingRunnable --> f2 = ");
                stringBuilder.append(interpolation);
                Log.d(O0000OOo, stringBuilder.toString());
                if (interpolation > 1.0f) {
                    layoutParams.height = (int) (((float) MyPullToZoomScrollView.this.O0000OoO) * interpolation);
                    MyPullToZoomScrollView.this.O0000OOo.setLayoutParams(layoutParams);
                    if (MyPullToZoomScrollView.this.O0000O0o) {
                        layoutParams = MyPullToZoomScrollView.this.O00000o0.getLayoutParams();
                        layoutParams.height = (int) (interpolation * ((float) MyPullToZoomScrollView.this.O0000OoO));
                        MyPullToZoomScrollView.this.O00000o0.setLayoutParams(layoutParams);
                    }
                    MyPullToZoomScrollView.this.post(this);
                    return;
                }
                this.O00000Oo = true;
            }
        }
    }

    public MyPullToZoomScrollView(Context context) {
        this(context, null);
    }

    public MyPullToZoomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000O0o = false;
        this.O0000Ooo = new O00000Oo();
        ((InternalScrollView) this.O000000o).setOnScrollViewChangedListener(new O000000o() {
            public void O000000o(int i, int i2, int i3, int i4) {
                if (MyPullToZoomScrollView.this.O000000o() && MyPullToZoomScrollView.this.O00000o0()) {
                    float O000000o = (float) ((MyPullToZoomScrollView.this.O0000OoO - MyPullToZoomScrollView.this.O0000OOo.getBottom()) + ((NestedScrollView) MyPullToZoomScrollView.this.O000000o).getScrollY());
                    if (O000000o > CropImageView.DEFAULT_ASPECT_RATIO && O000000o < ((float) MyPullToZoomScrollView.this.O0000OoO)) {
                        MyPullToZoomScrollView.this.O0000OOo.scrollTo(0, -((int) (0.65d * ((double) O000000o))));
                    } else if (MyPullToZoomScrollView.this.O0000OOo.getScrollY() != 0) {
                        MyPullToZoomScrollView.this.O0000OOo.scrollTo(0, 0);
                    }
                }
            }
        });
    }

    private void O0000Oo0() {
        if (this.O0000OOo != null) {
            this.O0000OOo.removeAllViews();
            if (this.O00000o0 != null) {
                this.O0000OOo.addView(this.O00000o0);
            }
            if (this.O00000Oo != null) {
                this.O0000OOo.addView(this.O00000Oo);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(int i) {
        if (!(this.O0000Ooo == null || this.O0000Ooo.O00000Oo())) {
            this.O0000Ooo.O000000o();
        }
        LayoutParams layoutParams = this.O0000OOo.getLayoutParams();
        layoutParams.height = Math.abs(i) + this.O0000OoO;
        this.O0000OOo.setLayoutParams(layoutParams);
        if (this.O0000O0o) {
            layoutParams = this.O00000o0.getLayoutParams();
            layoutParams.height = Math.abs(i) + this.O0000OoO;
            this.O00000o0.setLayoutParams(layoutParams);
        }
    }

    public void O000000o(int i, int i2) {
        if (this.O0000OOo != null) {
            LayoutParams layoutParams = this.O0000OOo.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(i, i2);
            }
            layoutParams = layoutParams;
            layoutParams.width = i;
            layoutParams.height = i2;
            this.O0000OOo.setLayoutParams(layoutParams);
            this.O0000OoO = i2;
            this.O0000O0o = true;
        }
    }

    public void O000000o(TypedArray typedArray) {
        this.O0000Oo0 = new RelativeLayout(getContext());
        this.O0000OOo = new FrameLayout(getContext());
        if (this.O00000o0 != null) {
            this.O0000OOo.addView(this.O00000o0);
        }
        if (this.O00000Oo != null) {
            this.O0000OOo.addView(this.O00000Oo);
        }
        int resourceId = typedArray.getResourceId(0, 0);
        if (resourceId > 0) {
            this.O0000Oo = LayoutInflater.from(getContext()).inflate(resourceId, null, false);
        }
        this.O0000OOo.setId(R.id.pull_to_zoom_header);
        this.O0000OOo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.O0000Oo0.addView(this.O0000OOo);
        if (this.O0000Oo != null) {
            this.O0000Oo.setId(R.id.pull_to_zoom_content);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.O0000Oo.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            layoutParams.addRule(3, R.id.pull_to_zoom_header);
            this.O0000Oo.setLayoutParams(layoutParams);
            this.O0000Oo0.addView(this.O0000Oo);
        }
        this.O0000Oo0.setClipChildren(false);
        this.O0000OOo.setClipChildren(false);
        ((NestedScrollView) this.O000000o).addView(this.O0000Oo0);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O00000Oo */
    public NestedScrollView O000000o(Context context, AttributeSet attributeSet) {
        InternalScrollView internalScrollView = new InternalScrollView(context, attributeSet);
        internalScrollView.setId(R.id.scrollview);
        internalScrollView.setFillViewport(true);
        return internalScrollView;
    }

    /* Access modifiers changed, original: protected */
    public void O00000oO() {
        this.O0000Ooo.O000000o(200);
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oo() {
        return ((NestedScrollView) this.O000000o).getScrollY() == 0;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.O0000OoO == 0 && this.O00000o0 != null) {
            this.O0000OoO = this.O0000OOo.getHeight();
        }
    }

    public void setHeaderLayoutParams(RelativeLayout.LayoutParams layoutParams) {
        if (this.O0000OOo != null) {
            this.O0000OOo.setLayoutParams(layoutParams);
            this.O0000OoO = layoutParams.height;
            this.O0000O0o = true;
        }
    }

    public void setHeaderView(View view) {
        if (view != null) {
            this.O00000Oo = view;
            O0000Oo0();
        }
    }

    public void setHideHeader(boolean z) {
        if (z != O00000o() && this.O0000OOo != null) {
            super.setHideHeader(z);
            if (z) {
                this.O0000OOo.setVisibility(8);
            } else {
                this.O0000OOo.setVisibility(0);
            }
        }
    }

    public void setScrollContentView(View view) {
        if (view != null) {
            if (this.O0000Oo != null) {
                this.O0000Oo0.removeView(this.O0000Oo);
            }
            this.O0000Oo = view;
            this.O0000Oo0.addView(this.O0000Oo);
        }
    }

    public void setZoomView(View view) {
        if (view != null) {
            this.O00000o0 = view;
            O0000Oo0();
        }
    }
}
