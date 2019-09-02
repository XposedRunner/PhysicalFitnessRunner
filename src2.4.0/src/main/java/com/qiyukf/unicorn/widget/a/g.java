package com.qiyukf.unicorn.widget.a;

import android.content.Context;

public final class g {

    public interface a {
        void a(int i);
    }

    public static void a(Context context, CharSequence charSequence, CharSequence[] charSequenceArr, a aVar) {
        if (charSequenceArr.length != 0) {
            ((e) ((e) ((e) ((e) new e(context).a(null)).b(charSequence)).a(charSequenceArr).a(true)).a(aVar)).a();
        }
    }

    public static void a(Context context, String str, String str2, CharSequence charSequence, CharSequence charSequence2, boolean z, a aVar) {
        ((c) ((c) ((c) ((c) new c(context).a((CharSequence) str)).b(str2)).a(charSequence, charSequence2).a(z)).a(aVar)).a();
    }

    public static void a(Context context, String str, boolean z, a aVar) {
        a(context, null, str, null, null, z, aVar);
    }
}
