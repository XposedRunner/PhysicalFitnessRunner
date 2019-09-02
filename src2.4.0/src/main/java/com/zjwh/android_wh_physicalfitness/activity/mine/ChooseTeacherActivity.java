package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ChooseTeaClassEvent;
import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.O00000o0;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChooseTeacherActivity extends BaseActivity {
    @ViewInject(2131297033)
    RecyclerView O000000o;
    @ViewInject(2131296515)
    private EditText O00000Oo;
    private fw<TeacherResModel> O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;
    private List<TeacherResModel> O00000oO;
    private List<TeacherResModel> O00000oo = new ArrayList();

    static {
        C.i(39);
    }

    public static native void O000000o(Activity activity);

    private native void O00000o();

    public native int O000000o();

    public native void O00000Oo();

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getTeaClass(ChooseTeaClassEvent chooseTeaClassEvent) {
        if (chooseTeaClassEvent != null) {
            this.O00000oO = chooseTeaClassEvent.getTeaClassData();
            if (this.O00000oO == null || this.O00000oO.size() <= 0) {
                this.O00000o0.O000000o(ContextCompat.getDrawable(this.O0000o0, 2131230924), null, "暂无任何授课老师");
            } else {
                this.O00000o0.O000000o();
                this.O00000oo.addAll(this.O00000oO);
                if (this.O00000o != null) {
                    this.O00000o.notifyDataSetChanged();
                }
            }
            O00000o0.O000000o().O0000O0o(chooseTeaClassEvent);
        }
    }

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
