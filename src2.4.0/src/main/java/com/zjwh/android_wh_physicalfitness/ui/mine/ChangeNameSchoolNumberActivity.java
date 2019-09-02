package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.cu;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChangeNameSchoolNumberActivity extends BaseActivity {
    @ViewInject(2131297158)
    public TextView O000000o;
    @ViewInject(2131296740)
    private ImageView O00000Oo;
    @ViewInject(2131296974)
    private TextView O00000o;
    @ViewInject(2131296972)
    private ImageView O00000o0;
    @ViewInject(2131297315)
    private TextView O00000oO;
    @ViewInject(2131296522)
    private EditText O00000oo;
    @ViewInject(2131296519)
    private EditText O0000O0o;
    private UserInfo O0000OOo = null;

    static {
        C.i(16777332);
    }

    public static native void O000000o(Activity activity);

    private void O00000o() {
        final String trim = this.O00000oo.getText().toString().trim();
        final String trim2 = this.O0000O0o.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            O00Oo00.O000000o("学号不能为空");
        } else if (TextUtils.isEmpty(trim2)) {
            O00Oo00.O000000o("姓名不能为空");
        } else if (trim2.equals(this.O0000OOo.getName()) && trim.equals(this.O0000OOo.getCampusId())) {
            finish();
        } else {
            O00000oO(getString(R.string.txt_loading));
            gj gjVar = new gj(gk.O000o0O);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("campusId", trim);
                jSONObject.put(cu.O000OO0o, trim2);
                gjVar.setBodyContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    ChangeNameSchoolNumberActivity.this.O0000OoO();
                    ChangeNameSchoolNumberActivity.this.O00000Oo("编辑失败", responseError.getMessage());
                }

                public void onFinished() {
                    ChangeNameSchoolNumberActivity.this.O0000OoO();
                }

                public void onSuccess(String str) {
                    ChangeNameSchoolNumberActivity.this.O0000OOo.setCampusId(trim);
                    ChangeNameSchoolNumberActivity.this.O0000OOo.setName(trim2);
                    O00Oo0.O000000o(ChangeNameSchoolNumberActivity.this.O0000OOo);
                    ChangeNameSchoolNumberActivity.this.finish();
                }
            }));
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        this.O0000OOo = O00Oo0.O00000o0();
        this.O00000oo.setText(this.O0000OOo.getCampusId());
        this.O0000O0o.setText(this.O0000OOo.getName());
    }

    public native void onCreate(Bundle bundle);
}
