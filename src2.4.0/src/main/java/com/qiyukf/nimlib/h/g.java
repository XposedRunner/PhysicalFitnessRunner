package com.qiyukf.nimlib.h;

import com.qiyukf.nimlib.a.a;
import com.qiyukf.nimlib.f.d;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private static ArrayList<a> a;

    public static synchronized void a() {
        synchronized (g.class) {
            Object obj = (a == null || a.size() <= 0) ? null : 1;
            a = null;
            if (obj != null) {
                d.a();
            }
        }
    }

    public static synchronized void a(ArrayList<a> arrayList) {
        synchronized (g.class) {
            a = arrayList;
            d.a();
        }
    }

    public static synchronized void a(List<a> list) {
        synchronized (g.class) {
            c(list);
            d.a();
        }
    }

    public static ArrayList<a> b() {
        return a;
    }

    public static synchronized void b(List<a> list) {
        synchronized (g.class) {
            c(list);
            if (a == null) {
                a = new ArrayList();
            }
            for (a add : list) {
                a.add(add);
            }
            d.a();
        }
    }

    private static synchronized void c(List<a> list) {
        synchronized (g.class) {
            if (a != null) {
                for (a remove : list) {
                    a.remove(remove);
                }
                if (a.size() == 0) {
                    a = null;
                }
            }
        }
    }
}
