package com.qiyukf.unicorn.ui.b.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.g;
import com.qiyukf.unicorn.f.a.a.a.g.b;
import java.util.List;

public class k extends e implements OnClickListener {
    private TextView a;
    private TextView b;
    private LinearLayout c;
    private View d;
    private View e;
    private TextView f;

    private void a(List<b> list, int i) {
        this.c.removeAllViews();
        i = Math.min(list.size(), Math.max(0, i));
        int i2 = 0;
        while (i2 < i) {
            b bVar = (b) list.get(i2);
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_logistic_item, this.c, false);
            View findViewById = inflate.findViewById(R.id.ysf_iv_logistic_icon);
            View findViewById2 = inflate.findViewById(R.id.ysf_logistic_line);
            TextView textView = (TextView) inflate.findViewById(R.id.ysf_tv_logistic_transport_message);
            TextView textView2 = (TextView) inflate.findViewById(R.id.ysf_tv_logistic_transport_time);
            textView.setText(bVar.a());
            textView2.setText(bVar.b());
            boolean z = i2 == 0;
            findViewById.setSelected(z);
            findViewById2.setPadding(0, z ? d.a(20.0f) : 0, 0, 0);
            textView.setSelected(z);
            textView2.setSelected(z);
            this.c.addView(inflate);
            i2++;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        List e;
        final g gVar = (g) this.message.getAttachment();
        this.a.setText(gVar.c());
        this.b.setText(gVar.d().a());
        int i = 3;
        if (gVar.e().size() <= 3 || gVar.g()) {
            this.d.setVisibility(8);
            e = gVar.e();
            i = gVar.e().size();
        } else {
            this.d.setVisibility(0);
            e = gVar.e();
        }
        a(e, i);
        if (gVar.f() != null) {
            this.e.setVisibility(0);
            this.f.setText(gVar.f().a());
            this.f.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    k.this.a(gVar.f().b());
                }
            });
            return;
        }
        this.e.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_logistic;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_logistic_label);
        this.b = (TextView) findViewById(R.id.ysf_tv_logistic_title);
        this.c = (LinearLayout) findViewById(R.id.ysf_logistic_transport_info);
        this.d = findViewById(R.id.ysf_logistic_more_layout);
        this.e = findViewById(R.id.ysf_bot_footer_layout);
        this.f = (TextView) findViewById(R.id.ysf_bot_footer_text);
        this.d.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == this.d) {
            g gVar = (g) this.message.getAttachment();
            gVar.h();
            this.d.setVisibility(8);
            a(gVar.e(), gVar.e().size());
        }
    }
}
