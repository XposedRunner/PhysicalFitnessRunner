package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class DynamicPublishBean {
    private String content;
    private List<Integer> fids;
    private float imageRate;
    private List<DynamicTagBean> tagList;
    private int topicId;
    private int unid;

    public DynamicPublishBean(int i, String str, List<Integer> list, float f) {
        this.unid = i;
        this.content = str;
        this.fids = list;
        this.imageRate = f;
    }

    public String getContent() {
        return this.content;
    }

    public List<Integer> getFids() {
        return this.fids;
    }

    public float getImageRate() {
        return this.imageRate;
    }

    public List<DynamicTagBean> getTagList() {
        return this.tagList;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public int getUnid() {
        return this.unid;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFids(List<Integer> list) {
        this.fids = list;
    }

    public void setImageRate(float f) {
        this.imageRate = f;
    }

    public void setTagList(List<DynamicTagBean> list) {
        this.tagList = list;
    }

    public void setTopicId(int i) {
        this.topicId = i;
    }

    public void setUnid(int i) {
        this.unid = i;
    }
}
