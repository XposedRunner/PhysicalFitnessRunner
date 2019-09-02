package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.Context;
import android.view.View;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import defpackage.gg;

class SportFragment$10 extends SportFragment$O000000o {
    final /* synthetic */ SportRecord O000000o;
    final /* synthetic */ SportFragment O00000Oo;

    SportFragment$10(SportFragment sportFragment, SportRecord sportRecord) {
        this.O00000Oo = sportFragment;
        this.O000000o = sportRecord;
        super(sportFragment, null);
    }

    public void onClick(View view) {
        super.onClick(view);
        Context activity = this.O00000Oo.getActivity();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SportFragment.O0000OOo(this.O00000Oo));
        stringBuilder.append(gg.O000OO00);
        O00O0Oo0.O000000o(activity, stringBuilder.toString());
        O000O0o.O000000o(this.O000000o.getTimestamp());
        O00O0Oo0.O000000o(gg.O000OO0o);
    }
}
