package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;
import java.util.List;

public class HomePageInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private ChannelInfoModel channelInfoModel;
    private RunModeModel runModeModel;
    private RunModel runModel;
    private RunRuleModel runRuleModel;
    private SchoolInfoModel schoolInfoModel;
    private List<SemesterInfo> semesterInfo;
    private SemesterInfoModel semesterInfoModel;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ChannelInfoModel getChannelInfoModel() {
        return this.channelInfoModel;
    }

    public RunModeModel getRunModeModel() {
        return this.runModeModel;
    }

    public RunModel getRunModel() {
        return this.runModel;
    }

    public RunRuleModel getRunRuleModel() {
        return this.runRuleModel;
    }

    public SchoolInfoModel getSchoolInfoModel() {
        return this.schoolInfoModel;
    }

    public List<SemesterInfo> getSemesterInfo() {
        return this.semesterInfo;
    }

    public SemesterInfoModel getSemesterInfoModel() {
        return this.semesterInfoModel;
    }

    public void setChannelInfoModel(ChannelInfoModel channelInfoModel) {
        this.channelInfoModel = channelInfoModel;
    }

    public void setRunModeModel(RunModeModel runModeModel) {
        this.runModeModel = runModeModel;
    }

    public void setRunModel(RunModel runModel) {
        this.runModel = runModel;
    }

    public void setRunModell(RunModel runModel) {
        this.runModel = runModel;
    }

    public void setRunRuleModel(RunRuleModel runRuleModel) {
        this.runRuleModel = runRuleModel;
    }

    public void setSchoolInfoModel(SchoolInfoModel schoolInfoModel) {
        this.schoolInfoModel = schoolInfoModel;
    }

    public void setSemesterInfo(List<SemesterInfo> list) {
        this.semesterInfo = list;
    }

    public void setSemesterInfoModel(SemesterInfoModel semesterInfoModel) {
        this.semesterInfoModel = semesterInfoModel;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HomePageInfo{channelInfoModel=");
        stringBuilder.append(this.channelInfoModel);
        stringBuilder.append(", runModeModel=");
        stringBuilder.append(this.runModeModel);
        stringBuilder.append(", runModel=");
        stringBuilder.append(this.runModel);
        stringBuilder.append(", runRuleModel=");
        stringBuilder.append(this.runRuleModel);
        stringBuilder.append(", schoolInfoModel=");
        stringBuilder.append(this.schoolInfoModel);
        stringBuilder.append(", semesterInfoModel=");
        stringBuilder.append(this.semesterInfoModel);
        stringBuilder.append(", semesterInfo=");
        stringBuilder.append(this.semesterInfo);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
