package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import java.io.File;
import org.xutils.common.Callback.CancelledException;

class SchoolNumBackActivity$7 implements MyCallback<String> {
    final /* synthetic */ File O000000o;
    final /* synthetic */ SchoolNumBackActivity O00000Oo;

    SchoolNumBackActivity$7(SchoolNumBackActivity schoolNumBackActivity, File file) {
        this.O00000Oo = schoolNumBackActivity;
        this.O000000o = file;
    }

    public void onCancelled(CancelledException cancelledException) {
        this.O00000Oo.O0000OoO();
    }

    public void onError(ResponseError responseError) {
        if (!this.O00000Oo.isFinishing()) {
            O00Oo00.O000000o(SchoolNumBackActivity.O00000oO(this.O00000Oo), responseError.getMessage());
        }
    }

    public void onFinished() {
        if (SchoolNumBackActivity.O00000o0(this.O00000Oo) != null && SchoolNumBackActivity.O00000o0(this.O00000Oo).isShowing()) {
            SchoolNumBackActivity.O00000o0(this.O00000Oo).cancel();
        }
    }

    public void onSuccess(String str) {
        O00Oo00.O000000o("上传成功");
        if (!this.O00000Oo.isFinishing()) {
            str = (String) this.O00000Oo.O0000OoO.fromJson(str, new TypeToken<String>() {
            }.getType());
            if (!TextUtils.isEmpty(str)) {
                SchoolNumBackActivity.O000000o(this.O00000Oo).add(str);
                SchoolNumBackActivity.O00000o(this.O00000Oo).O000000o(SchoolNumBackActivity.O000000o(this.O00000Oo));
            }
            this.O000000o.deleteOnExit();
        }
    }
}
