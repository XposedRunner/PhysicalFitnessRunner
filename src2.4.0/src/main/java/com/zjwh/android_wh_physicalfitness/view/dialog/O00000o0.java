package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.request.QCompleteUserInfo;
import defpackage.gf;
import org.xutils.common.util.DensityUtil;

/* compiled from: BindAccountDialog */
public class O00000o0 {
    static final /* synthetic */ boolean O000000o = true;
    private Context O00000Oo;
    private View O00000o;
    private Dialog O00000o0;
    private TextView O00000oO;
    private ImageView O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private TextView O0000OoO;
    private TextView O0000Ooo;
    private QCompleteUserInfo O0000o0;
    private Button O0000o00;

    public O00000o0(Context context, QCompleteUserInfo qCompleteUserInfo) {
        this.O00000Oo = context;
        this.O0000o0 = qCompleteUserInfo;
    }

    private void O00000o() {
        if (this.O0000o0 != null) {
            this.O0000O0o.setText(this.O0000o0.getCampusName());
            this.O0000Oo0.setText(this.O0000o0.getDepart());
            this.O0000Oo.setText(this.O0000o0.getName());
            this.O0000OoO.setText(this.O0000o0.getGender() == gf.O0000o0 ? R.string.sex_female : R.string.sex_male);
            this.O0000OOo.setText(this.O0000o0.getCampusId());
            this.O0000Ooo.setText(String.valueOf(this.O0000o0.getEnrollmentYear()));
            if (TextUtils.isEmpty(this.O0000o0.getGradeClass())) {
                this.O00000o.setVisibility(8);
            } else {
                this.O00000oO.setText(this.O0000o0.getGradeClass());
                this.O00000o.setVisibility(0);
            }
        }
        this.O00000oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O00000o0.this.O00000o0();
            }
        });
    }

    public O00000o0 O000000o() {
        View inflate = LayoutInflater.from(this.O00000Oo).inflate(R.layout.layout_bindaccount_dialog, null);
        this.O0000O0o = (TextView) inflate.findViewById(R.id.tv_dg_school);
        this.O0000OOo = (TextView) inflate.findViewById(R.id.tv_dg_school_num);
        this.O0000Oo0 = (TextView) inflate.findViewById(R.id.tv_dg_depart);
        this.O0000Oo = (TextView) inflate.findViewById(R.id.tv_dg_name);
        this.O0000OoO = (TextView) inflate.findViewById(R.id.tv_dg_sex);
        this.O0000Ooo = (TextView) inflate.findViewById(R.id.tv_dg_enter_year);
        this.O0000o00 = (Button) inflate.findViewById(R.id.btn_dg_submit);
        this.O00000oo = (ImageView) inflate.findViewById(R.id.iv_dg_cancel);
        this.O00000o = inflate.findViewById(R.id.classLayout);
        this.O00000oO = (TextView) inflate.findViewById(R.id.tv_dg_class);
        this.O00000o0 = new Dialog(this.O00000Oo, R.style.ActionSheetDialogStyle3);
        this.O00000o0.setContentView(inflate);
        int screenHeight = (int) (((double) DensityUtil.getScreenHeight()) * 0.165d);
        int screenWidth = (int) (((double) DensityUtil.getScreenWidth()) * 0.8d);
        Window window = this.O00000o0.getWindow();
        if (O000000o || window != null) {
            LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = screenHeight;
            attributes.width = screenWidth;
            window.setGravity(49);
            window.setAttributes(attributes);
            this.O00000o0.setCancelable(false);
            this.O00000o0.setCanceledOnTouchOutside(false);
            return this;
        }
        throw new AssertionError();
    }

    public void O000000o(OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.O0000o00.setOnClickListener(onClickListener);
        }
    }

    public void O000000o(boolean z) {
        if (z) {
            this.O0000o00.setBackgroundResource(R.drawable.shape_option);
            this.O0000o00.setEnabled(true);
            this.O0000o00.setText(R.string.finish_bind);
            this.O00000oo.setEnabled(true);
            return;
        }
        this.O0000o00.setBackgroundResource(R.drawable.shape_non_option);
        this.O0000o00.setEnabled(false);
        this.O0000o00.setText(R.string.optioning);
        this.O00000oo.setEnabled(false);
    }

    public void O00000Oo() {
        O00000o();
        if (this.O00000o0 != null) {
            this.O00000o0.show();
        }
    }

    public void O00000o0() {
        if (this.O00000o0 != null && this.O00000o0.isShowing()) {
            this.O00000o0.cancel();
        }
    }
}
