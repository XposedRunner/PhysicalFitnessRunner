package cn.jiguang.d.h;

import java.io.File;
import java.io.FileFilter;

final class g implements FileFilter {
    final /* synthetic */ boolean a;

    g(boolean z) {
        this.a = z;
    }

    public final boolean accept(File file) {
        return this.a == file.isDirectory();
    }
}
