package com.baidu.location.indoor.mapversion.c;

import android.content.Context;
import android.location.Location;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

public class a {
    private static a a;
    private c b;
    private String c;
    private boolean d = false;
    private String e = "rn";
    private b f;
    private String g = CoordinateType.GCJ02;
    private HashMap<String, d> h = new HashMap();
    private HashMap<String, double[][]> i = new HashMap();
    private d j = null;

    public interface c {
        void a(boolean z, String str);
    }

    public static class a {
        public double a;
        public double b;
        public double c;
        public double d;
        public double e;
        public double f;
        public double g;
        public double h;

        public a(String str) {
            a(str);
        }

        public void a(String str) {
            String[] split = str.trim().split("\\|");
            this.a = Double.valueOf(split[0]).doubleValue();
            this.b = Double.valueOf(split[1]).doubleValue();
            this.c = Double.valueOf(split[2]).doubleValue();
            this.d = Double.valueOf(split[3]).doubleValue();
            this.e = Double.valueOf(split[4]).doubleValue();
            this.f = Double.valueOf(split[5]).doubleValue();
            this.g = Double.valueOf(split[6]).doubleValue();
            this.h = Double.valueOf(split[7]).doubleValue();
        }
    }

    private class b extends Thread {
        private String b;
        private String c;

        public b(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x011d A:{Catch:{ Exception -> 0x0127 }} */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x011d A:{Catch:{ Exception -> 0x0127 }} */
        public void run() {
            /*
            r7 = this;
            r0 = 0;
            r1 = new java.io.File;	 Catch:{ Exception -> 0x0127 }
            r2 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r2 = r2.e;	 Catch:{ Exception -> 0x0127 }
            r1.<init>(r2);	 Catch:{ Exception -> 0x0127 }
            r2 = r1.exists();	 Catch:{ Exception -> 0x0127 }
            if (r2 == 0) goto L_0x0018;
        L_0x0012:
            r2 = r1.isDirectory();	 Catch:{ Exception -> 0x0127 }
            if (r2 != 0) goto L_0x001b;
        L_0x0018:
            r1.mkdirs();	 Catch:{ Exception -> 0x0127 }
        L_0x001b:
            r2 = new java.net.URL;	 Catch:{ Exception -> 0x0127 }
            r3 = "http://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet";
            r2.<init>(r3);	 Catch:{ Exception -> 0x0127 }
            r2 = r2.openConnection();	 Catch:{ Exception -> 0x0127 }
            r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0127 }
            r3 = 1;
            r2.setDoInput(r3);	 Catch:{ Exception -> 0x0127 }
            r2.setDoOutput(r3);	 Catch:{ Exception -> 0x0127 }
            r3 = "POST";
            r2.setRequestMethod(r3);	 Catch:{ Exception -> 0x0127 }
            r3 = "Accept-encoding";
            r4 = "gzip";
            r2.addRequestProperty(r3, r4);	 Catch:{ Exception -> 0x0127 }
            r3 = r2.getOutputStream();	 Catch:{ Exception -> 0x0127 }
            r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0127 }
            r4.<init>();	 Catch:{ Exception -> 0x0127 }
            r5 = "bldg=";
            r4.append(r5);	 Catch:{ Exception -> 0x0127 }
            r5 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r4.append(r5);	 Catch:{ Exception -> 0x0127 }
            r5 = "&md5=";
            r4.append(r5);	 Catch:{ Exception -> 0x0127 }
            r5 = r7.c;	 Catch:{ Exception -> 0x0127 }
            if (r5 != 0) goto L_0x005a;
        L_0x0057:
            r5 = "null";
            goto L_0x005c;
        L_0x005a:
            r5 = r7.c;	 Catch:{ Exception -> 0x0127 }
        L_0x005c:
            r4.append(r5);	 Catch:{ Exception -> 0x0127 }
            r4 = r4.toString();	 Catch:{ Exception -> 0x0127 }
            r4 = r4.getBytes();	 Catch:{ Exception -> 0x0127 }
            r3.write(r4);	 Catch:{ Exception -> 0x0127 }
            r3 = r2.getResponseCode();	 Catch:{ Exception -> 0x0127 }
            r4 = 0;
            r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r3 != r5) goto L_0x00ce;
        L_0x0073:
            r3 = "Hash";
            r3 = r2.getHeaderField(r3);	 Catch:{ Exception -> 0x0127 }
            r2 = r2.getInputStream();	 Catch:{ Exception -> 0x0127 }
            r4 = new java.io.File;	 Catch:{ Exception -> 0x0127 }
            r5 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r6 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r5 = r5.a(r6, r3);	 Catch:{ Exception -> 0x0127 }
            r4.<init>(r1, r5);	 Catch:{ Exception -> 0x0127 }
            r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0127 }
            r1.<init>(r4);	 Catch:{ Exception -> 0x0127 }
            r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r5 = new byte[r5];	 Catch:{ Exception -> 0x0127 }
        L_0x0093:
            r6 = r2.read(r5);	 Catch:{ Exception -> 0x0127 }
            if (r6 < 0) goto L_0x009d;
        L_0x0099:
            r1.write(r5, r0, r6);	 Catch:{ Exception -> 0x0127 }
            goto L_0x0093;
        L_0x009d:
            r1.flush();	 Catch:{ Exception -> 0x0127 }
            r1.close();	 Catch:{ Exception -> 0x0127 }
            r1 = com.baidu.location.indoor.mapversion.c.a.a(r4);	 Catch:{ Exception -> 0x0127 }
            r1 = r1.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x0127 }
            if (r1 == 0) goto L_0x00c7;
        L_0x00ad:
            r1 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r2 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r3 = r7.c;	 Catch:{ Exception -> 0x0127 }
            r1.b(r2, r3);	 Catch:{ Exception -> 0x0127 }
            r1 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r2 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r1.c = r2;	 Catch:{ Exception -> 0x0127 }
            r1 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r1 = r1.d();	 Catch:{ Exception -> 0x0127 }
            r2 = "OK";
            r4 = r2;
            goto L_0x0115;
        L_0x00c7:
            r1 = "Download failed";
            r4.delete();	 Catch:{ Exception -> 0x0127 }
            r4 = r1;
            goto L_0x0114;
        L_0x00ce:
            r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
            if (r3 != r1) goto L_0x00fd;
        L_0x00d2:
            r1 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r2 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r1.c = r2;	 Catch:{ Exception -> 0x0127 }
            r1 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r1 = r1.d();	 Catch:{ Exception -> 0x0127 }
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0127 }
            r2.<init>();	 Catch:{ Exception -> 0x0127 }
            r3 = "No roadnet update for ";
            r2.append(r3);	 Catch:{ Exception -> 0x0127 }
            r3 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r2.append(r3);	 Catch:{ Exception -> 0x0127 }
            r3 = ",";
            r2.append(r3);	 Catch:{ Exception -> 0x0127 }
            r3 = r7.c;	 Catch:{ Exception -> 0x0127 }
            r2.append(r3);	 Catch:{ Exception -> 0x0127 }
            r4 = r2.toString();	 Catch:{ Exception -> 0x0127 }
            goto L_0x0115;
        L_0x00fd:
            r1 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
            if (r3 != r1) goto L_0x0114;
        L_0x0101:
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0127 }
            r1.<init>();	 Catch:{ Exception -> 0x0127 }
            r2 = "Not found bldg ";
            r1.append(r2);	 Catch:{ Exception -> 0x0127 }
            r2 = r7.b;	 Catch:{ Exception -> 0x0127 }
            r1.append(r2);	 Catch:{ Exception -> 0x0127 }
            r4 = r1.toString();	 Catch:{ Exception -> 0x0127 }
        L_0x0114:
            r1 = r0;
        L_0x0115:
            r2 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r2 = r2.b;	 Catch:{ Exception -> 0x0127 }
            if (r2 == 0) goto L_0x012b;
        L_0x011d:
            r2 = com.baidu.location.indoor.mapversion.c.a.this;	 Catch:{ Exception -> 0x0127 }
            r2 = r2.b;	 Catch:{ Exception -> 0x0127 }
            r2.a(r1, r4);	 Catch:{ Exception -> 0x0127 }
            goto L_0x012b;
        L_0x0127:
            r1 = move-exception;
            r1.printStackTrace();
        L_0x012b:
            r1 = com.baidu.location.indoor.mapversion.c.a.this;
            r1.d = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.mapversion.c.a$b.run():void");
        }
    }

    public static class d implements Serializable {
        public String a;
        public String b;
        public a c;
        public a d;
        public a e;
        public a f = this.d;
        public short[][] g;
        private String h = CoordinateType.GCJ02;

        public d(String str) {
            this.a = str;
        }

        public double a(double d) {
            return (d + this.f.d) * this.f.c;
        }

        public a a() {
            return this.f;
        }

        public void a(String str) {
            if (str != null) {
                a aVar;
                this.h = str.toLowerCase();
                if (this.h.startsWith(CoordinateType.WGS84)) {
                    aVar = this.c;
                } else if (this.h.startsWith(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    aVar = this.e;
                } else if (this.h.startsWith(CoordinateType.GCJ02)) {
                    aVar = this.d;
                }
                this.f = aVar;
            }
        }

        public double b(double d) {
            return (d + this.f.f) * this.f.e;
        }

        public void b(String str) {
            String[] split = str.split("\\t");
            this.b = split[1];
            this.c = new a(split[2]);
            this.e = new a(split[3]);
            this.d = new a(split[4]);
            this.f = this.d;
            this.g = (short[][]) Array.newInstance(short.class, new int[]{(int) this.f.g, (int) this.f.h});
            for (int i = 0; ((double) i) < this.f.g; i++) {
                for (int i2 = 0; ((double) i2) < this.f.h; i2++) {
                    this.g[i][i2] = (short) (split[5].charAt((((int) this.f.h) * i) + i2) - 48);
                }
            }
        }

        public double c(double d) {
            return (d / this.f.c) - this.f.d;
        }

        public double d(double d) {
            return (d / this.f.e) - this.f.f;
        }
    }

    private a(Context context) {
        this.e = new File(context.getCacheDir(), this.e).getAbsolutePath();
    }

    public static a a() {
        return a;
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    public static String a(File file) {
        Exception e;
        String str = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MappedByteBuffer map = fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, file.length());
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(map);
            String bigInteger = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
                int length = 32 - bigInteger.length();
                while (length > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("0");
                    stringBuilder.append(bigInteger);
                    length--;
                    bigInteger = stringBuilder.toString();
                }
                return bigInteger;
            } catch (Exception e2) {
                Exception exception = e2;
                str = bigInteger;
                e = exception;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return str;
        }
    }

    private String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d(str));
        stringBuilder.append("_");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private void b(String str, String str2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.e);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(a(str, str2));
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String d(String str) {
        return str;
    }

    private boolean d() {
        if (this.c == null) {
            return false;
        }
        File f = f(this.c);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!d.a(f, byteArrayOutputStream)) {
            return false;
        }
        this.h.clear();
        this.i.clear();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return true;
                } else if (readLine.split("\\t")[1].split("_")[0].equals("geo")) {
                    j(readLine);
                } else {
                    d dVar = new d(this.c);
                    dVar.b(readLine);
                    dVar.a(this.g);
                    this.h.put(dVar.b.toLowerCase(), dVar);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return true;
            }
        }
    }

    private String e(String str) {
        File file = new File(this.e);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles(new b(this, str));
        int i = 0;
        if (listFiles == null || listFiles.length != 1) {
            while (listFiles != null && i < listFiles.length) {
                listFiles[i].delete();
                i++;
            }
            return null;
        }
        String[] split = listFiles[0].getName().split("_");
        return split.length < 2 ? null : split[1];
    }

    private File f(String str) {
        String e = e(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(a(str, e));
        return new File(stringBuilder.toString());
    }

    private boolean g(String str) {
        File f = f(str);
        return f.exists() && f.length() > 0;
    }

    private boolean h(String str) {
        return System.currentTimeMillis() - f(str).lastModified() > 1296000000;
    }

    private ArrayList<Double> i(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            double intValue;
            int i2;
            if (str.charAt(i) == ',') {
                i2 = i + 1;
                i += 2;
                intValue = (double) Integer.valueOf(str.substring(i2, i)).intValue();
            } else if (str.charAt(i) == '.') {
                i2 = i + 1;
                i += 4;
                intValue = Double.valueOf(str.substring(i2, i)).doubleValue();
            } else {
                i2 = i + 2;
                double intValue2 = (double) Integer.valueOf(str.substring(i, i2)).intValue();
                i = i2;
                intValue = intValue2;
            }
            arrayList.add(Double.valueOf(intValue));
        }
        return arrayList;
    }

    private void j(String str) {
        String[] split = str.split("\\t");
        String toLowerCase = split[1].split("_")[1].toLowerCase();
        try {
            if (this.h.containsKey(toLowerCase)) {
                ArrayList i = i(split[5]);
                int length = ((d) this.h.get(toLowerCase)).g.length;
                int length2 = ((d) this.h.get(toLowerCase)).g[0].length;
                double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{length, length2});
                int i2 = 0;
                int i3 = i2;
                while (i2 < length) {
                    int i4 = i3;
                    i3 = 0;
                    while (i3 < length2) {
                        if (((d) this.h.get(toLowerCase)).g[i2][i3] <= (short) 0 || ((d) this.h.get(toLowerCase)).g[i2][i3] == (short) 9) {
                            dArr[i2][i3] = 0.0d;
                        } else {
                            dArr[i2][i3] = ((Double) i.get(i4)).doubleValue();
                            i4++;
                        }
                        i3++;
                    }
                    i2++;
                    i3 = i4;
                }
                this.i.put(toLowerCase.toLowerCase(), dArr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k(String str) {
        if (!this.d) {
            this.d = true;
            this.f = new b(str, e(str));
            this.f.start();
        }
    }

    public void a(double d, double d2) {
        double d3 = d;
        double d4 = d2;
        if (this.j == null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            double d5 = d4 + 0.01d;
            double d6 = d3;
            Location.distanceBetween(d4, d6, d4, d3 + 0.01d, fArr);
            d4 = ((double) fArr[0]) / 0.01d;
            Location.distanceBetween(d4, d6, d5, d3, fArr2);
            double d7 = ((double) fArr2[0]) / 0.01d;
            this.j = new d("outdoor");
            this.j.b = "out";
            d dVar = this.j;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0|1.0|");
            stringBuilder.append(d4);
            stringBuilder.append("|");
            stringBuilder.append(-d3);
            stringBuilder.append("|");
            stringBuilder.append(d7);
            stringBuilder.append("|");
            stringBuilder.append(-d2);
            stringBuilder.append("|0|0");
            dVar.f = new a(stringBuilder.toString());
        }
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(String str, c cVar) {
        if (this.c == null || !str.equals(this.c)) {
            this.b = cVar;
            if (!g(str) || h(str)) {
                k(str);
                return;
            }
            this.c = str;
            d();
            if (this.b != null) {
                this.b.a(true, "OK");
            }
        }
    }

    public d b(String str) {
        return (d) this.h.get(str.toLowerCase());
    }

    public void b() {
        this.h.clear();
        this.i.clear();
        this.c = null;
        this.d = false;
    }

    public d c() {
        return this.j;
    }

    public double[][] c(String str) {
        return (double[][]) this.i.get(str.toLowerCase());
    }
}
