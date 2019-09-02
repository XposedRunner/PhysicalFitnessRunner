package com.zjwh.android_wh_physicalfitness.entity;

import java.io.Serializable;
import java.util.List;

public class TeaClassResModel implements Serializable {
    public String semesterName;
    public List<TeacherResModel> teacherResModels;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TeaClassResModel{semesterName='");
        stringBuilder.append(this.semesterName);
        stringBuilder.append('\'');
        stringBuilder.append(", teaClassResModels=");
        stringBuilder.append(this.teacherResModels);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
