package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;

/* compiled from: CompassView */
public class fs extends LinearLayout {
    Bitmap O000000o;
    Bitmap O00000Oo;
    ImageView O00000o;
    Bitmap O00000o0;
    ca O00000oO;
    Matrix O00000oo = new Matrix();

    public fs(Context context, ca caVar) {
        super(context);
        this.O00000oO = caVar;
        try {
            this.O00000o0 = OOo000.O000000o(context, "maps_dav_compass_needle_large.png");
            this.O00000Oo = OOo000.O000000o(this.O00000o0, bu.O000000o * 0.8f);
            this.O00000o0 = OOo000.O000000o(this.O00000o0, bu.O000000o * 0.7f);
            if (this.O00000Oo != null) {
                if (this.O00000o0 != null) {
                    this.O000000o = Bitmap.createBitmap(this.O00000Oo.getWidth(), this.O00000Oo.getHeight(), Config.ARGB_8888);
                    Canvas canvas = new Canvas(this.O000000o);
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setFilterBitmap(true);
                    canvas.drawBitmap(this.O00000o0, ((float) (this.O00000Oo.getWidth() - this.O00000o0.getWidth())) / 2.0f, ((float) (this.O00000Oo.getHeight() - this.O00000o0.getHeight())) / 2.0f, paint);
                    this.O00000o = new ImageView(context);
                    this.O00000o.setScaleType(ScaleType.MATRIX);
                    this.O00000o.setImageBitmap(this.O000000o);
                    this.O00000o.setClickable(true);
                    O00000Oo();
                    this.O00000o.setOnTouchListener(new OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            try {
                                if (!fs.this.O00000oO.isMaploaded()) {
                                    return false;
                                }
                                if (motionEvent.getAction() == 0) {
                                    fs.this.O00000o.setImageBitmap(fs.this.O00000Oo);
                                } else if (motionEvent.getAction() == 1) {
                                    fs.this.O00000o.setImageBitmap(fs.this.O000000o);
                                    CameraPosition cameraPosition = fs.this.O00000oO.getCameraPosition();
                                    fs.this.O00000oO.O00000Oo(O000O0o0.O000000o(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                                }
                                return false;
                            } catch (Throwable th) {
                                ooOOOOoo.O00000o0(th, "CompassView", "onTouch");
                                th.printStackTrace();
                            }
                        }
                    });
                    addView(this.O00000o);
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public void O000000o() {
        try {
            removeAllViews();
            if (this.O000000o != null) {
                this.O000000o.recycle();
            }
            if (this.O00000Oo != null) {
                this.O00000Oo.recycle();
            }
            if (this.O00000o0 != null) {
                this.O00000o0.recycle();
            }
            if (this.O00000oo != null) {
                this.O00000oo.reset();
                this.O00000oo = null;
            }
            this.O00000o0 = null;
            this.O000000o = null;
            this.O00000Oo = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public void O000000o(boolean z) {
        if (z) {
            setVisibility(0);
            O00000Oo();
            return;
        }
        setVisibility(8);
    }

    public void O00000Oo() {
        try {
            if (this.O00000oO != null && this.O00000o != null) {
                float O0000o0O = this.O00000oO.O0000o0O(1);
                float O0000o0 = this.O00000oO.O0000o0(1);
                if (this.O00000oo == null) {
                    this.O00000oo = new Matrix();
                }
                this.O00000oo.reset();
                this.O00000oo.postRotate(-O0000o0, ((float) this.O00000o.getDrawable().getBounds().width()) / 2.0f, ((float) this.O00000o.getDrawable().getBounds().height()) / 2.0f);
                this.O00000oo.postScale(1.0f, (float) Math.cos((((double) O0000o0O) * 3.141592653589793d) / 180.0d), ((float) this.O00000o.getDrawable().getBounds().width()) / 2.0f, ((float) this.O00000o.getDrawable().getBounds().height()) / 2.0f);
                this.O00000o.setImageMatrix(this.O00000oo);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
