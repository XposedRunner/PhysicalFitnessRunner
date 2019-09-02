package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import s.h.e.l.l.C;

@Deprecated
/* compiled from: SDKCoordinatorDownload */
public class o0OOoOO0 extends Thread implements com.amap.api.mapcore.util.oOO0O000.O000000o {
    protected static boolean O0000O0o = false;
    private static String O0000Oo = "sofail";
    private static String O0000Oo0 = "sodownload";
    protected O000000o O000000o;
    protected RandomAccessFile O00000Oo;
    protected String O00000o;
    protected String O00000o0;
    protected String O00000oO;
    protected Context O00000oo;
    private oOO0O000 O0000OOo = new oOO0O000(this.O000000o);

    /* compiled from: SDKCoordinatorDownload */
    public static class O000000o extends oOO0OO0O {
        private String O000000o;

        O000000o(String str) {
            this.O000000o = str;
        }

        public Map<String, String> getParams() {
            return null;
        }

        public Map<String, String> getRequestHead() {
            return null;
        }

        public String getURL() {
            return this.O000000o;
        }
    }

    static {
        C.i(4);
    }

    public o0OOoOO0(Context context, String str, String str2, String str3) {
        this.O00000oo = context;
        this.O00000oO = str3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("temp.so");
        this.O00000o0 = O000000o(context, stringBuilder.toString());
        this.O00000o = O000000o(context, "libwgs2gcj.so");
        this.O000000o = new O000000o(str2);
    }

    public static native String O000000o(Context context, String str);

    public static void O000000o(Context context, Throwable th) {
        if ((th instanceof UnsatisfiedLinkError) || (th instanceof LinkageError)) {
            O0000O0o = true;
            try {
                File file = new File(O000000o(context, "libwgs2gcj.so"));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static native String O00000Oo(Context context, String str);

    public native void O000000o();

    public native void O00000Oo();

    public void onDownload(byte[] bArr, long j) {
        try {
            if (this.O00000Oo == null) {
                File file = new File(this.O00000o0);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.O00000Oo = new RandomAccessFile(file, "rw");
            }
        } catch (FileNotFoundException e) {
            ooOOOOoo.O00000o0(e, "sdl", "oDd");
            O00000Oo();
        } catch (Throwable th) {
            O00000Oo();
            ooOOOOoo.O00000o0(th, "sdl", "oDd");
        }
        if (this.O00000Oo != null) {
            try {
                this.O00000Oo.seek(j);
                this.O00000Oo.write(bArr);
            } catch (IOException e2) {
                O00000Oo();
                ooOOOOoo.O00000o0(e2, "sdl", "oDd");
            }
        }
    }

    public void onException(Throwable th) {
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
            }
            O00000Oo();
            File file = new File(O00000Oo(this.O00000oo, "tempfile"));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            }
        } catch (Throwable th2) {
            ooOOOOoo.O00000o0(th2, "sdl", "oe");
        }
    }

    public void onFinish() {
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
            }
            String O000000o = o0OO00o0.O000000o(this.O00000o0);
            if (O000000o == null || !O000000o.equalsIgnoreCase(this.O00000oO)) {
                O00000Oo();
            } else if (new File(this.O00000o).exists()) {
                O00000Oo();
            } else {
                new File(this.O00000o0).renameTo(new File(this.O00000o));
            }
        } catch (Throwable th) {
            O00000Oo();
            File file = new File(this.O00000o);
            if (file.exists()) {
                file.delete();
            }
            ooOOOOoo.O00000o0(th, "sdl", "ofs");
        }
    }

    public native void onStop();

    public void run() {
        try {
            File file = new File(O00000Oo(this.O00000oo, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.O0000OOo.O000000o(this);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "sdl", "run");
            O00000Oo();
        }
    }
}
