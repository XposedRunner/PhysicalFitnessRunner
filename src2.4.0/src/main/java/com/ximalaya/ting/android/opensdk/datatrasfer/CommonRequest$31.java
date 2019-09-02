package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.column.ColumnDetail;
import com.ximalaya.ting.android.opensdk.model.column.ColumnDetailAlbum;
import com.ximalaya.ting.android.opensdk.model.column.ColumnDetailTrack;
import org.json.JSONException;
import org.json.JSONObject;

class CommonRequest$31 implements CommonRequest$IRequestCallBack<ColumnDetail> {
    CommonRequest$31() {
    }

    public ColumnDetail success(String str) throws Exception {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Gson gson = new Gson();
            if (jSONObject.optInt("column_content_type", 0) == 1) {
                return (ColumnDetailAlbum) gson.fromJson(str, new TypeToken<ColumnDetailAlbum>() {
                }.getType());
            }
            if (jSONObject.optInt("column_content_type", 0) == 2) {
                return (ColumnDetailTrack) gson.fromJson(str, new TypeToken<ColumnDetailTrack>() {
                }.getType());
            }
            throw new XimalayaException(XimalayaException.PARSE_JSON_ERROR, "parse response json data error");
        } catch (JSONException e) {
            throw e;
        }
    }
}
