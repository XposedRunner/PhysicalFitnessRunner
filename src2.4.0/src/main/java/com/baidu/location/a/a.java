package com.baidu.location.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.e.e;
import com.baidu.location.e.i;
import com.baidu.location.f;
import com.baidu.location.g.j;
import com.baidu.location.indoor.g;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {
    public static long c;
    private static a e;
    public boolean a;
    boolean b;
    int d;
    private ArrayList<a> f;
    private boolean g;
    private BDLocation h;
    private BDLocation i;
    private BDLocation j;
    private boolean k;
    private boolean l;
    private b m;

    private class a {
        public String a = null;
        public Messenger b = null;
        public LocationClientOption c = new LocationClientOption();
        public int d;

        public a(Message message) {
            boolean z = false;
            this.d = 0;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.g.b.a().a(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            boolean z2 = j.m || this.c.enableSimulateGps;
            j.m = z2;
            if (!j.g.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL)) {
                j.g = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt("priority");
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            z2 = j.i || this.c.isNeedNewVersionRgc;
            j.i = z2;
            z2 = j.h || message.getData().getBoolean("isneedaptag", false);
            j.h = z2;
            z2 = j.j || message.getData().getBoolean("isneedaptagd", false);
            j.j = z2;
            j.R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wifitimeout", ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            if (i < j.af) {
                j.af = i;
            }
            i = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i >= j.W) {
                j.W = i;
            }
            i = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i >= j.Y) {
                j.Y = i;
            }
            int i2 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i2 >= j.X) {
                j.X = i2;
            }
            if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
                o.a().a(this.c.mIsNeedDeviceDirect);
                o.a().b();
            }
            if (a.this.b || this.c.isNeedAltitude) {
                z = true;
            }
            a.this.b = z;
        }

        private void a(int i) {
            Message obtain = Message.obtain(null, i);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        public void a() {
            a(111);
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (g.a().e()) {
                bDLocation2.setIndoorLocMode(true);
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (!(this.c.coorType == null || this.c.coorType.equals(CoordinateType.GCJ02))) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (!(longitude == Double.MIN_VALUE || latitude == Double.MIN_VALUE)) {
                    String str;
                    double[] coorEncrypt;
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.GCJ02)) || bDLocation2.getCoorType() == null) {
                        coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = this.c.coorType;
                    } else if (!(bDLocation2.getCoorType() == null || !bDLocation2.getCoorType().equals(CoordinateType.WGS84) || this.c.coorType.equals("bd09ll"))) {
                        coorEncrypt = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(coorEncrypt[0]);
                        bDLocation2.setLatitude(coorEncrypt[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
            }
            a(i, "locStr", bDLocation2);
        }

        public void b() {
            if (this.c.location_change_notify) {
                a(j.b ? 54 : 55);
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ a a;
        private int b;
        private boolean c;

        public void run() {
            if (!this.c) {
                this.b++;
                this.a.l = false;
            }
        }
    }

    private a() {
        this.f = null;
        this.g = false;
        this.a = false;
        this.b = false;
        this.h = null;
        this.i = null;
        this.d = 0;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = null;
        this.f = new ArrayList();
    }

    private a a(Messenger messenger) {
        if (this.f == null) {
            return null;
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.b.equals(messenger)) {
                return aVar;
            }
        }
        return null;
    }

    public static a a() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:8:0x0019 in {1, 4, 6, 7} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private void a(com.baidu.location.a.a.a r2) {
        /*
        r1 = this;
        if (r2 != 0) goto L_0x0003;
        return;
        r0 = r2.b;
        r0 = r1.a(r0);
        if (r0 == 0) goto L_0x0011;
        r0 = 14;
        r2.a(r0);
        return;
        r0 = r1.f;
        r0.add(r2);
        r0 = 13;
        goto L_0x000d;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.a.a(com.baidu.location.a.a$a):void");
    }

    private void b(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.g.b.d);
        intent.putExtra("tag", "state");
        f.getServiceContext().sendBroadcast(intent);
    }

    private void f() {
        g();
        e();
    }

    private void g() {
        Iterator it = this.f.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.c.openGps) {
                z2 = true;
            }
            if (aVar.c.location_change_notify) {
                z = true;
            }
        }
        j.a = z;
        if (this.g != z2) {
            this.g = z2;
            e.a().a(this.g);
        }
    }

    public void a(Bundle bundle, int i) {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            try {
                a aVar = (a) it.next();
                aVar.a(i, bundle);
                if (aVar.d > 4) {
                    it.remove();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public void a(Message message) {
        if (message != null && message.replyTo != null) {
            c = System.currentTimeMillis();
            this.a = true;
            i.a().b();
            a(new a(message));
            f();
            if (this.k) {
                b("start");
                this.d = 0;
            }
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    public void a(String str) {
        c(new BDLocation(str));
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void b() {
        this.f.clear();
        this.h = null;
        f();
    }

    public void b(Message message) {
        a a = a(message.replyTo);
        if (a != null) {
            this.f.remove(a);
        }
        o.a().c();
        f();
        if (this.k) {
            b("stop");
            this.d = 0;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x0032=Splitter:B:10:0x0032, B:32:0x0099=Splitter:B:32:0x0099} */
    public void b(com.baidu.location.BDLocation r14) {
        /*
        r13 = this;
        r0 = 61;
        r1 = 66;
        r2 = 4;
        r3 = 0;
        r4 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        if (r14 == 0) goto L_0x004b;
    L_0x000a:
        r5 = r14.getLocType();
        if (r5 != r4) goto L_0x004b;
    L_0x0010:
        r5 = com.baidu.location.a.j.a();
        r5 = r5.b();
        if (r5 != 0) goto L_0x004b;
    L_0x001a:
        r5 = r13.i;
        if (r5 != 0) goto L_0x002c;
    L_0x001e:
        r5 = new com.baidu.location.BDLocation;
        r5.<init>();
        r13.i = r5;
        r5 = r13.i;
        r6 = 505; // 0x1f9 float:7.08E-43 double:2.495E-321;
        r5.setLocType(r6);
    L_0x002c:
        r5 = r13.f;
        r5 = r5.iterator();
    L_0x0032:
        r6 = r5.hasNext();	 Catch:{ Exception -> 0x00b0 }
        if (r6 == 0) goto L_0x00b0;
    L_0x0038:
        r6 = r5.next();	 Catch:{ Exception -> 0x00b0 }
        r6 = (com.baidu.location.a.a.a) r6;	 Catch:{ Exception -> 0x00b0 }
        r7 = r13.i;	 Catch:{ Exception -> 0x00b0 }
        r6.a(r7);	 Catch:{ Exception -> 0x00b0 }
        r6 = r6.d;	 Catch:{ Exception -> 0x00b0 }
        if (r6 <= r2) goto L_0x0032;
    L_0x0047:
        r5.remove();	 Catch:{ Exception -> 0x00b0 }
        goto L_0x0032;
    L_0x004b:
        r5 = r14.hasAltitude();
        if (r5 != 0) goto L_0x0082;
    L_0x0051:
        r5 = r13.b;
        if (r5 == 0) goto L_0x0082;
    L_0x0055:
        r5 = r14.getLocType();
        if (r5 == r4) goto L_0x0061;
    L_0x005b:
        r5 = r14.getLocType();
        if (r5 != r1) goto L_0x0082;
    L_0x0061:
        r5 = com.baidu.location.b.a.a();
        r6 = r14.getLongitude();
        r8 = r14.getLatitude();
        r5 = r5.a(r6, r8);
        r6 = r5[r3];
        com.baidu.location.b.a.a();
        r8 = 4666722622711529472; // 0x40c3878000000000 float:0.0 double:9999.0;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 >= 0) goto L_0x0082;
    L_0x007f:
        r14.setAltitude(r6);
    L_0x0082:
        r5 = r14.getLocType();
        if (r5 != r0) goto L_0x0093;
    L_0x0088:
        r5 = com.baidu.location.b.a.a();
        r5 = r5.a(r14);
        r14.setGpsAccuracyStatus(r5);
    L_0x0093:
        r5 = r13.f;
        r5 = r5.iterator();
    L_0x0099:
        r6 = r5.hasNext();	 Catch:{ Exception -> 0x00b0 }
        if (r6 == 0) goto L_0x00b0;
    L_0x009f:
        r6 = r5.next();	 Catch:{ Exception -> 0x00b0 }
        r6 = (com.baidu.location.a.a.a) r6;	 Catch:{ Exception -> 0x00b0 }
        r6.a(r14);	 Catch:{ Exception -> 0x00b0 }
        r6 = r6.d;	 Catch:{ Exception -> 0x00b0 }
        if (r6 <= r2) goto L_0x0099;
    L_0x00ac:
        r5.remove();	 Catch:{ Exception -> 0x00b0 }
        goto L_0x0099;
    L_0x00b0:
        r2 = com.baidu.location.a.l.g;
        if (r2 == 0) goto L_0x00b6;
    L_0x00b4:
        com.baidu.location.a.l.g = r3;
    L_0x00b6:
        r5 = com.baidu.location.g.j.W;
        r6 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r5 < r6) goto L_0x0109;
    L_0x00bc:
        r5 = r14.getLocType();
        if (r5 == r0) goto L_0x00ce;
    L_0x00c2:
        r0 = r14.getLocType();
        if (r0 == r4) goto L_0x00ce;
    L_0x00c8:
        r0 = r14.getLocType();
        if (r0 != r1) goto L_0x0109;
    L_0x00ce:
        r0 = r13.h;
        if (r0 == 0) goto L_0x0102;
    L_0x00d2:
        r0 = 1;
        r0 = new float[r0];
        r1 = r13.h;
        r4 = r1.getLatitude();
        r1 = r13.h;
        r6 = r1.getLongitude();
        r8 = r14.getLatitude();
        r10 = r14.getLongitude();
        r12 = r0;
        android.location.Location.distanceBetween(r4, r6, r8, r10, r12);
        r0 = r0[r3];
        r1 = com.baidu.location.g.j.Y;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 > 0) goto L_0x00f9;
    L_0x00f6:
        if (r2 != 0) goto L_0x00f9;
    L_0x00f8:
        return;
    L_0x00f9:
        r0 = 0;
        r13.h = r0;
        r0 = new com.baidu.location.BDLocation;
        r0.<init>(r14);
        goto L_0x0107;
    L_0x0102:
        r0 = new com.baidu.location.BDLocation;
        r0.<init>(r14);
    L_0x0107:
        r13.h = r0;
    L_0x0109:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.a.b(com.baidu.location.BDLocation):void");
    }

    public void c() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public void c(BDLocation bDLocation) {
        Address a = l.c().a(bDLocation);
        String f = l.c().f();
        List g = l.c().g();
        if (a != null) {
            bDLocation.setAddr(a);
        }
        if (f != null) {
            bDLocation.setLocationDescribe(f);
        }
        if (g != null) {
            bDLocation.setPoiList(g);
        }
        if (g.a().f() && g.a().g() != null) {
            bDLocation.setFloor(g.a().g());
            bDLocation.setIndoorLocMode(true);
            if (g.a().h() != null) {
                bDLocation.setBuildingID(g.a().h());
            }
        }
        a(bDLocation);
        l.c().c(bDLocation);
    }

    public boolean c(Message message) {
        a a = a(message.replyTo);
        boolean z = false;
        if (a == null) {
            return false;
        }
        int i = a.c.scanSpan;
        a.c.scanSpan = message.getData().getInt("scanSpan", a.c.scanSpan);
        if (a.c.scanSpan < 1000) {
            o.a().c();
            this.a = false;
        } else {
            this.a = true;
        }
        if (a.c.scanSpan > 999 && i < 1000) {
            if (a.c.mIsNeedDeviceDirect || a.c.isNeedAltitude) {
                o.a().a(a.c.mIsNeedDeviceDirect);
                o.a().b();
            }
            if (this.b || a.c.isNeedAltitude) {
                z = true;
            }
            this.b = z;
            z = true;
        }
        a.c.openGps = message.getData().getBoolean("openGPS", a.c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = a.c;
        if (string == null || string.equals("")) {
            string = a.c.coorType;
        }
        locationClientOption.coorType = string;
        string = message.getData().getString("addrType");
        locationClientOption = a.c;
        if (string == null || string.equals("")) {
            string = a.c.addrType;
        }
        locationClientOption.addrType = string;
        if (!j.g.equals(a.c.addrType)) {
            l.c().j();
        }
        a.c.timeOut = message.getData().getInt("timeOut", a.c.timeOut);
        a.c.location_change_notify = message.getData().getBoolean("location_change_notify", a.c.location_change_notify);
        a.c.priority = message.getData().getInt("priority", a.c.priority);
        int i2 = message.getData().getInt("wifitimeout", ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        if (i2 < j.af) {
            j.af = i2;
        }
        f();
        return z;
    }

    /* JADX WARNING: Missing block: B:12:0x001a, code skipped:
            return 1;
     */
    public int d(android.os.Message r3) {
        /*
        r2 = this;
        r0 = 1;
        if (r3 == 0) goto L_0x001a;
    L_0x0003:
        r1 = r3.replyTo;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r3 = r3.replyTo;
        r3 = r2.a(r3);
        if (r3 == 0) goto L_0x001a;
    L_0x0010:
        r1 = r3.c;
        if (r1 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r3 = r3.c;
        r3 = r3.priority;
        return r3;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.a.d(android.os.Message):int");
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&prod=");
            stringBuilder.append(com.baidu.location.g.b.e);
            stringBuilder.append(":");
            stringBuilder.append(com.baidu.location.g.b.d);
            return stringBuilder.toString();
        }
        a aVar = (a) this.f.get(0);
        if (aVar.c.prodName != null) {
            stringBuffer.append(aVar.c.prodName);
        }
        if (aVar.a != null) {
            stringBuffer.append(":");
            stringBuffer.append(aVar.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2 == null || stringBuffer2.equals("")) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("&prod=");
        stringBuilder2.append(stringBuffer2);
        return stringBuilder2.toString();
    }

    /* JADX WARNING: Missing block: B:12:0x001b, code skipped:
            return 1000;
     */
    public int e(android.os.Message r3) {
        /*
        r2 = this;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r3 == 0) goto L_0x001b;
    L_0x0004:
        r1 = r3.replyTo;
        if (r1 != 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r3 = r3.replyTo;
        r3 = r2.a(r3);
        if (r3 == 0) goto L_0x001b;
    L_0x0011:
        r1 = r3.c;
        if (r1 != 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r3 = r3.c;
        r3 = r3.scanSpan;
        return r3;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.a.e(android.os.Message):int");
    }

    public void e() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
    }
}
