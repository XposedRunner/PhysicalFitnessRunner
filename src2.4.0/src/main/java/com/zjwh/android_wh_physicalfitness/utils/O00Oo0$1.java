package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: Utils */
class O00Oo0$1 implements OnClickListener {
    final /* synthetic */ Context O000000o;

    O00Oo0$1(Context context) {
        this.O000000o = context;
    }

    public void onClick(View view) {
        try {
            Intent intent = new Intent("android.settings.SETTINGS");
            if (this.O000000o.getPackageManager().resolveActivity(intent, 65536) != null) {
                ((Activity) this.O000000o).startActivityForResult(intent, 0);
            } else {
                O00Oo00.O000000o("启动错误，请重试");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
