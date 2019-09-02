package com.zjwh.android_wh_physicalfitness.utils;

import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.statistics.DeviceActivationInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import defpackage.gg;
import defpackage.gj;
import defpackage.gk;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;

/* compiled from: StatisticsUtils */
public class O00OO0O {
    public static Cancelable O000000o() {
        MyApplication O000000o = MyApplication.O000000o();
        final String O00000Oo = O00Oo0.O00000Oo();
        if (O00000Oo.equals((String) O00O0Oo0.O000000o(O000000o, gg.O000O0oO, "1.0"))) {
            return null;
        }
        DeviceActivationInfo deviceActivationInfo = new DeviceActivationInfo(O000OO.O0000OOo(), O000OO.O00000o0(), O000OO.O0000o0o(), O000OO.O0000Oo(), O000OO.O0000O0o(), O00Oo0.O00000oO(O000000o));
        gj gjVar = new gj(gk.O0000o0O);
        gjVar.setBodyContent(O000o000.O000000o((Object) deviceActivationInfo));
        return HttpUtil.postOp(O000000o, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                O00O0Oo0.O000000o(gg.O000O0oO, O00000Oo);
            }
        });
    }

    public static Cancelable O000000o(PvDataInfo pvDataInfo) {
        gj gjVar = new gj(gk.O00OoO);
        gjVar.setBodyContent(O000o000.O000000o((Object) pvDataInfo));
        return HttpUtil.post(MyApplication.O000000o(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }

    public static Cancelable O000000o(PvDataInfoV29 pvDataInfoV29) {
        gj gjVar = new gj(gk.O00OoOO0);
        gjVar.setBodyContent(O000o000.O000000o((Object) pvDataInfoV29));
        return HttpUtil.post(MyApplication.O000000o(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }

    public static void O000000o(String str, int i, int i2, String str2) {
        gj gjVar = new gj(gk.O00O0oo0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("challenge", str);
            jSONObject.put("interactive", i);
            if (i2 != -1) {
                jSONObject.put("rrid", i2);
            }
            jSONObject.put("uuid", str2);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.postOp(MyApplication.O000000o(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }

    public static Cancelable O00000Oo(PvDataInfo pvDataInfo) {
        gj gjVar = new gj(gk.O00OoOO);
        gjVar.setBodyContent(O000o000.O000000o((Object) pvDataInfo));
        return HttpUtil.postOp(MyApplication.O000000o(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }
}
