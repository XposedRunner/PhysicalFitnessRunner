package com.zjwh.android_wh_physicalfitness.entity.statistics;

import com.zjwh.android_wh_physicalfitness.utils.O000OO;
import org.xutils.common.util.MD5;

public class PvDataInfoV29 extends PvDataInfo {
    private String androidId = O000OO.O0000Oo0();
    private String androidMac = MD5.md5(O000OO.O0000o0o().toUpperCase().replace(":", ""));
    private String sn = O000OO.O0000Oo();

    public PvDataInfoV29(int i, String str) {
        super(i, str);
    }

    public String getAndroidId() {
        return this.androidId;
    }

    public String getAndroidMac() {
        return this.androidMac;
    }

    public String getSn() {
        return this.sn;
    }

    public void setAndroidId(String str) {
        this.androidId = str;
    }

    public void setAndroidMac(String str) {
        this.androidMac = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PvDataInfoV29{sn='");
        stringBuilder.append(this.sn);
        stringBuilder.append('\'');
        stringBuilder.append(", androidId='");
        stringBuilder.append(this.androidId);
        stringBuilder.append('\'');
        stringBuilder.append(", androidMac='");
        stringBuilder.append(this.androidMac);
        stringBuilder.append('\'');
        stringBuilder.append(", module=");
        stringBuilder.append(this.module);
        stringBuilder.append(", itemId='");
        stringBuilder.append(this.itemId);
        stringBuilder.append('\'');
        stringBuilder.append(", stayTime=");
        stringBuilder.append(this.stayTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
