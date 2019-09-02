package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.album.SubordinatedAlbum;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerStatusListener;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl.PlayMode;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerConfig;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicStatusEvt;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicSwitchEvt;
import java.util.List;
import org.greenrobot.eventbus.O00000o0;

/* compiled from: MusicManager */
public class O00O00Oo {
    public static final String O000000o = "extra_album_url";
    public static final String O00000Oo = "extra_album_title";
    private static O00O00Oo O00000o = null;
    public static final String O00000o0 = "extra_album_id";
    private static Context O00000oO;
    private XmPlayerManager O00000oo;
    private IXmPlayerStatusListener O0000O0o;
    private List<Track> O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private long O0000Ooo;
    private boolean O0000o;
    private int O0000o0;
    private long O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o;
    private boolean O0000oO0 = true;

    public static O00O00Oo O000000o() {
        if (O00000o == null) {
            synchronized (O00O00Oo.class) {
                O00000o = new O00O00Oo();
            }
        }
        return O00000o;
    }

    public static void O000000o(Context context) {
        O00000oO = context;
    }

    private void O0000Ooo() {
        if (this.O00000oo != null) {
            this.O00000oo.pause();
            this.O00000oo.stop();
            this.O00000oo.resetPlayer();
        }
    }

    private boolean O0000o00() {
        if (!this.O0000oO0 || O00Oo0.O0000O0o(O00000oO) == 1 || O00Oo0.O0000O0o(O00000oO) == 0) {
            return true;
        }
        if (this.O00000oo != null && this.O00000oo.isPlaying()) {
            this.O00000oo.pause();
            this.O0000o = false;
            O00000o0.O000000o().O00000o(new MusicStatusEvt(false));
        }
        MyApplication.O000000o().O00000o();
        return false;
    }

    public void O000000o(int i) {
        if (this.O00000oo != null) {
            this.O00000oo.seekTo(i);
        }
    }

    public void O000000o(long j) {
        if (j >= 0 && this.O00000oo != null && this.O00000oo.getPlayList() != null) {
            for (Track track : this.O00000oo.getPlayList()) {
                if (track.getDataId() == j) {
                    track.setAuthorized(true);
                    this.O00000oo.updateTrackInPlayList(track);
                    break;
                }
            }
            PlayableModel currSound = this.O00000oo.getCurrSound();
            if (currSound != null && currSound.getDataId() == j && (this.O00000oo.isPlaying() || this.O00000oo.getPlayerStatus() == 0)) {
                this.O00000oo.play(this.O00000oo.getCurrentIndex());
            }
        }
    }

    public void O000000o(List<Track> list, int i, boolean z, long j) {
        this.O0000o0o = true;
        this.O0000OOo = list;
        this.O0000o0 = i;
        O00000Oo.O000000o();
        if (this.O00000oo != null && i >= 0 && i < list.size()) {
            this.O00000oo.playList(list, i);
        }
        Track track = (Track) list.get(i);
        this.O0000OoO = track.getAnnouncer().getNickname();
        SubordinatedAlbum album = track.getAlbum();
        if (album != null) {
            this.O0000Oo0 = album.getCoverUrlMiddle();
            this.O0000Oo = album.getAlbumTitle();
            this.O0000Ooo = album.getAlbumId();
        }
        this.O0000o0O = z;
        this.O0000o00 = j;
        O00000Oo();
    }

    public void O000000o(boolean z) {
        this.O0000o0o = z;
    }

    public void O00000Oo() {
        int duration;
        int i;
        if (this.O00000oo != null) {
            int playCurrPositon = this.O00000oo.getPlayCurrPositon();
            duration = this.O00000oo.getDuration();
            i = playCurrPositon;
        } else {
            i = 0;
            duration = i;
        }
        MyApplication.O000000o().O000000o(this.O0000Oo0, this.O0000Oo, this.O0000Ooo, this.O0000OoO, i, duration, this.O0000o0O, this.O0000o00);
    }

    public void O00000Oo(long j) {
        if (j >= 0 && this.O00000oo != null && this.O00000oo.getPlayList() != null) {
            boolean z = false;
            PlayableModel currSound = this.O00000oo.getCurrSound();
            for (Track track : this.O00000oo.getPlayList()) {
                if (!(track.getAlbum() == null || track.getAlbum().getAlbumId() != this.O0000Ooo || track.isAuthorized())) {
                    track.setAuthorized(true);
                    this.O00000oo.updateTrackInPlayList(track);
                    if (track.equals(currSound)) {
                        z = true;
                    }
                }
            }
            if ((z && this.O00000oo.isPlaying()) || this.O00000oo.getPlayerStatus() == 0) {
                this.O00000oo.play(this.O00000oo.getCurrentIndex());
            }
        }
    }

    public void O00000Oo(Context context) {
        XmPlayerConfig.getInstance(context.getApplicationContext()).setBreakpointResume(false);
        if (this.O00000oo == null) {
            this.O00000oo = XmPlayerManager.getInstance(context.getApplicationContext());
            this.O00000oo.init();
            if (this.O00000oo.isConnected()) {
                this.O00000oo.setBreakpointResume(false);
                this.O00000oo.setPlayMode(PlayMode.PLAY_MODEL_LIST_LOOP);
            } else {
                this.O00000oo.addOnConnectedListerner(new 1(this));
            }
            this.O0000O0o = new 2(this);
            this.O00000oo.addPlayerStatusListener(this.O0000O0o);
        }
    }

    public void O00000Oo(boolean z) {
        this.O0000oO0 = z;
    }

    public void O00000o() {
        if (this.O00000oo == null) {
            return;
        }
        if (this.O00000oo.isPlaying()) {
            this.O00000oo.pause();
            this.O0000o = false;
            return;
        }
        this.O00000oo.play();
    }

    public void O00000o0() {
        if (this.O00000oo != null) {
            if ((this.O00000oo.getPlayList() == null || this.O00000oo.getPlayList().size() <= 0) && this.O0000OOo != null && this.O0000OOo.size() > this.O0000o0) {
                this.O00000oo.playList(this.O0000OOo, this.O0000o0);
            } else {
                this.O00000oo.play();
            }
            if (!O00Oo0.O00000Oo(O00000oO)) {
                O00Oo00.O000000o(2131689762);
            }
        }
    }

    public void O00000oO() {
        if (this.O00000oo != null) {
            this.O00000oo.playNext();
            this.O0000o = false;
            O00000o0.O000000o().O00000o(new MusicStatusEvt(false));
            if (!O00Oo0.O00000Oo(O00000oO)) {
                O00Oo00.O000000o(2131689762);
            }
        }
    }

    public void O00000oo() {
        if (this.O00000oo != null) {
            this.O00000oo.playPre();
            this.O0000o = false;
            O00000o0.O000000o().O00000o(new MusicStatusEvt(false));
            if (!O00Oo0.O00000Oo(O00000oO)) {
                O00Oo00.O000000o(2131689762);
            }
        }
    }

    public void O0000O0o() {
        if (this.O00000oo != null) {
            O0000Ooo();
        }
        this.O0000o = false;
        this.O0000o0o = false;
        MyApplication.O000000o().O00000o0();
    }

    public MusicSwitchEvt O0000OOo() {
        return (this.O00000oo == null || this.O00000oo.getCurrSound() == null) ? null : new MusicSwitchEvt(this.O0000Ooo, this.O00000oo.getCurrSound().getDataId());
    }

    public boolean O0000Oo() {
        return this.O0000o0o;
    }

    public void O0000Oo0() {
        XmPlayerManager.release();
        if (!(this.O00000oo == null || this.O0000O0o == null)) {
            O0000Ooo();
            this.O00000oo.removePlayerStatusListener(this.O0000O0o);
        }
        this.O00000oo = null;
        this.O0000o0o = false;
        this.O0000o = false;
    }

    public boolean O0000OoO() {
        return this.O0000o;
    }
}
