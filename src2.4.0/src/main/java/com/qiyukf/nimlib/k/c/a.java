package com.qiyukf.nimlib.k.c;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import java.io.IOException;

final class a {
    private static a b;
    private String a = null;

    private a() {
    }

    private static long a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    private String a(String str, b bVar, boolean z) {
        StringBuilder stringBuilder = new StringBuilder(a(bVar));
        stringBuilder.append(str);
        str = stringBuilder.toString();
        File file = new File(str);
        if (z) {
            if (file.exists() && !file.isDirectory()) {
                return str;
            }
            str = "";
        }
        return str;
    }

    static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* Access modifiers changed, original: final */
    public final String a(b bVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(bVar.a());
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: final */
    public final String a(String str, b bVar) {
        return a(str, bVar, false);
    }

    public final void a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            this.a = HttpUtils.PATHS_SEPARATOR;
            return;
        }
        this.a = externalFilesDir.getAbsolutePath().concat(HttpUtils.PATHS_SEPARATOR).concat("com.qiyukf.unicorn/");
        externalFilesDir = new File(this.a);
        if (externalFilesDir.exists() && !externalFilesDir.isDirectory()) {
            externalFilesDir.delete();
        }
        int i = 1;
        for (b bVar : b.values()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(bVar.a());
            File file = new File(stringBuilder.toString());
            int exists = file.exists();
            if (exists == 0) {
                exists = file.mkdirs();
            }
            i &= exists;
        }
        if (i != 0) {
            String str = this.a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("/.nomedia");
            File file2 = new File(stringBuilder2.toString());
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final String b(String str, b bVar) {
        return TextUtils.isEmpty(str) ? "" : a(str, bVar, true);
    }

    /* Access modifiers changed, original: final */
    public final long c() {
        return a(this.a);
    }
}
