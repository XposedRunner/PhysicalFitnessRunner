package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.open.TDialog;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.HttpUtils.HttpStatusException;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class BaseApi {
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;
    protected c a;
    protected QQToken b;

    /* compiled from: ProGuard */
    public class TempRequestListener implements IRequestListener {
        private final IUiListener b;
        private final Handler c;

        public TempRequestListener(IUiListener iUiListener) {
            this.b = iUiListener;
            this.c = new Handler(e.a().getMainLooper(), BaseApi.this) {
                public void handleMessage(Message message) {
                    if (message.what == 0) {
                        TempRequestListener.this.b.onComplete(message.obj);
                    } else {
                        TempRequestListener.this.b.onError(new UiError(message.what, (String) message.obj, null));
                    }
                }
            };
        }

        public void onComplete(JSONObject jSONObject) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONObject;
            obtainMessage.what = 0;
            this.c.sendMessage(obtainMessage);
        }

        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = connectTimeoutException.getMessage();
            obtainMessage.what = -7;
            this.c.sendMessage(obtainMessage);
        }

        public void onHttpStatusException(HttpStatusException httpStatusException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = httpStatusException.getMessage();
            obtainMessage.what = -9;
            this.c.sendMessage(obtainMessage);
        }

        public void onIOException(IOException iOException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = iOException.getMessage();
            obtainMessage.what = -2;
            this.c.sendMessage(obtainMessage);
        }

        public void onJSONException(JSONException jSONException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = jSONException.getMessage();
            obtainMessage.what = -4;
            this.c.sendMessage(obtainMessage);
        }

        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = malformedURLException.getMessage();
            obtainMessage.what = -3;
            this.c.sendMessage(obtainMessage);
        }

        public void onNetworkUnavailableException(NetworkUnavailableException networkUnavailableException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = networkUnavailableException.getMessage();
            obtainMessage.what = -10;
            this.c.sendMessage(obtainMessage);
        }

        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = socketTimeoutException.getMessage();
            obtainMessage.what = -8;
            this.c.sendMessage(obtainMessage);
        }

        public void onUnknowException(Exception exception) {
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.obj = exception.getMessage();
            obtainMessage.what = -6;
            this.c.sendMessage(obtainMessage);
        }
    }

    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
    }

    public BaseApi(c cVar, QQToken qQToken) {
        this.a = cVar;
        this.b = qQToken;
    }

    private Intent a(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        return intent2;
    }

    /* Access modifiers changed, original: protected */
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        bundle.putString("status_version", VERSION.SDK);
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        if (this.b != null && this.b.isSessionValid()) {
            bundle.putString("access_token", this.b.getAccessToken());
            bundle.putString("oauth_consumer_key", this.b.getAppId());
            bundle.putString("openid", this.b.getOpenId());
            bundle.putString("appid_for_getting_config", this.b.getAppId());
        }
        SharedPreferences sharedPreferences = e.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            String str = Constants.PARAM_PLATFORM_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("desktop_m_qq-");
            stringBuilder.append(installChannel);
            stringBuilder.append("-");
            stringBuilder.append("android");
            stringBuilder.append("-");
            stringBuilder.append(registerChannel);
            stringBuilder.append("-");
            stringBuilder.append(businessId);
            bundle.putString(str, stringBuilder.toString());
        } else {
            bundle.putString(Constants.PARAM_PLATFORM_ID, sharedPreferences.getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        }
        return bundle;
    }

    /* Access modifiers changed, original: protected */
    public String a(String str) {
        Bundle a = a();
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            a.putString("need_version", str);
        }
        stringBuilder.append("http://openmobile.qq.com/oauth2.0/m_jump_by_version?");
        stringBuilder.append(HttpUtils.encodeUrl(a));
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: protected */
    public void a(Activity activity, int i, Intent intent, boolean z) {
        Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra("openSDK_LOG.AssistActivity.ExtraIntent", intent);
        activity.startActivityForResult(intent2, i);
    }

    /* Access modifiers changed, original: protected */
    public void a(Activity activity, Intent intent, int i) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i);
        activity.startActivityForResult(a(activity, intent), i);
    }

    /* Access modifiers changed, original: protected */
    public void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        stringBuilder.append(HttpUtils.encodeUrl(bundle));
        Context context = activity;
        new TDialog(context, "", stringBuilder.toString(), null, this.b).show();
    }

    /* Access modifiers changed, original: protected */
    public void a(Fragment fragment, Intent intent, int i) {
        intent.putExtra(Constants.KEY_REQUEST_CODE, i);
        fragment.startActivityForResult(a(fragment.getActivity(), intent), i);
    }

    /* Access modifiers changed, original: protected */
    public boolean a(Intent intent) {
        return intent != null ? h.a(e.a(), intent) : false;
    }

    /* Access modifiers changed, original: protected */
    public Intent b(String str) {
        Intent intent = new Intent();
        if (j.d(e.a())) {
            intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
            if (h.a(e.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (h.a(e.a(), intent)) {
            return intent;
        }
        intent.setClassName(Constants.PACKAGE_TIM, str);
        return h.a(e.a(), intent) ? intent : null;
    }

    /* Access modifiers changed, original: protected */
    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString("appid", this.b.getAppId());
        if (this.b.isSessionValid()) {
            bundle.putString(Constants.PARAM_KEY_STR, this.b.getAccessToken());
            bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
        }
        String openId = this.b.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        SharedPreferences sharedPreferences = e.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            openId = Constants.PARAM_PLATFORM_ID;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("desktop_m_qq-");
            stringBuilder.append(installChannel);
            stringBuilder.append("-");
            stringBuilder.append("android");
            stringBuilder.append("-");
            stringBuilder.append(registerChannel);
            stringBuilder.append("-");
            stringBuilder.append(businessId);
            bundle.putString(openId, stringBuilder.toString());
        } else {
            bundle.putString(Constants.PARAM_PLATFORM_ID, sharedPreferences.getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        bundle.putString("sdkv", Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    /* Access modifiers changed, original: protected */
    public Intent c(String str) {
        Intent intent = new Intent();
        Intent b = b(str);
        if (b == null || b.getComponent() == null) {
            return null;
        }
        intent.setClassName(b.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    public void releaseResource() {
    }
}
