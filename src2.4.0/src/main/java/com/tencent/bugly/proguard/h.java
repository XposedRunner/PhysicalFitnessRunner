package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public final class h {
    private StringBuilder a;
    private int b = 0;

    public h(StringBuilder stringBuilder, int i) {
        this.a = stringBuilder;
        this.b = i;
    }

    private <T> h a(T t, String str) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            byte byteValue = ((Byte) t).byteValue();
            a(str);
            stringBuilder = this.a;
            stringBuilder.append(byteValue);
            stringBuilder.append(10);
        } else if (t instanceof Boolean) {
            boolean booleanValue = ((Boolean) t).booleanValue();
            a(str);
            stringBuilder = this.a;
            stringBuilder.append(booleanValue ? 'T' : 'F');
            stringBuilder.append(10);
        } else if (t instanceof Short) {
            short shortValue = ((Short) t).shortValue();
            a(str);
            stringBuilder = this.a;
            stringBuilder.append(shortValue);
            stringBuilder.append(10);
        } else if (t instanceof Integer) {
            int intValue = ((Integer) t).intValue();
            a(str);
            stringBuilder = this.a;
            stringBuilder.append(intValue);
            stringBuilder.append(10);
        } else if (t instanceof Long) {
            long longValue = ((Long) t).longValue();
            a(str);
            stringBuilder2 = this.a;
            stringBuilder2.append(longValue);
            stringBuilder2.append(10);
        } else if (t instanceof Float) {
            float floatValue = ((Float) t).floatValue();
            a(str);
            stringBuilder = this.a;
            stringBuilder.append(floatValue);
            stringBuilder.append(10);
        } else if (t instanceof Double) {
            double doubleValue = ((Double) t).doubleValue();
            a(str);
            stringBuilder2 = this.a;
            stringBuilder2.append(doubleValue);
            stringBuilder2.append(10);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            List list = (List) t;
            if (list == null) {
                a(str);
                this.a.append("null\t");
            } else {
                a(list.toArray(), str);
            }
        } else if (t instanceof k) {
            a((k) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((boolean[]) t, str);
        } else {
            int i = 0;
            h hVar;
            int length;
            StringBuilder stringBuilder3;
            StringBuilder stringBuilder4;
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                a(str);
                if (sArr == null) {
                    this.a.append("null\n");
                } else if (sArr.length == 0) {
                    stringBuilder = this.a;
                    stringBuilder.append(sArr.length);
                    stringBuilder.append(", []\n");
                } else {
                    stringBuilder = this.a;
                    stringBuilder.append(sArr.length);
                    stringBuilder.append(", [\n");
                    hVar = new h(this.a, this.b + 1);
                    length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        hVar.a(null);
                        stringBuilder3 = hVar.a;
                        stringBuilder3.append(s);
                        stringBuilder3.append(10);
                        i++;
                    }
                    a(null);
                    stringBuilder2 = this.a;
                    stringBuilder2.append(']');
                    stringBuilder2.append(10);
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                a(str);
                if (iArr == null) {
                    this.a.append("null\n");
                } else if (iArr.length == 0) {
                    stringBuilder = this.a;
                    stringBuilder.append(iArr.length);
                    stringBuilder.append(", []\n");
                } else {
                    stringBuilder = this.a;
                    stringBuilder.append(iArr.length);
                    stringBuilder.append(", [\n");
                    hVar = new h(this.a, this.b + 1);
                    length = iArr.length;
                    while (i < length) {
                        int i2 = iArr[i];
                        hVar.a(null);
                        stringBuilder3 = hVar.a;
                        stringBuilder3.append(i2);
                        stringBuilder3.append(10);
                        i++;
                    }
                    a(null);
                    stringBuilder2 = this.a;
                    stringBuilder2.append(']');
                    stringBuilder2.append(10);
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                a(str);
                if (jArr == null) {
                    this.a.append("null\n");
                } else if (jArr.length == 0) {
                    stringBuilder = this.a;
                    stringBuilder.append(jArr.length);
                    stringBuilder.append(", []\n");
                } else {
                    stringBuilder = this.a;
                    stringBuilder.append(jArr.length);
                    stringBuilder.append(", [\n");
                    hVar = new h(this.a, this.b + 1);
                    length = jArr.length;
                    while (i < length) {
                        long j = jArr[i];
                        hVar.a(null);
                        stringBuilder4 = hVar.a;
                        stringBuilder4.append(j);
                        stringBuilder4.append(10);
                        i++;
                    }
                    a(null);
                    stringBuilder2 = this.a;
                    stringBuilder2.append(']');
                    stringBuilder2.append(10);
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                a(str);
                if (fArr == null) {
                    this.a.append("null\n");
                } else if (fArr.length == 0) {
                    stringBuilder = this.a;
                    stringBuilder.append(fArr.length);
                    stringBuilder.append(", []\n");
                } else {
                    stringBuilder = this.a;
                    stringBuilder.append(fArr.length);
                    stringBuilder.append(", [\n");
                    hVar = new h(this.a, this.b + 1);
                    length = fArr.length;
                    while (i < length) {
                        float f = fArr[i];
                        hVar.a(null);
                        stringBuilder3 = hVar.a;
                        stringBuilder3.append(f);
                        stringBuilder3.append(10);
                        i++;
                    }
                    a(null);
                    stringBuilder2 = this.a;
                    stringBuilder2.append(']');
                    stringBuilder2.append(10);
                }
            } else if (t instanceof double[]) {
                double[] dArr = (double[]) t;
                a(str);
                if (dArr == null) {
                    this.a.append("null\n");
                } else if (dArr.length == 0) {
                    stringBuilder = this.a;
                    stringBuilder.append(dArr.length);
                    stringBuilder.append(", []\n");
                } else {
                    stringBuilder = this.a;
                    stringBuilder.append(dArr.length);
                    stringBuilder.append(", [\n");
                    hVar = new h(this.a, this.b + 1);
                    length = dArr.length;
                    while (i < length) {
                        double d = dArr[i];
                        hVar.a(null);
                        stringBuilder4 = hVar.a;
                        stringBuilder4.append(d);
                        stringBuilder4.append(10);
                        i++;
                    }
                    a(null);
                    stringBuilder2 = this.a;
                    stringBuilder2.append(']');
                    stringBuilder2.append(10);
                }
            } else if (t.getClass().isArray()) {
                a((Object[]) t, str);
            } else {
                throw new b("write object error: unsupport type.");
            }
        }
        return this;
    }

    private <T> h a(T[] tArr, String str) {
        a(str);
        StringBuilder stringBuilder;
        if (tArr == null) {
            this.a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            stringBuilder = this.a;
            stringBuilder.append(tArr.length);
            stringBuilder.append(", []\n");
            return this;
        } else {
            stringBuilder = this.a;
            stringBuilder.append(tArr.length);
            stringBuilder.append(", [\n");
            h hVar = new h(this.a, this.b + 1);
            for (Object a : tArr) {
                hVar.a(a, null);
            }
            a(null);
            stringBuilder = this.a;
            stringBuilder.append(']');
            stringBuilder.append(10);
            return this;
        }
    }

    private void a(String str) {
        for (int i = 0; i < this.b; i++) {
            this.a.append(9);
        }
        if (str != null) {
            StringBuilder stringBuilder = this.a;
            stringBuilder.append(str);
            stringBuilder.append(": ");
        }
    }

    public final h a(byte b, String str) {
        a(str);
        StringBuilder stringBuilder = this.a;
        stringBuilder.append(b);
        stringBuilder.append(10);
        return this;
    }

    public final h a(int i, String str) {
        a(str);
        StringBuilder stringBuilder = this.a;
        stringBuilder.append(i);
        stringBuilder.append(10);
        return this;
    }

    public final h a(long j, String str) {
        a(str);
        StringBuilder stringBuilder = this.a;
        stringBuilder.append(j);
        stringBuilder.append(10);
        return this;
    }

    public final h a(k kVar, String str) {
        a(str);
        StringBuilder stringBuilder = this.a;
        stringBuilder.append('{');
        stringBuilder.append(10);
        if (kVar == null) {
            StringBuilder stringBuilder2 = this.a;
            stringBuilder2.append(9);
            stringBuilder2.append("null");
        } else {
            kVar.a(this.a, this.b + 1);
        }
        a(null);
        stringBuilder = this.a;
        stringBuilder.append('}');
        stringBuilder.append(10);
        return this;
    }

    public final h a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.a.append("null\n");
        } else {
            StringBuilder stringBuilder = this.a;
            stringBuilder.append(str);
            stringBuilder.append(10);
        }
        return this;
    }

    public final <K, V> h a(Map<K, V> map, String str) {
        a(str);
        StringBuilder stringBuilder;
        if (map == null) {
            this.a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            stringBuilder = this.a;
            stringBuilder.append(map.size());
            stringBuilder.append(", {}\n");
            return this;
        } else {
            stringBuilder = this.a;
            stringBuilder.append(map.size());
            stringBuilder.append(", {\n");
            h hVar = new h(this.a, this.b + 1);
            h hVar2 = new h(this.a, this.b + 2);
            for (Entry entry : map.entrySet()) {
                hVar.a(null);
                StringBuilder stringBuilder2 = hVar.a;
                stringBuilder2.append('(');
                stringBuilder2.append(10);
                hVar2.a(entry.getKey(), null);
                hVar2.a(entry.getValue(), null);
                hVar.a(null);
                StringBuilder stringBuilder3 = hVar.a;
                stringBuilder3.append(')');
                stringBuilder3.append(10);
            }
            a(null);
            stringBuilder = this.a;
            stringBuilder.append('}');
            stringBuilder.append(10);
            return this;
        }
    }

    public final h a(short s, String str) {
        a(str);
        StringBuilder stringBuilder = this.a;
        stringBuilder.append(s);
        stringBuilder.append(10);
        return this;
    }

    public final h a(boolean z, String str) {
        a(str);
        StringBuilder stringBuilder = this.a;
        stringBuilder.append(z ? 'T' : 'F');
        stringBuilder.append(10);
        return this;
    }

    public final h a(byte[] bArr, String str) {
        a(str);
        StringBuilder stringBuilder;
        if (bArr == null) {
            this.a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            stringBuilder = this.a;
            stringBuilder.append(bArr.length);
            stringBuilder.append(", []\n");
            return this;
        } else {
            stringBuilder = this.a;
            stringBuilder.append(bArr.length);
            stringBuilder.append(", [\n");
            h hVar = new h(this.a, this.b + 1);
            for (byte b : bArr) {
                hVar.a(null);
                StringBuilder stringBuilder2 = hVar.a;
                stringBuilder2.append(b);
                stringBuilder2.append(10);
            }
            a(null);
            stringBuilder = this.a;
            stringBuilder.append(']');
            stringBuilder.append(10);
            return this;
        }
    }
}
