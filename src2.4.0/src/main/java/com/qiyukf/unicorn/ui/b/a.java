package com.qiyukf.unicorn.ui.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.helper.e;
import com.qiyukf.nim.uikit.session.viewholder.b;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.j.c;
import java.util.List;

public abstract class a<T> extends b {
    protected LinearLayout a;
    private View b;
    private TextView c;
    private View d;
    private LinearLayout e;
    private View f;
    private TextView g;
    private View h;

    private static int a(Context context) {
        UICustomization uICustomization = d.e().uiCustomization;
        return (uICustomization == null || uICustomization.textMsgColorLeft == 0) ? context.getResources().getColor(R.color.ysf_black_2b2b2b) : uICustomization.textMsgColorLeft;
    }

    private static void a(TextView textView) {
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null && uICustomization.textMsgSize > 0.0f) {
            textView.setTextSize(uICustomization.textMsgSize);
        }
    }

    private void a(TextView textView, String str, boolean z) {
        a(textView);
        if (z) {
            c.a(textView, str, (int) textView.getResources().getDimension(R.dimen.ysf_bubble_content_max_width), this.message.getSessionId());
            return;
        }
        Context context = this.context;
        textView.setText(e.a(context, com.qiyukf.nim.uikit.session.emoji.e.a(context, str, this.message.getSessionId())));
    }

    private static int b(Context context) {
        UICustomization uICustomization = d.e().uiCustomization;
        return (uICustomization == null || uICustomization.hyperLinkColorLeft == 0) ? context.getResources().getColor(R.color.ysf_text_link_color_blue) : uICustomization.hyperLinkColorLeft;
    }

    public abstract void a(TextView textView, T t);

    public abstract void a(T t);

    /* Access modifiers changed, original: protected */
    public boolean a() {
        return true;
    }

    public abstract String b();

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        this.a.setBackgroundResource(isReceivedMessage() ? R.drawable.ysf_message_left_bg_no_padding_selector : R.drawable.ysf_message_right_bg_no_padding_selector);
        String b = b();
        if (TextUtils.isEmpty(b)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.d.setVisibility(8);
            a(this.c, b, e());
        }
        List d = d();
        this.e.removeAllViews();
        if (d == null || d.isEmpty()) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            if (this.b.getVisibility() == 0) {
                this.d.setVisibility(0);
            }
            for (int i = 0; i < d.size(); i++) {
                int b2;
                final Object obj = d.get(i);
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_clickable_item, null);
                TextView textView = (TextView) inflate.findViewById(R.id.ysf_clickable_item_text);
                a(textView);
                a(textView, obj);
                if (a()) {
                    textView.setEnabled(true);
                    b2 = b(textView.getContext());
                } else {
                    textView.setEnabled(false);
                    b2 = this.context.getResources().getColor(R.color.ysf_grey_999999);
                }
                textView.setTextColor(b2);
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        a.this.a(obj);
                    }
                });
                this.e.addView(inflate, -1, -2);
            }
        }
        b = c();
        if (TextUtils.isEmpty(b)) {
            this.f.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        a(this.g, com.qiyukf.basesdk.c.c.d.d(b), f());
        if (this.b.getVisibility() == 0 || this.e.getVisibility() == 0) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public abstract String c();

    public abstract List<T> d();

    /* Access modifiers changed, original: protected */
    public boolean e() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean f() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_clickable_list;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (LinearLayout) findViewById(R.id.ysf_clickable_list_content);
        this.b = findViewById(R.id.ysf_clickable_list_header);
        this.c = (TextView) findViewById(R.id.ysf_clickable_list_header_text);
        this.d = findViewById(R.id.ysf_clickable_list_header_divider);
        this.e = (LinearLayout) findViewById(R.id.ysf_clickable_list_container);
        this.f = findViewById(R.id.ysf_clickable_list_footer);
        this.g = (TextView) findViewById(R.id.ysf_clickable_list_footer_text);
        this.h = findViewById(R.id.ysf_clickable_list_footer_divider);
        this.c.setTextColor(a(this.c.getContext()));
        this.c.setLinkTextColor(b(this.c.getContext()));
        this.c.setOnTouchListener(com.qiyukf.nim.uikit.session.helper.a.a());
        this.g.setTextColor(a(this.g.getContext()));
        this.g.setLinkTextColor(b(this.g.getContext()));
        this.g.setOnTouchListener(com.qiyukf.nim.uikit.session.helper.a.a());
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }
}
