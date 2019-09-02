package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class DepartmentRankBean {
    private DepartmentRank myDepartmentRank;
    private List<DepartmentRank> rankList;

    public DepartmentRank getMyDepartmentRank() {
        return this.myDepartmentRank;
    }

    public List<DepartmentRank> getRankList() {
        return this.rankList;
    }

    public void setMyDepartmentRank(DepartmentRank departmentRank) {
        this.myDepartmentRank = departmentRank;
    }

    public void setRankList(List<DepartmentRank> list) {
        this.rankList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DepartmentRankBean{myDepartmentRank=");
        stringBuilder.append(this.myDepartmentRank);
        stringBuilder.append(", rankList=");
        stringBuilder.append(this.rankList);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
