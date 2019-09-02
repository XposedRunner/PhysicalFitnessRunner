package com.zjwh.android_wh_physicalfitness.ui.rank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.PersonalRank;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.MyPullToZoomScrollView;
import defpackage.O00Oo;
import defpackage.eq;
import defpackage.eq.O00000Oo;
import defpackage.hw;
import defpackage.hw.O000000o;
import defpackage.kh;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427623)
public class RankPersonalFragment extends BaseFragment implements O00000Oo, hw.O00000Oo {
    @ViewInject(2131296795)
    private LoadingEmptyLayout O000000o;
    @ViewInject(2131296928)
    private MyPullToZoomScrollView O00000oo;
    @ViewInject(2131296945)
    private RecyclerView O0000O0o;
    @ViewInject(2131296646)
    private ImageView O0000OOo;
    @ViewInject(2131296674)
    private ImageView O0000Oo;
    @ViewInject(2131297225)
    private TextView O0000Oo0;
    @ViewInject(2131297247)
    private TextView O0000OoO;
    @ViewInject(2131296648)
    private ImageView O0000Ooo;
    private O00000o0 O0000o;
    @ViewInject(2131297245)
    private TextView O0000o0;
    @ViewInject(2131297243)
    private TextView O0000o00;
    @ViewInject(2131297241)
    private TextView O0000o0O;
    private eq O0000o0o;
    private O000000o O0000oO0;

    static {
        C.i(16777354);
    }

    public static native RankPersonalFragment O000000o(String str);

    private O000000o O00000o0() {
        if (this.O0000oO0 == null) {
            this.O0000oO0 = new kh(this);
        }
        return this.O0000oO0;
    }

    @Event({2131296648})
    private void onClick(View view) {
        int O00000oO = O00Oo0.O00000oO();
        if (O00000oO > 0) {
            HomePageActivity.O000000o(getActivity(), O00000oO, 8);
        }
    }

    public native void O000000o();

    public native void O000000o(int i);

    public native void O000000o(PersonalRank personalRank);

    public void O000000o(PersonalRank personalRank, PersonalRank personalRank2) {
        TextView textView;
        this.O0000Oo.setImageResource(R.drawable.homepage_default_bg);
        if (personalRank == null) {
            UserInfo O00000o0 = O00Oo0.O00000o0();
            O00Oo0.O000000o(getActivity(), O00000o0.getIcon(), this.O0000Ooo, O00000o0.getSex());
            this.O0000OoO.setText("很遗憾你没有上榜，再接再厉！");
            this.O0000o00.setText(O00000o0.getName());
            this.O0000o0.setText(O00000o0.getPsign());
            this.O0000o0O.setText("0.0公里");
        } else {
            CharSequence charSequence;
            O00Oo0.O000000o(getActivity(), personalRank.getIcon(), this.O0000Ooo, personalRank.getGender());
            textView = this.O0000OoO;
            if (personalRank.getOrder() == 0) {
                charSequence = "很遗憾你没有上榜，再接再厉！";
            } else {
                charSequence = String.format(getContext().getString(R.string.rank2), new Object[]{Integer.valueOf(personalRank.getOrder())});
            }
            textView.setText(charSequence);
            this.O0000o00.setText(personalRank.getName());
            this.O0000o0.setText(personalRank.getPsign());
            this.O0000o0O.setText(String.format("%s公里", new Object[]{Double.valueOf(personalRank.getDis())}));
        }
        if (personalRank2 == null) {
            this.O0000Oo0.setText(R.string.rank_first_no_data);
            this.O0000OOo.setImageResource(R.drawable.default_round_male);
            return;
        }
        CharSequence string;
        textView = this.O0000Oo0;
        if (TextUtils.isEmpty(personalRank2.getName())) {
            string = getString(R.string.rank_first_no_data);
        } else {
            string = String.format(getString(R.string.has_conquer_first), new Object[]{personalRank2.getName()});
        }
        textView.setText(string);
        O00Oo0.O000000o(getActivity(), personalRank2.getIcon(), this.O0000OOo, personalRank2.getGender());
        O00Oo.O000000o((Fragment) this).O000000o(personalRank2.getBicon()).O0000O0o((int) R.drawable.homepage_default_bg).O00000oO(R.drawable.homepage_default_bg).O000000o(this.O0000Oo);
    }

    public void O000000o(ResponseError responseError) {
        if (O0000Ooo()) {
            this.O000000o.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    RankPersonalFragment.this.O00000o0().O000000o(RankPersonalFragment.this.getActivity());
                }
            });
        }
    }

    public void O000000o(List<PersonalRank> list, boolean z) {
        this.O000000o.O000000o();
        if (z) {
            this.O0000o0o.O000000o((List) list);
        } else {
            this.O0000o0o.O00000Oo(list);
        }
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(ResponseError responseError);

    /* Access modifiers changed, original: protected */
    public void f_() {
        super.f_();
        if (this.O00000o0 && this.O00000Oo) {
            O00000o0().O000000o(getActivity());
            this.O00000o0 = false;
            this.O00000Oo = false;
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        f_();
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O00000o0 = O00000o0();
        if (bundle == null) {
            bundle = getArguments();
        }
        O00000o0.O000000o(bundle);
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000oo.setZoomEnabled(true);
        this.O0000O0o.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.O0000o0o = new eq(this);
        this.O0000o = new O00000o0(this.O0000o0o);
        this.O0000O0o.setAdapter(this.O0000o);
        this.O0000O0o.setNestedScrollingEnabled(false);
        this.O0000O0o.addOnScrollListener(new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                if (O0000O0o.O000000o(RankPersonalFragment.this.O0000O0o) != LoadingFooter.O000000o.Loading) {
                    RankPersonalFragment.this.O00000o0().O00000Oo(RankPersonalFragment.this.getActivity());
                }
            }
        });
    }
}
