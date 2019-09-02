package com.zjwh.android_wh_physicalfitness.entity;

public class BannerBean {
    public static final int TYPE_ACTIVITY = 6;
    public static final int TYPE_ALBUM_DETAIL = 8;
    public static final int TYPE_ARTICLE = 1;
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_TOPIC = 2;
    public static final int TYPE_WEB = 5;
    public static final int TYPE_WECHAT_PROGRAM = 7;
    private String adExposingCodes;
    private MessageBodyBean body;
    private int id;
    private String imgUrl;
    private int type;

    public String getAdExposingCodes() {
        return this.adExposingCodes;
    }

    public MessageBodyBean getBody() {
        return this.body;
    }

    public int getId() {
        return this.id;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getType() {
        return this.type;
    }

    public void setAdExposingCodes(String str) {
        this.adExposingCodes = str;
    }

    public void setBody(MessageBodyBean messageBodyBean) {
        this.body = messageBodyBean;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BannerBean{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", imgUrl='");
        stringBuilder.append(this.imgUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", body=");
        stringBuilder.append(this.body);
        stringBuilder.append(", adExposingCodes='");
        stringBuilder.append(this.adExposingCodes);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
