package com.ximalaya.ting.android.opensdk.model.pay;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class ObfuscatePlayInfoList extends XimalayaResponse {
    private List<ObfuscatePlayInfo> mObfuscatePlayInfos;

    public List<ObfuscatePlayInfo> getObfuscatePlayInfos() {
        return this.mObfuscatePlayInfos;
    }

    public void setObfuscatePlayInfos(List<ObfuscatePlayInfo> list) {
        this.mObfuscatePlayInfos = list;
    }
}
