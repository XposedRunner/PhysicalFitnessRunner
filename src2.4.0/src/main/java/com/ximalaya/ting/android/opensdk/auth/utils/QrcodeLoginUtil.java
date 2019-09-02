package com.ximalaya.ting.android.opensdk.auth.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuth2AccessToken;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$IRequestCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.BaseBuilder;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.IHttpCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import java.util.Map;
import okhttp3.Response;

public class QrcodeLoginUtil {

    public interface IGenerateCallBack {
        void onError(int i, String str);

        void qrcodeImage(Bitmap bitmap, String str);
    }

    public static void checkQRCodeLoginStatus(Map<String, String> map, IDataCallBack<XmlyAuth2AccessToken> iDataCallBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        map.put("timestamp", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        map.put("nonce", stringBuilder.toString());
        map.put(XmlyConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
        try {
            map.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, CommonRequest.getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        CommonRequest.basePostRequest(DTransferConstants.GET_PAUTH_AUTHORIZE, map, iDataCallBack, new CommonRequest$IRequestCallBack<XmlyAuth2AccessToken>() {
            public final XmlyAuth2AccessToken success(String str) throws Exception {
                return XmlyAuth2AccessToken.parseAccessToken(str);
            }
        });
    }

    public static void requestGernerateQRCodeForLogin(Map<String, String> map, final IGenerateCallBack iGenerateCallBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        map.put("timestamp", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        map.put("nonce", stringBuilder.toString());
        try {
            map.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, CommonRequest.getInstanse().getAppKey());
        } catch (XimalayaException e) {
            e.printStackTrace();
        }
        try {
            BaseCall.getInstanse().doAsync(BaseBuilder.urlGet(CommonRequest.replaceHttpToHttps(DTransferConstants.GET_GENERATE_QRCODE), CommonRequest.CommonParams(map), CommonRequest.getInstanse().getAppsecret()).build(), new IHttpCallBack() {
                public final void onFailure(final int i, final String str) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            if (iGenerateCallBack != null) {
                                iGenerateCallBack.onError(i, str);
                            }
                        }
                    });
                }

                public final void onResponse(final Response response) {
                    final Bitmap decodeStream = BitmapFactory.decodeStream(response.body().byteStream());
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            if (iGenerateCallBack != null) {
                                iGenerateCallBack.qrcodeImage(decodeStream, response.header("qrcode_id"));
                            }
                        }
                    });
                }
            });
        } catch (XimalayaException e2) {
            if (iGenerateCallBack != null) {
                iGenerateCallBack.onError(e2.getErrorCode(), e2.getMessage());
            }
        }
    }
}
