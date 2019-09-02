package com.zjwh.android_wh_physicalfitness.fragment;

import android.os.Handler;

public abstract class LazyFragment extends BaseFragment {
    protected static long O0000O0o = 800;
    private Handler O000000o = new Handler();
    protected boolean O00000oo;
    private Runnable O0000OOo = new Runnable() {
        public void run() {
            LazyFragment.this.f_();
        }
    };

    /* Access modifiers changed, original: protected */
    public void O0000Oo() {
        this.O000000o.postDelayed(this.O0000OOo, O0000O0o);
    }

    /* Access modifiers changed, original: protected */
    public void O0000OoO() {
        this.O000000o.removeCallbacks(this.O0000OOo);
    }

    public abstract void f_();

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (getUserVisibleHint()) {
            this.O00000oo = true;
            O0000Oo();
            return;
        }
        this.O00000oo = false;
        O0000OoO();
    }
}
