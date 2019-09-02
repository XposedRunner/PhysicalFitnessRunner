package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.provinces.Province;
import com.ximalaya.ting.android.opensdk.model.live.provinces.ProvinceList;
import java.util.List;

class CommonRequest$42 implements CommonRequest$IRequestCallBack<ProvinceList> {
    CommonRequest$42() {
    }

    public ProvinceList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<Province>>() {
        }.getType(), str);
        ProvinceList provinceList = new ProvinceList();
        provinceList.setProvinceList(list);
        return provinceList;
    }
}
