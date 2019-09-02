package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class NewsHotCommentBean {
    private int count;
    private List<CommentBean> list;

    public int getCount() {
        return this.count;
    }

    public List<CommentBean> getList() {
        return this.list;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setList(List<CommentBean> list) {
        this.list = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HotCommentBean{count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", list=");
        stringBuilder.append(this.list);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
