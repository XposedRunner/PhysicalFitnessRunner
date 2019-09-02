package com.geetest.deepknow.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bangcle.andJni.JniLib1557756502;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogUtils */
public class i {
    public static int a = 1;
    public static String b = "Geetest_DeepKnow";
    private static a c;

    /* compiled from: LogUtils */
    private static class a {
        private HandlerThread a;
        private Handler b;
        private SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        /* compiled from: LogUtils */
        /* renamed from: com.geetest.deepknow.utils.i$a$1 */
        class AnonymousClass1 extends Handler {
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                JniLib1557756502.cV(this, message, Integer.valueOf(89));
            }
        }

        /* compiled from: LogUtils */
        private static class a {
            public long a;
            public String b;
            public String c;

            private a() {
            }
        }

        private void a(String str) {
            JniLib1557756502.cV(this, str, Integer.valueOf(93));
        }

        private static String b(SimpleDateFormat simpleDateFormat, long j, String str, String str2) {
            return (String) JniLib1557756502.cL(simpleDateFormat, Long.valueOf(j), str, str2, Integer.valueOf(94));
        }

        private static String d() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.b());
            stringBuilder.append(File.separator);
            stringBuilder.append("geetest");
            return stringBuilder.toString();
        }

        private static boolean e() {
            return JniLib1557756502.cZ(Integer.valueOf(95));
        }

        public synchronized void a() {
            JniLib1557756502.cV(this, Integer.valueOf(90));
        }

        public synchronized void a(String str, String str2) {
            JniLib1557756502.cV(this, str, str2, Integer.valueOf(91));
        }

        public synchronized void b() {
            JniLib1557756502.cV(this, Integer.valueOf(92));
        }
    }

    public static void a(int i, String str) {
        JniLib1557756502.cV(Integer.valueOf(i), str, Integer.valueOf(96));
    }

    public static void a(String str) {
        JniLib1557756502.cV(str, Integer.valueOf(97));
    }

    private static void a(String str, String str2) {
        JniLib1557756502.cV(str, str2, Integer.valueOf(98));
    }

    public static void b(String str) {
        JniLib1557756502.cV(str, Integer.valueOf(99));
    }
}
