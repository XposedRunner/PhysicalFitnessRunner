package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.entity.HomePageDialogBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O00000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import defpackage.gf;
import java.io.UnsupportedEncodingException;

class SportFragment$5 implements OnClickListener {
    final /* synthetic */ HomePageDialogBean O000000o;
    final /* synthetic */ SportFragment O00000Oo;

    SportFragment$5(SportFragment sportFragment, HomePageDialogBean homePageDialogBean) {
        this.O00000Oo = sportFragment;
        this.O000000o = homePageDialogBean;
    }

    public void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gf.O000o00O);
        stringBuilder.append(this.O000000o.getBounceId());
        O00OO0O.O000000o(new PvDataInfoV29(gf.O000Oo0O, stringBuilder.toString()));
        Context context = view.getContext();
        String str = O000000o.O00000Oo;
        stringBuilder = new StringBuilder();
        stringBuilder.append(gf.O000o00O);
        stringBuilder.append(this.O000000o.getBounceId());
        O00Oo00o.O000000o(context, str, stringBuilder.toString());
        String targetUrl = this.O000000o.getTargetUrl();
        try {
            if (!TextUtils.isEmpty(this.O000000o.getTargetUrl())) {
                targetUrl = O00000o0.O000000o(this.O000000o.getTargetUrl());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        O000o0.O000000o(this.O00000Oo.getActivity(), targetUrl);
    }
}
