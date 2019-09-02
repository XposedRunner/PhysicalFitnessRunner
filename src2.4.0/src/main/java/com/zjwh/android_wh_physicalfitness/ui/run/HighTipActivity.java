package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.AutoFixBean;
import com.zjwh.android_wh_physicalfitness.entity.AutoFixBean.State;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import defpackage.fw;
import defpackage.ga;
import defpackage.ks;
import defpackage.mu.O000000o;
import defpackage.nd;
import java.util.ArrayList;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;
import zhy.com.highlight.O00000Oo;

public class HighTipActivity extends BaseActivity {
    private O00000Oo O000000o;
    @ViewInject(2131297118)
    private ViewStub O00000Oo;
    private View O00000o;
    @ViewInject(2131297119)
    private ViewStub O00000o0;
    private boolean O00000oO = true;

    static {
        C.i(16777361);
    }

    private native View O000000o(int i);

    public static native void O000000o(Activity activity);

    private void O00000o() {
        ArrayList arrayList = new ArrayList();
        AutoFixBean autoFixBean = new AutoFixBean("后台定位服务", "开启后台定位服务，进行正常运动", State.Normal);
        autoFixBean.setText("正常运行");
        arrayList.add(autoFixBean);
        autoFixBean = new AutoFixBean("GPS权限服务", "开启GPS权限服务，进行正常运动", State.Normal);
        autoFixBean.setText("信号良好");
        arrayList.add(autoFixBean);
        autoFixBean = new AutoFixBean("GPS信号服务", "开启GPS开关，进行正常运动", State.Normal);
        autoFixBean.setText("已开启");
        arrayList.add(autoFixBean);
        autoFixBean = new AutoFixBean("网络信号服务", "连接有效网络，进行正常运动", State.Normal);
        autoFixBean.setText("网络较优");
        arrayList.add(autoFixBean);
        if (this.O00000o0.getParent() != null) {
            RecyclerView recyclerView = (RecyclerView) this.O00000o0.inflate().findViewById(R.id.recycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new fw<AutoFixBean>(this.O0000o0, R.layout.auto_fix_item, arrayList) {
                /* Access modifiers changed, original: protected */
                public void O000000o(ga gaVar, AutoFixBean autoFixBean, int i) {
                    gaVar.O000000o((int) R.id.auto_title, autoFixBean.getTitle());
                    gaVar.O000000o((int) R.id.auto_sub_title, autoFixBean.getSubTitle());
                    gaVar.O000000o((int) R.id.auto_fix_state, TextUtils.isEmpty(autoFixBean.getText()) ? "" : autoFixBean.getText());
                    gaVar.O00000oo(R.id.auto_fix_state, R.color.text_color_major);
                    gaVar.O000000o((int) R.id.auto_fix_state, true);
                }
            });
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (!HighTipActivity.this.isFinishing()) {
                        HighTipActivity.this.O0000O0o();
                    }
                }
            }, 20);
        }
    }

    private native void O00000oO();

    private native void O00000oo();

    private void O0000O0o() {
        this.O000000o = new O00000Oo(this.O0000o0).O00000Oo(false).O000000o(true).O000000o(new O000000o() {
            public void O000000o() {
                HighTipActivity.this.O000000o.O0000Oo0();
                HighTipActivity.this.finish();
            }
        }).O000000o((int) R.id.auto_fix, LayoutInflater.from(this.O0000o0).inflate(R.layout.high_tip_auto_fix_high, null, false), new ks((float) DensityUtil.dip2px(10.0f)), new nd(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) DensityUtil.dip2px(13.0f), (float) DensityUtil.dip2px(13.0f)));
        this.O000000o.O0000OOo();
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00OOOo.O000000o((Activity) this, 0, null);
        this.O00000o = this.O00000Oo.inflate();
    }

    public native void onDestroy();

    public native void onResume();
}
