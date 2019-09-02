package com.zjwh.android_wh_physicalfitness.entity;

public class EmulatorSwitchBean {
    private boolean cpu;
    private boolean cpuFreq;
    private boolean file;
    private boolean gps;
    private boolean gravity;
    private boolean kernel;
    private int passCount;
    private boolean temp;
    private boolean volt;

    public int getPassCount() {
        return this.passCount;
    }

    public boolean isCpu() {
        return this.cpu;
    }

    public boolean isCpuFreq() {
        return this.cpuFreq;
    }

    public boolean isFile() {
        return this.file;
    }

    public boolean isGps() {
        return this.gps;
    }

    public boolean isGravity() {
        return this.gravity;
    }

    public boolean isKernel() {
        return this.kernel;
    }

    public boolean isTemp() {
        return this.temp;
    }

    public boolean isVolt() {
        return this.volt;
    }

    public void setCpu(boolean z) {
        this.cpu = z;
    }

    public void setCpuFreq(boolean z) {
        this.cpuFreq = z;
    }

    public void setFile(boolean z) {
        this.file = z;
    }

    public void setGps(boolean z) {
        this.gps = z;
    }

    public void setGravity(boolean z) {
        this.gravity = z;
    }

    public void setKernel(boolean z) {
        this.kernel = z;
    }

    public void setPassCount(int i) {
        this.passCount = i;
    }

    public void setTemp(boolean z) {
        this.temp = z;
    }

    public void setVolt(boolean z) {
        this.volt = z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EmulatorSwitchBean{cpu=");
        stringBuilder.append(this.cpu);
        stringBuilder.append(", cpuFreq=");
        stringBuilder.append(this.cpuFreq);
        stringBuilder.append(", kernel=");
        stringBuilder.append(this.kernel);
        stringBuilder.append(", gravity=");
        stringBuilder.append(this.gravity);
        stringBuilder.append(", temp=");
        stringBuilder.append(this.temp);
        stringBuilder.append(", volt=");
        stringBuilder.append(this.volt);
        stringBuilder.append(", gps=");
        stringBuilder.append(this.gps);
        stringBuilder.append(", file=");
        stringBuilder.append(this.file);
        stringBuilder.append(", passCount=");
        stringBuilder.append(this.passCount);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
