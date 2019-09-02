package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.zjwh.android_wh_physicalfitness.utils.O00O00Oo;

class MusicPlayerDialog$1 implements OnSeekBarChangeListener {
    final /* synthetic */ MusicPlayerDialog O000000o;

    MusicPlayerDialog$1(MusicPlayerDialog musicPlayerDialog) {
        this.O000000o = musicPlayerDialog;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        O00O00Oo.O000000o().O000000o(seekBar.getProgress());
    }
}
