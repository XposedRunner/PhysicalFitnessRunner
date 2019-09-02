package com.qiyukf.unicorn.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.j.h;
import com.qiyukf.unicorn.ui.evaluate.c;
import java.util.List;

public final class a {
    private Context a;
    private UICustomization b;
    private c c;
    private ViewGroup d;
    private LinearLayout e;
    private PopupWindow f;
    private a g;
    private List<b> h;

    public interface a {
        void a(b bVar);
    }

    public a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.d = viewGroup;
            this.a = viewGroup.getContext();
            this.e = new LinearLayout(this.a);
            this.e.setOrientation(0);
            this.e.setGravity(16);
            this.e.setPadding(d.a(10.0f), 0, d.a(10.0f), 0);
            this.d.removeAllViews();
            this.d.addView(this.e);
        }
    }

    private View a(final b bVar, boolean z) {
        Resources resources;
        int i;
        View inflate = LayoutInflater.from(this.a).inflate(z ? R.layout.ysf_service_action_menu_item_folded : R.layout.ysf_service_action_menu_item, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ysf_action_menu_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.ysf_action_menu_title);
        textView.setText(bVar.b());
        if (z || !b()) {
            imageView.setImageResource(bVar.d());
            resources = this.a.getResources();
            i = R.color.ysf_title_bar_text_color_dark_selector;
        } else {
            imageView.setImageResource(bVar.e());
            resources = this.a.getResources();
            i = R.color.ysf_title_bar_text_color_light_selector;
        }
        textView.setTextColor(resources.getColorStateList(i));
        if (!TextUtils.isEmpty(bVar.c())) {
            int dimension = (int) this.a.getResources().getDimension(R.dimen.ysf_title_bar_icon_size);
            com.qiyukf.nim.uikit.a.a(bVar.c(), imageView, dimension, dimension);
        }
        if (bVar.a() == com.qiyukf.unicorn.ui.a.b.a.b) {
            textView.setMaxEms(3);
            textView.setEllipsize(TruncateAt.END);
        }
        h.a(inflate, bVar.f());
        if (bVar.a() == com.qiyukf.unicorn.ui.a.b.a.d) {
            h.a(inflate, false);
            if (this.c != null) {
                this.c.a(inflate);
            }
        }
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.this.a();
                if (a.this.g != null) {
                    a.this.g.a(bVar);
                }
            }
        });
        return inflate;
    }

    private void a() {
        if (this.f != null && this.f.isShowing()) {
            this.f.dismiss();
        }
    }

    private void b(List<b> list) {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(R.drawable.ysf_menu_panel_background);
        for (int i = 1; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (i > 1) {
                linearLayout.addView(LayoutInflater.from(this.a).inflate(R.layout.ysf_include_divider, linearLayout, false), -1, d.a(0.5f));
            }
            linearLayout.addView(a(bVar, true), -1, -2);
        }
        this.f = new PopupWindow(this.a);
        this.f.setWidth(d.a(100.0f));
        this.f.setHeight(-2);
        this.f.setContentView(linearLayout);
        this.f.setBackgroundDrawable(new ColorDrawable(0));
        this.f.setOutsideTouchable(false);
        this.f.setFocusable(true);
        this.f.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss() {
                a.a(a.this, 1.0f);
            }
        });
    }

    private boolean b() {
        return this.b != null && this.b.titleBarStyle == 1;
    }

    public final void a(UICustomization uICustomization) {
        this.b = uICustomization;
    }

    public final void a(a aVar) {
        this.g = aVar;
    }

    public final void a(c cVar) {
        this.c = cVar;
    }

    public final void a(List<b> list) {
        if (this.d != null) {
            if (list.isEmpty()) {
                this.d.setVisibility(8);
                return;
            }
            int i;
            this.d.setVisibility(0);
            int i2 = 1;
            if (this.h != null && this.h.size() == list.size()) {
                for (i = 0; i < this.h.size(); i++) {
                    if (!((b) this.h.get(i)).equals(list.get(i))) {
                        break;
                    }
                }
                i2 = 0;
            }
            if (i2 != 0) {
                this.h = list;
                a();
                for (b a : this.h) {
                    a.a(this.a);
                }
                this.e.removeAllViews();
                if (this.h.size() < 3) {
                    for (int i3 = 0; i3 < this.h.size(); i3++) {
                        View a2 = a((b) this.h.get(i3), false);
                        if (i3 > 0) {
                            LayoutParams layoutParams = new LayoutParams(-2, -2);
                            layoutParams.leftMargin = d.a(10.0f);
                            a2.setLayoutParams(layoutParams);
                        }
                        this.e.addView(a2);
                    }
                    return;
                }
                this.e.addView(a((b) this.h.get(0), false));
                ImageView imageView = new ImageView(this.a);
                imageView.setScaleType(ScaleType.CENTER_INSIDE);
                imageView.setImageResource(b() ? R.drawable.ysf_ic_menu_more_light : R.drawable.ysf_ic_menu_more_dark);
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.f != null) {
                            a.this.f.showAsDropDown(a.this.e, -d.a(30.0f), d.a(10.0f));
                            a.a(a.this, 0.5f);
                        }
                        if (a.this.g != null) {
                            a.this.g.a(new b(com.qiyukf.unicorn.ui.a.b.a.a));
                        }
                    }
                });
                i = (int) this.a.getResources().getDimension(R.dimen.ysf_title_bar_icon_size);
                LayoutParams layoutParams2 = new LayoutParams(i, i);
                layoutParams2.leftMargin = d.a(10.0f);
                this.e.addView(imageView, layoutParams2);
                b(this.h);
            }
        }
    }
}
