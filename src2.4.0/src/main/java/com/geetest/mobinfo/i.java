package com.geetest.mobinfo;

import android.support.v4.media.TransportMediator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.bangcle.andJni.JniLib1557756502;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {
    public static JSONObject a() {
        return (JSONObject) JniLib1557756502.cL(Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE));
    }

    public static JSONArray b() {
        return (JSONArray) JniLib1557756502.cL(Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_INCORRECT_DATA_FILE));
    }

    public static String c() {
        return (String) JniLib1557756502.cL(Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_LOW_VERSION_DATA));
    }

    public static String d() {
        return (String) JniLib1557756502.cL(Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_PARSE_USER_CONFIG_ERROR));
    }

    public static String e() {
        return (String) JniLib1557756502.cL(Integer.valueOf(TransportMediator.KEYCODE_MEDIA_PLAY));
    }
}
