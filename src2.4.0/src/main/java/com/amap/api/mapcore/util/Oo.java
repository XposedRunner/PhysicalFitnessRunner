package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/* compiled from: AMapMessageHandler */
public final class Oo implements Callback {
    private Map<Integer, O00000o> O000000o = new Hashtable();
    private Handler O00000Oo;
    private O00o000 O00000o;
    private HandlerThread O00000o0;
    private boolean O00000oO = false;

    public Oo(Context context, O00o000 o00o000, cb cbVar) {
        this.O00000o = o00o000;
        this.O00000o0 = new HandlerThread("AMapMessageHandler");
        this.O00000o0.start();
        this.O00000Oo = new Handler(this.O00000o0.getLooper(), this);
        this.O00000oO = false;
    }

    public void O000000o() {
        this.O00000oO = true;
        if (this.O00000o0 != null) {
            this.O00000o0.quit();
        }
        if (this.O00000Oo != null) {
            this.O00000Oo.removeCallbacksAndMessages(null);
        }
    }

    public void O000000o(O00000o o00000o) {
        try {
            if (!this.O00000oO && o00000o != null) {
                int i = o00000o.O000000o;
                if (o00000o.O000000o != 153) {
                    synchronized (this.O000000o) {
                        if (i < 33) {
                            this.O000000o.put(Integer.valueOf(i), o00000o);
                        }
                    }
                } else if (this.O000000o != null && this.O000000o.size() > 0) {
                    this.O00000Oo.obtainMessage(153).sendToTarget();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
        }
    }

    public boolean handleMessage(Message message) {
        try {
            if (this.O00000oO || message == null) {
                return false;
            }
            O00000o o00000o = (O00000o) message.obj;
            int i = message.what;
            if (i == 1) {
                this.O00000o.O0000oOO(((Integer) o00000o.O00000Oo).intValue());
            } else if (i == 153) {
                synchronized (this.O000000o) {
                    Set<Integer> keySet = this.O000000o.keySet();
                    if (keySet.size() > 0) {
                        for (Integer remove : keySet) {
                            O00000o o00000o2 = (O00000o) this.O000000o.remove(remove);
                            this.O00000Oo.obtainMessage(o00000o2.O000000o, o00000o2).sendToTarget();
                        }
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
