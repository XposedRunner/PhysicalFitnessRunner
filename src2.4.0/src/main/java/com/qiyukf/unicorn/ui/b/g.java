package com.qiyukf.unicorn.ui.b;

import android.widget.TextView;
import com.qiyukf.nim.uikit.session.viewholder.b;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.e.a;

public class g extends b {
    private TextView a;

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        if (this.message.getAttachment() instanceof a) {
            this.a.setText(R.string.ysf_msg_quit_session_tips);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_separator;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_message_item_separator_text);
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
