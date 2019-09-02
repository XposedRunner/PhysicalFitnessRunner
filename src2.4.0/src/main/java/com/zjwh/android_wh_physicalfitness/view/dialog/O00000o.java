package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.O000000o;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gf;
import defpackage.gj;
import defpackage.gk;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.DensityUtil;

/* compiled from: CodeDialog */
public class O00000o {
    private Context O000000o;
    private Dialog O00000Oo;
    private TextView O00000o;
    private LinearLayout O00000o0;
    private EditText O00000oO;
    private Button O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;
    private View O0000Oo;
    private View O0000Oo0;
    private LinearLayout O0000OoO;
    private O00OOo O0000Ooo;

    public O00000o(Context context) {
        this.O000000o = context;
    }

    private void O00000Oo(String str) {
        this.O00000oo.setText("获取中...");
        this.O00000oo.setEnabled(false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gk.O0000Oo);
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(gf.O0000o00);
        str = stringBuilder.toString();
        gj gjVar = new gj(str);
        Context context = this.O000000o;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(O000000o.O0000O0o);
        stringBuilder2.append(str);
        gjVar.setBodyContent(O00Oo0.O000000o(context, stringBuilder2.toString()));
        HttpUtil.postOp(this.O000000o.getApplicationContext(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                O00000o.this.O00000oo.setText(R.string.txt_get_ver_code);
                O00000o.this.O00000oo.setEnabled(true);
                O00Oo00.O000000o(responseError.getMessage());
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!((Activity) O00000o.this.O000000o).isFinishing()) {
                    O00000o.this.O0000Ooo = new O00OOo((Activity) O00000o.this.O000000o, 180000, 1000, O00000o.this.O00000oo, null);
                    O00000o.this.O0000Ooo.O000000o(ContextCompat.getColor(O00000o.this.O000000o, R.color.text_color_hint), ContextCompat.getColor(O00000o.this.O000000o, R.color.sport_green));
                    O00000o.this.O0000Ooo.O00000Oo(R.drawable.shape_corner_stroke_gray, R.drawable.shape_corner_stroke_green);
                    O00000o.this.O0000Ooo.start();
                }
            }
        });
    }

    public O00000o O000000o() {
        View inflate = LayoutInflater.from(this.O000000o).inflate(R.layout.view_code_dialog, null);
        this.O00000o0 = (LinearLayout) inflate.findViewById(R.id.lLayout_bg);
        this.O00000o = (TextView) inflate.findViewById(R.id.tv_title);
        this.O00000oO = (EditText) inflate.findViewById(R.id.edtCode);
        this.O00000oo = (Button) inflate.findViewById(R.id.btnCode);
        this.O0000O0o = (TextView) inflate.findViewById(R.id.tv_neg);
        this.O0000OOo = (TextView) inflate.findViewById(R.id.tv_pos);
        this.O0000Oo0 = inflate.findViewById(R.id.v_line_1);
        this.O0000Oo = inflate.findViewById(R.id.v_line_2);
        this.O0000OoO = (LinearLayout) inflate.findViewById(R.id.lin_btn);
        this.O00000Oo = new Dialog(this.O000000o, R.style.AlertDialogStyle);
        this.O00000Oo.setContentView(inflate);
        this.O00000Oo.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (O00000o.this.O0000Ooo != null) {
                    O00000o.this.O0000Ooo.cancel();
                    O00000o.this.O0000Ooo = null;
                }
            }
        });
        this.O00000oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                UserInfo O00000o0 = O00Oo0.O00000o0();
                if (O00000o0 != null) {
                    O00000o.this.O00000Oo(O00000o0.getUsername());
                }
            }
        });
        this.O00000o0.setLayoutParams(new LayoutParams((int) (((double) DensityUtil.getScreenWidth()) * 0.746d), -2));
        return this;
    }

    public O00000o O000000o(int i) {
        this.O00000o.setVisibility(0);
        this.O00000o.setText(i);
        return this;
    }

    public O00000o O000000o(int i, int i2, OnClickListener onClickListener) {
        return O000000o(this.O000000o.getString(i), i2, onClickListener);
    }

    public O00000o O000000o(int i, OnClickListener onClickListener) {
        return O000000o(i, -1, onClickListener);
    }

    public O00000o O000000o(String str) {
        this.O00000o.setVisibility(0);
        this.O00000o.setText(str);
        return this;
    }

    public O00000o O000000o(String str, int i, final OnClickListener onClickListener) {
        this.O0000OoO.setVisibility(0);
        this.O0000Oo0.setVisibility(0);
        this.O0000O0o.setVisibility(0);
        if (i != -1) {
            this.O0000O0o.setTextColor(ContextCompat.getColor(this.O000000o, i));
        }
        this.O0000O0o.setText(str);
        this.O0000O0o.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (O00000o.this.O00000Oo != null) {
                    O00000o.this.O00000Oo.dismiss();
                }
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        return this;
    }

    public O00000o O000000o(String str, OnClickListener onClickListener) {
        return O000000o(str, -1, onClickListener);
    }

    public O00000o O000000o(boolean z) {
        this.O00000Oo.setCancelable(z);
        return this;
    }

    public O00000o O00000Oo(int i, OnClickListener onClickListener) {
        return O00000Oo(this.O000000o.getString(i), onClickListener);
    }

    public O00000o O00000Oo(String str, final OnClickListener onClickListener) {
        this.O0000Oo.setVisibility(0);
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setText(str);
        this.O0000OOo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (onClickListener != null) {
                    String trim = O00000o.this.O00000oO.getText().toString().trim();
                    if (TextUtils.isEmpty(trim)) {
                        O00Oo00.O000000o((int) R.string.msg_invalid_ver_code);
                    } else {
                        view.setTag(trim);
                        onClickListener.onClick(view);
                    }
                }
            }
        });
        return this;
    }

    public O00000o O00000Oo(boolean z) {
        this.O00000Oo.setCanceledOnTouchOutside(z);
        return this;
    }

    public void O00000Oo() {
        if (!(((this.O000000o instanceof Activity) && ((Activity) this.O000000o).isFinishing()) || this.O00000Oo == null)) {
            this.O00000Oo.show();
        }
    }

    public void O00000o() {
        if (this.O00000Oo != null) {
            this.O00000Oo.cancel();
        }
    }

    public void O00000o0() {
        if (this.O00000Oo != null) {
            this.O00000Oo.dismiss();
        }
    }

    public boolean O00000oO() {
        return this.O00000Oo.isShowing();
    }
}
