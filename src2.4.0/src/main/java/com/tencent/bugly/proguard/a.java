package com.tencent.bugly.proguard;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
public class a {
    protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
    protected String b;
    i c;
    private HashMap<String, Object> d;

    a() {
        HashMap hashMap = new HashMap();
        this.d = new HashMap();
        this.b = "GBK";
        this.c = new i();
    }

    public static ag a(int i) {
        return i == 1 ? new af() : i == 3 ? new ae() : null;
    }

    public static am a(Context context, int i, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b == null || c == null) {
            x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            am amVar = new am();
            synchronized (b) {
                amVar.a = 1;
                amVar.b = b.f();
                amVar.c = b.c;
                amVar.d = b.j;
                amVar.e = b.l;
                b.getClass();
                amVar.f = "2.6.6";
                amVar.g = i;
                amVar.h = bArr == null ? "".getBytes() : bArr;
                amVar.i = b.g;
                amVar.j = b.h;
                amVar.k = new HashMap();
                amVar.l = b.e();
                amVar.m = c.p;
                amVar.o = b.h();
                amVar.p = b.f(context);
                amVar.q = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b.k());
                amVar.r = stringBuilder.toString();
                amVar.s = b.j();
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.m());
                amVar.t = stringBuilder.toString();
                amVar.u = b.l();
                stringBuilder = new StringBuilder();
                stringBuilder.append(b.n());
                amVar.v = stringBuilder.toString();
                amVar.w = amVar.p;
                b.getClass();
                amVar.n = "com.tencent.bugly";
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.y());
                amVar.k.put("A26", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.z());
                amVar.k.put("A60", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.A());
                amVar.k.put("A61", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.z);
                amVar.k.put("F11", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.y);
                amVar.k.put("F12", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.u());
                amVar.k.put("G1", stringBuilder2.toString());
                if (b.B) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(b.M());
                    amVar.k.put("G2", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(b.N());
                    amVar.k.put("G3", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(b.O());
                    amVar.k.put("G4", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(b.P());
                    amVar.k.put("G5", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(b.Q());
                    amVar.k.put("G6", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(Long.toString(b.R()));
                    amVar.k.put("G7", stringBuilder2.toString());
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(b.k);
                amVar.k.put("D3", stringBuilder2.toString());
                if (com.tencent.bugly.b.b != null) {
                    for (com.tencent.bugly.a aVar : com.tencent.bugly.b.b) {
                        if (!(aVar.versionKey == null || aVar.version == null)) {
                            amVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                amVar.k.put("G15", z.b("G15", ""));
                amVar.k.put("D4", z.b("D4", "0"));
            }
            u a = u.a();
            if (!(a == null || a.a || bArr == null)) {
                amVar.h = z.a(amVar.h, 2, 1, c.u);
                if (amVar.h == null) {
                    x.e("reqPkg sbuffer error!", new Object[0]);
                    return null;
                }
            }
            Map F = b.F();
            if (F != null) {
                for (Entry entry : F.entrySet()) {
                    amVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return amVar;
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static an a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.b();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b = dVar.b("detail", new an());
                an anVar = an.class.isInstance(b) ? (an) an.class.cast(b) : null;
                if (!(z || anVar == null || anVar.c == null || anVar.c.length <= 0)) {
                    x.c("resp buf %d", Integer.valueOf(anVar.c.length));
                    anVar.c = z.b(anVar.c, 2, 1, StrategyBean.d);
                    if (anVar.c == null) {
                        x.e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return anVar;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        StringBuilder stringBuilder;
        Map map;
        StringBuilder stringBuilder2;
        aq aqVar = new aq();
        aqVar.a = userInfoBean.e;
        aqVar.e = userInfoBean.j;
        aqVar.d = userInfoBean.c;
        aqVar.c = userInfoBean.d;
        aqVar.g = com.tencent.bugly.crashreport.common.info.a.b().i();
        aqVar.h = userInfoBean.o == 1;
        switch (userInfoBean.b) {
            case 1:
                aqVar.b = (byte) 1;
                break;
            case 2:
                aqVar.b = (byte) 4;
                break;
            case 3:
                aqVar.b = (byte) 2;
                break;
            case 4:
                aqVar.b = (byte) 3;
                break;
            default:
                if (userInfoBean.b >= 10 && userInfoBean.b < 20) {
                    aqVar.b = (byte) userInfoBean.b;
                    break;
                }
                x.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
                return null;
        }
        aqVar.f = new HashMap();
        if (userInfoBean.p >= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(userInfoBean.p);
            aqVar.f.put("C01", stringBuilder.toString());
        }
        if (userInfoBean.q >= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(userInfoBean.q);
            aqVar.f.put("C02", stringBuilder.toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (Entry entry : userInfoBean.r.entrySet()) {
                map = aqVar.f;
                stringBuilder2 = new StringBuilder("C03_");
                stringBuilder2.append((String) entry.getKey());
                map.put(stringBuilder2.toString(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (Entry entry2 : userInfoBean.s.entrySet()) {
                map = aqVar.f;
                stringBuilder2 = new StringBuilder("C04_");
                stringBuilder2.append((String) entry2.getKey());
                map.put(stringBuilder2.toString(), entry2.getValue());
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.l ^ 1);
        aqVar.f.put("A36", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.g);
        aqVar.f.put("F02", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.h);
        aqVar.f.put("F03", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.j);
        aqVar.f.put("F04", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.i);
        aqVar.f.put("F05", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.m);
        aqVar.f.put("F06", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(userInfoBean.k);
        aqVar.f.put("F10", stringBuilder.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.b), Integer.valueOf(aqVar.f.size()));
        return aqVar;
    }

    public static ar a(List<UserInfoBean> list, int i) {
        if (list == null || list.size() == 0) {
            return null;
        }
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        if (b == null) {
            return null;
        }
        b.t();
        ar arVar = new ar();
        arVar.b = b.d;
        arVar.c = b.h();
        ArrayList arrayList = new ArrayList();
        for (UserInfoBean a : list) {
            aq a2 = a(a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        arVar.d = arrayList;
        arVar.e = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.f);
        arVar.e.put("A7", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.s());
        arVar.e.put("A6", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.r());
        arVar.e.put("A5", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.p());
        arVar.e.put("A2", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.p());
        arVar.e.put("A1", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.h);
        arVar.e.put("A24", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.q());
        arVar.e.put("A17", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.w());
        arVar.e.put("A15", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.x());
        arVar.e.put("A13", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.v);
        arVar.e.put("F08", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(b.w);
        arVar.e.put("F09", stringBuilder.toString());
        Map G = b.G();
        if (G != null && G.size() > 0) {
            for (Entry entry : G.entrySet()) {
                Map map = arVar.e;
                stringBuilder = new StringBuilder("C04_");
                stringBuilder.append((String) entry.getKey());
                map.put(stringBuilder.toString(), entry.getValue());
            }
        }
        switch (i) {
            case 1:
                arVar.a = (byte) 1;
                break;
            case 2:
                arVar.a = (byte) 2;
                break;
            default:
                x.e("unknown up type %d ", Integer.valueOf(i));
                return null;
        }
        return arVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            k kVar = (k) cls.newInstance();
            i iVar = new i(bArr);
            iVar.a("utf-8");
            kVar.a(iVar);
            return kVar;
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static String a(ArrayList<String> arrayList) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < arrayList.size(); i++) {
            Object obj = (String) arrayList.get(i);
            if (obj.equals("java.lang.Integer") || obj.equals("int")) {
                obj = "int32";
            } else if (obj.equals("java.lang.Boolean") || obj.equals("boolean")) {
                obj = "bool";
            } else if (obj.equals("java.lang.Byte") || obj.equals("byte")) {
                obj = "char";
            } else if (obj.equals("java.lang.Double") || obj.equals("double")) {
                obj = "double";
            } else if (obj.equals("java.lang.Float") || obj.equals("float")) {
                obj = "float";
            } else if (obj.equals("java.lang.Long") || obj.equals("long")) {
                obj = "int64";
            } else if (obj.equals("java.lang.Short") || obj.equals("short")) {
                obj = "short";
            } else if (obj.equals("java.lang.Character")) {
                throw new IllegalArgumentException("can not support java.lang.Character");
            } else if (obj.equals("java.lang.String")) {
                obj = "string";
            } else if (obj.equals("java.util.List")) {
                obj = "list";
            } else if (obj.equals("java.util.Map")) {
                obj = "map";
            }
            arrayList.set(i, obj);
        }
        Collections.reverse(arrayList);
        for (i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            if (str.equals("list")) {
                i2 = i - 1;
                stringBuilder = new StringBuilder("<");
                stringBuilder.append((String) arrayList.get(i2));
                arrayList.set(i2, stringBuilder.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) arrayList.get(0));
                stringBuilder2.append(">");
                arrayList.set(0, stringBuilder2.toString());
            } else if (str.equals("map")) {
                i2 = i - 1;
                stringBuilder = new StringBuilder("<");
                stringBuilder.append((String) arrayList.get(i2));
                stringBuilder.append(",");
                arrayList.set(i2, stringBuilder.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) arrayList.get(0));
                stringBuilder2.append(">");
                arrayList.set(0, stringBuilder2.toString());
            } else if (str.equals("Array")) {
                i2 = i - 1;
                stringBuilder = new StringBuilder("<");
                stringBuilder.append((String) arrayList.get(i2));
                arrayList.set(i2, stringBuilder.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) arrayList.get(0));
                stringBuilder2.append(">");
                arrayList.set(0, stringBuilder2.toString());
            }
        }
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        return stringBuffer.toString();
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            } else if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a((ArrayList) arrayList, Array.get(obj, 0));
            } else {
                arrayList.add("Array");
                arrayList.add(HttpUtils.URL_AND_PARA_SEPARATOR);
            }
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a((ArrayList) arrayList, list.get(0));
                } else {
                    arrayList.add(HttpUtils.URL_AND_PARA_SEPARATOR);
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a((ArrayList) arrayList, obj);
                } else {
                    arrayList.add(HttpUtils.URL_AND_PARA_SEPARATOR);
                    arrayList.add(HttpUtils.URL_AND_PARA_SEPARATOR);
                }
            } else {
                arrayList.add(obj.getClass().getName());
            }
        }
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.b();
            dVar.a("utf-8");
            dVar.b(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", obj);
            return dVar.a();
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            j jVar = new j();
            jVar.a(this.b);
            jVar.a((Object) t, 0);
            byte[] a = l.a(jVar.a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            a(arrayList, (Object) t);
            hashMap.put(a(arrayList), a);
            this.d.remove(str);
            this.a.put(str, hashMap);
        }
    }

    public void a(byte[] bArr) {
        this.c.a(bArr);
        this.c.a(this.b);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.c.a(hashMap, 0, false);
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.b);
        jVar.a(this.a, 0);
        return l.a(jVar.a());
    }
}
