package com.ximalaya.ting.android.opensdk.model.category;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("cover_url_large")
    private String coverUrlLarge;
    @SerializedName("cover_url_middle")
    private String coverUrlMiddle;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    private long id;
    private String kind;
    @SerializedName("need_show_high_quality_tag")
    private boolean needAddHighQualityTag;

    public String getCategoryName() {
        return this.categoryName;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlMiddle() {
        return this.coverUrlMiddle;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public long getId() {
        return this.id;
    }

    public String getKind() {
        return this.kind;
    }

    public boolean isNeedAddHighQualityTag() {
        return this.needAddHighQualityTag;
    }

    public void setCategoryName(String str) {
        this.categoryName = str;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlMiddle(String str) {
        this.coverUrlMiddle = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Category [id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", kind=");
        stringBuilder.append(this.kind);
        stringBuilder.append(", categoryName=");
        stringBuilder.append(this.categoryName);
        stringBuilder.append(", coverUrlSmall=");
        stringBuilder.append(this.coverUrlSmall);
        stringBuilder.append(", coverUrlMiddle=");
        stringBuilder.append(this.coverUrlMiddle);
        stringBuilder.append(", coverUrlLarge=");
        stringBuilder.append(this.coverUrlLarge);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
