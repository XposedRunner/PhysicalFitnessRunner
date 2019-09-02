package com.qiyukf.nim.uikit.session.activity;

import com.qiyukf.basesdk.c.c;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.widget.a.g.a;

class WatchMessagePictureActivity$4 implements a {
    final /* synthetic */ WatchMessagePictureActivity a;

    WatchMessagePictureActivity$4(WatchMessagePictureActivity watchMessagePictureActivity) {
        this.a = watchMessagePictureActivity;
    }

    public final void a(int i) {
        c.a(this.a).a("android.permission.WRITE_EXTERNAL_STORAGE").a(new c.a() {
            public final void onDenied() {
                g.a(R.string.ysf_no_permission_save_image);
            }

            public final void onGranted() {
                WatchMessagePictureActivity$4.this.a.savePicture();
            }
        }).a();
    }
}
