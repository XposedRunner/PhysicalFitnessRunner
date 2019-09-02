package com.ximalaya.ting.android.opensdk.model.history;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayHistoryList extends XimalayaResponse {
    @SerializedName("play_histories")
    private List<PlayHistory> playHistory;
    @SerializedName("sync_at")
    private int syncAt;
    @SerializedName("uid")
    private int uid;

    public PlayHistoryList(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setSyncAt(jSONObject.optInt("sync_at"));
                setUid(jSONObject.optInt("uid"));
                JSONArray optJSONArray = jSONObject.optJSONArray("play_histories");
                if (optJSONArray != null) {
                    Gson gson = new Gson();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(new PlayHistory(optJSONArray.getJSONObject(i), gson));
                    }
                    setPlayHistory(arrayList);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<PlayHistory> getPlayHistory() {
        return this.playHistory;
    }

    public int getSyncAt() {
        return this.syncAt;
    }

    public int getUid() {
        return this.uid;
    }

    public void setPlayHistory(List<PlayHistory> list) {
        this.playHistory = list;
    }

    public void setSyncAt(int i) {
        this.syncAt = i;
    }

    public void setUid(int i) {
        this.uid = i;
    }
}
