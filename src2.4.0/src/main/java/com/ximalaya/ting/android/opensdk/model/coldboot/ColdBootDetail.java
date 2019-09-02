package com.ximalaya.ting.android.opensdk.model.coldboot;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class ColdBootDetail extends XimalayaResponse {
    @SerializedName("coldboot_genre")
    private String coldBootGenre;
    @SerializedName("coldboot_sub_genre")
    private String coldBootSubGenre;
    @SerializedName("coldboot_tags")
    private List<String> coldBootTagList;
    @SerializedName("device_id")
    private String deviceId;
    @SerializedName("device_type")
    private String deviceType;
    private String kind;

    public String getColdBootGenre() {
        return this.coldBootGenre;
    }

    public String getColdBootSubGenre() {
        return this.coldBootSubGenre;
    }

    public List<String> getColdBootTagList() {
        return this.coldBootTagList;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public String getKind() {
        return this.kind;
    }

    public void setColdBootGenre(String str) {
        this.coldBootGenre = str;
    }

    public void setColdBootSubGenre(String str) {
        this.coldBootSubGenre = str;
    }

    public void setColdBootTagList(List<String> list) {
        this.coldBootTagList = list;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }
}
