package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.MyCampusBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.dv;
import defpackage.dv.O00000Oo;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChangeMyCampusActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296945)
    private RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000Oo;
    private dv O00000o;
    @ViewInject(2131297199)
    private TextView O00000o0;
    private UserInfo O00000oO;
    private String O00000oo;
    private int O0000O0o;

    static {
        C.i(16777328);
    }

    public static native void O000000o(Activity activity);

    private native void O00000o();

    private native void O00000oO();

    private void O00000oo() {
        if (this.O0000O0o == O00Oo0.O00000oo()) {
            finish();
            return;
        }
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O000o0Oo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unid", this.O0000O0o);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                ChangeMyCampusActivity.this.O0000OoO();
                O00Oo00.O000000o(responseError.getMessage());
            }

            public void onFinished() {
                ChangeMyCampusActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                ChangeMyCampusActivity.this.O00000oO.setCampusName(ChangeMyCampusActivity.this.O00000oo);
                ChangeMyCampusActivity.this.O00000oO.setUnid(ChangeMyCampusActivity.this.O0000O0o);
                O00Oo0.O000000o(ChangeMyCampusActivity.this.O00000oO);
                ChangeMyCampusActivity.this.finish();
            }
        }));
    }

    public native int O000000o();

    public native void O000000o(MyCampusBean myCampusBean);

    public native void O00000Oo();

    public void n_() {
        this.O00000oO = O00Oo0.O00000o0();
        this.O0000O0o = this.O00000oO.getUnid();
    }

    public native void onCreate(Bundle bundle);
}
