package com.zjwh.android_wh_physicalfitness.entity.request;

public class QOrderList {
    private Page page;
    private int state;
    private int userId;

    public Page getPage() {
        return this.page;
    }

    public int getState() {
        return this.state;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QOrderList{page=");
        stringBuilder.append(this.page);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
