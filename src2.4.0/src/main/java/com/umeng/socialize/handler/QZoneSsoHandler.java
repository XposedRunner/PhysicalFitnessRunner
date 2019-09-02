package com.umeng.socialize.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig$Platform;
import com.umeng.socialize.ShareContent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.media.O00000o0;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O0000o00;
import defpackage.bv;
import defpackage.by;
import defpackage.cb;
import defpackage.cc;
import defpackage.db;
import org.json.JSONObject;

public class QZoneSsoHandler extends UMTencentSSOHandler {
    private static final String O000OoO = "QZoneSsoHandler";
    private O00000o0 O000OoO0;
    private QQPreferences O00O0Oo;

    private void O000000o(final Bundle bundle) {
        if (bundle != null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    if (QZoneSsoHandler.this.O000O0Oo.get() != null && !((Activity) QZoneSsoHandler.this.O000O0Oo.get()).isFinishing()) {
                        QZoneSsoHandler.this.O000OO00.publishToQzone((Activity) QZoneSsoHandler.this.O000O0Oo.get(), bundle, QZoneSsoHandler.this.O00000Oo(QZoneSsoHandler.this.O000OO0o));
                    }
                }
            });
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

    private boolean O000000o(PlatformConfig$Platform platformConfig$Platform) {
        return this.O000O0Oo.get() == null || ((Activity) this.O000O0Oo.get()).isFinishing() || this.O000OO00.isSupportSSOLogin((Activity) this.O000O0Oo.get());
    }

    private IUiListener O00000Oo(final UMShareListener uMShareListener) {
        return new IUiListener() {
            public void onCancel() {
                QZoneSsoHandler.this.O000000o(uMShareListener).onCancel(by.QZONE);
            }

            public void onComplete(Object obj) {
                QZoneSsoHandler.this.O000000o(uMShareListener).onResult(by.QZONE);
            }

            public void onError(UiError uiError) {
                UMShareListener O000000o = QZoneSsoHandler.this.O000000o(uMShareListener);
                by byVar = by.QZONE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.ShareFailed.O000000o());
                stringBuilder.append(uiError.errorMessage);
                O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
            }
        };
    }

    private void O00000Oo(final Bundle bundle) {
        if (bundle != null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    if (QZoneSsoHandler.this.O000O0Oo.get() != null && !((Activity) QZoneSsoHandler.this.O000O0Oo.get()).isFinishing()) {
                        QZoneSsoHandler.this.O000OO00.shareToQzone((Activity) QZoneSsoHandler.this.O000O0Oo.get(), bundle, QZoneSsoHandler.this.O00000Oo(QZoneSsoHandler.this.O000OO0o));
                    }
                }
            });
        }
    }

    private IUiListener O00000oO(UMAuthListener uMAuthListener) {
        return new IUiListener() {
            public void onCancel() {
                QZoneSsoHandler.this.O00000oo(QZoneSsoHandler.this.O000O0oo).onCancel(by.QQ, 0);
            }

            public void onComplete(Object obj) {
                O0000Oo0.O000000o(QZoneSsoHandler.this.O000000o);
                Bundle O00000Oo = QZoneSsoHandler.this.O00000Oo(obj);
                QZoneSsoHandler.this.O00O0Oo.O000000o(O00000Oo).O00000oo();
                QZoneSsoHandler.this.O000000o((JSONObject) obj);
                if (QZoneSsoHandler.this.O000O0oo != null) {
                    QZoneSsoHandler.this.O000O0oo.onComplete(by.QQ, 0, O0000Oo0.O000000o(O00000Oo));
                }
                if (O00000Oo != null && !TextUtils.isEmpty(O00000Oo.getString("ret"))) {
                }
            }

            public void onError(UiError uiError) {
                UMAuthListener O00000oo = QZoneSsoHandler.this.O00000oo(QZoneSsoHandler.this.O000O0oo);
                by byVar = by.QQ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.AuthorizeFailed.O000000o());
                stringBuilder.append(" ==> errorCode = ");
                stringBuilder.append(uiError.errorCode);
                stringBuilder.append(", errorMsg = ");
                stringBuilder.append(uiError.errorMessage);
                stringBuilder.append(", detail = ");
                stringBuilder.append(uiError.errorDetail);
                O00000oo.onError(byVar, 0, new Throwable(stringBuilder.toString()));
            }
        };
    }

    private void O0000Oo() {
        Bundle O00000o0 = this.O000OoO0.O00000o0();
        O00000o0.putString("appName", O0000o0O().getAppName());
        if (this.O000OoO0.O00000Oo()) {
            O000000o(O00000o0);
        } else {
            O00000Oo(O00000o0);
        }
    }

    private void O0000OoO() {
        if (this.O000O0Oo.get() != null && !((Activity) this.O000O0Oo.get()).isFinishing()) {
            this.O000OO00.login((Activity) this.O000O0Oo.get(), "all", O00000oO(this.O000O0oo));
        }
    }

    public void O000000o(int i, int i2, Intent intent) {
        if (i == bv.O0000oO) {
            Tencent.onActivityResultData(i, i2, intent, O00000Oo(this.O000OO0o));
        }
        if (i == bv.O0000oOO) {
            Tencent.onActivityResultData(i, i2, intent, O00000oO(this.O000O0oo));
        }
    }

    public void O000000o(Context context, PlatformConfig$Platform platformConfig$Platform) {
        super.O000000o(context, platformConfig$Platform);
        this.O00O0Oo = new QQPreferences(context, by.QQ.toString());
    }

    public void O000000o(final UMAuthListener uMAuthListener) {
        this.O000OO00.logout(O0000o00());
        if (this.O00O0Oo != null) {
            this.O00O0Oo.O0000O0o();
        }
        cc.O000000o(new Runnable() {
            public void run() {
                QZoneSsoHandler.this.O00000oo(uMAuthListener).onComplete(by.QZONE, 1, null);
            }
        });
    }

    public boolean O000000o() {
        return true;
    }

    public boolean O000000o(ShareContent shareContent, final UMShareListener uMShareListener) {
        if (uMShareListener != null) {
            this.O000OO0o = uMShareListener;
        }
        if (this.O000OO00 == null) {
            cc.O000000o(new Runnable() {
                public void run() {
                    UMShareListener O000000o = QZoneSsoHandler.this.O000000o(uMShareListener);
                    by byVar = by.QZONE;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(cb.ShareFailed.O000000o());
                    stringBuilder.append(com.umeng.socialize.utils.O0000o00.O000000o(Config.isUmengQQ.booleanValue()));
                    O000000o.onError(byVar, new Throwable(stringBuilder.toString()));
                }
            });
            return false;
        } else if (O000000o(O0000o0())) {
            this.O000OoO0 = new O00000o0(shareContent);
            if (this.O00oOoOo != null) {
                this.O000OoO0.O000000o(this.O00oOoOo.getCompressListener());
            }
            O0000Oo();
            return false;
        } else {
            if (Config.isJumptoAppStore) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("http://log.umsns.com/link/qq/download/"));
                ((Activity) this.O000O0Oo.get()).startActivity(intent);
            }
            cc.O000000o(new Runnable() {
                public void run() {
                    QZoneSsoHandler.this.O000000o(uMShareListener).onError(by.QQ, new Throwable(cb.NotInstall.O000000o()));
                }
            });
            return false;
        }
    }

    public int O00000Oo() {
        return bv.O0000oO;
    }

    public void O00000Oo(UMAuthListener uMAuthListener) {
        if (O000000o(O0000o0())) {
            this.O000O0oo = uMAuthListener;
            O0000OoO();
        }
    }
}
