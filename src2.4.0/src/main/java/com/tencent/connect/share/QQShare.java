package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.b;
import com.tencent.open.utils.c;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_APP = 6;
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType = "";

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
    }

    private void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        final String string2 = bundle.getString("title");
        final String string3 = bundle.getString("summary");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shareToMobileQQ -- imageUrl: ");
        stringBuilder.append(string);
        f.a("openSDK_LOG.QQShare", stringBuilder.toString());
        final Bundle bundle2;
        final IUiListener iUiListener2;
        final Activity activity2;
        if (TextUtils.isEmpty(string)) {
            c(activity, bundle, iUiListener);
        } else if (!j.g(string)) {
            bundle.putString("imageUrl", null);
            if (j.f(activity, "4.3.0")) {
                f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                c(activity, bundle, iUiListener);
            } else {
                f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
                bundle2 = bundle;
                iUiListener2 = iUiListener;
                activity2 = activity;
                a.a((Context) activity, string, new c() {
                    public void a(int i, String str) {
                        if (i == 0) {
                            bundle2.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            if (iUiListener2 != null) {
                                iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                                f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, QQShare.this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.c(activity2, bundle2, iUiListener2);
                    }

                    public void a(int i, ArrayList<String> arrayList) {
                    }
                });
            }
        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            if (iUiListener != null) {
                iUiListener.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
                f.e("openSDK_LOG.QQShare", Constants.MSG_SHARE_NOSD_ERROR);
            }
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_NOSD_ERROR);
            return;
        } else if (j.f(activity, "4.3.0")) {
            bundle2 = bundle;
            iUiListener2 = iUiListener;
            activity2 = activity;
            new b(activity).a(string, new c() {
                public void a(int i, String str) {
                    if (i == 0) {
                        bundle2.putString("imageLocalUrl", str);
                    } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                        if (iUiListener2 != null) {
                            iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_GETIMG_ERROR, null));
                            f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                        }
                        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, QQShare.this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                        return;
                    }
                    QQShare.this.c(activity2, bundle2, iUiListener2);
                }

                public void a(int i, ArrayList<String> arrayList) {
                }
            });
        } else {
            c(activity, bundle, iUiListener);
        }
        f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0343  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x02fb  */
    private void c(android.app.Activity r28, android.os.Bundle r29, com.tencent.tauth.IUiListener r30) {
        /*
        r27 = this;
        r0 = r27;
        r1 = r28;
        r2 = r29;
        r3 = r30;
        r4 = "openSDK_LOG.QQShare";
        r5 = "doShareToQQ() -- start";
        com.tencent.open.a.f.c(r4, r5);
        r4 = new java.lang.StringBuffer;
        r5 = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news";
        r4.<init>(r5);
        r5 = "imageUrl";
        r5 = r2.getString(r5);
        r6 = "title";
        r6 = r2.getString(r6);
        r7 = "summary";
        r7 = r2.getString(r7);
        r8 = "targetUrl";
        r8 = r2.getString(r8);
        r9 = "audio_url";
        r9 = r2.getString(r9);
        r10 = "req_type";
        r11 = 1;
        r10 = r2.getInt(r10, r11);
        r12 = "share_to_qq_ark_info";
        r12 = r2.getString(r12);
        r13 = "cflag";
        r14 = 0;
        r13 = r2.getInt(r13, r14);
        r15 = "share_qq_ext_str";
        r15 = r2.getString(r15);
        r16 = com.tencent.open.utils.j.a(r28);
        if (r16 != 0) goto L_0x005a;
    L_0x0054:
        r11 = "appName";
        r16 = r2.getString(r11);
    L_0x005a:
        r11 = r16;
        r14 = "imageLocalUrl";
        r2 = r2.getString(r14);
        r14 = r0.b;
        r14 = r14.getAppId();
        r3 = r0.b;
        r3 = r3.getOpenId();
        r1 = "openSDK_LOG.QQShare";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r20 = r13;
        r13 = "doShareToQQ -- openid: ";
        r0.append(r13);
        r0.append(r3);
        r0 = r0.toString();
        com.tencent.open.a.f.a(r1, r0);
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 2;
        if (r0 != 0) goto L_0x00a9;
    L_0x008d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r13 = "&image_url=";
        r0.append(r13);
        r5 = com.tencent.open.utils.j.i(r5);
        r5 = android.util.Base64.encodeToString(r5, r1);
        r0.append(r5);
        r0 = r0.toString();
        r4.append(r0);
    L_0x00a9:
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x00cb;
    L_0x00af:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r5 = "&file_data=";
        r0.append(r5);
        r2 = com.tencent.open.utils.j.i(r2);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x00cb:
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 != 0) goto L_0x00ed;
    L_0x00d1:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&title=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r6);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x00ed:
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 != 0) goto L_0x010f;
    L_0x00f3:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&description=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r7);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x010f:
        r0 = android.text.TextUtils.isEmpty(r14);
        if (r0 != 0) goto L_0x0129;
    L_0x0115:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&share_id=";
        r0.append(r2);
        r0.append(r14);
        r0 = r0.toString();
        r4.append(r0);
    L_0x0129:
        r0 = android.text.TextUtils.isEmpty(r8);
        if (r0 != 0) goto L_0x014b;
    L_0x012f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&url=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r8);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x014b:
        r0 = android.text.TextUtils.isEmpty(r11);
        if (r0 != 0) goto L_0x018b;
    L_0x0151:
        r0 = r11.length();
        r2 = 20;
        if (r0 <= r2) goto L_0x016f;
    L_0x0159:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r5 = 0;
        r2 = r11.substring(r5, r2);
        r0.append(r2);
        r2 = "...";
        r0.append(r2);
        r11 = r0.toString();
    L_0x016f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&app_name=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r11);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x018b:
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x01ad;
    L_0x0191:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&open_id=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r3);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x01ad:
        r0 = android.text.TextUtils.isEmpty(r9);
        if (r0 != 0) goto L_0x01cf;
    L_0x01b3:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&audioUrl=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r9);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x01cf:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&req_type=";
        r0.append(r2);
        r2 = java.lang.String.valueOf(r10);
        r2 = com.tencent.open.utils.j.i(r2);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
        r0 = android.text.TextUtils.isEmpty(r12);
        if (r0 != 0) goto L_0x0211;
    L_0x01f5:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&share_to_qq_ark_info=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r12);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x0211:
        r0 = android.text.TextUtils.isEmpty(r15);
        if (r0 != 0) goto L_0x0233;
    L_0x0217:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&share_qq_ext_str=";
        r0.append(r2);
        r2 = com.tencent.open.utils.j.i(r15);
        r2 = android.util.Base64.encodeToString(r2, r1);
        r0.append(r2);
        r0 = r0.toString();
        r4.append(r0);
    L_0x0233:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "&cflag=";
        r0.append(r2);
        r2 = r20;
        r3 = java.lang.String.valueOf(r2);
        r3 = com.tencent.open.utils.j.i(r3);
        r1 = android.util.Base64.encodeToString(r3, r1);
        r0.append(r1);
        r0 = r0.toString();
        r4.append(r0);
        r0 = "openSDK_LOG.QQShare";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = "doShareToQQ -- url: ";
        r1.append(r3);
        r3 = r4.toString();
        r1.append(r3);
        r1 = r1.toString();
        com.tencent.open.a.f.a(r0, r1);
        r0 = com.tencent.open.utils.e.a();
        r1 = r27;
        r3 = r1.b;
        r5 = "requireApi";
        r6 = 1;
        r7 = new java.lang.String[r6];
        r6 = "shareToNativeQQ";
        r8 = 0;
        r7[r8] = r6;
        com.tencent.connect.a.a.a(r0, r3, r5, r7);
        r0 = new android.content.Intent;
        r3 = "android.intent.action.VIEW";
        r0.<init>(r3);
        r3 = r4.toString();
        r3 = android.net.Uri.parse(r3);
        r0.setData(r3);
        r3 = "pkg_name";
        r4 = r28;
        r5 = r28.getPackageName();
        r0.putExtra(r3, r5);
        r3 = "4.6.0";
        r3 = com.tencent.open.utils.j.f(r4, r3);
        if (r3 == 0) goto L_0x02c6;
    L_0x02a9:
        r3 = "openSDK_LOG.QQShare";
        r5 = "doShareToQQ, qqver below 4.6.";
        com.tencent.open.a.f.c(r3, r5);
        r3 = r1.a(r0);
        if (r3 == 0) goto L_0x02c4;
    L_0x02b6:
        r3 = com.tencent.connect.common.UIListenerManager.getInstance();
        r5 = 11103; // 0x2b5f float:1.5559E-41 double:5.4856E-320;
        r6 = r30;
        r3.setListenerWithRequestcode(r5, r6);
        r1.a(r4, r0, r5);
    L_0x02c4:
        r5 = 1;
        goto L_0x02ee;
    L_0x02c6:
        r6 = r30;
        r3 = "openSDK_LOG.QQShare";
        r5 = "doShareToQQ, qqver greater than 4.6.";
        com.tencent.open.a.f.c(r3, r5);
        r3 = com.tencent.connect.common.UIListenerManager.getInstance();
        r5 = "shareToQQ";
        r3 = r3.setListnerWithAction(r5, r6);
        if (r3 == 0) goto L_0x02e2;
    L_0x02db:
        r3 = "openSDK_LOG.QQShare";
        r5 = "doShareToQQ, last listener is not null, cancel it.";
        com.tencent.open.a.f.c(r3, r5);
    L_0x02e2:
        r3 = r1.a(r0);
        if (r3 == 0) goto L_0x02c4;
    L_0x02e8:
        r3 = 10103; // 0x2777 float:1.4157E-41 double:4.9915E-320;
        r5 = 1;
        r1.a(r4, r3, r0, r5);
    L_0x02ee:
        r3 = "10";
        if (r2 != r5) goto L_0x02f4;
    L_0x02f2:
        r3 = "11";
    L_0x02f4:
        r8 = r3;
        r0 = r1.a(r0);
        if (r0 == 0) goto L_0x0343;
    L_0x02fb:
        r4 = com.tencent.open.b.d.a();
        r0 = r1.b;
        r5 = r0.getOpenId();
        r0 = r1.b;
        r6 = r0.getAppId();
        r7 = "ANDROIDQQ.SHARETOQQ.XX";
        r9 = "3";
        r10 = "0";
        r11 = r1.mViaShareQQType;
        r12 = "0";
        r13 = "1";
        r14 = "0";
        r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r17 = com.tencent.open.b.d.a();
        r18 = 0;
        r19 = "SHARE_CHECK_SDK";
        r20 = "1000";
        r0 = r1.b;
        r21 = r0.getAppId();
        r0 = 0;
        r22 = java.lang.String.valueOf(r0);
        r2 = android.os.SystemClock.elapsedRealtime();
        r23 = java.lang.Long.valueOf(r2);
        r24 = 0;
        r25 = 1;
        r26 = "";
        r17.a(r18, r19, r20, r21, r22, r23, r24, r25, r26);
        goto L_0x038a;
    L_0x0343:
        r4 = com.tencent.open.b.d.a();
        r0 = r1.b;
        r5 = r0.getOpenId();
        r0 = r1.b;
        r6 = r0.getAppId();
        r7 = "ANDROIDQQ.SHARETOQQ.XX";
        r9 = "3";
        r10 = "1";
        r11 = r1.mViaShareQQType;
        r12 = "0";
        r13 = "1";
        r14 = "0";
        r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r17 = com.tencent.open.b.d.a();
        r18 = 1;
        r19 = "SHARE_CHECK_SDK";
        r20 = "1000";
        r0 = r1.b;
        r21 = r0.getAppId();
        r0 = 0;
        r22 = java.lang.String.valueOf(r0);
        r2 = android.os.SystemClock.elapsedRealtime();
        r23 = java.lang.Long.valueOf(r2);
        r24 = 0;
        r25 = 1;
        r26 = "hasActivityForIntent fail";
        r17.a(r18, r19, r20, r21, r22, r23, r24, r25, r26);
    L_0x038a:
        r0 = "openSDK_LOG.QQShare";
        r2 = "doShareToQQ() --end";
        com.tencent.open.a.f.c(r0, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.c(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    public void releaseResource() {
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Context context = activity;
        Bundle bundle2 = bundle;
        IUiListener iUiListener2 = iUiListener;
        f.c("openSDK_LOG.QQShare", "shareToQQ() -- start.");
        String string = bundle2.getString("imageUrl");
        String string2 = bundle2.getString("title");
        String string3 = bundle2.getString("summary");
        CharSequence string4 = bundle2.getString("targetUrl");
        String string5 = bundle2.getString("imageLocalUrl");
        int i = bundle2.getInt("req_type", 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shareToQQ -- type: ");
        stringBuilder.append(i);
        f.c("openSDK_LOG.QQShare", stringBuilder.toString());
        switch (i) {
            case 1:
                this.mViaShareQQType = "1";
                break;
            case 2:
                this.mViaShareQQType = "3";
                break;
            case 5:
                this.mViaShareQQType = "2";
                break;
            case 6:
                this.mViaShareQQType = "4";
                break;
        }
        boolean z = false;
        if (i == 6) {
            if (j.f(context, "5.0.0")) {
                iUiListener2.onError(new UiError(-15, Constants.MSG_PARAM_APPSHARE_TOO_LOW, null));
                f.e("openSDK_LOG.QQShare", "shareToQQ, app share is not support below qq5.0.");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, app share is not support below qq5.0.");
                return;
            }
            string4 = String.format("http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1", new Object[]{this.b.getAppId(), "mqq"});
            bundle2.putString("targetUrl", string4);
        }
        if (j.b() || !j.f(context, "4.5.0")) {
            if (i == 5) {
                if (j.f(context, "4.3.0")) {
                    iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_QQ_VERSION_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, version below 4.3 is not support.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, version below 4.3 is not support.");
                    return;
                } else if (!j.h(string5)) {
                    iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ -- error: 非法的图片地址!");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR);
                    return;
                }
            }
            if (i != 5) {
                if (TextUtils.isEmpty(string4) || !(string4.startsWith("http://") || string4.startsWith("https://"))) {
                    iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, targetUrl is empty or illegal..");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, targetUrl is empty or illegal..");
                    return;
                } else if (TextUtils.isEmpty(string2)) {
                    iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                    f.e("openSDK_LOG.QQShare", "shareToQQ, title is empty.");
                    d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, title is empty.");
                    return;
                }
            }
            if (TextUtils.isEmpty(string) || string.startsWith("http://") || string.startsWith("https://") || new File(string).exists()) {
                if (!TextUtils.isEmpty(string2) && string2.length() > 128) {
                    bundle2.putString("title", j.a(string2, 128, null, null));
                }
                if (!TextUtils.isEmpty(string3) && string3.length() > 512) {
                    bundle2.putString("summary", j.a(string3, 512, null, null));
                }
                if (bundle2.getInt("cflag", 0) == 1) {
                    z = true;
                }
                if (j.a(context, z)) {
                    f.c("openSDK_LOG.QQShare", "shareToQQ, support share");
                    b(activity, bundle, iUiListener);
                } else {
                    try {
                        f.d("openSDK_LOG.QQShare", "shareToQQ, don't support share, will show download dialog");
                        new TDialog(context, "", a(""), null, this.b).show();
                    } catch (RuntimeException e) {
                        Throwable th = e;
                        f.b("openSDK_LOG.QQShare", " shareToQQ, TDialog.show not in main thread", th);
                        th.printStackTrace();
                        iUiListener2.onError(new UiError(-6, Constants.MSG_NOT_CALL_ON_MAIN_THREAD, null));
                    }
                }
                f.c("openSDK_LOG.QQShare", "shareToQQ() -- end.");
                return;
            }
            iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
            f.e("openSDK_LOG.QQShare", "shareToQQ, image url is emprty or illegal.");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ, image url is emprty or illegal.");
            return;
        }
        iUiListener2.onError(new UiError(-6, Constants.MSG_SHARE_NOSD_ERROR, null));
        f.e("openSDK_LOG.QQShare", "shareToQQ sdcard is null--end");
        d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "shareToQQ sdcard is null");
    }
}
