package com.zjwh.android_wh_physicalfitness.fragment;

import android.os.Build.VERSION;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;

class FindFragment$2 implements OnScrollChangeListener {
    final /* synthetic */ FindFragment O000000o;

    FindFragment$2(FindFragment findFragment) {
        this.O000000o = findFragment;
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        float abs = FindFragment.O00000Oo(this.O000000o).getHeight() > 0 ? Math.abs(i2 / FindFragment.O00000Oo(this.O000000o).getHeight()) >= 1 ? 1.0f : (float) Math.abs(i2 / FindFragment.O00000Oo(this.O000000o).getHeight()) : CropImageView.DEFAULT_ASPECT_RATIO;
        O00OOOo.O000000o(this.O000000o.getActivity(), Math.round(255.0f * abs), null);
        if (VERSION.SDK_INT >= 23) {
            double d = (double) abs;
            if (d >= 0.5d && this.O000000o.getActivity().getWindow().getDecorView().getSystemUiVisibility() != 9216) {
                this.O000000o.getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
            } else if (d < 0.5d && this.O000000o.getActivity().getWindow().getDecorView().getSystemUiVisibility() == 9216) {
                this.O000000o.getActivity().getWindow().getDecorView().setSystemUiVisibility(1280);
            }
        }
    }
}
