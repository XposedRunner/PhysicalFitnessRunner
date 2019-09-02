package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.fv.O000000o;

/* compiled from: ZoomControllerView */
class Oo0 extends LinearLayout {
    private Bitmap O000000o;
    private Bitmap O00000Oo;
    private Bitmap O00000o;
    private Bitmap O00000o0;
    private Bitmap O00000oO;
    private Bitmap O00000oo;
    private Bitmap O0000O0o;
    private Bitmap O0000OOo;
    private Bitmap O0000Oo;
    private Bitmap O0000Oo0;
    private Bitmap O0000OoO;
    private Bitmap O0000Ooo;
    private ImageView O0000o0;
    private ImageView O0000o00;
    private ca O0000o0O;

    public Oo0(Context context, ca caVar) {
        super(context);
        this.O0000o0O = caVar;
        try {
            this.O0000O0o = OOo000.O000000o(context, "zoomin_selected.png");
            this.O000000o = OOo000.O000000o(this.O0000O0o, bu.O000000o);
            this.O0000OOo = OOo000.O000000o(context, "zoomin_unselected.png");
            this.O00000Oo = OOo000.O000000o(this.O0000OOo, bu.O000000o);
            this.O0000Oo0 = OOo000.O000000o(context, "zoomout_selected.png");
            this.O00000o0 = OOo000.O000000o(this.O0000Oo0, bu.O000000o);
            this.O0000Oo = OOo000.O000000o(context, "zoomout_unselected.png");
            this.O00000o = OOo000.O000000o(this.O0000Oo, bu.O000000o);
            this.O0000OoO = OOo000.O000000o(context, "zoomin_pressed.png");
            this.O00000oO = OOo000.O000000o(this.O0000OoO, bu.O000000o);
            this.O0000Ooo = OOo000.O000000o(context, "zoomout_pressed.png");
            this.O00000oo = OOo000.O000000o(this.O0000Ooo, bu.O000000o);
            this.O0000o00 = new ImageView(context);
            this.O0000o00.setImageBitmap(this.O000000o);
            this.O0000o00.setClickable(true);
            this.O0000o0 = new ImageView(context);
            this.O0000o0.setImageBitmap(this.O00000o0);
            this.O0000o0.setClickable(true);
            this.O0000o00.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (Oo0.this.O0000o0O.O0000O0o() < Oo0.this.O0000o0O.getMaxZoomLevel()) {
                            if (Oo0.this.O0000o0O.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    Oo0.this.O0000o00.setImageBitmap(Oo0.this.O00000oO);
                                } else if (motionEvent.getAction() == 1) {
                                    Oo0.this.O0000o00.setImageBitmap(Oo0.this.O000000o);
                                    Oo0.this.O0000o0O.O00000Oo(O000O0o0.O000000o());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (RemoteException e) {
                        ooOOOOoo.O00000o0(e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.O0000o0.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (Oo0.this.O0000o0O.O0000O0o() > Oo0.this.O0000o0O.getMinZoomLevel()) {
                            if (Oo0.this.O0000o0O.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    Oo0.this.O0000o0.setImageBitmap(Oo0.this.O00000oo);
                                } else if (motionEvent.getAction() == 1) {
                                    Oo0.this.O0000o0.setImageBitmap(Oo0.this.O00000o0);
                                    Oo0.this.O0000o0O.O00000Oo(O000O0o0.O00000Oo());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                    }
                }
            });
            this.O0000o00.setPadding(0, 0, 20, -2);
            this.O0000o0.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.O0000o00);
            addView(this.O0000o0);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public void O000000o() {
        try {
            removeAllViews();
            this.O000000o.recycle();
            this.O00000Oo.recycle();
            this.O00000o0.recycle();
            this.O00000o.recycle();
            this.O00000oO.recycle();
            this.O00000oo.recycle();
            this.O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo = null;
            if (this.O0000O0o != null) {
                this.O0000O0o.recycle();
                this.O0000O0o = null;
            }
            if (this.O0000OOo != null) {
                this.O0000OOo.recycle();
                this.O0000OOo = null;
            }
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.recycle();
                this.O0000Oo0 = null;
            }
            if (this.O0000Oo != null) {
                this.O0000Oo.recycle();
                this.O0000O0o = null;
            }
            if (this.O0000OoO != null) {
                this.O0000OoO.recycle();
                this.O0000OoO = null;
            }
            if (this.O0000Ooo != null) {
                this.O0000Ooo.recycle();
                this.O0000Ooo = null;
            }
            this.O0000o00 = null;
            this.O0000o0 = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public void O000000o(float f) {
        try {
            if (f < this.O0000o0O.getMaxZoomLevel() && f > this.O0000o0O.getMinZoomLevel()) {
                this.O0000o00.setImageBitmap(this.O000000o);
                this.O0000o0.setImageBitmap(this.O00000o0);
            } else if (f == this.O0000o0O.getMinZoomLevel()) {
                this.O0000o0.setImageBitmap(this.O00000o);
                this.O0000o00.setImageBitmap(this.O000000o);
            } else if (f == this.O0000o0O.getMaxZoomLevel()) {
                this.O0000o00.setImageBitmap(this.O00000Oo);
                this.O0000o0.setImageBitmap(this.O00000o0);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public void O000000o(int i) {
        try {
            O000000o o000000o = (O000000o) getLayoutParams();
            if (i == 1) {
                o000000o.O00000o = 16;
            } else if (i == 2) {
                o000000o.O00000o = 80;
            }
            setLayoutParams(o000000o);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public void O000000o(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
