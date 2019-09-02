package com.zjwh.android_wh_physicalfitness.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.NoticeHasNewEvt;
import com.zjwh.android_wh_physicalfitness.entity.NoticeListBean;
import com.zjwh.android_wh_physicalfitness.ui.notice.NoticeDetailActivity;
import java.util.List;

class FindFragment$5 implements OnClickListener {
    final /* synthetic */ List O000000o;
    final /* synthetic */ FindFragment O00000Oo;

    FindFragment$5(FindFragment findFragment, List list) {
        this.O00000Oo = findFragment;
        this.O000000o = list;
    }

    public void onClick(View view) {
        int intValue = ((Integer) FindFragment.O00000o0(this.O00000Oo).getTag()).intValue();
        this.O00000Oo.notifyNoticeIcon(new NoticeHasNewEvt(false));
        NoticeDetailActivity.O000000o(this.O00000Oo.getActivity(), ((NoticeListBean) this.O000000o.get(intValue)).getId());
    }
}
