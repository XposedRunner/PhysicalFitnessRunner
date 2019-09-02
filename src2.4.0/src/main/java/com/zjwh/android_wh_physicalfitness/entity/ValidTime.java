package com.zjwh.android_wh_physicalfitness.entity;

public class ValidTime {
    private String end;
    private String start;

    public String getEnd() {
        return this.end;
    }

    public String getStart() {
        return this.start;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public void setStart(String str) {
        this.start = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ValidTime{start='");
        stringBuilder.append(this.start);
        stringBuilder.append('\'');
        stringBuilder.append(", end='");
        stringBuilder.append(this.end);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
