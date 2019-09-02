package com.zjwh.android_wh_physicalfitness.entity.database;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "topic_tag")
public class TopicTagBean {
    @Column(autoGen = true, isId = true, name = "id")
    private int id;
    @Column(name = "topicId")
    private int topicId;
    @Column(name = "topicTitle")
    private String topicTitle;
    @Column(name = "useTime")
    private long useTime;
    private int viewType = 2;

    public TopicTagBean(int i, String str, long j) {
        this.topicId = i;
        this.topicTitle = str;
        this.useTime = j;
    }

    public int getId() {
        return this.id;
    }

    public int getTopicId() {
        return this.topicId;
    }

    public String getTopicTitle() {
        return this.topicTitle;
    }

    public long getUseTime() {
        return this.useTime;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setTopicId(int i) {
        this.topicId = i;
    }

    public void setTopicTitle(String str) {
        this.topicTitle = str;
    }

    public void setUseTime(long j) {
        this.useTime = j;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }
}
