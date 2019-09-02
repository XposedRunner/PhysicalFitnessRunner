package com.qiyukf.unicorn.api.customization.action;

import com.qiyukf.nim.uikit.session.a.a;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MessageService;
import java.io.File;

public class ImageAction extends a {
    int actionFontColor = 0;

    public ImageAction() {
        super(R.drawable.ysf_message_plus_photo_selector, R.string.ysf_input_panel_photo, true);
    }

    public ImageAction(int i, int i2) {
        super(i, i2, true);
    }

    public int getActionFontColor() {
        return this.actionFontColor == 0 ? super.getActionFontColor() : this.actionFontColor;
    }

    /* Access modifiers changed, original: protected */
    public void onPicked(File file) {
        MessageService.sendMessage(buidlImageMessage(file));
    }

    public void setActionFontColor(int i) {
        this.actionFontColor = i;
    }
}
