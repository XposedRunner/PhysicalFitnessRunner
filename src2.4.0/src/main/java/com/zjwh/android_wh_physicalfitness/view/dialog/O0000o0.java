package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import java.lang.ref.WeakReference;

/* compiled from: UpdateDialog */
public class O0000o0 {
    private WeakReference<Context> O000000o;
    private Dialog O00000Oo;
    private TextView O00000o;
    private LinearLayout O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private ProgressBar O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private RelativeLayout O0000OoO;
    private LinearLayout O0000Ooo;

    public O0000o0(Context context) {
        this.O000000o = new WeakReference(context);
    }

    public O0000o0 O000000o() {
        View inflate = LayoutInflater.from((Context) this.O000000o.get()).inflate(R.layout.view_update_dialog, null);
        this.O00000o0 = (LinearLayout) inflate.findViewById(R.id.lLayout_bg);
        this.O00000o = (TextView) inflate.findViewById(R.id.tv_title);
        this.O00000oO = (TextView) inflate.findViewById(R.id.tv_msg);
        this.O00000oo = (TextView) inflate.findViewById(R.id.tv_size);
        this.O0000O0o = (TextView) inflate.findViewById(R.id.tv_percent);
        this.O0000OOo = (ProgressBar) inflate.findViewById(R.id.pb_percent);
        this.O0000Oo0 = (TextView) inflate.findViewById(R.id.tv_neg);
        this.O0000Oo = (TextView) inflate.findViewById(R.id.tv_pos);
        this.O0000OoO = (RelativeLayout) inflate.findViewById(R.id.rel_load);
        this.O0000Ooo = (LinearLayout) inflate.findViewById(R.id.lin_btn);
        this.O00000Oo = new Dialog((Context) this.O000000o.get(), R.style.AlertDialogStyle);
        this.O00000Oo.setContentView(inflate);
        this.O00000Oo.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (O0000o0.this.O00000o0 != null) {
                    O0000o0.this.O00000o0.removeAllViews();
                }
            }
        });
        return this;
    }

    public O0000o0 O000000o(int i) {
        this.O00000o.setVisibility(0);
        this.O00000o.setText(i);
        return this;
    }

    public O0000o0 O000000o(int i, int i2, final OnClickListener onClickListener) {
        this.O0000Ooo.setVisibility(0);
        this.O0000Oo0.setTextColor(ContextCompat.getColor((Context) this.O000000o.get(), i2));
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo0.setText(i);
        this.O0000Oo0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                O0000o0.this.O00000Oo.dismiss();
            }
        });
        return this;
    }

    public O0000o0 O000000o(int i, final OnClickListener onClickListener) {
        this.O0000Ooo.setVisibility(0);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo0.setText(i);
        this.O0000Oo0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                O0000o0.this.O00000Oo.dismiss();
            }
        });
        return this;
    }

    public O0000o0 O000000o(String str) {
        this.O00000o.setVisibility(0);
        this.O00000o.setText(str);
        return this;
    }

    public O0000o0 O000000o(String str, int i, final OnClickListener onClickListener) {
        this.O0000Ooo.setVisibility(0);
        this.O0000Oo0.setTextColor(ContextCompat.getColor((Context) this.O000000o.get(), i));
        this.O0000Oo0.setBackgroundResource(R.drawable.shape_dialog_detail_bg);
        this.O0000Oo0.setVisibility(0);
        this.O0000Oo0.setText(str);
        this.O0000Oo0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                onClickListener.onClick(view);
                O0000o0.this.O00000Oo.dismiss();
            }
        });
        return this;
    }

    public O0000o0 O000000o(String str, final OnClickListener onClickListener) {
        this.O0000Oo.setVisibility(0);
        this.O0000Oo.setText(str);
        this.O0000Oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                onClickListener.onClick(view);
                O0000o0.this.O00000Oo.dismiss();
            }
        });
        return this;
    }

    public O0000o0 O000000o(boolean z) {
        this.O00000Oo.setCancelable(z);
        return this;
    }

    public O0000o0 O00000Oo(int i) {
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText(i);
        return this;
    }

    public O0000o0 O00000Oo(int i, final OnClickListener onClickListener) {
        this.O0000Oo.setVisibility(0);
        this.O0000Oo.setText(i);
        this.O0000Oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                onClickListener.onClick(view);
                O0000o0.this.O00000Oo.dismiss();
            }
        });
        return this;
    }

    public O0000o0 O00000Oo(String str) {
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText(str);
        return this;
    }

    public O0000o0 O00000Oo(boolean z) {
        this.O00000Oo.setCanceledOnTouchOutside(z);
        return this;
    }

    public void O00000Oo() {
        if (this.O00000Oo != null) {
            this.O00000Oo.show();
        }
    }

    public boolean O00000o() {
        return this.O00000Oo.isShowing();
    }

    public O0000o0 O00000o0(String str) {
        this.O0000OoO.setVisibility(0);
        this.O00000oo.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        this.O00000oo.setText(String.format("%s %s", new Object[]{((Context) this.O000000o.get()).getString(2131689512), str}));
        this.O0000O0o.setText(String.format(((Context) this.O000000o.get()).getString(R.string.loading), new Object[]{Integer.valueOf(0)}));
        return this;
    }

    public void O00000o0() {
        if (this.O00000Oo != null) {
            this.O00000Oo.cancel();
        }
    }

    public void O00000o0(int i) {
        this.O0000OOo.setProgress(i);
        if (i < 100) {
            this.O0000O0o.setText(String.format(((Context) this.O000000o.get()).getString(R.string.loading), new Object[]{Integer.valueOf(i)}));
            return;
        }
        this.O0000O0o.setText(R.string.load_complete);
    }
}
