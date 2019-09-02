package cn.jiguang.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.x;
import cn.jiguang.d.h.f;
import cn.jiguang.g.h;
import cn.jiguang.g.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends Thread {
    private static final Object c = new Object();
    private static final Object d = new Object();
    private String a;
    private Context b;

    public a(Context context, String str) {
        this.b = context;
        this.a = str;
    }

    public static String a(Context context) {
        return f.b(f.a(context, "appPackageNames_v2"));
    }

    public static void a(Context context, ArrayList<h> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuilder.append(((h) arrayList.get(i)).b);
                if (i != arrayList.size() - 1) {
                    stringBuilder.append("&&");
                }
            }
            a(context, stringBuilder.toString());
        }
    }

    private void a(HashSet<String> hashSet) {
        if (this.b != null && hashSet != null && !hashSet.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            ArrayList a = d.a(this.b, true);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(a);
            Iterator it = a.iterator();
            while (it.hasNext()) {
                h hVar = (h) it.next();
                if (hashSet.remove(hVar.b)) {
                    arrayList.remove(hVar);
                }
                if (!i.a(this.a) && hVar.b.equals(this.a)) {
                    arrayList.remove(hVar);
                }
            }
            if (!i.a(this.a)) {
                hashSet.remove(this.a);
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                JSONObject a2 = h.a(str);
                if (a2 != null) {
                    jSONArray.put(a2);
                }
                cn.jiguang.d.f.a.a(this.b, str);
            }
            it2 = arrayList.iterator();
            while (it2.hasNext()) {
                h hVar2 = (h) it2.next();
                JSONObject a3 = h.a(hVar2.b, hVar2.e);
                if (a3 != null) {
                    jSONArray.put(a3);
                }
            }
            if (jSONArray.length() > 0) {
                x.a(this.b, jSONArray);
            }
            if (jSONArray.length() > 0 || !i.a(this.a)) {
                a(this.b, a);
            }
        }
    }

    private static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        synchronized (d) {
            File a = f.a(context, "appPackageNames_v2");
            if (a == null) {
                return false;
            } else if (f.a(a, str)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public final void run() {
        try {
            synchronized (c) {
                if (this.b != null) {
                    String a = a(this.b);
                    if (!TextUtils.isEmpty(a)) {
                        HashSet hashSet;
                        d.a(this.b, "last_check_userapp_status", Long.valueOf(System.currentTimeMillis()));
                        if (a == null) {
                            hashSet = null;
                        } else {
                            String[] split = a.split("&&");
                            HashSet hashSet2 = new HashSet();
                            Collections.addAll(hashSet2, split);
                            hashSet = hashSet2;
                        }
                        a(hashSet);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
