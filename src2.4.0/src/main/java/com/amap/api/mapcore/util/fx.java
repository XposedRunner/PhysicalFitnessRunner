package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: ScaleView */
public class fx extends View {
    private String O000000o = "";
    private int O00000Oo = 0;
    private Paint O00000o;
    private ca O00000o0;
    private Paint O00000oO;
    private Rect O00000oo;
    private IPoint O0000O0o;
    private float O0000OOo = 0.0f;
    private final int[] O0000Oo0 = new int[]{10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};

    public fx(Context context, ca caVar) {
        super(context);
        this.O00000o0 = caVar;
        this.O00000o = new Paint();
        this.O00000oo = new Rect();
        this.O00000o.setAntiAlias(true);
        this.O00000o.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.O00000o.setStrokeWidth(2.0f * bu.O000000o);
        this.O00000o.setStyle(Style.STROKE);
        this.O00000oO = new Paint();
        this.O00000oO.setAntiAlias(true);
        this.O00000oO.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.O00000oO.setTextSize(20.0f * bu.O000000o);
        this.O0000OOo = (float) OOOO0OO.O000000o(context, 1.0f);
        this.O0000O0o = new IPoint();
    }

    public void O000000o() {
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O000000o = null;
        this.O0000O0o = null;
    }

    public void O000000o(int i) {
        this.O00000Oo = i;
    }

    public void O000000o(String str) {
        this.O000000o = str;
    }

    public void O000000o(boolean z) {
        if (z) {
            setVisibility(0);
            O00000Oo();
            return;
        }
        O000000o("");
        O000000o(0);
        setVisibility(8);
    }

    public void O00000Oo() {
        if (this.O00000o0 != null) {
            try {
                float O000000o = this.O00000o0.O000000o(1);
                this.O00000o0.O000000o(1, this.O0000O0o);
                if (this.O0000O0o != null) {
                    DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) this.O0000O0o.x, (long) this.O0000O0o.y, 20);
                    double cos = (double) ((float) ((((Math.cos((pixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) O000000o))));
                    int i = (int) O000000o;
                    int O0000oOO = (int) (((double) this.O0000Oo0[i]) / (cos * ((double) this.O00000o0.O0000oOO())));
                    String O000000o2 = OOo000.O000000o(this.O0000Oo0[i]);
                    O000000o(O0000oOO);
                    O000000o(O000000o2);
                    pixelsToLatLong.recycle();
                    invalidate();
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.O000000o != null && !"".equals(this.O000000o) && this.O00000Oo != 0) {
            Point O0000Ooo = this.O00000o0.O0000Ooo();
            if (O0000Ooo != null) {
                this.O00000oO.getTextBounds(this.O000000o, 0, this.O000000o.length(), this.O00000oo);
                int i = O0000Ooo.x;
                int height = (O0000Ooo.y - this.O00000oo.height()) + 5;
                canvas.drawText(this.O000000o, (float) (((this.O00000Oo - this.O00000oo.width()) / 2) + i), (float) height, this.O00000oO);
                float f = (float) i;
                float height2 = (float) (height + (this.O00000oo.height() - 5));
                float f2 = f;
                canvas.drawLine(f2, height2 - (this.O0000OOo * 2.0f), f, height2 + bu.O000000o, this.O00000o);
                canvas.drawLine(f2, height2, (float) (this.O00000Oo + i), height2, this.O00000o);
                canvas.drawLine((float) (this.O00000Oo + i), height2 - (2.0f * this.O0000OOo), (float) (i + this.O00000Oo), height2 + bu.O000000o, this.O00000o);
            }
        }
    }
}
