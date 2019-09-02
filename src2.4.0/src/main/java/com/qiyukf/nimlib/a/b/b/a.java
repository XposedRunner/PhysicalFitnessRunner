package com.qiyukf.nimlib.a.b.b;

import com.qiyukf.nimlib.a.b.g;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.a.d.b.b;
import com.qiyukf.nimlib.i.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a extends g {
    private static void a(b bVar) {
        com.qiyukf.nimlib.a.c.a aVar;
        List<com.qiyukf.nimlib.h.c.b.b> f = bVar.f();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        for (com.qiyukf.nimlib.h.c.b.b bVar2 : f) {
            long c = bVar2.c(12);
            int b = bVar2.b(0);
            if (b == 2) {
                arrayList2.add(Long.valueOf(c));
            } else if (b == 0) {
                arrayList.add(Long.valueOf(c));
            } else if (b == 1) {
                String a = bVar2.a(1);
                Long l = (Long) hashMap.get(a);
                if (l == null || l.longValue() < c) {
                    hashMap.put(a, Long.valueOf(c));
                }
            }
        }
        if (!arrayList.isEmpty()) {
            aVar = new com.qiyukf.nimlib.a.c.b.a();
            aVar.a((byte) 7);
            aVar.b((byte) 2);
            aVar.a(arrayList);
            c.a().a(aVar, com.qiyukf.nimlib.a.f.a.d);
        }
        if (!hashMap.isEmpty()) {
            List arrayList3 = new ArrayList(hashMap.values());
            com.qiyukf.nimlib.a.c.a aVar2 = new com.qiyukf.nimlib.a.c.b.a();
            aVar2.a((byte) 8);
            aVar2.b((byte) 3);
            aVar2.a(arrayList3);
            c.a().a(aVar2, com.qiyukf.nimlib.a.f.a.d);
        }
        if (!arrayList2.isEmpty()) {
            aVar = new com.qiyukf.nimlib.a.c.b.a();
            aVar.a((byte) 101);
            aVar.b((byte) 2);
            aVar.a(arrayList2);
            c.a().a(aVar, com.qiyukf.nimlib.a.f.a.d);
        }
    }

    public final void a(com.qiyukf.nimlib.a.d.a aVar) {
        if (aVar.b()) {
            int i = (aVar.d() == (byte) 4 || aVar.d() == (byte) 100) ? 1 : 0;
            b bVar = (b) aVar;
            List<com.qiyukf.nimlib.h.c.b.b> f = bVar.f();
            int i2 = aVar.a().h() == (byte) 100 ? 1 : 0;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            List arrayList = new ArrayList();
            HashSet hashSet = new HashSet(f.size());
            for (com.qiyukf.nimlib.h.c.b.b bVar2 : f) {
                if (!hashSet.contains(bVar2.a(11))) {
                    bVar2.a(13, 1);
                    if (i2 != 0) {
                        bVar2.a(0, 2);
                    }
                    com.qiyukf.nimlib.i.a a = com.qiyukf.nimlib.i.c.a(bVar2, false);
                    if (a != null) {
                        String a2 = com.qiyukf.nimlib.i.c.a(bVar2);
                        ArrayList arrayList2 = (ArrayList) hashMap.get(a2);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            hashMap.put(a2, arrayList2);
                        }
                        arrayList2.add(a);
                        hashSet.add(a.getUuid());
                        hashMap2.put(a2, bVar2.a(6));
                        arrayList.add(a);
                    }
                }
            }
            f.a(arrayList);
            List arrayList3 = new ArrayList();
            for (String str : hashMap.keySet()) {
                Object a3;
                ArrayList arrayList4 = (ArrayList) hashMap.get(str);
                if (i != 0) {
                    a3 = com.qiyukf.nimlib.i.c.a(arrayList4, (String) hashMap2.get(str));
                } else {
                    com.qiyukf.nimlib.i.c.a(arrayList4);
                    a3 = com.qiyukf.nimlib.i.g.a((com.qiyukf.nimlib.i.a) arrayList4.get(arrayList4.size() - 1));
                }
                if (a3 != null) {
                    arrayList3.add(a3);
                }
            }
            com.qiyukf.nimlib.e.b.b(arrayList3);
            if (i != 0) {
                a(bVar);
            }
        }
    }
}
