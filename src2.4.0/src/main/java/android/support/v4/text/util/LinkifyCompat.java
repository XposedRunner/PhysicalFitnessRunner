package android.support.v4.text.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.PatternsCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.widget.TextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = new Comparator<LinkSpec>() {
        public final int compare(LinkSpec linkSpec, LinkSpec linkSpec2) {
            return linkSpec.start < linkSpec2.start ? -1 : (linkSpec.start <= linkSpec2.start && linkSpec.end >= linkSpec2.end) ? linkSpec.end > linkSpec2.end ? -1 : 0 : 1;
        }
    };
    private static final String[] EMPTY_STRING = new String[0];

    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@NonNull TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        addLinks(textView, pattern, str, null, null, null);
    }

    public static final void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable MatchFilter matchFilter, @Nullable TransformFilter transformFilter) {
        addLinks(textView, pattern, str, null, matchFilter, transformFilter);
    }

    public static final void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable MatchFilter matchFilter, @Nullable TransformFilter transformFilter) {
        CharSequence valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks((Spannable) valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static final boolean addLinks(@NonNull Spannable spannable, int i) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            ArrayList arrayList2 = arrayList;
            Spannable spannable2 = spannable;
            gatherLinks(arrayList2, spannable2, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LinkSpec linkSpec = (LinkSpec) it.next();
            if (linkSpec.frameworkAddedSpan == null) {
                applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable);
            }
        }
        return true;
    }

    public static final boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        return addLinks(spannable, pattern, str, null, null, null);
    }

    public static final boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable MatchFilter matchFilter, @Nullable TransformFilter transformFilter) {
        return addLinks(spannable, pattern, str, null, matchFilter, transformFilter);
    }

    public static final boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable MatchFilter matchFilter, @Nullable TransformFilter transformFilter) {
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = EMPTY_STRING;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            String str2 = strArr[i];
            i++;
            strArr2[i] = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                applyLink(makeUrl(matcher.group(0), strArr2, matcher, transformFilter), start, end, spannable);
                z = true;
            }
        }
        return z;
    }

    public static final boolean addLinks(@NonNull TextView textView, int i) {
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            Spannable valueOf = SpannableString.valueOf(text);
            if (!addLinks(valueOf, i)) {
                return false;
            }
            addLinkMovementMethod(textView);
            textView.setText(valueOf);
            return true;
        } else if (!addLinks((Spannable) text, i)) {
            return false;
        } else {
            addLinkMovementMethod(textView);
            return true;
        }
    }

    private static void applyLink(String str, int i, int i2, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i, i2, 33);
    }

    private static void gatherLinks(ArrayList<LinkSpec> arrayList, Spannable spannable, Pattern pattern, String[] strArr, MatchFilter matchFilter, TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                LinkSpec linkSpec = new LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = start;
                linkSpec.end = end;
                arrayList.add(linkSpec);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A:{LOOP_START, SYNTHETIC, LOOP:0: B:1:0x0005->B:16:0x0005, PHI: r0 r6 , Splitter:B:1:0x0005} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Failed to process nested try/catch */
    private static final void gatherMapLinks(java.util.ArrayList<android.support.v4.text.util.LinkifyCompat.LinkSpec> r5, android.text.Spannable r6) {
        /*
        r6 = r6.toString();
        r0 = 0;
    L_0x0005:
        r1 = android.webkit.WebView.findAddress(r6);	 Catch:{ UnsupportedOperationException -> 0x0044 }
        if (r1 == 0) goto L_0x0043;
    L_0x000b:
        r2 = r6.indexOf(r1);	 Catch:{ UnsupportedOperationException -> 0x0044 }
        if (r2 >= 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0043;
    L_0x0012:
        r3 = new android.support.v4.text.util.LinkifyCompat$LinkSpec;	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r3.<init>();	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r4 = r1.length();	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r4 = r4 + r2;
        r2 = r2 + r0;
        r3.start = r2;	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r0 = r0 + r4;
        r3.end = r0;	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r6 = r6.substring(r4);	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r2 = "UTF-8";
        r1 = java.net.URLEncoder.encode(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0005 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r2.<init>();	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r4 = "geo:0,0?q=";
        r2.append(r4);	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r2.append(r1);	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r1 = r2.toString();	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r3.url = r1;	 Catch:{ UnsupportedOperationException -> 0x0044 }
        r5.add(r3);	 Catch:{ UnsupportedOperationException -> 0x0044 }
        goto L_0x0005;
    L_0x0043:
        return;
    L_0x0044:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.util.LinkifyCompat.gatherMapLinks(java.util.ArrayList, android.text.Spannable):void");
    }

    private static String makeUrl(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable TransformFilter transformFilter) {
        int i;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i2 = 0;
        while (true) {
            i = 1;
            if (i2 >= strArr.length) {
                i = 0;
                break;
            }
            if (str.regionMatches(true, 0, strArr[i2], 0, strArr[i2].length())) {
                if (!str.regionMatches(false, 0, strArr[i2], 0, strArr[i2].length())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(strArr[i2]);
                    stringBuilder.append(str.substring(strArr[i2].length()));
                    str = stringBuilder.toString();
                }
            } else {
                i2++;
            }
        }
        if (i != 0 || strArr.length <= 0) {
            return str;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(strArr[0]);
        stringBuilder2.append(str);
        return stringBuilder2.toString();
    }

    private static final void pruneOverlaps(ArrayList<LinkSpec> arrayList, Spannable spannable) {
        int i;
        int i2 = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (i = 0; i < uRLSpanArr.length; i++) {
            LinkSpec linkSpec = new LinkSpec();
            linkSpec.frameworkAddedSpan = uRLSpanArr[i];
            linkSpec.start = spannable.getSpanStart(uRLSpanArr[i]);
            linkSpec.end = spannable.getSpanEnd(uRLSpanArr[i]);
            arrayList.add(linkSpec);
        }
        Collections.sort(arrayList, COMPARATOR);
        int size = arrayList.size();
        while (i2 < size - 1) {
            LinkSpec linkSpec2 = (LinkSpec) arrayList.get(i2);
            int i3 = i2 + 1;
            LinkSpec linkSpec3 = (LinkSpec) arrayList.get(i3);
            if (linkSpec2.start <= linkSpec3.start && linkSpec2.end > linkSpec3.start) {
                i = (linkSpec3.end > linkSpec2.end && linkSpec2.end - linkSpec2.start <= linkSpec3.end - linkSpec3.start) ? linkSpec2.end - linkSpec2.start < linkSpec3.end - linkSpec3.start ? i2 : -1 : i3;
                if (i != -1) {
                    URLSpan uRLSpan = ((LinkSpec) arrayList.get(i)).frameworkAddedSpan;
                    if (uRLSpan != null) {
                        spannable.removeSpan(uRLSpan);
                    }
                    arrayList.remove(i);
                    size--;
                }
            }
            i2 = i3;
        }
    }
}
