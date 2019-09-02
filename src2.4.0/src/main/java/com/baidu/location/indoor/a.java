package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import cn.jiguang.net.HttpUtils;
import com.baidu.android.bbalbs.common.a.b;
import com.baidu.android.bbalbs.common.a.c;
import com.baidu.location.g.e;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class a extends e {
    private static HashMap<String, Long> a = new HashMap();
    private static Object v = new Object();
    private static a w;
    private String b = "http://loc.map.baidu.com/indoorlocbuildinginfo.php";
    private final SimpleDateFormat c = new SimpleDateFormat("yyyyMM");
    private Context d;
    private boolean e;
    private String f;
    private HashSet<String> q;
    private a r;
    private String s = null;
    private Handler t;
    private Runnable u;

    public interface a {
        void a(boolean z);
    }

    public a(Context context) {
        this.d = context;
        this.q = new HashSet();
        this.e = false;
        this.k = new HashMap();
        this.t = new Handler();
        this.u = new b(this);
    }

    private String a(Date date) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append(this.c.format(date));
        File file = new File(this.d.getCacheDir(), c.a(stringBuilder.toString().getBytes(), false));
        if (!file.isFile()) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(readLine);
                stringBuilder2.append("\n");
                str = stringBuilder2.toString();
            }
            bufferedReader.close();
            if (!str.equals("")) {
                return new String(b.a(str.getBytes()));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void d(String str) {
        for (String toLowerCase : str.split(",")) {
            this.q.add(toLowerCase.toLowerCase());
        }
    }

    private void e(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append(this.c.format(new Date()));
        try {
            FileWriter fileWriter = new FileWriter(new File(this.d.getCacheDir(), c.a(stringBuilder.toString().getBytes(), false)));
            fileWriter.write(b.a(str.getBytes(), HttpUtils.ENCODING_UTF_8));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException unused) {
        }
    }

    private Date f() {
        Calendar instance = Calendar.getInstance();
        instance.add(2, -1);
        return instance.getTime();
    }

    private void f(String str) {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.d.getCacheDir(), "buildings"), true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n");
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void g() {
        try {
            Date f = f();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append(this.c.format(f));
            File file = new File(this.d.getCacheDir(), c.a(stringBuilder.toString().getBytes(), false));
            if (file.isFile()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        this.h = this.b;
        this.k.clear();
        this.k.put("bid", "none");
        this.k.put("bldg", this.f);
        this.k.put("mb", Build.MODEL);
        this.k.put("msdk", "2.0");
        this.k.put("cuid", com.baidu.location.g.b.a().b);
        this.k.put("anchors", "v1");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    public void a(boolean r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        if (r6 == 0) goto L_0x0048;
    L_0x0004:
        r6 = r5.j;
        if (r6 == 0) goto L_0x0048;
    L_0x0008:
        r6 = r5.j;	 Catch:{ Exception -> 0x0048 }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0048 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0048 }
        r6 = r6.getBytes();	 Catch:{ Exception -> 0x0048 }
        r6 = com.baidu.android.bbalbs.common.a.b.a(r6);	 Catch:{ Exception -> 0x0048 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0048 }
        r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0048 }
        r6.<init>(r2);	 Catch:{ Exception -> 0x0048 }
        r2 = "anchorinfo";
        r2 = r6.has(r2);	 Catch:{ Exception -> 0x0048 }
        if (r2 == 0) goto L_0x0048;
    L_0x0028:
        r2 = "anchorinfo";
        r6 = r6.optString(r2);	 Catch:{ Exception -> 0x0048 }
        if (r6 == 0) goto L_0x0048;
    L_0x0030:
        r2 = "";
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0048 }
        if (r2 != 0) goto L_0x0048;
    L_0x0038:
        r2 = r5.q;	 Catch:{ Exception -> 0x0048 }
        r2.clear();	 Catch:{ Exception -> 0x0048 }
        r5.d(r6);	 Catch:{ Exception -> 0x0048 }
        r5.e(r6);	 Catch:{ Exception -> 0x0048 }
        r5.g();	 Catch:{ Exception -> 0x0046 }
    L_0x0046:
        r6 = r0;
        goto L_0x0049;
    L_0x0048:
        r6 = r1;
    L_0x0049:
        if (r6 != 0) goto L_0x005e;
    L_0x004b:
        r2 = r5.s;
        if (r2 != 0) goto L_0x005e;
    L_0x004f:
        r0 = r5.f;
        r5.s = r0;
        r0 = r5.t;
        r2 = r5.u;
        r3 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r0.postDelayed(r2, r3);
        goto L_0x0081;
    L_0x005e:
        r2 = 0;
        if (r6 == 0) goto L_0x0064;
    L_0x0061:
        r5.s = r2;
        goto L_0x0081;
    L_0x0064:
        r3 = r5.s;
        r5.f(r3);
        r5.s = r2;
        r2 = r5.f();
        r2 = r5.a(r2);
        if (r2 == 0) goto L_0x0081;
    L_0x0075:
        r5.d(r2);
        r2 = r5.r;
        if (r2 == 0) goto L_0x0081;
    L_0x007c:
        r2 = r5.r;
        r2.a(r0);
    L_0x0081:
        r5.e = r1;
        r0 = r5.r;
        if (r0 == 0) goto L_0x008c;
    L_0x0087:
        r0 = r5.r;
        r0.a(r6);
    L_0x008c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.a.a(boolean):void");
    }

    public boolean a(String str) {
        return (this.f == null || !this.f.equalsIgnoreCase(str) || this.q.isEmpty()) ? false : true;
    }

    public boolean a(String str, a aVar) {
        if (!this.e) {
            this.r = aVar;
            this.e = true;
            this.f = str;
            try {
                String a = a(new Date());
                if (a == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (a.get(str) == null || currentTimeMillis - ((Long) a.get(str)).longValue() > LogBuilder.MAX_INTERVAL) {
                        a.put(str, Long.valueOf(currentTimeMillis));
                        e();
                        return false;
                    }
                }
                d(a);
                if (this.r != null) {
                    this.r.a(true);
                }
                this.e = false;
                return false;
            } catch (Exception unused) {
                this.e = false;
            }
        }
        return false;
    }

    public boolean b() {
        return (this.q == null || this.q.isEmpty()) ? false : true;
    }

    public boolean b(String str) {
        return (this.f == null || this.q == null || this.q.isEmpty() || !this.q.contains(str)) ? false : true;
    }

    public void c() {
        this.f = null;
        this.q.clear();
    }
}
