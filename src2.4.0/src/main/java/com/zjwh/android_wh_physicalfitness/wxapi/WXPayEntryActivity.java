package com.zjwh.android_wh_physicalfitness.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import s.h.e.l.l.C;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    public static final String O000000o = "com.huika.o2o.wxpaydonereceiver";
    private IWXAPI O00000Oo;

    static {
        C.i(16777380);
    }

    public native void onCreate(Bundle bundle);

    public native void onNewIntent(Intent intent);

    public native void onReq(BaseReq baseReq);

    public native void onResp(BaseResp baseResp);
}
