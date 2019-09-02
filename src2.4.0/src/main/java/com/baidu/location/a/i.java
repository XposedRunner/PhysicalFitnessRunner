package com.baidu.location.a;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.e.h;
import com.baidu.location.f;
import com.baidu.location.g.e;
import com.baidu.location.g.j;
import com.zjwh.android_wh_physicalfitness.utils.O000OO;
import java.util.HashMap;
import java.util.Locale;

public abstract class i {
    public static String c;
    public h a = null;
    public com.baidu.location.e.a b = null;
    final Handler d = new a();
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    private String h = null;
    private String i = null;

    public class a extends Handler {
        public void handleMessage(Message message) {
            if (f.isServing) {
                int i = message.what;
                if (i != 21) {
                    switch (i) {
                        case 62:
                        case 63:
                            i.this.a();
                            return;
                        default:
                            return;
                    }
                }
                i.this.a(message);
            }
        }
    }

    class b extends e {
        String a;
        String b;

        public b() {
            this.a = null;
            this.b = null;
            this.k = new HashMap();
        }

        public void a() {
            this.h = j.d();
            if (!((!j.h && !j.j) || i.this.h == null || i.this.i == null)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[]{i.this.h, i.this.i}));
                this.b = stringBuilder.toString();
            }
            String encodeTp4 = Jni.encodeTp4(this.b);
            this.b = null;
            if (this.a == null) {
                this.a = w.b();
            }
            this.k.put("bloc", encodeTp4);
            if (this.a != null) {
                this.k.put("up", this.a);
            }
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        public void a(String str) {
            this.b = str;
            c(j.f);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:? A:{SYNTHETIC, RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0093  */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0041 */
        /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
        /* JADX WARNING: Missing block: B:14:?, code skipped:
            r1 = new com.baidu.location.BDLocation();
            r1.setLocType(0);
     */
        public void a(boolean r7) {
            /*
            r6 = this;
            r0 = 63;
            if (r7 == 0) goto L_0x0080;
        L_0x0004:
            r7 = r6.j;
            if (r7 == 0) goto L_0x0080;
        L_0x0008:
            r7 = r6.j;	 Catch:{ Exception -> 0x0080 }
            com.baidu.location.a.i.c = r7;	 Catch:{ Exception -> 0x0080 }
            r1 = new com.baidu.location.BDLocation;	 Catch:{ Exception -> 0x0041 }
            r1.<init>(r7);	 Catch:{ Exception -> 0x0041 }
            r2 = r1.getLocType();	 Catch:{ Exception -> 0x0041 }
            r3 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            if (r2 != r3) goto L_0x0020;
        L_0x0019:
            r2 = com.baidu.location.a.h.a();	 Catch:{ Exception -> 0x0041 }
            r2.a(r7);	 Catch:{ Exception -> 0x0041 }
        L_0x0020:
            r7 = com.baidu.location.e.b.a();	 Catch:{ Exception -> 0x0041 }
            r7 = r7.h();	 Catch:{ Exception -> 0x0041 }
            r1.setOperators(r7);	 Catch:{ Exception -> 0x0041 }
            r7 = com.baidu.location.a.o.a();	 Catch:{ Exception -> 0x0041 }
            r7 = r7.d();	 Catch:{ Exception -> 0x0041 }
            if (r7 == 0) goto L_0x004a;
        L_0x0035:
            r7 = com.baidu.location.a.o.a();	 Catch:{ Exception -> 0x0041 }
            r7 = r7.e();	 Catch:{ Exception -> 0x0041 }
            r1.setDirection(r7);	 Catch:{ Exception -> 0x0041 }
            goto L_0x004a;
        L_0x0041:
            r1 = new com.baidu.location.BDLocation;	 Catch:{ Exception -> 0x0080 }
            r1.<init>();	 Catch:{ Exception -> 0x0080 }
            r7 = 0;
            r1.setLocType(r7);	 Catch:{ Exception -> 0x0080 }
        L_0x004a:
            r7 = 0;
            r6.a = r7;	 Catch:{ Exception -> 0x0080 }
            r7 = r1.getLocType();	 Catch:{ Exception -> 0x0080 }
            if (r7 != 0) goto L_0x0075;
        L_0x0053:
            r2 = r1.getLatitude();	 Catch:{ Exception -> 0x0080 }
            r4 = 1;
            r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r7 != 0) goto L_0x0075;
        L_0x005d:
            r2 = r1.getLongitude();	 Catch:{ Exception -> 0x0080 }
            r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r7 != 0) goto L_0x0075;
        L_0x0065:
            r7 = com.baidu.location.a.i.this;	 Catch:{ Exception -> 0x0080 }
            r7 = r7.d;	 Catch:{ Exception -> 0x0080 }
            r7 = r7.obtainMessage(r0);	 Catch:{ Exception -> 0x0080 }
            r1 = "HttpStatus error";
        L_0x006f:
            r7.obj = r1;	 Catch:{ Exception -> 0x0080 }
            r7.sendToTarget();	 Catch:{ Exception -> 0x0080 }
            goto L_0x008f;
        L_0x0075:
            r7 = com.baidu.location.a.i.this;	 Catch:{ Exception -> 0x0080 }
            r7 = r7.d;	 Catch:{ Exception -> 0x0080 }
            r2 = 21;
            r7 = r7.obtainMessage(r2);	 Catch:{ Exception -> 0x0080 }
            goto L_0x006f;
        L_0x0080:
            r7 = com.baidu.location.a.i.this;
            r7 = r7.d;
            r7 = r7.obtainMessage(r0);
            r0 = "HttpStatus error";
            r7.obj = r0;
            r7.sendToTarget();
        L_0x008f:
            r7 = r6.k;
            if (r7 == 0) goto L_0x0098;
        L_0x0093:
            r7 = r6.k;
            r7.clear();
        L_0x0098:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.i$b.a(boolean):void");
        }
    }

    public String a(String str) {
        if (this.h == null) {
            this.h = j.b(f.getServiceContext());
        }
        if (this.i == null) {
            this.i = j.c(f.getServiceContext());
        }
        if (this.b == null || !this.b.a()) {
            this.b = com.baidu.location.e.b.a().f();
        }
        if (this.a == null || !this.a.j()) {
            this.a = com.baidu.location.e.i.a().p();
        }
        Location h = com.baidu.location.e.e.a().j() ? com.baidu.location.e.e.a().h() : null;
        if ((this.b == null || this.b.d() || this.b.c()) && ((this.a == null || this.a.a() == 0) && h == null)) {
            return null;
        }
        StringBuilder stringBuilder;
        str = b();
        if (h.a().d() == -2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("&imo=1");
            str = stringBuilder2.toString();
        }
        int c = j.c(f.getServiceContext());
        if (c >= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("&lmd=");
            stringBuilder.append(c);
            str = stringBuilder.toString();
        }
        if (this.a == null || this.a.a() == 0) {
            String m = com.baidu.location.e.i.a().m();
            if (m != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(m);
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
        }
        String str2 = str;
        if (!this.f) {
            return j.a(this.b, this.a, h, str2, 0);
        }
        this.f = false;
        return j.a(this.b, this.a, h, str2, 0, true);
    }

    public abstract void a();

    public abstract void a(Message message);

    public String b() {
        String str;
        String c;
        String d = a.a().d();
        if (com.baidu.location.e.i.j()) {
            str = "&cn=32";
        } else {
            str = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(com.baidu.location.e.b.a().e())});
        }
        if (VERSION.SDK_INT >= 18) {
            c = j.c();
            if (!TextUtils.isEmpty(c)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("&qcip6c=");
                stringBuilder.append(c);
                str = stringBuilder.toString();
            }
        }
        if (this.e) {
            this.e = false;
            c = com.baidu.location.e.i.a().r();
            if (!(TextUtils.isEmpty(c) || c.equals(O000OO.O000000o))) {
                c = c.replace(":", "");
                str = String.format(Locale.CHINA, "%s&mac=%s", new Object[]{str, c});
            }
            int i = VERSION.SDK_INT;
        } else if (!this.g) {
            String e = w.e();
            if (e != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(e);
                str = stringBuilder2.toString();
            }
            this.g = true;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(d);
        return stringBuilder3.toString();
    }
}
