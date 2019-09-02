package com.qiyukf.nim.uikit.session.activity;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.qiyukf.basesdk.c.a;
import com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import java.util.List;

class WatchMessagePictureActivity$a extends PagerAdapter {
    final /* synthetic */ WatchMessagePictureActivity a;
    private List<IMMessage> b;
    private Handler c = a.a().c();
    private int d;

    public WatchMessagePictureActivity$a(WatchMessagePictureActivity watchMessagePictureActivity, int i, List<IMMessage> list) {
        this.a = watchMessagePictureActivity;
        this.b = list;
        this.d = i;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        MultiTouchZoomableImageView multiTouchZoomableImageView = (MultiTouchZoomableImageView) obj;
        multiTouchZoomableImageView.b();
        viewGroup.removeView(multiTouchZoomableImageView);
    }

    public final int getCount() {
        return this.b == null ? 0 : this.b.size();
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, final int i) {
        MultiTouchZoomableImageView multiTouchZoomableImageView = new MultiTouchZoomableImageView(viewGroup.getContext());
        viewGroup.addView(multiTouchZoomableImageView, new LayoutParams(-1, -1));
        multiTouchZoomableImageView.setTag(Integer.valueOf(i));
        if (i == this.d) {
            WatchMessagePictureActivity.a(this.a, (IMMessage) WatchMessagePictureActivity.f(this.a).get(i), true);
            return multiTouchZoomableImageView;
        }
        this.c.post(new Runnable() {
            public final void run() {
                WatchMessagePictureActivity.a(WatchMessagePictureActivity$a.this.a, (IMMessage) WatchMessagePictureActivity.f(WatchMessagePictureActivity$a.this.a).get(i), false);
            }
        });
        return multiTouchZoomableImageView;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
