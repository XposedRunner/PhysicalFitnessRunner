package com.ximalaya.ting.android.opensdk.model.banner;

import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import java.util.List;

public class DiscoveryBannerList extends XimalayaResponse {
    private List<Banner> bannerList;

    public List<Banner> getBannerList() {
        return this.bannerList;
    }

    public void setBannerList(List<Banner> list) {
        this.bannerList = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BannerList [bannerList=");
        stringBuilder.append(this.bannerList);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
