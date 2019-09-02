package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;

public class ClassResModel implements Serializable {
    public int cid;
    public String className;
    public boolean myClass;

    public ClassResModel(int i, String str, boolean z) {
        this.cid = i;
        this.className = str;
        this.myClass = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassResModel{cid=");
        stringBuilder.append(this.cid);
        stringBuilder.append(", className='");
        stringBuilder.append(this.className);
        stringBuilder.append('\'');
        stringBuilder.append(", myClass=");
        stringBuilder.append(this.myClass);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
