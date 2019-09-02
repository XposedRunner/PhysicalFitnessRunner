package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import s.h.e.l.l.C;

/* compiled from: NetFileFetch */
public class O00o00 implements com.amap.api.mapcore.util.oOO0O000.O000000o {
    O00o0 O000000o = null;
    long O00000Oo = 0;
    long O00000o;
    long O00000o0 = 0;
    boolean O00000oO = true;
    O00Oo O00000oo;
    long O0000O0o = 0;
    O000000o O0000OOo;
    private O0O000o O0000Oo;
    private Context O0000Oo0;
    private String O0000OoO;
    private ooooO0O0 O0000Ooo;
    private boolean O0000o0 = false;
    private O00OoO0o O0000o00;

    /* compiled from: NetFileFetch */
    public interface O000000o {
        void O00000o0();
    }

    /* compiled from: NetFileFetch */
    private static class O00000Oo extends OO0OOo0 {
        private final String O000000o;

        public O00000Oo(String str) {
            this.O000000o = str;
        }

        public String getURL() {
            return this.O000000o;
        }
    }

    static {
        C.i(3);
    }

    public O00o00(O00o0 o00o0, String str, Context context, O0O000o o0O000o) throws IOException {
        this.O00000oo = O00Oo.O000000o(context.getApplicationContext());
        this.O000000o = o00o0;
        this.O0000Oo0 = context;
        this.O0000OoO = str;
        this.O0000Oo = o0O000o;
        O00000o();
    }

    private void O000000o(long j) {
        if (this.O00000o > 0 && this.O0000Oo != null) {
            this.O0000Oo.O000000o(this.O00000o, j);
            this.O0000O0o = System.currentTimeMillis();
        }
    }

    private void O00000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O000000o.O00000Oo());
        stringBuilder.append(this.O000000o.O00000o0());
        File file = new File(stringBuilder.toString());
        if (file.exists()) {
            this.O00000oO = false;
            this.O00000Oo = file.length();
            try {
                this.O00000o = O0000O0o();
                this.O00000o0 = this.O00000o;
                return;
            } catch (IOException unused) {
                if (this.O0000Oo != null) {
                    this.O0000Oo.O000000o(com.amap.api.mapcore.util.O0O000o.O000000o.file_io_exception);
                    return;
                }
                return;
            }
        }
        this.O00000Oo = 0;
        this.O00000o0 = 0;
    }

    private void O00000o0() throws IOException {
        O0O00o0 o0O00o0 = new O0O00o0(this.O0000OoO);
        o0O00o0.setConnectionTimeout(1800000);
        o0O00o0.setSoTimeout(1800000);
        this.O0000Ooo = new ooooO0O0(o0O00o0, this.O00000Oo, this.O00000o0, MapsInitializer.getProtocol() == 2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O000000o.O00000Oo());
        stringBuilder.append(File.separator);
        stringBuilder.append(this.O000000o.O00000o0());
        this.O0000o00 = new O00OoO0o(stringBuilder.toString(), this.O00000Oo);
    }

    private boolean O00000oO() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O000000o.O00000Oo());
        stringBuilder.append(File.separator);
        stringBuilder.append(this.O000000o.O00000o0());
        return new File(stringBuilder.toString()).length() >= 10;
    }

    private void O00000oo() throws AMapException {
        if (o0O0OOO0.O000000o != 1) {
            int i = 0;
            while (i < 3) {
                try {
                    if (!o0O0OOO0.O000000o(this.O0000Oo0, OOo000.O00000oO())) {
                        i++;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
            }
        }
    }

    private long O0000O0o() throws IOException {
        Map O00000Oo;
        try {
            O00000Oo = oOO0O0O0.O00000Oo().O00000Oo(new O00000Oo(this.O000000o.O000000o()), MapsInitializer.getProtocol() == 2);
        } catch (o0O0oo0o e) {
            e.printStackTrace();
            O00000Oo = null;
        }
        String str = "Content-Length";
        int i = -1;
        if (O00000Oo != null) {
            for (String str2 : O00000Oo.keySet()) {
                if (str.equalsIgnoreCase(str2)) {
                    i = Integer.parseInt((String) O00000Oo.get(str2));
                }
            }
        }
        return (long) i;
    }

    private void O0000OOo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.O000000o != null && currentTimeMillis - this.O0000O0o > ((long) 500)) {
            O0000Oo0();
            this.O0000O0o = currentTimeMillis;
            O000000o(this.O00000Oo);
        }
    }

    private void O0000Oo0() {
        this.O00000oo.O000000o(this.O000000o.O00000oO(), this.O000000o.O00000o(), this.O00000o, this.O00000Oo, this.O00000o0);
    }

    public void O000000o() {
        try {
            if (OOo000.O00000o(this.O0000Oo0)) {
                O00000oo();
                if (o0O0OOO0.O000000o != 1) {
                    if (this.O0000Oo != null) {
                        this.O0000Oo.O000000o(com.amap.api.mapcore.util.O0O000o.O000000o.amap_exception);
                    }
                    return;
                }
                if (!O00000oO()) {
                    this.O00000oO = true;
                }
                if (this.O00000oO) {
                    this.O00000o = O0000O0o();
                    if (this.O00000o == -1) {
                        O00o.O000000o("File Length is not known!");
                    } else if (this.O00000o == ((long) -2)) {
                        O00o.O000000o("File is not access!");
                    } else {
                        this.O00000o0 = this.O00000o;
                    }
                    this.O00000Oo = 0;
                }
                if (this.O0000Oo != null) {
                    this.O0000Oo.O0000o0();
                }
                if (this.O00000Oo >= this.O00000o0) {
                    onFinish();
                } else {
                    O00000o0();
                    this.O0000Ooo.O000000o(this);
                }
                return;
            }
            if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(com.amap.api.mapcore.util.O0O000o.O000000o.network_exception);
            }
        } catch (AMapException e) {
            ooOOOOoo.O00000o0(e, "SiteFileFetch", "download");
            if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(com.amap.api.mapcore.util.O0O000o.O000000o.amap_exception);
            }
        } catch (IOException unused) {
            if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(com.amap.api.mapcore.util.O0O000o.O000000o.file_io_exception);
            }
        }
    }

    public void O000000o(O000000o o000000o) {
        this.O0000OOo = o000000o;
    }

    public native void O00000Oo();

    public void onDownload(byte[] bArr, long j) {
        try {
            this.O0000o00.O000000o(bArr);
            this.O00000Oo = j;
            O0000OOo();
        } catch (IOException e) {
            e.printStackTrace();
            ooOOOOoo.O00000o0(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            if (this.O0000Oo != null) {
                this.O0000Oo.O000000o(com.amap.api.mapcore.util.O0O000o.O000000o.file_io_exception);
            }
            if (this.O0000Ooo != null) {
                this.O0000Ooo.O000000o();
            }
        }
    }

    public native void onException(Throwable th);

    public native void onFinish();

    public native void onStop();
}
