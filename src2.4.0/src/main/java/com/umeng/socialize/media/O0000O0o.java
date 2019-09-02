package com.umeng.socialize.media;

import android.content.Context;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.PlatformConfig$APPIDPlatform;
import com.umeng.socialize.UMAuthListener;
import defpackage.by;
import defpackage.cu;
import java.util.HashMap;

/* compiled from: SinaExtra */
public class O0000O0o {
    public static void O000000o(Context context, String str, final UMAuthListener uMAuthListener) {
        WeiboParameters weiboParameters = new WeiboParameters(((PlatformConfig$APPIDPlatform) PlatformConfig.getPlatform(by.SINA)).appId);
        weiboParameters.put("access_token", str);
        new AsyncWeiboRunner(context).requestAsync("https://api.weibo.com/oauth2/get_token_info", weiboParameters, "POST", new RequestListener() {
            public void onComplete(String str) {
                HashMap hashMap = new HashMap();
                hashMap.put(cu.O000Oo0O, str);
                uMAuthListener.onComplete(by.SINA, 2, hashMap);
            }

            public void onWeiboException(WeiboException weiboException) {
                uMAuthListener.onError(by.SINA, 2, new Throwable(weiboException));
            }
        });
    }
}
