package com.qiyukf.unicorn.api.event;

import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.e.b;
import com.qiyukf.unicorn.h.c;

public class EventService {
    public static void requestStaff(boolean z) {
        requestStaff(c.a(), z, 0, 0, z ? 5 : 0);
    }

    public static boolean requestStaff(String str, boolean z, long j, long j2, int i) {
        b bVar;
        if (j == 0 && j2 == 0) {
            bVar = null;
        } else {
            b bVar2 = new b();
            bVar2.a = j == 0 ? 1 : 2;
            if (j == 0) {
                j = j2;
            }
            bVar2.b = j;
            bVar = bVar2;
        }
        return d.g().a(str, z, bVar, i);
    }
}
