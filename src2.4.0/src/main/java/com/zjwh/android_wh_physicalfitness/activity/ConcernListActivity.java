package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseRefreshLoadListActivity;
import com.zjwh.android_wh_physicalfitness.entity.FansListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import defpackage.gt.O000000o;
import defpackage.gt.O00000Oo;
import defpackage.ix;
import s.h.e.l.l.C;

public class ConcernListActivity extends BaseRefreshLoadListActivity<FansListBean, O000000o<FansListBean>> implements O00000Oo {
    private LocalBroadcastManager O0000OOo;
    private BroadcastReceiver O0000Oo0;

    static {
        C.i(16777278);
    }

    public static native void O000000o(Activity activity, int i, String str);

    private native void O0000o0o();

    public native int O000000o();

    public native void O000000o(int i);

    public native void O000000o(Bundle bundle);

    public native void O000000o(ResponseError responseError);

    public native void O000000o(String str, int i);

    public native void O00000Oo(int i);

    public native void O00000o();

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* renamed from: O00000oO */
    public synchronized O000000o<FansListBean> O0000OOo() {
        if (this.O00000o == null) {
            this.O00000o = new ix(this, this.O0000o0);
        }
        return (O000000o) this.O00000o;
    }

    public native void O00000oo();

    public native void O0000O0o();

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.white);
        O000000o O00000oO = O0000OOo();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O00000oO.O000000o(bundle);
        O0000o0o();
    }

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);
}
