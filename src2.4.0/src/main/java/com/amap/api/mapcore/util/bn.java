package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* compiled from: Req */
public final class bn {
    public static String O000OO;
    public static String O000OO00;
    public String O000000o = "1";
    public short O00000Oo = (short) 0;
    public String O00000o = null;
    public String O00000o0 = null;
    public String O00000oO = null;
    public String O00000oo = null;
    public String O0000O0o = null;
    public String O0000OOo = null;
    public String O0000Oo = null;
    public String O0000Oo0 = null;
    public String O0000OoO = null;
    public String O0000Ooo = null;
    public String O0000o = null;
    public String O0000o0 = null;
    public String O0000o00 = null;
    public String O0000o0O = null;
    public String O0000o0o = null;
    public String O0000oO = null;
    public String O0000oO0 = null;
    public String O0000oOO = null;
    public String O0000oOo = null;
    public String O0000oo = null;
    public String O0000oo0 = null;
    public String O0000ooO = null;
    public String O0000ooo = null;
    public String O000O00o = null;
    public ArrayList<bg> O000O0OO = new ArrayList();
    public String O000O0Oo = null;
    public String O000O0o = null;
    public ArrayList<ScanResult> O000O0o0 = new ArrayList();
    public String O000O0oO = null;
    public byte[] O000O0oo = null;
    public String O000OO0o = null;
    public String O000OOOo = null;
    private int O000OOo = 0;
    private byte[] O000OOo0 = null;
    public String O00oOoOo = null;
    public int O00oOooO = 0;
    public String O00oOooo = null;

    private String O000000o(String str, int i) {
        String[] split = this.O000O00o.split("\\*")[i].split(",");
        return "lac".equals(str) ? split[0] : "cellid".equals(str) ? split[1] : "signal".equals(str) ? split[2] : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A:{Catch:{ Throwable -> 0x0010 }} */
    private byte[] O000000o(java.lang.String r7) {
        /*
        r6 = this;
        r0 = ":";
        r0 = r7.split(r0);
        r1 = 6;
        r2 = new byte[r1];
        r3 = 0;
        if (r0 == 0) goto L_0x0012;
    L_0x000c:
        r4 = r0.length;	 Catch:{ Throwable -> 0x0010 }
        if (r4 == r1) goto L_0x001f;
    L_0x000f:
        goto L_0x0012;
    L_0x0010:
        r0 = move-exception;
        goto L_0x0042;
    L_0x0012:
        r0 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x0010 }
        r1 = r3;
    L_0x0015:
        r4 = r0.length;	 Catch:{ Throwable -> 0x0010 }
        if (r1 >= r4) goto L_0x001f;
    L_0x0018:
        r4 = "0";
        r0[r1] = r4;	 Catch:{ Throwable -> 0x0010 }
        r1 = r1 + 1;
        goto L_0x0015;
    L_0x001f:
        r1 = r3;
    L_0x0020:
        r4 = r0.length;	 Catch:{ Throwable -> 0x0010 }
        if (r1 >= r4) goto L_0x005b;
    L_0x0023:
        r4 = r0[r1];	 Catch:{ Throwable -> 0x0010 }
        r4 = r4.length();	 Catch:{ Throwable -> 0x0010 }
        r5 = 2;
        if (r4 <= r5) goto L_0x0034;
    L_0x002c:
        r4 = r0[r1];	 Catch:{ Throwable -> 0x0010 }
        r4 = r4.substring(r3, r5);	 Catch:{ Throwable -> 0x0010 }
        r0[r1] = r4;	 Catch:{ Throwable -> 0x0010 }
    L_0x0034:
        r4 = r0[r1];	 Catch:{ Throwable -> 0x0010 }
        r5 = 16;
        r4 = java.lang.Integer.parseInt(r4, r5);	 Catch:{ Throwable -> 0x0010 }
        r4 = (byte) r4;	 Catch:{ Throwable -> 0x0010 }
        r2[r1] = r4;	 Catch:{ Throwable -> 0x0010 }
        r1 = r1 + 1;
        goto L_0x0020;
    L_0x0042:
        r1 = "Req";
        r2 = new java.lang.StringBuilder;
        r3 = "getMacBa ";
        r2.<init>(r3);
        r2.append(r7);
        r7 = r2.toString();
        com.amap.api.mapcore.util.bp.O000000o(r0, r1, r7);
        r7 = "00:00:00:00:00:00";
        r2 = r6.O000000o(r7);
    L_0x005b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bn.O000000o(java.lang.String):byte[]");
    }

    private String O00000Oo(String str) {
        String str2 = this.O00oOooo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(">");
        if (!str2.contains(stringBuilder.toString())) {
            return "0";
        }
        str2 = this.O00oOooo;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(">");
        int indexOf = str2.indexOf(stringBuilder.toString());
        String str3 = this.O00oOooo;
        StringBuilder stringBuilder2 = new StringBuilder("</");
        stringBuilder2.append(str);
        return this.O00oOooo.substring((indexOf + str.length()) + 1, str3.indexOf(stringBuilder2.toString()));
    }

    private void O00000Oo() {
        if (TextUtils.isEmpty(this.O000000o)) {
            this.O000000o = "";
        }
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o0 = "";
        }
        if (TextUtils.isEmpty(this.O00000o)) {
            this.O00000o = "";
        }
        if (TextUtils.isEmpty(this.O00000oO)) {
            this.O00000oO = "";
        }
        if (TextUtils.isEmpty(this.O00000oo)) {
            this.O00000oo = "";
        }
        if (TextUtils.isEmpty(this.O0000O0o)) {
            this.O0000O0o = "";
        }
        if (TextUtils.isEmpty(this.O0000OOo)) {
            this.O0000OOo = "";
        }
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            this.O0000Oo0 = "";
        }
        if (TextUtils.isEmpty(this.O0000Oo) || !("0".equals(this.O0000Oo) || "2".equals(this.O0000Oo))) {
            this.O0000Oo = "0";
        }
        if (TextUtils.isEmpty(this.O0000OoO) || !("0".equals(this.O0000OoO) || "1".equals(this.O0000OoO))) {
            this.O0000OoO = "0";
        }
        if (TextUtils.isEmpty(this.O0000Ooo)) {
            this.O0000Ooo = "";
        }
        if (TextUtils.isEmpty(this.O0000o00)) {
            this.O0000o00 = "";
        }
        if (TextUtils.isEmpty(this.O0000o0)) {
            this.O0000o0 = "";
        }
        if (TextUtils.isEmpty(this.O0000o0O)) {
            this.O0000o0O = "";
        }
        if (TextUtils.isEmpty(this.O0000o0o)) {
            this.O0000o0o = "";
        }
        if (TextUtils.isEmpty(this.O0000o)) {
            this.O0000o = "";
        }
        if (TextUtils.isEmpty(this.O0000oO0)) {
            this.O0000oO0 = "";
        }
        if (TextUtils.isEmpty(this.O0000oO)) {
            this.O0000oO = "";
        }
        if (TextUtils.isEmpty(this.O0000oOO)) {
            this.O0000oOO = "";
        }
        if (TextUtils.isEmpty(this.O0000oOo)) {
            this.O0000oOo = "";
        }
        if (TextUtils.isEmpty(this.O0000oo0)) {
            this.O0000oo0 = "";
        }
        if (TextUtils.isEmpty(this.O0000oo)) {
            this.O0000oo = "";
        }
        if (TextUtils.isEmpty(this.O0000ooO)) {
            this.O0000ooO = "";
        }
        if (TextUtils.isEmpty(this.O0000ooo) || !("1".equals(this.O0000ooo) || "2".equals(this.O0000ooo))) {
            this.O0000ooo = "0";
        }
        if (!bh.O000000o(this.O00oOooO)) {
            this.O00oOooO = 0;
        }
        if (TextUtils.isEmpty(this.O00oOooo)) {
            this.O00oOooo = "";
        }
        if (TextUtils.isEmpty(this.O000O00o)) {
            this.O000O00o = "";
        }
        if (TextUtils.isEmpty(this.O00oOoOo)) {
            this.O00oOoOo = "";
        }
        if (TextUtils.isEmpty(this.O000O0o)) {
            this.O000O0o = "";
        }
        if (TextUtils.isEmpty(this.O000O0oO)) {
            this.O000O0oO = "";
        }
        if (TextUtils.isEmpty(O000OO00)) {
            O000OO00 = "";
        }
        if (this.O000O0oo == null) {
            this.O000O0oo = new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x035f A:{Catch:{ Throwable -> 0x0365 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x0357 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(1:2)|3|(1:5)|6|(9:8|(2:10|11)|14|15|(1:17)|18|(2:20|21)|24|(1:27))(1:28)|(2:29|30)|33|(2:35|(1:40)(1:39))(1:41)|42|(3:44|45|61)(1:62)|63|(1:68)(1:67)|69|(2:(7:72|(1:74)|77|78|79|(1:83)|84)|(1:88))(2:89|(1:91))|(1:93)(1:95)|94|96|97|98|(1:100)|101|102|(1:104)|105|107) */
    public final void O000000o(android.content.Context r30, boolean r31, boolean r32, com.amap.api.mapcore.util.bh r33, com.amap.api.mapcore.util.bj r34, android.net.ConnectivityManager r35, java.lang.String r36) {
        /*
        r29 = this;
        r1 = r29;
        r2 = "0";
        r3 = "0";
        r4 = "0";
        r5 = "0";
        r6 = "0";
        r7 = com.amap.api.mapcore.util.o0O0O0Oo.O00000oo(r30);
        r8 = com.amap.api.mapcore.util.bt.O00000oo();
        r9 = "";
        r10 = "";
        r11 = "";
        r12 = r36;
        r1.O000OO0o = r12;
        r12 = "api_serverSDK_130905";
        r13 = "S128DF1572465B890OE3F7A13167KLEI";
        if (r32 != 0) goto L_0x0028;
    L_0x0024:
        r12 = "UC_nlp_20131029";
        r13 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    L_0x0028:
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r16 = r2;
        r2 = r33.O00000o0();
        r17 = r9;
        r9 = r33.O00000o();
        r18 = r10;
        r10 = r33.O00000oO();
        r19 = r11;
        r11 = r33.O000000o();
        r20 = r8;
        r8 = r33.O00000Oo();
        r21 = r7;
        r7 = r34.O000000o();
        r22 = r6;
        r6 = 2;
        if (r9 != r6) goto L_0x005d;
    L_0x005b:
        r16 = "1";
    L_0x005d:
        r23 = r16;
        if (r10 == 0) goto L_0x00b3;
    L_0x0061:
        r6 = com.amap.api.mapcore.util.bp.O00000o;
        r6 = android.text.TextUtils.isEmpty(r6);
        if (r6 == 0) goto L_0x007e;
    L_0x0069:
        r6 = com.amap.api.mapcore.util.o0O0o000.O0000oo0(r30);	 Catch:{ Throwable -> 0x0070 }
        com.amap.api.mapcore.util.bp.O00000o = r6;	 Catch:{ Throwable -> 0x0070 }
        goto L_0x007e;
    L_0x0070:
        r0 = move-exception;
        r6 = r0;
        r24 = r5;
        r5 = "Aps";
        r25 = r4;
        r4 = "getApsReq part4";
        com.amap.api.mapcore.util.bp.O000000o(r6, r5, r4);
        goto L_0x0082;
    L_0x007e:
        r25 = r4;
        r24 = r5;
    L_0x0082:
        r4 = com.amap.api.mapcore.util.bp.O00000o;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x008e;
    L_0x008a:
        r4 = "888888888888888";
        com.amap.api.mapcore.util.bp.O00000o = r4;
    L_0x008e:
        r4 = com.amap.api.mapcore.util.bp.O00000oO;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x00a6;
    L_0x0096:
        r4 = r10.getSubscriberId();	 Catch:{ SecurityException -> 0x00a6, Throwable -> 0x009d }
        com.amap.api.mapcore.util.bp.O00000oO = r4;	 Catch:{ SecurityException -> 0x00a6, Throwable -> 0x009d }
        goto L_0x00a6;
    L_0x009d:
        r0 = move-exception;
        r4 = r0;
        r5 = "Aps";
        r6 = "getApsReq part2";
        com.amap.api.mapcore.util.bp.O000000o(r4, r5, r6);
    L_0x00a6:
        r4 = com.amap.api.mapcore.util.bp.O00000oO;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 == 0) goto L_0x00b7;
    L_0x00ae:
        r4 = "888888888888888";
        com.amap.api.mapcore.util.bp.O00000oO = r4;
        goto L_0x00b7;
    L_0x00b3:
        r25 = r4;
        r24 = r5;
    L_0x00b7:
        r5 = r35.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x00bc }
        goto L_0x00c5;
    L_0x00bc:
        r0 = move-exception;
        r5 = "Aps";
        r6 = "getApsReq part";
        com.amap.api.mapcore.util.bp.O000000o(r0, r5, r6);
        r5 = 0;
    L_0x00c5:
        r6 = r34.O00000oo();
        r16 = com.amap.api.mapcore.util.bj.O000000o(r6);
        r5 = com.amap.api.mapcore.util.bt.O000000o(r5);
        r4 = -1;
        if (r5 == r4) goto L_0x00e6;
    L_0x00d4:
        r4 = com.amap.api.mapcore.util.bt.O00000Oo(r10);
        if (r16 == 0) goto L_0x00e3;
    L_0x00da:
        r5 = r34.O00000oO();
        if (r5 == 0) goto L_0x00e3;
    L_0x00e0:
        r10 = "2";
        goto L_0x00ea;
    L_0x00e3:
        r10 = "1";
        goto L_0x00ea;
    L_0x00e6:
        r4 = r17;
        r10 = r18;
    L_0x00ea:
        r5 = r11.isEmpty();
        r26 = r10;
        r10 = 0;
        if (r5 != 0) goto L_0x022d;
    L_0x00f3:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        switch(r9) {
            case 1: goto L_0x0188;
            case 2: goto L_0x0101;
            default: goto L_0x00fb;
        };
    L_0x00fb:
        r27 = r4;
        r11 = r19;
        goto L_0x0224;
    L_0x0101:
        r9 = r11.get(r10);
        r9 = (com.amap.api.mapcore.util.bg) r9;
        r11 = r5.length();
        r5.delete(r10, r11);
        r11 = "<mcc>";
        r5.append(r11);
        r11 = r9.O000000o;
        r5.append(r11);
        r11 = "</mcc>";
        r5.append(r11);
        r11 = "<sid>";
        r5.append(r11);
        r11 = r9.O0000O0o;
        r5.append(r11);
        r11 = "</sid>";
        r5.append(r11);
        r11 = "<nid>";
        r5.append(r11);
        r11 = r9.O0000OOo;
        r5.append(r11);
        r11 = "</nid>";
        r5.append(r11);
        r11 = "<bid>";
        r5.append(r11);
        r11 = r9.O0000Oo0;
        r5.append(r11);
        r11 = "</bid>";
        r5.append(r11);
        r11 = r9.O00000oo;
        if (r11 <= 0) goto L_0x0170;
    L_0x014e:
        r11 = r9.O00000oO;
        if (r11 <= 0) goto L_0x0170;
    L_0x0152:
        r11 = "<lon>";
        r5.append(r11);
        r11 = r9.O00000oo;
        r5.append(r11);
        r11 = "</lon>";
        r5.append(r11);
        r11 = "<lat>";
        r5.append(r11);
        r11 = r9.O00000oO;
        r5.append(r11);
        r11 = "</lat>";
        r5.append(r11);
    L_0x0170:
        r11 = "<signal>";
        r5.append(r11);
        r9 = r9.O0000Oo;
        r5.append(r9);
        r9 = "</signal>";
        r5.append(r9);
        r9 = r5.toString();
        r27 = r4;
        r11 = r9;
        goto L_0x0224;
    L_0x0188:
        r9 = r11.get(r10);
        r9 = (com.amap.api.mapcore.util.bg) r9;
        r27 = r4;
        r4 = r5.length();
        r5.delete(r10, r4);
        r4 = "<mcc>";
        r5.append(r4);
        r4 = r9.O000000o;
        r5.append(r4);
        r4 = "</mcc>";
        r5.append(r4);
        r4 = "<mnc>";
        r5.append(r4);
        r4 = r9.O00000Oo;
        r5.append(r4);
        r4 = "</mnc>";
        r5.append(r4);
        r4 = "<lac>";
        r5.append(r4);
        r4 = r9.O00000o0;
        r5.append(r4);
        r4 = "</lac>";
        r5.append(r4);
        r4 = "<cellid>";
        r5.append(r4);
        r4 = r9.O00000o;
        r5.append(r4);
        r4 = "</cellid>";
        r5.append(r4);
        r4 = "<signal>";
        r5.append(r4);
        r4 = r9.O0000Oo;
        r5.append(r4);
        r4 = "</signal>";
        r5.append(r4);
        r4 = r5.toString();
        r10 = 1;
    L_0x01e7:
        r9 = r11.size();
        if (r10 >= r9) goto L_0x0220;
    L_0x01ed:
        r9 = r11.get(r10);
        r9 = (com.amap.api.mapcore.util.bg) r9;
        r28 = r4;
        r4 = r9.O00000o0;
        r14.append(r4);
        r4 = ",";
        r14.append(r4);
        r4 = r9.O00000o;
        r14.append(r4);
        r4 = ",";
        r14.append(r4);
        r4 = r9.O0000Oo;
        r14.append(r4);
        r4 = r11.size();
        r9 = 1;
        r4 = r4 - r9;
        if (r10 >= r4) goto L_0x021b;
    L_0x0216:
        r4 = "*";
        r14.append(r4);
    L_0x021b:
        r10 = r10 + 1;
        r4 = r28;
        goto L_0x01e7;
    L_0x0220:
        r28 = r4;
        r11 = r28;
    L_0x0224:
        r4 = r5.length();
        r9 = 0;
        r5.delete(r9, r4);
        goto L_0x0231;
    L_0x022d:
        r27 = r4;
        r11 = r19;
    L_0x0231:
        r4 = r2 & 4;
        r5 = 4;
        if (r4 != r5) goto L_0x0247;
    L_0x0236:
        r4 = r8.isEmpty();
        if (r4 != 0) goto L_0x0247;
    L_0x023c:
        r4 = r1.O000O0OO;
        r4.clear();
        r4 = r1.O000O0OO;
        r4.addAll(r8);
        goto L_0x024c;
    L_0x0247:
        r4 = r1.O000O0OO;
        r4.clear();
    L_0x024c:
        r4 = r34.O00000oO();
        if (r4 == 0) goto L_0x02b2;
    L_0x0252:
        if (r16 == 0) goto L_0x02a1;
    L_0x0254:
        r4 = r34.O00000oo();
        r4 = r4.getBSSID();
        r15.append(r4);
        r4 = ",";
        r15.append(r4);
        r4 = r34.O00000oo();
        r10 = r4.getRssi();
        r4 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r10 >= r4) goto L_0x0272;
    L_0x0270:
        r10 = 0;
        goto L_0x0277;
    L_0x0272:
        r4 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r10 <= r4) goto L_0x0277;
    L_0x0276:
        goto L_0x0270;
    L_0x0277:
        r15.append(r10);
        r4 = ",";
        r15.append(r4);
        r4 = r6.getSSID();
        r5 = 32;
        r6 = r6.getSSID();	 Catch:{ Exception -> 0x0291 }
        r8 = "UTF-8";
        r6 = r6.getBytes(r8);	 Catch:{ Exception -> 0x0291 }
        r6 = r6.length;	 Catch:{ Exception -> 0x0291 }
        goto L_0x0292;
    L_0x0291:
        r6 = r5;
    L_0x0292:
        if (r6 < r5) goto L_0x0296;
    L_0x0294:
        r4 = "unkwn";
    L_0x0296:
        r5 = "*";
        r6 = ".";
        r4 = r4.replace(r5, r6);
        r15.append(r4);
    L_0x02a1:
        if (r7 == 0) goto L_0x02be;
    L_0x02a3:
        r4 = r1.O000O0o0;
        if (r4 == 0) goto L_0x02be;
    L_0x02a7:
        r4 = r1.O000O0o0;
        r4.clear();
        r4 = r1.O000O0o0;
        r4.addAll(r7);
        goto L_0x02be;
    L_0x02b2:
        r34.O00000Oo();
        r4 = r1.O000O0o0;
        if (r4 == 0) goto L_0x02be;
    L_0x02b9:
        r4 = r1.O000O0o0;
        r4.clear();
    L_0x02be:
        if (r31 != 0) goto L_0x02c4;
    L_0x02c0:
        r4 = 2;
    L_0x02c1:
        r1.O00000Oo = r4;
        goto L_0x02c6;
    L_0x02c4:
        r4 = 0;
        goto L_0x02c1;
    L_0x02c6:
        r1.O00000o0 = r12;
        r1.O00000o = r13;
        r4 = com.amap.api.mapcore.util.bt.O00000o();
        r1.O00000oo = r4;
        r4 = new java.lang.StringBuilder;
        r5 = "android";
        r4.<init>(r5);
        r5 = com.amap.api.mapcore.util.bt.O00000oO();
        r4.append(r5);
        r4 = r4.toString();
        r1.O0000O0o = r4;
        r4 = com.amap.api.mapcore.util.bt.O00000Oo(r30);
        r1.O0000OOo = r4;
        r4 = r23;
        r1.O0000Oo0 = r4;
        r1.O0000Oo = r3;
        r3 = "0";
        r1.O0000OoO = r3;
        r3 = r25;
        r1.O0000Ooo = r3;
        r3 = r24;
        r1.O0000o00 = r3;
        r3 = r22;
        r1.O0000o0 = r3;
        r3 = r21;
        r1.O0000o0O = r3;
        r3 = com.amap.api.mapcore.util.bp.O00000o;
        r1.O0000o0o = r3;
        r3 = com.amap.api.mapcore.util.bp.O00000oO;
        r1.O0000o = r3;
        r3 = r20;
        r3 = java.lang.String.valueOf(r3);
        r1.O0000oO = r3;
        r3 = com.amap.api.mapcore.util.bt.O00000o(r30);
        r1.O0000oOO = r3;
        r3 = "4.5.1";
        r1.O0000oo0 = r3;
        r3 = 0;
        r1.O0000oo = r3;
        r3 = "";
        r1.O0000oOo = r3;
        r4 = r27;
        r1.O0000ooO = r4;
        r10 = r26;
        r1.O0000ooo = r10;
        r1.O00oOooO = r2;
        r1.O00oOooo = r11;
        r2 = r14.toString();
        r1.O000O00o = r2;
        r2 = r33.O0000Oo0();
        r1.O000O0Oo = r2;
        r2 = com.amap.api.mapcore.util.bj.O0000Oo0();
        r1.O000O0o = r2;
        r2 = r15.toString();
        r1.O00oOoOo = r2;
        r2 = O000OO00;	 Catch:{ Throwable -> 0x0357 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0357 }
        if (r2 == 0) goto L_0x0357;
    L_0x0351:
        r2 = com.amap.api.mapcore.util.o0O0o000.O0000OOo(r30);	 Catch:{ Throwable -> 0x0357 }
        O000OO00 = r2;	 Catch:{ Throwable -> 0x0357 }
    L_0x0357:
        r2 = O000OO;	 Catch:{ Throwable -> 0x0365 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0365 }
        if (r2 == 0) goto L_0x0365;
    L_0x035f:
        r2 = com.amap.api.mapcore.util.o0O0o000.O00000Oo(r30);	 Catch:{ Throwable -> 0x0365 }
        O000OO = r2;	 Catch:{ Throwable -> 0x0365 }
    L_0x0365:
        r2 = r14.length();
        r3 = 0;
        r14.delete(r3, r2);
        r2 = r15.length();
        r15.delete(r3, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bn.O000000o(android.content.Context, boolean, boolean, com.amap.api.mapcore.util.bh, com.amap.api.mapcore.util.bj, android.net.ConnectivityManager, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x066a A:{Catch:{ Throwable -> 0x068f }} */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x067c A:{SYNTHETIC, Splitter:B:253:0x067c} */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x06ac  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x06c0  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x057f  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0641 A:{Catch:{ Throwable -> 0x0657 }} */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0649 A:{Catch:{ Throwable -> 0x0657 }} */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0644 A:{Catch:{ Throwable -> 0x0657 }} */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x06ac  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x06c0  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x06ac  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x06c0  */
    public final byte[] O000000o() {
        /*
        r22 = this;
        r1 = r22;
        r22.O00000Oo();
        r2 = 2;
        r3 = new byte[r2];
        r4 = 4;
        r5 = new byte[r4];
        r6 = r1.O000O0oo;
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r8 = 1;
        if (r6 == 0) goto L_0x0017;
    L_0x0012:
        r6 = r1.O000O0oo;
        r6 = r6.length;
        r6 = r6 + r8;
        r7 = r7 + r6;
    L_0x0017:
        r6 = r1.O000OOo0;
        if (r6 == 0) goto L_0x0023;
    L_0x001b:
        r6 = r1.O000OOo;
        if (r7 <= r6) goto L_0x0020;
    L_0x001f:
        goto L_0x0023;
    L_0x0020:
        r6 = r1.O000OOo0;
        goto L_0x0029;
    L_0x0023:
        r6 = new byte[r7];
        r1.O000OOo0 = r6;
        r1.O000OOo = r7;
    L_0x0029:
        r7 = r1.O000000o;
        r7 = com.amap.api.mapcore.util.bt.O00000oO(r7);
        r9 = 0;
        r6[r9] = r7;
        r7 = r1.O00000Oo;
        r10 = 0;
        r7 = com.amap.api.mapcore.util.bt.O000000o(r7, r10);
        r11 = r7.length;
        java.lang.System.arraycopy(r7, r9, r6, r8, r11);
        r7 = r7.length;
        r7 = r7 + r8;
        r11 = r1.O00000o0;	 Catch:{ Throwable -> 0x0054 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0054 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0054 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0054 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0054 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0054 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0054 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0054 }
        r7 = r7 + r11;
        goto L_0x0062;
    L_0x0054:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot2";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0062:
        r11 = r1.O00000o;	 Catch:{ Throwable -> 0x0077 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0077 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0077 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0077 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0077 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0077 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0077 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0077 }
        r7 = r7 + r11;
        goto L_0x0085;
    L_0x0077:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot21";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0085:
        r11 = r1.O0000o0O;	 Catch:{ Throwable -> 0x009a }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x009a }
        r12 = r11.length;	 Catch:{ Throwable -> 0x009a }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x009a }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x009a }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x009a }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x009a }
        r11 = r11.length;	 Catch:{ Throwable -> 0x009a }
        r7 = r7 + r11;
        goto L_0x00a8;
    L_0x009a:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot22";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x00a8:
        r11 = r1.O00000oO;	 Catch:{ Throwable -> 0x00bd }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x00bd }
        r12 = r11.length;	 Catch:{ Throwable -> 0x00bd }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x00bd }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x00bd }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x00bd }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x00bd }
        r11 = r11.length;	 Catch:{ Throwable -> 0x00bd }
        r7 = r7 + r11;
        goto L_0x00cb;
    L_0x00bd:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot23";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x00cb:
        r11 = r1.O00000oo;	 Catch:{ Throwable -> 0x00e0 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x00e0 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x00e0 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x00e0 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x00e0 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x00e0 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x00e0 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x00e0 }
        r7 = r7 + r11;
        goto L_0x00ee;
    L_0x00e0:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot24";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x00ee:
        r11 = r1.O0000O0o;	 Catch:{ Throwable -> 0x0103 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0103 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0103 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0103 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0103 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0103 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0103 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0103 }
        r7 = r7 + r11;
        goto L_0x0111;
    L_0x0103:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot25";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0111:
        r11 = r1.O0000oOo;	 Catch:{ Throwable -> 0x0126 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0126 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0126 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0126 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0126 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0126 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0126 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0126 }
        r7 = r7 + r11;
        goto L_0x0134;
    L_0x0126:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot26";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0134:
        r11 = r1.O0000OOo;	 Catch:{ Throwable -> 0x0149 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0149 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0149 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0149 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0149 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0149 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0149 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0149 }
        r7 = r7 + r11;
        goto L_0x0157;
    L_0x0149:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot27";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0157:
        r11 = r1.O0000o0o;	 Catch:{ Throwable -> 0x016c }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x016c }
        r12 = r11.length;	 Catch:{ Throwable -> 0x016c }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x016c }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x016c }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x016c }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x016c }
        r11 = r11.length;	 Catch:{ Throwable -> 0x016c }
        r7 = r7 + r11;
        goto L_0x017a;
    L_0x016c:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot28";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x017a:
        r11 = r1.O0000o;	 Catch:{ Throwable -> 0x018f }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x018f }
        r12 = r11.length;	 Catch:{ Throwable -> 0x018f }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x018f }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x018f }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x018f }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x018f }
        r11 = r11.length;	 Catch:{ Throwable -> 0x018f }
        r7 = r7 + r11;
        goto L_0x019d;
    L_0x018f:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot29";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x019d:
        r11 = r1.O0000oOO;	 Catch:{ Throwable -> 0x01bc }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Throwable -> 0x01bc }
        if (r11 == 0) goto L_0x01a9;
    L_0x01a5:
        r6[r7] = r9;	 Catch:{ Throwable -> 0x01bc }
        r7 = r7 + r8;
        goto L_0x01ca;
    L_0x01a9:
        r11 = r1.O0000oOO;	 Catch:{ Throwable -> 0x01bc }
        r11 = r1.O000000o(r11);	 Catch:{ Throwable -> 0x01bc }
        r12 = r11.length;	 Catch:{ Throwable -> 0x01bc }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x01bc }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x01bc }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x01bc }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x01bc }
        r11 = r11.length;	 Catch:{ Throwable -> 0x01bc }
        r7 = r7 + r11;
        goto L_0x01ca;
    L_0x01bc:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot219";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x01ca:
        r11 = r1.O0000oo0;	 Catch:{ Throwable -> 0x01df }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x01df }
        r12 = r11.length;	 Catch:{ Throwable -> 0x01df }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x01df }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x01df }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x01df }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x01df }
        r11 = r11.length;	 Catch:{ Throwable -> 0x01df }
        r7 = r7 + r11;
        goto L_0x01ed;
    L_0x01df:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot211";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x01ed:
        r11 = r1.O0000oo;	 Catch:{ Throwable -> 0x0202 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0202 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0202 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0202 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0202 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0202 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0202 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0202 }
        r7 = r7 + r11;
        goto L_0x0210;
    L_0x0202:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot212";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0210:
        r11 = O000OO00;	 Catch:{ Throwable -> 0x0231 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Throwable -> 0x0231 }
        if (r11 == 0) goto L_0x021c;
    L_0x0218:
        r6[r7] = r9;	 Catch:{ Throwable -> 0x0231 }
        r7 = r7 + r8;
        goto L_0x023f;
    L_0x021c:
        r11 = O000OO00;	 Catch:{ Throwable -> 0x0231 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0231 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0231 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0231 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0231 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0231 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0231 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0231 }
        r7 = r7 + r11;
        goto L_0x023f;
    L_0x0231:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot213";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x023f:
        r11 = O000OO;	 Catch:{ Throwable -> 0x0260 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Throwable -> 0x0260 }
        if (r11 == 0) goto L_0x024b;
    L_0x0247:
        r6[r7] = r9;	 Catch:{ Throwable -> 0x0260 }
        r7 = r7 + r8;
        goto L_0x026e;
    L_0x024b:
        r11 = O000OO;	 Catch:{ Throwable -> 0x0260 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0260 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0260 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0260 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0260 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0260 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0260 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0260 }
        r7 = r7 + r11;
        goto L_0x026e;
    L_0x0260:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot214";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x026e:
        r11 = r1.O0000ooO;	 Catch:{ Throwable -> 0x0283 }
        r12 = "GBK";
        r11 = r11.getBytes(r12);	 Catch:{ Throwable -> 0x0283 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0283 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0283 }
        r6[r7] = r12;	 Catch:{ Throwable -> 0x0283 }
        r7 = r7 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0283 }
        java.lang.System.arraycopy(r11, r9, r6, r7, r12);	 Catch:{ Throwable -> 0x0283 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0283 }
        r7 = r7 + r11;
        goto L_0x0291;
    L_0x0283:
        r0 = move-exception;
        r11 = r7;
        r7 = r0;
        r12 = "Req";
        r13 = "buildV4Dot213";
        com.amap.api.mapcore.util.bp.O000000o(r7, r12, r13);
        r6[r11] = r9;
        r7 = r11 + 1;
    L_0x0291:
        r11 = r1.O0000ooo;
        r11 = java.lang.Byte.parseByte(r11);
        r6[r7] = r11;
        r7 = r7 + r8;
        r11 = r1.O0000Oo;
        r11 = java.lang.Byte.parseByte(r11);
        r6[r7] = r11;
        r7 = r7 + r8;
        r11 = r1.O00oOooO;
        r12 = 3;
        r11 = r11 & r12;
        r13 = r1.O00oOooO;
        r13 = (byte) r13;
        r6[r7] = r13;
        r7 = r7 + r8;
        r13 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r14 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r11 == r8) goto L_0x02b5;
    L_0x02b3:
        if (r11 != r2) goto L_0x03c9;
    L_0x02b5:
        r15 = "mcc";
        r15 = r1.O00000Oo(r15);
        r15 = com.amap.api.mapcore.util.bt.O00000Oo(r15);
        r10 = r15.length;
        java.lang.System.arraycopy(r15, r9, r6, r7, r10);
        r10 = r15.length;
        r7 = r7 + r10;
        if (r11 != r8) goto L_0x02f8;
    L_0x02c7:
        r10 = "mnc";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        r7 = r7 + r10;
        r10 = "lac";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        r7 = r7 + r10;
        r10 = "cellid";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000o0(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
    L_0x02f6:
        r7 = r7 + r10;
        goto L_0x034a;
    L_0x02f8:
        if (r11 != r2) goto L_0x034a;
    L_0x02fa:
        r10 = "sid";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        r7 = r7 + r10;
        r10 = "nid";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        r7 = r7 + r10;
        r10 = "bid";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        r7 = r7 + r10;
        r10 = "lon";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000o0(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        r7 = r7 + r10;
        r10 = "lat";
        r10 = r1.O00000Oo(r10);
        r10 = com.amap.api.mapcore.util.bt.O00000o0(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r10 = r10.length;
        goto L_0x02f6;
    L_0x034a:
        r10 = "signal";
        r10 = r1.O00000Oo(r10);
        r10 = java.lang.Integer.parseInt(r10);
        if (r10 <= r14) goto L_0x0358;
    L_0x0356:
        r10 = r9;
        goto L_0x035b;
    L_0x0358:
        if (r10 >= r13) goto L_0x035b;
    L_0x035a:
        goto L_0x0356;
    L_0x035b:
        r10 = (byte) r10;
        r6[r7] = r10;
        r7 = r7 + r8;
        r10 = com.amap.api.mapcore.util.bt.O000000o(r9, r3);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r9, r6, r7, r15);
        r7 = r7 + r2;
        if (r11 != r8) goto L_0x03c4;
    L_0x036a:
        r10 = r1.O000O00o;
        r10 = android.text.TextUtils.isEmpty(r10);
        if (r10 == 0) goto L_0x0377;
    L_0x0372:
        r6[r7] = r9;
    L_0x0374:
        r7 = r7 + 1;
        goto L_0x03c9;
    L_0x0377:
        r10 = r1.O000O00o;
        r11 = "\\*";
        r10 = r10.split(r11);
        r10 = r10.length;
        r11 = (byte) r10;
        r6[r7] = r11;
        r7 = r7 + 1;
        r11 = r7;
        r7 = r9;
    L_0x0387:
        if (r7 >= r10) goto L_0x03c2;
    L_0x0389:
        r15 = "lac";
        r15 = r1.O000000o(r15, r7);
        r15 = com.amap.api.mapcore.util.bt.O00000Oo(r15);
        r12 = r15.length;
        java.lang.System.arraycopy(r15, r9, r6, r11, r12);
        r12 = r15.length;
        r11 = r11 + r12;
        r12 = "cellid";
        r12 = r1.O000000o(r12, r7);
        r12 = com.amap.api.mapcore.util.bt.O00000o0(r12);
        r15 = r12.length;
        java.lang.System.arraycopy(r12, r9, r6, r11, r15);
        r12 = r12.length;
        r11 = r11 + r12;
        r12 = "signal";
        r12 = r1.O000000o(r12, r7);
        r12 = java.lang.Integer.parseInt(r12);
        if (r12 <= r14) goto L_0x03b7;
    L_0x03b5:
        r12 = r9;
        goto L_0x03ba;
    L_0x03b7:
        if (r12 >= r13) goto L_0x03ba;
    L_0x03b9:
        goto L_0x03b5;
    L_0x03ba:
        r12 = (byte) r12;
        r6[r11] = r12;
        r11 = r11 + r8;
        r7 = r7 + 1;
        r12 = 3;
        goto L_0x0387;
    L_0x03c2:
        r7 = r11;
        goto L_0x03c9;
    L_0x03c4:
        if (r11 != r2) goto L_0x03c9;
    L_0x03c6:
        r6[r7] = r9;
        goto L_0x0374;
    L_0x03c9:
        r10 = r1.O000O0Oo;
        if (r10 == 0) goto L_0x03eb;
    L_0x03cd:
        r11 = r1.O00oOooO;
        r12 = 8;
        r11 = r11 & r12;
        if (r11 != r12) goto L_0x03eb;
    L_0x03d4:
        r11 = "GBK";
        r10 = r10.getBytes(r11);	 Catch:{ Exception -> 0x03eb }
        r11 = r10.length;	 Catch:{ Exception -> 0x03eb }
        r12 = 60;
        r11 = java.lang.Math.min(r11, r12);	 Catch:{ Exception -> 0x03eb }
        r12 = (byte) r11;	 Catch:{ Exception -> 0x03eb }
        r6[r7] = r12;	 Catch:{ Exception -> 0x03eb }
        r7 = r7 + 1;
        java.lang.System.arraycopy(r10, r9, r6, r7, r11);	 Catch:{ Exception -> 0x03eb }
        r7 = r7 + r11;
        goto L_0x03ee;
    L_0x03eb:
        r6[r7] = r9;
        r7 = r7 + r8;
    L_0x03ee:
        r10 = r1.O000O0OO;
        r11 = r10.size();
        r12 = r1.O00oOooO;
        r12 = r12 & r4;
        if (r12 != r4) goto L_0x04e8;
    L_0x03f9:
        if (r11 <= 0) goto L_0x04e8;
    L_0x03fb:
        r12 = r10.get(r9);
        r12 = (com.amap.api.mapcore.util.bg) r12;
        r12 = r12.O0000o0O;
        if (r12 != 0) goto L_0x0407;
    L_0x0405:
        r11 = r11 + -1;
    L_0x0407:
        r12 = (byte) r11;
        r6[r7] = r12;
        r7 = r7 + r8;
        r12 = r7;
        r7 = r9;
    L_0x040d:
        if (r7 >= r11) goto L_0x04e6;
    L_0x040f:
        r15 = r10.get(r7);
        r15 = (com.amap.api.mapcore.util.bg) r15;
        r13 = r15.O0000o0O;
        if (r13 == 0) goto L_0x04de;
    L_0x0419:
        r13 = r15.O0000OoO;
        if (r13 == r8) goto L_0x0481;
    L_0x041d:
        r13 = r15.O0000OoO;
        r8 = 3;
        if (r13 == r8) goto L_0x0482;
    L_0x0422:
        r13 = r15.O0000OoO;
        if (r13 != r4) goto L_0x0427;
    L_0x0426:
        goto L_0x0482;
    L_0x0427:
        r13 = r15.O0000OoO;
        if (r13 != r2) goto L_0x04c0;
    L_0x042b:
        r13 = r15.O0000OoO;
        r13 = (byte) r13;
        r4 = r15.O0000o0;
        if (r4 == 0) goto L_0x0435;
    L_0x0432:
        r4 = r13 | 8;
        r13 = (byte) r4;
    L_0x0435:
        r6[r12] = r13;
        r12 = r12 + 1;
        r4 = r15.O000000o;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O0000O0o;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O0000OOo;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O0000Oo0;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O00000oo;
        r4 = com.amap.api.mapcore.util.bt.O00000Oo(r4, r5);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O00000oO;
        r4 = com.amap.api.mapcore.util.bt.O00000Oo(r4, r5);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        goto L_0x04bf;
    L_0x0481:
        r8 = 3;
    L_0x0482:
        r4 = r15.O0000OoO;
        r4 = (byte) r4;
        r13 = r15.O0000o0;
        if (r13 == 0) goto L_0x048c;
    L_0x0489:
        r4 = r4 | 8;
        r4 = (byte) r4;
    L_0x048c:
        r6[r12] = r4;
        r12 = r12 + 1;
        r4 = r15.O000000o;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O00000Oo;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O00000o0;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r15.O00000o;
        r4 = com.amap.api.mapcore.util.bt.O00000Oo(r4, r5);
        r13 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r13);
        r4 = r4.length;
    L_0x04bf:
        r12 = r12 + r4;
    L_0x04c0:
        r4 = r15.O0000Oo;
        r13 = 99;
        if (r4 <= r14) goto L_0x04c7;
    L_0x04c6:
        goto L_0x04cd;
    L_0x04c7:
        r8 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r4 >= r8) goto L_0x04cc;
    L_0x04cb:
        goto L_0x04cd;
    L_0x04cc:
        r13 = r4;
    L_0x04cd:
        r4 = (byte) r13;
        r6[r12] = r4;
        r4 = 1;
        r12 = r12 + r4;
        r4 = r15.O0000Ooo;
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);
        r8 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r8);
        r4 = r4.length;
        r12 = r12 + r4;
    L_0x04de:
        r7 = r7 + 1;
        r4 = 4;
        r8 = 1;
        r13 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        goto L_0x040d;
    L_0x04e6:
        r4 = r8;
        goto L_0x04ed;
    L_0x04e8:
        r6[r7] = r9;
        r4 = 1;
        r12 = r7 + 1;
    L_0x04ed:
        r5 = r1.O00oOoOo;
        r5 = r5.length();
        if (r5 != 0) goto L_0x04fa;
    L_0x04f5:
        r6[r12] = r9;
    L_0x04f7:
        r12 = r12 + r4;
        goto L_0x0571;
    L_0x04fa:
        r6[r12] = r4;
        r12 = r12 + r4;
        r4 = r1.O00oOoOo;	 Catch:{ Throwable -> 0x054f }
        r5 = ",";
        r4 = r4.split(r5);	 Catch:{ Throwable -> 0x054f }
        r5 = r4[r9];	 Catch:{ Throwable -> 0x054f }
        r5 = r1.O000000o(r5);	 Catch:{ Throwable -> 0x054f }
        r7 = r5.length;	 Catch:{ Throwable -> 0x054f }
        java.lang.System.arraycopy(r5, r9, r6, r12, r7);	 Catch:{ Throwable -> 0x054f }
        r5 = r5.length;	 Catch:{ Throwable -> 0x054f }
        r12 = r12 + r5;
        r5 = r4[r2];	 Catch:{ Throwable -> 0x0526 }
        r7 = "GBK";
        r5 = r5.getBytes(r7);	 Catch:{ Throwable -> 0x0526 }
        r7 = r5.length;	 Catch:{ Throwable -> 0x0526 }
        r7 = (byte) r7;	 Catch:{ Throwable -> 0x0526 }
        r6[r12] = r7;	 Catch:{ Throwable -> 0x0526 }
        r12 = r12 + 1;
        r7 = r5.length;	 Catch:{ Throwable -> 0x0526 }
        java.lang.System.arraycopy(r5, r9, r6, r12, r7);	 Catch:{ Throwable -> 0x0526 }
        r5 = r5.length;	 Catch:{ Throwable -> 0x0526 }
        r12 = r12 + r5;
        goto L_0x0533;
    L_0x0526:
        r0 = move-exception;
        r5 = r0;
        r7 = "Req";
        r8 = "buildV4Dot214";
        com.amap.api.mapcore.util.bp.O000000o(r5, r7, r8);	 Catch:{ Throwable -> 0x054f }
        r6[r12] = r9;	 Catch:{ Throwable -> 0x054f }
        r12 = r12 + 1;
    L_0x0533:
        r5 = 1;
        r4 = r4[r5];	 Catch:{ Throwable -> 0x054f }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x054f }
        if (r4 <= r14) goto L_0x053e;
    L_0x053c:
        r4 = r9;
        goto L_0x0543;
    L_0x053e:
        r5 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r4 >= r5) goto L_0x0543;
    L_0x0542:
        goto L_0x053c;
    L_0x0543:
        r4 = java.lang.String.valueOf(r4);	 Catch:{ Throwable -> 0x054f }
        r4 = java.lang.Byte.parseByte(r4);	 Catch:{ Throwable -> 0x054f }
        r6[r12] = r4;	 Catch:{ Throwable -> 0x054f }
        r4 = 1;
        goto L_0x04f7;
    L_0x054f:
        r0 = move-exception;
        r4 = r0;
        r5 = "Req";
        r7 = "buildV4Dot216";
        com.amap.api.mapcore.util.bp.O000000o(r4, r5, r7);
        r4 = "00:00:00:00:00:00";
        r4 = r1.O000000o(r4);
        r5 = r4.length;
        java.lang.System.arraycopy(r4, r9, r6, r12, r5);
        r4 = r4.length;
        r12 = r12 + r4;
        r6[r12] = r9;
        r4 = 1;
        r12 = r12 + r4;
        r5 = "0";
        r5 = java.lang.Byte.parseByte(r5);
        r6[r12] = r5;
        goto L_0x04f7;
    L_0x0571:
        r5 = r1.O000O0o0;
        r7 = r5.size();
        r8 = 25;
        r7 = java.lang.Math.min(r7, r8);
        if (r7 != 0) goto L_0x0585;
    L_0x057f:
        r6[r12] = r9;
        r12 = r12 + r4;
        r10 = r9;
        goto L_0x0630;
    L_0x0585:
        r8 = (byte) r7;
        r6[r12] = r8;
        r12 = r12 + r4;
        r4 = com.amap.api.mapcore.util.bt.O00000o0();
        r8 = 17;
        if (r4 < r8) goto L_0x0593;
    L_0x0591:
        r4 = 1;
        goto L_0x0594;
    L_0x0593:
        r4 = r9;
    L_0x0594:
        r10 = 0;
        if (r4 == 0) goto L_0x05a0;
    L_0x0598:
        r10 = com.amap.api.mapcore.util.bt.O00000Oo();
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r18;
    L_0x05a0:
        r8 = r9;
    L_0x05a1:
        if (r8 >= r7) goto L_0x061f;
    L_0x05a3:
        r13 = r5.get(r8);
        r13 = (android.net.wifi.ScanResult) r13;
        r15 = r13.BSSID;
        r15 = r1.O000000o(r15);
        r2 = r15.length;
        java.lang.System.arraycopy(r15, r9, r6, r12, r2);
        r2 = r15.length;
        r12 = r12 + r2;
        r2 = r13.SSID;	 Catch:{ Exception -> 0x05cb }
        r15 = "GBK";
        r2 = r2.getBytes(r15);	 Catch:{ Exception -> 0x05cb }
        r15 = r2.length;	 Catch:{ Exception -> 0x05cb }
        r15 = (byte) r15;	 Catch:{ Exception -> 0x05cb }
        r6[r12] = r15;	 Catch:{ Exception -> 0x05cb }
        r12 = r12 + 1;
        r15 = r2.length;	 Catch:{ Exception -> 0x05cb }
        java.lang.System.arraycopy(r2, r9, r6, r12, r15);	 Catch:{ Exception -> 0x05cb }
        r2 = r2.length;	 Catch:{ Exception -> 0x05cb }
        r12 = r12 + r2;
        r2 = 1;
        goto L_0x05cf;
    L_0x05cb:
        r6[r12] = r9;
        r2 = 1;
        r12 = r12 + r2;
    L_0x05cf:
        r15 = r13.level;
        if (r15 <= r14) goto L_0x05d7;
    L_0x05d3:
        r15 = r9;
        r14 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        goto L_0x05dc;
    L_0x05d7:
        r14 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r15 >= r14) goto L_0x05dc;
    L_0x05db:
        r15 = r9;
    L_0x05dc:
        r15 = java.lang.String.valueOf(r15);
        r15 = java.lang.Byte.parseByte(r15);
        r6[r12] = r15;
        r12 = r12 + r2;
        if (r4 == 0) goto L_0x05fc;
    L_0x05e9:
        r14 = r13.timestamp;
        r16 = r10 - r14;
        r14 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r16 = r16 / r14;
        r14 = 1;
        r20 = r10;
        r9 = r16 + r14;
        r9 = (int) r9;
        if (r9 >= 0) goto L_0x05ff;
    L_0x05fb:
        goto L_0x05fe;
    L_0x05fc:
        r20 = r10;
    L_0x05fe:
        r9 = 0;
    L_0x05ff:
        r2 = com.amap.api.mapcore.util.bt.O000000o(r9, r3);
        r9 = r2.length;
        r10 = 0;
        java.lang.System.arraycopy(r2, r10, r6, r12, r9);
        r2 = r2.length;
        r12 = r12 + r2;
        r2 = r13.frequency;
        r2 = com.amap.api.mapcore.util.bt.O000000o(r2, r3);
        r9 = r2.length;
        java.lang.System.arraycopy(r2, r10, r6, r12, r9);
        r2 = r2.length;
        r12 = r12 + r2;
        r8 = r8 + 1;
        r9 = r10;
        r10 = r20;
        r2 = 2;
        r14 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x05a1;
    L_0x061f:
        r10 = r9;
        r2 = r1.O000O0o;
        r2 = java.lang.Integer.parseInt(r2);
        r2 = com.amap.api.mapcore.util.bt.O000000o(r2, r3);
        r4 = r2.length;
        java.lang.System.arraycopy(r2, r10, r6, r12, r4);
        r2 = r2.length;
        r12 = r12 + r2;
    L_0x0630:
        r6[r12] = r10;
        r2 = 1;
        r12 = r12 + r2;
        r2 = r1.O000O0oO;	 Catch:{ Throwable -> 0x0657 }
        r4 = "GBK";
        r10 = r2.getBytes(r4);	 Catch:{ Throwable -> 0x0657 }
        r2 = r10.length;	 Catch:{ Throwable -> 0x0657 }
        r4 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r2 <= r4) goto L_0x0642;
    L_0x0641:
        r10 = 0;
    L_0x0642:
        if (r10 != 0) goto L_0x0649;
    L_0x0644:
        r2 = 0;
        r6[r12] = r2;	 Catch:{ Throwable -> 0x0657 }
        r2 = 1;
        goto L_0x065b;
    L_0x0649:
        r2 = r10.length;	 Catch:{ Throwable -> 0x0657 }
        r2 = (byte) r2;	 Catch:{ Throwable -> 0x0657 }
        r6[r12] = r2;	 Catch:{ Throwable -> 0x0657 }
        r12 = r12 + 1;
        r2 = r10.length;	 Catch:{ Throwable -> 0x0657 }
        r4 = 0;
        java.lang.System.arraycopy(r10, r4, r6, r12, r2);	 Catch:{ Throwable -> 0x0657 }
        r2 = r10.length;	 Catch:{ Throwable -> 0x0657 }
        r12 = r12 + r2;
        goto L_0x065c;
    L_0x0657:
        r2 = 0;
        r6[r12] = r2;
        r2 = 1;
    L_0x065b:
        r12 = r12 + r2;
    L_0x065c:
        r2 = 2;
        r4 = new byte[r2];
        r4 = {0, 0};
        r2 = r1.O000OO0o;	 Catch:{ Throwable -> 0x068f }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x068f }
        if (r2 != 0) goto L_0x0674;
    L_0x066a:
        r4 = r1.O000OO0o;	 Catch:{ Throwable -> 0x068f }
        r4 = r4.length();	 Catch:{ Throwable -> 0x068f }
        r4 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);	 Catch:{ Throwable -> 0x068f }
    L_0x0674:
        r5 = 0;
        r7 = 2;
        java.lang.System.arraycopy(r4, r5, r6, r12, r7);	 Catch:{ Throwable -> 0x068d }
        r12 = r12 + r7;
        if (r2 != 0) goto L_0x068b;
    L_0x067c:
        r2 = r1.O000OO0o;	 Catch:{ Throwable -> 0x068b }
        r4 = "GBK";
        r2 = r2.getBytes(r4);	 Catch:{ Throwable -> 0x068b }
        r4 = r2.length;	 Catch:{ Throwable -> 0x068b }
        r5 = 0;
        java.lang.System.arraycopy(r2, r5, r6, r12, r4);	 Catch:{ Throwable -> 0x068b }
        r2 = r2.length;	 Catch:{ Throwable -> 0x068b }
        r12 = r12 + r2;
    L_0x068b:
        r2 = 2;
        goto L_0x0691;
    L_0x068d:
        r2 = r7;
        goto L_0x0690;
    L_0x068f:
        r2 = 2;
    L_0x0690:
        r12 = r12 + r2;
    L_0x0691:
        r4 = new byte[r2];
        r4 = {0, 0};
        r4 = 0;
        r3 = com.amap.api.mapcore.util.bt.O000000o(r4, r3);	 Catch:{ Throwable -> 0x069e }
        java.lang.System.arraycopy(r3, r4, r6, r12, r2);	 Catch:{ Throwable -> 0x069e }
    L_0x069e:
        r12 = r12 + r2;
        r3 = new byte[r2];
        r3 = {0, 0};
        java.lang.System.arraycopy(r3, r4, r6, r12, r2);	 Catch:{ Throwable -> 0x06a7 }
    L_0x06a7:
        r12 = r12 + r2;
        r2 = r1.O000O0oo;
        if (r2 == 0) goto L_0x06b1;
    L_0x06ac:
        r2 = r1.O000O0oo;
        r9 = r2.length;
        r2 = 0;
        goto L_0x06b3;
    L_0x06b1:
        r2 = 0;
        r9 = 0;
    L_0x06b3:
        r2 = com.amap.api.mapcore.util.bt.O000000o(r9, r2);
        r3 = r2.length;
        r4 = 0;
        java.lang.System.arraycopy(r2, r4, r6, r12, r3);
        r2 = r2.length;
        r12 = r12 + r2;
        if (r9 <= 0) goto L_0x06cc;
    L_0x06c0:
        r2 = r1.O000O0oo;
        r3 = r1.O000O0oo;
        r3 = r3.length;
        java.lang.System.arraycopy(r2, r4, r6, r12, r3);
        r2 = r1.O000O0oo;
        r2 = r2.length;
        r12 = r12 + r2;
    L_0x06cc:
        r2 = new byte[r12];
        java.lang.System.arraycopy(r6, r4, r2, r4, r12);
        r3 = new java.util.zip.CRC32;
        r3.<init>();
        r3.update(r2);
        r5 = r3.getValue();
        r3 = com.amap.api.mapcore.util.bt.O000000o(r5);
        r5 = r3.length;
        r5 = r5 + r12;
        r5 = new byte[r5];
        java.lang.System.arraycopy(r2, r4, r5, r4, r12);
        r2 = r3.length;
        java.lang.System.arraycopy(r3, r4, r5, r12, r2);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bn.O000000o():byte[]");
    }
}
