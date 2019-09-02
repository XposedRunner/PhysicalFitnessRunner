package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Hashtable;

/* compiled from: Cache */
public final class O0OOO0O {
    Hashtable<String, ArrayList<O000000o>> O000000o = new Hashtable();
    boolean O00000Oo = true;
    String O00000o = null;
    long O00000o0 = 0;
    O0OO0O O00000oO = null;
    boolean O00000oo = true;
    boolean O0000O0o = true;
    String O0000OOo = String.valueOf(GeoLanguage.DEFAULT);
    private boolean O0000Oo = false;
    private long O0000Oo0 = 0;
    private String O0000OoO = "2.0.201501131131".replace(".", "");
    private String O0000Ooo = null;
    private long O0000o0 = 0;
    private String O0000o00 = null;

    /* compiled from: Cache */
    static class O000000o {
        private AMapLocationServer O000000o = null;
        private String O00000Oo = null;

        protected O000000o() {
        }

        public final AMapLocationServer O000000o() {
            return this.O000000o;
        }

        public final void O000000o(AMapLocationServer aMapLocationServer) {
            this.O000000o = aMapLocationServer;
        }

        public final void O000000o(String str) {
            this.O00000Oo = TextUtils.isEmpty(str) ? null : str.replace("##", "#");
        }

        public final String O00000Oo() {
            return this.O00000Oo;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006d A:{Catch:{ Throwable -> 0x0085 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e A:{Catch:{ Throwable -> 0x0085 }} */
    private com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(java.lang.String r5, java.lang.StringBuilder r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = "cgiwifi";
        r1 = r5.contains(r1);	 Catch:{ Throwable -> 0x0085 }
        if (r1 == 0) goto L_0x000e;
    L_0x0009:
        r6 = r4.O000000o(r6, r5);	 Catch:{ Throwable -> 0x0085 }
        goto L_0x0038;
    L_0x000e:
        r1 = "wifi";
        r1 = r5.contains(r1);	 Catch:{ Throwable -> 0x0085 }
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0009;
    L_0x0017:
        r6 = "cgi";
        r6 = r5.contains(r6);	 Catch:{ Throwable -> 0x0085 }
        if (r6 == 0) goto L_0x0037;
    L_0x001f:
        r6 = r4.O000000o;	 Catch:{ Throwable -> 0x0085 }
        r6 = r6.containsKey(r5);	 Catch:{ Throwable -> 0x0085 }
        if (r6 == 0) goto L_0x0037;
    L_0x0027:
        r6 = r4.O000000o;	 Catch:{ Throwable -> 0x0085 }
        r6 = r6.get(r5);	 Catch:{ Throwable -> 0x0085 }
        r6 = (java.util.ArrayList) r6;	 Catch:{ Throwable -> 0x0085 }
        r1 = 0;
        r6 = r6.get(r1);	 Catch:{ Throwable -> 0x0085 }
        r6 = (com.loc.O0OOO0O.O000000o) r6;	 Catch:{ Throwable -> 0x0085 }
        goto L_0x0038;
    L_0x0037:
        r6 = r0;
    L_0x0038:
        if (r6 == 0) goto L_0x008d;
    L_0x003a:
        r1 = r6.O000000o();	 Catch:{ Throwable -> 0x0085 }
        r1 = com.loc.OO000OO.O000000o(r1);	 Catch:{ Throwable -> 0x0085 }
        if (r1 == 0) goto L_0x008d;
    L_0x0044:
        r1 = r6.O000000o();	 Catch:{ Throwable -> 0x0085 }
        r2 = "mem";
        r1.e(r2);	 Catch:{ Throwable -> 0x0085 }
        r2 = r6.O00000Oo();	 Catch:{ Throwable -> 0x0085 }
        r1.h(r2);	 Catch:{ Throwable -> 0x0085 }
        r2 = r1.getTime();	 Catch:{ Throwable -> 0x0085 }
        r2 = com.loc.OoO0o.O00000Oo(r2);	 Catch:{ Throwable -> 0x0085 }
        if (r2 == 0) goto L_0x006d;
    L_0x005e:
        r5 = com.loc.OO000OO.O000000o(r1);	 Catch:{ Throwable -> 0x0085 }
        if (r5 == 0) goto L_0x0068;
    L_0x0064:
        r5 = 0;
        r4.O00000o0 = r5;	 Catch:{ Throwable -> 0x0085 }
    L_0x0068:
        r5 = 4;
        r1.setLocationType(r5);	 Catch:{ Throwable -> 0x0085 }
        return r1;
    L_0x006d:
        r1 = r4.O000000o;	 Catch:{ Throwable -> 0x0085 }
        if (r1 == 0) goto L_0x008d;
    L_0x0071:
        r1 = r4.O000000o;	 Catch:{ Throwable -> 0x0085 }
        r1 = r1.containsKey(r5);	 Catch:{ Throwable -> 0x0085 }
        if (r1 == 0) goto L_0x008d;
    L_0x0079:
        r1 = r4.O000000o;	 Catch:{ Throwable -> 0x0085 }
        r5 = r1.get(r5);	 Catch:{ Throwable -> 0x0085 }
        r5 = (java.util.ArrayList) r5;	 Catch:{ Throwable -> 0x0085 }
        r5.remove(r6);	 Catch:{ Throwable -> 0x0085 }
        return r0;
    L_0x0085:
        r5 = move-exception;
        r6 = "Cache";
        r1 = "get1";
        com.loc.O0o0000.O000000o(r5, r6, r1);
    L_0x008d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(java.lang.String, java.lang.StringBuilder):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed A:{LOOP_END, LOOP:1: B:34:0x00e7->B:36:0x00ed} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A:{LOOP_END, LOOP:2: B:38:0x0101->B:40:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0152 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0177 A:{SKIP} */
    private com.loc.O0OOO0O.O000000o O000000o(java.lang.StringBuilder r26, java.lang.String r27) {
        /*
        r25 = this;
        r0 = r25;
        r1 = r27;
        r2 = r0.O000000o;
        r2 = r2.isEmpty();
        r3 = 0;
        if (r2 != 0) goto L_0x0195;
    L_0x000d:
        r2 = android.text.TextUtils.isEmpty(r26);
        if (r2 == 0) goto L_0x0015;
    L_0x0013:
        goto L_0x0195;
    L_0x0015:
        r2 = r0.O000000o;
        r2 = r2.containsKey(r1);
        if (r2 != 0) goto L_0x001e;
    L_0x001d:
        return r3;
    L_0x001e:
        r2 = new java.util.Hashtable;
        r2.<init>();
        r4 = new java.util.Hashtable;
        r4.<init>();
        r5 = new java.util.Hashtable;
        r5.<init>();
        r6 = r0.O000000o;
        r1 = r6.get(r1);
        r1 = (java.util.ArrayList) r1;
        r6 = r1.size();
        r7 = 1;
        r6 = r6 - r7;
    L_0x003b:
        if (r6 < 0) goto L_0x0189;
    L_0x003d:
        r8 = r1.get(r6);
        r8 = (com.loc.O0OOO0O.O000000o) r8;
        r9 = r8.O00000Oo();
        r9 = android.text.TextUtils.isEmpty(r9);
        if (r9 != 0) goto L_0x0182;
    L_0x004d:
        r9 = r8.O00000Oo();
        r10 = android.text.TextUtils.isEmpty(r9);
        r11 = 0;
        if (r10 != 0) goto L_0x00b6;
    L_0x0058:
        r10 = android.text.TextUtils.isEmpty(r26);
        if (r10 == 0) goto L_0x005f;
    L_0x005e:
        goto L_0x00b6;
    L_0x005f:
        r10 = ",access";
        r10 = r9.contains(r10);
        if (r10 == 0) goto L_0x00b6;
    L_0x0067:
        r10 = ",access";
        r12 = r26;
        r10 = r12.indexOf(r10);
        r13 = -1;
        if (r10 != r13) goto L_0x0073;
    L_0x0072:
        goto L_0x00b8;
    L_0x0073:
        r10 = ",access";
        r9 = r9.split(r10);
        r10 = r9[r11];
        r13 = "#";
        r10 = r10.contains(r13);
        if (r10 == 0) goto L_0x0093;
    L_0x0083:
        r10 = r9[r11];
        r9 = r9[r11];
        r13 = "#";
        r9 = r9.lastIndexOf(r13);
        r9 = r9 + r7;
        r9 = r10.substring(r9);
        goto L_0x0095;
    L_0x0093:
        r9 = r9[r11];
    L_0x0095:
        r10 = android.text.TextUtils.isEmpty(r9);
        if (r10 == 0) goto L_0x009c;
    L_0x009b:
        goto L_0x00b8;
    L_0x009c:
        r10 = r26.toString();
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r13.append(r9);
        r9 = ",access";
        r13.append(r9);
        r9 = r13.toString();
        r9 = r10.contains(r9);
        goto L_0x00b9;
    L_0x00b6:
        r12 = r26;
    L_0x00b8:
        r9 = r11;
    L_0x00b9:
        if (r9 == 0) goto L_0x00cd;
    L_0x00bb:
        r9 = r8.O00000Oo();
        r10 = r26.toString();
        r9 = com.loc.OO000OO.O000000o(r9, r10);
        if (r9 == 0) goto L_0x00cb;
    L_0x00c9:
        goto L_0x017f;
    L_0x00cb:
        r9 = r7;
        goto L_0x00ce;
    L_0x00cd:
        r9 = r11;
    L_0x00ce:
        r10 = r8.O00000Oo();
        O000000o(r10, r2);
        r10 = r26.toString();
        O000000o(r10, r4);
        r5.clear();
        r10 = r2.keySet();
        r10 = r10.iterator();
    L_0x00e7:
        r13 = r10.hasNext();
        if (r13 == 0) goto L_0x00f9;
    L_0x00ed:
        r13 = r10.next();
        r13 = (java.lang.String) r13;
        r14 = "";
        r5.put(r13, r14);
        goto L_0x00e7;
    L_0x00f9:
        r10 = r4.keySet();
        r10 = r10.iterator();
    L_0x0101:
        r13 = r10.hasNext();
        if (r13 == 0) goto L_0x0113;
    L_0x0107:
        r13 = r10.next();
        r13 = (java.lang.String) r13;
        r14 = "";
        r5.put(r13, r14);
        goto L_0x0101;
    L_0x0113:
        r10 = r5.keySet();
        r13 = r10.size();
        r13 = new double[r13];
        r14 = r10.size();
        r14 = new double[r14];
        r15 = r10.iterator();
        r16 = r11;
    L_0x0129:
        if (r15 == 0) goto L_0x0158;
    L_0x012b:
        r17 = r15.hasNext();
        if (r17 == 0) goto L_0x0158;
    L_0x0131:
        r17 = r15.next();
        r3 = r17;
        r3 = (java.lang.String) r3;
        r17 = r2.containsKey(r3);
        r19 = 0;
        r21 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        if (r17 == 0) goto L_0x0146;
    L_0x0143:
        r23 = r21;
        goto L_0x0148;
    L_0x0146:
        r23 = r19;
    L_0x0148:
        r13[r16] = r23;
        r3 = r4.containsKey(r3);
        if (r3 == 0) goto L_0x0152;
    L_0x0150:
        r19 = r21;
    L_0x0152:
        r14[r16] = r19;
        r16 = r16 + 1;
        r3 = 0;
        goto L_0x0129;
    L_0x0158:
        r10.clear();
        r3 = O000000o(r13, r14);
        r13 = r3[r11];
        r15 = 4605380979056443392; // 0x3fe99999a0000000 float:-1.0842022E-19 double:0.800000011920929;
        r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));
        if (r10 < 0) goto L_0x016b;
    L_0x016a:
        goto L_0x017f;
    L_0x016b:
        r13 = r3[r7];
        r15 = 4603741668684706349; // 0x3fe3c6a7ef9db22d float:-9.76091E28 double:0.618;
        r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));
        if (r10 < 0) goto L_0x0177;
    L_0x0176:
        goto L_0x017f;
    L_0x0177:
        if (r9 == 0) goto L_0x0184;
    L_0x0179:
        r9 = r3[r11];
        r3 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1));
        if (r3 < 0) goto L_0x0184;
    L_0x017f:
        r18 = r8;
        goto L_0x018b;
    L_0x0182:
        r12 = r26;
    L_0x0184:
        r6 = r6 + -1;
        r3 = 0;
        goto L_0x003b;
    L_0x0189:
        r18 = 0;
    L_0x018b:
        r2.clear();
        r4.clear();
        r5.clear();
        return r18;
    L_0x0195:
        r1 = r3;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(java.lang.StringBuilder, java.lang.String):com.loc.O0OOO0O$O000000o");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private java.lang.String O000000o(java.lang.String r6, java.lang.StringBuilder r7, android.content.Context r8) {
        /*
        r5 = this;
        r0 = 0;
        if (r8 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = r5.O0000Ooo;	 Catch:{  }
        if (r2 != 0) goto L_0x0019;
    L_0x000d:
        r2 = "MD5";
        r8 = com.loc.OO00o00.O00000o0(r8);	 Catch:{  }
        r8 = com.loc.O0OOO0.O000000o(r2, r8);	 Catch:{  }
        r5.O0000Ooo = r8;	 Catch:{  }
    L_0x0019:
        r8 = "&";
        r8 = r6.contains(r8);	 Catch:{  }
        r2 = 0;
        if (r8 == 0) goto L_0x002c;
    L_0x0022:
        r8 = "&";
        r8 = r6.indexOf(r8);	 Catch:{  }
        r6 = r6.substring(r2, r8);	 Catch:{  }
    L_0x002c:
        r8 = "#";
        r8 = r6.lastIndexOf(r8);	 Catch:{  }
        r8 = r8 + 1;
        r8 = r6.substring(r8);	 Catch:{  }
        r3 = "cgi";
        r3 = r8.equals(r3);	 Catch:{  }
        if (r3 == 0) goto L_0x0050;
    L_0x0040:
        r7 = "cgi";
        r8 = r6.length();	 Catch:{  }
        r8 = r8 + -12;
        r6 = r6.substring(r2, r8);	 Catch:{  }
    L_0x004c:
        r1.put(r7, r6);	 Catch:{  }
        goto L_0x009e;
    L_0x0050:
        r3 = android.text.TextUtils.isEmpty(r7);	 Catch:{  }
        if (r3 != 0) goto L_0x009e;
    L_0x0056:
        r3 = ",access";
        r3 = r7.indexOf(r3);	 Catch:{  }
        r4 = -1;
        if (r3 == r4) goto L_0x009e;
    L_0x005f:
        r3 = 9;
        r8 = r8.length();	 Catch:{  }
        r3 = r3 + r8;
        r8 = r6.length();	 Catch:{  }
        r8 = r8 - r3;
        r6 = r6.substring(r2, r8);	 Catch:{  }
        r8 = "cgi";
        r1.put(r8, r6);	 Catch:{  }
        r6 = r7.toString();	 Catch:{  }
        r7 = ",access";
        r6 = r6.split(r7);	 Catch:{  }
        r7 = r6[r2];	 Catch:{  }
        r8 = "#";
        r7 = r7.contains(r8);	 Catch:{  }
        if (r7 == 0) goto L_0x0099;
    L_0x0088:
        r7 = r6[r2];	 Catch:{  }
        r6 = r6[r2];	 Catch:{  }
        r8 = "#";
        r6 = r6.lastIndexOf(r8);	 Catch:{  }
        r6 = r6 + 1;
        r6 = r7.substring(r6);	 Catch:{  }
        goto L_0x009b;
    L_0x0099:
        r6 = r6[r2];	 Catch:{  }
    L_0x009b:
        r7 = "mmac";
        goto L_0x004c;
    L_0x009e:
        r6 = r1.toString();	 Catch:{ Throwable -> 0x00b3 }
        r7 = "UTF-8";
        r6 = r6.getBytes(r7);	 Catch:{ Throwable -> 0x00b3 }
        r7 = r5.O0000Ooo;	 Catch:{ Throwable -> 0x00b3 }
        r6 = com.loc.O0OOO0.O00000o0(r6, r7);	 Catch:{ Throwable -> 0x00b3 }
        r6 = com.loc.oOo00.O00000Oo(r6);	 Catch:{  }
        return r6;
    L_0x00b3:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(java.lang.String, java.lang.StringBuilder, android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb A:{Catch:{ Throwable -> 0x0268, all -> 0x0266 }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027c  */
    private void O000000o(android.content.Context r11, java.lang.String r12) throws java.lang.Exception {
        /*
        r10 = this;
        r0 = com.loc.OoO0o.O0000oOo();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        if (r11 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = 0;
        r1 = "hmdb";
        r2 = 0;
        r1 = r11.openOrCreateDatabase(r1, r2, r0);	 Catch:{ Throwable -> 0x0271, all -> 0x026d }
        r3 = "hist";
        r3 = com.loc.OO000OO.O000000o(r1, r3);	 Catch:{ Throwable -> 0x026b }
        if (r3 != 0) goto L_0x0026;
    L_0x001a:
        if (r1 == 0) goto L_0x0025;
    L_0x001c:
        r11 = r1.isOpen();	 Catch:{ Throwable -> 0x026b }
        if (r11 == 0) goto L_0x0025;
    L_0x0022:
        r1.close();	 Catch:{ Throwable -> 0x026b }
    L_0x0025:
        return;
    L_0x0026:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x026b }
        r3.<init>();	 Catch:{ Throwable -> 0x026b }
        r4 = "SELECT feature, nb, loc FROM ";
        r3.append(r4);	 Catch:{ Throwable -> 0x026b }
        r4 = "hist";
        r3.append(r4);	 Catch:{ Throwable -> 0x026b }
        r4 = r10.O0000OoO;	 Catch:{ Throwable -> 0x026b }
        r3.append(r4);	 Catch:{ Throwable -> 0x026b }
        r4 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x026b }
        r6 = com.loc.OoO0o.O0000oOO();	 Catch:{ Throwable -> 0x026b }
        r8 = r4 - r6;
        r4 = " WHERE time > ";
        r3.append(r4);	 Catch:{ Throwable -> 0x026b }
        r3.append(r8);	 Catch:{ Throwable -> 0x026b }
        if (r12 == 0) goto L_0x0067;
    L_0x004e:
        r4 = " and feature = '";
        r3.append(r4);	 Catch:{ Throwable -> 0x026b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x026b }
        r4.<init>();	 Catch:{ Throwable -> 0x026b }
        r4.append(r12);	 Catch:{ Throwable -> 0x026b }
        r12 = "'";
        r4.append(r12);	 Catch:{ Throwable -> 0x026b }
        r12 = r4.toString();	 Catch:{ Throwable -> 0x026b }
        r3.append(r12);	 Catch:{ Throwable -> 0x026b }
    L_0x0067:
        r12 = " ORDER BY time ASC;";
        r3.append(r12);	 Catch:{ Throwable -> 0x026b }
        r12 = r3.toString();	 Catch:{ Throwable -> 0x026b }
        r12 = r1.rawQuery(r12, r0);	 Catch:{ Throwable -> 0x026b }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = r10.O0000Ooo;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 != 0) goto L_0x0089;
    L_0x007d:
        r4 = "MD5";
        r5 = com.loc.OO00o00.O00000o0(r11);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.O0OOO0.O000000o(r4, r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r10.O0000Ooo = r4;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x0089:
        if (r12 == 0) goto L_0x0255;
    L_0x008b:
        r4 = r12.moveToFirst();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 == 0) goto L_0x0255;
    L_0x0091:
        r4 = r12.getString(r2);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "{";
        r4 = r4.startsWith(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = 2;
        r6 = 1;
        if (r4 == 0) goto L_0x00f4;
    L_0x009f:
        r4 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7 = r12.getString(r2);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.<init>(r7);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7 = r0.length();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.delete(r2, r7);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7 = r12.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r7 != 0) goto L_0x00c1;
    L_0x00b9:
        r6 = r12.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x00bd:
        r0.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        goto L_0x00da;
    L_0x00c1:
        r6 = "mmac";
        r6 = com.loc.OO000OO.O000000o(r4, r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r6 == 0) goto L_0x00da;
    L_0x00c9:
        r6 = "#";
        r0.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "mmac";
        r6 = r4.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = ",access";
        goto L_0x00bd;
    L_0x00da:
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = r12.getString(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "type";
        r5 = com.loc.OO000OO.O000000o(r6, r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r5 == 0) goto L_0x017d;
    L_0x00eb:
        r5 = "type";
        r7 = "new";
        r6.put(r5, r7);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        goto L_0x017d;
    L_0x00f4:
        r4 = r12.getString(r2);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.oOo00.O00000Oo(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r8 = new java.lang.String;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r9 = r10.O0000Ooo;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.O0OOO0.O00000o(r4, r9);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r9 = "UTF-8";
        r8.<init>(r4, r9);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = r0.length();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.delete(r2, r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = r12.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 != 0) goto L_0x0138;
    L_0x011f:
        r4 = r12.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.oOo00.O00000Oo(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = new java.lang.String;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r8 = r10.O0000Ooo;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.O0OOO0.O00000o(r4, r8);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r8 = "UTF-8";
        r6.<init>(r4, r8);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        goto L_0x0153;
    L_0x0138:
        r4 = "mmac";
        r4 = com.loc.OO000OO.O000000o(r7, r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 == 0) goto L_0x0153;
    L_0x0140:
        r4 = "#";
        r0.append(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = "mmac";
        r4 = r7.getString(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = ",access";
        r0.append(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x0153:
        r4 = r12.getString(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.oOo00.O00000Oo(r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = new java.lang.String;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r8 = r10.O0000Ooo;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = com.loc.O0OOO0.O00000o(r4, r8);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r8 = "UTF-8";
        r5.<init>(r4, r8);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4 = "type";
        r4 = com.loc.OO000OO.O000000o(r6, r4);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 == 0) goto L_0x017c;
    L_0x0175:
        r4 = "type";
        r5 = "new";
        r6.put(r4, r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x017c:
        r4 = r7;
    L_0x017d:
        r7 = new com.autonavi.aps.amapapi.model.AMapLocationServer;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "";
        r7.<init>(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r7.b(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "mmac";
        r5 = com.loc.OO000OO.O000000o(r4, r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r5 == 0) goto L_0x01ee;
    L_0x018f:
        r5 = "cgi";
        r5 = com.loc.OO000OO.O000000o(r4, r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r5 == 0) goto L_0x01ee;
    L_0x0197:
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "cgi";
        r6 = r4.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "#";
        r5.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "network#";
        r6.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = r6.toString();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "cgi";
        r4 = r4.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "#";
        r4 = r4.contains(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 == 0) goto L_0x01e0;
    L_0x01cd:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "cgiwifi";
        r4.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x01da:
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = r4;
        goto L_0x023a;
    L_0x01e0:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "wifi";
        r4.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        goto L_0x01da;
    L_0x01ee:
        r5 = "cgi";
        r5 = com.loc.OO000OO.O000000o(r4, r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r5 == 0) goto L_0x0241;
    L_0x01f6:
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "cgi";
        r6 = r4.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "#";
        r5.append(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "network#";
        r6.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = r6.toString();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "cgi";
        r4 = r4.getString(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r6 = "#";
        r4 = r4.contains(r6);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 == 0) goto L_0x0241;
    L_0x022c:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.<init>();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r4.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r5 = "cgi";
        r4.append(r5);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        goto L_0x01da;
    L_0x023a:
        r9 = 0;
        r4 = r10;
        r6 = r0;
        r8 = r11;
        r4.O000000o(r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x0241:
        r4 = r12.moveToNext();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        if (r4 != 0) goto L_0x0091;
    L_0x0247:
        r11 = r0.length();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r0.delete(r2, r11);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r11 = r3.length();	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
        r3.delete(r2, r11);	 Catch:{ Throwable -> 0x0268, all -> 0x0266 }
    L_0x0255:
        if (r12 == 0) goto L_0x025a;
    L_0x0257:
        r12.close();
    L_0x025a:
        if (r1 == 0) goto L_0x0265;
    L_0x025c:
        r11 = r1.isOpen();
        if (r11 == 0) goto L_0x0265;
    L_0x0262:
        r1.close();
    L_0x0265:
        return;
    L_0x0266:
        r11 = move-exception;
        goto L_0x028d;
    L_0x0268:
        r11 = move-exception;
        r0 = r12;
        goto L_0x0273;
    L_0x026b:
        r11 = move-exception;
        goto L_0x0273;
    L_0x026d:
        r11 = move-exception;
        r12 = r0;
        r1 = r12;
        goto L_0x028d;
    L_0x0271:
        r11 = move-exception;
        r1 = r0;
    L_0x0273:
        r12 = "DB";
        r2 = "fetchHist p2";
        com.loc.O0o0000.O000000o(r11, r12, r2);	 Catch:{ all -> 0x028b }
        if (r0 == 0) goto L_0x027f;
    L_0x027c:
        r0.close();
    L_0x027f:
        if (r1 == 0) goto L_0x028a;
    L_0x0281:
        r11 = r1.isOpen();
        if (r11 == 0) goto L_0x028a;
    L_0x0287:
        r1.close();
    L_0x028a:
        return;
    L_0x028b:
        r11 = move-exception;
        r12 = r0;
    L_0x028d:
        if (r12 == 0) goto L_0x0292;
    L_0x028f:
        r12.close();
    L_0x0292:
        if (r1 == 0) goto L_0x029d;
    L_0x0294:
        r12 = r1.isOpen();
        if (r12 == 0) goto L_0x029d;
    L_0x029a:
        r1.close();
    L_0x029d:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(android.content.Context, java.lang.String):void");
    }

    private void O000000o(String str, AMapLocation aMapLocation, StringBuilder stringBuilder, Context context) throws Exception {
        Throwable th;
        if (context != null) {
            if (this.O0000Ooo == null) {
                this.O0000Ooo = O0OOO0.O000000o("MD5", OO00o00.O00000o0(context));
            }
            str = O000000o(str, stringBuilder, context);
            StringBuilder stringBuilder2 = new StringBuilder();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                try {
                    stringBuilder2.append("CREATE TABLE IF NOT EXISTS hist");
                    stringBuilder2.append(this.O0000OoO);
                    stringBuilder2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
                    openOrCreateDatabase.execSQL(stringBuilder2.toString());
                    stringBuilder2.delete(0, stringBuilder2.length());
                    stringBuilder2.append("REPLACE INTO ");
                    stringBuilder2.append("hist");
                    stringBuilder2.append(this.O0000OoO);
                    stringBuilder2.append(" VALUES (?, ?, ?, ?)");
                    Object[] objArr = new Object[]{str, O0OOO0.O00000o0(stringBuilder.toString().getBytes(HttpUtils.ENCODING_UTF_8), this.O0000Ooo), O0OOO0.O00000o0(aMapLocation.toStr().getBytes(HttpUtils.ENCODING_UTF_8), this.O0000Ooo), Long.valueOf(aMapLocation.getTime())};
                    for (int i = 1; i < objArr.length - 1; i++) {
                        objArr[i] = oOo00.O00000Oo((byte[]) objArr[i]);
                    }
                    openOrCreateDatabase.execSQL(stringBuilder2.toString(), objArr);
                    stringBuilder2.delete(0, stringBuilder2.length());
                    stringBuilder2.delete(0, stringBuilder2.length());
                    if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                        openOrCreateDatabase.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    stringBuilder2.delete(0, stringBuilder2.length());
                    if (openOrCreateDatabase != null && openOrCreateDatabase.isOpen()) {
                        openOrCreateDatabase.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                O0o0000.O000000o(th, "DB", "updateHist");
                stringBuilder2.delete(0, stringBuilder2.length());
                sQLiteDatabase.close();
            }
        }
    }

    private static void O000000o(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            for (CharSequence charSequence : str.split("#")) {
                if (!(TextUtils.isEmpty(charSequence) || charSequence.contains("|"))) {
                    hashtable.put(charSequence, "");
                }
            }
        }
    }

    private static double[] O000000o(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = new double[3];
        int i = 0;
        double d = 0.0d;
        double d2 = d;
        double d3 = d2;
        int i2 = 0;
        int i3 = i2;
        int i4 = i3;
        while (i2 < dArr3.length) {
            d += dArr3[i2] * dArr3[i2];
            d2 += dArr2[i2] * dArr2[i2];
            d3 += dArr3[i2] * dArr2[i2];
            if (dArr2[i2] == 1.0d) {
                i4++;
                if (dArr3[i2] == 1.0d) {
                    i3++;
                }
            }
            i2++;
        }
        dArr4[0] = d3 / (Math.sqrt(d) * Math.sqrt(d2));
        double d4 = (double) i3;
        dArr4[1] = (1.0d * d4) / ((double) i4);
        dArr4[2] = d4;
        while (i < dArr4.length - 1) {
            if (dArr4[i] > 1.0d) {
                dArr4[i] = 1.0d;
            }
            i++;
        }
        return dArr4;
    }

    private boolean O00000Oo() {
        return this.O0000Oo0 != 0 && (this.O000000o.size() > SpatialRelationUtil.A_CIRCLE_DEGREE || OO000OO.O00000o0() - this.O0000Oo0 > 36000000);
    }

    private void O00000o0() {
        this.O0000Oo0 = 0;
        if (!this.O000000o.isEmpty()) {
            this.O000000o.clear();
        }
        this.O0000Oo = false;
    }

    /* JADX WARNING: Missing block: B:27:0x0072, code skipped:
            return null;
     */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(android.content.Context r3, java.lang.String r4, java.lang.StringBuilder r5, boolean r6) {
        /*
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = com.loc.OoO0o.O0000oOo();
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r4);
        r4 = "&";
        r0.append(r4);
        r4 = r2.O00000oo;
        r0.append(r4);
        r4 = "&";
        r0.append(r4);
        r4 = r2.O0000O0o;
        r0.append(r4);
        r4 = "&";
        r0.append(r4);
        r4 = r2.O0000OOo;
        r0.append(r4);
        r4 = r0.toString();
        r0 = "gps";
        r0 = r4.contains(r0);
        if (r0 != 0) goto L_0x0072;
    L_0x0041:
        r0 = com.loc.OoO0o.O0000oOo();
        if (r0 == 0) goto L_0x0072;
    L_0x0047:
        if (r5 != 0) goto L_0x004a;
    L_0x0049:
        return r1;
    L_0x004a:
        r0 = r2.O00000Oo();
        if (r0 == 0) goto L_0x0054;
    L_0x0050:
        r2.O00000o0();
        return r1;
    L_0x0054:
        if (r6 == 0) goto L_0x0064;
    L_0x0056:
        r6 = r2.O0000Oo;
        if (r6 != 0) goto L_0x0064;
    L_0x005a:
        r6 = r2.O000000o(r4, r5, r3);	 Catch:{ Throwable -> 0x0064 }
        r2.O00000o0();	 Catch:{ Throwable -> 0x0064 }
        r2.O000000o(r3, r6);	 Catch:{ Throwable -> 0x0064 }
    L_0x0064:
        r3 = r2.O000000o;
        r3 = r3.isEmpty();
        if (r3 == 0) goto L_0x006d;
    L_0x006c:
        return r1;
    L_0x006d:
        r3 = r2.O000000o(r4, r5);
        return r3;
    L_0x0072:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(android.content.Context, java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2 A:{SKIP, Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f2 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ff A:{SKIP, Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a3 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d9 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d4 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0065 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a3 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00aa A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d4 A:{Catch:{ Throwable -> 0x010c }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d9 A:{Catch:{ Throwable -> 0x010c }} */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer O000000o(com.loc.O0Oo0o0 r20, boolean r21, com.autonavi.aps.amapapi.model.AMapLocationServer r22, com.loc.O0OOO00 r23, java.lang.StringBuilder r24, java.lang.String r25, android.content.Context r26) {
        /*
        r19 = this;
        r0 = r19;
        r2 = r22;
        r3 = r25;
        r4 = r0.O00000Oo;
        if (r4 == 0) goto L_0x0013;
    L_0x000a:
        r4 = com.loc.OoO0o.O0000oOo();
        if (r4 != 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0013;
    L_0x0011:
        r4 = 1;
        goto L_0x0014;
    L_0x0013:
        r4 = 0;
    L_0x0014:
        if (r4 != 0) goto L_0x0018;
    L_0x0016:
        r4 = 0;
        goto L_0x0026;
    L_0x0018:
        if (r2 == 0) goto L_0x0025;
    L_0x001a:
        r7 = r22.getTime();
        r4 = com.loc.OoO0o.O00000Oo(r7);
        if (r4 != 0) goto L_0x0025;
    L_0x0024:
        goto L_0x0016;
    L_0x0025:
        r4 = 1;
    L_0x0026:
        r7 = 0;
        if (r4 != 0) goto L_0x002a;
    L_0x0029:
        return r7;
    L_0x002a:
        r4 = r20.O00000o0();	 Catch:{ Throwable -> 0x010c }
        if (r4 != 0) goto L_0x0034;
    L_0x0030:
        r8 = r0.O00000oO;	 Catch:{ Throwable -> 0x010c }
        if (r8 == 0) goto L_0x0041;
    L_0x0034:
        r8 = r0.O00000oO;	 Catch:{ Throwable -> 0x010c }
        if (r8 == 0) goto L_0x0043;
    L_0x0038:
        r8 = r0.O00000oO;	 Catch:{ Throwable -> 0x010c }
        r4 = r8.equals(r4);	 Catch:{ Throwable -> 0x010c }
        if (r4 != 0) goto L_0x0041;
    L_0x0040:
        goto L_0x0043;
    L_0x0041:
        r4 = 0;
        goto L_0x0044;
    L_0x0043:
        r4 = 1;
    L_0x0044:
        if (r2 == 0) goto L_0x005e;
    L_0x0046:
        r8 = r23.O00000o0();	 Catch:{ Throwable -> 0x010c }
        r8 = r8.size();	 Catch:{ Throwable -> 0x010c }
        r9 = r22.getAccuracy();	 Catch:{ Throwable -> 0x010c }
        r10 = 1133871104; // 0x43958000 float:299.0 double:5.602067593E-315;
        r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r9 <= 0) goto L_0x005e;
    L_0x0059:
        r9 = 5;
        if (r8 <= r9) goto L_0x005e;
    L_0x005c:
        r8 = 1;
        goto L_0x005f;
    L_0x005e:
        r8 = 0;
    L_0x005f:
        r9 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r11 = 0;
        if (r2 == 0) goto L_0x00a0;
    L_0x0065:
        r13 = r0.O00000o;	 Catch:{ Throwable -> 0x010c }
        if (r13 == 0) goto L_0x00a0;
    L_0x0069:
        if (r8 != 0) goto L_0x00a0;
    L_0x006b:
        if (r4 != 0) goto L_0x00a0;
    L_0x006d:
        r4 = r0.O00000o;	 Catch:{ Throwable -> 0x010c }
        r13 = r24.toString();	 Catch:{ Throwable -> 0x010c }
        r4 = com.loc.OO000OO.O000000o(r4, r13);	 Catch:{ Throwable -> 0x010c }
        r13 = r0.O00000o0;	 Catch:{ Throwable -> 0x010c }
        r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
        if (r15 == 0) goto L_0x008b;
    L_0x007d:
        r13 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x010c }
        r5 = r0.O00000o0;	 Catch:{ Throwable -> 0x010c }
        r17 = r13 - r5;
        r5 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1));
        if (r5 >= 0) goto L_0x008b;
    L_0x0089:
        r5 = 1;
        goto L_0x008c;
    L_0x008b:
        r5 = 0;
    L_0x008c:
        if (r4 != 0) goto L_0x0090;
    L_0x008e:
        if (r5 == 0) goto L_0x00a1;
    L_0x0090:
        r5 = com.loc.OO000OO.O000000o(r22);	 Catch:{ Throwable -> 0x010c }
        if (r5 == 0) goto L_0x00a1;
    L_0x0096:
        r1 = "mem";
        r2.e(r1);	 Catch:{ Throwable -> 0x010c }
        r1 = 2;
        r2.setLocationType(r1);	 Catch:{ Throwable -> 0x010c }
        return r2;
    L_0x00a0:
        r4 = 0;
    L_0x00a1:
        if (r4 != 0) goto L_0x00aa;
    L_0x00a3:
        r4 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x010c }
        r0.O00000o0 = r4;	 Catch:{ Throwable -> 0x010c }
        goto L_0x00ac;
    L_0x00aa:
        r0.O00000o0 = r11;	 Catch:{ Throwable -> 0x010c }
    L_0x00ac:
        r2 = r0.O0000o00;	 Catch:{ Throwable -> 0x010c }
        if (r2 == 0) goto L_0x00d0;
    L_0x00b0:
        r2 = r0.O0000o00;	 Catch:{ Throwable -> 0x010c }
        r2 = r3.equals(r2);	 Catch:{ Throwable -> 0x010c }
        if (r2 != 0) goto L_0x00d0;
    L_0x00b8:
        r4 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x010c }
        r13 = r0.O0000o0;	 Catch:{ Throwable -> 0x010c }
        r17 = r4 - r13;
        r2 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1));
        if (r2 >= 0) goto L_0x00c7;
    L_0x00c4:
        r2 = r0.O0000o00;	 Catch:{ Throwable -> 0x010c }
        goto L_0x00e0;
    L_0x00c7:
        r4 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x010c }
    L_0x00cb:
        r0.O0000o0 = r4;	 Catch:{ Throwable -> 0x010c }
        r0.O0000o00 = r3;	 Catch:{ Throwable -> 0x010c }
        goto L_0x00df;
    L_0x00d0:
        r2 = r0.O0000o00;	 Catch:{ Throwable -> 0x010c }
        if (r2 != 0) goto L_0x00d9;
    L_0x00d4:
        r4 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x010c }
        goto L_0x00cb;
    L_0x00d9:
        r4 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x010c }
        r0.O0000o0 = r4;	 Catch:{ Throwable -> 0x010c }
    L_0x00df:
        r2 = r3;
    L_0x00e0:
        if (r8 != 0) goto L_0x00ee;
    L_0x00e2:
        if (r21 != 0) goto L_0x00ee;
    L_0x00e4:
        r3 = r24;
        r4 = r26;
        r5 = 0;
        r2 = r0.O000000o(r4, r2, r3, r5);	 Catch:{ Throwable -> 0x010c }
        goto L_0x00f0;
    L_0x00ee:
        r5 = 0;
        r2 = r7;
    L_0x00f0:
        if (r21 != 0) goto L_0x00fb;
    L_0x00f2:
        r3 = com.loc.OO000OO.O000000o(r2);	 Catch:{ Throwable -> 0x010c }
        if (r3 != 0) goto L_0x00fb;
    L_0x00f8:
        r16 = 1;
        goto L_0x00fd;
    L_0x00fb:
        r16 = r5;
    L_0x00fd:
        if (r16 != 0) goto L_0x010c;
    L_0x00ff:
        if (r8 == 0) goto L_0x0102;
    L_0x0101:
        return r7;
    L_0x0102:
        if (r21 == 0) goto L_0x0105;
    L_0x0104:
        return r7;
    L_0x0105:
        r0.O00000o0 = r11;	 Catch:{ Throwable -> 0x010c }
        r1 = 4;
        r2.setLocationType(r1);	 Catch:{ Throwable -> 0x010c }
        return r2;
    L_0x010c:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(com.loc.O0Oo0o0, boolean, com.autonavi.aps.amapapi.model.AMapLocationServer, com.loc.O0OOO00, java.lang.StringBuilder, java.lang.String, android.content.Context):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void O000000o() {
        this.O00000o0 = 0;
        this.O00000o = null;
    }

    public final void O000000o(Context context) {
        if (!this.O0000Oo) {
            try {
                O00000o0();
                O000000o(context, null);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "Cache", "loadDB");
            }
            this.O0000Oo = true;
        }
    }

    public final void O000000o(AMapLocationClientOption aMapLocationClientOption) {
        this.O0000O0o = aMapLocationClientOption.isNeedAddress();
        this.O00000oo = aMapLocationClientOption.isOffset();
        this.O00000Oo = aMapLocationClientOption.isLocationCacheEnable();
        this.O0000OOo = String.valueOf(aMapLocationClientOption.getGeoLanguage());
    }

    public final void O000000o(O0OO0O o0oo0o) {
        this.O00000oO = o0oo0o;
    }

    public final void O000000o(String str) {
        this.O00000o = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a2 A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0120 A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2 A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0171 A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016f A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018c A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0180 A:{Catch:{ Throwable -> 0x019f, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x019b A:{SYNTHETIC, Splitter:B:83:0x019b} */
    public final void O000000o(java.lang.String r9, java.lang.StringBuilder r10, com.autonavi.aps.amapapi.model.AMapLocationServer r11, android.content.Context r12, boolean r13) {
        /*
        r8 = this;
        r0 = com.loc.OO000OO.O000000o(r11);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a8 }
        r0.<init>();	 Catch:{ Throwable -> 0x01a8 }
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = "&";
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = r11.isOffset();	 Catch:{ Throwable -> 0x01a8 }
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = "&";
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = r11.i();	 Catch:{ Throwable -> 0x01a8 }
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = "&";
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = r11.j();	 Catch:{ Throwable -> 0x01a8 }
        r0.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = r0.toString();	 Catch:{ Throwable -> 0x01a8 }
        r0 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x01a8 }
        r1 = 0;
        if (r0 != 0) goto L_0x0055;
    L_0x003e:
        r0 = com.loc.OO000OO.O000000o(r11);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 != 0) goto L_0x0045;
    L_0x0044:
        goto L_0x0055;
    L_0x0045:
        r0 = "#";
        r0 = r9.startsWith(r0);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x004e;
    L_0x004d:
        goto L_0x0055;
    L_0x004e:
        r0 = "network";
        r0 = r9.contains(r0);	 Catch:{ Throwable -> 0x01a8 }
        goto L_0x0056;
    L_0x0055:
        r0 = r1;
    L_0x0056:
        if (r0 != 0) goto L_0x0059;
    L_0x0058:
        return;
    L_0x0059:
        r0 = r11.e();	 Catch:{ Throwable -> 0x01a8 }
        r2 = "mem";
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0066;
    L_0x0065:
        return;
    L_0x0066:
        r0 = r11.e();	 Catch:{ Throwable -> 0x01a8 }
        r2 = "file";
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0073;
    L_0x0072:
        return;
    L_0x0073:
        r0 = r11.e();	 Catch:{ Throwable -> 0x01a8 }
        r2 = "wifioff";
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0080;
    L_0x007f:
        return;
    L_0x0080:
        r0 = "-3";
        r2 = r11.d();	 Catch:{ Throwable -> 0x01a8 }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x008d;
    L_0x008c:
        return;
    L_0x008d:
        r0 = r8.O00000Oo();	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0096;
    L_0x0093:
        r8.O00000o0();	 Catch:{ Throwable -> 0x01a8 }
    L_0x0096:
        r0 = r11.f();	 Catch:{ Throwable -> 0x01a8 }
        r2 = "offpct";
        r2 = com.loc.OO000OO.O000000o(r0, r2);	 Catch:{ Throwable -> 0x01a8 }
        if (r2 == 0) goto L_0x00aa;
    L_0x00a2:
        r2 = "offpct";
        r0.remove(r2);	 Catch:{ Throwable -> 0x01a8 }
        r11.a(r0);	 Catch:{ Throwable -> 0x01a8 }
    L_0x00aa:
        r0 = "wifi";
        r0 = r9.contains(r0);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0120;
    L_0x00b2:
        r0 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x00b9;
    L_0x00b8:
        return;
    L_0x00b9:
        r0 = r11.getAccuracy();	 Catch:{ Throwable -> 0x01a8 }
        r2 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x00e5;
    L_0x00c3:
        r0 = r10.toString();	 Catch:{ Throwable -> 0x01a8 }
        r2 = "#";
        r0 = r0.split(r2);	 Catch:{ Throwable -> 0x01a8 }
        r2 = r0.length;	 Catch:{ Throwable -> 0x01a8 }
        r3 = r1;
    L_0x00cf:
        if (r1 >= r2) goto L_0x00e0;
    L_0x00d1:
        r4 = r0[r1];	 Catch:{ Throwable -> 0x01a8 }
        r5 = ",";
        r4 = r4.contains(r5);	 Catch:{ Throwable -> 0x01a8 }
        if (r4 == 0) goto L_0x00dd;
    L_0x00db:
        r3 = r3 + 1;
    L_0x00dd:
        r1 = r1 + 1;
        goto L_0x00cf;
    L_0x00e0:
        r0 = 8;
        if (r3 < r0) goto L_0x00f0;
    L_0x00e4:
        return;
    L_0x00e5:
        r0 = r11.getAccuracy();	 Catch:{ Throwable -> 0x01a8 }
        r1 = 1077936128; // 0x40400000 float:3.0 double:5.325712093E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 > 0) goto L_0x00f0;
    L_0x00ef:
        return;
    L_0x00f0:
        r0 = "cgiwifi";
        r0 = r9.contains(r0);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0141;
    L_0x00f8:
        r0 = r11.g();	 Catch:{ Throwable -> 0x01a8 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 != 0) goto L_0x0141;
    L_0x0102:
        r0 = "cgiwifi";
        r1 = "cgi";
        r3 = r9.replace(r0, r1);	 Catch:{ Throwable -> 0x01a8 }
        r5 = r11.h();	 Catch:{ Throwable -> 0x01a8 }
        r0 = com.loc.OO000OO.O000000o(r5);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0141;
    L_0x0114:
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a8 }
        r4.<init>();	 Catch:{ Throwable -> 0x01a8 }
        r7 = 1;
        r2 = r8;
        r6 = r12;
        r2.O000000o(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x01a8 }
        goto L_0x0141;
    L_0x0120:
        r0 = "cgi";
        r0 = r9.contains(r0);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0141;
    L_0x0128:
        if (r10 == 0) goto L_0x0134;
    L_0x012a:
        r0 = ",";
        r0 = r10.indexOf(r0);	 Catch:{ Throwable -> 0x01a8 }
        r1 = -1;
        if (r0 == r1) goto L_0x0134;
    L_0x0133:
        return;
    L_0x0134:
        r0 = "4";
        r1 = r11.d();	 Catch:{ Throwable -> 0x01a8 }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x0141;
    L_0x0140:
        return;
    L_0x0141:
        r0 = r8.O000000o(r9, r10);	 Catch:{ Throwable -> 0x01a8 }
        r1 = com.loc.OO000OO.O000000o(r0);	 Catch:{ Throwable -> 0x01a8 }
        if (r1 == 0) goto L_0x015b;
    L_0x014b:
        r0 = r0.toStr();	 Catch:{ Throwable -> 0x01a8 }
        r1 = 3;
        r1 = r11.toStr(r1);	 Catch:{ Throwable -> 0x01a8 }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x01a8 }
        if (r0 == 0) goto L_0x015b;
    L_0x015a:
        return;
    L_0x015b:
        r0 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x01a8 }
        r8.O0000Oo0 = r0;	 Catch:{ Throwable -> 0x01a8 }
        r0 = new com.loc.O0OOO0O$O000000o;	 Catch:{ Throwable -> 0x01a8 }
        r0.<init>();	 Catch:{ Throwable -> 0x01a8 }
        r0.O000000o(r11);	 Catch:{ Throwable -> 0x01a8 }
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x01a8 }
        if (r1 == 0) goto L_0x0171;
    L_0x016f:
        r1 = 0;
        goto L_0x0175;
    L_0x0171:
        r1 = r10.toString();	 Catch:{ Throwable -> 0x01a8 }
    L_0x0175:
        r0.O000000o(r1);	 Catch:{ Throwable -> 0x01a8 }
        r1 = r8.O000000o;	 Catch:{ Throwable -> 0x01a8 }
        r1 = r1.containsKey(r9);	 Catch:{ Throwable -> 0x01a8 }
        if (r1 == 0) goto L_0x018c;
    L_0x0180:
        r1 = r8.O000000o;	 Catch:{ Throwable -> 0x01a8 }
        r1 = r1.get(r9);	 Catch:{ Throwable -> 0x01a8 }
        r1 = (java.util.ArrayList) r1;	 Catch:{ Throwable -> 0x01a8 }
        r1.add(r0);	 Catch:{ Throwable -> 0x01a8 }
        goto L_0x0199;
    L_0x018c:
        r1 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x01a8 }
        r1.<init>();	 Catch:{ Throwable -> 0x01a8 }
        r1.add(r0);	 Catch:{ Throwable -> 0x01a8 }
        r0 = r8.O000000o;	 Catch:{ Throwable -> 0x01a8 }
        r0.put(r9, r1);	 Catch:{ Throwable -> 0x01a8 }
    L_0x0199:
        if (r13 == 0) goto L_0x01a7;
    L_0x019b:
        r8.O000000o(r9, r11, r10, r12);	 Catch:{ Throwable -> 0x019f }
        return;
    L_0x019f:
        r9 = move-exception;
        r10 = "Cache";
        r11 = "add";
        com.loc.O0o0000.O000000o(r9, r10, r11);	 Catch:{ Throwable -> 0x01a8 }
    L_0x01a7:
        return;
    L_0x01a8:
        r9 = move-exception;
        r10 = "Cache";
        r11 = "add";
        com.loc.O0o0000.O000000o(r9, r10, r11);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O000000o(java.lang.String, java.lang.StringBuilder, com.autonavi.aps.amapapi.model.AMapLocationServer, android.content.Context, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d A:{SYNTHETIC, Splitter:B:34:0x007d} */
    /* JADX WARNING: Missing block: B:24:0x0067, code skipped:
            if (r11.isOpen() != false) goto L_0x0069;
     */
    public final void O00000Oo(android.content.Context r11) {
        /*
        r10 = this;
        r10.O00000o0();	 Catch:{ Throwable -> 0x009a }
        r0 = 0;
        r1 = 0;
        if (r11 == 0) goto L_0x0091;
    L_0x0007:
        r2 = "hmdb";
        r11 = r11.openOrCreateDatabase(r2, r0, r1);	 Catch:{ Throwable -> 0x0072, all -> 0x006f }
        r2 = "hist";
        r2 = com.loc.OO000OO.O000000o(r11, r2);	 Catch:{ Throwable -> 0x006d }
        if (r2 != 0) goto L_0x0022;
    L_0x0015:
        if (r11 == 0) goto L_0x0091;
    L_0x0017:
        r2 = r11.isOpen();	 Catch:{ Throwable -> 0x006d }
        if (r2 == 0) goto L_0x0091;
    L_0x001d:
        r11.close();	 Catch:{ Throwable -> 0x006d }
        goto L_0x0091;
    L_0x0022:
        r2 = "time<?";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Throwable -> 0x006d }
        r4 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x006d }
        r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = r4 - r6;
        r4 = java.lang.String.valueOf(r8);	 Catch:{ Throwable -> 0x006d }
        r3[r0] = r4;	 Catch:{ Throwable -> 0x006d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004a }
        r5 = "hist";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x004a }
        r5 = r10.O0000OoO;	 Catch:{ Throwable -> 0x004a }
        r4.append(r5);	 Catch:{ Throwable -> 0x004a }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x004a }
        r11.delete(r4, r2, r3);	 Catch:{ Throwable -> 0x004a }
        goto L_0x0061;
    L_0x004a:
        r2 = move-exception;
        r3 = "DB";
        r4 = "clearHist";
        com.loc.O0o0000.O000000o(r2, r3, r4);	 Catch:{ Throwable -> 0x006d }
        r2 = r2.getMessage();	 Catch:{ Throwable -> 0x006d }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x006d }
        if (r3 != 0) goto L_0x0061;
    L_0x005c:
        r3 = "no such table";
        r2.contains(r3);	 Catch:{ Throwable -> 0x006d }
    L_0x0061:
        if (r11 == 0) goto L_0x0091;
    L_0x0063:
        r2 = r11.isOpen();	 Catch:{ Throwable -> 0x009a }
        if (r2 == 0) goto L_0x0091;
    L_0x0069:
        r11.close();	 Catch:{ Throwable -> 0x009a }
        goto L_0x0091;
    L_0x006d:
        r2 = move-exception;
        goto L_0x0074;
    L_0x006f:
        r0 = move-exception;
        r11 = r1;
        goto L_0x0085;
    L_0x0072:
        r2 = move-exception;
        r11 = r1;
    L_0x0074:
        r3 = "DB";
        r4 = "clearHist p2";
        com.loc.O0o0000.O000000o(r2, r3, r4);	 Catch:{ all -> 0x0084 }
        if (r11 == 0) goto L_0x0091;
    L_0x007d:
        r2 = r11.isOpen();	 Catch:{ Throwable -> 0x009a }
        if (r2 == 0) goto L_0x0091;
    L_0x0083:
        goto L_0x0069;
    L_0x0084:
        r0 = move-exception;
    L_0x0085:
        if (r11 == 0) goto L_0x0090;
    L_0x0087:
        r1 = r11.isOpen();	 Catch:{ Throwable -> 0x009a }
        if (r1 == 0) goto L_0x0090;
    L_0x008d:
        r11.close();	 Catch:{ Throwable -> 0x009a }
    L_0x0090:
        throw r0;	 Catch:{ Throwable -> 0x009a }
    L_0x0091:
        r10.O0000Oo = r0;	 Catch:{ Throwable -> 0x009a }
        r10.O00000o = r1;	 Catch:{ Throwable -> 0x009a }
        r0 = 0;
        r10.O0000o0 = r0;	 Catch:{ Throwable -> 0x009a }
        return;
    L_0x009a:
        r11 = move-exception;
        r0 = "Cache";
        r1 = "destroy part";
        com.loc.O0o0000.O000000o(r11, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OOO0O.O00000Oo(android.content.Context):void");
    }
}
