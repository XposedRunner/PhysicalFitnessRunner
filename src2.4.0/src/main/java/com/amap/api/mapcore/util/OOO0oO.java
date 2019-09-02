package com.amap.api.mapcore.util;

import cn.jiguang.net.HttpUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class OOO0oO<K, V> {
    private final LinkedHashMap<K, V> O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;

    public OOO0oO(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.O00000o0 = i;
        this.O000000o = new LinkedHashMap(0, 0.75f, true);
    }

    private void O000000o(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.O00000Oo >= 0 && this.O000000o.isEmpty()) {
                    int i2 = this.O00000Oo;
                }
                if (this.O00000Oo <= i) {
                    return;
                }
                Entry entry = null;
                for (Entry entry2 : this.O000000o.entrySet()) {
                }
                if (entry2 == null) {
                    return;
                }
                key = entry2.getKey();
                value = entry2.getValue();
                this.O000000o.remove(key);
                this.O00000Oo -= O00000o0(key, value);
                this.O00000oo++;
            }
            O000000o(true, key, value, null);
        }
        while (true) {
        }
    }

    private int O00000o0(K k, V v) {
        int O00000Oo = O00000Oo(k, v);
        if (O00000Oo >= 0) {
            return O00000Oo;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append(HttpUtils.EQUAL_SIGN);
        stringBuilder.append(v);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* JADX WARNING: Missing block: B:12:0x0022, code skipped:
            r0 = O00000Oo(r5);
     */
    /* JADX WARNING: Missing block: B:13:0x0026, code skipped:
            if (r0 != null) goto L_0x002a;
     */
    /* JADX WARNING: Missing block: B:15:0x0029, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:16:0x002a, code skipped:
            monitor-enter(r4);
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            r4.O00000oO++;
            r1 = r4.O000000o.put(r5, r0);
     */
    /* JADX WARNING: Missing block: B:19:0x0037, code skipped:
            if (r1 == null) goto L_0x003f;
     */
    /* JADX WARNING: Missing block: B:20:0x0039, code skipped:
            r4.O000000o.put(r5, r1);
     */
    /* JADX WARNING: Missing block: B:21:0x003f, code skipped:
            r4.O00000Oo += O00000o0(r5, r0);
     */
    /* JADX WARNING: Missing block: B:22:0x0048, code skipped:
            monitor-exit(r4);
     */
    /* JADX WARNING: Missing block: B:23:0x0049, code skipped:
            if (r1 == null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:24:0x004b, code skipped:
            O000000o(false, r5, r0, r1);
     */
    /* JADX WARNING: Missing block: B:25:0x004f, code skipped:
            return r1;
     */
    /* JADX WARNING: Missing block: B:26:0x0050, code skipped:
            O000000o(r4.O00000o0);
     */
    /* JADX WARNING: Missing block: B:27:0x0055, code skipped:
            return r0;
     */
    public final V O000000o(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r5 = new java.lang.NullPointerException;
        r0 = "key == null";
        r5.<init>(r0);
        throw r5;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.O000000o;	 Catch:{ all -> 0x0059 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r5 = r4.O0000O0o;	 Catch:{ all -> 0x0059 }
        r5 = r5 + 1;
        r4.O0000O0o = r5;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        return r0;
    L_0x001b:
        r0 = r4.O0000OOo;	 Catch:{ all -> 0x0059 }
        r0 = r0 + 1;
        r4.O0000OOo = r0;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        r0 = r4.O00000Oo(r5);
        if (r0 != 0) goto L_0x002a;
    L_0x0028:
        r5 = 0;
        return r5;
    L_0x002a:
        monitor-enter(r4);
        r1 = r4.O00000oO;	 Catch:{ all -> 0x0056 }
        r1 = r1 + 1;
        r4.O00000oO = r1;	 Catch:{ all -> 0x0056 }
        r1 = r4.O000000o;	 Catch:{ all -> 0x0056 }
        r1 = r1.put(r5, r0);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x003f;
    L_0x0039:
        r2 = r4.O000000o;	 Catch:{ all -> 0x0056 }
        r2.put(r5, r1);	 Catch:{ all -> 0x0056 }
        goto L_0x0048;
    L_0x003f:
        r2 = r4.O00000Oo;	 Catch:{ all -> 0x0056 }
        r3 = r4.O00000o0(r5, r0);	 Catch:{ all -> 0x0056 }
        r2 = r2 + r3;
        r4.O00000Oo = r2;	 Catch:{ all -> 0x0056 }
    L_0x0048:
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0050;
    L_0x004b:
        r2 = 0;
        r4.O000000o(r2, r5, r0, r1);
        return r1;
    L_0x0050:
        r5 = r4.O00000o0;
        r4.O000000o(r5);
        return r0;
    L_0x0056:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        throw r5;
    L_0x0059:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OOO0oO.O000000o(java.lang.Object):java.lang.Object");
    }

    public final V O000000o(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        Object put;
        synchronized (this) {
            this.O00000o++;
            this.O00000Oo += O00000o0(k, v);
            put = this.O000000o.put(k, v);
            if (put != null) {
                this.O00000Oo -= O00000o0(k, put);
            }
        }
        if (put != null) {
            O000000o(false, k, put, v);
        }
        O000000o(this.O00000o0);
        return put;
    }

    public final void O000000o() {
        O000000o(-1);
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(boolean z, K k, V v, V v2) {
    }

    /* Access modifiers changed, original: protected */
    public int O00000Oo(K k, V v) {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public V O00000Oo(K k) {
        return null;
    }

    public final synchronized String toString() {
        int i;
        i = this.O0000O0o + this.O0000OOo;
        i = i != 0 ? (100 * this.O0000O0o) / i : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.O00000o0), Integer.valueOf(this.O0000O0o), Integer.valueOf(this.O0000OOo), Integer.valueOf(i)});
    }
}
