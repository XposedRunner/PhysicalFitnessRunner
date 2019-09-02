package com.ximalaya.ting.android.opensdk.model.ranks;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Rank {
    @SerializedName("category_id")
    private long categoryId;
    @SerializedName("cover_url")
    private String coverUrl;
    @SerializedName("rank_content_type")
    private String rankContentType;
    @SerializedName("rank_first_item_id")
    private long rankFirstItemId;
    @SerializedName("rank_first_item_title")
    private String rankFirstItemTitle;
    @SerializedName("index_rank_items")
    private List<RankItem> rankItemList;
    @SerializedName("rank_item_num")
    private int rankItemNum;
    @SerializedName("rank_key")
    private String rankKey;
    @SerializedName("rank_order_num")
    private int rankOrderNum;
    @SerializedName("rank_period")
    private int rankPeriod;
    @SerializedName("rank_period_type")
    private String rankPeriodType;
    @SerializedName("rank_sub_title")
    private String rankSubTitle;
    @SerializedName("rank_title")
    private String rankTitle;
    @SerializedName("rank_type")
    private int rankType;

    public long getCategoryId() {
        return this.categoryId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getRankContentType() {
        return this.rankContentType;
    }

    public long getRankFirstItemId() {
        return this.rankFirstItemId;
    }

    public String getRankFirstItemTitle() {
        return this.rankFirstItemTitle;
    }

    public List<RankItem> getRankItemList() {
        return this.rankItemList;
    }

    public int getRankItemNum() {
        return this.rankItemNum;
    }

    public String getRankKey() {
        return this.rankKey;
    }

    public int getRankOrderNum() {
        return this.rankOrderNum;
    }

    public int getRankPeriod() {
        return this.rankPeriod;
    }

    public String getRankPeriodType() {
        return this.rankPeriodType;
    }

    public String getRankSubTitle() {
        return this.rankSubTitle;
    }

    public String getRankTitle() {
        return this.rankTitle;
    }

    public int getRankType() {
        return this.rankType;
    }

    public void setCategoryId(long j) {
        this.categoryId = j;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setRankContentType(String str) {
        this.rankContentType = str;
    }

    public void setRankFirstItemId(long j) {
        this.rankFirstItemId = j;
    }

    public void setRankFirstItemTitle(String str) {
        this.rankFirstItemTitle = str;
    }

    public void setRankItemList(List<RankItem> list) {
        this.rankItemList = list;
    }

    public void setRankItemNum(int i) {
        this.rankItemNum = i;
    }

    public void setRankKey(String str) {
        this.rankKey = str;
    }

    public void setRankOrderNum(int i) {
        this.rankOrderNum = i;
    }

    public void setRankPeriod(int i) {
        this.rankPeriod = i;
    }

    public void setRankPeriodType(String str) {
        this.rankPeriodType = str;
    }

    public void setRankSubTitle(String str) {
        this.rankSubTitle = str;
    }

    public void setRankTitle(String str) {
        this.rankTitle = str;
    }

    public void setRankType(int i) {
        this.rankType = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rank [rankKey=");
        stringBuilder.append(this.rankKey);
        stringBuilder.append(", rankTitle=");
        stringBuilder.append(this.rankTitle);
        stringBuilder.append(", rankType=");
        stringBuilder.append(this.rankType);
        stringBuilder.append(", rankSubTitle=");
        stringBuilder.append(this.rankSubTitle);
        stringBuilder.append(", rankPeriod=");
        stringBuilder.append(this.rankPeriod);
        stringBuilder.append(", rankPeriodType=");
        stringBuilder.append(this.rankPeriodType);
        stringBuilder.append(", rankItemNum=");
        stringBuilder.append(this.rankItemNum);
        stringBuilder.append(", rankOrderNum=");
        stringBuilder.append(this.rankOrderNum);
        stringBuilder.append(", coverUrl=");
        stringBuilder.append(this.coverUrl);
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", rankCOntentType=");
        stringBuilder.append(this.rankContentType);
        stringBuilder.append(", rankFirstItemId=");
        stringBuilder.append(this.rankFirstItemId);
        stringBuilder.append(", rankFirstItemTitle=");
        stringBuilder.append(this.rankFirstItemTitle);
        stringBuilder.append(", rankItemList=");
        stringBuilder.append(this.rankItemList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
