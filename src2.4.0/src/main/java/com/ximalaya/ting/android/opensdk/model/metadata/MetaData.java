package com.ximalaya.ting.android.opensdk.model.metadata;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MetaData {
    private List<Attributes> attributes;
    @SerializedName("display_name")
    private String displayName;
    private String kind;

    public List<Attributes> getAttributes() {
        return this.attributes;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getKind() {
        return this.kind;
    }

    public void setAttributes(List<Attributes> list) {
        this.attributes = list;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }
}
