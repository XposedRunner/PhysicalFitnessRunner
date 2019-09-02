package com.zjwh.android_wh_physicalfitness.utils;

import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;

/* compiled from: Utils */
class O00Oo0$2 implements OnLoadCompleteListener {
    O00Oo0$2() {
    }

    public void onLoadComplete(SoundPool soundPool, int i, int i2) {
        try {
            soundPool.play(i, 1.0f, 1.0f, 0, 0, 1.0f);
        } catch (Exception e) {
            e.printStackTrace();
            MyApplication O000000o = MyApplication.O000000o();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("跑步音频播放crash --> ");
            stringBuilder.append(O000o000.O000000o(e));
            x.O00000Oo(O000000o, stringBuilder.toString());
        }
    }
}
