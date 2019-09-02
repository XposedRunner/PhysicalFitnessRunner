package com.zjwh.android_wh_physicalfitness.ui.notice;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.NoticeListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.en;
import defpackage.hf.O000000o;
import defpackage.hf.O00000Oo;
import defpackage.ji;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class NoticeListActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131297041)
    public RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000Oo;
    private en O00000o;
    private O000000o O00000o0;

    static {
        C.i(16777351);
    }

    public static native void O000000o(Activity activity);

    private native void O0000O0o();

    private synchronized O000000o O0000OOo() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new ji(this);
        }
        return this.O00000o0;
    }

    public native int O000000o();

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            this.O00000Oo.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    NoticeListActivity.this.O0000OOo().O000000o(NoticeListActivity.this.O0000o0);
                }
            });
        }
    }

    public void O000000o(List<NoticeListBean> list) {
        this.O00000o.O000000o(list);
        this.O00000Oo.O000000o();
    }

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
