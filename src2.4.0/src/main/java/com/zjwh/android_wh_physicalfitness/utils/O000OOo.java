package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.UnicornImageLoader;

/* compiled from: GlideImageLoader */
public class O000OOo implements UnicornImageLoader {
    private Context O000000o;

    public O000OOo(Context context) {
        this.O000000o = context.getApplicationContext();
    }

    public void loadImage(String str, int i, int i2, ImageLoaderListener imageLoaderListener) {
        O00Oo.O00000o0(this.O000000o).O000000o(str).O0000Oo().O00000Oo(new 1(this, i, i2, imageLoaderListener));
    }

    @Nullable
    public Bitmap loadImageSync(String str, int i, int i2) {
        return null;
    }
}
