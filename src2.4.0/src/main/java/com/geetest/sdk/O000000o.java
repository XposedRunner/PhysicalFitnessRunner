package com.geetest.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.os.EnvironmentCompat;
import java.util.UUID;

/* compiled from: GeetestUtilsHolder */
public class O000000o {
    private static final String O000000o = "O000000o";
    private Context O00000Oo;
    private O00000o0 O00000o;
    private GT3ConfigBean O00000o0;
    private String O00000oO = "api.geetest.com";

    /* compiled from: GeetestUtilsHolder */
    public interface O000000o {
        void O000000o();

        void O000000o(String str, String str2);

        void O00000Oo();

        void O00000o();

        void O00000o0();

        void O00000oO();

        void O00000oo();

        void O0000O0o();

        void O0000OOo();

        void O0000Oo0();
    }

    public O000000o(Context context) {
        this.O00000Oo = context;
        this.O00000o = new O00000o0(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata", 0);
        if (EnvironmentCompat.MEDIA_UNKNOWN.equals(sharedPreferences.getString("uuid", EnvironmentCompat.MEDIA_UNKNOWN))) {
            sharedPreferences.edit().putString("uuid", UUID.randomUUID().toString()).apply();
        }
        new O00O0Oo("httpdns-for-test").O000000o("api.geetest.com", new O00000Oo(this));
    }

    private static boolean O000000o(String... strArr) {
        if (strArr == null) {
            return false;
        }
        for (Object contains : strArr) {
            if (O0Oo000.O000000o.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static String O00000oo() {
        return "4.0.7";
    }

    public final O00000o0 O000000o() {
        return this.O00000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Missing block: B:73:0x0175, code skipped:
            if (r3.equals("ar") != false) goto L_0x0179;
     */
    public final void O000000o(com.geetest.sdk.GT3ConfigBean r10) {
        /*
        r9 = this;
        r0 = "Geetest";
        r1 = "GT3Version-->4.0.7";
        android.util.Log.d(r0, r1);
        r9.O00000o0 = r10;
        r0 = r9.O00000o0;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0016;
    L_0x000f:
        r0 = "GT3ConfigBean cannot be null !";
        com.geetest.sdk.O0OOO00.O000000o(r0);
    L_0x0014:
        r0 = r1;
        goto L_0x003b;
    L_0x0016:
        r0 = r9.O00000o0;
        r0 = r0.getListener();
        if (r0 != 0) goto L_0x0024;
    L_0x001e:
        r0 = "Listener cannot be null !";
        com.geetest.sdk.O0OOO00.O000000o(r0);
        goto L_0x0014;
    L_0x0024:
        r0 = r9.O00000Oo;
        if (r0 != 0) goto L_0x002e;
    L_0x0028:
        r0 = "Context cannot be null !";
        com.geetest.sdk.O0OOO00.O000000o(r0);
        goto L_0x0014;
    L_0x002e:
        r0 = r9.O00000Oo;
        r0 = r0 instanceof android.app.Activity;
        if (r0 != 0) goto L_0x003a;
    L_0x0034:
        r0 = "Context must be activity type !";
        com.geetest.sdk.O0OOO00.O000000o(r0);
        goto L_0x0014;
    L_0x003a:
        r0 = r2;
    L_0x003b:
        if (r0 != 0) goto L_0x0045;
    L_0x003d:
        r10 = new java.lang.RuntimeException;
        r0 = "Illegal parameter !";
        r10.<init>(r0);
        throw r10;
    L_0x0045:
        r0 = r9.O00000oO;
        r10.setApiServerHost(r0);
        r0 = java.util.Locale.getDefault();
        r3 = r10.getLang();
        r3 = android.text.TextUtils.isEmpty(r3);
        r4 = 2;
        if (r3 == 0) goto L_0x00d7;
    L_0x0059:
        r1 = "in";
        r3 = r0.getLanguage();
        r1 = android.text.TextUtils.equals(r1, r3);
        if (r1 == 0) goto L_0x0093;
    L_0x0065:
        r1 = new java.lang.StringBuilder;
        r3 = "id";
        r1.<init>(r3);
        r3 = r0.getCountry();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0079;
    L_0x0076:
        r0 = "";
        goto L_0x008b;
    L_0x0079:
        r3 = new java.lang.StringBuilder;
        r5 = "-";
        r3.<init>(r5);
        r0 = r0.getCountry();
        r3.append(r0);
        r0 = r3.toString();
    L_0x008b:
        r1.append(r0);
        r0 = r1.toString();
        goto L_0x00d2;
    L_0x0093:
        r1 = r0.getLanguage();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x00a0;
    L_0x009d:
        r0 = "zh";
        goto L_0x00d2;
    L_0x00a0:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r0.getLanguage();
        r1.append(r3);
        r3 = r0.getCountry();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x00b9;
    L_0x00b6:
        r0 = "";
        goto L_0x00cb;
    L_0x00b9:
        r3 = new java.lang.StringBuilder;
        r5 = "-";
        r3.<init>(r5);
        r0 = r0.getCountry();
        r3.append(r0);
        r0 = r3.toString();
    L_0x00cb:
        r1.append(r0);
        r0 = r1.toString();
    L_0x00d2:
        r10.setLang(r0);
        goto L_0x0229;
    L_0x00d7:
        r0 = r10.getLang();
        r0 = r0.toLowerCase();
        r3 = "-";
        r3 = r0.split(r3);
        r3 = O000000o(r3);
        if (r3 == 0) goto L_0x0229;
    L_0x00eb:
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x00f5;
    L_0x00f1:
        r0 = java.util.Locale.ENGLISH;
        goto L_0x01f7;
    L_0x00f5:
        r3 = "-";
        r0 = r0.split(r3);
        r3 = r0[r1];
        r5 = -1;
        r6 = r3.hashCode();
        switch(r6) {
            case 3121: goto L_0x016f;
            case 3201: goto L_0x0165;
            case 3241: goto L_0x015b;
            case 3246: goto L_0x0151;
            case 3276: goto L_0x0147;
            case 3355: goto L_0x013d;
            case 3398: goto L_0x0133;
            case 3428: goto L_0x0129;
            case 3588: goto L_0x011e;
            case 3651: goto L_0x0113;
            case 3886: goto L_0x0107;
            default: goto L_0x0105;
        };
    L_0x0105:
        goto L_0x0178;
    L_0x0107:
        r1 = "zh";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x010f:
        r1 = 10;
        goto L_0x0179;
    L_0x0113:
        r1 = "ru";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x011b:
        r1 = 9;
        goto L_0x0179;
    L_0x011e:
        r1 = "pt";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x0126:
        r1 = 8;
        goto L_0x0179;
    L_0x0129:
        r1 = "ko";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x0131:
        r1 = 7;
        goto L_0x0179;
    L_0x0133:
        r1 = "jp";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x013b:
        r1 = 6;
        goto L_0x0179;
    L_0x013d:
        r1 = "id";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x0145:
        r1 = 5;
        goto L_0x0179;
    L_0x0147:
        r1 = "fr";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x014f:
        r1 = 4;
        goto L_0x0179;
    L_0x0151:
        r1 = "es";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x0159:
        r1 = 3;
        goto L_0x0179;
    L_0x015b:
        r1 = "en";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x0163:
        r1 = r4;
        goto L_0x0179;
    L_0x0165:
        r1 = "de";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0178;
    L_0x016d:
        r1 = r2;
        goto L_0x0179;
    L_0x016f:
        r6 = "ar";
        r3 = r3.equals(r6);
        if (r3 == 0) goto L_0x0178;
    L_0x0177:
        goto L_0x0179;
    L_0x0178:
        r1 = r5;
    L_0x0179:
        switch(r1) {
            case 0: goto L_0x01f0;
            case 1: goto L_0x01ed;
            case 2: goto L_0x01ea;
            case 3: goto L_0x01e2;
            case 4: goto L_0x01df;
            case 5: goto L_0x01d7;
            case 6: goto L_0x01d4;
            case 7: goto L_0x01d1;
            case 8: goto L_0x01c7;
            case 9: goto L_0x01bf;
            case 10: goto L_0x0180;
            default: goto L_0x017c;
        };
    L_0x017c:
        r0 = java.util.Locale.ENGLISH;
        goto L_0x01f7;
    L_0x0180:
        r1 = r0.length;
        if (r1 <= r2) goto L_0x01bc;
    L_0x0183:
        r1 = r0[r2];
        r3 = "tw";
        r1 = android.text.TextUtils.equals(r1, r3);
        if (r1 == 0) goto L_0x0191;
    L_0x018d:
        r0 = java.util.Locale.TRADITIONAL_CHINESE;
        goto L_0x01f7;
    L_0x0191:
        r1 = r0[r2];
        r3 = "hk";
        r1 = android.text.TextUtils.equals(r1, r3);
        if (r1 == 0) goto L_0x01a5;
    L_0x019b:
        r0 = new java.util.Locale;
        r1 = "zh";
        r3 = "HK";
        r0.<init>(r1, r3);
        goto L_0x01f7;
    L_0x01a5:
        r0 = r0[r2];
        r1 = "mo";
        r0 = android.text.TextUtils.equals(r0, r1);
        if (r0 == 0) goto L_0x01b9;
    L_0x01af:
        r0 = new java.util.Locale;
        r1 = "zh";
        r3 = "MO";
        r0.<init>(r1, r3);
        goto L_0x01f7;
    L_0x01b9:
        r0 = java.util.Locale.SIMPLIFIED_CHINESE;
        goto L_0x01f7;
    L_0x01bc:
        r0 = java.util.Locale.SIMPLIFIED_CHINESE;
        goto L_0x01f7;
    L_0x01bf:
        r0 = new java.util.Locale;
        r1 = "ru";
        r0.<init>(r1);
        goto L_0x01f7;
    L_0x01c7:
        r0 = new java.util.Locale;
        r1 = "pt";
        r3 = "PT";
        r0.<init>(r1, r3);
        goto L_0x01f7;
    L_0x01d1:
        r0 = java.util.Locale.KOREAN;
        goto L_0x01f7;
    L_0x01d4:
        r0 = java.util.Locale.JAPANESE;
        goto L_0x01f7;
    L_0x01d7:
        r0 = new java.util.Locale;
        r1 = "in";
        r0.<init>(r1);
        goto L_0x01f7;
    L_0x01df:
        r0 = java.util.Locale.FRENCH;
        goto L_0x01f7;
    L_0x01e2:
        r0 = new java.util.Locale;
        r1 = "es";
        r0.<init>(r1);
        goto L_0x01f7;
    L_0x01ea:
        r0 = java.util.Locale.ENGLISH;
        goto L_0x01f7;
    L_0x01ed:
        r0 = java.util.Locale.GERMAN;
        goto L_0x01f7;
    L_0x01f0:
        r0 = new java.util.Locale;
        r1 = "ar";
        r0.<init>(r1);
    L_0x01f7:
        r1 = r9.O00000Oo;
        r1 = r1.getResources();
        r3 = r1.getDisplayMetrics();
        r5 = r1.getConfiguration();
        r6 = r5.locale;
        r7 = android.os.Build.VERSION.SDK_INT;
        r8 = 17;
        if (r7 < r8) goto L_0x0211;
    L_0x020d:
        r5.setLocale(r0);
        goto L_0x0213;
    L_0x0211:
        r5.locale = r0;
    L_0x0213:
        r1.updateConfiguration(r5, r3);
        r0 = r9.O00000Oo;
        com.geetest.sdk.O00O0o.O000000o(r0);
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r8) goto L_0x0223;
    L_0x021f:
        r5.setLocale(r6);
        goto L_0x0225;
    L_0x0223:
        r5.locale = r6;
    L_0x0225:
        r1.updateConfiguration(r5, r3);
        goto L_0x022e;
    L_0x0229:
        r0 = r9.O00000Oo;
        com.geetest.sdk.O00O0o.O000000o(r0);
    L_0x022e:
        r0 = r9.O00000o;
        r0.O000000o(r10);
        r10 = r9.O00000o;
        r0 = r9.O00000o0;
        r0 = r0.getPattern();
        if (r0 != r4) goto L_0x023e;
    L_0x023d:
        r2 = r4;
    L_0x023e:
        r10.O000000o(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O000000o.O000000o(com.geetest.sdk.GT3ConfigBean):void");
    }

    public final void O00000Oo() {
        this.O00000o.O000000o();
    }

    public final void O00000o() {
        this.O00000o.O00000o0();
    }

    public final void O00000o0() {
        this.O00000o.O00000Oo();
    }

    public final void O00000oO() {
        this.O00000o.O00000o();
    }

    public final void O0000O0o() {
        this.O00000o.O00000oO();
    }

    public final void O0000OOo() {
        this.O00000o.O00000oo();
    }

    public final void O0000Oo0() {
        this.O00000o.O0000O0o();
    }
}
