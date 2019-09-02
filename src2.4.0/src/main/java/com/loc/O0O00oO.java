package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy */
public abstract class O0O00oO {
    byte[] O00000o = null;
    O0O00oO O00000o0;

    O0O00oO() {
    }

    O0O00oO(O0O00oO o0O00oO) {
        this.O00000o0 = o0O00oO;
    }

    public final byte[] O000000o() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        O0O00oO o0O00oO = this;
        while (true) {
            byte[] O000000o = o0O00oO.O000000o(o0O00oO.O00000o);
            if (o0O00oO.O00000o0 == null) {
                return O000000o;
            }
            o0O00oO.O00000o0.O00000o = O000000o;
            o0O00oO = o0O00oO.O00000o0;
        }
    }

    public abstract byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void O00000Oo(byte[] bArr) {
    }
}
