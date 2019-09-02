package com.ximalaya.ting.android.opensdk.model.xdcs;

public class BaseEvent {
    private String parentSpanId;
    private int seqId;
    private String spanId;
    private String traceId;
    private long ts;
    private String type;
    private String viewId;

    public String getParentSpanId() {
        return this.parentSpanId;
    }

    public int getSeqId() {
        return this.seqId;
    }

    public String getSpanId() {
        return this.spanId;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public long getTs() {
        return this.ts;
    }

    public String getType() {
        return this.type;
    }

    public String getViewId() {
        return this.viewId;
    }

    public void setParentSpanId(String str) {
        this.parentSpanId = str;
    }

    public void setSeqId(int i) {
        this.seqId = i;
    }

    public void setSpanId(String str) {
        this.spanId = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setViewId(String str) {
        this.viewId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseEvent [viewId=");
        stringBuilder.append(this.viewId);
        stringBuilder.append(", parentSpanId=");
        stringBuilder.append(this.parentSpanId);
        stringBuilder.append(", seqId=");
        stringBuilder.append(this.seqId);
        stringBuilder.append(", spanId=");
        stringBuilder.append(this.spanId);
        stringBuilder.append(", traceId=");
        stringBuilder.append(this.traceId);
        stringBuilder.append(", ts=");
        stringBuilder.append(this.ts);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
