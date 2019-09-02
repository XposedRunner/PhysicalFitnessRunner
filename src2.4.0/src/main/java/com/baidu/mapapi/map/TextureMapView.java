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
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.commonutils.a;
import com.baidu.mapsdkplatform.comapi.map.ac;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.l;
import java.io.File;

public final class TextureMapView extends ViewGroup {
    private static final String a = "TextureMapView";
    private static String i;
    private static int j;
    private static final SparseArray<Integer> p = new SparseArray();
    private int A;
    private ac b;
    private BaiduMap c;
    private ImageView d;
    private Bitmap e;
    private ak f;
    private Point g;
    private Point h;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private ImageView n;
    private Context o;
    private float q;
    private l r;
    private int s = LogoPosition.logoPostionleftBottom.ordinal();
    private boolean t = true;
    private boolean u = true;
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
    }

    public TextureMapView(Context context) {
        super(context);
        a(context, null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, null);
    }

    public TextureMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, null);
    }

    public TextureMapView(Context context, BaiduMapOptions baiduMapOptions) {
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
        r9.e = r0;
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
        r9.e = r2;
    L_0x0040:
        r0 = r9.e;
        if (r0 == 0) goto L_0x0057;
    L_0x0044:
        r0 = new android.widget.ImageView;
        r0.<init>(r10);
        r9.d = r0;
        r10 = r9.d;
        r0 = r9.e;
        r10.setImageBitmap(r0);
        r10 = r9.d;
        r9.addView(r10);
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.TextureMapView.a(android.content.Context):void");
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        setBackgroundColor(-1);
        this.o = context;
        i.a();
        BMapManager.init();
        a(context, baiduMapOptions, i, j);
        this.c = new BaiduMap(this.b);
        a(context);
        b(context);
        if (!(baiduMapOptions == null || baiduMapOptions.h)) {
            this.f.setVisibility(4);
        }
        c(context);
        if (!(baiduMapOptions == null || baiduMapOptions.i)) {
            this.k.setVisibility(4);
        }
        if (!(baiduMapOptions == null || baiduMapOptions.j == null)) {
            this.s = baiduMapOptions.j.ordinal();
        }
        if (!(baiduMapOptions == null || baiduMapOptions.l == null)) {
            this.h = baiduMapOptions.l;
        }
        if (baiduMapOptions != null && baiduMapOptions.k != null) {
            this.g = baiduMapOptions.k;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str, int i) {
        i = str;
        if (baiduMapOptions == null) {
            this.b = new ac(context, null, str, i);
        } else {
            this.b = new ac(context, baiduMapOptions.a(), str, i);
        }
        addView(this.b);
        this.r = new s(this);
        this.b.b().a(this.r);
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
        if (this.f.a()) {
            float f = this.b.b().E().a;
            boolean z = false;
            this.f.b(f > this.b.b().b);
            ak akVar = this.f;
            if (f < this.b.b().a) {
                z = true;
            }
            akVar.a(z);
        }
    }

    private void b(Context context) {
        this.f = new ak(context);
        if (this.f.a()) {
            this.f.b(new t(this));
            this.f.a(new u(this));
            addView(this.f);
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
            i = str;
        } else {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
    }

    public static void setIconCustom(int i) {
        j = i;
    }

    public static void setMapCustomEnable(boolean z) {
        i.a(z);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public final LogoPosition getLogoPosition() {
        switch (this.s) {
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
        this.c.b = this;
        return this.c;
    }

    public final int getMapLevel() {
        return ((Integer) p.get((int) this.b.b().E().a)).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.A;
    }

    public int getScaleControlViewWidth() {
        return this.A;
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
        i = r0;
        if (r7 != 0) goto L_0x0016;
        r7 = new com.baidu.mapapi.map.BaiduMapOptions;
        r7.<init>();
        r5.a(r6, r7);
        return;
        r0 = "mapstatus";
        r0 = r7.getParcelable(r0);
        r0 = (com.baidu.mapapi.map.MapStatus) r0;
        r1 = r5.g;
        if (r1 == 0) goto L_0x002c;
        r1 = "scalePosition";
        r1 = r7.getParcelable(r1);
        r1 = (android.graphics.Point) r1;
        r5.g = r1;
        r1 = r5.h;
        if (r1 == 0) goto L_0x003a;
        r1 = "zoomPosition";
        r1 = r7.getParcelable(r1);
        r1 = (android.graphics.Point) r1;
        r5.h = r1;
        r1 = "mZoomControlEnabled";
        r1 = r7.getBoolean(r1);
        r5.t = r1;
        r1 = "mScaleControlEnabled";
        r1 = r7.getBoolean(r1);
        r5.u = r1;
        r1 = "logoPosition";
        r1 = r7.getInt(r1);
        r5.s = r1;
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.TextureMapView.onCreate(android.content.Context, android.os.Bundle):void");
    }

    public final void onDestroy() {
        if (this.o != null) {
            this.b.a(this.o.hashCode());
        }
        if (!(this.e == null || this.e.isRecycled())) {
            this.e.recycle();
        }
        this.f.b();
        BMapManager.destroy();
        i.b();
        this.o = null;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:16:0x00af, code skipped:
            r9 = r1;
            r1 = r0;
            r0 = r9;
     */
    /* JADX WARNING: Missing block: B:19:0x00c8, code skipped:
            r2 = getWidth() - r1;
            r1 = r2 - r10.d.getMeasuredWidth();
     */
    /* JADX WARNING: Missing block: B:22:0x00eb, code skipped:
            r1 = (((getWidth() - r10.d.getMeasuredWidth()) + r10.v) - r10.w) / 2;
            r2 = (((getWidth() + r10.d.getMeasuredWidth()) + r10.v) - r10.w) / 2;
     */
    /* JADX WARNING: Missing block: B:24:0x0121, code skipped:
            r10.d.layout(r1, r3, r2, r0);
     */
    @android.annotation.SuppressLint({"NewApi"})
    public final void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
        r10 = this;
        r11 = r10.getChildCount();
        r12 = r10.d;
        r10.a(r12);
        r12 = r10.getWidth();
        r13 = r10.v;
        r12 = r12 - r13;
        r13 = r10.w;
        r12 = r12 - r13;
        r13 = r10.d;
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
        r15 = r10.d;
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
        if (r15 >= r11) goto L_0x025d;
    L_0x0062:
        r0 = r10.getChildAt(r15);
        r1 = r10.b;
        if (r0 != r1) goto L_0x0079;
    L_0x006a:
        r0 = r10.b;
        r1 = r10.getWidth();
        r2 = r10.getHeight();
        r0.layout(r14, r14, r1, r2);
        goto L_0x0259;
    L_0x0079:
        r1 = r10.d;
        r2 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        if (r0 != r1) goto L_0x0128;
    L_0x007f:
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
        r4 = r10.s;
        switch(r4) {
            case 1: goto L_0x0112;
            case 2: goto L_0x00de;
            case 3: goto L_0x00d6;
            case 4: goto L_0x00bb;
            case 5: goto L_0x00b3;
            default: goto L_0x009b;
        };
    L_0x009b:
        r1 = r10.getHeight();
        r1 = r1 - r2;
        r2 = r10.d;
        r2 = r2.getMeasuredWidth();
        r2 = r2 + r0;
        r3 = r10.d;
        r3 = r3.getMeasuredHeight();
        r3 = r1 - r3;
    L_0x00af:
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0121;
    L_0x00b3:
        r0 = r10.d;
        r0 = r0.getMeasuredHeight();
        r0 = r0 + r3;
        goto L_0x00c8;
    L_0x00bb:
        r0 = r10.getHeight();
        r0 = r0 - r2;
        r2 = r10.d;
        r2 = r2.getMeasuredHeight();
        r3 = r0 - r2;
    L_0x00c8:
        r2 = r10.getWidth();
        r2 = r2 - r1;
        r1 = r10.d;
        r1 = r1.getMeasuredWidth();
        r1 = r2 - r1;
        goto L_0x0121;
    L_0x00d6:
        r0 = r10.d;
        r0 = r0.getMeasuredHeight();
        r0 = r0 + r3;
        goto L_0x00eb;
    L_0x00de:
        r0 = r10.getHeight();
        r0 = r0 - r2;
        r1 = r10.d;
        r1 = r1.getMeasuredHeight();
        r3 = r0 - r1;
    L_0x00eb:
        r1 = r10.getWidth();
        r2 = r10.d;
        r2 = r2.getMeasuredWidth();
        r1 = r1 - r2;
        r2 = r10.v;
        r1 = r1 + r2;
        r2 = r10.w;
        r1 = r1 - r2;
        r1 = r1 / 2;
        r2 = r10.getWidth();
        r4 = r10.d;
        r4 = r4.getMeasuredWidth();
        r2 = r2 + r4;
        r4 = r10.v;
        r2 = r2 + r4;
        r4 = r10.w;
        r2 = r2 - r4;
        r2 = r2 / 2;
        goto L_0x0121;
    L_0x0112:
        r1 = r10.d;
        r1 = r1.getMeasuredHeight();
        r1 = r1 + r3;
        r2 = r10.d;
        r2 = r2.getMeasuredWidth();
        r2 = r2 + r0;
        goto L_0x00af;
    L_0x0121:
        r4 = r10.d;
        r4.layout(r1, r3, r2, r0);
        goto L_0x0259;
    L_0x0128:
        r1 = r10.f;
        if (r0 != r1) goto L_0x01a8;
    L_0x012c:
        r0 = r10.f;
        r0 = r0.a();
        if (r0 != 0) goto L_0x0136;
    L_0x0134:
        goto L_0x0259;
    L_0x0136:
        r0 = r10.f;
        r10.a(r0);
        r0 = r10.h;
        if (r0 != 0) goto L_0x0183;
    L_0x013f:
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
        r2 = r10.f;
        r2 = r2.getMeasuredWidth();
        r2 = r1 - r2;
        r3 = r10.f;
        r3 = r3.getMeasuredHeight();
        r3 = r0 - r3;
        r4 = r10.s;
        r5 = 4;
        if (r4 != r5) goto L_0x017c;
    L_0x016e:
        r4 = r10.d;
        r4 = r4.getMeasuredHeight();
        r0 = r0 - r4;
        r4 = r10.d;
        r4 = r4.getMeasuredHeight();
        r3 = r3 - r4;
    L_0x017c:
        r4 = r10.f;
        r4.layout(r2, r3, r1, r0);
        goto L_0x0259;
    L_0x0183:
        r0 = r10.f;
        r1 = r10.h;
        r1 = r1.x;
        r2 = r10.h;
        r2 = r2.y;
        r3 = r10.h;
        r3 = r3.x;
        r4 = r10.f;
        r4 = r4.getMeasuredWidth();
        r3 = r3 + r4;
        r4 = r10.h;
        r4 = r4.y;
        r5 = r10.f;
        r5 = r5.getMeasuredHeight();
        r4 = r4 + r5;
        r0.layout(r1, r2, r3, r4);
        goto L_0x0259;
    L_0x01a8:
        r1 = r10.k;
        if (r0 != r1) goto L_0x0211;
    L_0x01ac:
        r0 = r10.k;
        r10.a(r0);
        r0 = r10.g;
        if (r0 != 0) goto L_0x01ed;
    L_0x01b5:
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
        r0 = r10.d;
        r0 = r0.getMeasuredHeight();
        r2 = r2 - r0;
        r0 = r10.A;
        r0 = r0 + r1;
        r3 = r10.z;
        r3 = r3 + r2;
        r4 = r10.k;
        r4.layout(r1, r2, r0, r3);
        goto L_0x0259;
    L_0x01ed:
        r0 = r10.k;
        r1 = r10.g;
        r1 = r1.x;
        r2 = r10.g;
        r2 = r2.y;
        r3 = r10.g;
        r3 = r3.x;
        r4 = r10.k;
        r4 = r4.getMeasuredWidth();
        r3 = r3 + r4;
        r4 = r10.g;
        r4 = r4.y;
        r5 = r10.k;
        r5 = r5.getMeasuredHeight();
        r4 = r4 + r5;
        r0.layout(r1, r2, r3, r4);
        goto L_0x0259;
    L_0x0211:
        r1 = r0.getLayoutParams();
        r2 = r1 instanceof com.baidu.mapapi.map.MapViewLayoutParams;
        if (r2 == 0) goto L_0x0259;
    L_0x0219:
        r1 = (com.baidu.mapapi.map.MapViewLayoutParams) r1;
        r2 = r1.c;
        r3 = com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode.absoluteMode;
        if (r2 != r3) goto L_0x0224;
    L_0x0221:
        r2 = r1.b;
        goto L_0x0234;
    L_0x0224:
        r2 = r1.a;
        r2 = com.baidu.mapapi.model.CoordUtil.ll2mc(r2);
        r3 = r10.b;
        r3 = r3.b();
        r2 = r3.a(r2);
    L_0x0234:
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
    L_0x0259:
        r15 = r15 + 1;
        goto L_0x0060;
    L_0x025d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.TextureMapView.onLayout(boolean, int, int, int, int):void");
    }

    public final void onPause() {
        this.b.d();
    }

    public final void onResume() {
        this.b.c();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null && this.c != null) {
            bundle.putParcelable("mapstatus", this.c.getMapStatus());
            if (this.g != null) {
                bundle.putParcelable("scalePosition", this.g);
            }
            if (this.h != null) {
                bundle.putParcelable("zoomPosition", this.h);
            }
            bundle.putBoolean("mZoomControlEnabled", this.t);
            bundle.putBoolean("mScaleControlEnabled", this.u);
            bundle.putInt("logoPosition", this.s);
            bundle.putInt("paddingLeft", this.v);
            bundle.putInt("paddingTop", this.x);
            bundle.putInt("paddingRight", this.w);
            bundle.putInt("paddingBottom", this.y);
            bundle.putString("customMapPath", i);
        }
    }

    public void removeView(View view) {
        if (view != this.d) {
            super.removeView(view);
        }
    }

    public final void setLogoPosition(LogoPosition logoPosition) {
        if (logoPosition == null) {
            logoPosition = LogoPosition.logoPostionleftBottom;
        }
        this.s = logoPosition.ordinal();
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
            this.g = point;
            requestLayout();
        }
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.h = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.k.setVisibility(z ? 0 : 8);
        this.u = z;
    }

    public void showZoomControls(boolean z) {
        if (this.f.a()) {
            this.f.setVisibility(z ? 0 : 8);
            this.t = z;
        }
    }
}
