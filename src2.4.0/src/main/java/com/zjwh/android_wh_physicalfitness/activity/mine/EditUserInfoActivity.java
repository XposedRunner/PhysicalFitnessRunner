package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.os.Bundle;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.request.QEditUserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00O0OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gj;
import defpackage.gk;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class EditUserInfoActivity extends BaseActivity {
    @ViewInject(2131297089)
    public EditText O000000o;
    private int O00000Oo = 3;
    private UserInfo O00000o = null;
    private int O00000o0 = -1;
    private OnMenuItemClickListener O00000oO = new OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.action_edit_submit) {
                EditUserInfoActivity.this.O00000oO();
            }
            return true;
        }
    };

    static {
        C.i(16777307);
    }

    private native void O000000o(String str, String str2);

    private native void O00000o();

    private void O00000oO() {
        final String trim = this.O000000o.getText().toString().trim();
        if (O00Oo0.O00000o0(trim)) {
            O000000o(this.O00000Oo == 6 ? getString(R.string.depart2) : getString(R.string.signature), getString(R.string.msg_invalid_string, new Object[]{this.O00000Oo == 6 ? getString(R.string.depart2) : getString(R.string.signature)}));
        } else if (this.O00000Oo == 6 && !O00O0OOo.O00000oO(trim)) {
            O000000o(getString(R.string.depart2), getString(R.string.txt_only_china_or_str));
        } else if (TextUtils.isEmpty(trim) && this.O00000Oo == 6) {
            O000000o(getString(R.string.depart2), getString(R.string.msg_depart_empty));
        } else if (this.O00000o0 == -1) {
            O000000o(getString(R.string.tip), getString(R.string.msg_user_invalid));
        } else {
            O00000oO(getString(R.string.txt_saving_record));
            gj gjVar = new gj(gk.O000OoOO);
            QEditUserInfo qEditUserInfo = new QEditUserInfo();
            if (this.O00000Oo == 3) {
                qEditUserInfo.setPersonalSign(trim);
                qEditUserInfo.setUpdateSign(true);
            }
            gjVar.setBodyContent(this.O0000OoO.toJson(qEditUserInfo));
            O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    O00Oo00.O000000o(responseError.getMessage());
                }

                public void onFinished() {
                    EditUserInfoActivity.this.O0000OoO();
                }

                public void onSuccess(String str) {
                    if (EditUserInfoActivity.this.O00000Oo == 3) {
                        EditUserInfoActivity.this.O00000o.setPsign(trim);
                    }
                    O00Oo0.O000000o(EditUserInfoActivity.this.O00000o);
                    EditUserInfoActivity.this.setResult(-1);
                    EditUserInfoActivity.this.finish();
                }
            }));
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        this.O00000Oo = getIntent().getIntExtra("type", 3);
        this.O00000o = O00Oo0.O00000o0();
        if (this.O00000o == null) {
            O00Oo00.O000000o((int) R.string.get_extra_fail);
            finish();
            return;
        }
        this.O00000o0 = this.O00000o.getUid();
    }

    public native void onCreate(Bundle bundle);

    public native boolean onCreateOptionsMenu(Menu menu);
}
