package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fw;
import defpackage.ht.O000000o;
import defpackage.ht.O00000Oo;
import defpackage.kd;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MusicPurchasedActivity extends BaseActivity implements O00000Oo {
    protected fw O000000o;
    @ViewInject(2131296945)
    private RecyclerView O00000Oo;
    private O000000o O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;

    static {
        C.i(16777348);
    }

    public static native void O000000o(Activity activity);

    private native void O0000Oo0();

    private O000000o O0000o0() {
        if (this.O00000o == null) {
            this.O00000o = new kd(this);
        }
        return this.O00000o;
    }

    public native int O000000o();

    public native void O00000Oo();

    public native void O00000o();

    public void O00000oO() {
        if (!isFinishing()) {
            this.O00000o0.O000000o(null, getString(R.string.txt_request_failure), getString(R.string.txt_check_network), "", new OnClickListener() {
                public void onClick(View view) {
                    MusicPurchasedActivity.this.O0000o0().O00000Oo(MusicPurchasedActivity.this.O0000o0);
                }
            });
        }
    }

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O0000Oo0();
        O0000o0().O00000Oo(this.O0000o0);
    }
}
