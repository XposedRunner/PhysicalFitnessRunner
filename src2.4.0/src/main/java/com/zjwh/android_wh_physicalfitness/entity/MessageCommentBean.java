package com.zjwh.android_wh_physicalfitness.entity;

import com.google.gson.annotations.SerializedName;

public class MessageCommentBean extends MultiAdapterBean {
    private String avatarUrl;
    @SerializedName(alternate = {"showMessage"}, value = "content")
    private String content;
    private int gender;
    private int id;
    private int isDeleted;
    private boolean mIsNew;
    private int mTabIndex;
    private String nickName;
    private MessageParentCommentBean parentComment;
    private MessageRootCommentBean root;
    private long time;
    private int uid;
    private String university;

    public MessageCommentBean() {
        setViewType(1);
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getContent() {
        return this.content;
    }

    public int getGender() {
        return this.gender;
    }

    public int getId() {
        return this.id;
    }

    public int getIsDeleted() {
        return this.isDeleted;
    }

    public String getNickName() {
        return this.nickName;
    }

    public MessageParentCommentBean getParentComment() {
        return this.parentComment;
    }

    public MessageRootCommentBean getRoot() {
        return this.root;
    }

    public int getTabIndex() {
        return this.mTabIndex;
    }

    public long getTime() {
        return this.time;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUniversity() {
        return this.university;
    }

    public boolean isNew() {
        return this.mIsNew;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsDeleted(int i) {
        this.isDeleted = i;
    }

    public void setNew(boolean z) {
        this.mIsNew = z;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setParentComment(MessageParentCommentBean messageParentCommentBean) {
        this.parentComment = messageParentCommentBean;
    }

    public void setRoot(MessageRootCommentBean messageRootCommentBean) {
        this.root = messageRootCommentBean;
    }

    public void setTabIndex(int i) {
        this.mTabIndex = i;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUniversity(String str) {
        this.university = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageCommentBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", content='");
        stringBuilder.append(this.content);
        stringBuilder.append('\'');
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", nickName='");
        stringBuilder.append(this.nickName);
        stringBuilder.append('\'');
        stringBuilder.append(", university='");
        stringBuilder.append(this.university);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", isDeleted=");
        stringBuilder.append(this.isDeleted);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", parentComment=");
        stringBuilder.append(this.parentComment);
        stringBuilder.append(", root=");
        stringBuilder.append(this.root);
        stringBuilder.append(", mIsNew=");
        stringBuilder.append(this.mIsNew);
        stringBuilder.append(", mTabIndex=");
        stringBuilder.append(this.mTabIndex);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
