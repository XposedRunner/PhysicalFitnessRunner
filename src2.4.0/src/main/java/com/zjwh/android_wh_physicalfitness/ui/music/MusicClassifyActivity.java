package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicClassifyBean;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fn;
import defpackage.fn.O00000Oo;
import defpackage.hq;
import defpackage.hq.O000000o;
import defpackage.ka;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MusicClassifyActivity extends BaseActivity implements O00000Oo, hq.O00000Oo {
    public static final String O000000o = "extra_select_classify";
    @ViewInject(2131296945)
    private RecyclerView O00000Oo;
    private fn O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;
    private O000000o O00000oO;

    static {
        C.i(16777345);
    }

    public static native void O000000o(Activity activity, String str);

    private O000000o O0000OOo() {
        if (this.O00000oO == null) {
            this.O00000oO = new ka(this, this.O0000o0);
        }
        return this.O00000oO;
    }

    private native void O0000Oo0();

    public native int O000000o();

    public native void O000000o(long j, String str);

    public void O000000o(List<MusicClassifyBean> list) {
        if (this.O00000o != null) {
            this.O00000o0.O000000o();
            this.O00000o.O000000o((List) list);
        }
    }

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public void O0000O0o() {
        if (!isFinishing()) {
            this.O00000o0.O000000o(null, getString(R.string.txt_music_error), getString(R.string.txt_music_reload), "", new OnClickListener() {
                public void onClick(View view) {
                    MusicClassifyActivity.this.O0000OOo().O000000o();
                }
            });
        }
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O0000OOo = O0000OOo();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000OOo.O000000o(bundle);
        if (!isFinishing()) {
            O0000Oo0();
            O0000OOo().O000000o();
        }
    }

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);
}
