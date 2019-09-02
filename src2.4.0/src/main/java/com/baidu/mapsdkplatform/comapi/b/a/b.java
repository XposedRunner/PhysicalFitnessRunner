package com.baidu.mapsdkplatform.comapi.b.a;

import com.baidu.mapsdkplatform.comapi.util.g;
import java.io.File;
import java.util.Arrays;

class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void run() {
        if (g.a().b() != null) {
            File file = new File(a.a);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    Arrays.sort(listFiles, new c());
                    int length = listFiles.length;
                    if (length > 10) {
                        length = 10;
                    }
                    for (int i = 0; i < length; i++) {
                        File file2 = listFiles[i];
                        if (!file2.isDirectory() && file2.exists() && file2.isFile() && file2.getName().contains(a.b) && (file2.getName().endsWith(".txt") || (file2.getName().endsWith(".zip") && file2.exists()))) {
                            this.a.a(file2);
                        }
                    }
                    if (listFiles.length > 10) {
                        this.a.a(listFiles);
                    }
                }
            }
        }
    }
}
