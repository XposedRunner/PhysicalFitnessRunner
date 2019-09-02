package com.baidu.mapapi.map;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapViewLayoutParams.ELayoutMode;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapsdkplatform.comapi.map.ak;
import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comapi.map.l;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(20)
public class WearMapView extends ViewGroup implements OnApplyWindowInsetsListener {
    public static final int BT_INVIEW = 1;
    private static final String b = MapView.class.getSimpleName();
    private static String c = null;
    private static int d = 0;
    private static int r = 0;
    private static int s = 0;
    private static int t = 10;
    private static final SparseArray<Integer> w = new SparseArray();
    private l A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    ScreenShape a = ScreenShape.ROUND;
    private j e;
    private BaiduMap f;
    private ImageView g;
    private Bitmap h;
    private ak i;
    private boolean j = true;
    private Point k;
    private Point l;
    private RelativeLayout m;
    public AnimationTask mTask;
    public Timer mTimer;
    public a mTimerHandler;
    private SwipeDismissView n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private boolean u = true;
    private Context v;
    private boolean x = true;
    private boolean y = true;
    private float z;

    public class AnimationTask extends TimerTask {
        public void run() {
            Message message = new Message();
            message.what = 1;
            WearMapView.this.mTimerHandler.sendMessage(message);
        }
    }

    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    public enum ScreenShape {
        ROUND,
        RECTANGLE,
        UNDETECTED
    }

    private class a extends Handler {
        private final WeakReference<Context> b;

        public a(Context context) {
            this.b = new WeakReference(context);
        }

        public void handleMessage(Message message) {
            if (((Context) this.b.get()) != null) {
                super.handleMessage(message);
                if (message.what == 1 && WearMapView.this.i != null) {
                    WearMapView.this.a(true);
                }
            }
        }
    }

    static {
        w.append(3, Integer.valueOf(2000000));
        w.append(4, Integer.valueOf(1000000));
        w.append(5, Integer.valueOf(500000));
        w.append(6, Integer.valueOf(200000));
        w.append(7, Integer.valueOf(100000));
        w.append(8, Integer.valueOf(50000));
        w.append(9, Integer.valueOf(25000));
        w.append(10, Integer.valueOf(20000));
        w.append(11, Integer.valueOf(10000));
        w.append(12, Integer.valueOf(5000));
        w.append(13, Integer.valueOf(2000));
        w.append(14, Integer.valueOf(1000));
        w.append(15, Integer.valueOf(500));
        w.append(16, Integer.valueOf(200));
        w.append(17, Integer.valueOf(100));
        w.append(18, Integer.valueOf(50));
        w.append(19, Integer.valueOf(20));
        w.append(20, Integer.valueOf(10));
        w.append(21, Integer.valueOf(5));
        w.append(22, Integer.valueOf(2));
    }

    public WearMapView(Context context) {
        super(context);
        a(context, null);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, null);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, null);
    }

    public WearMapView(Context context, BaiduMapOptions baiduMapOptions) {
        super(context);
        a(context, baiduMapOptions);
    }

    private int a(int i, int i2) {
        return i - ((int) Math.sqrt(Math.pow((double) i, 2.0d) - Math.pow((double) i2, 2.0d)));
    }

    private void a(int i) {
        if (this.e != null) {
            switch (i) {
                case 0:
                    this.e.onPause();
                    b();
                    return;
                case 1:
                    this.e.onResume();
                    c();
                    return;
                default:
                    return;
            }
        }
    }

    private static void a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        r = point.x;
        s = point.y;
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions) {
        a(context);
        setOnApplyWindowInsetsListener(this);
        this.v = context;
        this.mTimerHandler = new a(context);
        this.mTimer = new Timer();
        if (!(this.mTimer == null || this.mTask == null)) {
            this.mTask.cancel();
        }
        this.mTask = new AnimationTask();
        this.mTimer.schedule(this.mTask, 5000);
        i.a();
        BMapManager.init();
        a(context, baiduMapOptions, c);
        this.f = new BaiduMap(this.e);
        this.e.a().s(false);
        this.e.a().r(false);
        c(context);
        d(context);
        b(context);
        if (!(baiduMapOptions == null || baiduMapOptions.h)) {
            this.i.setVisibility(4);
        }
        e(context);
        if (!(baiduMapOptions == null || baiduMapOptions.i)) {
            this.m.setVisibility(4);
        }
        if (!(baiduMapOptions == null || baiduMapOptions.l == null)) {
            this.l = baiduMapOptions.l;
        }
        if (baiduMapOptions != null && baiduMapOptions.k != null) {
            this.k = baiduMapOptions.k;
        }
    }

    private void a(Context context, BaiduMapOptions baiduMapOptions, String str) {
        if (baiduMapOptions == null) {
            this.e = new j(context, null, str, d);
        } else {
            this.e = new j(context, baiduMapOptions.a(), str, d);
        }
        addView(this.e);
        this.A = new w(this);
        this.e.a().a(this.A);
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0062 in {2, 4, 5} preds:[]
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
    private void a(android.view.View r9, boolean r10) {
        /*
        r8 = this;
        r0 = 1200; // 0x4b0 float:1.682E-42 double:5.93E-321;
        r2 = 1;
        r3 = 0;
        r4 = 2;
        if (r10 == 0) goto L_0x003a;
        r10 = new android.animation.AnimatorSet;
        r10.<init>();
        r5 = "TranslationY";
        r6 = new float[r4];
        r6 = {0, -1035468800};
        r5 = android.animation.ObjectAnimator.ofFloat(r9, r5, r6);
        r6 = "alpha";
        r7 = new float[r4];
        r7 = {1065353216, 0};
        r6 = android.animation.ObjectAnimator.ofFloat(r9, r6, r7);
        r4 = new android.animation.Animator[r4];
        r4[r3] = r5;
        r4[r2] = r6;
        r10.playTogether(r4);
        r2 = new com.baidu.mapapi.map.z;
        r2.<init>(r8, r9);
        r10.addListener(r2);
        r10.setDuration(r0);
        r10.start();
        return;
        r9.setVisibility(r3);
        r10 = new android.animation.AnimatorSet;
        r10.<init>();
        r5 = "TranslationY";
        r6 = new float[r4];
        r6 = {-1035468800, 0};
        r5 = android.animation.ObjectAnimator.ofFloat(r9, r5, r6);
        r6 = "alpha";
        r7 = new float[r4];
        r7 = {0, 1065353216};
        r9 = android.animation.ObjectAnimator.ofFloat(r9, r6, r7);
        r4 = new android.animation.Animator[r4];
        r4[r3] = r5;
        r4[r2] = r9;
        r10.playTogether(r4);
        goto L_0x0033;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.WearMapView.a(android.view.View, boolean):void");
    }

    private void a(boolean z) {
        if (this.j) {
            a(this.i, z);
        }
    }

    private void b() {
        if (!(this.e == null || this.u)) {
            d();
            this.u = true;
        }
    }

    private void b(Context context) {
        this.n = new SwipeDismissView(context, this);
        LayoutParams layoutParams = new LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 34.0f) + 0.5f), s);
        this.n.setBackgroundColor(Color.argb(0, 0, 0, 0));
        this.n.setLayoutParams(layoutParams);
        addView(this.n);
    }

    private void c() {
        if (this.e != null && this.u) {
            e();
            this.u = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    private void c(android.content.Context r10) {
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
        r9.h = r0;
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
        r9.h = r2;
    L_0x0040:
        r0 = r9.h;
        if (r0 == 0) goto L_0x0057;
    L_0x0044:
        r0 = new android.widget.ImageView;
        r0.<init>(r10);
        r9.g = r0;
        r10 = r9.g;
        r0 = r9.h;
        r10.setImageBitmap(r0);
        r10 = r9.g;
        r9.addView(r10);
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.WearMapView.c(android.content.Context):void");
    }

    private void d() {
        if (this.e != null) {
            this.e.b();
        }
    }

    private void d(Context context) {
        this.i = new ak(context, true);
        if (this.i.a()) {
            this.i.b(new x(this));
            this.i.a(new y(this));
            addView(this.i);
        }
    }

    private void e() {
        if (this.e != null) {
            this.e.c();
        }
    }

    private void e(Context context) {
        this.m = new RelativeLayout(context);
        this.m.setLayoutParams(new LayoutParams(-2, -2));
        this.o = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        this.o.setTextColor(Color.parseColor("#FFFFFF"));
        this.o.setTextSize(2, 11.0f);
        this.o.setTypeface(this.o.getTypeface(), 1);
        this.o.setLayoutParams(layoutParams);
        this.o.setId(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.m.addView(this.o);
        this.p = new TextView(context);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        this.p.setTextColor(Color.parseColor("#000000"));
        this.p.setTextSize(2, 11.0f);
        this.p.setLayoutParams(layoutParams);
        this.m.addView(this.p);
        this.q = new ImageView(context);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.o.getId());
        this.q.setLayoutParams(layoutParams);
        Bitmap a = com.baidu.mapsdkplatform.comapi.commonutils.a.a("icon_scale.9.png", context);
        byte[] ninePatchChunk = a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        this.q.setBackgroundDrawable(new NinePatchDrawable(a, ninePatchChunk, new Rect(), null));
        this.m.addView(this.q);
        addView(this.m);
    }

    public static void setCustomMapStylePath(String str) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("customMapStylePath String is illegal");
        } else if (new File(str).exists()) {
            c = str;
        } else {
            throw new RuntimeException("please check whether the customMapStylePath file exits");
        }
    }

    public static void setIconCustom(int i) {
        d = i;
    }

    public static void setMapCustomEnable(boolean z) {
        i.a(z);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (layoutParams instanceof MapViewLayoutParams) {
            super.addView(view, layoutParams);
        }
    }

    public final BaiduMap getMap() {
        this.f.c = this;
        return this.f;
    }

    public final int getMapLevel() {
        return ((Integer) w.get((int) this.e.a().E().a)).intValue();
    }

    public int getScaleControlViewHeight() {
        return this.F;
    }

    public int getScaleControlViewWidth() {
        return this.G;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x000e in {2, 4, 5} preds:[]
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
    public android.view.WindowInsets onApplyWindowInsets(android.view.View r1, android.view.WindowInsets r2) {
        /*
        r0 = this;
        r1 = r2.isRound();
        if (r1 == 0) goto L_0x000b;
        r1 = com.baidu.mapapi.map.WearMapView.ScreenShape.ROUND;
        r0.a = r1;
        return r2;
        r1 = com.baidu.mapapi.map.WearMapView.ScreenShape.RECTANGLE;
        goto L_0x0008;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.WearMapView.onApplyWindowInsets(android.view.View, android.view.WindowInsets):android.view.WindowInsets");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x006f in {1, 4, 6, 9, 12, 13} preds:[]
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
        c = r0;
        if (r7 != 0) goto L_0x0016;
        r7 = new com.baidu.mapapi.map.BaiduMapOptions;
        r7.<init>();
        r5.a(r6, r7);
        return;
        r0 = "mapstatus";
        r0 = r7.getParcelable(r0);
        r0 = (com.baidu.mapapi.map.MapStatus) r0;
        r1 = r5.k;
        if (r1 == 0) goto L_0x002c;
        r1 = "scalePosition";
        r1 = r7.getParcelable(r1);
        r1 = (android.graphics.Point) r1;
        r5.k = r1;
        r1 = r5.l;
        if (r1 == 0) goto L_0x003a;
        r1 = "zoomPosition";
        r1 = r7.getParcelable(r1);
        r1 = (android.graphics.Point) r1;
        r5.l = r1;
        r1 = "mZoomControlEnabled";
        r1 = r7.getBoolean(r1);
        r5.x = r1;
        r1 = "mScaleControlEnabled";
        r1 = r7.getBoolean(r1);
        r5.y = r1;
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.WearMapView.onCreate(android.content.Context, android.os.Bundle):void");
    }

    public final void onDestroy() {
        if (this.v != null) {
            this.e.b(this.v.hashCode());
        }
        if (!(this.h == null || this.h.isRecycled())) {
            this.h.recycle();
            this.h = null;
        }
        this.i.b();
        BMapManager.destroy();
        i.b();
        if (this.mTask != null) {
            this.mTask.cancel();
        }
        this.v = null;
    }

    public final void onDismiss() {
        removeAllViews();
    }

    public final void onEnterAmbient(Bundle bundle) {
        a(0);
    }

    public void onExitAmbient() {
        a(1);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (this.i.getVisibility() != 0) {
                    if (this.i.getVisibility() == 4) {
                        if (this.mTimer != null) {
                            if (this.mTask != null) {
                                this.mTask.cancel();
                            }
                            this.mTimer.cancel();
                            this.mTask = null;
                            this.mTimer = null;
                        }
                        a(false);
                        break;
                    }
                } else if (this.mTimer != null) {
                    if (this.mTask != null) {
                        this.mTimer.cancel();
                        this.mTask.cancel();
                    }
                    this.mTimer = null;
                    this.mTask = null;
                    break;
                }
                break;
            case 1:
                this.mTimer = new Timer();
                if (!(this.mTimer == null || this.mTask == null)) {
                    this.mTask.cancel();
                }
                this.mTask = new AnimationTask();
                this.mTimer.schedule(this.mTask, 5000);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* Access modifiers changed, original: protected|final */
    @TargetApi(20)
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int childCount = getChildCount();
        a(this.g);
        float f2 = 1.0f;
        if (((getWidth() - this.B) - this.C) - this.g.getMeasuredWidth() <= 0 || ((getHeight() - this.D) - this.E) - this.g.getMeasuredHeight() <= 0) {
            this.B = 0;
            this.C = 0;
            this.E = 0;
            this.D = 0;
            f = 1.0f;
        } else {
            f2 = ((float) ((getWidth() - this.B) - this.C)) / ((float) getWidth());
            f = ((float) ((getHeight() - this.D) - this.E)) / ((float) getHeight());
        }
        for (i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int i5;
            int i6;
            int a;
            int i7;
            if (childAt == this.e) {
                this.e.layout(0, 0, getWidth(), getHeight());
            } else if (childAt == this.g) {
                i5 = (int) (((float) this.E) + (12.0f * f));
                if (this.a == ScreenShape.ROUND) {
                    a(this.i);
                    i6 = r / 2;
                    a = a(i6, this.i.getMeasuredWidth() / 2);
                    i6 = t + ((r / 2) - a(i6, i6 - a));
                } else {
                    i6 = 0;
                    a = i6;
                }
                i7 = (s - a) - i5;
                a = r - i6;
                this.g.layout(a - this.g.getMeasuredWidth(), i7 - this.g.getMeasuredHeight(), a, i7);
            } else if (childAt == this.i) {
                if (this.i.a()) {
                    a(this.i);
                    if (this.l == null) {
                        i5 = (int) (((12.0f * f) + ((float) this.D)) + ((float) (this.a == ScreenShape.ROUND ? a(s / 2, this.i.getMeasuredWidth() / 2) : 0)));
                        i6 = (r - this.i.getMeasuredWidth()) / 2;
                        this.i.layout(i6, i5, this.i.getMeasuredWidth() + i6, this.i.getMeasuredHeight() + i5);
                    } else {
                        this.i.layout(this.l.x, this.l.y, this.l.x + this.i.getMeasuredWidth(), this.l.y + this.i.getMeasuredHeight());
                    }
                }
            } else if (childAt == this.m) {
                if (this.a == ScreenShape.ROUND) {
                    a(this.i);
                    i5 = r / 2;
                    i6 = a(i5, this.i.getMeasuredWidth() / 2);
                    i5 = t + ((r / 2) - a(i5, i5 - i6));
                } else {
                    i5 = 0;
                    i6 = i5;
                }
                a(this.m);
                if (this.k == null) {
                    a = (int) (((float) this.E) + (12.0f * f));
                    this.G = this.m.getMeasuredWidth();
                    this.F = this.m.getMeasuredHeight();
                    i5 = (int) ((((float) this.B) + (5.0f * f2)) + ((float) i5));
                    i7 = (s - a) - i6;
                    this.m.layout(i5, i7 - this.m.getMeasuredHeight(), this.G + i5, i7);
                } else {
                    this.m.layout(this.k.x, this.k.y, this.k.x + this.m.getMeasuredWidth(), this.k.y + this.m.getMeasuredHeight());
                }
            } else if (childAt == this.n) {
                a(this.n);
                this.n.layout(0, 0, this.n.getMeasuredWidth(), s);
            } else {
                LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof MapViewLayoutParams) {
                    MapViewLayoutParams mapViewLayoutParams = (MapViewLayoutParams) layoutParams;
                    Point a2 = mapViewLayoutParams.c == ELayoutMode.absoluteMode ? mapViewLayoutParams.b : this.e.a().a(CoordUtil.ll2mc(mapViewLayoutParams.a));
                    a(childAt);
                    i7 = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    int i8 = (int) (((float) a2.x) - (mapViewLayoutParams.d * ((float) i7)));
                    a = ((int) (((float) a2.y) - (mapViewLayoutParams.e * ((float) measuredHeight)))) + mapViewLayoutParams.f;
                    childAt.layout(i8, a, i7 + i8, measuredHeight + a);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null && this.f != null) {
            bundle.putParcelable("mapstatus", this.f.getMapStatus());
            if (this.k != null) {
                bundle.putParcelable("scalePosition", this.k);
            }
            if (this.l != null) {
                bundle.putParcelable("zoomPosition", this.l);
            }
            bundle.putBoolean("mZoomControlEnabled", this.x);
            bundle.putBoolean("mScaleControlEnabled", this.y);
            bundle.putInt("paddingLeft", this.B);
            bundle.putInt("paddingTop", this.D);
            bundle.putInt("paddingRight", this.C);
            bundle.putInt("paddingBottom", this.E);
            bundle.putString("customMapPath", c);
        }
    }

    public void removeView(View view) {
        if (view != this.g) {
            super.removeView(view);
        }
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        if (this.n != null) {
            this.n.setCallback(onDismissCallback);
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.B = i;
        this.D = i2;
        this.C = i3;
        this.E = i4;
    }

    public void setScaleControlPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.k = point;
            requestLayout();
        }
    }

    public void setShape(ScreenShape screenShape) {
        this.a = screenShape;
    }

    public void setViewAnimitionEnable(boolean z) {
        this.j = z;
    }

    public void setZoomControlsPosition(Point point) {
        if (point != null && point.x >= 0 && point.y >= 0 && point.x <= getWidth() && point.y <= getHeight()) {
            this.l = point;
            requestLayout();
        }
    }

    public void showScaleControl(boolean z) {
        this.m.setVisibility(z ? 0 : 8);
        this.y = z;
    }

    public void showZoomControls(boolean z) {
        if (this.i.a()) {
            this.i.setVisibility(z ? 0 : 8);
            this.x = z;
        }
    }
}
