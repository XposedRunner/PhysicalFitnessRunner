package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

@Deprecated
/* compiled from: SDKCoordinatorDownload */
public class OO0Oo00 extends Thread implements com.loc.O00OOOo.O000000o {
    protected static boolean O0000O0o = false;
    private static String O0000Oo = "sofail";
    private static String O0000Oo0 = "sodownload";
    protected O000000o O000000o;
    protected RandomAccessFile O00000Oo;
    protected String O00000o;
    protected String O00000o0;
    protected String O00000oO;
    protected Context O00000oo;
    private O00OOOo O0000OOo = new O00OOOo(this.O000000o);

    /* compiled from: SDKCoordinatorDownload */
    public static class O000000o extends O00OOo {
        private String O000000o;

        O000000o(String str) {
            this.O000000o = str;
        }

        public final Map<String, String> O000000o() {
            return null;
        }

        public final Map<String, String> O00000Oo() {
            return null;
        }

        public final String O00000o0() {
            return this.O000000o;
        }
    }

    public OO0Oo00(Context context, String str, String str2, String str3) {
        this.O00000oo = context;
        this.O00000oO = str3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("temp.so");
        this.O00000o0 = O000000o(context, stringBuilder.toString());
        this.O00000o = O000000o(context, "libwgs2gcj.so");
        this.O000000o = new O000000o(str2);
    }

    public static String O000000o(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getFilesDir().getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append("libso");
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public void O000000o() {
        if (this.O000000o != null && !TextUtils.isEmpty(this.O000000o.O00000o0()) && this.O000000o.O00000o0().contains("libJni_wgs2gcj.so") && this.O000000o.O00000o0().contains(OO0o000.O000000o(this.O00000oo)) && !new File(this.O00000o).exists()) {
            start();
        }
    }

    public final void O000000o(byte[] bArr, long j) {
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
            O0000o.O00000Oo(e, "sdl", "oDd");
            O00000Oo();
        } catch (Throwable th) {
            O00000Oo();
            O0000o.O00000Oo(th, "sdl", "oDd");
            return;
        }
        if (this.O00000Oo != null) {
            try {
                this.O00000Oo.seek(j);
                this.O00000Oo.write(bArr);
            } catch (IOException th2) {
                O00000Oo();
                O0000o.O00000Oo(th2, "sdl", "oDd");
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void O00000Oo() {
        File file = new File(this.O00000o0);
        if (file.exists()) {
            file.delete();
        }
    }

    public void O00000o() {
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
            }
            String O000000o = OO0OOOO.O000000o(this.O00000o0);
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
            O0000o.O00000Oo(th, "sdl", "ofs");
        }
    }

    public final void O00000o0() {
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
            }
            O00000Oo();
            File file = new File(O000000o(this.O00000oo, "tempfile"));
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            }
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "sdl", "oe");
        }
    }

    public final void O00000oO() {
        O00000Oo();
    }

    public void run() {
        try {
            File file = new File(O000000o(this.O00000oo, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.O0000OOo.O000000o(this);
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "sdl", "run");
            O00000Oo();
        }
    }
}
