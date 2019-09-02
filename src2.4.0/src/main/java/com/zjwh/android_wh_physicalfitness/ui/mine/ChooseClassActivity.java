package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.BindAccountActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean;
import defpackage.fg;
import defpackage.fg.O00000Oo;
import defpackage.hg;
import defpackage.hg.O000000o;
import defpackage.jp;
import java.util.List;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChooseClassActivity extends BaseActivity implements O00000Oo, hg.O00000Oo {
    @ViewInject(2131296945)
    private RecyclerView O000000o;
    @ViewInject(2131297199)
    private TextView O00000Oo;
    private O000000o O00000o;
    private fg O00000o0;

    static {
        C.i(16777334);
    }

    public static native void O000000o(Activity activity, int i, String str, int i2, String str2);

    private native void O0000OOo();

    @Event({2131296679})
    private void clickEvent(View view) {
        com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(BindAccountActivity.class);
        finish();
    }

    public native int O000000o();

    public native void O000000o(Intent intent);

    public native void O000000o(ResponseError responseError);

    public native void O000000o(ClassBean classBean);

    public native void O000000o(String str);

    public void O000000o(List<ClassBean> list) {
        this.O00000o0.O000000o((List) list);
    }

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public O000000o O0000O0o() {
        if (this.O00000o == null) {
            this.O00000o = new jp(this);
        }
        return this.O00000o;
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE, XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
        getWindow().setBackgroundDrawableResource(R.color.white);
        super.onCreate(bundle);
        O000000o O0000O0o = O0000O0o();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000O0o.O000000o(bundle);
        if (!isFinishing()) {
            O0000OOo();
            O0000O0o().O000000o((Context) this);
        }
    }
}
