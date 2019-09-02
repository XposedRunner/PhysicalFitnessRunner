package com.autonavi.amap.mapcore;

public class LinkInfo {
    private int length = 0;
    private int state = 0;
    private int time = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("状态：");
        stringBuilder.append(this.state);
        stringBuilder.append("|");
        stringBuilder.append("时间：");
        stringBuilder.append(this.time);
        stringBuilder.append("|");
        stringBuilder.append("长度：");
        stringBuilder.append(this.length);
        return stringBuilder.toString();
    }
}
