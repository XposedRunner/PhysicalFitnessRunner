package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.activity.mine.PersonalInfoActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChangeMyPhoneNumActivity extends BaseActivity {
    @ViewInject(2131297158)
    public TextView O000000o;
    @ViewInject(2131296740)
    private ImageView O00000Oo;
    @ViewInject(2131296520)
    private EditText O00000o;
    @ViewInject(2131296974)
    private TextView O00000o0;
    @ViewInject(2131296521)
    private EditText O00000oO;
    @ViewInject(2131297363)
    private TextView O00000oo;
    private O00OOo O0000O0o;
    private String O0000OOo;
    private UserInfo O0000Oo0;

    static {
        C.i(16777331);
    }

    public static native void O000000o(Activity activity);

    private native void O00000o();

    private native void O00000oO();

    private void O00000oo() {
        this.O0000OOo = this.O00000o.getText().toString().trim();
        String trim = this.O00000oO.getText().toString().trim();
        if (TextUtils.isEmpty(this.O0000OOo) || !O00O0OOo.O000000o(this.O0000OOo)) {
            O00Oo00.O000000o("输入有效手机号");
        } else if (TextUtils.isEmpty(trim)) {
            O00Oo00.O000000o("验证码不能为空");
        } else {
            O00000oO(getString(R.string.txt_loading));
            gj gjVar = new gj(gk.O000o0o0);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("phone", this.O0000OOo);
                jSONObject.put("verCode", trim);
                gjVar.setBodyContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    ChangeMyPhoneNumActivity.this.O0000OoO();
                    O00Oo00.O000000o(responseError.getMessage());
                }

                public void onFinished() {
                    ChangeMyPhoneNumActivity.this.O0000OoO();
                }

                public void onSuccess(String str) {
                    ChangeMyPhoneNumActivity.this.O0000Oo0.setUsername(ChangeMyPhoneNumActivity.this.O0000OOo);
                    O00Oo0.O000000o(ChangeMyPhoneNumActivity.this.O0000Oo0);
                    O00000Oo.O000000o(PersonalInfoActivity.class);
                    O00000Oo.O00000o0(CheckMyPhoneNumActivity.class);
                    O00000Oo.O00000o0(ChangeMyPhoneNumActivity.class);
                }
            }));
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
