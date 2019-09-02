package com.baidu.platform.comapi.pano;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.umeng.commonsdk.framework.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    AsyncHttpClient a = new AsyncHttpClient();

    public interface a<T> {
        void a(HttpStateError httpStateError);

        void a(T t);
    }

    private c a(String str) {
        if (str == null || str.equals("")) {
            return new c(PanoStateError.PANO_NOT_FOUND);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                return new c(PanoStateError.PANO_NOT_FOUND);
            }
            if (optJSONObject.optInt("error") != 0) {
                return new c(PanoStateError.PANO_UID_ERROR);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(c.a);
            if (optJSONArray == null) {
                return new c(PanoStateError.PANO_NOT_FOUND);
            }
            c cVar = null;
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i).optJSONObject("poiinfo");
                if (optJSONObject2 != null) {
                    cVar = new c(PanoStateError.PANO_NO_ERROR);
                    cVar.a(optJSONObject2.optString("PID"));
                    cVar.a(optJSONObject2.optInt("hasstreet"));
                }
            }
            return cVar;
        } catch (JSONException e) {
            e.printStackTrace();
            return new c(PanoStateError.PANO_NOT_FOUND);
        }
    }

    private String a(Builder builder) {
        String uri = builder.build().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uri);
        stringBuilder.append(HttpClient.getPhoneInfo());
        builder = Uri.parse(stringBuilder.toString()).buildUpon();
        builder.appendQueryParameter("sign", AppMD5.getSignMD5String(builder.build().getEncodedQuery()));
        return builder.build().toString();
    }

    private void a(Builder builder, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    public void a(String str, a<c> aVar) {
        Builder builder = new Builder();
        builder.scheme(HttpClient.isHttpsEnable ? "https" : "http");
        builder.encodedAuthority("api.map.baidu.com");
        builder.path("/sdkproxy/lbs_androidsdk/pano/v1/");
        a(builder, "qt", "poi");
        a(builder, Oauth2AccessToken.KEY_UID, str);
        a(builder, "action", "0");
        str = HttpClient.getAuthToken();
        if (str == null) {
            aVar.a(new c(PanoStateError.PANO_NO_TOKEN));
            return;
        }
        a(builder, "token", str);
        this.a.get(a(builder), new b(this, aVar));
    }
}
