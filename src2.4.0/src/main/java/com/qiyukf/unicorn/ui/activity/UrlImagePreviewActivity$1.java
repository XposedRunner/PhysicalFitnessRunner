package com.qiyukf.unicorn.ui.activity;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.widget.ProgressBar;
import com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.unicorn.api.ImageLoaderListener;

class UrlImagePreviewActivity$1 implements ImageLoaderListener {
    final /* synthetic */ MultiTouchZoomableImageView a;
    final /* synthetic */ ProgressBar b;
    final /* synthetic */ UrlImagePreviewActivity c;

    UrlImagePreviewActivity$1(UrlImagePreviewActivity urlImagePreviewActivity, MultiTouchZoomableImageView multiTouchZoomableImageView, ProgressBar progressBar) {
        this.c = urlImagePreviewActivity;
        this.a = multiTouchZoomableImageView;
        this.b = progressBar;
    }

    public final void onLoadComplete(@NonNull Bitmap bitmap) {
        if (this.a.getParent() != null) {
            this.b.setVisibility(8);
            this.a.a(bitmap);
        }
    }

    public final void onLoadFailed(Throwable th) {
        if (this.a.getParent() != null) {
            this.b.setVisibility(8);
            if (this.a.a() == UrlImagePreviewActivity.c(this.c)) {
                this.a.a(UrlImagePreviewActivity.d(this.c));
            }
        }
    }
}
