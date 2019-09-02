package com.ximalaya.ting.android.opensdk.model.banner;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class BannerV2List extends XimalayaResponse {
    private List<BannerV2> mBannerV2s;

    public List<BannerV2> getBannerV2s() {
        return this.mBannerV2s;
    }

    public void setBannerV2s(List<BannerV2> list) {
        this.mBannerV2s = list;
    }
}
