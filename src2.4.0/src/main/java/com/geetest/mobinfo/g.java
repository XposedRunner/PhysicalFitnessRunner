package com.geetest.mobinfo;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.bangcle.andJni.JniLib1557756502;
import org.json.JSONObject;

public class g {
    public static JSONObject a(Context context, String str, String str2, String str3, String str4, String str5) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM));
    }

    public static JSONObject b(Context context, String str, String str2, String str3) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, Integer.valueOf(SecExceptionCode.SEC_ERROR_SET_GLOBAL_USER_DATA));
    }

    public static JSONObject c(String str, String str2, String str3, String str4, String str5, String str6) {
        return (JSONObject) JniLib1557756502.cL(str, str2, str3, str4, str5, str6, Integer.valueOf(GlMapUtil.DEVICE_DISPLAY_DPI_LOW));
    }

    public static String d(Context context) {
        return x.a(context);
    }

    public static String e(Context context) {
        return x.b(context);
    }

    public static JSONObject f(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_DATA_FILE_MISMATCH));
    }
}
