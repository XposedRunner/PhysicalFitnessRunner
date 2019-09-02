package defpackage;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.socialize.utils.O0000O0o;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonNetImpl */
/* renamed from: cu */
public class cu implements UMLogDataProtocol {
    public static final String O000000o = "s_sdk_v";
    public static final String O00000Oo = "s_pcv";
    public static final String O00000o = "header";
    public static final String O00000o0 = "share";
    public static final String O00000oO = "content";
    public static final String O00000oo = "umid";
    public static final String O0000O0o = "imei";
    public static final String O0000OOo = "auth";
    public static final String O0000Oo = "s_e";
    public static final String O0000Oo0 = "dau";
    public static final String O0000OoO = "userinfo";
    public static final String O0000Ooo = "stats";
    public static final String O0000o = "am";
    public static final String O0000o0 = "s_t";
    public static final String O0000o00 = "ts";
    public static final String O0000o0O = "pf";
    public static final String O0000o0o = "sdkt";
    public static final String O0000oO = "unionid";
    public static final String O0000oO0 = "uid";
    public static final String O0000oOO = "aid";
    public static final String O0000oOo = "as";
    public static final String O0000oo = "sm";
    public static final String O0000oo0 = "at";
    public static final String O0000ooO = "pic";
    public static final String O0000ooo = "picurl";
    public static final String O000O00o = "stype";
    public static final String O000O0OO = "url";
    public static final String O000O0Oo = "m_p";
    public static final String O000O0o = "un";
    public static final String O000O0o0 = "durl";
    public static final String O000O0oO = "up";
    public static final String O000O0oo = "sex";
    public static final String O000OO = "s_dau";
    public static final String O000OO00 = "regn";
    public static final String O000OO0o = "name";
    public static final String O000OOOo = "a_b";
    public static final String O000OOo = "position";
    public static final String O000OOo0 = "s_i";
    public static final String O000OOoO = "menubg";
    public static final String O000OOoo = "s_s_s";
    public static final String O000Oo0 = "tag";
    public static final String O000Oo00 = "u_c";
    public static final String O000Oo0O = "result";
    public static final String O000Oo0o = "s_s_e";
    public static final String O000OoO = "success";
    public static final String O000OoO0 = "fail";
    public static final String O000OoOO = "e_m";
    public static final String O000OoOo = "s_a_s";
    public static final String O000Ooo = "s_i_s";
    public static final String O000Ooo0 = "s_a_e";
    public static final String O000OooO = "s_i_e";
    public static final int O000Oooo = 268435456;
    private static boolean O000o = false;
    public static final int O000o0 = 5242880;
    public static final int O000o00 = 16777216;
    public static final int O000o000 = 536870912;
    public static final int O000o00O = 33554432;
    public static final int O000o00o = 65536;
    public static final String O000o0O = "stats";
    public static final int O000o0O0 = 524288;
    private static cu O000oO00 = null;
    public static final String O00O0Oo = "cancel";
    public static final String O00oOoOo = "m_u";
    public static final String O00oOooO = "title";
    public static final String O00oOooo = "ct";
    private ArrayList<Integer> O000o0OO = new ArrayList();
    private ArrayList<Integer> O000o0Oo = new ArrayList();
    private ArrayList<Integer> O000o0o = new ArrayList();
    private ArrayList<Integer> O000o0o0 = new ArrayList();
    private ArrayList<Integer> O000o0oo = new ArrayList();
    private Context O000oO0;

    private cu(Context context) {
        this.O000oO0 = context;
    }

    public static cu O000000o(Context context) {
        if (O000oO00 == null) {
            O000oO00 = new cu(context);
        }
        return O000oO00;
    }

    private JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", cu.O00000Oo());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("share", new JSONObject());
            jSONObject.put("content", jSONObject2);
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
        return jSONObject;
    }

    private void O000000o(JSONObject jSONObject, int i) {
        if (jSONObject != null) {
            switch (i) {
                case ce.O00oOooo /*24577*/:
                    cy.O000000o(this.O000oO0).O00000o(jSONObject);
                    break;
                case ce.O000O00o /*24578*/:
                    cy.O000000o(this.O000oO0).O000000o(jSONObject);
                    break;
                case ce.O000O0OO /*24579*/:
                    cy.O000000o(this.O000oO0).O00000Oo(jSONObject);
                    break;
                case ce.O000O0Oo /*24580*/:
                    cy.O000000o(this.O000oO0).O00000o0(jSONObject);
                    break;
                case ce.O00oOoOo /*24581*/:
                case ce.O000O0o /*24583*/:
                    cy.O000000o(this.O000oO0).O00000oO(jSONObject);
                    break;
                default:
                    cy.O000000o(this.O000oO0).O00000oO(jSONObject);
                    break;
            }
        }
    }

    private static JSONObject O00000Oo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "6.9.4");
        jSONObject.put(O00000Oo, ce.O0000Oo0);
        return jSONObject;
    }

    public void removeCacheData(Object obj) {
        if (this.O000o0OO.size() > 0) {
            cy.O000000o(this.O000oO0).O000000o(this.O000o0OO, "s_e");
            this.O000o0OO.clear();
        }
        if (this.O000o0Oo.size() > 0) {
            cy.O000000o(this.O000oO0).O000000o(this.O000o0Oo, "auth");
            this.O000o0Oo.clear();
        }
        if (this.O000o0o.size() > 0) {
            cy.O000000o(this.O000oO0).O000000o(this.O000o0o, "dau");
            this.O000o0o.clear();
        }
        if (this.O000o0o0.size() > 0) {
            cy.O000000o(this.O000oO0).O000000o(this.O000o0o0, "userinfo");
            this.O000o0o0.clear();
        }
        if (this.O000o0oo.size() > 0) {
            O000o = false;
            cy.O000000o(this.O000oO0).O000000o(this.O000o0oo, "stats");
            this.O000o0oo.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0147  */
    public org.json.JSONObject setupReportData(long r21) {
        /*
        r20 = this;
        r1 = r20;
        r2 = r21;
        r4 = (double) r2;
        r6 = com.umeng.socialize.net.dplus.cache.O0000O0o.O00000Oo();
        r8 = 4672484613396889600; // 0x40d8000000000000 float:0.0 double:24576.0;
        r6 = r6 + r8;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 <= 0) goto L_0x0012;
    L_0x0010:
        r6 = 0;
        goto L_0x0013;
    L_0x0012:
        r6 = 1;
    L_0x0013:
        r13 = new org.json.JSONObject;
        r13.<init>();
        r7 = "header";
        r8 = defpackage.cu.O00000Oo();	 Catch:{ JSONException -> 0x013e }
        r13.put(r7, r8);	 Catch:{ JSONException -> 0x013e }
        r15 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x013e }
        r15.<init>();	 Catch:{ JSONException -> 0x013e }
        r12 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x013e }
        r12.<init>();	 Catch:{ JSONException -> 0x013e }
        r16 = 4652218415073722368; // 0x4090000000000000 float:0.0 double:1024.0;
        r7 = r1.O000oO0;	 Catch:{ JSONException -> 0x013e }
        r7 = defpackage.cy.O000000o(r7);	 Catch:{ JSONException -> 0x013e }
        r8 = "s_e";
        r9 = r1.O000o0OO;	 Catch:{ JSONException -> 0x013e }
        r10 = r4 - r16;
        r14 = r12;
        r12 = r6;
        r12 = r7.O000000o(r8, r9, r10, r12);	 Catch:{ JSONException -> 0x013e }
        r7 = r12.toString();	 Catch:{ JSONException -> 0x013e }
        r7 = r7.getBytes();	 Catch:{ JSONException -> 0x013e }
        r7 = r7.length;	 Catch:{ JSONException -> 0x013e }
        r7 = (double) r7;	 Catch:{ JSONException -> 0x013e }
        r16 = r16 + r7;
        r7 = r1.O000oO0;	 Catch:{ JSONException -> 0x013e }
        r7 = defpackage.cy.O000000o(r7);	 Catch:{ JSONException -> 0x013e }
        r8 = "auth";
        r9 = r1.O000o0Oo;	 Catch:{ JSONException -> 0x013e }
        r10 = r4 - r16;
        r2 = r12;
        r12 = r6;
        r3 = r7.O000000o(r8, r9, r10, r12);	 Catch:{ JSONException -> 0x013e }
        r7 = r3.toString();	 Catch:{ JSONException -> 0x013e }
        r7 = r7.getBytes();	 Catch:{ JSONException -> 0x013e }
        r7 = r7.length;	 Catch:{ JSONException -> 0x013e }
        r7 = (double) r7;	 Catch:{ JSONException -> 0x013e }
        r16 = r16 + r7;
        r7 = r1.O000oO0;	 Catch:{ JSONException -> 0x013e }
        r7 = defpackage.cy.O000000o(r7);	 Catch:{ JSONException -> 0x013e }
        r8 = "userinfo";
        r9 = r1.O000o0o0;	 Catch:{ JSONException -> 0x013e }
        r10 = r4 - r16;
        r12 = r6;
        r12 = r7.O000000o(r8, r9, r10, r12);	 Catch:{ JSONException -> 0x013e }
        r7 = r12.toString();	 Catch:{ JSONException -> 0x013e }
        r7 = r7.getBytes();	 Catch:{ JSONException -> 0x013e }
        r7 = r7.length;	 Catch:{ JSONException -> 0x013e }
        r7 = (double) r7;	 Catch:{ JSONException -> 0x013e }
        r16 = r16 + r7;
        r7 = r1.O000oO0;	 Catch:{ JSONException -> 0x013e }
        r7 = defpackage.cy.O000000o(r7);	 Catch:{ JSONException -> 0x013e }
        r8 = "dau";
        r9 = r1.O000o0o;	 Catch:{ JSONException -> 0x013e }
        r10 = r4 - r16;
        r18 = r13;
        r13 = r12;
        r12 = r6;
        r12 = r7.O000000o(r8, r9, r10, r12);	 Catch:{ JSONException -> 0x013a }
        r7 = r12.toString();	 Catch:{ JSONException -> 0x013a }
        r7 = r7.getBytes();	 Catch:{ JSONException -> 0x013a }
        r7 = r7.length;	 Catch:{ JSONException -> 0x013a }
        r7 = (double) r7;	 Catch:{ JSONException -> 0x013a }
        r16 = r16 + r7;
        r7 = com.umeng.socialize.net.dplus.cache.O0000O0o.O00000Oo();	 Catch:{ JSONException -> 0x013a }
        r9 = r12.length();	 Catch:{ JSONException -> 0x013a }
        if (r9 == 0) goto L_0x00bc;
    L_0x00b0:
        r9 = "dau";
        r14.put(r9, r12);	 Catch:{ JSONException -> 0x00b6 }
        goto L_0x00bc;
    L_0x00b6:
        r0 = move-exception;
        r2 = r0;
        r6 = r18;
        goto L_0x0141;
    L_0x00bc:
        r9 = r2.length();	 Catch:{ JSONException -> 0x013a }
        if (r9 == 0) goto L_0x00c7;
    L_0x00c2:
        r9 = "s_e";
        r14.put(r9, r2);	 Catch:{ JSONException -> 0x00b6 }
    L_0x00c7:
        r9 = r3.length();	 Catch:{ JSONException -> 0x013a }
        if (r9 == 0) goto L_0x00d2;
    L_0x00cd:
        r9 = "auth";
        r14.put(r9, r3);	 Catch:{ JSONException -> 0x00b6 }
    L_0x00d2:
        r9 = r13.length();	 Catch:{ JSONException -> 0x013a }
        if (r9 == 0) goto L_0x00dd;
    L_0x00d8:
        r9 = "userinfo";
        r14.put(r9, r13);	 Catch:{ JSONException -> 0x00b6 }
    L_0x00dd:
        r9 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x013a }
        r9.<init>();	 Catch:{ JSONException -> 0x013a }
        r10 = 4692750811720056832; // 0x4120000000000000 float:0.0 double:524288.0;
        r19 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r19 >= 0) goto L_0x00ef;
    L_0x00e8:
        r7 = O000o;	 Catch:{ JSONException -> 0x00b6 }
        if (r7 == 0) goto L_0x00ed;
    L_0x00ec:
        goto L_0x00ef;
    L_0x00ed:
        r4 = r12;
        goto L_0x010c;
    L_0x00ef:
        r7 = r1.O000oO0;	 Catch:{ JSONException -> 0x013a }
        r7 = defpackage.cy.O000000o(r7);	 Catch:{ JSONException -> 0x013a }
        r8 = "stats";
        r9 = r1.O000o0oo;	 Catch:{ JSONException -> 0x013a }
        r10 = r4 - r16;
        r4 = r12;
        r12 = r6;
        r9 = r7.O000000o(r8, r9, r10, r12);	 Catch:{ JSONException -> 0x013a }
        r5 = r9.length();	 Catch:{ JSONException -> 0x013a }
        if (r5 == 0) goto L_0x010c;
    L_0x0107:
        r5 = "stats";
        r14.put(r5, r9);	 Catch:{ JSONException -> 0x00b6 }
    L_0x010c:
        r5 = "share";
        r15.put(r5, r14);	 Catch:{ JSONException -> 0x013a }
        r5 = "content";
        r6 = r18;
        r6.put(r5, r15);	 Catch:{ JSONException -> 0x0138 }
        r2 = r2.length();	 Catch:{ JSONException -> 0x0138 }
        if (r2 != 0) goto L_0x0144;
    L_0x011e:
        r2 = r3.length();	 Catch:{ JSONException -> 0x0138 }
        if (r2 != 0) goto L_0x0144;
    L_0x0124:
        r2 = r13.length();	 Catch:{ JSONException -> 0x0138 }
        if (r2 != 0) goto L_0x0144;
    L_0x012a:
        r2 = r4.length();	 Catch:{ JSONException -> 0x0138 }
        if (r2 != 0) goto L_0x0144;
    L_0x0130:
        r2 = r9.length();	 Catch:{ JSONException -> 0x0138 }
        if (r2 != 0) goto L_0x0144;
    L_0x0136:
        r13 = 0;
        goto L_0x0145;
    L_0x0138:
        r0 = move-exception;
        goto L_0x0140;
    L_0x013a:
        r0 = move-exception;
        r6 = r18;
        goto L_0x0140;
    L_0x013e:
        r0 = move-exception;
        r6 = r13;
    L_0x0140:
        r2 = r0;
    L_0x0141:
        com.umeng.socialize.utils.O0000O0o.O000000o(r2);
    L_0x0144:
        r13 = r6;
    L_0x0145:
        if (r13 == 0) goto L_0x0159;
    L_0x0147:
        r2 = r13.toString();
        r2 = r2.getBytes();
        r2 = r2.length;
        r2 = (long) r2;
        r4 = r21;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x0159;
    L_0x0157:
        r2 = 0;
        return r2;
    L_0x0159:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cu.setupReportData(long):org.json.JSONObject");
    }

    public void workEvent(Object obj, int i) {
        if (i == ce.O000O0oO) {
            JSONObject O000000o = O000000o();
            if (O000000o != null) {
                JSONObject optJSONObject = O000000o.optJSONObject("header");
                O000000o = O000000o.optJSONObject("content");
                if (optJSONObject != null && O000000o != null) {
                    UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.O000oO0, optJSONObject, O000000o);
                }
            }
        }
    }
}
