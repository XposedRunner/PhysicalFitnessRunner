package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.NotificationManager;
import android.content.Intent;
import com.qiyukf.unicorn.api.Unicorn;
import com.zjwh.android_wh_physicalfitness.activity.MainActivity;
import com.zjwh.android_wh_physicalfitness.activity.WelcomeLoginActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.service.BluetoothService;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gg;
import defpackage.kf;
import org.xutils.common.Callback.CancelledException;

class SettingActivity$2 implements MyCallback<String> {
    final /* synthetic */ SettingActivity O000000o;

    SettingActivity$2(SettingActivity settingActivity) {
        this.O000000o = settingActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        O00Oo00.O000000o(SettingActivity.O00000oO(this.O000000o), responseError.getMessage());
    }

    public void onFinished() {
        this.O000000o.O0000OoO();
    }

    public void onSuccess(String str) {
        try {
            O000o0.O00000Oo();
            Unicorn.logout();
            ((NotificationManager) SettingActivity.O00000Oo(this.O000000o).getSystemService("notification")).cancelAll();
            O00Oo0.O00000o();
            kf.O00000Oo();
            this.O000000o.stopService(new Intent(this.O000000o, BluetoothService.class));
            O00O0Oo0.O000000o(this.O000000o, gg.O000o0O0);
            O00O0Oo0.O000000o(this.O000000o, gg.O000o0O);
            O00O0Oo0.O000000o(this.O000000o, "receiver_broadcast");
            O00O0Oo0.O000000o(this.O000000o, RunRuleModel.SP_KEY_MIN_DISTANCE);
            O00000Oo.O000000o(PersonalInfoActivity.class);
            O00000Oo.O00000o0(MainActivity.class);
            SettingActivity.O00000o0(this.O000000o);
            this.O000000o.startActivity(new Intent(SettingActivity.O00000o(this.O000000o), WelcomeLoginActivity.class));
            this.O000000o.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
