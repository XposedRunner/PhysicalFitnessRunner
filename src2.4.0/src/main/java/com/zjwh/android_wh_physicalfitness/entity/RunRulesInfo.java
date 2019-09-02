package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;

public class RunRulesInfo implements Serializable {
    public String dayGoal;
    public String runRulesUrl;
    public String semGoal;

    public RunRulesInfo(String str, String str2, String str3) {
        this.runRulesUrl = str;
        this.semGoal = str2;
        this.dayGoal = str3;
    }
}
