package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;
import java.util.List;

public class TeacherResModel implements Serializable {
    public String campusId;
    public List<ClassResModel> classResModels;
    public int mid;
    public boolean myTeacher;
    public String teacherName;

    public TeacherResModel(int i, String str, String str2, boolean z, List<ClassResModel> list) {
        this.mid = i;
        this.teacherName = str;
        this.campusId = str2;
        this.myTeacher = z;
        this.classResModels = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TeacherResModel{mid=");
        stringBuilder.append(this.mid);
        stringBuilder.append(", teacherName='");
        stringBuilder.append(this.teacherName);
        stringBuilder.append('\'');
        stringBuilder.append(", campusId='");
        stringBuilder.append(this.campusId);
        stringBuilder.append('\'');
        stringBuilder.append(", myTeacher=");
        stringBuilder.append(this.myTeacher);
        stringBuilder.append(", classResModels=");
        stringBuilder.append(this.classResModels);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
