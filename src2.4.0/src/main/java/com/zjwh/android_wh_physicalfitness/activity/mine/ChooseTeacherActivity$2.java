package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.content.Context;
import android.text.TextUtils;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;
import defpackage.fw;
import defpackage.ga;
import java.util.List;

class ChooseTeacherActivity$2 extends fw<TeacherResModel> {
    final /* synthetic */ ChooseTeacherActivity O000000o;

    ChooseTeacherActivity$2(ChooseTeacherActivity chooseTeacherActivity, Context context, int i, List list) {
        this.O000000o = chooseTeacherActivity;
        super(context, i, list);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(ga gaVar, TeacherResModel teacherResModel, int i) {
        gaVar.O000000o((int) R.id.tv_teachername, teacherResModel.teacherName);
        if (!TextUtils.isEmpty(teacherResModel.campusId)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("教职工号 ");
            stringBuilder.append(teacherResModel.campusId);
            gaVar.O000000o((int) R.id.tv_teachernumber, stringBuilder.toString());
        }
        gaVar.O000000o((int) R.id.iv_choose, teacherResModel.myTeacher);
        boolean z = true;
        if (i == ChooseTeacherActivity.O000000o(this.O000000o).size() - 1) {
            z = false;
        }
        gaVar.O000000o((int) R.id.line, z);
    }
}
