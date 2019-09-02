package com.qiyukf.unicorn.ui.b.a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.a.a.a.a.b.b;

public class j extends e {
    private a a;
    private View b;
    private TextView c;

    private static class a {
        private ImageView a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private TextView f;

        public a(View view) {
            this.a = (ImageView) view.findViewById(R.id.ysf_iv_goods_img);
            this.b = (TextView) view.findViewById(R.id.ysf_tv_goods_name);
            this.c = (TextView) view.findViewById(R.id.ysf_tv_goods_sku);
            this.d = (TextView) view.findViewById(R.id.ysf_tv_goods_price);
            this.e = (TextView) view.findViewById(R.id.ysf_tv_goods_count);
            this.f = (TextView) view.findViewById(R.id.ysf_tv_goods_state);
        }

        public final void a(b bVar) {
            int a = d.a(60.0f);
            com.qiyukf.nim.uikit.a.a(bVar.e(), this.a, a, a);
            this.b.setText(bVar.f());
            this.c.setText(bVar.i());
            this.d.setText(bVar.g());
            this.e.setText(bVar.h());
            this.f.setText(bVar.d());
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        final b bVar = (b) this.message.getAttachment();
        this.a.a(bVar);
        if (bVar.j()) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.c.setText(TextUtils.isEmpty(bVar.l()) ? "重新选择" : bVar.l());
            this.c.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    bVar.m().onClick(j.this.context, bVar.k());
                }
            });
            return;
        }
        this.b.setVisibility(8);
        this.c.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_goods;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.b = findViewById(R.id.view_ysf_item_message_goods_line);
        this.c = (TextView) findViewById(R.id.tv_ysf_item_message_goods);
        this.a = new a(findViewById(R.id.ysf_goods_content));
    }
}
