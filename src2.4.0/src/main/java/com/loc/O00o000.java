package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy */
public final class O00o000 extends O0O00oO {
    ByteArrayOutputStream O000000o = new ByteArrayOutputStream();

    public O00o000(O0O00oO o0O00oO) {
        super(o0O00oO);
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] O000000o(byte[] bArr) {
        bArr = this.O000000o.toByteArray();
        try {
            this.O000000o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.O000000o = new ByteArrayOutputStream();
        return bArr;
    }

    public final void O00000Oo(byte[] bArr) {
        try {
            this.O000000o.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
