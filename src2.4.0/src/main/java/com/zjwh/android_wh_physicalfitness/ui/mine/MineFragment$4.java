package com.zjwh.android_wh_physicalfitness.ui.mine;

import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.MineFragmentListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gg;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

class MineFragment$4 implements MyCallback<String> {
    final /* synthetic */ MineFragment O000000o;

    MineFragment$4(MineFragment mineFragment) {
        this.O000000o = mineFragment;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        O00Oo00.O000000o(responseError.getMessage());
    }

    public void onFinished() {
    }

    public void onSuccess(String str) {
        List list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<MineFragmentListBean>>() {
        }.getType());
        if (list != null && list.size() > 0) {
            O00O0Oo0.O000000o(gg.O000O0o0, O000o000.O000000o((Object) list));
            MineFragment.O0000OOo(this.O000000o).O000000o(list);
        }
    }
}
