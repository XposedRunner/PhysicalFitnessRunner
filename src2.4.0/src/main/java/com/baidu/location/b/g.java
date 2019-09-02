package com.baidu.location.b;

import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.Jni;
import com.baidu.location.g.e;
import com.baidu.location.g.j;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {
    private static Object a = new Object();
    private static g b;
    private Handler c = null;
    private String d = null;
    private int e = 24;
    private a f = null;
    private long g = 0;

    private class a extends e {
        private boolean b;
        private int c;
        private JSONArray d;
        private JSONArray e;

        a() {
            this.b = false;
            this.c = 0;
            this.d = null;
            this.e = null;
            this.k = new HashMap();
        }

        public void a() {
            this.h = j.f();
            this.k.clear();
            this.k.put("qt", "cltrw");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", this.d);
                jSONObject.put("frt", this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String encodeOfflineLocationUpdateRequest = Jni.encodeOfflineLocationUpdateRequest(jSONObject.toString());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(encodeOfflineLocationUpdateRequest);
            this.k.put("cltr[0]", stringBuilder.toString());
            this.k.put("cfg", Integer.valueOf(1));
            this.k.put("info", Jni.encode(com.baidu.location.g.b.a().c()));
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        public void a(boolean z) {
            if (z && this.j != null) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(this.j);
                    z = true;
                } catch (Exception unused) {
                    jSONObject = null;
                    z = false;
                }
                if (z && jSONObject != null) {
                    try {
                        jSONObject.put("tt", System.currentTimeMillis());
                        jSONObject.put("data", this.e);
                        try {
                            File file = new File(g.this.d, "wcnf.dat");
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                            bufferedWriter.write(com.baidu.android.bbalbs.common.a.b.a(jSONObject.toString().getBytes(), HttpUtils.ENCODING_UTF_8));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            this.b = false;
        }

        public void a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
            if (!this.b) {
                this.b = true;
                if (z) {
                    this.c = 1;
                } else {
                    this.c = 0;
                }
                this.d = jSONArray;
                this.e = jSONArray2;
                c(j.f());
            }
        }
    }

    private class b {
        public String a = null;
        public int b = 0;

        b(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    public static g a() {
        g gVar;
        synchronized (a) {
            if (b == null) {
                b = new g();
            }
            gVar = b;
        }
        return gVar;
    }

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    private List<b> a(List<WifiConfiguration> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WifiConfiguration wifiConfiguration : list) {
            int intValue;
            String str = wifiConfiguration.SSID;
            try {
                intValue = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
                intValue = 0;
            }
            if (intValue > 0 && str != null) {
                arrayList.add(new b(str, intValue));
            }
        }
        return arrayList;
    }

    private void a(boolean z, JSONArray jSONArray, JSONArray jSONArray2) {
        if (this.f == null) {
            this.f = new a();
        }
        this.f.a(z, jSONArray, jSONArray2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0171 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01af A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1 A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1 A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1 A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1 A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f1 A:{Catch:{ Exception -> 0x01e0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010a A:{Catch:{ Exception -> 0x01e0 }} */
    private void d() {
        /*
        r18 = this;
        r1 = r18;
        r2 = r1.d;
        if (r2 == 0) goto L_0x01e5;
    L_0x0006:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x01e0 }
        r3 = r1.d;	 Catch:{ Exception -> 0x01e0 }
        r4 = "wcnf.dat";
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x01e0 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01e0 }
        r5 = r2.exists();	 Catch:{ Exception -> 0x01e0 }
        r6 = 0;
        r10 = 1;
        if (r5 == 0) goto L_0x00ec;
    L_0x001c:
        r5 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00e4 }
        r11 = new java.io.FileReader;	 Catch:{ Exception -> 0x00e4 }
        r11.<init>(r2);	 Catch:{ Exception -> 0x00e4 }
        r5.<init>(r11);	 Catch:{ Exception -> 0x00e4 }
        r2 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00e4 }
        r2.<init>();	 Catch:{ Exception -> 0x00e4 }
    L_0x002b:
        r11 = r5.readLine();	 Catch:{ Exception -> 0x00e4 }
        if (r11 == 0) goto L_0x0035;
    L_0x0031:
        r2.append(r11);	 Catch:{ Exception -> 0x00e4 }
        goto L_0x002b;
    L_0x0035:
        r5.close();	 Catch:{ Exception -> 0x00e4 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00e4 }
        if (r2 == 0) goto L_0x00ed;
    L_0x003e:
        r5 = new java.lang.String;	 Catch:{ Exception -> 0x00e4 }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x00e4 }
        r2 = com.baidu.android.bbalbs.common.a.b.a(r2);	 Catch:{ Exception -> 0x00e4 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x00e4 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00e4 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x00e4 }
        r5 = "ison";
        r5 = r2.has(r5);	 Catch:{ Exception -> 0x00e4 }
        if (r5 == 0) goto L_0x0062;
    L_0x0058:
        r5 = "ison";
        r5 = r2.getInt(r5);	 Catch:{ Exception -> 0x00e4 }
        if (r5 != 0) goto L_0x0062;
    L_0x0060:
        r5 = 0;
        goto L_0x0063;
    L_0x0062:
        r5 = r10;
    L_0x0063:
        r11 = "cfg";
        r11 = r2.has(r11);	 Catch:{ Exception -> 0x00e1 }
        if (r11 == 0) goto L_0x0081;
    L_0x006b:
        r11 = "cfg";
        r11 = r2.getJSONObject(r11);	 Catch:{ Exception -> 0x00e1 }
        r12 = "frq";
        r12 = r11.has(r12);	 Catch:{ Exception -> 0x00e1 }
        if (r12 == 0) goto L_0x0081;
    L_0x0079:
        r12 = "frq";
        r11 = r11.getInt(r12);	 Catch:{ Exception -> 0x00e1 }
        r1.e = r11;	 Catch:{ Exception -> 0x00e1 }
    L_0x0081:
        r11 = "tt";
        r11 = r2.has(r11);	 Catch:{ Exception -> 0x00e1 }
        if (r11 == 0) goto L_0x0090;
    L_0x0089:
        r11 = "tt";
        r11 = r2.getLong(r11);	 Catch:{ Exception -> 0x00e1 }
        r3 = r11;
    L_0x0090:
        r11 = "data";
        r11 = r2.has(r11);	 Catch:{ Exception -> 0x00e1 }
        if (r11 == 0) goto L_0x00ee;
    L_0x0098:
        r11 = "data";
        r2 = r2.getJSONArray(r11);	 Catch:{ Exception -> 0x00e1 }
        r11 = new java.util.HashMap;	 Catch:{ Exception -> 0x00e1 }
        r11.<init>();	 Catch:{ Exception -> 0x00e1 }
        r12 = r2.length();	 Catch:{ Exception -> 0x00dd }
        r13 = 0;
    L_0x00a8:
        if (r13 >= r12) goto L_0x00db;
    L_0x00aa:
        r14 = r2.getJSONObject(r13);	 Catch:{ Exception -> 0x00dd }
        r15 = "ssid";
        r15 = r14.has(r15);	 Catch:{ Exception -> 0x00dd }
        if (r15 == 0) goto L_0x00d8;
    L_0x00b6:
        r15 = "num";
        r15 = r14.has(r15);	 Catch:{ Exception -> 0x00dd }
        if (r15 == 0) goto L_0x00d8;
    L_0x00be:
        r15 = new com.baidu.location.b.g$b;	 Catch:{ Exception -> 0x00dd }
        r8 = "ssid";
        r8 = r14.getString(r8);	 Catch:{ Exception -> 0x00dd }
        r9 = "num";
        r9 = r14.getInt(r9);	 Catch:{ Exception -> 0x00dd }
        r15.<init>(r8, r9);	 Catch:{ Exception -> 0x00dd }
        r8 = "ssid";
        r8 = r14.getString(r8);	 Catch:{ Exception -> 0x00dd }
        r11.put(r8, r15);	 Catch:{ Exception -> 0x00dd }
    L_0x00d8:
        r13 = r13 + 1;
        goto L_0x00a8;
    L_0x00db:
        r8 = r11;
        goto L_0x00ef;
    L_0x00dd:
        r0 = move-exception;
        r2 = r0;
        r8 = r11;
        goto L_0x00e8;
    L_0x00e1:
        r0 = move-exception;
        r2 = r0;
        goto L_0x00e7;
    L_0x00e4:
        r0 = move-exception;
        r2 = r0;
        r5 = r10;
    L_0x00e7:
        r8 = 0;
    L_0x00e8:
        r2.printStackTrace();	 Catch:{ Exception -> 0x01e0 }
        goto L_0x00ef;
    L_0x00ec:
        r3 = r6;
    L_0x00ed:
        r5 = r10;
    L_0x00ee:
        r8 = 0;
    L_0x00ef:
        if (r5 != 0) goto L_0x00f7;
    L_0x00f1:
        r2 = r1.e;	 Catch:{ Exception -> 0x01e0 }
        r2 = r2 * 4;
        r1.e = r2;	 Catch:{ Exception -> 0x01e0 }
    L_0x00f7:
        r11 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01e0 }
        r13 = r11 - r3;
        r2 = r1.e;	 Catch:{ Exception -> 0x01e0 }
        r2 = r2 * 60;
        r2 = r2 * 60;
        r2 = r2 * 1000;
        r11 = (long) r2;	 Catch:{ Exception -> 0x01e0 }
        r2 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1));
        if (r2 <= 0) goto L_0x01e5;
    L_0x010a:
        r2 = com.baidu.location.e.i.a();	 Catch:{ Exception -> 0x01e0 }
        r2 = r2.d();	 Catch:{ Exception -> 0x01e0 }
        r2 = r1.a(r2);	 Catch:{ Exception -> 0x01e0 }
        r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r5 != 0) goto L_0x0156;
    L_0x011a:
        if (r2 == 0) goto L_0x01d5;
    L_0x011c:
        r3 = r2.size();	 Catch:{ Exception -> 0x01e0 }
        if (r3 <= 0) goto L_0x01d5;
    L_0x0122:
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01e0 }
        r8.<init>();	 Catch:{ Exception -> 0x01e0 }
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01e0 }
        r3.<init>();	 Catch:{ Exception -> 0x01e0 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x01e0 }
    L_0x0130:
        r4 = r2.hasNext();	 Catch:{ Exception -> 0x01e0 }
        if (r4 == 0) goto L_0x01d8;
    L_0x0136:
        r4 = r2.next();	 Catch:{ Exception -> 0x01e0 }
        r4 = (com.baidu.location.b.g.b) r4;	 Catch:{ Exception -> 0x01e0 }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01e0 }
        r5.<init>();	 Catch:{ Exception -> 0x01e0 }
        r6 = "ssid";
        r7 = r4.a;	 Catch:{ Exception -> 0x01e0 }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x01e0 }
        r6 = "num";
        r4 = r4.b;	 Catch:{ Exception -> 0x01e0 }
        r5.put(r6, r4);	 Catch:{ Exception -> 0x01e0 }
        r8.put(r5);	 Catch:{ Exception -> 0x01e0 }
        r3.put(r5);	 Catch:{ Exception -> 0x01e0 }
        goto L_0x0130;
    L_0x0156:
        if (r2 == 0) goto L_0x01d5;
    L_0x0158:
        r3 = r2.size();	 Catch:{ Exception -> 0x01e0 }
        if (r3 <= 0) goto L_0x01d5;
    L_0x015e:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01e0 }
        r3.<init>();	 Catch:{ Exception -> 0x01e0 }
        if (r8 == 0) goto L_0x01d6;
    L_0x0165:
        r4 = r8.size();	 Catch:{ Exception -> 0x01e0 }
        if (r4 <= 0) goto L_0x01d6;
    L_0x016b:
        r2 = r2.iterator();	 Catch:{ Exception -> 0x01e0 }
        r16 = 0;
    L_0x0171:
        r4 = r2.hasNext();	 Catch:{ Exception -> 0x01e0 }
        if (r4 == 0) goto L_0x01d2;
    L_0x0177:
        r4 = r2.next();	 Catch:{ Exception -> 0x01e0 }
        r4 = (com.baidu.location.b.g.b) r4;	 Catch:{ Exception -> 0x01e0 }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01e0 }
        r5.<init>();	 Catch:{ Exception -> 0x01e0 }
        r6 = "ssid";
        r7 = r4.a;	 Catch:{ Exception -> 0x01e0 }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x01e0 }
        r6 = "num";
        r7 = r4.b;	 Catch:{ Exception -> 0x01e0 }
        r5.put(r6, r7);	 Catch:{ Exception -> 0x01e0 }
        r3.put(r5);	 Catch:{ Exception -> 0x01e0 }
        r5 = r4.a;	 Catch:{ Exception -> 0x01e0 }
        r5 = r8.containsKey(r5);	 Catch:{ Exception -> 0x01e0 }
        if (r5 == 0) goto L_0x01ac;
    L_0x019b:
        r5 = r4.b;	 Catch:{ Exception -> 0x01e0 }
        r6 = r4.a;	 Catch:{ Exception -> 0x01e0 }
        r6 = r8.get(r6);	 Catch:{ Exception -> 0x01e0 }
        r6 = (com.baidu.location.b.g.b) r6;	 Catch:{ Exception -> 0x01e0 }
        r6 = r6.b;	 Catch:{ Exception -> 0x01e0 }
        if (r5 == r6) goto L_0x01aa;
    L_0x01a9:
        goto L_0x01ac;
    L_0x01aa:
        r5 = 0;
        goto L_0x01ad;
    L_0x01ac:
        r5 = r10;
    L_0x01ad:
        if (r5 == 0) goto L_0x0171;
    L_0x01af:
        if (r16 != 0) goto L_0x01b7;
    L_0x01b1:
        r5 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01e0 }
        r5.<init>();	 Catch:{ Exception -> 0x01e0 }
        goto L_0x01b9;
    L_0x01b7:
        r5 = r16;
    L_0x01b9:
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01e0 }
        r6.<init>();	 Catch:{ Exception -> 0x01e0 }
        r7 = "ssid";
        r9 = r4.a;	 Catch:{ Exception -> 0x01e0 }
        r6.put(r7, r9);	 Catch:{ Exception -> 0x01e0 }
        r7 = "num";
        r4 = r4.b;	 Catch:{ Exception -> 0x01e0 }
        r6.put(r7, r4);	 Catch:{ Exception -> 0x01e0 }
        r5.put(r6);	 Catch:{ Exception -> 0x01e0 }
        r16 = r5;
        goto L_0x0171;
    L_0x01d2:
        r8 = r16;
        goto L_0x01d7;
    L_0x01d5:
        r3 = 0;
    L_0x01d6:
        r8 = 0;
    L_0x01d7:
        r10 = 0;
    L_0x01d8:
        if (r8 == 0) goto L_0x01e5;
    L_0x01da:
        if (r3 == 0) goto L_0x01e5;
    L_0x01dc:
        r1.a(r10, r8, r3);	 Catch:{ Exception -> 0x01e0 }
        return;
    L_0x01e0:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();
    L_0x01e5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.g.d():void");
    }

    public void b() {
        if (this.c == null) {
            this.c = new h(this);
        }
        this.d = j.h();
    }

    public void c() {
        if (System.currentTimeMillis() - this.g > 3600000 && this.c != null) {
            this.c.sendEmptyMessage(1);
            this.g = System.currentTimeMillis();
        }
    }
}
