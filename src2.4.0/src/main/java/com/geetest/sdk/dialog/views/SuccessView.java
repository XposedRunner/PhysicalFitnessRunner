package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.O0000Oo0.O000000o;
import com.geetest.sdk.O0000Oo0.O00000o0;
import com.geetest.sdk.O00O0Oo0;
import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;
import com.geetest.sdk.views.GT3View;

public class SuccessView extends RelativeLayout {
    private RelativeLayout O000000o;
    private View O00000Oo;
    private boolean O00000o0;

    public SuccessView(Context context, O000000o o000000o, O00000o0 o00000o0) {
        this(context, o000000o, o00000o0, (byte) 0);
    }

    private SuccessView(Context context, O000000o o000000o, O00000o0 o00000o0, byte b) {
        super(context, null, 0);
        this.O00000o0 = false;
        LayoutInflater.from(context).inflate(R.layout.gt3_success_progressdialog, this, true);
        this.O00000Oo = findViewById(R.id.gt3_success_view2);
        this.O000000o = (RelativeLayout) findViewById(R.id.gt3_success_lll);
        TextView textView = (TextView) findViewById(R.id.gt3_success_tvvv);
        ((TextView) findViewById(R.id.gt3_success_tv1)).setText(O00O0o.O0000OOo());
        textView.setText(O00O0o.O0000O0o());
        if (O00O0Oo0.O000000o()) {
            this.O000000o.setVisibility(0);
            this.O00000Oo.setVisibility(0);
        } else {
            this.O000000o.setVisibility(4);
            this.O00000Oo.setVisibility(4);
        }
        GT3View gT3View = (GT3View) findViewById(R.id.gt3_success_iv);
        gT3View.O000000o();
        gT3View.setGtListener(new O000000o(this, o000000o, o00000o0));
    }
}
