package com.zjwh.android_wh_physicalfitness.entity.statistics;

public class DeviceActivationInfo {
    public String channel;
    public String device_model;
    public String imei;
    public String imsi;
    public String mac_address;
    public String os_version;

    public DeviceActivationInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.device_model = str;
        this.os_version = str2;
        this.mac_address = str3;
        this.imei = str4;
        this.imsi = str5;
        this.channel = str6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceActivationInfo{device_model='");
        stringBuilder.append(this.device_model);
        stringBuilder.append('\'');
        stringBuilder.append(", os_version='");
        stringBuilder.append(this.os_version);
        stringBuilder.append('\'');
        stringBuilder.append(", mac_address='");
        stringBuilder.append(this.mac_address);
        stringBuilder.append('\'');
        stringBuilder.append(", imei='");
        stringBuilder.append(this.imei);
        stringBuilder.append('\'');
        stringBuilder.append(", imsi='");
        stringBuilder.append(this.imsi);
        stringBuilder.append('\'');
        stringBuilder.append(", channel='");
        stringBuilder.append(this.channel);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
