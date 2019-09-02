package com.ximalaya.ting.android.opensdk.auth.model;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class XmlyErrorInfo {
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_ERROR_DESC = "error_desc";
    public static final String KEY_ERROR_NO = "error_no";
    private String mErrorCode = "";
    private String mErrorDesc = "";
    private String mErrorNo = "";

    private static String getString(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        return string != null ? string : str2;
    }

    public static XmlyErrorInfo parseErrorInfo(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                XmlyErrorInfo xmlyErrorInfo = new XmlyErrorInfo();
                xmlyErrorInfo.setErrorNo(jSONObject.optString("error_no"));
                xmlyErrorInfo.setErrorCode(jSONObject.optString("error_code"));
                xmlyErrorInfo.setErrorDesc(jSONObject.optString("error_desc"));
                return xmlyErrorInfo;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Bundle getErrorBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("error_no", this.mErrorNo);
        bundle.putString("error_code", this.mErrorCode);
        bundle.putString("error_desc", this.mErrorDesc);
        return bundle;
    }

    public String getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorDesc() {
        return this.mErrorDesc;
    }

    public String getErrorNo() {
        return this.mErrorNo;
    }

    public void setErrorCode(String str) {
        this.mErrorCode = str;
    }

    public void setErrorDesc(String str) {
        this.mErrorDesc = str;
    }

    public void setErrorNo(String str) {
        this.mErrorNo = str;
    }
}
