package com.geetest.deepknow.e;

import android.content.Context;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.bean.DPJudgementBean;
import com.geetest.deepknow.c.a;
import org.json.JSONObject;

/* compiled from: DPMobInfo2 */
public final class c {
    private static JSONObject a(String str, a aVar) {
        return (JSONObject) JniLib1557756502.cL(str, aVar, Integer.valueOf(60));
    }

    public static byte[] a(Context context, a aVar, String str, DPJudgementBean dPJudgementBean) {
        return (byte[]) JniLib1557756502.cL(context, aVar, str, dPJudgementBean, Integer.valueOf(61));
    }
}
