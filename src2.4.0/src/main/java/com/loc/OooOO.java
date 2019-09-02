package com.loc;

import android.annotation.SuppressLint;
import android.net.wifi.ScanResult;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* compiled from: Req */
public final class OooOO {
    protected static String O000OO;
    protected static String O000OO00;
    public String O000000o = "1";
    protected short O00000Oo = (short) 0;
    protected String O00000o = null;
    protected String O00000o0 = null;
    protected String O00000oO = null;
    protected String O00000oo = null;
    protected String O0000O0o = null;
    public String O0000OOo = null;
    protected String O0000Oo = null;
    public String O0000Oo0 = null;
    protected String O0000OoO = null;
    protected String O0000Ooo = null;
    protected String O0000o = null;
    protected String O0000o0 = null;
    protected String O0000o00 = null;
    protected String O0000o0O = null;
    protected String O0000o0o = null;
    protected String O0000oO = null;
    protected String O0000oO0 = null;
    protected String O0000oOO = null;
    protected String O0000oOo = null;
    protected String O0000oo = null;
    protected String O0000oo0 = null;
    protected String O0000ooO = null;
    protected String O0000ooo = null;
    protected String O000O00o = null;
    protected ArrayList<O0OO0O> O000O0OO = new ArrayList();
    protected String O000O0Oo = null;
    protected String O000O0o = null;
    protected ArrayList<ScanResult> O000O0o0 = new ArrayList();
    protected String O000O0oO = null;
    protected byte[] O000O0oo = null;
    protected String O000OO0o = null;
    protected String O000OOOo = null;
    private byte[] O000OOo = null;
    protected String O000OOo0 = null;
    private int O000OOoO = 0;
    protected String O00oOoOo = null;
    protected int O00oOooO = 0;
    protected String O00oOooo = null;

    private static int O000000o(String str, byte[] bArr, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i] = (byte) 0;
                return i + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                length = TransportMediator.KEYCODE_MEDIA_PAUSE;
            }
            bArr[i] = (byte) length;
            i++;
            System.arraycopy(bytes, 0, bArr, i, length);
            return i + length;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Req", "copyContentWithByteLen");
            bArr[i] = (byte) 0;
        }
    }

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
        com.loc.O0o0000.O000000o(r0, r1, r7);
        r7 = "00:00:00:00:00:00";
        r2 = r6.O000000o(r7);
    L_0x005b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OooOO.O000000o(java.lang.String):byte[]");
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

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0368 A:{Catch:{ Throwable -> 0x036e }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:106:0x0360 */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x035a A:{Catch:{ Throwable -> 0x0360 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0368 A:{Catch:{ Throwable -> 0x036e }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:102:0x0352 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(1:2)|3|(1:5)|6|(9:8|(2:10|11)|14|15|(1:17)|18|(2:20|21)|24|(1:27))(1:28)|29|30|31|32|35|(2:37|(1:39)(1:40))(1:41)|42|(3:44|45|61)(1:62)|63|(1:68)(1:67)|69|(2:(2:72|(7:74|(1:76)|79|80|81|(1:85)|86))|(1:90))(2:91|(1:93))|94|(1:96)|97|98|99|(1:101)|102|103|(1:105)|106|107|(1:109)|110|112) */
    /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(1:2)|3|(1:5)|6|(9:8|(2:10|11)|14|15|(1:17)|18|(2:20|21)|24|(1:27))(1:28)|29|(3:30|31|32)|35|(2:37|(1:39)(1:40))(1:41)|42|(3:44|45|61)(1:62)|63|(1:68)(1:67)|69|(2:(2:72|(7:74|(1:76)|79|80|81|(1:85)|86))|(1:90))(2:91|(1:93))|94|(1:96)|97|98|99|(1:101)|102|103|(1:105)|106|107|(1:109)|110|112) */
    public final void O000000o(android.content.Context r29, boolean r30, boolean r31, com.loc.O0Oo0o0 r32, com.loc.O0OOO00 r33, android.net.ConnectivityManager r34, java.lang.String r35, java.lang.String r36) {
        /*
        r28 = this;
        r1 = r28;
        r2 = "0";
        r3 = "0";
        r4 = "0";
        r5 = "0";
        r6 = "0";
        r7 = com.loc.OO00o00.O00000oo(r29);
        r8 = com.loc.OO000OO.O0000O0o();
        r9 = "";
        r10 = "";
        r11 = "";
        r12 = r36;
        r1.O000OO0o = r12;
        r12 = "api_serverSDK_130905";
        r13 = "S128DF1572465B890OE3F7A13167KLEI";
        if (r31 != 0) goto L_0x0028;
    L_0x0024:
        r12 = "UC_nlp_20131029";
        r13 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
    L_0x0028:
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = r32.O00000oO();
        r16 = r2;
        r2 = r32.O00000oo();
        r17 = r9;
        r9 = r32.O0000O0o();
        r18 = r10;
        r10 = r32.O000000o();
        r19 = r11;
        r11 = r32.O00000Oo();
        r20 = r8;
        r8 = r33.O00000o0();
        r21 = r7;
        r7 = 2;
        if (r2 != r7) goto L_0x0056;
    L_0x0054:
        r16 = "1";
    L_0x0056:
        r22 = r16;
        if (r9 == 0) goto L_0x00ac;
    L_0x005a:
        r7 = com.loc.O0o0000.O00000o;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x0077;
    L_0x0062:
        r7 = com.loc.OO0O0o0.O0000oo0(r29);	 Catch:{ Throwable -> 0x0069 }
        com.loc.O0o0000.O00000o = r7;	 Catch:{ Throwable -> 0x0069 }
        goto L_0x0077;
    L_0x0069:
        r0 = move-exception;
        r7 = r0;
        r23 = r6;
        r6 = "Aps";
        r24 = r5;
        r5 = "getApsReq part4";
        com.loc.O0o0000.O000000o(r7, r6, r5);
        goto L_0x007b;
    L_0x0077:
        r24 = r5;
        r23 = r6;
    L_0x007b:
        r5 = com.loc.O0o0000.O00000o;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 == 0) goto L_0x0087;
    L_0x0083:
        r5 = "888888888888888";
        com.loc.O0o0000.O00000o = r5;
    L_0x0087:
        r5 = com.loc.O0o0000.O00000oO;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 == 0) goto L_0x009f;
    L_0x008f:
        r5 = r9.getSubscriberId();	 Catch:{ SecurityException -> 0x009f, Throwable -> 0x0096 }
        com.loc.O0o0000.O00000oO = r5;	 Catch:{ SecurityException -> 0x009f, Throwable -> 0x0096 }
        goto L_0x009f;
    L_0x0096:
        r0 = move-exception;
        r5 = r0;
        r6 = "Aps";
        r7 = "getApsReq part2";
        com.loc.O0o0000.O000000o(r5, r6, r7);
    L_0x009f:
        r5 = com.loc.O0o0000.O00000oO;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 == 0) goto L_0x00b0;
    L_0x00a7:
        r5 = "888888888888888";
        com.loc.O0o0000.O00000oO = r5;
        goto L_0x00b0;
    L_0x00ac:
        r24 = r5;
        r23 = r6;
    L_0x00b0:
        r5 = 0;
        r6 = r34.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x00b7 }
        r5 = r6;
        goto L_0x00bf;
    L_0x00b7:
        r0 = move-exception;
        r6 = "Aps";
        r7 = "getApsReq part";
        com.loc.O0o0000.O000000o(r0, r6, r7);
    L_0x00bf:
        r6 = r33.O000000o(r34);
        r5 = com.loc.OO000OO.O000000o(r5);
        r7 = -1;
        if (r5 == r7) goto L_0x00d6;
    L_0x00ca:
        r9 = com.loc.OO000OO.O00000Oo(r9);
        if (r6 == 0) goto L_0x00d3;
    L_0x00d0:
        r5 = "2";
        goto L_0x00da;
    L_0x00d3:
        r5 = "1";
        goto L_0x00da;
    L_0x00d6:
        r9 = r17;
        r5 = r18;
    L_0x00da:
        r7 = r10.isEmpty();
        r25 = r5;
        r5 = 0;
        if (r7 != 0) goto L_0x021e;
    L_0x00e3:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        switch(r2) {
            case 1: goto L_0x0179;
            case 2: goto L_0x00f1;
            default: goto L_0x00eb;
        };
    L_0x00eb:
        r26 = r9;
        r27 = r19;
        goto L_0x0213;
    L_0x00f1:
        r2 = r10.get(r5);
        r2 = (com.loc.O0OO0O) r2;
        r10 = r7.length();
        r7.delete(r5, r10);
        r10 = "<mcc>";
        r7.append(r10);
        r10 = r2.O000000o;
        r7.append(r10);
        r10 = "</mcc>";
        r7.append(r10);
        r10 = "<sid>";
        r7.append(r10);
        r10 = r2.O0000O0o;
        r7.append(r10);
        r10 = "</sid>";
        r7.append(r10);
        r10 = "<nid>";
        r7.append(r10);
        r10 = r2.O0000OOo;
        r7.append(r10);
        r10 = "</nid>";
        r7.append(r10);
        r10 = "<bid>";
        r7.append(r10);
        r10 = r2.O0000Oo0;
        r7.append(r10);
        r10 = "</bid>";
        r7.append(r10);
        r10 = r2.O00000oo;
        if (r10 <= 0) goto L_0x0160;
    L_0x013e:
        r10 = r2.O00000oO;
        if (r10 <= 0) goto L_0x0160;
    L_0x0142:
        r10 = "<lon>";
        r7.append(r10);
        r10 = r2.O00000oo;
        r7.append(r10);
        r10 = "</lon>";
        r7.append(r10);
        r10 = "<lat>";
        r7.append(r10);
        r10 = r2.O00000oO;
        r7.append(r10);
        r10 = "</lat>";
        r7.append(r10);
    L_0x0160:
        r10 = "<signal>";
        r7.append(r10);
        r2 = r2.O0000Oo;
        r7.append(r2);
        r2 = "</signal>";
        r7.append(r2);
        r2 = r7.toString();
        r27 = r2;
        r26 = r9;
        goto L_0x0213;
    L_0x0179:
        r2 = r10.get(r5);
        r2 = (com.loc.O0OO0O) r2;
        r26 = r9;
        r9 = r7.length();
        r7.delete(r5, r9);
        r9 = "<mcc>";
        r7.append(r9);
        r9 = r2.O000000o;
        r7.append(r9);
        r9 = "</mcc>";
        r7.append(r9);
        r9 = "<mnc>";
        r7.append(r9);
        r9 = r2.O00000Oo;
        r7.append(r9);
        r9 = "</mnc>";
        r7.append(r9);
        r9 = "<lac>";
        r7.append(r9);
        r9 = r2.O00000o0;
        r7.append(r9);
        r9 = "</lac>";
        r7.append(r9);
        r9 = "<cellid>";
        r7.append(r9);
        r9 = r2.O00000o;
        r7.append(r9);
        r9 = "</cellid>";
        r7.append(r9);
        r9 = "<signal>";
        r7.append(r9);
        r2 = r2.O0000Oo;
        r7.append(r2);
        r2 = "</signal>";
        r7.append(r2);
        r2 = r7.toString();
        r5 = 1;
    L_0x01d8:
        r9 = r10.size();
        if (r5 >= r9) goto L_0x0211;
    L_0x01de:
        r9 = r10.get(r5);
        r9 = (com.loc.O0OO0O) r9;
        r27 = r2;
        r2 = r9.O00000o0;
        r14.append(r2);
        r2 = ",";
        r14.append(r2);
        r2 = r9.O00000o;
        r14.append(r2);
        r2 = ",";
        r14.append(r2);
        r2 = r9.O0000Oo;
        r14.append(r2);
        r2 = r10.size();
        r9 = 1;
        r2 = r2 - r9;
        if (r5 >= r2) goto L_0x020c;
    L_0x0207:
        r2 = "*";
        r14.append(r2);
    L_0x020c:
        r5 = r5 + 1;
        r2 = r27;
        goto L_0x01d8;
    L_0x0211:
        r27 = r2;
    L_0x0213:
        r2 = r7.length();
        r5 = 0;
        r7.delete(r5, r2);
        r2 = r27;
        goto L_0x0222;
    L_0x021e:
        r26 = r9;
        r2 = r19;
    L_0x0222:
        r5 = r15 & 4;
        r7 = 4;
        if (r5 != r7) goto L_0x0238;
    L_0x0227:
        r5 = r11.isEmpty();
        if (r5 != 0) goto L_0x0238;
    L_0x022d:
        r5 = r1.O000O0OO;
        r5.clear();
        r5 = r1.O000O0OO;
        r5.addAll(r11);
        goto L_0x023d;
    L_0x0238:
        r5 = r1.O000O0OO;
        r5.clear();
    L_0x023d:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r7 = r33.O0000O0o();
        if (r7 == 0) goto L_0x02aa;
    L_0x0248:
        if (r6 == 0) goto L_0x0299;
    L_0x024a:
        r6 = r33.O0000OOo();
        r7 = com.loc.O0OOO00.O000000o(r6);
        if (r7 == 0) goto L_0x0299;
    L_0x0254:
        r7 = r6.getBSSID();
        r5.append(r7);
        r7 = ",";
        r5.append(r7);
        r7 = r6.getRssi();
        r9 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r7 >= r9) goto L_0x026a;
    L_0x0268:
        r7 = 0;
        goto L_0x026f;
    L_0x026a:
        r9 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r7 <= r9) goto L_0x026f;
    L_0x026e:
        goto L_0x0268;
    L_0x026f:
        r5.append(r7);
        r7 = ",";
        r5.append(r7);
        r7 = r6.getSSID();
        r9 = 32;
        r6 = r6.getSSID();	 Catch:{ Exception -> 0x0289 }
        r10 = "UTF-8";
        r6 = r6.getBytes(r10);	 Catch:{ Exception -> 0x0289 }
        r6 = r6.length;	 Catch:{ Exception -> 0x0289 }
        goto L_0x028a;
    L_0x0289:
        r6 = r9;
    L_0x028a:
        if (r6 < r9) goto L_0x028e;
    L_0x028c:
        r7 = "unkwn";
    L_0x028e:
        r6 = "*";
        r9 = ".";
        r6 = r7.replace(r6, r9);
        r5.append(r6);
    L_0x0299:
        if (r8 == 0) goto L_0x02b6;
    L_0x029b:
        r6 = r1.O000O0o0;
        if (r6 == 0) goto L_0x02b6;
    L_0x029f:
        r6 = r1.O000O0o0;
        r6.clear();
        r6 = r1.O000O0o0;
        r6.addAll(r8);
        goto L_0x02b6;
    L_0x02aa:
        r33.O00000o();
        r6 = r1.O000O0o0;
        if (r6 == 0) goto L_0x02b6;
    L_0x02b1:
        r6 = r1.O000O0o0;
        r6.clear();
    L_0x02b6:
        r6 = 0;
        r1.O00000Oo = r6;
        if (r30 != 0) goto L_0x02c2;
    L_0x02bb:
        r6 = r1.O00000Oo;
        r7 = 2;
        r6 = r6 | r7;
        r6 = (short) r6;
        r1.O00000Oo = r6;
    L_0x02c2:
        r1.O00000o0 = r12;
        r1.O00000o = r13;
        r6 = com.loc.OO000OO.O00000oO();
        r1.O00000oo = r6;
        r6 = new java.lang.StringBuilder;
        r7 = "android";
        r6.<init>(r7);
        r7 = com.loc.OO000OO.O00000oo();
        r6.append(r7);
        r6 = r6.toString();
        r1.O0000O0o = r6;
        r6 = com.loc.OO000OO.O00000Oo(r29);
        r1.O0000OOo = r6;
        r6 = r22;
        r1.O0000Oo0 = r6;
        r1.O0000Oo = r3;
        r3 = "0";
        r1.O0000OoO = r3;
        r1.O0000Ooo = r4;
        r3 = r24;
        r1.O0000o00 = r3;
        r3 = r23;
        r1.O0000o0 = r3;
        r3 = r21;
        r1.O0000o0O = r3;
        r3 = com.loc.O0o0000.O00000o;
        r1.O0000o0o = r3;
        r3 = com.loc.O0o0000.O00000oO;
        r1.O0000o = r3;
        r3 = r20;
        r3 = java.lang.String.valueOf(r3);
        r1.O0000oO = r3;
        r3 = com.loc.OO000OO.O0000Oo0(r29);
        r1.O0000oOO = r3;
        r3 = "4.6.0";
        r1.O0000oo0 = r3;
        r3 = r35;
        r1.O0000oo = r3;
        r3 = "";
        r1.O0000oOo = r3;
        r9 = r26;
        r1.O0000ooO = r9;
        r3 = r25;
        r1.O0000ooo = r3;
        r1.O00oOooO = r15;
        r1.O00oOooo = r2;
        r2 = r14.toString();
        r1.O000O00o = r2;
        r2 = r32.O0000OoO();
        r1.O000O0Oo = r2;
        r2 = com.loc.O0OOO00.O0000Ooo();
        r1.O000O0o = r2;
        r2 = r5.toString();
        r1.O00oOoOo = r2;
        r2 = O000OO00;	 Catch:{ Throwable -> 0x0352 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0352 }
        if (r2 == 0) goto L_0x0352;
    L_0x034c:
        r2 = com.loc.OO0O0o0.O0000OOo(r29);	 Catch:{ Throwable -> 0x0352 }
        O000OO00 = r2;	 Catch:{ Throwable -> 0x0352 }
    L_0x0352:
        r2 = O000OO;	 Catch:{ Throwable -> 0x0360 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0360 }
        if (r2 == 0) goto L_0x0360;
    L_0x035a:
        r2 = com.loc.OO0O0o0.O00000Oo(r29);	 Catch:{ Throwable -> 0x0360 }
        O000OO = r2;	 Catch:{ Throwable -> 0x0360 }
    L_0x0360:
        r2 = r1.O000OOo0;	 Catch:{ Throwable -> 0x036e }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x036e }
        if (r2 == 0) goto L_0x036e;
    L_0x0368:
        r2 = com.loc.OO0O0o0.O0000Oo0(r29);	 Catch:{ Throwable -> 0x036e }
        r1.O000OOo0 = r2;	 Catch:{ Throwable -> 0x036e }
    L_0x036e:
        r2 = r14.length();
        r3 = 0;
        r14.delete(r3, r2);
        r2 = r5.length();
        r5.delete(r3, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OooOO.O000000o(android.content.Context, boolean, boolean, com.loc.O0Oo0o0, com.loc.O0OOO00, android.net.ConnectivityManager, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x069e A:{Catch:{ Throwable -> 0x06c3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06b0 A:{SYNTHETIC, Splitter:B:303:0x06b0} */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x06e5  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x06e0  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06f4  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x070e  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0526  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0521  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x05b3  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x05ac  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x0675 A:{Catch:{ Throwable -> 0x068b }} */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x067d A:{Catch:{ Throwable -> 0x068b }} */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0678 A:{Catch:{ Throwable -> 0x068b }} */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x06e0  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x06e5  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06f4  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x070e  */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x06e5  */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x06e0  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06f4  */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x070e  */
    public final byte[] O000000o() {
        /*
        r21 = this;
        r1 = r21;
        r2 = r1.O000000o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x000e;
    L_0x000a:
        r2 = "";
        r1.O000000o = r2;
    L_0x000e:
        r2 = r1.O00000o0;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x001a;
    L_0x0016:
        r2 = "";
        r1.O00000o0 = r2;
    L_0x001a:
        r2 = r1.O00000o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0026;
    L_0x0022:
        r2 = "";
        r1.O00000o = r2;
    L_0x0026:
        r2 = r1.O00000oO;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0032;
    L_0x002e:
        r2 = "";
        r1.O00000oO = r2;
    L_0x0032:
        r2 = r1.O00000oo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x003e;
    L_0x003a:
        r2 = "";
        r1.O00000oo = r2;
    L_0x003e:
        r2 = r1.O0000O0o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x004a;
    L_0x0046:
        r2 = "";
        r1.O0000O0o = r2;
    L_0x004a:
        r2 = r1.O0000OOo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0056;
    L_0x0052:
        r2 = "";
        r1.O0000OOo = r2;
    L_0x0056:
        r2 = r1.O0000Oo0;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0062;
    L_0x005e:
        r2 = "";
        r1.O0000Oo0 = r2;
    L_0x0062:
        r2 = r1.O0000Oo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x006f;
    L_0x006a:
        r2 = "0";
        r1.O0000Oo = r2;
        goto L_0x0084;
    L_0x006f:
        r2 = "0";
        r3 = r1.O0000Oo;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0084;
    L_0x0079:
        r2 = "2";
        r3 = r1.O0000Oo;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0084;
    L_0x0083:
        goto L_0x006a;
    L_0x0084:
        r2 = r1.O0000OoO;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0091;
    L_0x008c:
        r2 = "0";
        r1.O0000OoO = r2;
        goto L_0x00a6;
    L_0x0091:
        r2 = "0";
        r3 = r1.O0000OoO;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x00a6;
    L_0x009b:
        r2 = "1";
        r3 = r1.O0000OoO;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x00a6;
    L_0x00a5:
        goto L_0x008c;
    L_0x00a6:
        r2 = r1.O0000Ooo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00b2;
    L_0x00ae:
        r2 = "";
        r1.O0000Ooo = r2;
    L_0x00b2:
        r2 = r1.O0000o00;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00be;
    L_0x00ba:
        r2 = "";
        r1.O0000o00 = r2;
    L_0x00be:
        r2 = r1.O0000o0;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00ca;
    L_0x00c6:
        r2 = "";
        r1.O0000o0 = r2;
    L_0x00ca:
        r2 = r1.O0000o0O;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00d6;
    L_0x00d2:
        r2 = "";
        r1.O0000o0O = r2;
    L_0x00d6:
        r2 = r1.O0000o0o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00e2;
    L_0x00de:
        r2 = "";
        r1.O0000o0o = r2;
    L_0x00e2:
        r2 = r1.O0000o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00ee;
    L_0x00ea:
        r2 = "";
        r1.O0000o = r2;
    L_0x00ee:
        r2 = r1.O0000oO0;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x00fa;
    L_0x00f6:
        r2 = "";
        r1.O0000oO0 = r2;
    L_0x00fa:
        r2 = r1.O0000oO;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0106;
    L_0x0102:
        r2 = "";
        r1.O0000oO = r2;
    L_0x0106:
        r2 = r1.O0000oOO;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0112;
    L_0x010e:
        r2 = "";
        r1.O0000oOO = r2;
    L_0x0112:
        r2 = r1.O0000oOo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x011e;
    L_0x011a:
        r2 = "";
        r1.O0000oOo = r2;
    L_0x011e:
        r2 = r1.O0000oo0;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x012a;
    L_0x0126:
        r2 = "";
        r1.O0000oo0 = r2;
    L_0x012a:
        r2 = r1.O0000oo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0136;
    L_0x0132:
        r2 = "";
        r1.O0000oo = r2;
    L_0x0136:
        r2 = r1.O0000ooO;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0142;
    L_0x013e:
        r2 = "";
        r1.O0000ooO = r2;
    L_0x0142:
        r2 = r1.O0000ooo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x014f;
    L_0x014a:
        r2 = "0";
        r1.O0000ooo = r2;
        goto L_0x0164;
    L_0x014f:
        r2 = "1";
        r3 = r1.O0000ooo;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0164;
    L_0x0159:
        r2 = "2";
        r3 = r1.O0000ooo;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0164;
    L_0x0163:
        goto L_0x014a;
    L_0x0164:
        r2 = r1.O00oOooO;
        r3 = 1;
        r4 = 0;
        if (r2 <= 0) goto L_0x0171;
    L_0x016a:
        r5 = 15;
        if (r2 <= r5) goto L_0x016f;
    L_0x016e:
        goto L_0x0171;
    L_0x016f:
        r2 = r3;
        goto L_0x0172;
    L_0x0171:
        r2 = r4;
    L_0x0172:
        if (r2 != 0) goto L_0x0176;
    L_0x0174:
        r1.O00oOooO = r4;
    L_0x0176:
        r2 = r1.O00oOooo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0182;
    L_0x017e:
        r2 = "";
        r1.O00oOooo = r2;
    L_0x0182:
        r2 = r1.O000O00o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x018e;
    L_0x018a:
        r2 = "";
        r1.O000O00o = r2;
    L_0x018e:
        r2 = r1.O00oOoOo;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x019a;
    L_0x0196:
        r2 = "";
        r1.O00oOoOo = r2;
    L_0x019a:
        r2 = r1.O000O0o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x01a6;
    L_0x01a2:
        r2 = "";
        r1.O000O0o = r2;
    L_0x01a6:
        r2 = r1.O000O0oO;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x01b2;
    L_0x01ae:
        r2 = "";
        r1.O000O0oO = r2;
    L_0x01b2:
        r2 = O000OO00;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x01be;
    L_0x01ba:
        r2 = "";
        O000OO00 = r2;
    L_0x01be:
        r2 = r1.O000O0oo;
        if (r2 != 0) goto L_0x01c6;
    L_0x01c2:
        r2 = new byte[r4];
        r1.O000O0oo = r2;
    L_0x01c6:
        r2 = r1.O000OOo0;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x01d2;
    L_0x01ce:
        r2 = "";
        r1.O000OOo0 = r2;
    L_0x01d2:
        r2 = 2;
        r5 = new byte[r2];
        r6 = 4;
        r7 = new byte[r6];
        r8 = r1.O000O0oo;
        r9 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        if (r8 == 0) goto L_0x01e3;
    L_0x01de:
        r8 = r1.O000O0oo;
        r8 = r8.length;
        r8 = r8 + r3;
        r9 = r9 + r8;
    L_0x01e3:
        r8 = r1.O000OOo;
        if (r8 == 0) goto L_0x01ef;
    L_0x01e7:
        r8 = r1.O000OOoO;
        if (r9 <= r8) goto L_0x01ec;
    L_0x01eb:
        goto L_0x01ef;
    L_0x01ec:
        r8 = r1.O000OOo;
        goto L_0x01f5;
    L_0x01ef:
        r8 = new byte[r9];
        r1.O000OOo = r8;
        r1.O000OOoO = r9;
    L_0x01f5:
        r9 = r1.O000000o;
        r9 = com.loc.OO000OO.O0000Oo(r9);
        r8[r4] = r9;
        r9 = r1.O00000Oo;
        r10 = 0;
        r9 = com.loc.OO000OO.O000000o(r9, r10);
        r11 = r9.length;
        java.lang.System.arraycopy(r9, r4, r8, r3, r11);
        r9 = r9.length;
        r9 = r9 + r3;
        r11 = r1.O00000o0;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O00000o;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000o0O;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O00000oO;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O00000oo;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000O0o;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000oOo;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000OOo;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000o0o;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000o;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000oOO;	 Catch:{ Throwable -> 0x0265 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Throwable -> 0x0265 }
        if (r11 == 0) goto L_0x0252;
    L_0x024e:
        r8[r9] = r4;	 Catch:{ Throwable -> 0x0265 }
        r9 = r9 + r3;
        goto L_0x0273;
    L_0x0252:
        r11 = r1.O0000oOO;	 Catch:{ Throwable -> 0x0265 }
        r11 = r1.O000000o(r11);	 Catch:{ Throwable -> 0x0265 }
        r12 = r11.length;	 Catch:{ Throwable -> 0x0265 }
        r12 = (byte) r12;	 Catch:{ Throwable -> 0x0265 }
        r8[r9] = r12;	 Catch:{ Throwable -> 0x0265 }
        r9 = r9 + 1;
        r12 = r11.length;	 Catch:{ Throwable -> 0x0265 }
        java.lang.System.arraycopy(r11, r4, r8, r9, r12);	 Catch:{ Throwable -> 0x0265 }
        r11 = r11.length;	 Catch:{ Throwable -> 0x0265 }
        r9 = r9 + r11;
        goto L_0x0273;
    L_0x0265:
        r0 = move-exception;
        r11 = r9;
        r9 = r0;
        r12 = "Req";
        r13 = "buildV4Dot219";
        com.loc.O0o0000.O000000o(r9, r12, r13);
        r8[r11] = r4;
        r9 = r11 + 1;
    L_0x0273:
        r11 = r1.O0000oo0;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000oo;
        r9 = O000000o(r11, r8, r9);
        r11 = O000OO00;
        r9 = O000000o(r11, r8, r9);
        r11 = O000OO;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000ooO;
        r9 = O000000o(r11, r8, r9);
        r11 = r1.O0000ooo;
        r11 = java.lang.Byte.parseByte(r11);
        r8[r9] = r11;
        r9 = r9 + r3;
        r11 = r1.O0000Oo;
        r11 = java.lang.Byte.parseByte(r11);
        r8[r9] = r11;
        r9 = r9 + r3;
        r11 = r1.O00oOooO;
        r12 = 3;
        r11 = r11 & r12;
        r13 = r1.O00oOooO;
        r13 = (byte) r13;
        r8[r9] = r13;
        r9 = r9 + r3;
        r13 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        r14 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r11 == r3) goto L_0x02b5;
    L_0x02b3:
        if (r11 != r2) goto L_0x03c9;
    L_0x02b5:
        r15 = "mcc";
        r15 = r1.O00000Oo(r15);
        r15 = com.loc.OO000OO.O00000Oo(r15);
        r10 = r15.length;
        java.lang.System.arraycopy(r15, r4, r8, r9, r10);
        r10 = r15.length;
        r9 = r9 + r10;
        if (r11 != r3) goto L_0x02f8;
    L_0x02c7:
        r10 = "mnc";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        r9 = r9 + r10;
        r10 = "lac";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        r9 = r9 + r10;
        r10 = "cellid";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000o0(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
    L_0x02f6:
        r9 = r9 + r10;
        goto L_0x034a;
    L_0x02f8:
        if (r11 != r2) goto L_0x034a;
    L_0x02fa:
        r10 = "sid";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        r9 = r9 + r10;
        r10 = "nid";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        r9 = r9 + r10;
        r10 = "bid";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000Oo(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        r9 = r9 + r10;
        r10 = "lon";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000o0(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        r9 = r9 + r10;
        r10 = "lat";
        r10 = r1.O00000Oo(r10);
        r10 = com.loc.OO000OO.O00000o0(r10);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r10 = r10.length;
        goto L_0x02f6;
    L_0x034a:
        r10 = "signal";
        r10 = r1.O00000Oo(r10);
        r10 = java.lang.Integer.parseInt(r10);
        if (r10 <= r14) goto L_0x0358;
    L_0x0356:
        r10 = r4;
        goto L_0x035b;
    L_0x0358:
        if (r10 >= r13) goto L_0x035b;
    L_0x035a:
        goto L_0x0356;
    L_0x035b:
        r10 = (byte) r10;
        r8[r9] = r10;
        r9 = r9 + r3;
        r10 = com.loc.OO000OO.O000000o(r4, r5);
        r15 = r10.length;
        java.lang.System.arraycopy(r10, r4, r8, r9, r15);
        r9 = r9 + r2;
        if (r11 != r3) goto L_0x03c4;
    L_0x036a:
        r10 = r1.O000O00o;
        r10 = android.text.TextUtils.isEmpty(r10);
        if (r10 == 0) goto L_0x0377;
    L_0x0372:
        r8[r9] = r4;
    L_0x0374:
        r9 = r9 + 1;
        goto L_0x03c9;
    L_0x0377:
        r10 = r1.O000O00o;
        r11 = "\\*";
        r10 = r10.split(r11);
        r10 = r10.length;
        r11 = (byte) r10;
        r8[r9] = r11;
        r9 = r9 + 1;
        r11 = r9;
        r9 = r4;
    L_0x0387:
        if (r9 >= r10) goto L_0x03c2;
    L_0x0389:
        r15 = "lac";
        r15 = r1.O000000o(r15, r9);
        r15 = com.loc.OO000OO.O00000Oo(r15);
        r12 = r15.length;
        java.lang.System.arraycopy(r15, r4, r8, r11, r12);
        r12 = r15.length;
        r11 = r11 + r12;
        r12 = "cellid";
        r12 = r1.O000000o(r12, r9);
        r12 = com.loc.OO000OO.O00000o0(r12);
        r15 = r12.length;
        java.lang.System.arraycopy(r12, r4, r8, r11, r15);
        r12 = r12.length;
        r11 = r11 + r12;
        r12 = "signal";
        r12 = r1.O000000o(r12, r9);
        r12 = java.lang.Integer.parseInt(r12);
        if (r12 <= r14) goto L_0x03b7;
    L_0x03b5:
        r12 = r4;
        goto L_0x03ba;
    L_0x03b7:
        if (r12 >= r13) goto L_0x03ba;
    L_0x03b9:
        goto L_0x03b5;
    L_0x03ba:
        r12 = (byte) r12;
        r8[r11] = r12;
        r11 = r11 + r3;
        r9 = r9 + 1;
        r12 = 3;
        goto L_0x0387;
    L_0x03c2:
        r9 = r11;
        goto L_0x03c9;
    L_0x03c4:
        if (r11 != r2) goto L_0x03c9;
    L_0x03c6:
        r8[r9] = r4;
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
        r8[r9] = r12;	 Catch:{ Exception -> 0x03eb }
        r9 = r9 + 1;
        java.lang.System.arraycopy(r10, r4, r8, r9, r11);	 Catch:{ Exception -> 0x03eb }
        r9 = r9 + r11;
        goto L_0x03ee;
    L_0x03eb:
        r8[r9] = r4;
        r9 = r9 + r3;
    L_0x03ee:
        r10 = r1.O000O0OO;
        r11 = r10.size();
        r12 = r1.O00oOooO;
        r12 = r12 & r6;
        r16 = 4617315517961601024; // 0x4014000000000000 float:0.0 double:5.0;
        if (r12 != r6) goto L_0x0514;
    L_0x03fb:
        if (r11 <= 0) goto L_0x0514;
    L_0x03fd:
        r12 = r10.get(r4);
        r12 = (com.loc.O0OO0O) r12;
        r12 = r12.O0000o0o;
        if (r12 != 0) goto L_0x0409;
    L_0x0407:
        r11 = r11 + -1;
    L_0x0409:
        r12 = (byte) r11;
        r8[r9] = r12;
        r9 = r9 + r3;
        r12 = r9;
        r9 = r4;
    L_0x040f:
        if (r9 >= r11) goto L_0x0519;
    L_0x0411:
        r15 = r10.get(r9);
        r15 = (com.loc.O0OO0O) r15;
        r13 = r15.O0000o0o;
        if (r13 == 0) goto L_0x050c;
    L_0x041b:
        r13 = r15.O0000OoO;
        if (r13 == r3) goto L_0x0483;
    L_0x041f:
        r13 = r15.O0000OoO;
        r3 = 3;
        if (r13 == r3) goto L_0x0483;
    L_0x0424:
        r3 = r15.O0000OoO;
        if (r3 != r6) goto L_0x0429;
    L_0x0428:
        goto L_0x0483;
    L_0x0429:
        r3 = r15.O0000OoO;
        if (r3 != r2) goto L_0x04c1;
    L_0x042d:
        r3 = r15.O0000OoO;
        r3 = (byte) r3;
        r13 = r15.O0000o0;
        if (r13 == 0) goto L_0x0437;
    L_0x0434:
        r3 = r3 | 8;
        r3 = (byte) r3;
    L_0x0437:
        r8[r12] = r3;
        r12 = r12 + 1;
        r3 = r15.O000000o;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O0000O0o;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O0000OOo;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O0000Oo0;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O00000oo;
        r3 = com.loc.OO000OO.O00000Oo(r3, r7);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O00000oO;
        r3 = com.loc.OO000OO.O00000Oo(r3, r7);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        goto L_0x04c0;
    L_0x0483:
        r3 = r15.O0000OoO;
        r3 = (byte) r3;
        r13 = r15.O0000o0;
        if (r13 == 0) goto L_0x048d;
    L_0x048a:
        r3 = r3 | 8;
        r3 = (byte) r3;
    L_0x048d:
        r8[r12] = r3;
        r12 = r12 + 1;
        r3 = r15.O000000o;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O00000Oo;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O00000o0;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = r15.O00000o;
        r3 = com.loc.OO000OO.O00000Oo(r3, r7);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
    L_0x04c0:
        r12 = r12 + r3;
    L_0x04c1:
        r3 = r15.O0000Oo;
        if (r3 <= r14) goto L_0x04c8;
    L_0x04c5:
        r13 = 99;
        goto L_0x04ce;
    L_0x04c8:
        r13 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r3 >= r13) goto L_0x04cd;
    L_0x04cc:
        goto L_0x04c5;
    L_0x04cd:
        r13 = r3;
    L_0x04ce:
        r3 = (byte) r13;
        r8[r12] = r3;
        r3 = 1;
        r12 = r12 + r3;
        r3 = r15.O0000Ooo;
        r3 = com.loc.OO000OO.O000000o(r3, r5);
        r13 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r13);
        r3 = r3.length;
        r12 = r12 + r3;
        r3 = "5.1";
        r3 = java.lang.Double.valueOf(r3);
        r18 = r3.doubleValue();
        r3 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1));
        if (r3 < 0) goto L_0x050c;
    L_0x04ed:
        r3 = r15.O0000OoO;
        r13 = 3;
        if (r3 == r13) goto L_0x04f6;
    L_0x04f2:
        r3 = r15.O0000OoO;
        if (r3 != r6) goto L_0x050d;
    L_0x04f6:
        r3 = r15.O0000o0O;
        r15 = 32767; // 0x7fff float:4.5916E-41 double:1.6189E-319;
        if (r3 <= r15) goto L_0x04fd;
    L_0x04fc:
        r3 = r15;
    L_0x04fd:
        if (r3 >= 0) goto L_0x0500;
    L_0x04ff:
        goto L_0x0501;
    L_0x0500:
        r15 = r3;
    L_0x0501:
        r3 = com.loc.OO000OO.O000000o(r15, r5);
        r15 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r15);
        r3 = r3.length;
        r12 = r12 + r3;
        goto L_0x050d;
    L_0x050c:
        r13 = 3;
    L_0x050d:
        r9 = r9 + 1;
        r3 = 1;
        r13 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        goto L_0x040f;
    L_0x0514:
        r8[r9] = r4;
        r3 = 1;
        r12 = r9 + 1;
    L_0x0519:
        r6 = r1.O00oOoOo;
        r6 = r6.length();
        if (r6 != 0) goto L_0x0526;
    L_0x0521:
        r8[r12] = r4;
    L_0x0523:
        r12 = r12 + r3;
        goto L_0x059e;
    L_0x0526:
        r8[r12] = r3;
        r12 = r12 + r3;
        r3 = r1.O00oOoOo;	 Catch:{ Throwable -> 0x057c }
        r6 = ",";
        r3 = r3.split(r6);	 Catch:{ Throwable -> 0x057c }
        r6 = r3[r4];	 Catch:{ Throwable -> 0x057c }
        r6 = r1.O000000o(r6);	 Catch:{ Throwable -> 0x057c }
        r7 = r6.length;	 Catch:{ Throwable -> 0x057c }
        java.lang.System.arraycopy(r6, r4, r8, r12, r7);	 Catch:{ Throwable -> 0x057c }
        r6 = r6.length;	 Catch:{ Throwable -> 0x057c }
        r12 = r12 + r6;
        r6 = r3[r2];	 Catch:{ Throwable -> 0x0553 }
        r7 = "GBK";
        r6 = r6.getBytes(r7);	 Catch:{ Throwable -> 0x0553 }
        r7 = r6.length;	 Catch:{ Throwable -> 0x0553 }
        if (r7 <= r14) goto L_0x0549;
    L_0x0548:
        r7 = r14;
    L_0x0549:
        r9 = (byte) r7;	 Catch:{ Throwable -> 0x0553 }
        r8[r12] = r9;	 Catch:{ Throwable -> 0x0553 }
        r12 = r12 + 1;
        java.lang.System.arraycopy(r6, r4, r8, r12, r7);	 Catch:{ Throwable -> 0x0553 }
        r12 = r12 + r7;
        goto L_0x0560;
    L_0x0553:
        r0 = move-exception;
        r6 = r0;
        r7 = "Req";
        r9 = "buildV4Dot214";
        com.loc.O0o0000.O000000o(r6, r7, r9);	 Catch:{ Throwable -> 0x057c }
        r8[r12] = r4;	 Catch:{ Throwable -> 0x057c }
        r12 = r12 + 1;
    L_0x0560:
        r6 = 1;
        r3 = r3[r6];	 Catch:{ Throwable -> 0x057c }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Throwable -> 0x057c }
        if (r3 <= r14) goto L_0x056b;
    L_0x0569:
        r3 = r4;
        goto L_0x0570;
    L_0x056b:
        r6 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r3 >= r6) goto L_0x0570;
    L_0x056f:
        goto L_0x0569;
    L_0x0570:
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x057c }
        r3 = java.lang.Byte.parseByte(r3);	 Catch:{ Throwable -> 0x057c }
        r8[r12] = r3;	 Catch:{ Throwable -> 0x057c }
        r3 = 1;
        goto L_0x0523;
    L_0x057c:
        r0 = move-exception;
        r3 = r0;
        r6 = "Req";
        r7 = "buildV4Dot216";
        com.loc.O0o0000.O000000o(r3, r6, r7);
        r3 = "00:00:00:00:00:00";
        r3 = r1.O000000o(r3);
        r6 = r3.length;
        java.lang.System.arraycopy(r3, r4, r8, r12, r6);
        r3 = r3.length;
        r12 = r12 + r3;
        r8[r12] = r4;
        r3 = 1;
        r12 = r12 + r3;
        r6 = "0";
        r6 = java.lang.Byte.parseByte(r6);
        r8[r12] = r6;
        goto L_0x0523;
    L_0x059e:
        r6 = r1.O000O0o0;
        r7 = r6.size();
        r9 = 25;
        r7 = java.lang.Math.min(r7, r9);
        if (r7 != 0) goto L_0x05b3;
    L_0x05ac:
        r8[r12] = r4;
        r12 = r12 + r3;
        r14 = r4;
        r2 = r5;
        goto L_0x0664;
    L_0x05b3:
        r9 = (byte) r7;
        r8[r12] = r9;
        r12 = r12 + r3;
        r3 = com.loc.OO000OO.O00000o();
        r9 = 17;
        if (r3 < r9) goto L_0x05c1;
    L_0x05bf:
        r3 = 1;
        goto L_0x05c2;
    L_0x05c1:
        r3 = r4;
    L_0x05c2:
        r9 = 0;
        if (r3 == 0) goto L_0x05ce;
    L_0x05c6:
        r9 = com.loc.OO000OO.O00000o0();
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r9 = r9 / r18;
    L_0x05ce:
        r11 = r4;
    L_0x05cf:
        if (r11 >= r7) goto L_0x0652;
    L_0x05d1:
        r13 = r6.get(r11);
        r13 = (android.net.wifi.ScanResult) r13;
        r15 = r13.BSSID;
        r15 = r1.O000000o(r15);
        r2 = r15.length;
        java.lang.System.arraycopy(r15, r4, r8, r12, r2);
        r2 = r15.length;
        r12 = r12 + r2;
        r2 = r13.SSID;	 Catch:{ Exception -> 0x05f9 }
        r15 = "GBK";
        r2 = r2.getBytes(r15);	 Catch:{ Exception -> 0x05f9 }
        r15 = r2.length;	 Catch:{ Exception -> 0x05f9 }
        r15 = (byte) r15;	 Catch:{ Exception -> 0x05f9 }
        r8[r12] = r15;	 Catch:{ Exception -> 0x05f9 }
        r12 = r12 + 1;
        r15 = r2.length;	 Catch:{ Exception -> 0x05f9 }
        java.lang.System.arraycopy(r2, r4, r8, r12, r15);	 Catch:{ Exception -> 0x05f9 }
        r2 = r2.length;	 Catch:{ Exception -> 0x05f9 }
        r12 = r12 + r2;
        r2 = 1;
        goto L_0x05fd;
    L_0x05f9:
        r8[r12] = r4;
        r2 = 1;
        r12 = r12 + r2;
    L_0x05fd:
        r15 = r13.level;
        if (r15 <= r14) goto L_0x0605;
    L_0x0601:
        r15 = r4;
        r14 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        goto L_0x060a;
    L_0x0605:
        r14 = -128; // 0xffffffffffffff80 float:NaN double:NaN;
        if (r15 >= r14) goto L_0x060a;
    L_0x0609:
        r15 = r4;
    L_0x060a:
        r15 = java.lang.String.valueOf(r15);
        r15 = java.lang.Byte.parseByte(r15);
        r8[r12] = r15;
        r12 = r12 + r2;
        if (r3 == 0) goto L_0x062d;
    L_0x0617:
        r14 = r13.timestamp;
        r18 = r9 - r14;
        r14 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r18 = r18 / r14;
        r14 = 1;
        r20 = r5;
        r4 = r18 + r14;
        r4 = (int) r4;
        if (r4 >= 0) goto L_0x062a;
    L_0x0629:
        goto L_0x062f;
    L_0x062a:
        r2 = r20;
        goto L_0x0632;
    L_0x062d:
        r20 = r5;
    L_0x062f:
        r2 = r20;
        r4 = 0;
    L_0x0632:
        r4 = com.loc.OO000OO.O000000o(r4, r2);
        r5 = r4.length;
        r14 = 0;
        java.lang.System.arraycopy(r4, r14, r8, r12, r5);
        r4 = r4.length;
        r12 = r12 + r4;
        r4 = r13.frequency;
        r4 = com.loc.OO000OO.O000000o(r4, r2);
        r5 = r4.length;
        java.lang.System.arraycopy(r4, r14, r8, r12, r5);
        r4 = r4.length;
        r12 = r12 + r4;
        r11 = r11 + 1;
        r5 = r2;
        r4 = r14;
        r2 = 2;
        r14 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        goto L_0x05cf;
    L_0x0652:
        r14 = r4;
        r2 = r5;
        r3 = r1.O000O0o;
        r3 = java.lang.Integer.parseInt(r3);
        r3 = com.loc.OO000OO.O000000o(r3, r2);
        r4 = r3.length;
        java.lang.System.arraycopy(r3, r14, r8, r12, r4);
        r3 = r3.length;
        r12 = r12 + r3;
    L_0x0664:
        r8[r12] = r14;
        r3 = 1;
        r12 = r12 + r3;
        r3 = r1.O000O0oO;	 Catch:{ Throwable -> 0x068b }
        r4 = "GBK";
        r10 = r3.getBytes(r4);	 Catch:{ Throwable -> 0x068b }
        r3 = r10.length;	 Catch:{ Throwable -> 0x068b }
        r4 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r3 <= r4) goto L_0x0676;
    L_0x0675:
        r10 = 0;
    L_0x0676:
        if (r10 != 0) goto L_0x067d;
    L_0x0678:
        r3 = 0;
        r8[r12] = r3;	 Catch:{ Throwable -> 0x068b }
        r3 = 1;
        goto L_0x068f;
    L_0x067d:
        r3 = r10.length;	 Catch:{ Throwable -> 0x068b }
        r3 = (byte) r3;	 Catch:{ Throwable -> 0x068b }
        r8[r12] = r3;	 Catch:{ Throwable -> 0x068b }
        r12 = r12 + 1;
        r3 = r10.length;	 Catch:{ Throwable -> 0x068b }
        r4 = 0;
        java.lang.System.arraycopy(r10, r4, r8, r12, r3);	 Catch:{ Throwable -> 0x068b }
        r3 = r10.length;	 Catch:{ Throwable -> 0x068b }
        r12 = r12 + r3;
        goto L_0x0690;
    L_0x068b:
        r3 = 0;
        r8[r12] = r3;
        r3 = 1;
    L_0x068f:
        r12 = r12 + r3;
    L_0x0690:
        r3 = 2;
        r4 = new byte[r3];
        r4 = {0, 0};
        r3 = r1.O000OO0o;	 Catch:{ Throwable -> 0x06c3 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x06c3 }
        if (r3 != 0) goto L_0x06a8;
    L_0x069e:
        r4 = r1.O000OO0o;	 Catch:{ Throwable -> 0x06c3 }
        r4 = r4.length();	 Catch:{ Throwable -> 0x06c3 }
        r4 = com.loc.OO000OO.O000000o(r4, r2);	 Catch:{ Throwable -> 0x06c3 }
    L_0x06a8:
        r5 = 0;
        r6 = 2;
        java.lang.System.arraycopy(r4, r5, r8, r12, r6);	 Catch:{ Throwable -> 0x06c1 }
        r12 = r12 + r6;
        if (r3 != 0) goto L_0x06bf;
    L_0x06b0:
        r3 = r1.O000OO0o;	 Catch:{ Throwable -> 0x06bf }
        r4 = "GBK";
        r3 = r3.getBytes(r4);	 Catch:{ Throwable -> 0x06bf }
        r4 = r3.length;	 Catch:{ Throwable -> 0x06bf }
        r5 = 0;
        java.lang.System.arraycopy(r3, r5, r8, r12, r4);	 Catch:{ Throwable -> 0x06bf }
        r3 = r3.length;	 Catch:{ Throwable -> 0x06bf }
        r12 = r12 + r3;
    L_0x06bf:
        r3 = 2;
        goto L_0x06c5;
    L_0x06c1:
        r3 = r6;
        goto L_0x06c4;
    L_0x06c3:
        r3 = 2;
    L_0x06c4:
        r12 = r12 + r3;
    L_0x06c5:
        r4 = new byte[r3];
        r4 = {0, 0};
        r4 = 0;
        r2 = com.loc.OO000OO.O000000o(r4, r2);	 Catch:{ Throwable -> 0x06d2 }
        java.lang.System.arraycopy(r2, r4, r8, r12, r3);	 Catch:{ Throwable -> 0x06d2 }
    L_0x06d2:
        r12 = r12 + r3;
        r2 = new byte[r3];
        r2 = {0, 0};
        java.lang.System.arraycopy(r2, r4, r8, r12, r3);	 Catch:{ Throwable -> 0x06db }
    L_0x06db:
        r12 = r12 + r3;
        r2 = r1.O000O0oo;
        if (r2 == 0) goto L_0x06e5;
    L_0x06e0:
        r2 = r1.O000O0oo;
        r4 = r2.length;
        r2 = 0;
        goto L_0x06e7;
    L_0x06e5:
        r2 = 0;
        r4 = 0;
    L_0x06e7:
        r2 = com.loc.OO000OO.O000000o(r4, r2);
        r3 = r2.length;
        r5 = 0;
        java.lang.System.arraycopy(r2, r5, r8, r12, r3);
        r2 = r2.length;
        r12 = r12 + r2;
        if (r4 <= 0) goto L_0x0700;
    L_0x06f4:
        r2 = r1.O000O0oo;
        r3 = r1.O000O0oo;
        r3 = r3.length;
        java.lang.System.arraycopy(r2, r5, r8, r12, r3);
        r2 = r1.O000O0oo;
        r2 = r2.length;
        r12 = r12 + r2;
    L_0x0700:
        r2 = "5.1";
        r2 = java.lang.Double.valueOf(r2);
        r2 = r2.doubleValue();
        r4 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1));
        if (r4 < 0) goto L_0x0718;
    L_0x070e:
        r8[r12] = r5;
        r12 = r12 + 1;
        r2 = r1.O000OOo0;
        r12 = O000000o(r2, r8, r12);
    L_0x0718:
        r2 = new byte[r12];
        java.lang.System.arraycopy(r8, r5, r2, r5, r12);
        r3 = new java.util.zip.CRC32;
        r3.<init>();
        r3.update(r2);
        r3 = r3.getValue();
        r3 = com.loc.OO000OO.O000000o(r3);
        r4 = r3.length;
        r4 = r4 + r12;
        r4 = new byte[r4];
        java.lang.System.arraycopy(r2, r5, r4, r5, r12);
        r2 = r3.length;
        java.lang.System.arraycopy(r3, r5, r4, r12, r2);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OooOO.O000000o():byte[]");
    }
}
