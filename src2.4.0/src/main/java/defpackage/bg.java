package defpackage;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DBFileTraversalUtil */
/* renamed from: bg */
public class bg {
    private static ExecutorService O000000o = Executors.newSingleThreadExecutor();
    private static FileLockUtil O00000Oo = new FileLockUtil();

    /* compiled from: DBFileTraversalUtil */
    /* renamed from: bg$O000000o */
    public interface O000000o {
        void O000000o();
    }

    public static void O000000o(String str, final FileLockCallback fileLockCallback, final O000000o o000000o) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            O000000o.execute(new Runnable() {
                public void run() {
                    for (File file : file.listFiles()) {
                        if (file.getName().endsWith(bj.O00000o)) {
                            bg.O00000Oo.doFileOperateion(file, fileLockCallback);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("--->>> file: ");
                            stringBuilder.append(file.getName());
                            UMRTLog.i("MobclickRT", stringBuilder.toString());
                        }
                    }
                    if (o000000o != null) {
                        o000000o.O000000o();
                    }
                    UMRTLog.i("MobclickRT", "--->>> end *** ");
                }
            });
        }
    }
}
