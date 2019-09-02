package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.mapcore.util.O00o00.O000000o;
import com.amap.api.maps.AMap;
import java.io.IOException;

/* compiled from: OfflineMapDownloadTask */
public class O00O0o extends s implements O000000o {
    private O00o00 O000000o;
    private O00oo000 O00000Oo;
    private Context O00000o;
    private O0O00oO O00000o0;
    private Bundle O00000oO;
    private boolean O00000oo;

    public O00O0o(O0O00oO o0O00oO, Context context) {
        this.O00000oO = new Bundle();
        this.O00000oo = false;
        this.O00000o0 = o0O00oO;
        this.O00000o = context;
    }

    public O00O0o(O0O00oO o0O00oO, Context context, AMap aMap) {
        this(o0O00oO, context);
    }

    private String O00000o() {
        return OOo000.O00000o0(this.O00000o);
    }

    private void O00000oO() throws IOException {
        this.O000000o = new O00o00(new O00o0(this.O00000o0.getUrl(), O00000o(), this.O00000o0.O00oOooO(), 1, this.O00000o0.O00oOooo()), this.O00000o0.getUrl(), this.O00000o, this.O00000o0);
        this.O000000o.O000000o((O000000o) this);
        this.O00000Oo = new O00oo000(this.O00000o0, this.O00000o0);
        if (!this.O00000oo) {
            this.O000000o.O000000o();
        }
    }

    public void O000000o() {
        this.O00000oo = true;
        if (this.O000000o != null) {
            this.O000000o.O00000Oo();
        } else {
            cancelTask();
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.O000000o();
        }
    }

    public void O00000Oo() {
        if (this.O00000oO != null) {
            this.O00000oO.clear();
            this.O00000oO = null;
        }
    }

    public void O00000o0() {
        if (this.O00000Oo != null) {
            this.O00000Oo.O00000Oo();
        }
    }

    public void runTask() {
        if (this.O00000o0.O0000ooo()) {
            this.O00000o0.O000000o(O0O000o.O000000o.file_io_exception);
            return;
        }
        try {
            O00000oO();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
