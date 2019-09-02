package com.qiyukf.unicorn.ui.evaluate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.b;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.j.h;
import com.qiyukf.unicorn.ui.evaluate.a.a;
import java.util.List;

public final class c {
    private Fragment a;
    private Context b;
    private View c;
    private ImageView d;
    private TextView e;
    private a f;
    private String g;
    private int h = 0;
    private boolean i = false;

    public c(Fragment fragment, String str) {
        this.a = fragment;
        this.g = str;
    }

    static /* synthetic */ void a(c cVar, int i, List list, String str) {
        cVar.f.a(false);
        cVar.f.b(true);
        d.g().c().a(cVar.g, i, str, list, new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i != 200 || c.this.f == null) {
                    if (!(i == 200 || c.this.f == null || !c.this.f.isShowing())) {
                        c.this.f.a(true);
                        c.this.f.b(false);
                        g.a(c.this.b.getString(R.string.ysf_network_error));
                    }
                    return;
                }
                c.this.f.cancel();
                c.this.f = null;
            }
        });
    }

    public final void a() {
        if (this.c != null) {
            b.a(this.a);
            if (this.h == 1) {
                this.d.clearAnimation();
                this.f = new a(this.b, this.g);
                this.f.setCanceledOnTouchOutside(false);
                this.f.a(new a() {
                    public final void a(int i, List<String> list, String str) {
                        c.a(c.this, i, list, str);
                    }
                });
                this.f.show();
            }
        }
    }

    public final void a(View view) {
        if (view != null) {
            this.c = view;
            this.b = view.getContext();
            this.d = (ImageView) view.findViewById(R.id.ysf_action_menu_icon);
            this.e = (TextView) view.findViewById(R.id.ysf_action_menu_title);
        }
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(boolean z) {
        this.i = z;
        b();
    }

    public final void b() {
        int i = 0;
        if (this.i) {
            this.h = com.qiyukf.unicorn.b.b.j(this.g);
        } else {
            this.h = 0;
        }
        if (com.qiyukf.unicorn.b.a().b() != null) {
            com.qiyukf.unicorn.b.a();
        }
        if (this.c != null) {
            h.a(this.c, this.h != 0);
            this.d.setImageLevel(this.h);
            this.e.setText(this.h == 2 ? R.string.ysf_evaluation_complete : R.string.ysf_evaluation);
            if (this.h == 0) {
                this.d.clearAnimation();
            }
        }
        if (com.qiyukf.unicorn.b.b.i(this.g) == 4) {
            i = 1;
        }
        if (this.i && i != 0) {
            c();
        }
    }

    public final void c() {
        if (this.c != null && this.h == 1 && (this.f == null || !this.f.isShowing())) {
            com.qiyukf.unicorn.b.b.a(this.g, -1);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -8.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new CycleInterpolator(3.0f));
            rotateAnimation.setDuration(400);
            rotateAnimation.setStartOffset(800);
            rotateAnimation.setRepeatCount(4);
            this.d.startAnimation(rotateAnimation);
        }
    }
}
