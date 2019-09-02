package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.io.RandomAccessFile;
import s.h.e.l.l.C;

/* compiled from: DexDownLoad */
public class oOo00OO0 implements com.amap.api.mapcore.util.oOO0O000.O000000o {
    protected oO00OO0O O000000o;
    protected o0OO0o00 O00000Oo;
    protected RandomAccessFile O00000o;
    protected String O00000o0;
    protected Context O00000oO;
    private oOO0O000 O00000oo;

    /* compiled from: DexDownLoad */
    class O000000o implements Runnable {
        private int O00000Oo;
        private String O00000o;
        private oO0O0o0o O00000o0;

        O000000o(int i) {
            this.O00000Oo = i;
        }

        O000000o(oO0O0o0o oo0o0o0o, int i) {
            this.O00000Oo = i;
            this.O00000o0 = oo0o0o0o;
        }

        public void run() {
            switch (this.O00000Oo) {
                case 0:
                    try {
                        if (oOo00OO0.this.O00000Oo()) {
                            oOOO0o00 oooo0o00 = new oOOO0o00(oOo00OO0.this.O00000oO, oOo00OO0.this.O00000Oo.O000000o(), oOo00OO0.this.O00000Oo.O00000Oo(), "O008");
                            oooo0o00.O000000o("{\"param_int_first\":0}");
                            oOOOOO0O.O000000o(oooo0o00, oOo00OO0.this.O00000oO);
                            oOo00OO0.this.O00000oo.O000000o(oOo00OO0.this);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        oOo00ooO.O000000o(th, "dDownLoad", "run()");
                        return;
                    }
                case 1:
                case 2:
                    try {
                        oO00OOOo.O000000o(oOo00OO0.this.O00000oO, this.O00000o0, oOo00OO0.this.O00000Oo, oOo00OO0.this.O00000o0, oOo00OO0.this.O000000o.O00000oO);
                        oO00OOOo.O000000o(oOo00OO0.this.O00000oO, oOo00OO0.this.O00000Oo);
                        return;
                    } catch (Throwable th2) {
                        oOo00ooO.O000000o(th2, "dDownLoad", "onFinish2");
                        return;
                    }
                case 3:
                    try {
                        oO00OOOo.O000000o(oOo00OO0.this.O00000oO, this.O00000o0, oOo00OO0.this.O00000Oo, oOo00OO0.this.O00000o0, this.O00000o);
                        oO00OOOo.O000000o(oOo00OO0.this.O00000oO, oOo00OO0.this.O00000Oo);
                        return;
                    } catch (Throwable th22) {
                        oOo00ooO.O000000o(th22, "dDownLoad", "processDownloadedFile()");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    static {
        C.i(6);
    }

    public oOo00OO0(Context context, oO00OO0O oo00oo0o, o0OO0o00 o0oo0o00) {
        try {
            this.O00000oO = context.getApplicationContext();
            this.O00000Oo = o0oo0o00;
            if (oo00oo0o != null) {
                this.O000000o = oo00oo0o;
                this.O00000oo = new oOO0O000(new oOo0000O(this.O000000o));
                this.O00000o0 = oO00OOOo.O000000o(context, this.O000000o.O00000Oo);
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "DexDownLoad()");
        }
    }

    private void O000000o(Context context, String str) {
        try {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.commit();
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "clearMarker()");
        }
    }

    private void O000000o(String str) {
        String O00000o0 = this.O000000o.O00000o0();
        oO0O0o0o oo0o0o0o = new oO0O0o0o(this.O00000oO, oO00Oo00.O000000o());
        com.amap.api.mapcore.util.oO00OOOo.O000000o.O000000o(oo0o0o0o, new com.amap.api.mapcore.util.oOOoOOO0.O000000o(this.O000000o.O00000Oo, str, this.O000000o.O00000o0, O00000o0, this.O000000o.O00000oO).O000000o("copy").O000000o(), oOOoOOO0.O000000o(this.O000000o.O00000Oo, this.O000000o.O00000o0, O00000o0, this.O000000o.O00000oO));
        O000000o(this.O00000oO, this.O000000o.O00000o0);
        try {
            oO0OO000.O00000Oo().O000000o().submit(new O000000o(oo0o0o0o, 2));
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "onFinish1");
        }
    }

    public void O000000o() {
        try {
            oO0OO000.O00000Oo().O000000o().submit(new O000000o(0));
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "startDownload()");
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000Oo() {
        boolean z = this.O000000o != null && this.O000000o.O00000o();
        try {
            if (!oOo00ooO.O000000o(this.O00000Oo, this.O000000o) || !oOo00ooO.O000000o(this.O000000o) || !oOo00ooO.O000000o(this.O00000oO, z) || oOo00ooO.O000000o(this.O00000oO, this.O000000o, this.O00000Oo) || !oOo00ooO.O000000o(this.O00000oO, this.O00000Oo, this.O000000o)) {
                return false;
            }
            oO00OOOo.O00000Oo(this.O00000oO, this.O00000Oo.O000000o());
            return true;
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    public void onDownload(byte[] bArr, long j) {
        try {
            if (this.O00000o == null) {
                File file = new File(this.O00000o0);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.O00000o = new RandomAccessFile(file, "rw");
            }
            this.O00000o.seek(j);
            this.O00000o.write(bArr);
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "onDownload()");
        }
    }

    public void onException(Throwable th) {
        try {
            oOo00ooO.O000000o(this.O00000o);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void onFinish() {
        try {
            if (this.O00000o != null) {
                oOo00ooO.O000000o(this.O00000o);
                String O00000Oo = this.O000000o.O00000Oo();
                if (oOo00ooO.O00000Oo(this.O00000o0, O00000Oo)) {
                    O000000o(O00000Oo);
                    oOOO0o00 oooo0o00 = new oOOO0o00(this.O00000oO, this.O00000Oo.O000000o(), this.O00000Oo.O00000Oo(), "O008");
                    oooo0o00.O000000o("{\"param_int_first\":1}");
                    oOOOOO0O.O000000o(oooo0o00, this.O00000oO);
                } else {
                    new File(this.O00000o0).delete();
                }
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "onFinish()");
        }
    }

    public native void onStop();
}
