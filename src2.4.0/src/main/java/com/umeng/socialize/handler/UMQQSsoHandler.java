package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.O00000Oo;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O0000o00;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import defpackage.bv;
import defpackage.by;
import defpackage.cb;
import defpackage.cc;
import defpackage.ce;
import defpackage.cu;
import defpackage.db;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UMQQSsoHandler extends UMTencentSSOHandler {
    private static final String O000OoO0 = "UMQQSsoHandler";
    private QQPreferences O000OoO;
    private final String O000OoOO = "https://graph.qq.com/oauth2.0/me?access_token=";
    private final String O000OoOo = "&unionid=1";
    private IUiListener O00O0Oo;

    private Bundle O000000o(ShareContent shareContent) {
        O00000Oo o00000Oo = new O00000Oo(shareContent);
        if (this.O00oOoOo != null) {
            o00000Oo.O000000o(this.O00oOoOo.getCompressListener());
        }
        Bundle O000000o = o00000Oo.O000000o(O0000o0O().isHideQzoneOnQQFriendList(), O0000o0O().getAppName());
        O000000o.putString("appName", O0000o0O().getAppName());
        return O000000o;
    }

    private String O000000o(QQPreferences qQPreferences) {
        return qQPreferences != null ? qQPreferences.O000000o() : null;
    }

    private static String O000000o(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(readLine);
                    stringBuilder2.append("/n");
                    stringBuilder.append(stringBuilder2.toString());
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        O0000O0o.O000000o(e);
                    }
                }
            } catch (IOException e2) {
                O0000O0o.O000000o(e2);
                inputStream.close();
            } catch (Throwable e22) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    O0000O0o.O000000o(e3);
                }
                throw e22;
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    private void O000000o(final Bundle bundle) {
        if (O00000oO()) {
            cc.O000000o(new Runnable() {
                public void run() {
                    if (UMQQSsoHandler.this.O000O0Oo.get() != null && !((Activity) UMQQSsoHandler.this.O000O0Oo.get()).isFinishing()) {
                        UMQQSsoHandler.this.O000OO00.shareToQQ((Activity) UMQQSsoHandler.this.O000O0Oo.get(), bundle, UMQQSsoHandler.this.O00O0Oo);
                    }
                }
            });
        } else {
            this.O00O0Oo.onError(new UiError(-1, O0000o00.O0000Oo, O0000o00.O0000Oo));
        }
    }

    private void O000000o(final UMShareListener uMShareListener, final String str) {
        cc.O000000o(new Runnable() {
            public void run() {
                UMShareListener O000000o = UMQQSsoHandler.this.O000000o(uMShareListener);
                by byVar = by.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.ShareDataTypeIllegal.O000000o());
                stringBuilder.append(str);
                O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
            }
        });
    }

    private void O000000o(String str) {
        if (this.O000OoO != null) {
            this.O000OoO.O00000Oo(str);
        }
    }

    private void O000000o(Map<String, String> map) {
        if (map != null) {
            String O000000o = O000000o(this.O000OoO);
            String O00000o0 = O00000o0(this.O000OoO);
            String O00000o = O00000o(this.O000OoO);
            String O00000Oo = O00000Oo(this.O000OoO);
            map.put(db.O000OOoO, O00000o0);
            map.put("uid", O00000o0);
            map.put("access_token", O000000o);
            map.put("expires_in", O00000o);
            map.put("accessToken", O000000o);
            map.put("expiration", O00000o);
            map.put(cu.O0000oO, O00000Oo);
        }
    }

    private void O000000o(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("access_token");
            String string2 = jSONObject.getString("expires_in");
            String string3 = jSONObject.getString(db.O000OOoO);
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                this.O000OO00.setAccessToken(string, string2);
                this.O000OO00.setOpenId(string3);
            }
        } catch (Exception e) {
            O0000O0o.O000000o(O0000o00.O0000O0o, e);
        }
    }

    private String O00000Oo(QQPreferences qQPreferences) {
        return qQPreferences != null ? qQPreferences.O00000Oo() : null;
    }

    private void O00000Oo(final UMShareListener uMShareListener) {
        if (Config.isJumptoAppStore) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(ce.O0000Oo));
            ((Activity) this.O000O0Oo.get()).startActivity(intent);
        }
        cc.O000000o(new Runnable() {
            public void run() {
                UMQQSsoHandler.this.O000000o(uMShareListener).onError(by.QQ, new Throwable(cb.NotInstall.O000000o()));
            }
        });
    }

    private void O00000Oo(String str) {
        if (this.O000OoO != null) {
            this.O000OoO.O00000o0(str);
        }
    }

    private String O00000o(QQPreferences qQPreferences) {
        if (qQPreferences == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(QQPreferences.O00000o0());
        stringBuilder.append("");
        return stringBuilder.toString();
    }

    private Map<String, String> O00000o(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", jSONObject.optString("nickname"));
        hashMap.put(cu.O000OO0o, jSONObject.optString("nickname"));
        hashMap.put("gender", O000000o((Object) jSONObject.optString("gender")));
        hashMap.put("profile_image_url", jSONObject.optString("figureurl_qq_2"));
        hashMap.put("iconurl", jSONObject.optString("figureurl_qq_2"));
        hashMap.put("is_yellow_year_vip", jSONObject.optString("is_yellow_year_vip"));
        hashMap.put("yellow_vip_level", jSONObject.optString("yellow_vip_level"));
        hashMap.put(db.O000OO00, jSONObject.optString(db.O000OO00));
        hashMap.put("city", jSONObject.optString("city"));
        hashMap.put("vip", jSONObject.optString("vip"));
        hashMap.put("ret", jSONObject.optString("ret"));
        hashMap.put("level", jSONObject.optString("level"));
        hashMap.put(DTransferConstants.PROVINCE, jSONObject.optString(DTransferConstants.PROVINCE));
        hashMap.put("is_yellow_vip", jSONObject.optString("is_yellow_vip"));
        return hashMap;
    }

    private IUiListener O00000o0(final UMShareListener uMShareListener) {
        return new IUiListener() {
            public void onCancel() {
                UMQQSsoHandler.this.O000000o(uMShareListener).onCancel(by.QQ);
            }

            public void onComplete(Object obj) {
                UMQQSsoHandler.this.O000000o(uMShareListener).onResult(by.QQ);
            }

            public void onError(UiError uiError) {
                String str = uiError == null ? "" : uiError.errorMessage;
                UMShareListener O000000o = UMQQSsoHandler.this.O000000o(uMShareListener);
                by byVar = by.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.ShareFailed.O000000o());
                stringBuilder.append(str);
                O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
            }
        };
    }

    private String O00000o0(QQPreferences qQPreferences) {
        return qQPreferences != null ? qQPreferences.O00000o() : null;
    }

    private String O00000o0(String str) {
        String str2 = "";
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection == null) {
                return str2;
            }
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();
            return inputStream == null ? str2 : O000000o(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    private boolean O00000oO(String str) {
        return TextUtils.isEmpty(str) ^ 1;
    }

    private void O0000O0o(final UMAuthListener uMAuthListener) {
        String O000000o = O000000o(this.O000OoO);
        if (O00000oO(O000000o)) {
            try {
                String O00000o = O00000o(this.O000OoO);
                String O00000o0 = O00000o0(this.O000OoO);
                if (!(TextUtils.isEmpty(O000000o) || TextUtils.isEmpty(O00000o) || TextUtils.isEmpty(O00000o0))) {
                    this.O000OO00.setAccessToken(O000000o, O00000o);
                    this.O000OO00.setOpenId(O00000o0);
                }
                new UserInfo(O0000o00(), this.O000OO00.getQQToken()).getUserInfo(O0000OOo(uMAuthListener));
                return;
            } catch (Exception e) {
                cc.O000000o(new Runnable() {
                    public void run() {
                        UMAuthListener O00000oo = UMQQSsoHandler.this.O00000oo(uMAuthListener);
                        by byVar = by.QQ;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                        stringBuilder.append(e.getMessage());
                        O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                    }
                });
                return;
            }
        }
        cc.O000000o(new Runnable() {
            public void run() {
                UMAuthListener O00000oo = UMQQSsoHandler.this.O00000oo(uMAuthListener);
                by byVar = by.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                stringBuilder.append("token is invalid");
                O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
            }
        });
    }

    private IUiListener O0000OOo(final UMAuthListener uMAuthListener) {
        return new IUiListener() {
            public void onCancel() {
                UMQQSsoHandler.this.O00000oo(uMAuthListener).onCancel(by.QQ, 2);
            }

            public void onComplete(Object obj) {
                if (uMAuthListener != null) {
                    try {
                        Map O00000o = UMQQSsoHandler.this.O00000o(obj.toString());
                        UMQQSsoHandler.this.O000000o(O00000o);
                        if (TextUtils.isEmpty((CharSequence) O00000o.get("ret")) || !((String) O00000o.get("ret")).equals("100030")) {
                            UMQQSsoHandler.this.O00000oo(uMAuthListener).onComplete(by.QQ, 2, O00000o);
                        } else {
                            UMQQSsoHandler.this.O0000Oo();
                            UMQQSsoHandler.this.O0000Oo0(uMAuthListener);
                        }
                    } catch (JSONException unused) {
                        UMAuthListener O00000oo = UMQQSsoHandler.this.O00000oo(uMAuthListener);
                        by byVar = by.QQ;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                        stringBuilder.append("parse json error");
                        O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
                    }
                }
            }

            public void onError(UiError uiError) {
                UMAuthListener O00000oo = UMQQSsoHandler.this.O00000oo(uMAuthListener);
                by byVar = by.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.RequestForUserProfileFailed.O000000o());
                stringBuilder.append(uiError.errorMessage);
                O00000oo.onError(byVar, 2, new Throwable(stringBuilder.toString()));
            }
        };
    }

    private void O0000Oo() {
        if (this.O000OoO != null) {
            this.O000OoO.O0000O0o();
        }
    }

    private void O0000Oo0(final UMAuthListener uMAuthListener) {
        O00000Oo(new UMAuthListener() {
            public void onCancel(by byVar, int i) {
                UMQQSsoHandler.this.O00000oo(uMAuthListener).onCancel(by.QQ, 2);
            }

            public void onComplete(by byVar, int i, Map<String, String> map) {
                UMQQSsoHandler.this.O0000O0o(uMAuthListener);
            }

            public void onError(by byVar, int i, Throwable th) {
                UMQQSsoHandler.this.O00000oo(uMAuthListener).onError(by.QQ, 2, th);
            }

            public void onStart(by byVar) {
            }
        });
    }

    private void O0000OoO() {
        if (!O00000oo()) {
            this.O000OO00.loginServerSide((Activity) this.O000O0Oo.get(), "all", O00000oO(this.O000O0oo));
        } else if (this.O000O0Oo.get() != null && !((Activity) this.O000O0Oo.get()).isFinishing()) {
            this.O000OO00.login((Activity) this.O000O0Oo.get(), "all", O00000oO(this.O000O0oo));
        }
    }

    public void O000000o(int i, int i2, Intent intent) {
        if (i == bv.O0000oO0) {
            Tencent.onActivityResultData(i, i2, intent, this.O00O0Oo);
        }
        if (i == bv.O0000oOO) {
            Tencent.onActivityResultData(i, i2, intent, O00000oO(this.O000O0oo));
        }
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
        if (context != null) {
            this.O000OoO = new QQPreferences(context, by.QQ.toString());
        }
    }

    public void O000000o(final UMAuthListener uMAuthListener) {
        this.O000OO00.logout(O0000o00());
        O0000Oo();
        cc.O000000o(new Runnable() {
            public void run() {
                UMQQSsoHandler.this.O00000oo(uMAuthListener).onComplete(by.QQ, 1, null);
            }
        });
    }

    public boolean O000000o() {
        return true;
    }

    public boolean O000000o(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (this.O000OO00 == null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMShareListener O000000o = UMQQSsoHandler.this.O000000o(uMShareListener);
                    by byVar = by.QQ;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.ShareFailed.O000000o());
                    stringBuilder.append(com.umeng.socialize.utils.O0000o00.O000000o(Config.isUmengQQ.booleanValue()));
                    O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else if (O00000oo()) {
            Bundle O000000o = O000000o(shareContent);
            String string = O000000o.getString("error");
            if (TextUtils.isEmpty(string)) {
                this.O00O0Oo = O00000o0(uMShareListener);
                O000000o(O000000o);
                return false;
            }
            O000000o(uMShareListener, string);
            return false;
        } else {
            O00000Oo(uMShareListener);
            return false;
        }
    }

    public int O00000Oo() {
        return bv.O0000oO0;
    }

    public void O00000Oo(UMAuthListener uMAuthListener) {
        this.O000O0oo = uMAuthListener;
        O0000OoO();
    }

    public void O00000o(UMAuthListener uMAuthListener) {
        super.O00000o(uMAuthListener);
        this.O000O0oo = uMAuthListener;
    }

    public void O00000o0(UMAuthListener uMAuthListener) {
        if (!O0000O0o() || O0000o0O().isNeedAuthOnGetUserInfo()) {
            O0000Oo0(uMAuthListener);
        } else {
            O0000O0o(uMAuthListener);
        }
    }

    /* Access modifiers changed, original: protected */
    public IUiListener O00000oO(final UMAuthListener uMAuthListener) {
        return new IUiListener() {
            public void onCancel() {
                UMQQSsoHandler.this.O00000oo(uMAuthListener).onCancel(by.QQ, 0);
            }

            public void onComplete(final Object obj) {
                O0000Oo0.O000000o(UMQQSsoHandler.this.O000000o);
                final Bundle O00000Oo = UMQQSsoHandler.this.O00000Oo(obj);
                if (UMQQSsoHandler.this.O000OoO == null && UMQQSsoHandler.this.O0000o00() != null) {
                    UMQQSsoHandler.this.O000OoO = new QQPreferences(UMQQSsoHandler.this.O0000o00(), by.QQ.toString());
                }
                if (UMQQSsoHandler.this.O000OoO != null) {
                    UMQQSsoHandler.this.O000OoO.O000000o(O00000Oo).O00000oo();
                }
                cc.O000000o(new Runnable() {
                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("https://graph.qq.com/oauth2.0/me?access_token=");
                        stringBuilder.append(UMQQSsoHandler.this.O000000o(UMQQSsoHandler.this.O000OoO));
                        stringBuilder.append("&unionid=1");
                        String O000000o = UMQQSsoHandler.this.O00000o0(stringBuilder.toString());
                        if (!TextUtils.isEmpty(O000000o)) {
                            try {
                                JSONObject jSONObject = new JSONObject(O000000o.replace("callback", "").replace("(", "").replace(")", ""));
                                O000000o = jSONObject.optString(cu.O0000oO);
                                UMQQSsoHandler.this.O00000Oo(jSONObject.optString(db.O000OOoO));
                                UMQQSsoHandler.this.O000000o(O000000o);
                                if (UMQQSsoHandler.this.O000OoO != null) {
                                    UMQQSsoHandler.this.O000OoO.O00000oo();
                                }
                                O000000o = jSONObject.optString("error_description");
                                if (!TextUtils.isEmpty(O000000o)) {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(O0000o00.O0000OOo);
                                    stringBuilder2.append(O000000o);
                                    O0000O0o.O000000o(stringBuilder2.toString());
                                }
                            } catch (JSONException e) {
                                O0000O0o.O000000o(e);
                            }
                        }
                        UMQQSsoHandler.this.O000000o((JSONObject) obj);
                        final Map O000000o2 = O0000Oo0.O000000o(O00000Oo);
                        O000000o2.put(cu.O0000oO, UMQQSsoHandler.this.O00000Oo(UMQQSsoHandler.this.O000OoO));
                        cc.O000000o(new Runnable() {
                            public void run() {
                                UMQQSsoHandler.this.O00000oo(uMAuthListener).onComplete(by.QQ, 0, O000000o2);
                            }
                        });
                        if (UMQQSsoHandler.this.O000O0oO != null) {
                            O000000o2.put("aid", UMQQSsoHandler.this.O000O0oO.appId);
                            O000000o2.put(cu.O0000oOo, UMQQSsoHandler.this.O000O0oO.appkey);
                        }
                    }
                }, true);
            }

            public void onError(UiError uiError) {
                UMAuthListener O00000oo = UMQQSsoHandler.this.O00000oo(uMAuthListener);
                by byVar = by.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.AuthorizeFailed.O000000o());
                stringBuilder.append("==> errorCode = ");
                stringBuilder.append(uiError.errorCode);
                stringBuilder.append(", errorMsg = ");
                stringBuilder.append(uiError.errorMessage);
                stringBuilder.append(", detail = ");
                stringBuilder.append(uiError.errorDetail);
                O00000oo.onError(byVar, 0, new Throwable(stringBuilder.toString()));
            }
        };
    }

    public boolean O00000oo() {
        return this.O000OO00 != null && this.O000OO00.isSupportSSOLogin((Activity) this.O000O0Oo.get());
    }

    public boolean O0000O0o() {
        return this.O000OoO != null ? this.O000OoO.O00000oO() : false;
    }

    public boolean O0000OOo() {
        return this.O000OO00.isSupportSSOLogin((Activity) this.O000O0Oo.get());
    }

    public String O0000Oo0() {
        return "3.1.0";
    }

    public boolean d_() {
        return this.O000O0oo != null;
    }
}
