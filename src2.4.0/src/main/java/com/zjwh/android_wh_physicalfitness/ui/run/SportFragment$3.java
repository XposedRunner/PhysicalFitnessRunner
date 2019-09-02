package com.zjwh.android_wh_physicalfitness.ui.run;

import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.HomePageDialogBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000O00o;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import java.lang.ref.WeakReference;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

class SportFragment$3 implements MyCallback<String> {
    final /* synthetic */ SportFragment O000000o;

    SportFragment$3(SportFragment sportFragment) {
        this.O000000o = sportFragment;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        O000O00o.O000000o(new WeakReference(this.O000000o.getActivity()));
    }

    public void onFinished() {
    }

    public void onSuccess(String str) {
        List list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<HomePageDialogBean>>() {
        }.getType());
        if (list != null && list.size() > 0) {
            SportFragment.O0000OoO(this.O000000o).addAll(list);
        }
        if (!this.O000000o.isHidden()) {
            if (this.O000000o.O0000Ooo()) {
                SportFragment.O0000Ooo(this.O000000o);
            } else {
                return;
            }
        }
        O000O00o.O000000o(new WeakReference(this.O000000o.getActivity()));
    }
}
