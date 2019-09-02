package com.zjwh.android_wh_physicalfitness.entity.mine;

public class ClassBean {
    private int classId;
    private String className;

    public int getClassId() {
        return this.classId;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassId(int i) {
        this.classId = i;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassBean{classId=");
        stringBuilder.append(this.classId);
        stringBuilder.append(", className='");
        stringBuilder.append(this.className);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
