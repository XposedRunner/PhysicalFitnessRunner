package com.umeng.socialize.handler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.Tencent;
import com.umeng.socialize.PlatformConfig$APPIDPlatform;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000o00;
import com.ximalaya.ting.android.opensdk.player.statistic.OpenSdkPlayStatisticUpload;
import defpackage.cu;
import defpackage.db;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class UMTencentSSOHandler extends UMSSOHandler {
    protected static Map<String, String> O000O0o0 = new HashMap();
    protected static final String O000OOOo = "nickname";
    protected static final String O000OOo = "is_yellow_year_vip";
    protected static final String O000OOo0 = "figureurl_qq_2";
    protected static final String O000OOoO = "yellow_vip_level";
    protected static final String O000OOoo = "msg";
    protected static final String O000Oo0 = "level";
    protected static final String O000Oo00 = "vip";
    protected static final String O000Oo0O = "ret";
    protected static final String O000Oo0o = "is_yellow_vip";
    private static final String O000OoO0 = "UMTencentSSOHandler";
    private static final String O00O0Oo = "100424468";
    protected ProgressDialog O000000o = null;
    protected String O000O0o = null;
    public PlatformConfig$APPIDPlatform O000O0oO = null;
    protected UMAuthListener O000O0oo;
    protected String O000OO = "6.9.4";
    protected Tencent O000OO00;
    protected UMShareListener O000OO0o;

    protected interface ObtainAppIdListener {
        void O000000o();
    }

    public interface ObtainImageUrlListener {
        void O000000o(String str);
    }

    private void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            O000O0o0.put(str, str2);
            this.O000O0o = str2;
        }
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
        this.O000O0oO = (PlatformConfig$APPIDPlatform) platformConfig$Platform;
        this.O000OO00 = Tencent.createInstance(this.O000O0oO.appId, context);
        if (this.O000OO00 == null) {
            O0000O0o.O000000o(O0000o00.O0000Oo0);
        }
    }

    /* Access modifiers changed, original: protected */
    public Bundle O00000Oo(Object obj) {
        Bundle bundle = new Bundle();
        if (obj == null) {
            return bundle;
        }
        String trim = obj.toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return bundle;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(trim);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject == null) {
            return bundle;
        }
        bundle.putString("auth_time", jSONObject.optString("auth_time", ""));
        bundle.putString("pay_token", jSONObject.optString("pay_token", ""));
        bundle.putString(cu.O0000o0O, jSONObject.optString(cu.O0000o0O, ""));
        bundle.putString(O000Oo0O, String.valueOf(jSONObject.optInt(O000Oo0O, -1)));
        bundle.putString("sendinstall", jSONObject.optString("sendinstall", ""));
        bundle.putString("page_type", jSONObject.optString("page_type", ""));
        bundle.putString(OpenSdkPlayStatisticUpload.KEY_APP_ID, jSONObject.optString(OpenSdkPlayStatisticUpload.KEY_APP_ID, ""));
        bundle.putString(db.O000OOoO, jSONObject.optString(db.O000OOoO, ""));
        bundle.putString("uid", jSONObject.optString(db.O000OOoO, ""));
        bundle.putString("expires_in", jSONObject.optString("expires_in", ""));
        bundle.putString("pfkey", jSONObject.optString("pfkey", ""));
        bundle.putString("access_token", jSONObject.optString("access_token", ""));
        return bundle;
    }

    public String O00000o0() {
        return this.O000OO;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oO() {
        return this.O000OO00 != null && this.O000OO00.getAppId().equals(this.O000O0oO.appId);
    }
}
