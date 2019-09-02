package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.httputil.BaseBuilder;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
import com.ximalaya.ting.android.opensdk.httputil.IHttpCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.httputil.XmSecretKeyUtil;
import com.ximalaya.ting.android.opensdk.model.SercretPubKey;
import com.ximalaya.ting.android.opensdk.util.DHUtil;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import com.ximalaya.ting.android.opensdk.util.dh.DhKeyPair;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class AccessTokenBaseCall {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_UID = "uid";
    public static HashSet<String> LOGIN_NEED_URL = new HashSet<String>() {
        {
            add("/subscribe/get_albums_by_uid");
            add("/subscribe/add_or_delete");
            add("/subscribe/batch_add");
            add("/play_history/get_by_uid");
            add("/play_history/upload");
            add("/play_history/batch_upload");
            add("/play_history/batch_delete");
            add("/open_pay/client_place_order");
            add("/open_pay/get_bought_albums");
            add("/open_pay/album_bought_status");
            add("/open_pay/track_bought_status");
            add("/profile/user_info");
            add("/profile/persona");
        }
    };

    private static void checkLoginNeed(String str) throws XimalayaException {
        if (!TextUtils.isEmpty(str)) {
            Iterator it = LOGIN_NEED_URL.iterator();
            boolean isEmpty = TextUtils.isEmpty(AccessTokenManager.getInstanse().getUid());
            while (it.hasNext()) {
                if (str.contains((CharSequence) it.next())) {
                    if (isEmpty && CommonRequest.getInstanse().getITokenStateChange() != null) {
                        CommonRequest.getInstanse().getITokenStateChange().tokenLosted();
                        throw XimalayaException.getExceptionByCode(XimalayaException.TOKEN_INVALID);
                    }
                    return;
                }
            }
        }
    }

    public static void doAsync(Request request, IHttpCallBack iHttpCallBack, Map<String, String> map, String str, String str2) {
        try {
            checkLoginNeed(str2);
            final IHttpCallBack iHttpCallBack2 = iHttpCallBack;
            final Request request2 = request;
            final Map<String, String> map2 = map;
            final String str3 = str2;
            final String str4 = str;
            BaseCall.getInstanse().doAsync(request, new IHttpCallBack() {
                public void onFailure(int i, String str) {
                    iHttpCallBack2.onFailure(i, str);
                }

                /* JADX WARNING: Removed duplicated region for block: B:21:0x0075 A:{Splitter:B:23:0x0079, ExcHandler: XimalayaException (r7_11 'e' com.ximalaya.ting.android.opensdk.httputil.XimalayaException)} */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing block: B:20:0x0072, code skipped:
            r7 = move-exception;
     */
                /* JADX WARNING: Missing block: B:21:0x0075, code skipped:
            r7 = move-exception;
     */
                /* JADX WARNING: Missing block: B:60:0x015f, code skipped:
            if (android.text.TextUtils.isEmpty(r7.getMessage()) != false) goto L_0x0161;
     */
                /* JADX WARNING: Missing block: B:61:0x0161, code skipped:
            r2.onFailure(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.HTTP_REQUEST_ERROR, (java.lang.String) com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP.get(java.lang.Integer.valueOf(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.HTTP_REQUEST_ERROR)));
     */
                /* JADX WARNING: Missing block: B:62:0x0173, code skipped:
            r2.onFailure(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.HTTP_REQUEST_ERROR, r7.getMessage());
     */
                /* JADX WARNING: Missing block: B:63:0x017c, code skipped:
            return;
     */
                /* JADX WARNING: Missing block: B:64:0x017d, code skipped:
            r2.onFailure(r7.getErrorCode(), r7.getErrorMessage());
     */
                public void onResponse(okhttp3.Response r7) {
                    /*
                    r6 = this;
                    r0 = new com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
                    r0.<init>(r7);
                    r1 = r0.getStatusCode();
                    r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                    if (r1 != r2) goto L_0x0014;
                L_0x000d:
                    r0 = r2;
                    r0.onResponse(r7);
                    goto L_0x0259;
                L_0x0014:
                    r7 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();
                    r7 = r7.parseResponseHandler(r0);
                    r0 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;
                    if (r7 == 0) goto L_0x0248;
                L_0x0020:
                    r1 = r7.getErrorDesc();
                    r1 = android.text.TextUtils.isEmpty(r1);
                    if (r1 == 0) goto L_0x002c;
                L_0x002a:
                    goto L_0x0248;
                L_0x002c:
                    r1 = r7.getErrorNo();
                    r3 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
                    r4 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
                    if (r1 == r3) goto L_0x003e;
                L_0x0036:
                    r1 = r7.getErrorNo();
                    r3 = 702; // 0x2be float:9.84E-43 double:3.47E-321;
                    if (r1 != r3) goto L_0x0064;
                L_0x003e:
                    r1 = r3;
                    r1 = r1.url();
                    r1 = r1.toString();
                    r3 = "http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange";
                    r1 = r1.contains(r3);
                    if (r1 != 0) goto L_0x01a7;
                L_0x0050:
                    r1 = r3;
                    r1 = r1.url();
                    r1 = r1.toString();
                    r3 = "http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info";
                    r1 = r1.contains(r3);
                    if (r1 == 0) goto L_0x0064;
                L_0x0062:
                    goto L_0x01a7;
                L_0x0064:
                    r1 = r7.getErrorNo();
                    r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;
                    if (r1 != r3) goto L_0x018c;
                L_0x006c:
                    r7 = 0;
                    r1 = com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall.getTokenBySimpleLoginSync();	 Catch:{ IOException -> 0x0078 }
                    goto L_0x007d;
                L_0x0072:
                    r7 = move-exception;
                    goto L_0x0155;
                L_0x0075:
                    r7 = move-exception;
                    goto L_0x017d;
                L_0x0078:
                    r1 = move-exception;
                    r1.printStackTrace();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = r7;
                L_0x007d:
                    if (r1 != 0) goto L_0x00bf;
                L_0x007f:
                    r1 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = r1.getITokenStateChange();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r1 == 0) goto L_0x008d;
                L_0x0089:
                    r7 = r1.getTokenByRefreshSync();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                L_0x008d:
                    if (r1 == 0) goto L_0x00b0;
                L_0x008f:
                    if (r7 != 0) goto L_0x00b0;
                L_0x0091:
                    r3 = r5;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r3 = com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall.isNeedLoginUrl(r3);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r3 == 0) goto L_0x00b0;
                L_0x0099:
                    r1.tokenLosted();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7 = r2;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
                    r2 = java.lang.Integer.valueOf(r1);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0 = r0.get(r2);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0 = (java.lang.String) r0;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7.onFailure(r1, r0);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    return;
                L_0x00b0:
                    if (r7 != 0) goto L_0x00bf;
                L_0x00b2:
                    r7 = com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager.isThirdToken();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r7 == 0) goto L_0x00bc;
                L_0x00b8:
                    com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager.getTokenByThirdSync();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    goto L_0x00bf;
                L_0x00bc:
                    com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall.getTokenByOrdinarySync();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                L_0x00bf:
                    r7 = "POST";
                    r1 = r3;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = r1.method();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7 = r7.equals(r1);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r7 == 0) goto L_0x00e0;
                L_0x00cd:
                    r7 = r5;	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r1 = r4;	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r1 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r1);	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r3 = r6;	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r7 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlPost(r7, r1, r3);	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r7 = r7.build();	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    goto L_0x00f2;
                L_0x00e0:
                    r7 = r5;	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r1 = r4;	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r1 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r1);	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r3 = r6;	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r7 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlGet(r7, r1, r3);	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                    r7 = r7.build();	 Catch:{ Exception -> 0x0143, XimalayaException -> 0x0075 }
                L_0x00f2:
                    r1 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getInstanse();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7 = r1.doSync(r7);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = new com.ximalaya.ting.android.opensdk.httputil.BaseResponse;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1.<init>(r7);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r3 = r1.getStatusCode();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r3 != r2) goto L_0x010c;
                L_0x0105:
                    r0 = r2;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0.onResponse(r7);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    goto L_0x0259;
                L_0x010c:
                    r7 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7 = r7.parseResponseHandler(r1);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r7 == 0) goto L_0x0130;
                L_0x0116:
                    r1 = r7.getErrorDesc();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    if (r1 == 0) goto L_0x0121;
                L_0x0120:
                    goto L_0x0130;
                L_0x0121:
                    r0 = r2;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = r7.getErrorNo();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7 = r7.getErrorDesc();	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0.onFailure(r1, r7);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    goto L_0x0259;
                L_0x0130:
                    r7 = r2;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r2 = java.lang.Integer.valueOf(r0);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = r1.get(r2);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = (java.lang.String) r1;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7.onFailure(r0, r1);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    goto L_0x0259;
                L_0x0143:
                    r7 = r2;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r1 = java.lang.Integer.valueOf(r4);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0 = r0.get(r1);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r0 = (java.lang.String) r0;	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    r7.onFailure(r4, r0);	 Catch:{ XimalayaException -> 0x0075, Exception -> 0x0072 }
                    return;
                L_0x0155:
                    r0 = r7.getMessage();
                    r0 = android.text.TextUtils.isEmpty(r0);
                    r1 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
                    if (r0 == 0) goto L_0x0173;
                L_0x0161:
                    r7 = r2;
                    r0 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;
                    r2 = java.lang.Integer.valueOf(r1);
                    r0 = r0.get(r2);
                    r0 = (java.lang.String) r0;
                    r7.onFailure(r1, r0);
                    goto L_0x017c;
                L_0x0173:
                    r0 = r2;
                    r7 = r7.getMessage();
                    r0.onFailure(r1, r7);
                L_0x017c:
                    return;
                L_0x017d:
                    r0 = r2;
                    r1 = r7.getErrorCode();
                    r7 = r7.getErrorMessage();
                    r0.onFailure(r1, r7);
                    goto L_0x0259;
                L_0x018c:
                    r0 = r7.getErrorNo();
                    r1 = 604; // 0x25c float:8.46E-43 double:2.984E-321;
                    if (r0 != r1) goto L_0x0198;
                L_0x0194:
                    r0 = 3;
                    r7.setErrorNo(r0);
                L_0x0198:
                    r0 = r2;
                    r1 = r7.getErrorNo();
                    r7 = r7.getErrorDesc();
                    r0.onFailure(r1, r7);
                    goto L_0x0259;
                L_0x01a7:
                    r1 = r3;
                    r3 = r4;
                    com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall.onEncryptExchanage(r1, r3);
                    r1 = "POST";
                    r3 = r3;
                    r3 = r3.method();
                    r1 = r1.equals(r3);
                    if (r1 == 0) goto L_0x01cf;
                L_0x01bc:
                    r1 = r5;	 Catch:{ Exception -> 0x0236 }
                    r3 = r4;	 Catch:{ Exception -> 0x0236 }
                    r3 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r3);	 Catch:{ Exception -> 0x0236 }
                    r5 = r6;	 Catch:{ Exception -> 0x0236 }
                    r1 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlPost(r1, r3, r5);	 Catch:{ Exception -> 0x0236 }
                    r1 = r1.build();	 Catch:{ Exception -> 0x0236 }
                    goto L_0x01e1;
                L_0x01cf:
                    r1 = r5;	 Catch:{ Exception -> 0x0236 }
                    r3 = r4;	 Catch:{ Exception -> 0x0236 }
                    r3 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r3);	 Catch:{ Exception -> 0x0236 }
                    r5 = r6;	 Catch:{ Exception -> 0x0236 }
                    r1 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlGet(r1, r3, r5);	 Catch:{ Exception -> 0x0236 }
                    r1 = r1.build();	 Catch:{ Exception -> 0x0236 }
                L_0x01e1:
                    r3 = 0;
                    r4 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getInstanse();	 Catch:{ Exception -> 0x01eb }
                    r1 = r4.doSync(r1);	 Catch:{ Exception -> 0x01eb }
                    goto L_0x01f0;
                L_0x01eb:
                    r1 = move-exception;
                    r1.printStackTrace();
                    r1 = r3;
                L_0x01f0:
                    r3 = new com.ximalaya.ting.android.opensdk.httputil.BaseResponse;
                    r3.<init>(r1);
                    r4 = r3.getStatusCode();
                    if (r4 != r2) goto L_0x0201;
                L_0x01fb:
                    r7 = r2;
                    r7.onResponse(r1);
                    goto L_0x0259;
                L_0x0201:
                    r1 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();
                    r1 = r1.parseResponseHandler(r3);
                    if (r1 == 0) goto L_0x0224;
                L_0x020b:
                    r1 = r1.getErrorDesc();
                    r1 = android.text.TextUtils.isEmpty(r1);
                    if (r1 == 0) goto L_0x0216;
                L_0x0215:
                    goto L_0x0224;
                L_0x0216:
                    r0 = r2;
                    r1 = r7.getErrorNo();
                    r7 = r7.getErrorDesc();
                    r0.onFailure(r1, r7);
                    goto L_0x0259;
                L_0x0224:
                    r7 = r2;
                    r1 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;
                    r2 = java.lang.Integer.valueOf(r0);
                    r1 = r1.get(r2);
                    r1 = (java.lang.String) r1;
                    r7.onFailure(r0, r1);
                    return;
                L_0x0236:
                    r7 = r2;
                    r0 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;
                    r1 = java.lang.Integer.valueOf(r4);
                    r0 = r0.get(r1);
                    r0 = (java.lang.String) r0;
                    r7.onFailure(r4, r0);
                    return;
                L_0x0248:
                    r7 = r2;
                    r1 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;
                    r2 = java.lang.Integer.valueOf(r0);
                    r1 = r1.get(r2);
                    r1 = (java.lang.String) r1;
                    r7.onFailure(r0, r1);
                L_0x0259:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall$AnonymousClass3.onResponse(okhttp3.Response):void");
                }
            });
        } catch (XimalayaException e) {
            e.printStackTrace();
            if (iHttpCallBack != null) {
                iHttpCallBack.onFailure(1014, (String) XimalayaException.ERR_MESSAGE_MAP.get(Integer.valueOf(1014)));
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:50:0x00da=Splitter:B:50:0x00da, B:74:0x015c=Splitter:B:74:0x015c} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01d6 A:{Splitter:B:1:0x0003, ExcHandler: XimalayaException (r6_45 'e' com.ximalaya.ting.android.opensdk.httputil.XimalayaException)} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01d6 A:{Splitter:B:1:0x0003, ExcHandler: XimalayaException (r6_45 'e' com.ximalaya.ting.android.opensdk.httputil.XimalayaException)} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01d6 A:{Splitter:B:1:0x0003, ExcHandler: XimalayaException (r6_45 'e' com.ximalaya.ting.android.opensdk.httputil.XimalayaException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:47:0x00cc, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:64:0x0123, code skipped:
            if (android.text.TextUtils.isEmpty(r6.getMessage()) != false) goto L_0x0125;
     */
    /* JADX WARNING: Missing block: B:65:0x0125, code skipped:
            r6.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:66:0x012c, code skipped:
            throw com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERROR_DESC_EMPTY);
     */
    /* JADX WARNING: Missing block: B:68:0x0133, code skipped:
            throw com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.PARSE_JSON_ERROR);
     */
    /* JADX WARNING: Missing block: B:92:0x01a2, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:96:0x01ad, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:98:0x01b8, code skipped:
            if (android.text.TextUtils.isEmpty(r6.getMessage()) != false) goto L_0x01ba;
     */
    /* JADX WARNING: Missing block: B:100:0x01cb, code skipped:
            throw new com.ximalaya.ting.android.opensdk.httputil.XimalayaException(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.HTTP_REQUEST_ERROR, (java.lang.String) com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP.get(java.lang.Integer.valueOf(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.HTTP_REQUEST_ERROR)));
     */
    /* JADX WARNING: Missing block: B:102:0x01d5, code skipped:
            throw new com.ximalaya.ting.android.opensdk.httputil.XimalayaException(com.ximalaya.ting.android.opensdk.httputil.XimalayaException.HTTP_REQUEST_ERROR, r6.getMessage());
     */
    /* JADX WARNING: Missing block: B:103:0x01d6, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:104:0x01d7, code skipped:
            throw r6;
     */
    public static java.lang.String doSync(okhttp3.Request r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8, java.lang.String r9) throws com.ximalaya.ting.android.opensdk.httputil.XimalayaException {
        /*
        checkLoginNeed(r9);
        r0 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getInstanse();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r0 = r0.doSync(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1 = new com.ximalaya.ting.android.opensdk.httputil.BaseResponse;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1.<init>(r0);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r2 = r0.code();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = 0;
        if (r2 != r3) goto L_0x0023;
    L_0x0019:
        r6 = r0.body();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r4 = r6.string();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        goto L_0x0179;
    L_0x0023:
        r0 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r0 = r0.parseResponseHandler(r1);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r2 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;
        if (r0 == 0) goto L_0x01a3;
    L_0x002f:
        r5 = r0.getErrorDesc();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r5 == 0) goto L_0x003b;
    L_0x0039:
        goto L_0x01a3;
    L_0x003b:
        r1 = r0.getErrorNo();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r5 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;
        if (r1 == r5) goto L_0x004b;
    L_0x0043:
        r1 = r0.getErrorNo();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r5 = 702; // 0x2be float:9.84E-43 double:3.47E-321;
        if (r1 != r5) goto L_0x006d;
    L_0x004b:
        r1 = r6.url();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1 = r1.toString();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r5 = "http://api.ximalaya.com/openapi-gateway-app/encrypt/exchange";
        r1 = r1.contains(r5);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r1 != 0) goto L_0x0134;
    L_0x005b:
        r1 = r6.url();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1 = r1.toString();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r5 = "http://api.ximalaya.com/openapi-gateway-app/tracks/get_play_info";
        r1 = r1.contains(r5);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r1 == 0) goto L_0x006d;
    L_0x006b:
        goto L_0x0134;
    L_0x006d:
        r0 = r0.getErrorNo();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r0 != r1) goto L_0x0179;
    L_0x0075:
        r0 = 0;
        r1 = getTokenBySimpleLoginSync();	 Catch:{ IOException -> 0x007b }
        goto L_0x0080;
    L_0x007b:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1 = r0;
    L_0x0080:
        if (r1 != 0) goto L_0x00b3;
    L_0x0082:
        r1 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r1 = r1.getITokenStateChange();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r1 == 0) goto L_0x0090;
    L_0x008c:
        r0 = r1.getTokenByRefreshSync();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x0090:
        if (r1 == 0) goto L_0x00a4;
    L_0x0092:
        if (r0 != 0) goto L_0x00a4;
    L_0x0094:
        r4 = isNeedLoginUrl(r9);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r4 == 0) goto L_0x00a4;
    L_0x009a:
        r1.tokenLosted();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = 1013; // 0x3f5 float:1.42E-42 double:5.005E-321;
        r6 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r6;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x00a4:
        if (r0 != 0) goto L_0x00b3;
    L_0x00a6:
        r0 = com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager.isThirdToken();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r0 == 0) goto L_0x00b0;
    L_0x00ac:
        com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenManager.getTokenByThirdSync();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        goto L_0x00b3;
    L_0x00b0:
        getTokenByOrdinarySync();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x00b3:
        r0 = "POST";
        r6 = r6.method();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r0.equals(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r6 == 0) goto L_0x00ce;
    L_0x00bf:
        r6 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r7);	 Catch:{ Exception -> 0x00cc, XimalayaException -> 0x01d6 }
        r6 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlPost(r9, r6, r8);	 Catch:{ Exception -> 0x00cc, XimalayaException -> 0x01d6 }
        r6 = r6.build();	 Catch:{ Exception -> 0x00cc, XimalayaException -> 0x01d6 }
        goto L_0x00da;
    L_0x00cc:
        r6 = move-exception;
        goto L_0x011b;
    L_0x00ce:
        r6 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r7);	 Catch:{ Exception -> 0x00cc, XimalayaException -> 0x01d6 }
        r6 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlGet(r9, r6, r8);	 Catch:{ Exception -> 0x00cc, XimalayaException -> 0x01d6 }
        r6 = r6.build();	 Catch:{ Exception -> 0x00cc, XimalayaException -> 0x01d6 }
    L_0x00da:
        r7 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getInstanse();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r7.doSync(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7 = new com.ximalaya.ting.android.opensdk.httputil.BaseResponse;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7.<init>(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r7.getStatusCode();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r6 != r3) goto L_0x00f3;
    L_0x00ed:
        r4 = r7.getResponseBodyToString();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        goto L_0x0179;
    L_0x00f3:
        r6 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r6.parseResponseHandler(r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r6 == 0) goto L_0x0116;
    L_0x00fd:
        r7 = r6.getErrorDesc();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r7 == 0) goto L_0x0108;
    L_0x0107:
        goto L_0x0116;
    L_0x0108:
        r7 = new com.ximalaya.ting.android.opensdk.httputil.XimalayaException;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r8 = r6.getErrorNo();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r6.getErrorDesc();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7.<init>(r8, r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r7;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x0116:
        r6 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(r2);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r6;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x011b:
        r7 = r6.getMessage();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r7 == 0) goto L_0x012d;
    L_0x0125:
        r6.printStackTrace();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(r2);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r6;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x012d:
        r6 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        r6 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r6;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x0134:
        onEncryptExchanage(r6, r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r0 = "POST";
        r6 = r6.method();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r0.equals(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r6 == 0) goto L_0x0150;
    L_0x0143:
        r6 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r7);	 Catch:{ Exception -> 0x01a2, XimalayaException -> 0x01d6 }
        r6 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlPost(r9, r6, r8);	 Catch:{ Exception -> 0x01a2, XimalayaException -> 0x01d6 }
        r6 = r6.build();	 Catch:{ Exception -> 0x01a2, XimalayaException -> 0x01d6 }
        goto L_0x015c;
    L_0x0150:
        r6 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.CommonParams(r7);	 Catch:{ Exception -> 0x01a2, XimalayaException -> 0x01d6 }
        r6 = com.ximalaya.ting.android.opensdk.httputil.BaseBuilder.urlGet(r9, r6, r8);	 Catch:{ Exception -> 0x01a2, XimalayaException -> 0x01d6 }
        r6 = r6.build();	 Catch:{ Exception -> 0x01a2, XimalayaException -> 0x01d6 }
    L_0x015c:
        r7 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getInstanse();	 Catch:{ Exception -> 0x0165, XimalayaException -> 0x01d6 }
        r6 = r7.doSync(r6);	 Catch:{ Exception -> 0x0165, XimalayaException -> 0x01d6 }
        goto L_0x016a;
    L_0x0165:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r4;
    L_0x016a:
        r7 = new com.ximalaya.ting.android.opensdk.httputil.BaseResponse;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7.<init>(r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r7.getStatusCode();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r6 != r3) goto L_0x017a;
    L_0x0175:
        r4 = r7.getResponseBodyToString();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x0179:
        return r4;
    L_0x017a:
        r6 = com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest.getInstanse();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r6.parseResponseHandler(r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r6 == 0) goto L_0x019d;
    L_0x0184:
        r7 = r6.getErrorDesc();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        if (r7 == 0) goto L_0x018f;
    L_0x018e:
        goto L_0x019d;
    L_0x018f:
        r7 = new com.ximalaya.ting.android.opensdk.httputil.XimalayaException;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r8 = r6.getErrorNo();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6 = r6.getErrorDesc();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7.<init>(r8, r6);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r7;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x019d:
        r6 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.getExceptionByCode(r2);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r6;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x01a2:
        return r4;
    L_0x01a3:
        r6 = new com.ximalaya.ting.android.opensdk.httputil.XimalayaException;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r7 = r1.toString();	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        r6.<init>(r2, r7);	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
        throw r6;	 Catch:{ XimalayaException -> 0x01d6, Exception -> 0x01ad }
    L_0x01ad:
        r6 = move-exception;
        r7 = r6.getMessage();
        r7 = android.text.TextUtils.isEmpty(r7);
        r8 = 1011; // 0x3f3 float:1.417E-42 double:4.995E-321;
        if (r7 == 0) goto L_0x01cc;
    L_0x01ba:
        r6 = new com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
        r7 = com.ximalaya.ting.android.opensdk.httputil.XimalayaException.ERR_MESSAGE_MAP;
        r9 = java.lang.Integer.valueOf(r8);
        r7 = r7.get(r9);
        r7 = (java.lang.String) r7;
        r6.<init>(r8, r7);
        throw r6;
    L_0x01cc:
        r7 = new com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
        r6 = r6.getMessage();
        r7.<init>(r8, r6);
        throw r7;
    L_0x01d6:
        r6 = move-exception;
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.datatrasfer.AccessTokenBaseCall.doSync(okhttp3.Request, java.util.Map, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String getString(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        if (string == null) {
            string = str2;
        }
        return string;
    }

    private static void getTokenByOrdinarySync() throws XimalayaException {
        try {
            Response doSync;
            try {
                doSync = BaseCall.getInstanse().doSync(BaseBuilder.urlPost(DTransferConstants.SECURE_ACCESS_TOKEN_URL, AccessTokenManager.getInstanse().getCommonParams()).build());
            } catch (Exception e) {
                e.printStackTrace();
                doSync = null;
            }
            if (doSync == null) {
                throw XimalayaException.getExceptionByCode(XimalayaException.GET_TOKEN_FAIL);
            } else if (new BaseResponse(doSync).getStatusCode() == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(doSync.body().string());
                    AccessTokenManager.getInstanse().setAccessToken(jSONObject.optString("access_token"), jSONObject.optLong("expires_in"));
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

    private static boolean getTokenBySimpleLoginSync() throws IOException {
        final SharedPreferencesUtil instance = SharedPreferencesUtil.getInstance(AccessTokenManager.getInstanse().getContext());
        if (instance.contains(AccessTokenManager.SIMPLE_SSO_CODE)) {
            final String string = instance.getString(AccessTokenManager.SIMPLE_SSO_CODE);
            if (!TextUtils.isEmpty(CommonRequest.simpleLoginSync(new HashMap<String, String>() {
            }))) {
                try {
                    Bundle bundle = (Bundle) Class.forName("com.ximalaya.ting.android.opensdk.auth.utils.Utility").getDeclaredMethod("parseUrl", new Class[]{String.class}).invoke(null, new Object[]{r0});
                    if (!(bundle == null || !bundle.containsKey("access_token") || TextUtils.isEmpty(getString(bundle, "access_token", "")))) {
                        String string2 = getString(bundle, "expires_in", "");
                        long j = 0;
                        if (!(TextUtils.isEmpty(string2) || string2.equals("0"))) {
                            j = System.currentTimeMillis() + (Long.parseLong(string2) * 1000);
                        }
                        AccessTokenManager.getInstanse().setAccessTokenAndUid(getString(bundle, "access_token", ""), j, string.split("&")[0]);
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean isNeedLoginUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator it = LOGIN_NEED_URL.iterator();
        while (it.hasNext()) {
            if (str.contains((CharSequence) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static void onEncryptExchanage(Request request, Map<String, String> map) {
        XmSecretKeyUtil.getInstance().reset();
        if (request.url().toString().contains(DTransferConstants.GET_PLAY_INFO)) {
            int i = 3;
            while (i > 0) {
                try {
                    final DhKeyPair initPartyAKey = DHUtil.initPartyAKey();
                    Response doSync = BaseCall.getInstanse().doSync(BaseBuilder.urlPost(DTransferConstants.GET_ENCRYPT_EXCHANGE, CommonRequest.CommonParams(new HashMap<String, String>() {
                    }), CommonRequest.getInstanse().getAppsecret()).build());
                    if (new BaseResponse(doSync).getStatusCode() == 200) {
                        XmSecretKeyUtil.getInstance().updateShareData((SercretPubKey) new Gson().fromJson(doSync.body().string(), SercretPubKey.class));
                        i = 0;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception unused) {
                    i--;
                }
            }
            return;
        }
        map.put(DTransferConstants.PUB_KEY, DHUtil.initPartyAKey().getPublicKey().toString());
    }
}
