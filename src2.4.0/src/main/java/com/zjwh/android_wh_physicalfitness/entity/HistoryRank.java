package com.zjwh.android_wh_physicalfitness.entity;

public class HistoryRank {
    private String champIcon;
    private String champName;
    private int champUid;
    private int curUserDis;
    private String curUserIcon;
    private int curUserOrder;
    private String hisRankId;

    public String getChampIcon() {
        return this.champIcon;
    }

    public String getChampName() {
        return this.champName;
    }

    public int getChampUid() {
        return this.champUid;
    }

    public int getCurUserDis() {
        return this.curUserDis;
    }

    public String getCurUserIcon() {
        return this.curUserIcon;
    }

    public int getCurUserOrder() {
        return this.curUserOrder;
    }

    public String getHisRankId() {
        return this.hisRankId;
    }

    public void setChampIcon(String str) {
        this.champIcon = str;
    }

    public void setChampName(String str) {
        this.champName = str;
    }

    public void setChampUid(int i) {
        this.champUid = i;
    }

    public void setCurUserDis(int i) {
        this.curUserDis = i;
    }

    public void setCurUserIcon(String str) {
        this.curUserIcon = str;
    }

    public void setCurUserOrder(int i) {
        this.curUserOrder = i;
    }

    public void setHisRankId(String str) {
        this.hisRankId = str;
    }
}
