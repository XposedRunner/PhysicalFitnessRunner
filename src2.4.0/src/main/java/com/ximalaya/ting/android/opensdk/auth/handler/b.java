package com.ximalaya.ting.android.opensdk.auth.handler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import com.ximalaya.ting.android.opensdk.auth.component.XmlyBrowserComponent;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuthInfo;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyParameters;
import com.ximalaya.ting.android.opensdk.auth.utils.Logger;
import com.ximalaya.ting.android.opensdk.auth.utils.c;
import com.ximalaya.ting.android.opensdk.auth.utils.g;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: XmlyWebAuthHandler */
public class b {
    private static final String a = "b";
    private static final String b = "无法连接到网络，请检查网络配置";
    private static final String c = "https://m.ximalaya.com/login?";
    private static final String d = "https://m.ximalaya.com/xiaoya/login?";
    private static final String e = "https://api.ximalaya.com/oauth2/v2/authorize?";
    private static final String f = "UTF-8";
    private Context g;
    private XmlyAuthInfo h;

    public b(Context context, XmlyAuthInfo xmlyAuthInfo) {
        this.g = context;
        this.h = xmlyAuthInfo;
    }

    private XmlyAuthInfo a() {
        return this.h;
    }

    private static String a(XmlyParameters xmlyParameters) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : xmlyParameters.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                try {
                    stringBuilder.append(URLEncoder.encode("&", "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            Object obj2 = xmlyParameters.get(str);
            if (obj2 instanceof String) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(URLEncoder.encode(str, "UTF-8"));
                        stringBuilder2.append(URLEncoder.encode("=", "UTF-8"));
                        stringBuilder2.append(URLEncoder.encode(str2, "UTF-8"));
                        stringBuilder.append(stringBuilder2.toString());
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
                Logger.i("encodeUrl", stringBuilder.toString());
            }
        }
        return stringBuilder.toString();
    }

    private void c(IXmlyAuthListener iXmlyAuthListener) {
        if (iXmlyAuthListener != null) {
            String stringBuilder;
            XmlyParameters xmlyParameters = new XmlyParameters(this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
            xmlyParameters.put("redirect_uri", this.h.getRedirectUrl());
            xmlyParameters.put("device_id", this.h.getDeviceId());
            xmlyParameters.put("client_os_type", ClientOSType.ANDROID);
            xmlyParameters.put("pack_id", this.h.getPackId());
            String str = "";
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(URLEncoder.encode(e, "UTF-8"));
                stringBuilder2.append(a(xmlyParameters));
                stringBuilder = stringBuilder2.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                stringBuilder = str;
            }
            StringBuilder stringBuilder3 = new StringBuilder("https://m.ximalaya.com/login?fromUri=");
            stringBuilder3.append(stringBuilder);
            stringBuilder = stringBuilder3.toString();
            if (c.a(this.g)) {
                com.ximalaya.ting.android.opensdk.auth.component.c cVar = new com.ximalaya.ting.android.opensdk.auth.component.c(this.g);
                cVar.a(this.h);
                cVar.a(iXmlyAuthListener);
                cVar.a(stringBuilder);
                cVar.b("喜马拉雅登录");
                Bundle d = cVar.d();
                Intent intent = new Intent(this.g, XmlyBrowserComponent.class);
                intent.putExtras(d);
                this.g.startActivity(intent);
            } else {
                g.a(this.g, "Error", "Application requires permission to access the Internet");
            }
        }
    }

    private void d(IXmlyAuthListener iXmlyAuthListener) {
        if (iXmlyAuthListener != null) {
            String stringBuilder;
            XmlyParameters xmlyParameters = new XmlyParameters(this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
            xmlyParameters.put("redirect_uri", this.h.getRedirectUrl());
            xmlyParameters.put("device_id", this.h.getDeviceId());
            xmlyParameters.put("client_os_type", ClientOSType.ANDROID);
            xmlyParameters.put("pack_id", this.h.getPackId());
            String str = "";
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(URLEncoder.encode(e, "UTF-8"));
                stringBuilder2.append(a(xmlyParameters));
                stringBuilder = stringBuilder2.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                stringBuilder = str;
            }
            StringBuilder stringBuilder3 = new StringBuilder("https://m.ximalaya.com/xiaoya/login?fromUri=");
            stringBuilder3.append(stringBuilder);
            stringBuilder = stringBuilder3.toString();
            if (c.a(this.g)) {
                com.ximalaya.ting.android.opensdk.auth.component.c cVar = new com.ximalaya.ting.android.opensdk.auth.component.c(this.g);
                cVar.a(this.h);
                cVar.a(iXmlyAuthListener);
                cVar.a(stringBuilder);
                cVar.b("手机号注册");
                Bundle d = cVar.d();
                Intent intent = new Intent(this.g, XmlyBrowserComponent.class);
                intent.putExtras(d);
                this.g.startActivity(intent);
            } else {
                g.a(this.g, "Error", "Application requires permission to access the Internet");
            }
        }
    }

    public final void a(IXmlyAuthListener iXmlyAuthListener) {
        if (iXmlyAuthListener != null) {
            String stringBuilder;
            XmlyParameters xmlyParameters = new XmlyParameters(this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
            xmlyParameters.put("redirect_uri", this.h.getRedirectUrl());
            xmlyParameters.put("device_id", this.h.getDeviceId());
            xmlyParameters.put("client_os_type", ClientOSType.ANDROID);
            xmlyParameters.put("pack_id", this.h.getPackId());
            String str = "";
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(URLEncoder.encode(e, "UTF-8"));
                stringBuilder2.append(a(xmlyParameters));
                stringBuilder = stringBuilder2.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                stringBuilder = str;
            }
            StringBuilder stringBuilder3 = new StringBuilder("https://m.ximalaya.com/login?fromUri=");
            stringBuilder3.append(stringBuilder);
            stringBuilder = stringBuilder3.toString();
            if (c.a(this.g)) {
                com.ximalaya.ting.android.opensdk.auth.component.c cVar = new com.ximalaya.ting.android.opensdk.auth.component.c(this.g);
                cVar.a(this.h);
                cVar.a(iXmlyAuthListener);
                cVar.a(stringBuilder);
                cVar.b("喜马拉雅登录");
                Bundle d = cVar.d();
                Intent intent = new Intent(this.g, XmlyBrowserComponent.class);
                intent.putExtras(d);
                this.g.startActivity(intent);
            } else {
                g.a(this.g, "Error", "Application requires permission to access the Internet");
            }
        }
    }

    public final void b(IXmlyAuthListener iXmlyAuthListener) {
        if (iXmlyAuthListener != null) {
            String stringBuilder;
            XmlyParameters xmlyParameters = new XmlyParameters(this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, this.h.getAppKey());
            xmlyParameters.put(XmlyConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
            xmlyParameters.put("redirect_uri", this.h.getRedirectUrl());
            xmlyParameters.put("device_id", this.h.getDeviceId());
            xmlyParameters.put("client_os_type", ClientOSType.ANDROID);
            xmlyParameters.put("pack_id", this.h.getPackId());
            String str = "";
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(URLEncoder.encode(e, "UTF-8"));
                stringBuilder2.append(a(xmlyParameters));
                stringBuilder = stringBuilder2.toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                stringBuilder = str;
            }
            StringBuilder stringBuilder3 = new StringBuilder("https://m.ximalaya.com/xiaoya/login?fromUri=");
            stringBuilder3.append(stringBuilder);
            stringBuilder = stringBuilder3.toString();
            if (c.a(this.g)) {
                com.ximalaya.ting.android.opensdk.auth.component.c cVar = new com.ximalaya.ting.android.opensdk.auth.component.c(this.g);
                cVar.a(this.h);
                cVar.a(iXmlyAuthListener);
                cVar.a(stringBuilder);
                cVar.b("手机号注册");
                Bundle d = cVar.d();
                Intent intent = new Intent(this.g, XmlyBrowserComponent.class);
                intent.putExtras(d);
                this.g.startActivity(intent);
            } else {
                g.a(this.g, "Error", "Application requires permission to access the Internet");
            }
        }
    }
}
