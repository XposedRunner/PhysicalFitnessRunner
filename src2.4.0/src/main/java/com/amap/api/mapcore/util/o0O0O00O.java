package com.amap.api.mapcore.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TraceResultPool */
public class o0O0O00O {
    private static volatile o0O0O00O O00000Oo;
    private Map<String, O000000o> O000000o;

    /* compiled from: TraceResultPool */
    class O000000o {
        private int O00000Oo = 0;
        private int O00000o = 0;
        private int O00000o0 = 0;
        private int O00000oO = 0;
        private int O00000oo = 0;
        private HashMap<Integer, List<LatLng>> O0000O0o;
        private List<LatLng> O0000OOo = new ArrayList();

        public O000000o(int i, int i2, int i3, HashMap<Integer, List<LatLng>> hashMap) {
            this.O00000Oo = i2;
            this.O0000O0o = hashMap;
            this.O00000o0 = i;
            this.O00000oO = i3;
        }

        private void O000000o(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.O00000o;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.O00000o0);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.O00000o++;
            this.O00000oo++;
        }

        private void O00000Oo(Handler handler) {
            if (this.O00000oo > 0) {
                int O000000o = o0O00Oo0.O000000o(this.O0000OOo);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.O0000OOo;
                obtainMessage.what = 101;
                obtainMessage.arg1 = O000000o;
                obtainMessage.arg2 = this.O00000oO;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.O00000o0);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                return;
            }
            o0O0O00O.this.O000000o(handler, this.O00000o0, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }

        public HashMap<Integer, List<LatLng>> O000000o() {
            return this.O0000O0o;
        }

        public void O000000o(Handler handler) {
            for (int i = this.O00000o; i <= this.O00000Oo; i++) {
                List list = (List) this.O0000O0o.get(Integer.valueOf(i));
                if (list == null) {
                    break;
                }
                this.O0000OOo.addAll(list);
                O000000o(handler, list);
            }
            if (this.O00000o == this.O00000Oo + 1) {
                O00000Oo(handler);
            }
        }
    }

    public o0O0O00O() {
        this.O000000o = null;
        this.O000000o = Collections.synchronizedMap(new HashMap());
    }

    public static o0O0O00O O000000o() {
        if (O00000Oo == null) {
            synchronized (o0O0O00O.class) {
                if (O00000Oo == null) {
                    O00000Oo = new o0O0O00O();
                }
            }
        }
        return O00000Oo;
    }

    public synchronized O000000o O000000o(String str) {
        if (this.O000000o == null) {
            return null;
        }
        return (O000000o) this.O000000o.get(str);
    }

    public void O000000o(Handler handler, int i, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    public synchronized void O000000o(String str, int i, int i2, int i3) {
        if (this.O000000o != null) {
            this.O000000o.put(str, new O000000o(i, i2, i3, new HashMap(16)));
        }
    }

    public synchronized void O000000o(String str, int i, List<LatLng> list) {
        if (this.O000000o != null) {
            ((O000000o) this.O000000o.get(str)).O000000o().put(Integer.valueOf(i), list);
        }
    }
}
