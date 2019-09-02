package com.umeng.socialize.weixin.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.handler.UMWXHandler;
import com.umeng.socialize.utils.O0000O0o;
import defpackage.by;

public abstract class WXCallbackActivity extends Activity implements IWXAPIEventHandler {
    protected UMWXHandler O000000o = null;
    private final String O00000Oo = WXCallbackActivity.class.getSimpleName();

    /* Access modifiers changed, original: protected */
    public void O000000o(Intent intent) {
        this.O000000o.O0000Oo().handleIntent(intent, this);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O0000O0o.O00000Oo("WXCallbackActivity onCreate");
        this.O000000o = (UMWXHandler) UMShareAPI.get(getApplicationContext()).getHandler(by.WEIXIN);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WXCallbackActivity mWxHandler：");
        stringBuilder.append(this.O000000o);
        O0000O0o.O00000Oo(stringBuilder.toString());
        this.O000000o.O000000o(getApplicationContext(), PlatformConfig.getPlatform(by.WEIXIN));
        O000000o(getIntent());
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        O0000O0o.O00000Oo("WXCallbackActivity onNewIntent");
        setIntent(intent);
        this.O000000o = (UMWXHandler) UMShareAPI.get(getApplicationContext()).getHandler(by.WEIXIN);
        this.O000000o.O000000o(getApplicationContext(), PlatformConfig.getPlatform(by.WEIXIN));
        O000000o(intent);
    }

    public void onReq(BaseReq baseReq) {
        if (this.O000000o != null) {
            this.O000000o.O00000oO().onReq(baseReq);
        }
        finish();
    }

    public void onResp(BaseResp baseResp) {
        O0000O0o.O00000Oo("WXCallbackActivity 分发回调");
        if (!(this.O000000o == null || baseResp == null)) {
            try {
                this.O000000o.O00000oO().onResp(baseResp);
            } catch (Exception e) {
                O0000O0o.O000000o(e);
            }
        }
        finish();
    }
}
