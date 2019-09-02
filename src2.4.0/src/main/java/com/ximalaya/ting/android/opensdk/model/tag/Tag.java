package com.ximalaya.ting.android.opensdk.model.tag;

import com.google.gson.annotations.SerializedName;

public class Tag {
    @SerializedName("kind")
    private String kind;
    @SerializedName("tag_name")
    private String tagName;

    public String getKind() {
        return this.kind;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tag{tagName='");
        stringBuilder.append(this.tagName);
        stringBuilder.append('\'');
        stringBuilder.append(", kind='");
        stringBuilder.append(this.kind);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
