package com.zjwh.android_wh_physicalfitness.entity;

import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import java.util.List;

public class RunRuleModel {
    public static final String SP_KEY_MIN_DISTANCE = "sp_key_min_distance";
    private double dayGoal;
    private int minDistance;
    private int minRunTime;
    private String runRulesUrl;
    private double speedBottom;
    private double speedTop;
    private int stepBottom;
    private int stepTop;
    private List<ValidTime> validTime;

    public double getDayGoal() {
        return this.dayGoal;
    }

    public int getMinDistance() {
        int intValue = ((Integer) O00O0Oo0.O00000o0(SP_KEY_MIN_DISTANCE, Integer.valueOf(this.minDistance))).intValue();
        return (intValue - this.minDistance == 0 || intValue <= 0) ? this.minDistance : intValue;
    }

    public int getMinRunTime() {
        return this.minRunTime;
    }

    public String getRunRulesUrl() {
        return this.runRulesUrl;
    }

    public double getSpeedBottom() {
        return this.speedBottom;
    }

    public double getSpeedTop() {
        return this.speedTop;
    }

    public int getStepBottom() {
        return this.stepBottom;
    }

    public int getStepTop() {
        return this.stepTop;
    }

    public List<ValidTime> getValidTime() {
        return this.validTime;
    }

    public void setDayGoal(double d) {
        this.dayGoal = d;
    }

    public void setMinDistance(int i) {
        this.minDistance = i;
    }

    public void setMinRunTime(int i) {
        this.minRunTime = i;
    }

    public void setRunRulesUrl(String str) {
        this.runRulesUrl = str;
    }

    public void setSpeedBottom(double d) {
        this.speedBottom = d;
    }

    public void setSpeedTop(double d) {
        this.speedTop = d;
    }

    public void setStepBottom(int i) {
        this.stepBottom = i;
    }

    public void setStepTop(int i) {
        this.stepTop = i;
    }

    public void setValidTimes(List<ValidTime> list) {
        this.validTime = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RunRuleModel{dayGoal=");
        stringBuilder.append(this.dayGoal);
        stringBuilder.append(", minDistance=");
        stringBuilder.append(this.minDistance);
        stringBuilder.append(", minRunTime=");
        stringBuilder.append(this.minRunTime);
        stringBuilder.append(", runRulesUrl='");
        stringBuilder.append(this.runRulesUrl);
        stringBuilder.append('\'');
        stringBuilder.append(", speedTop=");
        stringBuilder.append(this.speedTop);
        stringBuilder.append(", speedBottom=");
        stringBuilder.append(this.speedBottom);
        stringBuilder.append(", stepTop=");
        stringBuilder.append(this.stepTop);
        stringBuilder.append(", stepBottom=");
        stringBuilder.append(this.stepBottom);
        stringBuilder.append(", validTimes=");
        stringBuilder.append(this.validTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
