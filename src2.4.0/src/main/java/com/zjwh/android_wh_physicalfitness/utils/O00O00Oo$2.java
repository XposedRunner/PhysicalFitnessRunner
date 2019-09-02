package com.zjwh.android_wh_physicalfitness.utils;

import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerStatusListener;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerException;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicProgressEvt;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicStatusEvt;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicSwitchEvt;
import com.zjwh.android_wh_physicalfitness.entity.database.MusicHistoryBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import defpackage.gf;
import org.greenrobot.eventbus.O00000o0;
import org.xutils.ex.DbException;

/* compiled from: MusicManager */
class O00O00Oo$2 implements IXmPlayerStatusListener {
    final /* synthetic */ O00O00Oo O000000o;

    O00O00Oo$2(O00O00Oo o00O00Oo) {
        this.O000000o = o00O00Oo;
    }

    public void onBufferProgress(int i) {
    }

    public void onBufferingStart() {
    }

    public void onBufferingStop() {
    }

    public boolean onError(XmPlayerException xmPlayerException) {
        return false;
    }

    public void onPlayPause() {
        if (!(O00O00Oo.O000000o(this.O000000o) == null || O00O00Oo.O000000o(this.O000000o).getCurrSound() == null)) {
            O00OO0O.O000000o(new PvDataInfoV29(gf.O000OO00, String.valueOf(O00O00Oo.O000000o(this.O000000o).getCurrSound().getDataId())));
        }
        O00O00Oo.O000000o(this.O000000o, false);
        O00000o0.O000000o().O00000o(new MusicStatusEvt(false));
    }

    public void onPlayProgress(int i, int i2) {
        if (O00O00Oo.O00000o0(this.O000000o) && O00O00Oo.O0000Oo(this.O000000o) && O00000o0.O000000o().O00000o0(MusicProgressEvt.class)) {
            O00000o0.O000000o().O00000o(new MusicProgressEvt(i, i2));
        }
    }

    public void onPlayStart() {
        if (!(O00O00Oo.O000000o(this.O000000o) == null || O00O00Oo.O000000o(this.O000000o).getCurrSound() == null)) {
            O00OO0O.O000000o(new PvDataInfoV29(gf.O000O0oo, String.valueOf(O00O00Oo.O000000o(this.O000000o).getCurrSound().getDataId())));
        }
        if (O00O00Oo.O00000o0(this.O000000o)) {
            try {
                O00Oo0.O0000O0o().saveOrUpdate(new MusicHistoryBean(O00O00Oo.O00000o(this.O000000o), O00Oo0.O00000oO(), O00O00Oo.O00000oO(this.O000000o), O00O00Oo.O00000oo(this.O000000o), O00O00Oo.O0000O0o(this.O000000o), O00O00Oo.O0000OOo(this.O000000o), O00O00Oo.O0000Oo0(this.O000000o), System.currentTimeMillis()));
            } catch (DbException e) {
                e.printStackTrace();
            }
            O00O00Oo.O000000o(this.O000000o, true);
            O00000o0.O000000o().O00000o(new MusicStatusEvt(true));
        } else if (O00O00Oo.O000000o(this.O000000o) != null) {
            O00O00Oo.O000000o(this.O000000o).pause();
            O00O00Oo.O000000o(this.O000000o).stop();
        }
    }

    public void onPlayStop() {
        if (!(O00O00Oo.O000000o(this.O000000o) == null || O00O00Oo.O000000o(this.O000000o).getCurrSound() == null)) {
            O00OO0O.O000000o(new PvDataInfoV29(gf.O000OO0o, String.valueOf(O00O00Oo.O000000o(this.O000000o).getCurrSound().getDataId())));
        }
        O00O00Oo.O000000o(this.O000000o, false);
        O00000o0.O000000o().O00000o(new MusicStatusEvt(false));
    }

    public void onSoundPlayComplete() {
    }

    public void onSoundPrepared() {
    }

    public void onSoundSwitch(PlayableModel playableModel, PlayableModel playableModel2) {
        if (playableModel != null) {
            O00OO0O.O000000o(new PvDataInfoV29(gf.O000OO0o, String.valueOf(playableModel.getDataId())));
        }
        O00000o0.O000000o().O00000o(new MusicSwitchEvt(O00O00Oo.O00000o(this.O000000o), O00O00Oo.O000000o(this.O000000o).getCurrSound().getDataId()));
    }
}
