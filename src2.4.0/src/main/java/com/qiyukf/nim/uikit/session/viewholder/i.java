package com.qiyukf.nim.uikit.session.viewholder;

import android.graphics.BitmapFactory;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nim.uikit.common.ui.imageview.MsgThumbImageView;
import com.qiyukf.nimlib.k.b.b;
import com.qiyukf.nimlib.k.b.b.a;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;

public abstract class i extends b {
    protected MsgThumbImageView d;
    protected TextView e;
    protected ImageView f;

    public static int b() {
        return (int) (0.515625d * ((double) d.a()));
    }

    private void b(String str) {
        a aVar;
        int[] a = a();
        if (a[0] <= 0 || a[1] <= 0) {
            int b = (b() + c()) / 2;
            aVar = new a(b, b);
        } else {
            aVar = b.a((float) a[0], (float) a[1], (float) b(), (float) c());
        }
        setLayoutParams(aVar.a, aVar.b, this.d);
        a(aVar);
        if (str == null) {
            this.d.a(R.drawable.ysf_image_placeholder_loading, aVar.a, aVar.b, d());
        } else if (this.message.getAttachment() instanceof VideoAttachment) {
            this.d.a(BitmapFactory.decodeFile(str), aVar.a, aVar.b, d());
        } else {
            this.d.a(str, aVar.a, aVar.b, d());
        }
    }

    public static int c() {
        return (int) (0.2375d * ((double) d.a()));
    }

    private int d() {
        return isReceivedMessage() ? R.drawable.ysf_message_left_bg : R.drawable.ysf_message_right_bg;
    }

    public abstract String a(String str);

    public abstract void a(a aVar);

    public abstract int[] a();

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        this.f.setImageResource(isReceivedMessage() ? R.drawable.ysf_message_image_cover_left_selector : R.drawable.ysf_message_image_cover_right_selector);
        FileAttachment fileAttachment = (FileAttachment) this.message.getAttachment();
        String path = fileAttachment.getPath();
        String thumbPath = fileAttachment.getThumbPath();
        if (TextUtils.isEmpty(thumbPath)) {
            if (TextUtils.isEmpty(path)) {
                b(null);
                if (this.message.getAttachStatus() == AttachStatusEnum.transferred || this.message.getAttachStatus() == AttachStatusEnum.def) {
                    downloadAttachment();
                }
                fileAttachment = (FileAttachment) this.message.getAttachment();
                if (TextUtils.isEmpty(fileAttachment.getPath()) && TextUtils.isEmpty(fileAttachment.getThumbPath())) {
                    if (this.message.getAttachStatus() != AttachStatusEnum.fail || this.message.getStatus() == MsgStatusEnum.fail) {
                        this.alertButton.setVisibility(0);
                    } else {
                        this.alertButton.setVisibility(8);
                    }
                }
                if (this.message.getStatus() != MsgStatusEnum.sending || this.message.getAttachStatus() == AttachStatusEnum.transferring) {
                    this.progressBar.setVisibility(0);
                    this.e.setVisibility(0);
                    this.e.setText(com.qiyukf.basesdk.c.c.d.a(getAdapter().b(this.message)));
                }
                this.e.setVisibility(8);
                return;
            }
            thumbPath = a(path);
        }
        b(thumbPath);
        fileAttachment = (FileAttachment) this.message.getAttachment();
        if (this.message.getAttachStatus() != AttachStatusEnum.fail) {
        }
        this.alertButton.setVisibility(0);
        if (this.message.getStatus() != MsgStatusEnum.sending) {
        }
        this.progressBar.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setText(com.qiyukf.basesdk.c.c.d.a(getAdapter().b(this.message)));
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.d = (MsgThumbImageView) findViewById(R.id.message_item_thumb_thumbnail);
        this.e = (TextView) findViewById(R.id.message_item_thumb_progress_text);
        this.f = (ImageView) findViewById(R.id.message_item_thumb_cover);
        ViewCompat.setLayerType(this.d, 1, null);
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }
}
