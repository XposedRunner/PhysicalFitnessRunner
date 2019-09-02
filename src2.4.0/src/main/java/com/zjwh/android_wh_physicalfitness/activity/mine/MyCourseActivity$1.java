package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ChooseTeaClassEvent;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import org.greenrobot.eventbus.O00000o0;

class MyCourseActivity$1 implements OnClickListener {
    final /* synthetic */ MyCourseActivity O000000o;

    MyCourseActivity$1(MyCourseActivity myCourseActivity) {
        this.O000000o = myCourseActivity;
    }

    public void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            if (MyCourseActivity.O000000o(this.O000000o) == null) {
                O00Oo00.O00000Oo((int) R.string.courselist_error);
                MyCourseActivity.O00000Oo(this.O000000o);
                return;
            }
            O00000o0.O000000o().O00000oo(new ChooseTeaClassEvent(MyCourseActivity.O000000o(this.O000000o).teacherResModels));
            ChooseTeacherActivity.O000000o(this.O000000o);
        }
    }
}
