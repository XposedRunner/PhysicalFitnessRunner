package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.live.schedule.ScheduleList;
import java.util.List;

class CommonRequest$45 implements CommonRequest$IRequestCallBack<ScheduleList> {
    CommonRequest$45() {
    }

    public ScheduleList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Schedule>>() {
        }.getType(), str);
        ScheduleList scheduleList = new ScheduleList();
        scheduleList.setmScheduleList(list);
        return scheduleList;
    }
}
