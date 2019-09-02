package com.qiyukf.unicorn.widget.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.qiyukf.unicorn.R;

final class c extends b<c> implements OnClickListener {
    private Button d;
    private Button e;

    public c(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ysf_dialog_content_double_btn, null);
        this.d = (Button) inflate.findViewById(R.id.ysf_dialog_btn_left);
        this.e = (Button) inflate.findViewById(R.id.ysf_dialog_btn_right);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.b.a.removeAllViews();
        this.b.a.addView(inflate, -1, -2);
    }

    public final c a(CharSequence charSequence, CharSequence charSequence2) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.d.setText(charSequence);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            this.e.setText(charSequence2);
        }
        return this;
    }

    public final void onClick(View view) {
        this.b.cancel();
        if (this.c != null) {
            this.c.a(view == this.d ? 0 : 1);
        }
    }
}
