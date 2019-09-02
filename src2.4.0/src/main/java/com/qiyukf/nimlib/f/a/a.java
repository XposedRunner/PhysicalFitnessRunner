package com.qiyukf.nimlib.f.a;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.qiyukf.nimlib.h.c.c.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            a a = b.a(parcel);
            if (a != null) {
                a.d.flip();
            }
            return a;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new a[i];
        }
    };
    public int a;
    private int b;
    private ByteBuffer c;
    private ByteBuffer d;

    private static final class a {
        private static AtomicInteger a = new AtomicInteger(0);

        public static int a() {
            return a.incrementAndGet();
        }
    }

    private static class b {
        private static SparseArray<a> a = new SparseArray();

        /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x006e A:{RETURN} */
        static com.qiyukf.nimlib.f.a.a a(android.os.Parcel r4) {
            /*
            r0 = new com.qiyukf.nimlib.f.a.a;
            r1 = 0;
            r0.<init>(r1);
            r2 = r4.readInt();
            r0.a = r2;
            r2 = r4.readInt();
            if (r2 <= 0) goto L_0x001d;
        L_0x0012:
            r2 = r4.createByteArray();
            r2 = java.nio.ByteBuffer.wrap(r2);
            r0.c = r2;
        L_0x001d:
            r2 = r4.readInt();
            r0.b = r2;
            r2 = r4.readInt();
            if (r2 <= 0) goto L_0x0061;
        L_0x002a:
            r4 = r4.createByteArray();
            r3 = r0.b;
            if (r3 <= 0) goto L_0x005c;
        L_0x0034:
            r1 = r0.b;
            if (r1 != r2) goto L_0x0049;
        L_0x003a:
            r4 = java.nio.ByteBuffer.wrap(r4);
            r0.d = r4;
            r4 = r0.d;
            r4.position(r2);
            goto L_0x0068;
        L_0x0049:
            r1 = r0.b;
            r1 = java.nio.ByteBuffer.allocate(r1);
            r0.d = r1;
            r1 = r0.d;
            r1.put(r4);
            goto L_0x0068;
        L_0x005c:
            r4 = java.nio.ByteBuffer.wrap(r4, r1, r2);
            goto L_0x0065;
        L_0x0061:
            r4 = java.nio.ByteBuffer.allocate(r1);
        L_0x0065:
            r0.d = r4;
        L_0x0068:
            r4 = b(r0);
            if (r4 == 0) goto L_0x006f;
        L_0x006e:
            return r0;
        L_0x006f:
            r4 = r0.b;
            if (r4 <= 0) goto L_0x007d;
        L_0x0075:
            r4 = a;
            r1 = r0.a;
            r4.put(r1, r0);
            goto L_0x00a2;
        L_0x007d:
            r4 = a;
            r1 = r0.a;
            r4 = r4.get(r1);
            r4 = (com.qiyukf.nimlib.f.a.a) r4;
            if (r4 == 0) goto L_0x00a2;
        L_0x0089:
            r1 = r4.d;
            r0 = r0.d;
            r1.put(r0);
            r0 = b(r4);
            if (r0 == 0) goto L_0x00a2;
        L_0x009a:
            r0 = a;
            r1 = r4.a;
            r0.remove(r1);
            return r4;
        L_0x00a2:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.f.a.a$b.a(android.os.Parcel):com.qiyukf.nimlib.f.a.a");
        }

        static List<a> a(a aVar) {
            aVar.b = aVar.d.remaining();
            int i = 1;
            int c = ((aVar.b - 1) / 131072) + 1;
            ArrayList arrayList = new ArrayList(c);
            arrayList.add(aVar);
            while (i < c) {
                a aVar2 = new a();
                aVar2.a = aVar.a;
                aVar2.d = aVar.d.duplicate();
                aVar2.d.position(aVar.d.position() + (i * 131072));
                arrayList.add(aVar2);
                i++;
            }
            return arrayList;
        }

        static void a(Parcel parcel, a aVar) {
            parcel.writeInt(aVar.a);
            if (aVar.c == null || aVar.c.remaining() <= 0) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(aVar.c.limit());
                parcel.writeByteArray(aVar.c.array(), 0, aVar.c.limit());
            }
            parcel.writeInt(aVar.b);
            if (aVar.d.remaining() > 0) {
                int min = Math.min(aVar.d.remaining(), 131072);
                parcel.writeInt(min);
                a.a(parcel, aVar.d.array(), aVar.d.position(), min);
                return;
            }
            parcel.writeInt(0);
        }

        private static boolean b(a aVar) {
            return aVar.d.capacity() == 0 || (aVar.b > 0 && aVar.d.position() == aVar.b);
        }
    }

    private a() {
    }

    public a(com.qiyukf.nimlib.a.c.a aVar) {
        this.a = a.a();
        com.qiyukf.nimlib.h.c.c.b bVar = new com.qiyukf.nimlib.h.c.c.b();
        aVar.a().a(bVar);
        this.c = bVar.b();
        com.qiyukf.nimlib.h.c.c.b b = aVar.b();
        this.d = b != null ? b.b() : ByteBuffer.allocate(0);
    }

    public a(com.qiyukf.nimlib.a.d.a.a aVar) {
        this.a = a.a();
        com.qiyukf.nimlib.h.c.c.b bVar = new com.qiyukf.nimlib.h.c.c.b();
        aVar.a.a(bVar);
        this.c = bVar.b();
        this.d = aVar.b != null ? aVar.b.b() : ByteBuffer.allocate(0);
    }

    static /* synthetic */ void a(Parcel parcel, byte[] bArr, int i, int i2) {
        if (VERSION.SDK_INT >= 11) {
            parcel.writeByteArray(bArr, i, i2);
            return;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        parcel.writeByteArray(bArr2);
    }

    public final List<a> a() {
        return b.a(this);
    }

    public final com.qiyukf.nimlib.h.c.a b() {
        if (this.c == null) {
            return null;
        }
        com.qiyukf.nimlib.h.c.a aVar = new com.qiyukf.nimlib.h.c.a();
        aVar.a(new f(this.c));
        return aVar;
    }

    public final ByteBuffer c() {
        return this.d;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(parcel, this);
    }
}
