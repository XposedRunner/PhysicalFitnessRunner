package com.qiyukf.unicorn.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.qiyukf.basesdk.c.d.b;
import com.qiyukf.unicorn.R;

public final class d extends Dialog implements OnClickListener {
    private View a;
    private EditText b;
    private Button c;
    private a d;
    private String e;
    private TextWatcher f = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
            d.this.c.setEnabled(d.this.a().length() > 0);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    public interface a {
        void a(String str);
    }

    public d(Context context) {
        super(context, R.style.ysf_dialog_default_style);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ysf_dialog_input_evaluation, new LinearLayout(context), false);
        setContentView(inflate);
        setCancelable(false);
        this.a = inflate.findViewById(R.id.ysf_dialog_input_close);
        this.b = (EditText) inflate.findViewById(R.id.ysf_dialog_input_edit);
        this.c = (Button) inflate.findViewById(R.id.ysf_dialog_input_submit);
        this.a.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.b.addTextChangedListener(this.f);
    }

    private String a() {
        return this.b.getText().toString().trim();
    }

    public final d a(a aVar) {
        this.d = aVar;
        return this;
    }

    public final d a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.e = str;
        this.b.setText(this.e);
        this.b.setHint(str2);
        this.b.setSelection(this.b.length());
        return this;
    }

    public final void cancel() {
        b.b(this.b);
        super.cancel();
    }

    public final void onClick(View view) {
        if (view == this.a) {
            cancel();
            if (!a().equals(this.e)) {
                g.a(getContext(), "确定放弃编辑吗？", false, new com.qiyukf.unicorn.widget.a.g.a() {
                    public final void a(int i) {
                        if (i == 1) {
                            d.this.show();
                        }
                    }
                });
            }
        } else if (view == this.c && this.d != null) {
            this.d.a(a());
            cancel();
        }
    }
}
