package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseRefreshLoadListActivity;
import com.zjwh.android_wh_physicalfitness.entity.ActivitiesBean;
import com.zjwh.android_wh_physicalfitness.view.O000000o;
import defpackage.gw;
import defpackage.ip;
import org.xutils.common.util.DensityUtil;

public class ActivitiesActivity extends BaseRefreshLoadListActivity<ActivitiesBean, gw<ActivitiesBean>> {
    public static void O000000o(Activity activity) {
        activity.startActivity(new Intent(activity, ActivitiesActivity.class));
    }

    public int O000000o() {
        return R.layout.activity_topic;
    }

    public void O00000Oo() {
        this.O0000Ooo.setText(R.string.find_item_activity);
    }

    public void O00000Oo(int i) {
        if (i == -1 && !this.O00000Oo.isRefreshing()) {
            O00000oO(getString(R.string.txt_loading));
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000o() {
        super.O00000o();
        this.O00000o0.addItemDecoration(new O000000o(DensityUtil.dip2px(10.0f)));
        this.O00000o0.removeOnScrollListener(this.O0000O0o);
    }

    public void O00000oo() {
        if (!isFinishing()) {
            this.O000000o.O000000o(ContextCompat.getDrawable(this.O0000o0, R.drawable.empty_activities_icon), null, "暂无任何活动");
        }
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized gw<ActivitiesBean> O0000OOo() {
        if (this.O00000o == null) {
            this.O00000o = new ip(this);
        }
        return this.O00000o;
    }
}
