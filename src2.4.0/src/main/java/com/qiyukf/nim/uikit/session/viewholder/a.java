package com.qiyukf.nim.uikit.session.viewholder;

import android.graphics.drawable.AnimationDrawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.f;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.session.b.b;
import com.qiyukf.nim.uikit.session.helper.e;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.d;

public class a extends b {
    private TextView a;
    private View b;
    private View c;
    private ImageView d;
    private b e;
    private TextView f;
    private boolean g;
    private com.qiyukf.nim.uikit.common.media.a.a.a h = new com.qiyukf.nim.uikit.common.media.a.a.a() {
        public final void a(com.qiyukf.nim.uikit.common.media.a.b bVar) {
            if (a.a(a.this, bVar)) {
                a.this.a();
            }
        }

        public final void b(com.qiyukf.nim.uikit.common.media.a.b bVar) {
            if (a.a(a.this, bVar)) {
                a.this.a(bVar.a());
                a.this.b();
            }
        }
    };

    private void a() {
        if (this.d.getBackground() instanceof AnimationDrawable) {
            ((AnimationDrawable) this.d.getBackground()).start();
        }
    }

    private void a(long j) {
        j = f.a(j);
        if (j >= 0) {
            TextView textView = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("\"");
            textView.setText(stringBuilder.toString());
            return;
        }
        this.a.setText("");
    }

    private void a(boolean z) {
        int i = 8;
        this.f.setVisibility(z ? 0 : 8);
        this.b.setVisibility(z ? 8 : 0);
        View view = this.c;
        if (!z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    private void b() {
        if (this.d.getBackground() instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) this.d.getBackground();
            animationDrawable.stop();
            animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);
        }
    }

    private static int c() {
        UICustomization uICustomization = d.e().uiCustomization;
        return (uICustomization == null || uICustomization.msgItemBackgroundLeft <= 0) ? R.drawable.ysf_message_left_bg_selector : uICustomization.msgItemBackgroundLeft;
    }

    private static int d() {
        UICustomization uICustomization = d.e().uiCustomization;
        return (uICustomization == null || uICustomization.msgItemBackgroundRight <= 0) ? R.drawable.ysf_message_right_bg_selector : uICustomization.msgItemBackgroundRight;
    }

    private static int e() {
        UICustomization uICustomization = d.e().uiCustomization;
        return (uICustomization == null || uICustomization.textMsgColorLeft == 0) ? ViewCompat.MEASURED_STATE_MASK : uICustomization.textMsgColorLeft;
    }

    private static int f() {
        UICustomization uICustomization = d.e().uiCustomization;
        return (uICustomization == null || uICustomization.textMsgColorRight == 0) ? -1 : uICustomization.textMsgColorRight;
    }

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        AudioAttachment audioAttachment = (AudioAttachment) this.message.getAttachment();
        TextView textView;
        int c;
        if (!audioAttachment.getAutoTransform() || audioAttachment.getText() == null) {
            int i;
            boolean z = false;
            a(false);
            ImageView imageView;
            UICustomization uICustomization;
            if (isReceivedMessage()) {
                setGravity(this.d, 19);
                setGravity(this.a, 21);
                this.b.setBackgroundResource(c());
                imageView = this.d;
                uICustomization = d.e().uiCustomization;
                i = (uICustomization == null || uICustomization.audioMsgAnimationLeft <= 0) ? R.drawable.ysf_audio_animation_list_left : uICustomization.audioMsgAnimationLeft;
                imageView.setBackgroundResource(i);
                textView = this.a;
                i = e();
            } else {
                setGravity(this.d, 21);
                setGravity(this.a, 19);
                this.c.setVisibility(8);
                this.b.setBackgroundResource(d());
                imageView = this.d;
                uICustomization = d.e().uiCustomization;
                i = (uICustomization == null || uICustomization.audioMsgAnimationRight <= 0) ? R.drawable.ysf_audio_animation_list_right : uICustomization.audioMsgAnimationRight;
                imageView.setBackgroundResource(i);
                textView = this.a;
                i = f();
            }
            textView.setTextColor(i);
            AudioAttachment audioAttachment2 = (AudioAttachment) this.message.getAttachment();
            MsgStatusEnum status = this.message.getStatus();
            AttachStatusEnum attachStatus = this.message.getAttachStatus();
            if (TextUtils.isEmpty(audioAttachment2.getPath())) {
                if (attachStatus == AttachStatusEnum.fail || status == MsgStatusEnum.fail) {
                    this.alertButton.setVisibility(0);
                } else {
                    this.alertButton.setVisibility(8);
                }
            }
            if (status == MsgStatusEnum.sending || attachStatus == AttachStatusEnum.transferring) {
                this.progressBar.setVisibility(0);
            } else {
                this.progressBar.setVisibility(8);
            }
            if (isReceivedMessage() && attachStatus == AttachStatusEnum.transferred && status != MsgStatusEnum.read) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
            long duration = ((AudioAttachment) this.message.getAttachment()).getDuration();
            long a = f.a(duration);
            c = (int) (0.6d * ((double) com.qiyukf.basesdk.c.d.d.c()));
            int c2 = (int) (0.1875d * ((double) com.qiyukf.basesdk.c.d.d.c()));
            int atan = a <= 0 ? c2 : (a <= 0 || a > 120) ? c : (int) (((((double) (c - c2)) * 0.6366197723675814d) * Math.atan(((double) a) / 10.0d)) + ((double) c2));
            if (atan < c2) {
                c = c2;
            } else if (atan <= c) {
                c = atan;
            }
            LayoutParams layoutParams = this.b.getLayoutParams();
            layoutParams.width = c;
            this.b.setLayoutParams(layoutParams);
            b bVar = this.e;
            IMMessage iMMessage = this.message;
            if (bVar.j() != null && bVar.j().isTheSame(iMMessage)) {
                z = true;
            }
            if (z) {
                a();
            } else {
                a(duration);
                b();
            }
            this.e.a(this.h);
            return;
        }
        TextView textView2;
        a(true);
        if (isReceivedMessage()) {
            this.f.setBackgroundResource(c());
            textView2 = this.f;
            c = e();
        } else {
            this.f.setBackgroundResource(d());
            textView2 = this.f;
            c = f();
        }
        textView2.setTextColor(c);
        UICustomization uICustomization2 = d.e().uiCustomization;
        if (uICustomization2 != null && uICustomization2.textMsgSize > 0.0f) {
            this.f.setTextSize(uICustomization2.textMsgSize);
        }
        this.f.setText(e.a(this.context, com.qiyukf.nim.uikit.session.emoji.e.a(this.context, ((AudioAttachment) this.message.getAttachment()).getText())));
        textView2 = this.f;
        textView = this.f;
        UICustomization uICustomization3 = d.e().uiCustomization;
        if (uICustomization3 != null) {
            if (isReceivedMessage() && uICustomization3.hyperLinkColorLeft != 0) {
                c = uICustomization3.hyperLinkColorLeft;
                textView2.setLinkTextColor(c);
                this.f.setOnTouchListener(com.qiyukf.nim.uikit.session.helper.a.a());
            } else if (!(isReceivedMessage() || uICustomization3.hyperLinkColorRight == 0)) {
                c = uICustomization3.hyperLinkColorRight;
                textView2.setLinkTextColor(c);
                this.f.setOnTouchListener(com.qiyukf.nim.uikit.session.helper.a.a());
            }
        }
        int currentTextColor = textView.getCurrentTextColor();
        c = (ViewCompat.MEASURED_SIZE_MASK & currentTextColor) != 0 ? currentTextColor : textView.getContext().getResources().getColor(R.color.ysf_text_link_color_blue);
        textView2.setLinkTextColor(c);
        this.f.setOnTouchListener(com.qiyukf.nim.uikit.session.helper.a.a());
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_audio;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.message_item_audio_duration);
        this.b = findViewById(R.id.message_item_audio_container);
        this.c = findViewById(R.id.message_item_audio_unread_indicator);
        this.d = (ImageView) findViewById(R.id.message_item_audio_playing_animation);
        this.f = (TextView) findViewById(R.id.nim_message_item_text_body);
        this.e = b.i();
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    public void onDetached() {
        this.e.b(this.h);
        b();
        super.onDetached();
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
        if (this.b.getVisibility() == 0 && this.e != null) {
            if (!isReceivedMessage() || this.message.getAttachStatus() == AttachStatusEnum.transferred) {
                if (this.message.getStatus() != MsgStatusEnum.read) {
                    this.c.setVisibility(8);
                }
                this.e.a(this.message, com.qiyukf.unicorn.b.b.i() ? 0 : 3);
                this.e.a(true, this.adapter, this.message);
            } else {
                g.a(R.string.ysf_no_permission_audio_error);
            }
        }
    }

    public void reclaim() {
        this.e.b(this.h);
        b();
        super.reclaim();
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void setStatus() {
        switch (this.message.getStatus()) {
            case fail:
                this.progressBar.setVisibility(8);
                this.alertButton.setVisibility(0);
                if (((AudioAttachment) this.message.getAttachment()).getAutoTransform() && this.g) {
                    g.a(R.string.ysf_audio_translate_to_text_failed);
                    this.g = false;
                }
                return;
            case sending:
                this.progressBar.setVisibility(0);
                this.alertButton.setVisibility(8);
                this.g = true;
                return;
            default:
                this.progressBar.setVisibility(8);
                this.alertButton.setVisibility(8);
                return;
        }
    }
}
