package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.j;

/* compiled from: ProGuard */
public class SocialOperation extends BaseApi {
    public static final String GAME_FRIEND_ADD_MESSAGE = "add_msg";
    public static final String GAME_FRIEND_LABEL = "friend_label";
    public static final String GAME_FRIEND_OPENID = "fopen_id";
    public static final String GAME_SIGNATURE = "signature";
    public static final String GAME_UNION_ID = "unionid";
    public static final String GAME_UNION_NAME = "union_name";
    public static final String GAME_ZONE_ID = "zoneid";

    public SocialOperation(QQToken qQToken) {
        super(qQToken);
    }

    private void a(Activity activity) {
        a(activity, "");
    }

    private void a(Activity activity, String str) {
        new TDialog(activity, "", a(str), null, this.b).show();
    }

    public void bindQQGroup(Activity activity, Bundle bundle) {
        f.c("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- start");
        if (activity == null) {
            f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, activity is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
        } else if (bundle == null) {
            Toast.makeText(activity, "Bundle参数为空", 0).show();
            f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, params is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
        } else {
            StringBuilder stringBuilder;
            String a = j.a((Context) activity);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/bind_group?src_type=app&version=1");
            if (!TextUtils.isEmpty(a)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("&app_name=");
                stringBuilder.append(Base64.encodeToString(j.i(a), 2));
                stringBuffer.append(stringBuilder.toString());
            }
            a = bundle.getString(GAME_UNION_ID);
            if (TextUtils.isEmpty(a)) {
                Toast.makeText(activity, "游戏公会ID为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game union id is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("&unionid=");
            stringBuilder.append(Base64.encodeToString(j.i(a), 2));
            stringBuffer.append(stringBuilder.toString());
            a = bundle.getString(GAME_UNION_NAME);
            if (TextUtils.isEmpty(a)) {
                Toast.makeText(activity, "游戏公会名称为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game union name is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("&union_name=");
            stringBuilder.append(Base64.encodeToString(j.i(a), 2));
            stringBuffer.append(stringBuilder.toString());
            a = bundle.getString(GAME_ZONE_ID);
            if (TextUtils.isEmpty(a)) {
                Toast.makeText(activity, "游戏区域ID为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game zone id  is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("&zoneid=");
            stringBuilder.append(Base64.encodeToString(j.i(a), 2));
            stringBuffer.append(stringBuilder.toString());
            String string = bundle.getString(GAME_SIGNATURE);
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(activity, "游戏签名为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, game signature is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("&signature=");
            stringBuilder2.append(Base64.encodeToString(j.i(string), 2));
            stringBuffer.append(stringBuilder2.toString());
            string = this.b.getOpenId();
            if (TextUtils.isEmpty(string)) {
                Toast.makeText(activity, "Openid为空", 0).show();
                f.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, openid is empty.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                return;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("&openid=");
            stringBuilder3.append(Base64.encodeToString(j.i(string), 2));
            stringBuffer.append(stringBuilder3.toString());
            bundle = b();
            for (String a2 : bundle.keySet()) {
                bundle.putString(a2, Base64.encodeToString(j.i(bundle.getString(a2)), 2));
            }
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(HttpUtils.PARAMETERS_SEPARATOR);
            stringBuilder3.append(com.tencent.open.utils.HttpUtils.encodeUrl(bundle));
            stringBuffer.append(stringBuilder3.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("-->bindQQGroup, url: ");
            stringBuilder3.append(stringBuffer.toString());
            f.a("openSDK_LOG.GameAppOperation", stringBuilder3.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            if (!a(intent) || j.f(activity, "5.1.0")) {
                f.d("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                a(activity);
            } else {
                f.c("openSDK_LOG.GameAppOperation", "-->bingQQGroup target activity found, qqver > 5.1.0");
                try {
                    activity.startActivity(intent);
                    d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "0");
                } catch (Exception e) {
                    f.b("openSDK_LOG.GameAppOperation", "-->bind group, start activity exception.", e);
                    d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_BIND_GROUP, "18", "18", "1");
                    a(activity);
                }
            }
            f.c("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- end");
        }
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        f.c("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- start");
        if (bundle == null) {
            f.e("openSDK_LOG.GameAppOperation", "-->makeFriend params is null");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            return;
        }
        String string = bundle.getString(GAME_FRIEND_OPENID);
        if (TextUtils.isEmpty(string)) {
            f.e("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid is empty.");
            d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            return;
        }
        StringBuilder stringBuilder;
        String string2 = bundle.getString(GAME_FRIEND_LABEL);
        String string3 = bundle.getString(GAME_FRIEND_ADD_MESSAGE);
        String a = j.a((Context) activity);
        String openId = this.b.getOpenId();
        String appId = this.b.getAppId();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("-->make friend, fOpenid: ");
        stringBuilder2.append(string);
        stringBuilder2.append(" | label: ");
        stringBuilder2.append(string2);
        stringBuilder2.append(" | message: ");
        stringBuilder2.append(string3);
        stringBuilder2.append(" | openid: ");
        stringBuilder2.append(openId);
        stringBuilder2.append(" | appid:");
        stringBuilder2.append(appId);
        f.a("openSDK_LOG.GameAppOperation", stringBuilder2.toString());
        StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/add_friend?src_type=app&version=1");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("&fopen_id=");
        stringBuilder2.append(Base64.encodeToString(j.i(string), 2));
        stringBuffer.append(stringBuilder2.toString());
        if (!TextUtils.isEmpty(openId)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("&open_id=");
            stringBuilder.append(Base64.encodeToString(j.i(openId), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("&app_id=");
            stringBuilder.append(appId);
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("&friend_label=");
            stringBuilder.append(Base64.encodeToString(j.i(string2), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(string3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("&add_msg=");
            stringBuilder.append(Base64.encodeToString(j.i(string3), 2));
            stringBuffer.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(a)) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("&app_name=");
            stringBuilder3.append(Base64.encodeToString(j.i(a), 2));
            stringBuffer.append(stringBuilder3.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("-->make friend, url: ");
        stringBuilder.append(stringBuffer.toString());
        f.a("openSDK_LOG.GameAppOperation", stringBuilder.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        if (!a(intent) || j.f(activity, "5.1.0")) {
            f.d("openSDK_LOG.GameAppOperation", "-->make friend, there is no activity.");
            a(activity);
            d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
        } else {
            f.c("openSDK_LOG.GameAppOperation", "-->makeFriend target activity found, qqver greater than 5.1.0");
            try {
                activity.startActivity(intent);
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "0");
            } catch (Exception e) {
                f.b("openSDK_LOG.GameAppOperation", "-->make friend, start activity exception.", e);
                a(activity);
                d.a().a(this.b.getOpenId(), this.b.getAppId(), Constants.VIA_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "18", "1");
            }
        }
        f.c("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- end");
    }
}
