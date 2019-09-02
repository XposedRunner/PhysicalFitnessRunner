package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.a;

public class ak extends LinearLayout implements OnTouchListener {
    private ImageView a;
    private ImageView b;
    private Context c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private int l;
    private boolean m = false;
    private boolean n = false;

    @Deprecated
    public ak(Context context) {
        super(context);
        this.c = context;
        c();
        if (this.d != null && this.e != null && this.f != null && this.g != null) {
            this.a = new ImageView(this.c);
            this.b = new ImageView(this.c);
            this.a.setImageBitmap(this.d);
            this.b.setImageBitmap(this.f);
            this.l = a(this.f.getHeight() / 6);
            a(this.a, "main_topbtn_up.9.png");
            a(this.b, "main_bottombtn_up.9.png");
            this.a.setId(0);
            this.b.setId(1);
            this.a.setClickable(true);
            this.b.setClickable(true);
            this.a.setOnTouchListener(this);
            this.b.setOnTouchListener(this);
            setOrientation(1);
            setLayoutParams(new LayoutParams(-2, -2));
            addView(this.a);
            addView(this.b);
            this.n = true;
        }
    }

    /* JADX WARNING: Missing block: B:12:0x0064, code skipped:
            return;
     */
    public ak(android.content.Context r4, boolean r5) {
        /*
        r3 = this;
        r3.<init>(r4);
        r0 = 0;
        r3.m = r0;
        r3.n = r0;
        r3.c = r4;
        r3.m = r5;
        r4 = new android.widget.ImageView;
        r1 = r3.c;
        r4.<init>(r1);
        r3.a = r4;
        r4 = new android.widget.ImageView;
        r1 = r3.c;
        r4.<init>(r1);
        r3.b = r4;
        r4 = 1;
        r1 = -2;
        if (r5 == 0) goto L_0x0065;
    L_0x0022:
        r3.d();
        r5 = r3.h;
        if (r5 == 0) goto L_0x0064;
    L_0x0029:
        r5 = r3.i;
        if (r5 == 0) goto L_0x0064;
    L_0x002d:
        r5 = r3.j;
        if (r5 == 0) goto L_0x0064;
    L_0x0031:
        r5 = r3.k;
        if (r5 != 0) goto L_0x0036;
    L_0x0035:
        return;
    L_0x0036:
        r5 = r3.a;
        r2 = new android.widget.LinearLayout$LayoutParams;
        r2.<init>(r1, r1);
        r5.setLayoutParams(r2);
        r5 = r3.b;
        r2 = new android.widget.LinearLayout$LayoutParams;
        r2.<init>(r1, r1);
        r5.setLayoutParams(r2);
        r5 = r3.a;
        r2 = r3.h;
        r5.setImageBitmap(r2);
        r5 = r3.b;
        r2 = r3.j;
        r5.setImageBitmap(r2);
        r5 = new android.widget.LinearLayout$LayoutParams;
        r5.<init>(r1, r1);
        r3.setLayoutParams(r5);
        r3.setOrientation(r0);
        goto L_0x00ae;
    L_0x0064:
        return;
    L_0x0065:
        r3.c();
        r5 = r3.d;
        if (r5 == 0) goto L_0x00d8;
    L_0x006c:
        r5 = r3.e;
        if (r5 == 0) goto L_0x00d8;
    L_0x0070:
        r5 = r3.f;
        if (r5 == 0) goto L_0x00d8;
    L_0x0074:
        r5 = r3.g;
        if (r5 != 0) goto L_0x0079;
    L_0x0078:
        return;
    L_0x0079:
        r5 = r3.a;
        r2 = r3.d;
        r5.setImageBitmap(r2);
        r5 = r3.b;
        r2 = r3.f;
        r5.setImageBitmap(r2);
        r5 = r3.f;
        r5 = r5.getHeight();
        r5 = r5 / 6;
        r5 = r3.a(r5);
        r3.l = r5;
        r5 = r3.a;
        r2 = "main_topbtn_up.9.png";
        r3.a(r5, r2);
        r5 = r3.b;
        r2 = "main_bottombtn_up.9.png";
        r3.a(r5, r2);
        r5 = new android.widget.LinearLayout$LayoutParams;
        r5.<init>(r1, r1);
        r3.setLayoutParams(r5);
        r3.setOrientation(r4);
    L_0x00ae:
        r5 = r3.a;
        r5.setId(r0);
        r5 = r3.b;
        r5.setId(r4);
        r5 = r3.a;
        r5.setClickable(r4);
        r5 = r3.b;
        r5.setClickable(r4);
        r5 = r3.a;
        r5.setOnTouchListener(r3);
        r5 = r3.b;
        r5.setOnTouchListener(r3);
        r5 = r3.a;
        r3.addView(r5);
        r5 = r3.b;
        r3.addView(r5);
        r3.n = r4;
    L_0x00d8:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ak.<init>(android.content.Context, boolean):void");
    }

    private int a(int i) {
        return (int) ((this.c.getResources().getDisplayMetrics().density * ((float) i)) + 0.5f);
    }

    private Bitmap a(String str) {
        Matrix matrix = new Matrix();
        int densityDpi = SysOSUtil.getDensityDpi();
        float f = densityDpi > GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH ? 1.8f : (densityDpi <= GlMapUtil.DEVICE_DISPLAY_DPI_HIGH || densityDpi > GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH) ? 1.2f : 1.5f;
        matrix.postScale(f, f);
        Bitmap a = a.a(str, this.c);
        return Bitmap.createBitmap(a, 0, 0, a.getWidth(), a.getHeight(), matrix, true);
    }

    private void a(View view, String str) {
        Bitmap a = a.a(str, this.c);
        byte[] ninePatchChunk = a.getNinePatchChunk();
        NinePatch.isNinePatchChunk(ninePatchChunk);
        view.setBackgroundDrawable(new NinePatchDrawable(a, ninePatchChunk, new Rect(), null));
        view.setPadding(this.l, this.l, this.l, this.l);
    }

    private void c() {
        this.d = a("main_icon_zoomin.png");
        this.e = a("main_icon_zoomin_dis.png");
        this.f = a("main_icon_zoomout.png");
        this.g = a("main_icon_zoomout_dis.png");
    }

    private void d() {
        this.h = a("wear_zoom_in.png");
        this.i = a("wear_zoom_in_pressed.png");
        this.j = a("wear_zoon_out.png");
        this.k = a("wear_zoom_out_pressed.png");
    }

    public void a(OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0014 in {2, 4, 5} preds:[]
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
    public void a(boolean r2) {
        /*
        r1 = this;
        r0 = r1.a;
        r0.setEnabled(r2);
        if (r2 != 0) goto L_0x000f;
        r2 = r1.a;
        r0 = r1.e;
        r2.setImageBitmap(r0);
        return;
        r2 = r1.a;
        r0 = r1.d;
        goto L_0x000b;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ak.a(boolean):void");
    }

    public boolean a() {
        return this.n;
    }

    public void b() {
        if (!(this.d == null || this.d.isRecycled())) {
            this.d.recycle();
            this.d = null;
        }
        if (!(this.e == null || this.e.isRecycled())) {
            this.e.recycle();
            this.e = null;
        }
        if (!(this.f == null || this.f.isRecycled())) {
            this.f.recycle();
            this.f = null;
        }
        if (!(this.g == null || this.g.isRecycled())) {
            this.g.recycle();
            this.g = null;
        }
        if (!(this.h == null || this.h.isRecycled())) {
            this.h.recycle();
            this.h = null;
        }
        if (!(this.i == null || this.i.isRecycled())) {
            this.i.recycle();
            this.i = null;
        }
        if (!(this.j == null || this.j.isRecycled())) {
            this.j.recycle();
            this.j = null;
        }
        if (this.k != null && !this.k.isRecycled()) {
            this.k.recycle();
            this.k = null;
        }
    }

    public void b(OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0014 in {2, 4, 5} preds:[]
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
    public void b(boolean r2) {
        /*
        r1 = this;
        r0 = r1.b;
        r0.setEnabled(r2);
        if (r2 != 0) goto L_0x000f;
        r2 = r1.b;
        r0 = r1.g;
        r2.setImageBitmap(r0);
        return;
        r2 = r1.b;
        r0 = r1.f;
        goto L_0x000b;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ak.b(boolean):void");
    }

    /* JADX WARNING: Missing block: B:21:0x0045, code skipped:
            a(r2, r3);
     */
    /* JADX WARNING: Missing block: B:23:0x004d, code skipped:
            r2.setImageBitmap(r3);
     */
    public boolean onTouch(android.view.View r2, android.view.MotionEvent r3) {
        /*
        r1 = this;
        r0 = r2 instanceof android.widget.ImageView;
        if (r0 == 0) goto L_0x0065;
    L_0x0004:
        r2 = (android.widget.ImageView) r2;
        r2 = r2.getId();
        r0 = 1;
        switch(r2) {
            case 0: goto L_0x0037;
            case 1: goto L_0x000f;
            default: goto L_0x000e;
        };
    L_0x000e:
        goto L_0x0065;
    L_0x000f:
        r2 = r3.getAction();
        if (r2 != 0) goto L_0x0023;
    L_0x0015:
        r2 = r1.m;
        if (r2 != 0) goto L_0x001e;
    L_0x0019:
        r2 = r1.b;
        r3 = "main_bottombtn_down.9.png";
        goto L_0x0045;
    L_0x001e:
        r2 = r1.b;
        r3 = r1.k;
        goto L_0x004d;
    L_0x0023:
        r2 = r3.getAction();
        if (r2 != r0) goto L_0x0065;
    L_0x0029:
        r2 = r1.m;
        if (r2 != 0) goto L_0x0032;
    L_0x002d:
        r2 = r1.b;
        r3 = "main_bottombtn_up.9.png";
        goto L_0x0045;
    L_0x0032:
        r2 = r1.b;
        r3 = r1.j;
        goto L_0x004d;
    L_0x0037:
        r2 = r3.getAction();
        if (r2 != 0) goto L_0x0051;
    L_0x003d:
        r2 = r1.m;
        if (r2 != 0) goto L_0x0049;
    L_0x0041:
        r2 = r1.a;
        r3 = "main_topbtn_down.9.png";
    L_0x0045:
        r1.a(r2, r3);
        goto L_0x0065;
    L_0x0049:
        r2 = r1.a;
        r3 = r1.i;
    L_0x004d:
        r2.setImageBitmap(r3);
        goto L_0x0065;
    L_0x0051:
        r2 = r3.getAction();
        if (r2 != r0) goto L_0x0065;
    L_0x0057:
        r2 = r1.m;
        if (r2 != 0) goto L_0x0060;
    L_0x005b:
        r2 = r1.a;
        r3 = "main_topbtn_up.9.png";
        goto L_0x0045;
    L_0x0060:
        r2 = r1.a;
        r3 = r1.h;
        goto L_0x004d;
    L_0x0065:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ak.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
