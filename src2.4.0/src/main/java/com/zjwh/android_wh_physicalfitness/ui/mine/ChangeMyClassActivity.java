package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.ff;
import defpackage.ff.O00000Oo;
import defpackage.hg;
import defpackage.hg.O000000o;
import defpackage.jp;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChangeMyClassActivity extends BaseActivity implements O00000Oo, hg.O00000Oo {
    @ViewInject(2131296945)
    private RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000Oo;
    private ff O00000o;
    @ViewInject(2131297199)
    private TextView O00000o0;
    private O000000o O00000oO;

    static {
        C.i(16777329);
    }

    public static native void O000000o(Activity activity, int i, String str, int i2, String str2);

    private native void O0000OOo();

    public native int O000000o();

    public native void O000000o(Intent intent);

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            this.O00000Oo.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    ChangeMyClassActivity.this.O0000O0o().O000000o(ChangeMyClassActivity.this);
                }
            });
        }
    }

    public native void O000000o(ClassBean classBean);

    public native void O000000o(String str);

    public void O000000o(List<ClassBean> list) {
        this.O00000o.O000000o((List) list);
    }

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public O000000o O0000O0o() {
        if (this.O00000oO == null) {
            this.O00000oO = new jp(this);
        }
        return this.O00000oO;
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
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
