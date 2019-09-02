package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.rollcall.RollCallRecordBean;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fi;
import defpackage.hi.O000000o;
import defpackage.hi.O00000Oo;
import defpackage.jr;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RollCallRecordActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296795)
    private LoadingEmptyLayout O000000o;
    @ViewInject(2131296945)
    private RecyclerView O00000Oo;
    private fi O00000o;
    private O000000o O00000o0;
    private O00000o0 O00000oO;

    static {
        C.i(16777339);
    }

    public static native void O000000o(Activity activity);

    private O000000o O00000oo() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new jr(this);
        }
        return this.O00000o0;
    }

    private native void O0000O0o();

    public native int O000000o();

    public native void O000000o(int i);

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            O0000OoO();
            this.O000000o.O000000o(null, responseError.getMessage(), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    RollCallRecordActivity.this.O00000oo().O000000o(RollCallRecordActivity.this.O0000o0);
                }
            });
        }
    }

    public void O000000o(List<RollCallRecordBean> list) {
        if (!isFinishing()) {
            O0000OoO();
            this.O000000o.O000000o();
            this.O00000o.O000000o(list);
        }
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(ResponseError responseError);

    public void O00000Oo(List<RollCallRecordBean> list) {
        this.O00000o.O00000Oo(list);
    }

    public native void O00000o();

    public native void O00000oO();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O0000O0o();
        O00000oo().O000000o(this.O0000o0);
    }
}
