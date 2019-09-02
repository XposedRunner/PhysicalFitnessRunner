package cn.jiguang.d.d;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

final class s implements FileFilter {
    final /* synthetic */ String a;

    s(String str) {
        this.a = str;
    }

    public final boolean accept(File file) {
        return file.isDirectory() && (TextUtils.isEmpty(this.a) || this.a.equals(file.getName()));
    }
}
