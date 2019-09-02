package com.qiyukf.nim.uikit.session.viewholder;

import com.qiyukf.unicorn.R;

public class e extends b {
    /* Access modifiers changed, original: protected */
    public void bindContentView() {
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_action_custom_layout;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.timeTextView.setVisibility(8);
        this.alertButton.setVisibility(8);
        this.progressBar.setVisibility(8);
        this.nameTextView.setVisibility(8);
        this.contentContainer.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public boolean showAvatar() {
        return false;
    }
}
