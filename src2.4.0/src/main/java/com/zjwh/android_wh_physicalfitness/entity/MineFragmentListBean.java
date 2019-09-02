package com.zjwh.android_wh_physicalfitness.entity;

public class MineFragmentListBean {
    public static final int MINE_COURSE = 30006;
    public static final int MINE_NOTICE = 30008;
    public static final int MINE_RANK_HISTORY = 30003;
    public static final int MINE_ROLL_CALL = 30009;
    public static final int MINE_RUN_HISTORY = 30002;
    public static final int MINE_RUN_PRIZE = 30001;
    public static final int MINE_SCORE = 30005;
    public static final int MINE_SMART_ATTENDANCE = 30004;
    public static final int MINE_SPORT_CAMPUS = 30010;
    public static final int MINE_STUDENT = 30007;
    private String iconUrl;
    private String jumpUrl;
    private int moduleId;
    private String moduleName;
    private boolean newMessage;

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public boolean isNewMessage() {
        return this.newMessage;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setNewMessage(boolean z) {
        this.newMessage = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MineFragmentListBean{iconUrl='");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", moduleId=");
        stringBuilder.append(this.moduleId);
        stringBuilder.append(", jumpUrl='");
        stringBuilder.append(this.jumpUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", moduleName='");
        stringBuilder.append(this.moduleName);
        stringBuilder.append('\'');
        stringBuilder.append(", newMessage=");
        stringBuilder.append(this.newMessage);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
