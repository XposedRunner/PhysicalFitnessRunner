package com.zjwh.android_wh_physicalfitness.entity;

public class CommentBean {
    private String avatarUrl;
    private String content;
    private int gender;
    private int id;
    private int isLiked;
    private int likeCount;
    private String nickName;
    private MessageParentCommentBean parentComment;
    private long time;
    private int uid;
    private String university;

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

    public int getIsLiked() {
        return this.isLiked;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public String getNickName() {
        return this.nickName;
    }

    public MessageParentCommentBean getParentComment() {
        return this.parentComment;
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

    public void setIsLiked(int i) {
        this.isLiked = i;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setParentComment(MessageParentCommentBean messageParentCommentBean) {
        this.parentComment = messageParentCommentBean;
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
        stringBuilder.append("CommentBean{id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append(", content='");
        stringBuilder.append(this.content);
        stringBuilder.append('\'');
        stringBuilder.append(", uid='");
        stringBuilder.append(this.uid);
        stringBuilder.append('\'');
        stringBuilder.append(", nickName='");
        stringBuilder.append(this.nickName);
        stringBuilder.append('\'');
        stringBuilder.append(", university='");
        stringBuilder.append(this.university);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", time='");
        stringBuilder.append(this.time);
        stringBuilder.append('\'');
        stringBuilder.append(", likeCount='");
        stringBuilder.append(this.likeCount);
        stringBuilder.append('\'');
        stringBuilder.append(", isLiked='");
        stringBuilder.append(this.isLiked);
        stringBuilder.append('\'');
        stringBuilder.append(", parentComment=");
        stringBuilder.append(this.parentComment);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
