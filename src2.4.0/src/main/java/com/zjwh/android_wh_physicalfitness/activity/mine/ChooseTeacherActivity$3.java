package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;
import defpackage.fx.O000000o;

class ChooseTeacherActivity$3 implements O000000o {
    final /* synthetic */ ChooseTeacherActivity O000000o;

    ChooseTeacherActivity$3(ChooseTeacherActivity chooseTeacherActivity) {
        this.O000000o = chooseTeacherActivity;
    }

    public void O000000o(View view, ViewHolder viewHolder, int i) {
        Intent intent = new Intent(this.O000000o, ChooseCourseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("teacherResModel", (TeacherResModel) ChooseTeacherActivity.O000000o(this.O000000o).get(i));
        intent.putExtras(bundle);
        this.O000000o.startActivity(intent);
    }

    public boolean O00000Oo(View view, ViewHolder viewHolder, int i) {
        return false;
    }
}
