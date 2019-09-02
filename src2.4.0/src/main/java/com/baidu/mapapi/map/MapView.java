package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.commonutils.a;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.l;
import java.io.File;

public final class MapView extends ViewGroup {
    private static final String a = "MapView";
    private static String b;
    private static int c;
    private static final SparseArray<Integer> p = new SparseArray();
    private int A;
    private j d;
    private BaiduMap e;
    private ImageView f;
    private Bitmap g;
    private ak h;
    private Point i;
    private Point j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private Context o;
    private int q = LogoPosition.logoPostionleftBottom.ordinal();
    private boolean r = true;
    private boolean s = true;
    private float t;
    private l u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    static {
        p.append(3, Integer.valueOf(2000000));
        p.append(4, Integer.valueOf(1000000));
        p.append(5, Integer.valueOf(500000));
        p.append(6, Integer.valueOf(200000));
        p.append(7, Integer.valueOf(100000));
        p.append(8, Integer.valueOf(50000));
        p.append(9, Integer.valueOf(25000));
        p.append(10, Integer.valueOf(20000));
        p.append(11, Integer.valueOf(10000));
        p.append(12, Integer.valueOf(5000));
        p.append(13, Integer.valueOf(2000));
        p.append(14, Integer.valueOf(1000));
        p.append(15, Integer.valueOf(500));
        p.append(16, Integer.valueOf(200));
        p.append(17, Integer.valueOf(100));
        p.append(18, Integer.valueOf(50));
        p.append(19, Integer.valueOf(20));
        p.append(20, Integer.valueOf(10));
        p.append(21, Integer.valueOf(5));
        p.append(22, Integer.valueOf(2));
        p.append(23, Integer.valueOf(2));
        p.append(24, Integer.valueOf(2));
        p.append(25, Integer.valueOf(2));
        p.append(26, Integer.valueOf(2));
    }

    public MapView(Context context) {
        super(context);
        a(context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, null);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, null);
    }

    public MapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        a(context, baiduMapOptions);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    private void a(android.content.Context r10) {
        /*
        r9 = this;
        r0 = "logo_h.png";
        r1 = com.baidu.mapapi.common.SysOSUtil.getDensityDpi();
        r2 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;
        if (r1 >= r2) goto L_0x000c;
    L_0x000a:
        r0 = "logo_l.png";
    L_0x000c:
        r2 = com.baidu.mapsdkplatform.comapi.commonutils.a.a(r0, r10);
        r0 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        if (r1 <= r0) goto L_0x0030;
    L_0x0014:
        r7 = new android.graphics.Matrix;
        r7.<init>();
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x001b:
        r7.postScale(r0, r0);
        r3 = 0;
        r4 = 0;
        r5 = r2.getWidth();
        r6 = r2.getHeight();
        r8 = 1;
        r0 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8);
        r9.g = r0;
        goto L_0x0040;
    L_0x0030:
        r3 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        if (r1 <= r3) goto L_0x003e;
    L_0x0034:
        if (r1 > r0) goto L_0x003e;
    L_0x0036:
        r7 = new android.graphics.Matrix;
        r7.<init>();
        r0 = 1069547520; // 0x3fc00000 float:1.5 double:5.28426686E-315;
        goto L_0x001b;
    L_0x003e:
        r9.g = r2;
    L_0x0040:
        r0 = r9.g;
        if (r0 == 0) goto L_0x0057;
    L_0x0044:
        r0 = new android.widget.ImageView;
        r0.<init>(r10);
        r9.f = r0;
        r10 = r9.f;
        r0 = r9.g;
        r10.setImageBitmap(r0);
        r10 = r9.f;
        r9.addView(r10);
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.MapView.a(android.content.Context):void");
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        this.o = context;
        i.a();
        BMapManager.init();
        a(context, baiduMapOptions, b, c);
        this.e = new BaiduMap(this.d);
        a(context);
        b(context);
        if (!(baiduMapOptions == null || baiduMapOptions.h)) {
            this.h.setVisibility(4);
        }
        c(context);
        if (!(baiduMapOptions == null || baiduMapOptions.i)) {
            this.k.setVisibility(4);
        }
        if (!(baiduMapOptions == null || baiduMapOptions.j == null)) {
            this.q = baiduMapOptions.j.ordinal();
        }
        if (!(baiduMapOptions == null || baiduMapOptions.l == null)) {
            this.j = baiduMapOptions.l;
        }
        if (baiduMapOptions != null && baiduMapOptions.k != null) {
            this.i = baiduMapOptions.k;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        if (baiduMapOptions == null) {
            this.d = new j(context, null, str, i);
        } else {
            this.d = new j(context, baiduMapOptions.a(), str, i);
        }
        addView(this.d);
        this.u = new k(this);
        this.d.a().a(this.u);
    }

    private void a(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -2);
        }
        int i = layoutParams.width;
        i = i > 0 ? MeasureSpec.makeMeasureSpec(i, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0);
        int i2 = layoutParams.height;
        view.measure(i, i2 > 0 ? MeasureSpec.makeMeasureSpec(i2, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void b() {
        if (this.h.a()) {
            float f = this.d.a().E().a;
            boolean z = false;
            this.h.b(f > this.d.a().b);
            ak akVar = this.h;
            if (f < this.d.a().a) {
                z = true;
            }
            akVar.a(z);
        }
    }

    private void b(Context context) {
        this.h = new ak(context, false);
        if (this.h.a()) {
            this.h.b(new l(this));
            this.h.a(new m(this));
            addView(this.h);
        }
    }

    private void c(Context context) {
        this.k = new RelativeLayout(context);
        this.k.setLayoutParams(new LayoutParams(-2, -2));
        this.l = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.l.setTextColor(Color.parseColor("#FFFFFF"));
        this.l.setTextSize(2, 11.0f);
        this.l.setTypeface(this.l.getTypeface(), 1);
        this.l.setLayoutParams(layoutParams);
        this.l.setId(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.k.addView(this.l);
        this.m = new TextView(context);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        this.m.setTextColor(Color.parseColor("#000000"));
        this.m.setTextSize(2, 11.0f);
        this.m.setLayoutParams(layoutParams);
        this.k.addView(this.m);
        this.n = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.l.getId());
        this.n.setLayoutParams(layoutParams);
        Bitmap a = a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.n.setBackgroundDrawable(new NinePatchDrawable(a, ninePatchChunk, new Rect(), null));
        this.k.addView(this.n);
        addView(this.k);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        } else if (new File(str).exists()) {
            b = str;
        } else {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
    }

    public static void setIconCustom(int i) {
        c = i;
    }

    public static void setMapCustomEnable(boolean z) {
        i.a(z);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public void cancelRenderMap() {
        this.d.a().v(false);
        this.d.a().P().clear();
    }

    public final LogoPosition getLogoPosition() {
        switch (this.q) {
            case 1:
                return LogoPosition.logoPostionleftTop;
            case 2:
                return LogoPosition.logoPostionCenterBottom;
            case 3:
                return LogoPosition.logoPostionCenterTop;
            case 4:
                return LogoPosition.logoPostionRightBottom;
            case 5:
                return LogoPosition.logoPostionRightTop;
            default:
                return LogoPosition.logoPostionleftBottom;
        }
    }

    public final BaiduMap getMap() {
        this.e.a = this;
        return this.e;
    }

    public final int getMapLevel() {
        return ((Integer) p.get((int) this.d.a().E().a)).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.z;
    }

    public int getScaleControlViewWidth() {
        return this.A;
    }

    public boolean handleMultiTouch(float f, float f2, float f3, float f4) {
        return this.d != null && this.d.a(f, f2, f3, f4);
    }

    public void handleTouchDown(float f, float f2) {
        if (this.d != null) {
            this.d.a(f, f2);
        }
    }

    public boolean handleTouchMove(float f, float f2) {
        return this.d != null && this.d.c(f, f2);
    }

    public boolean handleTouchUp(float f, float f2) {
        return this.d == null ? false : this.d.b(f, f2);
    }

    public boolean inRangeOfView(float f, float f2) {
        return this.d != null && this.d.d(f, f2);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x0077 in {1, 4, 6, 9, 12, 13} preds:[]
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
    public void onCreate(android.content.Context r6, android.os.Bundle r7) {
        /*
        r5 = this;
        if (r7 != 0) goto L_0x0003;
        return;
        r0 = "customMapPath";
        r0 = r7.getString(r0);
        b = r0;
        if (r7 != 0) goto L_0x0016;
        r7 = new com.baidu.mapapi.map.BaiduMapOptions;
        r7.<init>();
        r5.a(r6, r7);
        return;
        r0 = "mapstatus";
        r0 = r7.getParcelable(r0);
        r0 = (com.baidu.mapapi.map.MapStatus) r0;
        r1 = r5.i;
        if (r1 == 0) goto L_0x002c;
        r1 = "scalePosition";
        r1 = r7.getParcelable(r1);
        r1 = (android.graphics.Point) r1;
        r5.i = r1;
        r1 = r5.j;
        if (r1 == 0) goto L_0x003a;
        r1 = "zoomPosition";
        r1 = r7.getParcelable(r1);
        r1 = (android.graphics.Point) r1;
        r5.j = r1;
        r1 = "mZoomControlEnabled";
        r1 = r7.getBoolean(r1);
        r5.r = r1;
        r1 = "mScaleControlEnabled";
        r1 = r7.getBoolean(r1);
        r5.s = r1;
        r1 = "logoPosition";
        r1 = r7.getInt(r1);
        r5.q = r1;
        r1 = "paddingLeft";
        r1 = r7.getInt(r1);
        r2 = "paddingTop";
        r2 = r7.getInt(r2);
        r3 = "paddingRight";
        r3 = r7.getInt(r3);
        r4 = "paddingBottom";
        r7 = r7.getInt(r4);
        r5.setPadding(r1, r2, r3, r7);
        r7 = new com.baidu.mapapi.map.BaiduMapOptions;
        r7.<init>();
        r7 = r7.mapStatus(r0);
        goto L_0x0012;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.MapView.onCreate(android.content.Context, android.os.Bundle):void");
    }

    public final void onDestroy() {
        if (this.o != null) {
            this.d.b(this.o.hashCode());
        }
        if (!(this.g == null || this.g.isRecycled())) {
            this.g.recycle();
            this.g = null;
        }
        if (b != null) {
            b = null;
        }
        this.h.b();
        BMapManager.destroy();
        i.b();
        this.o = null;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:18:0x00b3, code skipped:
            r9 = r1;
            r1 = r0;
            r0 = r9;
     */
    /* JADX WARNING: Missing block: B:21:0x00cc, code skipped:
            r2 = getWidth() - r1;
            r1 = r2 - r10.f.getMeasuredWidth();
     */
    /* JADX WARNING: Missing block: B:24:0x00ef, code skipped:
            r1 = (((getWidth() - r10.f.getMeasuredWidth()) + r10.v) - r10.w) / 2;
            r2 = (((getWidth() + r10.f.getMeasuredWidth()) + r10.v) - r10.w) / 2;
     */
    /* JADX WARNING: Missing block: B:26:0x0125, code skipped:
            r10.f.layout(r1, r3, r2, r0);
     */
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
        r10 = this;
        r11 = r10.getChildCount();
        r12 = r10.f;
        r10.a(r12);
        r12 = r10.getWidth();
        r13 = r10.v;
        r12 = r12 - r13;
        r13 = r10.w;
        r12 = r12 - r13;
        r13 = r10.f;
        r13 = r13.getMeasuredWidth();
        r12 = r12 - r13;
        r13 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r14 = 0;
        if (r12 <= 0) goto L_0x0056;
    L_0x001f:
        r12 = r10.getHeight();
        r15 = r10.x;
        r12 = r12 - r15;
        r15 = r10.y;
        r12 = r12 - r15;
        r15 = r10.f;
        r15 = r15.getMeasuredHeight();
        r12 = r12 - r15;
        if (r12 <= 0) goto L_0x0056;
    L_0x0032:
        r12 = r10.getWidth();
        r13 = r10.v;
        r12 = r12 - r13;
        r13 = r10.w;
        r12 = r12 - r13;
        r12 = (float) r12;
        r13 = r10.getWidth();
        r13 = (float) r13;
        r13 = r12 / r13;
        r12 = r10.getHeight();
        r15 = r10.x;
        r12 = r12 - r15;
        r15 = r10.y;
        r12 = r12 - r15;
        r12 = (float) r12;
        r15 = r10.getHeight();
        r15 = (float) r15;
        r12 = r12 / r15;
        goto L_0x005f;
    L_0x0056:
        r10.v = r14;
        r10.w = r14;
        r10.y = r14;
        r10.x = r14;
        r12 = r13;
    L_0x005f:
        r15 = r14;
    L_0x0060:
        if (r15 >= r11) goto L_0x026a;
    L_0x0062:
        r0 = r10.getChildAt(r15);
        if (r0 != 0) goto L_0x006a;
    L_0x0068:
        goto L_0x0266;
    L_0x006a:
        r1 = r10.d;
        if (r0 != r1) goto L_0x007d;
    L_0x006e:
        r0 = r10.d;
        r1 = r10.getWidth();
        r2 = r10.getHeight();
        r0.layout(r14, r14, r1, r2);
        goto L_0x0266;
    L_0x007d:
        r1 = r10.f;
        r2 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        if (r0 != r1) goto L_0x012c;
    L_0x0083:
        r0 = r10.v;
        r0 = (float) r0;
        r1 = r13 * r2;
        r0 = r0 + r1;
        r0 = (int) r0;
        r3 = r10.w;
        r3 = (float) r3;
        r3 = r3 + r1;
        r1 = (int) r3;
        r3 = r10.x;
        r3 = (float) r3;
        r2 = r2 * r12;
        r3 = r3 + r2;
        r3 = (int) r3;
        r4 = r10.y;
        r4 = (float) r4;
        r4 = r4 + r2;
        r2 = (int) r4;
        r4 = r10.q;
        switch(r4) {
            case 1: goto L_0x0116;
            case 2: goto L_0x00e2;
            case 3: goto L_0x00da;
            case 4: goto L_0x00bf;
            case 5: goto L_0x00b7;
            default: goto L_0x009f;
        };
    L_0x009f:
        r1 = r10.getHeight();
        r1 = r1 - r2;
        r2 = r10.f;
        r2 = r2.getMeasuredWidth();
        r2 = r2 + r0;
        r3 = r10.f;
        r3 = r3.getMeasuredHeight();
        r3 = r1 - r3;
    L_0x00b3:
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0125;
    L_0x00b7:
        r0 = r10.f;
        r0 = r0.getMeasuredHeight();
        r0 = r0 + r3;
        goto L_0x00cc;
    L_0x00bf:
        r0 = r10.getHeight();
        r0 = r0 - r2;
        r2 = r10.f;
        r2 = r2.getMeasuredHeight();
        r3 = r0 - r2;
    L_0x00cc:
        r2 = r10.getWidth();
        r2 = r2 - r1;
        r1 = r10.f;
        r1 = r1.getMeasuredWidth();
        r1 = r2 - r1;
        goto L_0x0125;
    L_0x00da:
        r0 = r10.f;
        r0 = r0.getMeasuredHeight();
        r0 = r0 + r3;
        goto L_0x00ef;
    L_0x00e2:
        r0 = r10.getHeight();
        r0 = r0 - r2;
        r1 = r10.f;
        r1 = r1.getMeasuredHeight();
        r3 = r0 - r1;
    L_0x00ef:
        r1 = r10.getWidth();
        r2 = r10.f;
        r2 = r2.getMeasuredWidth();
        r1 = r1 - r2;
        r2 = r10.v;
        r1 = r1 + r2;
        r2 = r10.w;
        r1 = r1 - r2;
        r1 = r1 / 2;
        r2 = r10.getWidth();
        r4 = r10.f;
        r4 = r4.getMeasuredWidth();
        r2 = r2 + r4;
        r4 = r10.v;
        r2 = r2 + r4;
        r4 = r10.w;
        r2 = r2 - r4;
        r2 = r2 / 2;
        goto L_0x0125;
    L_0x0116:
        r1 = r10.f;
        r1 = r1.getMeasuredHeight();
        r1 = r1 + r3;
        r2 = r10.f;
        r2 = r2.getMeasuredWidth();
        r2 = r2 + r0;
        goto L_0x00b3;
    L_0x0125:
        r4 = r10.f;
        r4.layout(r1, r3, r2, r0);
        goto L_0x0266;
    L_0x012c:
        r1 = r10.h;
        if (r0 != r1) goto L_0x01ac;
    L_0x0130:
        r0 = r10.h;
        r0 = r0.a();
        if (r0 != 0) goto L_0x013a;
    L_0x0138:
        goto L_0x0266;
    L_0x013a:
        r0 = r10.h;
        r10.a(r0);
        r0 = r10.j;
        if (r0 != 0) goto L_0x0187;
    L_0x0143:
        r0 = r10.getHeight();
        r0 = r0 + -15;
        r0 = (float) r0;
        r0 = r0 * r12;
        r1 = r10.x;
        r1 = (float) r1;
        r0 = r0 + r1;
        r0 = (int) r0;
        r1 = r10.getWidth();
        r1 = r1 + -15;
        r1 = (float) r1;
        r1 = r1 * r13;
        r2 = r10.v;
        r2 = (float) r2;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r10.h;
        r2 = r2.getMeasuredWidth();
        r2 = r1 - r2;
        r3 = r10.h;
        r3 = r3.getMeasuredHeight();
        r3 = r0 - r3;
        r4 = r10.q;
        r5 = 4;
        if (r4 != r5) goto L_0x0180;
    L_0x0172:
        r4 = r10.f;
        r4 = r4.getMeasuredHeight();
        r0 = r0 - r4;
        r4 = r10.f;
        r4 = r4.getMeasuredHeight();
        r3 = r3 - r4;
    L_0x0180:
        r4 = r10.h;
        r4.layout(r2, r3, r1, r0);
        goto L_0x0266;
    L_0x0187:
        r0 = r10.h;
        r1 = r10.j;
        r1 = r1.x;
        r2 = r10.j;
        r2 = r2.y;
        r3 = r10.j;
        r3 = r3.x;
        r4 = r10.h;
        r4 = r4.getMeasuredWidth();
        r3 = r3 + r4;
        r4 = r10.j;
        r4 = r4.y;
        r5 = r10.h;
        r5 = r5.getMeasuredHeight();
        r4 = r4 + r5;
        r0.layout(r1, r2, r3, r4);
        goto L_0x0266;
    L_0x01ac:
        r1 = r10.k;
        if (r0 != r1) goto L_0x0215;
    L_0x01b0:
        r0 = r10.k;
        r10.a(r0);
        r0 = r10.i;
        if (r0 != 0) goto L_0x01f1;
    L_0x01b9:
        r0 = r10.y;
        r0 = (float) r0;
        r1 = r12 * r2;
        r0 = r0 + r1;
        r1 = 1113587712; // 0x42600000 float:56.0 double:5.50185432E-315;
        r0 = r0 + r1;
        r0 = (int) r0;
        r1 = r10.k;
        r1 = r1.getMeasuredWidth();
        r10.A = r1;
        r1 = r10.k;
        r1 = r1.getMeasuredHeight();
        r10.z = r1;
        r1 = r10.v;
        r1 = (float) r1;
        r2 = r2 * r13;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r10.getHeight();
        r2 = r2 - r0;
        r0 = r10.f;
        r0 = r0.getMeasuredHeight();
        r2 = r2 - r0;
        r0 = r10.A;
        r0 = r0 + r1;
        r3 = r10.z;
        r3 = r3 + r2;
        r4 = r10.k;
        r4.layout(r1, r2, r0, r3);
        goto L_0x0266;
    L_0x01f1:
        r0 = r10.k;
        r1 = r10.i;
        r1 = r1.x;
        r2 = r10.i;
        r2 = r2.y;
        r3 = r10.i;
        r3 = r3.x;
        r4 = r10.k;
        r4 = r4.getMeasuredWidth();
        r3 = r3 + r4;
        r4 = r10.i;
        r4 = r4.y;
        r5 = r10.k;
        r5 = r5.getMeasuredHeight();
        r4 = r4 + r5;
        r0.layout(r1, r2, r3, r4);
        goto L_0x0266;
    L_0x0215:
        r1 = r0.getLayoutParams();
        if (r1 != 0) goto L_0x0222;
    L_0x021b:
        r2 = "test";
        r3 = "lp == null";
        android.util.Log.e(r2, r3);
    L_0x0222:
        r2 = r1 instanceof com.baidu.mapapi.map.MapViewLayoutParams;
        if (r2 == 0) goto L_0x0266;
    L_0x0226:
        r1 = (com.baidu.mapapi.map.MapViewLayoutParams) r1;
        r2 = r1.c;
        r3 = com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode.absoluteMode;
        if (r2 != r3) goto L_0x0231;
    L_0x022e:
        r2 = r1.b;
        goto L_0x0241;
    L_0x0231:
        r2 = r1.a;
        r2 = com.baidu.mapapi.model.CoordUtil.ll2mc(r2);
        r3 = r10.d;
        r3 = r3.a();
        r2 = r3.a(r2);
    L_0x0241:
        r10.a(r0);
        r3 = r0.getMeasuredWidth();
        r4 = r0.getMeasuredHeight();
        r5 = r1.d;
        r6 = r1.e;
        r7 = r2.x;
        r7 = (float) r7;
        r8 = (float) r3;
        r5 = r5 * r8;
        r7 = r7 - r5;
        r5 = (int) r7;
        r2 = r2.y;
        r2 = (float) r2;
        r7 = (float) r4;
        r6 = r6 * r7;
        r2 = r2 - r6;
        r2 = (int) r2;
        r1 = r1.f;
        r2 = r2 + r1;
        r3 = r3 + r5;
        r4 = r4 + r2;
        r0.layout(r5, r2, r3, r4);
    L_0x0266:
        r15 = r15 + 1;
        goto L_0x0060;
    L_0x026a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.MapView.onLayout(boolean, int, int, int, int):void");
    }

    public final void onPause() {
        this.d.onPause();
    }

    public final void onResume() {
        this.d.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null && this.e != null) {
            bundle.putParcelable("mapstatus", this.e.getMapStatus());
            if (this.i != null) {
                bundle.putParcelable("scalePosition", this.i);
            }
            if (this.j != null) {
                bundle.putParcelable("zoomPosition", this.j);
            }
            bundle.putBoolean("mZoomControlEnabled", this.r);
            bundle.putBoolean("mScaleControlEnabled", this.s);
            bundle.putInt("logoPosition", this.q);
            bundle.putInt("paddingLeft", this.v);
            bundle.putInt("paddingTop", this.x);
            bundle.putInt("paddingRight", this.w);
            bundle.putInt("paddingBottom", this.y);
            bundle.putString("customMapPath", b);
        }
    }

    public void removeView(View view) {
        if (view != this.f) {
            super.removeView(view);
        }
    }

    public void renderMap() {
        e a = this.d.a();
        a.v(true);
        a.Q();
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            logoPosition = LogoPosition.logoPostionleftBottom;
        }
        this.q = logoPosition.ordinal();
        requestLayout();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.v = i;
        this.x = i2;
        this.w = i3;
        this.y = i4;
    }

    public void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.i = point;
            requestLayout();
        }
    }

    public void setUpViewEventToMapView(MotionEvent motionEvent) {
        this.d.onTouchEvent(motionEvent);
    }

    public final void setZOrderMediaOverlay(boolean z) {
        if (this.d != null) {
            this.d.setZOrderMediaOverlay(z);
        }
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.j = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        this.s = z;
    }

    public void showZoomControls(boolean z) {
        if (this.h.a()) {
            this.h.setVisibility(z ? 0 : 8);
            this.r = z;
        }
    }
}
