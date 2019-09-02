package com.ximalaya.ting.android.opensdk.model.metadata;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Attributes extends ChildAttributes {
    @SerializedName("child_metadatas")
    private List<ChildMetadata> childMetadatas;

    public List<ChildMetadata> getChildMetadatas() {
        return this.childMetadatas;
    }

    public void setChildMetadatas(List<ChildMetadata> list) {
        this.childMetadatas = list;
    }
}
