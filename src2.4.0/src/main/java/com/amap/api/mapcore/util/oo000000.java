package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy */
public class oo000000 extends i {
    ByteArrayOutputStream O000000o = new ByteArrayOutputStream();

    public oo000000(i iVar) {
        super(iVar);
    }

    /* Access modifiers changed, original: protected */
    public byte[] O000000o(byte[] bArr) {
        bArr = this.O000000o.toByteArray();
        try {
            this.O000000o.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.O000000o = new ByteArrayOutputStream();
        return bArr;
    }

    public void O00000Oo(byte[] bArr) {
        try {
            this.O000000o.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
