package com.zjwh.android_wh_physicalfitness.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecurityCipher;
import com.alibaba.wireless.security.jaq.SecuritySignature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qiyukf.unicorn.api.Unicorn;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.UploadFormatEntity;
import com.zjwh.android_wh_physicalfitness.entity.UploadSignEntity;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.service.BluetoothService;
import defpackage.eb;
import defpackage.gg;
import defpackage.gj;
import defpackage.kf;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.ex.HttpException;
import org.xutils.http.HttpMethod;
import org.xutils.x;

public class HttpUtil {
    private static int AUTHORITY_ERR = 401;
    private static int DECRYPT_ERR = -999;
    private static int NETWORK_ERR = 666;
    private static int REQUEST_TYPE_GET = 1;
    private static int REQUEST_TYPE_GET_OPTION = 3;
    private static int REQUEST_TYPE_POST = 2;
    private static int REQUEST_TYPE_POST_OPTION = 4;
    private static int RESOURCE_ERR = 404;
    private static int RESULT_ERR = 400;
    private static int SERVICE_ERR = 500;
    private static int UNKNOWN_ERR = 402;
    private static Gson gson = new GsonBuilder().registerTypeAdapter(Double.class, new eb()).create();
    public static boolean isLogging;
    private static SSLContext s_sSLContext;

    public interface MyCallback<ResultType> extends Callback {
        void onCancelled(CancelledException cancelledException);

        void onError(ResponseError responseError);

        void onFinished();

        void onSuccess(ResultType resultType);
    }

    public interface CacheCallback extends MyCallback<String> {
        boolean onCache(String str);
    }

    private static void clearLoginMessage(Context context) {
        try {
            O000o0.O00000Oo();
            Unicorn.logout();
            ((NotificationManager) context.getSystemService("notification")).cancelAll();
            kf.O00000Oo();
            context.stopService(new Intent(context, BluetoothService.class));
            O00O0Oo0.O000000o(gg.O000o0O0);
            O00O0Oo0.O000000o(gg.O000o0O);
            O00O0Oo0.O000000o("receiver_broadcast");
            O00O0Oo0.O000000o(RunRuleModel.SP_KEY_MIN_DISTANCE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void error(Context context, Throwable th, int i, MyCallback<String> myCallback) {
        ResponseError responseError = new ResponseError();
        int code;
        if (th instanceof HttpException) {
            code = ((HttpException) th).getCode();
            if (code == SERVICE_ERR) {
                responseError.setError(SERVICE_ERR);
                responseError.setMessage(context.getString(R.string.network_error));
                myCallback.onError(responseError);
            } else if (code == RESOURCE_ERR) {
                responseError.setError(RESOURCE_ERR);
                responseError.setMessage(context.getString(R.string.network_error));
                myCallback.onError(responseError);
            } else if (code != AUTHORITY_ERR) {
                responseError.setError(RESULT_ERR);
                responseError.setMessage(context.getString(R.string.network_error));
                myCallback.onError(responseError);
            } else if (!isLogging) {
                isLogging = true;
                clearLoginMessage(context);
                O00000Oo.O000000o(context.getApplicationContext());
            }
        } else if (th instanceof SocketTimeoutException) {
            responseError.setError(RESULT_ERR);
            responseError.setMessage(context.getString(R.string.network_time_out));
            myCallback.onError(responseError);
        } else if ((th instanceof ConnectException) || (th instanceof UnknownHostException)) {
            responseError.setError(RESULT_ERR);
            code = (i == REQUEST_TYPE_POST_OPTION || i == REQUEST_TYPE_GET_OPTION) ? R.string.network_connected_error : R.string.txt_check_network;
            responseError.setMessage(context.getString(code));
            myCallback.onError(responseError);
        } else {
            responseError.setError(UNKNOWN_ERR);
            responseError.setMessage(context.getString(R.string.network_error));
            myCallback.onError(responseError);
        }
    }

    public static Cancelable get(Context context, gj gjVar, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().get(gjVar, getCallback(context, myCallback, REQUEST_TYPE_GET, true));
    }

    public static Cancelable get2test(Context context, gj gjVar, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().get(gjVar, getCallback(context, myCallback, REQUEST_TYPE_GET, false, true));
    }

    private static CommonCallback<String> getCacheCallback(Context context, CacheCallback cacheCallback, int i, boolean z, boolean z2) {
        final Context context2 = context;
        final boolean z3 = z;
        final boolean z4 = z2;
        final CacheCallback cacheCallback2 = cacheCallback;
        final int i2 = i;
        return new CommonCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                cacheCallback2.onCancelled(cancelledException);
            }

            public void onError(Throwable th, boolean z) {
                HttpUtil.error(context2, th, i2, cacheCallback2);
            }

            public void onFinished() {
                cacheCallback2.onFinished();
            }

            public void onSuccess(String str) {
                if (str != null) {
                    HttpUtil.success(context2, z3, z4, str, cacheCallback2);
                }
            }
        };
    }

    private static CommonCallback<String> getCallback(Context context, MyCallback<String> myCallback, int i, boolean z) {
        return getCallback(context, myCallback, i, true, z);
    }

    private static CommonCallback<String> getCallback(Context context, MyCallback<String> myCallback, int i, boolean z, boolean z2) {
        final Context context2 = context;
        final boolean z3 = z;
        final boolean z4 = z2;
        final MyCallback<String> myCallback2 = myCallback;
        final int i2 = i;
        return new CommonCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                myCallback2.onCancelled(cancelledException);
            }

            public void onError(Throwable th, boolean z) {
                HttpUtil.error(context2, th, i2, myCallback2);
            }

            public void onFinished() {
                myCallback2.onFinished();
            }

            public void onSuccess(String str) {
                HttpUtil.success(context2, z3, z4, str, myCallback2);
            }
        };
    }

    public static Cancelable getOp(Context context, gj gjVar, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().get(gjVar, getCallback(context, myCallback, REQUEST_TYPE_GET_OPTION, true));
    }

    private static SSLContext getSSLContext(Context context) {
        if (s_sSLContext != null) {
            return s_sSLContext;
        }
        try {
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(context.getAssets().open("leichi.crt"));
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            instance.setCertificateEntry("ca", generateCertificate);
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance2.init(instance);
            s_sSLContext = SSLContext.getInstance("TLS");
            s_sSLContext.init(null, instance2.getTrustManagers(), null);
            return s_sSLContext;
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cancelable post(Context context, gj gjVar, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().post(gjVar, getCallback(context, myCallback, REQUEST_TYPE_POST, true));
    }

    public static Cancelable post(Context context, gj gjVar, boolean z, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().post(gjVar, getCallback(context, myCallback, REQUEST_TYPE_POST, z));
    }

    public static Cancelable post2test(Context context, gj gjVar, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().post(gjVar, getCallback(context, myCallback, REQUEST_TYPE_POST, false, true));
    }

    public static Cancelable postCache(Context context, gj gjVar, CacheCallback cacheCallback) {
        setHeader(context, gjVar);
        return x.http().post(gjVar, getCacheCallback(context, cacheCallback, REQUEST_TYPE_POST, true, true));
    }

    public static Cancelable postOp(Context context, gj gjVar, MyCallback<String> myCallback) {
        setHeader(context, gjVar);
        return x.http().post(gjVar, getCallback(context, myCallback, REQUEST_TYPE_POST_OPTION, true));
    }

    public static Cancelable postSportRecord(Context context, gj gjVar, Map<String, String> map, MyCallback<String> myCallback) {
        setHeader(context, gjVar, map);
        return x.http().post(gjVar, getCallback(context, myCallback, REQUEST_TYPE_POST_OPTION, true));
    }

    public static boolean send(Context context, gj gjVar, CommonCallback commonCallback) {
        SSLContext sSLContext = getSSLContext(context);
        if (sSLContext == null) {
            return false;
        }
        gjVar.setSslSocketFactory(sSLContext.getSocketFactory());
        x.http().request(HttpMethod.POST, gjVar, commonCallback);
        return true;
    }

    public static void setAuthorization(gj gjVar) {
        UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 != null) {
            String username = O00000o0.getUsername();
            String psw = O00000o0.getPsw();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Basic ");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(username);
            stringBuilder2.append(":");
            stringBuilder2.append(psw);
            stringBuilder.append(O0000Oo0.O000000o(stringBuilder2.toString()));
            gjVar.setHeader("Authorization", stringBuilder.toString());
        }
    }

    private static void setHeader(Context context, gj gjVar) {
        setHeader(context, gjVar, null);
    }

    private static void setHeader(Context context, gj gjVar, Map<String, String> map) {
        Object obj = "";
        CharSequence charSequence = (String) O00O0Oo0.O00000o0(gg.O000o0O0, "");
        int intValue = ((Integer) O00O0Oo0.O00000o0(gg.O000o0O, Integer.valueOf(-1))).intValue();
        if (TextUtils.isEmpty(charSequence) || intValue == -1) {
            UserInfo O00000o0 = O00Oo0.O00000o0();
            if (!(O00000o0 == null || O00000o0.isLogout())) {
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = O00000o0.getToken();
                }
                if (intValue == -1) {
                    intValue = O00000o0.getUid();
                }
                O00O0Oo0.O000000o(gg.O000o0O0, TextUtils.isEmpty(charSequence) ? "" : charSequence);
                O00O0Oo0.O000000o(gg.O000o0O, Integer.valueOf(intValue));
            }
        }
        Object obj2 = (String) O00O0Oo0.O000000o(context, "CustomDeviceId", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        String stringBuilder2 = stringBuilder.toString();
        if (TextUtils.isEmpty(obj2)) {
            obj2 = O00Oo0.O00000Oo(context, stringBuilder2);
            O00O0Oo0.O000000o("CustomDeviceId", obj2 == null ? "" : obj2);
        }
        if (!TextUtils.isEmpty(charSequence) && intValue >= 0) {
            Map arrayMap = new ArrayMap();
            arrayMap.put("timeStamp", stringBuilder2);
            arrayMap.put("token", charSequence);
            arrayMap.put("uid", Integer.valueOf(intValue));
            try {
                obj = new SecuritySignature(context.getApplicationContext()).atlasSign(O00O0o.O000000o(arrayMap), context.getString(R.string.ali_app_key));
            } catch (JAQException e) {
                e.printStackTrace();
                x.O00000Oo(MyApplication.O000000o(), "header tokenSign ali sign error!");
            }
        }
        gjVar.setAsJsonContent(true);
        gjVar.setHeader("Accept", "application/json");
        gjVar.setHeader("Content-Type", "application/json");
        gjVar.setHeader("appVersion", O00Oo0.O00000Oo());
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("DeviceId", O00Oo0.O000000o());
        arrayMap2.put("osVersion", O000OO.O00000o0());
        arrayMap2.put("deviceName", O000OO.O0000OOo());
        arrayMap2.put("osType", "0");
        arrayMap2.put("CustomDeviceId", obj2);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(intValue);
        stringBuilder3.append("");
        arrayMap2.put("uid", stringBuilder3.toString());
        arrayMap2.put("token", charSequence);
        arrayMap2.put("timeStamp", stringBuilder2);
        arrayMap2.put("tokenSign", obj);
        arrayMap2.put("IMEI", O000OO.O0000Oo());
        arrayMap2.put("logicPixel", O000OO.O00000oo());
        arrayMap2.put("physicPixel", O000OO.O00000oO());
        arrayMap2.put("androidId", O000OO.O0000Oo0());
        arrayMap2.put("blMac", O000OO.O0000o0O());
        arrayMap2.put("wifiMac", O000OO.O0000o0o());
        arrayMap2.put("cpuModel", O000OO.O0000o0());
        arrayMap2.put("isRoot", String.valueOf(O000OO.O0000oOo()));
        arrayMap2.put("appUpdateTime", String.valueOf(O000OO.O0000o00()));
        arrayMap2.put("appInstallTime", String.valueOf(O000OO.O0000Ooo()));
        arrayMap2.put("nonce", O00Oo0.O0000Oo0());
        if (map != null) {
            arrayMap2.putAll(map);
        }
        try {
            gjVar.setHeader("headerSign", new SecurityCipher(context).atlasEncryptString(new JSONObject(arrayMap2).toString()));
        } catch (JAQException e2) {
            e2.printStackTrace();
        }
        gjVar.setConnectTimeout(15000);
    }

    public static String signRunRecord(UploadFormatEntity uploadFormatEntity, boolean z) {
        try {
            Map mapParams = new UploadSignEntity(uploadFormatEntity).getMapParams();
            if (z) {
                mapParams.put(gg.O0000Ooo, Integer.valueOf(uploadFormatEntity.getRoomId()));
            }
            String str = "";
            try {
                str = new SecuritySignature(MyApplication.O000000o()).atlasSign(O00O0o.O000000o(mapParams), MyApplication.O000000o().getString(R.string.ali_app_key));
            } catch (JAQException e) {
                e.printStackTrace();
            }
            uploadFormatEntity.setSignature(str);
            mapParams.clear();
            return O000o000.O000000o((Object) uploadFormatEntity);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String singDraw(int i, int i2) {
        Map arrayMap = new ArrayMap();
        arrayMap.put("drawType", Integer.valueOf(i));
        arrayMap.put("rrid", Integer.valueOf(i2));
        String str = "";
        try {
            str = new SecuritySignature(MyApplication.O000000o()).atlasSign(O00O0o.O000000o(arrayMap), MyApplication.O000000o().getString(R.string.ali_app_key));
        } catch (JAQException e) {
            e.printStackTrace();
        }
        arrayMap.clear();
        return str;
    }

    private static void success(Context context, boolean z, boolean z2, String str, MyCallback<String> myCallback) {
        ResponseError responseError;
        SecurityCipher securityCipher = new SecurityCipher(context);
        if (z) {
            try {
                str = securityCipher.decryptString(str.trim(), context.getString(R.string.ali_app_key));
                if (TextUtils.isEmpty(str)) {
                    throw new JAQException(DECRYPT_ERR);
                }
            } catch (Exception e) {
                e.printStackTrace();
                responseError = new ResponseError();
                responseError.setError(DECRYPT_ERR);
                responseError.setMessage("数据解析异常");
                myCallback.onError(responseError);
                return;
            }
        }
        responseError = (ResponseError) gson.fromJson(str, ResponseError.class);
        if (responseError.getError() == 10000) {
            myCallback.onSuccess(gson.toJson(responseError.getData()));
        } else if (responseError.getError() == 10006 && z2) {
            MyApplication.O000000o().O00000oO();
        } else {
            myCallback.onError(responseError);
        }
    }
}
