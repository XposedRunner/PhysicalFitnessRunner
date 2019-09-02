package com.amap.api.mapcore.util;

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
public class b extends i {
    private Context O000000o;
    private String O00000Oo;
    private oO00000o O00000oO;
    private Object[] O00000oo;

    public b(Context context, i iVar, oO00000o oo00000o, String str, Object... objArr) {
        super(iVar);
        this.O000000o = context;
        this.O00000Oo = str;
        this.O00000oO = oo00000o;
        this.O00000oo = objArr;
    }

    private String O000000o(Context context) {
        String str = "";
        try {
            return String.format(o0OOOO00.O00000o0(this.O00000Oo), this.O00000oo);
        } catch (Throwable th) {
            th.printStackTrace();
            ooOOOOoo.O00000o0(th, "ofm", "gpj");
            return str;
        }
    }

    private String O00000Oo(Context context) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return o0OOOO00.O000000o(this.O00000oO.O00000Oo(o0OOOO00.O000000o(O000000o(context))));
    }

    /* Access modifiers changed, original: protected */
    public byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String O000000o = o0OOOO00.O000000o(bArr);
        if (TextUtils.isEmpty(O000000o)) {
            return null;
        }
        String O00000Oo = O00000Oo(this.O000000o);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"pinfo\":\"");
        stringBuilder.append(O00000Oo);
        stringBuilder.append("\",\"els\":[");
        stringBuilder.append(O000000o);
        stringBuilder.append("]}");
        return o0OOOO00.O000000o(stringBuilder.toString());
    }
}
