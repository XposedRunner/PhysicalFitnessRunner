package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class DynamicBean {
    private String avatarUrl;
    private int commentCount;
    private List<DynamicCommentBean> commentList;
    private String content;
    private List<DynamicFileBean> files;
    private int gender;
    private int id;
    private int imageRate = -1;
    private int interestStatus;
    private int isLiked;
    private int likeCount;
    private String nickName;
    private List<DynamicTagBean> tagList;
    private long time;
    private int topicId;
    private String topicTitle;
    private int uid;
    private String university;
    private int viewType;

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public List<DynamicCommentBean> getCommentList() {
        return this.commentList;
    }

    public String getContent() {
        return this.content;
    }

    public List<DynamicFileBean> getFiles() {
        return this.files;
    }

    public int getGender() {
        return this.gender;
    }

    public int getId() {
        return this.id;
    }

    public int getImageRate() {
        return this.imageRate;
    }

    public int getInterestStatus() {
        return this.interestStatus;
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

    public List<DynamicTagBean> getTagList() {
        return this.tagList;
    }

    public long getTime() {
        return this.time;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public String getTopicTitle() {
        return this.topicTitle;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUniversity() {
        return this.university;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    public void setCommentCount(int i) {
        this.commentCount = i;
    }

    public void setCommentList(List<DynamicCommentBean> list) {
        this.commentList = list;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFiles(List<DynamicFileBean> list) {
        this.files = list;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImageRate(int i) {
        this.imageRate = i;
    }

    public void setInterestStatus(int i) {
        this.interestStatus = i;
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

    public void setTagList(List<DynamicTagBean> list) {
        this.tagList = list;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTopicId(int i) {
        this.topicId = i;
    }

    public void setTopicTitle(String str) {
        this.topicTitle = str;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public void setUniversity(String str) {
        this.university = str;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DynamicBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", content='");
        stringBuilder.append(this.content);
        stringBuilder.append('\'');
        stringBuilder.append(", uid=");
        stringBuilder.append(this.uid);
        stringBuilder.append(", nickName='");
        stringBuilder.append(this.nickName);
        stringBuilder.append('\'');
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", university='");
        stringBuilder.append(this.university);
        stringBuilder.append('\'');
        stringBuilder.append(", avatarUrl='");
        stringBuilder.append(this.avatarUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", likeCount=");
        stringBuilder.append(this.likeCount);
        stringBuilder.append(", isLiked=");
        stringBuilder.append(this.isLiked);
        stringBuilder.append(", files=");
        stringBuilder.append(this.files);
        stringBuilder.append(", interestStatus=");
        stringBuilder.append(this.interestStatus);
        stringBuilder.append(", topicTitle='");
        stringBuilder.append(this.topicTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", commentCount=");
        stringBuilder.append(this.commentCount);
        stringBuilder.append(", topicId=");
        stringBuilder.append(this.topicId);
        stringBuilder.append(", imageRate=");
        stringBuilder.append(this.imageRate);
        stringBuilder.append(", commentList=");
        stringBuilder.append(this.commentList);
        stringBuilder.append(", tagList=");
        stringBuilder.append(this.tagList);
        stringBuilder.append(", viewType=");
        stringBuilder.append(this.viewType);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
