package com.ximalaya.ting.android.opensdk.httputil;

import java.util.HashMap;
import java.util.Map;

public class XimalayaException extends Exception {
    public static final int DHKEY_CREATE_FAIL = 1015;
    public static final int DHKEY_REQUEST_FAIL = 1016;
    public static final int ENCODE_ERROR = 1008;
    public static final int ERROR_DESC_EMPTY = 1009;
    public static final Map<Integer, String> ERR_MESSAGE_MAP = new HashMap<Integer, String>() {
        {
            put(Integer.valueOf(1001), "request url is empty");
            put(Integer.valueOf(XimalayaException.SIGNATURE_ERR_BY_EMPTY), "exception occurs when caculate signature");
            put(Integer.valueOf(XimalayaException.FORM_ENCODE_LAST_ONE), "Form encoded body must have at least one part");
            put(Integer.valueOf(XimalayaException.NOT_INIT), "you must call #XiMaLaYa.init");
            put(Integer.valueOf(XimalayaException.NOT_HAVE_APPKEY), "get appkey error from AndroidManifest.xml metaData");
            put(Integer.valueOf(XimalayaException.ERROR_DESC_EMPTY), "parse data error");
            put(Integer.valueOf(XimalayaException.GET_TOKEN_FAIL), "get accesstoken fail");
            put(Integer.valueOf(XimalayaException.REQUEST_URL_PARSE_ERROR), "request url parse error");
            put(Integer.valueOf(XimalayaException.TOKEN_INVALID), "token invalid");
            put(Integer.valueOf(1014), "login need");
            put(Integer.valueOf(XimalayaException.HTTP_REQUEST_ERROR), "http error");
            put(Integer.valueOf(1015), "create dh ke error");
            put(Integer.valueOf(XimalayaException.DHKEY_REQUEST_FAIL), "create dh request fail");
        }
    };
    public static final int FORM_ENCODE_LAST_ONE = 1003;
    public static final int GET_SYSTEM_PARAMETER_ERROR = 1006;
    public static final int GET_TOKEN_FAIL = 1010;
    public static final int HTTP_REQUEST_ERROR = 1011;
    public static final int LOGIN_NEED = 1014;
    public static final int NOT_HAVE_APPKEY = 1005;
    public static final int NOT_INIT = 1004;
    public static final int PARSE_JSON_ERROR = 1007;
    public static final int REQUEST_URL_EMPTY = 1001;
    public static final int REQUEST_URL_PARSE_ERROR = 1012;
    public static final int SIGNATURE_ERR_BY_EMPTY = 1002;
    public static final int TOKEN_INVALID = 1013;
    private int mErrorCode;
    private String mErrorMessage;

    public XimalayaException(int i, String str) {
        this.mErrorCode = i;
        this.mErrorMessage = str;
    }

    public static final XimalayaException getExceptionByCode(int i) {
        return new XimalayaException(i, (String) ERR_MESSAGE_MAP.get(Integer.valueOf(i)));
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public void setErrorCode(int i) {
        this.mErrorCode = i;
    }

    public void setErrorMessage(String str) {
        this.mErrorMessage = str;
    }
}
