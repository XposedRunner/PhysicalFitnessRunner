package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.activity.mine.PersonalInfoActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import org.xutils.common.Callback.CancelledException;

class SchoolNumBackActivity$8 implements MyCallback<String> {
    final /* synthetic */ SchoolNumBackActivity O000000o;

    SchoolNumBackActivity$8(SchoolNumBackActivity schoolNumBackActivity) {
        this.O000000o = schoolNumBackActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        this.O000000o.O0000OoO();
        this.O000000o.O00000Oo("提交失败", responseError.getMessage());
    }

    public void onFinished() {
        this.O000000o.O0000OoO();
    }

    public void onSuccess(String str) {
        this.O000000o.O000000o("提交成功", "您的学号找回申请已提交\n1-7个工作日内会通过短信通知您审核结果", new OnClickListener() {
            public void onClick(View view) {
                if (O00000Oo.O00000o(ChangeNameSchoolNumberActivity.class)) {
                    O00000Oo.O00000o0(SchoolNumBackActivity.class);
                    O00000Oo.O00000o0(ChangeNameSchoolNumberActivity.class);
                    O00000Oo.O000000o(PersonalInfoActivity.class);
                    return;
                }
                SchoolNumBackActivity$8.this.O000000o.finish();
            }
        });
    }
}
