package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.model.inner.GeoPoint;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

@SuppressLint({"NewApi"})
public class j extends GLSurfaceView implements OnDoubleTapListener, OnGestureListener, com.baidu.mapsdkplatform.comapi.map.MapRenderer.a {
    private static final String a = "j";
    private Handler b;
    private MapRenderer c;
    private int d;
    private int e;
    private GestureDetector f;
    private e g;

    static class a {
        float a;
        float b;
        float c;
        float d;
        boolean e;
        float f;
        float g;
        double h;

        a() {
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MultiTouch{x1=");
            stringBuilder.append(this.a);
            stringBuilder.append(", x2=");
            stringBuilder.append(this.b);
            stringBuilder.append(", y1=");
            stringBuilder.append(this.c);
            stringBuilder.append(", y2=");
            stringBuilder.append(this.d);
            stringBuilder.append(", mTwoTouch=");
            stringBuilder.append(this.e);
            stringBuilder.append(", centerX=");
            stringBuilder.append(this.f);
            stringBuilder.append(", centerY=");
            stringBuilder.append(this.g);
            stringBuilder.append(", length=");
            stringBuilder.append(this.h);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public j(Context context, z zVar, String str, int i) {
        super(context);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        setEGLContextClientVersion(2);
        this.f = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.g == null) {
            this.g = new e(context, str, i);
        }
        this.g.a(context.hashCode());
        g();
        this.g.a();
        this.g.a(zVar);
        h();
        this.g.a(this.b);
        this.g.f();
        setBackgroundColor(0);
    }

    private static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eglGetDisplay, new int[2]);
        int[] iArr = new int[1];
        return egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344}, new EGLConfig[100], 100, iArr) && iArr[0] > 0;
    }

    private void g() {
        try {
            if (a(8, 8, 8, 8, 24, 0)) {
                setEGLConfigChooser(8, 8, 8, 8, 24, 0);
            } else if (a(5, 6, 5, 0, 24, 0)) {
                setEGLConfigChooser(5, 6, 5, 0, 24, 0);
            } else {
                setEGLConfigChooser(true);
            }
        } catch (IllegalArgumentException unused) {
            setEGLConfigChooser(true);
        }
        this.c = new MapRenderer(this, this);
        this.c.a(this.g.j);
        setRenderer(this.c);
        setRenderMode(1);
    }

    private void h() {
        this.b = new k(this);
    }

    public e a() {
        return this.g;
    }

    public void a(float f, float f2) {
        if (this.g != null && this.g.i != null) {
            this.g.b(f, f2);
        }
    }

    public void a(int i) {
        if (this.g != null) {
            Message message = new Message();
            message.what = 50;
            message.obj = Long.valueOf(this.g.j);
            boolean q = this.g.q();
            if (i == 3) {
                i = 0;
            } else {
                if (q) {
                    i = 1;
                }
                this.b.sendMessage(message);
            }
            message.arg1 = i;
            this.b.sendMessage(message);
        }
    }

    public void a(String str, Rect rect) {
        if (this.g != null && this.g.i != null) {
            if (rect != null) {
                int i = rect.left;
                int i2 = this.e < rect.bottom ? 0 : this.e - rect.bottom;
                int width = rect.width();
                int height = rect.height();
                if (i >= 0 && i2 >= 0 && width > 0 && height > 0) {
                    if (width > this.d) {
                        width = Math.abs(rect.width()) - (rect.right - this.d);
                    }
                    if (height > this.e) {
                        height = Math.abs(rect.height()) - (rect.bottom - this.e);
                    }
                    if (i > SysOSUtil.getScreenSizeX() || i2 > SysOSUtil.getScreenSizeY()) {
                        this.g.i.a(str, null);
                        requestRender();
                        return;
                    }
                    this.d = width;
                    this.e = height;
                    Bundle bundle = new Bundle();
                    bundle.putInt("x", i);
                    bundle.putInt("y", i2);
                    bundle.putInt("width", width);
                    bundle.putInt("height", height);
                    this.g.i.a(str, bundle);
                } else {
                    return;
                }
            }
            this.g.i.a(str, null);
            requestRender();
        }
    }

    public boolean a(float f, float f2, float f3, float f4) {
        return (this.g == null || this.g.i == null) ? false : this.g.a(f, f2, f3, f4);
    }

    public void b() {
        if (this.g != null) {
            this.g.u();
        }
    }

    public void b(int i) {
        if (this.g != null) {
            if (this.g.h != null) {
                for (l lVar : this.g.h) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            this.g.b(this.b);
            this.g.b(i);
            this.g = null;
        }
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
        }
    }

    public boolean b(float f, float f2) {
        return (this.g == null || this.g.i == null) ? false : this.g.d(f, f2);
    }

    public void c() {
        if (this.g != null) {
            this.g.v();
        }
    }

    public boolean c(float f, float f2) {
        return (this.g == null || this.g.i == null) ? false : this.g.c(f, f2);
    }

    public void d() {
        getHolder().setFormat(-3);
        this.g.i.s();
    }

    public boolean d(float f, float f2) {
        return (this.g == null || this.g.i == null) ? false : this.g.c((int) f, (int) f2);
    }

    public void e() {
        getHolder().setFormat(-1);
        this.g.i.t();
    }

    public void f() {
    }

    /* JADX WARNING: Missing block: B:25:0x0080, code skipped:
            return true;
     */
    public boolean onDoubleTap(android.view.MotionEvent r5) {
        /*
        r4 = this;
        r0 = r4.g;
        r1 = 1;
        if (r0 == 0) goto L_0x0080;
    L_0x0005:
        r0 = r4.g;
        r0 = r0.i;
        if (r0 == 0) goto L_0x0080;
    L_0x000b:
        r0 = r4.g;
        r0 = r0.k;
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r4.g;
        r2 = r5.getX();
        r2 = (int) r2;
        r5 = r5.getY();
        r5 = (int) r5;
        r5 = r0.b(r2, r5);
        r0 = 0;
        if (r5 == 0) goto L_0x007f;
    L_0x0025:
        r2 = r4.g;
        r2 = r2.h;
        if (r2 == 0) goto L_0x0045;
    L_0x002b:
        r2 = r4.g;
        r2 = r2.h;
        r2 = r2.iterator();
    L_0x0033:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x0045;
    L_0x0039:
        r3 = r2.next();
        r3 = (com.baidu.mapsdkplatform.comapi.map.l) r3;
        if (r3 == 0) goto L_0x0033;
    L_0x0041:
        r3.b(r5);
        goto L_0x0033;
    L_0x0045:
        r2 = r4.g;
        r2 = r2.f;
        if (r2 == 0) goto L_0x007f;
    L_0x004b:
        r0 = r4.g;
        r0 = r0.E();
        r2 = r0.a;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r2 + r3;
        r0.a = r2;
        r2 = r4.g;
        r2 = r2.g;
        if (r2 != 0) goto L_0x006a;
    L_0x005e:
        r2 = r5.getLongitudeE6();
        r0.d = r2;
        r2 = r5.getLatitudeE6();
        r0.e = r2;
    L_0x006a:
        r5 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r5 = r5 | r1;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r5;
        r5 = r4.g;
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r5.a(r0, r2);
        r5 = r4.g;
        r2 = java.lang.System.currentTimeMillis();
        com.baidu.mapsdkplatform.comapi.map.e.m = r2;
        return r1;
    L_0x007f:
        return r0;
    L_0x0080:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.j.onDoubleTap(android.view.MotionEvent):boolean");
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARNING: Missing block: B:15:0x0053, code skipped:
            return true;
     */
    public boolean onFling(android.view.MotionEvent r3, android.view.MotionEvent r4, float r5, float r6) {
        /*
        r2 = this;
        r3 = r2.g;
        r0 = 1;
        if (r3 == 0) goto L_0x0053;
    L_0x0005:
        r3 = r2.g;
        r3 = r3.i;
        if (r3 == 0) goto L_0x0053;
    L_0x000b:
        r3 = r2.g;
        r3 = r3.k;
        if (r3 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r3 = r2.g;
        r3 = r3.e;
        r1 = 0;
        if (r3 == 0) goto L_0x0052;
    L_0x0019:
        r5 = r5 * r5;
        r6 = r6 * r6;
        r5 = r5 + r6;
        r5 = (double) r5;
        r5 = java.lang.Math.sqrt(r5);
        r3 = (float) r5;
        r5 = 1140457472; // 0x43fa0000 float:500.0 double:5.634608575E-315;
        r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r5 > 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r5 = com.baidu.mapapi.map.BaiduMap.mapStatusReason;
        r5 = r5 | r0;
        com.baidu.mapapi.map.BaiduMap.mapStatusReason = r5;
        r5 = r2.g;
        r5.A();
        r5 = r2.g;
        r6 = 34;
        r1 = 1058642330; // 0x3f19999a float:0.6 double:5.230388065E-315;
        r3 = r3 * r1;
        r3 = (int) r3;
        r1 = r4.getY();
        r1 = (int) r1;
        r1 = r1 << 16;
        r4 = r4.getX();
        r4 = (int) r4;
        r4 = r4 | r1;
        r5.a(r6, r3, r4);
        r3 = r2.g;
        r3.M();
        return r0;
    L_0x0052:
        return r1;
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.j.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.g != null && this.g.i != null && this.g.k) {
            String a = this.g.i.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.g.l);
            if (a == null || a.equals("")) {
                if (this.g.h != null) {
                    for (l lVar : this.g.h) {
                        GeoPoint b = this.g.b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (lVar != null) {
                            lVar.c(b);
                        }
                    }
                }
            }
            if (this.g.h != null) {
                for (l lVar2 : this.g.h) {
                    if (lVar2 != null) {
                        if (lVar2.b(a)) {
                            this.g.p = true;
                        } else {
                            lVar2.c(this.g.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                        }
                    }
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (this.g != null && this.g.i != null) {
            this.g.i.c();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.g != null && this.g.i != null) {
            if (this.g.h != null) {
                for (l lVar : this.g.h) {
                    if (lVar != null) {
                        lVar.d();
                    }
                }
            }
            this.g.i.g();
            this.g.i.d();
            this.g.i.n();
            setRenderMode(1);
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b  */
    public boolean onSingleTapConfirmed(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r0 = r6.g;
        r1 = 1;
        if (r0 == 0) goto L_0x00ac;
    L_0x0005:
        r0 = r6.g;
        r0 = r0.i;
        if (r0 == 0) goto L_0x00ac;
    L_0x000b:
        r0 = r6.g;
        r0 = r0.k;
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r6.g;
        r0 = r0.i;
        r2 = -1;
        r3 = r7.getX();
        r3 = (int) r3;
        r4 = r7.getY();
        r4 = (int) r4;
        r5 = r6.g;
        r5 = r5.l;
        r0 = r0.a(r2, r3, r4, r5);
        r2 = 0;
        if (r0 == 0) goto L_0x007b;
    L_0x002c:
        r3 = "";
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x007b;
    L_0x0034:
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0050 }
        r3.<init>(r0);	 Catch:{ JSONException -> 0x0050 }
        r0 = "px";
        r2 = r7.getX();	 Catch:{ JSONException -> 0x004e }
        r2 = (int) r2;	 Catch:{ JSONException -> 0x004e }
        r3.put(r0, r2);	 Catch:{ JSONException -> 0x004e }
        r0 = "py";
        r7 = r7.getY();	 Catch:{ JSONException -> 0x004e }
        r7 = (int) r7;	 Catch:{ JSONException -> 0x004e }
        r3.put(r0, r7);	 Catch:{ JSONException -> 0x004e }
        goto L_0x0055;
    L_0x004e:
        r7 = move-exception;
        goto L_0x0052;
    L_0x0050:
        r7 = move-exception;
        r3 = r2;
    L_0x0052:
        r7.printStackTrace();
    L_0x0055:
        r7 = r6.g;
        r7 = r7.h;
        if (r7 == 0) goto L_0x00ac;
    L_0x005b:
        r7 = r6.g;
        r7 = r7.h;
        r7 = r7.iterator();
    L_0x0063:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x00ac;
    L_0x0069:
        r0 = r7.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r3 == 0) goto L_0x0063;
    L_0x0071:
        if (r0 == 0) goto L_0x0063;
    L_0x0073:
        r2 = r3.toString();
        r0.a(r2);
        goto L_0x0063;
    L_0x007b:
        r0 = r6.g;
        r0 = r0.h;
        if (r0 == 0) goto L_0x00ac;
    L_0x0081:
        r0 = r6.g;
        r0 = r0.h;
        r0 = r0.iterator();
    L_0x0089:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x00ac;
    L_0x008f:
        r2 = r0.next();
        r2 = (com.baidu.mapsdkplatform.comapi.map.l) r2;
        if (r2 != 0) goto L_0x0098;
    L_0x0097:
        goto L_0x0089;
    L_0x0098:
        r3 = r6.g;
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r3 = r3.b(r4, r5);
        r2.a(r3);
        goto L_0x0089;
    L_0x00ac:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.j.onSingleTapConfirmed(android.view.MotionEvent):boolean");
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g == null || this.g.i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        if (this.g.h != null) {
            for (l lVar : this.g.h) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        return this.f.onTouchEvent(motionEvent) ? true : this.g.a(motionEvent);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        if (this.g != null && this.g.i != null) {
            this.c.a = i2;
            this.c.b = i3;
            this.d = i2;
            this.e = i3;
            this.c.c = 0;
            ab E = this.g.E();
            if (E.f == 0 || E.f == -1 || E.f == (E.j.left - E.j.right) / 2) {
                E.f = -1;
            }
            if (E.g == 0 || E.g == -1 || E.g == (E.j.bottom - E.j.top) / 2) {
                E.g = -1;
            }
            E.j.left = 0;
            E.j.top = 0;
            E.j.bottom = i3;
            E.j.right = i2;
            this.g.a(E);
            this.g.a(this.d, this.e);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        if (surfaceHolder != null && !surfaceHolder.getSurface().isValid()) {
            surfaceDestroyed(surfaceHolder);
        }
    }
}
