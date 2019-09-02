package com.ximalaya.ting.android.opensdk.model.ranks;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class RankList extends XimalayaResponse {
    private List<Rank> rankList;

    public List<Rank> getRankList() {
        return this.rankList;
    }

    public void setRankList(List<Rank> list) {
        this.rankList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RankList{rankList=");
        stringBuilder.append(this.rankList);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
