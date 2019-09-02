package com.zjwh.android_wh_physicalfitness.ui.mine;

import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.utils.O000o00.O00000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import java.io.File;

class SchoolNumBackActivity$5 implements O00000o {
    final /* synthetic */ SchoolNumBackActivity O000000o;

    SchoolNumBackActivity$5(SchoolNumBackActivity schoolNumBackActivity) {
        this.O000000o = schoolNumBackActivity;
    }

    public void O000000o() {
        if (SchoolNumBackActivity.O00000o0(this.O000000o) != null && SchoolNumBackActivity.O00000o0(this.O000000o).isShowing()) {
            SchoolNumBackActivity.O00000o0(this.O000000o).dismiss();
        }
        O00Oo00.O000000o(this.O000000o.getString(R.string.msg_set_pic_error), false);
    }

    public void O000000o(File file) {
        SchoolNumBackActivity.O000000o(this.O000000o, file);
    }
}
