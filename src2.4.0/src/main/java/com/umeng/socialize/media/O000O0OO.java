package com.umeng.socialize.media;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.utils.O0000O0o;
import defpackage.by;
import defpackage.cc;
import defpackage.cu;
import defpackage.dl;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WeixinExtra */
public class O000O0OO {
    public static void O000000o(String str, String str2, final UMAuthListener uMAuthListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.weixin.qq.com/sns/auth?access_token=");
        stringBuilder.append(str);
        stringBuilder.append("&openid=");
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        new Thread(new Runnable() {
            public void run() {
                try {
                    final JSONObject jSONObject = new JSONObject(dl.O000000o(str));
                    if (jSONObject != null) {
                        cc.O000000o(new Runnable() {
                            public void run() {
                                HashMap hashMap = new HashMap();
                                if (jSONObject.optInt("errcode", -1) == 0) {
                                    hashMap.put(cu.O000Oo0O, jSONObject.toString());
                                    uMAuthListener.onComplete(by.WEIXIN, 2, hashMap);
                                    return;
                                }
                                uMAuthListener.onError(by.WEIXIN, 2, new Throwable(jSONObject.toString()));
                            }
                        });
                    }
                } catch (JSONException e) {
                    O0000O0o.O000000o(e);
                }
            }
        }).start();
    }
}
