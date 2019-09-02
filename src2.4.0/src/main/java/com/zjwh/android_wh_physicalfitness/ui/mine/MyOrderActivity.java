package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.gj;
import defpackage.gk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MyOrderActivity extends BaseActivity {
    @ViewInject(2131297377)
    private TextView O000000o;
    @ViewInject(2131297435)
    private TextView O00000Oo;
    private List<Fragment> O00000o = new ArrayList();
    @ViewInject(2131297306)
    private TextView O00000o0;
    private int O00000oO = 0;
    private int O00000oo = -1;
    private MyOrderFragment O0000O0o;
    private MyOrderFragment O0000OOo;
    private MyOrderFragment O0000Oo0;

    static {
        C.i(16777335);
    }

    public static native void O000000o(Activity activity);

    private void O00000oO() {
        O00000oO(getString(R.string.txt_loading));
        int O00000oO = O00Oo0.O00000oO();
        gj gjVar = new gj(gk.O00OoO0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", O00000oO);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                MyOrderActivity.this.O0000OoO();
                MyOrderActivity.this.O0000O0o.O00000Oo(-1);
                MyOrderActivity.this.O0000OOo.O00000Oo(-1);
                MyOrderActivity.this.O0000Oo0.O00000Oo(-1);
            }

            public void onFinished() {
                MyOrderActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                MyOrderActivity.this.O00000oo = ((Integer) O000o000.O000000o().fromJson(str, Integer.class)).intValue();
                MyOrderActivity.this.O0000O0o.O00000Oo(MyOrderActivity.this.O00000oo);
                MyOrderActivity.this.O0000OOo.O00000Oo(MyOrderActivity.this.O00000oo);
                MyOrderActivity.this.O0000Oo0.O00000Oo(MyOrderActivity.this.O00000oo);
            }
        }));
    }

    @Event({2131297377, 2131297435, 2131297306})
    private void onClick(View view) {
        int id = view.getId();
        int i = 0;
        if (id == R.id.tv_all) {
            i = 2;
        } else if (id != R.id.tv_not_used && id == R.id.tv_used) {
            i = 1;
        }
        if (this.O00000oO != i) {
            O000000o(i);
        }
    }

    public native int O000000o();

    public native void O000000o(int i);

    public native void O00000Oo();

    public native void O00000o();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);
}
