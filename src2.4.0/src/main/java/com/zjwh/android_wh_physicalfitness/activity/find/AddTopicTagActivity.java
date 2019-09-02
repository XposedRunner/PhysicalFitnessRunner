package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.TopicTagBean;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.dp;
import defpackage.dp.O00000o0;
import defpackage.gl.O000000o;
import defpackage.gl.O00000Oo;
import defpackage.iq;
import java.util.List;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AddTopicTagActivity extends BaseActivity implements O00000o0, O00000Oo {
    @ViewInject(2131296740)
    private ImageButton O000000o;
    @ViewInject(2131297158)
    private TextView O00000Oo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o;
    @ViewInject(2131296734)
    private LinearLayout O00000o0;
    @ViewInject(2131296942)
    private RecyclerView O00000oO;
    private dp O00000oo;
    private com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0 O0000O0o;
    private O000000o O0000OOo;
    private com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo O0000Oo0;

    static {
        C.i(16777300);
    }

    public static native void O000000o(Activity activity, int i, String str);

    private synchronized O000000o O0000OOo() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new iq(this);
        }
        return this.O0000OOo;
    }

    private native void O0000Oo0();

    @Event(type = OnClickListener.class, value = {2131296740})
    private void onClick(View view) {
        finish();
    }

    public native int O000000o();

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            this.O00000o.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    AddTopicTagActivity.this.O0000OOo().O000000o(AddTopicTagActivity.this.O0000o0);
                }
            });
        }
    }

    public native void O000000o(TopicTagBean topicTagBean);

    public void O000000o(List<TopicTagBean> list) {
        this.O00000oo.O000000o((List) list);
        this.O00000o.O000000o();
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public void O00000Oo(List<TopicTagBean> list) {
        this.O00000oo.O00000Oo(list);
    }

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);
}
