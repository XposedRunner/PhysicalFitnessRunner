package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: HeaderAddStrategy */
public final class O00o0 extends O0O00oO {
    private Context O000000o;
    private String O00000Oo;
    private O00000Oo O00000oO;
    private Object[] O00000oo;

    public O00o0(Context context, O0O00oO o0O00oO, O00000Oo o00000Oo, String str, Object... objArr) {
        super(o0O00oO);
        this.O000000o = context;
        this.O00000Oo = str;
        this.O00000oO = o00000Oo;
        this.O00000oo = objArr;
    }

    private String O00000Oo() {
        String str = "";
        try {
            return String.format(OO0o000.O00000o0(this.O00000Oo), this.O00000oo);
        } catch (Throwable th) {
            th.printStackTrace();
            O0000o.O00000Oo(th, "ofm", "gpj");
            return str;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String O000000o = OO0o000.O000000o(bArr);
        if (TextUtils.isEmpty(O000000o)) {
            return null;
        }
        Context context = this.O000000o;
        String O000000o2 = OO0o000.O000000o(this.O00000oO.O000000o(OO0o000.O000000o(O00000Oo())));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"pinfo\":\"");
        stringBuilder.append(O000000o2);
        stringBuilder.append("\",\"els\":[");
        stringBuilder.append(O000000o);
        stringBuilder.append("]}");
        return OO0o000.O000000o(stringBuilder.toString());
    }
}
