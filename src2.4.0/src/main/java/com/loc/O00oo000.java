package com.loc;

/* compiled from: LogJsonDataStrategy */
public final class O00oo000 extends O0O00oO {
    private StringBuilder O000000o = new StringBuilder();
    private boolean O00000Oo = true;

    public O00oo000(O0O00oO o0O00oO) {
        super(o0O00oO);
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] O000000o(byte[] bArr) {
        bArr = OO0o000.O000000o(this.O000000o.toString());
        this.O00000o = bArr;
        this.O00000Oo = true;
        this.O000000o.delete(0, this.O000000o.length());
        return bArr;
    }

    public final void O00000Oo(byte[] bArr) {
        String O000000o = OO0o000.O000000o(bArr);
        if (this.O00000Oo) {
            this.O00000Oo = false;
        } else {
            this.O000000o.append(",");
        }
        StringBuilder stringBuilder = this.O000000o;
        stringBuilder.append("{\"log\":\"");
        stringBuilder.append(O000000o);
        stringBuilder.append("\"}");
    }
}
