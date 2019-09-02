package com.ximalaya.ting.android.opensdk.model.column;

import com.google.gson.annotations.SerializedName;

public class Column {
    @SerializedName("column_content_type")
    private int columnContentType;
    @SerializedName("column_foot_note")
    private String columnFootNote;
    @SerializedName("id")
    private long columnId;
    @SerializedName("column_sub_title")
    private String columnSubTitle;
    @SerializedName("column_title")
    private String columnTitle;
    @SerializedName("cover_url_large")
    private String coverUrlLarge;
    @SerializedName("cover_url_small")
    private String coverUrlSmall;
    @SerializedName("is_hot")
    private boolean isHot;
    @SerializedName("released_at")
    private long releasedAt;

    public int getColumnContentType() {
        return this.columnContentType;
    }

    public String getColumnFootNote() {
        return this.columnFootNote;
    }

    public long getColumnId() {
        return this.columnId;
    }

    public String getColumnSubTitle() {
        return this.columnSubTitle;
    }

    public String getColumnTitle() {
        return this.columnTitle;
    }

    public String getCoverUrlLarge() {
        return this.coverUrlLarge;
    }

    public String getCoverUrlSmall() {
        return this.coverUrlSmall;
    }

    public long getReleasedAt() {
        return this.releasedAt;
    }

    public boolean isHot() {
        return this.isHot;
    }

    public void setColumnContentType(int i) {
        this.columnContentType = i;
    }

    public void setColumnFootNote(String str) {
        this.columnFootNote = str;
    }

    public void setColumnId(long j) {
        this.columnId = j;
    }

    public void setColumnSubTitle(String str) {
        this.columnSubTitle = str;
    }

    public void setColumnTitle(String str) {
        this.columnTitle = str;
    }

    public void setCoverUrlLarge(String str) {
        this.coverUrlLarge = str;
    }

    public void setCoverUrlSmall(String str) {
        this.coverUrlSmall = str;
    }

    public void setHot(boolean z) {
        this.isHot = z;
    }

    public void setReleasedAt(long j) {
        this.releasedAt = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Column [columnId=");
        stringBuilder.append(this.columnId);
        stringBuilder.append(", columnTitle=");
        stringBuilder.append(this.columnTitle);
        stringBuilder.append(", columnSubTitle=");
        stringBuilder.append(this.columnSubTitle);
        stringBuilder.append(", columnFootNote=");
        stringBuilder.append(this.columnFootNote);
        stringBuilder.append(", columnContentType=");
        stringBuilder.append(this.columnContentType);
        stringBuilder.append(", coverUrlSmall=");
        stringBuilder.append(this.coverUrlSmall);
        stringBuilder.append(", coverUrlLarge=");
        stringBuilder.append(this.coverUrlLarge);
        stringBuilder.append(", releasedAt=");
        stringBuilder.append(this.releasedAt);
        stringBuilder.append(", isHot=");
        stringBuilder.append(this.isHot);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
