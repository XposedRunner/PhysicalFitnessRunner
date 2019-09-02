package com.geetest.mobinfo;

import android.os.Process;
import android.text.TextUtils;
import com.bangcle.andJni.JniLib1557756502;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: HardwareInfo */
public class r {
    private static final String a = "r";
    private static JSONObject b;
    private static JSONArray c;
    private static boolean d;
    private static String e;
    private static boolean f;
    private static String g;
    private static boolean h;
    private static String i;
    private static boolean j;

    private static String a(String str) {
        return (String) JniLib1557756502.cL(str, Integer.valueOf(157));
    }

    public static JSONObject a() {
        if (b != null) {
            return b;
        }
        if (s.b("/system/app")) {
            File file = new File("/system/app");
            if (file != null) {
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    w.a(a, "getBrandInfo: -->rend brand info");
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray();
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = new JSONArray();
                    JSONArray jSONArray5 = new JSONArray();
                    JSONArray jSONArray6 = new JSONArray();
                    JSONArray jSONArray7 = new JSONArray();
                    JSONArray jSONArray8 = new JSONArray();
                    JSONArray jSONArray9 = new JSONArray();
                    JSONArray jSONArray10 = new JSONArray();
                    int length = list.length;
                    int i = 0;
                    while (i < length) {
                        String toLowerCase = list[i].toLowerCase();
                        String str = a;
                        String[] strArr = list;
                        StringBuilder stringBuilder = new StringBuilder();
                        int i2 = length;
                        stringBuilder.append("品牌特性---getBrandInfo: -->");
                        stringBuilder.append(toLowerCase);
                        w.a(str, stringBuilder.toString());
                        if ((toLowerCase.startsWith("hw") || toLowerCase.contains("huawei")) && !toLowerCase.equals("hw")) {
                            jSONArray.put(toLowerCase);
                        } else if (toLowerCase.contains("miui") || toLowerCase.contains("xiaomi")) {
                            jSONArray4.put(toLowerCase);
                        } else if (toLowerCase.contains("oppo")) {
                            jSONArray2.put(toLowerCase);
                        } else if (toLowerCase.contains("vivo")) {
                            jSONArray3.put(toLowerCase);
                        } else if (toLowerCase.contains("samsung")) {
                            jSONArray7.put(toLowerCase);
                        } else if (toLowerCase.startsWith("op")) {
                            jSONArray5.put(toLowerCase);
                        } else if (toLowerCase.contains("smartisan")) {
                            jSONArray6.put(toLowerCase);
                        } else if (toLowerCase.contains("lenovo")) {
                            jSONArray8.put(toLowerCase);
                        } else if (toLowerCase.startsWith("zte")) {
                            jSONArray9.put(toLowerCase);
                        } else if (toLowerCase.startsWith("mz")) {
                            jSONArray10.put(toLowerCase);
                        }
                        i++;
                        list = strArr;
                        length = i2;
                    }
                    if (s.b("/system/emui")) {
                        jSONArray.put("/system/emui");
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (jSONArray.length() > 0) {
                        try {
                            jSONObject.put("huawei", jSONArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    if (jSONArray4.length() > 0) {
                        try {
                            jSONObject.put("xiaomi", jSONArray4);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (jSONArray2.length() > 0) {
                        try {
                            jSONObject.put("oppo", jSONArray2);
                        } catch (JSONException e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (jSONArray3.length() > 0) {
                        try {
                            jSONObject.put("vivo", jSONArray3);
                        } catch (JSONException e222) {
                            e222.printStackTrace();
                        }
                    }
                    if (jSONArray7.length() > 0) {
                        try {
                            jSONObject.put("samsung", jSONArray7);
                        } catch (JSONException e2222) {
                            e2222.printStackTrace();
                        }
                    }
                    if (jSONArray5.length() > 0) {
                        try {
                            jSONObject.put("oneplus", jSONArray5);
                        } catch (JSONException e22222) {
                            e22222.printStackTrace();
                        }
                    }
                    if (jSONArray6.length() > 0) {
                        try {
                            jSONObject.put("smartisan", jSONArray6);
                        } catch (JSONException e222222) {
                            e222222.printStackTrace();
                        }
                    }
                    if (jSONArray8.length() > 0) {
                        try {
                            jSONObject.put("lenovo", jSONArray8);
                        } catch (JSONException e2222222) {
                            e2222222.printStackTrace();
                        }
                    }
                    if (jSONArray9.length() > 0) {
                        try {
                            jSONObject.put("zte", jSONArray9);
                        } catch (JSONException e22222222) {
                            e22222222.printStackTrace();
                        }
                    }
                    if (jSONArray10.length() > 0) {
                        try {
                            jSONObject.put("meizu", jSONArray10);
                        } catch (JSONException e222222222) {
                            e222222222.printStackTrace();
                        }
                    }
                    b = jSONObject;
                    return b;
                }
            }
        }
        return null;
    }

    public static JSONArray b() {
        if (c != null) {
            return c;
        }
        if (d) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getDkProgress: uid-->");
        stringBuilder.append(Process.myUid());
        w.a(str, stringBuilder.toString());
        str = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("getDkProgress: pid-->");
        stringBuilder.append(Process.myPid());
        w.a(str, stringBuilder.toString());
        str = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append("getDkProgress: tid-->");
        stringBuilder.append(Process.myTid());
        w.a(str, stringBuilder.toString());
        str = String.valueOf(Process.myPid());
        String a = a(str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", s.a(String.format("/proc/%s/cmdline", new Object[]{str})));
            jSONObject.put("id", str);
            jSONObject.put("u", a);
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        File file = new File("/proc");
        if (file == null || !file.exists()) {
            d = true;
            return null;
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            d = true;
            return null;
        }
        for (String str2 : list) {
            if (str2.matches("^\\d*$")) {
                try {
                    if (Integer.parseInt(str2) > 1000 && !TextUtils.equals(str2, str)) {
                        String a2 = a(str2);
                        String str3 = a;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("getDkProgressInfo: uid-->");
                        stringBuilder2.append(a2);
                        w.a(str3, stringBuilder2.toString());
                        if (!TextUtils.isEmpty(a2) && TextUtils.equals(a, a2)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("name", s.a(String.format("/proc/%s/cmdline", new Object[]{str2})));
                                jSONObject2.put("id", str2);
                                jSONObject2.put("u", a2);
                                jSONArray.put(jSONObject2);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        c = jSONArray;
        return c;
    }

    public static String c() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        if (f || !s.b("/proc/cpuinfo")) {
            return null;
        }
        String a = s.a("/proc/cpuinfo");
        w.a(a, "getPart: -->rend part");
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split("\n");
            if (split != null && split.length > 0) {
                HashSet hashSet = new HashSet();
                for (CharSequence charSequence : split) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        String toLowerCase = charSequence.toLowerCase();
                        if (toLowerCase.contains("cpu part")) {
                            String[] split2 = toLowerCase.split(":");
                            if (split2.length == 2) {
                                hashSet.add(split2[1].replaceAll(" ", ""));
                            }
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    a = "";
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(a);
                        stringBuilder.append(str);
                        a = stringBuilder.toString();
                    }
                    if (!TextUtils.isEmpty(a)) {
                        e = a;
                        f = true;
                        return e;
                    }
                }
            }
        }
        f = true;
        return e;
    }

    public static String d() {
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (h || !s.b("/proc/cpuinfo")) {
            return null;
        }
        String a = s.a("/proc/cpuinfo");
        w.a(a, "modelName: -->rend modelName");
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split("\n");
            if (split != null && split.length > 0) {
                HashSet hashSet = new HashSet();
                for (CharSequence charSequence : split) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        String toLowerCase = charSequence.toLowerCase();
                        if (toLowerCase.contains("model name")) {
                            String[] split2 = toLowerCase.split(":");
                            if (split2.length == 2) {
                                hashSet.add(split2[1].replaceAll(" ", ""));
                            }
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    a = "";
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(a);
                        stringBuilder.append(str);
                        a = stringBuilder.toString();
                    }
                    if (!TextUtils.isEmpty(a)) {
                        g = a;
                        h = true;
                        return g;
                    }
                }
            }
        }
        h = true;
        return g;
    }

    public static String e() {
        if (!TextUtils.isEmpty(i)) {
            return i;
        }
        if (j || !s.b("/proc/meminfo")) {
            return null;
        }
        String a = s.a("/proc/meminfo");
        w.a(a, "getMem: -->rend mem");
        if (!TextUtils.isEmpty(a)) {
            String[] split = a.split("\n");
            if (split != null && split.length > 0) {
                for (CharSequence charSequence : split) {
                    if (!TextUtils.isEmpty(charSequence)) {
                        String toLowerCase = charSequence.toLowerCase();
                        if (toLowerCase.contains("memtotal")) {
                            String[] split2 = toLowerCase.split(":");
                            if (split2.length == 2) {
                                i = split2[1].replaceAll(" ", "");
                                j = true;
                                return i;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        j = true;
        return i;
    }
}
