package com.zjwh.android_wh_physicalfitness.entity.rank;

import java.util.List;

public class RankCheatListBean {
    private List<RankCheatBean> list;
    private RankCheatBean self;

    public List<RankCheatBean> getList() {
        return this.list;
    }

    public RankCheatBean getSelf() {
        return this.self;
    }

    public void setList(List<RankCheatBean> list) {
        this.list = list;
    }

    public void setSelf(RankCheatBean rankCheatBean) {
        this.self = rankCheatBean;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RankCheatListBean{self=");
        stringBuilder.append(this.self);
        stringBuilder.append(", list=");
        stringBuilder.append(this.list);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
