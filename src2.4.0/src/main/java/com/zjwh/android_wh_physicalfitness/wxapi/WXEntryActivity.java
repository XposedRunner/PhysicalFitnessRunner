package com.zjwh.android_wh_physicalfitness.wxapi;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.umeng.socialize.weixin.view.WXCallbackActivity;
import defpackage.kz;

public class WXEntryActivity extends WXCallbackActivity {
    public void onResp(BaseResp baseResp) {
        super.onResp(baseResp);
        if (baseResp.getType() == 19) {
            String str = ((Resp) baseResp).extMsg;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onResp: ");
            stringBuilder.append(str);
            kz.O000000o("TAG", stringBuilder.toString());
        }
    }
}
