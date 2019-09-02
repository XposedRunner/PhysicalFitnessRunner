package com.ximalaya.ting.android.opensdk.util.dh;

import java.io.Serializable;
import java.math.BigInteger;

public class DhKeyPair implements Serializable {
    private BigInteger privateKey;
    private BigInteger publicKey;

    public BigInteger getPrivateKey() {
        return this.privateKey;
    }

    public BigInteger getPublicKey() {
        return this.publicKey;
    }

    public DhKeyPair setPrivateKey(BigInteger bigInteger) {
        this.privateKey = bigInteger;
        return this;
    }

    public DhKeyPair setPublicKey(BigInteger bigInteger) {
        this.publicKey = bigInteger;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DhKeyPair{publicKey=");
        stringBuilder.append(this.publicKey);
        stringBuilder.append(", privateKey=");
        stringBuilder.append(this.privateKey);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
