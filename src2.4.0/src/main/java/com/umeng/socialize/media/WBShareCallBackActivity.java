package com.umeng.socialize.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.handler.SinaSsoHandler;
import com.umeng.socialize.utils.O0000O0o;
import defpackage.by;

public class WBShareCallBackActivity extends Activity implements WbShareCallback {
    protected SinaSsoHandler O000000o = null;
    private final String O00000Oo = WBShareCallBackActivity.class.getSimpleName();

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O0000O0o.O00000Oo("WBShareCallBackActivity onCreate");
        this.O000000o = (SinaSsoHandler) UMShareAPI.get(getApplicationContext()).getHandler(by.SINA);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WBShareCallBackActivity sinaSsoHandler：");
        stringBuilder.append(this.O000000o);
        O0000O0o.O00000Oo(stringBuilder.toString());
        this.O000000o.O000000o((Context) this, PlatformConfig.getPlatform(by.SINA));
        WeiboMultiMessage O00000oO = this.O000000o.O00000oO();
        if (O00000oO == null || this.O000000o == null || this.O000000o.O00000o() == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("message = ");
            stringBuilder2.append(O00000oO);
            stringBuilder2.append("  sinaSsoHandler=");
            stringBuilder2.append(this.O000000o);
            stringBuilder2.append(" sinaSsoHandler.getWbHandler()=");
            stringBuilder2.append(this.O000000o.O00000o());
            O0000O0o.O000000o(stringBuilder2.toString());
            return;
        }
        this.O000000o.O00000o().shareMessage(O00000oO, false);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        O0000O0o.O00000Oo("WBShareCallBackActivity onNewIntent");
        this.O000000o = (SinaSsoHandler) UMShareAPI.get(getApplicationContext()).getHandler(by.SINA);
        if (this.O000000o == null) {
            finish();
            return;
        }
        this.O000000o.O000000o((Context) this, PlatformConfig.getPlatform(by.SINA));
        if (this.O000000o.O00000o() != null) {
            O0000O0o.O00000Oo("WBShareCallBackActivity 分发回调");
            this.O000000o.O00000o().doResultIntent(intent, this);
        }
        this.O000000o.O0000Ooo();
        finish();
    }

    public void onWbShareCancel() {
        if (this.O000000o != null) {
            this.O000000o.onCancel();
        }
    }

    public void onWbShareFail() {
        if (this.O000000o != null) {
            this.O000000o.O0000OoO();
        }
    }

    public void onWbShareSuccess() {
        if (this.O000000o != null) {
            this.O000000o.O0000Oo();
        }
    }
}
