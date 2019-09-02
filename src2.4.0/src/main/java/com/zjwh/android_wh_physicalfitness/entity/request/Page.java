package com.zjwh.android_wh_physicalfitness.entity.request;

public class Page {
    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return this.pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Page{pageNum=");
        stringBuilder.append(this.pageNum);
        stringBuilder.append(", pageSize=");
        stringBuilder.append(this.pageSize);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
