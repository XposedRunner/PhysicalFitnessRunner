package com.ximalaya.ting.android.opensdk.player.advertis;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.player.statistic.OpenSdkPlayStatisticUpload;
import com.ximalaya.ting.android.opensdk.util.DigestUtils;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.MyAsyncTask;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class XmAdsManager {
    public static final int AD_ADVANCE_TIME = 20000;
    private static final int MAX_ADS_CACHE = 20;
    private static final int MAX_DOWNLOAD_TIME = 5000;
    public static boolean isPlayFragmentShowing;
    private static volatile XmAdsManager sInstance;
    private static byte[] sLock = new byte[0];
    private IXmAdsDataHandle dataHandler;
    private long lastRequestTime;
    private long lastRequestTrackId = -1;
    private boolean mAdsActive = false;
    private List<String> mAdsFileCache = new CopyOnWriteArrayList();
    private MiniPlayer mAdsPlayer;
    private Context mAppCtx;
    private boolean mLastIsDuringPlay = false;
    private AdvertisList mLastRequestAdList;
    private String mLastRequestTag;
    private TaskWrapper mLastTask;
    private IXmAdsStatusListener mListener;
    private Map<String, List<IDataCallBack<String>>> requestMap = new ConcurrentHashMap();

    public interface IPlayStartCallBack {
        boolean onPlayStart();
    }

    public interface PlayAdsCallback {
        void onFinish(boolean z);
    }

    public class TaskWrapper {
        public AdvertisList ads;
        public PlayAdsCallback callback;
        public boolean cancel;
        public IPlayStartCallBack mPlayStartCallBack;
        public int playIndex = 0;
        public PlayAdsCallback tempCallBack;
        public Track track;
    }

    private XmAdsManager(Context context) {
        this.mAppCtx = context.getApplicationContext();
        loadCachedAdsFile();
    }

    private void dataReceiver(AdvertisList advertisList, TaskWrapper taskWrapper) {
        boolean exitPlayAds = exitPlayAds(taskWrapper.cancel, taskWrapper, false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dataReceiver 1:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        StringBuilder stringBuilder2;
        if (exitPlayAds) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataReceiver 2:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            return;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("dataReceiver 3:");
        stringBuilder3.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder3.toString());
        if (this.mListener != null) {
            this.mListener.onGetAdsInfo(advertisList);
        }
        if (advertisList == null || advertisList.getRet() != 0 || advertisList.getAdvertisList() == null || advertisList.getAdvertisList().size() == 0 || advertisList.getAdvertisList().get(0) == null) {
            this.mAdsActive = false;
            exitPlayAds(true, taskWrapper, true);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("dataReceiver 4:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            return;
        }
        if (((Advertis) advertisList.getAdvertisList().get(0)).getAdid() == -1) {
            this.mAdsActive = true;
        }
        taskWrapper.ads = advertisList;
        if (((Advertis) advertisList.getAdvertisList().get(0)).isDuringPlay()) {
            if (this.mListener != null) {
                this.mListener.onCompletePlayAds();
            }
            this.mAdsActive = false;
        } else {
            downloadAndPlayAds(taskWrapper);
            if (!isPlayFragmentShowing && ((Advertis) advertisList.getAdvertisList().get(0)).getSoundType() == 11) {
                onVideoAdCompleted();
            }
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("dataReceiver 5:");
        stringBuilder2.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder2.toString());
        this.dataHandler.upLoadAdsLog(taskWrapper);
    }

    private boolean deleteAdsCacheFile(String str) {
        File file = new File(FileUtilBase.getAdsCacheDir(this.mAppCtx, str));
        return file.exists() ? file.delete() : false;
    }

    private void downloadAdsFile(final TaskWrapper taskWrapper, final int i) {
        if (exitPlayAds(taskWrapper.cancel, taskWrapper, false)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("downloadAdsFile 0:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            return;
        }
        if (this.mListener != null) {
            this.mListener.onAdsStartBuffering();
        }
        MyAsyncTask.execute(new Runnable() {
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("downloadAdsFile doInBackground 1:");
                stringBuilder.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder.toString());
                if (!taskWrapper.cancel) {
                    String soundUrl = ((Advertis) taskWrapper.ads.getAdvertisList().get(0)).getSoundUrl();
                    String access$1000 = XmAdsManager.this.getFilePath(soundUrl);
                    if (new File(access$1000).exists()) {
                        XmAdsManager.this.onDownloadCallBack(taskWrapper, access$1000, false, i);
                    } else {
                        XmAdsManager.this.downloadUrlHaveCallBack(soundUrl, new IDataCallBack<String>() {
                            public void onError(int i, String str) {
                                XmAdsManager.this.onDownloadCallBack(taskWrapper, null, false, i);
                            }

                            public void onSuccess(@Nullable String str) {
                                XmAdsManager.this.onDownloadCallBack(taskWrapper, str, false, i);
                            }
                        });
                    }
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d4  */
    private void downloadAndPlayAds(final com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.TaskWrapper r14) {
        /*
        r13 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "downloadAndPlayAds 0:";
        r0.append(r1);
        r1 = java.lang.System.currentTimeMillis();
        r0.append(r1);
        r0 = r0.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r0);
        r0 = r14.cancel;
        r1 = 0;
        r0 = r13.exitPlayAds(r0, r14, r1);
        if (r0 == 0) goto L_0x003a;
    L_0x0021:
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r0 = "downloadAndPlayAds 1:";
        r14.append(r0);
        r0 = java.lang.System.currentTimeMillis();
        r14.append(r0);
        r14 = r14.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r14);
        return;
    L_0x003a:
        r0 = r13.wordOfMouthIndex(r14);
        r2 = r14.ads;
        r2 = r2.getAdvertisList();
        r2 = r2.get(r1);
        r2 = (com.ximalaya.ting.android.opensdk.model.advertis.Advertis) r2;
        r2 = r2.getSoundUrl();
        r2 = android.text.TextUtils.isEmpty(r2);
        r8 = 1;
        r2 = r2 ^ r8;
        if (r0 <= 0) goto L_0x006c;
    L_0x0056:
        r2 = r14.ads;
        r2 = r2.getAdvertisList();
        r2 = r2.get(r1);
        r2 = (com.ximalaya.ting.android.opensdk.model.advertis.Advertis) r2;
        r2 = r2.getSoundUrl();
        r2 = android.text.TextUtils.isEmpty(r2);
        r2 = r2 ^ r8;
        goto L_0x0071;
    L_0x006c:
        if (r0 != 0) goto L_0x0071;
    L_0x006e:
        r9 = r1;
        r10 = r9;
        goto L_0x0073;
    L_0x0071:
        r10 = r2;
        r9 = r8;
    L_0x0073:
        if (r0 < 0) goto L_0x00d2;
    L_0x0075:
        r2 = r14.ads;
        r2 = r2.getAdvertisList();
        r2 = r2.get(r0);
        r2 = (com.ximalaya.ting.android.opensdk.model.advertis.Advertis) r2;
        if (r2 == 0) goto L_0x00d2;
    L_0x0083:
        r11 = r2.getSoundUrl();
        r2 = r13.getFilePath(r11);
        r3 = new com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager$2;
        r3.<init>(r14, r2, r0);
        r14.mPlayStartCallBack = r3;
        r3 = new java.io.File;
        r3.<init>(r2);
        r2 = r3.exists();
        if (r2 == 0) goto L_0x00b8;
    L_0x009d:
        if (r0 == 0) goto L_0x00a3;
    L_0x009f:
        if (r9 == 0) goto L_0x00d2;
    L_0x00a1:
        if (r10 != 0) goto L_0x00d2;
    L_0x00a3:
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
        if (r0 == 0) goto L_0x00b2;
    L_0x00a9:
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
        r2 = r14.mPlayStartCallBack;
        r0.setPlayStartCallback(r2);
    L_0x00b2:
        r13.mAdsActive = r1;
        r13.exitPlayAds(r8, r14, r8);
        return;
    L_0x00b8:
        r12 = new com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager$3;
        r2 = r12;
        r3 = r13;
        r4 = r0;
        r5 = r9;
        r6 = r10;
        r7 = r14;
        r2.<init>(r4, r5, r6, r7);
        r2 = new com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager$4;
        r2.<init>(r11, r12);
        com.ximalaya.ting.android.opensdk.util.MyAsyncTask.execute(r2);
        if (r0 == 0) goto L_0x00d1;
    L_0x00cd:
        if (r9 == 0) goto L_0x00d2;
    L_0x00cf:
        if (r10 != 0) goto L_0x00d2;
    L_0x00d1:
        return;
    L_0x00d2:
        if (r9 == 0) goto L_0x014b;
    L_0x00d4:
        r2 = r14.ads;
        r2 = r2.getAdvertisList();
        r2 = r2.get(r1);
        r2 = (com.ximalaya.ting.android.opensdk.model.advertis.Advertis) r2;
        r3 = r2.getSoundType();
        r4 = 11;
        if (r3 != r4) goto L_0x00f4;
    L_0x00e8:
        r2 = r2.getDynamicImage();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x00f4;
    L_0x00f2:
        r2 = r8;
        goto L_0x00f5;
    L_0x00f4:
        r2 = r1;
    L_0x00f5:
        if (r2 == 0) goto L_0x00fe;
    L_0x00f7:
        r3 = r14.callback;
        r14.tempCallBack = r3;
        r3 = 0;
        r14.callback = r3;
    L_0x00fe:
        if (r10 != 0) goto L_0x0131;
    L_0x0100:
        if (r2 != 0) goto L_0x0131;
    L_0x0102:
        r13.mAdsActive = r1;
        if (r0 < 0) goto L_0x0115;
    L_0x0106:
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
        if (r0 == 0) goto L_0x0115;
    L_0x010c:
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
        r1 = r14.mPlayStartCallBack;
        r0.setPlayStartCallback(r1);
    L_0x0115:
        r13.exitPlayAds(r8, r14, r8);
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r0 = "downloadAndPlayAds 2:";
        r14.append(r0);
        r0 = java.lang.System.currentTimeMillis();
        r14.append(r0);
        r14 = r14.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.logToSd(r14);
        return;
    L_0x0131:
        if (r10 == 0) goto L_0x0138;
    L_0x0133:
        if (r2 != 0) goto L_0x0138;
    L_0x0135:
        r13.downloadAdsFile(r14, r0);
    L_0x0138:
        if (r2 == 0) goto L_0x014b;
    L_0x013a:
        if (r0 < 0) goto L_0x014b;
    L_0x013c:
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
        if (r0 == 0) goto L_0x014b;
    L_0x0142:
        r0 = com.ximalaya.ting.android.opensdk.player.service.XmPlayerService.getPlayerSrvice();
        r14 = r14.mPlayStartCallBack;
        r0.setPlayStartCallback(r14);
    L_0x014b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.downloadAndPlayAds(com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager$TaskWrapper):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x010b A:{LOOP_END, LOOP:4: B:62:0x0105->B:64:0x010b, Catch:{ all -> 0x00eb }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0131 A:{SYNTHETIC, Splitter:B:67:0x0131} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013c A:{SYNTHETIC, Splitter:B:73:0x013c} */
    /* JADX WARNING: Missing block: B:38:0x00b3, code skipped:
            r5.flush();
            r9 = (java.util.List) r6.requestMap.get(r7);
     */
    /* JADX WARNING: Missing block: B:39:0x00be, code skipped:
            if (r9 == null) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:41:0x00c4, code skipped:
            if (r9.size() <= 0) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:42:0x00c6, code skipped:
            r9 = r9.iterator();
     */
    /* JADX WARNING: Missing block: B:44:0x00ce, code skipped:
            if (r9.hasNext() == false) goto L_0x00da;
     */
    /* JADX WARNING: Missing block: B:45:0x00d0, code skipped:
            ((com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack) r9.next()).onSuccess(r8);
     */
    /* JADX WARNING: Missing block: B:46:0x00da, code skipped:
            r6.requestMap.remove(r7);
     */
    /* JADX WARNING: Missing block: B:47:0x00df, code skipped:
            if (r5 == null) goto L_0x0139;
     */
    /* JADX WARNING: Missing block: B:49:?, code skipped:
            r5.close();
     */
    /* JADX WARNING: Missing block: B:69:0x0135, code skipped:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:70:0x0136, code skipped:
            r7.printStackTrace();
     */
    private void downloadFile(java.lang.String r7, java.lang.String r8, @android.support.annotation.Nullable com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.TaskWrapper r9) {
        /*
        r6 = this;
        r0 = 0;
        r1 = 0;
        r2 = r6.mAppCtx;	 Catch:{ Exception -> 0x00ed }
        r2 = com.ximalaya.ting.android.opensdk.util.FileUtilBase.reduceHttpsToHttp(r2, r7);	 Catch:{ Exception -> 0x00ed }
        r3 = com.ximalaya.ting.android.opensdk.httputil.HttpUrlUtil.mConfig;	 Catch:{ Exception -> 0x00ed }
        r4 = "GET";
        r5 = new com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager$8;	 Catch:{ Exception -> 0x00ed }
        r5.<init>();	 Catch:{ Exception -> 0x00ed }
        r2 = com.ximalaya.ting.android.opensdk.httputil.HttpUrlUtil.getHttpURLConnection(r2, r3, r4, r5);	 Catch:{ Exception -> 0x00ed }
        r2.connect();	 Catch:{ Exception -> 0x00ed }
        r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x00ed }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == r4) goto L_0x005b;
    L_0x0020:
        r8 = r6.requestMap;	 Catch:{ Exception -> 0x00ed }
        r8 = r8.get(r7);	 Catch:{ Exception -> 0x00ed }
        r8 = (java.util.List) r8;	 Catch:{ Exception -> 0x00ed }
        if (r8 == 0) goto L_0x0055;
    L_0x002a:
        r9 = r8.size();	 Catch:{ Exception -> 0x00ed }
        if (r9 <= 0) goto L_0x0055;
    L_0x0030:
        r8 = r8.iterator();	 Catch:{ Exception -> 0x00ed }
    L_0x0034:
        r9 = r8.hasNext();	 Catch:{ Exception -> 0x00ed }
        if (r9 == 0) goto L_0x0055;
    L_0x003a:
        r9 = r8.next();	 Catch:{ Exception -> 0x00ed }
        r9 = (com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack) r9;	 Catch:{ Exception -> 0x00ed }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ed }
        r2.<init>();	 Catch:{ Exception -> 0x00ed }
        r4 = "resCode == ";
        r2.append(r4);	 Catch:{ Exception -> 0x00ed }
        r2.append(r3);	 Catch:{ Exception -> 0x00ed }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00ed }
        r9.onError(r0, r2);	 Catch:{ Exception -> 0x00ed }
        goto L_0x0034;
    L_0x0055:
        r8 = r6.requestMap;	 Catch:{ Exception -> 0x00ed }
        r8.remove(r7);	 Catch:{ Exception -> 0x00ed }
        return;
    L_0x005b:
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x00ed }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3 = new byte[r3];	 Catch:{ Exception -> 0x00ed }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x00ed }
        r4.<init>(r8);	 Catch:{ Exception -> 0x00ed }
        r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00ed }
        r5.<init>(r4, r0);	 Catch:{ Exception -> 0x00ed }
    L_0x006d:
        r1 = r2.read(r3);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r1 <= 0) goto L_0x00b3;
    L_0x0073:
        if (r9 == 0) goto L_0x00af;
    L_0x0075:
        r4 = r9.cancel;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r4 == 0) goto L_0x00af;
    L_0x0079:
        r8 = r6.requestMap;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r8 = r8.get(r7);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r8 = (java.util.List) r8;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r8 == 0) goto L_0x009f;
    L_0x0083:
        r9 = r8.size();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r9 <= 0) goto L_0x009f;
    L_0x0089:
        r8 = r8.iterator();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
    L_0x008d:
        r9 = r8.hasNext();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r9 == 0) goto L_0x009f;
    L_0x0093:
        r9 = r8.next();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r9 = (com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack) r9;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r1 = "已取消";
        r9.onError(r0, r1);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        goto L_0x008d;
    L_0x009f:
        r8 = r6.requestMap;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r8.remove(r7);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r5 == 0) goto L_0x00ae;
    L_0x00a6:
        r5.close();	 Catch:{ IOException -> 0x00aa }
        goto L_0x00ae;
    L_0x00aa:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x00ae:
        return;
    L_0x00af:
        r5.write(r3, r0, r1);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        goto L_0x006d;
    L_0x00b3:
        r5.flush();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r9 = r6.requestMap;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r9 = r9.get(r7);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r9 = (java.util.List) r9;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r9 == 0) goto L_0x00da;
    L_0x00c0:
        r1 = r9.size();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r1 <= 0) goto L_0x00da;
    L_0x00c6:
        r9 = r9.iterator();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
    L_0x00ca:
        r1 = r9.hasNext();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r1 == 0) goto L_0x00da;
    L_0x00d0:
        r1 = r9.next();	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r1 = (com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack) r1;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r1.onSuccess(r8);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        goto L_0x00ca;
    L_0x00da:
        r8 = r6.requestMap;	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        r8.remove(r7);	 Catch:{ Exception -> 0x00e8, all -> 0x00e5 }
        if (r5 == 0) goto L_0x0139;
    L_0x00e1:
        r5.close();	 Catch:{ IOException -> 0x0135 }
        goto L_0x0139;
    L_0x00e5:
        r7 = move-exception;
        r1 = r5;
        goto L_0x013a;
    L_0x00e8:
        r8 = move-exception;
        r1 = r5;
        goto L_0x00ee;
    L_0x00eb:
        r7 = move-exception;
        goto L_0x013a;
    L_0x00ed:
        r8 = move-exception;
    L_0x00ee:
        r8.printStackTrace();	 Catch:{ all -> 0x00eb }
        r9 = r6.requestMap;	 Catch:{ all -> 0x00eb }
        r9 = r9.get(r7);	 Catch:{ all -> 0x00eb }
        r9 = (java.util.List) r9;	 Catch:{ all -> 0x00eb }
        if (r9 == 0) goto L_0x012a;
    L_0x00fb:
        r2 = r9.size();	 Catch:{ all -> 0x00eb }
        if (r2 <= 0) goto L_0x012a;
    L_0x0101:
        r9 = r9.iterator();	 Catch:{ all -> 0x00eb }
    L_0x0105:
        r2 = r9.hasNext();	 Catch:{ all -> 0x00eb }
        if (r2 == 0) goto L_0x012a;
    L_0x010b:
        r2 = r9.next();	 Catch:{ all -> 0x00eb }
        r2 = (com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack) r2;	 Catch:{ all -> 0x00eb }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r3.<init>();	 Catch:{ all -> 0x00eb }
        r4 = "错误了==";
        r3.append(r4);	 Catch:{ all -> 0x00eb }
        r4 = r8.getMessage();	 Catch:{ all -> 0x00eb }
        r3.append(r4);	 Catch:{ all -> 0x00eb }
        r3 = r3.toString();	 Catch:{ all -> 0x00eb }
        r2.onError(r0, r3);	 Catch:{ all -> 0x00eb }
        goto L_0x0105;
    L_0x012a:
        r8 = r6.requestMap;	 Catch:{ all -> 0x00eb }
        r8.remove(r7);	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x0139;
    L_0x0131:
        r1.close();	 Catch:{ IOException -> 0x0135 }
        goto L_0x0139;
    L_0x0135:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0139:
        return;
    L_0x013a:
        if (r1 == 0) goto L_0x0144;
    L_0x013c:
        r1.close();	 Catch:{ IOException -> 0x0140 }
        goto L_0x0144;
    L_0x0140:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0144:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager.downloadFile(java.lang.String, java.lang.String, com.ximalaya.ting.android.opensdk.player.advertis.XmAdsManager$TaskWrapper):void");
    }

    private void downloadUrlHaveCallBack(String str, IDataCallBack<String> iDataCallBack) {
        List list = (List) this.requestMap.get(str);
        if (list == null || list.size() <= 0) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(iDataCallBack);
            this.requestMap.put(str, copyOnWriteArrayList);
            downloadFile(str, getFilePath(str), null);
            return;
        }
        list.add(iDataCallBack);
    }

    private synchronized boolean exitPlayAds(boolean z, TaskWrapper taskWrapper, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exitPlayAds cancel:");
        stringBuilder.append(z);
        stringBuilder.append(" task:");
        stringBuilder.append(taskWrapper.track.toString());
        stringBuilder.append(" result:");
        stringBuilder.append(z2);
        stringBuilder.append("  time:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        if (!z) {
            return false;
        }
        if (taskWrapper != null && taskWrapper == this.mLastTask) {
            if (this.mListener != null) {
                Logger.logToSd("exitPlayAds 0");
                this.mListener.onCompletePlayAds();
            }
            if (taskWrapper.callback != null) {
                Logger.logToSd("exitPlayAds 1");
                taskWrapper.callback.onFinish(z2);
            }
        }
        return true;
    }

    private synchronized void getAdsInfoAndPlay(final TaskWrapper taskWrapper, int i, boolean z) {
        if (!(this.mListener == null || z)) {
            this.mListener.onStartGetAdsInfo();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getAdsInfoAndPlay 0:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        StringBuilder stringBuilder2;
        if (this.dataHandler == null) {
            this.mAdsActive = false;
            exitPlayAds(true, taskWrapper, true);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("getAdsInfoAndPlay 1:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("getAdsInfoAndPlay 2:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        if (taskWrapper.track.getDataId() != this.lastRequestTrackId || this.mLastRequestAdList == null || System.currentTimeMillis() - this.lastRequestTime >= 40000) {
            HashMap hashMap = new HashMap();
            StringBuilder stringBuilder3;
            if ("track".equals(taskWrapper.track.getKind())) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(taskWrapper.track.getDataId());
                hashMap.put("trackId", stringBuilder3.toString());
            } else {
                String str = OpenSdkPlayStatisticUpload.KEY_RADIO_ID;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(taskWrapper.track.getRadioId());
                hashMap.put(str, stringBuilder3.toString());
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(taskWrapper.track.getDataId());
                hashMap.put("scheduleId", stringBuilder3.toString());
            }
            if (XmPlayerService.getPlayerSrvice() != null) {
                hashMap.put("mode", XmPlayerService.getPlayerSrvice().isOnlineResource() ? "0" : ClientOSType.IOS);
            } else {
                hashMap.put("mode", "0");
            }
            hashMap.put("playMethod", String.valueOf(i));
            String str2 = Advertis.FIELD_DURING_PLAY;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(z);
            stringBuilder4.append("");
            hashMap.put(str2, stringBuilder4.toString());
            this.dataHandler.cancleRequestTag(this.mLastRequestTag);
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("getAdsInfoAndPlay 4:");
            stringBuilder5.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder5.toString());
            this.mLastRequestTag = this.dataHandler.getAdsData(taskWrapper.track, hashMap, new IDataCallBack<AdvertisList>() {
                public void onError(int i, String str) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("getAdsInfoAndPlay 6:");
                    stringBuilder.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder.toString());
                    if (taskWrapper == XmAdsManager.this.mLastTask) {
                        XmAdsManager.this.mAdsActive = false;
                    }
                    XmAdsManager.this.exitPlayAds(true, taskWrapper, true);
                }

                public void onSuccess(AdvertisList advertisList) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("getAdsInfoAndPlay 5:");
                    stringBuilder.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder.toString());
                    XmAdsManager.this.dataReceiver(advertisList, taskWrapper);
                }
            });
            return;
        }
        dataReceiver(this.mLastRequestAdList, taskWrapper);
        this.mLastRequestAdList = null;
        this.lastRequestTrackId = -1;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("getAdsInfoAndPlay 3:");
        stringBuilder2.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder2.toString());
    }

    private String getFilePath(String str) {
        Context context = this.mAppCtx;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(DigestUtils.md5Hex(str));
        stringBuilder.append(getSuffixFromUrl(str));
        return FileUtilBase.getAdsCacheDir(context, stringBuilder.toString());
    }

    public static XmAdsManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new XmAdsManager(context);
                    removeOldAdFile(context);
                }
            }
        }
        return sInstance;
    }

    private static String getSuffixFromUrl(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(".")) ? null : str.substring(str.lastIndexOf("."), str.length());
    }

    private boolean isWordOfMouth(Advertis advertis) {
        return (advertis == null || !advertis.isWordOfMouth() || TextUtils.isEmpty(advertis.getSoundUrl())) ? false : true;
    }

    private void loadCachedAdsFile() {
        File file = new File(FileUtilBase.getAdsCacheDir(this.mAppCtx, ""));
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list();
        if (list != null && list.length != 0) {
            this.mAdsFileCache.clear();
            this.mAdsFileCache.addAll(Arrays.asList(list));
        }
    }

    private void onDownloadCallBack(TaskWrapper taskWrapper, String str, boolean z, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            onDownloadCallBackReal(taskWrapper, str, z, i);
            return;
        }
        final TaskWrapper taskWrapper2 = taskWrapper;
        final String str2 = str;
        final boolean z2 = z;
        final int i2 = i;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                XmAdsManager.this.onDownloadCallBackReal(taskWrapper2, str2, z2, i2);
            }
        });
    }

    private void onDownloadCallBackReal(TaskWrapper taskWrapper, String str, boolean z, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("downloadAdsFile onPostExecute 0:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        if (exitPlayAds(taskWrapper.cancel, taskWrapper, false)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("downloadAdsFile onPostExecute 1:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            if (this.mListener != null) {
                this.mListener.onAdsStopBuffering();
            }
            return;
        }
        StringBuilder stringBuilder3;
        if (TextUtils.isEmpty(str)) {
            this.mAdsActive = false;
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("downloadAdsFile onPostExecute 2:");
            stringBuilder3.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder3.toString());
            exitPlayAds(true, taskWrapper, true);
            if (this.mListener != null) {
                this.mListener.onAdsStopBuffering();
            }
        } else {
            if (this.mAdsFileCache.size() > 20) {
                deleteAdsCacheFile((String) this.mAdsFileCache.remove(0));
            }
            this.mAdsFileCache.add(str);
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("downloadAdsFile onPostExecute 3:");
            stringBuilder3.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder3.toString());
            playAdsInternal(taskWrapper, z, i);
        }
    }

    private void playAdsInternal(final TaskWrapper taskWrapper, final boolean z, final int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playAdsInternal 0:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder.toString());
        StringBuilder stringBuilder2;
        if (exitPlayAds(taskWrapper.cancel, taskWrapper, false)) {
            if (this.mListener != null) {
                this.mListener.onAdsStopBuffering();
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("playAdsInternal 1:");
            stringBuilder2.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder2.toString());
            return;
        }
        if (this.mAdsPlayer != null) {
            this.mAdsPlayer.stopPlay();
        } else {
            this.mAdsPlayer = new MiniPlayer();
        }
        this.mAdsPlayer.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("playAd CompletionListener:");
                stringBuilder.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder.toString());
                if (taskWrapper == XmAdsManager.this.mLastTask) {
                    XmAdsManager.this.mAdsPlayer.setOnCompletionListener(null);
                }
                if (!(z || i < 0 || XmPlayerService.getPlayerSrvice() == null)) {
                    XmPlayerService.getPlayerSrvice().setPlayStartCallback(taskWrapper.mPlayStartCallBack);
                }
                XmAdsManager.this.mAdsActive = false;
                XmAdsManager.this.exitPlayAds(true, taskWrapper, true);
            }
        });
        Advertis advertis = (Advertis) taskWrapper.ads.getAdvertisList().get(0);
        if (z && taskWrapper.ads.getAdvertisList().size() > i) {
            advertis.setSoundUrl(((Advertis) taskWrapper.ads.getAdvertisList().get(i)).getSoundUrl());
            advertis.setWordOfMouth(true);
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(DigestUtils.md5Hex(advertis.getSoundUrl()));
        stringBuilder3.append(getSuffixFromUrl(advertis.getSoundUrl()));
        String adsCacheDir = FileUtilBase.getAdsCacheDir(this.mAppCtx, stringBuilder3.toString());
        if (new File(adsCacheDir).exists()) {
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice == null || !playerSrvice.isLossAudioFocus()) {
                try {
                    this.mAdsPlayer.init(adsCacheDir, advertis);
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("playAdsInternal 3:");
                    stringBuilder3.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder3.toString());
                    playAd();
                } catch (Exception e) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("playAdsInternal 4:");
                    stringBuilder4.append(System.currentTimeMillis());
                    Logger.logToSd(stringBuilder4.toString());
                    e.printStackTrace();
                    if (this.mListener != null) {
                        this.mListener.onError(0, 0);
                    }
                    this.mAdsActive = false;
                    exitPlayAds(true, taskWrapper, true);
                }
            } else {
                playerSrvice.setLossAudioFocus(false);
                this.mAdsActive = false;
                exitPlayAds(true, taskWrapper, true);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("playAdsInternal 2:");
                stringBuilder2.append(System.currentTimeMillis());
                Logger.logToSd(stringBuilder2.toString());
                return;
            }
        }
        this.mAdsActive = false;
        exitPlayAds(true, taskWrapper, true);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("playAdsInternal 5:");
        stringBuilder2.append(System.currentTimeMillis());
        Logger.logToSd(stringBuilder2.toString());
    }

    private static void removeOldAdFile(Context context) {
        if (context != null) {
            String stringBuilder;
            StringBuilder stringBuilder2;
            if ("mounted".equals(Environment.getExternalStorageState())) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(Environment.getExternalStorageDirectory().getPath());
                stringBuilder2.append("/Android/data/");
                stringBuilder2.append(context.getPackageName());
                stringBuilder2.append("/files/ads");
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(context.getFilesDir().getPath());
                stringBuilder2.append("/ads");
                stringBuilder = stringBuilder2.toString();
            }
            try {
                FileUtilBase.deleFileNoCheckDownloadFile(new File(stringBuilder));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int wordOfMouthIndex(TaskWrapper taskWrapper) {
        if (taskWrapper == null || taskWrapper.ads == null || taskWrapper.ads.getAdvertisList() == null || taskWrapper.ads.getAdvertisList().size() == 0) {
            return -1;
        }
        List advertisList = taskWrapper.ads.getAdvertisList();
        for (int i = 0; i < advertisList.size(); i++) {
            Advertis advertis = (Advertis) advertisList.get(i);
            if (advertis != null && advertis.isWordOfMouth() && !TextUtils.isEmpty(advertis.getSoundUrl())) {
                return i;
            }
        }
        return -1;
    }

    public void exitPlayAds(boolean z) {
        if (this.mLastTask != null) {
            if (this.mLastTask.callback != null) {
                this.mLastTask.callback.onFinish(z);
            }
            stopCurrentAdPlay();
            if (this.mListener != null) {
                this.mListener.onCompletePlayAds();
            }
        }
    }

    public MiniPlayer getAdsPlayer() {
        return this.mAdsPlayer;
    }

    public TaskWrapper getLastTask() {
        return this.mLastTask;
    }

    public int getPlayerStatue() {
        return this.mAdsPlayer != null ? this.mAdsPlayer.getStatus() : 0;
    }

    public boolean isAdsActive() {
        return this.mAdsActive;
    }

    public boolean isAdsBuffering() {
        return this.mAdsActive && !isAdsPlaying();
    }

    public boolean isAdsPlaying() {
        return this.mAdsPlayer != null && this.mAdsPlayer.isPlaying();
    }

    public boolean isLastIsDuringPlay() {
        return this.mLastIsDuringPlay;
    }

    public boolean isVideoAdType() {
        return (this.mLastTask == null || this.mLastTask.ads == null || this.mLastTask.ads.getAdvertisList() == null || this.mLastTask.ads.getAdvertisList().size() <= 0 || this.mLastTask.ads.getAdvertisList().get(0) == null || 11 != ((Advertis) this.mLastTask.ads.getAdvertisList().get(0)).getSoundType()) ? false : true;
    }

    public void onPlayProgress(int i, int i2) {
        if (this.dataHandler != null) {
            this.dataHandler.onPlayProgress(i, i2);
        }
    }

    public void onVideoAdCompleted() {
        if (this.mLastTask != null) {
            if (this.mLastTask.tempCallBack != null) {
                this.mLastTask.tempCallBack.onFinish(true);
            }
            this.mAdsActive = false;
            if (wordOfMouthIndex(this.mLastTask) < 0) {
                stopCurrentAdPlay();
            } else {
                this.mLastTask.callback = this.mLastTask.tempCallBack;
                this.mLastTask.tempCallBack = null;
            }
            if (this.mListener != null) {
                this.mListener.onCompletePlayAds();
            }
        }
    }

    public synchronized void onlyStopPlayer() {
        if (this.mAdsPlayer != null) {
            this.mAdsPlayer.stopPlay();
        }
        this.mAdsActive = false;
    }

    public void pauseAd() {
        if (this.mAdsPlayer != null) {
            this.mAdsPlayer.pausePlay();
        }
    }

    public void playAd() {
        if (this.mAdsPlayer != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("playAd 0:");
            stringBuilder.append(System.currentTimeMillis());
            Logger.logToSd(stringBuilder.toString());
            this.mAdsPlayer.startPlay();
            Advertis advertis = this.mAdsPlayer.getAdvertis();
            if (advertis != null) {
                advertis.setAdSoundTime((long) this.mAdsPlayer.getDuration());
                if (this.mListener != null) {
                    this.mListener.onStartPlayAds(advertis, 0);
                }
            }
        }
    }

    public void playAds(Track track, int i, PlayAdsCallback playAdsCallback, boolean z) {
        if (!z) {
            stopCurrentAdPlay();
            this.mAdsActive = true;
        }
        TaskWrapper taskWrapper = new TaskWrapper();
        taskWrapper.track = track;
        taskWrapper.callback = playAdsCallback;
        this.mLastTask = taskWrapper;
        this.mLastIsDuringPlay = z;
        getAdsInfoAndPlay(this.mLastTask, i, z);
    }

    public void release() {
        if (this.mAdsPlayer != null) {
            this.mAdsPlayer.stopPlay();
        }
        if (this.mLastTask != null) {
            this.mLastTask.cancel = true;
        }
        this.mAdsActive = false;
        this.mAdsPlayer = null;
        this.mLastTask = null;
        this.mListener = null;
        if (this.dataHandler != null) {
            this.dataHandler.release();
        }
    }

    public void setAdsDataHandlerClassName(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("XmAdsManager ==  2 ");
        stringBuilder.append(str);
        Logger.logToSd(stringBuilder.toString());
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dataHandler = (IXmAdsDataHandle) Class.forName(str).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("XmAdsManager ==  3 ");
                stringBuilder2.append(this.dataHandler);
                Logger.logToSd(stringBuilder2.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setAdsStatusListener(IXmAdsStatusListener iXmAdsStatusListener) {
        this.mListener = iXmAdsStatusListener;
    }

    public synchronized void stopCurrentAdPlay() {
        if (this.mLastTask != null) {
            this.mLastTask.cancel = true;
            this.mLastTask.callback = null;
            this.mLastTask.tempCallBack = null;
            this.mLastTask.mPlayStartCallBack = null;
            this.mLastTask.playIndex = 0;
            if (XmPlayerService.getPlayerSrvice() != null) {
                XmPlayerService.getPlayerSrvice().setPlayStartCallback(null);
            }
        }
        if (this.mAdsPlayer != null) {
            this.mAdsPlayer.stopPlay();
        }
        this.mAdsActive = false;
    }
}
