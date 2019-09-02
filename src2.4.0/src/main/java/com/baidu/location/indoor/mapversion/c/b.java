package com.baidu.location.indoor.mapversion.c;

import java.io.File;
import java.io.FilenameFilter;

class b implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    b(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public boolean accept(File file, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.d(this.a));
        stringBuilder.append("_");
        return str.startsWith(stringBuilder.toString());
    }
}
