package cn.jiguang.e;

import android.util.Log;

public final class a {
    public static boolean a = true;
    private String b = "";

    private a() {
    }

    public a(String str) {
        StringBuilder stringBuilder = new StringBuilder("JIGUANG-");
        stringBuilder.append(str);
        this.b = stringBuilder.toString();
    }

    private static boolean a(int i) {
        return i >= 3;
    }

    public final void a(String str, String str2, Throwable th) {
        if (a && cn.jiguang.d.a.b && a(3)) {
            String str3 = this.b;
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            Log.d(str3, stringBuilder.toString(), th);
        }
    }

    public final void b(String str, String str2, Throwable th) {
        if (a && cn.jiguang.d.a.b && a(4)) {
            String str3 = this.b;
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            Log.i(str3, stringBuilder.toString(), th);
        }
    }

    public final void c(String str, String str2, Throwable th) {
        if (a && cn.jiguang.d.a.b && a(5)) {
            String str3 = this.b;
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            Log.w(str3, stringBuilder.toString(), th);
        }
    }

    public final void d(String str, String str2, Throwable th) {
        if (a && a(6)) {
            String str3 = this.b;
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            Log.e(str3, stringBuilder.toString(), th);
        }
    }
}
