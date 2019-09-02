package com.qiyukf.nim.uikit.session.helper;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.qiyukf.basesdk.c.c.b;
import com.qiyukf.basesdk.c.c.b.a;
import java.util.List;

public final class e {
    public static SpannableStringBuilder a(Context context, CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        a(context, spannableStringBuilder);
        return spannableStringBuilder;
    }

    private static void a(Context context, SpannableStringBuilder spannableStringBuilder) {
        List<a> a = b.a(spannableStringBuilder.toString());
        if (a.size() != 0) {
            for (a aVar : a) {
                spannableStringBuilder.setSpan(new b(context, aVar.a), aVar.b, aVar.c, 33);
            }
        }
    }
}
