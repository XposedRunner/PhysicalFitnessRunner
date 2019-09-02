package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.commonsdk.proguard.e;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig$APPIDPlatform;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.O000O00o;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o0;
import com.umeng.socialize.utils.O0000o00;
import com.umeng.socialize.utils.O0000o00.O000000o;
import com.umeng.socialize.utils.O0000o00.O000O0OO;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.zjwh.android_wh_physicalfitness.activity.common.BasePayActivity;
import defpackage.bv;
import defpackage.by;
import defpackage.ca;
import defpackage.cb;
import defpackage.cc;
import defpackage.ce;
import defpackage.cu;
import defpackage.db;
import defpackage.dl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UMWXHandler extends UMSSOHandler {
    private static final String O000000o = "UMWXHandler";
    private static final int O000O0o = 1;
    private static final int O000O0o0 = 604800;
    private static final int O000O0oO = 2;
    private static String O000OO00 = "snsapi_userinfo,snsapi_friend,snsapi_message";
    private static final String O000OOoo = "refresh_token_expires";
    private static final String O000Oo0 = "language";
    private static final String O000Oo00 = "nickname";
    private static final String O000Oo0O = "headimgurl";
    private static final String O000Oo0o = "sex";
    private static final String O000OoO = "errmsg";
    private static final String O000OoO0 = "privilege";
    private static final String O000OoOO = "40001";
    private static final String O000OoOo = "40030";
    private static final String O000Ooo0 = "42002";
    private static final String O00O0Oo = "errcode";
    private String O000O0oo = "6.9.4";
    private WeixinPreferences O000OO;
    private PlatformConfig$APPIDPlatform O000OO0o;
    private UMAuthListener O000OOOo;
    private by O000OOo = by.WEIXIN;
    private UMShareListener O000OOo0;
    private IWXAPI O000OOoO;
    private IWXAPIEventHandler O000Ooo = new IWXAPIEventHandler() {
        public void onReq(BaseReq baseReq) {
        }

        public void onResp(BaseResp baseResp) {
            switch (baseResp.getType()) {
                case 1:
                    UMWXHandler.this.O000000o((Resp) baseResp);
                    return;
                case 2:
                    UMWXHandler.this.O000000o((SendMessageToWX.Resp) baseResp);
                    return;
                default:
                    return;
            }
        }
    };

    private void O000000o(Bundle bundle) {
        if (this.O000OO != null) {
            this.O000OO.O000000o(bundle).O0000OoO();
        }
    }

    private void O000000o(Resp resp) {
        if (resp.errCode == 0) {
            O000000o(resp.code, this.O000OOOo);
        } else if (resp.errCode == -2) {
            O00000oo(this.O000OOOo).onCancel(by.WEIXIN, 0);
        } else if (resp.errCode == -6) {
            UMAuthListener O00000oo = O00000oo(this.O000OOOo);
            by byVar = by.WEIXIN;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cb.AuthorizeFailed.O000000o());
            stringBuilder.append(O0000o00.O000000o(O000000o.O00000o, O0000o0.O0000oOO));
            O00000oo.onError(byVar, 0, new Throwable(stringBuilder.toString()));
        } else {
            CharSequence concat = TextUtils.concat(new CharSequence[]{"weixin auth error (", String.valueOf(resp.errCode), "):", resp.errStr});
            UMAuthListener O00000oo2 = O00000oo(this.O000OOOo);
            by byVar2 = by.WEIXIN;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(cb.AuthorizeFailed.O000000o());
            stringBuilder2.append(concat);
            O00000oo2.onError(byVar2, 0, new Throwable(stringBuilder2.toString()));
        }
    }

    private void O000000o(Runnable runnable) {
        cc.O000000o(runnable);
    }

    private void O000000o(String str) {
        O000000o(O00000Oo(dl.O000000o(str)));
    }

    private void O000000o(String str, final UMAuthListener uMAuthListener) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
        stringBuilder.append("appid=");
        stringBuilder.append(this.O000OO0o.appId);
        stringBuilder.append("&secret=");
        stringBuilder.append(this.O000OO0o.appkey);
        stringBuilder.append("&code=");
        stringBuilder.append(str);
        stringBuilder.append("&grant_type=authorization_code");
        cc.O000000o(new Runnable() {
            public void run() {
                String O000000o = dl.O000000o(stringBuilder.toString());
                try {
                    final Map O00000o = O0000Oo0.O00000o(O000000o);
                    if (O00000o == null || O00000o.size() == 0) {
                        UMWXHandler.this.O0000ooO();
                    }
                    UMWXHandler.this.O000000o(UMWXHandler.this.O00000Oo(O000000o));
                    cc.O000000o(new Runnable() {
                        public void run() {
                            if (O00000o.get(UMWXHandler.O00O0Oo) != null) {
                                UMAuthListener O00000oo = UMWXHandler.this.O00000oo(uMAuthListener);
                                by byVar = by.WEIXIN;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(cb.AuthorizeFailed.O000000o());
                                stringBuilder.append((String) O00000o.get(UMWXHandler.O000OoO));
                                O00000oo.onError(byVar, 0, new Throwable(stringBuilder.toString()));
                            } else {
                                UMWXHandler.this.O00000oo(uMAuthListener).onComplete(by.WEIXIN, 0, O00000o);
                            }
                            O00000o.put("aid", UMWXHandler.this.O000OO0o.appId);
                            O00000o.put(cu.O0000oOo, UMWXHandler.this.O000OO0o.appkey);
                            O00000o.put("uid", O00000o.get(db.O000OOoO));
                            O00000o.put(cu.O0000oO, O00000o.get(cu.O0000oO));
                        }
                    });
                } catch (Exception e) {
                    O0000O0o.O000000o(e);
                }
            }
        }, true);
    }

    private boolean O000000o(O000O00o o000O00o) {
        Req req = new Req();
        req.transaction = O00000oO(o000O00o.O0000Oo0());
        req.message = o000O00o.O000000o();
        switch (this.O000OOo) {
            case WEIXIN:
                req.scene = 0;
                break;
            case WEIXIN_CIRCLE:
                req.scene = 1;
                break;
            case WEIXIN_FAVORITE:
                req.scene = 2;
                break;
            default:
                req.scene = 2;
                break;
        }
        if (req.message == null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMShareListener O000000o = UMWXHandler.this.O000000o(UMWXHandler.this.O000OOo0);
                    by O000000o2 = UMWXHandler.this.O000OOo;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.UnKnowCode.O000000o());
                    stringBuilder.append("message = null");
                    O000000o.onError(O000000o2, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else if (req.message.mediaObject == null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMShareListener O000000o = UMWXHandler.this.O000000o(UMWXHandler.this.O000OOo0);
                    by O000000o2 = UMWXHandler.this.O000OOo;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.UnKnowCode.O000000o());
                    stringBuilder.append("mediaobject = null");
                    O000000o.onError(O000000o2, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else {
            boolean sendReq = this.O000OOoO.sendReq(req);
            if (!sendReq) {
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMShareListener O000000o = UMWXHandler.this.O000000o(UMWXHandler.this.O000OOo0);
                        by O000000o2 = UMWXHandler.this.O000OOo;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.UnKnowCode.O000000o());
                        stringBuilder.append(O0000o00.O0000o0.O00oOooO);
                        O000000o.onError(O000000o2, new Throwable(stringBuilder.toString()));
                    }
                });
            }
            return sendReq;
        }
    }

    private Bundle O00000Oo(String str) {
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            return bundle;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                bundle.putString(str2, jSONObject.optString(str2));
            }
            bundle.putLong(O000OOoo, 604800);
            bundle.putString("accessToken", bundle.getString("access_token"));
            bundle.putString("expiration", bundle.getString("expires_in"));
            bundle.putString("refreshToken", bundle.getString("refresh_token"));
            bundle.putString("uid", bundle.getString(cu.O0000oO));
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return bundle;
    }

    private boolean O00000Oo(by byVar, O000O00o o000O00o) {
        return (o000O00o.O0000Oo() == 64 && (byVar == by.WEIXIN_CIRCLE || byVar == by.WEIXIN_FAVORITE)) ? false : true;
    }

    private Map<String, String> O00000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(O00O0Oo)) {
                hashMap.put(O00O0Oo, jSONObject.getString(O00O0Oo));
                hashMap.put(O000OoO, jSONObject.getString(O000OoO));
                return hashMap;
            }
            hashMap.put(db.O000OOoO, jSONObject.optString(db.O000OOoO));
            hashMap.put("screen_name", jSONObject.optString(O000Oo00));
            hashMap.put(cu.O000OO0o, jSONObject.optString(O000Oo00));
            hashMap.put("language", jSONObject.optString("language"));
            hashMap.put("city", jSONObject.optString("city"));
            hashMap.put(DTransferConstants.PROVINCE, jSONObject.optString(DTransferConstants.PROVINCE));
            hashMap.put(e.N, jSONObject.optString(e.N));
            hashMap.put("profile_image_url", jSONObject.optString(O000Oo0O));
            hashMap.put("iconurl", jSONObject.optString(O000Oo0O));
            hashMap.put(cu.O0000oO, jSONObject.optString(cu.O0000oO));
            hashMap.put("uid", jSONObject.optString(cu.O0000oO));
            hashMap.put("gender", O000000o(jSONObject.optString("sex")));
            JSONArray optJSONArray = jSONObject.optJSONArray(O000OoO0);
            int i = 0;
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                String[] strArr = new String[length];
                while (i < length) {
                    strArr[i] = optJSONArray.get(i).toString();
                    i++;
                }
                hashMap.put(O000OoO0, strArr.toString());
            }
            hashMap.put("access_token", O0000oo0());
            hashMap.put("refreshToken", O0000oO());
            hashMap.put("expires_in", String.valueOf(O0000oo()));
            hashMap.put("accessToken", O0000oo0());
            hashMap.put("refreshToken", O0000oO());
            hashMap.put("expiration", String.valueOf(O0000oo()));
            return hashMap;
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
            return Collections.emptyMap();
        }
    }

    private Map<String, String> O00000o0(String str) {
        Map<String, String> O00000o;
        Throwable e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.weixin.qq.com/sns/oauth2/refresh_token?");
        stringBuilder.append("appid=");
        stringBuilder.append(this.O000OO0o.appId);
        stringBuilder.append("&grant_type=refresh_token");
        stringBuilder.append("&refresh_token=");
        stringBuilder.append(str);
        try {
            O00000o = O0000Oo0.O00000o(dl.O000000o(stringBuilder.toString()));
            try {
                O00000o.put(cu.O0000oO, O0000oOo());
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            O00000o = null;
            O0000O0o.O000000o(e);
            return O00000o;
        }
        return O00000o;
    }

    private String O00000oO(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(System.currentTimeMillis());
        return stringBuilder.toString();
    }

    private void O00000oO(final UMAuthListener uMAuthListener) {
        String O0000oOO = O0000oOO();
        String O0000oo0 = O0000oo0();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
        stringBuilder.append(O0000oo0);
        stringBuilder.append("&openid=");
        stringBuilder.append(O0000oOO);
        stringBuilder.append("&lang=zh_CN");
        O0000oOO = dl.O000000o(stringBuilder.toString());
        if (TextUtils.isEmpty(O0000oOO) || O0000oOO.startsWith("##")) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMAuthListener O00000oo = UMWXHandler.this.O00000oo(uMAuthListener);
                    by byVar = by.WEIXIN;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                    stringBuilder.append(O0000oOO);
                    O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                }
            });
            return;
        }
        final Map O00000o = O00000o(O0000oOO);
        if (O00000o == null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMAuthListener O00000oo = UMWXHandler.this.O00000oo(uMAuthListener);
                    by byVar = by.WEIXIN;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                    stringBuilder.append(O0000oOO);
                    O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                }
            });
        } else if (!O00000o.containsKey(O00O0Oo)) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMWXHandler.this.O00000oo(uMAuthListener).onComplete(by.WEIXIN, 2, O00000o);
                }
            });
        } else if (((String) O00000o.get(O00O0Oo)).equals(O000OoOO)) {
            O0000oO0();
            O00000Oo(uMAuthListener);
        } else {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMAuthListener O00000oo = UMWXHandler.this.O00000oo(uMAuthListener);
                    by byVar = by.WEIXIN;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                    stringBuilder.append((String) O00000o.get(UMWXHandler.O00O0Oo));
                    O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                }
            });
        }
    }

    private boolean O0000OoO() {
        return this.O000OO != null ? this.O000OO.O0000OOo() : false;
    }

    private boolean O0000o() {
        return this.O000OO != null ? this.O000OO.O00000oO() : false;
    }

    private String O0000oO() {
        return this.O000OO != null ? this.O000OO.O00000o0() : "";
    }

    private void O0000oO0() {
        if (this.O000OO != null) {
            this.O000OO.O0000Oo();
        }
    }

    private String O0000oOO() {
        return this.O000OO != null ? this.O000OO.O00000Oo() : "";
    }

    private String O0000oOo() {
        return this.O000OO != null ? this.O000OO.O000000o() : "";
    }

    private long O0000oo() {
        return this.O000OO != null ? this.O000OO.O0000O0o() : 0;
    }

    private String O0000oo0() {
        return this.O000OO != null ? this.O000OO.O00000oo() : "";
    }

    private Map<String, String> O0000ooO() {
        return this.O000OO != null ? this.O000OO.O00000o() : null;
    }

    public String O000000o(Object obj) {
        String str = ca.O00000Oo;
        String str2 = ca.O000000o;
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (obj.equals("m") || obj.equals(ClientOSType.IOS) || obj.equals(O0000o00.O00000o0)) ? str : (obj.equals("f") || obj.equals(ClientOSType.ANDROID) || obj.equals(O0000o00.O00000o)) ? str2 : obj.toString();
        } else {
            if (!(obj instanceof Integer)) {
                return obj.toString();
            }
            Integer num = (Integer) obj;
            return num.intValue() == 1 ? str : num.intValue() == 2 ? str2 : obj.toString();
        }
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
        this.O000OO = new WeixinPreferences(context.getApplicationContext(), "weixin");
        this.O000OO0o = (PlatformConfig$APPIDPlatform) platformConfig$Platform;
        this.O000OOoO = WXAPIFactory.createWXAPI(context.getApplicationContext(), this.O000OO0o.appId, O0000o0O().getOpenWXAnalytics());
        this.O000OOoO.registerApp(this.O000OO0o.appId);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(SendMessageToWX.Resp resp) {
        UMShareListener O000000o;
        by byVar;
        StringBuilder stringBuilder;
        UMShareListener O000000o2;
        by byVar2;
        StringBuilder stringBuilder2;
        switch (resp.errCode) {
            case -6:
                O000000o = O000000o(this.O000OOo0);
                byVar = this.O000OOo;
                stringBuilder = new StringBuilder();
                stringBuilder.append(cb.ShareFailed.O000000o());
                stringBuilder.append(O0000o00.O000000o(O000000o.O00000o, O0000o0.O0000oOO));
                O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
                return;
            case -5:
                O000000o = O000000o(this.O000OOo0);
                byVar = this.O000OOo;
                stringBuilder = new StringBuilder();
                stringBuilder.append(cb.ShareFailed.O000000o());
                stringBuilder.append(O0000o00.O0000o0.O0000ooo);
                O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
                return;
            case -3:
            case -1:
                O000000o2 = O000000o(this.O000OOo0);
                byVar2 = this.O000OOo;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(cb.ShareFailed.O000000o());
                stringBuilder2.append(resp.errStr);
                O000000o2.onError(byVar2, new Throwable(stringBuilder2.toString()));
                return;
            case BasePayActivity.O0000oO0 /*-2*/:
                O000000o(this.O000OOo0).onCancel(this.O000OOo);
                return;
            case 0:
                new HashMap().put("uid", resp.openId);
                O000000o(this.O000OOo0).onResult(this.O000OOo);
                return;
            default:
                O000000o2 = O000000o(this.O000OOo0);
                byVar2 = this.O000OOo;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(cb.ShareFailed.O000000o());
                stringBuilder2.append("code:");
                stringBuilder2.append(resp.errCode);
                stringBuilder2.append("msg:");
                stringBuilder2.append(resp.errStr);
                O000000o2.onError(byVar2, new Throwable(stringBuilder2.toString()));
                return;
        }
    }

    public void O000000o(final UMAuthListener uMAuthListener) {
        O0000oO0();
        cc.O000000o(new Runnable() {
            public void run() {
                UMWXHandler.this.O00000oo(uMAuthListener).onComplete(by.WEIXIN, 1, null);
            }
        });
    }

    public boolean O000000o() {
        return true;
    }

    public boolean O000000o(by byVar, O000O00o o000O00o) {
        return (o000O00o.O0000Oo() == 128 && (byVar == by.WEIXIN_CIRCLE || byVar == by.WEIXIN_FAVORITE)) ? false : true;
    }

    public boolean O000000o(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (this.O000OO0o != null) {
            this.O000OOo = this.O000OO0o.getName();
        }
        if (O00000oo()) {
            O000O00o o000O00o = new O000O00o(shareContent);
            if (this.O00oOoOo != null) {
                o000O00o.O000000o(this.O00oOoOo.getCompressListener());
            }
            if (!O00000Oo(this.O000OOo, o000O00o)) {
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMShareListener O000000o = UMWXHandler.this.O000000o(uMShareListener);
                        by O000000o2 = UMWXHandler.this.O000OOo;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.ShareDataTypeIllegal.O000000o());
                        stringBuilder.append(O000O0OO.O0000OOo);
                        O000000o.onError(O000000o2, new Throwable(stringBuilder.toString()));
                    }
                });
                return false;
            } else if (O000000o(this.O000OOo, o000O00o)) {
                this.O000OOo0 = uMShareListener;
                return O000000o(o000O00o);
            } else {
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMShareListener O000000o = UMWXHandler.this.O000000o(uMShareListener);
                        by O000000o2 = UMWXHandler.this.O000OOo;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.ShareDataTypeIllegal.O000000o());
                        stringBuilder.append(O000O0OO.O0000Oo0);
                        O000000o.onError(O000000o2, new Throwable(stringBuilder.toString()));
                    }
                });
                return false;
            }
        }
        if (Config.isJumptoAppStore) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(ce.O0000OoO));
            ((Activity) this.O000O0Oo.get()).startActivity(intent);
        }
        cc.O000000o(new Runnable() {
            public void run() {
                UMWXHandler.this.O000000o(uMShareListener).onError(UMWXHandler.this.O000OOo, new Throwable(cb.NotInstall.O000000o()));
            }
        });
        return false;
    }

    public int O00000Oo() {
        return bv.O0000o0;
    }

    public void O00000Oo(final UMAuthListener uMAuthListener) {
        if (this.O000OO0o != null) {
            this.O000OOo = this.O000OO0o.getName();
        }
        this.O000OOOo = uMAuthListener;
        if (O00000oo()) {
            if (O0000OoO()) {
                String O0000oO = O0000oO();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=");
                stringBuilder.append(this.O000OO0o.appId);
                stringBuilder.append("&grant_type=refresh_token&refresh_token=");
                stringBuilder.append(O0000oO);
                O000000o(stringBuilder.toString());
                O0000oO();
                final Map O00000o0 = O00000o0(O0000oO);
                if (O00000o0.containsKey(O00O0Oo) && (((String) O00000o0.get(O00O0Oo)).equals(O000Ooo0) || ((String) O00000o0.get(O00O0Oo)).equals(O000OoOo))) {
                    O0000oO0();
                    O00000Oo(uMAuthListener);
                    return;
                }
                O000000o(new Runnable() {
                    public void run() {
                        UMWXHandler.this.O00000oo(UMWXHandler.this.O000OOOo).onComplete(by.WEIXIN, 0, O00000o0);
                    }
                });
            } else {
                SendAuth.Req req = new SendAuth.Req();
                req.scope = O000OO00;
                req.state = "none";
                this.O000OOoO.sendReq(req);
            }
            return;
        }
        if (Config.isJumptoAppStore) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("http://log.umsns.com/link/weixin/download/"));
            ((Activity) this.O000O0Oo.get()).startActivity(intent);
        }
        O000000o(new Runnable() {
            public void run() {
                UMWXHandler.this.O00000oo(uMAuthListener).onError(UMWXHandler.this.O000OOo, 0, new Throwable(cb.NotInstall.O000000o()));
            }
        });
    }

    public void O00000o(UMAuthListener uMAuthListener) {
        super.O00000o(uMAuthListener);
        this.O000OOOo = uMAuthListener;
    }

    public String O00000o0() {
        return this.O000O0oo;
    }

    public void O00000o0(final UMAuthListener uMAuthListener) {
        if (O0000o0O().isNeedAuthOnGetUserInfo()) {
            O0000oO0();
        }
        O00000Oo(new UMAuthListener() {
            public void onCancel(by byVar, int i) {
                UMWXHandler.this.O00000oo(uMAuthListener).onCancel(byVar, i);
            }

            public void onComplete(by byVar, int i, Map<String, String> map) {
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMWXHandler.this.O00000oO(uMAuthListener);
                    }
                }, true);
            }

            public void onError(by byVar, int i, Throwable th) {
                UMWXHandler.this.O00000oo(uMAuthListener).onError(byVar, i, th);
            }

            public void onStart(by byVar) {
            }
        });
    }

    public IWXAPIEventHandler O00000oO() {
        return this.O000Ooo;
    }

    public boolean O00000oo() {
        return this.O000OOoO != null && this.O000OOoO.isWXAppInstalled();
    }

    public boolean O0000O0o() {
        return this.O000OO.O0000Oo0();
    }

    public boolean O0000OOo() {
        return this.O000OOoO.isWXAppSupportAPI();
    }

    public IWXAPI O0000Oo() {
        return this.O000OOoO;
    }

    public String O0000Oo0() {
        return "3.1.1";
    }

    public void O0000Ooo() {
        super.O0000Ooo();
        this.O000OOOo = null;
    }

    public boolean d_() {
        return this.O000OOOo != null;
    }
}
