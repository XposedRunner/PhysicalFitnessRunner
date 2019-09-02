package com.zjwh.android_wh_physicalfitness.entity.rank;

import java.util.List;

public class QCheatUploadBean {
    private List<CheatChooseBean> cheatPeople;
    private String cheatcause;
    private List<String> pictures;

    public QCheatUploadBean(String str, List<String> list, List<CheatChooseBean> list2) {
        this.cheatcause = str;
        this.pictures = list;
        this.cheatPeople = list2;
    }

    public List<CheatChooseBean> getCheatPeople() {
        return this.cheatPeople;
    }

    public String getCheatcause() {
        return this.cheatcause;
    }

    public List<String> getPictures() {
        return this.pictures;
    }

    public void setCheatPeople(List<CheatChooseBean> list) {
        this.cheatPeople = list;
    }

    public void setCheatcause(String str) {
        this.cheatcause = str;
    }

    public void setPictures(List<String> list) {
        this.pictures = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QCheatUploadBean{cheatcause='");
        stringBuilder.append(this.cheatcause);
        stringBuilder.append('\'');
        stringBuilder.append(", pictures=");
        stringBuilder.append(this.pictures);
        stringBuilder.append(", cheatPeople=");
        stringBuilder.append(this.cheatPeople);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
