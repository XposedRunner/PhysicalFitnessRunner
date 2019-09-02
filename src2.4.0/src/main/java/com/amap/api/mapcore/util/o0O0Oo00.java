package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

/* compiled from: CoordinatorSoDownloader */
public class o0O0Oo00 extends o0OOoOO0 {
    private boolean O0000OOo = false;

    public o0O0Oo00(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
    }

    private void O000000o(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(new byte[32]);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            byte[] bArr = new byte[1024];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    if (read == 1024) {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr);
                    } else {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        randomAccessFile.seek((long) i);
                        randomAccessFile.write(bArr2);
                    }
                    i += read;
                } else {
                    fileInputStream.close();
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void O000000o() {
        if (this.O000000o != null && !TextUtils.isEmpty(this.O000000o.getURL()) && this.O000000o.getURL().endsWith("png") && this.O000000o.getURL().contains(o0OOOO00.O000000o(this.O00000oo))) {
            if ((this.O0000OOo || !o0OOOO00.O00000Oo(this.O00000oo)) && !O0000O0o && !new File(this.O00000o).exists()) {
                start();
            }
        }
    }

    public void onFinish() {
        File file;
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
            }
            String O000000o = o0OO00o0.O000000o(this.O00000o0);
            if (O000000o == null || !O000000o.equalsIgnoreCase(this.O00000oO)) {
                O00000Oo();
            }
            File file2 = new File(this.O00000o);
            if (file2.exists()) {
                O00000Oo();
                return;
            }
            file = new File(this.O00000o0);
            if (file != null) {
                if (file.exists()) {
                    O000000o(file, file2);
                    O00000Oo();
                }
            }
        } catch (Throwable th) {
            O00000Oo();
            file = new File(this.O00000o);
            if (file.exists()) {
                file.delete();
            }
            oO0OoOO0.O000000o(th, "sdl", "ofs");
        }
    }
}
