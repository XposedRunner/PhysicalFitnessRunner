package com.ximalaya.ting.android.opensdk.player.advertis.shopAdsEvent;

public class XmShopEvent {
    private XmShopsRecord props;
    private int seqId;
    private long ts;
    private String type = "AD";

    public XmShopsRecord getProps() {
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

    public void setProps(XmShopsRecord xmShopsRecord) {
        this.props = xmShopsRecord;
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
