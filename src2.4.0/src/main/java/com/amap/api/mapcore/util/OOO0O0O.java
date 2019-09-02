package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* compiled from: InfoCollectUtils */
public class OOO0O0O {
    private static boolean O000000o;
    private static volatile OOO0O0O O00000o;
    private Hashtable<String, String> O00000Oo = new Hashtable();
    private WeakReference<Context> O00000o0 = null;

    private OOO0O0O() {
    }

    public static OOO0O0O O000000o() {
        if (O00000o == null) {
            synchronized (OOO0O0O.class) {
                if (O00000o == null) {
                    O00000o = new OOO0O0O();
                }
            }
        }
        return O00000o;
    }

    public static void O000000o(int i) {
        if (O000000o) {
            O000000o(i < 1000);
        }
    }

    private void O000000o(String str) {
        if (str != null && this.O00000Oo != null) {
            synchronized (this.O00000Oo) {
                String O00000Oo = o0OO00o0.O00000Oo(str);
                if (!(this.O00000Oo == null || this.O00000Oo.contains(O00000Oo))) {
                    this.O00000Oo.put(O00000Oo, str);
                }
                if (O00000o()) {
                    O00000o0();
                }
            }
        }
    }

    public static void O000000o(boolean z) {
        O000000o = z;
    }

    public static void O00000Oo() {
        if (O00000o != null) {
            if (O00000o.O00000Oo != null && O00000o.O00000Oo.size() > 0) {
                synchronized (O00000o.O00000Oo) {
                    O00000o.O00000o0();
                    if (O00000o.O00000o0 != null) {
                        O00000o.O00000o0.clear();
                    }
                }
            }
            O00000o = null;
        }
        O000000o(false);
    }

    private boolean O00000o() {
        boolean z = false;
        if (this.O00000Oo == null) {
            return false;
        }
        if (this.O00000Oo.size() > 20) {
            z = true;
        }
        return z;
    }

    private void O00000o0() {
        if (O000000o) {
            if (this.O00000Oo != null) {
                StringBuffer stringBuffer = new StringBuffer();
                int i = 0;
                int size = this.O00000Oo.size();
                if (size > 0) {
                    stringBuffer.append("[");
                    for (String append : this.O00000Oo.values()) {
                        i++;
                        stringBuffer.append(append);
                        if (i < size) {
                            stringBuffer.append(",");
                        }
                    }
                    stringBuffer.append("]");
                    String stringBuffer2 = stringBuffer.toString();
                    if (!(TextUtils.isEmpty(stringBuffer2) || this.O00000o0 == null || this.O00000o0.get() == null)) {
                        oOOO0oOO.O000000o(stringBuffer2, (Context) this.O00000o0.get());
                    }
                }
                this.O00000Oo.clear();
            }
            return;
        }
        this.O00000Oo.clear();
    }

    public void O000000o(Context context) {
        if (context != null) {
            this.O00000o0 = new WeakReference(context);
        }
    }

    public void O000000o(LatLng latLng, String str, String str2) {
        if (O000000o) {
            if (!(latLng == null || TextUtils.isEmpty(str))) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("{");
                stringBuffer.append("\"lon\":");
                stringBuffer.append(latLng.longitude);
                stringBuffer.append(",");
                stringBuffer.append("\"lat\":");
                stringBuffer.append(latLng.latitude);
                stringBuffer.append(",");
                stringBuffer.append("\"title\":");
                stringBuffer.append("\"");
                stringBuffer.append(str);
                stringBuffer.append("\"");
                stringBuffer.append(",");
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                stringBuffer.append("\"snippet\":");
                stringBuffer.append("\"");
                stringBuffer.append(str2);
                stringBuffer.append("\"");
                stringBuffer.append("}");
                O000000o(stringBuffer.toString());
            }
            return;
        }
        this.O00000Oo.clear();
    }
}
