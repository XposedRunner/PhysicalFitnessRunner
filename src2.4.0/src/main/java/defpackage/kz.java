package defpackage;

import android.os.Environment;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Log */
/* renamed from: kz */
public class kz implements kx {
    private static kz O0000o = null;
    private static boolean O0000o0 = false;
    private static final String O0000o00 = "kz";
    private static boolean O0000o0O = false;
    private static SimpleDateFormat O0000o0o = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.ENGLISH);
    private static FileWriter O0000oO = null;
    private static final int O0000oO0 = 1024;
    private static BufferedWriter O0000oOO;
    private static ExecutorService O0000oOo;

    /* compiled from: Log */
    /* renamed from: kz$1 */
    static class 1 implements Runnable {
        final /* synthetic */ String O000000o;

        1(String str) {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:2:0x0001
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
            */
        public void run() {
            /*
            r2 = this;
            return;	 Catch:{ Exception -> 0x0011 }
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.kz$1.run():void");
        }
    }

    public static File O000000o(String str) {
        boolean equals = "mounted".equals(Environment.getExternalStorageState());
        File externalCacheDir = MyApplication.O000000o().getExternalCacheDir();
        String path = (!equals || externalCacheDir == null) ? MyApplication.O000000o().getCacheDir().getPath() : externalCacheDir.getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path);
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        externalCacheDir = new File(stringBuilder.toString());
        if (!externalCacheDir.mkdirs()) {
            path = O0000o00;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("文件夹 已创建");
            kz.O00000o0(path, stringBuilder.toString());
        }
        return externalCacheDir;
    }

    public static kz O000000o() {
        if (O0000o == null) {
            synchronized (kz.class) {
                if (O0000o == null) {
                    O0000o = new kz();
                }
            }
        }
        return O0000o;
    }

    private static void O000000o(int i, String str, String str2) {
        if (O0000o0) {
            String[] O0000O0o = kz.O0000O0o(str, str2);
            str2 = O0000O0o[0];
            String str3 = O0000O0o[1];
            str = O0000O0o[2];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str3);
                    kw.O000000o(i, str2, stringBuilder.toString());
                    break;
                case 7:
                    ky.O000000o(str2, str3, str);
                    break;
            }
        }
    }

    public static void O000000o(String str, String str2) {
        kz.O000000o(2, str, str2);
        if (O0000o0O) {
            kz.O000000o(str, str2, 'd');
        }
    }

    private static void O000000o(String str, String str2, char c) {
        String format = O0000o0o.format(new Date());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("  ");
        stringBuilder.append(c);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        stringBuilder.append("  ");
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        str = stringBuilder.toString();
        if (O0000oOo != null) {
            O0000oOo.execute(new 1(str));
        }
    }

    public static void O00000Oo(String str, String str2) {
        kz.O000000o(1, str, str2);
        if (O0000o0O) {
            kz.O000000o(str, str2, 'v');
        }
    }

    public static void O00000o(String str, String str2) {
        kz.O000000o(4, str, str2);
        if (O0000o0O) {
            kz.O000000o(str, str2, 'w');
        }
    }

    public static void O00000o0(String str, String str2) {
        kz.O000000o(3, str, str2);
        if (O0000o0O) {
            kz.O000000o(str, str2, 'i');
        }
    }

    public static void O00000oO(String str, String str2) {
        kz.O000000o(5, str, str2);
        if (O0000o0O) {
            kz.O000000o(str, str2, 'e');
        }
    }

    public static void O00000oo(String str, String str2) {
        kz.O000000o(7, str, str2);
        if (O0000o0O) {
            kz.O000000o(str, str2, 'e');
        }
    }

    private static String[] O0000O0o(String str, String str2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String fileName = stackTrace[5].getFileName();
        String methodName = stackTrace[5].getMethodName();
        int lineNumber = stackTrace[5].getLineNumber();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(methodName.substring(0, 1).toUpperCase());
        stringBuilder.append(methodName.substring(1));
        String stringBuilder2 = stringBuilder.toString();
        if (str == null) {
            str = fileName;
        }
        if (str2 == null) {
            str2 = kx.O00000o0;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("[ (");
        stringBuilder3.append(fileName);
        stringBuilder3.append(":");
        stringBuilder3.append(lineNumber);
        stringBuilder3.append(")#");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" ] ");
        String stringBuilder4 = stringBuilder3.toString();
        return new String[]{str, str2, stringBuilder4};
    }

    public void O000000o(boolean z) {
        O0000o0 = z;
    }

    public void O00000Oo() {
        String O00000oo = O00000oo();
        O0000oOo = Executors.newSingleThreadExecutor();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(O000O0o0.O0000Ooo, Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000oo);
        stringBuilder.append(File.separator);
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append("Log.txt");
        try {
            O0000oO = new FileWriter(new File(stringBuilder.toString()), true);
            O0000oOO = new BufferedWriter(O0000oO, 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O00000Oo(boolean z) {
        O0000o0O = z;
    }

    public void O00000o() {
        try {
            O0000oOO.flush();
            O0000oOO.close();
            O0000oO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O00000o0() {
        try {
            O0000oOO.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String O00000oO() {
        String[] list = new File(O00000oo()).list();
        Date date = new Date();
        String str = "";
        long j = -1;
        for (String str2 : list) {
            Date parse;
            kz.O000000o("LogFile", str2);
            try {
                parse = new SimpleDateFormat(O000O0o0.O0000Ooo, Locale.ENGLISH).parse(str2.substring(0, 10));
            } catch (Exception unused) {
                parse = null;
            }
            if (parse != null) {
                long time = date.getTime() - parse.getTime();
                if (j == -1 || time <= j) {
                    str = str2;
                    j = time;
                }
            }
        }
        return str;
    }

    public String O00000oo() {
        return kz.O000000o("Log").getAbsolutePath();
    }
}
