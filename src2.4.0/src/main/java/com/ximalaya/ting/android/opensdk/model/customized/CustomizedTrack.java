package com.ximalaya.ting.android.opensdk.model.customized;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class CustomizedTrack extends XimalayaResponse {
    @SerializedName("channel_play_count")
    private int channelPlayCount;
    @SerializedName("column_content_count")
    private int columnContentCount;
    @SerializedName("column_intro")
    private String columnIntro;
    @SerializedName("column_title")
    private String columnTitle;
    @SerializedName("cover_url_large")
    private String coverUrlLarge;
    @SerializedName("cover_url_middle")
    private String coverUrlMiddle;
    @SerializedName("cover_url_original")
    private String coverUrlOriginal;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("dimensions")
    private List<CustomizedDimension> dimensions;
    private int id;
    private String kind;
    @SerializedName("order_num")
    private int orderNum;
    @SerializedName("updated_at")
    private long updatedAt;

    public int getChannelPlayCount() {
        return this.channelPlayCount;
    }

    public int getColumnContentCount() {
        return this.columnContentCount;
    }

    public String getColumnIntro() {
        return this.columnIntro;
    }

    public String getColumnTitle() {
        return this.columnTitle;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlMiddle() {
        return this.coverUrlMiddle;
    }

    public String getCoverUrlOriginal() {
        return this.coverUrlOriginal;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public List<CustomizedDimension> getDimensions() {
        return this.dimensions;
    }

    public int getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public int getOrderNum() {
        return this.orderNum;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setChannelPlayCount(int i) {
        this.channelPlayCount = i;
    }

    public void setColumnContentCount(int i) {
        this.columnContentCount = i;
    }

    public void setColumnIntro(String str) {
        this.columnIntro = str;
    }

    public void setColumnTitle(String str) {
        this.columnTitle = str;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlMiddle(String str) {
        this.coverUrlMiddle = str;
    }

    public void setCoverUrlOriginal(String str) {
        this.coverUrlOriginal = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDimensions(List<CustomizedDimension> list) {
        this.dimensions = list;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setOrderNum(int i) {
        this.orderNum = i;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomizedTrack{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", kind='");
        stringBuilder.append(this.kind);
        stringBuilder.append('\'');
        stringBuilder.append(", columnTitle='");
        stringBuilder.append(this.columnTitle);
        stringBuilder.append('\'');
        stringBuilder.append(", columnIntro='");
        stringBuilder.append(this.columnIntro);
        stringBuilder.append('\'');
        stringBuilder.append(", columnContentCount=");
        stringBuilder.append(this.columnContentCount);
        stringBuilder.append(", channelPlayCount=");
        stringBuilder.append(this.channelPlayCount);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.createdAt);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", coverUrlOriginal='");
        stringBuilder.append(this.coverUrlOriginal);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlLarge='");
        stringBuilder.append(this.coverUrlLarge);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlMiddle='");
        stringBuilder.append(this.coverUrlMiddle);
        stringBuilder.append('\'');
        stringBuilder.append(", coverUrlSmall='");
        stringBuilder.append(this.coverUrlSmall);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
