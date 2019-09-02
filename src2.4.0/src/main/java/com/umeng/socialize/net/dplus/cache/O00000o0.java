package com.umeng.socialize.net.dplus.cache;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O00000Oo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: CacheExector */
public class O00000o0 {
    private static final String O000000o = "O00000o0";
    private final int O00000Oo = 32;
    private final int O00000o = 8;
    private final int O00000o0 = 5120;
    private String O00000oO = null;

    public O00000o0(String str) {
        this.O00000oO = str;
    }

    private double O000000o(long j) {
        return j <= 0 ? 0.0d : ((double) j) / 1024.0d;
    }

    private File O000000o() {
        if (TextUtils.isEmpty(this.O00000oO)) {
            Log.d(O000000o, "Couldn't create directory mDirPath is null");
            return null;
        }
        File file = new File(this.O00000oO);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        String str = O000000o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't create directory");
        stringBuilder.append(this.O00000oO);
        Log.d(str, stringBuilder.toString());
        return null;
    }

    private File O000000o(File file, String str) {
        return (file == null || !file.isDirectory()) ? null : new File(file, O00000o0(str));
    }

    private void O000000o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                O0000O0o.O000000o(O00000Oo.O000000o, e);
            }
        }
    }

    private File[] O000000o(File file) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        Arrays.sort(listFiles, O00000Oo());
        return listFiles;
    }

    private <T extends O0000OOo> T O00000Oo(String str, Class<T> cls) {
        try {
            return (O0000OOo) cls.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
        } catch (Throwable th) {
            O0000O0o.O000000o(O00000Oo.O000000o, th);
            return null;
        }
    }

    private File O00000Oo(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File O000000o;
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            O000000o = O000000o(file, str);
        } else {
            O000000o = O00000o0(file, str);
            if (O000000o == null) {
                O000000o = O000000o(file, str);
            }
        }
        return O000000o;
    }

    private Comparator<File> O00000Oo() {
        return new Comparator<File>() {
            /* renamed from: O000000o */
            public int compare(File file, File file2) {
                return Long.valueOf(file.length()).compareTo(Long.valueOf(file2.length()));
            }
        };
    }

    private File O00000o(File file, String str) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        String[] list = file.list();
        return (list == null || list.length <= 0) ? null : O00000oO(file, str);
    }

    /* JADX WARNING: Missing block: B:11:0x0022, code skipped:
            return null;
     */
    private java.io.File O00000o0(java.io.File r6, java.lang.String r7) {
        /*
        r5 = this;
        r6 = r5.O000000o(r6);
        r7 = 0;
        if (r6 == 0) goto L_0x0022;
    L_0x0007:
        r0 = r6.length;
        if (r0 > 0) goto L_0x000b;
    L_0x000a:
        goto L_0x0022;
    L_0x000b:
        r0 = 0;
        r1 = r6.length;
        if (r1 <= 0) goto L_0x0021;
    L_0x000f:
        r6 = r6[r0];
        r0 = r6.length();
        r0 = r5.O000000o(r0);
        r2 = 4629700416936869888; // 0x4040000000000000 float:0.0 double:32.0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0020;
    L_0x001f:
        return r7;
    L_0x0020:
        return r6;
    L_0x0021:
        return r7;
    L_0x0022:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache.O00000o0.O00000o0(java.io.File, java.lang.String):java.io.File");
    }

    private String O00000o0(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(System.currentTimeMillis()));
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private File O00000oO(File file, String str) {
        File[] O000000o = O000000o(file);
        if (O000000o == null || O000000o.length <= 0) {
            return null;
        }
        for (File file2 : O000000o) {
            if (O000000o(file2.length()) <= ((double) 40) && file2.getName().endsWith(str)) {
                return file2;
            }
            String str2 = O000000o;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getReadableFileFromFiles:file length don't legal");
            stringBuilder.append(file2.length());
            Log.e(str2, stringBuilder.toString());
            O00000Oo(file2.getName());
        }
        return null;
    }

    public double O000000o(String str) {
        File O000000o = O000000o();
        double d = 0.0d;
        if (O000000o == null || !O000000o.isDirectory()) {
            return 0.0d;
        }
        File[] listFiles = O000000o.listFiles();
        int i = 0;
        while (i < listFiles.length) {
            if (listFiles[i] != null && listFiles[i].getName().contains(str)) {
                d += O000000o(listFiles[i].length());
            }
            i++;
        }
        return d;
    }

    public <T extends O0000OOo> T O000000o(String str, Class<T> cls) {
        Closeable bufferedReader;
        Throwable e;
        File O00000o = O00000o(O000000o(), str);
        if (O00000o == null) {
            return null;
        }
        Closeable O00000o0;
        try {
            O00000o0 = new O000000o(O00000o).O00000o0();
        } catch (IOException e2) {
            O0000O0o.O000000o(O00000Oo.O000000o, e2);
            O00000Oo(O00000o.getName());
            O00000o0 = null;
        }
        if (O00000o0 == null) {
            return null;
        }
        Closeable inputStreamReader;
        try {
            int i;
            O0000OOo O00000Oo = O00000Oo(O00000o.getName(), (Class) cls);
            inputStreamReader = new InputStreamReader(O00000o0);
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                i = 0;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
                try {
                    O0000O0o.O000000o(O00000Oo.O000000o, e);
                    O000000o(O00000o0);
                    O000000o(inputStreamReader);
                    O000000o(bufferedReader);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    O000000o(O00000o0);
                    O000000o(inputStreamReader);
                    O000000o(bufferedReader);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bufferedReader = null;
                O000000o(O00000o0);
                O000000o(inputStreamReader);
                O000000o(bufferedReader);
                throw e;
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    i++;
                    String str2 = O000000o;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("read file:");
                    stringBuilder2.append(i);
                    stringBuilder2.append(readLine);
                    Log.d(str2, stringBuilder2.toString());
                    if (!TextUtils.isEmpty(readLine)) {
                        try {
                            stringBuilder.append(readLine);
                        } catch (Exception e4) {
                            O0000O0o.O000000o(O00000Oo.O000000o, e4);
                        }
                    }
                }
                if (O00000Oo != null) {
                    O00000Oo.O000000o(stringBuilder.toString());
                }
                O000000o(O00000o0);
                O000000o(inputStreamReader);
                O000000o(bufferedReader);
                return O00000Oo;
            } catch (IOException e5) {
                e = e5;
                O0000O0o.O000000o(O00000Oo.O000000o, e);
                O000000o(O00000o0);
                O000000o(inputStreamReader);
                O000000o(bufferedReader);
                return null;
            }
        } catch (IOException e6) {
            e = e6;
            inputStreamReader = null;
            bufferedReader = inputStreamReader;
            O0000O0o.O000000o(O00000Oo.O000000o, e);
            O000000o(O00000o0);
            O000000o(inputStreamReader);
            O000000o(bufferedReader);
            return null;
        } catch (Throwable th3) {
            e = th3;
            inputStreamReader = null;
            bufferedReader = inputStreamReader;
            O000000o(O00000o0);
            O000000o(inputStreamReader);
            O000000o(bufferedReader);
            throw e;
        }
    }

    public boolean O000000o(String str, String str2) {
        Throwable e;
        File O00000Oo = O00000Oo(O000000o(), str2);
        boolean z = false;
        if (O00000Oo == null) {
            return false;
        }
        Closeable O000000o;
        O000000o o000000o = new O000000o(O00000Oo);
        Closeable closeable = null;
        try {
            O000000o = o000000o.O000000o(true);
        } catch (IOException e2) {
            O0000O0o.O000000o(O00000Oo.O000000o, e2);
            O00000Oo(O00000Oo.getName());
            O000000o = null;
        }
        if (O000000o == null) {
            return false;
        }
        Closeable closeable2;
        try {
            if (TextUtils.isEmpty(str)) {
                closeable2 = null;
            } else {
                BufferedWriter bufferedWriter;
                closeable2 = new OutputStreamWriter(O000000o);
                try {
                    bufferedWriter = new BufferedWriter(closeable2);
                } catch (IOException e3) {
                    e = e3;
                    try {
                        o000000o.O00000Oo(O000000o);
                        O0000O0o.O000000o(O00000Oo.O000000o, e);
                        O000000o(closeable);
                        O000000o(closeable2);
                        O000000o(O000000o);
                        return z;
                    } catch (Throwable th) {
                        e = th;
                    }
                }
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    o000000o.O000000o((FileOutputStream) O000000o);
                    z = true;
                    closeable = bufferedWriter;
                } catch (IOException e4) {
                    e = e4;
                    closeable = bufferedWriter;
                    o000000o.O00000Oo(O000000o);
                    O0000O0o.O000000o(O00000Oo.O000000o, e);
                    O000000o(closeable);
                    O000000o(closeable2);
                    O000000o(O000000o);
                    return z;
                } catch (Throwable th2) {
                    e = th2;
                    closeable = bufferedWriter;
                    O000000o(closeable);
                    O000000o(closeable2);
                    O000000o(O000000o);
                    throw e;
                }
            }
        } catch (IOException e5) {
            e = e5;
            closeable2 = null;
            o000000o.O00000Oo(O000000o);
            O0000O0o.O000000o(O00000Oo.O000000o, e);
            O000000o(closeable);
            O000000o(closeable2);
            O000000o(O000000o);
            return z;
        } catch (Throwable th3) {
            e = th3;
            closeable2 = null;
            O000000o(closeable);
            O000000o(closeable2);
            O000000o(O000000o);
            throw e;
        }
        O000000o(closeable);
        O000000o(closeable2);
        O000000o(O000000o);
        return z;
    }

    public boolean O00000Oo(String str) {
        File[] listFiles = O000000o().listFiles();
        int i = 0;
        boolean z = false;
        while (i < listFiles.length) {
            if (listFiles[i] != null && listFiles[i].getName().contains(str)) {
                z = listFiles[i].delete();
            }
            i++;
        }
        return z;
    }
}
