package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O00000o;
import defpackage.ha.O000000o;
import defpackage.ha.O00000Oo;
import defpackage.jd;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class LoginActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296498)
    public EditText O000000o;
    @ViewInject(2131296496)
    public EditText O00000Oo;
    @ViewInject(2131297367)
    public TextView O00000o;
    @ViewInject(2131296701)
    public ImageView O00000o0;
    @ViewInject(2131296443)
    private ViewStub O00000oO;
    private Button O00000oo;
    private String O0000O0o = "";
    private String O0000OOo = "";
    private O000000o O0000Oo;
    private boolean O0000Oo0 = true;
    private O00000o O0000o;

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.LoginActivity$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ ResponseError O000000o;

        AnonymousClass1(ResponseError responseError) {
            this.O000000o = responseError;
        }

        public void onClick(View view) {
            LoginActivity.this.O00000o().O000000o(this.O000000o, (String) view.getTag());
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.LoginActivity$3 */
    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ ResponseError O000000o;

        AnonymousClass3(ResponseError responseError) {
            this.O000000o = responseError;
        }

        public void onClick(View view) {
            if (this.O000000o.getError() == jd.O00000o) {
                LoginActivity.this.O000000o(this.O000000o);
            } else {
                LoginActivity.this.O00000o().O000000o(this.O000000o, null);
            }
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.LoginActivity$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ String O00000Oo;

        AnonymousClass7(boolean z, String str) {
            this.O000000o = z;
            this.O00000Oo = str;
        }

        public void run() {
            if (this.O000000o && LoginActivity.this.O0000o != null && LoginActivity.this.O0000o.O00000oO()) {
                LoginActivity.this.O0000o.O00000o0();
            }
            LoginActivity.this.O000000o(true, (int) R.string.login);
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                O00Oo0.O000000o(LoginActivity.this, this.O00000Oo);
            }
        }
    }

    static {
        C.i(16777283);
    }

    private native void O000000o(int i);

    private native void O000000o(ResponseError responseError);

    private native void O000000o(boolean z, int i);

    private native void O0000Oo0();

    private boolean O0000o0() {
        this.O0000O0o = this.O000000o.getText().toString().trim();
        O00000o().O000000o(this.O0000O0o);
        if (TextUtils.isEmpty(this.O0000O0o) || !O00O0OOo.O00000o0(this.O0000O0o)) {
            O00Oo0.O000000o(this, R.string.msg_error_user_name);
            return false;
        }
        this.O0000OOo = this.O00000Oo.getText().toString().trim();
        if (this.O0000OOo.length() < 6 || this.O0000OOo.length() > 12) {
            O00Oo0.O000000o(this, R.string.msg_error_psw);
            return false;
        } else if (!O00O0OOo.O00000o0(this.O0000OOo)) {
            O00Oo0.O000000o(this, getString(R.string.msg_psw_format_error));
            return false;
        } else if (O00Oo0.O00000Oo(this)) {
            return true;
        } else {
            O00Oo0.O000000o(this, getString(R.string.network_not_connected));
            return false;
        }
    }

    private native void O0000o0O();

    @Event({2131296679, 2131296701, 2131297367, 2131297392, 2131297362})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            switch (view.getId()) {
                case R.id.iv_cancel /*2131296679*/:
                    onBackPressed();
                    break;
                case R.id.iv_show_psw /*2131296701*/:
                    if (this.O0000Oo0) {
                        this.O00000o0.setSelected(true);
                        this.O00000Oo.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        this.O00000o0.setSelected(false);
                        this.O00000Oo.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    this.O0000Oo0 ^= 1;
                    this.O00000Oo.postInvalidate();
                    Editable text = this.O00000Oo.getText();
                    if (text != null) {
                        Selection.setSelection(text, text.length());
                        break;
                    }
                    break;
                case R.id.tv_forget_psw /*2131297362*/:
                    startActivity(new Intent(this, ForgetPasswordActivity.class));
                    break;
                case R.id.tv_login /*2131297367*/:
                    O00O00o.O000000o((Activity) this);
                    break;
                case R.id.tv_register /*2131297392*/:
                    startActivity(new Intent(this, RegisterActivity.class));
                    overridePendingTransition(R.anim.act_fadein, R.anim.act_fadeout);
                    break;
            }
        }
    }

    public native int O000000o();

    public native void O000000o(ResponseError responseError, String str, int i);

    public native void O000000o(String str, String str2);

    public native void O000000o(String str, boolean z);

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public O000000o O00000o() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new jd(this.O0000o0, this);
        }
        return this.O0000Oo;
    }

    public native void O00000oO();

    public native void O00000oo();

    @PermissionSuccess(requestCode = 104)
    public void O0000O0o() {
        O000000o(1);
    }

    @PermissionFail(requestCode = 104)
    public void O0000OOo() {
        O00O00o.O000000o(this, 104);
    }

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public native void onBackPressed();

    public native void onConfigurationChanged(Configuration configuration);

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult((Activity) this, i, strArr, iArr);
    }
}
