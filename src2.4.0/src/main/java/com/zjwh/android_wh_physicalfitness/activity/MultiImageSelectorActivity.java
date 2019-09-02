package com.zjwh.android_wh_physicalfitness.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.fragment.MultiImageSelectorFragment.O000000o;
import java.io.File;
import java.util.ArrayList;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MultiImageSelectorActivity extends BaseActivity implements O000000o {
    public static final String O000000o = "max_select_count";
    public static final String O00000Oo = "select_count_mode";
    public static final String O00000o = "select_result";
    public static final String O00000o0 = "show_camera";
    public static final String O00000oO = "default_list";
    public static final int O00000oo = 0;
    public static final int O0000O0o = 1;
    private ArrayList<String> O0000OOo = new ArrayList();
    @ViewInject(2131296740)
    private ImageView O0000Oo;
    private int O0000Oo0;
    @ViewInject(2131297158)
    private TextView O0000o;

    static {
        C.i(16777284);
    }

    public native int O000000o();

    public native void O000000o(File file);

    public native void O000000o(String str);

    public native void O00000Oo();

    public native void O00000Oo(String str);

    public native void O00000o();

    public native void O00000o0(String str);

    public void n_() {
    }

    public native void onCreate(Bundle bundle);
}
