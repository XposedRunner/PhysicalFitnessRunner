package cn.jiguang.d.d;

import android.text.TextUtils;
import cn.jiguang.d.h.f;
import cn.jiguang.d.h.h;
import com.umeng.commonsdk.framework.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o {
    public static n a(File file) {
        String b = f.b(file);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(b);
            jSONObject.getJSONArray(c.a);
            return new n(file, jSONObject);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static n a(File file, Set<String> set) {
        n a = a(file);
        if (a != null) {
            a.b(h.a(a.d(), (Set) set));
        }
        return a;
    }

    public static List<n> a(List<n> list, File file) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            File c = nVar.c();
            if (h.b(nVar.d())) {
                f.a(c);
            } else {
                if (nVar.g()) {
                    h.a(nVar.d(), nVar.e());
                    nVar.b(false);
                }
                if (nVar.f()) {
                    f.a(nVar.c(), nVar.d().toString());
                    nVar.b();
                }
                if (!file.equals(c.getParentFile())) {
                    nVar.c().getAbsolutePath();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getAbsolutePath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(c.getName());
                    File file2 = new File(stringBuilder.toString());
                    nVar.c().renameTo(file2);
                    nVar.a(file2);
                }
                nVar.a(false);
                arrayList.add(nVar);
            }
        }
        return arrayList;
    }

    public static void a(List<n> list, int i) {
        if (!list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (n nVar : list) {
                JSONObject e = nVar.e();
                if (!h.b(e)) {
                    String jSONObject = e.toString();
                    List list2 = (List) hashMap.get(jSONObject);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(jSONObject, list2);
                    }
                    list2.add(nVar);
                }
            }
            for (List list3 : hashMap.values()) {
                int i2 = 0;
                for (int i3 = 1; i3 < list3.size(); i3++) {
                    if (!a((n) list3.get(i2), (n) list3.get(i3), 40960)) {
                        i2 = i3;
                    }
                }
            }
        }
    }

    private static boolean a(n nVar, n nVar2, int i) {
        int i2 = 0;
        if (nVar.a() + nVar2.a() > ((long) i)) {
            return false;
        }
        boolean z;
        try {
            JSONArray jSONArray = nVar.d().getJSONArray(c.a);
            JSONArray jSONArray2 = nVar2.d().getJSONArray(c.a);
            z = false;
            while (i2 < jSONArray2.length()) {
                try {
                    jSONArray.put(jSONArray2.getJSONObject(i2));
                    i2++;
                    z = true;
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            z = false;
        }
        if (z) {
            nVar.a(true);
            nVar2.a(null);
            nVar2.a(true);
        }
        return z;
    }
}
