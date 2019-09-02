package com.tencent.bugly.proguard;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public final class i {
    private ByteBuffer a;
    private String b = "GBK";

    /* compiled from: BUGLY */
    public static class a {
        public byte a;
        public int b;
    }

    public i(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    public i(byte[] bArr, int i) {
        this.a = ByteBuffer.wrap(bArr);
        this.a.position(4);
    }

    private double a(double d, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b = aVar.a;
            if (b == (byte) 12) {
                return 0.0d;
            }
            switch (b) {
                case (byte) 4:
                    return (double) this.a.getFloat();
                case (byte) 5:
                    return this.a.getDouble();
                default:
                    throw new g("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new g("require field not exist.");
        }
    }

    private float a(float f, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b = aVar.a;
            if (b == (byte) 4) {
                return this.a.getFloat();
            }
            if (b == (byte) 12) {
                return 0.0f;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new g("require field not exist.");
        }
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        aVar.b = (b & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Entry entry = (Entry) map2.entrySet().iterator().next();
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 8) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            for (int i2 = 0; i2 < a; i2++) {
                map.put(a(key, 0, true), a(value, 1, true));
            }
        } else if (z) {
            throw new g("require field not exist.");
        }
        return map;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.a);
            a(aVar.a);
        } while (aVar.a != (byte) 11);
    }

    private void a(byte b) {
        int i = 0;
        int i2;
        a aVar;
        switch (b) {
            case (byte) 0:
                this.a.position(this.a.position() + 1);
                return;
            case (byte) 1:
                this.a.position(this.a.position() + 2);
                return;
            case (byte) 2:
                this.a.position(this.a.position() + 4);
                return;
            case (byte) 3:
                this.a.position(this.a.position() + 8);
                return;
            case (byte) 4:
                this.a.position(this.a.position() + 4);
                return;
            case (byte) 5:
                this.a.position(this.a.position() + 8);
                return;
            case (byte) 6:
                i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                this.a.position(this.a.position() + i2);
                return;
            case (byte) 7:
                this.a.position(this.a.position() + this.a.getInt());
                return;
            case (byte) 8:
                i2 = a(0, 0, true);
                while (i < (i2 << 1)) {
                    aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i++;
                }
                return;
            case (byte) 9:
                i2 = a(0, 0, true);
                while (i < i2) {
                    a aVar2 = new a();
                    a(aVar2, this.a);
                    a(aVar2.a);
                    i++;
                }
                return;
            case (byte) 10:
                a();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                aVar = new a();
                a(aVar, this.a);
                if (aVar.a != (byte) 0) {
                    StringBuilder stringBuilder = new StringBuilder("skipField with invalid type, type value: ");
                    stringBuilder.append(b);
                    stringBuilder.append(", ");
                    stringBuilder.append(aVar.a);
                    throw new g(stringBuilder.toString());
                }
                this.a.position(this.a.position() + a(0, 0, true));
                return;
            default:
                throw new g("invalid type.");
        }
    }

    private boolean a(int i) {
        try {
            a aVar = new a();
            while (true) {
                int a = a(aVar, this.a.duplicate());
                if (i <= aVar.b) {
                    break;
                } else if (aVar.a == (byte) 11) {
                    break;
                } else {
                    this.a.position(this.a.position() + a);
                    a(aVar.a);
                }
            }
            return i == aVar.b;
        } catch (g | BufferUnderflowException unused) {
            return false;
        }
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return b(tArr[0], i, z);
        }
        throw new g("unable to get type of key and value.");
    }

    private <T> T[] b(T t, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
            for (int i2 = 0; i2 < a; i2++) {
                objArr[i2] = a((Object) t, 0, true);
            }
            return objArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private boolean[] d(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            boolean[] zArr = new boolean[a];
            for (int i2 = 0; i2 < a; i2++) {
                zArr[i2] = a((byte) 0, 0, true) != (byte) 0;
            }
            return zArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private short[] e(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            short[] sArr = new short[a];
            for (int i2 = 0; i2 < a; i2++) {
                sArr[i2] = a(sArr[0], 0, true);
            }
            return sArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private int[] f(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            int[] iArr = new int[a];
            for (int i2 = 0; i2 < a; i2++) {
                iArr[i2] = a(iArr[0], 0, true);
            }
            return iArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private long[] g(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            long[] jArr = new long[a];
            for (int i2 = 0; i2 < a; i2++) {
                jArr[i2] = a(jArr[0], 0, true);
            }
            return jArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private float[] h(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            float[] fArr = new float[a];
            for (int i2 = 0; i2 < a; i2++) {
                fArr[i2] = a(fArr[0], 0, true);
            }
            return fArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private double[] i(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a != (byte) 9) {
                throw new g("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                stringBuilder.append(a);
                throw new g(stringBuilder.toString());
            }
            double[] dArr = new double[a];
            for (int i2 = 0; i2 < a; i2++) {
                dArr[i2] = a(dArr[0], 0, true);
            }
            return dArr;
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final byte a(byte b, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            b = aVar.a;
            if (b == (byte) 0) {
                return this.a.get();
            }
            if (b == (byte) 12) {
                return (byte) 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return b;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (a(i2)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b = aVar.a;
            if (b == (byte) 12) {
                return 0;
            }
            switch (b) {
                case (byte) 0:
                    return this.a.get();
                case (byte) 1:
                    return this.a.getShort();
                case (byte) 2:
                    return this.a.getInt();
                default:
                    throw new g("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }

    public final long a(long j, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b = aVar.a;
            if (b == (byte) 12) {
                return 0;
            }
            switch (b) {
                case (byte) 0:
                    return (long) this.a.get();
                case (byte) 1:
                    return (long) this.a.getShort();
                case (byte) 2:
                    return (long) this.a.getInt();
                case (byte) 3:
                    return this.a.getLong();
                default:
                    throw new g("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final k a(k kVar, int i, boolean z) {
        if (a(i)) {
            try {
                kVar = (k) kVar.getClass().newInstance();
                a aVar = new a();
                a(aVar, this.a);
                if (aVar.a != (byte) 10) {
                    throw new g("type mismatch.");
                }
                kVar.a(this);
                a();
                return kVar;
            } catch (Exception e) {
                throw new g(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final <T> Object a(T t, int i, boolean z) {
        int i2 = 0;
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            boolean z2;
            if (a((byte) 0, i, z) != (byte) 0) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } else if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        } else {
            if (t instanceof Integer) {
                return Integer.valueOf(a(0, i, z));
            }
            if (t instanceof Long) {
                return Long.valueOf(a(0, i, z));
            }
            if (t instanceof Float) {
                return Float.valueOf(a(0.0f, i, z));
            }
            if (t instanceof Double) {
                return Double.valueOf(a(0.0d, i, z));
            }
            if (t instanceof String) {
                return String.valueOf(b(i, z));
            }
            if (t instanceof Map) {
                return (HashMap) a(new HashMap(), (Map) t, i, z);
            } else if (t instanceof List) {
                List list = (List) t;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b = b(list.get(0), i, z);
                if (b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (i2 < b.length) {
                    arrayList.add(b[i2]);
                    i2++;
                }
                return arrayList;
            } else if (t instanceof k) {
                return a((k) t, i, z);
            } else {
                if (t.getClass().isArray()) {
                    return ((t instanceof byte[]) || (t instanceof Byte[])) ? c(i, z) : t instanceof boolean[] ? d(i, z) : t instanceof short[] ? e(i, z) : t instanceof int[] ? f(i, z) : t instanceof long[] ? g(i, z) : t instanceof float[] ? h(i, z) : t instanceof double[] ? i(i, z) : a((Object[]) t, i, z);
                } else {
                    throw new g("read object error: unsupport type.");
                }
            }
        }
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    public final short a(short s, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b = aVar.a;
            if (b == (byte) 12) {
                return (short) 0;
            }
            switch (b) {
                case (byte) 0:
                    return (short) this.a.get();
                case (byte) 1:
                    return this.a.getShort();
                default:
                    throw new g("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final void a(byte[] bArr) {
        if (this.a != null) {
            this.a.clear();
        }
        this.a = ByteBuffer.wrap(bArr);
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != (byte) 0;
    }

    public final String b(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte[] bArr;
            switch (aVar.a) {
                case (byte) 6:
                    i = this.a.get();
                    if (i < 0) {
                        i += 256;
                    }
                    bArr = new byte[i];
                    this.a.get(bArr);
                    try {
                        return new String(bArr, this.b);
                    } catch (UnsupportedEncodingException unused) {
                        return new String(bArr);
                    }
                case (byte) 7:
                    i = this.a.getInt();
                    if (i > 104857600 || i < 0) {
                        StringBuilder stringBuilder = new StringBuilder("String too long: ");
                        stringBuilder.append(i);
                        throw new g(stringBuilder.toString());
                    }
                    bArr = new byte[i];
                    this.a.get(bArr);
                    try {
                        return new String(bArr, this.b);
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(bArr);
                    }
                default:
                    throw new g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final byte[] c(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b = aVar.a;
            if (b == (byte) 9) {
                i = a(0, 0, true);
                if (i < 0) {
                    StringBuilder stringBuilder = new StringBuilder("size invalid: ");
                    stringBuilder.append(i);
                    throw new g(stringBuilder.toString());
                }
                byte[] bArr = new byte[i];
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = a(bArr[0], 0, true);
                }
                return bArr;
            } else if (b != (byte) 13) {
                throw new g("type mismatch.");
            } else {
                a aVar2 = new a();
                a(aVar2, this.a);
                if (aVar2.a != (byte) 0) {
                    StringBuilder stringBuilder2 = new StringBuilder("type mismatch, tag: ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(", type: ");
                    stringBuilder2.append(aVar.a);
                    stringBuilder2.append(", ");
                    stringBuilder2.append(aVar2.a);
                    throw new g(stringBuilder2.toString());
                }
                int a = a(0, 0, true);
                if (a < 0) {
                    StringBuilder stringBuilder3 = new StringBuilder("invalid size, tag: ");
                    stringBuilder3.append(i);
                    stringBuilder3.append(", type: ");
                    stringBuilder3.append(aVar.a);
                    stringBuilder3.append(", ");
                    stringBuilder3.append(aVar2.a);
                    stringBuilder3.append(", size: ");
                    stringBuilder3.append(a);
                    throw new g(stringBuilder3.toString());
                }
                byte[] bArr2 = new byte[a];
                this.a.get(bArr2);
                return bArr2;
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }
}
