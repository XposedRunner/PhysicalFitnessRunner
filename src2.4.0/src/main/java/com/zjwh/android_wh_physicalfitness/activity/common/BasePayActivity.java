package com.zjwh.android_wh_physicalfitness.activity.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.WeChatPayInfoEntity;
import com.zjwh.android_wh_physicalfitness.wxapi.WXPayEntryActivity;
import s.h.e.l.l.C;

public class BasePayActivity extends BaseShareActivity {
    private static final String O000000o = "BasePayActivity";
    public static final int O0000Oo = 3;
    public static final int O0000o = 0;
    public static final int O0000oO = -1;
    public static final int O0000oO0 = -2;
    private O00000Oo O00000Oo = null;
    private O000000o O00000o = null;
    private IWXAPI O00000o0 = null;
    Handler O0000oOO = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 0) {
                BasePayActivity.this.O000000o(3, 0);
            } else if (message.what == -2) {
                BasePayActivity.this.O000000o(3, -2);
            } else {
                BasePayActivity.this.O000000o(3, -1);
            }
        }
    };

    public interface O000000o {
        void O000000o(int i, int i2);
    }

    class O00000Oo extends BroadcastReceiver {
        O00000Oo() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(WXPayEntryActivity.O000000o)) {
                final int i = intent.getExtras().getInt("errCode");
                final String string = intent.getExtras().getString("errMessage");
                new Thread() {
                    public void run() {
                        Message message = new Message();
                        message.what = i;
                        message.obj = string;
                        BasePayActivity.this.O0000oOO.sendMessage(message);
                    }
                }.start();
            }
        }
    }

    static {
        C.i(16777295);
    }

    private void O000000o(int i, int i2) {
        if (this.O00000o != null) {
            this.O00000o.O000000o(i, i2);
        }
    }

    private void O00000o() {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WXPayEntryActivity.O000000o);
        if (this.O00000Oo == null) {
            this.O00000Oo = new O00000Oo();
        }
        instance.registerReceiver(this.O00000Oo, intentFilter);
    }

    private void O00000oO() {
        if (this.O00000Oo != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.O00000Oo);
            this.O00000Oo = null;
        }
    }

    private void O00000oo() {
        this.O00000o0 = WXAPIFactory.createWXAPI(this, getString(R.string.wechat_app_id));
    }

    public void O000000o(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public native void O000000o(WeChatPayInfoEntity weChatPayInfoEntity);

    public native boolean O0000OOo();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
