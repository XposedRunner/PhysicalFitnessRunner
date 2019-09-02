package com.geetest.sdk;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;

/* compiled from: PingUtils */
public final class O0O0O {
    private int O000000o;
    private int O00000Oo;
    private O0O0O0o O00000o;
    private String O00000o0;

    public O0O0O(String str) {
        this(str, (byte) 0);
    }

    private O0O0O(String str, byte b) {
        this.O000000o = 32;
        this.O00000Oo = 10;
        this.O00000o0 = str;
        this.O00000o = new O0O0O0o();
    }

    private static String O000000o(String str) {
        try {
            if (str.contains("ping")) {
                str = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
            } else {
                str = null;
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private O0O0O0o O00000Oo() {
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o.O00000Oo(1);
            return this.O00000o;
        }
        int i = this.O00000Oo;
        int i2 = this.O000000o;
        String O00000Oo = O00000Oo(String.format("/system/bin/ping -c %d -w %d  %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), O00000Oo}));
        if (O00000Oo != null) {
            try {
                String substring;
                this.O00000o.O00000Oo(0);
                this.O00000o.O000000o(O000000o(O00000Oo));
                O0O0O0o o0O0O0o = this.O00000o;
                try {
                    if (O00000Oo.contains("statistics")) {
                        substring = O00000Oo.substring(O00000Oo.indexOf("\n", O00000Oo.indexOf("statistics")) + 1);
                        for (String str : substring.substring(0, substring.indexOf("\n")).split(", ")) {
                            if (str.contains(" packets transmitted")) {
                                o0O0O0o.O00000o0(Integer.parseInt(str.substring(0, str.indexOf(" packets transmitted"))));
                            }
                            if (str.contains(" received")) {
                                o0O0O0o.O00000o(Integer.parseInt(str.substring(0, str.indexOf(" received"))));
                            }
                            if (str.contains(" errors")) {
                                o0O0O0o.O00000Oo(Integer.parseInt(str.substring(0, str.indexOf(" errors"))));
                            }
                            if (str.contains(" packet loss")) {
                                o0O0O0o.O000000o(Float.parseFloat(str.substring(0, str.indexOf("%"))));
                            }
                            if (str.contains("time")) {
                                o0O0O0o.O000000o(Integer.parseInt(str.substring(str.lastIndexOf("e") + 2, str.indexOf("ms"))));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                o0O0O0o = this.O00000o;
                try {
                    if (O00000Oo.contains("rtt")) {
                        substring = O00000Oo.substring(O00000Oo.indexOf("rtt"));
                        String[] split = substring.substring(substring.indexOf(HttpUtils.EQUAL_SIGN) + 2).split(HttpUtils.PATHS_SEPARATOR);
                        o0O0O0o.O00000oO(Float.parseFloat(split[0]));
                        o0O0O0o.O00000Oo(Float.parseFloat(split[1]));
                        o0O0O0o.O00000o(Float.parseFloat(split[2]));
                        o0O0O0o.O00000o0(Float.parseFloat(split[3].substring(0, split[3].indexOf(" ms"))));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                O0O0O0o o0O0O0o2 = this.O00000o;
                try {
                    if (O00000Oo.contains("ttl")) {
                        O00000Oo = O00000Oo.substring(O00000Oo.indexOf("ttl"), O00000Oo.indexOf("\n", O00000Oo.indexOf("ttl")));
                        o0O0O0o2.O00000oO(Integer.parseInt(O00000Oo.substring(4, O00000Oo.indexOf(" "))));
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e32) {
                e32.printStackTrace();
            }
        }
        return this.O00000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    private static java.lang.String O00000Oo(java.lang.String r6) {
        /*
        r0 = 0;
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x0042, all -> 0x003d }
        r6 = r1.exec(r6);	 Catch:{ IOException -> 0x0042, all -> 0x003d }
        r1 = r6.getInputStream();	 Catch:{ IOException -> 0x003b }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x003b }
        r3 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x003b }
        r3.<init>(r1);	 Catch:{ IOException -> 0x003b }
        r2.<init>(r3);	 Catch:{ IOException -> 0x003b }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003b }
        r3.<init>();	 Catch:{ IOException -> 0x003b }
    L_0x001c:
        r4 = r2.readLine();	 Catch:{ IOException -> 0x003b }
        if (r4 == 0) goto L_0x002b;
    L_0x0022:
        r3.append(r4);	 Catch:{ IOException -> 0x003b }
        r4 = "\n";
        r3.append(r4);	 Catch:{ IOException -> 0x003b }
        goto L_0x001c;
    L_0x002b:
        r2.close();	 Catch:{ IOException -> 0x003b }
        r1.close();	 Catch:{ IOException -> 0x003b }
        r1 = r3.toString();	 Catch:{ IOException -> 0x003b }
        if (r6 == 0) goto L_0x003a;
    L_0x0037:
        r6.destroy();
    L_0x003a:
        return r1;
    L_0x003b:
        r1 = move-exception;
        goto L_0x0044;
    L_0x003d:
        r6 = move-exception;
        r5 = r0;
        r0 = r6;
        r6 = r5;
        goto L_0x004e;
    L_0x0042:
        r1 = move-exception;
        r6 = r0;
    L_0x0044:
        r1.printStackTrace();	 Catch:{ all -> 0x004d }
        if (r6 == 0) goto L_0x004c;
    L_0x0049:
        r6.destroy();
    L_0x004c:
        return r0;
    L_0x004d:
        r0 = move-exception;
    L_0x004e:
        if (r6 == 0) goto L_0x0053;
    L_0x0050:
        r6.destroy();
    L_0x0053:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O0O0O.O00000Oo(java.lang.String):java.lang.String");
    }

    public final O0O0O0o O000000o() {
        return O00000Oo();
    }
}
