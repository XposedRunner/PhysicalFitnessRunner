package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.HistoryRank;
import com.zjwh.android_wh_physicalfitness.ui.rank.RankingListActivity;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.eg;
import defpackage.eg.O00000Oo;
import java.util.ArrayList;
import java.util.List;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class HistoryRankActivity extends BaseActivity {
    @ViewInject(2131297108)
    public SwipeRefreshLayout O000000o;
    @ViewInject(2131297039)
    public RecyclerView O00000Oo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o;
    @ViewInject(2131296371)
    public TextView O00000o0;
    private List<HistoryRank> O00000oO = new ArrayList();
    private eg O00000oo;

    static {
        C.i(16777308);
    }

    public static native void O000000o(Activity activity);

    private void O00000o() {
        this.O00000oo = new eg(this.O0000o0);
        this.O00000Oo.setAdapter(this.O00000oo);
        this.O00000Oo.setLayoutManager(new LinearLayoutManager(this));
        this.O00000oo.O000000o(new O00000Oo() {
            public void O000000o(HistoryRank historyRank) {
                RankingListActivity.O000000o(HistoryRankActivity.this, historyRank.getHisRankId());
            }
        });
        this.O000000o.setColorSchemeResources(new int[]{R.color.sport_green, R.color.green2, R.color.big_red, R.color.green3});
        this.O000000o.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                HistoryRankActivity.this.O00000oO();
            }
        });
    }

    private native void O00000oO();

    private native void O00000oo();

    @Event(type = OnClickListener.class, value = {2131296371})
    private void onClick(View view) {
        if (view.getId() == R.id.btn_today_rank) {
            RankingListActivity.O000000o(this, null);
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);
}
