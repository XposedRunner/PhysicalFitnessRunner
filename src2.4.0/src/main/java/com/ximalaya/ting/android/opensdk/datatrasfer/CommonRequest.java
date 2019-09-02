package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.connect.common.Constants;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseBuilder;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.httputil.ExecutorDelivery;
import com.ximalaya.ting.android.opensdk.httputil.HttpDNSUtilForOpenSDK;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.httputil.XmSecretKeyUtil;
import com.ximalaya.ting.android.opensdk.httputil.util.BASE64Encoder;
import com.ximalaya.ting.android.opensdk.model.PostResponse;
import com.ximalaya.ting.android.opensdk.model.SercretPubKey;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.ximalaya.ting.android.opensdk.model.album.AnnouncerListByIds;
import com.ximalaya.ting.android.opensdk.model.album.BatchAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.CategoryRecommendAlbumsList;
import com.ximalaya.ting.android.opensdk.model.album.DiscoveryRecommendAlbumsList;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.HotAggregationList;
import com.ximalaya.ting.android.opensdk.model.album.RecommendCollectAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.RelativeAlbums;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.SubscribeAlbumList;
import com.ximalaya.ting.android.opensdk.model.album.UpdateBatchList;
import com.ximalaya.ting.android.opensdk.model.album.XmAlbumTracksStatue;
import com.ximalaya.ting.android.opensdk.model.announcer.AnnouncerCategoryList;
import com.ximalaya.ting.android.opensdk.model.announcer.AnnouncerList;
import com.ximalaya.ting.android.opensdk.model.app.AppModel;
import com.ximalaya.ting.android.opensdk.model.banner.BannerV2List;
import com.ximalaya.ting.android.opensdk.model.banner.BannersContentList;
import com.ximalaya.ting.android.opensdk.model.banner.CategoryBannerList;
import com.ximalaya.ting.android.opensdk.model.banner.DiscoveryBannerList;
import com.ximalaya.ting.android.opensdk.model.banner.RankBannerList;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;
import com.ximalaya.ting.android.opensdk.model.coldboot.ColdBootDetail;
import com.ximalaya.ting.android.opensdk.model.coldboot.ColdBootTag;
import com.ximalaya.ting.android.opensdk.model.coldboot.GenreList;
import com.ximalaya.ting.android.opensdk.model.coldboot.SubGenreList;
import com.ximalaya.ting.android.opensdk.model.column.ColumnDetail;
import com.ximalaya.ting.android.opensdk.model.column.ColumnList;
import com.ximalaya.ting.android.opensdk.model.customized.ColumnItems;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedAlbumColumnDetail;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedAlbumList;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedSearchList;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedTrackColumnDetail;
import com.ximalaya.ting.android.opensdk.model.customized.CustomizedTrackList;
import com.ximalaya.ting.android.opensdk.model.download.RecommendDownload;
import com.ximalaya.ting.android.opensdk.model.history.PlayHistoryList;
import com.ximalaya.ting.android.opensdk.model.live.program.ProgramList;
import com.ximalaya.ting.android.opensdk.model.live.provinces.ProvinceList;
import com.ximalaya.ting.android.opensdk.model.live.radio.CityList;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioCategoryList;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioList;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioListByCategory;
import com.ximalaya.ting.android.opensdk.model.live.radio.RadioListById;
import com.ximalaya.ting.android.opensdk.model.live.schedule.ScheduleList;
import com.ximalaya.ting.android.opensdk.model.metadata.MetaDataList;
import com.ximalaya.ting.android.opensdk.model.pay.BoughtStatuList;
import com.ximalaya.ting.android.opensdk.model.pay.ObfuscatePlayInfo;
import com.ximalaya.ting.android.opensdk.model.pay.ObfuscatePlayInfoList;
import com.ximalaya.ting.android.opensdk.model.pay.OrderDetail;
import com.ximalaya.ting.android.opensdk.model.pay.PayInfo;
import com.ximalaya.ting.android.opensdk.model.pay.PayOderStatue;
import com.ximalaya.ting.android.opensdk.model.ranks.RankAlbumList;
import com.ximalaya.ting.android.opensdk.model.ranks.RankList;
import com.ximalaya.ting.android.opensdk.model.ranks.RankTrackList;
import com.ximalaya.ting.android.opensdk.model.search.SearchAll;
import com.ximalaya.ting.android.opensdk.model.tag.TagList;
import com.ximalaya.ting.android.opensdk.model.track.AnnouncerTrackList;
import com.ximalaya.ting.android.opensdk.model.track.BatchTrackList;
import com.ximalaya.ting.android.opensdk.model.track.CommonTrackList;
import com.ximalaya.ting.android.opensdk.model.track.LastPlayTrackList;
import com.ximalaya.ting.android.opensdk.model.track.SearchTrackList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.track.TrackBaseInfo;
import com.ximalaya.ting.android.opensdk.model.track.TrackHotList;
import com.ximalaya.ting.android.opensdk.model.track.TrackIdList;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.ximalaya.ting.android.opensdk.model.user.XmBaseUserInfo;
import com.ximalaya.ting.android.opensdk.model.user.XmUserInfo;
import com.ximalaya.ting.android.opensdk.model.word.HotWordList;
import com.ximalaya.ting.android.opensdk.model.word.SuggestWords;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.player.advertis.OpenSdkUtils;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsEvent;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsEvents;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsRecord;
import com.ximalaya.ting.android.opensdk.player.advertis.shopAdsEvent.XmShopEvents;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerConfig;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.AsyncGson;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.EncryptUtilForSDK;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.NetworkType;
import com.ximalaya.ting.android.opensdk.util.PayUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class CommonRequest {
    public static final String TAG = "XiMaLaYaSDK";
    public static ExecutorDelivery delivery = new ExecutorDelivery(mHandler);
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    private static String mUserAgent = null;
    private static int sPagesize = 20;
    private static CommonRequest singleton;
    private static IRequestCallBack<TrackBaseInfo> trackInfCallBack = new 51();
    private boolean isUseHttps = false;
    private String mAppid = "";
    private String mAppkey = "";
    private String mAppsecret;
    private Config mConfig = null;
    private Context mContext = null;
    private String mDeviceid = "";
    private String mDisplay = "";
    private ITokenStateChangeWrapper mITokenStateChange;
    private String mMac = "";
    public String mManufacturer;
    private String mNetWorkType = "";
    public Set<String> mNoSupportHttps = new HashSet();
    private String mPackageName = "";
    private String mSimName = "";
    private final Set<String> noSupportHttpsInApp = new 1(this);

    private CommonRequest() {
    }

    public static void AddOrDelSubscribe(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/subscribe/add_or_delete", map, iDataCallBack, new 89());
    }

    public static Map<String, String> CommonParams(Map<String, String> map) throws XimalayaException {
        HashMap hashMap = new HashMap();
        hashMap.putAll(getInstanse().assembleCommonParams());
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("access_token", AccessTokenManager.getInstanse().getAccessToken());
        String uid = AccessTokenManager.getInstanse().getUid();
        if (!(TextUtils.isEmpty(uid) || AccessTokenManager.isThirdToken())) {
            hashMap.put(Oauth2AccessToken.KEY_UID, uid);
        }
        return hashMap;
    }

    private static void addOpenSDKAdCookie(Builder builder, StringBuilder stringBuilder) throws UnsupportedEncodingException, XimalayaException {
        CharSequence encode;
        stringBuilder.append("1&_device");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("android&");
        stringBuilder2.append(getInstanse().getDeviceId());
        stringBuilder2.append(HttpUtils.PARAMETERS_SEPARATOR);
        stringBuilder2.append(DTransferConstants.SDK_VERSION_NO_V);
        stringBuilder.append(URLEncoder.encode(stringBuilder2.toString(), HttpUtils.ENCODING_UTF_8));
        stringBuilder.append(";");
        stringBuilder.append("impl");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(URLEncoder.encode(getInstanse().getPackageName(), HttpUtils.ENCODING_UTF_8));
        stringBuilder.append(";");
        stringBuilder.append("XUM");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(URLEncoder.encode(getInstanse().getLocalMacAddress(), HttpUtils.ENCODING_UTF_8));
        stringBuilder.append(";");
        stringBuilder.append("c-oper");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(URLEncoder.encode(getInstanse().getSimName(), HttpUtils.ENCODING_UTF_8));
        stringBuilder.append(";");
        stringBuilder.append("net-mode");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(URLEncoder.encode(getInstanse().getNetWorkType(), HttpUtils.ENCODING_UTF_8));
        stringBuilder.append(";");
        stringBuilder.append("manufacture");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(URLEncoder.encode(getInstanse().getManufacturer(), HttpUtils.ENCODING_UTF_8));
        stringBuilder.append(";");
        try {
            BASE64Encoder bASE64Encoder = new BASE64Encoder();
            encode = BASE64Encoder.encode(hexStr2ByteArray(OpenSdkUtils.getAndroidId(getInstanse().getContext())));
        } catch (Exception e) {
            e.printStackTrace();
            encode = null;
        }
        if (!TextUtils.isEmpty(encode)) {
            stringBuilder.append("AID");
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(encode);
            stringBuilder.append(";");
        }
        stringBuilder.append("osversion");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(VERSION.SDK_INT);
        stringBuilder.append(";");
        String imei = OpenSdkUtils.getIMEI(getInstanse().getContext());
        if (!TextUtils.isEmpty(imei)) {
            try {
                imei = Long.toHexString(Long.valueOf(imei).longValue());
                stringBuilder.append("XIM");
                stringBuilder.append(HttpUtils.EQUAL_SIGN);
                stringBuilder.append(imei);
                stringBuilder.append(";");
            } catch (NumberFormatException unused) {
            }
        }
        stringBuilder.append("res");
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(URLEncoder.encode(getInstanse().getDisplay(), HttpUtils.ENCODING_UTF_8));
        builder.addHeader("Cookie", stringBuilder.toString());
    }

    public static <T> T baseGetReqeustSync(String str, Map<String, String> map, IRequestCallBack<T> iRequestCallBack) throws Exception {
        try {
            try {
                return iRequestCallBack != null ? iRequestCallBack.success(AccessTokenBaseCall.doSync(BaseBuilder.urlGet(replaceHttpToHttps(str), CommonParams(map), getInstanse().getAppsecret()).build(), map, getInstanse().getAppsecret(), str)) : null;
            } catch (Exception e) {
                throw e;
            } catch (XimalayaException e2) {
                throw e2;
            }
        } catch (XimalayaException e22) {
            throw e22;
        }
    }

    public static <T extends XimalayaResponse> void baseGetRequest(String str, Map<String, String> map, IDataCallBack<T> iDataCallBack, IRequestCallBack<T> iRequestCallBack) {
        try {
            AccessTokenBaseCall.doAsync(BaseBuilder.urlGet(replaceHttpToHttps(str), CommonParams(map), getInstanse().getAppsecret()).build(), new 2(iRequestCallBack, iDataCallBack), map, getInstanse().getAppsecret(), str);
        } catch (XimalayaException e) {
            iDataCallBack.onError(e.getErrorCode(), e.getMessage());
        }
    }

    public static <T> void basePostRequest(String str, Map<String, String> map, IDataCallBack<T> iDataCallBack, IRequestCallBack<T> iRequestCallBack) {
        try {
            Builder urlPost = BaseBuilder.urlPost(replaceHttpToHttps(str), CommonParams(map), getInstanse().getAppsecret());
            if (str.contains("client_place_order")) {
                urlPost.header("Accept-Encoding", "danding");
            }
            AccessTokenBaseCall.doAsync(urlPost.build(), new 3(iRequestCallBack, iDataCallBack), map, getInstanse().getAppsecret(), str);
        } catch (XimalayaException e) {
            iDataCallBack.onError(e.getErrorCode(), e.getMessage());
        }
    }

    public static <T> T basePostRequestSync(String str, Map<String, String> map, IRequestCallBack<T> iRequestCallBack) throws Exception {
        try {
            try {
                return iRequestCallBack != null ? iRequestCallBack.success(AccessTokenBaseCall.doSync(BaseBuilder.urlPost(replaceHttpToHttps(str), CommonParams(map), getInstanse().getAppsecret()).build(), map, getInstanse().getAppsecret(), str)) : null;
            } catch (Exception e) {
                throw e;
            } catch (XimalayaException e2) {
                throw e2;
            }
        } catch (XimalayaException e22) {
            throw e22;
        }
    }

    public static void batchAddSubscribe(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/subscribe/batch_add", map, iDataCallBack, new 90());
    }

    public static void batchDeleHistory(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/play_history/batch_delete", map, iDataCallBack, new 87());
    }

    public static void batchGetObfuscatedPlayInfo(Map<String, String> map, IDataCallBack<ObfuscatePlayInfoList> iDataCallBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/batch_get_obfuscated_play_info/");
        stringBuilder.append(System.currentTimeMillis());
        baseGetRequest(stringBuilder.toString(), map, iDataCallBack, new 13());
    }

    public static void batchGetPaidAlbum(Map<String, String> map, IDataCallBack<BatchAlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/batch_get_paid_albums", map, iDataCallBack, new 95());
    }

    public static void batchPaidTracks(Map<String, String> map, IDataCallBack<BatchTrackList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/batch_get_paid_tracks", map, iDataCallBack, new 96());
    }

    public static void batchUploadHistory(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/play_history/batch_upload", map, iDataCallBack, new 86());
    }

    public static void clientCancelOrder(Map<String, String> map, IDataCallBack<PayOderStatue> iDataCallBack) {
        map.put("confirm_type", "2");
        basePostRequest("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/confirm_order", map, iDataCallBack, new 112());
    }

    public static void destroy() {
        release();
    }

    public static void getAdvertis(Map<String, String> map, IDataCallBack<AdvertisList> iDataCallBack, int i) {
        try {
            map.put("appid", "-2");
            map.put("version", DTransferConstants.SDK_VERSION_NO_V);
            map.put("device", "android");
            Object uid = AccessTokenManager.getInstanse().getUid();
            if (TextUtils.isEmpty(uid)) {
                uid = "-1";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("");
            map.put("xt", stringBuilder.toString());
            map.put(Oauth2AccessToken.KEY_UID, uid);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(OpenSdkUtils.getOperator(getInstanse().getContext()));
            stringBuilder2.append("");
            map.put("operator", stringBuilder2.toString());
            map.put("network", getInstanse().getNetWorkType());
            map.put("deviceId", getInstanse().getDeviceId());
            map.put(WBConstants.SSO_APP_KEY, getInstanse().getAppKey());
            if (XmPlayerService.getPlayerSrvice() != null) {
                int i2;
                PlayMode playMode = XmPlayerService.getPlayerSrvice().getPlayMode();
                if (playMode != PlayMode.PLAY_MODEL_LIST) {
                    if (playMode == PlayMode.PLAY_MODEL_SINGLE_LOOP) {
                        i2 = 1;
                    } else if (playMode == PlayMode.PLAY_MODEL_RANDOM) {
                        i2 = 2;
                    } else if (playMode == PlayMode.PLAY_MODEL_LIST_LOOP) {
                        i2 = 3;
                    } else if (playMode == PlayMode.PLAY_MODEL_SINGLE) {
                        i2 = 4;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i2);
                    stringBuilder.append("");
                    map.put("playMode", stringBuilder.toString());
                }
                i2 = 0;
                stringBuilder = new StringBuilder();
                stringBuilder.append(i2);
                stringBuilder.append("");
                map.put("playMode", stringBuilder.toString());
            }
            Builder urlGet = BaseBuilder.urlGet(replaceHttpToHttps("http://adse.ximalaya.com/soundPatch"), map);
            urlGet.addHeader("User-Agent", getUserAgent());
            try {
                addOpenSDKAdCookie(urlGet, new StringBuilder());
                BaseCall.getInstanse().doAsync(urlGet.build(), new 56(iDataCallBack), i);
            } catch (UnsupportedEncodingException e) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("UnsupportedEncodingException :");
                stringBuilder3.append(e.getMessage());
                iDataCallBack.onError(1008, stringBuilder3.toString());
            } catch (XimalayaException e2) {
                iDataCallBack.onError(e2.getErrorCode(), e2.getErrorMessage());
            } catch (Exception e3) {
                iDataCallBack.onError(0, e3.getMessage());
            }
        } catch (XimalayaException e22) {
            iDataCallBack.onError(e22.getErrorCode(), e22.getMessage());
        } catch (Exception e32) {
            iDataCallBack.onError(0, e32.getMessage());
        }
    }

    public static void getAlbumByUid(Map<String, String> map, IDataCallBack<SubscribeAlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/subscribe/get_albums_by_uid", map, iDataCallBack, new 88());
    }

    public static void getAlbumList(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/albums/list", map, iDataCallBack, new 19());
    }

    @Deprecated
    public static void getAlbums(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        map.put("calc_dimension", "1");
        getAlbumList(map, iDataCallBack);
    }

    public static void getAlbumsByAnnouncer(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/announcers/albums", map, iDataCallBack, new 15());
    }

    public static void getAllPaidAlbums(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/all_paid_albums", map, iDataCallBack, new 91());
    }

    public static void getAllTrackIdsInAlbum(Map<String, String> map, IDataCallBack<TrackIdList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/get_all_track_ids", map, iDataCallBack, new 23());
    }

    public static void getAnnouncerCategoryList(Map<String, String> map, IDataCallBack<AnnouncerCategoryList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/announcers/categories", map, iDataCallBack, new 54());
    }

    public static void getAnnouncerList(Map<String, String> map, IDataCallBack<AnnouncerList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/announcers/list", map, iDataCallBack, new 55());
    }

    public static void getAnnouncersBatch(Map<String, String> map, IDataCallBack<AnnouncerListByIds> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/announcers/get_batch", map, iDataCallBack, new 39());
    }

    private Context getAplication() throws XimalayaException {
        if (this.mContext != null) {
            return this.mContext.getApplicationContext();
        }
        throw XimalayaException.getExceptionByCode(1004);
    }

    public static void getAppModel(Map<String, String> map, IDataCallBack<AppModel> iDataCallBack) {
        try {
            BaseCall.getInstanse().doAsync(BaseBuilder.urlGet(replaceHttpToHttps("http://api.ximalaya.com/version/get_latest_version"), map).build(), new 50(iDataCallBack));
        } catch (XimalayaException e) {
            iDataCallBack.onError(e.getErrorCode(), e.getMessage());
        }
    }

    public static void getBannersContentList(Map<String, String> map, IDataCallBack<BannersContentList> iDataCallBack) {
        String str = "";
        if (map.containsKey("banner_content_type")) {
            str = (String) map.get("banner_content_type");
            if (!(str.equalsIgnoreCase(Constants.VIA_SHARE_TYPE_INFO) || str.equalsIgnoreCase("7"))) {
                iDataCallBack.onError(0, "please add param banner_content_type 6 or 7");
            }
        } else {
            iDataCallBack.onError(0, "please add param banner_content_type");
        }
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/banners/get_content_list", map, iDataCallBack, new 49(str));
    }

    public static void getBaseUserInfo(Map<String, String> map, IDataCallBack<XmBaseUserInfo> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/profile/user_info", map, iDataCallBack, new 109());
    }

    public static void getBatch(Map<String, String> map, IDataCallBack<BatchAlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/get_batch", map, iDataCallBack, new 16());
    }

    public static void getBatchTracks(Map<String, String> map, IDataCallBack<BatchTrackList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/tracks/get_batch", map, iDataCallBack, new 17());
    }

    public static void getBoughtAlbumStatus(Map<String, String> map, IDataCallBack<BoughtStatuList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/album_bought_status", map, iDataCallBack, new 101());
    }

    public static void getBoughtAlbums(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/get_bought_albums", map, iDataCallBack, new 100());
    }

    public static void getBoughtTrackStatus(Map<String, String> map, IDataCallBack<BoughtStatuList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/track_bought_status", map, iDataCallBack, new 102());
    }

    public static void getCategories(Map<String, String> map, IDataCallBack<CategoryList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/categories/list", map, iDataCallBack, new 4());
    }

    @Deprecated
    public static void getCategoryBannerList(Map<String, String> map, IDataCallBack<CategoryBannerList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/banners/category_banners", map, iDataCallBack, new 27());
    }

    public static void getCategoryBannersV2(Map<String, String> map, IDataCallBack<BannerV2List> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/banners/category_banners", map, iDataCallBack, new 114());
    }

    public static void getCategoryRecommendAlbums(Map<String, String> map, IDataCallBack<CategoryRecommendAlbumsList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/category_recommend_albums", map, iDataCallBack, new 72());
    }

    public static void getCitys(Map<String, String> map, IDataCallBack<CityList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/cities", map, iDataCallBack, new 82());
    }

    public static void getColdBootDetail(Map<String, String> map, IDataCallBack<ColdBootDetail> iDataCallBack) {
        try {
            map.put("device_id", getInstanse().getDeviceId());
            map.put("device_type", "2");
            baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/coldboot/detail", map, iDataCallBack, new 65());
        } catch (XimalayaException e) {
            iDataCallBack.onError(e.getErrorCode(), e.getMessage());
        }
    }

    public static void getColdBootTag(Map<String, String> map, IDataCallBack<ColdBootTag> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/coldboot/tags", map, iDataCallBack, new 63());
    }

    public static void getColdbootGenres(Map<String, String> map, IDataCallBack<GenreList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/coldboot/genres", map, iDataCallBack, new 61());
    }

    public static void getColdbootSubGenres(Map<String, String> map, IDataCallBack<SubGenreList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/coldboot/sub_genres", map, iDataCallBack, new 62());
    }

    public static void getColumnList(Map<String, String> map, IDataCallBack<ColumnList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/column/quality_list", map, iDataCallBack, new 30());
    }

    public static void getComlumnDetail(Map<String, String> map, IDataCallBack<ColumnDetail> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/column/detail", map, iDataCallBack, new 31());
    }

    public static void getCustomizeTrackList(Map<String, String> map, IDataCallBack<TrackList> iDataCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", UrlConstants.TRACKLIST);
        hashMap.putAll(map);
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/customized/tracks", map, iDataCallBack, new 21(hashMap));
    }

    public static void getCustomizedAlbumColumDetail(Map<String, String> map, IDataCallBack<CustomizedAlbumColumnDetail> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/customized/album_column_detail", map, iDataCallBack, new 80());
    }

    public static void getCustomizedAlbumColumns(Map<String, String> map, IDataCallBack<CustomizedAlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/customized/album_columns", map, iDataCallBack, new 78());
    }

    public static void getCustomizedCategories(Map<String, String> map, IDataCallBack<CategoryList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/customized/categories", map, iDataCallBack, new 5());
    }

    public static void getCustomizedTrackColumDetail(Map<String, String> map, IDataCallBack<CustomizedTrackColumnDetail> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/customized/track_column_detail", map, iDataCallBack, new 81());
    }

    public static void getCustomizedTrackColumns(Map<String, String> map, IDataCallBack<CustomizedTrackList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/customized/track_columns", map, iDataCallBack, new 79());
    }

    public static void getCustomizedTrackDetail(Map<String, String> map, IDataCallBack<ColumnItems> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/customized/track_detail", map, iDataCallBack, new 106());
    }

    public static void getDiscoveryBannerList(Map<String, String> map, IDataCallBack<DiscoveryBannerList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/banners/discovery_banners", map, iDataCallBack, new 26());
    }

    public static void getDiscoveryRecommendAlbums(Map<String, String> map, IDataCallBack<DiscoveryRecommendAlbumsList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/discovery_recommend_albums", map, iDataCallBack, new 71());
    }

    public static void getGuessLikeAlbum(Map<String, String> map, IDataCallBack<GussLikeAlbumList> iDataCallBack) {
        map.put("device_type", "2");
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/albums/guess_like", map, iDataCallBack, new 29());
    }

    public static Handler getHandler() {
        return mHandler;
    }

    public static void getHotAggregationList(Map<String, String> map, IDataCallBack<HotAggregationList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/albums/hot_aggregation", map, iDataCallBack, new 40());
    }

    public static void getHotTracks(Map<String, String> map, IDataCallBack<TrackHotList> iDataCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", UrlConstants.TRACKHOTLIST);
        hashMap.putAll(map);
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/tracks/hot", map, iDataCallBack, new 18(hashMap));
    }

    public static void getHotWords(Map<String, String> map, IDataCallBack<HotWordList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/hot_words", map, iDataCallBack, new 24());
    }

    public static CommonRequest getInstanse() {
        if (singleton == null) {
            synchronized (CommonRequest.class) {
                if (singleton == null) {
                    singleton = new CommonRequest();
                }
            }
        }
        return singleton;
    }

    public static void getLastPlayTracks(Map<String, String> map, IDataCallBack<LastPlayTrackList> iDataCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", UrlConstants.TRACKLIST);
        hashMap.putAll(map);
        hashMap.remove("pid");
        hashMap.remove("track_id");
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/tracks/get_last_play_tracks", map, iDataCallBack, new 20(hashMap));
    }

    public static void getMetadataAlbumList(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/metadata/albums", map, iDataCallBack, new 74());
    }

    public static void getMetadataList(Map<String, String> map, IDataCallBack<MetaDataList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/metadata/list", map, iDataCallBack, new 73());
    }

    public static void getObfuscatedPlayInfo(Map<String, String> map, IDataCallBack<ObfuscatePlayInfo> iDataCallBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_obfuscated_play_info/");
        stringBuilder.append(System.currentTimeMillis());
        baseGetRequest(stringBuilder.toString(), map, iDataCallBack, new 11());
    }

    public static ObfuscatePlayInfo getObfuscatedPlayInfoSync(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_obfuscated_play_info/");
        stringBuilder.append(System.currentTimeMillis());
        try {
            return (ObfuscatePlayInfo) baseGetReqeustSync(stringBuilder.toString(), map, new 12());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getOrderDetail(Map<String, String> map, IDataCallBack<OrderDetail> iDataCallBack) {
        basePostRequest("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_order_detail", map, iDataCallBack, new 113());
    }

    public static void getPaidAlbumByTag(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/paid_albums_by_tag", map, iDataCallBack, new 93());
    }

    public static void getPaidRank(Map<String, String> map, IDataCallBack<RankList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/paid_content_ranks", map, iDataCallBack, new 97());
    }

    public static void getPaidRankAlbumList(Map<String, String> map, IDataCallBack<RankAlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/rank_albums", map, iDataCallBack, new 98());
    }

    public static void getPaidTags(Map<String, String> map, IDataCallBack<TagList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/tags", map, iDataCallBack, new 92());
    }

    public static void getPaidTrackByAlbum(Map<String, String> map, IDataCallBack<TrackList> iDataCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", "http://api.ximalaya.com/openapi-gateway-app/open_pay/browse_paid_album_tracks");
        hashMap.putAll(map);
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/browse_paid_album_tracks", map, iDataCallBack, new 94(hashMap));
    }

    public static void getPlayHistoryByUid(Map<String, String> map, IDataCallBack<PlayHistoryList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/play_history/get_by_uid", map, iDataCallBack, new 84());
    }

    public static void getPriceInfo(Map<String, String> map, IDataCallBack<PayInfo> iDataCallBack) {
        baseGetRequest("https://mpay.ximalaya.com/openapi-payfacade-app/open_pay/get_price_info", map, iDataCallBack, new 105());
    }

    public static void getProgram(Map<String, String> map, IDataCallBack<ProgramList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/get_playing_program", map, iDataCallBack, new 46());
    }

    public static void getProvinces(Map<String, String> map, IDataCallBack<ProvinceList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/provinces", map, iDataCallBack, new 42());
    }

    public static void getRadioCategory(Map<String, String> map, IDataCallBack<RadioCategoryList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/radio_categories", map, iDataCallBack, new 75());
    }

    public static void getRadios(Map<String, String> map, IDataCallBack<RadioList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/radios", map, iDataCallBack, new 44());
    }

    public static void getRadiosByCategory(Map<String, String> map, IDataCallBack<RadioListByCategory> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/get_radios_by_category", map, iDataCallBack, new 76());
    }

    public static void getRadiosByCity(Map<String, String> map, IDataCallBack<RadioList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/get_radios_by_city", map, iDataCallBack, new 43());
    }

    public static void getRadiosByIds(Map<String, String> map, IDataCallBack<RadioListById> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/get_radios_by_ids", map, iDataCallBack, new 48());
    }

    public static void getRankAlbumList(Map<String, String> map, IDataCallBack<RankAlbumList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/ranks/albums", map, iDataCallBack, new 33());
    }

    public static void getRankAlbums(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/rank_albums", map, iDataCallBack, new 99());
    }

    public static void getRankBannerList(Map<String, String> map, IDataCallBack<RankBannerList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/banners/rank_banners", map, iDataCallBack, new 28());
    }

    public static void getRankList(Map<String, String> map, IDataCallBack<RankList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/ranks/index_list", map, iDataCallBack, new 32());
    }

    public static void getRankRadios(Map<String, String> map, IDataCallBack<RadioList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/ranks/radios", map, iDataCallBack, new 35());
    }

    public static void getRankTrackList(Map<String, String> map, IDataCallBack<RankTrackList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/ranks/tracks", map, iDataCallBack, new 34());
    }

    public static void getRecommendCollect(Map<String, String> map, IDataCallBack<RecommendCollectAlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/recommend_collect", map, iDataCallBack, new 47());
    }

    public static void getRecommendDownloadList(Map<String, String> map, IDataCallBack<RecommendDownload> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/recommend_download", map, iDataCallBack, new 41());
    }

    public static void getRelativeAlbums(Map<String, String> map, IDataCallBack<RelativeAlbums> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/albums/relative_album", map, iDataCallBack, new 37());
    }

    public static void getRelativeAlbumsUseTrackId(Map<String, String> map, IDataCallBack<RelativeAlbums> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/tracks/relative_album", map, iDataCallBack, new 36());
    }

    public static void getSchedules(Map<String, String> map, IDataCallBack<ScheduleList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/live/schedules", map, iDataCallBack, new 45());
    }

    public static void getSearchAll(Map<String, String> map, IDataCallBack<SearchAll> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/all", map, iDataCallBack, new 9());
    }

    public static void getSearchAnnouncers(Map<String, String> map, IDataCallBack<AnnouncerList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/announcers", map, iDataCallBack, new 14());
    }

    public static void getSearchedAlbums(Map<String, String> map, IDataCallBack<SearchAlbumList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/albums", map, iDataCallBack, new 7());
    }

    public static void getSearchedRadios(Map<String, String> map, IDataCallBack<RadioList> iDataCallBack) {
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/radios", map, iDataCallBack, new 10());
    }

    public static void getSearchedTracks(Map<String, String> map, IDataCallBack<SearchTrackList> iDataCallBack) {
        getInstanse().setPageSize(map);
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", UrlConstants.SEARCHTRACKLIST);
        hashMap.putAll(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/tracks", map, iDataCallBack, new 8(hashMap));
    }

    public static void getSuggestWord(Map<String, String> map, IDataCallBack<SuggestWords> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/search/suggest_words", map, iDataCallBack, new 25());
    }

    public static void getTags(Map<String, String> map, IDataCallBack<TagList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/v2/tags/list", map, iDataCallBack, new 38());
    }

    public static void getTrackInfo(Map<String, String> map, IDataCallBack<TrackBaseInfo> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info", map, iDataCallBack, trackInfCallBack);
    }

    public static TrackBaseInfo getTrackInfoSync(Map<String, String> map) {
        try {
            return (TrackBaseInfo) baseGetReqeustSync("http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info", map, trackInfCallBack);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void getTrackList(Map<String, String> map, IDataCallBack<CommonTrackList> iDataCallBack) {
        if (!CommonRequestForMain.invokeFuncWithCommonRequestM(map, iDataCallBack, "getTrackListM")) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            String str = (String) hashMap.remove("track_base_url");
            hashMap.remove("total_page");
            hashMap.remove("pre_page");
            baseGetRequest(str, hashMap, iDataCallBack, new 70());
        }
    }

    public static void getTrackStatuesByAlbumId(Map<String, String> map, IDataCallBack<XmAlbumTracksStatue> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/get_all_track_ids", map, iDataCallBack, new 111());
    }

    public static void getTracks(Map<String, String> map, IDataCallBack<TrackList> iDataCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", UrlConstants.TRACKLIST);
        hashMap.putAll(map);
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/browse", map, iDataCallBack, new 22(hashMap));
    }

    public static void getTracksByAnnouncer(Map<String, String> map, IDataCallBack<AnnouncerTrackList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/announcers/tracks", map, iDataCallBack, new 77(map));
    }

    @Deprecated
    public static void getUpToDateAlbums(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        getAlbumList(map, iDataCallBack);
    }

    public static void getUpdateBatch(Map<String, String> map, IDataCallBack<UpdateBatchList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/albums/get_update_batch", map, iDataCallBack, new 6());
    }

    public static String getUserAgent() {
        if (BaseUtil.isMainApp()) {
            return CommonRequestForMain.getUseragent();
        }
        if (TextUtils.isEmpty(mUserAgent)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ting_");
            stringBuilder.append(getInstanse().getSdkVersion());
            stringBuilder.append("(");
            try {
                stringBuilder.append(URLEncoder.encode(Build.MODEL, "utf-8"));
            } catch (UnsupportedEncodingException unused) {
            }
            stringBuilder.append(",");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Android");
            stringBuilder2.append(VERSION.SDK_INT);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(")");
            mUserAgent = stringBuilder.toString();
        }
        return mUserAgent;
    }

    public static void getUserInfo(Map<String, String> map, IDataCallBack<XmUserInfo> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/profile/persona", map, iDataCallBack, new 110());
    }

    public static byte[] hexStr2ByteArray(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            bArr[i] = (byte) ((((byte) (Character.digit(str.charAt(i2), 16) & 255)) << 4) | ((byte) (Character.digit(str.charAt(i2 + 1), 16) & 255)));
            i2 += 2;
            i++;
        }
        return bArr;
    }

    public static void postColdBootTag(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        map.put("device_type", "2");
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/coldboot/submit_tags", map, iDataCallBack, new 64());
    }

    public static void postLiveBatchsRecords(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-collector-app/live_batch_records", map, iDataCallBack, new 68());
    }

    public static void postLiveSingleRecord(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-collector-app/live_single_record", map, iDataCallBack, new 66());
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    public static void postString(java.lang.String r2, com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack r3) {
        /*
        r0 = "http://xdcs-collector.ximalaya.com/api/v1/adRealTime";
        r2 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlPost(r0, r2);	 Catch:{ XimalayaException -> 0x0017, UnsupportedEncodingException -> 0x0013 }
        r0 = new java.lang.StringBuilder;	 Catch:{ XimalayaException -> 0x0017, UnsupportedEncodingException -> 0x0013 }
        r0.<init>();	 Catch:{ XimalayaException -> 0x0017, UnsupportedEncodingException -> 0x0013 }
        addOpenSDKAdCookie(r2, r0);	 Catch:{ XimalayaException -> 0x0017, UnsupportedEncodingException -> 0x0013 }
        r2 = r2.build();	 Catch:{ XimalayaException -> 0x0017, UnsupportedEncodingException -> 0x0013 }
        goto L_0x0018;
    L_0x0013:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x0017:
        r2 = 0;
    L_0x0018:
        if (r2 == 0) goto L_0x0026;
    L_0x001a:
        r0 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getInstanse();
        r1 = new com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$59;
        r1.<init>(r3);
        r0.doAsync(r2, r1);
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.postString(java.lang.String, com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack):void");
    }

    public static void postStringOld(String str, IDataCallBack iDataCallBack) {
        Request build;
        try {
            build = BaseBuilder.urlPost("http://xdcs-collector.ximalaya.com/api/v1/realtime", str).build();
        } catch (XimalayaException unused) {
            build = null;
        }
        if (build != null) {
            BaseCall.getInstanse().doAsync(build, new 60(iDataCallBack));
        }
    }

    public static void postTrackBatchsRecords(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-collector-app/track_batch_records", map, iDataCallBack, new 69());
    }

    public static void postTrackSingleRecord(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-collector-app/track_single_record", map, iDataCallBack, new 67());
    }

    public static void release() {
        if (!BaseUtil.isMainApp()) {
            EncryptUtilForSDK.release();
        }
    }

    /* JADX WARNING: Missing block: B:27:0x0070, code skipped:
            return r2;
     */
    public static java.lang.String replaceHttpToHttps(java.lang.String r2) {
        /*
        if (r2 == 0) goto L_0x0070;
    L_0x0002:
        r0 = "https";
        r0 = r2.startsWith(r0);
        if (r0 != 0) goto L_0x0070;
    L_0x000a:
        r0 = "http";
        r0 = r2.startsWith(r0);
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0070;
    L_0x0013:
        r0 = com.ximalaya.ting.android.opensdk.util.BaseUtil.isMainApp();
        if (r0 != 0) goto L_0x006f;
    L_0x0019:
        r0 = getInstanse();
        r0 = r0.getUseHttps();
        if (r0 == 0) goto L_0x006f;
    L_0x0023:
        r0 = getInstanse();
        r0 = r0.noSupportHttpsInApp;
        r0 = r0.iterator();
    L_0x002d:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0040;
    L_0x0033:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r1 = r2.contains(r1);
        if (r1 == 0) goto L_0x002d;
    L_0x003f:
        return r2;
    L_0x0040:
        r0 = getInstanse();
        r0 = r0.mNoSupportHttps;
        if (r0 != 0) goto L_0x0049;
    L_0x0048:
        return r2;
    L_0x0049:
        r0 = getInstanse();
        r0 = r0.mNoSupportHttps;
        r0 = r0.iterator();
    L_0x0053:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0066;
    L_0x0059:
        r1 = r0.next();
        r1 = (java.lang.String) r1;
        r1 = r2.contains(r1);
        if (r1 == 0) goto L_0x0053;
    L_0x0065:
        return r2;
    L_0x0066:
        r0 = "http";
        r1 = "https";
        r2 = r2.replace(r0, r1);
        return r2;
    L_0x006f:
        return r2;
    L_0x0070:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.replaceHttpToHttps(java.lang.String):java.lang.String");
    }

    public static void searchCustomizedTrackOrAlbum(Map<String, String> map, IDataCallBack<CustomizedSearchList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/customized/search_albums_or_track_columns", map, iDataCallBack, new 107());
    }

    public static void searchPaidAlbums(Map<String, String> map, IDataCallBack<AlbumList> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/search_paid_albums", map, iDataCallBack, new 103());
    }

    public static void searchPaidTracks(Map<String, String> map, IDataCallBack<TrackList> iDataCallBack) {
        HashMap hashMap = new HashMap();
        hashMap.put("track_base_url", "http://api.ximalaya.com/openapi-gateway-app/open_pay/search_paid_tracks");
        hashMap.putAll(map);
        getInstanse().setPageSize(map);
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/open_pay/search_paid_tracks", map, iDataCallBack, new 104(hashMap));
    }

    public static void searchTracks(Map<String, String> map, IDataCallBack<CustomizedTrackColumnDetail> iDataCallBack) {
        baseGetRequest("http://api.ximalaya.com/openapi-gateway-app/customized/search_tracks", map, iDataCallBack, new 83());
    }

    public static void simpleLogin(Map<String, String> map, IDataCallBack<String> iDataCallBack) {
        Builder urlPost;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        map.put("timestamp", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        map.put("nonce", stringBuilder.toString());
        map.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "token");
        try {
            map.put("client_id", getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        try {
            urlPost = BaseBuilder.urlPost(replaceHttpToHttps("http://api.ximalaya.com/oauth2/authorize"), CommonParams(map), getInstanse().getAppsecret());
        } catch (XimalayaException e2) {
            e2.printStackTrace();
            urlPost = null;
        }
        new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build().newCall(urlPost.build()).enqueue(new 108(iDataCallBack));
    }

    public static String simpleLoginSync(Map<String, String> map) throws IOException {
        Builder urlPost;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        map.put("timestamp", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        map.put("nonce", stringBuilder.toString());
        map.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "token");
        try {
            map.put("client_id", getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        try {
            urlPost = BaseBuilder.urlPost(replaceHttpToHttps("http://api.ximalaya.com/oauth2/authorize"), CommonParams(map), getInstanse().getAppsecret());
        } catch (XimalayaException e2) {
            e2.printStackTrace();
            urlPost = null;
        }
        Response execute = new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build().newCall(urlPost.build()).execute();
        return execute.code() == SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH ? execute.headers().get("Location") : "";
    }

    public static void statOnlineAd(List<XmAdsRecord> list, IDataCallBack iDataCallBack) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (XmAdsRecord xmAdsRecord : list) {
                XmAdsEvent xmAdsEvent = new XmAdsEvent();
                xmAdsEvent.setType("AD");
                xmAdsEvent.setProps(xmAdsRecord);
                xmAdsEvent.setTs(System.currentTimeMillis());
                arrayList.add(xmAdsEvent);
            }
            Object xmAdsEvents = new XmAdsEvents();
            xmAdsEvents.setEvents(arrayList);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new AsyncGson().toJsonResultOnThread(xmAdsEvents, new 57(iDataCallBack));
            } else {
                try {
                    String toJson = new Gson().toJson(xmAdsEvents);
                    if (!TextUtils.isEmpty(toJson)) {
                        postString(toJson, iDataCallBack);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void statOnlineShopAd(XmShopEvents xmShopEvents, IDataCallBack iDataCallBack) {
        if (xmShopEvents != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new AsyncGson().toJsonResultOnThread(xmShopEvents, new 58(iDataCallBack));
            } else {
                try {
                    String toJson = new Gson().toJson((Object) xmShopEvents);
                    if (!TextUtils.isEmpty(toJson)) {
                        postStringOld(toJson, iDataCallBack);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String subUrlCore(String str) {
        return str.substring(str.indexOf(HttpUtils.PATHS_SEPARATOR, "http://".length()), str.length());
    }

    public static void updateSecret(Map<String, String> map, IDataCallBack<SercretPubKey> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange", map, iDataCallBack, new 52());
    }

    public static SercretPubKey updateSecretSync(Map<String, String> map) {
        try {
            return (SercretPubKey) basePostRequestSync("http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange", map, new 53());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void updateTrackForPlay(Map<String, String> map, IDataCallBack<String> iDataCallBack, Track track) {
        if (BaseUtil.isMainApp()) {
            CommonRequestForMain.updateTrackForPlay(map, iDataCallBack, track);
        } else {
            PayUtil.updateTrackInfo(map, iDataCallBack, track);
        }
    }

    public static void uploadHistory(Map<String, String> map, IDataCallBack<PostResponse> iDataCallBack) {
        basePostRequest("http://api.ximalaya.com/openapi-gateway-app/play_history/upload", map, iDataCallBack, new 85());
    }

    public Map<String, String> assembleCommonParams() throws XimalayaException {
        HashMap hashMap = new HashMap();
        hashMap.put("app_key", getInstanse().getAppKey());
        hashMap.put("device_id", getDeviceId());
        hashMap.put("pack_id", getInstanse().getPackId());
        hashMap.put("sdk_version", getInstanse().getSdkVersion());
        hashMap.put("client_os_type", String.valueOf(getInstanse().getClientOsType()));
        return hashMap;
    }

    public String getAppKey() throws XimalayaException {
        if (TextUtils.isEmpty(this.mAppkey)) {
            try {
                this.mAppkey = getAplication().getPackageManager().getApplicationInfo(getAplication().getPackageName(), 128).metaData.getString("app_key");
            } catch (XimalayaException e) {
                throw e;
            } catch (Exception e2) {
                Logger.e(e2);
                throw XimalayaException.getExceptionByCode(1005);
            }
        }
        if (!TextUtils.isEmpty(this.mAppkey)) {
            return this.mAppkey;
        }
        throw XimalayaException.getExceptionByCode(1005);
    }

    public String getAppsecret() {
        return this.mAppsecret;
    }

    public int getClientOsType() {
        return 2;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getDefaultPagesize() {
        return sPagesize;
    }

    public String getDeviceId() throws XimalayaException {
        if (TextUtils.isEmpty(this.mDeviceid)) {
            this.mDeviceid = Secure.getString(getAplication().getContentResolver(), "android_id");
        }
        if (TextUtils.isEmpty(this.mDeviceid)) {
            this.mDeviceid = UUID.randomUUID().toString();
        }
        return this.mDeviceid;
    }

    public String getDisplay() {
        return this.mDisplay;
    }

    public Config getHttpConfig() {
        return this.mConfig;
    }

    public ITokenStateChange getITokenStateChange() {
        return this.mITokenStateChange;
    }

    @SuppressLint({"WifiManagerLeak"})
    public String getLocalMacAddress() throws XimalayaException {
        if (TextUtils.isEmpty(this.mMac)) {
            this.mMac = ((WifiManager) getAplication().getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (!TextUtils.isEmpty(this.mMac)) {
            return this.mMac;
        }
        throw new XimalayaException(1006, "get mac address error");
    }

    public String getManufacturer() {
        if (!TextUtils.isEmpty(this.mManufacturer)) {
            return this.mManufacturer;
        }
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                this.mManufacturer = URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception unused) {
        }
        return this.mManufacturer;
    }

    public String getNetWorkType() {
        this.mNetWorkType = NetworkType.getNetWorkType(this.mContext).getName();
        return this.mNetWorkType;
    }

    public String getPackId() throws XimalayaException {
        if (this.mAppid.equals("")) {
            try {
                this.mAppid = getAplication().getPackageManager().getApplicationInfo(getAplication().getPackageName(), 128).metaData.getString("pack_id");
            } catch (NameNotFoundException unused) {
                throw new XimalayaException(SecExceptionCode.SEC_ERROR_SIGNATRUE, "get packid error");
            }
        }
        return this.mAppid;
    }

    public String getPackageName() {
        if (this.mPackageName.equals("")) {
            this.mPackageName = this.mContext.getPackageName();
        }
        return this.mPackageName;
    }

    public String getSdkVersion() {
        return DTransferConstants.SDK_VERSION_VALUE;
    }

    public String getSimName() {
        if (TextUtils.isEmpty(this.mSimName)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
                if (telephonyManager.getSimState() == 5) {
                    this.mSimName = telephonyManager.getSimOperatorName();
                } else {
                    this.mSimName = "未知";
                }
            } catch (Exception unused) {
            }
        }
        return this.mSimName;
    }

    public boolean getUseHttps() {
        return this.isUseHttps;
    }

    public void init(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mAppsecret = str;
        AccessTokenManager instanse = AccessTokenManager.getInstanse();
        instanse.setITokenStateChange(this.mITokenStateChange);
        instanse.init(context);
        if (XmPlayerConfig.getInstance(context).isUsePreventHijack()) {
            BaseCall.getInstanse().addInterceptor(HttpDNSUtilForOpenSDK.getHttpDNSInterceptor());
        }
        EncryptUtilForSDK.getInstance().init(this.mContext);
        XmSecretKeyUtil.getInstance().init(this.mContext);
    }

    public void onlySetHttpConfig(Config config) {
        this.mConfig = config;
    }

    public DataErrorCategory parseResponseHandler(BaseResponse baseResponse) {
        try {
            return (DataErrorCategory) new Gson().fromJson(baseResponse.getResponseBodyToString(), DataErrorCategory.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setAppkey(String str) {
        this.mAppkey = str;
    }

    public void setDebugLevel(int i) {
        Logger.setDebugLevel(i);
    }

    public void setDefaultPagesize(int i) {
        if (sPagesize != i) {
            sPagesize = i;
            XmPlayerManager.getInstance(this.mContext).setAutoLoadPageSizeInner(i);
        }
    }

    public void setHttpConfig(Config config) {
        this.mConfig = config;
        BaseCall.getInstanse().setHttpConfig(this.mConfig);
        if (this.mContext != null) {
            String curProcessName = BaseUtil.getCurProcessName(this.mContext);
            if (!TextUtils.isEmpty(curProcessName) && !curProcessName.contains(":player")) {
                XmPlayerManager.getInstance(this.mContext).setHttpConfig(this.mConfig);
            }
        }
    }

    public void setITokenStateChange(ITokenStateChange iTokenStateChange) {
        if (iTokenStateChange != null) {
            this.mITokenStateChange = new ITokenStateChangeWrapper(iTokenStateChange);
            if (BaseUtil.isMainProcess(this.mContext)) {
                XmPlayerManager.getInstance(this.mContext).setTokenInvalidForSDK(this.mITokenStateChange);
                return;
            }
            return;
        }
        this.mITokenStateChange = null;
    }

    public void setPackid(String str) {
        this.mAppid = str;
    }

    public void setPageSize(Map<String, String> map) {
        if (!map.containsKey("count")) {
            map.put("count", String.valueOf(getDefaultPagesize()));
        }
    }

    public void setUseHttps(boolean z) {
        this.isUseHttps = z;
    }
}
