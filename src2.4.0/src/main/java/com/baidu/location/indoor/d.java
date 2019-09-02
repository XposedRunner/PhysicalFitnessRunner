package com.baidu.location.indoor;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class d {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static d b;
    private Context c;
    private boolean d = false;
    private boolean e = false;
    private BluetoothAdapter f;
    private boolean g = false;
    private b h;
    private boolean i = false;
    private String j = null;
    private long k = -1;
    private HashMap<String, ScanResult> l = new HashMap();
    private Handler m = new Handler();
    private Runnable n = new e(this);
    private Object o = null;

    public static class a implements Comparable<a> {
        public String a;
        public int b;
        public long c;

        public a(String str, int i, long j) {
            this.a = str;
            this.b = i;
            this.c = j / 1000000;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return Math.abs(this.b) > Math.abs(aVar.b) ? 1 : 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.toUpperCase());
            stringBuilder.append(";");
            stringBuilder.append(this.b);
            stringBuilder.append(";");
            stringBuilder.append(this.c);
            return stringBuilder.toString();
        }
    }

    public interface b {
        void a(boolean z, String str, String str2, String str3);
    }

    @TargetApi(18)
    private d(Context context) {
        this.c = context;
        if (this.f == null) {
            try {
                if (VERSION.SDK_INT > 18) {
                    this.f = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
                    this.g = this.c.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                    return;
                }
                this.f = BluetoothAdapter.getDefaultAdapter();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    private String a(List<a> list, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(list);
        stringBuilder.append(((a) list.get(0)).toString());
        int i2 = 1;
        while (i2 < list.size() && i2 < i) {
            stringBuilder.append("|");
            stringBuilder.append(((a) list.get(i2)).toString());
            i2++;
        }
        return stringBuilder.toString();
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = a[i2 >>> 4];
            cArr[i3 + 1] = a[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(21)
    private void a(HashMap<String, ScanResult> hashMap) {
        ArrayList<ScanResult> arrayList = new ArrayList(hashMap.values());
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        List arrayList3 = new ArrayList();
        for (ScanResult scanResult : arrayList) {
            arrayList3.add(new a(scanResult.getDevice().getAddress().replaceAll(":", ""), scanResult.getRssi(), scanResult.getTimestampNanos()));
            if (this.d) {
                scanResult.getScanRecord().getAdvertiseFlags();
                byte[] bytes = scanResult.getScanRecord().getBytes();
                if (bytes.length >= 26) {
                    String a = a(Arrays.copyOfRange(bytes, 9, 25));
                    arrayList2.add(a);
                    hashMap2.put(a, scanResult.getDevice().getName());
                    hashMap3.put(a, a(Arrays.copyOfRange(bytes, 0, 9)));
                    if (hashMap4.get(a) == null) {
                        hashMap4.put(a, Integer.valueOf(0));
                    }
                    hashMap4.put(a, Integer.valueOf(((Integer) hashMap4.get(a)).intValue() + 1));
                }
            }
        }
        Object obj = null;
        int i = 0;
        for (String str : hashMap4.keySet()) {
            if (((Integer) hashMap4.get(str)).intValue() > i) {
                i = ((Integer) hashMap4.get(str)).intValue();
                obj = str;
            }
        }
        boolean z = i > 3;
        if (this.h != null && this.d) {
            this.h.a(z, obj, (String) hashMap2.get(obj), (String) hashMap3.get(obj));
            this.d = false;
        }
        if (arrayList3.size() > 3) {
            this.j = a(arrayList3, 32);
            this.k = System.currentTimeMillis();
        }
        if (this.i) {
            a(true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    private boolean h() {
        /*
        r8 = this;
        r0 = new java.io.File;
        r1 = r8.c;
        r1 = r1.getCacheDir();
        r2 = "ibct";
        r0.<init>(r1, r2);
        r1 = r0.exists();
        r2 = 0;
        if (r1 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r1 = 0;
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0048 }
        r4 = new java.io.FileReader;	 Catch:{ Exception -> 0x0048 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0048 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0048 }
        r0 = "";
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0025:
        r4 = r3.readLine();	 Catch:{ Exception -> 0x0043 }
        if (r4 == 0) goto L_0x003f;
    L_0x002b:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003c }
        r0.<init>();	 Catch:{ Exception -> 0x003c }
        r0.append(r1);	 Catch:{ Exception -> 0x003c }
        r0.append(r4);	 Catch:{ Exception -> 0x003c }
        r1 = r0.toString();	 Catch:{ Exception -> 0x003c }
        r0 = r4;
        goto L_0x0025;
    L_0x003c:
        r0 = move-exception;
        r1 = r4;
        goto L_0x0049;
    L_0x003f:
        r3.close();	 Catch:{ Exception -> 0x0048 }
        goto L_0x004c;
    L_0x0043:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x0049;
    L_0x0048:
        r0 = move-exception;
    L_0x0049:
        r0.printStackTrace();
    L_0x004c:
        if (r1 == 0) goto L_0x0072;
    L_0x004e:
        r0 = r1.trim();
        r3 = "";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x005b;
    L_0x005a:
        return r2;
    L_0x005b:
        r0 = java.lang.Long.valueOf(r1);	 Catch:{ Exception -> 0x0072 }
        r0 = r0.longValue();	 Catch:{ Exception -> 0x0072 }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0072 }
        r5 = r3 - r0;
        r0 = 259200; // 0x3f480 float:3.63217E-40 double:1.28062E-318;
        r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r3 >= 0) goto L_0x0072;
    L_0x0070:
        r0 = 1;
        return r0;
    L_0x0072:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.d.h():boolean");
    }

    private void i() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.c.getCacheDir(), "ibct"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("");
            fileWriter.write(stringBuilder.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception unused) {
        }
    }

    @TargetApi(21)
    public void a(boolean z) {
        if (this.f != null) {
            try {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        this.o = new f(this);
                        this.f.getBluetoothLeScanner().startScan((ScanCallback) this.o);
                        this.m.postDelayed(this.n, 3000);
                        z = true;
                    } else {
                        if (this.h != null) {
                            this.f.getBluetoothLeScanner().stopScan((ScanCallback) this.o);
                        }
                        z = false;
                    }
                    this.d = z;
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean a() {
        if (this.f == null || !this.g) {
            return false;
        }
        try {
            return this.f.isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean a(b bVar) {
        if (this.d || this.e) {
            return false;
        }
        this.e = true;
        if (!a() || h()) {
            return false;
        }
        i();
        this.h = bVar;
        a(true);
        return true;
    }

    public boolean b() {
        if (!a()) {
            return false;
        }
        a(true);
        this.i = true;
        return true;
    }

    public void c() {
        this.e = false;
        this.d = false;
    }

    public void d() {
        this.i = false;
    }

    public String e() {
        return this.j;
    }

    public long f() {
        return this.k;
    }

    public boolean g() {
        return System.currentTimeMillis() - this.k <= 20000;
    }
}
