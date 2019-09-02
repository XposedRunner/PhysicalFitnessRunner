package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.O0000Oo0.O000000o;
import com.geetest.sdk.O0000Oo0.O00000Oo;
import com.geetest.sdk.O00O0Oo0;
import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;

public class FailedView extends RelativeLayout {
    private RelativeLayout O000000o;
    private View O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;

    public FailedView(Context context, GT3ErrorBean gT3ErrorBean, O000000o o000000o, O00000Oo o00000Oo) {
        this(context, gT3ErrorBean, o000000o, o00000Oo, (byte) 0);
    }

    private FailedView(Context context, GT3ErrorBean gT3ErrorBean, O000000o o000000o, O00000Oo o00000Oo, byte b) {
        super(context, null, 0);
        LayoutInflater.from(context).inflate(R.layout.gt3_overtime_progressdialog, this, true);
        this.O00000Oo = findViewById(R.id.gt3_ot_view3);
        this.O000000o = (RelativeLayout) findViewById(R.id.gt3_ot_llll);
        this.O00000o0 = (TextView) findViewById(R.id.tv_test_geetest_cord);
        this.O00000o = (TextView) findViewById(R.id.gt3_ot_tv1);
        if (!TextUtils.isEmpty(gT3ErrorBean.errorCode)) {
            this.O00000o0.setText(gT3ErrorBean.errorCode);
        }
        if (TextUtils.isEmpty(gT3ErrorBean.errorCode) || !gT3ErrorBean.errorCode.startsWith("_") || TextUtils.isEmpty(gT3ErrorBean.errorDesc)) {
            this.O00000o.setText(O00O0o.O0000Oo0());
        } else {
            this.O00000o.setText(gT3ErrorBean.errorDesc);
        }
        ((TextView) findViewById(R.id.gt3_ot_tvvv)).setText(O00O0o.O0000O0o());
        if (O00O0Oo0.O000000o()) {
            this.O000000o.setVisibility(0);
            this.O00000Oo.setVisibility(0);
        } else {
            this.O000000o.setVisibility(4);
            this.O00000Oo.setVisibility(4);
        }
        o000000o.postDelayed(o00000Oo, 2000);
    }
}
