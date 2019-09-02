package com.ximalaya.ting.android.opensdk.player;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.constants.PreferenceConstantsInOpenSdk;
import com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$ITokenStateChange;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.live.program.Program;
import com.ximalaya.ting.android.opensdk.model.live.radio.Radio;
import com.ximalaya.ting.android.opensdk.model.live.schedule.Schedule;
import com.ximalaya.ting.android.opensdk.model.live.schedule.ScheduleList;
import com.ximalaya.ting.android.opensdk.model.statistic.RecordModel;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.model.track.CommonTrackList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.ximalaya.ting.android.opensdk.player.advertis.IXmAdsStatusListener;
import com.ximalaya.ting.android.opensdk.player.advertis.OpenSdkAdsDataHandler;
import com.ximalaya.ting.android.opensdk.player.constants.PlayerConstants;
import com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher.Stub;
import com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessHandle;
import com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayer;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerStatusListener;
import com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerException;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.player.statistic.OpenSdkPlayStatisticUpload;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.ModelUtil;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.ximalaya.ting.android.player.PlayerUtil;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.yalantis.ucrop.view.CropImageView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class XmPlayerManager {
    private static final int MSG_ADS_BUFFERING_START = 14;
    private static final int MSG_ADS_BUFFERING_STOP = 15;
    private static final int MSG_BUFFER_PROGRESS_CHANGE = 9;
    private static final int MSG_BUFFER_STATUS_CHANGE = 6;
    private static final int MSG_CLOSE_APP = 20;
    private static final int MSG_COMPLETE_PLAY_ADS = 17;
    private static final int MSG_GET_ADS_INFO = 13;
    private static final int MSG_OLD_CHARGE_TRACK_NEED_REDOWNLOAD = 19;
    private static final int MSG_PLAY_ADS_ERROR = 18;
    private static final int MSG_PLAY_COMPLETE = 4;
    private static final int MSG_PLAY_ERROR = 10;
    private static final int MSG_PLAY_PAUSE = 2;
    private static final int MSG_PLAY_START = 1;
    private static final int MSG_PLAY_STOP = 3;
    private static final int MSG_PROGRESS_CHANGE = 7;
    private static final int MSG_SOUND_CHANGE = 8;
    private static final int MSG_SOUND_PREPARED = 5;
    private static final int MSG_START_GET_ADS_INFO = 12;
    private static final int MSG_START_PLAY_ADS = 16;
    private static final String TAG = "XmPlayerServiceManager";
    private static int mEnvironment = 1;
    private static Config sHttpConfig = null;
    private static volatile XmPlayerManager sInstance = null;
    private static byte[] sLock = new byte[0];
    private static int sPageSize = 20;
    private boolean checkAdContent;
    private Stub mAdsListenerStub = new Stub() {
        public void onAdsStartBuffering() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(14).sendToTarget();
        }

        public void onAdsStopBuffering() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(15).sendToTarget();
        }

        public void onCompletePlayAds() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(17).sendToTarget();
        }

        public void onError(int i, int i2) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(18);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            obtainMessage.sendToTarget();
        }

        public void onGetAdsInfo(AdvertisList advertisList) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(13);
            obtainMessage.obj = advertisList;
            obtainMessage.sendToTarget();
        }

        public void onStartGetAdsInfo() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(12).sendToTarget();
        }

        public void onStartPlayAds(Advertis advertis, int i) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(16);
            obtainMessage.arg1 = i;
            obtainMessage.obj = advertis;
            obtainMessage.sendToTarget();
        }
    };
    private List<IXmAdsStatusListener> mAdsStatusListeners = new CopyOnWriteArrayList();
    private Context mAppCtx;
    private boolean mBindRet = false;
    private List<Track> mCachedPlayList;
    private ServiceConnection mConn = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                String str = XmPlayerManager.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onServiceConnected progress:");
                stringBuilder.append(Process.myPid());
                Logger.i(str, stringBuilder.toString());
                boolean z = true;
                XmPlayerManager.this.mConnected = true;
                XmPlayerManager.this.mBindRet = true;
                XmPlayerManager.this.mPlayerStub = IXmPlayer.Stub.asInterface(iBinder);
                XmPlayerManager.this.mPlayerStub.registePlayerListener(XmPlayerManager.this.mListenerStub);
                XmPlayerManager.this.mPlayerStub.registeAdsListener(XmPlayerManager.this.mAdsListenerStub);
                if (BaseUtil.isMainProcess(XmPlayerManager.this.mAppCtx)) {
                    XmPlayerManager.this.mPlayerStub.setPlayerProcessRequestEnvironment(XmPlayerManager.mEnvironment);
                    XmPlayerManager.this.mPlayerStub.registeCommonBusinessListener(XmPlayerManager.this.mIXmCommonBusinessDispatcherStub);
                    XmPlayerManager.this.mPlayerStub.setPlayListChangeListener(XmPlayerManager.this.mDataCallbackSub);
                    if (XmPlayerManager.this.mNotification != null) {
                        XmPlayerManager.this.mPlayerStub.setNotification(XmPlayerManager.this.mNotificationId, XmPlayerManager.this.mNotification);
                    }
                }
                if (!(TextUtils.isEmpty(CommonRequest.getInstanse().getAppsecret()) || BaseUtil.isMainApp() || !BaseUtil.isMainProcess(XmPlayerManager.this.mAppCtx))) {
                    if (CommonRequest.getInstanse().getITokenStateChange() != null) {
                        XmPlayerManager.this.mPlayerStub.setTokenInvalidForSDK(XmPlayerManager.this.mTokenInvalidForSDKCallBackStub);
                    }
                    XmPlayerManager.this.mPlayerStub.setAppSecret(CommonRequest.getInstanse().getAppsecret());
                    XmPlayerManager.this.mPlayerStub.setAppkeyAndPackId(CommonRequest.getInstanse().getAppKey(), CommonRequest.getInstanse().getPackId());
                    XmPlayerManager.this.mPlayerStub.setTokenToPlayForSDK(AccessTokenManager.getInstanse().getTokenModel());
                }
                if (!BaseUtil.isMainApp() && BaseUtil.isMainProcess(XmPlayerManager.this.mAppCtx)) {
                    XmPlayerManager.this.mPlayerStub.setAdsDataHandlerClassName(OpenSdkAdsDataHandler.class.getName());
                    XmPlayerManager.this.mPlayerStub.setPlayStatisticClassName(OpenSdkPlayStatisticUpload.class.getName());
                }
                XmPlayerManager.this.setPlayerProxy();
                XmPlayerManager.this.setDefaultPageSize();
                Logger.i(XmPlayerManager.TAG, "onServiceConnected123");
                for (IConnectListener iConnectListener : XmPlayerManager.this.mConnectListenerSet) {
                    if (iConnectListener != null) {
                        iConnectListener.onConnected();
                    }
                }
                if (XmPlayerManager.this.mConnectListener != null) {
                    XmPlayerManager.this.mConnectListener.onConnected();
                }
                XmPlayerManager.this.mCurModel = XmPlayerManager.this.mPlayerStub.getTrack(XmPlayerManager.this.mPlayerStub.getCurrIndex());
                boolean access$1700 = XmPlayerManager.this.checkAdContent;
                if (ConstantsOpenSdk.isDebug) {
                    if (!SharedPreferencesUtil.getInstance(XmPlayerManager.this.mAppCtx).getBoolean(PreferenceConstantsInOpenSdk.TINGMAIN_KEY_USE_CHECK_AD_CONTENT, true) || !XmPlayerManager.this.checkAdContent) {
                        z = false;
                    }
                    access$1700 = z;
                }
                XmPlayerManager.this.mPlayerStub.setCheckAdContent(access$1700);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.i(XmPlayerManager.TAG, "onServiceDisconnected");
            XmPlayerManager.this.mConnected = false;
            XmPlayerManager.this.mBindRet = false;
            XmPlayerManager.this.init(XmPlayerManager.this.mNotificationId, XmPlayerManager.this.mNotification);
        }
    };
    private IConnectListener mConnectListener;
    private Set<IConnectListener> mConnectListenerSet = new HashSet();
    private boolean mConnected = false;
    private PlayableModel mCurModel;
    private IXmDataCallback mDataCallback;
    private IXmDataCallback.Stub mDataCallbackSub = new IXmDataCallback.Stub() {
        public void onDataReady(List<Track> list, boolean z, boolean z2) throws RemoteException {
            if (XmPlayerManager.this.mDataCallback != null) {
                XmPlayerManager.this.mDataCallback.onDataReady(list, z, z2);
            }
        }

        public void onError(int i, String str, boolean z) throws RemoteException {
            if (XmPlayerManager.this.mDataCallback != null) {
                XmPlayerManager.this.mDataCallback.onError(i, str, z);
            }
        }
    };
    private IXmCommonBusinessDispatcher.Stub mIXmCommonBusinessDispatcherStub = new IXmCommonBusinessDispatcher.Stub() {
        public void closeApp() throws RemoteException {
            XmPlayerManager.this.mUiHandler.removeCallbacksAndMessages(null);
            XmPlayerManager.this.mUiHandler.obtainMessage(20).sendToTarget();
        }

        public String getDownloadPlayPath(Track track) throws RemoteException {
            return XmPlayerManager.this.mIXmCommonBusinessHandle != null ? XmPlayerManager.this.mIXmCommonBusinessHandle.getDownloadPlayPath(track) : null;
        }

        public void isOldTrackDownload(Track track) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(19);
            obtainMessage.obj = track;
            obtainMessage.sendToTarget();
        }
    };
    private IXmCommonBusinessHandle mIXmCommonBusinessHandle;
    private IXmPlayerEventDispatcher.Stub mListenerStub = new IXmPlayerEventDispatcher.Stub() {
        public void onBufferProgress(int i) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(9);
            obtainMessage.arg1 = i;
            obtainMessage.sendToTarget();
        }

        public void onBufferingStart() throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(6);
            obtainMessage.obj = Boolean.valueOf(true);
            obtainMessage.sendToTarget();
        }

        public void onBufferingStop() throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(6);
            obtainMessage.obj = Boolean.valueOf(false);
            obtainMessage.sendToTarget();
        }

        public void onError(XmPlayerException xmPlayerException) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(10);
            obtainMessage.obj = xmPlayerException;
            obtainMessage.sendToTarget();
        }

        public void onPlayPause() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(2).sendToTarget();
        }

        public void onPlayProgress(int i, int i2) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(7);
            obtainMessage.arg1 = i;
            obtainMessage.arg2 = i2;
            obtainMessage.sendToTarget();
        }

        public void onPlayStart() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(1).sendToTarget();
        }

        public void onPlayStop() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(3).sendToTarget();
        }

        public void onSoundPlayComplete() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(4).sendToTarget();
        }

        public void onSoundPrepared() throws RemoteException {
            XmPlayerManager.this.mUiHandler.obtainMessage(5).sendToTarget();
        }

        public void onSoundSwitch(Track track, Track track2) throws RemoteException {
            Message obtainMessage = XmPlayerManager.this.mUiHandler.obtainMessage(8);
            obtainMessage.obj = new Object[]{track, track2};
            obtainMessage.sendToTarget();
        }
    };
    private Notification mNotification;
    private int mNotificationId = 0;
    private List<IXmPlayerStatusListener> mPlayerStatusListeners = new CopyOnWriteArrayList();
    private IXmPlayer mPlayerStub;
    private IXmTokenInvalidForSDKCallBack.Stub mTokenInvalidForSDKCallBackStub = new IXmTokenInvalidForSDKCallBack.Stub() {
        public void tokenInvalid() throws RemoteException {
            CommonRequest$ITokenStateChange iTokenStateChange = CommonRequest.getInstanse().getITokenStateChange();
            if (iTokenStateChange == null) {
                AccessTokenManager.getInstanse().update();
            } else if (!iTokenStateChange.getTokenByRefreshAsync()) {
                iTokenStateChange.tokenLosted();
            }
        }
    };
    private UIHandler mUiHandler;
    private int mVideoAdState = 0;

    public interface IConnectListener {
        void onConnected();
    }

    private class UIHandler extends Handler {
        public UIHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    XmPlayerManager.this.handlePlayStart();
                    return;
                case 2:
                    XmPlayerManager.this.handlePlayPause();
                    return;
                case 3:
                    XmPlayerManager.this.handlePlayStop();
                    return;
                case 4:
                    XmPlayerManager.this.handlePlayComplete();
                    return;
                case 5:
                    XmPlayerManager.this.handleSoundPrepared();
                    return;
                case 6:
                    if (message.obj instanceof Boolean) {
                        XmPlayerManager.this.handleBufferStatusChange(((Boolean) message.obj).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    XmPlayerManager.this.handlePlayProgressChange(message.arg1, message.arg2);
                    return;
                case 8:
                    Object[] objArr = (Object[]) message.obj;
                    XmPlayerManager.this.handleSoundChange((PlayableModel) objArr[0], (PlayableModel) objArr[1]);
                    return;
                case 9:
                    XmPlayerManager.this.handleBufferChange(message.arg1);
                    return;
                case 10:
                    XmPlayerManager.this.handlePlayError((XmPlayerException) message.obj);
                    return;
                case 12:
                    XmPlayerManager.this.handleStartGetAdsInfo();
                    return;
                case 13:
                    XmPlayerManager.this.handleGetAdsInfo((AdvertisList) message.obj);
                    return;
                case 14:
                    XmPlayerManager.this.handleAdsBufferingStart();
                    return;
                case 15:
                    XmPlayerManager.this.handleAdsBufferingStop();
                    return;
                case 16:
                    XmPlayerManager.this.handleStartPlayAds((Advertis) message.obj, message.arg1);
                    return;
                case 17:
                    XmPlayerManager.this.handleCompletePlayAds();
                    return;
                case 18:
                    XmPlayerManager.this.handlePlayAdsError(message.arg1, message.arg2);
                    return;
                case 19:
                    XmPlayerManager.this.handleOldChargeTrackNeedRedownload((Track) message.obj);
                    return;
                case 20:
                    XmPlayerManager.this.handleCloseApp();
                    return;
                default:
                    return;
            }
        }
    }

    private XmPlayerManager(Context context) {
        this.mAppCtx = context.getApplicationContext();
        this.mUiHandler = new UIHandler(Looper.getMainLooper());
        XMediaPlayerConstants.resetCacheDir(this.mAppCtx);
    }

    private boolean checkConnectionStatus() {
        if (this.mConnected && this.mPlayerStub != null && this.mPlayerStub.asBinder() != null && this.mPlayerStub.asBinder().isBinderAlive()) {
            return true;
        }
        Logger.i(TAG, "checkConnectionStatus disconnected");
        init(this.mNotificationId, this.mNotification);
        return false;
    }

    public static XmPlayerManager getInstance(Context context) {
        if (ConstantsOpenSdk.isDebug) {
            Context context2 = (context != null || sInstance == null) ? context : sInstance.mAppCtx;
            if (!(context2 == null || BaseUtil.isMainProcess(context2) || !BaseUtil.isMainApp())) {
                Thread.dumpStack();
                throw new RuntimeException("only main process can use this method");
            }
        }
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new XmPlayerManager(context);
                }
            }
        }
        return sInstance;
    }

    public static long getPlayCacheSize() {
        return PlayerUtil.getPlayCacheSize();
    }

    private void handleAdsBufferingStart() {
        for (IXmAdsStatusListener onAdsStartBuffering : this.mAdsStatusListeners) {
            onAdsStartBuffering.onAdsStartBuffering();
        }
    }

    private void handleAdsBufferingStop() {
        for (IXmAdsStatusListener onAdsStopBuffering : this.mAdsStatusListeners) {
            onAdsStopBuffering.onAdsStopBuffering();
        }
    }

    private void handleBufferChange(int i) {
        for (IXmPlayerStatusListener onBufferProgress : this.mPlayerStatusListeners) {
            onBufferProgress.onBufferProgress(i);
        }
    }

    private void handleBufferStatusChange(boolean z) {
        for (IXmPlayerStatusListener iXmPlayerStatusListener : this.mPlayerStatusListeners) {
            if (z) {
                iXmPlayerStatusListener.onBufferingStart();
            } else {
                iXmPlayerStatusListener.onBufferingStop();
            }
        }
    }

    private void handleCloseApp() {
        if (this.mIXmCommonBusinessHandle != null) {
            this.mIXmCommonBusinessHandle.closeApp();
        }
    }

    private void handleCompletePlayAds() {
        for (IXmAdsStatusListener onCompletePlayAds : this.mAdsStatusListeners) {
            onCompletePlayAds.onCompletePlayAds();
        }
    }

    private void handleGetAdsInfo(AdvertisList advertisList) {
        for (IXmAdsStatusListener onGetAdsInfo : this.mAdsStatusListeners) {
            onGetAdsInfo.onGetAdsInfo(advertisList);
        }
    }

    private void handleOldChargeTrackNeedRedownload(Track track) {
        if (this.mIXmCommonBusinessHandle != null) {
            this.mIXmCommonBusinessHandle.isOldTrackDownload(track);
        }
    }

    private void handlePlayAdsError(int i, int i2) {
        for (IXmAdsStatusListener onError : this.mAdsStatusListeners) {
            onError.onError(i, i2);
        }
    }

    private void handlePlayComplete() {
        for (IXmPlayerStatusListener onSoundPlayComplete : this.mPlayerStatusListeners) {
            onSoundPlayComplete.onSoundPlayComplete();
        }
    }

    private void handlePlayError(XmPlayerException xmPlayerException) {
        for (IXmPlayerStatusListener onError : this.mPlayerStatusListeners) {
            onError.onError(xmPlayerException);
        }
    }

    private void handlePlayPause() {
        for (IXmPlayerStatusListener onPlayPause : this.mPlayerStatusListeners) {
            onPlayPause.onPlayPause();
        }
    }

    private void handlePlayProgressChange(int i, int i2) {
        for (IXmPlayerStatusListener onPlayProgress : this.mPlayerStatusListeners) {
            onPlayProgress.onPlayProgress(i, i2);
        }
    }

    private void handlePlayStart() {
        for (IXmPlayerStatusListener onPlayStart : this.mPlayerStatusListeners) {
            onPlayStart.onPlayStart();
        }
    }

    private void handlePlayStop() {
        for (IXmPlayerStatusListener onPlayStop : this.mPlayerStatusListeners) {
            onPlayStop.onPlayStop();
        }
    }

    private void handleSoundChange(PlayableModel playableModel, PlayableModel playableModel2) {
        this.mCurModel = playableModel2;
        for (IXmPlayerStatusListener onSoundSwitch : this.mPlayerStatusListeners) {
            onSoundSwitch.onSoundSwitch(playableModel, playableModel2);
        }
    }

    private void handleSoundPrepared() {
        for (IXmPlayerStatusListener onSoundPrepared : this.mPlayerStatusListeners) {
            onSoundPrepared.onSoundPrepared();
        }
    }

    private void handleStartGetAdsInfo() {
        for (IXmAdsStatusListener onStartGetAdsInfo : this.mAdsStatusListeners) {
            onStartGetAdsInfo.onStartGetAdsInfo();
        }
    }

    private void handleStartPlayAds(Advertis advertis, int i) {
        for (IXmAdsStatusListener onStartPlayAds : this.mAdsStatusListeners) {
            onStartPlayAds.onStartPlayAds(advertis, i);
        }
    }

    private boolean isConnectedStatus() {
        return this.mConnected && this.mPlayerStub != null && this.mPlayerStub.asBinder() != null && this.mPlayerStub.asBinder().isBinderAlive();
    }

    public static void release() {
        Logger.i(TAG, "release");
        if (sInstance != null) {
            sInstance.pause();
            sInstance.stop();
            if (sInstance.mBindRet || !(sInstance.mPlayerStub == null || sInstance.mPlayerStub.asBinder() == null || !sInstance.mPlayerStub.asBinder().isBinderAlive())) {
                sInstance.mAppCtx.unbindService(sInstance.mConn);
                sInstance.mBindRet = false;
            }
            sInstance.mAppCtx.stopService(XmPlayerService.getIntent(sInstance.mAppCtx));
            sInstance.mNotification = null;
            sInstance.mPlayerStatusListeners.clear();
            sInstance.mAdsStatusListeners.clear();
            sInstance.mConnectListenerSet.clear();
            sInstance.mConnectListener = null;
            sInstance.mCurModel = null;
            sInstance.mConnected = false;
            sInstance.mPlayerStub = null;
        }
    }

    private void setDefaultPageSize() throws RemoteException {
        if (checkConnectionStatus() && this.mPlayerStub != null) {
            this.mPlayerStub.setPageSize(sPageSize);
        }
    }

    private void setPlayList(Map<String, String> map, List<Track> list, int i, boolean z) {
        if (checkConnectionStatus() && list != null) {
            try {
                int size = list.size();
                if (size < 30) {
                    this.mPlayerStub.setPlayList(map, list);
                } else {
                    for (int i2 = 0; i2 < size / 30; i2++) {
                        if (i2 == 0) {
                            this.mPlayerStub.setPlayList(map, list.subList(i2 * 30, (i2 + 1) * 30));
                        } else {
                            this.mPlayerStub.addPlayList(list.subList(i2 * 30, (i2 + 1) * 30));
                        }
                    }
                    int i3 = size % 30;
                    if (i3 != 0) {
                        int i4 = 30 * (size / 30);
                        this.mPlayerStub.addPlayList(list.subList(i4, i3 + i4));
                    }
                }
                if (z) {
                    this.mPlayerStub.play(i);
                } else {
                    this.mPlayerStub.setPlayIndex(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setPlayerProcessRequestEnvironment(int i) {
        if (sInstance == null) {
            mEnvironment = i;
        } else if (sInstance.isConnectedStatus()) {
            try {
                sInstance.mPlayerStub.setPlayerProcessRequestEnvironment(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setPlayerProxy() throws RemoteException {
        if (this.mPlayerStub != null) {
            this.mPlayerStub.setProxyNew(sHttpConfig);
        }
    }

    private PlayableModel trackToOther(Track track) {
        if (!checkConnectionStatus()) {
            return null;
        }
        int i = -1;
        try {
            i = this.mPlayerStub.getPlaySourceType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (track != null) {
            if (i == 2) {
                return (track == null || !"schedule".equals(track.getKind())) ? track : ModelUtil.trackToSchedule(track);
            } else {
                if (i == 3) {
                    if ("radio".equals(track.getKind())) {
                        return ModelUtil.trackToRadio(track);
                    }
                    if ("schedule".equals(track.getKind())) {
                        return ModelUtil.trackToSchedule(track);
                    }
                }
            }
        }
        return null;
    }

    public static void unBind() {
        Logger.i(TAG, "unBind release");
        if (sInstance != null) {
            if (sInstance.mBindRet || !(sInstance.mPlayerStub == null || sInstance.mPlayerStub.asBinder() == null || !sInstance.mPlayerStub.asBinder().isBinderAlive())) {
                sInstance.mAppCtx.unbindService(sInstance.mConn);
                sInstance.mBindRet = false;
            }
            sInstance.mNotification = null;
            sInstance.mPlayerStatusListeners.clear();
            sInstance.mAdsStatusListeners.clear();
            sInstance.mConnectListenerSet.clear();
            sInstance.mConnectListener = null;
            sInstance.mCurModel = null;
            sInstance.mConnected = false;
            sInstance.mPlayerStub = null;
            sInstance = null;
        }
    }

    public void addAdsStatusListener(IXmAdsStatusListener iXmAdsStatusListener) {
        if (iXmAdsStatusListener != null && !this.mAdsStatusListeners.contains(iXmAdsStatusListener)) {
            this.mAdsStatusListeners.add(iXmAdsStatusListener);
        }
    }

    public void addOnConnectedListerner(IConnectListener iConnectListener) {
        this.mConnectListenerSet.add(iConnectListener);
    }

    public void addPlayerStatusListener(IXmPlayerStatusListener iXmPlayerStatusListener) {
        if (iXmPlayerStatusListener != null && !this.mPlayerStatusListeners.contains(iXmPlayerStatusListener)) {
            this.mPlayerStatusListeners.add(iXmPlayerStatusListener);
        }
    }

    public void addTracksToPlayList(List<Track> list) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.addPlayList(list);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void clearPlayCache() {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.clearPlayCache();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean containPlayerStatusListener(IXmPlayerStatusListener iXmPlayerStatusListener) {
        return this.mPlayerStatusListeners.contains(iXmPlayerStatusListener);
    }

    public void deleteWeikeTrackInPlayList(String str) {
        if (!checkConnectionStatus()) {
        }
    }

    public CommonTrackList getCommonTrackList() {
        if (!isConnectedStatus()) {
            return null;
        }
        try {
            CommonTrackList commonTrackList = new CommonTrackList();
            commonTrackList.setParams(this.mPlayerStub.getParam());
            commonTrackList.setTracks(getPlayList());
            return commonTrackList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCurPlayUrl() {
        if (!isConnectedStatus()) {
            return null;
        }
        try {
            return this.mPlayerStub.getCurPlayUrl();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCurrPlayType() {
        if (!isConnectedStatus()) {
            return -1;
        }
        try {
            return this.mPlayerStub.getPlaySourceType();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public PlayableModel getCurrSound() {
        return getCurrSound(true);
    }

    public PlayableModel getCurrSound(boolean z) {
        if (!isConnectedStatus()) {
            return null;
        }
        if (this.mCurModel != null && z) {
            return trackToOther((Track) this.mCurModel);
        }
        try {
            return trackToOther(this.mPlayerStub.getTrack(this.mPlayerStub.getCurrIndex()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Track getCurrSoundIgnoreKind(boolean z) {
        if (!isConnectedStatus()) {
            return null;
        }
        if (this.mCurModel != null && z) {
            return (Track) this.mCurModel;
        }
        try {
            return this.mPlayerStub.getTrack(this.mPlayerStub.getCurrIndex());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PlayableModel getCurrWeikeSound(boolean z) {
        if (!isConnectedStatus()) {
            return null;
        }
        if (this.mCurModel != null && z) {
            PlayableModel playableModel = this.mCurModel;
        }
        try {
            Track track = this.mPlayerStub.getTrack(this.mPlayerStub.getCurrIndex());
            return (track == null || !track.isWeikeTrack) ? null : track;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCurrentIndex() {
        if (!isConnectedStatus()) {
            return -1;
        }
        try {
            return this.mPlayerStub.getCurrIndex();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public long getCurrentTrackPlayedDuration() {
        if (!checkConnectionStatus()) {
            return 0;
        }
        try {
            return this.mPlayerStub.getCurrentTrackPlayedDuration();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int getDuration() {
        if (!isConnectedStatus()) {
            return 0;
        }
        try {
            return this.mPlayerStub.getDuration();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getHistoryPos(long j) {
        if (!isConnectedStatus()) {
            return -1;
        }
        try {
            String historyPos = this.mPlayerStub.getHistoryPos(String.valueOf(j));
            if (TextUtils.isEmpty(historyPos)) {
                return -1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("XmPlayerManager HistoryPos result:");
            stringBuilder.append(historyPos);
            Logger.log(stringBuilder.toString());
            return Integer.parseInt(historyPos);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void getNextPlayList() {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.getNextPlayList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getPlayCurrPositon() {
        if (!isConnectedStatus()) {
            return 0;
        }
        int playCurrPosition;
        try {
            playCurrPosition = this.mPlayerStub.getPlayCurrPosition();
        } catch (Exception e) {
            e.printStackTrace();
            playCurrPosition = 0;
        }
        return playCurrPosition;
    }

    public List<Track> getPlayList() {
        if (!isConnectedStatus()) {
            return null;
        }
        this.mCachedPlayList = new ArrayList();
        int i = 0;
        while (true) {
            try {
                List playList = this.mPlayerStub.getPlayList(i);
                if (playList == null) {
                    return this.mCachedPlayList;
                }
                this.mCachedPlayList.addAll(playList);
                if (playList.size() < 30) {
                    return this.mCachedPlayList;
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return this.mCachedPlayList;
            }
        }
    }

    public boolean getPlayListOrder() {
        if (!isConnectedStatus()) {
            return true;
        }
        try {
            return this.mPlayerStub.getPlayListOrder();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public Map<String, String> getPlayListParams() {
        if (!checkConnectionStatus()) {
            return null;
        }
        try {
            return this.mPlayerStub.getParam();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int getPlayListSize() {
        if (!isConnectedStatus()) {
            return 0;
        }
        try {
            return this.mPlayerStub.getPlayListSize();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public PlayMode getPlayMode() {
        if (!isConnectedStatus()) {
            return PlayMode.PLAY_MODEL_LIST;
        }
        try {
            return PlayMode.valueOf(this.mPlayerStub.getPlayMode());
        } catch (Exception e) {
            e.printStackTrace();
            return PlayMode.PLAY_MODEL_LIST;
        }
    }

    public int getPlayerStatus() {
        if (!isConnectedStatus()) {
            return 7;
        }
        try {
            return this.mPlayerStub.getPlayerStatus();
        } catch (Exception e) {
            e.printStackTrace();
            return 7;
        }
    }

    public void getPrePlayList() {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.getPrePlayList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public float getTempo() {
        if (!checkConnectionStatus()) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        try {
            return this.mPlayerStub.getTempo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return CropImageView.DEFAULT_ASPECT_RATIO;
        } catch (Exception e2) {
            e2.printStackTrace();
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    public Track getTrack(int i) {
        if (!isConnectedStatus()) {
            return null;
        }
        try {
            return this.mPlayerStub.getTrack(i);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getVideoAdState() {
        return this.mVideoAdState;
    }

    public boolean hasNextPlayList() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.haveNextPlayList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hasNextSound() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.hasNextSound();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean hasPrePlayList() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.havePrePlayList();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hasPreSound() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.hasPreSound();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void init() {
        try {
            this.mAppCtx.startService(XmPlayerService.getIntent(this.mAppCtx));
            this.mBindRet = this.mAppCtx.bindService(XmPlayerService.getIntent(this.mAppCtx), this.mConn, 1);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bind ret ");
            stringBuilder.append(this.mBindRet);
            Logger.i(str, stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(int i, Notification notification) {
        if (BaseUtil.isMainApp()) {
            init();
            return;
        }
        this.mNotificationId = i;
        this.mNotification = notification;
        init();
        if (this.mConnected && this.mPlayerStub != null && this.mPlayerStub.asBinder() != null && this.mPlayerStub.asBinder().isBinderAlive()) {
            try {
                this.mPlayerStub.setNotification(this.mNotificationId, this.mNotification);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void insertTracksToPlayListHead(List<Track> list) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.insertPlayListHead(list);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean isAdPlaying() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mVideoAdState == 2 ? true : this.mPlayerStub.isAdPlaying();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAdsActive() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            if (this.mVideoAdState != 2) {
                if (this.mVideoAdState != 0) {
                    return this.mPlayerStub.isAdsActive();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isBuffering() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.isBuffering();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isConnected() {
        return this.mConnected;
    }

    public boolean isDLNAState() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.isDLNAState();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isLoading() {
        if (!checkConnectionStatus()) {
            return false;
        }
        try {
            if (this.mVideoAdState != 2) {
                if (this.mVideoAdState != 3) {
                    return this.mPlayerStub.isLoading();
                }
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isOnlineSource() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.isOnlineSource();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isPlaying() {
        if (!isConnectedStatus()) {
            return false;
        }
        try {
            return this.mVideoAdState == 2 ? true : this.mPlayerStub.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void needContinuePlay(boolean z) {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.needContinuePlay(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        if (checkConnectionStatus()) {
            try {
                if (this.mVideoAdState == 2) {
                    LocalBroadcastManager.getInstance(this.mAppCtx).sendBroadcast(new Intent(PlayerConstants.ACTION_PAUSE_VIDEO_AD));
                } else {
                    this.mPlayerStub.pausePlay();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void pausePlayInMillis(long j) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.pausePlayInMillis(j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean permutePlayList() {
        if (!checkConnectionStatus()) {
            return false;
        }
        try {
            return this.mPlayerStub.permutePlayList();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void play() {
        if (checkConnectionStatus()) {
            try {
                if (this.mVideoAdState == 3) {
                    LocalBroadcastManager.getInstance(this.mAppCtx).sendBroadcast(new Intent(PlayerConstants.ACTION_PLAY_VIDEO_AD));
                } else {
                    this.mPlayerStub.startPlay();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void play(int i) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.play(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean playActivityRadio(Radio radio) {
        if (!checkConnectionStatus() || radio == null) {
            return false;
        }
        CommonTrackList commonTrackList = new CommonTrackList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ModelUtil.radioToTrack(radio, true));
        commonTrackList.setTracks(arrayList);
        commonTrackList.setTotalCount(1);
        commonTrackList.setTotalPage(1);
        playList(commonTrackList, 0);
        return true;
    }

    public void playList(CommonTrackList commonTrackList, int i) {
        if (checkConnectionStatus() && commonTrackList != null && commonTrackList.getTracks() != null && commonTrackList.getTracks().size() != 0) {
            setPlayList(commonTrackList.getParams(), commonTrackList.getTracks(), i, true);
        }
    }

    public void playList(List<Track> list, int i) {
        if (!checkConnectionStatus()) {
            return;
        }
        if (list == null || list.size() == 0) {
            Logger.i(TAG, "Empty TrackList");
        } else {
            setPlayList(null, list, i, true);
        }
    }

    public void playLiveRadioForSDK(Radio radio, int i, int i2) {
        if (checkConnectionStatus() && radio != null) {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(radio.getDataId());
            stringBuilder.append("");
            hashMap.put("radio_id", stringBuilder.toString());
            if (i >= 0) {
                String str = DTransferConstants.WEEKDAY;
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("");
                hashMap.put(str, stringBuilder.toString());
            }
            final boolean z = i == Calendar.getInstance().get(7) - 1;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy:MM:dd");
            Calendar instance = Calendar.getInstance();
            if (i >= 0) {
                instance.set(7, i + 1);
            }
            final String format = simpleDateFormat.format(instance.getTime());
            final Radio radio2 = radio;
            final int i3 = i2;
            CommonRequest.getSchedules(hashMap, new IDataCallBack<ScheduleList>() {
                public void onError(int i, String str) {
                }

                public void onSuccess(ScheduleList scheduleList) {
                    if (XmPlayerManager.this.checkConnectionStatus() && scheduleList != null) {
                        ArrayList arrayList = new ArrayList();
                        if (scheduleList.getmScheduleList() == null || scheduleList.getmScheduleList().isEmpty()) {
                            Schedule radioToSchedule = ModelUtil.radioToSchedule(radio2);
                            if (radioToSchedule != null) {
                                arrayList.add(radioToSchedule);
                                XmPlayerManager.this.playSchedule(arrayList, -1);
                            } else {
                                return;
                            }
                        }
                        List<Schedule> list = scheduleList.getmScheduleList();
                        for (Schedule schedule : list) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(format);
                            stringBuilder.append(":");
                            stringBuilder.append(schedule.getStartTime());
                            schedule.setStartTime(stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(format);
                            stringBuilder.append(":");
                            stringBuilder.append(schedule.getEndTime());
                            schedule.setEndTime(stringBuilder.toString());
                            Program relatedProgram = schedule.getRelatedProgram();
                            if (relatedProgram == null) {
                                relatedProgram = new Program();
                                schedule.setRelatedProgram(relatedProgram);
                            }
                            relatedProgram.setBackPicUrl(radio2.getCoverUrlLarge());
                            schedule.setRadioId(radio2.getDataId());
                            schedule.setRadioName(radio2.getRadioName());
                            schedule.setRadioPlayCount(radio2.getRadioPlayCount());
                            if (z) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(schedule.getStartTime());
                                stringBuilder2.append("-");
                                stringBuilder2.append(schedule.getEndTime());
                                if (BaseUtil.isInTime(stringBuilder2.toString()) == 0) {
                                    relatedProgram.setRate24AacUrl(radio2.getRate24AacUrl());
                                    relatedProgram.setRate24TsUrl(radio2.getRate24TsUrl());
                                    relatedProgram.setRate64AacUrl(radio2.getRate64AacUrl());
                                    relatedProgram.setRate64TsUrl(radio2.getRate64TsUrl());
                                    break;
                                }
                            }
                        }
                        XmPlayerManager.this.playSchedule(list, i3);
                    }
                }
            });
        }
    }

    public void playNext() {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.playNext();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void playPre() {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.playPre();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean playRadio(Radio radio) {
        if (!checkConnectionStatus() || radio == null) {
            return false;
        }
        CommonTrackList commonTrackList = new CommonTrackList();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ModelUtil.radioToTrack(radio, false));
        commonTrackList.setTracks(arrayList);
        commonTrackList.setTotalCount(1);
        commonTrackList.setTotalPage(1);
        playList(commonTrackList, 0);
        return true;
    }

    public boolean playSchedule(List<Schedule> list, int i) {
        if (!checkConnectionStatus() || list == null) {
            return false;
        }
        try {
            this.mPlayerStub.setPlayList(null, ModelUtil.toTrackList(list));
            if (i == -1) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(((Schedule) list.get(i2)).getStartTime());
                    stringBuilder.append("-");
                    stringBuilder.append(((Schedule) list.get(i2)).getEndTime());
                    if (BaseUtil.isInTime(stringBuilder.toString()) == 0) {
                        i = i2;
                        break;
                    }
                }
            }
            this.mPlayerStub.play(i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void removeAdsStatusListener(IXmAdsStatusListener iXmAdsStatusListener) {
        if (iXmAdsStatusListener != null && this.mAdsStatusListeners != null) {
            this.mAdsStatusListeners.remove(iXmAdsStatusListener);
        }
    }

    public void removeListByIndex(int i) {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.removeListByIndex(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeOnConnectedListerner(IConnectListener iConnectListener) {
        this.mConnectListenerSet.remove(iConnectListener);
    }

    public void removePlayerStatusListener(IXmPlayerStatusListener iXmPlayerStatusListener) {
        if (iXmPlayerStatusListener != null && this.mPlayerStatusListeners != null) {
            this.mPlayerStatusListeners.remove(iXmPlayerStatusListener);
        }
    }

    public void requestSoundAd() {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.requestSoundAd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resetPlayList() {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.resetPlayList();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void resetPlayer() {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.resetPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void seekTo(int i) {
        if (checkConnectionStatus()) {
            try {
                if (!(this.mVideoAdState == 1 || this.mVideoAdState == 2)) {
                    if (this.mVideoAdState != 3) {
                        this.mPlayerStub.seekTo(i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void seekToByPercent(float f) {
        seekTo((int) (((float) getDuration()) * f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A:{Catch:{ Exception -> 0x002d }} */
    public void setAutoLoadPageSizeInner(int r2) {
        /*
        r1 = this;
        r0 = sPageSize;
        if (r0 != r2) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        sPageSize = r2;
        r2 = r1.mConnected;	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x0026;
    L_0x000b:
        r2 = r1.mPlayerStub;	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x0026;
    L_0x000f:
        r2 = r1.mPlayerStub;	 Catch:{ Exception -> 0x002d }
        r2 = r2.asBinder();	 Catch:{ Exception -> 0x002d }
        if (r2 == 0) goto L_0x0026;
    L_0x0017:
        r2 = r1.mPlayerStub;	 Catch:{ Exception -> 0x002d }
        r2 = r2.asBinder();	 Catch:{ Exception -> 0x002d }
        r2 = r2.isBinderAlive();	 Catch:{ Exception -> 0x002d }
        if (r2 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0026;
    L_0x0024:
        r2 = 0;
        goto L_0x0027;
    L_0x0026:
        r2 = 1;
    L_0x0027:
        if (r2 != 0) goto L_0x0031;
    L_0x0029:
        r1.setDefaultPageSize();	 Catch:{ Exception -> 0x002d }
        goto L_0x0031;
    L_0x002d:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.XmPlayerManager.setAutoLoadPageSizeInner(int):void");
    }

    public void setBreakpointResume(boolean z) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.setBreakpointResume(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setCdnConfigModel(CdnConfigModel cdnConfigModel) {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.setPlayCdnConfigureModel(cdnConfigModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCheckAdContent(boolean z) {
        this.checkAdContent = z;
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.setCheckAdContent(z);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setCommonBusinessHandle(IXmCommonBusinessHandle iXmCommonBusinessHandle) {
        this.mIXmCommonBusinessHandle = iXmCommonBusinessHandle;
    }

    public void setDLNAState(boolean z) {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.setDLNAState(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setHistoryPos(long j, int i) {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.setHistoryPosById(j, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setHttpConfig(Config config) {
        sHttpConfig = config;
        if (isConnectedStatus()) {
            try {
                setPlayerProxy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    public void setOnConnectedListerner(IConnectListener iConnectListener) {
        this.mConnectListener = iConnectListener;
    }

    public void setPlayList(CommonTrackList commonTrackList, int i) {
        if (checkConnectionStatus() && commonTrackList != null && commonTrackList.getTracks() != null && commonTrackList.getTracks().size() != 0) {
            setPlayList(commonTrackList.getParams(), commonTrackList.getTracks(), i, false);
        }
    }

    public void setPlayList(List<Track> list, int i) {
        if (checkConnectionStatus() && list != null && list.size() != 0) {
            setPlayList(null, list, i, false);
        }
    }

    public void setPlayListChangeListener(IXmDataCallback iXmDataCallback) {
        this.mDataCallback = iXmDataCallback;
    }

    public void setPlayMode(PlayMode playMode) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.setPlayMode(playMode.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setRecordModel(RecordModel recordModel) {
        if (isConnectedStatus()) {
            try {
                this.mPlayerStub.setRecordModel(recordModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setSoundTouchAllParams(float f, float f2, float f3) {
        if (checkConnectionStatus()) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setSoundTouchAllParams1 tempo:");
                stringBuilder.append(f);
                stringBuilder.append(" pitch:");
                stringBuilder.append(f2);
                stringBuilder.append(" rate:");
                stringBuilder.append(f3);
                Logger.log(stringBuilder.toString());
                this.mPlayerStub.setSoundTouchAllParams(f, f2, f3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setTempo(float f) {
        setSoundTouchAllParams(f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
    }

    public void setTokenInvalidForSDK(CommonRequest$ITokenStateChange commonRequest$ITokenStateChange) {
        if (isConnectedStatus()) {
            if (commonRequest$ITokenStateChange != null) {
                try {
                    this.mPlayerStub.setTokenInvalidForSDK(this.mTokenInvalidForSDKCallBackStub);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.mPlayerStub.setTokenInvalidForSDK(null);
            }
        }
    }

    public void setTokenToPlayForSDK(AccessToken accessToken) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.setTokenToPlayForSDK(accessToken);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setVideoAdState(int i) {
        this.mVideoAdState = i;
    }

    public void setVolume(float f, float f2) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.setVolume(f, f2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.stopPlay();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateHistoryPosInList(List<? extends Track> list) {
        if (isConnectedStatus() && list != null && !list.isEmpty()) {
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            Iterator it = list.iterator();
            int i2 = 1;
            while (true) {
                i = 0;
                if (it.hasNext()) {
                    Track track = (Track) it.next();
                    if (i2 != 0) {
                        i2 = 0;
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append(track.getDataId());
                } else {
                    try {
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            String historyPos = this.mPlayerStub.getHistoryPos(stringBuilder.toString());
            if (!TextUtils.isEmpty(historyPos)) {
                String[] split = historyPos.split(",");
                if (split.length == list.size()) {
                    for (Track lastPlayedMills : list) {
                        lastPlayedMills.setLastPlayedMills(Integer.parseInt(split[i]));
                        i++;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("HistoryPos result:");
                    stringBuilder2.append(historyPos);
                    Logger.log(stringBuilder2.toString());
                } else if (ConstantsOpenSdk.isDebug) {
                    throw new RuntimeException("track list not equal length with callback data length");
                }
            }
        }
    }

    public void updateTrackDownloadUrlInPlayList(Track track) {
        if (checkConnectionStatus()) {
            try {
                this.mPlayerStub.updateTrackDownloadUrlInPlayList(track);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateTrackInPlayList(Track track) {
        if (isConnectedStatus()) {
            try {
                if (this.mPlayerStub.updateTrackInPlayList(track)) {
                    this.mCurModel = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
