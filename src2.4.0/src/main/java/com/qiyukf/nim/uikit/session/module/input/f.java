package com.qiyukf.nim.uikit.session.module.input;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.module.a;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.OnBotEventListener;
import com.qiyukf.unicorn.api.QuickEntry;
import com.qiyukf.unicorn.api.QuickEntryListener;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.e.c;
import java.util.List;

public final class f {
    private a a;
    private LinearLayout b;
    private LinearLayout c;

    public f(a aVar, LinearLayout linearLayout) {
        this.a = aVar;
        this.b = linearLayout;
    }

    public final void a(List<? extends c> list) {
        if (list != null && !list.isEmpty()) {
            if (this.c == null) {
                this.c = (LinearLayout) LayoutInflater.from(this.a.a).inflate(R.layout.ysf_message_quick_entry_layout, this.b, false);
                this.b.addView(this.c, 0);
            }
            this.c.setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.ysf_message_quick_entry_container);
            linearLayout.removeAllViews();
            int i = 0;
            while (i < list.size()) {
                final c cVar = (c) list.get(i);
                View inflate = LayoutInflater.from(this.a.a).inflate(R.layout.ysf_message_quick_entry_item, linearLayout, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.ysf_quick_entry_icon);
                TextView textView = (TextView) inflate.findViewById(R.id.ysf_quick_entry_text);
                if (!TextUtils.isEmpty(cVar.getIconUrl())) {
                    imageView.setVisibility(0);
                    com.qiyukf.nim.uikit.a.a(cVar.getIconUrl(), imageView);
                }
                textView.setText(cVar.getName());
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (cVar instanceof com.qiyukf.unicorn.f.a.c.a) {
                            com.qiyukf.unicorn.f.a.c.a aVar = (com.qiyukf.unicorn.f.a.c.a) cVar;
                            if (aVar.a() == 1) {
                                if (f.this.a.e.isAllowSendMessage(true)) {
                                    f.this.a.e.sendMessage(MessageBuilder.createTextMessage(f.this.a.c, f.this.a.d, aVar.b()), false);
                                    return;
                                }
                            } else if (aVar.a() == 2) {
                                OnBotEventListener onBotEventListener = d.e().onBotEventListener;
                                if (onBotEventListener != null) {
                                    onBotEventListener.onUrlClick(f.this.a.a, aVar.c());
                                }
                            }
                            return;
                        }
                        if (cVar instanceof QuickEntry) {
                            QuickEntry quickEntry = (QuickEntry) cVar;
                            QuickEntryListener quickEntryListener = d.e().quickEntryListener;
                            if (quickEntryListener != null) {
                                quickEntryListener.onClick(f.this.a.a, f.this.a.c, quickEntry);
                            }
                        }
                    }
                });
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                float f = 10.0f;
                layoutParams.leftMargin = com.qiyukf.basesdk.c.d.d.a(i == 0 ? 10.0f : 5.0f);
                if (i != list.size() - 1) {
                    f = 0.0f;
                }
                layoutParams.rightMargin = com.qiyukf.basesdk.c.d.d.a(f);
                inflate.setLayoutParams(layoutParams);
                linearLayout.addView(inflate);
                i++;
            }
        } else if (this.c != null && this.c.getVisibility() != 8) {
            this.c.setVisibility(8);
        }
    }
}
