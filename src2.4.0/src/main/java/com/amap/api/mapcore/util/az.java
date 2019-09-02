package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore.Inner_3dMap_location;

/* compiled from: MapLocationManagerResultHandler */
public final class az extends Handler {
    ax O000000o = null;

    public az(Looper looper, ax axVar) {
        super(looper);
        this.O000000o = axVar;
    }

    public az(ax axVar) {
        this.O000000o = axVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            try {
                if (this.O000000o != null) {
                    this.O000000o.O000000o((Inner_3dMap_location) message.obj);
                }
            } catch (Throwable th) {
                bp.O000000o(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
            }
        }
    }
}
