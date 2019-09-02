package com.qiyukf.nim.uikit.common.media.picker.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiyukf.basesdk.c.a;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.common.media.picker.model.PhotoInfo;
import com.qiyukf.nim.uikit.common.ui.imageview.BaseZoomableImageView;
import com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.nimlib.k.b.b;
import com.qiyukf.unicorn.R;
import java.util.List;

public final class c extends PagerAdapter {
    private List<PhotoInfo> a;
    private LayoutInflater b;
    private Handler c = a.a().c();
    private Handler d = new Handler();
    private int e;

    public c(int i, List<PhotoInfo> list, LayoutInflater layoutInflater) {
        this.e = i;
        this.a = list;
        this.b = layoutInflater;
    }

    public final void a(final MultiTouchZoomableImageView multiTouchZoomableImageView, int i, boolean z) {
        PhotoInfo photoInfo = (PhotoInfo) this.a.get(i);
        if (photoInfo != null && photoInfo.getAbsolutePath() != null) {
            Bitmap a;
            Bitmap b = com.qiyukf.nimlib.k.b.a.b(photoInfo.getAbsolutePath());
            if (b == null) {
                a = b.a();
                g.b(R.string.ysf_picker_image_error);
            } else {
                a = b.a(photoInfo.getAbsolutePath(), b);
            }
            if (z) {
                multiTouchZoomableImageView.a(a);
            } else {
                this.d.post(new Runnable() {
                    public final void run() {
                        multiTouchZoomableImageView.a(a);
                    }
                });
            }
        }
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        ((BaseZoomableImageView) view.findViewById(R.id.imageView)).b();
        viewGroup.removeView(view);
    }

    public final int getCount() {
        return this.a == null ? 0 : this.a.size();
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i) {
        View inflate = this.b.inflate(R.layout.ysf_preview_image_layout_multi_touch, null);
        final MultiTouchZoomableImageView multiTouchZoomableImageView = (MultiTouchZoomableImageView) inflate.findViewById(R.id.imageView);
        if (i == this.e) {
            a(multiTouchZoomableImageView, i, true);
        } else {
            this.c.post(new Runnable() {
                public final void run() {
                    c.this.a(multiTouchZoomableImageView, i, false);
                }
            });
        }
        viewGroup.addView(inflate);
        inflate.setTag(Integer.valueOf(i));
        return inflate;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
