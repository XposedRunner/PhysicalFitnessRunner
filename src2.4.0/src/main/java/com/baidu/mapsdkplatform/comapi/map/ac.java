package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.m.a;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
public class ac extends TextureView implements OnDoubleTapListener, OnGestureListener, SurfaceTextureListener, a {
    public static int a;
    public static int b;
    public static int c;
    private GestureDetector d;
    private Handler e;
    private boolean f = false;
    private SurfaceTexture g;
    private m h = null;
    private e i;

    public ac(Context context, z zVar, String str, int i) {
        super(context);
        a(context, zVar, str, i);
    }

    private void a(Context context, z zVar, String str, int i) {
        setSurfaceTextureListener(this);
        if (context == null) {
            throw new RuntimeException("when you create an mapview, the context can not be null");
        }
        this.d = new GestureDetector(context, this);
        EnvironmentUtilities.initAppDirectory(context);
        if (this.i == null) {
            this.i = new e(context, str, i);
        }
        this.i.a(context.hashCode());
        this.i.a();
        this.i.a(zVar);
        e();
        this.i.a(this.e);
        this.i.f();
    }

    private void e() {
        this.e = new ad(this);
    }

    public int a() {
        if (this.i == null) {
            return 0;
        }
        if (c <= 1) {
            MapRenderer.nativeResize(this.i.j, a, b);
            c++;
        }
        return MapRenderer.nativeRender(this.i.j);
    }

    public void a(int i) {
        synchronized (this.i) {
            if (this.i.h != null) {
                for (l lVar : this.i.h) {
                    if (lVar != null) {
                        lVar.f();
                    }
                }
            }
            if (this.i != null) {
                this.i.b(this.e);
                this.i.b(i);
                this.i = null;
            }
            this.e.removeCallbacksAndMessages(null);
            if (this.h != null) {
                this.h.c();
                this.h = null;
            }
            if (this.g != null) {
                if (VERSION.SDK_INT >= 19) {
                    this.g.release();
                }
                this.g = null;
            }
        }
    }

    /* JADX WARNING: Missing block: B:28:0x0085, code skipped:
            if (r7.h != null) goto L_0x00a4;
     */
    /* JADX WARNING: Missing block: B:34:0x00a2, code skipped:
            if (r7.h != null) goto L_0x00a4;
     */
    public void a(java.lang.String r8, android.graphics.Rect r9) {
        /*
        r7 = this;
        r0 = r7.i;
        if (r0 == 0) goto L_0x00a9;
    L_0x0004:
        r0 = r7.i;
        r0 = r0.i;
        if (r0 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = 0;
        if (r9 == 0) goto L_0x0099;
    L_0x000e:
        r1 = r9.left;
        r2 = b;
        r3 = r9.bottom;
        if (r2 >= r3) goto L_0x0018;
    L_0x0016:
        r2 = 0;
        goto L_0x001d;
    L_0x0018:
        r2 = b;
        r3 = r9.bottom;
        r2 = r2 - r3;
    L_0x001d:
        r3 = r9.width();
        r4 = r9.height();
        if (r1 < 0) goto L_0x0098;
    L_0x0027:
        if (r2 < 0) goto L_0x0098;
    L_0x0029:
        if (r3 <= 0) goto L_0x0098;
    L_0x002b:
        if (r4 > 0) goto L_0x002e;
    L_0x002d:
        return;
    L_0x002e:
        r5 = a;
        if (r3 <= r5) goto L_0x0040;
    L_0x0032:
        r3 = r9.width();
        r3 = java.lang.Math.abs(r3);
        r5 = r9.right;
        r6 = a;
        r5 = r5 - r6;
        r3 = r3 - r5;
    L_0x0040:
        r5 = b;
        if (r4 <= r5) goto L_0x0052;
    L_0x0044:
        r4 = r9.height();
        r4 = java.lang.Math.abs(r4);
        r9 = r9.bottom;
        r5 = b;
        r9 = r9 - r5;
        r4 = r4 - r9;
    L_0x0052:
        r9 = com.baidu.mapapi.common.SysOSUtil.getScreenSizeX();
        if (r1 > r9) goto L_0x0088;
    L_0x0058:
        r9 = com.baidu.mapapi.common.SysOSUtil.getScreenSizeY();
        if (r2 <= r9) goto L_0x005f;
    L_0x005e:
        goto L_0x0088;
    L_0x005f:
        a = r3;
        b = r4;
        r9 = new android.os.Bundle;
        r9.<init>();
        r0 = "x";
        r9.putInt(r0, r1);
        r0 = "y";
        r9.putInt(r0, r2);
        r0 = "width";
        r9.putInt(r0, r3);
        r0 = "height";
        r9.putInt(r0, r4);
        r0 = r7.i;
        r0 = r0.i;
        r0.a(r8, r9);
        r8 = r7.h;
        if (r8 == 0) goto L_0x00a9;
    L_0x0087:
        goto L_0x00a4;
    L_0x0088:
        r9 = r7.i;
        r9 = r9.i;
        r9.a(r8, r0);
        r8 = r7.h;
        if (r8 == 0) goto L_0x0098;
    L_0x0093:
        r8 = r7.h;
        r8.a();
    L_0x0098:
        return;
    L_0x0099:
        r9 = r7.i;
        r9 = r9.i;
        r9.a(r8, r0);
        r8 = r7.h;
        if (r8 == 0) goto L_0x00a9;
    L_0x00a4:
        r8 = r7.h;
        r8.a();
    L_0x00a9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ac.a(java.lang.String, android.graphics.Rect):void");
    }

    public e b() {
        return this.i;
    }

    public void c() {
        if (this.i != null && this.i.i != null) {
            if (this.i.h != null) {
                for (l lVar : this.i.h) {
                    if (lVar != null) {
                        lVar.d();
                    }
                }
            }
            this.i.i.g();
            this.i.i.d();
            this.i.i.n();
            if (this.h != null) {
                this.h.a();
            }
            if (this.i.b()) {
                this.f = true;
            }
        }
    }

    public void d() {
        if (this.i != null && this.i.i != null) {
            this.f = false;
            this.i.i.c();
            synchronized (this.i) {
                this.i.i.c();
                if (this.h != null) {
                    this.h.b();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:25:0x0080, code skipped:
            return true;
     */
    public boolean onDoubleTap(android.view.MotionEvent r5) {
        /*
        r4 = this;
        r0 = r4.i;
        r1 = 1;
        if (r0 == 0) goto L_0x0080;
    L_0x0005:
        r0 = r4.i;
        r0 = r0.i;
        if (r0 == 0) goto L_0x0080;
    L_0x000b:
        r0 = r4.i;
        r0 = r0.k;
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r4.i;
        r2 = r5.getX();
        r2 = (int) r2;
        r5 = r5.getY();
        r5 = (int) r5;
        r5 = r0.b(r2, r5);
        r0 = 0;
        if (r5 == 0) goto L_0x007f;
    L_0x0025:
        r2 = r4.i;
        r2 = r2.h;
        if (r2 == 0) goto L_0x0045;
    L_0x002b:
        r2 = r4.i;
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
        r2 = r4.i;
        r2 = r2.f;
        if (r2 == 0) goto L_0x007f;
    L_0x004b:
        r0 = r4.i;
        r0 = r0.E();
        r2 = r0.a;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r2 + r3;
        r0.a = r2;
        r2 = r4.i;
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
        r5 = r4.i;
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r5.a(r0, r2);
        r5 = r4.i;
        r2 = java.lang.System.currentTimeMillis();
        com.baidu.mapsdkplatform.comapi.map.e.m = r2;
        return r1;
    L_0x007f:
        return r0;
    L_0x0080:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ac.onDoubleTap(android.view.MotionEvent):boolean");
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
        r3 = r2.i;
        r0 = 1;
        if (r3 == 0) goto L_0x0053;
    L_0x0005:
        r3 = r2.i;
        r3 = r3.i;
        if (r3 == 0) goto L_0x0053;
    L_0x000b:
        r3 = r2.i;
        r3 = r3.k;
        if (r3 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r3 = r2.i;
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
        r5 = r2.i;
        r5.A();
        r5 = r2.i;
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
        r3 = r2.i;
        r3.M();
        return r0;
    L_0x0052:
        return r1;
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ac.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.i != null && this.i.i != null && this.i.k) {
            String a = this.i.i.a(-1, (int) motionEvent.getX(), (int) motionEvent.getY(), this.i.l);
            if (this.i.h != null) {
                if (a == null || a.equals("")) {
                    for (l lVar : this.i.h) {
                        GeoPoint b = this.i.b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (lVar != null) {
                            lVar.c(b);
                        }
                    }
                }
                for (l lVar2 : this.i.h) {
                    if (lVar2.b(a)) {
                        this.i.p = true;
                    } else {
                        lVar2.c(this.i.b((int) motionEvent.getX(), (int) motionEvent.getY()));
                    }
                }
            }
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006a  */
    public boolean onSingleTapConfirmed(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r0 = r6.i;
        r1 = 1;
        if (r0 == 0) goto L_0x00a6;
    L_0x0005:
        r0 = r6.i;
        r0 = r0.i;
        if (r0 == 0) goto L_0x00a6;
    L_0x000b:
        r0 = r6.i;
        r0 = r0.k;
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r6.i;
        r0 = r0.h;
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = r6.i;
        r0 = r0.i;
        r2 = -1;
        r3 = r7.getX();
        r3 = (int) r3;
        r4 = r7.getY();
        r4 = (int) r4;
        r5 = r6.i;
        r5 = r5.l;
        r0 = r0.a(r2, r3, r4, r5);
        r2 = 0;
        if (r0 == 0) goto L_0x007c;
    L_0x0033:
        r3 = "";
        r3 = r0.equals(r3);
        if (r3 != 0) goto L_0x007c;
    L_0x003b:
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0057 }
        r3.<init>(r0);	 Catch:{ JSONException -> 0x0057 }
        r0 = "px";
        r2 = r7.getX();	 Catch:{ JSONException -> 0x0055 }
        r2 = (int) r2;	 Catch:{ JSONException -> 0x0055 }
        r3.put(r0, r2);	 Catch:{ JSONException -> 0x0055 }
        r0 = "py";
        r7 = r7.getY();	 Catch:{ JSONException -> 0x0055 }
        r7 = (int) r7;	 Catch:{ JSONException -> 0x0055 }
        r3.put(r0, r7);	 Catch:{ JSONException -> 0x0055 }
        goto L_0x005c;
    L_0x0055:
        r7 = move-exception;
        goto L_0x0059;
    L_0x0057:
        r7 = move-exception;
        r3 = r2;
    L_0x0059:
        r7.printStackTrace();
    L_0x005c:
        r7 = r6.i;
        r7 = r7.h;
        r7 = r7.iterator();
    L_0x0064:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x00a6;
    L_0x006a:
        r0 = r7.next();
        r0 = (com.baidu.mapsdkplatform.comapi.map.l) r0;
        if (r3 == 0) goto L_0x0064;
    L_0x0072:
        if (r0 == 0) goto L_0x0064;
    L_0x0074:
        r2 = r3.toString();
        r0.a(r2);
        goto L_0x0064;
    L_0x007c:
        r0 = r6.i;
        r0 = r0.h;
        r0 = r0.iterator();
    L_0x0084:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x00a6;
    L_0x008a:
        r2 = r0.next();
        r2 = (com.baidu.mapsdkplatform.comapi.map.l) r2;
        if (r2 == 0) goto L_0x0084;
    L_0x0092:
        r3 = r6.i;
        r4 = r7.getX();
        r4 = (int) r4;
        r5 = r7.getY();
        r5 = (int) r5;
        r3 = r3.b(r4, r5);
        r2.a(r3);
        goto L_0x0084;
    L_0x00a6:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.map.ac.onSingleTapConfirmed(android.view.MotionEvent):boolean");
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.i != null) {
            if (this.g == null) {
                this.g = surfaceTexture;
                this.h = new m(this.g, this, new AtomicBoolean(true), this);
                this.h.start();
                a = i;
                b = i2;
                ab E = this.i.E();
                if (E != null) {
                    if (E.f == 0 || E.f == -1 || E.f == (E.j.left - E.j.right) / 2) {
                        E.f = -1;
                    }
                    if (E.g == 0 || E.g == -1 || E.g == (E.j.bottom - E.j.top) / 2) {
                        E.g = -1;
                    }
                    E.j.left = 0;
                    E.j.top = 0;
                    E.j.bottom = i2;
                    E.j.right = i;
                    this.i.a(E);
                    this.i.a(a, b);
                    return;
                }
                return;
            }
            setSurfaceTexture(this.g);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.i != null) {
            a = i;
            b = i2;
            c = 1;
            ab E = this.i.E();
            if (E.f == 0 || E.f == -1 || E.f == (E.j.left - E.j.right) / 2) {
                E.f = -1;
            }
            if (E.g == 0 || E.g == -1 || E.g == (E.j.bottom - E.j.top) / 2) {
                E.g = -1;
            }
            E.j.left = 0;
            E.j.top = 0;
            E.j.bottom = i2;
            E.j.right = i;
            this.i.a(E);
            this.i.a(a, b);
            MapRenderer.nativeResize(this.i.j, i, i2);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (this.f && this.h != null) {
            this.h.a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.i == null || this.i.i == null) {
            return true;
        }
        super.onTouchEvent(motionEvent);
        if (this.i.h != null) {
            for (l lVar : this.i.h) {
                if (lVar != null) {
                    lVar.a(motionEvent);
                }
            }
        }
        return this.d.onTouchEvent(motionEvent) ? true : this.i.a(motionEvent);
    }
}
