package com.zjwh.android_wh_physicalfitness.entity.music;

public class MusicOrderBean {
    private long xima_order_created_at;
    private String xima_order_no;
    private int xima_order_status;
    private long xima_order_updated_at;

    public long getXima_order_created_at() {
        return this.xima_order_created_at;
    }

    public String getXima_order_no() {
        return this.xima_order_no;
    }

    public int getXima_order_status() {
        return this.xima_order_status;
    }

    public long getXima_order_updated_at() {
        return this.xima_order_updated_at;
    }

    public void setXima_order_created_at(long j) {
        this.xima_order_created_at = j;
    }

    public void setXima_order_no(String str) {
        this.xima_order_no = str;
    }

    public void setXima_order_status(int i) {
        this.xima_order_status = i;
    }

    public void setXima_order_updated_at(long j) {
        this.xima_order_updated_at = j;
    }
}
