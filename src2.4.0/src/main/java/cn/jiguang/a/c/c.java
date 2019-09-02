package cn.jiguang.a.c;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.a.a.b.f;
import cn.jiguang.a.a.c.a;
import cn.jiguang.a.a.c.d;
import cn.jiguang.a.a.c.g;
import cn.jiguang.d.d.x;
import cn.jiguang.d.h.h;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    private static int b = 102400;

    private static ArrayList<JSONArray> a(JSONArray jSONArray, int i) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (!(optJSONObject == null || optJSONObject.length() == 0)) {
                    int a = h.a(optJSONObject);
                    i3 += a;
                    if (i3 > i) {
                        if (jSONArray2.length() > 0) {
                            arrayList.add(jSONArray2);
                        }
                        jSONArray2 = new JSONArray();
                        jSONArray2.put(optJSONObject);
                        i3 = a;
                    } else {
                        jSONArray2.put(optJSONObject);
                    }
                }
                i2++;
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(jSONArray2);
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            ArrayList a = a(d.b(context), b);
            if (a != null && !a.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                x.a(context, jSONObject, "app_list");
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    JSONArray jSONArray = (JSONArray) a.get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        h.a(jSONObject2, jSONObject);
                        jSONObject2.put("data", jSONArray);
                        jSONObject2.put("slice_index", i + 1);
                        jSONObject2.put("slice_count", size);
                        x.a(context, jSONObject2);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void a(Context context, int i) {
        try {
            a.execute(new d(context, i));
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str) {
        if (!cn.jiguang.d.a.d.d(context)) {
            return;
        }
        if (TextUtils.isEmpty(a.a(context))) {
            a(context);
            a.a(context, d.a(context, true));
            return;
        }
        try {
            new a(context, str).start();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (!cn.jiguang.d.a.d.d(context)) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            x.a(context, jSONObject);
        }
    }

    public static void a(Context context, boolean z) {
        try {
            f.a(context, false);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        String[] a = d.a(context);
        if (a != null && a.length != 0) {
            int length = a.length;
            String b = cn.jiguang.d.a.b(context);
            long c = cn.jiguang.d.a.d.c(context);
            int i = 0;
            int i2 = i;
            String str = "[";
            int i3 = i2;
            while (i3 < length) {
                StringBuilder stringBuilder;
                String str2 = a[i3];
                if (i == 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    str = "\"";
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    str = ",\"";
                }
                stringBuilder.append(str);
                stringBuilder.append(str2);
                stringBuilder.append("\"");
                str = stringBuilder.toString();
                i3++;
                i++;
                if (i >= 50 || str.length() > 1000 || i3 == length) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("]");
                    String stringBuilder3 = stringBuilder2.toString();
                    x.a(context, cn.jiguang.g.a.a("android_permissions", String.format(Locale.ENGLISH, "{\"total\":%d,\"page\":%d,\"senderid\":\"%s\",\"uid\":%s,\"permission_list\":%s}", new Object[]{Integer.valueOf(length), Integer.valueOf(i2), b, Long.valueOf(c), stringBuilder3})));
                    i2++;
                    str = "[";
                    i = 0;
                }
            }
        }
    }

    public static void b(Context context, int i) {
        g.a(context, i);
    }
}
