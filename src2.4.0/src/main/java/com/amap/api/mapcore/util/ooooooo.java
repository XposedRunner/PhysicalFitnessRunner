package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.o0O0O0o0.O000000o;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AbstractProtocalHandler */
public abstract class ooooooo<T, V> {
    protected T O000000o;
    protected int O00000Oo = 3;
    protected Context O00000o0;

    public ooooooo(Context context, T t) {
        O000000o(context, t);
    }

    private void O000000o(Context context, T t) {
        this.O00000o0 = context;
        this.O000000o = t;
    }

    public abstract String O000000o();

    public abstract JSONObject O000000o(O000000o o000000o);

    public abstract V O00000Oo(JSONObject jSONObject) throws AMapException;

    public abstract Map<String, String> O00000Oo();

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0004 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0004 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    public V O00000o() throws com.amap.api.maps.AMapException {
        /*
        r9 = this;
        r0 = 0;
        r1 = 0;
        r2 = r0;
        r3 = r2;
    L_0x0004:
        r4 = r9.O00000Oo;
        if (r1 >= r4) goto L_0x0053;
    L_0x0008:
        r4 = r9.O00000o0;	 Catch:{ Throwable -> 0x0032 }
        r5 = com.amap.api.mapcore.util.OOo000.O00000oO();	 Catch:{ Throwable -> 0x0032 }
        r6 = r9.O000000o();	 Catch:{ Throwable -> 0x0032 }
        r7 = r9.O00000Oo();	 Catch:{ Throwable -> 0x0032 }
        r4 = com.amap.api.mapcore.util.o0O0O0o0.O000000o(r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0032 }
        r3 = r9.O000000o(r4);	 Catch:{ Throwable -> 0x002d }
        r3 = r9.O00000Oo(r3);	 Catch:{ Throwable -> 0x002d }
        r2 = r9.O00000Oo;	 Catch:{ Throwable -> 0x0028 }
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x0004;
    L_0x0028:
        r2 = move-exception;
        r8 = r4;
        r4 = r2;
        r2 = r3;
        goto L_0x0030;
    L_0x002d:
        r3 = move-exception;
        r8 = r4;
        r4 = r3;
    L_0x0030:
        r3 = r8;
        goto L_0x0033;
    L_0x0032:
        r4 = move-exception;
    L_0x0033:
        r5 = "AbstractProtocalHandler";
        r6 = "getDataMayThrow AMapException";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r4, r5, r6);
        r4.printStackTrace();
        r1 = r1 + 1;
        r4 = r9.O00000Oo;
        if (r1 < r4) goto L_0x0004;
    L_0x0043:
        if (r3 == 0) goto L_0x0051;
    L_0x0045:
        r2 = r3.O000000o;
        if (r2 == 0) goto L_0x0051;
    L_0x0049:
        r0 = new com.amap.api.maps.AMapException;
        r1 = r3.O000000o;
        r0.<init>(r1);
        throw r0;
    L_0x0051:
        r2 = r0;
        goto L_0x0004;
    L_0x0053:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ooooooo.O00000o():java.lang.Object");
    }

    public V O00000o0() throws AMapException {
        return this.O000000o != null ? O00000o() : null;
    }
}
