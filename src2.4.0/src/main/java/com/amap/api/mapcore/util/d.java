package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;

/* compiled from: StatisticsHeaderDataStrategy */
public class d extends i {
    public static int O000000o = 13;
    public static int O00000Oo = 6;
    private Context O00000oO;

    public d(Context context, i iVar) {
        super(iVar);
        this.O00000oO = context;
    }

    private byte[] O000000o(Context context) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[0];
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("1.2.");
            stringBuilder.append(O000000o);
            stringBuilder.append(".");
            stringBuilder.append(O00000Oo);
            o0OOOO00.O000000o(byteArrayOutputStream, stringBuilder.toString());
            o0OOOO00.O000000o(byteArrayOutputStream, "Android");
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0o000.O0000oo0(context));
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0o000.O0000o00(context));
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0o000.O0000OOo(context));
            o0OOOO00.O000000o(byteArrayOutputStream, Build.MANUFACTURER);
            o0OOOO00.O000000o(byteArrayOutputStream, Build.MODEL);
            o0OOOO00.O000000o(byteArrayOutputStream, Build.DEVICE);
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0o000.O0000ooO(context));
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0O0Oo.O00000o0(context));
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0O0Oo.O00000o(context));
            o0OOOO00.O000000o(byteArrayOutputStream, o0O0O0Oo.O00000oo(context));
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

    /* Access modifiers changed, original: protected */
    public byte[] O000000o(byte[] bArr) {
        byte[] O000000o = O000000o(this.O00000oO);
        byte[] bArr2 = new byte[(O000000o.length + bArr.length)];
        System.arraycopy(O000000o, 0, bArr2, 0, O000000o.length);
        System.arraycopy(bArr, 0, bArr2, O000000o.length, bArr.length);
        return bArr2;
    }
}
