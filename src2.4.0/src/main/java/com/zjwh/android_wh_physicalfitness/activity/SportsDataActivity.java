package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.BarChartPoint;
import com.zjwh.android_wh_physicalfitness.entity.HomePage;
import com.zjwh.android_wh_physicalfitness.entity.PersonalSportData;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.BarChart;
import defpackage.gj;
import defpackage.gk;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class SportsDataActivity extends BaseActivity {
    public static final String O000000o = "extra_user_id";
    @ViewInject(2131297397)
    private TextView O00000Oo;
    @ViewInject(2131297436)
    private TextView O00000o;
    @ViewInject(2131297309)
    private TextView O00000o0;
    @ViewInject(2131296337)
    private BarChart O00000oO;
    @ViewInject(2131297307)
    private TextView O00000oo;
    @ViewInject(2131297308)
    private TextView O0000O0o;
    private List<BarChartPoint> O0000OOo = new ArrayList();
    private PersonalSportData O0000Oo;
    private int O0000Oo0 = -1;
    private HomePage O0000o;

    static {
        C.i(16777290);
    }

    public static native void O000000o(Activity activity, int i);

    private native void O000000o(Bundle bundle);

    public native int O000000o();

    public native void O00000Oo();

    public void O00000o() {
        gj gjVar = new gj(gk.O000o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.O0000Oo0);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!SportsDataActivity.this.isFinishing()) {
                    SportsDataActivity.this.O0000OoO();
                }
            }

            public void onFinished() {
                if (!SportsDataActivity.this.isFinishing()) {
                    SportsDataActivity.this.O0000OoO();
                }
            }

            public void onSuccess(String str) {
                SportsDataActivity.this.O0000Oo = (PersonalSportData) O000o000.O000000o().fromJson(str, PersonalSportData.class);
                if (SportsDataActivity.this.O0000Oo != null) {
                    SportsDataActivity.this.O00000Oo.setText(String.format(Locale.getDefault(), "%d次", new Object[]{Integer.valueOf(SportsDataActivity.this.O0000Oo.getSemesterCount())}));
                    SportsDataActivity.this.O00000o0.setText(String.format(Locale.getDefault(), "%s公里", new Object[]{O00Oo0.O00000o0(((double) SportsDataActivity.this.O0000Oo.getSemesterDis()) / 1000.0d)}));
                    SportsDataActivity.this.O00000o.setText(String.format(Locale.getDefault(), "%s公里", new Object[]{O00Oo0.O00000o0(((double) SportsDataActivity.this.O0000Oo.getSemesterValidDis()) / 1000.0d)}));
                    SportsDataActivity.this.O00000oo.setText(String.format(Locale.getDefault(), "%d天", new Object[]{Integer.valueOf(SportsDataActivity.this.O0000Oo.getTotalDays())}));
                    SportsDataActivity.this.O0000O0o.setText(String.format(Locale.getDefault(), "%s公里", new Object[]{O00Oo0.O00000o0(((double) SportsDataActivity.this.O0000Oo.getTotalDis()) / 1000.0d)}));
                }
            }
        }));
    }

    public native void O00000oO();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onSaveInstanceState(Bundle bundle);
}
