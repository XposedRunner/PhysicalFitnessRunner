package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.MyDepartBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.dw;
import defpackage.dw.O00000Oo;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChangeMyDepartActivity extends BaseActivity implements O00000Oo {
    public static final int O000000o = 10000;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000Oo;
    @ViewInject(2131297199)
    private TextView O00000o;
    @ViewInject(2131296945)
    private RecyclerView O00000o0;
    private int O00000oO;
    private UserInfo O00000oo = null;
    private dw O0000O0o;
    private int O0000OOo = 0;
    private String O0000Oo0;

    static {
        C.i(16777330);
    }

    public static native void O000000o(Activity activity);

    private native void O00000o();

    private native void O00000oO();

    private void O00000oo() {
        if (this.O0000OOo == O00Oo0.O00000o0().getDepartmentId()) {
            finish();
            return;
        }
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O000o0o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("departId", this.O0000OOo);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                ChangeMyDepartActivity.this.O0000OoO();
                O00Oo00.O000000o(responseError.getMessage());
            }

            public void onFinished() {
                ChangeMyDepartActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                ChangeMyDepartActivity.this.O00000oo.setDepart(ChangeMyDepartActivity.this.O0000Oo0);
                ChangeMyDepartActivity.this.O00000oo.setDepartmentId(ChangeMyDepartActivity.this.O0000OOo);
                ChangeMyDepartActivity.this.O00000oo.setShowClassEnum(false);
                ChangeMyDepartActivity.this.O00000oo.setClassId(-1);
                ChangeMyDepartActivity.this.O00000oo.setGradeClass("");
                O00Oo0.O000000o(ChangeMyDepartActivity.this.O00000oo);
                ChangeMyDepartActivity.this.finish();
            }
        }));
    }

    public native int O000000o();

    public native void O000000o(MyDepartBean myDepartBean);

    public native void O00000Oo();

    public void n_() {
        this.O00000oo = O00Oo0.O00000o0();
        this.O00000oO = this.O00000oo.getUnid();
        this.O0000OOo = this.O00000oo.getDepartmentId();
        this.O0000Oo0 = this.O00000oo.getDepart();
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public native void onCreate(Bundle bundle);
}
