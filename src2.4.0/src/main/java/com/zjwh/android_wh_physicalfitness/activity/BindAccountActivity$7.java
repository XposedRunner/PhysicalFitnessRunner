package com.zjwh.android_wh_physicalfitness.activity;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import org.xutils.common.Callback.CancelledException;

class BindAccountActivity$7 implements MyCallback<String> {
    final /* synthetic */ BindAccountActivity O000000o;

    BindAccountActivity$7(BindAccountActivity bindAccountActivity) {
        this.O000000o = bindAccountActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        if (!this.O000000o.isFinishing()) {
            O00Oo0.O000000o(this.O000000o, responseError.getMessage());
            BindAccountActivity.O00000o0(this.O000000o);
            this.O000000o.O0000OOo.setVisibility(8);
        }
    }

    public void onFinished() {
        this.O000000o.O00000o0.setEnabled(true);
        this.O000000o.O00000o0.setTextColor(ContextCompat.getColor(BindAccountActivity.O00000oo(this.O000000o), R.color.text_color_major));
        this.O000000o.O00000o0.setText(R.string.txt_check);
    }

    public void onSuccess(String str) {
        if (!this.O000000o.isFinishing()) {
            boolean z = false;
            this.O000000o.O0000OOo.setVisibility(0);
            try {
                UserInfo userInfo = (UserInfo) this.O000000o.O0000OoO.fromJson(str, UserInfo.class);
                if (userInfo != null) {
                    BindAccountActivity.O00000Oo(this.O000000o, userInfo.getDepartmentId());
                    BindAccountActivity.O000000o(this.O000000o, userInfo.getDepart());
                    BindAccountActivity.O00000o0(this.O000000o, userInfo.getClassId());
                    BindAccountActivity.O000000o(this.O000000o, userInfo.getSex());
                    EditText editText = this.O000000o.O00000oO;
                    boolean z2 = TextUtils.isEmpty(userInfo.getDepart()) && !userInfo.isHasEnum();
                    editText.setFocusableInTouchMode(z2);
                    RelativeLayout O00000o = BindAccountActivity.O00000o(this.O000000o);
                    z2 = TextUtils.isEmpty(userInfo.getDepart()) && userInfo.isHasEnum();
                    O00000o.setClickable(z2);
                    this.O000000o.O00000oo.setClickable(userInfo.getSex() == -1);
                    TextView O000000o = BindAccountActivity.O000000o(this.O000000o);
                    if (userInfo.getEnrollmentYear() <= 0) {
                        z = true;
                    }
                    O000000o.setClickable(z);
                    BindAccountActivity.O00000oO(this.O000000o).setName(TextUtils.isEmpty(userInfo.getName()) ? "" : userInfo.getName());
                    BindAccountActivity.O00000oO(this.O000000o).setSex(userInfo.getSex());
                    BindAccountActivity.O00000oO(this.O000000o).setCampusId(TextUtils.isEmpty(userInfo.getCampusId()) ? "" : userInfo.getCampusId());
                    BindAccountActivity.O00000oO(this.O000000o).setDepart(TextUtils.isEmpty(userInfo.getDepart()) ? "" : userInfo.getDepart());
                    BindAccountActivity.O00000oO(this.O000000o).setHasEnum(userInfo.isHasEnum());
                    BindAccountActivity.O00000oO(this.O000000o).setDepartmentId(userInfo.getDepartmentId());
                    BindAccountActivity.O00000oO(this.O000000o).setGiven(userInfo.isGiven());
                    BindAccountActivity.O00000oO(this.O000000o).setShowClassEnum(userInfo.isShowClassEnum());
                    BindAccountActivity.O00000oO(this.O000000o).setClassId(userInfo.getClassId());
                    BindAccountActivity.O00000oO(this.O000000o).setGradeClass(userInfo.getGradeClass());
                    BindAccountActivity.O000000o(this.O000000o, userInfo);
                }
            } catch (Exception e) {
                e.printStackTrace();
                O00Oo0.O000000o(this.O000000o, R.string.msg_check_failure);
            }
        }
    }
}
