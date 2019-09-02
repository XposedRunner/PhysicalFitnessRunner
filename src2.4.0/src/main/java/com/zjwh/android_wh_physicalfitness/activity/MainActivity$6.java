package com.zjwh.android_wh_physicalfitness.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.entity.MainBottomItemBean;
import defpackage.oO00OOOo;
import defpackage.oOo0oooO;

class MainActivity$6 extends oOo0oooO<Bitmap> {
    final /* synthetic */ Drawable[] O00000Oo;
    final /* synthetic */ ImageView O00000o;
    final /* synthetic */ boolean[] O00000o0;
    final /* synthetic */ MainBottomItemBean O00000oO;
    final /* synthetic */ MainActivity O00000oo;

    MainActivity$6(MainActivity mainActivity, Drawable[] drawableArr, boolean[] zArr, ImageView imageView, MainBottomItemBean mainBottomItemBean) {
        this.O00000oo = mainActivity;
        this.O00000Oo = drawableArr;
        this.O00000o0 = zArr;
        this.O00000o = imageView;
        this.O00000oO = mainBottomItemBean;
    }

    public void O000000o(Bitmap bitmap, oO00OOOo<? super Bitmap> oo00oooo) {
        this.O00000Oo[0] = new BitmapDrawable(this.O00000oo.getResources(), bitmap);
        this.O00000o0[0] = true;
        MainActivity.O000000o(this.O00000oo, this.O00000o, this.O00000Oo, this.O00000oO.getModuleId(), this.O00000o0[1]);
    }

    public void O000000o(Exception exception, Drawable drawable) {
        super.O000000o(exception, drawable);
        this.O00000o0[0] = true;
        MainActivity.O000000o(this.O00000oo, this.O00000o, this.O00000Oo, this.O00000oO.getModuleId(), this.O00000o0[1]);
    }
}
