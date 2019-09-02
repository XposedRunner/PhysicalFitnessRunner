package com.baidu.mapapi.synchronization.histroytrace;

public class HistoryTraceQueryOptions {
    private String a = null;
    private int b = 0;
    private String c = null;
    private String d = null;
    private int e = 4;
    private int f = 5;

    public int getCurrentOrderState() {
        return this.f;
    }

    public String getDriverId() {
        return this.d;
    }

    public String getOrderId() {
        return this.a;
    }

    public int getQueryOrderState() {
        return this.e;
    }

    public int getRoleType() {
        return this.b;
    }

    public String getUserId() {
        return this.c;
    }

    public HistoryTraceQueryOptions setCurrentOrderState(int i) {
        this.f = i;
        return this;
    }

    public HistoryTraceQueryOptions setDriverId(String str) {
        this.d = str;
        return this;
    }

    public HistoryTraceQueryOptions setOrderId(String str) {
        this.a = str;
        return this;
    }

    public HistoryTraceQueryOptions setQueryOrderState(int i) {
        this.e = i;
        return this;
    }

    public HistoryTraceQueryOptions setRoleType(int i) {
        this.b = i;
        return this;
    }

    public HistoryTraceQueryOptions setUserId(String str) {
        this.c = str;
        return this;
    }
}
