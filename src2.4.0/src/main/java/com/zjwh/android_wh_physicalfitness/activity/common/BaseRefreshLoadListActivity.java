package com.zjwh.android_wh_physicalfitness.activity.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.gx;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public abstract class BaseRefreshLoadListActivity<T, K extends gw<T>> extends BaseActivity implements gx {
    @ViewInject(2131296795)
    protected LoadingEmptyLayout O000000o;
    @ViewInject(2131296949)
    protected SwipeRefreshLayout O00000Oo;
    protected K O00000o;
    @ViewInject(2131296942)
    protected RecyclerView O00000o0;
    protected fw<T> O00000oO;
    protected O00000o0 O00000oo;
    protected O00000Oo O0000O0o;

    static {
        C.i(36);
    }

    public native void O000000o(Bundle bundle);

    public native void O000000o(ResponseError responseError);

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(int i);

    public void O00000Oo(ResponseError responseError) {
        if (!isFinishing()) {
            this.O000000o.O000000o(null, getString(2131689986), responseError.getMessage(), "", new 3(this));
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000o() {
        this.O00000Oo.setColorSchemeResources(2131099885, 2131099770, 2131099682, 2131099771);
        this.O00000Oo.setOnRefreshListener(new 1(this));
        this.O00000o0.setLayoutManager(new LinearLayoutManager(this));
        this.O0000O0o = new 2(this);
        this.O00000o0.addOnScrollListener(this.O0000O0o);
        this.O00000oO = O0000OOo().O000000o(this.O0000o0);
        this.O00000oo = new O00000o0(this.O00000oO);
        this.O00000o0.setAdapter(this.O00000oo);
    }

    public native void O00000oo();

    public abstract K O0000OOo();

    public native void O0000Oo0();

    public native void O0000o0();

    public native void O0000o0O();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            O00000o();
            O0000OOo().O00000Oo(this.O0000o0);
        }
    }

    public native void onDestroy();
}
