package com.qiyukf.unicorn.ui.b.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.i;
import com.qiyukf.unicorn.f.a.a.a.i.a;
import com.qiyukf.unicorn.j.c;
import com.qiyukf.unicorn.ui.activity.UrlImagePreviewActivity;
import java.util.ArrayList;

public class l extends e {
    private LinearLayout a;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.a.removeAllViews();
        i iVar = (i) this.message.getAttachment();
        for (int i = 0; i < iVar.c().size(); i++) {
            View view;
            final a aVar = (a) iVar.c().get(i);
            if (aVar.a()) {
                view = (ImageView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_image, this.a, false);
                com.qiyukf.nim.uikit.a.a(aVar.f(), (ImageView) view);
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(aVar.f());
                        UrlImagePreviewActivity.start(l.this.context, arrayList, 0);
                    }
                });
            } else if (aVar.c() || aVar.b()) {
                view = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_button, this.a, false);
                view.setText(aVar.e());
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (aVar.c()) {
                            l.this.a(aVar.g(), aVar.h(), aVar.e());
                        } else {
                            l.this.a(aVar.g());
                        }
                    }
                });
            } else if (aVar.d()) {
                view = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_text, this.a, false);
                c.a(view, aVar.e(), (int) view.getResources().getDimension(R.dimen.ysf_bubble_content_rich_image_max_width), this.message.getSessionId());
                view.setOnTouchListener(com.qiyukf.nim.uikit.session.helper.a.a());
            } else {
                view = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_text, this.a, false);
                view.setText(aVar.e());
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i > 0) {
                layoutParams.setMargins(0, d.a(10.0f), 0, 0);
            }
            this.a.addView(view);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_mix;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (LinearLayout) findViewById(R.id.ysf_message_mix_container);
    }
}
