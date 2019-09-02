package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseRefreshLoadListActivity;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import com.zjwh.android_wh_physicalfitness.view.O000000o;
import defpackage.gw;
import defpackage.jk;
import org.xutils.common.util.DensityUtil;

public class TopicActivity extends BaseRefreshLoadListActivity<TopicBean, gw<TopicBean>> {
    public static void O000000o(Activity activity) {
        activity.startActivity(new Intent(activity, TopicActivity.class));
    }

    public int O000000o() {
        return R.layout.activity_topic;
    }

    public void O00000Oo() {
        this.O0000Ooo.setText(R.string.find_item_topic);
    }

    /* Access modifiers changed, original: protected */
    public void O00000o() {
        super.O00000o();
        this.O00000o0.addItemDecoration(new O000000o(DensityUtil.dip2px(8.0f)));
    }

    public void O00000oo() {
        if (!isFinishing()) {
            this.O000000o.O000000o(ContextCompat.getDrawable(this.O0000o0, R.drawable.empty_topic_icon), null, "暂无话题信息");
        }
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized gw<TopicBean> O0000OOo() {
        if (this.O00000o == null) {
            this.O00000o = new jk(this);
        }
        return this.O00000o;
    }
}
