package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x028e  */
    private void b(android.app.Activity r30, android.os.Bundle r31, com.tencent.tauth.IUiListener r32) {
        /*
        r29 = this;
        r1 = r29;
        r2 = r31;
        r3 = "openSDK_LOG.QzonePublish";
        r4 = "doPublishToQzone() --start";
        com.tencent.open.a.f.c(r3, r4);
        r3 = new java.lang.StringBuffer;
        r4 = "mqqapi://qzone/publish?src_type=app&version=1&file_type=news";
        r3.<init>(r4);
        r4 = "imageUrl";
        r4 = r2.getStringArrayList(r4);
        r5 = "summary";
        r5 = r2.getString(r5);
        r6 = "req_type";
        r7 = 3;
        r6 = r2.getInt(r6, r7);
        r8 = "appName";
        r8 = r2.getString(r8);
        r9 = "videoPath";
        r9 = r2.getString(r9);
        r10 = "videoDuration";
        r10 = r2.getInt(r10);
        r11 = "videoSize";
        r11 = r2.getLong(r11);
        r13 = "";
        r14 = "extMap";
        r2 = r2.getBundle(r14);	 Catch:{ Exception -> 0x008b }
        if (r2 == 0) goto L_0x0088;
    L_0x0047:
        r14 = r2.keySet();	 Catch:{ Exception -> 0x008b }
        r15 = new org.json.JSONObject;	 Catch:{ Exception -> 0x008b }
        r15.<init>();	 Catch:{ Exception -> 0x008b }
        r14 = r14.iterator();	 Catch:{ Exception -> 0x008b }
    L_0x0054:
        r16 = r14.hasNext();	 Catch:{ Exception -> 0x008b }
        if (r16 == 0) goto L_0x0079;
    L_0x005a:
        r16 = r14.next();	 Catch:{ Exception -> 0x008b }
        r7 = r16;
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x008b }
        r17 = r13;
        r13 = r2.getString(r7);	 Catch:{ Exception -> 0x0086 }
        r13 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Exception -> 0x0086 }
        if (r13 != 0) goto L_0x0075;
    L_0x006e:
        r13 = r2.getString(r7);	 Catch:{ Exception -> 0x0086 }
        r15.put(r7, r13);	 Catch:{ Exception -> 0x0086 }
    L_0x0075:
        r13 = r17;
        r7 = 3;
        goto L_0x0054;
    L_0x0079:
        r17 = r13;
        r2 = r15.length();	 Catch:{ Exception -> 0x0086 }
        if (r2 <= 0) goto L_0x0096;
    L_0x0081:
        r13 = r15.toString();	 Catch:{ Exception -> 0x0086 }
        goto L_0x0098;
    L_0x0086:
        r0 = move-exception;
        goto L_0x008e;
    L_0x0088:
        r17 = r13;
        goto L_0x0096;
    L_0x008b:
        r0 = move-exception;
        r17 = r13;
    L_0x008e:
        r2 = r0;
        r7 = "openSDK_LOG.QzonePublish";
        r13 = "publishToQzone()  --error parse extmap";
        com.tencent.open.a.f.b(r7, r13, r2);
    L_0x0096:
        r13 = r17;
    L_0x0098:
        r2 = r1.b;
        r2 = r2.getAppId();
        r7 = r1.b;
        r7 = r7.getOpenId();
        r14 = "openSDK_LOG.QzonePublish";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r1 = "openId:";
        r15.append(r1);
        r15.append(r7);
        r1 = r15.toString();
        com.tencent.open.a.f.a(r14, r1);
        r1 = "";
        r14 = 3;
        if (r14 != r6) goto L_0x0113;
    L_0x00bf:
        if (r4 == 0) goto L_0x0113;
    L_0x00c1:
        r1 = "7";
        r14 = new java.lang.StringBuffer;
        r14.<init>();
        r15 = r4.size();
        r18 = r1;
        r1 = 0;
    L_0x00cf:
        if (r1 >= r15) goto L_0x00f0;
    L_0x00d1:
        r16 = r4.get(r1);
        r19 = r4;
        r4 = r16;
        r4 = (java.lang.String) r4;
        r4 = java.net.URLEncoder.encode(r4);
        r14.append(r4);
        r4 = r15 + -1;
        if (r1 == r4) goto L_0x00eb;
    L_0x00e6:
        r4 = ";";
        r14.append(r4);
    L_0x00eb:
        r1 = r1 + 1;
        r4 = r19;
        goto L_0x00cf;
    L_0x00f0:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = "&image_url=";
        r1.append(r4);
        r4 = r14.toString();
        r4 = com.tencent.open.utils.j.i(r4);
        r14 = 2;
        r4 = android.util.Base64.encodeToString(r4, r14);
        r1.append(r4);
        r1 = r1.toString();
        r3.append(r1);
        r1 = r18;
    L_0x0113:
        r4 = 4;
        if (r4 != r6) goto L_0x0175;
    L_0x0116:
        r1 = "8";
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = "&videoPath=";
        r14.append(r15);
        r9 = com.tencent.open.utils.j.i(r9);
        r15 = 2;
        r9 = android.util.Base64.encodeToString(r9, r15);
        r14.append(r9);
        r9 = r14.toString();
        r3.append(r9);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r14 = "&videoDuration=";
        r9.append(r14);
        r10 = java.lang.String.valueOf(r10);
        r10 = com.tencent.open.utils.j.i(r10);
        r10 = android.util.Base64.encodeToString(r10, r15);
        r9.append(r10);
        r9 = r9.toString();
        r3.append(r9);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "&videoSize=";
        r9.append(r10);
        r10 = java.lang.String.valueOf(r11);
        r10 = com.tencent.open.utils.j.i(r10);
        r10 = android.util.Base64.encodeToString(r10, r15);
        r9.append(r10);
        r9 = r9.toString();
        r3.append(r9);
    L_0x0175:
        r25 = r1;
        r1 = android.text.TextUtils.isEmpty(r5);
        if (r1 != 0) goto L_0x019a;
    L_0x017d:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r9 = "&description=";
        r1.append(r9);
        r5 = com.tencent.open.utils.j.i(r5);
        r9 = 2;
        r5 = android.util.Base64.encodeToString(r5, r9);
        r1.append(r5);
        r1 = r1.toString();
        r3.append(r1);
    L_0x019a:
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 != 0) goto L_0x01b4;
    L_0x01a0:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r5 = "&share_id=";
        r1.append(r5);
        r1.append(r2);
        r1 = r1.toString();
        r3.append(r1);
    L_0x01b4:
        r1 = android.text.TextUtils.isEmpty(r8);
        if (r1 != 0) goto L_0x01d7;
    L_0x01ba:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "&app_name=";
        r1.append(r2);
        r2 = com.tencent.open.utils.j.i(r8);
        r5 = 2;
        r2 = android.util.Base64.encodeToString(r2, r5);
        r1.append(r2);
        r1 = r1.toString();
        r3.append(r1);
    L_0x01d7:
        r1 = com.tencent.open.utils.j.e(r7);
        if (r1 != 0) goto L_0x01fa;
    L_0x01dd:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "&open_id=";
        r1.append(r2);
        r2 = com.tencent.open.utils.j.i(r7);
        r5 = 2;
        r2 = android.util.Base64.encodeToString(r2, r5);
        r1.append(r2);
        r1 = r1.toString();
        r3.append(r1);
    L_0x01fa:
        r1 = android.text.TextUtils.isEmpty(r13);
        if (r1 != 0) goto L_0x021d;
    L_0x0200:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "&share_qzone_ext_str=";
        r1.append(r2);
        r2 = com.tencent.open.utils.j.i(r13);
        r5 = 2;
        r2 = android.util.Base64.encodeToString(r2, r5);
        r1.append(r2);
        r1 = r1.toString();
        r3.append(r1);
    L_0x021d:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "&req_type=";
        r1.append(r2);
        r2 = java.lang.String.valueOf(r6);
        r2 = com.tencent.open.utils.j.i(r2);
        r5 = 2;
        r2 = android.util.Base64.encodeToString(r2, r5);
        r1.append(r2);
        r1 = r1.toString();
        r3.append(r1);
        r1 = "openSDK_LOG.QzonePublish";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "doPublishToQzone, url: ";
        r2.append(r5);
        r5 = r3.toString();
        r2.append(r5);
        r2 = r2.toString();
        com.tencent.open.a.f.a(r1, r2);
        r1 = com.tencent.open.utils.e.a();
        r2 = r29;
        r5 = r2.b;
        r6 = "requireApi";
        r7 = 1;
        r7 = new java.lang.String[r7];
        r8 = "shareToNativeQQ";
        r9 = 0;
        r7[r9] = r8;
        com.tencent.connect.a.a.a(r1, r5, r6, r7);
        r1 = new android.content.Intent;
        r5 = "android.intent.action.VIEW";
        r1.<init>(r5);
        r3 = r3.toString();
        r3 = android.net.Uri.parse(r3);
        r1.setData(r3);
        r3 = "pkg_name";
        r5 = r30.getPackageName();
        r1.putExtra(r3, r5);
        r3 = r2.a(r1);
        if (r3 == 0) goto L_0x02da;
    L_0x028e:
        r3 = 10104; // 0x2778 float:1.4159E-41 double:4.992E-320;
        r5 = r30;
        r6 = 0;
        r2.a(r5, r3, r1, r6);
        r7 = com.tencent.open.b.d.a();
        r8 = 0;
        r9 = "SHARE_CHECK_SDK";
        r10 = "1000";
        r1 = r2.b;
        r11 = r1.getAppId();
        r12 = java.lang.String.valueOf(r4);
        r3 = android.os.SystemClock.elapsedRealtime();
        r13 = java.lang.Long.valueOf(r3);
        r14 = 0;
        r15 = 1;
        r16 = "hasActivityForIntent success";
        r7.a(r8, r9, r10, r11, r12, r13, r14, r15, r16);
        r18 = com.tencent.open.b.d.a();
        r1 = r2.b;
        r19 = r1.getOpenId();
        r1 = r2.b;
        r20 = r1.getAppId();
        r21 = "ANDROIDQQ.SHARETOQZ.XX";
        r22 = "11";
        r23 = "3";
        r24 = "1";
        r26 = "0";
        r27 = "1";
        r28 = "0";
        r18.a(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        goto L_0x0324;
    L_0x02da:
        r1 = "openSDK_LOG.QzonePublish";
        r3 = "doPublishToQzone() target activity not found";
        com.tencent.open.a.f.e(r1, r3);
        r5 = com.tencent.open.b.d.a();
        r6 = 1;
        r7 = "SHARE_CHECK_SDK";
        r8 = "1000";
        r1 = r2.b;
        r9 = r1.getAppId();
        r10 = java.lang.String.valueOf(r4);
        r3 = android.os.SystemClock.elapsedRealtime();
        r11 = java.lang.Long.valueOf(r3);
        r12 = 0;
        r13 = 1;
        r14 = "hasActivityForIntent fail";
        r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r18 = com.tencent.open.b.d.a();
        r1 = r2.b;
        r19 = r1.getOpenId();
        r1 = r2.b;
        r20 = r1.getAppId();
        r21 = "ANDROIDQQ.SHARETOQZ.XX";
        r22 = "11";
        r23 = "3";
        r24 = "1";
        r26 = "0";
        r27 = "1";
        r28 = "0";
        r18.a(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    L_0x0324:
        r1 = "openSDK_LOG";
        r3 = "doPublishToQzone() --end";
        com.tencent.open.a.f.c(r1, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzonePublish.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        final Bundle bundle2 = bundle;
        final IUiListener iUiListener2 = iUiListener;
        f.c("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle2 == null) {
            iUiListener2.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
        } else if (j.e((Context) activity)) {
            CharSequence a = j.a((Context) activity);
            int i = 0;
            if (a == null) {
                a = bundle2.getString("appName");
            } else if (a.length() > 20) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a.substring(0, 20));
                stringBuilder.append("...");
                a = stringBuilder.toString();
            }
            if (!TextUtils.isEmpty(a)) {
                bundle2.putString("appName", a);
            }
            int i2 = bundle2.getInt("req_type");
            if (i2 == 3) {
                ArrayList stringArrayList = bundle2.getStringArrayList("imageUrl");
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    while (i < stringArrayList.size()) {
                        if (!j.h((String) stringArrayList.get(i))) {
                            stringArrayList.remove(i);
                            i--;
                        }
                        i++;
                    }
                    bundle2.putStringArrayList("imageUrl", stringArrayList);
                }
                b(activity, bundle, iUiListener);
                f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            } else if (i2 == 4) {
                String string = bundle2.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
                if (j.h(string)) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    final String str = string;
                    final Activity activity2 = activity;
                    final IUiListener iUiListener3 = iUiListener2;
                    mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            long length = new File(str).length();
                            int duration = mediaPlayer.getDuration();
                            bundle2.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, str);
                            bundle2.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                            bundle2.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                            QzonePublish.this.b(activity2, bundle2, iUiListener3);
                            f.c("openSDK_LOG.QzonePublish", "publishToQzone() --end");
                        }
                    });
                    mediaPlayer.setOnErrorListener(new OnErrorListener() {
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            f.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                            iUiListener2.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                            return false;
                        }
                    });
                    try {
                        mediaPlayer.setDataSource(string);
                        mediaPlayer.prepareAsync();
                    } catch (Exception unused) {
                        f.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
                        iUiListener2.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                    }
                } else {
                    f.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
                    iUiListener2.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                }
            } else {
                iUiListener2.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
                f.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
                d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            }
        } else {
            iUiListener2.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            f.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            d.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, "", a(""), null, this.b).show();
        }
    }
}
