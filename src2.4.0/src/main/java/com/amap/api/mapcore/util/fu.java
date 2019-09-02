package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;

/* compiled from: LocationView */
public class fu extends LinearLayout {
    Bitmap O000000o;
    Bitmap O00000Oo;
    Bitmap O00000o;
    Bitmap O00000o0;
    Bitmap O00000oO;
    Bitmap O00000oo;
    ImageView O0000O0o;
    ca O0000OOo;
    boolean O0000Oo0 = false;

    @SuppressLint({"ClickableViewAccessibility"})
    public fu(Context context, ca caVar) {
        super(context);
        this.O0000OOo = caVar;
        try {
            this.O00000o = OOo000.O000000o(context, "location_selected.png");
            this.O000000o = OOo000.O000000o(this.O00000o, bu.O000000o);
            this.O00000oO = OOo000.O000000o(context, "location_pressed.png");
            this.O00000Oo = OOo000.O000000o(this.O00000oO, bu.O000000o);
            this.O00000oo = OOo000.O000000o(context, "location_unselected.png");
            this.O00000o0 = OOo000.O000000o(this.O00000oo, bu.O000000o);
            this.O0000O0o = new ImageView(context);
            this.O0000O0o.setImageBitmap(this.O000000o);
            this.O0000O0o.setClickable(true);
            this.O0000O0o.setPadding(0, 20, 20, 0);
            this.O0000O0o.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!fu.this.O0000Oo0) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        fu.this.O0000O0o.setImageBitmap(fu.this.O00000Oo);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            fu.this.O0000O0o.setImageBitmap(fu.this.O000000o);
                            fu.this.O0000OOo.setMyLocationEnabled(true);
                            Location myLocation = fu.this.O0000OOo.getMyLocation();
                            if (myLocation == null) {
                                return false;
                            }
                            LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                            fu.this.O0000OOo.O000000o(myLocation);
                            fu.this.O0000OOo.O000000o(O000O0o0.O000000o(latLng, fu.this.O0000OOo.O0000O0o()));
                        } catch (Throwable th) {
                            ooOOOOoo.O00000o0(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                    return false;
                }
            });
            addView(this.O0000O0o);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "LocationView", "create");
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
            if (this.O00000Oo != null) {
                this.O00000o0.recycle();
            }
            this.O000000o = null;
            this.O00000Oo = null;
            this.O00000o0 = null;
            if (this.O00000o != null) {
                this.O00000o.recycle();
                this.O00000o = null;
            }
            if (this.O00000oO != null) {
                this.O00000oO.recycle();
                this.O00000oO = null;
            }
            if (this.O00000oo != null) {
                this.O00000oo.recycle();
                this.O00000oo = null;
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public void O000000o(boolean z) {
        this.O0000Oo0 = z;
        if (z) {
            try {
                this.O0000O0o.setImageBitmap(this.O000000o);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "LocationView", "showSelect");
                th.printStackTrace();
                return;
            }
        }
        this.O0000O0o.setImageBitmap(this.O00000o0);
        this.O0000O0o.invalidate();
    }
}
