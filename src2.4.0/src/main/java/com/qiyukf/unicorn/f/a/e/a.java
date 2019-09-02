package com.qiyukf.unicorn.f.a.e;

import android.content.Context;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;

@b(a = 26)
public class a extends e {
    @com.qiyukf.unicorn.f.a.b.a(a = "sessionid")
    private long a;

    public final void a(long j) {
        this.a = j;
    }

    public String getContent(Context context) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(context.getString(R.string.ysf_msg_quit_session_tips));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
