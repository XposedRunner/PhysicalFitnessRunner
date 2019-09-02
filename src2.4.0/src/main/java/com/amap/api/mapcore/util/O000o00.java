package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap.CommonInfoWindowAdapter;
import com.amap.api.maps.AMap.ImageInfoWindowAdapter;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.MultiPositionInfoWindowAdapter;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;

/* compiled from: InfoWindowDelegate */
public class O000o00 {
    InfoWindowAdapter O000000o = null;
    CommonInfoWindowAdapter O00000Oo = null;
    private boolean O00000o = true;
    Context O00000o0;
    private View O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private Drawable O0000OOo = null;
    private O000o000 O0000Oo;
    private O000o000 O0000Oo0;
    private InfoWindowAdapter O0000OoO = new InfoWindowAdapter() {
        public View getInfoContents(Marker marker) {
            return null;
        }

        public View getInfoWindow(Marker marker) {
            try {
                if (O000o00.this.O0000OOo == null) {
                    O000o00.this.O0000OOo = OOO.O000000o(O000o00.this.O00000o0, "infowindow_bg.9.png");
                }
                if (O000o00.this.O00000oO == null) {
                    O000o00.this.O00000oO = new LinearLayout(O000o00.this.O00000o0);
                    O000o00.this.O00000oO.setBackground(O000o00.this.O0000OOo);
                    O000o00.this.O00000oo = new TextView(O000o00.this.O00000o0);
                    O000o00.this.O00000oo.setText(marker.getTitle());
                    O000o00.this.O00000oo.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    O000o00.this.O0000O0o = new TextView(O000o00.this.O00000o0);
                    O000o00.this.O0000O0o.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    O000o00.this.O0000O0o.setText(marker.getSnippet());
                    ((LinearLayout) O000o00.this.O00000oO).setOrientation(1);
                    ((LinearLayout) O000o00.this.O00000oO).addView(O000o00.this.O00000oo);
                    ((LinearLayout) O000o00.this.O00000oO).addView(O000o00.this.O0000O0o);
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return O000o00.this.O00000oO;
        }
    };
    private CommonInfoWindowAdapter O0000Ooo = new CommonInfoWindowAdapter() {
        public InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                InfoWindowParams infoWindowParams = new InfoWindowParams();
                if (O000o00.this.O0000OOo == null) {
                    O000o00.this.O0000OOo = OOO.O000000o(O000o00.this.O00000o0, "infowindow_bg.9.png");
                }
                O000o00.this.O00000oO = new LinearLayout(O000o00.this.O00000o0);
                O000o00.this.O00000oO.setBackground(O000o00.this.O0000OOo);
                O000o00.this.O00000oo = new TextView(O000o00.this.O00000o0);
                O000o00.this.O00000oo.setText("标题");
                O000o00.this.O00000oo.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                O000o00.this.O0000O0o = new TextView(O000o00.this.O00000o0);
                O000o00.this.O0000O0o.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                O000o00.this.O0000O0o.setText("内容");
                ((LinearLayout) O000o00.this.O00000oO).setOrientation(1);
                ((LinearLayout) O000o00.this.O00000oO).addView(O000o00.this.O00000oo);
                ((LinearLayout) O000o00.this.O00000oO).addView(O000o00.this.O0000O0o);
                infoWindowParams.setInfoWindowType(2);
                infoWindowParams.setInfoWindow(O000o00.this.O00000oO);
                return infoWindowParams;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    };

    public O000o00(Context context) {
        this.O00000o0 = context;
    }

    public View O000000o(BasePointOverlay basePointOverlay) {
        if (this.O000000o != null) {
            return this.O000000o.getInfoWindow((Marker) basePointOverlay);
        }
        if (this.O00000Oo != null) {
            InfoWindowParams infoWindowParams = this.O00000Oo.getInfoWindowParams(basePointOverlay);
            if (infoWindowParams != null) {
                return infoWindowParams.getInfoWindow();
            }
        }
        InfoWindowParams infoWindowParams2 = this.O0000Ooo.getInfoWindowParams(basePointOverlay);
        return infoWindowParams2 != null ? infoWindowParams2.getInfoWindow() : null;
    }

    public View O000000o(Marker marker) {
        return (this.O000000o == null || !(this.O000000o instanceof MultiPositionInfoWindowAdapter)) ? null : ((MultiPositionInfoWindowAdapter) this.O000000o).getInfoWindowClick(marker);
    }

    public void O000000o(O000o000 o000o000) {
        synchronized (this) {
            this.O0000Oo0 = o000o000;
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.O000000o(this);
            }
        }
    }

    public void O000000o(bi biVar) throws RemoteException {
        O000o000 O00000o = O00000o();
        if (O00000o != null) {
            O00000o.O000000o(biVar);
        }
    }

    public synchronized void O000000o(CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.O00000Oo = commonInfoWindowAdapter;
        this.O000000o = null;
        if (this.O00000Oo == null) {
            this.O00000Oo = this.O0000Ooo;
            this.O00000o = true;
        } else {
            this.O00000o = false;
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.a_();
        }
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.a_();
        }
    }

    public synchronized void O000000o(InfoWindowAdapter infoWindowAdapter) {
        this.O000000o = infoWindowAdapter;
        this.O00000Oo = null;
        if (this.O000000o == null) {
            this.O000000o = this.O0000OoO;
            this.O00000o = true;
        } else {
            this.O00000o = false;
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.a_();
        }
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.a_();
        }
    }

    public void O000000o(String str, String str2) {
        if (this.O00000oo != null) {
            this.O00000oo.requestLayout();
            this.O00000oo.setText(str);
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.requestLayout();
            this.O0000O0o.setText(str2);
        }
        if (this.O00000oO != null) {
            this.O00000oO.requestLayout();
        }
    }

    public synchronized boolean O000000o() {
        return this.O00000o;
    }

    public boolean O000000o(MotionEvent motionEvent) {
        O000o000 O00000o = O00000o();
        return O00000o != null ? O00000o.O000000o(motionEvent) : false;
    }

    public View O00000Oo(BasePointOverlay basePointOverlay) {
        if (this.O000000o != null) {
            return this.O000000o.getInfoContents((Marker) basePointOverlay);
        }
        if (this.O00000Oo != null) {
            InfoWindowParams infoWindowParams = this.O00000Oo.getInfoWindowParams(basePointOverlay);
            if (infoWindowParams != null) {
                return infoWindowParams.getInfoContents();
            }
        }
        InfoWindowParams infoWindowParams2 = this.O0000Ooo.getInfoWindowParams(basePointOverlay);
        return infoWindowParams2 != null ? infoWindowParams2.getInfoContents() : null;
    }

    public View O00000Oo(Marker marker) {
        return (this.O000000o == null || !(this.O000000o instanceof MultiPositionInfoWindowAdapter)) ? null : ((MultiPositionInfoWindowAdapter) this.O000000o).getOverturnInfoWindow(marker);
    }

    public void O00000Oo() {
        this.O00000o0 = null;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O0000O0o = null;
        synchronized (this) {
            OOo000.O000000o(this.O0000OOo);
            this.O0000OOo = null;
            this.O0000OoO = null;
            this.O000000o = null;
        }
        this.O00000Oo = null;
        this.O0000Oo0 = null;
        this.O0000Oo = null;
    }

    public void O00000Oo(O000o000 o000o000) {
        synchronized (this) {
            this.O0000Oo = o000o000;
            if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(this);
            }
        }
    }

    public synchronized O000o000 O00000o() {
        if (this.O000000o != null) {
            if (this.O000000o instanceof ImageInfoWindowAdapter) {
                return this.O0000Oo;
            } else if (this.O000000o instanceof MultiPositionInfoWindowAdapter) {
                return this.O0000Oo;
            }
        }
        if (this.O00000Oo == null || this.O00000Oo.getInfoWindowParams(null).getInfoWindowType() != 1) {
            return this.O0000Oo0;
        }
        return this.O0000Oo;
    }

    public long O00000o0(BasePointOverlay basePointOverlay) {
        if (this.O000000o != null && (this.O000000o instanceof ImageInfoWindowAdapter)) {
            return ((ImageInfoWindowAdapter) this.O000000o).getInfoWindowUpdateTime();
        }
        if (this.O00000Oo != null) {
            InfoWindowParams infoWindowParams = this.O00000Oo.getInfoWindowParams(basePointOverlay);
            if (infoWindowParams != null) {
                return infoWindowParams.getInfoWindowUpdateTime();
            }
        }
        return 0;
    }

    public View O00000o0(Marker marker) {
        return (this.O000000o == null || !(this.O000000o instanceof MultiPositionInfoWindowAdapter)) ? null : ((MultiPositionInfoWindowAdapter) this.O000000o).getOverturnInfoWindowClick(marker);
    }

    public void O00000o0() {
        O000o000 O00000o = O00000o();
        if (O00000o != null) {
            O00000o.O00000Oo();
        }
    }

    public void O00000oO() {
        O000o000 O00000o = O00000o();
        if (O00000o != null) {
            O00000o.a_();
        }
    }

    public Drawable O00000oo() {
        if (this.O0000OOo == null) {
            try {
                this.O0000OOo = OOO.O000000o(this.O00000o0, "infowindow_bg.9.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.O0000OOo;
    }
}
