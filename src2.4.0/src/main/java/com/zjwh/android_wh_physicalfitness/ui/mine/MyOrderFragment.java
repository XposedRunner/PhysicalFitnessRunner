package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.MyOrderInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.ek;
import defpackage.hd.O000000o;
import defpackage.hd.O00000Oo;
import defpackage.jg;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427515)
public class MyOrderFragment extends BaseFragment implements O00000Oo {
    public static final String O000000o = "extra_status";
    @ViewInject(2131296949)
    public SwipeRefreshLayout O00000oo;
    @ViewInject(2131296942)
    public RecyclerView O0000O0o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000OOo;
    private ek O0000Oo;
    private O000000o O0000Oo0;
    private O00000o0 O0000OoO;
    private com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo O0000Ooo;
    private boolean O0000o0;
    private int O0000o00 = -1;

    static {
        C.i(16777336);
    }

    public static native MyOrderFragment O000000o(int i);

    private synchronized O000000o O0000o0() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new jg(this, getActivity());
        }
        return this.O0000Oo0;
    }

    public native void O000000o();

    public void O000000o(ResponseError responseError) {
        if (O0000Ooo()) {
            this.O0000OOo.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    MyOrderFragment.this.O0000o0().O000000o();
                }
            });
        }
    }

    public void O000000o(List<MyOrderInfoBean> list) {
        this.O0000Oo.O000000o(list);
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(int i);

    public native void O00000o();

    public native void O00000o0();

    public native void O00000oO();

    public native boolean O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public native void O0000Oo0();

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!this.O0000o0) {
            O00000Oo(this.O0000o00);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O0000o0 = O0000o0();
        if (bundle == null) {
            bundle = getArguments();
        }
        O0000o0.O000000o(bundle);
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000O0o.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000Oo = new ek();
        this.O0000OoO = new O00000o0(this.O0000Oo);
        this.O0000O0o.setAdapter(this.O0000OoO);
        this.O00000oo.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                MyOrderFragment.this.O0000o0().O00000Oo();
            }
        });
        this.O0000Ooo = new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                if (!(O0000O0o.O000000o(MyOrderFragment.this.O0000O0o) == LoadingFooter.O000000o.Loading || MyOrderFragment.this.O0000Oo0 == null)) {
                    MyOrderFragment.this.O0000Oo0.O00000o0();
                }
            }
        };
        this.O0000O0o.addOnScrollListener(this.O0000Ooo);
    }
}
