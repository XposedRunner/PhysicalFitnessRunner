package com.geetest.sdk;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: GT3LogUtils */
public final class O0OOO00 {
    private static O000000o O000000o;

    /* compiled from: GT3LogUtils */
    private static class O000000o {
        private HandlerThread O000000o;
        private Handler O00000Oo;
        private SimpleDateFormat O00000o0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        /* compiled from: GT3LogUtils */
        private static class O000000o {
            public long O000000o;
            public String O00000Oo;
            public String O00000o0;

            private O000000o() {
            }

            /* synthetic */ O000000o(byte b) {
                this();
            }
        }

        private static String O00000o() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            stringBuilder.append(File.separator);
            stringBuilder.append("Geetest");
            return stringBuilder.toString();
        }

        static /* synthetic */ boolean O00000o0() {
            File file = new File(O00000o());
            if (!file.exists()) {
                return false;
            }
            File file2 = new File(file, "sensebot_log.txt");
            return (file2.exists() && file2.length() >= 10485760) ? file2.delete() : false;
        }

        public final synchronized void O000000o() {
            this.O000000o = new HandlerThread("Geetest Thread");
            this.O000000o.start();
            this.O00000Oo = new O0OOO0(this, this.O000000o.getLooper());
        }

        public final synchronized void O000000o(String str, String str2) {
            if (OO0oO.O000000o()) {
                Message obtainMessage = this.O00000Oo.obtainMessage();
                obtainMessage.what = 0;
                O000000o o000000o = new O000000o();
                o000000o.O000000o = System.currentTimeMillis();
                o000000o.O00000Oo = str;
                o000000o.O00000o0 = str2;
                obtainMessage.obj = o000000o;
                this.O00000Oo.sendMessage(obtainMessage);
            }
        }

        public final synchronized void O00000Oo() {
            if (OO0oO.O000000o()) {
                Message obtainMessage = this.O00000Oo.obtainMessage();
                obtainMessage.what = 1;
                this.O00000Oo.sendMessage(obtainMessage);
            }
        }
    }

    public static void O000000o() {
    }

    public static void O000000o(String str) {
        Log.i("Geetest", str);
        String str2 = "Geetest";
        if (O000000o == null) {
            O000000o o000000o = new O000000o();
            O000000o = o000000o;
            o000000o.O000000o();
            O000000o.O00000Oo();
        }
        O000000o.O000000o(str2, str);
    }

    public static void O00000Oo() {
    }
}
