package com.qiyukf.unicorn.ui.activity;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.nim.uikit.common.ui.imageview.a;
import com.qiyukf.unicorn.R;

class UrlImagePreviewActivity$a extends PagerAdapter {
    final /* synthetic */ UrlImagePreviewActivity a;

    private UrlImagePreviewActivity$a(UrlImagePreviewActivity urlImagePreviewActivity) {
        this.a = urlImagePreviewActivity;
    }

    /* synthetic */ UrlImagePreviewActivity$a(UrlImagePreviewActivity urlImagePreviewActivity, byte b) {
        this(urlImagePreviewActivity);
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ViewGroup viewGroup2 = (ViewGroup) obj;
        viewGroup2.removeAllViews();
        viewGroup.removeView(viewGroup2);
    }

    public final int getCount() {
        return UrlImagePreviewActivity.b(this.a).size();
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ysf_url_image_preview_item, null);
        final MultiTouchZoomableImageView multiTouchZoomableImageView = (MultiTouchZoomableImageView) inflate.findViewById(R.id.ysf_image_preview_image);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.ysf_image_preview_progress);
        multiTouchZoomableImageView.a(UrlImagePreviewActivity.a(this.a));
        multiTouchZoomableImageView.a((a) new a() {
            public final void a() {
                UrlImagePreviewActivity$a.this.a.finish();
            }

            public final void b() {
                UrlImagePreviewActivity.a(UrlImagePreviewActivity$a.this.a, multiTouchZoomableImageView);
            }

            public final void c() {
                UrlImagePreviewActivity$a.this.a.finish();
            }
        });
        UrlImagePreviewActivity.a(this.a, multiTouchZoomableImageView, progressBar, (String) UrlImagePreviewActivity.b(this.a).get(i));
        viewGroup.addView(inflate);
        return inflate;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
