package com.ximalaya.ting.android.opensdk.model.app;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;

public class AppModel extends XimalayaResponse {
    @SerializedName("created_at")
    private long createdAt;
    @SerializedName("id")
    private long dataId;
    @SerializedName("download_url")
    private String downloadUrl;
    @SerializedName("file_name")
    private String filename;
    @SerializedName("sdk_or_app_name")
    private String name;
    @SerializedName("client_os_type")
    private int osType;
    @SerializedName("pack_id")
    private String packId;
    @SerializedName("release_info")
    private String releaseInfo;
    @SerializedName("release_type")
    private int releaseType;
    @SerializedName("updated_at")
    private long updatedAt;
    @SerializedName("version_code")
    private int versionCode;
    @SerializedName("version_name")
    private String versionName;

    public long getCreatedAt() {
        return this.createdAt;
    }

    public long getDataId() {
        return this.dataId;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getName() {
        return this.name;
    }

    public int getOsType() {
        return this.osType;
    }

    public String getPackId() {
        return this.packId;
    }

    public String getReleaseInfo() {
        return this.releaseInfo;
    }

    public int getReleaseType() {
        return this.releaseType;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setCreatedAt(long j) {
        this.createdAt = j;
    }

    public void setDataId(long j) {
        this.dataId = j;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOsType(int i) {
        this.osType = i;
    }

    public void setPackId(String str) {
        this.packId = str;
    }

    public void setReleaseInfo(String str) {
        this.releaseInfo = str;
    }

    public void setReleaseType(int i) {
        this.releaseType = i;
    }

    public void setUpdatedAt(long j) {
        this.updatedAt = j;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppModel [dataId=");
        stringBuilder.append(this.dataId);
        stringBuilder.append(", releaseType=");
        stringBuilder.append(this.releaseType);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", packId=");
        stringBuilder.append(this.packId);
        stringBuilder.append(", osType=");
        stringBuilder.append(this.osType);
        stringBuilder.append(", versionCode=");
        stringBuilder.append(this.versionCode);
        stringBuilder.append(", versionName=");
        stringBuilder.append(this.versionName);
        stringBuilder.append(", releaseInfo=");
        stringBuilder.append(this.releaseInfo);
        stringBuilder.append(", downloadUrl=");
        stringBuilder.append(this.downloadUrl);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", createdAt=");
        stringBuilder.append(this.createdAt);
        stringBuilder.append(", filename=");
        stringBuilder.append(this.filename);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
