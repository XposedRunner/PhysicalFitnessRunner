package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CustomizedTrackColumnDetail extends CustomizedTrack {
    @SerializedName("customized_track_column_items")
    private List<ColumnItems> columnItemses;
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("total_count")
    private int totalCount;
    @SerializedName("total_page")
    private int totalPage;

    public List<ColumnItems> getColumnItemses() {
        return this.columnItemses;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setColumnItemses(List<ColumnItems> list) {
        this.columnItemses = list;
    }

    public void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public void setTotalCount(int i) {
        this.totalCount = i;
    }

    public void setTotalPage(int i) {
        this.totalPage = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomizedTrackColumnDetail{columnItemses=");
        stringBuilder.append(this.columnItemses);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
