package com.zjwh.android_wh_physicalfitness.entity;

import java.util.List;

public class PersonalRankBean {
    PersonalRank myRank;
    List<PersonalRank> rankList;

    public PersonalRank getMyRank() {
        return this.myRank;
    }

    public List<PersonalRank> getRankList() {
        return this.rankList;
    }

    public void setMyRank(PersonalRank personalRank) {
        this.myRank = personalRank;
    }

    public void setRankList(List<PersonalRank> list) {
        this.rankList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersonalRankBean{myRank=");
        stringBuilder.append(this.myRank);
        stringBuilder.append(", rankList=");
        stringBuilder.append(this.rankList);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
