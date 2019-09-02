package com.qiyukf.nimlib.k.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public final class c {
    public static String a(String str, b bVar) {
        str = a.a().a(str, bVar);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File parentFile = new File(str).getParentFile();
        if (!(parentFile == null || parentFile.exists())) {
            parentFile.mkdirs();
        }
        return str;
    }

    public static void a(Context context) {
        a.a().a(context);
    }

    public static void a(File file) {
        a(file, false);
    }

    private static void a(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        a(a, false);
                    }
                }
            }
            if (file.isFile() || !z) {
                file.delete();
            }
        }
    }

    public static boolean a() {
        a.a();
        return a.b();
    }

    public static boolean a(b bVar) {
        a.a();
        return a.b() && a.a().c() >= bVar.b();
    }

    public static String b() {
        String absolutePath;
        StringBuilder stringBuilder;
        if (VERSION.SDK_INT >= 8) {
            absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            stringBuilder = new StringBuilder();
        } else {
            absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            stringBuilder = new StringBuilder();
        }
        stringBuilder.append(absolutePath);
        stringBuilder.append("/qiyu/");
        return stringBuilder.toString();
    }

    public static String b(b bVar) {
        return a.a().a(bVar);
    }

    public static String b(String str, b bVar) {
        return a.a().b(str, bVar);
    }

    public static boolean c(b bVar) {
        a(new File(a.a().a(bVar)), true);
        return true;
    }
}
