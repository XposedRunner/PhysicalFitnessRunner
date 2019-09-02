package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityCipher;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class CheckMyPhoneNumActivity extends BaseActivity {
    @ViewInject(2131297385)
    private TextView O000000o;
    @ViewInject(2131296521)
    private EditText O00000Oo;
    @ViewInject(2131297323)
    private TextView O00000o0;

    static {
        C.i(16777333);
    }

    public static native void O000000o(Activity activity);

    private void O00000o() {
        String trim = this.O00000Oo.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            O00Oo00.O000000o("密码不能为空");
        } else if (trim.length() < 6 || trim.length() > 12) {
            O00Oo00.O000000o((int) R.string.msg_error_psw);
        } else {
            try {
                Object atlasEncryptString;
                O00000oO(getString(R.string.txt_loading));
                String str = "";
                try {
                    atlasEncryptString = new SecurityCipher(getApplicationContext()).atlasEncryptString(trim);
                } catch (JAQException e) {
                    e.printStackTrace();
                    x.O00000Oo(MyApplication.O000000o(), "change password signPwd ali sign error!");
                    atlasEncryptString = str;
                }
                gj gjVar = new gj(gk.O000oO00);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("signPwd", atlasEncryptString);
                    gjVar.setBodyContent(jSONObject.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                    public void onCancelled(CancelledException cancelledException) {
                    }

                    public void onError(ResponseError responseError) {
                        CheckMyPhoneNumActivity.this.O0000OoO();
                        O00Oo00.O000000o(responseError.getMessage());
                    }

                    public void onFinished() {
                        CheckMyPhoneNumActivity.this.O0000OoO();
                    }

                    public void onSuccess(String str) {
                        ChangeMyPhoneNumActivity.O000000o(CheckMyPhoneNumActivity.this);
                    }
                }));
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        this.O000000o.setText(O00Oo0.O00000o0().getUsername());
    }

    public native void onCreate(Bundle bundle);
}
