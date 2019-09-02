package com.zjwh.android_wh_physicalfitness.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.common.util.MD5;
import org.xutils.http.RequestParams;
import org.xutils.x;

/* compiled from: AdUtils */
public class O00000o0 {
    public static final String O000000o = "sp_key_ip";

    public static String O000000o(String str) throws UnsupportedEncodingException {
        return str.replace("__OS__", "0").replace("__IP__", (String) O00O0Oo0.O00000o0(O000000o, "")).replace("__IMEI__", O000OO.O0000Oo()).replace("__ANDROIDID__", MD5.md5(O000OO.O0000Oo0())).replace("__ANDROIDID1__", O000OO.O0000Oo0()).replace("__MAC1__", MD5.md5(O000OO.O0000Oo0().toUpperCase())).replace("__MAC__", MD5.md5(O000OO.O0000o0o().toUpperCase().replace(":", ""))).replace("__APP__", URLEncoder.encode("运动世界校园", "UTF-8"));
    }

    public static void O00000Oo(String str) {
        try {
            str = O000000o(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        x.http().get(new RequestParams(str), new CommonCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(Throwable th, boolean z) {
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
            }
        });
    }
}
