package com.ximalaya.ting.android.opensdk.auth.constants;

public class XmlyConstants {
    public static final String AUTH_PARAMS_ACCESS_TOKEN = "access_token";
    public static final String AUTH_PARAMS_CLIENT_ID = "client_id";
    public static final String AUTH_PARAMS_CLIENT_OS_TYPE = "client_os_type";
    public static final String AUTH_PARAMS_CODE = "code";
    public static final String AUTH_PARAMS_DEVICE_ID = "device_id";
    public static final String AUTH_PARAMS_GRANT_TYPE = "grant_type";
    public static final String AUTH_PARAMS_OBTAIN_AUTH_TYPE = "obtain_auth_type";
    public static final String AUTH_PARAMS_PACKAGE_ID = "pack_id";
    public static final String AUTH_PARAMS_REDIRECT_URL = "redirect_uri";
    public static final String AUTH_PARAMS_REFRESH_TOKEN = "refresh_token";
    public static final String AUTH_PARAMS_RESPONSE_TYPE = "response_type";
    public static final String AUTH_PARAMS_SCOPE = "scope";
    public static final String AUTH_PARAMS_SSO_CODE = "ssoCode";
    public static final String AUTH_PARAMS_STATE = "state";
    public static final String AUTH_PARAMS_UID = "uid";
    public static final String AUTH_PARAMS_VERSION = "version";
    public static final boolean IS_RELEASE = true;
    public static final String SSO_APP_KEY = "app_key";
    public static final String SSO_CLIENT_OS_TYPE = "client_os_type";
    public static final String SSO_DEVICE_ID = "device_id";
    public static final String SSO_OBTAIN_AUTH_TYPE = "obtain_auth_type";
    public static final String SSO_PACKAGE_ID = "pack_id";
    public static final String SSO_REDIRECT_URL = "redirect_uri";
    public static final String SSO_STATE = "state";
    public static final String SSO_THIRD_APP_NAME = "third_app_name";
    public static final String XMLY_TING_APP_PACKAGE_NAME = "_xmly_ting_app_package";
    public static final String XMLY_TING_APP_SIGNATURES = "22a001357629de32518a24508149689f";
    public static final String XMLY_TING_APP_SIGNATURES_RELEASE = "22a001357629de32518a24508149689f";

    public interface ClientOSType {
        public static final String ANDROID = "2";
        public static final String IOS = "1";
        public static final String WEB_OR_H5 = "3";
    }

    public interface RequestParams {
        public static final String BUNDLE_KEY_IS_LOGIN_FROM_OAUTH_SDK = "login_from_oauth_sdk";
        public static final String BUNDLE_KEY_IS_QUICK_LOGIN_TYPE = "is_quick_login";
        public static final String BUNDLE_KEY_OBTAIN_AUTH_TYPE = "obtain_auth_type";
    }

    public interface ResponseParams {
        public static final String BUNDLE_KEY_CODE = "code";
        public static final String BUNDLE_KEY_ERROR = "error";
        public static final String BUNDLE_KEY_ERROR_CODE = "error_code";
        public static final String BUNDLE_KEY_ERROR_DESC = "error_desc";
        public static final String BUNDLE_KEY_ERROR_NO = "error_no";
        public static final String BUNDLE_KEY_ERROR_SERVICE = "service";
        public static final String BUNDLE_KEY_STATE = "state";
    }
}
