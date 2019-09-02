package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.c;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_APP = 6;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;
    private boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    public String mViaShareQzoneType = "";

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x037a  */
    private void b(android.app.Activity r27, android.os.Bundle r28, com.tencent.tauth.IUiListener r29) {
        /*
        r26 = this;
        r1 = r26;
        r2 = r27;
        r3 = r28;
        r4 = r29;
        r5 = "openSDK_LOG.QzoneShare";
        r6 = "doshareToQzone() --start";
        com.tencent.open.a.f.c(r5, r6);
        r5 = new java.lang.StringBuffer;
        r6 = "mqqapi://share/to_qzone?src_type=app&version=1&file_type=news";
        r5.<init>(r6);
        r6 = "imageUrl";
        r6 = r3.getStringArrayList(r6);
        r7 = "title";
        r7 = r3.getString(r7);
        r8 = "summary";
        r8 = r3.getString(r8);
        r9 = "targetUrl";
        r9 = r3.getString(r9);
        r10 = "audio_url";
        r10 = r3.getString(r10);
        r11 = "req_type";
        r12 = 1;
        r11 = r3.getInt(r11, r12);
        r13 = "appName";
        r13 = r3.getString(r13);
        r14 = "cflag";
        r15 = 0;
        r14 = r3.getInt(r14, r15);
        r15 = "share_qq_ext_str";
        r15 = r3.getString(r15);
        r17 = "";
        r12 = "extMap";
        r3 = r3.getBundle(r12);	 Catch:{ Exception -> 0x0097 }
        if (r3 == 0) goto L_0x0094;
    L_0x0058:
        r12 = r3.keySet();	 Catch:{ Exception -> 0x0097 }
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0097 }
        r4.<init>();	 Catch:{ Exception -> 0x0097 }
        r2 = r12.iterator();	 Catch:{ Exception -> 0x0097 }
    L_0x0065:
        r21 = r2.hasNext();	 Catch:{ Exception -> 0x0097 }
        if (r21 == 0) goto L_0x0083;
    L_0x006b:
        r21 = r2.next();	 Catch:{ Exception -> 0x0097 }
        r22 = r2;
        r2 = r21;
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0097 }
        r23 = r14;
        r14 = r3.get(r2);	 Catch:{ Exception -> 0x0092 }
        r4.put(r2, r14);	 Catch:{ Exception -> 0x0092 }
        r2 = r22;
        r14 = r23;
        goto L_0x0065;
    L_0x0083:
        r23 = r14;
        r2 = r12.size();	 Catch:{ Exception -> 0x0092 }
        if (r2 <= 0) goto L_0x00a2;
    L_0x008b:
        r2 = r4.toString();	 Catch:{ Exception -> 0x0092 }
        r17 = r2;
        goto L_0x00a2;
    L_0x0092:
        r0 = move-exception;
        goto L_0x009a;
    L_0x0094:
        r23 = r14;
        goto L_0x00a2;
    L_0x0097:
        r0 = move-exception;
        r23 = r14;
    L_0x009a:
        r2 = r0;
        r3 = "openSDK_LOG.QzoneShare";
        r4 = "ShareToQzone()  --error parse extmap";
        com.tencent.open.a.f.b(r3, r4, r2);
    L_0x00a2:
        r2 = r17;
        r3 = r1.b;
        r3 = r3.getAppId();
        r4 = r1.b;
        r4 = r4.getOpenId();
        r12 = "openSDK_LOG.QzoneShare";
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r1 = "openId:";
        r14.append(r1);
        r14.append(r4);
        r1 = r14.toString();
        com.tencent.open.a.f.a(r12, r1);
        if (r6 == 0) goto L_0x011d;
    L_0x00c8:
        r12 = new java.lang.StringBuffer;
        r12.<init>();
        r14 = r6.size();
        r1 = 9;
        if (r14 <= r1) goto L_0x00d6;
    L_0x00d5:
        goto L_0x00da;
    L_0x00d6:
        r1 = r6.size();
    L_0x00da:
        r14 = 0;
    L_0x00db:
        if (r14 >= r1) goto L_0x00fc;
    L_0x00dd:
        r17 = r6.get(r14);
        r25 = r6;
        r6 = r17;
        r6 = (java.lang.String) r6;
        r6 = java.net.URLEncoder.encode(r6);
        r12.append(r6);
        r6 = r1 + -1;
        if (r14 == r6) goto L_0x00f7;
    L_0x00f2:
        r6 = ";";
        r12.append(r6);
    L_0x00f7:
        r14 = r14 + 1;
        r6 = r25;
        goto L_0x00db;
    L_0x00fc:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r6 = "&image_url=";
        r1.append(r6);
        r6 = r12.toString();
        r6 = com.tencent.open.utils.j.i(r6);
        r12 = 2;
        r6 = android.util.Base64.encodeToString(r6, r12);
        r1.append(r6);
        r1 = r1.toString();
        r5.append(r1);
    L_0x011d:
        r1 = android.text.TextUtils.isEmpty(r7);
        if (r1 != 0) goto L_0x0140;
    L_0x0123:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r6 = "&title=";
        r1.append(r6);
        r6 = com.tencent.open.utils.j.i(r7);
        r7 = 2;
        r6 = android.util.Base64.encodeToString(r6, r7);
        r1.append(r6);
        r1 = r1.toString();
        r5.append(r1);
    L_0x0140:
        r1 = android.text.TextUtils.isEmpty(r8);
        if (r1 != 0) goto L_0x0163;
    L_0x0146:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r6 = "&description=";
        r1.append(r6);
        r6 = com.tencent.open.utils.j.i(r8);
        r7 = 2;
        r6 = android.util.Base64.encodeToString(r6, r7);
        r1.append(r6);
        r1 = r1.toString();
        r5.append(r1);
    L_0x0163:
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 != 0) goto L_0x017d;
    L_0x0169:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r6 = "&share_id=";
        r1.append(r6);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
    L_0x017d:
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x01a0;
    L_0x0183:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&url=";
        r1.append(r3);
        r3 = com.tencent.open.utils.j.i(r9);
        r6 = 2;
        r3 = android.util.Base64.encodeToString(r3, r6);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
    L_0x01a0:
        r1 = android.text.TextUtils.isEmpty(r13);
        if (r1 != 0) goto L_0x01c3;
    L_0x01a6:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&app_name=";
        r1.append(r3);
        r3 = com.tencent.open.utils.j.i(r13);
        r6 = 2;
        r3 = android.util.Base64.encodeToString(r3, r6);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
    L_0x01c3:
        r1 = com.tencent.open.utils.j.e(r4);
        if (r1 != 0) goto L_0x01e6;
    L_0x01c9:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&open_id=";
        r1.append(r3);
        r3 = com.tencent.open.utils.j.i(r4);
        r4 = 2;
        r3 = android.util.Base64.encodeToString(r3, r4);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
    L_0x01e6:
        r1 = com.tencent.open.utils.j.e(r10);
        if (r1 != 0) goto L_0x0209;
    L_0x01ec:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&audioUrl=";
        r1.append(r3);
        r3 = com.tencent.open.utils.j.i(r10);
        r4 = 2;
        r3 = android.util.Base64.encodeToString(r3, r4);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
    L_0x0209:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&req_type=";
        r1.append(r3);
        r3 = java.lang.String.valueOf(r11);
        r3 = com.tencent.open.utils.j.i(r3);
        r4 = 2;
        r3 = android.util.Base64.encodeToString(r3, r4);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
        r1 = com.tencent.open.utils.j.e(r15);
        if (r1 != 0) goto L_0x024c;
    L_0x0230:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&share_qq_ext_str=";
        r1.append(r3);
        r3 = com.tencent.open.utils.j.i(r15);
        r3 = android.util.Base64.encodeToString(r3, r4);
        r1.append(r3);
        r1 = r1.toString();
        r5.append(r1);
    L_0x024c:
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 != 0) goto L_0x026f;
    L_0x0252:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "&share_qzone_ext_str=";
        r1.append(r3);
        r2 = com.tencent.open.utils.j.i(r2);
        r3 = 2;
        r2 = android.util.Base64.encodeToString(r2, r3);
        r1.append(r2);
        r1 = r1.toString();
        r5.append(r1);
    L_0x026f:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "&cflag=";
        r1.append(r2);
        r2 = r23;
        r2 = java.lang.String.valueOf(r2);
        r2 = com.tencent.open.utils.j.i(r2);
        r3 = 2;
        r2 = android.util.Base64.encodeToString(r2, r3);
        r1.append(r2);
        r1 = r1.toString();
        r5.append(r1);
        r1 = "openSDK_LOG.QzoneShare";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "doshareToQzone, url: ";
        r2.append(r3);
        r3 = r5.toString();
        r2.append(r3);
        r2 = r2.toString();
        com.tencent.open.a.f.a(r1, r2);
        r1 = com.tencent.open.utils.e.a();
        r2 = r26;
        r3 = r2.b;
        r4 = "requireApi";
        r6 = 1;
        r6 = new java.lang.String[r6];
        r7 = "shareToNativeQQ";
        r8 = 0;
        r6[r8] = r7;
        com.tencent.connect.a.a.a(r1, r3, r4, r6);
        r1 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r1.<init>(r3);
        r3 = r5.toString();
        r3 = android.net.Uri.parse(r3);
        r1.setData(r3);
        r3 = "pkg_name";
        r4 = r27;
        r5 = r27.getPackageName();
        r1.putExtra(r3, r5);
        r3 = "4.6.0";
        r3 = com.tencent.open.utils.j.g(r4, r3);
        if (r3 == 0) goto L_0x0302;
    L_0x02e6:
        r3 = r2.a(r1);
        if (r3 == 0) goto L_0x02fa;
    L_0x02ec:
        r3 = com.tencent.connect.common.UIListenerManager.getInstance();
        r5 = 11104; // 0x2b60 float:1.556E-41 double:5.486E-320;
        r6 = r29;
        r3.setListenerWithRequestcode(r5, r6);
        r2.a(r4, r1, r5);
    L_0x02fa:
        r3 = "openSDK_LOG.QzoneShare";
        r4 = "doShareToQzone() -- QQ Version is < 4.6.0";
        com.tencent.open.a.f.c(r3, r4);
        goto L_0x032a;
    L_0x0302:
        r6 = r29;
        r3 = "openSDK_LOG.QzoneShare";
        r5 = "doShareToQzone() -- QQ Version is > 4.6.0";
        com.tencent.open.a.f.c(r3, r5);
        r3 = com.tencent.connect.common.UIListenerManager.getInstance();
        r5 = "shareToQzone";
        r3 = r3.setListnerWithAction(r5, r6);
        if (r3 == 0) goto L_0x031e;
    L_0x0317:
        r3 = "openSDK_LOG.QzoneShare";
        r5 = "doShareToQzone() -- do listener onCancel()";
        com.tencent.open.a.f.c(r3, r5);
    L_0x031e:
        r3 = r2.a(r1);
        if (r3 == 0) goto L_0x032a;
    L_0x0324:
        r3 = 10104; // 0x2778 float:1.4159E-41 double:4.992E-320;
        r5 = 0;
        r2.a(r4, r3, r1, r5);
    L_0x032a:
        r1 = r2.a(r1);
        r3 = 4;
        if (r1 == 0) goto L_0x037a;
    L_0x0331:
        r4 = com.tencent.open.b.d.a();
        r1 = r2.b;
        r5 = r1.getOpenId();
        r1 = r2.b;
        r6 = r1.getAppId();
        r7 = "ANDROIDQQ.SHARETOQZ.XX";
        r8 = "11";
        r9 = "3";
        r10 = "0";
        r11 = r2.mViaShareQzoneType;
        r12 = "0";
        r13 = "1";
        r14 = "0";
        r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r15 = com.tencent.open.b.d.a();
        r16 = 0;
        r17 = "SHARE_CHECK_SDK";
        r18 = "1000";
        r1 = r2.b;
        r19 = r1.getAppId();
        r20 = java.lang.String.valueOf(r3);
        r3 = android.os.SystemClock.elapsedRealtime();
        r21 = java.lang.Long.valueOf(r3);
        r22 = 0;
        r23 = 1;
        r24 = "";
        r15.a(r16, r17, r18, r19, r20, r21, r22, r23, r24);
        goto L_0x03c2;
    L_0x037a:
        r4 = com.tencent.open.b.d.a();
        r1 = r2.b;
        r5 = r1.getOpenId();
        r1 = r2.b;
        r6 = r1.getAppId();
        r7 = "ANDROIDQQ.SHARETOQZ.XX";
        r8 = "11";
        r9 = "3";
        r10 = "1";
        r11 = r2.mViaShareQzoneType;
        r12 = "0";
        r13 = "1";
        r14 = "0";
        r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r15 = com.tencent.open.b.d.a();
        r16 = 1;
        r17 = "SHARE_CHECK_SDK";
        r18 = "1000";
        r1 = r2.b;
        r19 = r1.getAppId();
        r20 = java.lang.String.valueOf(r3);
        r3 = android.os.SystemClock.elapsedRealtime();
        r21 = java.lang.Long.valueOf(r3);
        r22 = 0;
        r23 = 1;
        r24 = "hasActivityForIntent fail";
        r15.a(r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L_0x03c2:
        r1 = "openSDK_LOG";
        r3 = "doShareToQzone() --end";
        com.tencent.open.a.f.c(r1, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    public void releaseResource() {
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        final Context context = activity;
        final Bundle bundle2 = bundle;
        final IUiListener iUiListener2 = iUiListener;
        f.c("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle2 == null) {
            iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            f.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        String string = bundle2.getString("title");
        String string2 = bundle2.getString("summary");
        CharSequence string3 = bundle2.getString("targetUrl");
        ArrayList stringArrayList = bundle2.getStringArrayList("imageUrl");
        String a = j.a((Context) activity);
        if (a == null) {
            a = bundle2.getString("appName");
        } else if (a.length() > 20) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.substring(0, 20));
            stringBuilder.append("...");
            a = stringBuilder.toString();
        }
        int i = bundle2.getInt("req_type");
        if (i != 1) {
            switch (i) {
                case 5:
                    this.mViaShareQzoneType = "2";
                    break;
                case 6:
                    this.mViaShareQzoneType = "4";
                    break;
                default:
                    this.mViaShareQzoneType = "1";
                    break;
            }
        }
        this.mViaShareQzoneType = "1";
        if (i != 1) {
            switch (i) {
                case 5:
                    iUiListener2.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                    return;
                case 6:
                    if (!j.g(context, "5.0.0")) {
                        string3 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{this.b.getAppId(), "mqq"});
                        bundle2.putString("targetUrl", string3);
                        break;
                    }
                    iUiListener2.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                    f.e("openSDK_LOG.QzoneShare", "-->shareToQzone, app share is not support below qq5.0.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone, app share is not support below qq5.0.");
                    return;
                default:
                    if (!j.e(string) || !j.e(string2)) {
                        this.c = true;
                    } else if (stringArrayList == null || stringArrayList.size() == 0) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("来自");
                        stringBuilder2.append(a);
                        stringBuilder2.append("的分享");
                        String stringBuilder3 = stringBuilder2.toString();
                        this.c = true;
                        string = stringBuilder3;
                    } else {
                        this.c = false;
                    }
                    this.d = false;
                    this.e = true;
                    this.f = false;
                    break;
            }
        }
        this.c = true;
        this.d = false;
        this.e = true;
        this.f = false;
        if (j.b() || !j.g(context, "4.5.0")) {
            String str;
            if (this.c) {
                if (TextUtils.isEmpty(string3)) {
                    iUiListener2.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                    return;
                } else if (!j.g(string3)) {
                    iUiListener2.onError(new UiError(-5, Constants.MSG_PARAM_TARGETURL_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_TARGETURL_ERROR);
                    return;
                }
            }
            if (this.d) {
                bundle2.putString("title", "");
                bundle2.putString("summary", "");
            } else if (this.e && j.e(string)) {
                iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                return;
            } else {
                if (!j.e(string) && string.length() > 200) {
                    bundle2.putString("title", j.a(string, 200, null, null));
                }
                if (!j.e(string2) && string2.length() > SecExceptionCode.SEC_ERROR_SIGNATRUE) {
                    bundle2.putString("summary", j.a(string2, (int) SecExceptionCode.SEC_ERROR_SIGNATRUE, null, null));
                }
            }
            if (!TextUtils.isEmpty(a)) {
                bundle2.putString("appName", a);
            }
            if (stringArrayList != null && (stringArrayList == null || stringArrayList.size() != 0)) {
                int i2 = 0;
                while (i2 < stringArrayList.size()) {
                    str = (String) stringArrayList.get(i2);
                    if (!(j.g(str) || j.h(str))) {
                        stringArrayList.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                if (stringArrayList.size() == 0) {
                    iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    f.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                    return;
                }
                bundle2.putStringArrayList("imageUrl", stringArrayList);
            } else if (this.f) {
                iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_ERROR, null));
                f.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
            if (!j.g(context, "4.6.0")) {
                f.c("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                a.a(context, stringArrayList, new c() {
                    public void a(int i, String str) {
                        iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    }

                    public void a(int i, ArrayList<String> arrayList) {
                        if (i == 0) {
                            bundle2.putStringArrayList("imageUrl", arrayList);
                        }
                        QzoneShare.this.b(context, bundle2, iUiListener2);
                    }
                });
            } else if (h.c(context, "4.2.0") < 0 || h.c(context, "4.6.0") >= 0) {
                f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                new TDialog(context, "", a(""), null, this.b).show();
            } else {
                f.d("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                QQShare qQShare = new QQShare(context, this.b);
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    str = (String) stringArrayList.get(0);
                    if (i != 5 || j.h(str)) {
                        bundle2.putString("imageLocalUrl", str);
                    } else {
                        iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                        f.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                        return;
                    }
                }
                if (!j.g(context, "4.5.0")) {
                    bundle2.putInt("cflag", 1);
                }
                qQShare.shareToQQ(context, bundle2, iUiListener2);
            }
            f.c("openSDK_LOG.QzoneShare", "shareToQzone() --end");
            return;
        }
        iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
        f.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
    }
}
