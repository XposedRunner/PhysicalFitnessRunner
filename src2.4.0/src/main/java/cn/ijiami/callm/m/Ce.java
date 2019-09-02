package cn.ijiami.callm.m;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* compiled from: Hl */
public class Ce {
    public static void checkEmulatorIJM(final Context context) {
        if (new File(Environment.getExternalStorageDirectory(), "/system/app/NoxHelp_zh.apk").exists()) {
            System.exit(0);
        }
        new File(Environment.getExternalStorageDirectory(), "YSLauncher").exists();
        try {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        l lVar = new l(context);
                    } catch (Exception unused) {
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
