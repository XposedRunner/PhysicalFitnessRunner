package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

/* compiled from: CoordinatorSoDownloader */
public class OO0O0OO extends OO0Oo00 {
    private boolean O0000OOo = false;

    public OO0O0OO(Context context, String str, String str2, String str3) {
        super(context, str, str2, str3);
    }

    private static void O000000o(File file, File file2) {
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

    public final void O000000o() {
        if (this.O000000o != null && !TextUtils.isEmpty(this.O000000o.O00000o0()) && this.O000000o.O00000o0().endsWith("png") && this.O000000o.O00000o0().contains(OO0o000.O000000o(this.O00000oo))) {
            if ((this.O0000OOo || !OO0o000.O00000Oo(this.O00000oo)) && !O0000O0o && !new File(this.O00000o).exists()) {
                start();
            }
        }
    }

    public final void O000000o(boolean z) {
        this.O0000OOo = z;
    }

    public final void O00000o() {
        File file;
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.close();
            }
            String O000000o = OO0OOOO.O000000o(this.O00000o0);
            if (O000000o == null || !O000000o.equalsIgnoreCase(this.O00000oO)) {
                O00000Oo();
                return;
            }
            File file2 = new File(this.O00000o);
            if (file2.exists()) {
                O00000Oo();
                return;
            }
            file = new File(this.O00000o0);
            if (file.exists()) {
                O000000o(file, file2);
                O00000Oo();
            }
        } catch (Throwable th) {
            O00000Oo();
            file = new File(this.O00000o);
            if (file.exists()) {
                file.delete();
            }
            O0000Oo.O000000o(th, "sdl", "ofs");
        }
    }
}
