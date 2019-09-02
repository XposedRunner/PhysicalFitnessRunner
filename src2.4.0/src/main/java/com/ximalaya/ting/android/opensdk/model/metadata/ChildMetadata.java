package com.ximalaya.ting.android.opensdk.model.metadata;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ChildMetadata {
    private List<ChildAttributes> attributes;
    @SerializedName("display_name")
    private String displayName;
    private String kind;

    public List<ChildAttributes> getAttributes() {
        return this.attributes;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getKind() {
        return this.kind;
    }

    public void setAttributes(List<ChildAttributes> list) {
        this.attributes = list;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }
}
