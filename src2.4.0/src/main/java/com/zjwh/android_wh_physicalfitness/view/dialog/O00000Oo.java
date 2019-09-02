package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.view.ScrollerNumberPicker;
import java.util.ArrayList;

/* compiled from: ActionPickerDialog */
public class O00000Oo {
    private Context O000000o;
    private Dialog O00000Oo;
    private ScrollerNumberPicker O00000o;
    private TextView O00000o0;
    private TextView O00000oO;
    private TextView O00000oo;
    private Display O0000O0o;
    private Typeface O0000OOo;
    private int O0000Oo = 500;
    private O000000o O0000Oo0;
    private ArrayList<String> O0000OoO = null;
    private int O0000Ooo = 0;
    private int O0000o00 = 0;

    /* compiled from: ActionPickerDialog */
    public interface O000000o {
        void O000000o(int i);
    }

    public O00000Oo(Context context) {
        this.O000000o = context;
        this.O0000O0o = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.O0000OOo = Typeface.createFromAsset(context.getAssets(), "fonts/Impact.ttf");
        this.O0000Oo = (int) (((double) this.O0000O0o.getHeight()) * 0.32d);
    }

    public O00000Oo O000000o() {
        View inflate = LayoutInflater.from(this.O000000o).inflate(R.layout.view_action_picker, null);
        inflate.setMinimumWidth(this.O0000O0o.getWidth());
        this.O00000o0 = (TextView) inflate.findViewById(R.id.txt_title);
        this.O00000o = (ScrollerNumberPicker) inflate.findViewById(R.id.snp_year);
        this.O00000oO = (TextView) inflate.findViewById(R.id.tv_sure);
        this.O00000oo = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.O00000o0.setTypeface(this.O0000OOo, 1);
        this.O00000o0.setHeight((int) (((double) this.O0000Oo) * 0.19d));
        this.O00000Oo = new Dialog(this.O000000o, R.style.ActionSheetDialogStyle2);
        this.O00000Oo.setContentView(inflate);
        Window window = this.O00000Oo.getWindow();
        window.setGravity(83);
        LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = this.O0000Oo;
        window.setAttributes(attributes);
        this.O00000o.setOnSelectListener(new com.zjwh.android_wh_physicalfitness.view.ScrollerNumberPicker.O00000Oo() {
            public void O000000o(int i, String str) {
                O00000Oo.this.O0000Ooo = i;
            }

            public void O00000Oo(int i, String str) {
            }
        });
        this.O00000oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                O00000Oo.this.O00000Oo.dismiss();
            }
        });
        return this;
    }

    public O00000Oo O000000o(int i) {
        this.O00000o0.setVisibility(0);
        this.O00000o0.setText(i);
        return this;
    }

    public O00000Oo O000000o(O000000o o000000o) {
        this.O0000Oo0 = o000000o;
        return this;
    }

    public O00000Oo O000000o(String str) {
        if (!(this.O0000OoO == null || TextUtils.isEmpty(str))) {
            int indexOf = this.O0000OoO.indexOf(str);
            this.O0000o00 = indexOf;
            this.O0000Ooo = indexOf;
            if (this.O0000o00 < 0) {
                this.O0000o00 = 0;
            }
        }
        return this;
    }

    public O00000Oo O000000o(ArrayList<String> arrayList) {
        this.O0000OoO = arrayList;
        return this;
    }

    public O00000Oo O000000o(boolean z) {
        this.O00000Oo.setCancelable(z);
        return this;
    }

    public O00000Oo O00000Oo(boolean z) {
        this.O00000Oo.setCanceledOnTouchOutside(z);
        return this;
    }

    public void O00000Oo() {
        this.O00000o.setData(this.O0000OoO);
        this.O00000o.setDefault(this.O0000o00);
        if (this.O0000Oo0 != null) {
            this.O00000oO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    O00000Oo.this.O0000Oo0.O000000o(O00000Oo.this.O0000Ooo);
                    O00000Oo.this.O00000Oo.dismiss();
                }
            });
        }
        this.O00000Oo.show();
    }
}
