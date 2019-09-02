package com.qiyukf.nim.uikit.session.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.activity.WatchMessagePictureActivity;
import com.qiyukf.nim.uikit.session.helper.b;
import com.qiyukf.nimlib.k.b.b.a;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import org.json.JSONObject;

public class g extends i {
    protected TextView a;
    protected String b;
    protected OnClickListener c = new OnClickListener() {
        public final void onClick(View view) {
            b.a(g.this.context, g.this.b, "");
        }
    };

    /* Access modifiers changed, original: protected|final */
    public final String a(String str) {
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (TextUtils.isEmpty(this.b)) {
            layoutParams.gravity = 16;
            this.d.setLayoutParams(layoutParams);
            setLayoutParams(aVar.a, aVar.b, this.f);
            return;
        }
        layoutParams.gravity = 48;
        this.d.setLayoutParams(layoutParams);
        setLayoutParams(aVar.a, aVar.b + 152, this.f);
        setLayoutParams(aVar.a, 152, this.a);
    }

    /* Access modifiers changed, original: protected|final */
    public final int[] a() {
        ImageAttachment imageAttachment = (ImageAttachment) this.message.getAttachment();
        return new int[]{imageAttachment.getWidth(), imageAttachment.getHeight()};
    }

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        super.bindContentView();
        JSONObject f = com.qiyukf.basesdk.c.b.f(this.message.getExtension(), "action");
        if (f != null) {
            TextView textView;
            CharSequence charSequence;
            this.a.setVisibility(0);
            if (TextUtils.isEmpty(com.qiyukf.basesdk.c.b.e(f, "label"))) {
                textView = this.a;
                charSequence = "知道了";
            } else {
                textView = this.a;
                charSequence = com.qiyukf.basesdk.c.b.e(f, "label");
            }
            textView.setText(charSequence);
            this.b = com.qiyukf.basesdk.c.b.e(f, SocialConstants.PARAM_URL);
            if (TextUtils.isEmpty(this.b)) {
                this.a.setOnClickListener(null);
                return;
            } else {
                this.a.setOnClickListener(this.c);
                return;
            }
        }
        this.a.setOnClickListener(null);
        this.a.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_picture;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        super.inflateContentView();
        this.a = (TextView) findViewById(R.id.tv_nim_message_item_thumb_button);
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (IMMessage iMMessage : getAdapter().a()) {
            if (iMMessage.getMsgType() == MsgTypeEnum.image) {
                if (iMMessage.isTheSame(this.message)) {
                    i = arrayList.size();
                }
                arrayList.add(iMMessage);
            }
        }
        WatchMessagePictureActivity.start(this.context, arrayList, i);
    }
}
