package com.qiyukf.unicorn.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.unicorn.R;

public final class a extends Dialog implements OnClickListener {
    private View a;
    private View b;
    private TextView c;
    private LinearLayout d;
    private com.qiyukf.unicorn.widget.a.g.a e;
    private int f;

    public a(@NonNull Context context, int i) {
        super(context, i == 17 ? R.style.ysf_dialog_default_style : R.style.ysf_popup_dialog_style);
        this.f = i;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ysf_dialog_category, null);
        if (i == 17) {
            inflate.setBackgroundResource(R.drawable.ysf_dialog_bg);
        } else {
            inflate.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ysf_white));
        }
        this.a = inflate.findViewById(R.id.ysf_dialog_category_title_layout);
        this.b = inflate.findViewById(R.id.ysf_dialog_category_close);
        this.c = (TextView) inflate.findViewById(R.id.ysf_dialog_category_title);
        this.d = (LinearLayout) inflate.findViewById(R.id.ysf_dialog_category_item_container);
        this.b.setOnClickListener(this);
        setContentView(inflate);
    }

    public final void a(com.qiyukf.unicorn.widget.a.g.a aVar) {
        this.e = aVar;
    }

    public final void a(String[] strArr) {
        this.d.removeAllViews();
        int i = 0;
        while (i < strArr.length) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ysf_dialog_category_item, this.d, false);
            TextView textView = (TextView) inflate.findViewById(R.id.ysf_dialog_category_item_name);
            View findViewById = inflate.findViewById(R.id.ysf_dialog_category_item_divider);
            textView.setText(strArr[i]);
            findViewById.setVisibility(i == strArr.length + -1 ? 8 : 0);
            inflate.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.cancel();
                    if (a.this.e != null) {
                        a.this.e.a(i);
                    }
                }
            });
            this.d.addView(inflate);
            i++;
        }
    }

    public final void onClick(View view) {
        if (view == this.b) {
            cancel();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = this.f == 17 ? getContext().getResources().getDimensionPixelSize(R.dimen.ysf_dialog_width) : -1;
        attributes.height = -2;
        attributes.gravity = this.f;
        getWindow().setAttributes(attributes);
    }

    public final void setTitle(CharSequence charSequence) {
        this.a.setVisibility(charSequence == null ? 8 : 0);
        this.c.setText(charSequence);
    }
}
