package com.ximalaya.ting.android.opensdk.auth.handler;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuth2AccessToken;
import com.ximalaya.ting.android.opensdk.auth.utils.AccessTokenKeeper;
import com.ximalaya.ting.android.opensdk.auth.utils.Logger;
import com.ximalaya.ting.android.opensdk.auth.utils.b;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$IRequestCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: XmlyThirdAuthHandler */
public final class a {
    private static final String a = b.class.getSimpleName();
    private static final String b = "http://api.ximalaya.com/oauth2/exchange_access_token";
    private Context c;

    /* compiled from: XmlyThirdAuthHandler */
    private static class a extends XimalayaResponse {
        private String a;
        private String b;
        private String c;

        public a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        private void a(String str) {
            this.b = str;
        }

        private void b(String str) {
            this.a = str;
        }

        private String c() {
            return this.c;
        }

        private void c(String str) {
            this.c = str;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.a;
        }
    }

    public a(Context context) {
        this.c = context;
    }

    private void a(final String str, String str2, final IXmlyAuthListener iXmlyAuthListener) {
        HashMap hashMap = new HashMap();
        hashMap.put(XmlyConstants.AUTH_PARAMS_GRANT_TYPE, "token_exchange");
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("nonce", b.a(String.valueOf(currentTimeMillis)));
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("third_uid", str);
        hashMap.put("third_token", str2);
        try {
            hashMap.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, CommonRequest.getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        CommonRequest.basePostRequest("http://api.ximalaya.com/oauth2/exchange_access_token", hashMap, /* anonymous class already generated */, /* anonymous class already generated */);
    }

    @WorkerThread
    public final Bundle a(final String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(XmlyConstants.AUTH_PARAMS_GRANT_TYPE, "token_exchange");
        long currentTimeMillis = System.currentTimeMillis();
        hashMap.put("nonce", b.a(String.valueOf(currentTimeMillis)));
        hashMap.put("timestamp", String.valueOf(currentTimeMillis));
        hashMap.put("third_uid", str);
        hashMap.put("third_token", str2);
        try {
            hashMap.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, CommonRequest.getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        try {
            a aVar = (a) CommonRequest.basePostRequestSync("http://api.ximalaya.com/oauth2/exchange_access_token", hashMap, new CommonRequest$IRequestCallBack<a>() {
                private a a(String str) throws Exception {
                    JSONObject jSONObject = new JSONObject(str);
                    return new a(jSONObject.optString("access_token"), jSONObject.optString("expires_in"), str);
                }

                public final /* synthetic */ Object success(String str) throws Exception {
                    JSONObject jSONObject = new JSONObject(str);
                    return new a(jSONObject.optString("access_token"), jSONObject.optString("expires_in"), str);
                }
            });
            if (aVar != null) {
                XmlyAuth2AccessToken xmlyAuth2AccessToken = new XmlyAuth2AccessToken(aVar.b(), aVar.a());
                xmlyAuth2AccessToken.setUid(str);
                if (xmlyAuth2AccessToken.isSessionValid()) {
                    AccessTokenKeeper.clear(this.c);
                    AccessTokenKeeper.writeAccessToken(this.c, xmlyAuth2AccessToken);
                } else {
                    Logger.d(a, "Failed to receive access token by Web");
                }
                return xmlyAuth2AccessToken.toBundle();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
