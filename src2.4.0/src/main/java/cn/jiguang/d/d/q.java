package cn.jiguang.d.d;

import java.io.File;
import java.io.FileFilter;

final class q implements FileFilter {
    q() {
    }

    public final boolean accept(File file) {
        return file.isDirectory() && file.getName().startsWith("jpush_stat_history");
    }
}
