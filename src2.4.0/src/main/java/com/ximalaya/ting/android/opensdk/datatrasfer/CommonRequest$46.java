package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.program.Program;
import com.ximalaya.ting.android.opensdk.model.live.program.ProgramList;
import java.util.ArrayList;

class CommonRequest$46 implements CommonRequest$IRequestCallBack<ProgramList> {
    CommonRequest$46() {
    }

    public ProgramList success(String str) throws Exception {
        Program program = (Program) BaseResponse.getResponseBodyStringToObject(new TypeToken<Program>() {
        }.getType(), str);
        ProgramList programList = new ProgramList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(program);
        programList.setmProgramList(arrayList);
        return programList;
    }
}
