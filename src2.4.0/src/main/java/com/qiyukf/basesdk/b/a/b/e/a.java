package com.qiyukf.basesdk.b.a.b.e;

import java.io.File;
import java.io.RandomAccessFile;

public class a {
    private static final String a = c.a(a.class);
    private final RandomAccessFile b;
    private final File c;
    private final String d;

    public a(File file, String str) {
        this.c = file;
        this.b = new RandomAccessFile(file, "r");
        if (str == null || str.trim().length() <= 0) {
            str = file.getName();
        }
        this.d = str;
    }

    public final byte[] a(long j, int i) {
        if (j == 0 && i == 0 && this.c.length() == 0) {
            return new byte[0];
        }
        if (j >= this.c.length()) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.b.seek(j);
        this.b.read(bArr);
        return bArr;
    }
}
