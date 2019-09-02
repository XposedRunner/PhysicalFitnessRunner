package com.qiyukf.basesdk.c.a;

import java.util.Locale;

public final class b {

    /* renamed from: com.qiyukf.basesdk.c.a.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[a.a().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Missing block: B:13:?, code skipped:
            return;
     */
        static {
            /*
            r0 = com.qiyukf.basesdk.c.a.b.a.a();
            r0 = r0.length;
            r0 = new int[r0];
            a = r0;
            r0 = 1;
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = com.qiyukf.basesdk.c.a.b.a.b;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = r2 - r0;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = com.qiyukf.basesdk.c.a.b.a.c;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = r2 - r0;
            r3 = 2;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = com.qiyukf.basesdk.c.a.b.a.d;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = r2 - r0;
            r3 = 3;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = com.qiyukf.basesdk.c.a.b.a.e;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = r2 - r0;
            r3 = 4;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = com.qiyukf.basesdk.c.a.b.a.a;	 Catch:{ NoSuchFieldError -> 0x0031 }
            r2 = r2 - r0;
            r0 = 5;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0031 }
        L_0x0031:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.c.a.b$AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;

        static {
            g = new int[]{a, b, c, d, e, f};
        }

        public static int[] a() {
            return (int[]) g.clone();
        }
    }

    public static String a(long j) {
        int i = a.f;
        if (i == a.f) {
            double d = (double) j;
            i = d < 1024.0d ? a.a : d < 1048576.0d ? a.b : d < 1.073741824E9d ? a.c : d < 1.099511627776E12d ? a.d : a.e;
        }
        switch (AnonymousClass1.a[i - 1]) {
            case 1:
                return String.format(Locale.US, "%d KB", new Object[]{Integer.valueOf((int) (((double) j) / 1024.0d))});
            case 2:
                return String.format(Locale.US, "%.1f MB", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
            case 3:
                return String.format(Locale.US, "%.1f GB", new Object[]{Double.valueOf(((double) j) / 1.073741824E9d)});
            case 4:
                return String.format(Locale.US, "%.1f PB", new Object[]{Double.valueOf(((double) j) / 1.099511627776E12d)});
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append(" B");
                return stringBuilder.toString();
        }
    }

    public static String a(String str) {
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
        }
        return "";
    }

    public static String b(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(47);
        return (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) ? str : str.substring(lastIndexOf + 1);
    }
}
