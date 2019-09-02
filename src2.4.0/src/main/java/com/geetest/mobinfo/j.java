package com.geetest.mobinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.media.TransportMediator;
import com.bangcle.andJni.JniLib1557756502;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: AndroidEmulatorUtils */
public class j {
    private static final String[] a = new String[]{"goldfish"};
    private static final String[] b = new String[]{"/dev/socket/qemud", "/dev/qemu_pipe"};

    private static Boolean a(Context context) {
        return (Boolean) JniLib1557756502.cL(context, Integer.valueOf(TransportMediator.KEYCODE_MEDIA_PAUSE));
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(128));
    }

    private static boolean a() {
        String str = "$unknown";
        try {
            Process start = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            bufferedReader.close();
            str = stringBuilder.toString().toLowerCase();
        } catch (Exception unused) {
        }
        return str.contains("intel") || str.contains("amd");
    }

    private static boolean a(Context context, String str) {
        return JniLib1557756502.cZ(context, str, Integer.valueOf(129));
    }

    private static boolean a(String str) {
        File file = new File(str);
        if (file.exists() && file.canRead()) {
            byte[] bArr = new byte[1024];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(bArr);
                fileInputStream.close();
            } catch (Exception unused) {
            }
            String str2 = new String(bArr);
            for (CharSequence contains : a) {
                if (str2.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b() {
        for (String file : b) {
            if (new File(file).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Context context) {
        return JniLib1557756502.cZ(context, Integer.valueOf(TransportMediator.KEYCODE_MEDIA_RECORD));
    }

    /* JADX WARNING: Missing block: B:74:0x016c, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:75:0x016d, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:76:0x016e, code skipped:
            return true;
     */
    /* JADX WARNING: Missing block: B:77:0x016f, code skipped:
            return true;
     */
    private static boolean c() {
        /*
        r0 = android.os.Build.PRODUCT;
        r1 = "sdk";
        r0 = r0.contains(r1);
        r1 = 1;
        if (r0 != 0) goto L_0x016f;
    L_0x000b:
        r0 = android.os.Build.PRODUCT;
        r2 = "sdk_x86";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016f;
    L_0x0015:
        r0 = android.os.Build.PRODUCT;
        r2 = "sdk_google";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016f;
    L_0x001f:
        r0 = android.os.Build.PRODUCT;
        r2 = "Andy";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016f;
    L_0x0029:
        r0 = android.os.Build.PRODUCT;
        r2 = "Droid4X";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016f;
    L_0x0033:
        r0 = android.os.Build.PRODUCT;
        r2 = "nox";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016f;
    L_0x003d:
        r0 = android.os.Build.PRODUCT;
        r2 = "vbox86p";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016f;
    L_0x0047:
        r0 = android.os.Build.PRODUCT;
        r2 = "aries";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0053;
    L_0x0051:
        goto L_0x016f;
    L_0x0053:
        r0 = android.os.Build.MANUFACTURER;
        r2 = "Genymotion";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016e;
    L_0x005d:
        r0 = android.os.Build.MANUFACTURER;
        r2 = "Andy";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016e;
    L_0x0067:
        r0 = android.os.Build.MANUFACTURER;
        r2 = "nox";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016e;
    L_0x0071:
        r0 = android.os.Build.MANUFACTURER;
        r2 = "TiantianVM";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x007d;
    L_0x007b:
        goto L_0x016e;
    L_0x007d:
        r0 = android.os.Build.BRAND;
        r2 = "Andy";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0088;
    L_0x0087:
        return r1;
    L_0x0088:
        r0 = android.os.Build.DEVICE;
        r2 = "Andy";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016d;
    L_0x0092:
        r0 = android.os.Build.DEVICE;
        r2 = "Droid4X";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016d;
    L_0x009c:
        r0 = android.os.Build.DEVICE;
        r2 = "nox";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016d;
    L_0x00a6:
        r0 = android.os.Build.DEVICE;
        r2 = "vbox86p";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016d;
    L_0x00b0:
        r0 = android.os.Build.DEVICE;
        r2 = "aries";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x00bc;
    L_0x00ba:
        goto L_0x016d;
    L_0x00bc:
        r0 = android.os.Build.MODEL;
        r2 = "Emulator";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016c;
    L_0x00c6:
        r0 = android.os.Build.MODEL;
        r2 = "google_sdk";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016c;
    L_0x00d0:
        r0 = android.os.Build.MODEL;
        r2 = "Droid4X";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016c;
    L_0x00da:
        r0 = android.os.Build.MODEL;
        r2 = "TiantianVM";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016c;
    L_0x00e4:
        r0 = android.os.Build.MODEL;
        r2 = "Andy";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016c;
    L_0x00ee:
        r0 = android.os.Build.MODEL;
        r2 = "Android SDK built for x86_64";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016c;
    L_0x00f8:
        r0 = android.os.Build.MODEL;
        r2 = "Android SDK built for x86";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0103;
    L_0x0102:
        goto L_0x016c;
    L_0x0103:
        r0 = android.os.Build.HARDWARE;
        r2 = "vbox86";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016b;
    L_0x010d:
        r0 = android.os.Build.HARDWARE;
        r2 = "nox";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016b;
    L_0x0117:
        r0 = android.os.Build.HARDWARE;
        r2 = "ttVM_x86";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0122;
    L_0x0121:
        goto L_0x016b;
    L_0x0122:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "generic/sdk/generic";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016a;
    L_0x012c:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "generic_x86/sdk_x86/generic_x86";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016a;
    L_0x0136:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "Andy";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016a;
    L_0x0140:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "ttVM_Hdragon";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016a;
    L_0x014a:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "generic/google_sdk/generic";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016a;
    L_0x0154:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "vbox86p";
        r0 = r0.contains(r2);
        if (r0 != 0) goto L_0x016a;
    L_0x015e:
        r0 = android.os.Build.FINGERPRINT;
        r2 = "generic/vbox86p/vbox86p";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0169;
    L_0x0168:
        goto L_0x016a;
    L_0x0169:
        r1 = 0;
    L_0x016a:
        return r1;
    L_0x016b:
        return r1;
    L_0x016c:
        return r1;
    L_0x016d:
        return r1;
    L_0x016e:
        return r1;
    L_0x016f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.mobinfo.j.c():boolean");
    }

    @SuppressLint({"HardwareIds"})
    private static boolean c(Context context) {
        return JniLib1557756502.cZ(context, Integer.valueOf(131));
    }
}
