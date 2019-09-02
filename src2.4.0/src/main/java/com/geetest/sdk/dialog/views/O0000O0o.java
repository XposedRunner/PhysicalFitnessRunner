package com.geetest.sdk.dialog.views;

import com.baidu.mapapi.SDKInitializer;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebviewBuilder */
final class O0000O0o implements Runnable {
    final /* synthetic */ String O000000o;
    final /* synthetic */ O000000o O00000Oo;

    O0000O0o(O000000o o000000o, String str) {
        this.O00000Oo = o000000o;
        this.O000000o = str;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject(this.O000000o);
            O00000Oo.this.O00000oO.O000000o(jSONObject.getString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE).replaceAll("[a-zA-Z]", ""), jSONObject.getString("user_error"));
        } catch (JSONException e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O000000o);
            stringBuilder.append("-->");
            stringBuilder.append(e.toString());
            O00000Oo.this.O00000oO.O000000o("202", stringBuilder.toString());
        }
    }
}
