package com.zjwh.android_wh_physicalfitness.utils;

import com.ximalaya.ting.android.opensdk.player.XmPlayerManager.IConnectListener;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;

/* compiled from: MusicManager */
class O00O00Oo$1 implements IConnectListener {
    final /* synthetic */ O00O00Oo O000000o;

    O00O00Oo$1(O00O00Oo o00O00Oo) {
        this.O000000o = o00O00Oo;
    }

    public void onConnected() {
        O00O00Oo.O000000o(this.O000000o).removeOnConnectedListerner(this);
        O00O00Oo.O000000o(this.O000000o).setBreakpointResume(false);
        O00O00Oo.O000000o(this.O000000o).setPlayMode(PlayMode.PLAY_MODEL_LIST_LOOP);
        O00O00Oo.O00000Oo(this.O000000o);
    }
}
