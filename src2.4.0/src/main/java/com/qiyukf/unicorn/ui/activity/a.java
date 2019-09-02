package com.qiyukf.unicorn.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class a {
    private View a;
    private int b;
    private LayoutParams c;
    private int d;
    private boolean e = true;

    private a(Activity activity) {
        this.a = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (a.this.e) {
                    a.this.d = a.this.a.getHeight();
                    a.this.b = a.this.d;
                    a.this.e = false;
                }
                a.e(a.this);
            }
        });
        this.c = (LayoutParams) this.a.getLayoutParams();
    }

    public static void a(Activity activity) {
        a aVar = new a(activity);
    }

    public static boolean a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = false;
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            z = z2;
            return z;
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void e(a aVar) {
        Rect rect = new Rect();
        aVar.a.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        if (i != aVar.b) {
            int height = aVar.a.getRootView().getHeight();
            int i2 = height - i;
            if (i2 > height / 4) {
                aVar.c.height = height - i2;
            } else {
                aVar.c.height = aVar.d;
            }
            aVar.a.requestLayout();
            aVar.b = i;
        }
    }
}
