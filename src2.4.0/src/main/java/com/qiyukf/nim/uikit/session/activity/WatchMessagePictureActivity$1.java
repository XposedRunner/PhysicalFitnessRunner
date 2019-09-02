package com.qiyukf.nim.uikit.session.activity;

import android.support.v4.view.ViewPager.OnPageChangeListener;

class WatchMessagePictureActivity$1 implements OnPageChangeListener {
    final /* synthetic */ WatchMessagePictureActivity a;

    WatchMessagePictureActivity$1(WatchMessagePictureActivity watchMessagePictureActivity) {
        this.a = watchMessagePictureActivity;
    }

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
        if (f == 0.0f && WatchMessagePictureActivity.a(this.a)) {
            WatchMessagePictureActivity.a(this.a, false);
            WatchMessagePictureActivity.b(this.a).setVisibility(8);
            WatchMessagePictureActivity.a(this.a, i);
            WatchMessagePictureActivity.b(this.a, WatchMessagePictureActivity.c(this.a).getCurrentItem());
        }
    }

    public final void onPageSelected(int i) {
        WatchMessagePictureActivity.a(this.a, true);
    }
}
