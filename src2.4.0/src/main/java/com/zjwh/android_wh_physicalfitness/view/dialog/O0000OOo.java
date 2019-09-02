package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import defpackage.O00Oo;
import defpackage.O00Oo00;
import defpackage.lc;

/* compiled from: HomePageActivityDialog */
public class O0000OOo extends Dialog {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    private TextView O00000o;
    private ImageView O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private ImageView O0000O0o;
    private int O0000OOo;

    public O0000OOo(@NonNull Context context, int i) {
        super(context, R.style.BaseDialog);
        if (i == 0) {
            setContentView(R.layout.layout_home_page_dialog);
        } else if (i == 1) {
            setContentView(R.layout.layout_home_page_irregular_dialog);
        }
        setCancelable(false);
        this.O0000OOo = i;
        O000000o(i);
    }

    private void O000000o(int i) {
        this.O00000o0 = (ImageView) findViewById(R.id.iv);
        this.O0000O0o = (ImageView) findViewById(R.id.iv_cancel);
        if (i == 0) {
            this.O00000o = (TextView) findViewById(R.id.tv_title);
            this.O00000oO = (TextView) findViewById(R.id.tv_tip);
            this.O00000oo = (TextView) findViewById(R.id.tv_prize_detail);
        }
    }

    public O0000OOo O000000o(final OnClickListener onClickListener) {
        if (this.O0000OOo == 0) {
            if (this.O00000oo != null) {
                this.O00000oo.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        O0000OOo.this.dismiss();
                        if (onClickListener != null) {
                            onClickListener.onClick(view);
                        }
                    }
                });
            }
        } else if (this.O0000OOo == 1 && this.O00000o0 != null) {
            this.O00000o0.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    O0000OOo.this.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        }
        return this;
    }

    public O0000OOo O000000o(String str) {
        if (this.O00000o != null) {
            this.O00000o.setText(str);
        }
        return this;
    }

    public O0000OOo O00000Oo(final OnClickListener onClickListener) {
        if (this.O0000O0o != null) {
            this.O0000O0o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    O0000OOo.this.dismiss();
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            });
        }
        return this;
    }

    public O0000OOo O00000Oo(String str) {
        if (this.O00000oO != null) {
            this.O00000oO.setText(str);
        }
        return this;
    }

    public O0000OOo O00000o(String str) {
        if (this.O00000o0 != null) {
            O00Oo00 O000000o = O00Oo.O00000o0(getContext()).O000000o(str);
            if (this.O0000OOo == 0) {
                O000000o.O00000oO(R.drawable.shape_dialog_corner_window).O0000O0o((int) R.drawable.shape_dialog_corner_window).O000000o(new lc(getContext()));
            } else if (this.O0000OOo == 1) {
                O000000o.O00000oO(R.color.window_background);
            }
            O000000o.O000000o(this.O00000o0);
        }
        return this;
    }

    public O0000OOo O00000o0(String str) {
        if (this.O00000oo != null) {
            this.O00000oo.setText(str);
        }
        return this;
    }
}
