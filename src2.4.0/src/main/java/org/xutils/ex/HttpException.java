package org.xutils.ex;

import android.text.TextUtils;

public class HttpException extends BaseException {
    private static final long serialVersionUID = 1;
    private int code;
    private String customMessage;
    private String errorCode;
    private String result;

    public HttpException(int i, String str) {
        super(str);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrorCode() {
        return this.errorCode == null ? String.valueOf(this.code) : this.errorCode;
    }

    public String getMessage() {
        return !TextUtils.isEmpty(this.customMessage) ? this.customMessage : super.getMessage();
    }

    public String getResult() {
        return this.result;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setMessage(String str) {
        this.customMessage = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errorCode: ");
        stringBuilder.append(getErrorCode());
        stringBuilder.append(", msg: ");
        stringBuilder.append(getMessage());
        stringBuilder.append(", result: ");
        stringBuilder.append(this.result);
        return stringBuilder.toString();
    }
}
