package com.amap.api.mapcore.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy */
public abstract class i {
    byte[] O00000o = null;
    i O00000o0;

    i() {
    }

    i(i iVar) {
        this.O00000o0 = iVar;
    }

    public byte[] O000000o() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] O000000o = O000000o(this.O00000o);
        if (this.O00000o0 == null) {
            return O000000o;
        }
        this.O00000o0.O00000o0(O000000o);
        return this.O00000o0.O000000o();
    }

    public abstract byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void O00000Oo(byte[] bArr) {
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o0(byte[] bArr) {
        this.O00000o = bArr;
    }
}
