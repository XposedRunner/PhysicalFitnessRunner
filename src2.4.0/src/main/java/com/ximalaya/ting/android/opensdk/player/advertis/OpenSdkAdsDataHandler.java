package com.ximalaya.ting.android.opensdk.player.advertis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$IRequestCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.XimalayaResponse;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.TaskWrapper;
import com.ximalaya.ting.android.opensdk.player.advertis.shopAdsEvent.XmShopEvent;
import com.ximalaya.ting.android.opensdk.player.advertis.shopAdsEvent.XmShopEvents;
import com.ximalaya.ting.android.opensdk.player.advertis.shopAdsEvent.XmShopsRecord;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.MyAsyncTask;
import com.ximalaya.ting.android.opensdk.util.NetworkType;
import defpackage.db;
import defpackage.oOOO0O0o;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OpenSdkAdsDataHandler implements IXmAdsDataHandle {
    private static final int PLAY_POSITION_END = 3;
    private static final int PLAY_POSITION_FRONT = 1;
    private static final int PLAY_POSITION_MIDDLE = 2;
    public static boolean ignoreXmAd = false;
    private static OpenSdkAdsDataHandler instance = null;
    private static String mAndroidId = null;
    private static int resumeShowTime = 600000;
    private boolean canPlayCenter = false;
    private boolean ea = true;
    private boolean isRequest = false;
    private long lastShowBrankAdTime = 0;
    private AppConfig mAppConfig;
    private TempAdvertis mTempAdvertis;
    private String playUrl;
    private List<String> prefixUrls;
    private long trackId;
    private boolean willShow;

    static class AppConfig extends XimalayaResponse {
        @SerializedName("ad_location")
        public AdLocaltion adLocaltion;
        @SerializedName("app_name")
        public String appName;
        @SerializedName("audio_url_prefix")
        public String audioUrlPrefix;
        @SerializedName("brand_ad_interval")
        public int brandAdInterval = 300;
        @SerializedName("ea")
        public boolean ea;
        @SerializedName("brand_ad_url")
        public AdUrl soundAddress;

        class AdLocaltion {
            public boolean end;
            public boolean front;
            public boolean middle;

            AdLocaltion() {
            }
        }

        class AdUrl {
            public String end;
            public String front;
            public String middle;

            AdUrl() {
            }
        }

        AppConfig() {
        }
    }

    private class TempAdvertis {
        IDataCallBack<AdvertisList> callBack;
        boolean hasUseBrandsAd;
        long trackId;

        private TempAdvertis() {
            this.hasUseBrandsAd = true;
        }

        /* synthetic */ TempAdvertis(OpenSdkAdsDataHandler openSdkAdsDataHandler, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private OpenSdkAdsDataHandler() {
    }

    public static String getAndroidId(Context context) {
        if (!TextUtils.isEmpty(mAndroidId)) {
            return mAndroidId;
        }
        if (context != null) {
            mAndroidId = Secure.getString(context.getContentResolver(), db.O000000o);
        }
        if (mAndroidId == null || mAndroidId.equalsIgnoreCase(db.O000000o) || mAndroidId.equalsIgnoreCase("9774d56d682e549c")) {
            mAndroidId = "undefined";
        }
        return mAndroidId;
    }

    public static OpenSdkAdsDataHandler getInstance() {
        if (instance == null) {
            synchronized (OpenSdkAdsDataHandler.class) {
                if (instance == null) {
                    instance = new OpenSdkAdsDataHandler();
                }
            }
        }
        return instance;
    }

    public void cancleRequestTag(String str) {
    }

    public AdvertisList checkAndAddBrankAd(AdvertisList advertisList, String str, int i) {
        boolean equals = "true".equals(str);
        if ((System.currentTimeMillis() - this.lastShowBrankAdTime > ((long) resumeShowTime) && !ignoreXmAd && this.trackId >= 0 && ((i == 1 || i == 3) && (advertisList == null || advertisList.getAdvertisList() == null || advertisList.getAdvertisList().size() == 0))) || i == 2) {
            this.lastShowBrankAdTime = System.currentTimeMillis();
            if (advertisList == null) {
                advertisList = new AdvertisList();
                advertisList.setRet(0);
            }
            Advertis advertis = new Advertis();
            advertis.setAdid(-1);
            advertis.setAdLocation(i);
            String str2 = new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwMjYvTTA5L0RDLzMxL3dLZ0pXRmpjcVhIU0xUTF9BQUFfOVR3aEFVRTIxMy5tcDM=", 0));
            if (this.mAppConfig != null) {
                if (i == 1) {
                    str2 = (this.mAppConfig.soundAddress == null || TextUtils.isEmpty(this.mAppConfig.soundAddress.front)) ? new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwNDEvTTA3LzVGLzBCL3dLZ0o4VnM1d3ptVHU1QUtBQVBkZk9jYjdMSTczOC5tcDM=", 0)) : this.mAppConfig.soundAddress.front;
                } else if (i == 2) {
                    str2 = (this.mAppConfig.soundAddress == null || TextUtils.isEmpty(this.mAppConfig.soundAddress.middle)) ? new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwMjYvTTA5L0RDLzMxL3dLZ0pXRmpjcVhIU0xUTF9BQUFfOVR3aEFVRTIxMy5tcDM=", 0)) : this.mAppConfig.soundAddress.middle;
                } else if (i == 3) {
                    str2 = (this.mAppConfig.soundAddress == null || TextUtils.isEmpty(this.mAppConfig.soundAddress.end)) ? new String(Base64.decode("aHR0cDovL2ZkZnMueG1jZG4uY29tL2dyb3VwMjYvTTA5L0RDLzMxL3dLZ0pXRmpjcVhIU0xUTF9BQUFfOVR3aEFVRTIxMy5tcDM", 0)) : this.mAppConfig.soundAddress.end;
                }
            }
            advertis.setSoundUrl(str2);
            if (advertisList.getAdvertisList() == null) {
                advertisList.setAdvertisList(new ArrayList());
            }
            advertisList.getAdvertisList().add(advertis);
        }
        if (advertisList == null) {
            advertisList = new AdvertisList();
        }
        advertisList.setDuringPlay(equals);
        if (advertisList.getAdvertisList() != null && advertisList.getAdvertisList().size() > 0) {
            Advertis advertis2 = (Advertis) advertisList.getAdvertisList().get(0);
            if (advertis2 != null) {
                List showTokens = advertis2.getShowTokens();
                if (showTokens != null && showTokens.size() > 0) {
                    advertis2.setTempToken((String) showTokens.remove(0));
                }
                advertis2.setDuringPlay(equals);
            }
        }
        return advertisList;
    }

    public AdvertisList checkAndAddBrankAd(AdvertisList advertisList, String str, String str2) {
        return checkAndAddBrankAd(advertisList, str, "4".equals(str2) ? 3 : 1);
    }

    public String getAdsData(Track track, Map<String, String> map, IDataCallBack<AdvertisList> iDataCallBack) {
        this.willShow = true;
        Logger.logToSd("OpenSdkAdsDataHandler  == 1");
        this.trackId = track.getDataId();
        if (!(map == null || XmPlayerService.getPlayerSrvice() == null)) {
            float tempo = XmPlayerService.getPlayerSrvice().getPlayControl().getTempo();
            int i = Float.compare(tempo, 0.8f) <= 0 ? 0 : Float.compare(tempo, 1.4f) >= 0 ? 2 : 1;
            Logger.logToSd("OpenSdkAdsDataHandler  == 2");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            map.put("playSpeed", stringBuilder.toString());
        }
        this.mTempAdvertis = new TempAdvertis(this, null);
        this.mTempAdvertis.trackId = this.trackId;
        this.mTempAdvertis.callBack = iDataCallBack;
        final String str = (String) map.get("playMethod");
        final long j = this.trackId;
        if (XmPlayerService.getPlayerSrvice() != null) {
            this.playUrl = XmPlayerService.getPlayerSrvice().getTrackUrl(track);
            if (TextUtils.isEmpty(this.playUrl) && this.trackId > 0) {
                this.willShow = true;
            } else if (this.playUrl == null || !this.playUrl.startsWith("http")) {
                if (this.trackId > 0) {
                    this.willShow = true;
                } else {
                    this.willShow = false;
                }
            }
        }
        if (this.willShow) {
            if (this.isRequest) {
                if (!(TextUtils.isEmpty(this.playUrl) || this.prefixUrls == null)) {
                    if (this.prefixUrls.contains(Uri.parse(this.playUrl).getHost())) {
                        this.willShow = true;
                    } else {
                        this.willShow = false;
                    }
                }
                if (!this.willShow) {
                    iDataCallBack.onSuccess(null);
                } else if (!this.ea) {
                    iDataCallBack.onSuccess(checkAndAddBrankAd(null, (String) map.get(Advertis.FIELD_DURING_PLAY), str));
                } else if ("4".equals(str)) {
                    iDataCallBack.onSuccess(checkAndAddBrankAd(null, (String) map.get(Advertis.FIELD_DURING_PLAY), str));
                    return null;
                } else {
                    final IDataCallBack<AdvertisList> iDataCallBack2 = iDataCallBack;
                    final Map<String, String> map2 = map;
                    CommonRequest.getAdvertis(map, new IDataCallBack<AdvertisList>() {
                        public void onError(int i, String str) {
                            if (OpenSdkAdsDataHandler.this.trackId == j) {
                                Logger.logToSd("OpenSdkAdsDataHandler  == 11   ");
                                iDataCallBack2.onError(i, str);
                            }
                        }

                        public void onSuccess(AdvertisList advertisList) {
                            if (OpenSdkAdsDataHandler.this.trackId == j) {
                                Logger.logToSd("OpenSdkAdsDataHandler  == 10   ");
                                if (!(advertisList == null || advertisList.getAdvertisList() == null)) {
                                    for (int i = 0; i < advertisList.getAdvertisList().size(); i++) {
                                        ((Advertis) advertisList.getAdvertisList().get(i)).setTrackId(OpenSdkAdsDataHandler.this.trackId);
                                    }
                                }
                                if (!(advertisList == null || advertisList.getAdvertisList() == null)) {
                                    OpenSdkAdsDataHandler.this.mTempAdvertis.hasUseBrandsAd = false;
                                }
                                iDataCallBack2.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(advertisList, (String) map2.get(Advertis.FIELD_DURING_PLAY), str));
                            }
                        }
                    }, oOOO0O0o.O00000Oo);
                }
            } else {
                Logger.logToSd("OpenSdkAdsDataHandler  == 3");
                final String str2 = str;
                final IDataCallBack<AdvertisList> iDataCallBack3 = iDataCallBack;
                final Map<String, String> map3 = map;
                CommonRequest.baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/app/config", null, new IDataCallBack<AppConfig>() {
                    public void onError(int i, String str) {
                        if (OpenSdkAdsDataHandler.this.trackId == j) {
                            OpenSdkAdsDataHandler.this.isRequest = true;
                            Logger.logToSd("OpenSdkAdsDataHandler  == 9   ");
                            iDataCallBack3.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(null, (String) map3.get(Advertis.FIELD_DURING_PLAY), str2));
                        }
                    }

                    public void onSuccess(AppConfig appConfig) {
                        OpenSdkAdsDataHandler.this.mAppConfig = appConfig;
                        if (OpenSdkAdsDataHandler.this.trackId == j) {
                            if (appConfig != null) {
                                if (appConfig.adLocaltion != null) {
                                    OpenSdkAdsDataHandler.this.canPlayCenter = appConfig.adLocaltion.middle;
                                    boolean z = (appConfig.adLocaltion.front || appConfig.adLocaltion.middle || appConfig.adLocaltion.end) ? false : true;
                                    OpenSdkAdsDataHandler.ignoreXmAd = z;
                                }
                                OpenSdkAdsDataHandler.this.ea = appConfig.ea;
                                if (appConfig.audioUrlPrefix != null) {
                                    OpenSdkAdsDataHandler.this.prefixUrls = Arrays.asList(appConfig.audioUrlPrefix.split(","));
                                }
                                OpenSdkAdsDataHandler.resumeShowTime = appConfig.brandAdInterval * 1000;
                                if (!TextUtils.isEmpty(OpenSdkAdsDataHandler.this.playUrl)) {
                                    if (OpenSdkAdsDataHandler.this.prefixUrls.contains(Uri.parse(OpenSdkAdsDataHandler.this.playUrl).getHost())) {
                                        OpenSdkAdsDataHandler.this.willShow = true;
                                    } else {
                                        OpenSdkAdsDataHandler.this.willShow = false;
                                    }
                                }
                                try {
                                    if (!OpenSdkAdsDataHandler.this.willShow) {
                                        iDataCallBack3.onSuccess(null);
                                    } else if (!appConfig.ea) {
                                        Logger.logToSd("OpenSdkAdsDataHandler  == 6   ");
                                        iDataCallBack3.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(null, (String) map3.get(Advertis.FIELD_DURING_PLAY), str2));
                                    } else if ("4".equals(str2)) {
                                        iDataCallBack3.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(null, (String) map3.get(Advertis.FIELD_DURING_PLAY), str2));
                                        return;
                                    } else {
                                        CommonRequest.getAdvertis(map3, new IDataCallBack<AdvertisList>() {
                                            public void onError(int i, String str) {
                                                if (OpenSdkAdsDataHandler.this.trackId == j) {
                                                    iDataCallBack3.onError(i, str);
                                                }
                                            }

                                            public void onSuccess(AdvertisList advertisList) {
                                                if (OpenSdkAdsDataHandler.this.trackId == j) {
                                                    if (!(advertisList == null || advertisList.getAdvertisList() == null)) {
                                                        for (int i = 0; i < advertisList.getAdvertisList().size(); i++) {
                                                            ((Advertis) advertisList.getAdvertisList().get(i)).setTrackId(OpenSdkAdsDataHandler.this.trackId);
                                                        }
                                                    }
                                                    if (!(advertisList == null || advertisList.getAdvertisList() == null)) {
                                                        OpenSdkAdsDataHandler.this.mTempAdvertis.hasUseBrandsAd = false;
                                                    }
                                                    iDataCallBack3.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(advertisList, (String) map3.get(Advertis.FIELD_DURING_PLAY), str2));
                                                }
                                            }
                                        }, oOOO0O0o.O00000Oo);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Logger.logToSd("OpenSdkAdsDataHandler  == 7   ");
                                    iDataCallBack3.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(null, (String) map3.get(Advertis.FIELD_DURING_PLAY), str2));
                                }
                            } else {
                                Logger.logToSd("OpenSdkAdsDataHandler  == 8   ");
                                iDataCallBack3.onSuccess(OpenSdkAdsDataHandler.this.checkAndAddBrankAd(null, (String) map3.get(Advertis.FIELD_DURING_PLAY), str2));
                            }
                            OpenSdkAdsDataHandler.this.isRequest = true;
                        }
                    }
                }, new CommonRequest$IRequestCallBack<AppConfig>() {
                    public AppConfig success(String str) throws Exception {
                        return (AppConfig) new Gson().fromJson(str, AppConfig.class);
                    }
                });
            }
            return null;
        }
        iDataCallBack.onSuccess(null);
        return null;
    }

    public void onPlayProgress(int i, int i2) {
        if ((i2 / 2) / 1000 != i / 1000) {
            return;
        }
        if (((this.mTempAdvertis != null && !this.mTempAdvertis.hasUseBrandsAd) || this.canPlayCenter) && System.currentTimeMillis() - this.lastShowBrankAdTime > ((long) resumeShowTime) && !ignoreXmAd && this.willShow) {
            if (this.mTempAdvertis != null) {
                this.mTempAdvertis.hasUseBrandsAd = true;
            }
            XmPlayerService.getPlayerSrvice().pausePlay();
            if (this.mTempAdvertis != null) {
                this.mTempAdvertis.callBack.onSuccess(checkAndAddBrankAd(null, "false", 2));
            }
        }
    }

    public void release() {
        instance.isRequest = false;
    }

    @SuppressLint({"StaticFieldLeak"})
    public void upLoadAdsLog(final TaskWrapper taskWrapper) {
        if (taskWrapper != null && taskWrapper.ads != null && taskWrapper.ads.getAdvertisList() != null && taskWrapper.ads.getAdvertisList().size() > 0 && taskWrapper.ads.getAdvertisList().get(0) != null) {
            if (((Advertis) taskWrapper.ads.getAdvertisList().get(0)).getAdid() > 0 && !TextUtils.isEmpty(((Advertis) taskWrapper.ads.getAdvertisList().get(0)).getSoundUrl()) && !"null".equals(((Advertis) taskWrapper.ads.getAdvertisList().get(0)).getSoundUrl())) {
                new MyAsyncTask<Void, Void, Void>() {
                    /* Access modifiers changed, original: protected|varargs */
                    public Void doInBackground(Void... voidArr) {
                        Advertis advertis = (Advertis) taskWrapper.ads.getAdvertisList().get(0);
                        if (XmPlayerService.getPlayerSrvice() != null) {
                            if (advertis.getShowUrls() != null) {
                                for (String thirdAdStatRequest : advertis.getShowUrls()) {
                                    AdUrlUtil.getInstance(XmPlayerService.getPlayerSrvice()).thirdAdStatRequest(thirdAdStatRequest);
                                }
                            }
                            if (advertis.getThirdShowStatUrls() != null) {
                                for (String thirdAdStatRequest2 : advertis.getThirdShowStatUrls()) {
                                    AdUrlUtil.getInstance(XmPlayerService.getPlayerSrvice()).thirdAdStatRequest(thirdAdStatRequest2);
                                }
                            }
                            AdUrlUtil.getInstance(XmPlayerService.getPlayerSrvice()).thirdAdStatRequest(advertis.getThirdStatUrl());
                        }
                        final XmAdsRecord xmAdsRecord = new XmAdsRecord();
                        xmAdsRecord.setTime(System.currentTimeMillis());
                        xmAdsRecord.setTrackId(taskWrapper.track.getDataId());
                        xmAdsRecord.setAdItemId((long) advertis.getAdid());
                        xmAdsRecord.setResponseId(taskWrapper.ads.getResponseId());
                        xmAdsRecord.setVersion(CommonRequest.getInstanse().getSdkVersion());
                        xmAdsRecord.setAndroidId(OpenSdkAdsDataHandler.getAndroidId(XmPlayerService.getPlayerSrvice()));
                        xmAdsRecord.setAdSource(advertis.getAdtype());
                        xmAdsRecord.setAppid(-2);
                        xmAdsRecord.setRecSrc(advertis.getRecSrc());
                        xmAdsRecord.setRecTrack(advertis.getRecTrack());
                        try {
                            xmAdsRecord.setAppKey(CommonRequest.getInstanse().getAppKey());
                        } catch (XimalayaException e) {
                            e.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(advertis.getTempToken())) {
                            try {
                                xmAdsRecord.setShowToken(new String(OpenSdkUtils.AesEcbNopaddingDecrypt(advertis.getTempToken())));
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        final XmAdsEvent xmAdsEvent = new XmAdsEvent();
                        xmAdsEvent.setProps(xmAdsRecord);
                        xmAdsEvent.setTs(System.currentTimeMillis());
                        new XmAdsEvents().setEvents(new ArrayList<XmAdsEvent>() {
                        });
                        CommonRequest.statOnlineAd(new ArrayList<XmAdsRecord>() {
                        }, null);
                        return null;
                    }

                    /* Access modifiers changed, original: protected */
                    public void onPostExecute(Void voidR) {
                        super.onPostExecute(voidR);
                    }
                }.myexec(new Void[0]);
            } else if (((Advertis) taskWrapper.ads.getAdvertisList().get(0)).getAdid() == -1) {
                new MyAsyncTask<Void, Void, Void>() {
                    /* Access modifiers changed, original: protected|varargs */
                    public Void doInBackground(Void... voidArr) {
                        Advertis advertis = (Advertis) taskWrapper.ads.getAdvertisList().get(0);
                        if (advertis == null) {
                            return null;
                        }
                        XmShopsRecord xmShopsRecord = new XmShopsRecord();
                        try {
                            xmShopsRecord.setAppKey(CommonRequest.getInstanse().getAppKey());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String str = "front";
                        if (advertis.getAdLocation() == 1) {
                            str = "front";
                        } else if (advertis.getAdLocation() == 2) {
                            str = "middle";
                        } else if (advertis.getAdLocation() == 3) {
                            str = "end";
                        }
                        xmShopsRecord.setAdLocation(str);
                        xmShopsRecord.setAdUrl(advertis.getSoundUrl());
                        xmShopsRecord.setSdkVersion(CommonRequest.getInstanse().getSdkVersion());
                        xmShopsRecord.setPlayTime(System.currentTimeMillis());
                        int operator = NetworkType.getOperator(CommonRequest.getInstanse().getContext());
                        String str2 = operator == 0 ? "移动" : operator == 1 ? "联通" : operator == 2 ? "电信" : "其他";
                        try {
                            xmShopsRecord.setCarrierOperator(URLEncoder.encode(str2, "UTF-8"));
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        try {
                            xmShopsRecord.setDeviceId(CommonRequest.getInstanse().getDeviceId());
                        } catch (XimalayaException e3) {
                            e3.printStackTrace();
                        }
                        xmShopsRecord.setDeviceName("android");
                        try {
                            xmShopsRecord.setDeviceType(URLEncoder.encode(Build.MODEL, "UTF-8"));
                        } catch (UnsupportedEncodingException e22) {
                            e22.printStackTrace();
                        }
                        try {
                            xmShopsRecord.setManufacture(URLEncoder.encode(CommonRequest.getInstanse().getManufacturer(), "UTF-8"));
                        } catch (UnsupportedEncodingException e222) {
                            e222.printStackTrace();
                        }
                        xmShopsRecord.setNetworkMode(NetworkType.getNetWorkType(CommonRequest.getInstanse().getContext()).getName());
                        xmShopsRecord.setOs("android");
                        final XmShopEvent xmShopEvent = new XmShopEvent();
                        xmShopEvent.setProps(xmShopsRecord);
                        xmShopEvent.setTs(System.currentTimeMillis());
                        XmShopEvents xmShopEvents = new XmShopEvents();
                        xmShopEvents.setEvents(new ArrayList<XmShopEvent>() {
                        });
                        CommonRequest.statOnlineShopAd(xmShopEvents, null);
                        return null;
                    }
                }.myexec(new Void[0]);
            }
        }
    }
}
