package com.ximalaya.ting.android.opensdk.player.advertis;

public class XmAdsEvent {
    private XmAdsRecord props;
    private int seqId;
    private long ts;
    private String type = "AD";

    public XmAdsRecord getProps() {
        return this.props;
    }

    public int getSeqId() {
        return this.seqId;
    }

    public long getTs() {
        return this.ts;
    }

    public String getType() {
        return this.type;
    }

    public void setProps(XmAdsRecord xmAdsRecord) {
        this.props = xmAdsRecord;
    }

    public void setSeqId(int i) {
        this.seqId = i;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public void setType(String str) {
        this.type = str;
    }
}
