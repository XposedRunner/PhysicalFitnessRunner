package com.qiyukf.nim.uikit.session.activity;

import android.graphics.Bitmap;
import com.qiyukf.nim.uikit.common.ui.imageview.BaseZoomableImageView;

class WatchMessagePictureActivity$6 implements Runnable {
    final /* synthetic */ BaseZoomableImageView a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ WatchMessagePictureActivity c;

    WatchMessagePictureActivity$6(WatchMessagePictureActivity watchMessagePictureActivity, BaseZoomableImageView baseZoomableImageView, Bitmap bitmap) {
        this.c = watchMessagePictureActivity;
        this.a = baseZoomableImageView;
        this.b = bitmap;
    }

    public final void run() {
        this.a.a(this.b);
    }
}
