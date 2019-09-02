package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SignIntegralBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.DailySignDialog;
import org.xutils.common.Callback.CancelledException;

class MineFragment$6 implements MyCallback<String> {
    final /* synthetic */ MineFragment O000000o;

    MineFragment$6(MineFragment mineFragment) {
        this.O000000o = mineFragment;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        MineFragment.O0000o00(this.O000000o).setClickable(true);
        O00Oo00.O000000o(responseError.getMessage());
    }

    public void onFinished() {
    }

    public void onSuccess(String str) {
        SignIntegralBean signIntegralBean = (SignIntegralBean) O000o000.O000000o().fromJson(str, SignIntegralBean.class);
        if (signIntegralBean != null) {
            StringBuilder stringBuilder;
            String str2;
            MineFragment.O0000OoO(this.O000000o).setText(String.valueOf(signIntegralBean.getPoint()));
            TextView O0000Ooo = MineFragment.O0000Ooo(this.O000000o);
            if (signIntegralBean.getSigninState() == 1) {
                stringBuilder = new StringBuilder();
                str2 = "今日已签到，已连续签到";
            } else {
                stringBuilder = new StringBuilder();
                str2 = "已连续签到";
            }
            stringBuilder.append(str2);
            stringBuilder.append(signIntegralBean.getContinueDays());
            stringBuilder.append("天");
            O0000Ooo.setText(stringBuilder.toString());
            MineFragment.O0000o00(this.O000000o).setVisibility(signIntegralBean.getSigninState() == 1 ? 8 : 0);
            try {
                DailySignDialog.O000000o(signIntegralBean.getContinueDays()).show(this.O000000o.getFragmentManager(), null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
