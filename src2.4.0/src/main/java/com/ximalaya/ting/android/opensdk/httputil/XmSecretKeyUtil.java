package com.ximalaya.ting.android.opensdk.httputil;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.SercretPubKey;
import com.ximalaya.ting.android.opensdk.model.track.TrackBaseInfo;
import com.ximalaya.ting.android.opensdk.util.AESUtil;
import com.ximalaya.ting.android.opensdk.util.DHUtil;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.util.HashMap;

public class XmSecretKeyUtil {
    public static final String CLIENT_TXT = "client.txt";
    private static final String FALL_BACK_PUBLIC_KEY = "E0kmVeFAbSqiuv2ZSi0AKw==";
    private static final String SECRET_EXPIRED_TIME = "secret_expired_time";
    private static final String SECRET_PUBLIC_KEY = "secret_public_key";
    private static final String SECRET_REQUEST_TIME = "secret_request_time";
    private static XmSecretKeyUtil singleton;
    private boolean isInited = false;
    private Context mContext;
    private String pubKey;

    private boolean checkAuthorized() {
        long j = SharedPreferencesUtil.getInstance(this.mContext).getLong(SECRET_REQUEST_TIME, 0);
        int i = SharedPreferencesUtil.getInstance(this.mContext).getInt(SECRET_EXPIRED_TIME, 0);
        if (!TextUtils.isEmpty(this.pubKey) && (System.currentTimeMillis() - j) / 1000 <= ((long) i)) {
            return true;
        }
        this.pubKey = null;
        reset();
        return false;
    }

    private static byte[] decodeBase64(String str) {
        try {
            return Base64.decode(str, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static XmSecretKeyUtil getInstance() {
        if (singleton == null) {
            synchronized (XmSecretKeyUtil.class) {
                if (singleton == null) {
                    singleton = new XmSecretKeyUtil();
                }
            }
        }
        return singleton;
    }

    private static String shortenSecretKey(String str, int i) {
        if (str.length() < i) {
            StringBuilder stringBuilder = new StringBuilder(str);
            while (stringBuilder.length() < i) {
                stringBuilder.append("0");
            }
            str = stringBuilder.toString();
        }
        return str.substring(0, i);
    }

    private void update() {
        DhKeyPair initPartyAKey = DHUtil.initPartyAKey();
        if (initPartyAKey != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(DTransferConstants.PUB_KEY, initPartyAKey.getPublicKey().toString());
            CommonRequest.updateSecret(hashMap, new IDataCallBack<SercretPubKey>() {
                public void onError(int i, String str) {
                    XmSecretKeyUtil.this.reset();
                }

                public void onSuccess(@Nullable SercretPubKey sercretPubKey) {
                    XmSecretKeyUtil.this.updateShareData(sercretPubKey);
                }
            });
        }
    }

    @WorkerThread
    public void conversionModel(TrackBaseInfo trackBaseInfo, boolean z) {
        if (trackBaseInfo != null) {
            byte[] decode;
            if (!checkAuthorized()) {
                updateSync();
            }
            if (z) {
                decode = Base64.decode(FALL_BACK_PUBLIC_KEY, 0);
            } else if (checkAuthorized()) {
                decode = shortenSecretKey(DHUtil.getSecret(this.pubKey, DHUtil.initPartyAKey()), 16).getBytes();
            } else {
                return;
            }
            if (decode != null) {
                try {
                    trackBaseInfo.setDownloadUrl(AESUtil.decryptAsString(decodeBase64(trackBaseInfo.getDownloadUrl()), decode));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    trackBaseInfo.setPlayUrl24M4a(AESUtil.decryptAsString(decodeBase64(trackBaseInfo.getPlayUrl24M4a()), decode));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    trackBaseInfo.setPlayUrl64M4a(AESUtil.decryptAsString(decodeBase64(trackBaseInfo.getPlayUrl64M4a()), decode));
                } catch (Throwable th22) {
                    th22.printStackTrace();
                }
                try {
                    trackBaseInfo.setPlayUrlAmr(AESUtil.decryptAsString(decodeBase64(trackBaseInfo.getPlayUrlAmr()), decode));
                } catch (Throwable th222) {
                    th222.printStackTrace();
                }
                try {
                    trackBaseInfo.setPlayUrl32(AESUtil.decryptAsString(decodeBase64(trackBaseInfo.getPlayUrl32()), decode));
                } catch (Throwable th2222) {
                    th2222.printStackTrace();
                }
                try {
                    trackBaseInfo.setPlayUrl64(AESUtil.decryptAsString(decodeBase64(trackBaseInfo.getPlayUrl64()), decode));
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    public void init(Context context) {
        if (!this.isInited) {
            this.isInited = true;
            this.mContext = context.getApplicationContext();
            this.pubKey = SharedPreferencesUtil.getInstance(this.mContext).getString(SECRET_PUBLIC_KEY);
            if (!checkAuthorized()) {
                update();
            }
        }
    }

    public void reset() {
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(SECRET_REQUEST_TIME);
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(SECRET_EXPIRED_TIME);
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(SECRET_PUBLIC_KEY);
        DHUtil.deleteSaveFile(this.mContext);
    }

    public void updateShareData(SercretPubKey sercretPubKey) {
        if (sercretPubKey != null) {
            this.pubKey = sercretPubKey.getPubKey();
            SharedPreferencesUtil.getInstance(this.mContext).saveString(SECRET_PUBLIC_KEY, this.pubKey);
            SharedPreferencesUtil.getInstance(this.mContext).saveLong(SECRET_REQUEST_TIME, System.currentTimeMillis());
            SharedPreferencesUtil.getInstance(this.mContext).saveInt(SECRET_EXPIRED_TIME, sercretPubKey.getExpiredTime());
            return;
        }
        reset();
    }

    @WorkerThread
    public SercretPubKey updateSync() {
        DhKeyPair initPartyAKey = DHUtil.initPartyAKey();
        if (initPartyAKey == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTransferConstants.PUB_KEY, initPartyAKey.getPublicKey().toString());
        SercretPubKey updateSecretSync = CommonRequest.updateSecretSync(hashMap);
        updateShareData(updateSecretSync);
        return updateSecretSync;
    }
}
