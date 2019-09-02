package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class SecretActivity extends BaseActivity implements OnCheckedChangeListener {
    @ViewInject(2131297050)
    public SwitchCompat O000000o;
    @ViewInject(2131297048)
    public SwitchCompat O00000Oo;
    @ViewInject(2131297429)
    public TextView O00000o;
    @ViewInject(2131297049)
    public SwitchCompat O00000o0;
    private UserInfo O00000oO = null;

    static {
        C.i(16777312);
    }

    public native int O000000o();

    public void O000000o(int i, int i2, int i3) {
        gj gjVar = new gj(gk.O000O00o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nameSecret", i);
            jSONObject.put("departmentSecret", i2);
            jSONObject.put("yearSecret", i3);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                O00Oo0.O000000o(SecretActivity.this.O00000oO);
            }
        }));
    }

    public native void O00000Oo();

    public native void O00000o();

    public void n_() {
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.sc_allow_others_see_myDepart /*2131297048*/:
                this.O00000oO.setDepartmentSecret(z ^ 1);
                O000000o(this.O00000oO.getNameSecret(), this.O00000oO.getDepartmentSecret(), this.O00000oO.getYearSecret());
                return;
            case R.id.sc_allow_others_see_myGrade /*2131297049*/:
                this.O00000oO.setYearSecret(z ^ 1);
                O000000o(this.O00000oO.getNameSecret(), this.O00000oO.getDepartmentSecret(), this.O00000oO.getYearSecret());
                return;
            case R.id.sc_allow_others_see_myName /*2131297050*/:
                this.O00000oO.setNameSecret(z ^ 1);
                O000000o(this.O00000oO.getNameSecret(), this.O00000oO.getDepartmentSecret(), this.O00000oO.getYearSecret());
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        setTheme(R.style.SwitchCompat);
        super.onCreate(bundle);
        this.O00000oO = O00Oo0.O00000o0();
        if (this.O00000oO == null) {
            O00Oo00.O00000Oo((int) R.string.get_extra_fail);
            finish();
        }
        if (!isFinishing()) {
            O00000o();
        }
    }
}
