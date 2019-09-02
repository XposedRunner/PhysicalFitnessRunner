package com.baidu.location.b;

import android.content.SharedPreferences.Editor;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.location.Jni;
import com.baidu.location.f;
import com.baidu.location.g.b;
import com.baidu.location.g.c;
import com.baidu.location.g.i;
import com.baidu.location.g.j;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class e {
    private static e i = null;
    private static final String k;
    private static int l = -1;
    private static int m = -1;
    private static int n;
    public boolean a = true;
    public boolean b = true;
    public boolean c = false;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public boolean g = true;
    public boolean h = false;
    private a j = null;

    class a extends com.baidu.location.g.e {
        String a;
        boolean b;
        boolean c;

        public a() {
            this.a = null;
            this.b = false;
            this.c = false;
            this.k = new HashMap();
        }

        public void a() {
            Map map;
            Object obj;
            Object obj2;
            this.h = j.d();
            this.i = 2;
            String encode = Jni.encode(this.a);
            this.a = null;
            if (this.b) {
                map = this.k;
                obj = "qt";
                obj2 = "grid";
            } else {
                map = this.k;
                obj = "qt";
                obj2 = "conf";
            }
            map.put(obj, obj2);
            this.k.put("req", encode);
        }

        public void a(String str, boolean z) {
            if (!this.c) {
                this.c = true;
                this.a = str;
                this.b = z;
                if (z) {
                    a(true, "loc.map.baidu.com");
                } else {
                    c(j.f);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
        public void a(boolean r2) {
            /*
            r1 = this;
            if (r2 == 0) goto L_0x0017;
        L_0x0002:
            r2 = r1.j;
            if (r2 == 0) goto L_0x0017;
        L_0x0006:
            r2 = r1.b;
            if (r2 == 0) goto L_0x0012;
        L_0x000a:
            r2 = com.baidu.location.b.e.this;
            r0 = r1.m;
            r2.a(r0);
            goto L_0x001d;
        L_0x0012:
            r2 = com.baidu.location.b.e.this;
            r0 = r1.j;
            goto L_0x001a;
        L_0x0017:
            r2 = com.baidu.location.b.e.this;
            r0 = 0;
        L_0x001a:
            r2.b(r0);
        L_0x001d:
            r2 = r1.k;
            if (r2 == 0) goto L_0x0026;
        L_0x0021:
            r2 = r1.k;
            r2.clear();
        L_0x0026:
            r2 = 0;
            r1.c = r2;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e$a.a(boolean):void");
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/conlts.dat");
        k = stringBuilder.toString();
    }

    private e() {
    }

    public static e a() {
        if (i == null) {
            i = new e();
        }
        return i;
    }

    private void a(int i) {
        boolean z = true;
        this.a = (i & 1) == 1;
        this.b = (i & 2) == 2;
        this.c = (i & 4) == 4;
        this.d = (i & 8) == 8;
        this.f = (i & 65536) == 65536;
        if ((i & 131072) != 131072) {
            z = false;
        }
        this.g = z;
        if ((i & 16) == 16) {
            this.e = false;
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = true;
            int i = 14400000;
            int i2 = 10;
            try {
                if (jSONObject.has("ipen") && jSONObject.getInt("ipen") == 0) {
                    z = false;
                }
                if (jSONObject.has("ipvt")) {
                    i = jSONObject.getInt("ipvt");
                }
                if (jSONObject.has("ipvn")) {
                    i2 = jSONObject.getInt("ipvn");
                }
                Editor edit = f.getServiceContext().getSharedPreferences("MapCoreServicePre", 0).edit();
                edit.putBoolean("ipLocInfoUpload", z);
                edit.putInt("ipValidTime", i);
                edit.putInt("ipLocInfoUploadTimesPerDay", i2);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    private void a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int i = 0;
        if (bArr2 != null) {
            try {
                if (bArr2.length < GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH) {
                    j.x = false;
                    j.u = j.s + 0.025d;
                    j.t = j.r - 0.025d;
                } else {
                    j.x = true;
                    j.t = Double.longBitsToDouble(((((((((((long) bArr2[7]) & 255) << 56) | ((((long) bArr2[6]) & 255) << 48)) | ((((long) bArr2[5]) & 255) << 40)) | ((((long) bArr2[4]) & 255) << 32)) | ((((long) bArr2[3]) & 255) << 24)) | ((((long) bArr2[2]) & 255) << 16)) | ((((long) bArr2[1]) & 255) << 8)) | (((long) bArr2[0]) & 255));
                    j.u = Double.longBitsToDouble(((((((((((long) bArr2[15]) & 255) << 56) | ((((long) bArr2[14]) & 255) << 48)) | ((((long) bArr2[13]) & 255) << 40)) | ((((long) bArr2[12]) & 255) << 32)) | ((((long) bArr2[11]) & 255) << 24)) | ((((long) bArr2[10]) & 255) << 16)) | ((((long) bArr2[9]) & 255) << 8)) | (((long) bArr2[8]) & 255));
                    j.w = new byte[625];
                    while (i < 625) {
                        j.w[i] = bArr2[i + 16];
                        i++;
                    }
                }
                i = 1;
            } catch (Exception unused) {
                return;
            }
        }
        if (i != 0) {
            g();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:240:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0028 A:{Catch:{ Exception -> 0x0435 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|(18:10|(2:12|(22:14|(1:18)|19|(1:23)|24|(1:28)|29|(1:33)|34|(1:38)|39|(1:43)|44|(1:48)|49|(1:53)|54|(1:58)|59|(1:63)|64|(1:68)))|69|(2:71|(8:73|(1:77)|78|(1:82)|83|(1:87)|88|(1:92)))|93|(2:95|(8:97|(1:101)|102|(1:106)|107|(1:111)|112|(1:116)))|117|(2:119|(8:121|(1:125)|126|(1:130)|131|(1:135)|136|(1:140)))|141|(2:143|(10:145|(1:149)|150|(1:154)|155|(1:159)|160|(1:164)|165|(1:169)))|170|(2:172|(12:174|(2:178|(1:180)(1:181))|182|(2:186|(1:188)(1:189))|190|(1:194)|195|(1:199)|200|(2:204|(1:206)(1:207))|208|(1:212)))|213|(2:215|(6:217|(1:221)|222|(1:226)|227|(1:231)))|232|(1:234)|235|237)(1:240)) */
    private boolean a(java.lang.String r12) {
        /*
        r11 = this;
        r0 = 1;
        r1 = 0;
        if (r12 == 0) goto L_0x0435;
    L_0x0004:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0435 }
        r2.<init>(r12);	 Catch:{ Exception -> 0x0435 }
        r12 = "ipconf";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x001a;
    L_0x0011:
        r12 = "ipconf";
        r12 = r2.getJSONObject(r12);	 Catch:{ Exception -> 0x001a }
        r11.a(r12);	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        r12 = "ver";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Integer.parseInt(r12);	 Catch:{ Exception -> 0x0435 }
        r3 = com.baidu.location.g.j.y;	 Catch:{ Exception -> 0x0435 }
        if (r12 <= r3) goto L_0x0435;
    L_0x0028:
        com.baidu.location.g.j.y = r12;	 Catch:{ Exception -> 0x0435 }
        r12 = "gps";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        r3 = 5;
        r4 = 4;
        r5 = 3;
        r6 = 2;
        if (r12 == 0) goto L_0x013f;
    L_0x0036:
        r12 = "gps";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r7 = "\\|";
        r12 = r12.split(r7);	 Catch:{ Exception -> 0x0435 }
        r7 = r12.length;	 Catch:{ Exception -> 0x0435 }
        r8 = 10;
        if (r7 <= r8) goto L_0x013f;
    L_0x0047:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x005d;
    L_0x004b:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x005d;
    L_0x0055:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.z = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x005d:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0073;
    L_0x0061:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0073;
    L_0x006b:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.A = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0073:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0089;
    L_0x0077:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0089;
    L_0x0081:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.B = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0089:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x009f;
    L_0x008d:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x009f;
    L_0x0097:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.C = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x009f:
        r7 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x00b5;
    L_0x00a3:
        r7 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x00b5;
    L_0x00ad:
        r7 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.D = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x00b5:
        r7 = r12[r3];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x00cb;
    L_0x00b9:
        r7 = r12[r3];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x00cb;
    L_0x00c3:
        r7 = r12[r3];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.E = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x00cb:
        r7 = 6;
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        if (r9 == 0) goto L_0x00e2;
    L_0x00d0:
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r10 = "";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0435 }
        if (r9 != 0) goto L_0x00e2;
    L_0x00da:
        r7 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.F = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x00e2:
        r7 = 7;
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        if (r9 == 0) goto L_0x00f9;
    L_0x00e7:
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r10 = "";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0435 }
        if (r9 != 0) goto L_0x00f9;
    L_0x00f1:
        r7 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.G = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x00f9:
        r7 = 8;
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        if (r9 == 0) goto L_0x0111;
    L_0x00ff:
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r10 = "";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0435 }
        if (r9 != 0) goto L_0x0111;
    L_0x0109:
        r7 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.H = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0111:
        r7 = 9;
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        if (r9 == 0) goto L_0x0129;
    L_0x0117:
        r9 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r10 = "";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0435 }
        if (r9 != 0) goto L_0x0129;
    L_0x0121:
        r7 = r12[r7];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.I = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0129:
        r7 = r12[r8];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x013f;
    L_0x012d:
        r7 = r12[r8];	 Catch:{ Exception -> 0x0435 }
        r9 = "";
        r7 = r7.equals(r9);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x013f;
    L_0x0137:
        r12 = r12[r8];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Integer.parseInt(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.J = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x013f:
        r12 = "up";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x01ae;
    L_0x0147:
        r12 = "up";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r7 = "\\|";
        r12 = r12.split(r7);	 Catch:{ Exception -> 0x0435 }
        r7 = r12.length;	 Catch:{ Exception -> 0x0435 }
        if (r7 <= r5) goto L_0x01ae;
    L_0x0156:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x016c;
    L_0x015a:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x016c;
    L_0x0164:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.K = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x016c:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0182;
    L_0x0170:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0182;
    L_0x017a:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.L = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0182:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0198;
    L_0x0186:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0198;
    L_0x0190:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.M = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0198:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x01ae;
    L_0x019c:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x01ae;
    L_0x01a6:
        r12 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Float.parseFloat(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.N = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x01ae:
        r12 = "wf";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x021d;
    L_0x01b6:
        r12 = "wf";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r7 = "\\|";
        r12 = r12.split(r7);	 Catch:{ Exception -> 0x0435 }
        r7 = r12.length;	 Catch:{ Exception -> 0x0435 }
        if (r7 <= r5) goto L_0x021d;
    L_0x01c5:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x01db;
    L_0x01c9:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x01db;
    L_0x01d3:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.O = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x01db:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x01f1;
    L_0x01df:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x01f1;
    L_0x01e9:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.P = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x01f1:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0207;
    L_0x01f5:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0207;
    L_0x01ff:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.Q = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0207:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x021d;
    L_0x020b:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x021d;
    L_0x0215:
        r12 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Float.parseFloat(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.R = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x021d:
        r12 = "ab";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x028c;
    L_0x0225:
        r12 = "ab";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r7 = "\\|";
        r12 = r12.split(r7);	 Catch:{ Exception -> 0x0435 }
        r7 = r12.length;	 Catch:{ Exception -> 0x0435 }
        if (r7 <= r5) goto L_0x028c;
    L_0x0234:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x024a;
    L_0x0238:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x024a;
    L_0x0242:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.S = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x024a:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0260;
    L_0x024e:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0260;
    L_0x0258:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.T = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0260:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0276;
    L_0x0264:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0276;
    L_0x026e:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.U = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0276:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x028c;
    L_0x027a:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x028c;
    L_0x0284:
        r12 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Integer.parseInt(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.V = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x028c:
        r12 = "zxd";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x0311;
    L_0x0294:
        r12 = "zxd";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r7 = "\\|";
        r12 = r12.split(r7);	 Catch:{ Exception -> 0x0435 }
        r7 = r12.length;	 Catch:{ Exception -> 0x0435 }
        if (r7 <= r4) goto L_0x0311;
    L_0x02a3:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x02b9;
    L_0x02a7:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x02b9;
    L_0x02b1:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.ar = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x02b9:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x02cf;
    L_0x02bd:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x02cf;
    L_0x02c7:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.as = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x02cf:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x02e5;
    L_0x02d3:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x02e5;
    L_0x02dd:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.at = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x02e5:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x02fb;
    L_0x02e9:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x02fb;
    L_0x02f3:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.au = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x02fb:
        r7 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0311;
    L_0x02ff:
        r7 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0311;
    L_0x0309:
        r12 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Integer.parseInt(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.av = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x0311:
        r12 = "gpc";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x03cb;
    L_0x0319:
        r12 = "gpc";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r7 = "\\|";
        r12 = r12.split(r7);	 Catch:{ Exception -> 0x0435 }
        r7 = r12.length;	 Catch:{ Exception -> 0x0435 }
        if (r7 <= r3) goto L_0x03cb;
    L_0x0328:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0343;
    L_0x032c:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0343;
    L_0x0336:
        r7 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        if (r7 <= 0) goto L_0x0341;
    L_0x033e:
        com.baidu.location.g.j.aa = r0;	 Catch:{ Exception -> 0x0435 }
        goto L_0x0343;
    L_0x0341:
        com.baidu.location.g.j.aa = r1;	 Catch:{ Exception -> 0x0435 }
    L_0x0343:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x035e;
    L_0x0347:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x035e;
    L_0x0351:
        r7 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        if (r7 <= 0) goto L_0x035c;
    L_0x0359:
        com.baidu.location.g.j.ab = r0;	 Catch:{ Exception -> 0x0435 }
        goto L_0x035e;
    L_0x035c:
        com.baidu.location.g.j.ab = r1;	 Catch:{ Exception -> 0x0435 }
    L_0x035e:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x0374;
    L_0x0362:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x0374;
    L_0x036c:
        r7 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.ac = r7;	 Catch:{ Exception -> 0x0435 }
    L_0x0374:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        if (r7 == 0) goto L_0x038a;
    L_0x0378:
        r7 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r8 = "";
        r7 = r7.equals(r8);	 Catch:{ Exception -> 0x0435 }
        if (r7 != 0) goto L_0x038a;
    L_0x0382:
        r5 = r12[r5];	 Catch:{ Exception -> 0x0435 }
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.ae = r5;	 Catch:{ Exception -> 0x0435 }
    L_0x038a:
        r5 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        if (r5 == 0) goto L_0x03b5;
    L_0x038e:
        r5 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        r7 = "";
        r5 = r5.equals(r7);	 Catch:{ Exception -> 0x0435 }
        if (r5 != 0) goto L_0x03b5;
    L_0x0398:
        r4 = r12[r4];	 Catch:{ Exception -> 0x0435 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x0435 }
        if (r4 <= 0) goto L_0x03b3;
    L_0x03a0:
        r4 = (long) r4;	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.ak = r4;	 Catch:{ Exception -> 0x0435 }
        r4 = com.baidu.location.g.j.ak;	 Catch:{ Exception -> 0x0435 }
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r7;
        r7 = 60;
        r4 = r4 * r7;
        com.baidu.location.g.j.ag = r4;	 Catch:{ Exception -> 0x0435 }
        r4 = com.baidu.location.g.j.ag;	 Catch:{ Exception -> 0x0435 }
        r4 = r4 >> r6;
        com.baidu.location.g.j.al = r4;	 Catch:{ Exception -> 0x0435 }
        goto L_0x03b5;
    L_0x03b3:
        com.baidu.location.g.j.p = r1;	 Catch:{ Exception -> 0x0435 }
    L_0x03b5:
        r4 = r12[r3];	 Catch:{ Exception -> 0x0435 }
        if (r4 == 0) goto L_0x03cb;
    L_0x03b9:
        r4 = r12[r3];	 Catch:{ Exception -> 0x0435 }
        r5 = "";
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0435 }
        if (r4 != 0) goto L_0x03cb;
    L_0x03c3:
        r12 = r12[r3];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Integer.parseInt(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.an = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x03cb:
        r12 = "shak";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x0424;
    L_0x03d3:
        r12 = "shak";
        r12 = r2.getString(r12);	 Catch:{ Exception -> 0x0435 }
        r3 = "\\|";
        r12 = r12.split(r3);	 Catch:{ Exception -> 0x0435 }
        r3 = r12.length;	 Catch:{ Exception -> 0x0435 }
        if (r3 <= r6) goto L_0x0424;
    L_0x03e2:
        r3 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        if (r3 == 0) goto L_0x03f8;
    L_0x03e6:
        r3 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r4 = "";
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0435 }
        if (r3 != 0) goto L_0x03f8;
    L_0x03f0:
        r3 = r12[r1];	 Catch:{ Exception -> 0x0435 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.ao = r3;	 Catch:{ Exception -> 0x0435 }
    L_0x03f8:
        r3 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        if (r3 == 0) goto L_0x040e;
    L_0x03fc:
        r3 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r4 = "";
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0435 }
        if (r3 != 0) goto L_0x040e;
    L_0x0406:
        r3 = r12[r0];	 Catch:{ Exception -> 0x0435 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.ap = r3;	 Catch:{ Exception -> 0x0435 }
    L_0x040e:
        r3 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        if (r3 == 0) goto L_0x0424;
    L_0x0412:
        r3 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r4 = "";
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0435 }
        if (r3 != 0) goto L_0x0424;
    L_0x041c:
        r12 = r12[r6];	 Catch:{ Exception -> 0x0435 }
        r12 = java.lang.Float.parseFloat(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.aq = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x0424:
        r12 = "dmx";
        r12 = r2.has(r12);	 Catch:{ Exception -> 0x0435 }
        if (r12 == 0) goto L_0x0434;
    L_0x042c:
        r12 = "dmx";
        r12 = r2.getInt(r12);	 Catch:{ Exception -> 0x0435 }
        com.baidu.location.g.j.am = r12;	 Catch:{ Exception -> 0x0435 }
    L_0x0434:
        r1 = r0;
    L_0x0435:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.a(java.lang.String):boolean");
    }

    private void b(int i) {
        File file = new File(k);
        if (!file.exists()) {
            i();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            randomAccessFile.seek((long) (128 + (readInt * n)));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.d);
            stringBuilder.append(0);
            byte[] bytes = stringBuilder.toString().getBytes();
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes, 0, bytes.length);
            randomAccessFile.writeInt(i);
            if (readInt2 == n) {
                randomAccessFile.seek(8);
                randomAccessFile.writeInt(readInt2 + 1);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A:{Catch:{ Exception -> 0x0027 }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036 A:{Catch:{ Exception -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A:{Catch:{ Exception -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A:{Catch:{ Exception -> 0x0043 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000e */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A:{Catch:{ Exception -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036 A:{Catch:{ Exception -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040 A:{Catch:{ Exception -> 0x0043 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0027 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:2|3|(1:5)|6|7|(1:9)|10|11|(1:13)(2:14|(1:16)(1:17))|(2:19|21)(1:24)) */
    private void b(java.lang.String r3) {
        /*
        r2 = this;
        r0 = -1;
        m = r0;
        if (r3 == 0) goto L_0x0043;
    L_0x0005:
        r1 = r2.a(r3);	 Catch:{ Exception -> 0x000e }
        if (r1 == 0) goto L_0x000e;
    L_0x000b:
        r2.f();	 Catch:{ Exception -> 0x000e }
    L_0x000e:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0027 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0027 }
        r3 = "ctr";
        r3 = r1.has(r3);	 Catch:{ Exception -> 0x0027 }
        if (r3 == 0) goto L_0x0027;
    L_0x001b:
        r3 = "ctr";
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x0027 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0027 }
        m = r3;	 Catch:{ Exception -> 0x0027 }
    L_0x0027:
        r2.j();	 Catch:{ Exception -> 0x0043 }
        r3 = m;	 Catch:{ Exception -> 0x0043 }
        if (r3 == r0) goto L_0x0036;
    L_0x002e:
        r3 = m;	 Catch:{ Exception -> 0x0043 }
        r1 = m;	 Catch:{ Exception -> 0x0043 }
        r2.b(r1);	 Catch:{ Exception -> 0x0043 }
        goto L_0x003e;
    L_0x0036:
        r3 = l;	 Catch:{ Exception -> 0x0043 }
        if (r3 == r0) goto L_0x003d;
    L_0x003a:
        r3 = l;	 Catch:{ Exception -> 0x0043 }
        goto L_0x003e;
    L_0x003d:
        r3 = r0;
    L_0x003e:
        if (r3 == r0) goto L_0x0043;
    L_0x0040:
        r2.a(r3);	 Catch:{ Exception -> 0x0043 }
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.e.b(java.lang.String):void");
    }

    private void e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&ver=");
        stringBuilder.append(j.y);
        stringBuilder.append("&usr=");
        stringBuilder.append(b.a().b());
        stringBuilder.append("&app=");
        stringBuilder.append(b.d);
        stringBuilder.append("&prod=");
        stringBuilder.append(b.e);
        String stringBuilder2 = stringBuilder.toString();
        if (this.j == null) {
            this.j = new a();
        }
        this.j.a(stringBuilder2, false);
    }

    private void f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/config.dat");
        String stringBuilder2 = stringBuilder.toString();
        boolean z = j.aa;
        boolean z2 = j.ab;
        byte[] bytes = String.format(Locale.CHINA, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", new Object[]{Integer.valueOf(j.y), Float.valueOf(j.z), Float.valueOf(j.A), Float.valueOf(j.B), Float.valueOf(j.C), Integer.valueOf(j.D), Integer.valueOf(j.E), Integer.valueOf(j.F), Integer.valueOf(j.G), Integer.valueOf(j.H), Integer.valueOf(j.I), Integer.valueOf(j.J), Float.valueOf(j.K), Float.valueOf(j.L), Float.valueOf(j.M), Float.valueOf(j.N), Integer.valueOf(j.O), Float.valueOf(j.P), Integer.valueOf(j.Q), Float.valueOf(j.R), Float.valueOf(j.S), Float.valueOf(j.T), Integer.valueOf(j.U), Integer.valueOf(j.V), Integer.valueOf(z), Integer.valueOf(z2), Integer.valueOf(j.ac), Integer.valueOf(j.ae), Long.valueOf(j.ak), Integer.valueOf(j.an), Float.valueOf(j.ar), Float.valueOf(j.as), Integer.valueOf(j.at), Integer.valueOf(j.au), Integer.valueOf(j.av), Integer.valueOf(j.ao), Integer.valueOf(j.ap), Float.valueOf(j.aq), Integer.valueOf(j.am)}).getBytes();
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(stringBuilder2);
            if (!file.exists()) {
                File file2 = new File(i.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.seek(2);
            randomAccessFile.writeInt(bytes.length);
            randomAccessFile.write(bytes);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private void g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/config.dat");
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                File file2 = new File(i.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(1);
            randomAccessFile.writeBoolean(true);
            randomAccessFile.seek(1024);
            randomAccessFile.writeDouble(j.t);
            randomAccessFile.writeDouble(j.u);
            randomAccessFile.writeBoolean(j.x);
            if (j.x && j.w != null) {
                randomAccessFile.write(j.w);
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private void h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.a);
        stringBuilder.append("/config.dat");
        try {
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(2);
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    a(new String(bArr));
                }
                randomAccessFile.seek(1);
                if (randomAccessFile.readBoolean()) {
                    randomAccessFile.seek(1024);
                    j.t = randomAccessFile.readDouble();
                    j.u = randomAccessFile.readDouble();
                    j.x = randomAccessFile.readBoolean();
                    if (j.x) {
                        j.w = new byte[625];
                        randomAccessFile.read(j.w, 0, 625);
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
        if (j.p) {
            boolean z = f.isServing;
        }
    }

    private void i() {
        try {
            File file = new File(k);
            if (!file.exists()) {
                File file2 = new File(i.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(128);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    private void j() {
        try {
            File file = new File(k);
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4);
                int readInt = randomAccessFile.readInt();
                if (readInt > SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY) {
                    randomAccessFile.close();
                    n = 0;
                    i();
                    return;
                }
                int readInt2 = randomAccessFile.readInt();
                randomAccessFile.seek(128);
                byte[] bArr = new byte[readInt];
                int i = 0;
                while (i < readInt2) {
                    randomAccessFile.seek((long) (128 + (readInt * i)));
                    int readInt3 = randomAccessFile.readInt();
                    if (readInt3 > 0 && readInt3 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt3);
                        readInt3--;
                        if (bArr[readInt3] == (byte) 0) {
                            String str = new String(bArr, 0, readInt3);
                            b.a();
                            if (str.equals(b.d)) {
                                l = randomAccessFile.readInt();
                                n = i;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                if (i == readInt2) {
                    n = readInt2;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        h();
    }

    public void c() {
    }

    public void d() {
        if (System.currentTimeMillis() - c.a().d() > 604800000) {
            c.a().c(System.currentTimeMillis());
            e();
        }
    }
}
