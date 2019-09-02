package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OfflineDBOperation */
public class O00Oo {
    private static volatile O00Oo O000000o;
    private static oO0O0o0o O00000Oo;
    private Context O00000o0;

    private O00Oo(Context context) {
        this.O00000o0 = context;
        O00000Oo = O00000Oo(this.O00000o0);
    }

    public static O00Oo O000000o(Context context) {
        if (O000000o == null) {
            synchronized (O00Oo.class) {
                if (O000000o == null) {
                    O000000o = new O00Oo(context);
                }
            }
        }
        return O000000o;
    }

    private List<String> O000000o(List<O00Oo0> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            for (O00Oo0 O000000o : list) {
                arrayList.add(O000000o.O000000o());
            }
        }
        return arrayList;
    }

    private void O000000o(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            String O000000o = O00Oo0.O000000o(str);
            if (O00000Oo.O00000Oo(O000000o, O00Oo0.class).size() > 0) {
                O00000Oo.O000000o(O000000o, O00Oo0.class);
            }
            String[] split = str2.split(";");
            List arrayList = new ArrayList();
            for (String o00Oo0 : split) {
                arrayList.add(new O00Oo0(str, o00Oo0));
            }
            O00000Oo.O000000o(arrayList);
        }
    }

    private oO0O0o0o O00000Oo(Context context) {
        try {
            return new oO0O0o0o(context, O00Oo0o0.O000000o());
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    private boolean O00000Oo() {
        if (O00000Oo == null) {
            O00000Oo = O00000Oo(this.O00000o0);
        }
        return O00000Oo != null;
    }

    public synchronized O00Oo00 O000000o(String str) {
        if (!O00000Oo()) {
            return null;
        }
        List O00000Oo = O00000Oo.O00000Oo(O00Oo0OO.O00000oO(str), O00Oo00.class);
        if (O00000Oo.size() <= 0) {
            return null;
        }
        return (O00Oo00) O00000Oo.get(0);
    }

    public ArrayList<O00Oo00> O000000o() {
        ArrayList arrayList = new ArrayList();
        if (!O00000Oo()) {
            return arrayList;
        }
        for (O00Oo00 add : O00000Oo.O00000Oo("", O00Oo00.class)) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public synchronized void O000000o(O00Oo00 o00Oo00) {
        if (O00000Oo()) {
            O00000Oo.O000000o((Object) o00Oo00, O00Oo0OO.O00000oo(o00Oo00.O0000Oo0()));
            O000000o(o00Oo00.O00000oo(), o00Oo00.O00000Oo());
        }
    }

    public void O000000o(String str, int i, long j, long j2, long j3) {
        if (O00000Oo()) {
            O000000o(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    public synchronized void O000000o(String str, int i, long j, long[] jArr, long[] jArr2) {
        try {
            if (O00000Oo()) {
                long j2 = jArr[0];
                long j3 = jArr2[0];
            }
        } finally {
            Object obj = r0;
        }
    }

    public synchronized List<String> O00000Oo(String str) {
        ArrayList arrayList = new ArrayList();
        if (!O00000Oo()) {
            return arrayList;
        }
        arrayList.addAll(O000000o(O00000Oo.O00000Oo(O00Oo0.O000000o(str), O00Oo0.class)));
        return arrayList;
    }

    public synchronized void O00000Oo(O00Oo00 o00Oo00) {
        if (O00000Oo()) {
            O00000Oo.O000000o(O00Oo0OO.O00000oo(o00Oo00.O0000Oo0()), O00Oo0OO.class);
            O00000Oo.O000000o(O00Oo0.O000000o(o00Oo00.O00000oo()), O00Oo0.class);
            O00000Oo.O000000o(O00Oo00o.O000000o(o00Oo00.O00000oo()), O00Oo00o.class);
        }
    }

    /* JADX WARNING: Missing block: B:12:0x0028, code skipped:
            return r0;
     */
    public synchronized java.lang.String O00000o(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 0;
        r1 = r3.O00000Oo();	 Catch:{ all -> 0x0029 }
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r3);
        return r0;
    L_0x000a:
        r4 = com.amap.api.mapcore.util.O00Oo0OO.O00000oo(r4);	 Catch:{ all -> 0x0029 }
        r1 = O00000Oo;	 Catch:{ all -> 0x0029 }
        r2 = com.amap.api.mapcore.util.O00Oo0OO.class;
        r4 = r1.O00000Oo(r4, r2);	 Catch:{ all -> 0x0029 }
        r1 = r4.size();	 Catch:{ all -> 0x0029 }
        if (r1 <= 0) goto L_0x0027;
    L_0x001c:
        r0 = 0;
        r4 = r4.get(r0);	 Catch:{ all -> 0x0029 }
        r4 = (com.amap.api.mapcore.util.O00Oo0OO) r4;	 Catch:{ all -> 0x0029 }
        r0 = r4.O00000oO();	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r3);
        return r0;
    L_0x0029:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00Oo.O00000o(java.lang.String):java.lang.String");
    }

    public synchronized void O00000o0(String str) {
        if (O00000Oo()) {
            O00000Oo.O000000o(O00Oo0OO.O00000oO(str), O00Oo0OO.class);
            O00000Oo.O000000o(O00Oo0.O000000o(str), O00Oo0.class);
            O00000Oo.O000000o(O00Oo00o.O000000o(str), O00Oo00o.class);
        }
    }
}
