package com.taobao.wireless.security.adapter.datacollection;

import android.annotation.TargetApi;
import android.app.UiModeManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class c {
    private static Context a;
    private static String b;
    private static String c;
    private static String d;
    private static long e;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.c.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 9 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.datacollection.c.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.c.<clinit>():void");
    }

    public static String a() {
        Context context = a;
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            int i = displayMetrics2.widthPixels;
            int i2 = displayMetrics2.heightPixels;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(Math.min(i, i2)));
            stringBuilder.append("*");
            stringBuilder.append(String.valueOf(Math.max(i, i2)));
            return stringBuilder.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    private static String a(File file) {
        String str = null;
        if (file == null) {
            return null;
        }
        StatFs statFs = new StatFs(file.getPath());
        if (VERSION.SDK_INT >= 18) {
            try {
                Long l = (Long) statFs.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(statFs, new Object[0]);
                if (l != null) {
                    str = l.toString();
                }
            } catch (Throwable unused) {
            }
            return str;
        }
        long blockSize = (long) statFs.getBlockSize();
        long blockCount = (long) statFs.getBlockCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(blockCount * blockSize);
        stringBuilder.append("");
        return stringBuilder.toString();
    }

    private static synchronized void a(int i) {
        synchronized (c.class) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (e != 0 && currentTimeMillis - e < 10000) {
                    if (i == 1 && b != null) {
                    } else if (i == 2 && c != null) {
                    } else if (i == 3 && d != null) {
                    }
                }
                e = currentTimeMillis;
                Context context = a;
                if (context != null) {
                    Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    if (registerReceiver != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(registerReceiver.getIntExtra("level", -1));
                        stringBuilder.append("");
                        b = stringBuilder.toString();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(registerReceiver.getIntExtra("voltage", -1));
                        stringBuilder.append("");
                        c = stringBuilder.toString();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(registerReceiver.getIntExtra("temperature", -1));
                        stringBuilder.append("");
                        d = stringBuilder.toString();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        if (context != null && a == null) {
            a = context;
        }
    }

    public static String b() {
        Context context = a;
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            int i = displayMetrics2.widthPixels;
            int i2 = displayMetrics2.heightPixels;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("*");
            stringBuilder.append(i2);
            return String.valueOf(stringBuilder.toString());
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(File file) {
        String str = null;
        if (file == null) {
            return null;
        }
        StatFs statFs = new StatFs(file.getPath());
        if (VERSION.SDK_INT >= 18) {
            try {
                Long l = (Long) statFs.getClass().getDeclaredMethod("getAvailableBytes", new Class[0]).invoke(statFs, new Object[0]);
                if (l != null) {
                    str = l.toString();
                }
            } catch (Throwable unused) {
            }
            return str;
        }
        long availableBlocks = (long) statFs.getAvailableBlocks();
        long blockCount = (long) statFs.getBlockCount();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(blockCount * availableBlocks);
        stringBuilder.append("");
        return stringBuilder.toString();
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String c() {
        Context context = a;
        if (context == null) {
            return "";
        }
        try {
            int i;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            float f = displayMetrics.xdpi;
            float f2 = displayMetrics.ydpi;
            int i2 = VERSION.SDK_INT;
            if (i2 < 14 || i2 >= 17) {
                if (i2 >= 17) {
                    defaultDisplay.getRealMetrics(displayMetrics);
                }
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            } else {
                Method method = Display.class.getMethod("getRawWidth", new Class[0]);
                Method method2 = Display.class.getMethod("getRawHeight", new Class[0]);
                i = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                int intValue = ((Integer) method2.invoke(defaultDisplay, new Object[0])).intValue();
                i2 = i;
                i = intValue;
            }
            double d = ((double) i2) / ((double) f);
            double d2 = ((double) i) / ((double) f2);
            float refreshRate = defaultDisplay.getRefreshRate();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a(d));
            stringBuilder.append("*");
            stringBuilder.append(a(d2));
            stringBuilder.append("*");
            stringBuilder.append(Float.toString(refreshRate));
            return stringBuilder.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean c(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.television");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A:{SYNTHETIC, Splitter:B:18:0x0043} */
    /* JADX WARNING: Missing block: B:11:0x0037, code skipped:
            if (r4 != null) goto L_0x0039;
     */
    /* JADX WARNING: Missing block: B:13:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:24:0x0048, code skipped:
            if (r4 != null) goto L_0x0039;
     */
    public static java.lang.String d() {
        /*
        r0 = "/proc/meminfo";
        r1 = 0;
        r2 = 0;
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0047, all -> 0x003f }
        r5 = new java.io.FileReader;	 Catch:{ Exception -> 0x0047, all -> 0x003f }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0047, all -> 0x003f }
        r0 = 8;
        r4.<init>(r5, r0);	 Catch:{ Exception -> 0x0047, all -> 0x003f }
        r0 = r4.readLine();	 Catch:{ Exception -> 0x0048, all -> 0x003d }
        if (r0 == 0) goto L_0x0018;
    L_0x0017:
        goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        if (r0 == 0) goto L_0x0037;
    L_0x001b:
        r1 = 58;
        r1 = r0.indexOf(r1);	 Catch:{ Exception -> 0x0048, all -> 0x003d }
        r5 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r5 = r0.indexOf(r5);	 Catch:{ Exception -> 0x0048, all -> 0x003d }
        r1 = r1 + 1;
        r0 = r0.substring(r1, r5);	 Catch:{ Exception -> 0x0048, all -> 0x003d }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0048, all -> 0x003d }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0048, all -> 0x003d }
        r0 = (long) r0;
        r2 = r0;
    L_0x0037:
        if (r4 == 0) goto L_0x004b;
    L_0x0039:
        r4.close();	 Catch:{ IOException -> 0x004b }
        goto L_0x004b;
    L_0x003d:
        r0 = move-exception;
        goto L_0x0041;
    L_0x003f:
        r0 = move-exception;
        r4 = r1;
    L_0x0041:
        if (r4 == 0) goto L_0x0046;
    L_0x0043:
        r4.close();	 Catch:{ IOException -> 0x0046 }
    L_0x0046:
        throw r0;
    L_0x0047:
        r4 = r1;
    L_0x0048:
        if (r4 == 0) goto L_0x004b;
    L_0x004a:
        goto L_0x0039;
    L_0x004b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r2);
        r1 = "";
        r0.append(r1);
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.datacollection.c.d():java.lang.String");
    }

    public static boolean d(Context context) {
        try {
            return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            return (dataDirectory == null || dataDirectory.getAbsolutePath().length() == 0) ? null : a(dataDirectory);
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String f() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            return (dataDirectory == null || dataDirectory.getAbsolutePath().length() == 0) ? null : b(dataDirectory);
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String g() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                return (externalStorageDirectory == null || externalStorageDirectory.getAbsolutePath().length() == 0) ? null : a(externalStorageDirectory);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String h() {
        a(1);
        String str = b;
        return str == null ? "-1" : str;
    }

    public static String i() {
        a(2);
        String str = c;
        return str == null ? "-1" : str;
    }

    public static String j() {
        a(3);
        String str = d;
        return str == null ? "-1" : str;
    }

    @TargetApi(3)
    public static String k() {
        try {
            String string = Secure.getString(a.getContentResolver(), "android_id");
            return string != null ? string.trim() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String l() {
        return a == null ? "" : Float.toString(new Paint().getTextSize());
    }

    public static String m() {
        try {
            DisplayMetrics displayMetrics = a.getResources().getDisplayMetrics();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(displayMetrics.densityDpi);
            return stringBuilder.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String n() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            String address = defaultAdapter != null ? defaultAdapter.getAddress() : null;
            return address != null ? address.trim() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            String name = defaultAdapter != null ? defaultAdapter.getName() : null;
            return name != null ? name.trim() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String p() {
        return b(a) ? "Tablet" : (c(a) || d(a)) ? "TV" : "Phone";
    }
}
