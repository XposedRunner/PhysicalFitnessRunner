package com.qiyukf.unicorn.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.unicorn.R;

public final class b {
    private int a;
    private String b;
    private int c;
    private int d;
    private String e;
    private boolean f;

    /* renamed from: com.qiyukf.unicorn.ui.a.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[a.a().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        static {
            /*
            r0 = com.qiyukf.unicorn.ui.a.b.a.a();
            r0 = r0.length;
            r0 = new int[r0];
            a = r0;
            r0 = 1;
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.b;	 Catch:{ NoSuchFieldError -> 0x0011 }
            r2 = r2 - r0;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0011 }
        L_0x0011:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.c;	 Catch:{ NoSuchFieldError -> 0x0019 }
            r2 = r2 - r0;
            r3 = 2;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0019 }
        L_0x0019:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.d;	 Catch:{ NoSuchFieldError -> 0x0021 }
            r2 = r2 - r0;
            r3 = 3;
            r1[r2] = r3;	 Catch:{ NoSuchFieldError -> 0x0021 }
        L_0x0021:
            r1 = a;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = com.qiyukf.unicorn.ui.a.b.a.e;	 Catch:{ NoSuchFieldError -> 0x0029 }
            r2 = r2 - r0;
            r0 = 4;
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0029 }
        L_0x0029:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.ui.a.b$AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;

        static {
            f = new int[]{a, b, c, d, e};
        }

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    public b(int i) {
        this(i, null, null, true);
    }

    public b(int i, String str, String str2, boolean z) {
        this.a = i;
        this.b = str;
        this.e = str2;
        this.f = z;
    }

    public b(int i, boolean z) {
        this(i, null, null, z);
    }

    public final int a() {
        return this.a;
    }

    public final void a(Context context) {
        int i;
        switch (AnonymousClass1.a[this.a - 1]) {
            case 1:
                this.c = R.drawable.ysf_default_shop_logo_dark;
                this.d = R.drawable.ysf_default_shop_logo_light;
                if (TextUtils.isEmpty(this.b)) {
                    i = R.string.ysf_menu_shop_name;
                    break;
                }
                return;
            case 2:
                this.c = R.drawable.ysf_human_service_dark;
                this.d = R.drawable.ysf_human_service_light;
                i = R.string.ysf_menu_request_staff;
                break;
            case 3:
                this.c = R.drawable.ysf_evaluation_star_level_list_dark;
                this.d = R.drawable.ysf_evaluation_star_level_list_light;
                i = R.string.ysf_evaluation;
                break;
            case 4:
                this.c = R.drawable.ysf_ic_menu_close_dark_selector;
                this.d = R.drawable.ysf_ic_menu_close_light_selector;
                this.b = context.getString(R.string.ysf_menu_close_session);
                return;
            default:
                return;
        }
        this.b = context.getString(i);
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.e;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.f == bVar.f) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f;
    }
}
