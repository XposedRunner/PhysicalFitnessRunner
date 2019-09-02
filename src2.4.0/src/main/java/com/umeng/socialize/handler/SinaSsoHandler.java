package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.umeng.socialize.PlatformConfig$APPIDPlatform;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.O0000OOo;
import com.umeng.socialize.media.WBShareCallBackActivity;
import com.umeng.socialize.utils.O00000Oo;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O000000o;
import com.umeng.socialize.utils.O0000o00.O00oOooO;
import defpackage.by;
import defpackage.cb;
import defpackage.cc;
import defpackage.ch;
import defpackage.ci;
import defpackage.cm;
import defpackage.cn;
import defpackage.cr;
import defpackage.cu;
import java.util.Map;

public class SinaSsoHandler extends UMSSOHandler {
    private static final int O000O0o = 5659;
    private static final String O000O0o0 = "SinaSsoHandler";
    private static final String O000OOo = "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write";
    private static final String O000Oo0 = "userName";
    private static final String O000Oo00 = "https://api.weibo.com/2/users/show.json";
    protected String O000000o = "6.9.4";
    private PlatformConfig$APPIDPlatform O000O0oO = null;
    private SinaPreferences O000O0oo;
    private Context O000OO;
    private UMShareListener O000OO00;
    private AuthListener O000OO0o;
    private SsoHandler O000OOOo;
    private AuthInfo O000OOo0;
    private WbShareHandler O000OOoO;
    private WeiboMultiMessage O000OOoo;

    class AuthListener implements WbAuthListener {
        private UMAuthListener O00000Oo = null;

        AuthListener(UMAuthListener uMAuthListener) {
            this.O00000Oo = uMAuthListener;
        }

        public void cancel() {
            if (this.O00000Oo != null) {
                this.O00000Oo.onCancel(by.SINA, 0);
            }
        }

        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            if (this.O00000Oo != null) {
                UMAuthListener uMAuthListener = this.O00000Oo;
                by byVar = by.SINA;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.AuthorizeFailed.O000000o());
                stringBuilder.append(wbConnectErrorMessage.getErrorMessage());
                uMAuthListener.onError(byVar, 0, new Throwable(stringBuilder.toString()));
            }
        }

        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            Bundle O000000o = SinaSsoHandler.this.O000000o(oauth2AccessToken);
            SinaSsoHandler.this.O000000o(O000000o);
            if (this.O00000Oo != null) {
                O000000o.putString("aid", SinaSsoHandler.this.O000O0oO.appId);
                O000000o.putString(cu.O0000oOo, SinaSsoHandler.this.O000O0oO.appkey);
                O000000o.putString(cu.O000OO0o, O000000o.getString(SinaSsoHandler.O000Oo0));
                O000000o.putString("accessToken", O000000o.getString("access_token"));
                O000000o.putString("refreshToken", O000000o.getString("refresh_token"));
                O000000o.putString("expiration", O000000o.getString("expires_in"));
                this.O00000Oo.onComplete(by.SINA, 0, O0000Oo0.O000000o(O000000o));
            }
        }
    }

    private Bundle O000000o(Oauth2AccessToken oauth2AccessToken) {
        Bundle bundle = new Bundle();
        bundle.putString(O000Oo0, oauth2AccessToken.getUid());
        bundle.putString("uid", oauth2AccessToken.getUid());
        bundle.putString("access_token", oauth2AccessToken.getToken());
        bundle.putString("refresh_token", oauth2AccessToken.getRefreshToken());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(oauth2AccessToken.getExpiresTime());
        stringBuilder.append("");
        bundle.putString("expires_in", stringBuilder.toString());
        return bundle;
    }

    private void O000000o(Bundle bundle) {
        if (this.O000O0oo != null) {
            this.O000O0oo.O000000o(bundle).O0000OOo();
        }
    }

    private void O00000oO(final UMAuthListener uMAuthListener) {
        cn cnVar = (cn) new cr().O000000o(new cm(O0000oO0(), O0000oO(), this.O000O0oO.appId));
        if (cnVar != null) {
            final Map map = cnVar.O000000o;
            if (map != null && !map.containsKey("error")) {
                map.put("iconurl", map.get("profile_image_url"));
                map.put(cu.O000OO0o, map.get("screen_name"));
                map.put("gender", O000000o(map.get("gender")));
                if (this.O000O0oo != null) {
                    map.put("uid", this.O000O0oo.O00000oO());
                    map.put("access_token", this.O000O0oo.O000000o());
                    map.put("refreshToken", this.O000O0oo.O00000o0());
                    map.put("expires_in", String.valueOf(this.O000O0oo.O00000Oo()));
                    map.put("accessToken", this.O000O0oo.O000000o());
                    map.put("refreshToken", this.O000O0oo.O00000o0());
                    map.put("expiration", String.valueOf(this.O000O0oo.O00000Oo()));
                    cc.O000000o(new Runnable() {
                        public void run() {
                            uMAuthListener.onComplete(by.SINA, 2, map);
                        }
                    });
                }
            } else if (map != null) {
                if (this.O000O0oo != null) {
                    this.O000O0oo.O0000Oo0();
                }
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMAuthListener uMAuthListener = uMAuthListener;
                        by byVar = by.SINA;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.RequestForUserProfileFailed);
                        stringBuilder.append(((String) map.get("error")).toString());
                        uMAuthListener.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                    }
                });
            } else {
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMAuthListener uMAuthListener = uMAuthListener;
                        by byVar = by.SINA;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.RequestForUserProfileFailed);
                        stringBuilder.append(O000000o.O00000oo);
                        uMAuthListener.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                    }
                });
            }
            return;
        }
        cc.O000000o(new Runnable() {
            public void run() {
                UMAuthListener uMAuthListener = uMAuthListener;
                by byVar = by.SINA;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.RequestForUserProfileFailed);
                stringBuilder.append(O00oOooO.O00000oo);
                uMAuthListener.onError(byVar, 2, new Throwable(stringBuilder.toString()));
            }
        });
    }

    private void O0000O0o(final UMAuthListener uMAuthListener) {
        O00000Oo(new UMAuthListener() {
            public void onCancel(by byVar, int i) {
                uMAuthListener.onCancel(byVar, i);
            }

            public void onComplete(by byVar, int i, Map<String, String> map) {
                cc.O000000o(new Runnable() {
                    public void run() {
                        SinaSsoHandler.this.O00000oO(uMAuthListener);
                    }
                }, false);
            }

            public void onError(by byVar, int i, Throwable th) {
                uMAuthListener.onError(byVar, i, th);
            }

            public void onStart(by byVar) {
            }
        });
    }

    private boolean O0000o() {
        WbAppInfo wbAppInfo = WeiboAppManager.getInstance((Context) this.O000O0Oo.get()).getWbAppInfo();
        return wbAppInfo != null && wbAppInfo.isLegal();
    }

    private String O0000oO() {
        return this.O000O0oo != null ? this.O000O0oo.O000000o() != null ? this.O000O0oo.O000000o() : "" : "";
    }

    private String O0000oO0() {
        return this.O000O0oo != null ? this.O000O0oo.O00000oO() : "";
    }

    private String O0000oOO() {
        return this.O000O0oo != null ? this.O000O0oo.O00000o0() : "";
    }

    private long O0000oOo() {
        return this.O000O0oo != null ? this.O000O0oo.O00000Oo() : 0;
    }

    public void O000000o(int i, int i2, Intent intent) {
        if (this.O000OOOo != null) {
            this.O000OOOo.authorizeCallBack(i, i2, intent);
        }
        this.O000OOOo = null;
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
        this.O000OO = context.getApplicationContext();
        PlatformConfig$APPIDPlatform platformConfig$APPIDPlatform = (PlatformConfig$APPIDPlatform) platformConfig$Platform;
        this.O000O0oO = platformConfig$APPIDPlatform;
        this.O000O0oo = new SinaPreferences(this.O000OO, "sina");
        this.O000OOo0 = new AuthInfo(context, platformConfig$APPIDPlatform.appId, ((PlatformConfig$APPIDPlatform) O0000o0()).redirectUrl, O000OOo);
        if (context instanceof Activity) {
            WbSdk.install(context, this.O000OOo0);
            Activity activity = (Activity) context;
            this.O000OOOo = new SsoHandler(activity);
            this.O000OOoO = new WbShareHandler(activity);
            this.O000OOoO.registerApp();
        }
    }

    public void O000000o(final UMAuthListener uMAuthListener) {
        ch chVar = new ch(this.O000O0oO.appId, O0000oO());
        if (this.O000O0oo != null) {
            this.O000O0oo.O0000Oo0();
        }
        ci ciVar = (ci) new cr().O000000o(chVar);
        AccessTokenKeeper.clear(O00000Oo.O000000o());
        if (this.O000O0oo != null) {
            this.O000O0oo.O0000Oo0();
        }
        cc.O000000o(new Runnable() {
            public void run() {
                uMAuthListener.onComplete(SinaSsoHandler.this.O0000o0().getName(), 1, null);
            }
        });
    }

    public boolean O000000o() {
        return true;
    }

    public boolean O000000o(ShareContent shareContent, UMShareListener uMShareListener) {
        O0000OOo o0000OOo = new O0000OOo(shareContent);
        if (this.O00oOoOo != null) {
            o0000OOo.O000000o(this.O00oOoOo.getCompressListener());
        }
        o0000OOo.O000000o(WbSdk.supportMultiImage((Context) this.O000O0Oo.get()));
        this.O000OOoo = o0000OOo.O000000o();
        this.O000OO00 = uMShareListener;
        if (!(this.O000O0Oo.get() == null || ((Activity) this.O000O0Oo.get()).isFinishing())) {
            ((Activity) this.O000O0Oo.get()).startActivity(new Intent((Context) this.O000O0Oo.get(), WBShareCallBackActivity.class));
        }
        return true;
    }

    public int O00000Oo() {
        return 5659;
    }

    public void O00000Oo(UMAuthListener uMAuthListener) {
        this.O000OO0o = new AuthListener(uMAuthListener);
        if (this.O000OOOo == null) {
            return;
        }
        if (O0000o0O().isSinaAuthWithWebView()) {
            this.O000OOOo.authorizeWeb(this.O000OO0o);
        } else {
            this.O000OOOo.authorize(this.O000OO0o);
        }
    }

    public WbShareHandler O00000o() {
        return this.O000OOoO;
    }

    public String O00000o0() {
        return this.O000000o;
    }

    public void O00000o0(UMAuthListener uMAuthListener) {
        if (O0000o0O().isNeedAuthOnGetUserInfo() || !this.O000O0oo.O0000O0o()) {
            O0000O0o(uMAuthListener);
        } else {
            O00000oO(uMAuthListener);
        }
    }

    public WeiboMultiMessage O00000oO() {
        return this.O000OOoo;
    }

    public boolean O00000oo() {
        return O0000o();
    }

    public boolean O0000O0o() {
        return this.O000O0oo != null ? this.O000O0oo.O00000oo() : false;
    }

    public boolean O0000OOo() {
        return true;
    }

    public void O0000Oo() {
        if (this.O000OO00 != null) {
            this.O000OO00.onResult(by.SINA);
        }
    }

    public String O0000Oo0() {
        return "3.1.4";
    }

    public void O0000OoO() {
        if (this.O000OO00 != null) {
            this.O000OO00.onError(by.SINA, new Throwable(cb.ShareFailed.O000000o()));
        }
    }

    public void O0000Ooo() {
        super.O0000Ooo();
        this.O000OOOo = null;
        this.O000OOoO = null;
    }

    public void onCancel() {
        if (this.O000OO00 != null) {
            this.O000OO00.onCancel(by.SINA);
        }
    }
}
