package com.zjwh.android_wh_physicalfitness.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.zjwh.android_wh_physicalfitness.activity.find.TopicDetailActivity;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import defpackage.gf;
import defpackage.in;

class FindFragment$3 implements in<TopicBean> {
    final /* synthetic */ FindFragment O000000o;

    FindFragment$3(FindFragment findFragment) {
        this.O000000o = findFragment;
    }

    /* renamed from: O000000o */
    public void O00000Oo(View view, int i, TopicBean topicBean) {
        TopicDetailActivity.O000000o(this.O000000o.getActivity(), topicBean.getId());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gf.O000o00O);
        stringBuilder.append(topicBean.getId());
        O00OO0O.O000000o(new PvDataInfoV29(10002, stringBuilder.toString()));
        FragmentActivity activity = this.O000000o.getActivity();
        String str = O000000o.O0000O0o;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(O00000o0.O00000Oo);
        stringBuilder2.append(i);
        stringBuilder2.append("_");
        stringBuilder2.append(topicBean.getId());
        O00Oo00o.O000000o(activity, str, stringBuilder2.toString());
    }

    /* renamed from: O00000Oo */
    public void O000000o(View view, int i, TopicBean topicBean) {
    }
}
