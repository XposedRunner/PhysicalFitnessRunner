package com.amap.api.mapcore.util;

/* compiled from: LogJsonDataStrategy */
public class c extends i {
    private StringBuilder O000000o = new StringBuilder();
    private boolean O00000Oo = true;

    public c(i iVar) {
        super(iVar);
    }

    /* Access modifiers changed, original: protected */
    public byte[] O000000o(byte[] bArr) {
        bArr = o0OOOO00.O000000o(this.O000000o.toString());
        O00000o0(bArr);
        this.O00000Oo = true;
        this.O000000o.delete(0, this.O000000o.length());
        return bArr;
    }

    public void O00000Oo(byte[] bArr) {
        String O000000o = o0OOOO00.O000000o(bArr);
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
