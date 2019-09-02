package com.ximalaya.ting.android.opensdk.model.user;

import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class XmUserInfo extends XimalayaResponse {
    @SerializedName("birth_day")
    private String birthDay;
    @SerializedName("birth_month")
    private String birthMonth;
    @SerializedName("birth_year")
    private String birthYear;
    private int id;
    @SerializedName("interested_album_ids")
    private List<Long> interestedAlbumIds;
    @SerializedName("interested_category_ids")
    private List<Integer> interestedCategoryIds;
    private String kind;
    @SerializedName("last_play_at")
    private long lastPlayAt;
    @SerializedName("login_historys")
    private List<LoginHistory> loginHistorys;
    private int sex;

    public String getBirthDay() {
        return this.birthDay;
    }

    public String getBirthMonth() {
        return this.birthMonth;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public int getId() {
        return this.id;
    }

    public List<Long> getInterestedAlbumIds() {
        return this.interestedAlbumIds;
    }

    public List<Integer> getInterestedCategoryIds() {
        return this.interestedCategoryIds;
    }

    public String getKind() {
        return this.kind;
    }

    public long getLastPlayAt() {
        return this.lastPlayAt;
    }

    public List<LoginHistory> getLoginHistorys() {
        return this.loginHistorys;
    }

    public int getSex() {
        return this.sex;
    }

    public void setBirthDay(String str) {
        this.birthDay = str;
    }

    public void setBirthMonth(String str) {
        this.birthMonth = str;
    }

    public void setBirthYear(String str) {
        this.birthYear = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setInterestedAlbumIds(List<Long> list) {
        this.interestedAlbumIds = list;
    }

    public void setInterestedCategoryIds(List<Integer> list) {
        this.interestedCategoryIds = list;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setLastPlayAt(long j) {
        this.lastPlayAt = j;
    }

    public void setLoginHistorys(List<LoginHistory> list) {
        this.loginHistorys = list;
    }

    public void setSex(int i) {
        this.sex = i;
    }
}
