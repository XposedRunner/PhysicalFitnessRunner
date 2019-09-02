package com.ximalaya.ting.android.opensdk.model.word;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class HotWordList extends XimalayaResponse {
    private List<HotWord> hotWordList;

    public List<HotWord> getHotWordList() {
        return this.hotWordList;
    }

    public void setHotWordList(List<HotWord> list) {
        this.hotWordList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HotWordList [hotWordList=");
        stringBuilder.append(this.hotWordList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
