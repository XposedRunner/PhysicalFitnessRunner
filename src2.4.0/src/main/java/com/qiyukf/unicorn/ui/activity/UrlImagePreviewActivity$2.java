package com.qiyukf.unicorn.ui.activity;

import android.graphics.Bitmap;
import com.qiyukf.basesdk.c.c;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.widget.a.g.a;

class UrlImagePreviewActivity$2 implements a {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ UrlImagePreviewActivity b;

    UrlImagePreviewActivity$2(UrlImagePreviewActivity urlImagePreviewActivity, Bitmap bitmap) {
        this.b = urlImagePreviewActivity;
        this.a = bitmap;
    }

    public final void a(int i) {
        c.a(this.b).a("android.permission.WRITE_EXTERNAL_STORAGE").a(new c.a() {
            public final void onDenied() {
                g.a(R.string.ysf_no_permission_save_image);
            }

            public final void onGranted() {
                UrlImagePreviewActivity.a(UrlImagePreviewActivity$2.this.b, UrlImagePreviewActivity$2.this.a);
            }
        }).a();
    }
}
