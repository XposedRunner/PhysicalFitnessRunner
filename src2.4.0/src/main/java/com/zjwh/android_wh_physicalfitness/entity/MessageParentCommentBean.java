package com.zjwh.android_wh_physicalfitness.entity;

public class MessageParentCommentBean {
    private String content;
    private int isDeleted;
    private String nickName;

    public String getContent() {
        return this.content;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ParentCommentBean{content='");
        stringBuilder.append(this.content);
        stringBuilder.append('\'');
        stringBuilder.append(", isDeleted='");
        stringBuilder.append(this.isDeleted);
        stringBuilder.append('\'');
        stringBuilder.append(", nickName='");
        stringBuilder.append(this.nickName);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
