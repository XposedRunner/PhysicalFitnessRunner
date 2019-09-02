package com.zjwh.android_wh_physicalfitness.entity.Eventbus;

import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;
import java.util.List;

public class SearchTeaClassEvent {
    private List<TeacherResModel> teacherResModels;

    public SearchTeaClassEvent(List<TeacherResModel> list) {
        this.teacherResModels = list;
    }

    public List<TeacherResModel> getTeaClassData() {
        return this.teacherResModels;
    }
}
