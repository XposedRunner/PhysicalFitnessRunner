package com.zjwh.android_wh_physicalfitness.entity;

public class RandomConfigBean {
    private int policy;
    private int selDistance;
    private long timestamp;

    public int getPolicy() {
        return this.policy;
    }

    public int getSelDistance() {
        return this.selDistance;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setPolicy(int i) {
        this.policy = i;
    }

    public void setSelDistance(int i) {
        this.selDistance = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RandomConfigBean{policy=");
        stringBuilder.append(this.policy);
        stringBuilder.append(", selDistance=");
        stringBuilder.append(this.selDistance);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
