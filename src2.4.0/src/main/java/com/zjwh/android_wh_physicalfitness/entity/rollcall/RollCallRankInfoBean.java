package com.zjwh.android_wh_physicalfitness.entity.rollcall;

import java.util.List;

public class RollCallRankInfoBean {
    private List<RollCallRankBean> list;
    private RollCallRankBean myself;

    public List<RollCallRankBean> getList() {
        return this.list;
    }

    public RollCallRankBean getMyself() {
        return this.myself;
    }

    public void setList(List<RollCallRankBean> list) {
        this.list = list;
    }

    public void setMyself(RollCallRankBean rollCallRankBean) {
        this.myself = rollCallRankBean;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RollCallRankInfoBean{myself=");
        stringBuilder.append(this.myself);
        stringBuilder.append(", list=");
        stringBuilder.append(this.list);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
