package com.qiyukf.nim.uikit.session.viewholder;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.nimlib.k.a.a;
import com.qiyukf.nimlib.k.a.b;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.ui.activity.FileDownloadActivity;
import com.qiyukf.unicorn.widget.FileNameTextView;

public class d extends b {
    private LinearLayout a;
    private ImageView b;
    private FileNameTextView c;
    private TextView d;

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        Context context;
        int i;
        this.a.setBackgroundResource(isReceivedMessage() ? R.drawable.ysf_message_left_bg_product_selector : R.drawable.ysf_message_right_bg_product_selector);
        FileAttachment fileAttachment = (FileAttachment) this.message.getAttachment();
        this.b.setImageResource(b.a(fileAttachment.getDisplayName(), false));
        this.c.a(fileAttachment.getDisplayName());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.qiyukf.basesdk.c.a.b.a(fileAttachment.getSize()));
        stringBuilder.append("  ");
        if (a.d(this.message)) {
            context = this.context;
            i = R.string.ysf_msg_file_downloaded;
        } else if (a.e(this.message)) {
            context = this.context;
            i = R.string.ysf_msg_file_expired;
        } else {
            context = this.context;
            i = R.string.ysf_msg_file_not_downloaded;
        }
        stringBuilder.append(context.getString(i));
        this.d.setText(stringBuilder.toString());
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_file;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (LinearLayout) findViewById(R.id.ll_content);
        this.b = (ImageView) findViewById(R.id.message_item_file_icon_image);
        this.c = (FileNameTextView) findViewById(R.id.message_item_file_name_label);
        this.d = (TextView) findViewById(R.id.message_item_file_status_label);
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
        if (a.d(this.message) || !a.e(this.message)) {
            FileDownloadActivity.start(this.context, this.message);
        }
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }
}
