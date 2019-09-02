package com.loc;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy */
public final class O00o extends O0O00oO {
    public static int O000000o = 13;
    public static int O00000Oo = 6;
    private Context O00000oO;

    public O00o(Context context, O0O00oO o0O00oO) {
        super(o0O00oO);
        this.O00000oO = context;
    }

    private static byte[] O000000o(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            StringBuilder stringBuilder = new StringBuilder("1.2.");
            stringBuilder.append(O000000o);
            stringBuilder.append(".");
            stringBuilder.append(O00000Oo);
            OO0o000.O000000o(byteArrayOutputStream, stringBuilder.toString());
            OO0o000.O000000o(byteArrayOutputStream, "Android");
            OO0o000.O000000o(byteArrayOutputStream, OO0O0o0.O0000oo0(context));
            OO0o000.O000000o(byteArrayOutputStream, OO0O0o0.O0000o00(context));
            OO0o000.O000000o(byteArrayOutputStream, OO0O0o0.O0000OOo(context));
            OO0o000.O000000o(byteArrayOutputStream, Build.MANUFACTURER);
            OO0o000.O000000o(byteArrayOutputStream, Build.MODEL);
            OO0o000.O000000o(byteArrayOutputStream, Build.DEVICE);
            OO0o000.O000000o(byteArrayOutputStream, OO0O0o0.O0000ooO(context));
            OO0o000.O000000o(byteArrayOutputStream, OO00o00.O00000o0(context));
            OO0o000.O000000o(byteArrayOutputStream, OO00o00.O00000o(context));
            OO0o000.O000000o(byteArrayOutputStream, OO00o00.O00000oo(context));
            byteArrayOutputStream.write(new byte[]{(byte) 0});
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Throwable th) {
                th.printStackTrace();
                return toByteArray;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return bArr;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] O000000o(byte[] bArr) {
        byte[] O000000o = O000000o(this.O00000oO);
        byte[] bArr2 = new byte[(O000000o.length + bArr.length)];
        System.arraycopy(O000000o, 0, bArr2, 0, O000000o.length);
        System.arraycopy(bArr, 0, bArr2, O000000o.length, bArr.length);
        return bArr2;
    }
}
