package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: StatisticsManager */
public class O00OoOO0 {
    private static WeakReference<O00Oo00o> O000000o;

    public static void O000000o(final Context context) {
        O0000o.O00000o().submit(new Runnable() {
            public final void run() {
                try {
                    O00Oo00o O000000o = O00Ooo00.O000000o(O00OoOO0.O000000o);
                    O00Ooo00.O000000o(context, O000000o, O0000o00.O0000OOo, 1000, 307200, "2");
                    if (O000000o.O0000O0o == null) {
                        O000000o.O0000O0o = new O00o000(new O00o(context, new O00o00(new ooooooo(new O0O000o()))));
                    }
                    O000000o.O0000OOo = 3600000;
                    if (TextUtils.isEmpty(O000000o.O0000Oo0)) {
                        O000000o.O0000Oo0 = "cKey";
                    }
                    if (O000000o.O00000oo == null) {
                        O000000o.O00000oo = new O0O0O(context, O000000o.O0000OOo, O000000o.O0000Oo0, new O0O00o0(30, O000000o.O000000o, new O0O0OO(context)));
                    }
                    O00Oo0.O000000o(O000000o);
                } catch (Throwable th) {
                    O0000o.O00000Oo(th, "stm", "usd");
                }
            }
        });
    }

    public static synchronized void O000000o(final O00OoO0o o00OoO0o, final Context context) {
        synchronized (O00OoOO0.class) {
            O0000o.O00000o().submit(new Runnable() {
                public final void run() {
                    try {
                        synchronized (O00OoOO0.class) {
                            O00OoOO0.O000000o(context, o00OoO0o.O000000o());
                        }
                    } catch (Throwable th) {
                        O0000o.O00000Oo(th, "stm", "as");
                    }
                }
            });
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000e */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:5:0x0009, code skipped:
            if (r3.size() == 0) goto L_0x001e;
     */
    /* JADX WARNING: Missing block: B:8:?, code skipped:
            com.loc.O0000o.O00000o().submit(new com.loc.O00OoOO0.AnonymousClass2());
     */
    /* JADX WARNING: Missing block: B:10:0x001b, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:14:0x001f, code skipped:
            return;
     */
    public static synchronized void O000000o(final java.util.List<com.loc.O00OoO0o> r3, final android.content.Context r4) {
        /*
        r0 = com.loc.O00OoOO0.class;
        monitor-enter(r0);
        if (r3 == 0) goto L_0x001e;
    L_0x0005:
        r1 = r3.size();	 Catch:{ Throwable -> 0x000e }
        if (r1 != 0) goto L_0x000e;
    L_0x000b:
        goto L_0x001e;
    L_0x000c:
        r3 = move-exception;
        goto L_0x001c;
    L_0x000e:
        r1 = com.loc.O0000o.O00000o();	 Catch:{ all -> 0x000c }
        r2 = new com.loc.O00OoOO0$2;	 Catch:{ all -> 0x000c }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x000c }
        r1.submit(r2);	 Catch:{ all -> 0x000c }
        monitor-exit(r0);
        return;
    L_0x001c:
        monitor-exit(r0);
        throw r3;
    L_0x001e:
        monitor-exit(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00OoOO0.O000000o(java.util.List, android.content.Context):void");
    }
}
