package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.helper.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    private static Pattern a = Pattern.compile("<a\\s+([^>]*)>([^<]*)</a>");
    private static Pattern b = Pattern.compile("href\\s*=\\s*(\\S*)");

    private static class a extends b {
        private int a;
        private int b;
        private String c;

        public a(Context context, String str, String str2, String str3) {
            super(context, str2);
            this.c = str;
            a(str3);
        }

        public final String a() {
            return this.c;
        }

        public final void a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    private static Drawable a(Context context, CharSequence charSequence, float f) {
        Drawable a = b.a(context, charSequence.toString());
        if (a != null) {
            a.setBounds(0, 0, (int) (((float) a.getIntrinsicWidth()) * f), (int) (((float) a.getIntrinsicHeight()) * f));
        }
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        Matcher matcher = b.b().matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Drawable a = a(context, charSequence.subSequence(start, end), 0.6f);
            if (a != null) {
                spannableString.setSpan(new ImageSpan(a, 0), start, end, 33);
            }
        }
        return spannableString;
    }

    public static SpannableString a(Context context, String str, String str2) {
        return a(context, b(context, str, str2));
    }

    public static void a(Context context, Editable editable, int i, int i2) {
        if (i2 > 0) {
            i2 += i;
            if (editable.length() >= i2) {
                Matcher matcher = b.b().matcher(editable.subSequence(i, i2));
                while (matcher.find()) {
                    int start = matcher.start() + i;
                    int end = matcher.end() + i;
                    Drawable a = a(context, editable.subSequence(start, end).toString(), 0.45f);
                    if (a != null) {
                        editable.setSpan(new ImageSpan(a, 0), start, end, 33);
                    }
                }
            }
        }
    }

    public static void a(Context context, TextView textView, String str, String str2) {
        SpannableString a = a(context, str, str2);
        if (textView != null) {
            textView.setText(a);
        }
    }

    public static SpannableString b(Context context, String str, String str2) {
        CharSequence str3;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        Matcher matcher = a.matcher(str3);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String str4 = null;
            Matcher matcher2 = b.matcher(group);
            if (matcher2.find()) {
                str4 = matcher2.group(1).replace("\"", "").replace("'", "");
            }
            a aVar = new a(context, group2, str4, str2);
            aVar.a(start, end);
            arrayList.add(aVar);
        }
        if (arrayList.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                stringBuilder.append(str3.subSequence(i, aVar2.a));
                stringBuilder.append(aVar2.a());
                i = aVar2.b;
                aVar2.b = stringBuilder.length();
                aVar2.a = aVar2.b - aVar2.a().length();
            }
            stringBuilder.append(str3.subSequence(i, str3.length()));
            str3 = stringBuilder.toString();
        }
        SpannableString spannableString = new SpannableString(str3);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a aVar3 = (a) it2.next();
            spannableString.setSpan(aVar3, aVar3.a, aVar3.b, 33);
        }
        return spannableString;
    }
}
