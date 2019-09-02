package defpackage;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.umeng.socialize.utils.O0000O0o;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: CacheUtil */
/* renamed from: br */
public class br {

    /* compiled from: CacheUtil */
    /* renamed from: br$O000000o */
    private static class O000000o implements Comparator<File> {
        private O000000o() {
        }

        /* renamed from: O000000o */
        public int compare(File file, File file2) {
            return file.lastModified() > file2.lastModified() ? 1 : file.lastModified() == file2.lastModified() ? 0 : -1;
        }
    }

    public static void O000000o() {
        Object obj = (Environment.getExternalStorageDirectory() == null || TextUtils.isEmpty(Environment.getExternalStorageDirectory().getPath())) ? null : 1;
        StringBuilder stringBuilder;
        if (obj != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append(File.separator);
            stringBuilder.append(bt.O00000oO);
            stringBuilder.append(File.separator);
            bt.O00000o = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getDataDirectory().getPath());
            stringBuilder.append(File.separator);
            stringBuilder.append(bt.O00000oO);
            stringBuilder.append(File.separator);
            bt.O00000o = stringBuilder.toString();
        }
        File file = new File(bt.O00000o);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            br.O000000o(bt.O00000o);
        } catch (Exception e) {
            O0000O0o.O000000o(e);
        }
    }

    private static void O000000o(String str) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null && listFiles.length != 0) {
            int i = 0;
            int i2 = 0;
            int i3 = i2;
            while (i2 < listFiles.length) {
                i3 = (int) (((long) i3) + listFiles[i2].length());
                i2++;
            }
            if (i3 > 0 || 40 > br.O00000o0()) {
                i2 = listFiles.length;
                Arrays.sort(listFiles, new O000000o());
                while (i < i2) {
                    listFiles[i].delete();
                    i++;
                }
            }
        }
    }

    public static void O00000Oo() {
        br.O000000o();
    }

    private static int O00000o0() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (int) ((((double) statFs.getAvailableBlocks()) * ((double) statFs.getBlockSize())) / 1048576.0d);
    }
}
