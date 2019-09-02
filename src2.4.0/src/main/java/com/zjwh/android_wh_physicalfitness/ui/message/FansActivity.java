package com.zjwh.android_wh_physicalfitness.ui.message;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import s.h.e.l.l.C;

public class FansActivity extends BaseActivity {
    public static final String O000000o = "extra_news_count";
    private int O00000Oo;
    private FragmentManager O00000o0;

    static {
        C.i(16777321);
    }

    public static native void O000000o(Activity activity, int i);

    private native void O000000o(Bundle bundle);

    private native void O00000o();

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            this.O00000o0 = getSupportFragmentManager();
            O00000o();
        }
    }
}
