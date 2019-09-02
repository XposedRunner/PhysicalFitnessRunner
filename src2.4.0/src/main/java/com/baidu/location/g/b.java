package com.baidu.location.g;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;

public class b {
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static int h;
    private static b i;
    public String a = null;
    public String b = null;
    public String c = null;
    private boolean j = false;

    private b() {
        if (f.getServiceContext() != null) {
            a(f.getServiceContext());
        }
    }

    public static b a() {
        if (i == null) {
            i = new b();
        }
        return i;
    }

    public String a(boolean z) {
        return a(z, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0134  */
    public java.lang.String a(boolean r6, java.lang.String r7) {
        /*
        r5 = this;
        r0 = new java.lang.StringBuffer;
        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0.<init>(r1);
        r1 = "&sdk=";
        r0.append(r1);
        r1 = 1089722122; // 0x40f3d70a float:7.62 double:5.38394264E-315;
        r0.append(r1);
        if (r6 == 0) goto L_0x0066;
    L_0x0014:
        r1 = com.baidu.location.g.j.g;
        r2 = "all";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0023;
    L_0x001e:
        r1 = "&addr=allj";
        r0.append(r1);
    L_0x0023:
        r1 = com.baidu.location.g.j.i;
        if (r1 != 0) goto L_0x0028;
    L_0x0027:
        goto L_0x002d;
    L_0x0028:
        r1 = "&adtp=n2";
        r0.append(r1);
    L_0x002d:
        r1 = com.baidu.location.g.j.h;
        if (r1 != 0) goto L_0x003d;
    L_0x0031:
        r1 = com.baidu.location.g.j.k;
        if (r1 != 0) goto L_0x003d;
    L_0x0035:
        r1 = com.baidu.location.g.j.l;
        if (r1 != 0) goto L_0x003d;
    L_0x0039:
        r1 = com.baidu.location.g.j.j;
        if (r1 == 0) goto L_0x0066;
    L_0x003d:
        r1 = "&sema=";
        r0.append(r1);
        r1 = com.baidu.location.g.j.h;
        if (r1 == 0) goto L_0x004b;
    L_0x0046:
        r1 = "aptag|";
        r0.append(r1);
    L_0x004b:
        r1 = com.baidu.location.g.j.j;
        if (r1 == 0) goto L_0x0054;
    L_0x004f:
        r1 = "aptagd|";
        r0.append(r1);
    L_0x0054:
        r1 = com.baidu.location.g.j.k;
        if (r1 == 0) goto L_0x005d;
    L_0x0058:
        r1 = "poiregion|";
        r0.append(r1);
    L_0x005d:
        r1 = com.baidu.location.g.j.l;
        if (r1 == 0) goto L_0x0066;
    L_0x0061:
        r1 = "regular";
        r0.append(r1);
    L_0x0066:
        if (r6 == 0) goto L_0x007f;
    L_0x0068:
        if (r7 != 0) goto L_0x0070;
    L_0x006a:
        r7 = "&coor=gcj02";
    L_0x006c:
        r0.append(r7);
        goto L_0x0076;
    L_0x0070:
        r1 = "&coor=";
        r0.append(r1);
        goto L_0x006c;
    L_0x0076:
        r7 = com.baidu.location.e.e.k();
        if (r7 == 0) goto L_0x007f;
    L_0x007c:
        r0.append(r7);
    L_0x007f:
        r7 = r5.b;
        if (r7 != 0) goto L_0x008e;
    L_0x0083:
        r7 = "&im=";
    L_0x0085:
        r0.append(r7);
        r7 = r5.a;
        r0.append(r7);
        goto L_0x00c0;
    L_0x008e:
        r7 = "&cu=";
        r0.append(r7);
        r7 = r5.b;
        r0.append(r7);
        r7 = r5.a;
        if (r7 == 0) goto L_0x00c0;
    L_0x009c:
        r7 = r5.a;
        r1 = "NULL";
        r7 = r7.equals(r1);
        if (r7 != 0) goto L_0x00c0;
    L_0x00a6:
        r7 = r5.b;
        r1 = new java.lang.StringBuffer;
        r2 = r5.a;
        r1.<init>(r2);
        r1 = r1.reverse();
        r1 = r1.toString();
        r7 = r7.contains(r1);
        if (r7 != 0) goto L_0x00c0;
    L_0x00bd:
        r7 = "&Aim=";
        goto L_0x0085;
    L_0x00c0:
        r7 = r5.c;
        if (r7 == 0) goto L_0x00ce;
    L_0x00c4:
        r7 = "&Aid=";
        r0.append(r7);
        r7 = r5.c;
        r0.append(r7);
    L_0x00ce:
        r7 = "&fw=";
        r0.append(r7);
        r7 = com.baidu.location.f.getFrameVersion();
        r0.append(r7);
        r7 = "&lt=1";
        r0.append(r7);
        r7 = "&mb=";
        r0.append(r7);
        r7 = android.os.Build.MODEL;
        r0.append(r7);
        r7 = com.baidu.location.g.j.b();
        if (r7 == 0) goto L_0x00f7;
    L_0x00ef:
        r1 = "&laip=";
        r0.append(r1);
        r0.append(r7);
    L_0x00f7:
        r7 = com.baidu.location.a.n.a();
        r7 = r7.d();
        r1 = 0;
        r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        r2 = 0;
        if (r1 == 0) goto L_0x011e;
    L_0x0105:
        r1 = "&altv=";
        r0.append(r1);
        r1 = java.util.Locale.US;
        r3 = "%.5f";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r7 = java.lang.Float.valueOf(r7);
        r4[r2] = r7;
        r7 = java.lang.String.format(r1, r3, r4);
        r0.append(r7);
    L_0x011e:
        r7 = "&resid=";
        r0.append(r7);
        r7 = "12";
        r0.append(r7);
        r7 = "&os=A";
        r0.append(r7);
        r7 = android.os.Build.VERSION.SDK;
        r0.append(r7);
        if (r6 == 0) goto L_0x014b;
    L_0x0134:
        r6 = "&sv=";
        r0.append(r6);
        r6 = android.os.Build.VERSION.RELEASE;
        if (r6 == 0) goto L_0x0148;
    L_0x013d:
        r7 = r6.length();
        r1 = 6;
        if (r7 <= r1) goto L_0x0148;
    L_0x0144:
        r6 = r6.substring(r2, r1);
    L_0x0148:
        r0.append(r6);
    L_0x014b:
        r6 = r0.toString();
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.g.b.a(boolean, java.lang.String):java.lang.String");
    }

    public void a(Context context) {
        if (context != null && !this.j) {
            try {
                this.a = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception unused) {
                this.a = "NULL";
            }
            try {
                this.b = CommonParam.a(context);
            } catch (Exception unused2) {
                this.b = null;
            }
            try {
                this.c = com.baidu.android.bbalbs.common.util.b.b(context);
            } catch (Exception unused3) {
                this.c = null;
            }
            try {
                d = context.getPackageName();
            } catch (Exception unused4) {
                d = null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(this.b);
            j.o = stringBuilder.toString();
            this.j = true;
        }
    }

    public void a(String str, String str2) {
        e = str;
        d = str2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x002f in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public java.lang.String b() {
        /*
        r2 = this;
        r0 = r2.b;
        if (r0 == 0) goto L_0x0022;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "v7.62|";
        r0.append(r1);
        r1 = r2.b;
        r0.append(r1);
        r1 = "|";
        r0.append(r1);
        r1 = android.os.Build.MODEL;
        r0.append(r1);
        r0 = r0.toString();
        return r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "v7.62|";
        r0.append(r1);
        r1 = r2.a;
        goto L_0x0010;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.g.b.b():java.lang.String");
    }

    public String c() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.b != null) {
            stringBuffer.append("&cu=");
            str = this.b;
        } else {
            stringBuffer.append("&im=");
            str = this.a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(d);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.62f);
        return stringBuffer.toString();
    }

    public String d() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.b == null) {
            stringBuffer.append("&im=");
            str = this.a;
        } else {
            stringBuffer.append("&cu=");
            str = this.b;
        }
        stringBuffer.append(str);
        stringBuffer.append("&sdk=");
        stringBuffer.append(7.62f);
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&stp=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        stringBuffer.append("&prod=");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append(":");
        stringBuilder.append(d);
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append(j.e(f.getServiceContext()));
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        return stringBuffer.toString();
    }
}
