package com.amap.api.maps.model;

public class CustomMapStyleOptions {
    private boolean enable = true;
    private byte[] styleData = null;
    private String styleDataPath = null;
    private byte[] styleExtraData = null;
    private String styleExtraPath = null;
    private String styleId = null;
    private byte[] styleTextureData = null;
    private String styleTexturePath = null;

    public byte[] getStyleData() {
        return this.styleData;
    }

    public String getStyleDataPath() {
        return this.styleDataPath;
    }

    public byte[] getStyleExtraData() {
        return this.styleExtraData;
    }

    public String getStyleExtraPath() {
        return this.styleExtraPath;
    }

    public String getStyleId() {
        return this.styleId;
    }

    public byte[] getStyleTextureData() {
        return this.styleTextureData;
    }

    public String getStyleTexturePath() {
        return this.styleTexturePath;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public CustomMapStyleOptions setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public CustomMapStyleOptions setStyleData(byte[] bArr) {
        this.styleData = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleDataPath(String str) {
        this.styleDataPath = str;
        return this;
    }

    public CustomMapStyleOptions setStyleExtraData(byte[] bArr) {
        this.styleExtraData = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleExtraPath(String str) {
        this.styleExtraPath = str;
        return this;
    }

    public CustomMapStyleOptions setStyleId(String str) {
        this.styleId = str;
        return this;
    }

    public CustomMapStyleOptions setStyleTextureData(byte[] bArr) {
        this.styleTextureData = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleTexturePath(String str) {
        this.styleTexturePath = str;
        return this;
    }
}
