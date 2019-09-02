package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;
import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;

class ChooseTeacherActivity$1 implements TextWatcher {
    final /* synthetic */ ChooseTeacherActivity O000000o;

    ChooseTeacherActivity$1(ChooseTeacherActivity chooseTeacherActivity) {
        this.O000000o = chooseTeacherActivity;
    }

    public void afterTextChanged(Editable editable) {
        if (ChooseTeacherActivity.O000000o(this.O000000o) != null) {
            ChooseTeacherActivity.O000000o(this.O000000o).clear();
        }
        String trim = ChooseTeacherActivity.O00000Oo(this.O000000o).getText().toString().trim();
        if (ChooseTeacherActivity.O00000o0(this.O000000o) != null) {
            for (TeacherResModel teacherResModel : ChooseTeacherActivity.O00000o0(this.O000000o)) {
                if (teacherResModel.teacherName.startsWith(trim)) {
                    ChooseTeacherActivity.O000000o(this.O000000o).add(teacherResModel);
                }
                ChooseTeacherActivity.O00000o(this.O000000o).notifyDataSetChanged();
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
