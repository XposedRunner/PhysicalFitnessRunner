package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.AutoFixBean;
import defpackage.hz.O000000o;
import defpackage.hz.O00000Oo;
import defpackage.kk;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AutoFixGuideActivity extends BaseActivity implements O00000Oo {
    public static final String O000000o = "extra_bean";
    private static final String O00000Oo = "http://h5.gxapp.iydsj.com/autofix/modelintro.html";
    @ViewInject(2131297490)
    private WebView O00000o;
    @ViewInject(2131297008)
    private RelativeLayout O00000o0;
    @ViewInject(2131296984)
    private View O00000oO;
    private O000000o O00000oo;

    static {
        C.i(16777358);
    }

    public static native void O000000o(Context context, AutoFixBean autoFixBean);

    private native void O00000oO();

    private O000000o O00000oo() {
        if (this.O00000oo == null) {
            this.O00000oo = new kk();
        }
        return this.O00000oo;
    }

    private native void O0000O0o();

    @Event(type = OnClickListener.class, value = {2131296368})
    private void onClick(View view) {
        O00000oo().O000000o((Context) this);
    }

    public native int O000000o();

    public native void O00000Oo();

    public native void O00000o();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O00000oo = O00000oo();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O00000oo.O000000o(bundle);
        if (!isFinishing()) {
            O00000oO();
        }
    }

    public native void onDestroy();

    public native void onPause();

    public native void onResume();
}
