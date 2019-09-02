package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.support.v4.os.EnvironmentCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import cn.jiguang.net.HttpUtils;
import com.baidu.mapapi.SDKInitializer;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class AidTask {
    private static final String AID_FILE_NAME = "weibo_sdk_aid";
    public static final String AID_TAG = "weibo_aid_value";
    private static final int MAX_RETRY_NUM = 3;
    private static final String TAG = "AidTask";
    private static final int VERSION = 1;
    public static final int WHAT_LOAD_AID_ERR = 1002;
    public static final int WHAT_LOAD_AID_SUC = 1001;
    private static AidTask sInstance;
    private String hash;
    private AidInfo mAidInfo;
    private String mAppKey;
    private Context mContext;
    private CallbackHandler mHandler;
    private ArrayList<WeiboUtilListener> mListeners = new ArrayList();
    private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
    private String pkg;

    public static final class AidInfo {
        private String mAid;
        private String mSubCookie;

        public static AidInfo parseJson(String str) throws WeiboException {
            AidInfo aidInfo = new AidInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("error")) {
                    if (!jSONObject.has(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE)) {
                        aidInfo.mAid = jSONObject.optString("aid", "");
                        aidInfo.mSubCookie = jSONObject.optString("sub", "");
                        return aidInfo;
                    }
                }
                LogUtil.d(AidTask.TAG, "loadAidFromNet has error !!!");
                throw new WeiboException("loadAidFromNet has error !!!");
            } catch (JSONException e) {
                String str2 = AidTask.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("loadAidFromNet JSONException Msg : ");
                stringBuilder.append(e.getMessage());
                LogUtil.d(str2, stringBuilder.toString());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        /* Access modifiers changed, original: 0000 */
        public AidInfo cloneAidInfo() {
            AidInfo aidInfo = new AidInfo();
            aidInfo.mAid = this.mAid;
            aidInfo.mSubCookie = this.mSubCookie;
            return aidInfo;
        }

        public String getAid() {
            return this.mAid;
        }

        public String getSubCookie() {
            return this.mSubCookie;
        }
    }

    public interface AidResultCallBack {
        void onAidGenFailed(Exception exception);

        void onAidGenSuccessed(AidInfo aidInfo);
    }

    private static class CallbackHandler extends Handler {
        private WeakReference<AidResultCallBack> callBackReference;

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            AidResultCallBack aidResultCallBack = (AidResultCallBack) this.callBackReference.get();
            switch (message.what) {
                case 1001:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenSuccessed(((AidInfo) message.obj).cloneAidInfo());
                        return;
                    }
                    return;
                case 1002:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenFailed((WeiboException) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void setCallback(AidResultCallBack aidResultCallBack) {
            if (this.callBackReference == null) {
                this.callBackReference = new WeakReference(aidResultCallBack);
            } else if (((AidResultCallBack) this.callBackReference.get()) != aidResultCallBack) {
                this.callBackReference = new WeakReference(aidResultCallBack);
            }
        }
    }

    private AidTask(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1; i++) {
                        try {
                            AidTask.this.getAidInfoFile(i).delete();
                        } catch (Exception unused) {
                        }
                    }
                }
            }).start();
        }
    }

    private void aidTaskInit(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "aidTaskInit ");
            initAidInfo(str, str2, str3);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x002c */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x002f A:{SYNTHETIC, Splitter:B:26:0x002f} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0029 A:{SYNTHETIC, Splitter:B:20:0x0029} */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|(0)|22|23) */
    private synchronized void cacheAidInfo(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);
        return;
    L_0x0009:
        r0 = 0;
        r1 = 1;
        r1 = r3.getAidInfoFile(r1);	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x002d, all -> 0x0026 }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0024, all -> 0x0021 }
        r2.write(r4);	 Catch:{ Exception -> 0x0024, all -> 0x0021 }
        if (r2 == 0) goto L_0x0032;
    L_0x001d:
        r2.close();	 Catch:{ IOException -> 0x0032 }
        goto L_0x0032;
    L_0x0021:
        r4 = move-exception;
        r0 = r2;
        goto L_0x0027;
    L_0x0024:
        r0 = r2;
        goto L_0x002d;
    L_0x0026:
        r4 = move-exception;
    L_0x0027:
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r0.close();	 Catch:{ IOException -> 0x002c }
    L_0x002c:
        throw r4;	 Catch:{ all -> 0x0034 }
    L_0x002d:
        if (r0 == 0) goto L_0x0032;
    L_0x002f:
        r0.close();	 Catch:{ IOException -> 0x0032 }
    L_0x0032:
        monitor-exit(r3);
        return;
    L_0x0034:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask.cacheAidInfo(java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c7 A:{SYNTHETIC, Splitter:B:19:0x00c7} */
    private static java.lang.String encryptRsa(java.lang.String r7, java.lang.String r8) throws java.lang.Exception {
        /*
        r0 = "RSA/ECB/PKCS1Padding";
        r0 = javax.crypto.Cipher.getInstance(r0);
        r8 = getPublicKey(r8);
        r1 = 1;
        r0.init(r1, r8);
        r8 = "UTF-8";
        r7 = r7.getBytes(r8);
        r8 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x00c3 }
        r1.<init>();	 Catch:{ all -> 0x00c3 }
        r8 = 0;
    L_0x001b:
        r2 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r2 = splite(r7, r8, r2);	 Catch:{ all -> 0x00c1 }
        r3 = -1;
        if (r2 == r3) goto L_0x0054;
    L_0x0024:
        r3 = r0.doFinal(r7, r8, r2);	 Catch:{ all -> 0x00c1 }
        r1.write(r3);	 Catch:{ all -> 0x00c1 }
        r4 = "AidTask";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c1 }
        r5.<init>();	 Catch:{ all -> 0x00c1 }
        r6 = "encryptRsa offset = ";
        r5.append(r6);	 Catch:{ all -> 0x00c1 }
        r5.append(r8);	 Catch:{ all -> 0x00c1 }
        r6 = "     len = ";
        r5.append(r6);	 Catch:{ all -> 0x00c1 }
        r5.append(r2);	 Catch:{ all -> 0x00c1 }
        r6 = "     enBytes len = ";
        r5.append(r6);	 Catch:{ all -> 0x00c1 }
        r3 = r3.length;	 Catch:{ all -> 0x00c1 }
        r5.append(r3);	 Catch:{ all -> 0x00c1 }
        r3 = r5.toString();	 Catch:{ all -> 0x00c1 }
        com.sina.weibo.sdk.utils.LogUtil.d(r4, r3);	 Catch:{ all -> 0x00c1 }
        r8 = r8 + r2;
        goto L_0x001b;
    L_0x0054:
        r1.flush();	 Catch:{ all -> 0x00c1 }
        r7 = r1.toByteArray();	 Catch:{ all -> 0x00c1 }
        r8 = "AidTask";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c1 }
        r0.<init>();	 Catch:{ all -> 0x00c1 }
        r2 = "encryptRsa total enBytes len = ";
        r0.append(r2);	 Catch:{ all -> 0x00c1 }
        r2 = r7.length;	 Catch:{ all -> 0x00c1 }
        r0.append(r2);	 Catch:{ all -> 0x00c1 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c1 }
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r0);	 Catch:{ all -> 0x00c1 }
        r7 = com.sina.weibo.sdk.utils.Base64.encodebyte(r7);	 Catch:{ all -> 0x00c1 }
        r8 = "AidTask";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c1 }
        r0.<init>();	 Catch:{ all -> 0x00c1 }
        r2 = "encryptRsa total base64byte len = ";
        r0.append(r2);	 Catch:{ all -> 0x00c1 }
        r2 = r7.length;	 Catch:{ all -> 0x00c1 }
        r0.append(r2);	 Catch:{ all -> 0x00c1 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c1 }
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r0);	 Catch:{ all -> 0x00c1 }
        r8 = new java.lang.String;	 Catch:{ all -> 0x00c1 }
        r0 = "UTF-8";
        r8.<init>(r7, r0);	 Catch:{ all -> 0x00c1 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c1 }
        r7.<init>();	 Catch:{ all -> 0x00c1 }
        r0 = "01";
        r7.append(r0);	 Catch:{ all -> 0x00c1 }
        r7.append(r8);	 Catch:{ all -> 0x00c1 }
        r7 = r7.toString();	 Catch:{ all -> 0x00c1 }
        r8 = "AidTask";
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c1 }
        r0.<init>();	 Catch:{ all -> 0x00c1 }
        r2 = "encryptRsa total base64string : ";
        r0.append(r2);	 Catch:{ all -> 0x00c1 }
        r0.append(r7);	 Catch:{ all -> 0x00c1 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c1 }
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r0);	 Catch:{ all -> 0x00c1 }
        if (r1 == 0) goto L_0x00c0;
    L_0x00bd:
        r1.close();	 Catch:{ IOException -> 0x00c0 }
    L_0x00c0:
        return r7;
    L_0x00c1:
        r7 = move-exception;
        goto L_0x00c5;
    L_0x00c3:
        r7 = move-exception;
        r1 = r8;
    L_0x00c5:
        if (r1 == 0) goto L_0x00ca;
    L_0x00c7:
        r1.close();	 Catch:{ IOException -> 0x00ca }
    L_0x00ca:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask.encryptRsa(java.lang.String, java.lang.String):java.lang.String");
    }

    private static String genMfpString(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence generateUAAid;
            String os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("1", os);
            }
            os = getImei(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("2", os);
            }
            os = getMeid(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("3", os);
            }
            os = getImsi(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("4", os);
            }
            os = getMac(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("5", os);
            }
            os = getIccid(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_INFO, os);
            }
            os = getSerialNo();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("7", os);
            }
            os = getAndroidId(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, os);
            }
            os = getCpu();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, os);
            }
            os = getModel();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, os);
            }
            os = getSdSize();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, os);
            }
            os = getResolution(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, os);
            }
            os = getSsid(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, os);
            }
            os = getDeviceName();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("18", os);
            }
            os = getConnectType(context);
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, os);
            }
            os = "";
            try {
                generateUAAid = Utility.generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
                generateUAAid = os;
            }
            if (!TextUtils.isEmpty(generateUAAid)) {
                jSONObject.put("20", generateUAAid);
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private void generateAid(String str, AidResultCallBack aidResultCallBack) {
        generateAid(str, null, null, aidResultCallBack);
    }

    private void generateAid(String str, String str2, String str3, final AidResultCallBack aidResultCallBack) {
        if (!TextUtils.isEmpty(str)) {
            this.mAppKey = str;
            this.hash = str3;
            this.pkg = str2;
            new Thread(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
                /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
                /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
                public void run() {
                    /*
                    r5 = this;
                    r0 = com.sina.weibo.sdk.utils.AidTask.this;
                    r0 = r0.mTaskLock;
                    r0.lock();
                    r0 = com.sina.weibo.sdk.utils.AidTask.this;
                    r0 = r0.loadAidInfoFromCache();
                    r1 = 0;
                    if (r0 != 0) goto L_0x0047;
                L_0x0012:
                    r2 = com.sina.weibo.sdk.utils.AidTask.this;	 Catch:{ WeiboException -> 0x002c }
                    r2 = r2.loadAidFromNet();	 Catch:{ WeiboException -> 0x002c }
                    r3 = com.sina.weibo.sdk.utils.AidTask.AidInfo.parseJson(r2);	 Catch:{ WeiboException -> 0x002c }
                    r0 = com.sina.weibo.sdk.utils.AidTask.this;	 Catch:{ WeiboException -> 0x0028 }
                    r0.cacheAidInfo(r2);	 Catch:{ WeiboException -> 0x0028 }
                    r0 = com.sina.weibo.sdk.utils.AidTask.this;	 Catch:{ WeiboException -> 0x0028 }
                    r0.mAidInfo = r3;	 Catch:{ WeiboException -> 0x0028 }
                    r0 = r3;
                    goto L_0x0047;
                L_0x0028:
                    r0 = move-exception;
                    r1 = r0;
                    r0 = r3;
                    goto L_0x002d;
                L_0x002c:
                    r1 = move-exception;
                L_0x002d:
                    r2 = "AidTask";
                    r3 = new java.lang.StringBuilder;
                    r3.<init>();
                    r4 = "AidTaskInit WeiboException Msg : ";
                    r3.append(r4);
                    r4 = r1.getMessage();
                    r3.append(r4);
                    r3 = r3.toString();
                    com.sina.weibo.sdk.utils.LogUtil.e(r2, r3);
                L_0x0047:
                    r2 = com.sina.weibo.sdk.utils.AidTask.this;
                    r2 = r2.mTaskLock;
                    r2.unlock();
                    r2 = android.os.Message.obtain();
                    if (r0 == 0) goto L_0x005d;
                L_0x0056:
                    r1 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
                    r2.what = r1;
                    r2.obj = r0;
                    goto L_0x0063;
                L_0x005d:
                    r0 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
                    r2.what = r0;
                    r2.obj = r1;
                L_0x0063:
                    r0 = com.sina.weibo.sdk.utils.AidTask.this;
                    r0 = r0.mHandler;
                    r1 = r5;
                    r0.setCallback(r1);
                    r0 = com.sina.weibo.sdk.utils.AidTask.this;
                    r0 = r0.mHandler;
                    r0.sendMessage(r2);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask$AnonymousClass3.run():void");
                }
            }).start();
        }
    }

    private File getAidInfoFile(int i) {
        File filesDir = this.mContext.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AID_FILE_NAME);
        stringBuilder.append(i);
        return new File(filesDir, stringBuilder.toString());
    }

    private static String getAndroidId(Context context) {
        try {
            return Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getConnectType(Context context) {
        String str = "none";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            String str2;
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str2 = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str2 = "3G";
                        break;
                    case 13:
                        str2 = "4G";
                        break;
                    default:
                        str2 = "none";
                        break;
                }
            } else if (activeNetworkInfo.getType() != 1) {
                return str;
            } else {
                str2 = "wifi";
            }
            return str2;
        } catch (Exception unused) {
            return str;
        }
    }

    private static String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized AidTask getInstance(Context context) {
        AidTask aidTask;
        synchronized (AidTask.class) {
            if (sInstance == null) {
                sInstance = new AidTask(context);
            }
            aidTask = sInstance;
        }
        return aidTask;
    }

    private static String getMac(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getMacAddress() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getMeid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getMfp(Context context) {
        String str = "";
        try {
            str = new String(genMfpString(context).getBytes(), HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
        }
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("genMfpString() utf-8 string : ");
        stringBuilder.append(str);
        LogUtil.d(str2, stringBuilder.toString());
        try {
            str2 = encryptRsa(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("encryptRsa() string : ");
            stringBuilder.append(str2);
            LogUtil.d(str, stringBuilder.toString());
            return str2;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getOS() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Android ");
            stringBuilder.append(VERSION.RELEASE);
            return stringBuilder.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
    }

    private static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(displayMetrics.widthPixels));
            stringBuilder.append("*");
            stringBuilder.append(String.valueOf(displayMetrics.heightPixels));
            return stringBuilder.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getSerialNo() {
        String str = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{"ro.serialno", EnvironmentCompat.MEDIA_UNKNOWN});
        } catch (Exception unused) {
            return str;
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private void initAidInfo(String str) {
        initAidInfo(str, null, null);
    }

    private String loadAidFromNet() throws WeiboException {
        String packageName = this.pkg == null ? this.mContext.getPackageName() : this.pkg;
        String sign = this.hash == null ? Utility.getSign(this.mContext, packageName) : this.hash;
        String mfp = getMfp(this.mContext);
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put(LogBuilder.KEY_APPKEY, this.mAppKey);
        weiboParameters.put("mfp", mfp);
        weiboParameters.put("packagename", packageName);
        weiboParameters.put("key_hash", sign);
        StringBuilder stringBuilder;
        try {
            packageName = HttpManager.openUrl(this.mContext, "https://api.weibo.com/oauth2/getaid.json", Constants.HTTP_GET, weiboParameters);
            sign = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("loadAidFromNet response : ");
            stringBuilder.append(packageName);
            LogUtil.d(sign, stringBuilder.toString());
            return packageName;
        } catch (WeiboException e) {
            sign = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("loadAidFromNet WeiboException Msg : ");
            stringBuilder.append(e.getMessage());
            LogUtil.d(sign, stringBuilder.toString());
            throw e;
        }
    }

    private void notifyListener(AidInfo aidInfo) {
        Bundle bundle = new Bundle();
        if (aidInfo != null) {
            bundle.putString(AID_TAG, aidInfo.getAid());
        }
        try {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                for (int i = 0; i < this.mListeners.size(); i++) {
                    ((WeiboUtilListener) this.mListeners.get(i)).onComplete(bundle);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int splite(byte[] bArr, int i, int i2) {
        return i >= bArr.length ? -1 : Math.min(bArr.length - i, i2);
    }

    public void addListener(WeiboUtilListener weiboUtilListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(weiboUtilListener);
    }

    public void aidTaskInit(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "aidTaskInit ");
            initAidInfo(str);
        }
    }

    public void getAidAsync(String str, AidResultCallBack aidResultCallBack) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mAidInfo == null || aidResultCallBack == null) {
                generateAid(str, aidResultCallBack);
            } else {
                aidResultCallBack.onAidGenSuccessed(this.mAidInfo.cloneAidInfo());
            }
        }
    }

    public AidInfo getAidSync(String str) throws WeiboException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.e(TAG, "getAidSync ");
        if (this.mAidInfo == null) {
            aidTaskInit(str);
        }
        return this.mAidInfo;
    }

    public void initAidInfo(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            this.mAppKey = str;
            this.pkg = str2;
            this.hash = str3;
            new Thread(new Runnable() {
                public void run() {
                    if (AidTask.this.mTaskLock.tryLock()) {
                        AidInfo loadAidInfoFromCache = AidTask.this.loadAidInfoFromCache();
                        if (loadAidInfoFromCache == null) {
                            int i = 1;
                            do {
                                i++;
                                try {
                                    String access$200 = AidTask.this.loadAidFromNet();
                                    AidInfo parseJson = AidInfo.parseJson(access$200);
                                    AidTask.this.cacheAidInfo(access$200);
                                    AidTask.this.mAidInfo = parseJson;
                                    AidTask.this.notifyListener(AidTask.this.mAidInfo);
                                    break;
                                } catch (WeiboException e) {
                                    String str = AidTask.TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("AidTaskInit WeiboException Msg : ");
                                    stringBuilder.append(e.getMessage());
                                    LogUtil.e(str, stringBuilder.toString());
                                    if (i >= 3) {
                                    }
                                }
                            } while (i >= 3);
                        } else {
                            AidTask.this.mAidInfo = loadAidInfoFromCache;
                        }
                        AidTask.this.mTaskLock.unlock();
                        return;
                    }
                    LogUtil.e(AidTask.TAG, "tryLock : false, return");
                }
            }).start();
        }
    }

    public String loadAidFromCache() {
        AidInfo loadAidInfoFromCache = loadAidInfoFromCache();
        if (loadAidInfoFromCache == null) {
            return "";
        }
        return loadAidInfoFromCache.getAid() == null ? "" : loadAidInfoFromCache.getAid();
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A:{SYNTHETIC, Splitter:B:24:0x0032} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b A:{SYNTHETIC, Splitter:B:16:0x002b} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002e */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public synchronized com.sina.weibo.sdk.utils.AidTask.AidInfo loadAidInfoFromCache() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 1;
        r1 = 0;
        r0 = r4.getAidInfoFile(r0);	 Catch:{ Exception -> 0x002f, all -> 0x0027 }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x002f, all -> 0x0027 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x002f, all -> 0x0027 }
        r0 = r2.available();	 Catch:{ Exception -> 0x0030, all -> 0x0025 }
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0030, all -> 0x0025 }
        r2.read(r0);	 Catch:{ Exception -> 0x0030, all -> 0x0025 }
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x0030, all -> 0x0025 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0030, all -> 0x0025 }
        r0 = com.sina.weibo.sdk.utils.AidTask.AidInfo.parseJson(r3);	 Catch:{ Exception -> 0x0030, all -> 0x0025 }
        if (r2 == 0) goto L_0x0023;
    L_0x0020:
        r2.close();	 Catch:{ IOException -> 0x0023 }
    L_0x0023:
        monitor-exit(r4);
        return r0;
    L_0x0025:
        r0 = move-exception;
        goto L_0x0029;
    L_0x0027:
        r0 = move-exception;
        r2 = r1;
    L_0x0029:
        if (r2 == 0) goto L_0x002e;
    L_0x002b:
        r2.close();	 Catch:{ IOException -> 0x002e }
    L_0x002e:
        throw r0;	 Catch:{ all -> 0x0036 }
    L_0x002f:
        r2 = r1;
    L_0x0030:
        if (r2 == 0) goto L_0x0039;
    L_0x0032:
        r2.close();	 Catch:{ IOException -> 0x0039 }
        goto L_0x0039;
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0039:
        monitor-exit(r4);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.AidTask.loadAidInfoFromCache():com.sina.weibo.sdk.utils.AidTask$AidInfo");
    }

    public void removeListener(WeiboUtilListener weiboUtilListener) {
        if (this.mListeners != null && this.mListeners.size() > 0) {
            this.mListeners.remove(weiboUtilListener);
        }
    }

    public synchronized void setAppkey(String str) {
        this.mAppKey = str;
    }
}
