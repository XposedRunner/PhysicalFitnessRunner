package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import java.util.Map;

/* compiled from: NetManger */
public class oOO0O0O0 extends ooooOO00 {
    private static oOO0O0O0 O00000o0;
    private r O00000o;
    private Handler O00000oO;

    /* compiled from: NetManger */
    /* renamed from: com.amap.api.mapcore.util.oOO0O0O0$1 */
    class AnonymousClass1 extends s {
        final /* synthetic */ oOO0OO0O O000000o;
        final /* synthetic */ oOO0OOo0 O00000Oo;
        final /* synthetic */ oOO0O0O0 O00000o0;

        public void runTask() {
            try {
                this.O00000o0.O000000o(this.O00000o0.O00000o0(this.O000000o, false), this.O00000Oo);
            } catch (o0O0oo0o e) {
                this.O00000o0.O000000o(e, this.O00000Oo);
            }
        }
    }

    /* compiled from: NetManger */
    static class O000000o extends Handler {
        private O000000o(Looper looper) {
            super(looper);
        }

        /* synthetic */ O000000o(Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((oOOO000o) message.obj).O00000Oo.O000000o();
                        break;
                    case 1:
                        oOOO000o oooo000o = (oOOO000o) message.obj;
                        oooo000o.O00000Oo.O000000o(oooo000o.O000000o);
                        break;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private oOO0O0O0(boolean z, int i) {
        if (z) {
            try {
                this.O00000o = r.O00000Oo(i);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.O00000oO = new O000000o(Looper.getMainLooper(), null);
        } else {
            this.O00000oO = new O000000o();
        }
    }

    public static oOO0O0O0 O000000o(boolean z) {
        return O000000o(z, 5);
    }

    private static synchronized oOO0O0O0 O000000o(boolean z, int i) {
        oOO0O0O0 ooo0o0o0;
        synchronized (oOO0O0O0.class) {
            try {
                if (O00000o0 == null) {
                    O00000o0 = new oOO0O0O0(z, i);
                } else if (z && O00000o0.O00000o == null) {
                    O00000o0.O00000o = r.O00000Oo(i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ooo0o0o0 = O00000o0;
        }
        return ooo0o0o0;
    }

    private void O000000o(o0O0oo0o o0o0oo0o, oOO0OOo0 ooo0ooo0) {
        oOOO000o oooo000o = new oOOO000o();
        oooo000o.O000000o = o0o0oo0o;
        oooo000o.O00000Oo = ooo0ooo0;
        Message obtain = Message.obtain();
        obtain.obj = oooo000o;
        obtain.what = 1;
        this.O00000oO.sendMessage(obtain);
    }

    private void O000000o(oOO0Oo00 ooo0oo00, oOO0OOo0 ooo0ooo0) {
        ooo0ooo0.O000000o(ooo0oo00.O00000Oo, ooo0oo00.O000000o);
        oOOO000o oooo000o = new oOOO000o();
        oooo000o.O00000Oo = ooo0ooo0;
        Message obtain = Message.obtain();
        obtain.obj = oooo000o;
        obtain.what = 0;
        this.O00000oO.sendMessage(obtain);
    }

    public static oOO0O0O0 O00000Oo() {
        return O000000o(true, 5);
    }

    public Map<String, String> O00000Oo(oOO0OO0O ooo0oo0o, boolean z) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            O00000o0(ooo0oo0o);
            return new oOO0O00O(ooo0oo0o.a, ooo0oo0o.b, ooo0oo0o.c == null ? null : ooo0oo0o.c, z).O000000o(ooo0oo0o.getURL(), ooo0oo0o.isIPRequest(), ooo0oo0o.getIPDNSName(), ooo0oo0o.getRequestHead(), ooo0oo0o.getParams(), ooo0oo0o.isIgnoreGZip());
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] O00000Oo(oOO0OO0O ooo0oo0o) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            oOO0Oo00 O000000o = O000000o(ooo0oo0o, false);
            return O000000o != null ? O000000o.O000000o : null;
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            ooOOOOoo.O00000oO().O00000Oo(th, "NetManager", "makeSyncPostRequest");
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] O00000o(oOO0OO0O ooo0oo0o) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            oOO0Oo00 O00000o0 = O00000o0(ooo0oo0o, false);
            return O00000o0 != null ? O00000o0.O000000o : null;
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable unused) {
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    public oOO0Oo00 O00000o0(oOO0OO0O ooo0oo0o, boolean z) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            O00000o0(ooo0oo0o);
            return new oOO0O00O(ooo0oo0o.a, ooo0oo0o.b, ooo0oo0o.c == null ? null : ooo0oo0o.c, z).O00000Oo(ooo0oo0o.getURL(), ooo0oo0o.isIPRequest(), ooo0oo0o.getIPDNSName(), ooo0oo0o.getRequestHead(), ooo0oo0o.getParams(), ooo0oo0o.isIgnoreGZip());
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] O00000oO(oOO0OO0O ooo0oo0o) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            oOO0Oo00 O00000o0 = O00000o0(ooo0oo0o, true);
            return O00000o0 != null ? O00000o0.O000000o : null;
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable unused) {
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }
}
