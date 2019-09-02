package com.zjwh.android_wh_physicalfitness.utils;

import com.geetest.deepknow.DPAPI;
import com.geetest.deepknow.bean.DPJudgementBean;
import com.geetest.deepknow.listener.DPJudgementListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import defpackage.kz;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DeepKnowUtils */
public class O000OO0o {
    public static final int O000000o = 1;
    public static final int O00000Oo = 2;
    public static final int O00000o = 4;
    public static final int O00000o0 = 3;
    public static final int O00000oO = 5;
    public static final int O00000oo = 6;
    public static final int O0000O0o = 7;
    public static final int O0000OOo = 8;

    public static void O000000o(int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("uid", Integer.valueOf(i2));
        O000000o(i, hashMap, null);
    }

    public static void O000000o(int i, int i2, String str) {
        Map hashMap = new HashMap();
        hashMap.put("uid", Integer.valueOf(i2));
        hashMap.put("uuid", str);
        O000000o(i, hashMap, null);
    }

    public static void O000000o(int i, int i2, String str, DPJudgementListener dPJudgementListener) {
        Map hashMap = new HashMap();
        hashMap.put("uid", Integer.valueOf(i2));
        hashMap.put("uuid", str);
        O000000o(i, hashMap, dPJudgementListener);
    }

    private static void O000000o(int i, Map<String, Object> map, final DPJudgementListener dPJudgementListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("emitSenseData interactive: ");
        stringBuilder.append(i);
        kz.O00000o0("DeepKnowUtils", stringBuilder.toString());
        kz.O00000oo("DeepKnowUtils", new JSONObject(map).toString());
        DPAPI.getInstance(MyApplication.O000000o()).emitSenseData(new DPJudgementBean(MyApplication.O000000o().getString(R.string.geet_deep_konw_id), i, map), new DPJudgementListener() {
            public void onDeepKnowResult(JSONObject jSONObject) {
                kz.O00000oo("DeepKnowUtils", jSONObject.toString());
                if (dPJudgementListener != null) {
                    dPJudgementListener.onDeepKnowResult(jSONObject);
                }
            }

            public void onError(String str, String str2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onError: ");
                stringBuilder.append(str);
                stringBuilder.append(" s1: ");
                stringBuilder.append(str2);
                kz.O000000o("DeepKnowUtils", stringBuilder.toString());
                if (dPJudgementListener != null) {
                    dPJudgementListener.onError(str, str2);
                }
            }
        });
    }
}
