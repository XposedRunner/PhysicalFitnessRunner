package com.baidu.location.a;

import com.baidu.location.g.i;
import com.baidu.location.g.j;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class g {
    private static g a = null;
    private static String b = "Temp_in.dat";
    private static File c = new File(i.a, b);
    private static StringBuffer d = null;
    private static boolean e = true;
    private static int f;
    private static int g;
    private static long h;
    private static long i;
    private static long j;
    private static double k;
    private static double l;
    private static int m;
    private static int n;
    private static int o;

    public static String a() {
        if (c == null || !c.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            if (a(readInt, readInt2, readInt3)) {
                if (readInt2 != 0) {
                    if (readInt2 != readInt3) {
                        int i;
                        long j = 0 + ((long) (12 + (1024 * (readInt2 - 1))));
                        randomAccessFile.seek(j);
                        int readInt4 = randomAccessFile.readInt();
                        byte[] bArr = new byte[readInt4];
                        randomAccessFile.seek(j + 4);
                        for (i = 0; i < readInt4; i++) {
                            bArr[i] = randomAccessFile.readByte();
                        }
                        String str = new String(bArr);
                        i = 1;
                        if (readInt < j.ae) {
                            readInt2++;
                        } else {
                            if (readInt2 != j.ae) {
                                i = 1 + readInt2;
                            }
                            readInt2 = i;
                        }
                        randomAccessFile.seek(4);
                        randomAccessFile.writeInt(readInt2);
                        randomAccessFile.close();
                        return str;
                    }
                }
                randomAccessFile.close();
                return null;
            }
            randomAccessFile.close();
            c();
            return null;
        } catch (IOException unused) {
        }
    }

    private static boolean a(int i, int i2, int i3) {
        if (i >= 0 && i <= j.ae && i2 >= 0) {
            i++;
            return i2 <= i && i3 >= 1 && i3 <= i && i3 <= j.ae;
        }
        return false;
    }

    private static void b() {
        e = true;
        d = null;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = 0;
        k = 0.0d;
        l = 0.0d;
        m = 0;
        n = 0;
        o = 0;
    }

    private static boolean c() {
        if (c.exists()) {
            c.delete();
        }
        if (!c.getParentFile().exists()) {
            c.getParentFile().mkdirs();
        }
        try {
            c.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(c, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b();
            return c.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}
