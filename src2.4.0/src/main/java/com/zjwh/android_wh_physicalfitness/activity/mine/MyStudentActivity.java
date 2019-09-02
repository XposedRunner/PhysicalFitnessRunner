package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.entity.ClassInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.SchoolsAndSemeBean;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfoBean;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.el;
import defpackage.el.O00000Oo;
import defpackage.em;
import defpackage.et;
import java.util.ArrayList;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MyStudentActivity extends BaseActivity implements O00000Oo, et.O00000Oo {
    @ViewInject(2131297158)
    public TextView O000000o;
    @ViewInject(2131297033)
    private RecyclerView O00000Oo;
    @ViewInject(2131296467)
    private DrawerLayout O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;
    @ViewInject(2131296974)
    private TextView O00000oO;
    @ViewInject(2131296740)
    private ImageView O00000oo;
    @ViewInject(2131296778)
    private LinearLayout O0000O0o;
    @ViewInject(2131296679)
    private ImageView O0000OOo;
    @ViewInject(2131297044)
    private RecyclerView O0000Oo;
    @ViewInject(2131297042)
    private RecyclerView O0000Oo0;
    @ViewInject(2131296361)
    private Button O0000o;
    private et O0000oO;
    private em O0000oO0;
    private el O0000oOO;
    private O00000o0 O0000oOo;
    private O00000o0 O0000oo;
    private O00000o0 O0000oo0;
    private int O0000ooO = 0;
    private List<SchoolsAndSemeBean> O0000ooo;
    private TextView O000O00o;
    private List<SemesterInfoBean> O00oOooO = new ArrayList();
    private ClassInfoBean O00oOooo;

    static {
        C.i(16777309);
    }

    private native View O000000o(String str);

    public static native void O000000o(Activity activity);

    private native void O00000o();

    private native void O00000oO();

    private native void O00000oo();

    private native void O0000O0o();

    public native int O000000o();

    public native void O000000o(SchoolsAndSemeBean schoolsAndSemeBean, int i);

    public native void O000000o(SemesterInfoBean semesterInfoBean);

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);
}
