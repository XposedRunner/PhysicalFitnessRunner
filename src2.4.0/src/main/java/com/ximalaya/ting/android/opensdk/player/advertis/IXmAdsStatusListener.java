package com.ximalaya.ting.android.opensdk.player.advertis;

import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;

public interface IXmAdsStatusListener {
    void onAdsStartBuffering();

    void onAdsStopBuffering();

    void onCompletePlayAds();

    void onError(int i, int i2);

    void onGetAdsInfo(AdvertisList advertisList);

    void onStartGetAdsInfo();

    void onStartPlayAds(Advertis advertis, int i);
}
