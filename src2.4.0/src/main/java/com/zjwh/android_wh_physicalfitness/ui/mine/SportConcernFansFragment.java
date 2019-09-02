package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.SportConcernFansBean;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fj;
import defpackage.fj.O00000o0;
import defpackage.hl.O000000o;
import defpackage.hl.O00000Oo;
import defpackage.ju;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427644)
public class SportConcernFansFragment extends BaseFragment implements O00000o0, O00000Oo {
    public static final String O000000o = "extra_type";
    @ViewInject(2131296945)
    private RecyclerView O00000oo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000O0o;
    private com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo O0000OOo;
    private fj O0000Oo;
    private O000000o O0000Oo0;
    private com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0 O0000OoO;
    private LocalBroadcastManager O0000Ooo;
    private BroadcastReceiver O0000o00;

    static {
        C.i(16777342);
    }

    public static native SportConcernFansFragment O00000Oo(int i);

    private O000000o O00000oO() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new ju(this);
        }
        return this.O0000Oo0;
    }

    private native void O00000oo();

    public native void O000000o();

    public native void O000000o(int i);

    public native void O000000o(int i, int i2, SportConcernFansBean sportConcernFansBean);

    public void O000000o(ResponseError responseError) {
        if (O0000Ooo()) {
            this.O0000O0o.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    SportConcernFansFragment.this.O00000oO().O000000o(SportConcernFansFragment.this.getContext(), true);
                }
            });
        }
    }

    public void O000000o(List<SportConcernFansBean> list) {
        this.O0000O0o.O000000o();
        if (this.O0000Oo != null) {
            this.O0000Oo.O000000o((List) list);
            this.O0000Oo.notifyDataSetChanged();
        }
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(ResponseError responseError);

    public native void O00000o();

    public native void O00000o0();

    /* Access modifiers changed, original: protected */
    public void f_() {
        super.f_();
        if (this.O00000o0 && this.O00000Oo) {
            O00000oO().O000000o(getContext(), true);
            this.O00000o0 = false;
            this.O00000Oo = false;
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O00000oo();
        f_();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        O00000oO().O00000Oo(bundle);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        O000000o O00000oO = O00000oO();
        if (bundle == null) {
            bundle = getArguments();
        }
        O00000oO.O000000o(bundle);
        this.O00000oo.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000Oo = new fj(this);
        this.O0000OoO = new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0(this.O0000Oo);
        this.O0000OOo = new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                if (O0000O0o.O000000o(SportConcernFansFragment.this.O00000oo) != LoadingFooter.O000000o.Loading) {
                    SportConcernFansFragment.this.O00000oO().O000000o(SportConcernFansFragment.this.getContext());
                }
            }
        };
        this.O00000oo.addOnScrollListener(this.O0000OOo);
        this.O00000oo.setAdapter(this.O0000OoO);
    }
}
