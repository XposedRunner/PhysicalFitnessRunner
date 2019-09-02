package com.qiyukf.nim.uikit.session.viewholder;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.emoji.e;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;

public class f extends b {
    private TextView a;

    /* Access modifiers changed, original: protected */
    public String a() {
        return this.message.getContent();
    }

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        e.a(this.context, this.a, a(), this.message.getSessionId());
        this.a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_notification;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) this.view.findViewById(R.id.ysf_message_item_notification_label);
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.tipsTextSize > 0.0f) {
                this.a.setTextSize(uICustomization.tipsTextSize);
            }
            if (uICustomization.tipsTextColor != 0) {
                this.a.setTextColor(uICustomization.tipsTextColor);
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
