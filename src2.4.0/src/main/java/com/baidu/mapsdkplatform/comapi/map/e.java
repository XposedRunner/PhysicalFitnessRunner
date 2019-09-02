package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.mapapi.UIMsg.m_AppUI;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.LatLngBounds.Builder;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.mapsdkplatform.comjni.map.basemap.JNIBaseMap;
import com.baidu.mapsdkplatform.comjni.map.basemap.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class e implements b {
    private static int N = 0;
    private static int O = 0;
    private static List<JNIBaseMap> ar = null;
    public static float d = 1096.0f;
    static long m;
    private static final String r = j.class.getSimpleName();
    private boolean A = false;
    private aj B;
    private ai C;
    private Context D;
    private List<d> E;
    private x F;
    private g G;
    private ae H;
    private ah I;
    private n J;
    private a K;
    private o L;
    private af M;
    private int P;
    private int Q;
    private int R;
    private a S = new a();
    private VelocityTracker T;
    private long U;
    private long V;
    private long W;
    private long X;
    private int Y;
    private float Z;
    public float a = 21.0f;
    private float aa;
    private boolean ab;
    private long ac;
    private long ad;
    private boolean ae = false;
    private boolean af = false;
    private float ag;
    private float ah;
    private float ai;
    private float aj;
    private long ak = 0;
    private long al = 0;
    private f am;
    private String an;
    private int ao;
    private b ap;
    private c aq;
    private boolean as = false;
    private Queue<a> at = new LinkedList();
    public float b = 4.0f;
    public float c = 21.0f;
    boolean e = true;
    boolean f = true;
    boolean g = false;
    List<l> h;
    com.baidu.mapsdkplatform.comjni.map.basemap.a i;
    long j;
    boolean k;
    int l;
    boolean n;
    boolean o;
    boolean p;
    public MapStatusUpdate q = null;
    private boolean s;
    private boolean t;
    private boolean u = true;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = true;
    private boolean z = true;

    public static class a {
        public long a;
        public int b;
        public int c;
        public int d;
        public Bundle e;

        public a(long j, int i, int i2, int i3) {
            this.a = j;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        public a(Bundle bundle) {
            this.e = bundle;
        }
    }

    public e(Context context, String str, int i) {
        this.D = context;
        this.h = new ArrayList();
        this.an = str;
        this.ao = i;
    }

    private void R() {
        if (this.w || this.t || this.s || this.x) {
            if (this.a > 20.0f) {
                this.a = 20.0f;
            }
            if (E().a > 20.0f) {
                ab E = E();
                E.a = 20.0f;
                a(E);
            }
            return;
        }
        this.a = this.c;
    }

    private void S() {
        if (!this.n) {
            this.n = true;
            this.o = false;
            if (this.h != null) {
                for (l lVar : this.h) {
                    if (lVar != null) {
                        lVar.a(E());
                    }
                }
            }
        }
    }

    private boolean T() {
        if (this.i == null || !this.k) {
            return true;
        }
        this.af = false;
        if (!this.e) {
            return false;
        }
        float f = (float) (this.al - this.ak);
        float abs = (Math.abs(this.ai - this.ag) * 1000.0f) / f;
        float abs2 = (Math.abs(this.aj - this.ah) * 1000.0f) / f;
        abs = (float) Math.sqrt((double) ((abs * abs) + (abs2 * abs2)));
        if (abs <= 500.0f) {
            return false;
        }
        A();
        a(34, (int) (abs * 0.6f), (((int) this.aj) << 16) | ((int) this.ai));
        M();
        return true;
    }

    private Activity a(Context context) {
        return context == null ? null : context instanceof Activity ? (Activity) context : context instanceof ContextWrapper ? a(((ContextWrapper) context).getBaseContext()) : null;
    }

    private void a(d dVar) {
        if (this.i != null) {
            dVar.a = this.i.a(dVar.c, dVar.d, dVar.b);
            this.E.add(dVar);
        }
    }

    private void a(String str, String str2, long j) {
        try {
            Class cls = Class.forName(str);
            Object newInstance = cls.newInstance();
            cls.getMethod(str2, new Class[]{Long.TYPE}).invoke(newInstance, new Object[]{Long.valueOf(j)});
        } catch (Exception unused) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (!this.S.e) {
            this.ad = motionEvent.getDownTime();
            long j = (this.ad - this.ac >= 400 || Math.abs(motionEvent.getX() - this.Z) >= 120.0f || Math.abs(motionEvent.getY() - this.aa) >= 120.0f) ? this.ad : 0;
            this.ac = j;
            this.Z = motionEvent.getX();
            this.aa = motionEvent.getY();
            a(4, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
            this.ab = true;
        }
    }

    private void b(String str, Bundle bundle) {
        if (this.i != null) {
            this.G.a(str);
            this.G.a(bundle);
            this.i.b(this.G.a);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (this.S.e || System.currentTimeMillis() - m < 300) {
            return true;
        }
        if (this.p) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    GeoPoint b = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.d(b);
                    }
                }
            }
            return true;
        }
        float abs = Math.abs(motionEvent.getX() - this.Z);
        float abs2 = Math.abs(motionEvent.getY() - this.aa);
        float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? ((double) SysOSUtil.getDensity()) * 1.5d : (double) SysOSUtil.getDensity());
        if (this.ab && abs / density <= 3.0f && abs2 / density <= 3.0f) {
            return true;
        }
        this.ab = false;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (this.e) {
            BaiduMap.mapStatusReason = 1 | BaiduMap.mapStatusReason;
            S();
            a(3, 0, (y << 16) | x);
        }
        return false;
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.p) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    GeoPoint b = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.e(b);
                    }
                }
            }
            this.p = false;
            return true;
        }
        boolean z = !this.S.e && motionEvent.getEventTime() - this.ad < 400 && Math.abs(motionEvent.getX() - this.Z) < 10.0f && Math.abs(motionEvent.getY() - this.aa) < 10.0f;
        M();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (z) {
            return false;
        }
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        a(5, 0, (y << 16) | x);
        return true;
    }

    private boolean e(float f, float f2) {
        if (this.i == null || !this.k) {
            return true;
        }
        this.ae = false;
        GeoPoint b = b((int) f, (int) f2);
        if (b != null) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    if (lVar != null) {
                        lVar.b(b);
                    }
                }
            }
            if (this.f) {
                ab E = E();
                E.a += 1.0f;
                E.d = b.getLongitudeE6();
                E.e = b.getLatitudeE6();
                a(E, (int) SecExceptionCode.SEC_ERROR_STA_ENC);
                m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    private boolean e(Bundle bundle) {
        return this.i == null ? false : this.i.e(bundle);
    }

    private boolean f(Bundle bundle) {
        if (bundle == null || this.i == null) {
            return false;
        }
        boolean d = this.i.d(bundle);
        if (d) {
            e(d);
            this.i.b(this.B.a);
        }
        return d;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:16:0x0050 in {4, 7, 8, 12, 15} preds:[]
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
    private void g(android.os.Bundle r4) {
        /*
        r3 = this;
        r0 = "param";
        r0 = r4.get(r0);
        if (r0 == 0) goto L_0x002f;
        r0 = "param";
        r4 = r4.get(r0);
        r4 = (android.os.Bundle) r4;
        r0 = "type";
        r0 = r4.getInt(r0);
        r1 = com.baidu.mapsdkplatform.comapi.map.h.ground;
        r1 = r1.ordinal();
        if (r0 != r1) goto L_0x001f;
        goto L_0x003d;
        r1 = com.baidu.mapsdkplatform.comapi.map.h.arc;
        r1 = r1.ordinal();
        if (r0 < r1) goto L_0x0028;
        goto L_0x003d;
        r1 = com.baidu.mapsdkplatform.comapi.map.h.popup;
        r1 = r1.ordinal();
        goto L_0x003d;
        r0 = "type";
        r0 = r4.getInt(r0);
        r1 = com.baidu.mapsdkplatform.comapi.map.h.ground;
        r1 = r1.ordinal();
        if (r0 != r1) goto L_0x0047;
        r0 = "layer_addr";
        r1 = r3.I;
        r1 = r1.a;
        r4.putLong(r0, r1);
        return;
        r1 = com.baidu.mapsdkplatform.comapi.map.h.arc;
        r1 = r1.ordinal();
        if (r0 < r1) goto L_0x0028;
        goto L_0x003d;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.e.g(android.os.Bundle):void");
    }

    static void l(boolean z) {
        ar = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
        if (ar == null || ar.size() == 0) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.b(0, z);
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.basemap.a.b(((JNIBaseMap) ar.get(0)).a, z);
        for (JNIBaseMap jNIBaseMap : ar) {
            if (jNIBaseMap != null) {
                jNIBaseMap.ClearLayer(jNIBaseMap.a, -1);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void A() {
        if (!(this.n || this.o)) {
            this.o = true;
            if (this.h != null) {
                for (l lVar : this.h) {
                    if (lVar != null) {
                        lVar.a(E());
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void B() {
        this.o = false;
        this.n = false;
        if (this.h != null) {
            for (l lVar : this.h) {
                if (lVar != null) {
                    lVar.c(E());
                }
            }
        }
    }

    public boolean C() {
        return this.i != null ? this.i.a(this.H.a) : false;
    }

    public boolean D() {
        return this.i != null ? this.i.a(this.aq.a) : false;
    }

    public ab E() {
        if (this.i == null) {
            return null;
        }
        Bundle h = this.i.h();
        ab abVar = new ab();
        abVar.a(h);
        return abVar;
    }

    public LatLngBounds F() {
        if (this.i == null) {
            return null;
        }
        Bundle i = this.i.i();
        Builder builder = new Builder();
        int i2 = i.getInt("maxCoorx");
        int i3 = i.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint((double) i.getInt("minCoory"), (double) i2))).include(CoordUtil.mc2ll(new GeoPoint((double) i.getInt("maxCoory"), (double) i3)));
        return builder.build();
    }

    public MapStatusUpdate G() {
        return this.q;
    }

    public int H() {
        return this.P;
    }

    public int I() {
        return this.Q;
    }

    /* Access modifiers changed, original: 0000 */
    public ab J() {
        if (this.i == null) {
            return null;
        }
        Bundle j = this.i.j();
        ab abVar = new ab();
        abVar.a(j);
        return abVar;
    }

    public double K() {
        return E().m;
    }

    /* Access modifiers changed, original: 0000 */
    public void L() {
        this.n = false;
        if (!this.o && this.h != null) {
            for (l lVar : this.h) {
                if (lVar != null) {
                    lVar.c(E());
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void M() {
        this.R = 0;
        this.S.e = false;
        this.S.h = 0.0d;
    }

    public float[] N() {
        return this.i == null ? null : this.i.u();
    }

    public float[] O() {
        return this.i == null ? null : this.i.v();
    }

    public Queue<a> P() {
        return this.at;
    }

    public void Q() {
        if (!this.at.isEmpty()) {
            a aVar = (a) this.at.poll();
            if (aVar.e == null) {
                com.baidu.mapsdkplatform.comjni.map.basemap.a.a(aVar.a, aVar.b, aVar.c, aVar.d);
                return;
            }
            if (this.i != null) {
                A();
                this.i.a(aVar.e);
            }
        }
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!this.k) {
            return 12.0f;
        }
        if (this.i == null) {
            return 0.0f;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("left", i);
        bundle.putInt("right", i3);
        bundle.putInt("bottom", i4);
        bundle.putInt("top", i2);
        bundle.putInt("hasHW", 1);
        bundle.putInt("width", i5);
        bundle.putInt("height", i6);
        return this.i.c(bundle);
    }

    /* Access modifiers changed, original: 0000 */
    public int a(int i, int i2, int i3) {
        if (!this.as) {
            return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.j, i, i2, i3);
        }
        this.at.add(new a(this.j, i, i2, i3));
        return 0;
    }

    public int a(Bundle bundle, long j, int i, Bundle bundle2) {
        if (j == this.G.a) {
            bundle.putString("jsondata", this.G.a());
            bundle.putBundle("param", this.G.b());
            return this.G.g;
        } else if (j == this.F.a) {
            bundle.putString("jsondata", this.F.a());
            bundle.putBundle("param", this.F.b());
            return this.F.g;
        } else if (j == this.J.a) {
            bundle.putBundle("param", this.L.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom")));
            return this.J.g;
        } else if (j != this.B.a) {
            return 0;
        } else {
            bundle.putBundle("param", this.C.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom"), this.D));
            return this.B.g;
        }
    }

    public Point a(GeoPoint geoPoint) {
        return this.M.a(geoPoint);
    }

    /* Access modifiers changed, original: 0000 */
    public void a() {
        this.E = new ArrayList();
        this.am = new f();
        a(this.am);
        this.ap = new b();
        a(this.ap);
        this.J = new n();
        a(this.J);
        this.K = new a();
        a(this.K);
        a(new p());
        this.H = new ae();
        a(this.H);
        this.aq = new c();
        a(this.aq);
        if (this.i != null) {
            this.i.e(false);
        }
        this.I = new ah();
        a(this.I);
        this.G = new g();
        a(this.G);
        this.F = new x();
        a(this.F);
    }

    public void a(float f, float f2) {
        this.a = f;
        this.c = f;
        this.b = f2;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i) {
        this.i = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.i.a(i);
        this.j = this.i.a();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.j);
        int i2 = SysOSUtil.getDensityDpi() < 180 ? 18 : SysOSUtil.getDensityDpi() < GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN ? 25 : SysOSUtil.getDensityDpi() < GlMapUtil.DEVICE_DISPLAY_DPI_HIGH ? 37 : 50;
        this.l = i2;
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(moduleFileName);
        stringBuilder.append("/cfg");
        moduleFileName = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(appSDCardPath);
        stringBuilder.append("/vmp");
        appSDCardPath = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(moduleFileName);
        stringBuilder.append("/a/");
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(moduleFileName);
        stringBuilder.append("/a/");
        String stringBuilder3 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(moduleFileName);
        stringBuilder.append("/idrres/");
        String stringBuilder4 = stringBuilder.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(appSDCardPath);
        stringBuilder5.append(str);
        String stringBuilder6 = stringBuilder5.toString();
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(appSDCardPath);
        stringBuilder5.append(str);
        String stringBuilder7 = stringBuilder5.toString();
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(appCachePath);
        stringBuilder5.append("/tmp/");
        String stringBuilder8 = stringBuilder5.toString();
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append(appSecondCachePath);
        stringBuilder5.append("/tmp/");
        String stringBuilder9 = stringBuilder5.toString();
        Activity a = a(this.D);
        if (a != null) {
            Display defaultDisplay = a.getWindowManager().getDefaultDisplay();
            this.i.a(stringBuilder2, stringBuilder6, stringBuilder8, stringBuilder9, stringBuilder7, stringBuilder3, this.an, this.ao, stringBuilder4, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
            return;
        }
        throw new RuntimeException("Please give the right context.");
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, int i2) {
        this.P = i;
        this.Q = i2;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.i.a(j, j2, j3, j4, z);
    }

    public void a(Bitmap bitmap) {
        if (this.i != null) {
            Bundle bundle;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            int i = 0;
            try {
                jSONObject.put("type", 0);
                jSONObject2.put("x", N);
                jSONObject2.put("y", O);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (bitmap == null) {
                bundle = null;
            } else {
                Bundle bundle2 = new Bundle();
                ArrayList arrayList = new ArrayList();
                ParcelItem parcelItem = new ParcelItem();
                Bundle bundle3 = new Bundle();
                ByteBuffer allocate = ByteBuffer.allocate((bitmap.getWidth() * bitmap.getHeight()) * 4);
                bitmap.copyPixelsToBuffer(allocate);
                bundle3.putByteArray("imgdata", allocate.array());
                bundle3.putInt("imgindex", bitmap.hashCode());
                bundle3.putInt("imgH", bitmap.getHeight());
                bundle3.putInt("imgW", bitmap.getWidth());
                bundle3.putInt("hasIcon", 1);
                parcelItem.setBundle(bundle3);
                arrayList.add(parcelItem);
                if (arrayList.size() > 0) {
                    ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                    while (i < arrayList.size()) {
                        parcelItemArr[i] = (ParcelItem) arrayList.get(i);
                        i++;
                    }
                    bundle2.putParcelableArray("icondata", parcelItemArr);
                }
                bundle = bundle2;
            }
            b(jSONObject.toString(), bundle);
            this.i.b(this.G.a);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Handler handler) {
        MessageCenter.registMessage(m_AppUI.MSG_APP_SAVESCREEN, handler);
        MessageCenter.registMessage(39, handler);
        MessageCenter.registMessage(41, handler);
        MessageCenter.registMessage(49, handler);
        MessageCenter.registMessage(m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.registMessage(50, handler);
        MessageCenter.registMessage(999, handler);
        BaseMapCallback.addLayerDataInterface(this.j, this);
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.q = mapStatusUpdate;
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds != null && this.i != null) {
            LatLng latLng = latLngBounds.northeast;
            LatLng latLng2 = latLngBounds.southwest;
            GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
            GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
            int longitudeE6 = (int) ll2mc.getLongitudeE6();
            int latitudeE6 = (int) ll2mc2.getLatitudeE6();
            int longitudeE62 = (int) ll2mc2.getLongitudeE6();
            int latitudeE62 = (int) ll2mc.getLatitudeE6();
            Bundle bundle = new Bundle();
            bundle.putInt("maxCoorx", longitudeE6);
            bundle.putInt("minCoory", latitudeE6);
            bundle.putInt("minCoorx", longitudeE62);
            bundle.putInt("maxCoory", latitudeE62);
            this.i.b(bundle);
        }
    }

    public void a(ab abVar) {
        if (this.i != null && abVar != null) {
            Bundle a = abVar.a(this);
            a.putInt("animation", 0);
            a.putInt("animatime", 0);
            this.i.a(a);
        }
    }

    public void a(ab abVar, int i) {
        if (this.i != null && abVar != null) {
            Bundle a = abVar.a(this);
            a.putInt("animation", 1);
            a.putInt("animatime", i);
            if (this.as) {
                this.at.add(new a(a));
                return;
            }
            A();
            this.i.a(a);
        }
    }

    public void a(ai aiVar) {
        this.C = aiVar;
    }

    public void a(l lVar) {
        if (lVar != null && this.h != null) {
            this.h.add(lVar);
        }
    }

    public void a(o oVar) {
        this.L = oVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(z zVar) {
        ab abVar = new ab();
        if (zVar == null) {
            zVar = new z();
        }
        abVar = zVar.a;
        this.y = zVar.f;
        this.z = zVar.d;
        this.e = zVar.e;
        this.f = zVar.g;
        this.i.a(abVar.a(this));
        this.i.c(y.DEFAULT.ordinal());
        this.u = zVar.b;
        if (zVar.b) {
            N = (int) (SysOSUtil.getDensity() * 40.0f);
            O = (int) (40.0f * SysOSUtil.getDensity());
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", N);
                jSONObject2.put("y", O);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.G.a(jSONObject.toString());
            this.i.a(this.G.a, true);
        } else {
            this.i.a(this.G.a, false);
        }
        int i = zVar.c;
        if (i == 2) {
            a(true);
        }
        if (i == 3) {
            this.i.a(this.am.a, false);
            this.i.a(this.aq.a, false);
            this.i.a(this.H.a, false);
            this.i.e(false);
        }
    }

    public void a(String str, Bundle bundle) {
        if (this.i != null) {
            this.F.a(str);
            this.F.a(bundle);
            this.i.b(this.F.a);
        }
    }

    public void a(List<Bundle> list) {
        if (this.i != null && list != null) {
            int size = list.size();
            Bundle[] bundleArr = new Bundle[list.size()];
            for (int i = 0; i < size; i++) {
                g((Bundle) list.get(i));
                bundleArr[i] = (Bundle) list.get(i);
            }
            this.i.a(bundleArr);
        }
    }

    public void a(boolean z) {
        if (this.i != null) {
            if (!this.i.a(this.am.a)) {
                this.i.a(this.am.a, true);
            }
            this.t = z;
            R();
            this.i.a(this.t);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x024c  */
    /* JADX WARNING: Missing block: B:56:0x01ca, code skipped:
            if (2 == r0.R) goto L_0x01cf;
     */
    public boolean a(float r23, float r24, float r25, float r26) {
        /*
        r22 = this;
        r0 = r22;
        r1 = r23;
        r2 = r25;
        r3 = r0.Q;
        r3 = (float) r3;
        r3 = r3 - r24;
        r4 = r0.Q;
        r4 = (float) r4;
        r4 = r4 - r26;
        r5 = r0.S;
        r5 = r5.e;
        r9 = 1;
        if (r5 != r9) goto L_0x022d;
    L_0x0017:
        r5 = r0.R;
        r15 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r8 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r17 = 0;
        if (r5 != 0) goto L_0x00bd;
    L_0x0024:
        r5 = r0.S;
        r5 = r5.c;
        r5 = r5 - r3;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 <= 0) goto L_0x0036;
    L_0x002d:
        r5 = r0.S;
        r5 = r5.d;
        r5 = r5 - r4;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 > 0) goto L_0x0048;
    L_0x0036:
        r5 = r0.S;
        r5 = r5.c;
        r5 = r5 - r3;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 >= 0) goto L_0x00b4;
    L_0x003f:
        r5 = r0.S;
        r5 = r5.d;
        r5 = r5 - r4;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 >= 0) goto L_0x00b4;
    L_0x0048:
        r5 = r4 - r3;
        r6 = (double) r5;
        r10 = r2 - r1;
        r11 = (double) r10;
        r6 = java.lang.Math.atan2(r6, r11);
        r11 = r0.S;
        r11 = r11.d;
        r12 = r0.S;
        r12 = r12.c;
        r11 = r11 - r12;
        r11 = (double) r11;
        r13 = r0.S;
        r13 = r13.b;
        r14 = r0.S;
        r14 = r14.a;
        r13 = r13 - r14;
        r13 = (double) r13;
        r11 = java.lang.Math.atan2(r11, r13);
        r6 = r6 - r11;
        r10 = r10 * r10;
        r5 = r5 * r5;
        r10 = r10 + r5;
        r10 = (double) r10;
        r10 = java.lang.Math.sqrt(r10);
        r5 = r0.S;
        r12 = r5.h;
        r10 = r10 / r12;
        r12 = java.lang.Math.log(r10);
        r18 = java.lang.Math.log(r8);
        r12 = r12 / r18;
        r12 = r12 * r15;
        r5 = (int) r12;
        r12 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r6 = r6 * r12;
        r12 = 4614256673094690983; // 0x400921ff2e48e8a7 float:4.5681372E-11 double:3.1416;
        r6 = r6 / r12;
        r6 = (int) r6;
        r12 = 0;
        r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r7 <= 0) goto L_0x00a2;
    L_0x0097:
        r7 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        if (r5 > r7) goto L_0x00a0;
    L_0x009b:
        r7 = -3000; // 0xfffffffffffff448 float:NaN double:NaN;
        if (r5 < r7) goto L_0x00a0;
    L_0x009f:
        goto L_0x00a2;
    L_0x00a0:
        r5 = 2;
        goto L_0x00ab;
    L_0x00a2:
        r5 = java.lang.Math.abs(r6);
        r6 = 10;
        if (r5 < r6) goto L_0x00af;
    L_0x00aa:
        goto L_0x00a0;
    L_0x00ab:
        r0.R = r5;
        r6 = 1;
        goto L_0x00b8;
    L_0x00af:
        r5 = 2;
        r6 = 1;
        r0.R = r6;
        goto L_0x00b8;
    L_0x00b4:
        r5 = 2;
        r6 = 1;
        r0.R = r5;
    L_0x00b8:
        r5 = r0.R;
        if (r5 != 0) goto L_0x00be;
    L_0x00bc:
        return r6;
    L_0x00bd:
        r6 = 1;
    L_0x00be:
        r5 = r0.R;
        r7 = 0;
        if (r5 != r6) goto L_0x00fc;
    L_0x00c3:
        r5 = r0.y;
        if (r5 == 0) goto L_0x00fc;
    L_0x00c7:
        r5 = r0.S;
        r5 = r5.c;
        r5 = r5 - r3;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 <= 0) goto L_0x00e4;
    L_0x00d0:
        r5 = r0.S;
        r5 = r5.d;
        r5 = r5 - r4;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 <= 0) goto L_0x00e4;
    L_0x00d9:
        r22.S();
        r5 = 83;
    L_0x00de:
        r6 = 1;
        r0.a(r6, r5, r7);
        goto L_0x022d;
    L_0x00e4:
        r5 = r0.S;
        r5 = r5.c;
        r5 = r5 - r3;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 >= 0) goto L_0x022d;
    L_0x00ed:
        r5 = r0.S;
        r5 = r5.d;
        r5 = r5 - r4;
        r5 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1));
        if (r5 >= 0) goto L_0x022d;
    L_0x00f6:
        r22.S();
        r5 = 87;
        goto L_0x00de;
    L_0x00fc:
        r5 = r0.R;
        r6 = 4;
        r10 = 3;
        r11 = 2;
        if (r5 == r11) goto L_0x010b;
    L_0x0103:
        r5 = r0.R;
        if (r5 == r6) goto L_0x010b;
    L_0x0107:
        r5 = r0.R;
        if (r5 != r10) goto L_0x022d;
    L_0x010b:
        r5 = r4 - r3;
        r11 = (double) r5;
        r13 = r2 - r1;
        r6 = (double) r13;
        r6 = java.lang.Math.atan2(r11, r6);
        r11 = r0.S;
        r11 = r11.d;
        r12 = r0.S;
        r12 = r12.c;
        r11 = r11 - r12;
        r11 = (double) r11;
        r14 = r0.S;
        r14 = r14.b;
        r10 = r0.S;
        r10 = r10.a;
        r14 = r14 - r10;
        r8 = (double) r14;
        r8 = java.lang.Math.atan2(r11, r8);
        r6 = r6 - r8;
        r13 = r13 * r13;
        r5 = r5 * r5;
        r13 = r13 + r5;
        r8 = (double) r13;
        r8 = java.lang.Math.sqrt(r8);
        r5 = r0.S;
        r10 = r5.h;
        r8 = r8 / r10;
        r10 = java.lang.Math.log(r8);
        r12 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r12 = java.lang.Math.log(r12);
        r10 = r10 / r12;
        r10 = r10 * r15;
        r5 = (int) r10;
        r10 = r0.S;
        r10 = r10.g;
        r11 = r0.S;
        r11 = r11.c;
        r10 = r10 - r11;
        r10 = (double) r10;
        r12 = r0.S;
        r12 = r12.f;
        r13 = r0.S;
        r13 = r13.a;
        r12 = r12 - r13;
        r12 = (double) r12;
        r10 = java.lang.Math.atan2(r10, r12);
        r12 = r0.S;
        r12 = r12.f;
        r13 = r0.S;
        r13 = r13.a;
        r12 = r12 - r13;
        r13 = r0.S;
        r13 = r13.f;
        r14 = r0.S;
        r14 = r14.a;
        r13 = r13 - r14;
        r12 = r12 * r13;
        r13 = r0.S;
        r13 = r13.g;
        r14 = r0.S;
        r14 = r14.c;
        r13 = r13 - r14;
        r14 = r0.S;
        r14 = r14.g;
        r15 = r0.S;
        r15 = r15.c;
        r14 = r14 - r15;
        r13 = r13 * r14;
        r12 = r12 + r13;
        r12 = (double) r12;
        r12 = java.lang.Math.sqrt(r12);
        r10 = r10 + r6;
        r14 = java.lang.Math.cos(r10);
        r14 = r14 * r12;
        r14 = r14 * r8;
        r20 = r4;
        r21 = r5;
        r4 = (double) r1;
        r14 = r14 + r4;
        r4 = (float) r14;
        r10 = java.lang.Math.sin(r10);
        r12 = r12 * r10;
        r12 = r12 * r8;
        r10 = (double) r3;
        r12 = r12 + r10;
        r5 = (float) r12;
        r10 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r6 = r6 * r10;
        r10 = 4614256673094690983; // 0x400921ff2e48e8a7 float:4.5681372E-11 double:3.1416;
        r6 = r6 / r10;
        r6 = (int) r6;
        r10 = 0;
        r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        r10 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
        if (r7 <= 0) goto L_0x01fe;
    L_0x01b8:
        r7 = r0.R;
        r11 = 3;
        if (r11 == r7) goto L_0x01cd;
    L_0x01bd:
        r7 = r21;
        r12 = java.lang.Math.abs(r7);
        r13 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r12 <= r13) goto L_0x01fe;
    L_0x01c7:
        r12 = r0.R;
        r13 = 2;
        if (r13 != r12) goto L_0x01fe;
    L_0x01cc:
        goto L_0x01cf;
    L_0x01cd:
        r7 = r21;
    L_0x01cf:
        r0.R = r11;
        r6 = r22.E();
        r6 = r6.a;
        r11 = r0.f;
        if (r11 == 0) goto L_0x0224;
    L_0x01db:
        r11 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r13 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1));
        if (r13 <= 0) goto L_0x01f1;
    L_0x01e1:
        r8 = r0.a;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 < 0) goto L_0x01e9;
    L_0x01e7:
        r8 = 0;
        return r8;
    L_0x01e9:
        r22.S();
        r9 = 3;
    L_0x01ed:
        r0.a(r10, r9, r7);
        goto L_0x0224;
    L_0x01f1:
        r8 = 0;
        r9 = 3;
        r11 = r0.b;
        r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        if (r6 > 0) goto L_0x01fa;
    L_0x01f9:
        return r8;
    L_0x01fa:
        r22.S();
        goto L_0x01ed;
    L_0x01fe:
        if (r6 == 0) goto L_0x0224;
    L_0x0200:
        r7 = r0.R;
        r8 = 4;
        if (r8 == r7) goto L_0x0212;
    L_0x0205:
        r7 = java.lang.Math.abs(r6);
        r9 = 10;
        if (r7 <= r9) goto L_0x0224;
    L_0x020d:
        r7 = r0.R;
        r9 = 2;
        if (r9 != r7) goto L_0x0224;
    L_0x0212:
        r0.R = r8;
        r7 = r0.z;
        if (r7 == 0) goto L_0x0224;
    L_0x0218:
        r7 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r8 = 1;
        r7 = r7 | r8;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r7;
        r22.S();
        r0.a(r10, r8, r6);
    L_0x0224:
        r6 = r0.S;
        r6.f = r4;
        r4 = r0.S;
        r4.g = r5;
        goto L_0x022f;
    L_0x022d:
        r20 = r4;
    L_0x022f:
        r4 = r0.R;
        r5 = 2;
        if (r5 == r4) goto L_0x0246;
    L_0x0234:
        r4 = r0.S;
        r4.c = r3;
        r3 = r0.S;
        r4 = r20;
        r3.d = r4;
        r3 = r0.S;
        r3.a = r1;
        r1 = r0.S;
        r1.b = r2;
    L_0x0246:
        r1 = r0.S;
        r1 = r1.e;
        if (r1 != 0) goto L_0x029c;
    L_0x024c:
        r1 = r0.S;
        r2 = r0.P;
        r3 = 2;
        r2 = r2 / r3;
        r2 = (float) r2;
        r1.f = r2;
        r1 = r0.S;
        r2 = r0.Q;
        r2 = r2 / r3;
        r2 = (float) r2;
        r1.g = r2;
        r1 = r0.S;
        r2 = 1;
        r1.e = r2;
        r1 = r0.S;
        r1 = r1.h;
        r3 = 0;
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 != 0) goto L_0x029c;
    L_0x026c:
        r1 = r0.S;
        r1 = r1.b;
        r2 = r0.S;
        r2 = r2.a;
        r1 = r1 - r2;
        r2 = r0.S;
        r2 = r2.b;
        r3 = r0.S;
        r3 = r3.a;
        r2 = r2 - r3;
        r1 = r1 * r2;
        r2 = r0.S;
        r2 = r2.d;
        r3 = r0.S;
        r3 = r3.c;
        r2 = r2 - r3;
        r3 = r0.S;
        r3 = r3.d;
        r4 = r0.S;
        r4 = r4.c;
        r3 = r3 - r4;
        r2 = r2 * r3;
        r1 = r1 + r2;
        r1 = (double) r1;
        r1 = java.lang.Math.sqrt(r1);
        r3 = r0.S;
        r3.h = r1;
    L_0x029c:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.e.a(float, float, float, float):boolean");
    }

    public boolean a(long j) {
        for (d dVar : this.E) {
            if (dVar.a == j) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        if (point == null || this.i == null || point.x < 0 || point.y < 0) {
            return false;
        }
        N = point.x;
        O = point.y;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("x", N);
            jSONObject2.put("y", O);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.G.a(jSONObject.toString());
        this.i.b(this.G.a);
        return true;
    }

    public boolean a(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        this.B = new aj();
        long a = this.i.a(this.B.c, this.B.d, this.B.b);
        if (a != 0) {
            this.B.a = a;
            this.E.add(this.B);
            bundle.putLong("sdktileaddr", a);
            if (e(bundle) && f(bundle)) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0372  */
    /* JADX WARNING: Missing block: B:13:0x0064, code skipped:
            r9 = r0.Y + 1;
     */
    /* JADX WARNING: Missing block: B:15:0x006e, code skipped:
            r9 = r0.Y - 1;
     */
    /* JADX WARNING: Missing block: B:16:0x0071, code skipped:
            r0.Y = r9;
     */
    /* JADX WARNING: Missing block: B:104:0x02e6, code skipped:
            if (2 == r4.R) goto L_0x02eb;
     */
    public boolean a(android.view.MotionEvent r23) {
        /*
        r22 = this;
        r0 = r22;
        r1 = r23;
        r2 = r23.getPointerCount();
        r3 = 0;
        r4 = 2;
        r5 = 1;
        if (r2 != r4) goto L_0x002e;
    L_0x000d:
        r6 = r1.getX(r3);
        r6 = (int) r6;
        r7 = r1.getY(r3);
        r7 = (int) r7;
        r6 = r0.c(r6, r7);
        if (r6 == 0) goto L_0x002d;
    L_0x001d:
        r6 = r1.getX(r5);
        r6 = (int) r6;
        r7 = r1.getY(r5);
        r7 = (int) r7;
        r6 = r0.c(r6, r7);
        if (r6 != 0) goto L_0x002e;
    L_0x002d:
        r2 = r5;
    L_0x002e:
        if (r2 != r4) goto L_0x03c4;
    L_0x0030:
        r2 = r0.Q;
        r2 = (float) r2;
        r6 = r1.getY(r3);
        r2 = r2 - r6;
        r6 = r0.Q;
        r6 = (float) r6;
        r7 = r1.getY(r5);
        r6 = r6 - r7;
        r7 = r1.getX(r3);
        r8 = r1.getX(r5);
        r9 = r23.getAction();
        switch(r9) {
            case 5: goto L_0x0068;
            case 6: goto L_0x005e;
            case 261: goto L_0x0057;
            case 262: goto L_0x0050;
            default: goto L_0x004f;
        };
    L_0x004f:
        goto L_0x0073;
    L_0x0050:
        r9 = r23.getEventTime();
        r0.W = r9;
        goto L_0x0064;
    L_0x0057:
        r9 = r23.getEventTime();
        r0.U = r9;
        goto L_0x006e;
    L_0x005e:
        r9 = r23.getEventTime();
        r0.X = r9;
    L_0x0064:
        r9 = r0.Y;
        r9 = r9 + r5;
        goto L_0x0071;
    L_0x0068:
        r9 = r23.getEventTime();
        r0.V = r9;
    L_0x006e:
        r9 = r0.Y;
        r9 = r9 - r5;
    L_0x0071:
        r0.Y = r9;
    L_0x0073:
        r9 = r0.T;
        if (r9 != 0) goto L_0x007d;
    L_0x0077:
        r9 = android.view.VelocityTracker.obtain();
        r0.T = r9;
    L_0x007d:
        r9 = r0.T;
        r9.addMovement(r1);
        r1 = android.view.ViewConfiguration.getMinimumFlingVelocity();
        r9 = android.view.ViewConfiguration.getMaximumFlingVelocity();
        r10 = r0.T;
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r9 = (float) r9;
        r10.computeCurrentVelocity(r11, r9);
        r9 = r0.T;
        r9 = r9.getXVelocity(r5);
        r10 = r0.T;
        r10 = r10.getYVelocity(r5);
        r11 = r0.T;
        r11 = r11.getXVelocity(r4);
        r12 = r0.T;
        r12 = r12.getYVelocity(r4);
        r9 = java.lang.Math.abs(r9);
        r1 = (float) r1;
        r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r9 > 0) goto L_0x011b;
    L_0x00b3:
        r9 = java.lang.Math.abs(r10);
        r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r9 > 0) goto L_0x011b;
    L_0x00bb:
        r9 = java.lang.Math.abs(r11);
        r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r9 > 0) goto L_0x011b;
    L_0x00c3:
        r9 = java.lang.Math.abs(r12);
        r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r1 <= 0) goto L_0x00cc;
    L_0x00cb:
        goto L_0x011b;
    L_0x00cc:
        r1 = r0.R;
        if (r1 != 0) goto L_0x0352;
    L_0x00d0:
        r1 = r0.Y;
        if (r1 != 0) goto L_0x0352;
    L_0x00d4:
        r9 = r0.W;
        r11 = r0.X;
        r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r1 <= 0) goto L_0x00df;
    L_0x00dc:
        r9 = r0.W;
        goto L_0x00e1;
    L_0x00df:
        r9 = r0.X;
    L_0x00e1:
        r0.W = r9;
        r9 = r0.U;
        r11 = r0.V;
        r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r1 >= 0) goto L_0x00ee;
    L_0x00eb:
        r9 = r0.V;
        goto L_0x00f0;
    L_0x00ee:
        r9 = r0.U;
    L_0x00f0:
        r0.U = r9;
        r9 = r0.W;
        r11 = r0.U;
        r15 = r9 - r11;
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r1 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1));
        if (r1 >= 0) goto L_0x0352;
    L_0x00fe:
        r1 = r0.f;
        if (r1 == 0) goto L_0x0352;
    L_0x0102:
        r1 = r22.E();
        if (r1 == 0) goto L_0x0352;
    L_0x0108:
        r3 = r1.a;
        r9 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = r3 - r9;
        r1.a = r3;
        r3 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r3 = r3 | r5;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r3;
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0.a(r1, r3);
        goto L_0x0352;
    L_0x011b:
        r1 = r0.S;
        r1 = r1.e;
        if (r1 == 0) goto L_0x0352;
    L_0x0121:
        r1 = r0.R;
        r15 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r17 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r12 = 0;
        if (r1 != 0) goto L_0x01c9;
    L_0x0132:
        r1 = r0.S;
        r1 = r1.c;
        r1 = r1 - r2;
        r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r1 <= 0) goto L_0x0144;
    L_0x013b:
        r1 = r0.S;
        r1 = r1.d;
        r1 = r1 - r6;
        r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r1 > 0) goto L_0x0156;
    L_0x0144:
        r1 = r0.S;
        r1 = r1.c;
        r1 = r1 - r2;
        r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r1 >= 0) goto L_0x01bf;
    L_0x014d:
        r1 = r0.S;
        r1 = r1.d;
        r1 = r1 - r6;
        r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1));
        if (r1 >= 0) goto L_0x01bf;
    L_0x0156:
        r1 = r6 - r2;
        r19 = r6;
        r5 = (double) r1;
        r12 = r8 - r7;
        r13 = (double) r12;
        r5 = java.lang.Math.atan2(r5, r13);
        r13 = r0.S;
        r13 = r13.d;
        r14 = r0.S;
        r14 = r14.c;
        r13 = r13 - r14;
        r13 = (double) r13;
        r9 = r0.S;
        r9 = r9.b;
        r10 = r0.S;
        r10 = r10.a;
        r9 = r9 - r10;
        r9 = (double) r9;
        r9 = java.lang.Math.atan2(r13, r9);
        r5 = r5 - r9;
        r12 = r12 * r12;
        r1 = r1 * r1;
        r12 = r12 + r1;
        r9 = (double) r12;
        r9 = java.lang.Math.sqrt(r9);
        r1 = r0.S;
        r11 = r1.h;
        r9 = r9 / r11;
        r11 = java.lang.Math.log(r9);
        r13 = java.lang.Math.log(r3);
        r11 = r11 / r13;
        r11 = r11 * r17;
        r1 = (int) r11;
        r5 = r5 * r15;
        r11 = 4614256673094690983; // 0x400921ff2e48e8a7 float:4.5681372E-11 double:3.1416;
        r5 = r5 / r11;
        r5 = (int) r5;
        r11 = 0;
        r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r6 <= 0) goto L_0x01ad;
    L_0x01a2:
        r6 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        if (r1 > r6) goto L_0x01ab;
    L_0x01a6:
        r6 = -3000; // 0xfffffffffffff448 float:NaN double:NaN;
        if (r1 < r6) goto L_0x01ab;
    L_0x01aa:
        goto L_0x01ad;
    L_0x01ab:
        r1 = 2;
        goto L_0x01b6;
    L_0x01ad:
        r1 = java.lang.Math.abs(r5);
        r5 = 10;
        if (r1 < r5) goto L_0x01ba;
    L_0x01b5:
        goto L_0x01ab;
    L_0x01b6:
        r0.R = r1;
        r5 = 1;
        goto L_0x01c4;
    L_0x01ba:
        r1 = 2;
        r5 = 1;
        r0.R = r5;
        goto L_0x01c4;
    L_0x01bf:
        r19 = r6;
        r1 = 2;
        r0.R = r1;
    L_0x01c4:
        r1 = r0.R;
        if (r1 != 0) goto L_0x01cb;
    L_0x01c8:
        return r5;
    L_0x01c9:
        r19 = r6;
    L_0x01cb:
        r1 = r0.R;
        if (r1 != r5) goto L_0x021a;
    L_0x01cf:
        r1 = r0.y;
        if (r1 == 0) goto L_0x021a;
    L_0x01d3:
        r1 = r0.S;
        r1 = r1.c;
        r1 = r1 - r2;
        r3 = 0;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x01f7;
    L_0x01dd:
        r1 = r0.S;
        r1 = r1.d;
        r1 = r1 - r19;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x01f7;
    L_0x01e7:
        r1 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r3 = 1;
        r1 = r1 | r3;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r1;
        r22.S();
        r1 = 83;
    L_0x01f2:
        r4 = 0;
        r0.a(r3, r1, r4);
        goto L_0x0217;
    L_0x01f7:
        r1 = r0.S;
        r1 = r1.c;
        r1 = r1 - r2;
        r3 = 0;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x0217;
    L_0x0201:
        r1 = r0.S;
        r1 = r1.d;
        r1 = r1 - r19;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x0217;
    L_0x020b:
        r1 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r3 = 1;
        r1 = r1 | r3;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r1;
        r22.S();
        r1 = 87;
        goto L_0x01f2;
    L_0x0217:
        r4 = r0;
        goto L_0x0355;
    L_0x021a:
        r1 = r0.R;
        r5 = 4;
        r6 = 3;
        r9 = 2;
        if (r1 == r9) goto L_0x0229;
    L_0x0221:
        r1 = r0.R;
        if (r1 == r5) goto L_0x0229;
    L_0x0225:
        r1 = r0.R;
        if (r1 != r6) goto L_0x0217;
    L_0x0229:
        r1 = r19 - r2;
        r9 = (double) r1;
        r11 = r8 - r7;
        r12 = (double) r11;
        r9 = java.lang.Math.atan2(r9, r12);
        r12 = r0.S;
        r12 = r12.d;
        r13 = r0.S;
        r13 = r13.c;
        r12 = r12 - r13;
        r12 = (double) r12;
        r14 = r0.S;
        r14 = r14.b;
        r5 = r0.S;
        r5 = r5.a;
        r14 = r14 - r5;
        r20 = r7;
        r6 = (double) r14;
        r5 = java.lang.Math.atan2(r12, r6);
        r9 = r9 - r5;
        r11 = r11 * r11;
        r1 = r1 * r1;
        r11 = r11 + r1;
        r5 = (double) r11;
        r5 = java.lang.Math.sqrt(r5);
        r1 = r0.S;
        r11 = r1.h;
        r5 = r5 / r11;
        r11 = java.lang.Math.log(r5);
        r3 = java.lang.Math.log(r3);
        r11 = r11 / r3;
        r11 = r11 * r17;
        r1 = (int) r11;
        r3 = r0.S;
        r3 = r3.g;
        r4 = r0.S;
        r4 = r4.c;
        r3 = r3 - r4;
        r3 = (double) r3;
        r7 = r0.S;
        r7 = r7.f;
        r11 = r0.S;
        r11 = r11.a;
        r7 = r7 - r11;
        r11 = (double) r7;
        r3 = java.lang.Math.atan2(r3, r11);
        r7 = r0.S;
        r7 = r7.f;
        r11 = r0.S;
        r11 = r11.a;
        r7 = r7 - r11;
        r11 = r0.S;
        r11 = r11.f;
        r12 = r0.S;
        r12 = r12.a;
        r11 = r11 - r12;
        r7 = r7 * r11;
        r11 = r0.S;
        r11 = r11.g;
        r12 = r0.S;
        r12 = r12.c;
        r11 = r11 - r12;
        r12 = r0.S;
        r12 = r12.g;
        r13 = r0.S;
        r13 = r13.c;
        r12 = r12 - r13;
        r11 = r11 * r12;
        r7 = r7 + r11;
        r11 = (double) r7;
        r11 = java.lang.Math.sqrt(r11);
        r3 = r3 + r9;
        r13 = java.lang.Math.cos(r3);
        r13 = r13 * r11;
        r13 = r13 * r5;
        r21 = r1;
        r7 = r20;
        r0 = (double) r7;
        r13 = r13 + r0;
        r0 = (float) r13;
        r3 = java.lang.Math.sin(r3);
        r11 = r11 * r3;
        r11 = r11 * r5;
        r3 = (double) r2;
        r11 = r11 + r3;
        r1 = (float) r11;
        r9 = r9 * r15;
        r3 = 4614256673094690983; // 0x400921ff2e48e8a7 float:4.5681372E-11 double:3.1416;
        r9 = r9 / r3;
        r3 = (int) r9;
        r9 = 0;
        r4 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        r9 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
        if (r4 <= 0) goto L_0x0326;
    L_0x02d2:
        r4 = r22;
        r10 = r4.R;
        r11 = 3;
        if (r11 == r10) goto L_0x02e9;
    L_0x02d9:
        r10 = r21;
        r12 = java.lang.Math.abs(r10);
        r13 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r12 <= r13) goto L_0x0328;
    L_0x02e3:
        r12 = r4.R;
        r13 = 2;
        if (r13 != r12) goto L_0x0328;
    L_0x02e8:
        goto L_0x02eb;
    L_0x02e9:
        r10 = r21;
    L_0x02eb:
        r4.R = r11;
        r3 = r22.E();
        r3 = r3.a;
        r11 = r4.f;
        if (r11 == 0) goto L_0x0349;
    L_0x02f7:
        r11 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r13 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1));
        if (r13 <= 0) goto L_0x0313;
    L_0x02fd:
        r5 = r4.a;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 < 0) goto L_0x0305;
    L_0x0303:
        r5 = 0;
        return r5;
    L_0x0305:
        r3 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r6 = 1;
        r3 = r3 | r6;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r3;
        r22.S();
        r11 = 3;
    L_0x030f:
        r4.a(r9, r11, r10);
        goto L_0x0349;
    L_0x0313:
        r5 = 0;
        r6 = 1;
        r11 = 3;
        r12 = r4.b;
        r3 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1));
        if (r3 > 0) goto L_0x031d;
    L_0x031c:
        return r5;
    L_0x031d:
        r3 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r3 = r3 | r6;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r3;
        r22.S();
        goto L_0x030f;
    L_0x0326:
        r4 = r22;
    L_0x0328:
        if (r3 == 0) goto L_0x0349;
    L_0x032a:
        r5 = r4.R;
        r6 = 4;
        if (r6 == r5) goto L_0x033c;
    L_0x032f:
        r5 = java.lang.Math.abs(r3);
        r10 = 10;
        if (r5 <= r10) goto L_0x0349;
    L_0x0337:
        r5 = r4.R;
        r10 = 2;
        if (r10 != r5) goto L_0x0349;
    L_0x033c:
        r4.R = r6;
        r5 = r4.z;
        if (r5 == 0) goto L_0x0349;
    L_0x0342:
        r22.S();
        r5 = 1;
        r4.a(r9, r5, r3);
    L_0x0349:
        r3 = r4.S;
        r3.f = r0;
        r0 = r4.S;
        r0.g = r1;
        goto L_0x0355;
    L_0x0352:
        r4 = r0;
        r19 = r6;
    L_0x0355:
        r0 = r4.R;
        r1 = 2;
        if (r1 == r0) goto L_0x036c;
    L_0x035a:
        r0 = r4.S;
        r0.c = r2;
        r0 = r4.S;
        r6 = r19;
        r0.d = r6;
        r0 = r4.S;
        r0.a = r7;
        r0 = r4.S;
        r0.b = r8;
    L_0x036c:
        r0 = r4.S;
        r0 = r0.e;
        if (r0 != 0) goto L_0x03c2;
    L_0x0372:
        r0 = r4.S;
        r1 = r4.P;
        r2 = 2;
        r1 = r1 / r2;
        r1 = (float) r1;
        r0.f = r1;
        r0 = r4.S;
        r1 = r4.Q;
        r1 = r1 / r2;
        r1 = (float) r1;
        r0.g = r1;
        r0 = r4.S;
        r1 = 1;
        r0.e = r1;
        r0 = r4.S;
        r0 = r0.h;
        r2 = 0;
        r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r5 != 0) goto L_0x03c2;
    L_0x0392:
        r0 = r4.S;
        r0 = r0.b;
        r1 = r4.S;
        r1 = r1.a;
        r0 = r0 - r1;
        r1 = r4.S;
        r1 = r1.b;
        r2 = r4.S;
        r2 = r2.a;
        r1 = r1 - r2;
        r0 = r0 * r1;
        r1 = r4.S;
        r1 = r1.d;
        r2 = r4.S;
        r2 = r2.c;
        r1 = r1 - r2;
        r2 = r4.S;
        r2 = r2.d;
        r3 = r4.S;
        r3 = r3.c;
        r2 = r2 - r3;
        r1 = r1 * r2;
        r0 = r0 + r1;
        r0 = (double) r0;
        r0 = java.lang.Math.sqrt(r0);
        r2 = r4.S;
        r2.h = r0;
    L_0x03c2:
        r0 = 1;
        return r0;
    L_0x03c4:
        r4 = r0;
        r0 = r5;
        r2 = r23.getAction();
        switch(r2) {
            case 0: goto L_0x03d8;
            case 1: goto L_0x03d3;
            case 2: goto L_0x03cf;
            default: goto L_0x03cd;
        };
    L_0x03cd:
        r0 = 0;
        return r0;
    L_0x03cf:
        r22.c(r23);
        return r0;
    L_0x03d3:
        r0 = r22.d(r23);
        return r0;
    L_0x03d8:
        r22.b(r23);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.e.a(android.view.MotionEvent):boolean");
    }

    public boolean a(String str, String str2) {
        return this.i.a(str, str2);
    }

    public GeoPoint b(int i, int i2) {
        return this.M.a(i, i2);
    }

    /* Access modifiers changed, original: 0000 */
    public void b(float f, float f2) {
        if (!this.S.e) {
            this.ad = System.currentTimeMillis();
            if (this.ad - this.ac >= 400 || Math.abs(f - this.Z) >= 120.0f || Math.abs(f2 - this.aa) >= 120.0f) {
                this.ac = this.ad;
            } else {
                this.ac = 0;
                this.ae = true;
            }
            this.Z = f;
            this.aa = f2;
            a(4, 0, ((int) f) | (((int) f2) << 16));
            this.ab = true;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i) {
        if (this.i != null) {
            this.i.b(i);
            this.i = null;
        }
    }

    public void b(Bundle bundle) {
        if (this.i != null) {
            g(bundle);
            this.i.f(bundle);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(Handler handler) {
        MessageCenter.unregistMessage(m_AppUI.MSG_APP_SAVESCREEN, handler);
        MessageCenter.unregistMessage(41, handler);
        MessageCenter.unregistMessage(49, handler);
        MessageCenter.unregistMessage(39, handler);
        MessageCenter.unregistMessage(m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.unregistMessage(50, handler);
        MessageCenter.unregistMessage(999, handler);
        BaseMapCallback.removeLayerDataInterface(this.j);
    }

    public void b(boolean z) {
        this.A = z;
    }

    public boolean b() {
        return this.A;
    }

    public void c() {
        if (this.i != null) {
            for (d dVar : this.E) {
                this.i.a(dVar.a, false);
            }
        }
    }

    public void c(Bundle bundle) {
        if (this.i != null) {
            g(bundle);
            this.i.g(bundle);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:5:0x001b in {1, 3, 4} preds:[]
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
    public void c(boolean r5) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0010;
        r5 = r4.i;
        r0 = r4.I;
        r0 = r0.a;
        r2 = r4.F;
        r2 = r2.a;
        r5.a(r0, r2);
        return;
        r5 = r4.i;
        r0 = r4.F;
        r0 = r0.a;
        r2 = r4.I;
        r2 = r2.a;
        goto L_0x000c;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.e.c(boolean):void");
    }

    /* Access modifiers changed, original: 0000 */
    public boolean c(float f, float f2) {
        if (this.S.e || System.currentTimeMillis() - m < 300) {
            return true;
        }
        if (this.p) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    GeoPoint b = b((int) f, (int) f2);
                    if (lVar != null) {
                        lVar.d(b);
                    }
                }
            }
            return true;
        }
        float abs = Math.abs(f - this.Z);
        float abs2 = Math.abs(f2 - this.aa);
        float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? ((double) SysOSUtil.getDensity()) * 1.5d : (double) SysOSUtil.getDensity());
        if (this.ab && abs / density <= 3.0f && abs2 / density <= 3.0f) {
            return true;
        }
        this.ab = false;
        int i = (int) f;
        int i2 = (int) f2;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (this.e) {
            this.ag = this.ai;
            this.ah = this.aj;
            this.ai = f;
            this.aj = f2;
            this.ak = this.al;
            this.al = System.currentTimeMillis();
            this.af = true;
            S();
            a(3, 0, (i2 << 16) | i);
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:10:0x0012, code skipped:
            return false;
     */
    public boolean c(int r3, int r4) {
        /*
        r2 = this;
        r0 = 0;
        if (r3 < 0) goto L_0x0012;
    L_0x0003:
        r1 = r2.P;
        r1 = r1 + r0;
        if (r3 > r1) goto L_0x0012;
    L_0x0008:
        if (r4 < 0) goto L_0x0012;
    L_0x000a:
        r3 = r2.Q;
        r3 = r3 + r0;
        if (r4 <= r3) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r3 = 1;
        return r3;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.e.c(int, int):boolean");
    }

    public void d() {
        if (this.i != null) {
            for (d dVar : this.E) {
                if ((dVar instanceof x) || (dVar instanceof a) || (dVar instanceof n)) {
                    this.i.a(dVar.a, false);
                } else {
                    this.i.a(dVar.a, true);
                }
            }
            this.i.c(false);
        }
    }

    public void d(Bundle bundle) {
        if (this.i != null) {
            g(bundle);
            this.i.h(bundle);
        }
    }

    public void d(boolean z) {
        if (this.i != null) {
            this.i.a(this.G.a, z);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean d(float f, float f2) {
        if (this.p) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    GeoPoint b = b((int) f, (int) f2);
                    if (lVar != null) {
                        lVar.e(b);
                    }
                }
            }
            this.p = false;
            return true;
        }
        if (!this.S.e) {
            if (this.ae) {
                return e(f, f2);
            }
            if (this.af) {
                return T();
            }
            if (System.currentTimeMillis() - this.ad < 400 && Math.abs(f - this.Z) < 10.0f && Math.abs(f2 - this.aa) < 10.0f) {
                M();
                return true;
            }
        }
        M();
        int i = (int) f;
        int i2 = (int) f2;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        a(5, 0, i | (i2 << 16));
        return true;
    }

    public void e(boolean z) {
        if (this.i != null) {
            this.i.a(this.B.a, z);
        }
    }

    public boolean e() {
        return (this.B == null || this.i == null) ? false : this.i.c(this.B.a);
    }

    /* Access modifiers changed, original: 0000 */
    public void f() {
        if (this.i != null) {
            this.M = new af(this.i);
        }
    }

    public void f(boolean z) {
        if (this.i != null) {
            this.i.a(this.am.a, z);
        }
    }

    public void g(boolean z) {
        if (this.i != null) {
            this.x = z;
            this.i.b(this.x);
        }
    }

    public boolean g() {
        return this.s;
    }

    public String h() {
        return this.i == null ? null : this.i.e(this.G.a);
    }

    public void h(boolean z) {
        if (this.i != null) {
            this.s = z;
            this.i.c(this.s);
        }
    }

    public void i(boolean z) {
        if (this.i != null) {
            this.i.d(z);
        }
    }

    public boolean i() {
        return this.x;
    }

    public void j(boolean z) {
        if (this.i != null) {
            this.u = z;
            this.i.a(this.G.a, z);
        }
    }

    public boolean j() {
        return this.i == null ? false : this.i.k();
    }

    public void k(boolean z) {
        float f = z ? 22.0f : 21.0f;
        this.a = f;
        this.c = f;
        this.i.e(z);
        this.i.d(this.ap.a);
        this.i.d(this.aq.a);
    }

    public boolean k() {
        return this.t;
    }

    public boolean l() {
        return this.i.a(this.am.a);
    }

    public void m(boolean z) {
        if (this.i != null) {
            this.v = z;
            this.i.a(this.F.a, z);
        }
    }

    public boolean m() {
        return this.i == null ? false : this.i.o();
    }

    public void n() {
        if (this.i != null) {
            this.i.d(this.I.a);
        }
    }

    public void n(boolean z) {
        if (this.i != null) {
            this.w = z;
            this.i.a(this.J.a, z);
        }
    }

    public void o() {
        if (this.i != null) {
            this.i.p();
            this.i.b(this.J.a);
        }
    }

    public void o(boolean z) {
        this.e = z;
    }

    public MapBaseIndoorMapInfo p() {
        return this.i.q();
    }

    public void p(boolean z) {
        this.f = z;
    }

    public void q(boolean z) {
        this.g = z;
    }

    public boolean q() {
        return this.i.r();
    }

    public void r(boolean z) {
        this.z = z;
    }

    public boolean r() {
        return this.u;
    }

    public void s(boolean z) {
        this.y = z;
    }

    public boolean s() {
        return this.v;
    }

    public void t() {
        if (this.i != null) {
            this.i.b(this.J.a);
        }
    }

    public void t(boolean z) {
        if (this.i != null) {
            this.i.a(this.H.a, z);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void u() {
        if (this.i != null) {
            this.i.e();
        }
    }

    public void u(boolean z) {
        if (this.i != null) {
            this.i.a(this.aq.a, z);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void v() {
        if (this.i != null) {
            this.i.f();
        }
    }

    public void v(boolean z) {
        this.as = z;
    }

    public boolean w() {
        return this.e;
    }

    public boolean x() {
        return this.f;
    }

    public boolean y() {
        return this.z;
    }

    public boolean z() {
        return this.y;
    }
}
