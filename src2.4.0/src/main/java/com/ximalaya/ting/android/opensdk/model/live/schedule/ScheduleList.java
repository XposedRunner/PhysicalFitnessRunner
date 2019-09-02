package com.ximalaya.ting.android.opensdk.model.live.schedule;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class ScheduleList extends XimalayaResponse {
    private List<Schedule> mScheduleList;

    public List<Schedule> getmScheduleList() {
        return this.mScheduleList;
    }

    public void setmScheduleList(List<Schedule> list) {
        this.mScheduleList = list;
    }
}
