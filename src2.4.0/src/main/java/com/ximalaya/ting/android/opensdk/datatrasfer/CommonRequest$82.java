package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.model.live.radio.City;
import com.ximalaya.ting.android.opensdk.model.live.radio.CityList;
import java.util.List;

class CommonRequest$82 implements CommonRequest$IRequestCallBack<CityList> {
    CommonRequest$82() {
    }

    public CityList success(String str) throws Exception {
        List list = (List) BaseResponse.getResponseBodyStringToObject(new TypeToken<List<City>>() {
        }.getType(), str);
        CityList cityList = new CityList();
        cityList.setCities(list);
        return cityList;
    }
}
