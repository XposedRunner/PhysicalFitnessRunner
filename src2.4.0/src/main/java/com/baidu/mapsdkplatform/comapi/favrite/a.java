package com.baidu.mapsdkplatform.comapi.favrite;

import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static a b;
    private com.baidu.mapsdkplatform.comjni.map.favorite.a a = null;
    private boolean c = false;
    private boolean d = false;
    private Vector<String> e = null;
    private Vector<String> f = null;
    private boolean g = false;
    private c h = new c(this, null);
    private b i = new b(this, null);

    class a implements Comparator<String> {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str2.compareTo(str);
        }
    }

    private class b {
        private long b;
        private long c;

        private b() {
        }

        /* synthetic */ b(a aVar, b bVar) {
            this();
        }

        private void a() {
            this.b = System.currentTimeMillis();
        }

        private void b() {
            this.c = System.currentTimeMillis();
        }

        private boolean c() {
            return this.c - this.b > 1000;
        }
    }

    private class c {
        private String b;
        private long c;
        private long d;

        private c() {
            this.c = 5000;
            this.d = 0;
        }

        /* synthetic */ c(a aVar, b bVar) {
            this();
        }

        private String a() {
            return this.b;
        }

        private void a(String str) {
            this.b = str;
            this.d = System.currentTimeMillis();
        }

        private boolean b() {
            return TextUtils.isEmpty(this.b);
        }

        private boolean c() {
            return true;
        }
    }

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                    b.h();
                }
            }
        }
        return b;
    }

    public static boolean g() {
        return (b == null || b.a == null || !b.a.d()) ? false : true;
    }

    private boolean h() {
        if (this.a == null) {
            this.a = new com.baidu.mapsdkplatform.comjni.map.favorite.a();
            if (this.a.a() == 0) {
                this.a = null;
                return false;
            }
            j();
            i();
        }
        return true;
    }

    private boolean i() {
        if (this.a == null) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SysOSUtil.getModuleFileName());
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        String str = "fav_poi";
        this.a.a(1);
        return this.a.a(stringBuilder.toString(), str, "fifo", 10, 501, -1);
    }

    private void j() {
        this.c = false;
        this.d = false;
    }

    /* JADX WARNING: Missing block: B:43:0x00f8, code skipped:
            return 1;
     */
    /* JADX WARNING: Missing block: B:55:0x0109, code skipped:
            return -1;
     */
    public synchronized int a(java.lang.String r7, com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi r8) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.a;	 Catch:{ all -> 0x010a }
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r6);
        return r1;
    L_0x0008:
        r0 = -1;
        if (r7 == 0) goto L_0x0108;
    L_0x000b:
        r2 = "";
        r2 = r7.equals(r2);	 Catch:{ all -> 0x010a }
        if (r2 != 0) goto L_0x0108;
    L_0x0013:
        if (r8 != 0) goto L_0x0017;
    L_0x0015:
        goto L_0x0108;
    L_0x0017:
        r6.j();	 Catch:{ all -> 0x010a }
        r2 = r6.e();	 Catch:{ all -> 0x010a }
        if (r2 == 0) goto L_0x0025;
    L_0x0020:
        r3 = r2.size();	 Catch:{ all -> 0x010a }
        goto L_0x0026;
    L_0x0025:
        r3 = r1;
    L_0x0026:
        r4 = 1;
        r3 = r3 + r4;
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r3 <= r5) goto L_0x002f;
    L_0x002c:
        r7 = -2;
        monitor-exit(r6);
        return r7;
    L_0x002f:
        if (r2 == 0) goto L_0x0058;
    L_0x0031:
        r3 = r2.size();	 Catch:{ all -> 0x010a }
        if (r3 <= 0) goto L_0x0058;
    L_0x0037:
        r2 = r2.iterator();	 Catch:{ all -> 0x010a }
    L_0x003b:
        r3 = r2.hasNext();	 Catch:{ all -> 0x010a }
        if (r3 == 0) goto L_0x0058;
    L_0x0041:
        r3 = r2.next();	 Catch:{ all -> 0x010a }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x010a }
        r3 = r6.b(r3);	 Catch:{ all -> 0x010a }
        if (r3 != 0) goto L_0x004e;
    L_0x004d:
        goto L_0x003b;
    L_0x004e:
        r3 = r3.b;	 Catch:{ all -> 0x010a }
        r3 = r7.equals(r3);	 Catch:{ all -> 0x010a }
        if (r3 == 0) goto L_0x003b;
    L_0x0056:
        monitor-exit(r6);
        return r0;
    L_0x0058:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.<init>();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r8.b = r7;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = java.lang.String.valueOf(r2);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r2.<init>();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r2.append(r7);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r3 = "_";
        r2.append(r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r3 = r8.hashCode();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r2.append(r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r8.h = r7;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r8.a = r2;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "bdetail";
        r3 = r8.i;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "uspoiname";
        r3 = r8.b;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7.<init>();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r3 = "x";
        r5 = r8.c;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r5 = r5.getmPtx();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7.put(r3, r5);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r3 = "y";
        r5 = r8.c;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r5 = r5.getmPty();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7.put(r3, r5);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r3 = "pt";
        r0.put(r3, r7);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "ncityid";
        r3 = r8.e;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "npoitype";
        r3 = r8.g;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "uspoiuid";
        r3 = r8.f;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "addr";
        r3 = r8.d;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = "addtimesec";
        r3 = r8.h;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0.put(r7, r3);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7.<init>();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r3 = "Fav_Sync";
        r7.put(r3, r0);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r0 = "Fav_Content";
        r8 = r8.j;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7.put(r0, r8);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r8 = r6.a;	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = r7.toString();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        r7 = r8.a(r2, r7);	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        if (r7 == 0) goto L_0x00f9;
    L_0x00f1:
        r6.j();	 Catch:{ JSONException -> 0x0103, all -> 0x00fe }
        g();	 Catch:{ all -> 0x010a }
        monitor-exit(r6);
        return r4;
    L_0x00f9:
        g();	 Catch:{ all -> 0x010a }
        monitor-exit(r6);
        return r1;
    L_0x00fe:
        r7 = move-exception;
        g();	 Catch:{ all -> 0x010a }
        throw r7;	 Catch:{ all -> 0x010a }
    L_0x0103:
        g();	 Catch:{ all -> 0x010a }
        monitor-exit(r6);
        return r1;
    L_0x0108:
        monitor-exit(r6);
        return r0;
    L_0x010a:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.favrite.a.a(java.lang.String, com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi):int");
    }

    /* JADX WARNING: Missing block: B:21:0x0027, code skipped:
            return false;
     */
    public synchronized boolean a(java.lang.String r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.a;	 Catch:{ all -> 0x0028 }
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r2);
        return r1;
    L_0x0008:
        if (r3 == 0) goto L_0x0026;
    L_0x000a:
        r0 = "";
        r0 = r3.equals(r0);	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0026;
    L_0x0013:
        r0 = r2.c(r3);	 Catch:{ all -> 0x0028 }
        if (r0 != 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r2);
        return r1;
    L_0x001b:
        r2.j();	 Catch:{ all -> 0x0028 }
        r0 = r2.a;	 Catch:{ all -> 0x0028 }
        r3 = r0.a(r3);	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);
        return r3;
    L_0x0026:
        monitor-exit(r2);
        return r1;
    L_0x0028:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.favrite.a.a(java.lang.String):boolean");
    }

    public FavSyncPoi b(String str) {
        if (this.a == null || str == null || str.equals("")) {
            return null;
        }
        try {
            if (!c(str)) {
                return null;
            }
            FavSyncPoi favSyncPoi = new FavSyncPoi();
            String b = this.a.b(str);
            if (b == null || b.equals("")) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(b);
            JSONObject optJSONObject = jSONObject.optJSONObject("Fav_Sync");
            String optString = jSONObject.optString("Fav_Content");
            favSyncPoi.b = optJSONObject.optString("uspoiname");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("pt");
            favSyncPoi.c = new Point(optJSONObject2.optInt("x"), optJSONObject2.optInt("y"));
            favSyncPoi.e = optJSONObject.optString("ncityid");
            favSyncPoi.f = optJSONObject.optString("uspoiuid");
            favSyncPoi.g = optJSONObject.optInt("npoitype");
            favSyncPoi.d = optJSONObject.optString("addr");
            favSyncPoi.h = optJSONObject.optString("addtimesec");
            favSyncPoi.i = optJSONObject.optBoolean("bdetail");
            favSyncPoi.j = optString;
            favSyncPoi.a = str;
            return favSyncPoi;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void b() {
        if (b != null) {
            if (b.a != null) {
                b.a.b();
                b.a = null;
            }
            b = null;
        }
    }

    /* JADX WARNING: Missing block: B:20:0x00a0, code skipped:
            return r1;
     */
    /* JADX WARNING: Missing block: B:25:0x00a4, code skipped:
            return false;
     */
    public synchronized boolean b(java.lang.String r6, com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi r7) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.a;	 Catch:{ all -> 0x00a5 }
        r1 = 0;
        if (r0 == 0) goto L_0x00a3;
    L_0x0006:
        if (r6 == 0) goto L_0x00a3;
    L_0x0008:
        r0 = "";
        r0 = r6.equals(r0);	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x00a3;
    L_0x0010:
        if (r7 != 0) goto L_0x0014;
    L_0x0012:
        goto L_0x00a3;
    L_0x0014:
        r0 = r5.c(r6);	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r5);
        return r1;
    L_0x001c:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a1 }
        r0.<init>();	 Catch:{ JSONException -> 0x00a1 }
        r2 = "uspoiname";
        r3 = r7.b;	 Catch:{ JSONException -> 0x00a1 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x00a1 }
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a1 }
        r2.<init>();	 Catch:{ JSONException -> 0x00a1 }
        r3 = "x";
        r4 = r7.c;	 Catch:{ JSONException -> 0x00a1 }
        r4 = r4.getmPtx();	 Catch:{ JSONException -> 0x00a1 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x00a1 }
        r3 = "y";
        r4 = r7.c;	 Catch:{ JSONException -> 0x00a1 }
        r4 = r4.getmPty();	 Catch:{ JSONException -> 0x00a1 }
        r2.put(r3, r4);	 Catch:{ JSONException -> 0x00a1 }
        r3 = "pt";
        r0.put(r3, r2);	 Catch:{ JSONException -> 0x00a1 }
        r2 = "ncityid";
        r3 = r7.e;	 Catch:{ JSONException -> 0x00a1 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x00a1 }
        r2 = "npoitype";
        r3 = r7.g;	 Catch:{ JSONException -> 0x00a1 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x00a1 }
        r2 = "uspoiuid";
        r3 = r7.f;	 Catch:{ JSONException -> 0x00a1 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x00a1 }
        r2 = "addr";
        r3 = r7.d;	 Catch:{ JSONException -> 0x00a1 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x00a1 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x00a1 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ JSONException -> 0x00a1 }
        r7.h = r2;	 Catch:{ JSONException -> 0x00a1 }
        r2 = "addtimesec";
        r3 = r7.h;	 Catch:{ JSONException -> 0x00a1 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x00a1 }
        r2 = "bdetail";
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00a1 }
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a1 }
        r2.<init>();	 Catch:{ JSONException -> 0x00a1 }
        r3 = "Fav_Sync";
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x00a1 }
        r0 = "Fav_Content";
        r7 = r7.j;	 Catch:{ JSONException -> 0x00a1 }
        r2.put(r0, r7);	 Catch:{ JSONException -> 0x00a1 }
        r5.j();	 Catch:{ JSONException -> 0x00a1 }
        r7 = r5.a;	 Catch:{ JSONException -> 0x00a1 }
        if (r7 == 0) goto L_0x009f;
    L_0x0092:
        r7 = r5.a;	 Catch:{ JSONException -> 0x00a1 }
        r0 = r2.toString();	 Catch:{ JSONException -> 0x00a1 }
        r6 = r7.b(r6, r0);	 Catch:{ JSONException -> 0x00a1 }
        if (r6 == 0) goto L_0x009f;
    L_0x009e:
        r1 = 1;
    L_0x009f:
        monitor-exit(r5);
        return r1;
    L_0x00a1:
        monitor-exit(r5);
        return r1;
    L_0x00a3:
        monitor-exit(r5);
        return r1;
    L_0x00a5:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.favrite.a.b(java.lang.String, com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi):boolean");
    }

    public synchronized boolean c() {
        if (this.a == null) {
            return false;
        }
        j();
        boolean c = this.a.c();
        g();
        return c;
    }

    public boolean c(String str) {
        return (this.a == null || str == null || str.equals("") || !this.a.c(str)) ? false : true;
    }

    public ArrayList<String> d() {
        if (this.a == null) {
            return null;
        }
        if (this.d && this.f != null) {
            return new ArrayList(this.f);
        }
        try {
            Bundle bundle = new Bundle();
            this.a.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                if (this.f == null) {
                    this.f = new Vector();
                } else {
                    this.f.clear();
                }
                for (int i = 0; i < stringArray.length; i++) {
                    if (!stringArray[i].equals("data_version")) {
                        String b = this.a.b(stringArray[i]);
                        if (b != null) {
                            if (!b.equals("")) {
                                this.f.add(stringArray[i]);
                            }
                        }
                    }
                }
                if (this.f.size() > 0) {
                    try {
                        Collections.sort(this.f, new a());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.d = true;
                }
            } else if (this.f != null) {
                this.f.clear();
                this.f = null;
            }
            if (this.f != null) {
                if (!this.f.isEmpty()) {
                    return new ArrayList(this.f);
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public ArrayList<String> e() {
        ArrayList<String> arrayList = null;
        if (this.a == null) {
            return null;
        }
        if (this.c && this.e != null) {
            return new ArrayList(this.e);
        }
        try {
            Bundle bundle = new Bundle();
            this.a.a(bundle);
            String[] stringArray = bundle.getStringArray("rstString");
            if (stringArray != null) {
                if (this.e == null) {
                    this.e = new Vector();
                } else {
                    this.e.clear();
                }
                for (String str : stringArray) {
                    if (!str.equals("data_version")) {
                        this.e.add(str);
                    }
                }
                if (this.e.size() > 0) {
                    try {
                        Collections.sort(this.e, new a());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.c = true;
                }
            } else if (this.e != null) {
                this.e.clear();
                this.e = null;
            }
            if (this.e != null) {
                if (this.e.size() == 0) {
                    return null;
                }
                arrayList = new ArrayList(this.e);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public String f() {
        if (this.i.c() && !this.h.c() && !this.h.b()) {
            return this.h.a();
        }
        this.i.a();
        if (this.a == null) {
            return null;
        }
        ArrayList d = d();
        JSONObject jSONObject = new JSONObject();
        if (d != null) {
            try {
                JSONArray jSONArray = new JSONArray();
                int i = 0;
                Iterator it = d.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (!(str == null || str.equals("data_version"))) {
                        String b = this.a.b(str);
                        if (!(b == null || b.equals(""))) {
                            JSONObject optJSONObject = new JSONObject(b).optJSONObject("Fav_Sync");
                            optJSONObject.put("key", str);
                            jSONArray.put(i, optJSONObject);
                            i++;
                        }
                    }
                }
                if (i > 0) {
                    jSONObject.put("favcontents", jSONArray);
                    jSONObject.put("favpoinum", i);
                }
            } catch (JSONException unused) {
                return null;
            }
        }
        this.i.b();
        this.h.a(jSONObject.toString());
        return this.h.a();
    }
}
