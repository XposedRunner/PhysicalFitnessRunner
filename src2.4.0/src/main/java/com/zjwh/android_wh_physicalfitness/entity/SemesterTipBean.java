package com.zjwh.android_wh_physicalfitness.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class SemesterTipBean implements Parcelable {
    public static final Creator<SemesterTipBean> CREATOR = new Creator<SemesterTipBean>() {
        public SemesterTipBean createFromParcel(Parcel parcel) {
            return new SemesterTipBean(parcel);
        }

        public SemesterTipBean[] newArray(int i) {
            return new SemesterTipBean[i];
        }
    };
    private String distanceLimit;
    private String gradeLimit;
    private boolean hasSemester;
    private List<String> runValidTime;
    private String semesterGoal;
    private boolean showMoreLimit;
    private String speedLimit;
    private String time;

    protected SemesterTipBean(Parcel parcel) {
        boolean z = false;
        this.showMoreLimit = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.hasSemester = z;
        this.semesterGoal = parcel.readString();
        this.time = parcel.readString();
        this.gradeLimit = parcel.readString();
        this.distanceLimit = parcel.readString();
        this.speedLimit = parcel.readString();
        this.runValidTime = parcel.createStringArrayList();
    }

    public int describeContents() {
        return 0;
    }

    public String getDistanceLimit() {
        return this.distanceLimit;
    }

    public String getGradeLimit() {
        return this.gradeLimit;
    }

    public List<String> getRunValidTime() {
        return this.runValidTime;
    }

    public String getSemesterGoal() {
        return this.semesterGoal;
    }

    public String getSpeedLimit() {
        return this.speedLimit;
    }

    public String getTime() {
        return this.time;
    }

    public boolean isHasSemester() {
        return this.hasSemester;
    }

    public boolean isShowMoreLimit() {
        return this.showMoreLimit;
    }

    public void setDistanceLimit(String str) {
        this.distanceLimit = str;
    }

    public void setGradeLimit(String str) {
        this.gradeLimit = str;
    }

    public void setHasSemester(boolean z) {
        this.hasSemester = z;
    }

    public void setRunValidTime(List<String> list) {
        this.runValidTime = list;
    }

    public void setSemesterGoal(String str) {
        this.semesterGoal = str;
    }

    public void setShowMoreLimit(boolean z) {
        this.showMoreLimit = z;
    }

    public void setSpeedLimit(String str) {
        this.speedLimit = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SemesterTipBean{showMoreLimit=");
        stringBuilder.append(this.showMoreLimit);
        stringBuilder.append(", hasSemester=");
        stringBuilder.append(this.hasSemester);
        stringBuilder.append(", semesterGoal='");
        stringBuilder.append(this.semesterGoal);
        stringBuilder.append('\'');
        stringBuilder.append(", time='");
        stringBuilder.append(this.time);
        stringBuilder.append('\'');
        stringBuilder.append(", gradeLimit='");
        stringBuilder.append(this.gradeLimit);
        stringBuilder.append('\'');
        stringBuilder.append(", distanceLimit='");
        stringBuilder.append(this.distanceLimit);
        stringBuilder.append('\'');
        stringBuilder.append(", speedLimit='");
        stringBuilder.append(this.speedLimit);
        stringBuilder.append('\'');
        stringBuilder.append(", runValidTime=");
        stringBuilder.append(this.runValidTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.showMoreLimit);
        parcel.writeByte(this.hasSemester);
        parcel.writeString(this.semesterGoal);
        parcel.writeString(this.time);
        parcel.writeString(this.gradeLimit);
        parcel.writeString(this.distanceLimit);
        parcel.writeString(this.speedLimit);
        parcel.writeStringList(this.runValidTime);
    }
}
