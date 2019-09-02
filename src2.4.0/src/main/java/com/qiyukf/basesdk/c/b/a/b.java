package com.qiyukf.basesdk.c.b.a;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.qiyukf.basesdk.c.b.e;

public final class b extends ClickableSpan {
    private e a;
    private Context b;
    private String c;
    private String d;

    public b(Context context, String str, String str2) {
        this.b = context;
        this.c = str;
        this.d = str2;
    }

    public final void a(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        if (this.a != null) {
            this.a.a(this.b, this.c, this.d);
        }
    }
}
