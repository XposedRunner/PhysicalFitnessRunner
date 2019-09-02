package com.qiyukf.unicorn.widget.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.unicorn.R;

public final class f extends Dialog {
    private ProgressBar a;
    private TextView b;
    private Handler c;

    public f(Context context) {
        super(context, R.style.ysf_dialog_default_style);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ysf_progress_dialog, null);
        this.a = (ProgressBar) inflate.findViewById(R.id.ysf_progress_dialog_progress);
        this.b = (TextView) inflate.findViewById(R.id.ysf_progress_dialog_message);
        setContentView(inflate);
        setCancelable(false);
    }

    public final void a() {
        this.a.setVisibility(8);
    }

    public final void a(String str) {
        this.b.setText(str);
    }

    public final void b() {
        if (!isShowing()) {
            show();
        }
        if (this.c == null) {
            this.c = new Handler(Looper.getMainLooper());
        }
        this.c.postDelayed(new Runnable() {
            public final void run() {
                if (f.this.isShowing()) {
                    f.this.cancel();
                }
            }
        }, 1000);
    }
}
