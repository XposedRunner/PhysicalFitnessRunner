package com.zjwh.android_wh_physicalfitness.ui.run;

import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;

class SportFragment$11 implements OnClickListener {
    final /* synthetic */ SportRecord O000000o;
    final /* synthetic */ boolean O00000Oo;
    final /* synthetic */ SportFragment O00000o;
    final /* synthetic */ boolean O00000o0;

    SportFragment$11(SportFragment sportFragment, SportRecord sportRecord, boolean z, boolean z2) {
        this.O00000o = sportFragment;
        this.O000000o = sportRecord;
        this.O00000Oo = z;
        this.O00000o0 = z2;
    }

    public void onClick(View view) {
        if (this.O000000o.getSportType() == 3) {
            RunDueActivity.O000000o(this.O00000o.getActivity(), this.O000000o.getRoomId(), this.O000000o.getSelDistance());
        } else if (this.O00000Oo) {
            RunFreeActivity.O000000o(this.O00000o.getActivity(), this.O000000o.getCreateTime());
        } else if (this.O000000o.getSportType() != 1) {
        } else {
            if (this.O00000o0) {
                RunSequenceActivity.O00000Oo(this.O00000o.getActivity(), this.O000000o.getSelDistance());
            } else if (this.O000000o.getPolicy() == 2) {
                RunEndActivity.O000000o(this.O00000o.getActivity(), this.O000000o.getSelDistance());
            } else {
                RunRandomActivity.O000000o(this.O00000o.getActivity(), this.O000000o.getSelDistance());
            }
        }
    }
}
