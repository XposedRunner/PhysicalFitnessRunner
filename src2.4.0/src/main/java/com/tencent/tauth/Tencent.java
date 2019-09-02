package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.SocialOperation;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.HttpUtils.HttpStatusException;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.j;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static Tencent b;
    private final c a;

    private Tencent(String str, Context context) {
        this.a = c.a(str, context);
    }

    private static boolean a(Context context, String str) {
        String stringBuilder;
        StringBuilder stringBuilder2;
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
                return true;
            } catch (NameNotFoundException unused) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.");
                stringBuilder3.append("\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>");
                stringBuilder = stringBuilder3.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n");
                stringBuilder2.append(stringBuilder);
                f.e("openSDK_LOG.Tencent", stringBuilder2.toString());
                return false;
            }
        } catch (NameNotFoundException unused2) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent");
            stringBuilder4.append(str);
            stringBuilder4.append("\" />,详细信息请查看官网文档.");
            stringBuilder = stringBuilder4.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(stringBuilder);
            stringBuilder2.append("\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent");
            stringBuilder2.append(str);
            stringBuilder2.append("\" />\n");
            stringBuilder2.append("</intent-filter>\n");
            stringBuilder2.append("</activity>");
            stringBuilder = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity");
            stringBuilder2.append(stringBuilder);
            f.e("openSDK_LOG.Tencent", stringBuilder2.toString());
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            e.a(context.getApplicationContext());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("createInstance()  -- start, appId = ");
            stringBuilder.append(str);
            f.c("openSDK_LOG.Tencent", stringBuilder.toString());
            if (b == null) {
                b = new Tencent(str, context);
            } else if (!str.equals(b.getAppId())) {
                b.logout(context);
                b = new Tencent(str, context);
            }
            if (a(context, str)) {
                com.tencent.open.utils.f.a(context, str);
                f.c("openSDK_LOG.Tencent", "createInstance()  -- end");
                Tencent tencent = b;
                return tencent;
            }
            return null;
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        String str = "openSDK_LOG.Tencent";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleResultData() data = null ? ");
        boolean z = false;
        stringBuilder.append(intent == null);
        stringBuilder.append(", listener = null ? ");
        if (iUiListener == null) {
            z = true;
        }
        stringBuilder.append(z);
        f.c(str, stringBuilder.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        String str = "openSDK_LOG.Tencent";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityResultData() reqcode = ");
        stringBuilder.append(i);
        stringBuilder.append(", resultcode = ");
        stringBuilder.append(i2);
        stringBuilder.append(", data = null ? ");
        boolean z = false;
        stringBuilder.append(intent == null);
        stringBuilder.append(", listener = null ? ");
        if (iUiListener == null) {
            z = true;
        }
        stringBuilder.append(z);
        f.c(str, stringBuilder.toString());
        return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "ask()");
        new SocialApi(this.a.b()).ask(activity, bundle, iUiListener);
        return 0;
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        new SocialOperation(getQQToken()).bindQQGroup(activity, bundle);
    }

    public void checkLogin(IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "checkLogin()");
        this.a.a(iUiListener);
    }

    public boolean checkSessionValid(String str) {
        JSONObject loadSession = this.a.b().loadSession(str);
        if (!(loadSession == null || loadSession.length() == 0)) {
            try {
                String string = loadSession.getString("access_token");
                String string2 = loadSession.getString("expires_in");
                String string3 = loadSession.getString("openid");
                str = loadSession.getString(Constants.PARAM_EXPIRES_TIME);
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || TextUtils.isEmpty(str))) {
                    if (System.currentTimeMillis() < Long.parseLong(str)) {
                        return true;
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("checkSessionValid ");
                stringBuilder.append(e.toString());
                f.c("QQToken", stringBuilder.toString());
                return false;
            }
        }
        return false;
    }

    public String getAccessToken() {
        return this.a.b().getAccessToken();
    }

    public String getAppId() {
        return this.a.b().getAppId();
    }

    public long getExpiresIn() {
        return this.a.b().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.a.b().getOpenId();
    }

    public QQToken getQQToken() {
        return this.a.b();
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "gift()");
        new SocialApi(this.a.b()).gift(activity, bundle, iUiListener);
        return 0;
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        String str = "openSDK_LOG.Tencent";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleLoginData() data = null ? ");
        boolean z = false;
        stringBuilder.append(intent == null);
        stringBuilder.append(", listener = null ? ");
        if (iUiListener == null) {
            z = true;
        }
        stringBuilder.append(z);
        f.c(str, stringBuilder.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("initSessionCache ");
            stringBuilder.append(e.toString());
            f.c("QQToken", stringBuilder.toString());
        }
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "invite()");
        new SocialApi(this.a.b()).invite(activity, bundle, iUiListener);
        return 0;
    }

    public boolean isQQInstalled(Context context) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (((PackageInfo) installedPackages.get(i)).packageName.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public boolean isSessionValid() {
        return this.a.c();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        boolean z = true;
        if (j.d((Context) activity) && h.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (h.c(activity, "4.1") < 0 && h.d(activity, "1.1") < 0) {
            z = false;
        }
        return z;
    }

    public boolean joinQQGroup(Activity activity, String str) {
        StringBuilder stringBuilder;
        f.c("openSDK_LOG.Tencent", "joinQQGroup()");
        Intent intent = new Intent();
        String openId = this.a.b().getOpenId();
        String appId = this.a.b().getAppId();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26k%3D");
        stringBuilder2.append(str);
        StringBuffer stringBuffer = new StringBuffer(stringBuilder2.toString());
        if (!TextUtils.isEmpty(openId)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("&openid=");
            stringBuilder.append(Base64.encodeToString(j.i(openId), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("&appid=");
            stringBuilder.append(appId);
            stringBuffer.append(stringBuilder.toString());
        }
        intent.setData(Uri.parse(stringBuffer.toString()));
        try {
            activity.startActivity(intent);
            d.a().a(this.a.b().getOpenId(), this.a.b().getAppId(), Constants.VIA_JOIN_GROUP, Constants.VIA_REPORT_TYPE_JOININ_GROUP, "18", "0");
            return true;
        } catch (Exception unused) {
            d.a().a(this.a.b().getOpenId(), this.a.b().getAppId(), Constants.VIA_JOIN_GROUP, Constants.VIA_REPORT_TYPE_JOININ_GROUP, "18", "1");
            return false;
        }
    }

    public JSONObject loadSession(String str) {
        return this.a.b().loadSession(str);
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("login() with activity, scope is ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.a(activity, str, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("login() with fragment, scope is ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.a(fragment, str, iUiListener, "");
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loginServerSide() with activity, scope = ");
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        c cVar = this.a;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        return cVar.a(activity, stringBuilder.toString(), iUiListener);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loginServerSide() with fragment, scope = ");
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        c cVar = this.a;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        return cVar.a(fragment, stringBuilder.toString(), iUiListener, "");
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loginWithOEM() with activity, scope = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.a(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        f.c("openSDK_LOG.Tencent", "logout()");
        this.a.b().setAccessToken(null, "0");
        this.a.b().setOpenId(null);
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        new SocialOperation(getQQToken()).makeFriend(activity, bundle);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "publishToQzone()");
        new QzonePublish(activity, this.a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reAuth() with activity, scope = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.b(activity, str, iUiListener);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        this.a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        f.c("openSDK_LOG.Tencent", "request()");
        return HttpUtils.request(this.a.b(), e.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        f.c("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.requestAsync(this.a.b(), e.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        this.a.b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setAccessToken(), expiresIn = ");
        stringBuilder.append(str2);
        stringBuilder.append("");
        f.a("openSDK_LOG.Tencent", stringBuilder.toString());
        this.a.a(str, str2);
    }

    public void setOpenId(String str) {
        f.a("openSDK_LOG.Tencent", "setOpenId() --start");
        this.a.a(e.a(), str);
        f.a("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQQ()");
        new QQShare(activity, this.a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQzone()");
        new QzoneShare(activity, this.a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "story()");
        new SocialApi(this.a.b()).story(activity, bundle, iUiListener);
        return 0;
    }
}
