package com.zjwh.android_wh_physicalfitness.view.blur;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.utils.O0000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O0000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0OO;

/* compiled from: BlurDialogFragmentHelper */
public class O000000o {
    private final DialogFragment O000000o;
    private ViewGroup O00000Oo;
    private View O00000o;
    private ViewGroup O00000o0;
    private ImageView O00000oO;
    private int O00000oo;
    private int O0000O0o = R.style.fullscreen;
    private int O0000OOo = R.color.dark_a85;

    public O000000o(@NonNull DialogFragment dialogFragment) {
        this.O000000o = dialogFragment;
        this.O00000oo = dialogFragment.getActivity().getResources().getInteger(17694721);
    }

    private void O00000oO() {
        O0000Oo.O000000o(this.O00000o, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, this.O00000oo, null);
        O0000Oo.O000000o(this.O00000oO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, this.O00000oo, null);
    }

    private void O00000oo() {
        O0000Oo.O000000o(this.O00000o, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, this.O00000oo, null);
        O0000Oo.O000000o(this.O00000oO, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, this.O00000oo, new Runnable() {
            public void run() {
                O000000o.this.O00000Oo.removeView(O000000o.this.O00000o0);
            }
        });
    }

    public void O000000o() {
        this.O000000o.setStyle(0, 16973841);
    }

    public void O000000o(int i) {
        this.O00000oo = i;
    }

    public void O000000o(boolean z) {
        this.O000000o.getDialog().getWindow().setWindowAnimations(this.O0000O0o);
        Rect rect = new Rect();
        this.O00000Oo = (ViewGroup) this.O000000o.getActivity().getWindow().getDecorView();
        this.O00000Oo.getWindowVisibleDisplayFrame(rect);
        this.O00000o0 = new FrameLayout(this.O000000o.getActivity());
        if (O0000Oo.O000000o()) {
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            layoutParams.setMargins(0, 0, 0, z ? O00Oo0OO.O000000o(this.O00000Oo.getResources()) : 0);
            this.O00000o0.setLayoutParams(layoutParams);
        } else {
            this.O00000o0.setPadding(rect.left, rect.top, 0, 0);
        }
        this.O00000o = new View(this.O000000o.getActivity());
        this.O00000o.setBackgroundColor(ContextCompat.getColor(this.O000000o.getContext(), this.O0000OOo));
        O0000Oo.O000000o(this.O00000o, (float) CropImageView.DEFAULT_ASPECT_RATIO);
        this.O00000oO = new ImageView(this.O000000o.getActivity());
        LayoutParams layoutParams2 = new LayoutParams(-1, -1);
        layoutParams2.setMargins(0, 0, 0, 0);
        this.O00000oO.setLayoutParams(layoutParams2);
        this.O00000oO.setPadding(rect.left, rect.top, 0, 0);
        O0000Oo.O000000o(this.O00000oO, 1.0f);
        this.O00000o0.addView(this.O00000oO);
        this.O00000o0.addView(this.O00000o);
        this.O00000Oo.addView(this.O00000o0);
        Bitmap O000000o = O0000Oo.O000000o(this.O00000Oo, rect.right, rect.bottom, (float) rect.left, (float) rect.top, 1);
        this.O00000oO.setImageBitmap(O0000o0.O000000o(this.O000000o.getActivity(), O000000o));
        O000000o.recycle();
    }

    public void O00000Oo() {
        O00000oO();
    }

    public void O00000Oo(@StyleRes int i) {
        this.O0000O0o = i;
    }

    public void O00000o() {
        if (this.O00000Oo != null) {
            this.O00000Oo.removeAllViews();
        }
    }

    public void O00000o0() {
        O00000oo();
    }

    public void O00000o0(@ColorRes int i) {
        this.O0000OOo = i;
    }
}
