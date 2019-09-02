package com.qiyukf.unicorn.ui.b.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.c;
import com.qiyukf.unicorn.f.a.a.a.e.b;
import com.qiyukf.unicorn.j.h;
import java.util.List;

public class g extends e implements OnClickListener, OnDismissListener {
    private View a;
    private TextView b;
    private c c;
    private b d;
    private PopupWindow e;
    private View f;
    private View g;

    public static class a {
        private LinearLayout a;

        public a(LinearLayout linearLayout) {
            this.a = linearLayout;
        }

        public final void a(List<List<com.qiyukf.unicorn.f.a.a.a.c.a.a>> list) {
            for (int i = 0; i < list.size(); i++) {
                View view;
                List list2 = (List) list.get(i);
                View view2 = (LinearLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.ysf_popup_window_card_detail_group, this.a, false);
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.ysf_card_detail_group);
                View findViewById = view2.findViewById(R.id.ysf_card_detail_space);
                int i2 = 0;
                while (i2 < list2.size()) {
                    com.qiyukf.unicorn.f.a.a.a.c.a.a aVar = (com.qiyukf.unicorn.f.a.a.a.c.a.a) list2.get(i2);
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(view2.getContext()).inflate(R.layout.ysf_popup_window_card_detail_item, view2, false);
                    LinearLayout linearLayout3 = (LinearLayout) linearLayout2.findViewById(R.id.ysf_card_detail_item);
                    View findViewById2 = linearLayout2.findViewById(R.id.ysf_card_detail_divider);
                    b[] a = aVar.a();
                    int i3 = 0;
                    while (i3 < 2) {
                        view = view2;
                        b bVar = a[i3];
                        aVar.a();
                        b.a(bVar, linearLayout3, 2, false);
                        i3++;
                        view2 = view;
                    }
                    view = view2;
                    if (i2 == list2.size() - 1) {
                        findViewById2.setVisibility(8);
                    }
                    linearLayout.addView(linearLayout2);
                    i2++;
                    view2 = view;
                }
                view = view2;
                if (i == list.size() - 1) {
                    findViewById.setVisibility(8);
                }
                this.a.addView(view);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.c = (c) this.message.getAttachment();
        this.d.a(this.c.c());
        if (this.c.c().a() != null) {
            this.a.setVisibility(0);
            this.b.setText(this.c.c().a().d());
            this.b.setOnClickListener(this);
            return;
        }
        this.a.setVisibility(8);
    }

    public final void c() {
        this.e = new PopupWindow(this.context);
        this.e.setWidth(-1);
        this.e.setHeight((int) (((double) d.b()) * 0.8d));
        this.e.setContentView(LayoutInflater.from(this.context).inflate(R.layout.ysf_popup_window_card_detail, null));
        this.e.setBackgroundDrawable(new ColorDrawable(0));
        this.e.setOutsideTouchable(false);
        this.e.setFocusable(true);
        this.e.setOnDismissListener(this);
        this.e.setAnimationStyle(R.style.ysf_dialog_window_animation_style);
        this.e.showAtLocation(((Activity) this.context).getWindow().getDecorView().findViewById(16908290), 81, 0, 0);
        h.a(((Activity) this.context).getWindow(), 0.3f);
        this.f = this.e.getContentView().findViewById(R.id.ysf_card_detail_placeholder);
        TextView textView = (TextView) this.e.getContentView().findViewById(R.id.ysf_bot_list_title);
        this.g = this.e.getContentView().findViewById(R.id.ysf_bot_list_close);
        LinearLayout linearLayout = (LinearLayout) this.e.getContentView().findViewById(R.id.ysf_card_detail_container);
        textView.setText(this.c.d().a());
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        new a(linearLayout).a(this.c.d().b());
        getAdapter().d().b();
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_card_detail;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ysf_holder_card_layout);
        this.a = findViewById(R.id.ysf_bot_footer_layout);
        this.b = (TextView) findViewById(R.id.ysf_bot_footer_text);
        this.d = new b(linearLayout, true);
    }

    public void onClick(View view) {
        if (view == this.b) {
            a.a(this.c.c().a(), this);
            return;
        }
        if (view == this.g || view == this.f) {
            this.e.dismiss();
        }
    }

    public void onDismiss() {
        h.a(((Activity) this.context).getWindow(), 1.0f);
    }
}
