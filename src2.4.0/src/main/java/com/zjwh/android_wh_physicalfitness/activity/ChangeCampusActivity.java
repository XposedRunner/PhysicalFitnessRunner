package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.GetCampusEvt;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.RunModeModel;
import com.zjwh.android_wh_physicalfitness.entity.database.NearBySchoolBean;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.du;
import defpackage.du.O00000o0;
import defpackage.gj;
import defpackage.gk;
import defpackage.li;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChangeCampusActivity extends BaseActivity implements O00000o0 {
    @ViewInject(2131296942)
    private RecyclerView O000000o;
    private du O00000Oo;
    private li O00000o;
    private List<NearBySchoolBean> O00000o0 = new ArrayList();

    static {
        C.i(16777275);
    }

    public static native void O000000o(Activity activity);

    private native void O00000oo();

    private native void O0000O0o();

    @Event({2131296679})
    private void onClick(View view) {
        if (view.getId() == R.id.iv_cancel) {
            finish();
        }
    }

    public native int O000000o();

    public void O000000o(double d, double d2) {
        gj gjVar = new gj(gk.O000O0oo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lat", d);
            jSONObject.put("lon", d2);
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
                ChangeCampusActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                List list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<NearBySchoolBean>>() {
                }.getType());
                if (list != null && list.size() > 0) {
                    NearBySchoolBean nearBySchoolBean = new NearBySchoolBean();
                    nearBySchoolBean.setCampusName("附近校区");
                    nearBySchoolBean.setViewType(1);
                    ChangeCampusActivity.this.O00000o0.add(nearBySchoolBean);
                    ChangeCampusActivity.this.O00000o0.addAll(list);
                    ChangeCampusActivity.this.O00000Oo.notifyDataSetChanged();
                }
            }
        }));
    }

    public native void O000000o(NearBySchoolBean nearBySchoolBean);

    public native void O00000Oo();

    public void O00000Oo(final NearBySchoolBean nearBySchoolBean) {
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O000OOoO);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unid", nearBySchoolBean.getUnid());
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                O00Oo00.O000000o(responseError.getMessage(), false);
            }

            public void onFinished() {
                ChangeCampusActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                org.greenrobot.eventbus.O00000o0.O000000o().O00000o(new GetCampusEvt(nearBySchoolBean, (RunModeModel) O000o000.O000000o().fromJson(str, RunModeModel.class)));
                ChangeCampusActivity.this.finish();
            }
        }));
    }

    public native void O00000o();

    public void O00000oO() {
        try {
            List O0000OoO = O00Oo0.O0000OoO();
            if (O0000OoO != null && O0000OoO.size() > 0) {
                NearBySchoolBean nearBySchoolBean = new NearBySchoolBean();
                nearBySchoolBean.setCampusName("最近跑步");
                nearBySchoolBean.setViewType(1);
                this.O00000o0.add(this.O00000o0.size(), nearBySchoolBean);
                int size = this.O00000o0.size();
                for (int i = 0; i < O0000OoO.size(); i++) {
                    this.O00000o0.add(size + i, O0000OoO.get(i));
                }
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void n_() {
        O00000o();
        O00000oO();
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
