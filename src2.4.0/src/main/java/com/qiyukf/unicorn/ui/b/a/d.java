package com.qiyukf.unicorn.ui.b.a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.nim.uikit.a;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.b;

public class d extends e {
    private ImageView a;
    private TextView b;
    private TextView c;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        final b bVar = (b) this.message.getAttachment();
        if (TextUtils.isEmpty(bVar.c())) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
            a.a(bVar.c(), this.a, (int) this.context.getResources().getDimension(R.dimen.ysf_bubble_max_width), com.qiyukf.basesdk.c.d.d.a(92.0f));
        }
        this.b.setText(bVar.d());
        this.c.setText(bVar.e().a());
        this.c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                d.this.a(bVar.e().b());
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_activity;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (ImageView) findViewById(R.id.ysf_iv_activity_img);
        this.b = (TextView) findViewById(R.id.ysf_tv_activity_label);
        this.c = (TextView) findViewById(R.id.ysf_btn_activity_action);
    }
}
