package com.zjwh.android_wh_physicalfitness.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SignResModel;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import java.util.Collections;
import java.util.List;
import org.xutils.common.Callback.CancelledException;

class CheckAttendanceActivity$1 implements MyCallback<String> {
    final /* synthetic */ CheckAttendanceActivity O000000o;

    CheckAttendanceActivity$1(CheckAttendanceActivity checkAttendanceActivity) {
        this.O000000o = checkAttendanceActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        this.O000000o.O0000OoO();
        if (!this.O000000o.isFinishing()) {
            CheckAttendanceActivity.O000000o(this.O000000o).O000000o(null, this.O000000o.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    CheckAttendanceActivity$1.this.O000000o.n_();
                }
            });
            O00Oo00.O00000Oo(responseError.getMessage());
        }
    }

    public void onFinished() {
        this.O000000o.O0000OoO();
        Collections.sort(this.O000000o.O00000o);
        CheckAttendanceActivity.O000000o(this.O000000o, this.O000000o.O00000o);
        CheckAttendanceActivity.O00000o0(this.O000000o);
    }

    public void onSuccess(String str) {
        if (!this.O000000o.isFinishing()) {
            List list = (List) this.O000000o.O0000OoO.fromJson(str, new TypeToken<List<SignResModel>>() {
            }.getType());
            if (list == null || list.size() <= 0) {
                CheckAttendanceActivity.O000000o(this.O000000o).O000000o(ContextCompat.getDrawable(CheckAttendanceActivity.O00000Oo(this.O000000o), R.drawable.empty_student_icon), null, this.O000000o.getString(R.string.nosudent));
            } else {
                this.O000000o.O00000o.clear();
                this.O000000o.O00000o.addAll(list);
                CheckAttendanceActivity.O000000o(this.O000000o).O000000o();
            }
        }
    }
}
