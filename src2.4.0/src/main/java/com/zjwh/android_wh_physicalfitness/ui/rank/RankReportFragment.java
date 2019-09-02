package com.zjwh.android_wh_physicalfitness.ui.rank;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.rank.RankCheatListBean;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.ep;
import defpackage.hx.O000000o;
import defpackage.hx.O00000Oo;
import defpackage.ki;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427516)
public class RankReportFragment extends BaseFragment implements O00000Oo {
    @ViewInject(2131296945)
    private RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000oo;
    private ep O0000O0o;
    private O00000o0 O0000OOo;
    private O000000o O0000Oo0;

    static {
        C.i(16777355);
    }

    public static native RankReportFragment O00000o();

    public native void O000000o();

    public native void O000000o(int i);

    public void O000000o(ResponseError responseError) {
        if (O0000Ooo()) {
            this.O00000oo.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    RankReportFragment.this.O00000oO().O000000o(RankReportFragment.this.getActivity());
                }
            });
        }
    }

    public native void O000000o(RankCheatListBean rankCheatListBean, boolean z);

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(ResponseError responseError);

    public native void O00000o0();

    public O000000o O00000oO() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new ki(this);
        }
        return this.O0000Oo0;
    }

    /* Access modifiers changed, original: protected */
    public void f_() {
        super.f_();
        if (this.O00000o0 && this.O00000Oo) {
            O00000oO().O000000o(getActivity());
            this.O00000o0 = false;
            this.O00000Oo = false;
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        f_();
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O000000o.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000O0o = new ep();
        this.O0000OOo = new O00000o0(this.O0000O0o);
        this.O000000o.setAdapter(this.O0000OOo);
        this.O000000o.addOnScrollListener(new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                if (O0000O0o.O000000o(RankReportFragment.this.O000000o) != LoadingFooter.O000000o.Loading) {
                    RankReportFragment.this.O00000oO().O00000Oo(RankReportFragment.this.getActivity());
                }
            }
        });
    }
}
