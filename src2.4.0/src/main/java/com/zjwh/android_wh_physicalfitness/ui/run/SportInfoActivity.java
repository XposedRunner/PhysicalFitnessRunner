package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.ui.mine.RunHistoryActivity;
import com.zjwh.android_wh_physicalfitness.view.progress.ProgressView;
import defpackage.if.O000000o;
import defpackage.if.O00000Oo;
import defpackage.kr;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class SportInfoActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296923)
    private ProgressView O000000o;
    @ViewInject(2131297300)
    private TextView O00000Oo;
    @ViewInject(2131297222)
    private TextView O00000o;
    @ViewInject(2131297284)
    private TextView O00000o0;
    @ViewInject(2131297219)
    private TextView O00000oO;
    @ViewInject(2131297290)
    private TextView O00000oo;
    @ViewInject(2131297262)
    private TextView O0000O0o;
    private O000000o O0000OOo;

    static {
        C.i(16777368);
    }

    public static native void O000000o(Activity activity, double d, double d2);

    private native void O0000OOo();

    @Event(type = OnMenuItemClickListener.class, value = {2131297163})
    private boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_run_info) {
            RunHistoryActivity.O000000o(this);
        }
        return true;
    }

    public native int O000000o();

    public native void O000000o(String str, String str2, int i);

    public native void O000000o(String str, String str2, String str3, String str4);

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public O000000o O0000O0o() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new kr(this);
        }
        return this.O0000OOo;
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.white);
        O0000OOo();
        O000000o O0000O0o = O0000O0o();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000O0o.O000000o(bundle);
        if (!isFinishing()) {
            O0000O0o().O000000o((Context) this);
        }
    }

    public native boolean onCreateOptionsMenu(Menu menu);

    public native void onDestroy();
}
