package com.zjwh.android_wh_physicalfitness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.request.QRegisterCheckVerCode;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.gg;
import defpackage.gj;
import defpackage.gk;
import defpackage.jd;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RegisterActivity extends BaseActivity {
    @ViewInject(2131296495)
    public EditText O000000o;
    @ViewInject(2131296499)
    public EditText O00000Oo;
    @ViewInject(2131297391)
    public TextView O00000o;
    @ViewInject(2131296496)
    public EditText O00000o0;
    @ViewInject(2131297373)
    public TextView O00000oO;
    @ViewInject(2131297363)
    public TextView O00000oo;
    private O00OOo O0000O0o;

    static {
        C.i(16777286);
    }

    private native void O000000o(UserInfo userInfo, String str, String str2);

    private native void O000000o(String str);

    private native void O00000o();

    private void O00000oO() {
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
        if (TextUtils.isEmpty(trim3) || trim3.length() > 12 || trim3.length() < 6) {
            O00Oo0.O000000o(this, R.string.hint_input_psw);
        } else if (!O00O0OOo.O00000o0(trim3)) {
            O00Oo0.O000000o(this, R.string.msg_psw_format_error);
        } else if (O00Oo0.O00000Oo(this)) {
            this.O00000oO.setEnabled(false);
            this.O00000oO.setText(R.string.optioning);
            this.O00000oO.setBackgroundResource(R.drawable.shape_non_option);
            gj gjVar = new gj(gk.O00O0ooo);
            gjVar.setBodyContent(this.O0000OoO.toJson(new QRegisterCheckVerCode(trim, trim2, trim3)));
            O000000o(HttpUtil.postOp(this.O0000o0, gjVar, O000000o(trim, trim3)));
        } else {
            O00Oo0.O000000o(this, getString(R.string.network_not_connected));
        }
    }

    @Event(type = OnClickListener.class, value = {2131297363, 2131297373, 2131297391, 2131296679})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            int id = view.getId();
            if (id == R.id.iv_cancel) {
                O00000Oo.O000000o(WelcomeLoginActivity.class);
                finish();
            } else if (id == R.id.tv_get_ver_code) {
                this.O00000Oo.requestFocus();
                String trim = this.O000000o.getText().toString().trim();
                if (O00O0OOo.O000000o(trim)) {
                    O000000o(trim);
                } else {
                    O00Oo0.O000000o(this, R.string.msg_invalid_phone_number);
                }
            } else if (id == R.id.tv_next) {
                O00000oO();
            } else if (id == R.id.tv_protocol) {
                startActivity(new Intent(this, ClauseActivity.class));
            }
        }
    }

    public native int O000000o();

    public MyCallback<String> O000000o(final String str, final String str2) {
        return new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(final ResponseError responseError) {
                if (responseError.getError() == jd.O000000o) {
                    RegisterActivity.this.O000000o(new UserInfo(), str, str2);
                    new O0000Oo(RegisterActivity.this).O000000o().O000000o(false).O00000Oo(false).O000000o("绑定设备").O00000Oo(responseError.getMessage()).O000000o((int) R.string.cancel, new OnClickListener() {
                        public void onClick(View view) {
                            O00000Oo.O000000o(WelcomeLoginActivity.class);
                            RegisterActivity.this.finish();
                        }
                    }).O00000Oo((int) R.string.sure, new OnClickListener() {
                        public void onClick(View view) {
                            RegisterActivity.this.O000000o(responseError, str, str2);
                        }
                    }).O00000Oo();
                    return;
                }
                O00Oo0.O000000o(RegisterActivity.this, responseError.getMessage());
            }

            public void onFinished() {
                RegisterActivity.this.O00000oO.setEnabled(true);
                RegisterActivity.this.O00000oO.setText(R.string.txt_next);
                RegisterActivity.this.O00000oO.setBackgroundResource(R.drawable.shape_option);
            }

            public void onSuccess(String str) {
                UserInfo userInfo = (UserInfo) RegisterActivity.this.O0000OoO.fromJson(str, UserInfo.class);
                if (userInfo != null) {
                    if (TextUtils.isEmpty(userInfo.getToken())) {
                        O00Oo0.O000000o(gg.O000OOoO, "");
                    }
                    O00O0Oo0.O000000o(gg.O000o0O0, userInfo.getToken());
                    O00O0Oo0.O000000o(gg.O000o0O, Integer.valueOf(userInfo.getUid()));
                    RegisterActivity.this.O000000o(userInfo, str, str2);
                    O00000Oo.O000000o(WelcomeLoginActivity.class);
                    BindAccountActivity.O000000o(RegisterActivity.this);
                    RegisterActivity.this.finish();
                }
            }
        };
    }

    public native void O000000o(ResponseError responseError, String str, String str2);

    public native void O00000Oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native boolean onKeyDown(int i, KeyEvent keyEvent);
}
