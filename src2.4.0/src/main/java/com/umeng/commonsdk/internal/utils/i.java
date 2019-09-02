package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.a;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: SDStorage */
public class i {
    private static final String a = "/.um/.umm.dat";
    private static final String b = "/.uxx/.cca.dat";
    private static final String c = "/.cc/.adfwe.dat";
    private static final String d = "/.a.dat";
    private static final String e = "umdat";

    public static String a(Context context) {
        String b = b(context);
        if (b == null || b.equals("")) {
            b = g(context);
        }
        if (b == null || b.equals("")) {
            b = c(context);
        }
        if (b == null || b.equals("")) {
            b = d(context);
        }
        if (b == null || b.equals("")) {
            b = e(context);
        }
        return (b == null || b.equals("")) ? f(context) : b;
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String g = g(context);
            if (TextUtils.isEmpty(g) || !str.equals(g)) {
                b(context, str);
            }
        }
    }

    private static void a(Context context, String str, String str2) {
        if (DeviceConfig.checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equalsIgnoreCase("mounted")) {
                    String c = c(context, str2);
                    if (c == null || !c.equals(str)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(Environment.getExternalStorageDirectory());
                        stringBuilder.append(str2);
                        File file = new File(stringBuilder.toString());
                        if (!(file.getParentFile() == null || file.getParentFile().exists())) {
                            file.getParentFile().mkdir();
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(Environment.getExternalStorageDirectory());
                        stringBuilder.append(str2);
                        RandomAccessFile randomAccessFile = new RandomAccessFile(stringBuilder.toString(), "rw");
                        randomAccessFile.setLength((long) str.getBytes().length);
                        FileChannel channel = randomAccessFile.getChannel();
                        FileLock tryLock = channel.tryLock();
                        ByteBuffer allocate = ByteBuffer.allocate(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
                        allocate.clear();
                        allocate.put(str.getBytes());
                        allocate.flip();
                        while (allocate.hasRemaining()) {
                            channel.write(allocate);
                        }
                        channel.force(true);
                        if (tryLock != null) {
                            tryLock.release();
                        }
                        channel.close();
                    }
                }
            } catch (Exception e) {
                if (e != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("saveFileUmtt:");
                    stringBuilder2.append(e.getMessage());
                    ULog.e(stringBuilder2.toString());
                }
            }
        }
    }

    public static String b(Context context) {
        return h(context);
    }

    public static void b(Context context, String str) {
        a(context, str, a);
        a(context, str, b);
        a(context, str, c);
        a(context, str, d);
        d(context, str);
    }

    public static String c(Context context) {
        return c(context, a);
    }

    private static String c(Context context, String str) {
        String str2 = null;
        try {
            if (DeviceConfig.checkPermission(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equalsIgnoreCase("mounted")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Environment.getExternalStorageDirectory());
                    stringBuilder.append(str);
                    if (!new File(stringBuilder.toString()).exists()) {
                        return null;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Environment.getExternalStorageDirectory());
                    stringBuilder.append(str);
                    FileChannel channel = new RandomAccessFile(stringBuilder.toString(), "rw").getChannel();
                    FileLock tryLock = channel.tryLock();
                    stringBuilder = new StringBuilder();
                    ByteBuffer allocate = ByteBuffer.allocate(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
                    allocate.clear();
                    while (channel.read(allocate) != -1) {
                        byte[] bArr = new byte[allocate.position()];
                        for (int i = 0; i < allocate.position(); i++) {
                            bArr[i] = allocate.get(i);
                        }
                        stringBuilder.append(new String(bArr));
                        allocate.clear();
                    }
                    if (channel != null) {
                        tryLock.release();
                    }
                    channel.close();
                    str2 = stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            if (e != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("getFileUmtt:");
                stringBuilder2.append(e.getMessage());
                ULog.e(stringBuilder2.toString());
            }
        }
        return str2;
    }

    public static String d(Context context) {
        return c(context, b);
    }

    private static void d(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(e, 0);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("u", null);
            if (string == null || !string.equals(str)) {
                sharedPreferences.edit().putString("u", str).commit();
            }
        }
    }

    public static String e(Context context) {
        return c(context, c);
    }

    public static String f(Context context) {
        return c(context, d);
    }

    public static String g(Context context) {
        return i(context);
    }

    private static String h(Context context) {
        return a.a(context, e.e, null);
    }

    private static String i(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(e, 0);
        return sharedPreferences != null ? sharedPreferences.getString("u", null) : null;
    }
}
