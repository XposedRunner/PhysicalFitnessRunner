package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.MyDepartBean;
import defpackage.dz;
import defpackage.dz.O00000Oo;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChooseDepartActivity extends BaseActivity implements O00000Oo {
    public static final String O000000o = "extra_unid";
    public static final String O00000Oo = "extra_school_name";
    @ViewInject(2131296679)
    private ImageView O00000o;
    @ViewInject(2131296942)
    private RecyclerView O00000o0;
    private dz O00000oO;
    private String O00000oo;
    private int O0000O0o = -1;

    static {
        C.i(16777276);
    }

    public static native void O000000o(Activity activity, int i, String str);

    private native void O000000o(Bundle bundle);

    private native void O00000o();

    private native void O00000oO();

    public native int O000000o();

    public native void O000000o(MyDepartBean myDepartBean);

    public native void O00000Oo();

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public native void onCreate(Bundle bundle);

    public native void onSaveInstanceState(Bundle bundle);
}
