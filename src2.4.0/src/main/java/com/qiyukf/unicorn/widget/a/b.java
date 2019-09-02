package com.qiyukf.unicorn.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qiyukf.unicorn.R;

abstract class b<T extends b> {
    protected Context a;
    protected a b;
    protected com.qiyukf.unicorn.widget.a.g.a c;

    protected static class a extends Dialog {
        ViewGroup a;
        TextView b;
        TextView c;

        public a(@NonNull Context context) {
            super(context, R.style.ysf_dialog_default_style);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ysf_dialog_base, null);
            this.a = (ViewGroup) inflate.findViewById(R.id.ysf_dialog_content);
            this.b = (TextView) inflate.findViewById(R.id.ysf_tv_dialog_title);
            this.c = (TextView) inflate.findViewById(R.id.ysf_tv_dialog_message);
            setContentView(inflate);
        }
    }

    public b(Context context) {
        this.a = context;
        this.b = new a(context);
    }

    public final T a(com.qiyukf.unicorn.widget.a.g.a aVar) {
        this.c = aVar;
        return this;
    }

    public final T a(CharSequence charSequence) {
        this.b.b.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.b.b.setText(charSequence);
        return this;
    }

    public final T a(boolean z) {
        this.b.setCancelable(z);
        return this;
    }

    public void a() {
        this.b.show();
    }

    public final T b(CharSequence charSequence) {
        this.b.c.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.b.c.setText(charSequence);
        return this;
    }
}
