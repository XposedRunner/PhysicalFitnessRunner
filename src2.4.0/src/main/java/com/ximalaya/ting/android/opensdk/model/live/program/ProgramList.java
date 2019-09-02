package com.ximalaya.ting.android.opensdk.model.live.program;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class ProgramList extends XimalayaResponse {
    private List<Program> mProgramList;

    public List<Program> getmProgramList() {
        return this.mProgramList;
    }

    public void setmProgramList(List<Program> list) {
        this.mProgramList = list;
    }
}
