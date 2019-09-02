package com.ximalaya.ting.android.opensdk.model;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class PostResponse extends XimalayaResponse {
    private int code;
    private String message;
    private String response;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponse() {
        return this.response;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PostResponse [response=");
        stringBuilder.append(this.response);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
