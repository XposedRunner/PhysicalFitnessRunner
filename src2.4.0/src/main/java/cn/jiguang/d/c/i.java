package cn.jiguang.d.c;

import java.util.HashMap;

final class i {
    private static Integer[] a = new Integer[64];
    private HashMap b = new HashMap();
    private HashMap c = new HashMap();
    private String d;
    private int e = 3;
    private String f;
    private int g = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private boolean h;

    static {
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(i);
        }
    }

    public i(String str, int i) {
        this.d = str;
    }

    private static Integer c(int i) {
        return (i < 0 || i >= a.length) ? Integer.valueOf(i) : a[i];
    }

    private void d(int i) {
        if (i < 0 || i > this.g) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append(" ");
            stringBuilder.append(i);
            stringBuilder.append("is out of range");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final void a(int i) {
        this.g = 3;
    }

    public final void a(int i, String str) {
        Object str2;
        d(i);
        Integer c = c(i);
        if (this.e == 2) {
            str2 = str2.toUpperCase();
        } else if (this.e == 3) {
            str2 = str2.toLowerCase();
        }
        this.b.put(str2, c);
        this.c.put(c, str2);
    }

    public final void a(boolean z) {
        this.h = true;
    }

    public final String b(int i) {
        d(i);
        String str = (String) this.c.get(c(i));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i);
        if (this.f != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append(num);
            num = stringBuilder.toString();
        }
        return num;
    }
}
