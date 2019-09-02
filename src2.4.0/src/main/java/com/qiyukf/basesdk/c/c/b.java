package com.qiyukf.basesdk.c.c;

import android.text.util.Linkify.MatchFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    public static final Pattern a = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
    public static final Pattern b;
    public static final Pattern c;
    public static final MatchFilter d = new MatchFilter() {
        public final boolean acceptMatch(CharSequence charSequence, int i, int i2) {
            return i == 0 ? true : (charSequence.charAt(i + -1) == '@' || ((String) charSequence).regionMatches(i - 3, "://", 0, 3)) ? false : true;
        }
    };

    public static class a {
        public String a;
        public int b;
        public int c;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("(([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,63}|");
        stringBuilder.append(a);
        stringBuilder.append(")");
        b = Pattern.compile(stringBuilder.toString());
        stringBuilder = new StringBuilder("((?:(http|https|Http|Https|HTTP|HTTPS|rtsp|Rtsp|RTSP):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:");
        stringBuilder.append(b);
        stringBuilder.append(")(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9¡-퟿豈-﷏ﷰ-￯\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        c = Pattern.compile(stringBuilder.toString());
    }

    public static List<a> a(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = c.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (d.acceptMatch(str, start, end)) {
                a aVar = new a();
                aVar.a = b(matcher.group(0));
                aVar.b = start;
                aVar.c = end;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x005b  */
    private static java.lang.String b(java.lang.String r12) {
        /*
        r0 = 3;
        r1 = new java.lang.String[r0];
        r2 = "http://";
        r3 = 0;
        r1[r3] = r2;
        r2 = "https://";
        r4 = 1;
        r1[r4] = r2;
        r2 = "rtsp://";
        r5 = 2;
        r1[r5] = r2;
        r2 = r3;
    L_0x0013:
        if (r2 >= r0) goto L_0x0058;
    L_0x0015:
        r6 = 1;
        r7 = 0;
        r8 = r1[r2];
        r9 = 0;
        r5 = r1[r2];
        r10 = r5.length();
        r5 = r12;
        r5 = r5.regionMatches(r6, r7, r8, r9, r10);
        if (r5 == 0) goto L_0x0055;
    L_0x0027:
        r7 = 0;
        r8 = 0;
        r9 = r1[r2];
        r10 = 0;
        r0 = r1[r2];
        r11 = r0.length();
        r6 = r12;
        r0 = r6.regionMatches(r7, r8, r9, r10, r11);
        if (r0 != 0) goto L_0x0059;
    L_0x0039:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r5 = r1[r2];
        r0.append(r5);
        r2 = r1[r2];
        r2 = r2.length();
        r12 = r12.substring(r2);
        r0.append(r12);
        r12 = r0.toString();
        goto L_0x0059;
    L_0x0055:
        r2 = r2 + 1;
        goto L_0x0013;
    L_0x0058:
        r4 = r3;
    L_0x0059:
        if (r4 != 0) goto L_0x006c;
    L_0x005b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r1[r3];
        r0.append(r1);
        r0.append(r12);
        r12 = r0.toString();
    L_0x006c:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.c.b.b(java.lang.String):java.lang.String");
    }
}
