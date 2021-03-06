package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.music.AlbumListBean;
import defpackage.fp;
import defpackage.hu.O000000o;
import defpackage.hu.O00000Oo;
import defpackage.ke;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MusicSearchActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296945)
    private RecyclerView O000000o;
    @ViewInject(2131296515)
    private EditText O00000Oo;
    private O000000o O00000o;
    @ViewInject(2131297260)
    private TextView O00000o0;
    private fp O00000oO;
    private O00000o0 O00000oo;

    static {
        C.i(16777349);
    }

    public static native void O000000o(Activity activity, int i);

    private native void O0000o0();

    private void O0000o0O() {
        O0000o0o().O000000o(this.O00000Oo.getText().toString().trim());
    }

    private O000000o O0000o0o() {
        if (this.O00000o == null) {
            this.O00000o = new ke(this);
        }
        return this.O00000o;
    }

    public native int O000000o();

    public void O000000o(List<AlbumListBean> list, boolean z, boolean z2) {
        if (!(isFinishing() || this.O00000oO == null)) {
            if (z) {
                this.O00000oO.O00000Oo(list);
            } else {
                this.O00000oO.O000000o(list);
            }
            if (z2) {
                O0000O0o.O000000o(this.O000000o, LoadingFooter.O000000o.Normal);
            } else {
                this.O00000oo.O00000o(this.O00000oo.O00000Oo());
            }
        }
    }

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public native void O0000Oo0();

    public native boolean dispatchTouchEvent(MotionEvent motionEvent);

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O0000o0o = O0000o0o();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000o0o.O000000o(bundle);
        if (!isFinishing()) {
            O0000o0();
        }
    }

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);
}
