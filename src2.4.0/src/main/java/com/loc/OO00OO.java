package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.amap.api.location.APSServiceBase;
import s.h.e.l.l.C;

/* compiled from: ApsServiceCore */
public class OO00OO implements APSServiceBase {
    OO000o O000000o = null;
    Context O00000Oo = null;
    Messenger O00000o0 = null;

    static {
        C.i(22);
    }

    public OO00OO(Context context) {
        this.O00000Oo = context.getApplicationContext();
        this.O000000o = new OO000o(this.O00000Oo);
    }

    public native IBinder onBind(Intent intent);

    public void onCreate() {
        try {
            OO000o.O00000oo();
            this.O000000o.O0000Oo = OO000OO.O00000o0();
            this.O000000o.O0000OoO = OO000OO.O00000Oo();
            this.O000000o.O000000o();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "onCreate");
        }
    }

    public void onDestroy() {
        try {
            if (this.O000000o != null) {
                this.O000000o.O00000Oo().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ApsServiceCore", "onDestroy");
        }
    }

    public native int onStartCommand(Intent intent, int i, int i2);
}
