package com.zjwh.android_wh_physicalfitness.activity.appeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.AppealResultBean;
import com.zjwh.android_wh_physicalfitness.entity.HistoryRefresh;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gj;
import defpackage.gk;
import org.greenrobot.eventbus.O00000o0;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AppealActivity extends BaseActivity {
    public static final int O000000o = 1000;
    public static final int O00000Oo = 1001;
    private static final String O00000o = "extra_id";
    public static final String O00000o0 = "extra_info";
    @ViewInject(2131296517)
    private EditText O00000oO;
    private String O00000oo;
    private int O0000O0o;
    private AppealResultBean O0000OOo;

    static {
        C.i(16777293);
    }

    @Event({2131296360})
    private void MyClick(View view) {
        if (view.getId() == R.id.btn_appeal) {
            this.O00000oo = this.O00000oO.getText().toString().trim();
            if (O00Oo0.O00000o0(this.O00000oo)) {
                O00Oo00.O000000o((int) R.string.txt_no_emoji);
                return;
            }
            O00000o();
        }
    }

    public static native void O000000o(Activity activity, int i);

    private native void O000000o(Bundle bundle);

    private void O00000o() {
        O00000oO("正在提交");
        gj gjVar = new gj(gk.O000OO00);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rrid", this.O0000O0o);
            jSONObject.put("appealContent", this.O00000oo);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                AppealActivity.this.O0000OoO();
                if (!AppealActivity.this.isFinishing()) {
                    if (responseError.getError() == 11502) {
                        AppealActivity.this.O000000o("申诉失败", responseError.getMessage(), new OnClickListener() {
                            public void onClick(View view) {
                                AppealActivity.this.setResult(1001);
                                AppealActivity.this.finish();
                            }
                        });
                    } else {
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
                AppealActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                O00Oo00.O000000o("申诉成功", true);
                O00000o0.O000000o().O00000o(new HistoryRefresh(true));
                AppealActivity.this.O0000OOo = (AppealResultBean) O000o000.O000000o().fromJson(str, AppealResultBean.class);
                Intent intent = new Intent();
                intent.putExtra("extra_info", AppealActivity.this.O0000OOo != null ? AppealActivity.this.O0000OOo.getStatusInfo() : "成绩审核中，请耐心等待结果");
                AppealActivity.this.setResult(1000, intent);
                AppealActivity.this.finish();
            }
        }));
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onSaveInstanceState(Bundle bundle);
}
