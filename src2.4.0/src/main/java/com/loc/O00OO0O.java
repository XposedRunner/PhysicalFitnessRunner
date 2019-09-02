package com.loc;

import android.content.Context;
import com.tencent.stat.DeviceInfo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class O00OO0O extends O00OOo {
    protected Context O000000o;
    protected OO0Oo0 O00000Oo;

    public O00OO0O(Context context, OO0Oo0 oO0Oo0) {
        if (context != null) {
            this.O000000o = context.getApplicationContext();
        }
        this.O00000Oo = oO0Oo0;
    }

    protected static byte[] O000000o(byte[] bArr) {
        byte length = (byte) (bArr.length % 256);
        return new byte[]{(byte) (r4 / 256), length};
    }

    private byte[] O0000o0() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O000000o;
            byteArrayOutputStream.write(new byte[]{(byte) 3});
            if (O00000oO()) {
                O000000o = OO0O0O.O000000o(this.O000000o, O0000Oo());
                byteArrayOutputStream.write(O000000o(O000000o));
            } else {
                O000000o = new byte[]{(byte) 0, (byte) 0};
            }
            byteArrayOutputStream.write(O000000o);
            O000000o = OO0o000.O000000o(O0000O0o());
            if (O000000o == null || O000000o.length <= 0) {
                O000000o = new byte[]{(byte) 0, (byte) 0};
            } else {
                byteArrayOutputStream.write(O000000o(O000000o));
            }
            byteArrayOutputStream.write(O000000o);
            O000000o = OO0o000.O000000o(O00000oo());
            if (O000000o == null || O000000o.length <= 0) {
                O000000o = new byte[]{(byte) 0, (byte) 0};
            } else {
                byteArrayOutputStream.write(O000000o(O000000o));
            }
            byteArrayOutputStream.write(O000000o);
            O000000o = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return O000000o;
            } catch (Throwable th) {
                O0000Oo.O000000o(th, "bre", "gred");
                return O000000o;
            }
        } catch (Throwable th2) {
            O0000Oo.O000000o(th2, "bre", "gred");
        }
        return new byte[]{(byte) 0};
    }

    private static byte[] O0000o00() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(OO0o000.O000000o("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{(byte) 1});
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Throwable th) {
                O0000Oo.O000000o(th, "bre", "gbh");
                return toByteArray;
            }
        } catch (Throwable th2) {
            O0000Oo.O000000o(th2, "bre", "gbh");
        }
        return null;
    }

    private byte[] O0000o0O() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O0000OOo = O0000OOo();
            if (O0000OOo != null) {
                if (O0000OOo.length != 0) {
                    byteArrayOutputStream.write(new byte[]{(byte) 1});
                    byteArrayOutputStream.write(O000000o(O0000OOo));
                    byteArrayOutputStream.write(O0000OOo);
                    O0000OOo = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        return O0000OOo;
                    } catch (Throwable th) {
                        O0000Oo.O000000o(th, "bre", "grrd");
                        return O0000OOo;
                    }
                }
            }
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            O0000OOo = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return O0000OOo;
            } catch (Throwable th2) {
                O0000Oo.O000000o(th2, "bre", "grrd");
                return O0000OOo;
            }
        } catch (Throwable th22) {
            O0000Oo.O000000o(th22, "bre", "grrd");
        }
        return new byte[]{(byte) 0};
    }

    private byte[] O0000o0o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] O0000Oo0 = O0000Oo0();
            if (O0000Oo0 != null) {
                if (O0000Oo0.length != 0) {
                    byteArrayOutputStream.write(new byte[]{(byte) 1});
                    Context context = this.O000000o;
                    O0000Oo0 = oOo00.O000000o(O0000Oo0);
                    byteArrayOutputStream.write(O000000o(O0000Oo0));
                    byteArrayOutputStream.write(O0000Oo0);
                    O0000Oo0 = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        return O0000Oo0;
                    } catch (Throwable th) {
                        O0000Oo.O000000o(th, "bre", "gred");
                        return O0000Oo0;
                    }
                }
            }
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            O0000Oo0 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return O0000Oo0;
            } catch (Throwable th2) {
                O0000Oo.O000000o(th2, "bre", "gred");
                return O0000Oo0;
            }
        } catch (Throwable th22) {
            O0000Oo.O000000o(th22, "bre", "gred");
        }
        return new byte[]{(byte) 0};
    }

    public Map<String, String> O00000Oo() {
        String O00000oo = OO00o00.O00000oo(this.O000000o);
        String O000000o = OO0O0O.O000000o();
        Context context = this.O000000o;
        StringBuilder stringBuilder = new StringBuilder("key=");
        stringBuilder.append(O00000oo);
        String O000000o2 = OO0O0O.O000000o(context, O000000o, stringBuilder.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceInfo.TAG_TIMESTAMPS, O000000o);
        hashMap.put("key", O00000oo);
        hashMap.put("scode", O000000o2);
        return hashMap;
    }

    public final byte[] O00000o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(O0000o00());
            byteArrayOutputStream.write(O0000o0());
            byteArrayOutputStream.write(O0000o0O());
            byteArrayOutputStream.write(O0000o0o());
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Throwable th) {
                O0000Oo.O000000o(th, "bre", "geb");
                return toByteArray;
            }
        } catch (Throwable th2) {
            O0000Oo.O000000o(th2, "bre", "geb");
        }
        return null;
    }

    public boolean O00000oO() {
        return true;
    }

    public String O00000oo() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.O00000Oo.O00000o0(), this.O00000Oo.O000000o()});
    }

    /* Access modifiers changed, original: protected */
    public String O0000O0o() {
        return "2.1";
    }

    public abstract byte[] O0000OOo();

    /* Access modifiers changed, original: protected */
    public boolean O0000Oo() {
        return false;
    }

    public abstract byte[] O0000Oo0();
}
