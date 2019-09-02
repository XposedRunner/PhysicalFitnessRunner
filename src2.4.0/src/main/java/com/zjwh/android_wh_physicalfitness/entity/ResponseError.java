package com.zjwh.android_wh_physicalfitness.entity;

public class ResponseError {
    private Object data;
    private int error;
    private String message;

    public Object getData() {
        return this.data;
    }

    public int getError() {
        return this.error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setError(int i) {
        this.error = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
