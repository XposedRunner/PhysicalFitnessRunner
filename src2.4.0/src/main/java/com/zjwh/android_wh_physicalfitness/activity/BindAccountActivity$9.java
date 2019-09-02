package com.zjwh.android_wh_physicalfitness.activity;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.gg;
import org.xutils.common.Callback.CancelledException;

class BindAccountActivity$9 implements MyCallback<String> {
    final /* synthetic */ UserInfo O000000o;
    final /* synthetic */ BindAccountActivity O00000Oo;

    BindAccountActivity$9(BindAccountActivity bindAccountActivity, UserInfo userInfo) {
        this.O00000Oo = bindAccountActivity;
        this.O000000o = userInfo;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        BindAccountActivity.O0000OOo(this.O00000Oo);
    }

    public void onFinished() {
        BindAccountActivity.O0000Oo0(this.O00000Oo).O000000o(true);
        if (BindAccountActivity.O0000Oo0(this.O00000Oo) != null) {
            BindAccountActivity.O0000Oo0(this.O00000Oo).O00000o0();
        }
    }

    public void onSuccess(String str) {
        try {
            UserInfo userInfo = (UserInfo) new Gson().fromJson(str, UserInfo.class);
            if (userInfo != null) {
                userInfo.setToken(this.O000000o.getToken());
                if (TextUtils.isEmpty(userInfo.getToken())) {
                    O00Oo0.O000000o(gg.O000OOoO, "");
                }
                O00O0Oo0.O000000o(gg.O000o0O0, userInfo.getToken());
                O00O0Oo0.O000000o(gg.O000o0O, Integer.valueOf(userInfo.getUid()));
                O00Oo0.O000000o(userInfo);
                if (!O00000Oo.O00000o(MainActivity.class)) {
                    MainActivity.O000000o(this.O00000Oo);
                    O000o0.O00000Oo(this.O00000Oo, this.O00000Oo.getIntent().getStringExtra("data"));
                }
                this.O00000Oo.finish();
                return;
            }
            BindAccountActivity.O0000OOo(this.O00000Oo);
        } catch (Exception e) {
            e.printStackTrace();
            BindAccountActivity.O0000OOo(this.O00000Oo);
        }
    }
}
