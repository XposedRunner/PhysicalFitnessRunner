package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import org.xutils.common.util.DensityUtil;

/* compiled from: MyConfirmDialog */
public class O0000Oo {
    private Context O000000o;
    private Dialog O00000Oo;
    private TextView O00000o;
    private LinearLayout O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private View O0000OOo;
    private LinearLayout O0000Oo;
    private View O0000Oo0;

    public O0000Oo(Context context) {
        this.O000000o = context;
    }

    public O0000Oo O000000o() {
        if (this.O000000o != null) {
            View inflate = LayoutInflater.from(this.O000000o).inflate(R.layout.view_confirm_dialog, null);
            this.O00000o0 = (LinearLayout) inflate.findViewById(R.id.lLayout_bg);
            this.O00000o = (TextView) inflate.findViewById(R.id.tv_title);
            this.O00000oO = (TextView) inflate.findViewById(R.id.tv_msg);
            this.O00000oo = (TextView) inflate.findViewById(R.id.tv_neg);
            this.O0000O0o = (TextView) inflate.findViewById(R.id.tv_pos);
            this.O0000OOo = inflate.findViewById(R.id.v_line_1);
            this.O0000Oo0 = inflate.findViewById(R.id.v_line_2);
            this.O0000Oo = (LinearLayout) inflate.findViewById(R.id.lin_btn);
            this.O00000Oo = new Dialog(this.O000000o, R.style.AlertDialogStyle);
            this.O00000Oo.setContentView(inflate);
            this.O00000o0.setLayoutParams(new LayoutParams((int) (((double) DensityUtil.getScreenWidth()) * 0.746d), -2));
        }
        return this;
    }

    public O0000Oo O000000o(int i) {
        this.O00000o.setVisibility(0);
        this.O00000o.setText(i);
        return this;
    }

    public O0000Oo O000000o(int i, int i2, OnClickListener onClickListener) {
        return O000000o(this.O000000o.getString(i), i2, onClickListener);
    }

    public O0000Oo O000000o(int i, OnClickListener onClickListener) {
        return O000000o(i, -1, onClickListener);
    }

    public O0000Oo O000000o(@Nullable OnCancelListener onCancelListener) {
        this.O00000Oo.setOnCancelListener(onCancelListener);
        return this;
    }

    public O0000Oo O000000o(@Nullable OnDismissListener onDismissListener) {
        this.O00000Oo.setOnDismissListener(onDismissListener);
        return this;
    }

    public O0000Oo O000000o(String str) {
        this.O00000o.setVisibility(0);
        this.O00000o.setText(str);
        return this;
    }

    public O0000Oo O000000o(String str, int i, final OnClickListener onClickListener) {
        this.O0000Oo.setVisibility(0);
        this.O0000OOo.setVisibility(0);
        this.O00000oo.setVisibility(0);
        if (i != -1) {
            this.O00000oo.setTextColor(ContextCompat.getColor(this.O000000o, i));
        }
        this.O00000oo.setText(str);
        this.O00000oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O0000Oo.this.O00000Oo.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        return this;
    }

    public O0000Oo O000000o(String str, OnClickListener onClickListener) {
        return O000000o(str, -1, onClickListener);
    }

    public O0000Oo O000000o(boolean z) {
        this.O00000Oo.setCancelable(z);
        return this;
    }

    public O0000Oo O00000Oo(int i) {
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText(i);
        return this;
    }

    public O0000Oo O00000Oo(int i, OnClickListener onClickListener) {
        return O00000Oo(this.O000000o.getString(i), onClickListener);
    }

    public O0000Oo O00000Oo(String str) {
        this.O00000oO.setVisibility(0);
        this.O00000oO.setText(str);
        return this;
    }

    public O0000Oo O00000Oo(String str, final OnClickListener onClickListener) {
        this.O0000Oo0.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        this.O0000O0o.setText(str);
        this.O0000O0o.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O0000Oo.this.O00000Oo.dismiss();
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        return this;
    }

    public O0000Oo O00000Oo(boolean z) {
        this.O00000Oo.setCanceledOnTouchOutside(z);
        return this;
    }

    public void O00000Oo() {
        if (!(this.O000000o instanceof Activity) || !((Activity) this.O000000o).isFinishing()) {
            this.O00000Oo.show();
        }
    }

    public void O00000o() {
        if (this.O00000Oo != null) {
            this.O00000Oo.cancel();
        }
    }

    public void O00000o0() {
        this.O00000Oo.dismiss();
    }

    public boolean O00000oO() {
        return this.O00000Oo.isShowing();
    }
}
