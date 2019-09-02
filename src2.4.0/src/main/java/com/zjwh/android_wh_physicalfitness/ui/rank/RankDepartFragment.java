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
import com.zjwh.android_wh_physicalfitness.entity.DepartmentRank;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.eq;
import defpackage.hv.O000000o;
import defpackage.hv.O00000Oo;
import defpackage.kg;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427516)
public class RankDepartFragment extends BaseFragment implements O00000Oo {
    @ViewInject(2131296945)
    private RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000oo;
    private eq O0000O0o;
    private O000000o O0000OOo;

    static {
        C.i(16777353);
    }

    public static native RankDepartFragment O000000o(String str);

    public native void O000000o();

    public void O000000o(ResponseError responseError) {
        if (O0000Ooo()) {
            this.O00000oo.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    RankDepartFragment.this.O00000o().O000000o(RankDepartFragment.this.getActivity());
                }
            });
        }
    }

    public void O000000o(List<DepartmentRank> list) {
        this.O0000O0o.O00000o0(list);
    }

    public native void O00000Oo();

    public O000000o O00000o() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new kg(this);
        }
        return this.O0000OOo;
    }

    public native void O00000o0();

    /* Access modifiers changed, original: protected */
    public void f_() {
        super.f_();
        if (this.O00000o0 && this.O00000Oo) {
            O00000o().O000000o(getActivity());
            this.O00000o0 = false;
            this.O00000Oo = false;
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        f_();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O00000o = O00000o();
        if (bundle == null) {
            bundle = getArguments();
        }
        O00000o.O000000o(bundle);
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O000000o.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000O0o = new eq();
        this.O000000o.setAdapter(this.O0000O0o);
    }
}
