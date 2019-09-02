package com.qiyukf.unicorn.d;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.qiyukf.basesdk.c.d.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;

public final class b {
    public static String a() {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("   time: ", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append(" ");
        stringBuilder.append(Build.MODEL);
        linkedHashMap.put(" device: ", stringBuilder.toString());
        linkedHashMap.put("android: ", VERSION.RELEASE);
        linkedHashMap.put(" system: ", Build.DISPLAY);
        ActivityManager activityManager = (ActivityManager) com.qiyukf.nimlib.b.a().getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        linkedHashMap.put("    ram: ", String.valueOf(memoryInfo.availMem));
        String str = "   disk: ";
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSizeLong;
            long availableBlocksLong;
            if (VERSION.SDK_INT >= 18) {
                blockSizeLong = statFs.getBlockSizeLong();
                long blockCountLong = statFs.getBlockCountLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
                jArr[0] = blockCountLong * blockSizeLong;
                jArr[1] = blockSizeLong * availableBlocksLong;
            } else {
                blockSizeLong = (long) statFs.getBlockSize();
                availableBlocksLong = (long) statFs.getAvailableBlocks();
                jArr[0] = ((long) statFs.getBlockCount()) * blockSizeLong;
                jArr[1] = blockSizeLong * availableBlocksLong;
            }
        }
        long j = jArr[0];
        long j2 = jArr[1];
        if (j <= 0) {
            obj = "--";
        } else {
            Locale locale;
            String str2;
            Object[] objArr;
            float f = (float) ((j2 * 100) / j);
            Locale locale2 = Locale.US;
            String str3 = "%.01f%% [%s]";
            Object[] objArr2 = new Object[2];
            objArr2[0] = Float.valueOf(f);
            if (j >= 1073741824) {
                f = (float) (j / 1073741824);
                locale = Locale.US;
                str2 = "%.02f GB";
                objArr = new Object[]{Float.valueOf(f)};
            } else if (j >= 1048576) {
                f = (float) (j / 1048576);
                locale = Locale.US;
                str2 = "%.02f MB";
                objArr = new Object[]{Float.valueOf(f)};
            } else {
                f = (float) (j / 1024);
                locale = Locale.US;
                str2 = "%.02f KB";
                objArr = new Object[]{Float.valueOf(f)};
            }
            objArr2[1] = String.format(locale, str2, objArr);
            obj = String.format(locale2, str3, objArr2);
        }
        linkedHashMap.put(str, obj);
        linkedHashMap.put("network: ", c.h(com.qiyukf.nimlib.b.a()));
        StringBuilder stringBuilder2 = new StringBuilder();
        for (Entry entry : linkedHashMap.entrySet()) {
            if (entry != null) {
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append((String) entry.getValue());
                stringBuilder2.append(System.getProperty("line.separator"));
            }
        }
        stringBuilder2.append(System.getProperty("line.separator"));
        stringBuilder2.append("========================");
        stringBuilder2.append(System.getProperty("line.separator"));
        stringBuilder2.append(System.getProperty("line.separator"));
        return stringBuilder2.toString();
    }
}
