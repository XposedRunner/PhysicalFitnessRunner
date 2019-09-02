package com.loc;

import com.amap.api.maps.AMapException;
import java.net.URLConnection;

/* compiled from: BaseNetManager */
public final class O00O0o {
    public static int O000000o = 0;
    public static String O00000Oo = "";
    private static O00O0o O00000o0;

    /* compiled from: BaseNetManager */
    public interface O000000o {
        URLConnection O000000o();
    }

    public static O00O0o O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new O00O0o();
        }
        return O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008a A:{Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }} */
    public static com.loc.O00Oo00 O000000o(com.loc.O00OOo r7, boolean r8) throws com.loc.OO00Oo0 {
        /*
        if (r7 != 0) goto L_0x0010;
    L_0x0002:
        r7 = new com.loc.OO00Oo0;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r8 = "requeust is null";
        r7.<init>(r8);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        throw r7;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
    L_0x000a:
        r7 = move-exception;
        goto L_0x009e;
    L_0x000d:
        r7 = move-exception;
        goto L_0x00a9;
    L_0x0010:
        r0 = r7.O00000o0();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r0 == 0) goto L_0x0096;
    L_0x0016:
        r0 = "";
        r1 = r7.O00000o0();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r0 = r0.equals(r1);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r0 == 0) goto L_0x0024;
    L_0x0022:
        goto L_0x0096;
    L_0x0024:
        r0 = r7.O00000oO;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r0 != 0) goto L_0x002a;
    L_0x0028:
        r0 = 0;
        goto L_0x002c;
    L_0x002a:
        r0 = r7.O00000oO;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
    L_0x002c:
        r1 = new com.loc.O00OOo0;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r2 = r7.O00000o0;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r3 = r7.O00000o;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r1.<init>(r2, r3, r0, r8);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r8 = r7.O00000o();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r8 == 0) goto L_0x0045;
    L_0x003b:
        r8 = r8.length;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r8 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0045;
    L_0x003f:
        r8 = r7.O00000Oo();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r8 != 0) goto L_0x004a;
    L_0x0045:
        r8 = r7.O00000o0();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        goto L_0x0066;
    L_0x004a:
        r8 = com.loc.O00OOo0.O000000o(r8);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r0 = new java.lang.StringBuffer;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r0.<init>();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r2 = r7.O00000o0();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r0.append(r2);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r2 = "?";
        r0.append(r2);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r0.append(r8);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r8 = r0.toString();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
    L_0x0066:
        r2 = r8;
        r3 = r7.O0000Ooo();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r4 = r7.O0000OoO();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r5 = r7.O000000o();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r8 = r7.O00000o();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r8 == 0) goto L_0x007c;
    L_0x0079:
        r0 = r8.length;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r0 != 0) goto L_0x0090;
    L_0x007c:
        r7 = r7.O00000Oo();	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r7 = com.loc.O00OOo0.O000000o(r7);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r0 = android.text.TextUtils.isEmpty(r7);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        if (r0 != 0) goto L_0x0090;
    L_0x008a:
        r7 = com.loc.OO0o000.O000000o(r7);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r6 = r7;
        goto L_0x0091;
    L_0x0090:
        r6 = r8;
    L_0x0091:
        r7 = r1.O000000o(r2, r3, r4, r5, r6);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        return r7;
    L_0x0096:
        r7 = new com.loc.OO00Oo0;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        r8 = "request url is empty";
        r7.<init>(r8);	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
        throw r7;	 Catch:{ OO00Oo0 -> 0x000d, Throwable -> 0x000a }
    L_0x009e:
        r7.printStackTrace();
        r7 = new com.loc.OO00Oo0;
        r8 = "未知的错误";
        r7.<init>(r8);
        throw r7;
    L_0x00a9:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00O0o.O000000o(com.loc.O00OOo, boolean):com.loc.O00Oo00");
    }

    public static byte[] O000000o(O00OOo o00OOo) throws OO00Oo0 {
        OO00Oo0 e;
        try {
            O00Oo00 O000000o = O000000o(o00OOo, true);
            return O000000o != null ? O000000o.O000000o : null;
        } catch (OO00Oo0 e2) {
            throw e2;
        } catch (Throwable unused) {
            e2 = new OO00Oo0(AMapException.ERROR_UNKNOWN);
        }
    }

    public static byte[] O00000Oo(O00OOo o00OOo) throws OO00Oo0 {
        OO00Oo0 e;
        try {
            O00Oo00 O000000o = O000000o(o00OOo, false);
            return O000000o != null ? O000000o.O000000o : null;
        } catch (OO00Oo0 e2) {
            throw e2;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "bm", "msp");
            e2 = new OO00Oo0(AMapException.ERROR_UNKNOWN);
        }
    }
}
