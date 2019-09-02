package com.ecloud.pulltozoomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class PullToZoomListViewEx extends PullToZoomBase<ListView> implements OnScrollListener {
    private static final String O00000oo = "PullToZoomListViewEx";
    private static final Interpolator O0000Oo = new Interpolator() {
        public float getInterpolation(float f) {
            f -= 1.0f;
            return 1.0f + (f * (((f * f) * f) * f));
        }
    };
    private FrameLayout O0000O0o;
    private int O0000OOo;
    private O000000o O0000Oo0;

    class O000000o implements Runnable {
        protected long O000000o;
        protected boolean O00000Oo = true;
        protected long O00000o;
        protected float O00000o0;

        O000000o() {
        }

        public void O000000o() {
            this.O00000Oo = true;
        }

        public void O000000o(long j) {
            if (PullToZoomListViewEx.this.O00000o0 != null) {
                this.O00000o = SystemClock.currentThreadTimeMillis();
                this.O000000o = j;
                this.O00000o0 = ((float) PullToZoomListViewEx.this.O0000O0o.getBottom()) / ((float) PullToZoomListViewEx.this.O0000OOo);
                this.O00000Oo = false;
                PullToZoomListViewEx.this.post(this);
            }
        }

        public boolean O00000Oo() {
            return this.O00000Oo;
        }

        public void run() {
            if (!(PullToZoomListViewEx.this.O00000o0 == null || this.O00000Oo || ((double) this.O00000o0) <= 1.0d)) {
                float interpolation = this.O00000o0 - ((this.O00000o0 - 1.0f) * PullToZoomListViewEx.O0000Oo.getInterpolation((((float) SystemClock.currentThreadTimeMillis()) - ((float) this.O00000o)) / ((float) this.O000000o)));
                LayoutParams layoutParams = PullToZoomListViewEx.this.O0000O0o.getLayoutParams();
                String O0000OOo = PullToZoomListViewEx.O00000oo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ScalingRunnable --> f2 = ");
                stringBuilder.append(interpolation);
                Log.d(O0000OOo, stringBuilder.toString());
                if (interpolation > 1.0f) {
                    layoutParams.height = (int) (interpolation * ((float) PullToZoomListViewEx.this.O0000OOo));
                    PullToZoomListViewEx.this.O0000O0o.setLayoutParams(layoutParams);
                    PullToZoomListViewEx.this.post(this);
                    return;
                }
                this.O00000Oo = true;
            }
        }
    }

    public PullToZoomListViewEx(Context context) {
        this(context, null);
    }

    public PullToZoomListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((ListView) this.O000000o).setOnScrollListener(this);
        this.O0000Oo0 = new O000000o();
    }

    private void O0000Oo() {
        if (this.O0000O0o != null) {
            ((ListView) this.O000000o).removeHeaderView(this.O0000O0o);
            this.O0000O0o.removeAllViews();
            if (this.O00000o0 != null) {
                this.O0000O0o.addView(this.O00000o0);
            }
            if (this.O00000Oo != null) {
                this.O0000O0o.addView(this.O00000Oo);
            }
            this.O0000OOo = this.O0000O0o.getHeight();
            ((ListView) this.O000000o).addHeaderView(this.O0000O0o);
        }
    }

    private void O0000Oo0() {
        if (this.O0000O0o != null) {
            ((ListView) this.O000000o).removeHeaderView(this.O0000O0o);
        }
    }

    private boolean O0000OoO() {
        ListAdapter adapter = ((ListView) this.O000000o).getAdapter();
        boolean z = true;
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        if (((ListView) this.O000000o).getFirstVisiblePosition() <= 1) {
            View childAt = ((ListView) this.O000000o).getChildAt(0);
            if (childAt != null) {
                if (childAt.getTop() < ((ListView) this.O000000o).getTop()) {
                    z = false;
                }
                return z;
            }
        }
        return false;
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
        stringBuilder.append(this.O0000OOo);
        Log.d(str, stringBuilder.toString());
        if (!(this.O0000Oo0 == null || this.O0000Oo0.O00000Oo())) {
            this.O0000Oo0.O000000o();
        }
        LayoutParams layoutParams = this.O0000O0o.getLayoutParams();
        layoutParams.height = Math.abs(i) + this.O0000OOo;
        this.O0000O0o.setLayoutParams(layoutParams);
    }

    public void O000000o(int i, int i2) {
        if (this.O0000O0o != null) {
            LayoutParams layoutParams = this.O0000O0o.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(i, i2);
            }
            layoutParams = layoutParams;
            layoutParams.width = i;
            layoutParams.height = i2;
            this.O0000O0o.setLayoutParams(layoutParams);
            this.O0000OOo = i2;
        }
    }

    public void O000000o(TypedArray typedArray) {
        this.O0000O0o = new FrameLayout(getContext());
        if (this.O00000o0 != null) {
            this.O0000O0o.addView(this.O00000o0);
        }
        if (this.O00000Oo != null) {
            this.O0000O0o.addView(this.O00000Oo);
        }
        ((ListView) this.O000000o).addHeaderView(this.O0000O0o);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O00000Oo */
    public ListView O000000o(Context context, AttributeSet attributeSet) {
        ListView listView = new ListView(context, attributeSet);
        listView.setId(16908298);
        return listView;
    }

    /* Access modifiers changed, original: protected */
    public void O00000oO() {
        Log.d(O00000oo, "smoothScrollToTop --> ");
        this.O0000Oo0.O000000o(200);
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oo() {
        return O0000OoO();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Log.d(O00000oo, "onLayout --> ");
        if (this.O0000OOo == 0 && this.O0000O0o != null) {
            this.O0000OOo = this.O0000O0o.getHeight();
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.O00000o0 != null && !O00000o() && O000000o()) {
            float bottom = (float) (this.O0000OOo - this.O0000O0o.getBottom());
            String str = O00000oo;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onScroll --> f = ");
            stringBuilder.append(bottom);
            Log.d(str, stringBuilder.toString());
            if (!O00000o0()) {
                return;
            }
            if (bottom > 0.0f && bottom < ((float) this.O0000OOo)) {
                this.O0000O0o.scrollTo(0, -((int) (0.65d * ((double) bottom))));
            } else if (this.O0000O0o.getScrollY() != 0) {
                this.O0000O0o.scrollTo(0, 0);
            }
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        Log.d(O00000oo, "onScrollStateChanged --> ");
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((ListView) this.O000000o).setAdapter(listAdapter);
    }

    public void setHeaderLayoutParams(AbsListView.LayoutParams layoutParams) {
        if (this.O0000O0o != null) {
            this.O0000O0o.setLayoutParams(layoutParams);
            this.O0000OOo = layoutParams.height;
        }
    }

    public void setHeaderView(View view) {
        if (view != null) {
            this.O00000Oo = view;
            O0000Oo();
        }
    }

    public void setHideHeader(boolean z) {
        if (z != O00000o()) {
            super.setHideHeader(z);
            if (z) {
                O0000Oo0();
            } else {
                O0000Oo();
            }
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        ((ListView) this.O000000o).setOnItemClickListener(onItemClickListener);
    }

    public void setZoomView(View view) {
        if (view != null) {
            this.O00000o0 = view;
            O0000Oo();
        }
    }
}
