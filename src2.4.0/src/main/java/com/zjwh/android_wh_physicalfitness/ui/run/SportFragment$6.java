package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.entity.HomePageDialogBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import defpackage.gf;

class SportFragment$6 implements OnClickListener {
    final /* synthetic */ HomePageDialogBean O000000o;
    final /* synthetic */ SportFragment O00000Oo;

    SportFragment$6(SportFragment sportFragment, HomePageDialogBean homePageDialogBean) {
        this.O00000Oo = sportFragment;
        this.O000000o = homePageDialogBean;
    }

    public void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gf.O000o00o);
        stringBuilder.append(this.O000000o.getBounceId());
        O00OO0O.O000000o(new PvDataInfoV29(gf.O000Oo0O, stringBuilder.toString()));
        Context context = view.getContext();
        String str = O000000o.O00000Oo;
        stringBuilder = new StringBuilder();
        stringBuilder.append(gf.O000o00o);
        stringBuilder.append(this.O000000o.getBounceId());
        O00Oo00o.O000000o(context, str, stringBuilder.toString());
    }
}
