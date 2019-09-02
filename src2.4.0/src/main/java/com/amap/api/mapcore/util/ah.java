package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* compiled from: AuthTaskDownload */
public class ah implements com.amap.api.mapcore.util.oOO0O000.O000000o {
    O000000o O000000o;
    private final Context O00000Oo;
    private ooooO0O0 O00000o;
    private RandomAccessFile O00000o0;
    private String O00000oO;

    /* compiled from: AuthTaskDownload */
    static class O000000o {
        protected String O000000o;
        protected String O00000Oo;
        protected String O00000o;
        protected String O00000o0;
        protected O00000o0 O00000oO;

        public O000000o(String str, String str2, String str3) {
            this.O000000o = str;
            this.O00000Oo = str2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append(".tmp");
            this.O00000o0 = stringBuilder.toString();
            this.O00000o = str3;
        }

        public String O000000o() {
            return this.O000000o;
        }

        public void O000000o(O00000o0 o00000o0) {
            this.O00000oO = o00000o0;
        }

        public String O00000Oo() {
            return this.O00000Oo;
        }

        public String O00000o() {
            return this.O00000o;
        }

        public String O00000o0() {
            return this.O00000o0;
        }

        public O00000o0 O00000oO() {
            return this.O00000oO;
        }
    }

    /* compiled from: AuthTaskDownload */
    static class O00000Oo extends OO0OOo0 {
        private final O000000o O000000o;

        O00000Oo(O000000o o000000o) {
            this.O000000o = o000000o;
        }

        public Map<String, String> getParams() {
            return null;
        }

        public Map<String, String> getRequestHead() {
            return null;
        }

        public String getURL() {
            return this.O000000o != null ? this.O000000o.O000000o() : null;
        }
    }

    /* compiled from: AuthTaskDownload */
    static class O00000o0 {
        protected String O000000o;
        protected String O00000Oo;

        public O00000o0(String str, String str2) {
            this.O000000o = str;
            this.O00000Oo = str2;
        }

        public String O000000o() {
            return this.O000000o;
        }

        public String O00000Oo() {
            return this.O00000Oo;
        }

        public boolean O00000o0() {
            return (TextUtils.isEmpty(this.O000000o) || TextUtils.isEmpty(this.O00000Oo)) ? false : true;
        }
    }

    /* compiled from: AuthTaskDownload */
    static class O00000o extends O000000o {
        public O00000o(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        public void O000000o(String str, String str2) {
            O000000o(new O00000o0(str, str2));
        }
    }

    public ah(Context context, O000000o o000000o, o0OO0o00 o0oo0o00) {
        this.O00000Oo = context.getApplicationContext();
        if (o000000o != null) {
            this.O000000o = o000000o;
            this.O00000o = new ooooO0O0(new O00000Oo(o000000o));
            this.O00000oO = o000000o.O00000o0();
        }
    }

    private boolean O00000Oo() {
        O00000o0 O00000oO = this.O000000o.O00000oO();
        return (O00000oO != null && O00000oO.O00000o0() && OOOO00O.O000000o(this.O00000Oo, O00000oO.O000000o(), O00000oO.O00000Oo(), "").equalsIgnoreCase(this.O000000o.O00000Oo())) ? false : true;
    }

    public void O000000o() {
        try {
            if (O00000Oo() && this.O00000o != null) {
                this.O00000o.O000000o(this);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AuthTaskDownload", "startDownload()");
        }
    }

    public void onDownload(byte[] bArr, long j) {
        try {
            if (this.O00000o0 == null) {
                File file = new File(this.O00000oO);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.O00000o0 = new RandomAccessFile(file, "rw");
            }
            this.O00000o0.seek(j);
            this.O00000o0.write(bArr);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AuthTaskDownload", "onDownload()");
        }
    }

    public void onException(Throwable th) {
        try {
            if (this.O00000o0 != null) {
                this.O00000o0.close();
            }
        } catch (Throwable th2) {
            ooOOOOoo.O00000o0(th2, "AuthTaskDownload", "onException()");
        }
    }

    public void onFinish() {
        try {
            if (this.O00000o0 != null) {
                this.O00000o0.close();
                String O00000Oo = this.O000000o.O00000Oo();
                Object O000000o = o0OO00o0.O000000o(this.O00000oO);
                if (O000000o == null || !O00000Oo.equalsIgnoreCase(O000000o)) {
                    try {
                        new File(this.O00000oO).delete();
                    } catch (Throwable th) {
                        ooOOOOoo.O00000o0(th, "AuthTaskDownload", "onFinish");
                    }
                }
                O00000Oo = this.O000000o.O00000o();
                try {
                    O00OoOO0 o00OoOO0 = new O00OoOO0();
                    File file = new File(this.O00000oO);
                    o00OoOO0.O000000o(file, new File(O00000Oo), -1, O00o.O000000o(file), null);
                    O00000o0 O00000oO = this.O000000o.O00000oO();
                    if (O00000oO != null && O00000oO.O00000o0()) {
                        OOOO00O.O000000o(this.O00000Oo, O00000oO.O000000o(), O00000oO.O00000Oo(), O000000o);
                    }
                    new File(this.O00000oO).delete();
                } catch (Throwable th2) {
                    ooOOOOoo.O00000o0(th2, "AuthTaskDownload", "onFinish1");
                }
            }
        } catch (Throwable th22) {
            ooOOOOoo.O00000o0(th22, "AuthTaskDownload", "onFinish()");
        }
    }

    public void onStop() {
    }
}
