package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.c.b;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class SocialApiIml extends BaseApi {
    private Activity c;

    /* compiled from: ProGuard */
    private class a implements IUiListener {
        private IUiListener b;
        private String c;
        private String d;
        private Bundle e;
        private Activity f;

        a(Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.b = iUiListener;
            this.c = str;
            this.d = str2;
            this.e = bundle;
        }

        public void onCancel() {
            this.b.onCancel();
        }

        public void onComplete(Object obj) {
            String string;
            try {
                string = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (JSONException e) {
                e.printStackTrace();
                f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e);
                string = null;
            }
            this.e.putString("encrytoken", string);
            SocialApiIml.this.a((Context) SocialApiIml.this.c, this.c, this.e, this.d, this.b);
            if (TextUtils.isEmpty(string)) {
                f.b("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                SocialApiIml.this.writeEncryToken(this.f);
            }
        }

        public void onError(UiError uiError) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OpenApi, EncryptTokenListener() onError");
            stringBuilder.append(uiError.errorMessage);
            f.b("openSDK_LOG.SocialApiIml", stringBuilder.toString());
            this.b.onError(uiError);
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public SocialApiIml(c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->handleIntentWithAgent action = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.SocialApiIml", stringBuilder.toString());
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, (int) Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        String str3 = "openSDK_LOG.SocialApiIml";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->handleIntent action = ");
        stringBuilder.append(str);
        stringBuilder.append(", activityIntent = null ? ");
        Object obj = null;
        stringBuilder.append(intent == null);
        f.c(str3, stringBuilder.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        com.tencent.open.utils.f a = com.tencent.open.utils.f.a(e.a(), this.b.getAppId());
        if (z || a.b("C_LoginH5")) {
            obj = 1;
        }
        if (obj != null) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c == null) {
            f.c("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = c;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, g.a().a(e.a(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->handleIntentWithH5 action = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.SocialApiIml", stringBuilder.toString());
        Intent b = b("com.tencent.open.agent.AgentActivity");
        a aVar = new a(activity, iUiListener, str, str2, bundle);
        Intent b2 = b("com.tencent.open.agent.EncryTokenActivity");
        if (b2 == null || b == null || b.getComponent() == null || b2.getComponent() == null || !b.getComponent().getPackageName().equals(b2.getComponent().getPackageName())) {
            f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("tencent&sdk&qazxc***14969%%");
            stringBuilder2.append(this.b.getAccessToken());
            stringBuilder2.append(this.b.getAppId());
            stringBuilder2.append(this.b.getOpenId());
            stringBuilder2.append("qzone3.4");
            String f = j.f(stringBuilder2.toString());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, f);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            aVar.onComplete(jSONObject);
            return;
        }
        b2.putExtra("oauth_consumer_key", this.b.getAppId());
        b2.putExtra("openid", this.b.getOpenId());
        b2.putExtra("access_token", this.b.getAccessToken());
        b2.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
        if (a(b2)) {
            f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
            a(activity, b2, (int) Constants.REQUEST_SOCIAL_H5);
        }
    }

    private void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.a("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.b.getAppId());
        if (this.b.isSessionValid()) {
            bundle.putString("access_token", this.b.getAccessToken());
        }
        String openId = this.b.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString(Constants.PARAM_PLATFORM_ID, e.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        } catch (Exception e) {
            e.printStackTrace();
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(HttpUtils.encodeUrl(bundle));
        String stringBuilder2 = stringBuilder.toString();
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (SocialConstants.ACTION_CHALLENGE.equals(str) || SocialConstants.ACTION_BRAG.equals(str)) {
            f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new c(this.c, str, stringBuilder2, iUiListener, this.b).show();
            return;
        }
        new TDialog(this.c, str, stringBuilder2, iUiListener, this.b).show();
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    /* Access modifiers changed, original: protected */
    public Intent b(String str) {
        Intent intent = new Intent();
        intent.setClassName(Constants.PACKAGE_QZONE, str);
        Intent intent2 = new Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        Intent intent3 = new Intent();
        intent3.setClassName(Constants.PACKAGE_QQ_PAD, str);
        if (j.d(e.a()) && h.a(e.a(), intent3)) {
            return intent3;
        }
        if (h.a(e.a(), intent2) && h.c(e.a(), "4.7") >= 0) {
            return intent2;
        }
        if (!h.a(e.a(), intent) || h.a(h.a(e.a(), Constants.PACKAGE_QZONE), "4.2") < 0) {
            return null;
        }
        if (!h.a(e.a(), intent.getComponent().getPackageName(), Constants.SIGNATRUE_QZONE)) {
            intent = null;
        }
        return intent;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c == null) {
            f.c("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c = c(SocialConstants.ACTIVITY_INVITE);
        }
        Intent intent = c;
        bundle.putAll(b());
        Activity activity2 = activity;
        a(activity2, intent, SocialConstants.ACTION_INVITE, bundle, g.a().a(e.a(), "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        Activity activity2 = activity;
        a(activity2, c, SocialConstants.ACTION_STORY, bundle, g.a().a(e.a(), "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str = "tencent&sdk&qazxc***14969%%";
        String accessToken = this.b.getAccessToken();
        String appId = this.b.getAppId();
        String openId = this.b.getOpenId();
        String str2 = "qzone3.4";
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(accessToken);
            stringBuilder.append(appId);
            stringBuilder.append(openId);
            stringBuilder.append(str2);
            str = j.f(stringBuilder.toString());
        }
        b bVar = new b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"");
        stringBuilder2.append(this.b.getOpenId());
        stringBuilder2.append("_");
        stringBuilder2.append(this.b.getAppId());
        stringBuilder2.append("\"]=\"");
        stringBuilder2.append(str);
        stringBuilder2.append("\";</script></head><body></body></html>");
        openId = stringBuilder2.toString();
        String a = g.a().a(context, "http://qzs.qq.com");
        bVar.loadDataWithBaseURL(a, openId, "text/html", "utf-8", a);
    }
}
