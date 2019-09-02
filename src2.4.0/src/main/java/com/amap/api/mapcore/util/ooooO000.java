package com.amap.api.mapcore.util;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class ooooO000 extends oOO0OO0O {
    protected Context O000000o;
    protected o0OO0o00 O00000Oo;

    public ooooO000(Context context, o0OO0o00 o0oo0o00) {
        if (context != null) {
            this.O000000o = context.getApplicationContext();
        }
        this.O00000Oo = o0oo0o00;
    }

    private byte[] O000000o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(o0OOOO00.O000000o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{(byte) 1});
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "bre", "gbh");
            }
            return toByteArray;
        } catch (Throwable th2) {
            oO0OoOO0.O000000o(th2, "bre", "gbh");
        }
        return null;
    }

    private byte[] O0000Oo() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O00000o0 = O00000o0();
            if (O00000o0 != null) {
                if (O00000o0.length != 0) {
                    byteArrayOutputStream.write(new byte[]{(byte) 1});
                    O00000o0 = o0O0OOOo.O000000o(this.O000000o, O00000o0);
                    byteArrayOutputStream.write(O000000o(O00000o0));
                    byteArrayOutputStream.write(O00000o0);
                    O00000o0 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        oO0OoOO0.O000000o(th, "bre", "gred");
                    }
                    return O00000o0;
                }
            }
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            O00000o0 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                oO0OoOO0.O000000o(th2, "bre", "gred");
            }
            return O00000o0;
        } catch (Throwable th22) {
            oO0OoOO0.O000000o(th22, "bre", "gred");
        }
        return new byte[]{(byte) 0};
    }

    private byte[] O0000Oo0() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O00000Oo = O00000Oo();
            if (O00000Oo != null) {
                if (O00000Oo.length != 0) {
                    byteArrayOutputStream.write(new byte[]{(byte) 1});
                    byteArrayOutputStream.write(O000000o(O00000Oo));
                    byteArrayOutputStream.write(O00000Oo);
                    O00000Oo = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        oO0OoOO0.O000000o(th, "bre", "grrd");
                    }
                    return O00000Oo;
                }
            }
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            O00000Oo = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                oO0OoOO0.O000000o(th2, "bre", "grrd");
            }
            return O00000Oo;
        } catch (Throwable th22) {
            oO0OoOO0.O000000o(th22, "bre", "grrd");
        }
        return new byte[]{(byte) 0};
    }

    /* Access modifiers changed, original: protected */
    public byte[] O000000o(byte[] bArr) {
        byte length = (byte) (bArr.length % 256);
        return new byte[]{(byte) (r5 / 256), length};
    }

    public abstract byte[] O00000Oo();

    /* Access modifiers changed, original: protected */
    public String O00000o() {
        return "2.1";
    }

    public abstract byte[] O00000o0();

    public boolean O00000oO() {
        return true;
    }

    public byte[] O00000oo() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O000000o;
            byteArrayOutputStream.write(new byte[]{(byte) 3});
            if (O00000oO()) {
                O000000o = o0O0OOOo.O000000o(this.O000000o, O0000OOo());
                byteArrayOutputStream.write(O000000o(O000000o));
                byteArrayOutputStream.write(O000000o);
            } else {
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            }
            O000000o = o0OOOO00.O000000o(O00000o());
            if (O000000o == null || O000000o.length <= 0) {
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            } else {
                byteArrayOutputStream.write(O000000o(O000000o));
                byteArrayOutputStream.write(O000000o);
            }
            O000000o = o0OOOO00.O000000o(O0000O0o());
            if (O000000o == null || O000000o.length <= 0) {
                byteArrayOutputStream.write(new byte[]{(byte) 0, (byte) 0});
            } else {
                byteArrayOutputStream.write(O000000o(O000000o));
                byteArrayOutputStream.write(O000000o);
            }
            O000000o = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "bre", "gred");
            }
            return O000000o;
        } catch (Throwable th2) {
            oO0OoOO0.O000000o(th2, "bre", "gred");
        }
        return new byte[]{(byte) 0};
    }

    public String O0000O0o() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.O00000Oo.O00000o0(), this.O00000Oo.O000000o()});
    }

    /* Access modifiers changed, original: protected */
    public boolean O0000OOo() {
        return false;
    }

    public final byte[] getEntityBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(O000000o());
            byteArrayOutputStream.write(O00000oo());
            byteArrayOutputStream.write(O0000Oo0());
            byteArrayOutputStream.write(O0000Oo());
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "bre", "geb");
            }
            return toByteArray;
        } catch (Throwable th2) {
            oO0OoOO0.O000000o(th2, "bre", "geb");
        }
        return null;
    }

    public Map<String, String> getParams() {
        String O00000oo = o0O0O0Oo.O00000oo(this.O000000o);
        String O000000o = o0O0OOOo.O000000o();
        Context context = this.O000000o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key=");
        stringBuilder.append(O00000oo);
        String O000000o2 = o0O0OOOo.O000000o(context, O000000o, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceInfo.TAG_TIMESTAMPS, O000000o);
        hashMap.put("key", O00000oo);
        hashMap.put("scode", O000000o2);
        return hashMap;
    }
}
