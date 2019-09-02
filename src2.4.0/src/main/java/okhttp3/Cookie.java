package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    public static final class Builder {
        String domain;
        long expiresAt;
        boolean hostOnly;
        boolean httpOnly;
        String name;
        String path;
        boolean persistent;
        boolean secure;
        String value;

        private Builder domain(String str, boolean z) {
            return null;
        }

        public Cookie build() {
            return null;
        }

        public Builder domain(String str) {
            return null;
        }

        public Builder expiresAt(long j) {
            return null;
        }

        public Builder hostOnlyDomain(String str) {
            return null;
        }

        public Builder httpOnly() {
            return null;
        }

        public Builder name(String str) {
            return null;
        }

        public Builder path(String str) {
            return null;
        }

        public Builder secure() {
            return null;
        }

        public Builder value(String str) {
            return null;
        }
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.hostOnly = z3;
        this.persistent = z4;
    }

    private Cookie(Builder builder) {
        if (builder.name == null) {
            throw new NullPointerException("builder.name == null");
        } else if (builder.value == null) {
            throw new NullPointerException("builder.value == null");
        } else if (builder.domain == null) {
            throw new NullPointerException("builder.domain == null");
        } else {
            this.name = builder.name;
            this.value = builder.value;
            this.expiresAt = builder.expiresAt;
            this.domain = builder.domain;
            this.path = builder.path;
            this.secure = builder.secure;
            this.httpOnly = builder.httpOnly;
            this.persistent = builder.persistent;
            this.hostOnly = builder.hostOnly;
        }
    }

    private static int dateCharacterOffset(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            int i3 = ((charAt >= ' ' || charAt == 9) && charAt < 127 && ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && charAt != ':')))) ? 0 : 1;
            if (i3 == (z ^ 1)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static boolean domainMatch(HttpUrl httpUrl, String str) {
        String host = httpUrl.host();
        return host.equals(str) ? true : host.endsWith(str) && host.charAt((host.length() - str.length()) - 1) == '.' && !Util.verifyAsIpAddress(host);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010e  */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    static okhttp3.Cookie parse(long r26, okhttp3.HttpUrl r28, java.lang.String r29) {
        /*
        r2 = r29;
        r3 = r29.length();
        r4 = 59;
        r5 = 0;
        r6 = okhttp3.internal.Util.delimiterOffset(r2, r5, r3, r4);
        r7 = 61;
        r8 = okhttp3.internal.Util.delimiterOffset(r2, r5, r6, r7);
        r9 = 0;
        if (r8 != r6) goto L_0x0017;
    L_0x0016:
        return r9;
    L_0x0017:
        r11 = okhttp3.internal.Util.trimSubstring(r2, r5, r8);
        r10 = r11.isEmpty();
        if (r10 == 0) goto L_0x0022;
    L_0x0021:
        return r9;
    L_0x0022:
        r10 = 1;
        r8 = r8 + r10;
        r12 = okhttp3.internal.Util.trimSubstring(r2, r8, r6);
        r6 = r6 + r10;
        r13 = -1;
        r15 = 253402300799999; // 0xe677d21fdbff float:-1.71647681E11 double:1.251973714024093E-309;
        r19 = r5;
        r20 = r19;
        r24 = r20;
        r8 = r9;
        r21 = r10;
        r17 = r13;
        r22 = r15;
        r10 = r8;
    L_0x003e:
        if (r6 >= r3) goto L_0x00b2;
    L_0x0040:
        r9 = okhttp3.internal.Util.delimiterOffset(r2, r6, r3, r4);
        r4 = okhttp3.internal.Util.delimiterOffset(r2, r6, r9, r7);
        r6 = okhttp3.internal.Util.trimSubstring(r2, r6, r4);
        if (r4 >= r9) goto L_0x0055;
    L_0x004e:
        r4 = r4 + 1;
        r4 = okhttp3.internal.Util.trimSubstring(r2, r4, r9);
        goto L_0x0057;
    L_0x0055:
        r4 = "";
    L_0x0057:
        r7 = "expires";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x006c;
    L_0x005f:
        r6 = r4.length();	 Catch:{ IllegalArgumentException -> 0x00aa }
        r6 = parseExpires(r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x00aa }
        r22 = r6;
    L_0x0069:
        r24 = 1;
        goto L_0x00aa;
    L_0x006c:
        r7 = "max-age";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x007b;
    L_0x0074:
        r6 = parseMaxAge(r4);	 Catch:{  }
        r17 = r6;
        goto L_0x0069;
    L_0x007b:
        r7 = "domain";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x008b;
    L_0x0083:
        r4 = parseDomain(r4);	 Catch:{ IllegalArgumentException -> 0x00aa }
        r8 = r4;
        r21 = r5;
        goto L_0x00aa;
    L_0x008b:
        r7 = "path";
        r7 = r6.equalsIgnoreCase(r7);
        if (r7 == 0) goto L_0x0095;
    L_0x0093:
        r10 = r4;
        goto L_0x00aa;
    L_0x0095:
        r4 = "secure";
        r4 = r6.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x00a0;
    L_0x009d:
        r19 = 1;
        goto L_0x00aa;
    L_0x00a0:
        r4 = "httponly";
        r4 = r6.equalsIgnoreCase(r4);
        if (r4 == 0) goto L_0x00aa;
    L_0x00a8:
        r20 = 1;
    L_0x00aa:
        r6 = r9 + 1;
        r4 = 59;
        r7 = 61;
        r9 = 0;
        goto L_0x003e;
    L_0x00b2:
        r2 = -9223372036854775808;
        r4 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1));
        if (r4 != 0) goto L_0x00ba;
    L_0x00b8:
        r13 = r2;
        goto L_0x00df;
    L_0x00ba:
        r2 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1));
        if (r2 == 0) goto L_0x00dd;
    L_0x00be:
        r2 = 9223372036854775; // 0x20c49ba5e353f7 float:-3.943512E-16 double:4.663754807431093E-308;
        r4 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1));
        if (r4 > 0) goto L_0x00cc;
    L_0x00c7:
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r17 = r17 * r2;
        goto L_0x00d1;
    L_0x00cc:
        r17 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
    L_0x00d1:
        r2 = r26 + r17;
        r4 = (r2 > r26 ? 1 : (r2 == r26 ? 0 : -1));
        if (r4 < 0) goto L_0x00db;
    L_0x00d7:
        r0 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b8;
    L_0x00db:
        r13 = r15;
        goto L_0x00df;
    L_0x00dd:
        r13 = r22;
    L_0x00df:
        if (r8 != 0) goto L_0x00e9;
    L_0x00e1:
        r0 = r28.host();
        r15 = r0;
        r0 = r28;
        goto L_0x00f4;
    L_0x00e9:
        r0 = r28;
        r1 = domainMatch(r0, r8);
        if (r1 != 0) goto L_0x00f3;
    L_0x00f1:
        r1 = 0;
        return r1;
    L_0x00f3:
        r15 = r8;
    L_0x00f4:
        if (r10 == 0) goto L_0x0102;
    L_0x00f6:
        r1 = "/";
        r1 = r10.startsWith(r1);
        if (r1 != 0) goto L_0x00ff;
    L_0x00fe:
        goto L_0x0102;
    L_0x00ff:
        r16 = r10;
        goto L_0x0117;
    L_0x0102:
        r0 = r28.encodedPath();
        r1 = 47;
        r1 = r0.lastIndexOf(r1);
        if (r1 == 0) goto L_0x0113;
    L_0x010e:
        r0 = r0.substring(r5, r1);
        goto L_0x0115;
    L_0x0113:
        r0 = "/";
    L_0x0115:
        r16 = r0;
    L_0x0117:
        r0 = new okhttp3.Cookie;
        r10 = r0;
        r17 = r19;
        r18 = r20;
        r19 = r21;
        r20 = r24;
        r10.<init>(r11, r12, r13, r15, r16, r17, r18, r19, r20);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.parse(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
    }

    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List values = headers.values("Set-Cookie");
        int size = values.size();
        List list = null;
        for (int i = 0; i < size; i++) {
            Cookie parse = parse(httpUrl, (String) values.get(i));
            if (parse != null) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(parse);
            }
        }
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        str = Util.domainToAscii(str);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i, int i2) {
        i = dateCharacterOffset(str, i, i2, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i3 = -1;
        int i4 = i3;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        while (i < i2) {
            int dateCharacterOffset = dateCharacterOffset(str, i + 1, i2, true);
            matcher.region(i, dateCharacterOffset);
            if (i3 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i = Integer.parseInt(matcher.group(1));
                i3 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
                i7 = i3;
                i3 = i;
            } else if (i5 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else if (i6 == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                i6 = MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            i = dateCharacterOffset(str, dateCharacterOffset + 1, i2, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i6 == -1) {
            throw new IllegalArgumentException();
        } else if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        } else if (i3 < 0 || i3 > 23) {
            throw new IllegalArgumentException();
        } else if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i6 - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i3);
            gregorianCalendar.set(12, i7);
            gregorianCalendar.set(13, i8);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long parseMaxAge(String str) {
        long j = Long.MIN_VALUE;
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                j = parseLong;
            }
            return j;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                if (!str.startsWith("-")) {
                    j = Long.MAX_VALUE;
                }
                return j;
            }
            throw e;
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        return encodedPath.equals(str) ? true : encodedPath.startsWith(str) && (str.endsWith("/") || encodedPath.charAt(str.length()) == '/');
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
            z = true;
        }
        return z;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        return (31 * (((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + ((int) (this.expiresAt ^ (this.expiresAt >>> 32)))) * 31) + (this.secure ^ 1)) * 31) + (this.httpOnly ^ 1)) * 31) + (this.persistent ^ 1))) + (this.hostOnly ^ 1);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        return ((this.hostOnly ? httpUrl.host().equals(this.domain) : domainMatch(httpUrl, this.domain)) && pathMatch(httpUrl, this.path)) ? !this.secure || httpUrl.isHttps() : false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append('=');
        stringBuilder.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=");
                stringBuilder.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            stringBuilder.append("; domain=");
            stringBuilder.append(this.domain);
        }
        stringBuilder.append("; path=");
        stringBuilder.append(this.path);
        if (this.secure) {
            stringBuilder.append("; secure");
        }
        if (this.httpOnly) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }

    public String value() {
        return this.value;
    }
}
