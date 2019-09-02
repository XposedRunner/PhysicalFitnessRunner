package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.O00O0O0o;
import com.geetest.sdk.O00O0Oo0;
import com.geetest.sdk.O00O0o;
import com.geetest.sdk.R;
import com.geetest.sdk.views.GT3GifView;

public class LoadingView extends RelativeLayout {
    private RelativeLayout O000000o;
    private GT3GifView O00000Oo;
    private View O00000o0;

    public LoadingView(Context context) {
        this(context, null, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.gt3_wait_progressdialog, this, true);
        this.O000000o = (RelativeLayout) findViewById(R.id.gt3_wait_ll);
        this.O00000Oo = (GT3GifView) findViewById(R.id.gt3_wait_iv);
        this.O00000Oo.O000000o();
        GT3GifView gT3GifView = this.O00000Oo;
        O00O0O0o o00O0O0o = new O00O0O0o();
        gT3GifView.setGifResource(O00O0O0o.O000000o());
        TextView textView = (TextView) findViewById(R.id.gt3_wait_tvvv);
        ((TextView) findViewById(R.id.gt3_wait_tv2)).setText(O00O0o.O00000oo());
        textView.setText(O00O0o.O0000O0o());
        this.O00000o0 = findViewById(R.id.gt3_wait_view1);
        if (O00O0Oo0.O000000o()) {
            this.O000000o.setVisibility(0);
            this.O00000o0.setVisibility(0);
            return;
        }
        this.O000000o.setVisibility(4);
        this.O00000o0.setVisibility(4);
    }
}
