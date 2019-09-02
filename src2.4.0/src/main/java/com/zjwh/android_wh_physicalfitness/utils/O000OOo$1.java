package com.zjwh.android_wh_physicalfitness.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import defpackage.oO00OOOo;
import defpackage.oOo0oooO;

/* compiled from: GlideImageLoader */
class O000OOo$1 extends oOo0oooO<Bitmap> {
    final /* synthetic */ ImageLoaderListener O00000Oo;
    final /* synthetic */ O000OOo O00000o0;

    O000OOo$1(O000OOo o000OOo, int i, int i2, ImageLoaderListener imageLoaderListener) {
        this.O00000o0 = o000OOo;
        this.O00000Oo = imageLoaderListener;
        super(i, i2);
    }

    public void O000000o(Bitmap bitmap, oO00OOOo<? super Bitmap> oo00oooo) {
        if (this.O00000Oo != null) {
            this.O00000Oo.onLoadComplete(bitmap);
        }
    }

    public void O000000o(Exception exception, Drawable drawable) {
        if (this.O00000Oo != null) {
            this.O00000Oo.onLoadFailed(exception);
        }
    }
}
