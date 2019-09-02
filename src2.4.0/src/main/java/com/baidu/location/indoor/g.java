package com.baidu.location.indoor;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Jni;
import com.baidu.location.a.o;
import com.baidu.location.g.j;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class g {
    private static g h;
    private String A;
    private String B;
    private int C;
    private int D;
    private c<String> E;
    private int F;
    private c<String> G;
    private double H;
    private double I;
    private double J;
    private boolean K;
    private boolean L;
    private List<h> M;
    private int N;
    private int O;
    private int P;
    private a Q;
    private String R;
    private d S;
    private boolean T;
    private q U;
    private com.baidu.location.indoor.q.a V;
    private com.baidu.location.indoor.mapversion.a.a W;
    private int X;
    private BDLocation Y;
    private boolean Z;
    public d a;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private c ad;
    private e ae;
    private f af;
    private b ag;
    public SimpleDateFormat b;
    private int c;
    private boolean d;
    private int e;
    private boolean f;
    private BDLocationListener g;
    private long i;
    private volatile boolean j;
    private n k;
    private g l;
    private i m;
    private long n;
    private boolean o;
    private boolean p;
    private long q;
    private int r;
    private String s;
    private com.baidu.location.indoor.n.a t;
    private int u;
    private int v;
    private String w;
    private String x;
    private m y;
    private String z;

    class a {
    }

    class b {
        public String a;
        public int b;
        public String c;
        private ArrayList<Double> e;
        private ArrayList<String> f;
        private Map<String, Double> g;
        private int h;
        private Map<String, Integer> i;

        public b() {
            this.a = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = 0;
            this.b = 0;
            this.c = null;
            this.i = null;
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.i = new HashMap();
        }

        private int a(BDLocation bDLocation) {
            if (!bDLocation.getBuildingID().equals(this.c)) {
                this.c = bDLocation.getBuildingID();
                a();
            }
            if (b(bDLocation.getRetFields("p_floor")) != 0) {
                this.b = 0;
                return 1;
            }
            try {
                if (this.f.size() == 0) {
                    for (Entry entry : this.g.entrySet()) {
                        this.f.add(entry.getKey());
                        this.e.add(entry.getValue());
                    }
                } else {
                    Double d;
                    int i;
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = this.f.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                        arrayList2.add(Double.valueOf(0.0d));
                    }
                    HashMap hashMap = new HashMap();
                    for (Entry entry2 : this.g.entrySet()) {
                        String str = (String) entry2.getKey();
                        d = (Double) entry2.getValue();
                        hashMap.put(str, d);
                        if (!this.f.contains(str)) {
                            arrayList.add(str);
                            arrayList2.add(d);
                        }
                    }
                    double d2 = 0.0d;
                    for (Double doubleValue : this.g.values()) {
                        d2 += doubleValue.doubleValue();
                    }
                    for (i = 0; i < arrayList.size(); i++) {
                        arrayList2.set(i, hashMap.containsKey(arrayList.get(i)) ? hashMap.get(arrayList.get(i)) : Double.valueOf((1.0d - d2) / ((double) (this.h - hashMap.size()))));
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (i = 0; i < arrayList.size(); i++) {
                        arrayList3.add(Double.valueOf(0.0d));
                    }
                    for (i = 0; i < this.f.size(); i++) {
                        d = (Double) this.e.get(i);
                        ArrayList a = a(arrayList, (String) this.f.get(i));
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            arrayList3.set(i2, Double.valueOf(((Double) arrayList3.get(i2)).doubleValue() + ((d.doubleValue() * ((Double) a.get(i2)).doubleValue()) * ((Double) arrayList2.get(i2)).doubleValue())));
                        }
                    }
                    this.f = arrayList;
                    this.e = a(arrayList3);
                }
                String str2 = null;
                double d3 = 0.0d;
                for (int i3 = 0; i3 < this.f.size(); i3++) {
                    if (((Double) this.e.get(i3)).doubleValue() > d3) {
                        d3 = ((Double) this.e.get(i3)).doubleValue();
                        str2 = (String) this.f.get(i3);
                    }
                }
                this.a = str2;
            } catch (Exception unused) {
                this.b = 0;
            }
            this.b = 1;
            return 0;
        }

        private int a(String str) {
            if (this.i.containsKey(str)) {
                return ((Integer) this.i.get(str)).intValue();
            }
            int i = 1000;
            try {
                if (!str.startsWith("F")) {
                    if (!str.startsWith("f")) {
                        if (str.startsWith("B") || str.startsWith("b")) {
                            i = -Integer.parseInt(str.substring(1));
                        }
                        this.i.put(str, Integer.valueOf(i));
                        return i;
                    }
                }
                i = Integer.parseInt(str.substring(1)) - 1;
            } catch (Exception unused) {
            }
            this.i.put(str, Integer.valueOf(i));
            return i;
        }

        private ArrayList<Double> a(ArrayList<Double> arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Double valueOf = Double.valueOf(0.0d);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                valueOf = Double.valueOf(valueOf.doubleValue() + ((Double) it.next()).doubleValue());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Double.valueOf(((Double) it2.next()).doubleValue() / valueOf.doubleValue()));
            }
            return arrayList2;
        }

        private ArrayList<Double> a(ArrayList<String> arrayList, String str) {
            ArrayList arrayList2 = new ArrayList();
            double[] dArr = new double[]{180.0d, 10.0d, 1.0d};
            int a = a(str);
            Iterator it;
            if (a == 1000) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Double.valueOf(((String) it.next()).equals(str) ? dArr[0] : dArr[2]));
                }
                return arrayList2;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                int a2 = a((String) it.next());
                a2 = a2 == 1000 ? 2 : a > a2 ? a - a2 : a2 - a;
                if (a2 > 2) {
                    a2 = 2;
                }
                arrayList2.add(Double.valueOf(dArr[a2]));
            }
            return arrayList2;
        }

        private void a() {
            this.e.clear();
            this.f.clear();
            this.i.clear();
        }

        private int b(String str) {
            try {
                String[] split = str.split(";");
                if (split.length <= 1) {
                    return 1;
                }
                this.h = Integer.parseInt(split[0]);
                this.g = new HashMap();
                for (int i = 1; i < split.length; i++) {
                    String[] split2 = split[i].split(":");
                    this.g.put(split2[0], Double.valueOf(Double.parseDouble(split2[1])));
                }
                return 0;
            } catch (Exception unused) {
                return 1;
            }
        }

        private String b() {
            return this.a;
        }
    }

    class c {
        public ArrayList<ArrayList<Float>> a = null;
        public double[] b = null;
        private float d = -0.18181887f;
        private float e = -0.90904963f;
        private float f = -0.55321634f;
        private float g = -0.05259979f;
        private float h = 24.0f;
        private float i = 8.61f;
        private float j = 4.25f;
        private float k = 60.39f;
        private float l = 15.6f;
        private float m = 68.07f;
        private float n = 11.61f;

        public double a(double d, double d2, double d3, double d4) {
            double[] a = a(d2, d3);
            double abs = Math.abs(d4 - a[0]);
            return abs > 2.0d * a[1] ? d + abs : d;
        }

        public boolean a(int i, double d, double d2) {
            return (((double) (this.d + (((((float) i) - this.i) / this.j) * this.e))) + (((d - ((double) this.k)) / ((double) this.l)) * ((double) this.f))) + (((d2 - ((double) this.m)) / ((double) this.n)) * ((double) this.g)) > 0.0d;
        }

        public boolean a(ArrayList<ArrayList<Float>> arrayList) {
            int i = 0;
            while (i < arrayList.size()) {
                if (this.a == null) {
                    return false;
                }
                int i2 = 0;
                int i3 = i2;
                while (i2 < this.a.size()) {
                    ArrayList arrayList2 = (ArrayList) this.a.get(i2);
                    if (arrayList2.size() > 0 && arrayList2.equals(arrayList.get(i))) {
                        i3 = true;
                    }
                    i2++;
                }
                if (i3 == 0) {
                    return false;
                }
                i++;
            }
            return true;
        }

        public double[] a(double d, double d2) {
            return com.baidu.location.b.a.a().a(d, d2);
        }

        public boolean b(ArrayList<ArrayList<Float>> arrayList) {
            boolean a;
            int size = arrayList.size();
            List list = com.baidu.location.e.i.a().q().a;
            if (list != null) {
                double d;
                double d2 = 10000.0d;
                if (list.size() >= 3) {
                    d = (double) (-((ScanResult) list.get(0)).level);
                    d2 = ((double) (((-((ScanResult) list.get(0)).level) - ((ScanResult) list.get(1)).level) - ((ScanResult) list.get(2)).level)) / 3.0d;
                } else {
                    d = 10000.0d;
                }
                a = a(size, d, d2);
            } else {
                a = false;
            }
            boolean a2 = a(arrayList);
            this.a = arrayList;
            return (a || a2) ? false : true;
        }
    }

    public class d extends Handler {
        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                int i = message.what;
                if (i == 21) {
                    g.this.a(message);
                } else if (i == 41) {
                    g.this.k();
                } else if (i != SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM) {
                    super.dispatchMessage(message);
                } else {
                    g.this.a((BDLocation) message.obj);
                }
            }
        }
    }

    class e {
        private double b = -1.0d;
        private long c = 0;
        private long d = 0;
        private long e = 0;
        private long f = 0;
        private long g = 0;
        private long h = 0;
        private long i = 0;
        private long j = 0;
        private long k = 0;
        private double l = 0.0d;
        private double m = 0.0d;
        private double n = 0.0d;
        private double o = 0.0d;
        private int p = 0;
        private int q = 0;
        private com.baidu.location.e.h r = null;
        private long s = 0;
        private int t = 0;
        private int u = 0;

        private void a() {
            this.b = -1.0d;
            this.c = 0;
            this.d = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0.0d;
            this.m = 0.0d;
            this.p = 0;
            this.q = 0;
            this.r = null;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            this.e = 0;
        }

        private void a(double d, double d2, double d3, long j) {
            this.j = j;
            this.u = 0;
        }

        private void a(Location location, boolean z) {
            this.k = System.currentTimeMillis();
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            if (this.l != 0.0d) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.m, this.l, latitude, longitude, fArr);
                if (fArr[0] < 20.0f) {
                    this.p++;
                } else {
                    this.p = 0;
                }
                if (fArr[0] < 5.0f) {
                    this.q++;
                } else {
                    this.q = 0;
                }
            }
            this.l = longitude;
            this.m = latitude;
            if (location.hasSpeed() && location.getSpeed() > 3.0f) {
                this.h = System.currentTimeMillis();
            }
            if (location.getAccuracy() >= 10.0f || z) {
                this.t = 0;
            } else {
                this.t++;
            }
        }

        private boolean a(double d, double d2, double d3) {
            if (!g.this.ae.c()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f != 0 && currentTimeMillis - this.f > 10000) {
                return true;
            }
            if (this.q >= 5 && d3 < 15.0d && currentTimeMillis - this.c > 20000) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.o, this.n, d2, d, fArr);
                if (fArr[0] > 30.0f) {
                    return true;
                }
            }
            return false;
        }

        private boolean a(BDLocation bDLocation, double d, String str) {
            long currentTimeMillis = System.currentTimeMillis();
            this.i = currentTimeMillis;
            this.b = d;
            this.n = bDLocation.getLongitude();
            this.o = bDLocation.getLatitude();
            if (str.equals("wifi")) {
                this.c = currentTimeMillis;
            }
            if (str.equals("gps")) {
                this.e = currentTimeMillis;
            }
            if (e()) {
                this.f = currentTimeMillis;
            }
            g.this.d = g.this.a(bDLocation.getLongitude(), bDLocation.getLatitude());
            if (g.this.d || g.this.c == 1) {
                this.g = currentTimeMillis;
            }
            return (this.s == 0 || currentTimeMillis - this.s <= StatisticConfig.MIN_UPLOAD_INTERVAL || currentTimeMillis - this.j >= 10000 || currentTimeMillis - this.k >= 10000) ? (this.t <= 10 || currentTimeMillis - this.c <= StatisticConfig.MIN_UPLOAD_INTERVAL) ? (currentTimeMillis - this.g <= 10000 || currentTimeMillis - this.c <= StatisticConfig.MIN_UPLOAD_INTERVAL) ? this.f == 0 || currentTimeMillis - this.f <= 60000 : false : false : false;
        }

        private boolean b() {
            System.currentTimeMillis();
            if (g.this.o || this.p < 3 || (!com.baidu.location.e.i.a().h().contains("&wifio") && g.this.c != 1)) {
                return false;
            }
            this.u = 1;
            return true;
        }

        private boolean c() {
            long currentTimeMillis = System.currentTimeMillis();
            return (currentTimeMillis - this.h >= 10000 || currentTimeMillis - this.c <= StatisticConfig.MIN_UPLOAD_INTERVAL) ? currentTimeMillis - this.k >= 10000 || this.j == 0 || currentTimeMillis - this.j <= 16000 || currentTimeMillis - this.c <= StatisticConfig.MIN_UPLOAD_INTERVAL : false;
        }

        private void d() {
            com.baidu.location.e.h q = com.baidu.location.e.i.a().q();
            if (q.a != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.r == null || !q.b(this.r)) {
                    if (currentTimeMillis - this.s < 10000) {
                        this.d = currentTimeMillis;
                    }
                    this.s = currentTimeMillis;
                    this.r = q;
                }
            }
        }

        private boolean e() {
            return (this.u != 1 && c() && this.b <= 25.0d) ? this.i == 0 || System.currentTimeMillis() - this.i <= StatisticConfig.MIN_UPLOAD_INTERVAL : false;
        }
    }

    private class f {
        public int a = 10;
        private List<a> c = Collections.synchronizedList(new ArrayList());

        private class a {
            public double a;
            public double b;
            public double c;

            public a(double d, double d2, double d3) {
                this.a = d;
                this.b = d2;
                this.c = d3;
            }
        }

        public void a(BDLocation bDLocation) {
            this.c.add(new a(bDLocation.getLongitude(), bDLocation.getLatitude(), g.this.ae.b));
        }

        public String toString() {
            if (this.c.size() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            double d = ((a) this.c.get(0)).a;
            double d2 = ((a) this.c.get(0)).b;
            double d3 = ((a) this.c.get(0)).c;
            stringBuffer.append(String.format("%.6f:%.6f:%.1f", new Object[]{Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)}));
            int size = (this.c.size() > this.a ? this.c.size() - this.a : 0) + 1;
            while (size < this.c.size()) {
                double d4 = (((a) this.c.get(size)).a - d) * 1000000.0d;
                double d5 = d;
                double d6 = (((a) this.c.get(size)).b - d2) * 1000000.0d;
                double d7 = ((a) this.c.get(size)).c;
                stringBuffer.append(String.format(";%.0f:%.0f:%.1f", new Object[]{Double.valueOf(d4), Double.valueOf(d6), Double.valueOf(d7)}));
                size++;
                int i = 0;
                d = d5;
            }
            return stringBuffer.toString();
        }
    }

    class g extends Thread {
        private volatile boolean b = true;
        private long c = 0;
        private long d = 0;

        g() {
        }

        public void run() {
            while (this.b) {
                if (g.this.c != 1 || g.this.d) {
                    g.this.i = 3000;
                } else {
                    g.this.i = 5000;
                }
                if (g.this.k.c() == 1) {
                    this.d = System.currentTimeMillis();
                }
                boolean z = System.currentTimeMillis() - this.c > 17500;
                if (System.currentTimeMillis() - this.d < 5000) {
                    if (System.currentTimeMillis() - this.c > 10000) {
                        z = true;
                    }
                    if (System.currentTimeMillis() - this.c > g.this.i) {
                        z = true;
                    }
                }
                if (z) {
                    com.baidu.location.e.i.a().i();
                    g.this.k.f();
                    this.c = System.currentTimeMillis();
                    g.this.j = false;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException unused) {
                    this.b = false;
                    return;
                }
            }
        }
    }

    private class h {
        public int a;
        public double b;
        public double c;
        public int d = 1;
        public double e;

        public h(int i, double d, double d2, double d3) {
            this.a = i;
            this.b = d;
            this.c = d2;
            this.e = d3;
        }

        public String toString() {
            if (this.c == this.e) {
                return String.format("%d:%.1f:%.2f", new Object[]{Integer.valueOf(this.d), Double.valueOf(this.c), Double.valueOf(this.b)});
            }
            return String.format("%d:%.1f:%.2f:%.1f", new Object[]{Integer.valueOf(this.d), Double.valueOf(this.c), Double.valueOf(this.b), Double.valueOf(this.e)});
        }
    }

    class i extends com.baidu.location.g.e {
        private boolean b;
        private boolean c;
        private String d;
        private String e;
        private long f;
        private a q;
        private long r;
        private long s;

        public i() {
            this.b = false;
            this.c = false;
            this.d = null;
            this.e = null;
            this.f = 0;
            this.q = null;
            this.r = 0;
            this.s = 0;
            this.k = new HashMap();
        }

        public void a() {
            this.h = j.d();
            if (g.this.x == null || g.this.y == null || !g.this.x.equals(g.this.y.a())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("&nd_idf=1&indoor_polygon=1");
                stringBuilder.append(this.d);
                this.d = stringBuilder.toString();
            }
            this.i = 1;
            String encodeTp4 = Jni.encodeTp4(this.d);
            this.d = null;
            this.k.put("bloc", encodeTp4);
            this.r = System.currentTimeMillis();
        }

        public void a(boolean z) {
            if (!z || this.j == null) {
                g.this.r = g.this.r + 1;
                g.this.X = 0;
                this.b = false;
                if (g.this.r > 40) {
                    g.this.d();
                }
            }
            try {
                String str = this.j;
                if (g.this.o) {
                    BDLocation bDLocation = new BDLocation(str);
                    if (!(bDLocation == null || bDLocation.getLocType() != BDLocation.TypeNetWorkLocation || bDLocation.getBuildingID() == null)) {
                        g.this.Y = new BDLocation(bDLocation);
                    }
                    String indoorLocationSurpportBuidlingName = bDLocation != null ? bDLocation.getIndoorLocationSurpportBuidlingName() : null;
                    if (!(indoorLocationSurpportBuidlingName == null || g.this.Q.a(indoorLocationSurpportBuidlingName))) {
                        g.this.Q.a(indoorLocationSurpportBuidlingName, null);
                    }
                    if (g.this.S != null) {
                        g.this.S.a(new l(this));
                    }
                    o.a().b(true);
                    if (!(bDLocation == null || bDLocation.getBuildingName() == null)) {
                        g.this.A = bDLocation.getBuildingName();
                    }
                    if (!(bDLocation == null || bDLocation.getFloor() == null)) {
                        g.this.q = System.currentTimeMillis();
                        this.s = System.currentTimeMillis();
                        int i = (int) (this.s - this.r);
                        if (i > 10000) {
                            g.this.X = 0;
                        } else if (i < SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY) {
                            g.this.X = 2;
                        } else {
                            g.this.X = 1;
                        }
                        if (bDLocation.getFloor().contains("-a")) {
                            g.this.K = true;
                            bDLocation.setFloor(bDLocation.getFloor().split("-")[0]);
                        } else {
                            g.this.K = false;
                        }
                        g.this.E.add(bDLocation.getFloor());
                    }
                    Message obtainMessage = g.this.a.obtainMessage(21);
                    obtainMessage.obj = bDLocation;
                    obtainMessage.sendToTarget();
                } else {
                    this.b = false;
                    return;
                }
            } catch (Exception unused) {
            }
            if (this.k != null) {
                this.k.clear();
            }
            this.b = false;
        }

        public void b() {
            if (this.b) {
                this.c = true;
                return;
            }
            StringBuffer stringBuffer = new StringBuffer(1024);
            String h = com.baidu.location.e.b.a().f().h();
            String f = com.baidu.location.e.e.a().f();
            g.this.J = 0.5d;
            com.baidu.location.e.h q = com.baidu.location.e.i.a().q();
            String a = g.this.a(q);
            if (a == null) {
                a = q.a(g.this.e, true, false);
            }
            if (a != null && a.length() >= 10) {
                if (this.e == null || !this.e.equals(a)) {
                    StringBuilder stringBuilder;
                    this.e = a;
                    this.b = true;
                    stringBuffer.append(h);
                    if (f != null) {
                        stringBuffer.append(f);
                    }
                    stringBuffer.append("&coor=gcj02");
                    stringBuffer.append("&lt=1");
                    stringBuffer.append(a);
                    if (!(g.this.k == null || g.this.O > 2 || g.this.k.h() == null)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("&idsl=");
                        stringBuilder.append(g.this.k.h());
                        stringBuffer.append(stringBuilder.toString());
                    }
                    int size = g.this.M.size();
                    stringBuffer.append(g.this.a(size));
                    g.this.N = size;
                    g.this.O = g.this.O + 1;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("&drsi=");
                    stringBuilder.append(g.this.O);
                    stringBuffer.append(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("&drc=");
                    stringBuilder.append(g.this.u);
                    stringBuffer.append(stringBuilder.toString());
                    if (!(g.this.H == 0.0d || g.this.I == 0.0d)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("&lst_idl=");
                        stringBuilder.append(String.format(Locale.CHINA, "%.5f:%.5f", new Object[]{Double.valueOf(g.this.H), Double.valueOf(g.this.I)}));
                        stringBuffer.append(stringBuilder.toString());
                    }
                    g.this.u = 0;
                    stringBuffer.append("&idpfv=1");
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("&iflxy=");
                    stringBuilder.append(g.this.af.toString());
                    stringBuffer.append(stringBuilder.toString());
                    g.this.af.c.clear();
                    if (g.this.k != null && g.this.k.g()) {
                        stringBuffer.append("&pdr2=1");
                    }
                    if (!(g.this.S == null || g.this.S.e() == null || !g.this.S.g())) {
                        stringBuffer.append("&bleand=");
                        stringBuffer.append(g.this.S.e());
                        stringBuffer.append("&bleand_et=");
                        stringBuffer.append(g.this.S.f());
                    }
                    g.this.P = g.this.P + 1;
                    if (g.this.R != null) {
                        stringBuffer.append(g.this.R);
                        g.this.R = null;
                    }
                    h = com.baidu.location.a.a.a().d();
                    if (h != null) {
                        stringBuffer.append(h);
                    }
                    stringBuffer.append(com.baidu.location.g.b.a().a(true));
                    this.d = stringBuffer.toString();
                    if (g.this.c != 1 || g.this.d || System.currentTimeMillis() - this.f >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
                        c(j.f);
                        this.f = System.currentTimeMillis();
                    }
                }
            }
        }

        /* JADX WARNING: Missing block: B:11:0x0012, code skipped:
            return;
     */
        public synchronized void c() {
            /*
            r1 = this;
            monitor-enter(r1);
            r0 = r1.b;	 Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r1);
            return;
        L_0x0007:
            r0 = r1.c;	 Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0011;
        L_0x000b:
            r0 = 0;
            r1.c = r0;	 Catch:{ all -> 0x0013 }
            r1.b();	 Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1);
            return;
        L_0x0013:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.g$i.c():void");
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x00a5 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    private g() {
        /*
        r5 = this;
        r5.<init>();
        r0 = 0;
        r5.c = r0;
        r5.d = r0;
        r1 = 32;
        r5.e = r1;
        r1 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r5.i = r1;
        r1 = 1;
        r5.j = r1;
        r2 = 0;
        r5.a = r2;
        r5.k = r2;
        r5.l = r2;
        r5.m = r2;
        r3 = 0;
        r5.n = r3;
        r5.o = r0;
        r5.p = r0;
        r5.q = r3;
        r5.r = r0;
        r5.s = r2;
        r5.u = r0;
        r5.v = r0;
        r5.w = r2;
        r5.x = r2;
        r5.y = r2;
        r5.z = r2;
        r5.A = r2;
        r5.B = r2;
        r5.C = r0;
        r3 = 3;
        r5.D = r3;
        r5.E = r2;
        r3 = 20;
        r5.F = r3;
        r5.G = r2;
        r3 = 0;
        r5.H = r3;
        r5.I = r3;
        r3 = 4600877379321698714; // 0x3fd999999999999a float:-1.5881868E-23 double:0.4;
        r5.J = r3;
        r5.K = r0;
        r5.L = r1;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1 = java.util.Collections.synchronizedList(r1);
        r5.M = r1;
        r1 = -1;
        r5.N = r1;
        r5.O = r0;
        r5.P = r0;
        r5.R = r2;
        r5.S = r2;
        r5.T = r0;
        r1 = new java.text.SimpleDateFormat;
        r3 = "yyyy-MM-dd HH:mm:ss";
        r1.<init>(r3);
        r5.b = r1;
        r1 = 2;
        r5.X = r1;
        r5.Y = r2;
        r5.Z = r0;
        r5.aa = r0;
        r5.ab = r0;
        r5.ac = r0;
        r5.ad = r2;
        r5.ae = r2;
        r5.af = r2;
        r5.ag = r2;
        r5.f = r0;
        r0 = new com.baidu.location.indoor.h;
        r0.<init>(r5);
        r5.g = r0;
        r0 = new com.baidu.location.indoor.g$d;
        r0.<init>();
        r5.a = r0;
        r0 = com.baidu.location.f.getServiceContext();	 Catch:{ Exception -> 0x00a5 }
        com.baidu.location.indoor.mapversion.c.a.a(r0);	 Catch:{ Exception -> 0x00a5 }
    L_0x00a5:
        r0 = com.baidu.location.f.getServiceContext();	 Catch:{ Exception -> 0x00ac }
        com.baidu.location.indoor.mapversion.c.c.a(r0);	 Catch:{ Exception -> 0x00ac }
    L_0x00ac:
        r0 = new com.baidu.location.indoor.q;
        r0.<init>();
        r5.U = r0;
        r0 = r5.U;
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.a(r1);
        r0 = new com.baidu.location.indoor.i;
        r0.<init>(r5);
        r5.V = r0;
        r0 = new com.baidu.location.indoor.j;
        r0.<init>(r5);
        r5.t = r0;
        r0 = new com.baidu.location.indoor.n;
        r1 = com.baidu.location.f.getServiceContext();
        r2 = r5.t;
        r0.<init>(r1, r2);
        r5.k = r0;
        r0 = new com.baidu.location.indoor.g$i;
        r0.<init>();
        r5.m = r0;
        r0 = new com.baidu.location.indoor.c;
        r1 = r5.D;
        r0.<init>(r1);
        r5.E = r0;
        r0 = new com.baidu.location.indoor.c;
        r1 = r5.F;
        r0.<init>(r1);
        r5.G = r0;
        r0 = new com.baidu.location.indoor.a;
        r1 = com.baidu.location.f.getServiceContext();
        r0.<init>(r1);
        r5.Q = r0;
        r0 = new com.baidu.location.indoor.g$c;
        r0.<init>();
        r5.ad = r0;
        r5.i();
        r0 = new com.baidu.location.indoor.g$e;
        r0.<init>();
        r5.ae = r0;
        r0 = new com.baidu.location.indoor.g$f;
        r0.<init>();
        r5.af = r0;
        r0 = new com.baidu.location.indoor.g$b;
        r0.<init>();
        r5.ag = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.g.<init>():void");
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (h == null) {
                h = new g();
            }
            gVar = h;
        }
        return gVar;
    }

    private String a(int i) {
        if (this.M.size() == 0) {
            return "&dr=0:0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&dr=");
        int i2 = 1;
        ((h) this.M.get(0)).d = 1;
        stringBuilder.append(((h) this.M.get(0)).toString());
        int i3 = ((h) this.M.get(0)).a;
        while (i2 < this.M.size() && i2 <= i) {
            ((h) this.M.get(i2)).d = ((h) this.M.get(i2)).a - i3;
            stringBuilder.append(";");
            stringBuilder.append(((h) this.M.get(i2)).toString());
            i3 = ((h) this.M.get(i2)).a;
            i2++;
        }
        return stringBuilder.toString();
    }

    private String a(com.baidu.location.e.h hVar) {
        StringBuilder stringBuilder;
        int a = hVar.a();
        if (a <= this.e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(hVar.a(this.e, true, true));
            stringBuilder.append("&aprk=0");
        } else {
            String str = "";
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < a; i++) {
                String toLowerCase = ((ScanResult) hVar.a.get(i)).BSSID.replaceAll(":", "").toLowerCase();
                if (this.Q == null || !this.Q.b(toLowerCase)) {
                    arrayList2.add(hVar.a.get(i));
                } else {
                    arrayList.add(hVar.a.get(i));
                }
            }
            if (arrayList.size() > 0) {
                str = "&aprk=3";
            }
            if (str.equals("")) {
                str = (this.Q == null || !this.Q.b()) ? "&aprk=1" : "&aprk=2";
            }
            arrayList.addAll(arrayList2);
            hVar.a = arrayList;
            String a2 = hVar.a(this.e, true, true);
            stringBuilder = new StringBuilder();
            stringBuilder.append(a2);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private void a(Message message) {
        if (this.o) {
            this.p = false;
            BDLocation bDLocation = (BDLocation) message.obj;
            if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                m();
                if (!(bDLocation.getIndoorSurpportPolygon() == null || bDLocation.getIndoorLocationSurpportBuidlingID() == null || (this.y != null && this.y.a().equals(bDLocation.getBuildingID())))) {
                    String[] split = bDLocation.getIndoorSurpportPolygon().split("\\|");
                    Location[] locationArr = new Location[split.length];
                    for (int i = 0; i < split.length; i++) {
                        String[] split2 = split[i].split(",");
                        Location location = new Location("gps");
                        location.setLatitude(Double.valueOf(split2[1]).doubleValue());
                        location.setLongitude(Double.valueOf(split2[0]).doubleValue());
                        locationArr[i] = location;
                    }
                    this.y = new m(bDLocation.getIndoorLocationSurpportBuidlingID(), locationArr);
                }
                if (this.L && this.S != null) {
                    int i2 = ((((bDLocation.getIndoorLocationSource() >> 2) & 1) == 1 ? 1 : false) == 0 || !this.S.a()) ? false : 1;
                    if (i2 != 0) {
                        this.L = false;
                        this.S.b();
                    }
                }
                this.r = 0;
                if (bDLocation.getBuildingID() != null) {
                    this.p = true;
                    bDLocation.setIndoorLocMode(true);
                    if (bDLocation.getRetFields("tp") == null || !bDLocation.getRetFields("tp").equalsIgnoreCase("ble")) {
                        this.T = false;
                    } else {
                        bDLocation.setRadius(8.0f);
                        bDLocation.setNetworkLocationType("ble");
                        this.T = true;
                    }
                    String retFields = bDLocation.getRetFields("pdr2");
                    if (!(retFields == null || !retFields.equals("1") || this.k == null)) {
                        this.k.a(true);
                    }
                    this.x = bDLocation.getBuildingID();
                    this.z = bDLocation.getBuildingName();
                    this.B = bDLocation.getNetworkLocationType();
                    this.C = bDLocation.isParkAvailable();
                    this.ag.a(bDLocation);
                    if (bDLocation.getFloor().equals(l())) {
                        if (this.w == null) {
                            this.w = bDLocation.getFloor();
                        }
                        com.baidu.location.indoor.mapversion.c.a.a().a(bDLocation.getLongitude(), bDLocation.getLatitude());
                        a(bDLocation.getBuildingName(), bDLocation.getFloor());
                        if (bDLocation.getFloor().equals(l())) {
                            if (!bDLocation.getFloor().equalsIgnoreCase(this.w) && this.ab) {
                                this.ae.a();
                                com.baidu.location.indoor.mapversion.b.a.c();
                                this.ac = com.baidu.location.indoor.mapversion.b.a.a(bDLocation.getFloor());
                            }
                            this.w = bDLocation.getFloor();
                            if (this.k != null && this.k.e() >= 0.0d && bDLocation.getDirection() <= 0.0f) {
                                bDLocation.setDirection((float) this.k.e());
                            }
                            double[] a = com.baidu.location.indoor.mapversion.b.a.a(bDLocation);
                            if (!(a == null || a[0] == -1.0d || a[0] != 0.0d)) {
                                bDLocation.setLongitude(a[1]);
                                bDLocation.setLatitude(a[2]);
                                bDLocation.setFusionLocInfo("res", a);
                                bDLocation.setRadius((float) a[5]);
                                bDLocation.setDirection((float) a[6]);
                                bDLocation.setSpeed((float) a[8]);
                                if (!this.ae.a(bDLocation, a[5], "wifi")) {
                                    d();
                                    return;
                                }
                            }
                            this.I = bDLocation.getLatitude();
                            this.H = bDLocation.getLongitude();
                        } else {
                            return;
                        }
                    }
                    return;
                }
            } else if (bDLocation.getLocType() == 63) {
                this.r++;
                if (this.r > 10) {
                    d();
                } else {
                    return;
                }
            } else {
                this.r = 0;
            }
            if (this.p) {
                if (bDLocation.getTime() == null) {
                    bDLocation.setTime(this.b.format(new Date()));
                }
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                String networkLocationType = bDLocation2.getNetworkLocationType();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(networkLocationType);
                stringBuilder.append("2");
                bDLocation2.setNetworkLocationType(stringBuilder.toString());
                if (this.U == null || !this.U.c()) {
                    a(bDLocation2, 21);
                } else {
                    this.U.a(bDLocation2);
                }
            }
            this.m.c();
        }
    }

    private void a(BDLocation bDLocation) {
    }

    private void a(BDLocation bDLocation, int i) {
        if (bDLocation != null) {
            if (bDLocation.getNetworkLocationType().startsWith("vps")) {
                if (bDLocation.getLongitude() == -1.0d && bDLocation.getLatitude() == -1.0d) {
                    bDLocation.setUserIndoorState(-1);
                } else {
                    bDLocation.setUserIndoorState(1);
                }
                bDLocation.setIndoorNetworkState(this.X);
                com.baidu.location.a.a.a().a(bDLocation);
                return;
            }
            if (this.Y != null) {
                if (bDLocation.getAddrStr() == null && this.Y.getAddrStr() != null) {
                    bDLocation.setAddr(this.Y.getAddress());
                    bDLocation.setAddrStr(this.Y.getAddrStr());
                }
                if (bDLocation.getPoiList() == null && this.Y.getPoiList() != null) {
                    bDLocation.setPoiList(this.Y.getPoiList());
                }
                if (bDLocation.getLocationDescribe() == null && this.Y.getLocationDescribe() != null) {
                    bDLocation.setLocationDescribe(this.Y.getLocationDescribe());
                }
            }
            if (bDLocation != null) {
                bDLocation.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
                if (bDLocation.getNetworkLocationType().contains("2")) {
                    String networkLocationType = bDLocation.getNetworkLocationType();
                    bDLocation.setNetworkLocationType(networkLocationType.substring(0, networkLocationType.length() - 1));
                    bDLocation.setUserIndoorState(1);
                    bDLocation.setIndoorNetworkState(this.X);
                    com.baidu.location.a.a.a().a(bDLocation);
                    BDLocation bDLocation2 = new BDLocation(bDLocation);
                    bDLocation2.setRadius(this.T ? 8.0f : 15.0f);
                    Message obtainMessage = this.a.obtainMessage(SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM);
                    obtainMessage.obj = bDLocation2;
                    obtainMessage.sendToTarget();
                }
            }
        }
    }

    private void a(String str, String str2) {
        if (this.z == null || !this.z.equals(str) || !this.ab) {
            com.baidu.location.indoor.mapversion.c.a a = com.baidu.location.indoor.mapversion.c.a.a();
            a.a(CoordinateType.GCJ02);
            a.a(str, new k(this, str, str2));
        }
    }

    private void i() {
    }

    private void j() {
        this.E.clear();
        this.G.clear();
        this.q = 0;
        this.r = 0;
        this.C = 0;
        this.v = 0;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.L = true;
        this.J = 0.4d;
        this.T = false;
        this.H = 0.0d;
        this.I = 0.0d;
        this.K = false;
        this.O = 0;
        this.u = 0;
        this.s = null;
        this.ae.a();
        com.baidu.location.indoor.mapversion.b.a.c();
        if (this.ab) {
            com.baidu.location.indoor.mapversion.c.a.a().b();
        }
        this.ac = false;
        this.ab = false;
        o.a().b(false);
        if (this.S != null) {
            this.S.c();
        }
    }

    private void k() {
        if (this.o) {
            this.j = true;
            this.ae.d();
            this.m.b();
            this.n = System.currentTimeMillis();
        }
    }

    private String l() {
        if (this.ag.b == 1 && this.ag.a != null) {
            return this.ag.b();
        }
        HashMap hashMap = new HashMap();
        int size = this.E.size();
        String str = "";
        String str2 = null;
        int i = -1;
        int i2 = 0;
        while (i2 < size) {
            try {
                String str3 = (String) this.E.get(i2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(str3);
                stringBuilder.append("|");
                str = stringBuilder.toString();
                hashMap.put(str3, hashMap.containsKey(str3) ? Integer.valueOf(((Integer) hashMap.get(str3)).intValue() + 1) : Integer.valueOf(1));
                i2++;
            } catch (Exception unused) {
                str2 = this.w;
            }
        }
        for (String str4 : hashMap.keySet()) {
            if (((Integer) hashMap.get(str4)).intValue() > i) {
                str2 = str4;
                i = ((Integer) hashMap.get(str4)).intValue();
            }
        }
        return str2;
    }

    private void m() {
        for (int i = this.N; i >= 0 && this.M.size() > 0; i--) {
            this.M.remove(0);
        }
        this.N = -1;
    }

    public boolean a(double d, double d2) {
        com.baidu.location.indoor.mapversion.c.c a = com.baidu.location.indoor.mapversion.c.c.a();
        if (!a.c() || !a.b()) {
            return false;
        }
        Map d3 = a.d();
        if (d3 == null) {
            return false;
        }
        String str = null;
        for (String str2 : d3.keySet()) {
            com.baidu.location.indoor.mapversion.c.c.b bVar = (com.baidu.location.indoor.mapversion.c.c.b) d3.get(str2);
            if (d > bVar.e && d < bVar.c && d2 > bVar.f && d2 < bVar.d) {
                String str3 = bVar.b;
                str = bVar.a;
                str3 = bVar.g;
                break;
            }
        }
        if (str != null) {
            return true;
        }
        return false;
    }

    public boolean a(Location location, ArrayList<ArrayList<Float>> arrayList) {
        if (arrayList.size() == 0 || !com.baidu.location.e.e.a().j()) {
            return false;
        }
        if (!this.o && location.getSpeed() > 3.0f) {
            return false;
        }
        double[] coorEncrypt = Jni.coorEncrypt(location.getLongitude(), location.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
        double d = coorEncrypt[0];
        double d2 = coorEncrypt[1];
        double accuracy = (double) location.getAccuracy();
        double bearing = (double) location.getBearing();
        double altitude = location.getAltitude();
        double speed = (double) location.getSpeed();
        boolean z = a(d, d2) || this.c == 1;
        if (!this.o && !z) {
            return false;
        }
        try {
            if (!this.ad.b(arrayList)) {
                return false;
            }
            this.ae.a(location, z);
            if (this.ae.b()) {
                c();
                return true;
            } else if (!e()) {
                return false;
            } else {
                double d3 = speed;
                double d4 = altitude;
                double d5 = bearing;
                double d6 = accuracy;
                if (this.ae.a(d, d2, accuracy)) {
                    com.baidu.location.indoor.mapversion.b.a.c();
                }
                double[] a = com.baidu.location.indoor.mapversion.b.a.a(d, d2, this.ad.a(d6, d, d2, d4), d5, d3);
                if (a != null) {
                    try {
                        if (a[0] != -1.0d) {
                            if (a[0] == 0.0d) {
                                String str;
                                BDLocation bDLocation = new BDLocation();
                                bDLocation.setAltitude(d4);
                                bDLocation.setLatitude(a[2]);
                                bDLocation.setLongitude(a[1]);
                                if (this.T) {
                                    bDLocation.setRadius(8.0f);
                                } else {
                                    bDLocation.setRadius(15.0f);
                                }
                                bDLocation.setDirection((float) d5);
                                bDLocation.setSpeed((float) d3);
                                bDLocation.setLocType(BDLocation.TypeNetWorkLocation);
                                bDLocation.setNetworkLocationType("gps");
                                if (System.currentTimeMillis() - this.ae.c < 20000) {
                                    bDLocation.setFloor(this.w);
                                    bDLocation.setBuildingName(this.z);
                                    str = this.x;
                                } else {
                                    str = null;
                                    bDLocation.setFloor(null);
                                    bDLocation.setBuildingName(null);
                                }
                                bDLocation.setBuildingID(str);
                                bDLocation.setIndoorLocMode(true);
                                this.I = bDLocation.getLatitude();
                                this.H = bDLocation.getLongitude();
                                bDLocation.setFusionLocInfo("res", a);
                                bDLocation.setRadius((float) a[5]);
                                bDLocation.setDirection((float) a[6]);
                                bDLocation.setSpeed((float) a[8]);
                                bDLocation.setTime(this.b.format(new Date()));
                                BDLocation bDLocation2 = new BDLocation(bDLocation);
                                String networkLocationType = bDLocation2.getNetworkLocationType();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(networkLocationType);
                                stringBuilder.append("2");
                                bDLocation2.setNetworkLocationType(stringBuilder.toString());
                                if (this.U == null || !this.U.c()) {
                                    a(bDLocation2, 21);
                                } else {
                                    this.U.a(bDLocation2);
                                }
                                if (!this.ae.a(bDLocation, a[5], "gps")) {
                                    d();
                                }
                                return true;
                            }
                        }
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
        } catch (Exception unused2) {
            return false;
        }
    }

    public boolean a(Bundle bundle) {
        if (bundle == null || this.W == null) {
            return false;
        }
        com.baidu.location.indoor.mapversion.a.a.d dVar = new com.baidu.location.indoor.mapversion.a.a.d();
        dVar.b(bundle.getString("bid")).c(bundle.getString(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE));
        dVar.a(bundle.getDouble("fov")).a(bundle.getFloatArray("gravity"));
        dVar.a(bundle.getString("image"));
        dVar.a(bundle.getBoolean("force_online"));
        this.W.a(dVar);
        return true;
    }

    public synchronized void b() {
        if (this.o) {
            this.E.clear();
        }
    }

    public boolean b(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        this.c = bundle.getInt("mode");
        return true;
    }

    public synchronized void c() {
        if (!this.o) {
            com.baidu.location.indoor.mapversion.b.a.b();
            this.q = System.currentTimeMillis();
            this.k.a();
            this.l = new g();
            this.l.start();
            this.p = false;
            this.o = true;
            this.S = d.a(com.baidu.location.f.getServiceContext());
            this.O = 0;
            this.u = 0;
            o.a().b(true);
        }
    }

    public synchronized void d() {
        if (this.o) {
            this.o = false;
            this.k.b();
            if (this.U != null && this.U.c()) {
                this.U.a();
            }
            if (this.Q != null) {
                this.Q.c();
            }
            if (this.S != null) {
                this.S.d();
            }
            if (this.l != null) {
                this.l.b = false;
                this.l.interrupt();
                this.l = null;
            }
            j();
            this.p = false;
            com.baidu.location.a.a.a().c();
        }
    }

    public boolean e() {
        return this.o;
    }

    public boolean f() {
        return this.o && this.ae.e();
    }

    public String g() {
        return this.w;
    }

    public String h() {
        return this.x;
    }
}
