package com.amap.api.mapcore.util;

/* compiled from: IDownloadListener */
public interface O0O000o {

    /* compiled from: IDownloadListener */
    public enum O000000o {
        amap_exception(-1),
        network_exception(-1),
        file_io_exception(0),
        success_no_exception(1),
        cancel_no_exception(2);
        
        private int O00000oo;

        private O000000o(int i) {
            this.O00000oo = i;
        }
    }

    void O000000o(long j, long j2);

    void O000000o(O000000o o000000o);

    void O0000o0();

    void O0000o0O();

    void O0000o0o();
}
