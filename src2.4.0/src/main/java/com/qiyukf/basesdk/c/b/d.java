package com.qiyukf.basesdk.c.b;

import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.qiyukf.basesdk.c.b.a.b;
import java.util.ArrayList;

public final class d {
    private b a;
    private e b;
    private a c;
    private String d;
    private String e;

    public interface a {
        CharSequence a(SpannableStringBuilder spannableStringBuilder);
    }

    private d(String str) {
        this.d = str;
    }

    public static d a(String str) {
        return new d(str);
    }

    public final d a(b bVar) {
        this.a = bVar;
        return this;
    }

    public final d a(a aVar) {
        this.c = aVar;
        return this;
    }

    public final d a(e eVar) {
        this.b = eVar;
        return this;
    }

    public final void a(TextView textView) {
        if (TextUtils.isEmpty(this.d)) {
            textView.setText("");
            return;
        }
        int spanEnd;
        a aVar = new a();
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        aVar.a(textView);
        aVar.a(this.a);
        aVar.a(this.d);
        cVar.a(textView);
        this.d = c.a(this.d);
        Spanned fromHtml = Html.fromHtml(this.d, aVar, cVar);
        CharSequence spannableStringBuilder = fromHtml instanceof SpannableStringBuilder ? (SpannableStringBuilder) fromHtml : new SpannableStringBuilder(fromHtml);
        arrayList.clear();
        int i = 0;
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ImageSpan.class);
        for (int i2 = 0; i2 < imageSpanArr.length; i2++) {
            ImageSpan imageSpan = imageSpanArr[i2];
            String source = imageSpan.getSource();
            int spanStart = spannableStringBuilder.getSpanStart(imageSpan);
            spanEnd = spannableStringBuilder.getSpanEnd(imageSpan);
            arrayList.add(source);
            com.qiyukf.basesdk.c.b.a.a aVar2 = new com.qiyukf.basesdk.c.b.a.a(textView.getContext(), arrayList, i2);
            aVar2.a(this.b);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannableStringBuilder.getSpans(spanStart, spanEnd, ClickableSpan.class);
            if (clickableSpanArr != null) {
                for (Object removeSpan : clickableSpanArr) {
                    spannableStringBuilder.removeSpan(removeSpan);
                }
            }
            spannableStringBuilder.setSpan(aVar2, spanStart, spanEnd, 33);
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        if (uRLSpanArr != null) {
            int length = uRLSpanArr.length;
            while (i < length) {
                Object obj = uRLSpanArr[i];
                spanEnd = spannableStringBuilder.getSpanStart(obj);
                int spanEnd2 = spannableStringBuilder.getSpanEnd(obj);
                spannableStringBuilder.removeSpan(obj);
                b bVar = new b(textView.getContext(), obj.getURL(), this.e);
                bVar.a(this.b);
                spannableStringBuilder.setSpan(bVar, spanEnd, spanEnd2, 34);
                i++;
            }
        }
        while (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        if (this.c != null) {
            spannableStringBuilder = this.c.a(spannableStringBuilder);
        }
        textView.setText(spannableStringBuilder);
    }

    public final d b(String str) {
        this.e = str;
        return this;
    }
}
