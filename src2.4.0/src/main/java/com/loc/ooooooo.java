package com.loc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsPubDataStrategy */
public final class ooooooo extends O0O00oO {
    public ooooooo(O0O00oO o0O00oO) {
        super(o0O00oO);
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] O000000o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] O000000o = OO0o000.O000000o(stringBuffer.toString());
        byte[] bArr2 = new byte[(O000000o.length + bArr.length)];
        System.arraycopy(O000000o, 0, bArr2, 0, O000000o.length);
        System.arraycopy(bArr, 0, bArr2, O000000o.length, bArr.length);
        return bArr2;
    }
}
