package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseBuilder;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.httputil.IHttpCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.httputil.util.SignatureUtil;
import com.ximalaya.ting.android.opensdk.model.token.AccessToken;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.ximalaya.ting.android.player.MD5;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessTokenManager {
    private static final String ACCESS_TOKEN_PREF = "access_token_pref";
    private static final String AUTH2UID = "auth2uid";
    private static final String CLIENT_ID = "client_id";
    private static final String CURRENT_TIME_PREF = "current_time_pref";
    private static final String DEVICE_ID = "device_id";
    private static final String EXPIRE_IN_PREF = "expire_in_pref";
    private static final String GRANT_TYPE = "grant_type";
    private static final String GRANT_TYPE_VALUE = "client_credentials";
    private static final String NONCE = "nonce";
    public static final String REFRESH_TOKEN_PREF = "refresh_token_pref";
    private static final String SIG = "sig";
    public static final String SIMPLE_REDIRECT_URI = "simple_redirect_uri";
    public static final String SIMPLE_SSO_CODE = "simple_sso_code";
    public static final String THIRD_TOKEN = "xm_thirdToken";
    public static final String THIRD_UID = "xm_thirdUid";
    private static final String TIME_STAMP = "timestamp";
    private static AccessTokenManager mSingleton;
    private Context mContext;
    private CommonRequest$ITokenStateChange mITokenStateChange;
    private AccessToken mToken;
    private String redirectUri;
    private String ssoCode;

    private AccessTokenManager() {
    }

    private boolean checkExpire(long j, long j2) {
        return (System.currentTimeMillis() - j2) / 1000 > j;
    }

    public static AccessTokenManager getInstanse() {
        if (mSingleton == null) {
            synchronized (AccessTokenManager.class) {
                if (mSingleton == null) {
                    mSingleton = new AccessTokenManager();
                }
            }
        }
        return mSingleton;
    }

    public static String getRandomString(int i) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuffer.toString();
    }

    public static void getTokenByThirdAsync() {
        HashMap hashMap = new HashMap();
        hashMap.put("grant_type", "token_exchange");
        long currentTimeMillis = System.currentTimeMillis();
        String str = NONCE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("");
        hashMap.put(str, MD5.md5(stringBuilder.toString()));
        str = TIME_STAMP;
        stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        hashMap.put("third_uid", getInstanse().getThirdUid());
        hashMap.put("third_token", getInstanse().getThirdToken());
        try {
            hashMap.put("client_id", CommonRequest.getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        CommonRequest.basePostRequest(DTransferConstants.GET_THIRD_LOGIN, hashMap, new IDataCallBack<String>() {
            public void onError(int i, String str) {
            }

            public void onSuccess(String str) {
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        AccessTokenManager.getInstanse().setAccessTokenAndUidByThirdType(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"), AccessTokenManager.getInstanse().getThirdUid(), AccessTokenManager.getInstanse().getThirdToken());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new CommonRequest$IRequestCallBack<String>() {
            public String success(String str) throws Exception {
                return str;
            }
        });
    }

    public static void getTokenByThirdSync() throws XimalayaException {
        try {
            Response doSync;
            HashMap hashMap = new HashMap();
            hashMap.put("grant_type", "token_exchange");
            long currentTimeMillis = System.currentTimeMillis();
            String str = NONCE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append("");
            hashMap.put(str, MD5.md5(stringBuilder.toString()));
            str = TIME_STAMP;
            stringBuilder = new StringBuilder();
            stringBuilder.append(currentTimeMillis);
            stringBuilder.append("");
            hashMap.put(str, stringBuilder.toString());
            hashMap.put("third_uid", getInstanse().getThirdUid());
            hashMap.put("third_token", getInstanse().getThirdToken());
            try {
                hashMap.put("client_id", CommonRequest.getInstanse().getAppKey());
            } catch (XimalayaException e) {
                e.printStackTrace();
            }
            try {
                doSync = BaseCall.getInstanse().doSync(BaseBuilder.urlPost(CommonRequest.replaceHttpToHttps(DTransferConstants.GET_THIRD_LOGIN), CommonRequest.CommonParams(hashMap), CommonRequest.getInstanse().getAppsecret()).build());
            } catch (Exception e2) {
                e2.printStackTrace();
                doSync = null;
            }
            if (doSync == null) {
                throw XimalayaException.getExceptionByCode(XimalayaException.GET_TOKEN_FAIL);
            } else if (new BaseResponse(doSync).getStatusCode() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(doSync.body().string());
                    getInstanse().setAccessTokenAndUidByThirdType(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"), getInstanse().getThirdUid(), getInstanse().getThirdToken());
                } catch (Exception unused) {
                    throw XimalayaException.getExceptionByCode(XimalayaException.ERROR_DESC_EMPTY);
                }
            } else {
                throw XimalayaException.getExceptionByCode(XimalayaException.GET_TOKEN_FAIL);
            }
        } catch (Exception unused2) {
            throw XimalayaException.getExceptionByCode(XimalayaException.GET_TOKEN_FAIL);
        }
    }

    public static boolean isThirdToken() {
        return (TextUtils.isEmpty(getInstanse().getThirdToken()) || TextUtils.isEmpty(getInstanse().getThirdUid())) ? false : true;
    }

    private void removeToken() {
        this.mToken = null;
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(ACCESS_TOKEN_PREF);
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(EXPIRE_IN_PREF);
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(CURRENT_TIME_PREF);
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(AUTH2UID);
        SharedPreferencesUtil.getInstance(this.mContext).removeByKey(REFRESH_TOKEN_PREF);
    }

    public synchronized String getAccessToken() {
        if (this.mToken != null) {
            if (!TextUtils.isEmpty(this.mToken.getAccessToken())) {
                return this.mToken.getAccessToken();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    public Map<String, String> getCommonParams() throws XimalayaException {
        HashMap hashMap = new HashMap();
        hashMap.put("client_id", CommonRequest.getInstanse().getAppKey());
        hashMap.put("grant_type", GRANT_TYPE_VALUE);
        hashMap.put("device_id", CommonRequest.getInstanse().getDeviceId());
        hashMap.put(NONCE, getRandomString(9));
        String str = TIME_STAMP;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        hashMap.put(str, stringBuilder.toString());
        hashMap.put("sig", SignatureUtil.generateSignature(CommonRequest.getInstanse().getAppsecret(), hashMap));
        return hashMap;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public String getRefreshToken() {
        return this.mToken != null ? this.mToken.getRefreshToken() : null;
    }

    public String getThirdToken() {
        return getTokenModel().getThirdToken();
    }

    public String getThirdUid() {
        return getTokenModel().getThirdUid();
    }

    public AccessToken getTokenModel() {
        if (this.mToken != null) {
            return this.mToken;
        }
        AccessToken accessToken = new AccessToken();
        this.mToken = accessToken;
        return accessToken;
    }

    public String getUid() {
        return this.mToken != null ? this.mToken.getUid() : "";
    }

    public void init(Context context) {
        this.mContext = context.getApplicationContext();
        this.ssoCode = SharedPreferencesUtil.getInstance(this.mContext).getString(SIMPLE_SSO_CODE);
        this.redirectUri = SharedPreferencesUtil.getInstance(this.mContext).getString(SIMPLE_REDIRECT_URI);
        getTokenModel().setThirdUid(SharedPreferencesUtil.getInstance(this.mContext).getString(THIRD_UID));
        getTokenModel().setThirdToken(SharedPreferencesUtil.getInstance(this.mContext).getString(THIRD_TOKEN));
        if (SharedPreferencesUtil.getInstance(this.mContext).contains(ACCESS_TOKEN_PREF) && SharedPreferencesUtil.getInstance(this.mContext).contains(EXPIRE_IN_PREF)) {
            getTokenModel().setAccessToken(SharedPreferencesUtil.getInstance(this.mContext).getString(ACCESS_TOKEN_PREF));
            getTokenModel().setExpire(SharedPreferencesUtil.getInstance(this.mContext).getLong(EXPIRE_IN_PREF));
            getTokenModel().setLastGetTime(SharedPreferencesUtil.getInstance(this.mContext).getLong(CURRENT_TIME_PREF));
            getTokenModel().setUid(SharedPreferencesUtil.getInstance(this.mContext).getString(AUTH2UID));
            getTokenModel().setRefreshToken(SharedPreferencesUtil.getInstance(this.mContext).getString(REFRESH_TOKEN_PREF));
            if (TextUtils.isEmpty(this.mToken.getAccessToken()) || checkExpire(this.mToken.getExpire(), this.mToken.getLastGetTime())) {
                update();
                return;
            }
            return;
        }
        update();
    }

    public void loginOut(final ILoginOutCallBack iLoginOutCallBack) {
        Builder urlPost;
        try {
            urlPost = BaseBuilder.urlPost(DTransferConstants.SECURE_ACCESS_TOKEN_URL, getInstanse().getCommonParams());
        } catch (XimalayaException e) {
            e.printStackTrace();
            urlPost = null;
        }
        if (urlPost == null) {
            iLoginOutCallBack.onFail(-1, "初始化错误");
        } else {
            BaseCall.getInstanse().doAsync(urlPost.build(), new IHttpCallBack() {
                public void onFailure(int i, String str) {
                    iLoginOutCallBack.onFail(i, str);
                }

                public void onResponse(Response response) {
                    if (response.code() == 200) {
                        try {
                            JSONObject jSONObject = new JSONObject(response.body().string());
                            AccessTokenManager.this.removeToken();
                            AccessTokenManager.this.ssoCode = null;
                            AccessTokenManager.this.redirectUri = null;
                            SharedPreferencesUtil.getInstance(AccessTokenManager.this.mContext).removeByKey(AccessTokenManager.SIMPLE_SSO_CODE);
                            SharedPreferencesUtil.getInstance(AccessTokenManager.this.mContext).removeByKey(AccessTokenManager.SIMPLE_REDIRECT_URI);
                            SharedPreferencesUtil.getInstance(AccessTokenManager.this.mContext).removeByKey(AccessTokenManager.THIRD_TOKEN);
                            SharedPreferencesUtil.getInstance(AccessTokenManager.this.mContext).removeByKey(AccessTokenManager.THIRD_UID);
                            AccessTokenManager.this.setAccessToken(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"));
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    if (iLoginOutCallBack != null) {
                                        iLoginOutCallBack.onSuccess();
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    iLoginOutCallBack.onFail(XimalayaException.PARSE_JSON_ERROR, "parse response json data error");
                                }
                            });
                            return;
                        }
                    }
                    AccessTokenManager.this.removeToken();
                    iLoginOutCallBack.onFail(response.code(), "http 请求出错");
                }
            });
        }
    }

    public void onlyUpdateAccessToken(AccessToken accessToken) {
        this.mToken = accessToken;
    }

    public void saveSSOCode(String str, String str2) {
        this.ssoCode = str;
        this.redirectUri = str2;
        SharedPreferencesUtil.getInstance(this.mContext).saveString(SIMPLE_SSO_CODE, str);
        SharedPreferencesUtil.getInstance(this.mContext).saveString(SIMPLE_REDIRECT_URI, str2);
    }

    /* Access modifiers changed, original: protected */
    public void setAccessToken(String str, long j) {
        removeToken();
        if (!TextUtils.isEmpty(str) && j > 0) {
            getTokenModel().setAccessToken(str);
            getTokenModel().setExpire(j);
            long currentTimeMillis = System.currentTimeMillis();
            getTokenModel().setLastGetTime(currentTimeMillis);
            SharedPreferencesUtil.getInstance(this.mContext).saveString(ACCESS_TOKEN_PREF, str);
            SharedPreferencesUtil.getInstance(this.mContext).saveLong(EXPIRE_IN_PREF, j);
            SharedPreferencesUtil.getInstance(this.mContext).saveLong(CURRENT_TIME_PREF, currentTimeMillis);
            XmPlayerManager.getInstance(this.mContext).setTokenToPlayForSDK(getTokenModel());
        }
    }

    @Deprecated
    public void setAccessTokenAndUid(String str, long j, String str2) {
        setAccessTokenAndUid(str, null, j, str2);
    }

    public void setAccessTokenAndUid(String str, String str2, long j, String str3) {
        if (!TextUtils.isEmpty(str) && j > 0 && !TextUtils.isEmpty(str3)) {
            getTokenModel().setAccessToken(str);
            getTokenModel().setExpire(j);
            getTokenModel().setUid(str3);
            getTokenModel().setRefreshToken(str2);
            long currentTimeMillis = System.currentTimeMillis();
            getTokenModel().setLastGetTime(currentTimeMillis);
            SharedPreferencesUtil.getInstance(this.mContext).saveString(ACCESS_TOKEN_PREF, str);
            SharedPreferencesUtil.getInstance(this.mContext).saveLong(EXPIRE_IN_PREF, j);
            SharedPreferencesUtil.getInstance(this.mContext).saveLong(CURRENT_TIME_PREF, currentTimeMillis);
            SharedPreferencesUtil.getInstance(this.mContext).saveString(AUTH2UID, str3);
            SharedPreferencesUtil.getInstance(this.mContext).saveString(REFRESH_TOKEN_PREF, str2);
            XmPlayerManager.getInstance(this.mContext).setTokenToPlayForSDK(getTokenModel());
        }
    }

    public void setAccessTokenAndUidByThirdType(String str, long j, String str2, String str3) {
        SharedPreferencesUtil.getInstance(this.mContext).saveString(THIRD_TOKEN, str3);
        SharedPreferencesUtil.getInstance(this.mContext).saveString(THIRD_UID, str2);
        getTokenModel().setThirdToken(str3);
        getTokenModel().setThirdUid(str2);
        setAccessTokenAndUid(str, null, j, str2);
    }

    public void setContext(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void setITokenStateChange(CommonRequest$ITokenStateChange commonRequest$ITokenStateChange) {
        this.mITokenStateChange = commonRequest$ITokenStateChange;
    }

    public void update() {
        boolean tokenByRefreshAsync = this.mITokenStateChange != null ? this.mITokenStateChange.getTokenByRefreshAsync() : false;
        if (this.mITokenStateChange != null && !tokenByRefreshAsync) {
            removeToken();
            this.mITokenStateChange.tokenLosted();
        } else if (this.mITokenStateChange == null || !tokenByRefreshAsync) {
            removeToken();
            if (isThirdToken()) {
                getTokenByThirdAsync();
                return;
            }
            Builder builder = null;
            try {
                builder = BaseBuilder.urlPost(DTransferConstants.SECURE_ACCESS_TOKEN_URL, getInstanse().getCommonParams());
            } catch (XimalayaException unused) {
            }
            if (builder != null) {
                BaseCall.getInstanse().doAsync(builder.build(), new IHttpCallBack() {
                    public void onFailure(int i, String str) {
                    }

                    public void onResponse(Response response) {
                        if (response.code() == 200) {
                            try {
                                JSONObject jSONObject = new JSONObject(response.body().string());
                                AccessTokenManager.this.setAccessToken(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"));
                                return;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        }
                        AccessTokenManager.this.removeToken();
                    }
                });
            }
        }
    }
}
