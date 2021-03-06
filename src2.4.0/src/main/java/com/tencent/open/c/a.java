package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;

/* compiled from: ProGuard */
public class a extends RelativeLayout {
    private static final String a = "com.tencent.open.c.a";
    private Rect b = null;
    private boolean c = false;
    private a d = null;

    /* compiled from: ProGuard */
    public interface a {
        void a();

        void a(int i);
    }

    public a(Context context) {
        super(context);
        if (this.b == null) {
            this.b = new Rect();
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i2);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.b.top) - size;
        if (!(this.d == null || size == 0)) {
            if (height > 100) {
                this.d.a((Math.abs(this.b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                this.d.a();
            }
        }
        super.onMeasure(i, i2);
    }
}
