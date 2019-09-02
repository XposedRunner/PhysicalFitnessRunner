package com.qiyukf.nimlib.h.c.c;

import com.qiyukf.nimlib.h.c.b.a;
import com.qiyukf.nimlib.h.c.b.b;
import java.util.Collection;

public final class d {
    public static b a(f fVar) {
        a bVar = new b();
        fVar.a(bVar);
        return bVar;
    }

    public static void a(b bVar, Collection<?> collection) {
        if (collection == null) {
            bVar.b(0);
            return;
        }
        bVar.b(collection.size());
        for (Object next : collection) {
            if (next instanceof Integer) {
                bVar.a(((Integer) next).intValue());
            } else if (next instanceof Short) {
                bVar.a(((Short) next).shortValue());
            } else if (next instanceof Long) {
                bVar.a(((Long) next).longValue());
            } else if (next instanceof String) {
                bVar.a((String) next);
            } else if (next instanceof a) {
                bVar.a((a) next);
            } else if (next instanceof Collection) {
                a(bVar, (Collection) next);
            } else if (next instanceof byte[]) {
                bVar.b((byte[]) next);
            } else if (next instanceof Byte) {
                bVar.a(((Byte) next).byteValue());
            } else {
                StringBuilder stringBuilder = new StringBuilder("unmarshallable type: ");
                stringBuilder.append(next.getClass());
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        while (true) {
            byte b = (byte) (i % 128);
            i /= 128;
            if (i > 0) {
                b = (byte) (b | 128);
            }
            int i3 = i2 + 1;
            bArr[i2] = b;
            if (i <= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                return bArr2;
            }
            i2 = i3;
        }
    }

    public static int b(int i) {
        int i2 = 0;
        do {
            i /= 128;
            i2++;
        } while (i > 0);
        return i2;
    }
}
