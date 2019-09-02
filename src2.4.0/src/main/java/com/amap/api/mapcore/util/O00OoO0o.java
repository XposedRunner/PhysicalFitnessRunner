package com.amap.api.mapcore.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: FileAccessI */
class O00OoO0o {
    RandomAccessFile O000000o;

    public O00OoO0o() throws IOException {
        this("", 0);
    }

    public O00OoO0o(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                ooOOOOoo.O00000o0(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        this.O000000o = new RandomAccessFile(str, "rw");
        this.O000000o.seek(j);
    }

    public synchronized int O000000o(byte[] bArr) throws IOException {
        this.O000000o.write(bArr);
        return bArr.length;
    }

    public void O000000o() {
        if (this.O000000o != null) {
            try {
                this.O000000o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.O000000o = null;
        }
    }
}
