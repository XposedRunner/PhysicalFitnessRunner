package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.utils.WbAuthConstants;

public class WbConnectErrorMessage {
    private String errorCode = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_CODE;
    private String errorMessage = WbAuthConstants.AUTH_FAILED_NOT_INSTALL_MSG;

    public WbConnectErrorMessage(String str, String str2) {
        this.errorMessage = str;
        this.errorCode = str2;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
