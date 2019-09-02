package cn.ijiami.callm.m;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Hl */
public class l {
    private static boolean c;
    Context a;
    private String b;
    private BroadcastReceiver d = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            Intent registerReceiver = l.this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            registerReceiver.getIntExtra("status", -1);
            registerReceiver.getIntExtra("plugged", -1);
            intent.getIntExtra("scale", -1);
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("voltage", -1);
            int intExtra3 = intent.getIntExtra("temperature", -1);
            l.c("ro.product.model");
            if (intExtra3 == 0 && l.this.b.equals("x86")) {
                l.this.a(context);
            }
            if (intExtra2 <= 0) {
                l.this.a(context);
            }
            if (intExtra < 0 && (intExtra2 < 2000 || intExtra2 > 5000)) {
                l.this.a(context);
            }
            try {
                if (l.this.d != null) {
                    l.this.a.unregisterReceiver(l.this.d);
                }
            } catch (Exception unused) {
            }
        }
    };

    public l(Context context) {
        this.a = context;
        String str = Build.MODEL;
        str = Build.FINGERPRINT;
        this.b = c("ro.product.cpu.abi");
        String str2 = this.b;
        new StringBuilder().append(this.b);
        new StringBuilder().append(str2);
        new StringBuilder().append(str);
        str2 = c("ro.arch");
        if (!TextUtils.isEmpty(str2) && str2.contains("x86")) {
            this.b = "x86";
        }
        str2 = c("ro.dalvik.vm.isa.arm");
        if (!TextUtils.isEmpty(str2) && str2.contains("x86")) {
            this.b = "x86";
        }
        StringBuilder stringBuilder = new StringBuilder("/proc/");
        stringBuilder.append(Process.myPid());
        stringBuilder.append("/maps");
        String a = a(stringBuilder.toString());
        if (a.contains("/data/dalvik-cache/x86/")) {
            this.b = "x86";
        }
        if (TextUtils.isEmpty(this.b)) {
            a(context);
        }
        if (str.contains(".tiantian.") || str.contains("TiantianVM") || str.toLowerCase().contains("ldsplayer") || str.toLowerCase().toLowerCase().contains("ludashi") || str.contains("TTVM/") || str.contains("iToolsVM") || str.contains("KPPlayer") || ((str.contains("samsung") && this.b.contains("x86") && str.contains("KOT49H")) || (str.contains("samsung") && this.b.contains("x86") && str.contains("JDQ39") && !str.contains("santos10wifizc")))) {
            a(context);
            return;
        }
        str = a("/proc/cpuinfo");
        if (str.contains("Genuine Intel(R)") || str.contains("Intel(R) Core(TM)") || str.contains("Intel(R) Pentium(R)") || str.contains("Intel(R) Xeon(R)") || str.contains("AMD")) {
            a(context);
        }
        if (TextUtils.isEmpty(str) && this.b.contains("x86")) {
            a(context);
        }
        str = c("ro.product.cpu.abi");
        if (a.contains("/data/dalvik-cache/x86/") && str2.contains("x86") && !str.contains("x86")) {
            a(context);
        }
        if (a.contains("/data/dalvik-cache/x86/") && !str.contains("x86")) {
            a(context);
        }
        if (str2.contains("x86") && !str.contains("x86")) {
            a(context);
        }
        boolean booleanValue = ((Boolean) a(101, (List) a(4, null, 1, 0, false), 1, 0, false)).booleanValue();
        if (this.b.contains("x86") || booleanValue) {
            if (((Boolean) a(101, (List) a(1, null, 2, 0, booleanValue), 2, 1, booleanValue)).booleanValue()) {
                a(context);
            }
            if (((Boolean) a(101, (List) a(2, null, 2, 0, booleanValue), 2, 0, booleanValue)).booleanValue()) {
                a(context);
            }
            if (((Boolean) a(101, (List) a(3, null, 2, 0, booleanValue), 2, 0, booleanValue)).booleanValue()) {
                a(context);
            }
            if (((Boolean) a(101, (List) a(5, null, 2, 0, booleanValue), 2, 0, booleanValue)).booleanValue()) {
                a(context);
            }
            if (((Boolean) a(101, (List) a(7, null, 2, 0, booleanValue), 2, 0, booleanValue)).booleanValue()) {
                a(context);
            }
            if (((Boolean) a(101, (List) a(6, null, 2, 0, booleanValue), 2, 0, booleanValue)).booleanValue()) {
                a(context);
            }
            if (((Boolean) a(101, (List) a(8, null, 2, 0, booleanValue), 2, 0, booleanValue)).booleanValue()) {
                a(context);
            }
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            this.a.registerReceiver(this.d, intentFilter);
        } catch (Exception unused) {
        }
    }

    public static Object a(int i, Object obj, int i2, int i3, boolean z) {
        if (i != -1 && i <= 100) {
            ArrayList arrayList = new ArrayList();
            if (i == 1) {
                arrayList.add(new File("/system/lib/vboxguest.ko"));
                arrayList.add(new File("/system/lib/vboxsf.ko"));
                arrayList.add(new File(Environment.getExternalStorageDirectory(), "BigNoxHD"));
                arrayList.add(new File(Environment.getExternalStorageDirectory(), "BigNoxGameHD"));
                arrayList.add(new File(Environment.getExternalStorageDirectory(), "Android/data/com.bignox.app.store.hd"));
                arrayList.add(new File(Environment.getExternalStorageDirectory(), "/data/data/com.bignox.app.store.hd"));
                return arrayList;
            }
            if (i == 2) {
                arrayList.add(new File("/data/dalvik-cache/com.microvirt.tools"));
                arrayList.add(new File("/sdcard/Android/data/com.microvirt.guide"));
                arrayList.add(new File("/sdcard/Android/data/com.microvirt.guide"));
                arrayList.add(new File("/sdcard/xysdk"));
                arrayList.add(new File("/data/data/com.microvirt.tools"));
                arrayList.add(new File("/sdcard/Android/data/com.microvirt.launcher"));
                arrayList.add(new File("/data/data/com.microvirt.memuime"));
                arrayList.add(new File("/data/data/com.microvirt.launcher"));
                arrayList.add(new File("/data/data/com.microvirt.market"));
                arrayList.add(new File("/data/data/com.microvirt.download"));
                arrayList.add(new File("/data/user/0/com.microvirt.market"));
                arrayList.add(new File("/data/user/0/com.microvirt.launcher"));
            } else if (i == 3) {
                arrayList.add(new File("/system/lib/libc_malloc_debug_qemu.so"));
                arrayList.add(new File("/init.ludashi.rc"));
                arrayList.add(new File("/fstab.ludashi"));
                arrayList.add(new File("/system/lib/vboxsf.ko"));
            } else if (i == 4) {
                arrayList.add(new File("/system/bin/su"));
                arrayList.add(new File("/system/bin"));
                arrayList.add(new File("/system/xbin/su"));
                arrayList.add(new File("/su/bin/"));
                arrayList.add(new File("/system/sbin/su"));
                arrayList.add(new File("/sbin/su"));
                arrayList.add(new File("/vendor/bin/su"));
            } else if (i == 5) {
                arrayList.add(new File("/data/data/com.mumu.launcher"));
                arrayList.add(new File("/data/data/com.netease.mumu.cloner"));
                arrayList.add(new File("/data/data/com.netease.nemu_vapi_android.nemu"));
                arrayList.add(new File("/data/property/nemu.nemud.device.imsi"));
                arrayList.add(new File("/data/property/nemu.nemud.device.sim.serialno"));
                arrayList.add(new File("/data/mumu_store_apps"));
                arrayList.add(new File("/system/app/nemu-vinput-pack"));
                arrayList.add(new File("/system/app/nemu-vapi-android-pack"));
                arrayList.add(new File("/system/nemu-cloner"));
            } else if (i == 6) {
                arrayList.add(new File("sdcard/Android/data/com.bluestacks.home"));
                arrayList.add(new File("/data/data/com.bluestacks.searchapp"));
                arrayList.add(new File("/data/data/com.bluestacks.windowsfilemanager"));
                arrayList.add(new File("/data/data/com.bluestacks.settings"));
                arrayList.add(new File("/data/data/com.bluestacks.setup"));
                arrayList.add(new File("/data/data/com.bluestacks.bstfolder"));
                arrayList.add(new File("/data/app/app-lib/com.bluestacks.setup"));
                arrayList.add(new File("/data/bluestacks.prop"));
                arrayList.add(new File("/ueventd.vbox86.rc"));
            } else if (i == 8) {
                arrayList.add(new File("ueventd.ttVM_x86.rc"));
                arrayList.add(new File("/dev/vboxguest"));
                arrayList.add(new File("/dev/vboxpci"));
                arrayList.add(new File("/dev/vboxuser"));
            } else if (i == 7) {
                arrayList.add(new File("/fstab.vbox86"));
                arrayList.add(new File("/system/bin/droid4x"));
                arrayList.add(new File("/system/bin/droid4x_setprop"));
                arrayList.add(new File("/system/droid4x/bin/su"));
                arrayList.add(new File("/system/bin/droid4x-prop"));
                arrayList.add(new File("/system/bin/droid4x-vbox-sf"));
            }
            return arrayList;
        } else if (!(obj instanceof List)) {
            return null;
        } else {
            i = 0;
            for (File exists : (List) obj) {
                if (exists.exists()) {
                    i++;
                    continue;
                }
                if (i >= i2) {
                    return Boolean.TRUE;
                }
            }
            return i >= i2 ? Boolean.TRUE : (i > 0 && i3 == 1 && z) ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(Context context) {
        Log.getStackTraceString(new Exception());
        if (context != null && (context instanceof Activity)) {
            try {
                ((Activity) context).finish();
            } catch (Error | Exception unused) {
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
        while (true) {
            context.registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                }
            }, new IntentFilter("android.intent.action.SCREEN_ON"));
        }
    }

    private static String c(String str) {
        return (String) a("android.os.Build", "getString", new Class[]{String.class}, new Object[]{str});
    }

    /* Access modifiers changed, original: protected */
    public String a(String str) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                } else {
                    bufferedReader.close();
                    fileReader.close();
                    return stringBuffer.toString();
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }
}
