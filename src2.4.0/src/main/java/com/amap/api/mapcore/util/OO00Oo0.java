package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;

/* compiled from: CustomStyleTask */
public class OO00Oo0 implements Runnable {
    private Context O000000o;
    private ca O00000Oo;
    private O000000o O00000o;
    private OO00OOO O00000o0;
    private int O00000oO = 0;

    /* compiled from: CustomStyleTask */
    public interface O000000o {
        void O000000o(byte[] bArr, int i);
    }

    public OO00Oo0(Context context, O000000o o000000o, int i) {
        boolean z = false;
        this.O000000o = context;
        this.O00000o = o000000o;
        this.O00000oO = i;
        if (this.O00000o0 == null) {
            Context context2 = this.O000000o;
            String str = "";
            if (i == 1) {
                z = true;
            }
            this.O00000o0 = new OO00OOO(context2, str, z);
        }
    }

    public OO00Oo0(Context context, ca caVar) {
        this.O000000o = context;
        this.O00000Oo = caVar;
        if (this.O00000o0 == null) {
            this.O00000o0 = new OO00OOO(this.O000000o, "");
        }
    }

    public void O000000o() {
        this.O000000o = null;
        if (this.O00000o0 != null) {
            this.O00000o0 = null;
        }
    }

    public void O000000o(String str) {
        if (this.O00000o0 != null) {
            this.O00000o0.O00000Oo(str);
        }
    }

    public void O00000Oo() {
        OOOo000.O000000o().O000000o(this);
    }

    public void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.O00000o0 != null) {
                    com.amap.api.mapcore.util.OO00OOO.O000000o o000000o = (com.amap.api.mapcore.util.OO00OOO.O000000o) this.O00000o0.O000000o();
                    if (!(o000000o == null || o000000o.O000000o == null)) {
                        if (this.O00000o != null) {
                            this.O00000o.O000000o(o000000o.O000000o, this.O00000oO);
                        } else if (this.O00000Oo != null) {
                            this.O00000Oo.O000000o(this.O00000Oo.getMapConfig().isCustomStyleEnable(), o000000o.O000000o);
                        }
                    }
                }
                ooOOOOoo.O000000o(this.O000000o, OOo000.O00000oO());
                if (this.O00000Oo != null) {
                    this.O00000Oo.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
