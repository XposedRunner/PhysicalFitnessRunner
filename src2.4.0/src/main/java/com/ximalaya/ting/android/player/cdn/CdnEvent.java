package com.ximalaya.ting.android.player.cdn;

public class CdnEvent {
    private String parentSpanId;
    private CdnCollectDataForPlay props;
    private int seqId;
    private String spanId;
    private String traceId;
    private long ts;
    private String type;
    private String viewId;

    public String getParentSpanId() {
        return this.parentSpanId;
    }

    public CdnCollectDataForPlay getProps() {
        return this.props;
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

    public void setProps(CdnCollectDataForPlay cdnCollectDataForPlay) {
        this.props = cdnCollectDataForPlay;
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
        stringBuilder.append(super.toString());
        stringBuilder.append("CdnEvent [props=");
        stringBuilder.append(this.props);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
