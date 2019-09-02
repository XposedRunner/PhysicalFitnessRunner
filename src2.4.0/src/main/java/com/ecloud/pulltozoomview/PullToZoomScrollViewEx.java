package com.ecloud.pulltozoomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class PullToZoomScrollViewEx extends PullToZoomBase<ScrollView> {
    private static final String O00000oo = "PullToZoomScrollViewEx";
    private static final Interpolator O0000o00 = new Interpolator() {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return 1.0f + (f * (((f * f) * f) * f));
        }
    };
    private boolean O0000O0o;
    private FrameLayout O0000OOo;
    private View O0000Oo;
    private LinearLayout O0000Oo0;
    private int O0000OoO;
    private O00000Oo O0000Ooo;

    protected interface O000000o {
        void O000000o(int i, int i2, int i3, int i4);
    }

    protected class InternalScrollView extends ScrollView {
        private O000000o O00000Oo;

        public InternalScrollView(PullToZoomScrollViewEx pullToZoomScrollViewEx, Context context) {
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
            if (PullToZoomScrollViewEx.this.O00000o0 != null) {
                this.O00000o = SystemClock.currentThreadTimeMillis();
                this.O000000o = j;
                this.O00000o0 = ((float) PullToZoomScrollViewEx.this.O0000OOo.getBottom()) / ((float) PullToZoomScrollViewEx.this.O0000OoO);
                this.O00000Oo = false;
                PullToZoomScrollViewEx.this.post(this);
            }
        }

        public boolean O00000Oo() {
            return this.O00000Oo;
        }

        public void run() {
            if (!(PullToZoomScrollViewEx.this.O00000o0 == null || this.O00000Oo || ((double) this.O00000o0) <= 1.0d)) {
                float interpolation = this.O00000o0 - ((this.O00000o0 - 1.0f) * PullToZoomScrollViewEx.O0000o00.getInterpolation((((float) SystemClock.currentThreadTimeMillis()) - ((float) this.O00000o)) / ((float) this.O000000o)));
                LayoutParams layoutParams = PullToZoomScrollViewEx.this.O0000OOo.getLayoutParams();
                String O0000O0o = PullToZoomScrollViewEx.O00000oo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ScalingRunnable --> f2 = ");
                stringBuilder.append(interpolation);
                Log.d(O0000O0o, stringBuilder.toString());
                if (interpolation > 1.0f) {
                    layoutParams.height = (int) (((float) PullToZoomScrollViewEx.this.O0000OoO) * interpolation);
                    PullToZoomScrollViewEx.this.O0000OOo.setLayoutParams(layoutParams);
                    if (PullToZoomScrollViewEx.this.O0000O0o) {
                        layoutParams = PullToZoomScrollViewEx.this.O00000o0.getLayoutParams();
                        layoutParams.height = (int) (interpolation * ((float) PullToZoomScrollViewEx.this.O0000OoO));
                        PullToZoomScrollViewEx.this.O00000o0.setLayoutParams(layoutParams);
                    }
                    PullToZoomScrollViewEx.this.post(this);
                    return;
                }
                this.O00000Oo = true;
            }
        }
    }

    public PullToZoomScrollViewEx(Context context) {
        this(context, null);
    }

    public PullToZoomScrollViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000O0o = false;
        this.O0000Ooo = new O00000Oo();
        ((InternalScrollView) this.O000000o).setOnScrollViewChangedListener(new O000000o() {
            public void O000000o(int i, int i2, int i3, int i4) {
                if (PullToZoomScrollViewEx.this.O000000o() && PullToZoomScrollViewEx.this.O00000o0()) {
                    String O0000O0o = PullToZoomScrollViewEx.O00000oo;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onScrollChanged --> getScrollY() = ");
                    stringBuilder.append(((ScrollView) PullToZoomScrollViewEx.this.O000000o).getScrollY());
                    Log.d(O0000O0o, stringBuilder.toString());
                    float O000000o = (float) ((PullToZoomScrollViewEx.this.O0000OoO - PullToZoomScrollViewEx.this.O0000OOo.getBottom()) + ((ScrollView) PullToZoomScrollViewEx.this.O000000o).getScrollY());
                    String O0000O0o2 = PullToZoomScrollViewEx.O00000oo;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("onScrollChanged --> f = ");
                    stringBuilder2.append(O000000o);
                    Log.d(O0000O0o2, stringBuilder2.toString());
                    if (O000000o > 0.0f && O000000o < ((float) PullToZoomScrollViewEx.this.O0000OoO)) {
                        PullToZoomScrollViewEx.this.O0000OOo.scrollTo(0, -((int) (0.65d * ((double) O000000o))));
                    } else if (PullToZoomScrollViewEx.this.O0000OOo.getScrollY() != 0) {
                        PullToZoomScrollViewEx.this.O0000OOo.scrollTo(0, 0);
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
        String str = O00000oo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pullHeaderToZoom --> newScrollValue = ");
        stringBuilder.append(i);
        Log.d(str, stringBuilder.toString());
        str = O00000oo;
        stringBuilder = new StringBuilder();
        stringBuilder.append("pullHeaderToZoom --> mHeaderHeight = ");
        stringBuilder.append(this.O0000OoO);
        Log.d(str, stringBuilder.toString());
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
        this.O0000Oo0 = new LinearLayout(getContext());
        this.O0000Oo0.setOrientation(1);
        this.O0000OOo = new FrameLayout(getContext());
        if (this.O00000o0 != null) {
            this.O0000OOo.addView(this.O00000o0);
        }
        if (this.O00000Oo != null) {
            this.O0000OOo.addView(this.O00000Oo);
        }
        int resourceId = typedArray.getResourceId(R.styleable.PullToZoomView_contentView, 0);
        if (resourceId > 0) {
            this.O0000Oo = LayoutInflater.from(getContext()).inflate(resourceId, null, false);
        }
        this.O0000Oo0.addView(this.O0000OOo);
        if (this.O0000Oo != null) {
            this.O0000Oo0.addView(this.O0000Oo);
        }
        this.O0000Oo0.setClipChildren(false);
        this.O0000OOo.setClipChildren(false);
        ((ScrollView) this.O000000o).addView(this.O0000Oo0);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O00000Oo */
    public ScrollView O000000o(Context context, AttributeSet attributeSet) {
        InternalScrollView internalScrollView = new InternalScrollView(context, attributeSet);
        internalScrollView.setId(R.id.scrollview);
        return internalScrollView;
    }

    /* Access modifiers changed, original: protected */
    public void O00000oO() {
        Log.d(O00000oo, "smoothScrollToTop --> ");
        this.O0000Ooo.O000000o(200);
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oo() {
        return ((ScrollView) this.O000000o).getScrollY() == 0;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Log.d(O00000oo, "onLayout --> ");
        if (this.O0000OoO == 0 && this.O00000o0 != null) {
            this.O0000OoO = this.O0000OOo.getHeight();
        }
    }

    public void setHeaderLayoutParams(LinearLayout.LayoutParams layoutParams) {
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
