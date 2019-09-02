package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ChooseCourseEvt;
import com.zjwh.android_wh_physicalfitness.entity.TeaClassResModel;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MyCourseActivity extends BaseActivity {
    @ViewInject(2131297263)
    TextView O000000o;
    @ViewInject(2131297005)
    View O00000Oo;
    @ViewInject(2131297285)
    private TextView O00000o;
    @ViewInject(2131296795)
    LoadingEmptyLayout O00000o0;
    @ViewInject(2131297208)
    private TextView O00000oO;
    private TeaClassResModel O00000oo;

    static {
        C.i(40);
    }

    public static native void O000000o(Activity activity);

    private native void O000000o(ChooseCourseEvt chooseCourseEvt);

    private native void O00000o();

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateCourse(ChooseCourseEvt chooseCourseEvt) {
        if (chooseCourseEvt != null) {
            this.O00000o.setText(chooseCourseEvt.teacherName);
            this.O00000oO.setText(chooseCourseEvt.className);
            O000000o(chooseCourseEvt);
        }
    }
}
