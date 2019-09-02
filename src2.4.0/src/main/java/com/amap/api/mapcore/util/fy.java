package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.io.File;

/* compiled from: WaterMarkerView */
public class fy extends View {
    private Bitmap O000000o;
    private Bitmap O00000Oo;
    private Bitmap O00000o;
    private Bitmap O00000o0;
    private Bitmap O00000oO;
    private Bitmap O00000oo;
    private Paint O0000O0o = new Paint();
    private boolean O0000OOo = false;
    private int O0000Oo = 0;
    private int O0000Oo0 = 0;
    private int O0000OoO = 0;
    private int O0000Ooo = 10;
    private boolean O0000o = false;
    private int O0000o0 = 0;
    private int O0000o00 = 0;
    private int O0000o0O = 10;
    private int O0000o0o = 8;
    private Context O0000oO;
    private boolean O0000oO0 = false;
    private float O0000oOO = 0.0f;
    private float O0000oOo = 0.0f;
    private boolean O0000oo0 = true;

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fd A:{SYNTHETIC, Splitter:B:31:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107 A:{SYNTHETIC, Splitter:B:36:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010f A:{SYNTHETIC, Splitter:B:41:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0119 A:{SYNTHETIC, Splitter:B:46:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fd A:{SYNTHETIC, Splitter:B:31:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107 A:{SYNTHETIC, Splitter:B:36:0x0107} */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010f A:{SYNTHETIC, Splitter:B:41:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0119 A:{SYNTHETIC, Splitter:B:46:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010f A:{SYNTHETIC, Splitter:B:41:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0119 A:{SYNTHETIC, Splitter:B:46:0x0119} */
    public fy(android.content.Context r5, com.amap.api.mapcore.util.ca r6) {
        /*
        r4 = this;
        r4.<init>(r5);
        r6 = new android.graphics.Paint;
        r6.<init>();
        r4.O0000O0o = r6;
        r6 = 0;
        r4.O0000OOo = r6;
        r4.O0000Oo0 = r6;
        r4.O0000Oo = r6;
        r4.O0000OoO = r6;
        r0 = 10;
        r4.O0000Ooo = r0;
        r4.O0000o00 = r6;
        r4.O0000o0 = r6;
        r4.O0000o0O = r0;
        r0 = 8;
        r4.O0000o0o = r0;
        r4.O0000o = r6;
        r4.O0000oO0 = r6;
        r6 = 0;
        r4.O0000oOO = r6;
        r4.O0000oOo = r6;
        r6 = 1;
        r4.O0000oo0 = r6;
        r0 = 0;
        r1 = r5.getApplicationContext();	 Catch:{ Throwable -> 0x00ef, all -> 0x00eb }
        r4.O0000oO = r1;	 Catch:{ Throwable -> 0x00ef, all -> 0x00eb }
        r1 = com.amap.api.mapcore.util.OOOO0OO.O000000o(r5);	 Catch:{ Throwable -> 0x00ef, all -> 0x00eb }
        r2 = "ap.data";
        r1 = r1.open(r2);	 Catch:{ Throwable -> 0x00ef, all -> 0x00eb }
        r2 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r4.O00000oO = r2;	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r2 = r4.O00000oO;	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r3 = com.amap.api.mapcore.util.bu.O000000o;	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r2 = com.amap.api.mapcore.util.OOo000.O000000o(r2, r3);	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r4.O000000o = r2;	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r1.close();	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r2 = com.amap.api.mapcore.util.OOOO0OO.O000000o(r5);	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r3 = "ap1.data";
        r2 = r2.open(r3);	 Catch:{ Throwable -> 0x00e7, all -> 0x00e4 }
        r0 = android.graphics.BitmapFactory.decodeStream(r2);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r4.O00000oo = r0;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r4.O00000oo;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r3 = com.amap.api.mapcore.util.bu.O000000o;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = com.amap.api.mapcore.util.OOo000.O000000o(r0, r3);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r4.O00000Oo = r0;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r2.close();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r0.getWidth();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r4.O0000Oo = r0;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r0.getHeight();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r4.O0000Oo0 = r0;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r4.O0000O0o;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0.setAntiAlias(r6);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6 = r4.O0000O0o;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r6.setColor(r0);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6 = r4.O0000O0o;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = android.graphics.Paint.Style.STROKE;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6.setStyle(r0);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6.<init>();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = r5.getFilesDir();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6.append(r0);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r0 = "/icon_web_day.data";
        r6.append(r0);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = r6;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6.<init>();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r5 = r5.getFilesDir();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6.append(r5);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r5 = "/icon_web_night.data";
        r6.append(r5);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r5 = r6.toString();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = r5;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r5 = com.amap.api.mapcore.util.OOOo000.O000000o();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6 = new com.amap.api.mapcore.util.fy$1;	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r6.<init>();	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        r5.O000000o(r6);	 Catch:{ Throwable -> 0x00e2, all -> 0x00e0 }
        if (r1 == 0) goto L_0x00d5;
    L_0x00cd:
        r1.close();	 Catch:{ Throwable -> 0x00d1 }
        goto L_0x00d5;
    L_0x00d1:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x00d5:
        if (r2 == 0) goto L_0x010a;
    L_0x00d7:
        r2.close();	 Catch:{ Throwable -> 0x00db }
        goto L_0x010a;
    L_0x00db:
        r5 = move-exception;
        r5.printStackTrace();
        goto L_0x010a;
    L_0x00e0:
        r5 = move-exception;
        goto L_0x010d;
    L_0x00e2:
        r5 = move-exception;
        goto L_0x00e9;
    L_0x00e4:
        r5 = move-exception;
        r2 = r0;
        goto L_0x010d;
    L_0x00e7:
        r5 = move-exception;
        r2 = r0;
    L_0x00e9:
        r0 = r1;
        goto L_0x00f1;
    L_0x00eb:
        r5 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x010d;
    L_0x00ef:
        r5 = move-exception;
        r2 = r0;
    L_0x00f1:
        r6 = "WaterMarkerView";
        r1 = "create";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r5, r6, r1);	 Catch:{ all -> 0x010b }
        r5.printStackTrace();	 Catch:{ all -> 0x010b }
        if (r0 == 0) goto L_0x0105;
    L_0x00fd:
        r0.close();	 Catch:{ Throwable -> 0x0101 }
        goto L_0x0105;
    L_0x0101:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0105:
        if (r2 == 0) goto L_0x010a;
    L_0x0107:
        r2.close();	 Catch:{ Throwable -> 0x00db }
    L_0x010a:
        return;
    L_0x010b:
        r5 = move-exception;
        r1 = r0;
    L_0x010d:
        if (r1 == 0) goto L_0x0117;
    L_0x010f:
        r1.close();	 Catch:{ Throwable -> 0x0113 }
        goto L_0x0117;
    L_0x0113:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0117:
        if (r2 == 0) goto L_0x0121;
    L_0x0119:
        r2.close();	 Catch:{ Throwable -> 0x011d }
        goto L_0x0121;
    L_0x011d:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0121:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fy.<init>(android.content.Context, com.amap.api.mapcore.util.ca):void");
    }

    private void O00000oo() {
        switch (this.O0000o0) {
            case 0:
                O0000OOo();
                break;
            case 2:
                O0000O0o();
                break;
        }
        this.O0000Ooo = this.O0000o0O;
        this.O0000o00 = (getHeight() - this.O0000o0o) - this.O0000Oo0;
        if (this.O0000Ooo < 0) {
            this.O0000Ooo = 0;
        }
        if (this.O0000o00 < 0) {
            this.O0000o00 = 0;
        }
    }

    private void O0000O0o() {
        if (this.O0000oo0) {
            this.O0000o0O = (int) (((float) getWidth()) * this.O0000oOO);
        } else {
            this.O0000o0O = (int) ((((float) getWidth()) * this.O0000oOO) - ((float) this.O0000Oo));
        }
        this.O0000o0o = (int) (((float) getHeight()) * this.O0000oOo);
    }

    private void O0000OOo() {
        if (this.O0000OoO == 1) {
            this.O0000o0O = (getWidth() - this.O0000Oo) / 2;
        } else if (this.O0000OoO == 2) {
            this.O0000o0O = (getWidth() - this.O0000Oo) - 10;
        } else {
            this.O0000o0O = 10;
        }
        this.O0000o0o = 8;
    }

    public void O000000o() {
        try {
            if (this.O000000o != null) {
                this.O000000o.recycle();
            }
            if (this.O00000Oo != null) {
                this.O00000Oo.recycle();
            }
            this.O000000o = null;
            this.O00000Oo = null;
            if (this.O00000oO != null) {
                this.O00000oO.recycle();
                this.O00000oO = null;
            }
            if (this.O00000oo != null) {
                this.O00000oo.recycle();
                this.O00000oo = null;
            }
            if (this.O00000o0 != null) {
                this.O00000o0.recycle();
            }
            this.O00000o0 = null;
            if (this.O00000o != null) {
                this.O00000o.recycle();
            }
            this.O00000o = null;
            this.O0000O0o = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public void O000000o(int i) {
        this.O0000o0 = 0;
        this.O0000OoO = i;
        O00000o();
    }

    public void O000000o(int i, float f) {
        this.O0000o0 = 2;
        f = Math.max(0.0f, Math.min(f, 1.0f));
        switch (i) {
            case 0:
                this.O0000oOO = f;
                this.O0000oo0 = true;
                break;
            case 1:
                this.O0000oOO = 1.0f - f;
                this.O0000oo0 = false;
                break;
            case 2:
                this.O0000oOo = 1.0f - f;
                break;
        }
        O00000o();
    }

    public void O000000o(String str, int i) {
        try {
            if (new File(str).exists()) {
                Bitmap bitmap;
                if (i == 0) {
                    bitmap = this.O00000o0;
                    this.O00000oO = BitmapFactory.decodeFile(str);
                    this.O00000o0 = OOo000.O000000o(this.O00000oO, bu.O000000o);
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                } else if (i == 1) {
                    bitmap = this.O00000o;
                    this.O00000oO = BitmapFactory.decodeFile(str);
                    this.O00000o = OOo000.O000000o(this.O00000oO, bu.O000000o);
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public void O000000o(boolean z) {
        try {
            this.O0000OOo = z;
            if (z) {
                this.O0000O0o.setColor(-1);
            } else {
                this.O0000O0o.setColor(ViewCompat.MEASURED_STATE_MASK);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "WaterMarkerView", "changeBitmap");
            th.printStackTrace();
        }
    }

    public Bitmap O00000Oo() {
        return this.O0000OOo ? (!this.O0000oO0 || this.O00000o == null) ? this.O00000Oo : this.O00000o : (!this.O0000oO0 || this.O00000o0 == null) ? this.O000000o : this.O00000o0;
    }

    public void O00000Oo(int i) {
        this.O0000o0 = 1;
        this.O0000o0o = i;
        O00000o();
    }

    public void O00000Oo(boolean z) {
        if (this.O0000oO0 != z) {
            this.O0000oO0 = z;
            if (!z) {
                this.O0000Oo = this.O000000o.getWidth();
                this.O0000Oo0 = this.O000000o.getHeight();
            } else if (this.O0000OOo) {
                if (this.O00000o != null) {
                    this.O0000Oo = this.O00000o.getWidth();
                    this.O0000Oo0 = this.O00000o.getHeight();
                }
            } else if (this.O00000o0 != null) {
                this.O0000Oo = this.O00000o0.getWidth();
                this.O0000Oo0 = this.O00000o0.getHeight();
            }
        }
    }

    public float O00000o(int i) {
        switch (i) {
            case 0:
                return this.O0000oOO;
            case 1:
                return 1.0f - this.O0000oOO;
            case 2:
                return 1.0f - this.O0000oOo;
            default:
                return 0.0f;
        }
    }

    public void O00000o() {
        if (getWidth() != 0 && getHeight() != 0) {
            O00000oo();
            postInvalidate();
        }
    }

    public Point O00000o0() {
        return new Point(this.O0000Ooo, this.O0000o00 - 2);
    }

    public void O00000o0(int i) {
        this.O0000o0 = 1;
        this.O0000o0O = i;
        O00000o();
    }

    public boolean O00000oO() {
        return this.O0000OOo;
    }

    public void onDraw(Canvas canvas) {
        try {
            if (getWidth() != 0) {
                if (getHeight() != 0) {
                    if (this.O00000Oo != null) {
                        if (!this.O0000o) {
                            O00000oo();
                            this.O0000o = true;
                        }
                        canvas.drawBitmap(O00000Oo(), (float) this.O0000Ooo, (float) this.O0000o00, this.O0000O0o);
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
