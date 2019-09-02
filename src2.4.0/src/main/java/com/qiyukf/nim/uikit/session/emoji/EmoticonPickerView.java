package com.qiyukf.nim.uikit.session.emoji;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.unicorn.R;

public class EmoticonPickerView extends LinearLayout {
    private Context a;
    private d b;
    private c c;
    private ViewPager d;
    private LinearLayout e;

    public EmoticonPickerView(Context context) {
        super(context);
        a(context);
    }

    public EmoticonPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @TargetApi(11)
    public EmoticonPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.ysf_emoji_layout, this);
    }

    public final void a() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public final void a(d dVar) {
        if (dVar != null) {
            this.b = dVar;
        } else {
            a.a("sticker", "listener is null");
        }
        if (this.b == null) {
            a.a("sticker", "show picker view when listener is null");
        }
        if (this.c == null) {
            this.c = new c(this.a, this.b, this.d, this.e);
        }
        this.c.a();
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = (ViewPager) findViewById(R.id.emotion_icon_pager);
        this.e = (LinearLayout) findViewById(R.id.layout_scr_bottom);
    }
}
