package com.zjwh.android_wh_physicalfitness.entity;

public class DynamicMainHeadBean {
    private int participateNum;
    private String topicCoverImg;
    private int topicId;
    private String topicTitle;

    public int getParticipateNum() {
        return this.participateNum;
    }

    public String getTopicCoverImg() {
        return this.topicCoverImg;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public String getTopicTitle() {
        return this.topicTitle;
    }

    public void setParticipateNum(int i) {
        this.participateNum = i;
    }

    public void setTopicCoverImg(String str) {
        this.topicCoverImg = str;
    }

    public void setTopicId(int i) {
        this.topicId = i;
    }

    public void setTopicTitle(String str) {
        this.topicTitle = str;
    }
}
