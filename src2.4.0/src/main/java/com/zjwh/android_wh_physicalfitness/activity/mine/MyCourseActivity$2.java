package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ClassResModel;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.TeaClassResModel;
import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import defpackage.bv;
import org.xutils.common.Callback.CancelledException;

class MyCourseActivity$2 implements MyCallback<String> {
    final /* synthetic */ MyCourseActivity O000000o;

    MyCourseActivity$2(MyCourseActivity myCourseActivity) {
        this.O000000o = myCourseActivity;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        if (!this.O000000o.isFinishing()) {
            if (responseError.getError() == bv.O0000oOO) {
                this.O000000o.O00000o0.O000000o(ContextCompat.getDrawable(MyCourseActivity.O00000oO(this.O000000o), R.drawable.empty_class_icon), null, this.O000000o.getString(R.string.nocourse));
            } else {
                this.O000000o.O00000o0.O000000o(null, this.O000000o.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                    public void onClick(View view) {
                        MyCourseActivity.O00000Oo(MyCourseActivity$2.this.O000000o);
                    }
                });
            }
        }
    }

    public void onFinished() {
        this.O000000o.O0000OoO();
    }

    public void onSuccess(String str) {
        if (!this.O000000o.isFinishing()) {
            this.O000000o.O00000Oo.setVisibility(0);
            MyCourseActivity.O000000o(this.O000000o, (TeaClassResModel) O000o000.O000000o(str, TeaClassResModel.class));
            if (MyCourseActivity.O000000o(this.O000000o) != null) {
                this.O000000o.O000000o.setText(MyCourseActivity.O000000o(this.O000000o).semesterName);
                if (MyCourseActivity.O000000o(this.O000000o).teacherResModels != null) {
                    for (TeacherResModel teacherResModel : MyCourseActivity.O000000o(this.O000000o).teacherResModels) {
                        if (teacherResModel.myTeacher && teacherResModel.classResModels != null) {
                            for (ClassResModel classResModel : teacherResModel.classResModels) {
                                if (classResModel.myClass) {
                                    MyCourseActivity.O00000o0(this.O000000o).setText(teacherResModel.teacherName);
                                    MyCourseActivity.O00000o(this.O000000o).setText(classResModel.className);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            this.O000000o.O00000o0.O000000o();
        }
    }
}
