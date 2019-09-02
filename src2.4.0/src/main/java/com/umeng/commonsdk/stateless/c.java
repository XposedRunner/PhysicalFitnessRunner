package com.umeng.commonsdk.stateless;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: UMSLEnvelopeManager */
public class c {
    private final byte[] a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    private final int b = 1;
    private final int c = 0;
    private String d = "1.0";
    private String e = null;
    private byte[] f = null;
    private byte[] g = null;
    private byte[] h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private byte[] l = null;
    private byte[] m = null;
    private boolean n = false;

    private c(byte[] bArr, String str, byte[] bArr2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.e = str;
        this.k = bArr.length;
        this.l = f.a(bArr);
        this.j = (int) (System.currentTimeMillis() / 1000);
        this.m = bArr2;
    }

    public static c a(Context context, String str, byte[] bArr) {
        try {
            String mac = DeviceConfig.getMac(context);
            String deviceId = DeviceConfig.getDeviceId(context);
            String str2 = "walle";
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[stateless] build envelope, raw is  ");
            stringBuilder.append(bArr == null);
            stringBuilder.append("m app key is ");
            stringBuilder.append(str);
            stringBuilder.append("device id is ");
            stringBuilder.append(deviceId);
            stringBuilder.append(", mac is ");
            stringBuilder.append(mac);
            objArr[0] = stringBuilder.toString();
            ULog.i(str2, objArr);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(deviceId);
            stringBuilder2.append(mac);
            c cVar = new c(bArr, str, stringBuilder2.toString().getBytes());
            cVar.a();
            return cVar;
        } catch (Exception e) {
            Object[] objArr2 = new Object[1];
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("[stateless] build envelope, e is ");
            stringBuilder3.append(e.getMessage());
            objArr2[0] = stringBuilder3.toString();
            ULog.i("walle", objArr2);
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    private byte[] a(byte[] bArr, int i) {
        byte[] b = f.b(this.m);
        byte[] b2 = f.b(this.l);
        int i2 = 0;
        int length = b.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            bArr2[i4] = b2[i3];
            bArr2[i4 + 1] = b[i3];
        }
        for (int i5 = 0; i5 < 2; i5++) {
            bArr2[i5] = bArr[i5];
            bArr2[(bArr2.length - i5) - 1] = bArr[(bArr.length - i5) - 1];
        }
        bArr = new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) (i >>> 24)};
        while (i2 < bArr2.length) {
            bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i2 % 4]);
            i2++;
        }
        return bArr2;
    }

    public static c b(Context context, String str, byte[] bArr) {
        try {
            String mac = DeviceConfig.getMac(context);
            String deviceId = DeviceConfig.getDeviceId(context);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(deviceId);
            stringBuilder.append(mac);
            c cVar = new c(bArr, str, stringBuilder.toString().getBytes());
            cVar.a(true);
            cVar.a();
            return cVar;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    private byte[] c() {
        return a(this.a, (int) (System.currentTimeMillis() / 1000));
    }

    private byte[] d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.c(this.f));
        stringBuilder.append(this.i);
        stringBuilder.append(this.j);
        stringBuilder.append(this.k);
        stringBuilder.append(f.c(this.g));
        return f.b(stringBuilder.toString().getBytes());
    }

    public void a() {
        if (this.f == null) {
            this.f = c();
        }
        if (this.n) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.f, 1, bArr, 0, 16);
                this.l = f.a(this.l, bArr);
            } catch (Exception unused) {
            }
        }
        this.g = a(this.f, this.j);
        this.h = d();
    }

    public void a(boolean z) {
        this.n = z;
    }

    public byte[] b() {
        b bVar = new b();
        bVar.a(this.d);
        bVar.b(this.e);
        bVar.c(f.c(this.f));
        bVar.a(this.i);
        bVar.b(this.j);
        bVar.c(this.k);
        bVar.a(this.l);
        bVar.d(this.n);
        bVar.d(f.c(this.g));
        bVar.e(f.c(this.h));
        try {
            return new s().a(bVar);
        } catch (Exception unused) {
            return null;
        }
    }
}
