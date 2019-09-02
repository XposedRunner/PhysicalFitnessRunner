package com.qiyukf.unicorn.ui.b;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.e.c;

public class b extends com.qiyukf.nim.uikit.session.viewholder.b {
    private View a;
    private TextView b;
    private Button c;
    private TextView d;

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        c cVar = (c) this.message.getAttachment();
        boolean a = cVar.a();
        int i = 0;
        this.a.setVisibility(a ? 8 : 0);
        TextView textView = this.d;
        if (!a) {
            i = 8;
        }
        textView.setVisibility(i);
        if (a) {
            this.d.setText(cVar.a(this.context));
            this.d.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        this.b.setText(cVar.a(this.context));
        this.c.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (com.qiyukf.unicorn.b.a().b() != null) {
                    com.qiyukf.unicorn.b.a();
                } else {
                    d.g().c().a(b.this.context, b.this.message);
                }
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_evaluation;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = this.view.findViewById(R.id.ysf_message_item_evaluation_invitation_layout);
        this.b = (TextView) this.view.findViewById(R.id.ysf_message_item_evaluation_invitation);
        this.c = (Button) this.view.findViewById(R.id.ysf_btn_message_item_evaluation);
        this.d = (TextView) this.view.findViewById(R.id.ysf_message_item_evaluation_thanks);
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.tipsTextSize > 0.0f) {
                this.d.setTextSize(uICustomization.tipsTextSize);
            }
            if (uICustomization.tipsTextColor != 0) {
                this.d.setTextColor(uICustomization.tipsTextColor);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean isMiddleItem() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean showAvatar() {
        return false;
    }
}
