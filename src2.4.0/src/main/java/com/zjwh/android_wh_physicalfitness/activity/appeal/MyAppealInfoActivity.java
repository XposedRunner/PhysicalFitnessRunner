package com.zjwh.android_wh_physicalfitness.activity.appeal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.AppealInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MyAppealInfoActivity extends BaseActivity {
    public static final String O000000o = "extra_rrid";
    @ViewInject(2131297311)
    private TextView O00000Oo;
    @ViewInject(2131297312)
    private TextView O00000o;
    @ViewInject(2131297310)
    private TextView O00000o0;
    @ViewInject(2131296518)
    private TextView O00000oO;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000oo;
    private int O0000O0o;
    private AppealInfoBean O0000OOo;

    static {
        C.i(16777294);
    }

    public static native void O000000o(Activity activity, int i);

    private native void O000000o(Bundle bundle);

    public native int O000000o();

    public native void O00000Oo();

    public void O00000o() {
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O000OO0o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rrid", this.O0000O0o);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                MyAppealInfoActivity.this.O0000OoO();
                if (!MyAppealInfoActivity.this.isFinishing()) {
                    MyAppealInfoActivity.this.O00000oo.O000000o(null, MyAppealInfoActivity.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                        public void onClick(View view) {
                            MyAppealInfoActivity.this.O00000o();
                        }
                    });
                }
            }

            public void onFinished() {
                MyAppealInfoActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                if (!MyAppealInfoActivity.this.isFinishing()) {
                    MyAppealInfoActivity.this.O00000oo.O000000o();
                    MyAppealInfoActivity.this.O0000OOo = (AppealInfoBean) O000o000.O000000o().fromJson(str, AppealInfoBean.class);
                    if (MyAppealInfoActivity.this.O0000OOo != null) {
                        if (MyAppealInfoActivity.this.O0000OOo.getAppealStatus() == 3) {
                            MyAppealInfoActivity.this.O00000Oo.setText("审核通过");
                            MyAppealInfoActivity.this.O00000Oo.setTextColor(ContextCompat.getColor(MyAppealInfoActivity.this.O0000o0, R.color.green));
                        } else if (MyAppealInfoActivity.this.O0000OOo.getAppealStatus() == 4) {
                            MyAppealInfoActivity.this.O00000Oo.setText("审核未通过");
                            MyAppealInfoActivity.this.O00000Oo.setTextColor(ContextCompat.getColor(MyAppealInfoActivity.this.O0000o0, R.color.red));
                        } else if (MyAppealInfoActivity.this.O0000OOo.getAppealStatus() == 2) {
                            MyAppealInfoActivity.this.O00000Oo.setText("审核中");
                            MyAppealInfoActivity.this.O00000Oo.setTextColor(ContextCompat.getColor(MyAppealInfoActivity.this.O0000o0, R.color.text_color_hint));
                        }
                        MyAppealInfoActivity.this.O00000o0.setText(MyAppealInfoActivity.this.O0000OOo.getVerifier());
                        MyAppealInfoActivity.this.O00000oO.setText(MyAppealInfoActivity.this.O0000OOo.getVerifyInfo());
                        MyAppealInfoActivity.this.O00000o.setText(O000O0o0.O000000o(O000O0o0.O0000o00, MyAppealInfoActivity.this.O0000OOo.getVerifyTime()));
                    }
                }
            }
        }));
    }

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onSaveInstanceState(Bundle bundle);
}
