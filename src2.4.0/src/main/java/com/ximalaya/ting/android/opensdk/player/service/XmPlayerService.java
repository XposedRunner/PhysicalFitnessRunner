package com.ximalaya.ting.android.opensdk.player.service;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.constants.PreferenceConstantsInOpenSdk;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$ITokenStateChange;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequestForMain;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.httputil.HttpDNSUtilForOpenSDK;
import com.ximalaya.ting.android.opensdk.httputil.HttpUrlUtil;
import com.ximalaya.ting.android.opensdk.httputil.IDataSupportCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XmSecretKeyUtil;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.AlbumList;
import com.ximalaya.ting.android.opensdk.model.album.SearchAlbumList;
import com.ximalaya.ting.android.opensdk.model.category.Category;
import com.ximalaya.ting.android.opensdk.model.category.CategoryList;
import com.ximalaya.ting.android.opensdk.model.category.CategoryModel;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.model.track.LastPlayTrackList;
import com.ximalaya.ting.android.opensdk.model.track.SearchTrackList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.track.TrackBaseInfo;
import com.ximalaya.ting.android.opensdk.model.track.TrackHotList;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.opensdk.model.xdcs.StatToServerFactoryImplForOpen;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManagerForPlayer;
import com.ximalaya.ting.android.opensdk.player.advertis.IXmAdsStatusListener;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.IPlayStartCallBack;
import com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.PlayAdsCallback;
import com.ximalaya.ting.android.opensdk.player.appnotification.NotificationColorUtils;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import com.ximalaya.ting.android.opensdk.player.appwidget.WidgetProvider;
import com.ximalaya.ting.android.opensdk.player.mediacontrol.MediaControlManager;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayer.Stub;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl.IPlaySeekListener;
import com.ximalaya.ting.android.opensdk.player.statistic.XmStatisticsManager;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.ModelUtil;
import com.ximalaya.ting.android.opensdk.util.PayUtil;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.ximalaya.ting.android.player.DownloadThread;
import com.ximalaya.ting.android.player.IDomainServerIpCallback;
import com.ximalaya.ting.android.player.PlayerUtil;
import com.ximalaya.ting.android.player.StaticConfig;
import com.ximalaya.ting.android.player.XMediaPlayer.OnPlayDataOutputListener;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.ximalaya.ting.android.player.cdn.CdnConstants;
import com.ximalaya.ting.android.player.cdn.CdnUtil;
import com.ximalaya.ting.android.player.xdcs.IStatToServerFactory;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import s.h.e.l.l.C;

public class XmPlayerService extends Service {
    private static final int CODEERR = 404;
    private static final int CODE_ALBUM_INFO = 101;
    private static final int CODE_ATTENTION_ALBUM = 107;
    private static final int CODE_COLLECT_ALBUM = 100;
    public static final int CODE_DATA_CHANGE_LOGIN_INOROUT = 116;
    public static final int CODE_GET_ALBUMS_BY_CATEGORY_ID_AND_TAG = 129;
    public static final int CODE_GET_CATEGORIES_LIST = 128;
    public static final int CODE_GET_NEW_ALBUM_RANK = 132;
    public static final int CODE_GET_NEW_TRACK_RANK = 133;
    public static final int CODE_GET_PARSE_DEVICE_INFO = 117;
    public static final int CODE_GET_PROVINCES = 125;
    public static final int CODE_GET_RADIO_LIST = 126;
    public static final int CODE_GET_RADIO_SCHEDULES = 127;
    public static final int CODE_GET_RECOMMEND_ALBUMLIST_BY_ALBUMID = 123;
    public static final int CODE_GET_RECOMMEND_ALBUMLIST_BY_TRACKID = 124;
    public static final int CODE_GET_SPECIALLISTEN = 119;
    public static final int CODE_GET_SUBJECTDETAIL = 120;
    public static final int CODE_GET_SUGGEST_ALBUMS = 118;
    public static final int CODE_GET_TAGS_BY_CATEGORY_ID = 130;
    public static final int CODE_GET_TRACKLIST_BYTRACKIDATALBUM = 122;
    public static final int CODE_GET_TRACK_DETAIL_INFO = 131;
    public static final int CODE_HOT_ALBUM = 115;
    public static final int CODE_HOT_TRACK = 105;
    private static final int CODE_RANK_ALBUM = 103;
    private static final int CODE_RANK_ANCHOR = 104;
    private static final int CODE_RANK_TRACK = 102;
    public static final int CODE_SUBSCRIBE_ALBUM = 121;
    private static final int CODE_USER_INFO = 106;
    private static final String COMMREQUSTM_METHOD_NAME = "getStringByUrlForOpenSDK";
    private static final int COMPLETE_OFFSET = 1000;
    public static final int LOCAL_RADIO = 0;
    public static final int NATIONAL_RADIO = 1;
    public static final int NET_RADIO = 3;
    private static final String OPENSDK_GETALBUMDATA = "openSDK_getAlbumData";
    private static final String OPENSDK_GETATTENTIONALBUMLIST = "openSDK_getAttentionAlbumList";
    public static final String OPENSDK_GETHOTTRACK = "openSDK_recommentTrack";
    public static final String OPENSDK_GETRANKALBUMLIST = "openSDK_getRankAlbumList";
    public static final String OPENSDK_GETRANKANCHORLIST = "openSDK_getRankAnchorList";
    private static final String OPENSDK_GETSUBSCRIBEALBUMLIST = "openSDK_getSubscribtAlbumList";
    public static final String OPENSDK_GETUSERINFO = "openSDK_getUserInfo";
    public static final String OPENSDK_GET_ALBUMS_BY_CATEGORY_ID_AND_TAG = "opensdk_get_albums_by_category_id_and_tag";
    public static final String OPENSDK_GET_CATEGORIES_LIST = "opensdk_get_categories_list";
    public static final String OPENSDK_GET_HOT_ALBUM = "openSDK_recommentAlbum";
    public static final String OPENSDK_GET_NEW_RANK_ALBUM = "openSDK_getNewRankAlbum";
    public static final String OPENSDK_GET_NEW_RANK_TRACK = "openSDK_getNewRankTrack";
    public static final String OPENSDK_GET_PARSE_DEVICE_INFO = "opensdk_get_parse_device_info";
    public static final String OPENSDK_GET_PROVINCES = "opensdk_get_provinces";
    public static final String OPENSDK_GET_RADIO_LIST = "opensdk_get_radio_list";
    public static final String OPENSDK_GET_RADIO_SCHEDULES = "opensdk_get_radio_schedules";
    public static final String OPENSDK_GET_RANK_TRACK = "openSDK_getRankList";
    public static final String OPENSDK_GET_RECOMMEND_ALBUMLIST_BY_ALBUMID = "opensdk_get_recommend_albumlist_by_albumid";
    public static final String OPENSDK_GET_RECOMMEND_ALBUMLIST_BY_TRACKID = "opensdk_get_recommend_albumlist_by_trackid";
    public static final String OPENSDK_GET_SPECIALLISTEN = "opensdk_get_speciallisten";
    public static final String OPENSDK_GET_SUBJECTDETAIL = "opensdk_get_subjectdetail";
    public static final String OPENSDK_GET_SUGGEST_ALBUMS = "opensdk_get_suggest_albums";
    public static final String OPENSDK_GET_TAGS_BY_CATEGORY_ID = "opensdk_get_tags_by_category_id";
    public static final String OPENSDK_GET_TRACKLIST_BYTRACKIDATALBUM = "opensdk_get_tracklist_bytrackidatalbum";
    public static final String OPENSDK_GET_TRACK_INFO = "openSDK_getTrackInfoDetail";
    public static final String OPENSDK_SUBSCRIBE_ALBUM = "opensdk_subscribe_album";
    public static final int PLAN_NORMAL = 0;
    public static final int PLAN_PAUSE_ON_COMPLETE = -1;
    public static final int PROVINCE_RADIO = 2;
    private static final String TAG = "XmPlayerService";
    public static final int TYPE_HOT_ALBUM = 2;
    public static final int TYPE_HOT_TRACK = 1;
    public static final String TYPE_RANK_ALBUM = "album";
    public static final String TYPE_RANK_ANCHOR = "anchor";
    public static final String TYPE_RANK_TRACK = "track";
    private static Service mService;
    private int c = 0;
    private boolean hasInitNotification = false;
    private boolean isContinuePlay = false;
    private boolean isDLNAState = false;
    public boolean isLossAudioFocus = false;
    private RemoteCallbackList<IXmAdsEventDispatcher> mAdsDispatcher = new MyRemoteCallbackList();
    private IXmAdsStatusListener mAdsListener = new IXmAdsStatusListener() {
        private byte[] mLock = new byte[0];

        public void onAdsStartBuffering() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onAdsStartBuffering XmPlayerService 672:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i)).onAdsStartBuffering();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public void onAdsStopBuffering() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onAdsStopBuffering XmPlayerService 654:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i)).onAdsStopBuffering();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public void onCompletePlayAds() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onCompletePlayAds XmPlayerService 636:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i)).onCompletePlayAds();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public void onError(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onError XmPlayerService 618:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i3 = 0; i3 < beginBroadcast; i3++) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i3)).onError(i, i2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public void onGetAdsInfo(AdvertisList advertisList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onGetAdsInfo XmPlayerService 598:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                XmPlayerService.this.startCheckIsPauseTime();
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i)).onGetAdsInfo(advertisList);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public void onStartGetAdsInfo() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onStartGetAdsInfo XmPlayerService 580:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i)).onStartGetAdsInfo();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }

        public void onStartPlayAds(Advertis advertis, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mAdsListener onStartPlayAds XmPlayerService 556:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (this.mLock) {
                int i2 = 0;
                if (XmPlayerService.this.mWillPause) {
                    XmPlayerService.this.mWillPause = false;
                    XmPlayerService.this.pausePlay();
                    return;
                }
                int beginBroadcast = XmPlayerService.this.mAdsDispatcher.beginBroadcast();
                while (i2 < beginBroadcast) {
                    try {
                        ((IXmAdsEventDispatcher) XmPlayerService.this.mAdsDispatcher.getBroadcastItem(i2)).onStartPlayAds(advertis, i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    i2++;
                }
                XmPlayerService.this.mAdsDispatcher.finishBroadcast();
            }
        }
    };
    private XmAdsManager mAdsManager;
    private Context mAppCtx;
    private String mAppSecret;
    private Runnable mCheckIsPauseTimeRunnable;
    public Config mConfig;
    private RemoteCallbackList<IXmCustomDataCallBack> mCustomDataCallBack = new MyRemoteCallbackList();
    private IDomainServerIpCallback mIDomainServerIpCallback;
    private IStatToServerFactory mIStatToServerFactory;
    private IXmCommonBusinessDispatcher mIXmCommonBusinessDispatcher;
    private int mLastDuration;
    private PlayableModel mLastModel;
    protected XmPlayListControl mListControl;
    private RemoteCallbackList<IXmMainDataSupportDataCallback> mMainDataSupportCallbackList = new MyRemoteCallbackList();
    private long mMaxSaveTime = -813934592;
    private MediaControlManager mMediaControlManager;
    private Notification mNotification;
    private int mNotificationId;
    private NotificationManager mNotificationManager;
    private OnPlayDataOutputListener mOnPlayDataOutputListener;
    private long mPauseTimeInMills = 0;
    private SharedPreferences mPlayHistory;
    private SharedPreferences mPlayLastPlayTrackInAlbum;
    private IPlaySeekListener mPlaySeekListener = new IPlaySeekListener() {
        public void onSeekComplete(int i) {
            if (XmPlayerService.this.mStatisticsManager != null) {
                XmPlayerService.this.mStatisticsManager.onSeekComplete(i);
            }
        }
    };
    private IPlayStartCallBack mPlayStartCallBack;
    private XmPlayerAudioFocusControl mPlayerAudioFocusControl;
    private XmPlayerConfig mPlayerConfig;
    private XmPlayerControl mPlayerControl;
    private RemoteCallbackList<IXmPlayerEventDispatcher> mPlayerDispatcher = new MyRemoteCallbackList();
    private XmPlayerImpl mPlayerImpl;
    private IXmPlayerStatusListener mPlayerStatusListener = new IXmPlayerStatusListener() {
        private void saveDownloadedSize() {
            Editor edit = XmPlayerService.this.getApplicationContext().getSharedPreferences("downloadedSize", SharedPreferencesUtil.SHARE_MODEL).edit();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(DownloadThread.downloadedSize);
            edit.putString("downloadedSize", stringBuilder.toString());
            edit.apply();
        }

        public void onBufferProgress(int i) {
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i2)).onBufferProgress(i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
                XmPlayerService.this.mStatisticsManager.stuckStatistics(i, XmPlayerService.this.mPlayerControl.getDuration(), XmPlayerService.this.mPlayerControl.getCurrentPos());
            }
        }

        public void onBufferingStart() {
            XmPlayerService.this.startCheckIsPauseTime();
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onBufferingStart();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
        }

        public void onBufferingStop() {
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onBufferingStop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
        }

        public boolean onError(XmPlayerException xmPlayerException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onError XmPlayerService 475:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (XmPlayerService.class) {
                XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateViewStateAtPause(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx));
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onError(xmPlayerException);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            return false;
        }

        public void onPlayPause() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPlayPause XmPlayerService 393:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onPlayPause();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("xmplayerservice onPlayPause");
            stringBuilder.append(new Date());
            Logger.logToSd(stringBuilder.toString());
            XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateViewStateAtPause(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx));
            XmPlayerService.this.sendPlayerPauseBroadCast();
            XmPlayerService.this.mMediaControlManager.pausePlay();
        }

        /* JADX WARNING: Missing block: B:42:0x00eb, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:44:0x00ed, code skipped:
            return;
     */
        public void onPlayProgress(int r8, int r9) {
            /*
            r7 = this;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "onPlayProgress XmPlayerService 336:";
            r0.append(r1);
            r1 = java.lang.System.currentTimeMillis();
            r0.append(r1);
            r0 = r0.toString();
            com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r0);
            r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.class;
            monitor-enter(r0);
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r1 = r1.mListControl;	 Catch:{ all -> 0x00ee }
            r1 = r1.getCurrentPlayableModel();	 Catch:{ all -> 0x00ee }
            r2 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r2 = r2.mPlayerControl;	 Catch:{ all -> 0x00ee }
            r2 = r2.getRealPlayableModelInPlayer();	 Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00ec;
        L_0x002f:
            if (r2 != 0) goto L_0x0033;
        L_0x0031:
            goto L_0x00ec;
        L_0x0033:
            r3 = r1.equals(r2);	 Catch:{ all -> 0x00ee }
            if (r3 == 0) goto L_0x0098;
        L_0x0039:
            r3 = r1;
            r3 = (com.ximalaya.ting.android.opensdk.model.track.Track) r3;	 Catch:{ all -> 0x00ee }
            r4 = 0;
            if (r8 <= 0) goto L_0x0056;
        L_0x003f:
            r5 = r9 + -1000;
            if (r8 >= r5) goto L_0x0056;
        L_0x0043:
            r3.setLastPlayedMills(r8);	 Catch:{ all -> 0x00ee }
            r3 = r3.needSaveHistory();	 Catch:{ all -> 0x00ee }
            if (r3 == 0) goto L_0x006c;
        L_0x004c:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r5 = r1.getDataId();	 Catch:{ all -> 0x00ee }
            r3.saveSoundHistoryPos(r5, r8);	 Catch:{ all -> 0x00ee }
            goto L_0x006c;
        L_0x0056:
            r5 = r9 + -1000;
            if (r8 < r5) goto L_0x006c;
        L_0x005a:
            r3.setLastPlayedMills(r4);	 Catch:{ all -> 0x00ee }
            r3 = r3.needSaveHistory();	 Catch:{ all -> 0x00ee }
            if (r3 == 0) goto L_0x006c;
        L_0x0063:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r5 = r1.getDataId();	 Catch:{ all -> 0x00ee }
            r3.saveSoundHistoryPos(r5, r4);	 Catch:{ all -> 0x00ee }
        L_0x006c:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3 = r3.mPlayerDispatcher;	 Catch:{ all -> 0x00ee }
            r3 = r3.beginBroadcast();	 Catch:{ all -> 0x00ee }
        L_0x0076:
            if (r4 >= r3) goto L_0x008f;
        L_0x0078:
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r5 = r5.mPlayerDispatcher;	 Catch:{ all -> 0x00ee }
            r5 = r5.getBroadcastItem(r4);	 Catch:{ all -> 0x00ee }
            r5 = (com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher) r5;	 Catch:{ all -> 0x00ee }
            r5.onPlayProgress(r8, r9);	 Catch:{ Exception -> 0x0088 }
            goto L_0x008c;
        L_0x0088:
            r5 = move-exception;
            r5.printStackTrace();	 Catch:{ all -> 0x00ee }
        L_0x008c:
            r4 = r4 + 1;
            goto L_0x0076;
        L_0x008f:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3 = r3.mPlayerDispatcher;	 Catch:{ all -> 0x00ee }
            r3.finishBroadcast();	 Catch:{ all -> 0x00ee }
        L_0x0098:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3 = r3.mStatisticsManager;	 Catch:{ all -> 0x00ee }
            r3.checkIsSeek(r8, r9);	 Catch:{ all -> 0x00ee }
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3 = r3.mPlayerControl;	 Catch:{ all -> 0x00ee }
            if (r3 == 0) goto L_0x00bc;
        L_0x00a9:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3 = r3.mStatisticsManager;	 Catch:{ all -> 0x00ee }
            r4 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r4 = r4.mPlayerControl;	 Catch:{ all -> 0x00ee }
            r4 = r4.isPlayingRadio();	 Catch:{ all -> 0x00ee }
            r3.onPlayProgress(r8, r9, r4);	 Catch:{ all -> 0x00ee }
        L_0x00bc:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3.checkIsPauseTime();	 Catch:{ all -> 0x00ee }
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r3 = r3.mAdsManager;	 Catch:{ all -> 0x00ee }
            if (r3 == 0) goto L_0x00ea;
        L_0x00c9:
            r3 = "track";
            r1 = r1.getKind();	 Catch:{ all -> 0x00ee }
            r1 = r3.equals(r1);	 Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00ea;
        L_0x00d5:
            r1 = "track";
            r2 = r2.getKind();	 Catch:{ all -> 0x00ee }
            r1 = r1.equals(r2);	 Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00ea;
        L_0x00e1:
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x00ee }
            r1 = r1.mAdsManager;	 Catch:{ all -> 0x00ee }
            r1.onPlayProgress(r8, r9);	 Catch:{ all -> 0x00ee }
        L_0x00ea:
            monitor-exit(r0);	 Catch:{ all -> 0x00ee }
            return;
        L_0x00ec:
            monitor-exit(r0);	 Catch:{ all -> 0x00ee }
            return;
        L_0x00ee:
            r8 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x00ee }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$AnonymousClass1.onPlayProgress(int, int):void");
        }

        public void onPlayStart() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPlayStart XmPlayerService 294:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            if (XmPlayerService.this.mPlayStartCallBack == null || !XmPlayerService.this.mPlayStartCallBack.onPlayStart()) {
                int i = 0;
                if (XmPlayerService.this.mWillPause) {
                    XmPlayerService.this.mWillPause = false;
                    XmPlayerService.this.pausePlay();
                    return;
                }
                XmPlayerService.this.removeCheckIsPauseTime();
                synchronized (XmPlayerService.class) {
                    int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                    while (i < beginBroadcast) {
                        try {
                            ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onPlayStart();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                    XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
                }
                XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateViewStateAtStart(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx));
                XmPlayerService.this.sendPlayerStartBroadCast();
                Track track = (Track) XmPlayerService.this.mListControl.getCurrentPlayableModel();
                i = XmPlayerService.this.mPlayerControl.getCurrentPos();
                XmPlayerService.this.mStatisticsManager.onPlayTrack(track, XmPlayerService.this.mPlayerControl.isOnlineSource(), i, XmPlayerService.this.getCurPlayUrl());
                XmPlayerService.this.mStatisticsManager.onPlayStart(i, XmPlayerService.this.mPlayerControl.isPlayingRadio());
                XmPlayerService.this.mMediaControlManager.startPlay();
                XmPlayerService.this.saveLastPlayTrackInAlbum(track);
                if (XmPlayerService.this.mAdsManager != null) {
                    XmPlayerService.this.mAdsManager.onlyStopPlayer();
                }
            }
        }

        public void onPlayStop() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPlayStop XmPlayerService 271:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onPlayStop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            XmPlayerService.this.mStatisticsManager.onStopTrack((Track) XmPlayerService.this.mListControl.getCurrentPlayableModel(), XmPlayerService.this.mPlayerControl.getCurrentPos());
            XmPlayerService.this.mStatisticsManager.onPlayStop();
            XmPlayerService.this.mMediaControlManager.stopPlay();
        }

        /* JADX WARNING: Missing block: B:24:0x00bf, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:42:0x0136, code skipped:
            return;
     */
        public void onSoundPlayComplete() {
            /*
            r10 = this;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "onSoundPlayComplete XmPlayerService 417:";
            r0.append(r1);
            r1 = java.lang.System.currentTimeMillis();
            r0.append(r1);
            r0 = r0.toString();
            com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r0);
            r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.class;
            monitor-enter(r0);
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r1 = r1.mPauseTimeInMills;	 Catch:{ all -> 0x0137 }
            r3 = -1;
            r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
            r1 = 1;
            r2 = 0;
            if (r5 != 0) goto L_0x0032;
        L_0x0029:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r4 = 0;
            r3.mPauseTimeInMills = r4;	 Catch:{ all -> 0x0137 }
            r3 = r2;
            goto L_0x0033;
        L_0x0032:
            r3 = r1;
        L_0x0033:
            r4 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r4 = r4.mListControl;	 Catch:{ all -> 0x0137 }
            r4 = r4.getNextIndex(r2);	 Catch:{ all -> 0x0137 }
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r5 = r5.mPlayerDispatcher;	 Catch:{ all -> 0x0137 }
            r5 = r5.beginBroadcast();	 Catch:{ all -> 0x0137 }
            r6 = r2;
        L_0x0046:
            if (r6 >= r5) goto L_0x005f;
        L_0x0048:
            r7 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r7 = r7.mPlayerDispatcher;	 Catch:{ all -> 0x0137 }
            r7 = r7.getBroadcastItem(r6);	 Catch:{ all -> 0x0137 }
            r7 = (com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher) r7;	 Catch:{ all -> 0x0137 }
            r7.onSoundPlayComplete();	 Catch:{ Exception -> 0x0058 }
            goto L_0x005c;
        L_0x0058:
            r7 = move-exception;
            r7.printStackTrace();	 Catch:{ all -> 0x0137 }
        L_0x005c:
            r6 = r6 + 1;
            goto L_0x0046;
        L_0x005f:
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r5 = r5.mPlayerDispatcher;	 Catch:{ all -> 0x0137 }
            r5.finishBroadcast();	 Catch:{ all -> 0x0137 }
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r5 = r5.mAppCtx;	 Catch:{ all -> 0x0137 }
            r5 = com.ximalaya.ting.android.opensdk.player.appnotification.NotificationColorUtils.isDarkNotificationBar(r5);	 Catch:{ all -> 0x0137 }
            r6 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r6 = r6.mAppCtx;	 Catch:{ all -> 0x0137 }
            r6 = com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater.getInstanse(r6);	 Catch:{ all -> 0x0137 }
            r7 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r7 = r7.mNotificationManager;	 Catch:{ all -> 0x0137 }
            r8 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r8 = r8.mNotification;	 Catch:{ all -> 0x0137 }
            r9 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r9 = r9.mNotificationId;	 Catch:{ all -> 0x0137 }
            r6.updateViewStateAtPause(r7, r8, r9, r5);	 Catch:{ all -> 0x0137 }
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r5.sendPlayCompleteBroadCast();	 Catch:{ all -> 0x0137 }
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r5 = r5.mLastModel;	 Catch:{ all -> 0x0137 }
            r5 = (com.ximalaya.ting.android.opensdk.model.track.Track) r5;	 Catch:{ all -> 0x0137 }
            if (r5 == 0) goto L_0x00c0;
        L_0x00a0:
            r6 = r5.isAudition();	 Catch:{ all -> 0x0137 }
            if (r6 == 0) goto L_0x00c0;
        L_0x00a6:
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r1 = r1.mPlayerStatusListener;	 Catch:{ all -> 0x0137 }
            if (r1 == 0) goto L_0x00be;
        L_0x00ae:
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r1 = r1.mPlayerStatusListener;	 Catch:{ all -> 0x0137 }
            r2 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r2 = r2.mLastModel;	 Catch:{ all -> 0x0137 }
            r3 = 0;
            r1.onSoundSwitch(r2, r3);	 Catch:{ all -> 0x0137 }
        L_0x00be:
            monitor-exit(r0);	 Catch:{ all -> 0x0137 }
            return;
        L_0x00c0:
            if (r4 < 0) goto L_0x00cc;
        L_0x00c2:
            r5 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r5 = r5.mListControl;	 Catch:{ all -> 0x0137 }
            r5 = r5.getPlayableModel(r4);	 Catch:{ all -> 0x0137 }
            r5 = (com.ximalaya.ting.android.opensdk.model.track.Track) r5;	 Catch:{ all -> 0x0137 }
        L_0x00cc:
            r6 = new com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$1$1;	 Catch:{ all -> 0x0137 }
            r6.<init>(r4, r3);	 Catch:{ all -> 0x0137 }
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r3 = r3.isDLNAState;	 Catch:{ all -> 0x0137 }
            if (r3 != 0) goto L_0x0111;
        L_0x00d9:
            if (r5 == 0) goto L_0x0111;
        L_0x00db:
            r3 = com.ximalaya.ting.android.opensdk.util.BaseUtil.isMainApp();	 Catch:{ all -> 0x0137 }
            if (r3 != 0) goto L_0x00ed;
        L_0x00e1:
            r3 = "schedule";
            r4 = r5.getKind();	 Catch:{ all -> 0x0137 }
            r3 = r3.equals(r4);	 Catch:{ all -> 0x0137 }
            if (r3 != 0) goto L_0x0111;
        L_0x00ed:
            r3 = "radio";
            r4 = r5.getKind();	 Catch:{ all -> 0x0137 }
            r3 = r3.equals(r4);	 Catch:{ all -> 0x0137 }
            if (r3 != 0) goto L_0x0111;
        L_0x00f9:
            r3 = "live_flv";
            r4 = r5.getKind();	 Catch:{ all -> 0x0137 }
            r3 = r3.equals(r4);	 Catch:{ all -> 0x0137 }
            if (r3 == 0) goto L_0x0106;
        L_0x0105:
            goto L_0x0111;
        L_0x0106:
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r1 = r1.mAdsManager;	 Catch:{ all -> 0x0137 }
            r3 = 4;
            r1.playAds(r5, r3, r6, r2);	 Catch:{ all -> 0x0137 }
            goto L_0x0135;
        L_0x0111:
            r2 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;	 Catch:{ all -> 0x0137 }
            r2 = r2.mAdsManager;	 Catch:{ all -> 0x0137 }
            r2.stopCurrentAdPlay();	 Catch:{ all -> 0x0137 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0137 }
            r2.<init>();	 Catch:{ all -> 0x0137 }
            r3 = "play 11:";
            r2.append(r3);	 Catch:{ all -> 0x0137 }
            r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0137 }
            r2.append(r3);	 Catch:{ all -> 0x0137 }
            r2 = r2.toString();	 Catch:{ all -> 0x0137 }
            com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r2);	 Catch:{ all -> 0x0137 }
            r6.onFinish(r1);	 Catch:{ all -> 0x0137 }
        L_0x0135:
            monitor-exit(r0);	 Catch:{ all -> 0x0137 }
            return;
        L_0x0137:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0137 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$AnonymousClass1.onSoundPlayComplete():void");
        }

        public void onSoundPrepared() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSoundPrepared XmPlayerService 192:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            XmPlayerService.this.mLastDuration = XmPlayerService.this.mPlayerControl.getDuration();
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                for (int i = 0; i < beginBroadcast; i++) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onSoundPrepared();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
        }

        public void onSoundSwitch(PlayableModel playableModel, PlayableModel playableModel2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSoundSwitch XmPlayerService 221:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            if (XmPlayerService.this.getPlayerImpl() != null) {
                XmPlayerService.this.getPlayerImpl().lastRequestTime = System.currentTimeMillis();
            }
            int i = 0;
            XmPlayerService.this.mWillPause = false;
            String str = XmPlayerService.TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(DownloadThread.downloadedSize);
            stringBuilder2.append("");
            Logger.i(str, stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("");
            stringBuilder3.append(DownloadThread.downloadedSize);
            SharedPreferencesUtil.getInstance(XmPlayerService.this.mAppCtx).saveString("downloadedSize", stringBuilder3.toString());
            DownloadThread.downloadedSize = 0;
            synchronized (XmPlayerService.class) {
                int beginBroadcast = XmPlayerService.this.mPlayerDispatcher.beginBroadcast();
                while (i < beginBroadcast) {
                    try {
                        ((IXmPlayerEventDispatcher) XmPlayerService.this.mPlayerDispatcher.getBroadcastItem(i)).onSoundSwitch((Track) playableModel, (Track) playableModel2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                XmPlayerService.this.mPlayerDispatcher.finishBroadcast();
            }
            if (playableModel != null && (playableModel instanceof Track)) {
                XmPlayerService.this.mStatisticsManager.onStopTrack((Track) playableModel, XmPlayerService.this.mPlayerControl.getCurrentPos());
            }
            if (XmPlayerService.this.mStatisticsManager != null) {
                XmPlayerService.this.mStatisticsManager.onSoundSwitch();
            }
            XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateModelDetail(XmPlayerService.this.mListControl, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx));
        }
    };
    private String mSeparator = "__xm__";
    private XmStatisticsManager mStatisticsManager;
    private Handler mTimeHandler;
    private boolean mWillPause = false;
    private WidgetProvider provider;
    private long trackId;

    class XmPlayerImpl extends Stub {
        private long lastRequestTime;

        XmPlayerImpl() {
        }

        public void addPlayList(List<Track> list) throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.addPlayList(list);
            }
        }

        public void browseAlbums(long j, int i, int i2, final long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            String str = DTransferConstants.ALBUM_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            String str2 = DTransferConstants.PAGE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append("");
            hashMap.put(str2, stringBuilder2.toString());
            str2 = DTransferConstants.PAGE_SIZE;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i2);
            stringBuilder2.append("");
            hashMap.put(str2, stringBuilder2.toString());
            CommonRequest.getTracks(hashMap, new IDataCallBack<TrackList>() {
                public void onError(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j2);
                }

                public void onSuccess(TrackList trackList) {
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(trackList), 3, j2);
                }
            });
        }

        public void clearPlayCache() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                PlayerUtil.cleanUpCacheSound(XmPlayerService.this.mPlayerControl.getCurPlayUrl());
            }
        }

        public void exitSoundAd() throws RemoteException {
            String[] packagesForUid = XmPlayerService.this.getPackageManager().getPackagesForUid(getCallingUid());
            Object obj = (packagesForUid == null || packagesForUid.length <= 0) ? null : packagesForUid[0];
            String str = "com.ximalaya.ting.android";
            if (!TextUtils.isEmpty(str) && str.equals(obj) && BaseUtil.isMainApp() && XmPlayerService.this.mAdsManager != null) {
                XmPlayerService.this.mAdsManager.exitPlayAds(isPlaying());
            }
        }

        public void getAlbumByCategoryId(long j, int i, int i2, final long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            String str = DTransferConstants.CATEGORY_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            String str2 = DTransferConstants.PAGE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append("");
            hashMap.put(str2, stringBuilder2.toString());
            str2 = DTransferConstants.PAGE_SIZE;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i2);
            stringBuilder2.append("");
            hashMap.put(str2, stringBuilder2.toString());
            CommonRequest.getAlbums(hashMap, new IDataCallBack<AlbumList>() {
                public void onError(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j2);
                }

                public void onSuccess(AlbumList albumList) {
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(albumList), 9, j2);
                }
            });
        }

        public void getAlbumByCategoryIdAndTag(long j, int i, int i2, int i3, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("id", stringBuilder.toString());
            String str = DTransferConstants.PAGE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i2);
            stringBuilder2.append("");
            hashMap.put(str, stringBuilder2.toString());
            str = DTransferConstants.PAGE_SIZE;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i3);
            stringBuilder2.append("");
            hashMap.put(str, stringBuilder2.toString());
            if (i != 0) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(i);
                stringBuilder2.append("");
                hashMap.put("keywordId", stringBuilder2.toString());
            }
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_ALBUMS_BY_CATEGORY_ID_AND_TAG, j2, XmPlayerService.OPENSDK_GET_ALBUMS_BY_CATEGORY_ID_AND_TAG);
        }

        public void getAlbumInfo(long j, int i, int i2, String str, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            String str2 = DTransferConstants.PAGE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put(str2, stringBuilder.toString());
            if (i2 > 0) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(i2);
                stringBuilder2.append("");
                hashMap.put("pageSize", stringBuilder2.toString());
            } else {
                hashMap.put("pageSize", "20");
            }
            String str3 = DTransferConstants.ALBUMID;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(j);
            stringBuilder3.append("");
            hashMap.put(str3, stringBuilder3.toString());
            hashMap.put("isAsc", "true");
            hashMap.put("device", "android");
            hashMap.put("url_from", str);
            XmPlayerService.this.getRequestMData(hashMap, 101, j2, XmPlayerService.OPENSDK_GETALBUMDATA);
        }

        public void getAttentionAlbum(int i, String str, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            if (TextUtils.isEmpty(str)) {
                hashMap.put("sign", ClientOSType.ANDROID);
            } else {
                hashMap.put(PreferenceConstantsInOpenSdk.TIMELINE, str);
                hashMap.put("sign", ClientOSType.IOS);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put("size", stringBuilder.toString());
            XmPlayerService.this.getRequestMData(hashMap, 107, j, XmPlayerService.OPENSDK_GETATTENTIONALBUMLIST);
        }

        public void getCategoriesList(int i, int i2, long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), 128, j, XmPlayerService.OPENSDK_GET_CATEGORIES_LIST);
        }

        public void getCategoryModelList(final long j) throws RemoteException {
            CommonRequest.getCategories(new HashMap(), new IDataCallBack<CategoryList>() {
                public void onError(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j);
                }

                public void onSuccess(CategoryList categoryList) {
                    ArrayList arrayList = new ArrayList();
                    for (Category category : categoryList.getCategories()) {
                        CategoryModel categoryModel = new CategoryModel();
                        categoryModel.setCategoryId((int) category.getId());
                        categoryModel.setCategoryName(category.getCategoryName());
                        arrayList.add(categoryModel);
                    }
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(arrayList), 4, j);
                }
            });
        }

        public String getCurPlayUrl() throws RemoteException {
            return XmPlayerService.this.mPlayerControl != null ? XmPlayerService.this.mPlayerControl.getCurPlayUrl() : null;
        }

        public int getCurrIndex() throws RemoteException {
            return XmPlayerService.this.mListControl != null ? XmPlayerService.this.mListControl.getCurrIndex() : -1;
        }

        public long getCurrentTrackPlayedDuration() {
            return XmPlayerControl.mPlayedDuration;
        }

        public int getDefultPageSize() throws RemoteException {
            return 20;
        }

        public int getDuration() throws RemoteException {
            return XmPlayerService.this.mPlayerControl.getDuration();
        }

        public String getHistoryPos(String str) throws RemoteException {
            return XmPlayerService.this.getSoundHistoryPos(str);
        }

        public void getHotContent(boolean z, int i, int i2, final long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put(DTransferConstants.CATEGORY_ID, "0");
            String str = DTransferConstants.PAGE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            String str2 = DTransferConstants.PAGE_SIZE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i2);
            stringBuilder2.append("");
            hashMap.put(str2, stringBuilder2.toString());
            if (z) {
                CommonRequest.getHotTracks(hashMap, new IDataCallBack<TrackHotList>() {
                    public void onError(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }

                    public void onSuccess(TrackHotList trackHotList) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(trackHotList), 5, j);
                    }
                });
            } else {
                CommonRequest.getAlbums(hashMap, new IDataCallBack<AlbumList>() {
                    public void onError(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }

                    public void onSuccess(AlbumList albumList) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(albumList), 6, j);
                    }
                });
            }
        }

        public String getLastPlayTrackInAlbum(String str) throws RemoteException {
            return XmPlayerService.this.getLastPlayTrackInAlbumInner(str);
        }

        public void getMainHotContent(int i, int i2, int i3, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            String str = DTransferConstants.PAGE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i2);
            hashMap.put(str, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(i3);
            hashMap.put("per_page", stringBuilder2.toString());
            hashMap.put("condition", "hot");
            hashMap.put(DTransferConstants.CATEGORY_NAME, "all");
            hashMap.put(DTransferConstants.TAG_NAME, "");
            hashMap.put("device", "android");
            if (i == 1) {
                XmPlayerService.this.getRequestMData(hashMap, 105, j, XmPlayerService.OPENSDK_GETHOTTRACK);
            } else if (i == 2) {
                hashMap.put("status", "0");
                XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_HOT_ALBUM, j, XmPlayerService.OPENSDK_GET_HOT_ALBUM);
            }
        }

        public void getMyCollect(int i, int i2, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put("pageId", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i2);
            stringBuilder2.append("");
            hashMap.put("pageSize", stringBuilder2.toString());
            XmPlayerService.this.getRequestMData(hashMap, 100, j, XmPlayerService.OPENSDK_GETSUBSCRIBEALBUMLIST);
        }

        public void getNewRank(int i, int i2, int i3, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i2);
            hashMap.put("pageId", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(i3);
            hashMap.put("pageSize", stringBuilder2.toString());
            hashMap.put("target", "main");
            if (i == 0) {
                hashMap.put("rankingListId", "21");
                XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_NEW_ALBUM_RANK, j, XmPlayerService.OPENSDK_GET_NEW_RANK_ALBUM);
            } else if (i == 1) {
                hashMap.put("rankingListId", "57");
                XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_NEW_TRACK_RANK, j, XmPlayerService.OPENSDK_GET_NEW_RANK_TRACK);
            } else if (i == 2) {
                hashMap.put("rankingListId", "50");
                XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_NEW_ALBUM_RANK, j, XmPlayerService.OPENSDK_GET_NEW_RANK_ALBUM);
            }
        }

        public void getNextPlayList() throws RemoteException {
            XmPlayerService.this.mListControl.getNextPlayList(false);
        }

        public Map<String, String> getParam() throws RemoteException {
            return XmPlayerService.this.mListControl.getParams();
        }

        public void getParseDeviceInfo(long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), XmPlayerService.CODE_GET_PARSE_DEVICE_INFO, j, XmPlayerService.OPENSDK_GET_PARSE_DEVICE_INFO);
        }

        public int getPlayCurrPosition() throws RemoteException {
            return XmPlayerService.this.mPlayerControl.getCurrentPos();
        }

        public List<Track> getPlayList(int i) throws RemoteException {
            List playList = XmPlayerService.this.mListControl.getPlayList();
            if (playList == null || playList.size() < 30) {
                return playList;
            }
            int size = playList.size();
            i *= 30;
            int i2 = i + 30;
            if (size <= i) {
                return null;
            }
            if (i2 > size) {
                i2 = i + (size % 30);
            }
            return playList.subList(i, i2);
        }

        public boolean getPlayListOrder() throws RemoteException {
            return XmPlayerService.this.mListControl.getPlayListOrder();
        }

        public int getPlayListSize() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? 0 : XmPlayerService.getPlayerSrvice().getPlayListSize();
        }

        public String getPlayMode() throws RemoteException {
            return XmPlayerService.this.mListControl != null ? XmPlayerService.this.mListControl.getPlayMode().toString() : "";
        }

        public int getPlaySourceType() throws RemoteException {
            return XmPlayerService.this.mListControl.getPlaySource();
        }

        public int getPlayerStatus() throws RemoteException {
            return (XmPlayerService.this.mAdsManager == null || XmPlayerService.this.mPlayerControl == null) ? 7 : XmPlayerService.this.mAdsManager.isAdsActive() ? 3 : XmPlayerService.this.mPlayerControl.getPlayerState();
        }

        public void getPrePlayList() throws RemoteException {
            XmPlayerService.this.mListControl.getPrePlayList(false);
        }

        public void getProvinces(long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), XmPlayerService.CODE_GET_PROVINCES, j, XmPlayerService.OPENSDK_GET_PROVINCES);
        }

        public Radio getRadio() throws RemoteException {
            return XmPlayerService.this.mListControl.getRadio();
        }

        public void getRadioList(int i, long j, int i2, int i3, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put("radioType", stringBuilder.toString());
            if (i == 2) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(j);
                stringBuilder2.append("");
                hashMap.put("provinceCode", stringBuilder2.toString());
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(i3);
            stringBuilder3.append("");
            hashMap.put("pageSize", stringBuilder3.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(i2);
            stringBuilder3.append("");
            hashMap.put("pageNum", stringBuilder3.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_RADIO_LIST, j2, XmPlayerService.OPENSDK_GET_RADIO_LIST);
        }

        public void getRadioSchedules(String str, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("radio", str);
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_RADIO_SCHEDULES, j, XmPlayerService.OPENSDK_GET_RADIO_SCHEDULES);
        }

        public void getRank(String str, String str2, int i, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            hashMap.put("key", str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put("pageId", stringBuilder.toString());
            hashMap.put("pageSize", "20");
            if ("track".equals(str)) {
                XmPlayerService.this.getRequestMData(hashMap, 102, j, XmPlayerService.OPENSDK_GET_RANK_TRACK);
            } else if ("album".equals(str)) {
                XmPlayerService.this.getRequestMData(hashMap, 103, j, XmPlayerService.OPENSDK_GETRANKALBUMLIST);
            } else if (XmPlayerService.TYPE_RANK_ANCHOR.equals(str)) {
                XmPlayerService.this.getRequestMData(hashMap, 104, j, XmPlayerService.OPENSDK_GETRANKANCHORLIST);
            }
        }

        public void getRecommendAlbumListByAlbumId(long j, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            String str = DTransferConstants.ALBUMID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_RECOMMEND_ALBUMLIST_BY_ALBUMID, j2, XmPlayerService.OPENSDK_GET_RECOMMEND_ALBUMLIST_BY_ALBUMID);
        }

        public void getRecommendAlbumListByTrackId(long j, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("trackId", stringBuilder.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_RECOMMEND_ALBUMLIST_BY_TRACKID, j2, XmPlayerService.OPENSDK_GET_RECOMMEND_ALBUMLIST_BY_TRACKID);
        }

        public void getSourseLists(String str, int i, int i2, int i3, final int i4, final long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            hashMap.put(DTransferConstants.SEARCH_KEY, str);
            str = DTransferConstants.CATEGORY_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            str = DTransferConstants.PAGE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i2);
            stringBuilder2.append("");
            hashMap.put(str, stringBuilder2.toString());
            str = DTransferConstants.PAGE_SIZE;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i3);
            stringBuilder2.append("");
            hashMap.put(str, stringBuilder2.toString());
            if (i4 == 1) {
                CommonRequest.getSearchedAlbums(hashMap, new IDataCallBack<SearchAlbumList>() {
                    public void onError(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }

                    public void onSuccess(SearchAlbumList searchAlbumList) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(searchAlbumList), i4, j);
                    }
                });
            } else if (i4 == 2) {
                CommonRequest.getSearchedTracks(hashMap, new IDataCallBack<SearchTrackList>() {
                    public void onError(int i, String str) {
                        XmPlayerService.this.setCustomCallBackErrData(str, j);
                    }

                    public void onSuccess(SearchTrackList searchTrackList) {
                        XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(searchTrackList), i4, j);
                    }
                });
            }
        }

        public void getSpecialListenList(int i, int i2, int i3, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i3);
            stringBuilder.append("");
            hashMap.put("categoryId", stringBuilder.toString());
            hashMap.put("scale", ClientOSType.ANDROID);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append("");
            hashMap.put("pageId", stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(i2);
            stringBuilder3.append("");
            hashMap.put("pageSize", stringBuilder3.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_SPECIALLISTEN, j, XmPlayerService.OPENSDK_GET_SPECIALLISTEN);
        }

        public void getSubjectDetail(int i, int i2, long j, long j2) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("id", stringBuilder.toString());
            String str = DTransferConstants.PAGE;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append("");
            hashMap.put(str, stringBuilder2.toString());
            String str2 = DTransferConstants.PAGE_SIZE;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(i2);
            stringBuilder3.append("");
            hashMap.put(str2, stringBuilder3.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_SUBJECTDETAIL, j2, XmPlayerService.OPENSDK_GET_SUBJECTDETAIL);
        }

        public void getSuggestAlbums(int i, int i2, boolean z, long j) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(i);
            hashMap.put("pageId", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(i2);
            hashMap.put("pageSize", stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("");
            stringBuilder3.append(z);
            hashMap.put("isLogin", stringBuilder3.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_SUGGEST_ALBUMS, j, XmPlayerService.OPENSDK_GET_SUGGEST_ALBUMS);
        }

        public void getTags(long j, long j2) {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("categoryId", stringBuilder.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_TAGS_BY_CATEGORY_ID, j2, XmPlayerService.OPENSDK_GET_TAGS_BY_CATEGORY_ID);
        }

        public float getTempo() throws RemoteException {
            return XmPlayerService.this.mPlayerControl != null ? XmPlayerService.this.mPlayerControl.getTempo() : CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public Track getTrack(int i) throws RemoteException {
            return (Track) XmPlayerService.this.mListControl.getPlayableModel(i);
        }

        public void getTrackDetailInfo(long j, long j2) {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("trackId", stringBuilder.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_TRACK_DETAIL_INFO, j2, XmPlayerService.OPENSDK_GET_TRACK_INFO);
        }

        public Track getTrackInfoSync(long j) {
            HashMap hashMap = new HashMap();
            hashMap.put("device", "android");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("trackId", stringBuilder.toString());
            try {
                Class commonRequestM = BaseCall.getCommonRequestM();
                if (commonRequestM != null) {
                    return (Track) commonRequestM.getMethod("getTrackInfoDetailSync", new Class[]{Map.class}).invoke(null, new Object[]{hashMap});
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
            return null;
        }

        public void getTrackListByLastTrack(long j, long j2, int i, final long j3) throws RemoteException {
            HashMap hashMap = new HashMap();
            String str = DTransferConstants.ALBUM_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(j2);
            stringBuilder2.append("");
            hashMap.put("track_id", stringBuilder2.toString());
            String str2 = DTransferConstants.PAGE_SIZE;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append("");
            hashMap.put(str2, stringBuilder2.toString());
            CommonRequest.getLastPlayTracks(hashMap, new IDataCallBack<LastPlayTrackList>() {
                public void onError(int i, String str) {
                    XmPlayerService.this.setCustomCallBackErrData(str, j3);
                }

                public void onSuccess(LastPlayTrackList lastPlayTrackList) {
                    XmPlayerService.this.setCustomCallBackSuccessData(new Gson().toJson(lastPlayTrackList), 8, j3);
                }
            });
        }

        public void getTrackListByTrackIdAtAlbum(long j, long j2, boolean z, long j3) throws RemoteException {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            hashMap.put("trackId", stringBuilder.toString());
            String str = DTransferConstants.ALBUMID;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(j2);
            stringBuilder2.append("");
            hashMap.put(str, stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(z);
            stringBuilder2.append("");
            hashMap.put("asc", stringBuilder2.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_GET_TRACKLIST_BYTRACKIDATALBUM, j3, XmPlayerService.OPENSDK_GET_TRACKLIST_BYTRACKIDATALBUM);
        }

        public void getUserInfo(long j) throws RemoteException {
            XmPlayerService.this.getRequestMData(new HashMap(), 106, j, XmPlayerService.OPENSDK_GETUSERINFO);
        }

        public boolean hasNextSound() throws RemoteException {
            int currListSize = XmPlayerService.this.mListControl.getCurrListSize();
            return currListSize <= 1 ? false : XmPlayerService.this.mListControl.getCurrIndex() + 1 < currListSize || XmPlayerService.this.mListControl.isLoading();
        }

        public boolean hasPreSound() throws RemoteException {
            if (XmPlayerService.this.mListControl.getCurrListSize() <= 1) {
                return false;
            }
            int currIndex = XmPlayerService.this.mListControl.getCurrIndex();
            return currIndex > 0 && currIndex - 1 >= 0;
        }

        public boolean haveNextPlayList() throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.hasNextPage();
            }
            return false;
        }

        public boolean havePrePlayList() throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.hasPrePage();
            }
            return false;
        }

        public void init(String str, String str2, String str3) throws RemoteException {
            CommonRequest.getInstanse().setAppkey(str2);
            CommonRequest.getInstanse().setPackid(str3);
            CommonRequest.getInstanse().init(XmPlayerService.this, str);
        }

        public void insertPlayListHead(List<Track> list) throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.insertPlayListHead(list);
            }
        }

        public boolean isAdPlaying() throws RemoteException {
            return XmPlayerService.this.mAdsManager != null ? XmPlayerService.this.mAdsManager.isAdsPlaying() : false;
        }

        public boolean isAdsActive() throws RemoteException {
            return XmPlayerService.this.mAdsManager != null ? XmPlayerService.this.mAdsManager.isAdsActive() : false;
        }

        public boolean isBuffering() throws RemoteException {
            boolean z = false;
            if (XmPlayerService.this.mPlayerControl == null) {
                return false;
            }
            if (XmPlayerService.this.mPlayerControl.isBuffering() || getPlayerStatus() == 9) {
                z = true;
            }
            return z;
        }

        public boolean isDLNAState() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl == null) {
                return XmPlayerService.this.isDLNAState;
            }
            XmPlayerService.this.isDLNAState = XmPlayerService.this.mPlayerControl.isDLNAState();
            return XmPlayerService.this.isDLNAState;
        }

        public boolean isLoading() throws RemoteException {
            if (!(XmPlayerService.this.mAdsManager == null || XmPlayerService.this.mPlayerControl == null)) {
                return XmPlayerService.this.mPlayerControl.getPlayerState() == 9 ? true : (!XmPlayerService.this.mAdsManager.isAdsActive() || XmPlayerService.this.mAdsManager.isLastIsDuringPlay() || XmPlayerService.this.mAdsManager.getPlayerStatue() == 2) ? false : true;
            }
            return false;
        }

        public boolean isOnlineSource() throws RemoteException {
            return XmPlayerService.this.mPlayerControl != null ? XmPlayerService.this.mPlayerControl.isOnlineSource() : false;
        }

        public boolean isPlaying() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().isPlaying();
        }

        public void needContinuePlay(boolean z) throws RemoteException {
            XmPlayerService.this.isContinuePlay = z;
            if (XmPlayerService.this.mPlayerAudioFocusControl != null) {
                XmPlayerService.this.mPlayerAudioFocusControl.needContinuePlay(z);
            }
        }

        public boolean pausePlay() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().pausePlay();
        }

        public void pausePlayInMillis(long j) throws RemoteException {
            XmPlayerService.this.mPauseTimeInMills = j;
        }

        public boolean permutePlayList() throws RemoteException {
            return XmPlayerService.this.mListControl.permutePlayList();
        }

        public boolean play(int i) throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().play(i);
        }

        public boolean playNext() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().playNext();
        }

        public boolean playPre() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().playPre();
        }

        public boolean playRadio(Radio radio) throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().playRadio(radio);
        }

        public void registeAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
            String str = XmPlayerService.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Process ");
            stringBuilder.append(Binder.getCallingPid());
            stringBuilder.append("has register AdsListener");
            Logger.i(str, stringBuilder.toString());
            if (iXmAdsEventDispatcher != null) {
                XmPlayerService.this.mAdsDispatcher.register(iXmAdsEventDispatcher, new ProcessCookie(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void registeCommonBusinessListener(IXmCommonBusinessDispatcher iXmCommonBusinessDispatcher) throws RemoteException {
            XmPlayerService.this.mIXmCommonBusinessDispatcher = iXmCommonBusinessDispatcher;
        }

        public void registeCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
            String str = XmPlayerService.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Process ");
            stringBuilder.append(Binder.getCallingPid());
            stringBuilder.append("has register CustomDataCallBack");
            Logger.i(str, stringBuilder.toString());
            if (iXmCustomDataCallBack != null) {
                XmPlayerService.this.mCustomDataCallBack.register(iXmCustomDataCallBack, new ProcessCookie(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void registeMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
            if (iXmMainDataSupportDataCallback != null) {
                XmPlayerService.this.mMainDataSupportCallbackList.register(iXmMainDataSupportDataCallback, new ProcessCookie(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void registePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
            String str = XmPlayerService.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Process ");
            stringBuilder.append(Binder.getCallingPid());
            stringBuilder.append("has register PlayerListener");
            Logger.i(str, stringBuilder.toString());
            if (iXmPlayerEventDispatcher != null && XmPlayerService.this.mPlayerDispatcher != null) {
                XmPlayerService.this.mPlayerDispatcher.register(iXmPlayerEventDispatcher, new ProcessCookie(Binder.getCallingPid(), Binder.getCallingUid()));
            }
        }

        public void removeListByIndex(int i) throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.removeListByIndex(i);
            }
        }

        public void requestSoundAd() throws RemoteException {
            Logger.logToSd("requestSoundAd");
            if (!isAdsActive() && XmPlayerService.this.mAdsManager != null && (XmPlayerService.this.mLastModel instanceof Track) && System.currentTimeMillis() - this.lastRequestTime > 3000) {
                this.lastRequestTime = System.currentTimeMillis();
                Logger.logToSd("requestSoundAd playAds");
                XmPlayerService.this.mAdsManager.playAds((Track) XmPlayerService.this.mLastModel, 0, null, true);
            }
        }

        public void resetPlayList() throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.resetPlayList();
            }
            XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateModelDetail(XmPlayerService.this.mListControl, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx));
            if (XmPlayerService.this.mAdsManager != null) {
                XmPlayerService.this.mAdsManager.stopCurrentAdPlay();
            }
        }

        public void resetPlayer() throws RemoteException {
            if (XmPlayerService.this.mPlayerControl != null) {
                XmPlayerService.this.mPlayerControl.resetMediaPlayer();
            }
        }

        public boolean seekTo(int i) throws RemoteException {
            return (XmPlayerService.this.mAdsManager.isAdsActive() || XmPlayerService.this.mListControl.getPlaySource() == 3) ? false : XmPlayerService.this.mPlayerControl.seekTo(i);
        }

        public void setAdsDataHandlerClassName(String str) throws RemoteException {
            XmPlayerService.this.mAdsManager.setAdsDataHandlerClassName(str);
        }

        public void setAppSecret(String str) throws RemoteException {
            String str2 = XmPlayerService.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setAppSecret ");
            stringBuilder.append(str);
            Logger.i(str2, stringBuilder.toString());
            XmPlayerService.this.mAppSecret = str;
            CommonRequest.getInstanse().init(XmPlayerService.this.mAppCtx, XmPlayerService.this.mAppSecret);
        }

        public void setAppkeyAndPackId(String str, String str2) throws RemoteException {
            CommonRequest.getInstanse().setAppkey(str);
            CommonRequest.getInstanse().setPackid(str2);
        }

        public void setBreakpointResume(boolean z) throws RemoteException {
            XmPlayerConfig.getInstance(XmPlayerService.this).setBreakpointResume(z);
        }

        public void setCategoryId(int i, final long j) throws RemoteException {
            final HashMap hashMap = new HashMap();
            String str = DTransferConstants.CATEGORY_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            CommonRequest.getHotTracks(hashMap, new IDataCallBack<TrackHotList>() {
                public void onError(int i, String str) {
                    XmPlayerService xmPlayerService = XmPlayerService.this;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String) hashMap.get(DTransferConstants.SEARCH_KEY));
                    stringBuilder.append(str);
                    xmPlayerService.setCustomCallBackErrData(stringBuilder.toString(), j);
                }

                public void onSuccess(TrackHotList trackHotList) {
                    if (trackHotList == null || trackHotList.getTracks() == null || trackHotList.getTracks().size() <= 0) {
                        XmPlayerService.this.setCustomCallBackErrData((String) hashMap.get(DTransferConstants.SEARCH_KEY), j);
                        return;
                    }
                    XmPlayerService.getPlayerSrvice().setPlayList(hashMap, trackHotList.getTracks());
                    XmPlayerService.getPlayerSrvice().play(0);
                }
            });
        }

        public void setCheckAdContent(boolean z) throws RemoteException {
            if (BaseUtil.isMainApp()) {
                try {
                    Field declaredField = Class.forName("com.ximalaya.ting.android.host.manager.ad.AdManager").getDeclaredField("checkAdContent");
                    declaredField.setAccessible(true);
                    declaredField.set(null, Boolean.valueOf(z));
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (ClassNotFoundException e3) {
                    e3.printStackTrace();
                    if (ConstantsOpenSdk.isDebug) {
                        throw new RuntimeException("AdManager 类路径发生变化");
                    }
                }
            }
        }

        public void setDLNAState(boolean z) throws RemoteException {
            XmPlayerService.this.isDLNAState = z;
            if (XmPlayerService.this.mPlayerControl != null) {
                XmPlayerService.this.mPlayerControl.setDLNAState(z);
            }
        }

        public void setHistoryPosById(long j, int i) throws RemoteException {
            XmPlayerService.this.saveSoundHistoryPos(j, i);
        }

        public void setNotification(int i, Notification notification) throws RemoteException {
            if (notification != null) {
                try {
                    if (XmPlayerService.mService != null) {
                        Logger.i(XmPlayerService.TAG, "setNotification");
                        XmPlayerService.mService.startForeground(i, notification);
                        XmPlayerService.this.mNotification = notification;
                        XmPlayerService.this.mNotificationId = i;
                        if (XmPlayerService.this.mAppCtx != null && XmPlayerService.this.mListControl != null && XmPlayerService.this.mNotificationManager != null) {
                            boolean isDarkNotificationBar = NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx);
                            XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateModelDetail(XmPlayerService.this.mListControl, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, isDarkNotificationBar);
                            XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateViewStateAtPause(XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, isDarkNotificationBar);
                        }
                    }
                } catch (Exception e) {
                    String str = CdnConstants.PLAY_INFO;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("setNotification:");
                    stringBuilder.append(e.toString());
                    CdnUtil.statToXDCSError(str, stringBuilder.toString());
                }
            }
        }

        public void setPageSize(int i) throws RemoteException {
            if (CommonRequest.getInstanse().getDefaultPagesize() != i) {
                CommonRequest.getInstanse().setDefaultPagesize(i);
            }
        }

        /* JADX WARNING: Missing block: B:14:0x004e, code skipped:
            if (com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice().play(r7) == false) goto L_0x0071;
     */
        public void setPlayByAlbumTracks(java.lang.String r6, int r7, long r8) throws android.os.RemoteException {
            /*
            r5 = this;
            r0 = android.text.TextUtils.isEmpty(r6);
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x000d;
        L_0x0008:
            if (r7 >= 0) goto L_0x000b;
        L_0x000a:
            goto L_0x000d;
        L_0x000b:
            r0 = r1;
            goto L_0x000e;
        L_0x000d:
            r0 = r2;
        L_0x000e:
            if (r0 != 0) goto L_0x0070;
        L_0x0010:
            r3 = new com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$XmPlayerImpl$7;	 Catch:{ Exception -> 0x0051 }
            r3.<init>();	 Catch:{ Exception -> 0x0051 }
            r3 = r3.getType();	 Catch:{ Exception -> 0x0051 }
            r4 = new com.google.gson.Gson;	 Catch:{ Exception -> 0x0051 }
            r4.<init>();	 Catch:{ Exception -> 0x0051 }
            r6 = r4.fromJson(r6, r3);	 Catch:{ Exception -> 0x0051 }
            r6 = (com.ximalaya.ting.android.opensdk.model.track.CommonTrackList) r6;	 Catch:{ Exception -> 0x0051 }
            r3 = r6.getTracks();	 Catch:{ Exception -> 0x0051 }
            if (r3 == 0) goto L_0x0034;
        L_0x002a:
            r3 = r6.getTracks();	 Catch:{ Exception -> 0x0051 }
            r3 = r3.size();	 Catch:{ Exception -> 0x0051 }
            if (r3 != 0) goto L_0x0035;
        L_0x0034:
            r0 = r2;
        L_0x0035:
            if (r0 != 0) goto L_0x0070;
        L_0x0037:
            r3 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();	 Catch:{ Exception -> 0x0051 }
            r4 = r6.getParams();	 Catch:{ Exception -> 0x0051 }
            r6 = r6.getTracks();	 Catch:{ Exception -> 0x0051 }
            r3.setPlayList(r4, r6);	 Catch:{ Exception -> 0x0051 }
            r6 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();	 Catch:{ Exception -> 0x0051 }
            r6 = r6.play(r7);	 Catch:{ Exception -> 0x0051 }
            if (r6 != 0) goto L_0x0070;
        L_0x0050:
            goto L_0x0071;
        L_0x0051:
            r6 = move-exception;
            r6.printStackTrace();
            r7 = "play_info";
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r3 = "setPlayByAlbumTracks:";
            r0.append(r3);
            r6 = r6.toString();
            r0.append(r6);
            r6 = r0.toString();
            com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r7, r6);
            goto L_0x0071;
        L_0x0070:
            r2 = r0;
        L_0x0071:
            if (r2 == 0) goto L_0x007b;
        L_0x0073:
            r6 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;
            r7 = "播放失败";
            r6.setCustomCallBackErrData(r7, r8);
            goto L_0x0082;
        L_0x007b:
            r6 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;
            r7 = "播放成功";
            r6.setCustomCallBackSuccessData(r7, r1, r8);
        L_0x0082:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$XmPlayerImpl.setPlayByAlbumTracks(java.lang.String, int, long):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
        /* JADX WARNING: Missing block: B:7:0x0034, code skipped:
            if (com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice().play(0) == false) goto L_0x0055;
     */
        public void setPlayByTrack(java.lang.String r8, long r9) throws android.os.RemoteException {
            /*
            r7 = this;
            r0 = android.text.TextUtils.isEmpty(r8);
            r1 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
            if (r1 != 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = 1;
            if (r0 != 0) goto L_0x0056;
        L_0x000e:
            r2 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();	 Catch:{ Exception -> 0x0037 }
            r3 = 0;
            r4 = new com.ximalaya.ting.android.opensdk.model.track.Track[r1];	 Catch:{ Exception -> 0x0037 }
            r5 = new com.google.gson.Gson;	 Catch:{ Exception -> 0x0037 }
            r5.<init>();	 Catch:{ Exception -> 0x0037 }
            r6 = com.ximalaya.ting.android.opensdk.model.track.Track.class;
            r8 = r5.fromJson(r8, r6);	 Catch:{ Exception -> 0x0037 }
            r8 = (com.ximalaya.ting.android.opensdk.model.track.Track) r8;	 Catch:{ Exception -> 0x0037 }
            r5 = 0;
            r4[r5] = r8;	 Catch:{ Exception -> 0x0037 }
            r8 = java.util.Arrays.asList(r4);	 Catch:{ Exception -> 0x0037 }
            r2.setPlayList(r3, r8);	 Catch:{ Exception -> 0x0037 }
            r8 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();	 Catch:{ Exception -> 0x0037 }
            r8 = r8.play(r5);	 Catch:{ Exception -> 0x0037 }
            if (r8 != 0) goto L_0x0056;
        L_0x0036:
            goto L_0x0055;
        L_0x0037:
            r8 = move-exception;
            r8.printStackTrace();
            r0 = "play_info";
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r3 = "setPlayByTrack:";
            r2.append(r3);
            r8 = r8.toString();
            r2.append(r8);
            r8 = r2.toString();
            com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r0, r8);
        L_0x0055:
            r0 = r1;
        L_0x0056:
            if (r0 == 0) goto L_0x005f;
        L_0x0058:
            r8 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.this;
            r0 = "播放失败";
            r8.setCustomCallBackErrData(r0, r9);
        L_0x005f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerService$XmPlayerImpl.setPlayByTrack(java.lang.String, long):void");
        }

        public void setPlayCdnConfigureModel(CdnConfigModel cdnConfigModel) throws RemoteException {
            CdnUtil.setCdnConfigModel(cdnConfigModel);
        }

        public boolean setPlayIndex(int i) throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().play(i, false);
        }

        public void setPlayList(Map map, List<Track> list) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() != null) {
                XmPlayerService.getPlayerSrvice().setPlayList(map, list);
            }
        }

        public void setPlayListChangeListener(IXmDataCallback iXmDataCallback) throws RemoteException {
            XmPlayerService.this.mListControl.setPlayListChangeListener(iXmDataCallback);
        }

        public void setPlayMode(String str) throws RemoteException {
            if (XmPlayerService.this.mListControl != null) {
                XmPlayerService.this.mListControl.setPlayMode(PlayMode.valueOf(str));
            }
        }

        public void setPlayModel(String str, int i, final long j) throws RemoteException {
            if (TextUtils.isEmpty(str)) {
                XmPlayerService.this.setCustomCallBackErrData("内容为null", j);
                return;
            }
            final HashMap hashMap = new HashMap();
            hashMap.put(DTransferConstants.SEARCH_KEY, str);
            if (i >= 0) {
                str = DTransferConstants.CATEGORY_ID;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("");
                hashMap.put(str, stringBuilder.toString());
            }
            CommonRequest.getSearchedTracks(hashMap, new IDataCallBack<SearchTrackList>() {
                public void onError(int i, String str) {
                    XmPlayerService xmPlayerService = XmPlayerService.this;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String) hashMap.get(DTransferConstants.SEARCH_KEY));
                    stringBuilder.append(str);
                    xmPlayerService.setCustomCallBackErrData(stringBuilder.toString(), j);
                }

                public void onSuccess(SearchTrackList searchTrackList) {
                    if (searchTrackList == null || searchTrackList.getTracks() == null || searchTrackList.getTracks().size() <= 0) {
                        XmPlayerService xmPlayerService = XmPlayerService.this;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((String) hashMap.get(DTransferConstants.SEARCH_KEY));
                        stringBuilder.append("没有搜索的数据");
                        xmPlayerService.setCustomCallBackErrData(stringBuilder.toString(), j);
                        return;
                    }
                    XmPlayerService.getPlayerSrvice().setPlayList(hashMap, searchTrackList.getTracks());
                    XmPlayerService.getPlayerSrvice().play(0);
                }
            });
        }

        public void setPlayStatisticClassName(String str) throws RemoteException {
            XmPlayerService.this.mStatisticsManager.setUploadClassName(str);
        }

        public void setPlayerProcessRequestEnvironment(int i) throws RemoteException {
            if (BaseUtil.isMainApp()) {
                try {
                    Field declaredField = Class.forName("com.ximalaya.ting.android.host.util.constant.AppConstants").getDeclaredField("environmentId");
                    declaredField.setAccessible(true);
                    declaredField.set(null, Integer.valueOf(i));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchFieldException e3) {
                    e3.printStackTrace();
                }
            }
        }

        public void setProxy(String str, int i, String str2, Map map) throws RemoteException {
            Config config = new Config();
            config.proxyHost = str;
            config.proxyPort = i;
            config.authorization = str2;
            config.property = map;
            setProxyNew(config);
        }

        public void setProxyNew(Config config) throws RemoteException {
            String str = XmPlayerService.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("代理 setProxyNew ");
            stringBuilder.append(config);
            Logger.e(str, stringBuilder.toString());
            XmPlayerService.this.mConfig = config;
            XmPlayerService.this.mPlayerControl.setProxy(config);
            CommonRequest.getInstanse().onlySetHttpConfig(config);
            BaseCall.getInstanse().setHttpConfig(config);
            FileUtilBase.setProxy(XmPlayerService.this, config);
            HttpUrlUtil.mConfig = config;
        }

        public void setRecordModel(RecordModel recordModel) throws RemoteException {
            if (XmPlayerService.this.mStatisticsManager != null) {
                XmPlayerService.this.mStatisticsManager.setRecordModel(recordModel);
            }
        }

        public void setSoundTouchAllParams(float f, float f2, float f3) throws RemoteException {
            if (XmPlayerService.getPlayerSrvice() != null) {
                XmPlayerService.getPlayerSrvice().setSoundTouchAllParams(f, f2, f3);
            }
        }

        public void setTokenInvalidForSDK(final IXmTokenInvalidForSDKCallBack iXmTokenInvalidForSDKCallBack) throws RemoteException {
            if (iXmTokenInvalidForSDKCallBack != null) {
                CommonRequest.getInstanse().setITokenStateChange(new CommonRequest$ITokenStateChange() {
                    public boolean getTokenByRefreshAsync() {
                        return false;
                    }

                    public boolean getTokenByRefreshSync() {
                        return false;
                    }

                    public void tokenLosted() {
                        if (iXmTokenInvalidForSDKCallBack != null) {
                            try {
                                iXmTokenInvalidForSDKCallBack.tokenInvalid();
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            } else {
                CommonRequest.getInstanse().setITokenStateChange(null);
            }
        }

        public void setTokenToPlayForSDK(AccessToken accessToken) throws RemoteException {
            AccessTokenManager.getInstanse().setContext(XmPlayerService.this);
            AccessTokenManager.getInstanse().onlyUpdateAccessToken(accessToken);
        }

        public void setVolume(float f, float f2) throws RemoteException {
            XmPlayerService.this.mPlayerControl.setVolume(f, f2);
        }

        public boolean startPlay() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().startPlay();
        }

        public boolean stopPlay() throws RemoteException {
            return XmPlayerService.getPlayerSrvice() == null ? false : XmPlayerService.getPlayerSrvice().stopPlay();
        }

        public void subscribeAlbum(String str, boolean z, long j) throws RemoteException {
            long id;
            HashMap hashMap = new HashMap();
            try {
                id = ((Album) new Gson().fromJson(str, Album.class)).getId();
            } catch (Exception e) {
                e.printStackTrace();
                id = 0;
            }
            String str2 = DTransferConstants.ALBUMID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(id);
            stringBuilder.append("");
            hashMap.put(str2, stringBuilder.toString());
            hashMap.put("album", str);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(z);
            stringBuilder2.append("");
            hashMap.put("isSubscribed", stringBuilder2.toString());
            XmPlayerService.this.getRequestMData(hashMap, XmPlayerService.CODE_SUBSCRIBE_ALBUM, j, XmPlayerService.OPENSDK_SUBSCRIBE_ALBUM);
        }

        public void unregisteAdsListener(IXmAdsEventDispatcher iXmAdsEventDispatcher) throws RemoteException {
            if (iXmAdsEventDispatcher != null) {
                XmPlayerService.this.mAdsDispatcher.unregister(iXmAdsEventDispatcher);
            }
        }

        public void unregisteCustomDataCallBack(IXmCustomDataCallBack iXmCustomDataCallBack) throws RemoteException {
            if (iXmCustomDataCallBack != null) {
                XmPlayerService.this.mCustomDataCallBack.unregister(iXmCustomDataCallBack);
            }
        }

        public void unregisteMainDataSupportCallBack(IXmMainDataSupportDataCallback iXmMainDataSupportDataCallback) throws RemoteException {
            if (iXmMainDataSupportDataCallback != null) {
                XmPlayerService.this.mMainDataSupportCallbackList.unregister(iXmMainDataSupportDataCallback);
            }
        }

        public void unregistePlayerListener(IXmPlayerEventDispatcher iXmPlayerEventDispatcher) throws RemoteException {
            if (iXmPlayerEventDispatcher != null && XmPlayerService.this.mPlayerDispatcher != null) {
                XmPlayerService.this.mPlayerDispatcher.unregister(iXmPlayerEventDispatcher);
            }
        }

        public void updateTrackDownloadUrlInPlayList(Track track) throws RemoteException {
            int indexOf = XmPlayerService.this.mListControl.getPlayList().indexOf(track);
            if (indexOf >= 0) {
                ((Track) XmPlayerService.this.mListControl.getPlayList().get(indexOf)).setDownloadedSaveFilePath(track.getDownloadedSaveFilePath());
            }
        }

        public boolean updateTrackInPlayList(Track track) throws RemoteException {
            if (track == null) {
                return false;
            }
            int indexOf = XmPlayerService.this.mListControl.getPlayList().indexOf(track);
            if (indexOf < 0) {
                return false;
            }
            XmPlayerService.this.mListControl.updateTrackInPlayList(indexOf, track);
            XmNotificationCreater.getInstanse(XmPlayerService.this.mAppCtx).updateModelDetail(XmPlayerService.this.mListControl, XmPlayerService.this.mNotificationManager, XmPlayerService.this.mNotification, XmPlayerService.this.mNotificationId, NotificationColorUtils.isDarkNotificationBar(XmPlayerService.this.mAppCtx));
            return true;
        }
    }

    static {
        C.i(16777270);
    }

    private void checkIsPauseTime() {
        long currentTimeMillis = this.mPauseTimeInMills - System.currentTimeMillis();
        if (this.mPauseTimeInMills > 0 && currentTimeMillis <= 0) {
            this.mPauseTimeInMills = 0;
            try {
                if (getPlayerImpl().getPlayerStatus() == 3) {
                    pausePlay();
                } else {
                    this.mWillPause = true;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> void getDataWithXDCS(String str, Map<String, String> map, IDataSupportCallBack<T> iDataSupportCallBack, Object... objArr) {
        Class commonRequestM = BaseCall.getCommonRequestM();
        if (commonRequestM != null) {
            Class[] clsArr = new Class[(objArr.length + 2)];
            clsArr[0] = Map.class;
            clsArr[1] = IDataSupportCallBack.class;
            for (int i = 2; i < clsArr.length; i++) {
                clsArr[i] = objArr[i - 2].getClass();
            }
            try {
                Method declaredMethod = commonRequestM.getDeclaredMethod(str, clsArr);
                Object[] objArr2 = new Object[(objArr.length + 2)];
                objArr2[0] = map;
                objArr2[1] = iDataSupportCallBack;
                for (int i2 = 2; i2 < objArr2.length; i2++) {
                    objArr2[i2] = objArr[i2 - 2];
                }
                if (objArr2 != null) {
                    if (objArr2.length >= 2) {
                        declaredMethod.invoke(null, objArr2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final native Intent getIntent(Context context);

    private String getLastPlayTrackInAlbumInner(String str) {
        try {
            str = this.mPlayLastPlayTrackInAlbum.getString(str, null);
            return TextUtils.isEmpty(str) ? null : str.split(this.mSeparator)[0];
        } catch (Exception unused) {
            return null;
        }
    }

    public static native XmPlayerService getPlayerSrvice();

    private Radio getRadio(PlayableModel playableModel) {
        Schedule trackToSchedule = ModelUtil.trackToSchedule((Track) playableModel);
        Radio radio = new Radio();
        radio.setDataId(trackToSchedule.getRadioId());
        radio.setKind("schedule");
        radio.setRadioName(trackToSchedule.getRadioName());
        radio.setProgramName(trackToSchedule.getRelatedProgram().getProgramName());
        radio.setScheduleID(trackToSchedule.getDataId());
        radio.setCoverUrlSmall(trackToSchedule.getRelatedProgram().getBackPicUrl());
        radio.setCoverUrlLarge(trackToSchedule.getRelatedProgram().getBackPicUrl());
        radio.setUpdateAt(System.currentTimeMillis());
        radio.setRate24AacUrl(trackToSchedule.getRelatedProgram().getRate24AacUrl());
        radio.setRate24TsUrl(trackToSchedule.getRelatedProgram().getRate24AacUrl());
        radio.setRate64AacUrl(trackToSchedule.getRelatedProgram().getRate64AacUrl());
        radio.setRate64TsUrl(trackToSchedule.getRelatedProgram().getRate64TsUrl());
        radio.setRadioPlayCount(trackToSchedule.getRadioPlayCount());
        radio.setProgramId(trackToSchedule.getRelatedProgram().getProgramId());
        return radio;
    }

    private native String getRadioUrl(Radio radio);

    private void getRequestMData(Map<String, String> map, final int i, final long j, String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getRequestMData   type = ");
        stringBuilder.append(i);
        stringBuilder.append("   ; urlKey = ");
        stringBuilder.append(str);
        Logger.e(str2, stringBuilder.toString());
        getDataWithXDCS(COMMREQUSTM_METHOD_NAME, map, new IDataSupportCallBack<String>() {
            public void onError(int i, String str) {
                XmPlayerService.this.setMainDataSupportCallBackErrorData(str, j);
            }

            public void onSuccess(String str) {
                XmPlayerService.this.setMainDataSupportCallBackSuccessData(str, i, j);
            }
        }, str);
    }

    private int getSoundHistoryPos(long j) {
        if (!this.mPlayerConfig.isBreakpointResume() || j <= 0) {
            return -1;
        }
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.mPlayHistory;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(j);
            return sharedPreferences.getInt(stringBuilder.toString(), -1);
        } catch (Exception unused) {
            sharedPreferences = this.mPlayHistory;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(j);
            return (int) sharedPreferences.getLong(stringBuilder2.toString(), -1);
        }
    }

    private native String getTrackUrlByBaseInfo(TrackBaseInfo trackBaseInfo);

    private void initPlayerService() {
        mService = this;
        SharedPreferencesUtil.getInstanceForPlayer(this);
        if (this.mIDomainServerIpCallback == null) {
            if (BaseUtil.isMainApp()) {
                this.mIDomainServerIpCallback = new IDomainServerIpCallback() {
                    public String getNewDownloadUrlIfExpire(String str) {
                        if (TextUtils.isEmpty(str)) {
                            return null;
                        }
                        PlayableModel playableModel = XmPlayerService.this.getPlayableModel();
                        if (playableModel == null) {
                            return null;
                        }
                        Track track = (Track) playableModel;
                        if (!track.isPaid() || !str.contains(XMediaPlayerConstants.IS_CHARGE)) {
                            return null;
                        }
                        CharSequence chargeDownloadUrl = BaseUtil.isMainApp() ? CommonRequestForMain.getChargeDownloadUrl(track) : PayUtil.updateTrackInfoSync(track.getDataId());
                        if (!TextUtils.isEmpty(chargeDownloadUrl)) {
                            XmPlayerService.this.mPlayerControl.updateCurPlayUrl(chargeDownloadUrl);
                        }
                        return chargeDownloadUrl;
                    }

                    public String[][] getStaticDomainServerIp(String str) {
                        return CommonRequestForMain.getStaticDomainServerIpInner(str);
                    }

                    public void setBadIp(String str, String str2, String str3) {
                        CommonRequestForMain.setBadIp(str, str2, str3);
                    }
                };
            } else {
                this.mIDomainServerIpCallback = HttpDNSUtilForOpenSDK.getDomainServerIpCallBack(this);
            }
            StaticConfig.setDomainServerIpCallback(this.mIDomainServerIpCallback);
        }
        StaticConfig.setUseragent(CommonRequest.getUserAgent());
        if (this.mAppCtx == null) {
            this.mAppCtx = getApplicationContext();
        }
        if (this.provider == null) {
            this.provider = new WidgetProvider();
        }
        if (this.mPlayerConfig == null) {
            this.mPlayerConfig = XmPlayerConfig.getInstance(this.mAppCtx);
        }
        if (this.mPlayerControl == null) {
            this.mPlayerControl = new XmPlayerControl(this.mAppCtx);
            this.mPlayerControl.setPlayerStatusListener(this.mPlayerStatusListener);
            this.mPlayerControl.setOnPlayDataOutputListener(this.mOnPlayDataOutputListener);
            this.mPlayerControl.setPlaySeekListener(this.mPlaySeekListener);
        }
        if (this.mListControl == null) {
            this.mListControl = new XmPlayListControl();
        }
        if (this.mPlayerImpl == null) {
            this.mPlayerImpl = new XmPlayerImpl();
        }
        if (this.mPlayHistory == null) {
            this.mPlayHistory = getSharedPreferences(PreferenceConstantsInOpenSdk.OPENSDK_FILENAME_PLAY_HISTORY_RECORD, 0);
        }
        if (this.mPlayLastPlayTrackInAlbum == null) {
            this.mPlayLastPlayTrackInAlbum = getSharedPreferences(PreferenceConstantsInOpenSdk.OPENSDK_FILENAME_PLAY_TRACK_HISTORY_RECORD, 0);
        }
        if (this.mPlayerAudioFocusControl == null) {
            this.mPlayerAudioFocusControl = new XmPlayerAudioFocusControl(this.mAppCtx);
        }
        this.mStatisticsManager = XmStatisticsManager.getInstance();
        this.mStatisticsManager.setContext(this);
        this.mAdsManager = XmAdsManager.getInstance(this.mAppCtx);
        this.mAdsManager.setAdsStatusListener(this.mAdsListener);
        this.mNotificationManager = (NotificationManager) this.mAppCtx.getSystemService("notification");
        if (VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(XmNotificationCreater.CHANNEL_ID, "播放通知栏", 4);
            notificationChannel.enableLights(false);
            notificationChannel.setShowBadge(false);
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(false);
            this.mNotificationManager.createNotificationChannel(notificationChannel);
        }
        if (this.mMediaControlManager == null) {
            try {
                this.mMediaControlManager = new MediaControlManager(this);
                this.mMediaControlManager.initMediaControl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mIStatToServerFactory == null) {
            this.mIStatToServerFactory = new StatToServerFactoryImplForOpen();
            StaticConfig.setIStatToServerFactory(this.mIStatToServerFactory);
        }
        XmSecretKeyUtil.getInstance().init(mService.getApplicationContext());
    }

    private boolean isNewList(List<? extends PlayableModel> list) {
        return this.mLastModel == null || list == null || !list.contains(this.mLastModel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce A:{Catch:{ Exception -> 0x019d }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A:{Catch:{ Exception -> 0x019d }} */
    private boolean play(int r11, boolean r12, int r13) {
        /*
        r10 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "play 0:";
        r0.append(r1);
        r1 = java.lang.System.currentTimeMillis();
        r0.append(r1);
        r0 = r0.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r0);
        r0 = 0;
        r1 = 0;
        if (r11 < 0) goto L_0x01be;
    L_0x001c:
        r2 = r10.mListControl;
        r2 = r2.getCurrListSize();
        if (r11 >= r2) goto L_0x01be;
    L_0x0024:
        r2 = r10.mListControl;	 Catch:{ Exception -> 0x019d }
        r2.setCurrIndex(r11);	 Catch:{ Exception -> 0x019d }
        r2 = r10.mListControl;	 Catch:{ Exception -> 0x019d }
        r11 = r2.getPlayableModel(r11);	 Catch:{ Exception -> 0x019d }
        r11 = (com.ximalaya.ting.android.opensdk.model.track.Track) r11;	 Catch:{ Exception -> 0x019d }
        if (r11 != 0) goto L_0x0055;
    L_0x0033:
        r11 = "XmPlayerService";
        r12 = "Get current model return null, play fail";
        com.ximalaya.ting.android.opensdk.util.Logger.e(r11, r12);	 Catch:{ Exception -> 0x019d }
        r10.mLastModel = r0;	 Catch:{ Exception -> 0x019d }
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r11.<init>();	 Catch:{ Exception -> 0x019d }
        r12 = "play 1:";
        r11.append(r12);	 Catch:{ Exception -> 0x019d }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x019d }
        r11.append(r12);	 Catch:{ Exception -> 0x019d }
        r11 = r11.toString();	 Catch:{ Exception -> 0x019d }
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r11);	 Catch:{ Exception -> 0x019d }
        return r1;
    L_0x0055:
        r2 = r10.mListControl;	 Catch:{ Exception -> 0x019d }
        r2 = r2.getPlayList();	 Catch:{ Exception -> 0x019d }
        r3 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r2 = r2.indexOf(r3);	 Catch:{ Exception -> 0x019d }
        if (r2 < 0) goto L_0x0070;
    L_0x0063:
        r3 = r10.mListControl;	 Catch:{ Exception -> 0x019d }
        r3 = r3.getPlayList();	 Catch:{ Exception -> 0x019d }
        r2 = r3.get(r2);	 Catch:{ Exception -> 0x019d }
        r2 = (com.ximalaya.ting.android.opensdk.model.PlayableModel) r2;	 Catch:{ Exception -> 0x019d }
        goto L_0x0071;
    L_0x0070:
        r2 = r0;
    L_0x0071:
        if (r2 != 0) goto L_0x0075;
    L_0x0073:
        r2 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
    L_0x0075:
        r3 = r2 instanceof com.ximalaya.ting.android.opensdk.model.track.Track;	 Catch:{ Exception -> 0x019d }
        if (r3 == 0) goto L_0x00a1;
    L_0x0079:
        r3 = r2;
        r3 = (com.ximalaya.ting.android.opensdk.model.track.Track) r3;	 Catch:{ Exception -> 0x019d }
        r3 = r3.getAlbum();	 Catch:{ Exception -> 0x019d }
        if (r3 == 0) goto L_0x00a1;
    L_0x0082:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r3.<init>();	 Catch:{ Exception -> 0x019d }
        r4 = "Test statistic track";
        r3.append(r4);	 Catch:{ Exception -> 0x019d }
        r4 = r2;
        r4 = (com.ximalaya.ting.android.opensdk.model.track.Track) r4;	 Catch:{ Exception -> 0x019d }
        r4 = r4.getAlbum();	 Catch:{ Exception -> 0x019d }
        r4 = r4.getRecSrc();	 Catch:{ Exception -> 0x019d }
        r3.append(r4);	 Catch:{ Exception -> 0x019d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x019d }
        com.ximalaya.ting.android.opensdk.util.Logger.log(r3);	 Catch:{ Exception -> 0x019d }
    L_0x00a1:
        r3 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r4 = 1;
        if (r3 == 0) goto L_0x00b1;
    L_0x00a6:
        r3 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r3 = r11.equals(r3);	 Catch:{ Exception -> 0x019d }
        if (r3 != 0) goto L_0x00af;
    L_0x00ae:
        goto L_0x00b1;
    L_0x00af:
        r3 = r1;
        goto L_0x00b2;
    L_0x00b1:
        r3 = r4;
    L_0x00b2:
        r5 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        if (r5 == 0) goto L_0x0174;
    L_0x00b6:
        r5 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r5 = r11.equals(r5);	 Catch:{ Exception -> 0x019d }
        if (r5 == 0) goto L_0x0174;
    L_0x00be:
        r5 = r11.isAuthorized();	 Catch:{ Exception -> 0x019d }
        r6 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r6 = (com.ximalaya.ting.android.opensdk.model.track.Track) r6;	 Catch:{ Exception -> 0x019d }
        r6 = r6.isAuthorized();	 Catch:{ Exception -> 0x019d }
        if (r5 == r6) goto L_0x00ce;
    L_0x00cc:
        goto L_0x0174;
    L_0x00ce:
        r5 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        if (r5 == 0) goto L_0x00ff;
    L_0x00d2:
        r5 = r11.getAlbum();	 Catch:{ Exception -> 0x019d }
        if (r5 == 0) goto L_0x00ff;
    L_0x00d8:
        r5 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r5 = (com.ximalaya.ting.android.opensdk.model.track.Track) r5;	 Catch:{ Exception -> 0x019d }
        r5 = r5.getAlbum();	 Catch:{ Exception -> 0x019d }
        if (r5 == 0) goto L_0x00ff;
    L_0x00e2:
        r5 = r11.getAlbum();	 Catch:{ Exception -> 0x019d }
        r5 = r5.getAlbumId();	 Catch:{ Exception -> 0x019d }
        r7 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r7 = (com.ximalaya.ting.android.opensdk.model.track.Track) r7;	 Catch:{ Exception -> 0x019d }
        r7 = r7.getAlbum();	 Catch:{ Exception -> 0x019d }
        r7 = r7.getAlbumId();	 Catch:{ Exception -> 0x019d }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r9 == 0) goto L_0x00ff;
    L_0x00fa:
        r5 = r10.mPlayerStatusListener;	 Catch:{ Exception -> 0x019d }
        r5.onSoundSwitch(r2, r11);	 Catch:{ Exception -> 0x019d }
    L_0x00ff:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r2.<init>();	 Catch:{ Exception -> 0x019d }
        r5 = "play 3:";
        r2.append(r5);	 Catch:{ Exception -> 0x019d }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x019d }
        r2.append(r5);	 Catch:{ Exception -> 0x019d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x019d }
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r2);	 Catch:{ Exception -> 0x019d }
        r10.mLastModel = r11;	 Catch:{ Exception -> 0x019d }
        if (r12 == 0) goto L_0x015b;
    L_0x011b:
        r11 = r10.mAdsManager;	 Catch:{ Exception -> 0x019d }
        r11 = r11.isAdsActive();	 Catch:{ Exception -> 0x019d }
        if (r11 == 0) goto L_0x014c;
    L_0x0123:
        r11 = r10.mAdsManager;	 Catch:{ Exception -> 0x019d }
        r11 = r11.getPlayerStatue();	 Catch:{ Exception -> 0x019d }
        if (r11 == r4) goto L_0x012e;
    L_0x012b:
        r12 = 3;
        if (r11 != r12) goto L_0x0133;
    L_0x012e:
        r11 = r10.mAdsManager;	 Catch:{ Exception -> 0x019d }
        r11.playAd();	 Catch:{ Exception -> 0x019d }
    L_0x0133:
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r11.<init>();	 Catch:{ Exception -> 0x019d }
        r12 = "play 4:";
        r11.append(r12);	 Catch:{ Exception -> 0x019d }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x019d }
        r11.append(r12);	 Catch:{ Exception -> 0x019d }
        r11 = r11.toString();	 Catch:{ Exception -> 0x019d }
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r11);	 Catch:{ Exception -> 0x019d }
        return r1;
    L_0x014c:
        r11 = r10.mPlayerControl;	 Catch:{ Exception -> 0x019d }
        r11 = r11.play(r4);	 Catch:{ Exception -> 0x019d }
        if (r11 != 0) goto L_0x015a;
    L_0x0154:
        r11 = r10.mLastModel;	 Catch:{ Exception -> 0x019d }
        r11 = r10.playTrackPrivate(r11, r12, r13, r3);	 Catch:{ Exception -> 0x019d }
    L_0x015a:
        return r11;
    L_0x015b:
        r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r11.<init>();	 Catch:{ Exception -> 0x019d }
        r12 = "play 5:";
        r11.append(r12);	 Catch:{ Exception -> 0x019d }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x019d }
        r11.append(r12);	 Catch:{ Exception -> 0x019d }
        r11 = r11.toString();	 Catch:{ Exception -> 0x019d }
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r11);	 Catch:{ Exception -> 0x019d }
        return r1;
    L_0x0174:
        r4 = r10.mPlayerControl;	 Catch:{ Exception -> 0x019d }
        r4.pause(r1);	 Catch:{ Exception -> 0x019d }
        r4 = r10.mPlayerStatusListener;	 Catch:{ Exception -> 0x019d }
        r4.onSoundSwitch(r2, r11);	 Catch:{ Exception -> 0x019d }
        r10.mLastModel = r11;	 Catch:{ Exception -> 0x019d }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r2.<init>();	 Catch:{ Exception -> 0x019d }
        r4 = "play 2:";
        r2.append(r4);	 Catch:{ Exception -> 0x019d }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x019d }
        r2.append(r4);	 Catch:{ Exception -> 0x019d }
        r2 = r2.toString();	 Catch:{ Exception -> 0x019d }
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r2);	 Catch:{ Exception -> 0x019d }
        r11 = r10.playTrackPrivate(r11, r12, r13, r3);	 Catch:{ Exception -> 0x019d }
        return r11;
    L_0x019d:
        r11 = move-exception;
        r11.printStackTrace();
        r10.mLastModel = r0;
        r12 = "play_info";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = "play(0):";
        r13.append(r0);
        r11 = r11.toString();
        r13.append(r11);
        r11 = r13.toString();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r12, r11);
        goto L_0x01e4;
    L_0x01be:
        r12 = "XmPlayerService";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r2 = "Index Out Of Bound, index:";
        r13.append(r2);
        r13.append(r11);
        r11 = ", total:";
        r13.append(r11);
        r11 = r10.mListControl;
        r11 = r11.getCurrListSize();
        r13.append(r11);
        r11 = r13.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.e(r12, r11);
        r10.mLastModel = r0;
    L_0x01e4:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.play(int, boolean, int):boolean");
    }

    private void playTrack(final Track track, final boolean z) {
        this.trackId = track.getDataId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playTrack 13:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        CharSequence downloadUrl = getDownloadUrl(track);
        Object obj = (!track.isPaid() || track.isFree()) ? null : 1;
        if (obj == null || !TextUtils.isEmpty(downloadUrl)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("playTrack 16:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            if (TextUtils.isEmpty(downloadUrl)) {
                downloadUrl = getTrackUrl(track);
            }
            if (!TextUtils.isEmpty(downloadUrl) || (track.getType() == 4 && track.isVideo())) {
                playTrackInner(downloadUrl, track, z);
                return;
            }
            HashMap hashMap = new HashMap();
            final long dataId = track.getDataId();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(dataId);
            stringBuilder3.append("");
            hashMap.put("track_id", stringBuilder3.toString());
            final Track track2 = track;
            final boolean z2 = z;
            CommonRequest.getTrackInfo(hashMap, new IDataCallBack<TrackBaseInfo>() {
                public void onError(int i, String str) {
                    if (dataId == XmPlayerService.this.trackId && (XmPlayerService.this.mAdsManager == null || !XmPlayerService.this.mAdsManager.isAdsActive())) {
                        XmPlayerService.this.playTrackInner(null, track2, z2);
                    }
                }

                public void onSuccess(@Nullable TrackBaseInfo trackBaseInfo) {
                    if (trackBaseInfo != null && dataId == XmPlayerService.this.trackId && (XmPlayerService.this.mAdsManager == null || !XmPlayerService.this.mAdsManager.isAdsActive())) {
                        XmPlayerService.this.playTrackInner(XmPlayerService.this.getTrackUrlByBaseInfo(trackBaseInfo), track2, z2);
                    }
                }
            });
            return;
        }
        if (this.mPlayerStatusListener != null) {
            this.mPlayerStatusListener.onBufferingStart();
        }
        CommonRequest.updateTrackForPlay(new HashMap(), new IDataCallBack<String>() {
            public void onError(int i, String str) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("playTrack 15:");
                stringBuilder.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder.toString());
                if (XmPlayerService.this.mPlayerStatusListener != null) {
                    XmPlayerService.this.mPlayerStatusListener.onBufferingStop();
                }
                XmPlayerService.this.playTrackInner(null, track, z);
                if (i == DTransferConstants.NO_AUTHORIZED_CODE) {
                    track.setAuthorized(false);
                    XmPlayerService.this.mPlayerStatusListener.onSoundSwitch(track, null);
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("playTrack updateTrackForPlay error code:");
                stringBuilder.append(i);
                stringBuilder.append(" msg:");
                stringBuilder.append(str);
                Logger.log(stringBuilder.toString());
            }

            public void onSuccess(String str) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("playTrack 14:");
                stringBuilder.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder.toString());
                if (XmPlayerService.this.mPlayerStatusListener != null) {
                    XmPlayerService.this.mPlayerStatusListener.onBufferingStop();
                }
                XmPlayerService.this.playTrackInner(str, track, z);
            }
        }, track);
    }

    private void playTrackInner(String str, Track track, boolean z) {
        int soundHistoryPos = getSoundHistoryPos(track.getDataId());
        if (soundHistoryPos < 0 || track.isAudition() || soundHistoryPos > track.getDuration() * 1000) {
            soundHistoryPos = 0;
        }
        if (TextUtils.isEmpty(str)) {
            str = getTrackUrl(track);
        }
        if (!(z ? this.mPlayerControl.initAndPlay(str, soundHistoryPos) : this.mPlayerControl.initAndNotAutoPlay(str, soundHistoryPos))) {
            this.mLastModel = null;
        }
    }

    private boolean playTrackPrivate(PlayableModel playableModel, boolean z, int i, boolean z2) throws Exception {
        setLossAudioFocus(false);
        if (z) {
            this.mPlayerAudioFocusControl.setAudioFocusAtStartState();
        }
        if (!z) {
            boolean isDarkNotificationBar = NotificationColorUtils.isDarkNotificationBar(this.mAppCtx);
            XmNotificationCreater.getInstanse(this.mAppCtx).updateModelDetail(this.mListControl, this.mNotificationManager, this.mNotification, this.mNotificationId, isDarkNotificationBar);
            XmNotificationCreater.getInstanse(this.mAppCtx).updateViewStateAtPause(this.mNotificationManager, this.mNotification, this.mNotificationId, isDarkNotificationBar);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("play 6_0 mPlayerControl.resetMediaPlayer:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        this.mPlayerControl.resetMediaPlayer();
        if (playableModel instanceof Track) {
            final Track track = (Track) playableModel;
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            if (z) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("play 6:");
                stringBuilder2.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder2.toString());
                AnonymousClass6 anonymousClass6 = new PlayAdsCallback() {
                    public void onFinish(boolean z) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("play 7:");
                        stringBuilder.append(System.currentTimeMillis());
                        Logger.logToSd(stringBuilder.toString());
                        try {
                            if (XmPlayerService.this.isLossAudioFocus()) {
                                XmPlayerService.this.setLossAudioFocus(false);
                                XmPlayerService.this.playTrack(track, false);
                                if (XmPlayerService.this.mPlayerStatusListener != null) {
                                    XmPlayerService.this.mPlayerStatusListener.onPlayPause();
                                    return;
                                }
                                return;
                            }
                            XmPlayerService.this.playTrack(track, z);
                        } catch (Exception e) {
                            e.printStackTrace();
                            XmPlayerService.this.mLastModel = null;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("play 8:");
                            stringBuilder.append(System.currentTimeMillis());
                            Logger.logToSd(stringBuilder.toString());
                            String str = CdnConstants.PLAY_INFO;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("playAdsCallback:");
                            stringBuilder2.append(e.toString());
                            CdnUtil.statToXDCSError(str, stringBuilder2.toString());
                        }
                    }
                };
                if (this.isDLNAState || ((!BaseUtil.isMainApp() && "schedule".equals(playableModel.getKind())) || "radio".equals(playableModel.getKind()) || PlayableModel.KIND_LIVE_FLV.equals(playableModel.getKind()) || !z2)) {
                    this.mAdsManager.stopCurrentAdPlay();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("play 11:");
                    stringBuilder3.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder3.toString());
                    anonymousClass6.onFinish(true);
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("play 12:");
                    stringBuilder3.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder3.toString());
                    this.mAdsManager.playAds(track, i, anonymousClass6, false);
                }
            } else {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("play 9:");
                stringBuilder3.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder3.toString());
                try {
                    playTrack(track, false);
                } catch (Exception e) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("play 10:");
                    stringBuilder2.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder2.toString());
                    this.mLastModel = null;
                    e.printStackTrace();
                    String str = CdnConstants.PLAY_INFO;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("playTrack:");
                    stringBuilder4.append(e.toString());
                    CdnUtil.statToXDCSError(str, stringBuilder4.toString());
                }
            }
            return true;
        } else if (!(playableModel instanceof Radio)) {
            return false;
        } else {
            this.mPlayerControl.init(getRadioUrl((Radio) playableModel), 0);
            return true;
        }
    }

    private native void removeCheckIsPauseTime();

    private void saveLastPlayTrackInAlbum(Track track) {
        if (track != null && "track".equals(track.getKind()) && track.getAlbum() != null) {
            Editor edit = this.mPlayLastPlayTrackInAlbum.edit();
            Map all = this.mPlayLastPlayTrackInAlbum.getAll();
            if (all != null && all.size() > 500) {
                for (Entry entry : all.entrySet()) {
                    Object value = entry.getValue();
                    if (value != null) {
                        if (System.currentTimeMillis() - Long.parseLong(value.toString().split(this.mSeparator)[1]) > this.mMaxSaveTime) {
                            edit.remove((String) entry.getKey());
                        }
                    }
                }
            }
            if (track.getAlbum() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(track.getAlbum().getAlbumId());
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(new GsonBuilder().serializeSpecialFloatingPointValues().create().toJson(track));
                stringBuilder3.append(this.mSeparator);
                stringBuilder3.append(System.currentTimeMillis());
                edit.putString(stringBuilder2, stringBuilder3.toString());
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
        }
    }

    private native void sendPlayCompleteBroadCast();

    private native void sendPlayerPauseBroadCast();

    private native void sendPlayerStartBroadCast();

    private void setCustomCallBackErrData(String str, long j) {
        setMainDataSupportCallBackErrorData(str, j);
        if (this.mCustomDataCallBack != null) {
            int beginBroadcast = this.mCustomDataCallBack.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((IXmCustomDataCallBack) this.mCustomDataCallBack.getBroadcastItem(i)).onError(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mCustomDataCallBack.finishBroadcast();
        }
    }

    private void setCustomCallBackSuccessData(String str, int i, long j) {
        setMainDataSupportCallBackSuccessData(str, i, j);
        if (this.mCustomDataCallBack != null) {
            int beginBroadcast = this.mCustomDataCallBack.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                try {
                    ((IXmCustomDataCallBack) this.mCustomDataCallBack.getBroadcastItem(i2)).onSuccess(str, i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mCustomDataCallBack.finishBroadcast();
        }
    }

    private void setMainDataSupportCallBackErrorData(String str, long j) {
        if (this.mMainDataSupportCallbackList != null) {
            int beginBroadcast = this.mMainDataSupportCallbackList.beginBroadcast();
            for (int i = 0; i < beginBroadcast; i++) {
                try {
                    ((IXmMainDataSupportDataCallback) this.mMainDataSupportCallbackList.getBroadcastItem(i)).onError(str, j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mMainDataSupportCallbackList.finishBroadcast();
        }
    }

    private void setMainDataSupportCallBackSuccessData(String str, int i, long j) {
        if (this.mMainDataSupportCallbackList != null) {
            int beginBroadcast = this.mMainDataSupportCallbackList.beginBroadcast();
            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                try {
                    ((IXmMainDataSupportDataCallback) this.mMainDataSupportCallbackList.getBroadcastItem(i2)).onSuccess(str, i, j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.mMainDataSupportCallbackList.finishBroadcast();
        }
    }

    private void startCheckIsPauseTime() {
        if (this.mPauseTimeInMills > 0) {
            if (this.mCheckIsPauseTimeRunnable == null) {
                this.mCheckIsPauseTimeRunnable = new Runnable() {
                    public void run() {
                        XmPlayerService.this.checkIsPauseTime();
                        XmPlayerService.this.getTimeHander().postDelayed(XmPlayerService.this.mCheckIsPauseTimeRunnable, 500);
                    }
                };
            }
            getTimeHander().postDelayed(this.mCheckIsPauseTimeRunnable, 500);
        }
    }

    public void closeApp() {
        try {
            if (this.mIXmCommonBusinessDispatcher != null) {
                this.mIXmCommonBusinessDispatcher.closeApp();
            }
        } catch (RemoteException e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("close app ");
            stringBuilder.append(e.toString());
            Logger.i(str, stringBuilder.toString());
        }
        try {
            XmPlayerManager.unBind();
            XmPlayerManagerForPlayer.unBind();
            stopSelf();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (mService != null && !BaseUtil.isProcessRunning(this, "com.ximalaya.ting.android")) {
            Logger.i(TAG, "close app use stopself");
            try {
                stopSelf();
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
    }

    public native void closeNotification();

    public native String getCurPlayUrl();

    public native PlayableModel getCurrPlayModel();

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0044 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:23|24) */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            r0 = "";
     */
    public java.lang.String getDownloadUrl(com.ximalaya.ting.android.opensdk.model.track.Track r3) {
        /*
        r2 = this;
        r0 = r3.canPlayTrack();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r3 = "";
        return r3;
    L_0x0009:
        r0 = r3.getDownloadedSaveFilePath();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0023;
    L_0x0013:
        r1 = r2.mIXmCommonBusinessDispatcher;	 Catch:{ RemoteException -> 0x001f }
        if (r1 == 0) goto L_0x0023;
    L_0x0017:
        r1 = r2.mIXmCommonBusinessDispatcher;	 Catch:{ RemoteException -> 0x001f }
        r1 = r1.getDownloadPlayPath(r3);	 Catch:{ RemoteException -> 0x001f }
        r0 = r1;
        goto L_0x0023;
    L_0x001f:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0023:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x005f;
    L_0x0029:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x005b }
        r1.<init>(r0);	 Catch:{ Exception -> 0x005b }
        r1 = r1.exists();	 Catch:{ Exception -> 0x005b }
        if (r1 == 0) goto L_0x005f;
    L_0x0034:
        r1 = ".xm";
        r1 = r0.contains(r1);	 Catch:{ Exception -> 0x005b }
        if (r1 == 0) goto L_0x0046;
    L_0x003c:
        r0 = r2.mIXmCommonBusinessDispatcher;	 Catch:{ Throwable -> 0x0044 }
        r0.isOldTrackDownload(r3);	 Catch:{ Throwable -> 0x0044 }
        r3 = "null";
        return r3;
    L_0x0044:
        r0 = "";
    L_0x0046:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005b }
        r3.<init>();	 Catch:{ Exception -> 0x005b }
        r1 = "XmPlayerService:method=getTrackUrl:path=";
        r3.append(r1);	 Catch:{ Exception -> 0x005b }
        r3.append(r0);	 Catch:{ Exception -> 0x005b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x005b }
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r3);	 Catch:{ Exception -> 0x005b }
        return r0;
    L_0x005b:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x005f:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getDownloadUrl(com.ximalaya.ting.android.opensdk.model.track.Track):java.lang.String");
    }

    public int getDuration() {
        if (getPlayerImpl() != null) {
            try {
                return getPlayerImpl().getDuration();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public native XmPlayerControl getPlayControl();

    public int getPlayCurrPosition() {
        if (getPlayerImpl() != null) {
            try {
                return getPlayerImpl().getPlayCurrPosition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public native XmPlayListControl getPlayListControl();

    public native int getPlayListSize();

    public PlayMode getPlayMode() {
        return this.mListControl != null ? this.mListControl.getPlayMode() : PlayMode.PLAY_MODEL_LIST;
    }

    public native PlayableModel getPlayableModel();

    public XmPlayerImpl getPlayerImpl() {
        return this.mPlayerImpl;
    }

    public String getSoundHistoryPos(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                split[i] = String.valueOf(getSoundHistoryPos(Long.valueOf(split[i]).longValue()));
            }
            return TextUtils.join(",", split);
        } catch (Exception unused) {
            return null;
        }
    }

    public native Handler getTimeHander();

    public native String getTrackUrl(Track track);

    public PlayMode getXmPlayMode() {
        if (getPlayListControl() != null) {
            try {
                return getPlayListControl().getPlayMode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return PlayMode.PLAY_MODEL_LIST;
    }

    public native boolean isContinuePlay();

    public synchronized boolean isLossAudioFocus() {
        return this.isLossAudioFocus;
    }

    public native boolean isOnlineResource();

    public native boolean isPlaying();

    public native void notifProgress(int i, int i2);

    public native IBinder onBind(Intent intent);

    @SuppressLint({"NewApi"})
    public void onCreate() {
        super.onCreate();
        initPlayerService();
        Logger.i(TAG, "---onCreate");
    }

    public native void onDestroy();

    public native int onStartCommand(Intent intent, int i, int i2);

    public native boolean pausePlay();

    public native boolean play(int i);

    public native boolean play(int i, boolean z);

    public native boolean playCurrent();

    public native boolean playNext();

    public native void playPauseNoNotif();

    public native boolean playPre();

    @Deprecated
    public boolean playRadio(Radio radio) {
        this.mPlayerAudioFocusControl.setAudioFocusAtStartState();
        if (this.mPlayerConfig.isUseSystemPlayer() || radio == null) {
            return false;
        }
        try {
            if (radio.equals(this.mLastModel)) {
                return false;
            }
            this.mPlayerControl.stop();
            this.mListControl.setRadio(radio);
            this.mPlayerStatusListener.onSoundSwitch(this.mLastModel, radio);
            this.mPlayerControl.initAndPlay(getRadioUrl(radio), 0);
            this.mLastModel = radio;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public native void requestAudioFocusControl();

    @SuppressLint({"NewApi"})
    public void saveSoundHistoryPos(long j, int i) {
        if (j > 0) {
            Editor edit = this.mPlayHistory.edit();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(j);
            edit.putInt(stringBuilder.toString(), i);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
    }

    public void seekTo(int i) {
        if (getPlayerImpl() != null) {
            try {
                getPlayerImpl().seekTo(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void setLossAudioFocus(boolean z) {
        this.isLossAudioFocus = z;
    }

    public void setNotification() {
        if (!this.hasInitNotification) {
            this.hasInitNotification = true;
            Class cls = null;
            try {
                cls = Class.forName("com.ximalaya.ting.android.host.activity.MainActivity");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (cls != null) {
                Notification initNotification = XmNotificationCreater.getInstanse(mService.getApplicationContext()).initNotification(mService.getApplicationContext(), cls);
                if (initNotification != null) {
                    try {
                        if (mService != null) {
                            Logger.i(TAG, "setNotification");
                            mService.startForeground(16842960, initNotification);
                            this.mNotification = initNotification;
                            this.mNotificationId = 16842960;
                            if (!(this.mAppCtx == null || this.mListControl == null || this.mNotificationManager == null)) {
                                boolean isDarkNotificationBar = NotificationColorUtils.isDarkNotificationBar(this.mAppCtx);
                                XmNotificationCreater.getInstanse(this.mAppCtx).updateModelDetail(this.mListControl, this.mNotificationManager, this.mNotification, this.mNotificationId, isDarkNotificationBar);
                                XmNotificationCreater.getInstanse(this.mAppCtx).updateViewStateAtPause(this.mNotificationManager, this.mNotification, this.mNotificationId, isDarkNotificationBar);
                            }
                        }
                    } catch (Exception e2) {
                        String str = CdnConstants.PLAY_INFO;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("setNotification:");
                        stringBuilder.append(e2.toString());
                        CdnUtil.statToXDCSError(str, stringBuilder.toString());
                    }
                }
            }
        }
    }

    public void setPlayDataOutPutListener(OnPlayDataOutputListener onPlayDataOutputListener) {
        if (this.mPlayerControl != null) {
            this.mPlayerControl.setOnPlayDataOutputListener(onPlayDataOutputListener);
        }
        this.mOnPlayDataOutputListener = onPlayDataOutputListener;
    }

    public void setPlayList(Map<String, String> map, List<Track> list) {
        this.mListControl.setPlayList(map, list);
    }

    public void setPlayStartCallback(IPlayStartCallBack iPlayStartCallBack) {
        this.mPlayStartCallBack = iPlayStartCallBack;
    }

    public native void setSoundTouchAllParams(float f, float f2, float f3);

    public native void setVolume(float f, float f2);

    public native boolean startPlay();

    public native boolean startPlay(boolean z);

    public native boolean stopPlay();
}
