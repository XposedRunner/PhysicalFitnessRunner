package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;

/* compiled from: UiSettingsDelegateImp */
class O0000o0 implements cd {
    final Handler O000000o = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message != null && O0000o0.this.O00000Oo != null) {
                try {
                    switch (message.what) {
                        case 0:
                            O0000o0.this.O00000Oo.O000000o(O0000o0.this.O0000OOo);
                            break;
                        case 1:
                            O0000o0.this.O00000Oo.O00000oO(O0000o0.this.O0000Oo);
                            break;
                        case 2:
                            O0000o0.this.O00000Oo.O00000o(O0000o0.this.O0000Oo0);
                            break;
                        case 3:
                            O0000o0.this.O00000Oo.O00000o0(O0000o0.this.O00000oo);
                            break;
                        case 4:
                            O0000o0.this.O00000Oo.O00000Oo(O0000o0.this.O0000o0);
                            break;
                        case 5:
                            O0000o0.this.O00000Oo.O0000OOo(O0000o0.this.O0000OoO);
                            break;
                        case 6:
                            O0000o0.this.O00000Oo.O00oOooO();
                            break;
                        default:
                            break;
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "UiSettingsDelegateImp", "handleMessage");
                }
            }
        }
    };
    private ca O00000Oo;
    private boolean O00000o = true;
    private boolean O00000o0 = true;
    private boolean O00000oO = true;
    private boolean O00000oo = false;
    private boolean O0000O0o = true;
    private boolean O0000OOo = true;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = true;
    private boolean O0000OoO = true;
    private int O0000Ooo = 0;
    private boolean O0000o0 = true;
    private int O0000o00 = 1;
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;

    O0000o0(ca caVar) {
        this.O00000Oo = caVar;
    }

    public float getLogoMarginRate(int i) {
        return this.O00000Oo.O0000Ooo(i);
    }

    public int getLogoPosition() throws RemoteException {
        return this.O0000Ooo;
    }

    public int getZoomPosition() throws RemoteException {
        return this.O0000o00;
    }

    public boolean isCompassEnabled() throws RemoteException {
        return this.O0000Oo0;
    }

    public boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.O0000o0o;
    }

    public boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.O0000o0;
    }

    public boolean isLogoEnable() {
        return this.O0000OoO;
    }

    public boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.O00000oo;
    }

    public boolean isRotateGesturesEnabled() throws RemoteException {
        return this.O00000o0;
    }

    public boolean isScaleControlsEnabled() throws RemoteException {
        return this.O0000Oo;
    }

    public boolean isScrollGesturesEnabled() throws RemoteException {
        return this.O00000o;
    }

    public boolean isTiltGesturesEnabled() throws RemoteException {
        return this.O00000oO;
    }

    public boolean isZoomControlsEnabled() throws RemoteException {
        return this.O0000OOo;
    }

    public boolean isZoomGesturesEnabled() throws RemoteException {
        return this.O0000O0o;
    }

    public boolean isZoomInByScreenCenter() {
        return this.O0000o0O;
    }

    public void requestRefreshLogo() {
        this.O000000o.obtainMessage(6).sendToTarget();
    }

    public void setAllGesturesEnabled(boolean z) throws RemoteException {
        setRotateGesturesEnabled(z);
        setTiltGesturesEnabled(z);
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    public void setCompassEnabled(boolean z) throws RemoteException {
        this.O0000Oo0 = z;
        this.O000000o.obtainMessage(2).sendToTarget();
    }

    public void setGestureScaleByMapCenter(boolean z) throws RemoteException {
        this.O0000o0o = z;
    }

    public void setIndoorSwitchEnabled(boolean z) throws RemoteException {
        this.O0000o0 = z;
        this.O000000o.obtainMessage(4).sendToTarget();
    }

    public void setLogoBottomMargin(int i) {
        this.O00000Oo.O0000Oo(i);
    }

    public void setLogoEnable(boolean z) {
        this.O0000OoO = z;
        this.O000000o.obtainMessage(5).sendToTarget();
    }

    public void setLogoLeftMargin(int i) {
        this.O00000Oo.O0000OoO(i);
    }

    public void setLogoMarginRate(int i, float f) {
        this.O00000Oo.O000000o(i, f);
    }

    public void setLogoPosition(int i) throws RemoteException {
        this.O0000Ooo = i;
        this.O00000Oo.O0000Oo0(i);
    }

    public void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.O00000oo = z;
        this.O000000o.obtainMessage(3).sendToTarget();
    }

    public void setRotateGesturesEnabled(boolean z) throws RemoteException {
        this.O00000o0 = z;
    }

    public void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.O0000Oo = z;
        this.O000000o.obtainMessage(1).sendToTarget();
    }

    public void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.O00000o = z;
    }

    public void setTiltGesturesEnabled(boolean z) throws RemoteException {
        this.O00000oO = z;
    }

    public void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.O0000OOo = z;
        this.O000000o.obtainMessage(0).sendToTarget();
    }

    public void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.O0000O0o = z;
    }

    public void setZoomInByScreenCenter(boolean z) {
        this.O0000o0O = z;
    }

    public void setZoomPosition(int i) throws RemoteException {
        this.O0000o00 = i;
        this.O00000Oo.O0000O0o(i);
    }
}
