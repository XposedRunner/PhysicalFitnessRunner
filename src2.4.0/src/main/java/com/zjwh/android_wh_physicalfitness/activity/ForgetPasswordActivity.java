package com.zjwh.android_wh_physicalfitness.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.request.QRegisterCheckVerCode;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gj;
import defpackage.gk;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ForgetPasswordActivity extends BaseActivity {
    @ViewInject(2131296495)
    public EditText O000000o;
    @ViewInject(2131296499)
    public EditText O00000Oo;
    @ViewInject(2131297331)
    public TextView O00000o;
    @ViewInject(2131296496)
    public EditText O00000o0;
    @ViewInject(2131297363)
    public TextView O00000oO;
    private O00OOo O00000oo;

    static {
        C.i(16777281);
    }

    private native void O000000o(String str);

    private void O00000o() {
        String trim = this.O000000o.getText().toString().trim();
        if (TextUtils.isEmpty(trim) || !O00O0OOo.O000000o(trim)) {
            O00Oo0.O000000o(this, R.string.msg_invalid_phone_number);
            return;
        }
        String trim2 = this.O00000Oo.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            O00Oo0.O000000o(this, R.string.msg_invalid_ver_code);
            return;
        }
        String trim3 = this.O00000o0.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            O00Oo0.O000000o(this, R.string.hint_input_psw);
        } else if (trim3.length() < 6 || trim3.length() > 12) {
            O00Oo0.O000000o(this, R.string.hint_input_psw);
        } else if (O00O0OOo.O00000o0(trim3)) {
            this.O00000o.setEnabled(false);
            this.O00000o.setText(R.string.optioning);
            this.O00000o.setBackgroundResource(R.drawable.shape_non_option);
            gj gjVar = new gj(gk.O0000Oo0);
            gjVar.setBodyContent(this.O0000OoO.toJson(new QRegisterCheckVerCode(trim, trim2, trim3)));
            HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    O00Oo0.O000000o(ForgetPasswordActivity.this, responseError.getMessage());
                }

                public void onFinished() {
                    ForgetPasswordActivity.this.O00000o.setEnabled(true);
                    ForgetPasswordActivity.this.O00000o.setText(R.string.txt_sure);
                    ForgetPasswordActivity.this.O00000o.setBackgroundResource(R.drawable.shape_option);
                }

                public void onSuccess(String str) {
                    O00Oo00.O000000o(ForgetPasswordActivity.this.O0000o0, (int) R.string.txt_reset_psw_success);
                    ForgetPasswordActivity.this.finish();
                }
            });
        } else {
            O00Oo0.O000000o(this, R.string.msg_psw_format_error);
        }
    }

    @Event(type = OnClickListener.class, value = {2131296679, 2131297363, 2131297331})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            int id = view.getId();
            if (id == R.id.iv_cancel) {
                O00000Oo.O000000o(WelcomeLoginActivity.class);
                finish();
            } else if (id == R.id.tv_complete) {
                O00000o();
            } else if (id == R.id.tv_get_ver_code) {
                String trim = this.O000000o.getText().toString().trim();
                if (O00O0OOo.O000000o(trim)) {
                    this.O00000Oo.requestFocus();
                    O000000o(trim);
                } else {
                    O00Oo0.O000000o(this, R.string.msg_invalid_phone_number);
                }
            }
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
