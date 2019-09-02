package com.loc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: EncryptProcessor */
public abstract class O00000Oo {
    O00000Oo O000000o;

    O00000Oo() {
    }

    O00000Oo(O00000Oo o00000Oo) {
        this.O000000o = o00000Oo;
    }

    public final byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        if (this.O000000o != null) {
            bArr = this.O000000o.O000000o(bArr);
        }
        return O00000Oo(bArr);
    }

    public abstract byte[] O00000Oo(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;
}
