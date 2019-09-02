package com.amap.api.mapcore.util;

/* compiled from: DownloadManager */
public class oOO0O000 {
    private oOO0O00O O000000o;
    private oOO0OO0O O00000Oo;

    /* compiled from: DownloadManager */
    public interface O000000o {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public oOO0O000(oOO0OO0O ooo0oo0o) {
        this(ooo0oo0o, 0, -1);
    }

    public oOO0O000(oOO0OO0O ooo0oo0o, long j, long j2) {
        this(ooo0oo0o, j, j2, false);
    }

    public oOO0O000(oOO0OO0O ooo0oo0o, long j, long j2, boolean z) {
        this.O00000Oo = ooo0oo0o;
        this.O000000o = new oOO0O00O(this.O00000Oo.a, this.O00000Oo.b, ooo0oo0o.c == null ? null : ooo0oo0o.c, z);
        this.O000000o.O00000Oo(j2);
        this.O000000o.O000000o(j);
    }

    public void O000000o() {
        this.O000000o.O000000o();
    }

    public void O000000o(O000000o o000000o) {
        this.O000000o.O000000o(this.O00000Oo.getURL(), this.O00000Oo.isIPRequest(), this.O00000Oo.getIPDNSName(), this.O00000Oo.getRequestHead(), this.O00000Oo.getParams(), this.O00000Oo.getEntityBytes(), o000000o);
    }
}
