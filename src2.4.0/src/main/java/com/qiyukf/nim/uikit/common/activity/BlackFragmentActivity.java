package com.qiyukf.nim.uikit.common.activity;

import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.unicorn.R;

public abstract class BlackFragmentActivity extends BaseFragmentActivity {
    /* Access modifiers changed, original: protected|final */
    public final void e() {
        this.a.setBackgroundResource(R.drawable.ysf_title_bar_bg_black);
        TextView textView = (TextView) findViewById(R.id.ysf_title_bar_title);
        ((ImageView) findViewById(R.id.ysf_title_bar_back_view)).setImageResource(R.drawable.ysf_title_bar_back_icon_white);
        textView.setTextColor(-1);
    }
}
