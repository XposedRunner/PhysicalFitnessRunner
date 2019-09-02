package cn.jiguang.a.a.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jiguang.d.a.a;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.x;
import cn.jiguang.d.h.f;
import cn.jiguang.g.i;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e implements UncaughtExceptionHandler {
    private static e b = new e();
    private static int c = 1048576;
    public boolean a;
    private UncaughtExceptionHandler d;

    private e() {
        this.d = null;
        this.a = true;
        this.a = d.b();
    }

    public static e a() {
        return b;
    }

    private static String a(Throwable th) {
        String th2 = th.toString();
        try {
            String[] split = th2.split(":");
            if (split.length <= 1) {
                return th2;
            }
            int length = split.length - 1;
            while (length >= 0) {
                if (!split[length].endsWith("Exception")) {
                    if (!split[length].endsWith("Error")) {
                        length--;
                    }
                }
                return split[length];
            }
            return th2;
        } catch (NullPointerException | PatternSyntaxException unused) {
            return th2;
        }
    }

    private JSONArray a(Context context, Throwable th) {
        String b = f.b(f.a(context, "jpush_uncaughtexception_file"));
        JSONArray jSONArray = null;
        int i = 0;
        if (!TextUtils.isEmpty(b)) {
            try {
                JSONArray jSONArray2 = new JSONArray(b);
                try {
                    i = b.length();
                } catch (JSONException unused) {
                }
                jSONArray = jSONArray2;
            } catch (JSONException unused2) {
            }
        }
        return a(context, jSONArray, i, th);
    }

    private JSONArray a(Context context, JSONArray jSONArray, int i, Throwable th) {
        JSONObject jSONObject;
        long currentTimeMillis = System.currentTimeMillis() + a.r();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            jSONObject = null;
            try {
                if (i3 >= jSONArray.length()) {
                    break;
                }
                jSONObject = jSONArray.optJSONObject(i3);
                if (jSONObject != null && stringWriter2.equals(jSONObject.getString("stacktrace"))) {
                    jSONObject.put("count", jSONObject.getInt("count") + 1);
                    jSONObject.put("crashtime", currentTimeMillis);
                    break;
                }
                i3++;
            } catch (Throwable unused) {
            }
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("crashtime", currentTimeMillis);
            jSONObject2.put("stacktrace", stringWriter2);
            jSONObject2.put("message", a(th));
            jSONObject2.put("count", 1);
            jSONObject2.put("networktype", cn.jiguang.g.a.e(context));
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                Object obj = packageInfo.versionName == null ? "null" : packageInfo.versionName;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(packageInfo.versionCode);
                String stringBuilder2 = stringBuilder.toString();
                jSONObject2.put("versionname", obj);
                jSONObject2.put("versioncode", stringBuilder2);
            }
            if (i + jSONObject2.toString().length() < c) {
                jSONArray.put(jSONObject2);
                return jSONArray;
            }
            long j = -1;
            int i4 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    long optLong = optJSONObject.optLong("crashtime");
                    if (j == -1 || optLong < j) {
                        i4 = i2;
                        j = optLong;
                    }
                }
                i2++;
            }
            jSONArray.put(i4, jSONObject2);
        }
        return jSONArray;
    }

    public static void a(Context context) {
        if (context != null) {
            f.a(f.a(context, "jpush_uncaughtexception_file"));
        }
    }

    public static void a(Context context, String str) {
        if (!i.a(str) && str.equals("crash_log")) {
            e eVar = b;
            if (context != null && d.d(context)) {
                try {
                    new f(eVar).start();
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static JSONArray b(Context context) {
        String b = f.b(f.a(context, "jpush_uncaughtexception_file"));
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            return new JSONArray(b);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONObject c(Context context) {
        JSONArray b = b(context);
        if (b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", b);
            jSONObject.put("network_type", cn.jiguang.g.a.e(context));
            x.a(context, jSONObject, "crash_log");
            JSONObject a = b.a(context);
            if (a != null && a.length() > 0) {
                jSONObject.put("device_info", a);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final void b() {
        if (this.d == null) {
            this.d = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (this.a) {
            if (this.a) {
                String str = null;
                Context a = cn.jiguang.d.a.a(null);
                if (a != null) {
                    JSONArray a2 = a(a, th);
                    a(a);
                    if (a2 != null) {
                        str = a2.toString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        File a3 = f.a(a, "jpush_uncaughtexception_file");
                        if (a3 != null) {
                            f.a(a3, str);
                        }
                    }
                }
            }
            try {
                f fVar = new f(this);
                fVar.start();
                fVar.join(2000);
            } catch (Throwable unused) {
            }
        }
        if (this.d != this) {
            this.d.uncaughtException(thread, th);
        }
        throw new RuntimeException(th);
    }
}
