package com.geetest.mobinfo;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.bangcle.andJni.JniLib1557756502;
import org.json.JSONObject;

public class f {
    public static JSONObject a(Context context, String str, String str2, String str3) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED));
    }

    public static JSONObject b(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT));
    }

    public static JSONObject c(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET));
    }
}
