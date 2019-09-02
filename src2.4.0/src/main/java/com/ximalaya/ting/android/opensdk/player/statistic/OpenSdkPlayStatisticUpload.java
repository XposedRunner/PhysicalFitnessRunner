package com.ximalaya.ting.android.opensdk.player.statistic;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.BaseBuilder;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.model.PostResponse;
import com.ximalaya.ting.android.opensdk.model.history.XmPlayRecord;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkPlayStatisticUpload implements IXmPlayStatisticUpload {
    public static final String KEY_APP_ID = "appid";
    public static final String KEY_BUNDLE_ID = "bundleId";
    public static final String KEY_CLIENT = "client";
    public static final String KEY_DEVICE_ID = "deviceId";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_NEW_RADIO_ID = "radio_id";
    public static final String KEY_NEW_TRACK_ID = "track_id";
    public static final String KEY_PLAYED_SECS = "played_secs";
    public static final String KEY_PLAY_SOURCE = "play_source";
    public static final String KEY_PLAY_TYPE = "play_type";
    public static final String KEY_PROGRAM_ID = "programId";
    @Deprecated
    public static final String KEY_RADIO_ID = "radioId";
    public static final String KEY_REC_SRC = "rec_src";
    public static final String KEY_REC_TRACK = "rec_track";
    public static final String KEY_SCHEDULE_ID = "programScheduleId";
    public static final String KEY_STARTED_AT = "started_at";
    @Deprecated
    public static final String KEY_TRACK_ID = "trackId";
    public static final String KEY_VERSION = "version";
    private static final int MAX_RETRY_COUNT = 3;
    private static OpenSdkPlayStatisticUpload sInstance;
    private HandlerThread mWorker = new HandlerThread("statistics-manager");
    private Handler mWorkerHandler;

    @Deprecated
    private class Task implements Runnable {
        private XmPlayRecord mListenRecord;
        private String mRadioUrl = "openapi/live/record";
        private int mRetry = 0;
        private String mTrackUrl = "openapi/tracks/record";

        public Task(XmPlayRecord xmPlayRecord) {
            this.mListenRecord = xmPlayRecord;
        }

        public void run() {
            if (this.mListenRecord != null) {
                Map CommonParams;
                String stringBuilder;
                StringBuilder stringBuilder2;
                this.mRetry++;
                CharSequence charSequence = null;
                try {
                    CommonParams = CommonRequest.CommonParams(new HashMap());
                } catch (XimalayaException e) {
                    e.printStackTrace();
                    CommonParams = null;
                }
                if (CommonParams == null) {
                    CommonParams = new HashMap();
                }
                StringBuilder stringBuilder3;
                if (this.mListenRecord.isPlayTrack()) {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(DTransferConstants.PLAY_RECORD);
                    stringBuilder3.append(this.mTrackUrl);
                    stringBuilder = stringBuilder3.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("");
                    stringBuilder2.append(this.mListenRecord.getId());
                    CommonParams.put("trackId", stringBuilder2.toString());
                    Logger.i("StatisticsManager", "uploadtrack");
                } else {
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(DTransferConstants.PLAY_RECORD);
                    stringBuilder3.append(this.mRadioUrl);
                    stringBuilder = stringBuilder3.toString();
                    String str = OpenSdkPlayStatisticUpload.KEY_RADIO_ID;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("");
                    stringBuilder2.append(this.mListenRecord.getId());
                    CommonParams.put(str, stringBuilder2.toString());
                    Logger.i("StatisticsManager", "uploadradio");
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(this.mListenRecord.getPlayedSecs());
                CommonParams.put("played_secs", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(this.mListenRecord.getDuration());
                CommonParams.put("duration", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(this.mListenRecord.getStartTime());
                CommonParams.put("started_at", stringBuilder2.toString());
                try {
                    charSequence = BaseCall.getInstanse().doSync(BaseBuilder.urlPost(stringBuilder, CommonParams).build()).body().string();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int i = 0;
                if (!TextUtils.isEmpty(charSequence)) {
                    try {
                        JSONObject jSONObject = new JSONObject(charSequence);
                        if (jSONObject != null && jSONObject.has("ret") && jSONObject.getInt("ret") == 0) {
                            i = 1;
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                if (i == 0 && this.mRetry < 3) {
                    OpenSdkPlayStatisticUpload.this.mWorkerHandler.post(this);
                }
            }
        }
    }

    private OpenSdkPlayStatisticUpload() {
        this.mWorker.start();
        this.mWorkerHandler = new Handler(this.mWorker.getLooper());
    }

    public static OpenSdkPlayStatisticUpload getInstance() {
        if (sInstance == null) {
            synchronized (OpenSdkPlayStatisticUpload.class) {
                if (sInstance == null) {
                    sInstance = new OpenSdkPlayStatisticUpload();
                }
            }
        }
        return sInstance;
    }

    public void release() {
        synchronized (OpenSdkPlayStatisticUpload.class) {
            this.mWorkerHandler.removeCallbacksAndMessages(null);
            this.mWorker.quit();
            sInstance = null;
        }
    }

    public void upLoadData(XmPlayRecord xmPlayRecord) {
        StringBuilder stringBuilder;
        HashMap hashMap = new HashMap();
        if (xmPlayRecord.isPlayTrack()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(xmPlayRecord.getId());
            hashMap.put("track_id", stringBuilder.toString());
            Logger.i("StatisticsManager", "uploadtrack");
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(xmPlayRecord.getId());
            hashMap.put("radio_id", stringBuilder.toString());
            Logger.i("StatisticsManager", "uploadradio");
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(xmPlayRecord.getPlayedSecs());
        hashMap.put("played_secs", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(xmPlayRecord.getDuration());
        hashMap.put("duration", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(xmPlayRecord.getStartTime());
        hashMap.put("started_at", stringBuilder.toString());
        hashMap.put("play_type", "0");
        if (xmPlayRecord.isPlayTrack()) {
            CommonRequest.postTrackSingleRecord(hashMap, new IDataCallBack<PostResponse>() {
                public void onError(int i, String str) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("postTrackSingleRecord onError  ");
                    stringBuilder.append(str);
                    Logger.log(stringBuilder.toString());
                }

                public void onSuccess(PostResponse postResponse) {
                    if (postResponse != null && postResponse.getCode() == 0) {
                        Logger.log("postTrackSingleRecord onSuccess");
                    }
                }
            });
        } else {
            CommonRequest.postLiveSingleRecord(hashMap, new IDataCallBack<PostResponse>() {
                public void onError(int i, String str) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("postLiveSingleRecord onError  ");
                    stringBuilder.append(str);
                    Logger.log(stringBuilder.toString());
                }

                public void onSuccess(PostResponse postResponse) {
                    if (postResponse != null && postResponse.getCode() == 0) {
                        Logger.log("postLiveSingleRecord onSuccess");
                    }
                }
            });
        }
    }
}
