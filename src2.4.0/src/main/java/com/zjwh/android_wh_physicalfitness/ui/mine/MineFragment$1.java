package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;

class MineFragment$1 implements OnScrollChangeListener {
    final /* synthetic */ MineFragment O000000o;

    MineFragment$1(MineFragment mineFragment) {
        this.O000000o = mineFragment;
    }

    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        int height = MineFragment.O000000o(this.O000000o).getHeight() / 2;
        float abs = height > 0 ? Math.abs(i2 / height) >= 1 ? 1.0f : (float) Math.abs(i2 / MineFragment.O000000o(this.O000000o).getHeight()) : CropImageView.DEFAULT_ASPECT_RATIO;
        MineFragment.O00000Oo(this.O000000o).setBackgroundColor(O00Oo0.O000000o(abs, ContextCompat.getColor(this.O000000o.getContext(), R.color.white)));
        MineFragment.O00000o0(this.O000000o).setVisibility(abs == 1.0f ? 0 : 8);
        O00OOOo.O00000Oo(this.O000000o.getActivity(), Math.round(255.0f * abs), MineFragment.O00000Oo(this.O000000o));
        double d = (double) abs;
        if (d < 0.5d) {
            float f = 1.0f - (abs * 2.0f);
            MineFragment.O00000o(this.O000000o).setAlpha(f);
            MineFragment.O00000o(this.O000000o).setImageResource(R.drawable.mine_scan_icon);
            MineFragment.O00000oO(this.O000000o).setAlpha(f);
            MineFragment.O00000oO(this.O000000o).setImageResource(R.drawable.mine_qrcode_icon);
            MineFragment.O00000oo(this.O000000o).setAlpha(f);
            MineFragment.O00000oo(this.O000000o).setImageResource(R.drawable.mine_message_icon);
        } else {
            abs = (abs * 2.0f) - 1.0f;
            MineFragment.O00000o(this.O000000o).setAlpha(abs);
            MineFragment.O00000o(this.O000000o).setImageResource(R.drawable.mine_scan_black_icon);
            MineFragment.O00000oO(this.O000000o).setAlpha(abs);
            MineFragment.O00000oO(this.O000000o).setImageResource(R.drawable.mine_qrcode_black_icon);
            MineFragment.O00000oo(this.O000000o).setAlpha(abs);
            MineFragment.O00000oo(this.O000000o).setImageResource(R.drawable.mine_message_black_icon);
        }
        if (VERSION.SDK_INT < 23) {
            return;
        }
        if (d >= 0.5d && this.O000000o.getActivity().getWindow().getDecorView().getSystemUiVisibility() != 9216) {
            this.O000000o.getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
        } else if (d < 0.5d && this.O000000o.getActivity().getWindow().getDecorView().getSystemUiVisibility() == 9216) {
            this.O000000o.getActivity().getWindow().getDecorView().setSystemUiVisibility(1280);
        }
    }
}
