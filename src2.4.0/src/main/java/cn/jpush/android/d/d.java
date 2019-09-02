package cn.jpush.android.d;

import java.io.File;
import java.util.Comparator;

final class d implements Comparator<File> {
    d() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        return file.lastModified() > file2.lastModified() ? -1 : file.lastModified() < file2.lastModified() ? 1 : 0;
    }
}
