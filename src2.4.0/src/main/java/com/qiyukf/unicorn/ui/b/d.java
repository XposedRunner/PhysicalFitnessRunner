package com.qiyukf.unicorn.ui.b;

import android.widget.TextView;
import com.qiyukf.nim.uikit.session.viewholder.h;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.j.c;

public class d extends h {
    /* Access modifiers changed, original: protected|final */
    public final void a(TextView textView) {
        int dimension = (int) textView.getResources().getDimension(R.dimen.ysf_bubble_content_rich_image_max_width);
        c.a(textView, ((com.qiyukf.unicorn.f.a.d.h) this.message.getAttachment()).a(), dimension, this.message.getSessionId());
    }
}
