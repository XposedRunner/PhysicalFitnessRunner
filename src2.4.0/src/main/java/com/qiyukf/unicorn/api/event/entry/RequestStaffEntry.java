package com.qiyukf.unicorn.api.event.entry;

import com.qiyukf.unicorn.api.ProductDetail;

public class RequestStaffEntry {
    private String custom;
    private long entryId;
    private long faqGroupId;
    private long groupId;
    private boolean isHumanOnly;
    private boolean isRobot;
    private String label;
    private ProductDetail productDetail;
    private boolean robotFirst;
    private long robotId;
    private int scenes;
    private String shopId;
    private long staffId;
    private String title;
    private String uri;
    public int vipLevel;

    public String getCustom() {
        return this.custom;
    }

    public long getEntryId() {
        return this.entryId;
    }

    public long getFaqGroupId() {
        return this.faqGroupId;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getLabel() {
        return this.label;
    }

    public ProductDetail getProductDetail() {
        return this.productDetail;
    }

    public long getRobotId() {
        return this.robotId;
    }

    public int getScenes() {
        return this.scenes;
    }

    public String getShopId() {
        return this.shopId;
    }

    public long getStaffId() {
        return this.staffId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUri() {
        return this.uri;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public boolean isHumanOnly() {
        return this.isHumanOnly;
    }

    public boolean isRobot() {
        return this.isRobot;
    }

    public boolean isRobotFirst() {
        return this.robotFirst;
    }

    public void setCustom(String str) {
        this.custom = str;
    }

    public void setEntryId(long j) {
        this.entryId = j;
    }

    public void setFaqGroupId(long j) {
        this.faqGroupId = j;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public void setHumanOnly(boolean z) {
        this.isHumanOnly = z;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public void setRobot(boolean z) {
        this.isRobot = z;
    }

    public void setRobotFirst(boolean z) {
        this.robotFirst = z;
    }

    public void setRobotId(long j) {
        this.robotId = j;
    }

    public void setScenes(int i) {
        this.scenes = i;
    }

    public void setShopId(String str) {
        this.shopId = str;
    }

    public void setStaffId(long j) {
        this.staffId = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public void setVipLevel(int i) {
        this.vipLevel = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("scenes:");
        stringBuilder.append(getScenes());
        stringBuilder.append("isHumanOnly:");
        stringBuilder.append(isHumanOnly());
        stringBuilder.append("isRobot:");
        stringBuilder.append(this.isRobot);
        stringBuilder.append("label");
        stringBuilder.append(getLabel());
        stringBuilder.append("entryId:");
        stringBuilder.append(getEntryId());
        stringBuilder.append("shopId:");
        stringBuilder.append(getShopId());
        stringBuilder.append("uri:");
        stringBuilder.append(getUri());
        stringBuilder.append("title:");
        stringBuilder.append(getTitle());
        stringBuilder.append("custom:");
        stringBuilder.append(getCustom());
        stringBuilder.append("groupId:");
        stringBuilder.append(getGroupId());
        stringBuilder.append("staffId:");
        stringBuilder.append(getStaffId());
        stringBuilder.append("robotFirst:");
        stringBuilder.append(isRobotFirst());
        stringBuilder.append("robotId:");
        stringBuilder.append(getRobotId());
        stringBuilder.append("faqGroupId:");
        stringBuilder.append(getFaqGroupId());
        return stringBuilder.toString();
    }
}
