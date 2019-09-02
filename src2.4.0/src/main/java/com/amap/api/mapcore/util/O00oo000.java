package com.amap.api.mapcore.util;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: UnZipFile */
public class O00oo000 {
    private O00000Oo O000000o;

    /* compiled from: UnZipFile */
    public interface O00000o0 {
        void O000000o();

        void O000000o(long j);
    }

    /* compiled from: UnZipFile */
    public static class O000000o {
        public boolean O000000o = false;
    }

    /* compiled from: UnZipFile */
    private static class O00000Oo {
        private String O000000o;
        private String O00000Oo;
        private O000000o O00000o = new O000000o();
        private O00Ooo00 O00000o0 = null;
        private String O00000oO;

        public O00000Oo(O00o0000 o00o0000, O00Ooo00 o00Ooo00) {
            this.O000000o = o00o0000.O000O00o();
            this.O00000Oo = o00o0000.O000O0OO();
            this.O00000o0 = o00Ooo00;
        }

        public String O000000o() {
            return this.O000000o;
        }

        public void O000000o(String str) {
            if (str.length() > 1) {
                this.O00000oO = str;
            }
        }

        public String O00000Oo() {
            return this.O00000Oo;
        }

        public O00Ooo00 O00000o() {
            return this.O00000o0;
        }

        public String O00000o0() {
            return this.O00000oO;
        }

        public O000000o O00000oO() {
            return this.O00000o;
        }

        public void O00000oo() {
            this.O00000o.O000000o = true;
        }
    }

    public O00oo000(O00o0000 o00o0000, O00Ooo00 o00Ooo00) {
        this.O000000o = new O00000Oo(o00o0000, o00Ooo00);
    }

    private static int O000000o(File file, ZipInputStream zipInputStream, long j, long j2, O00000o0 o00000o0, O000000o o000000o) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i;
            } else if (o000000o == null || !o000000o.O000000o) {
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && o00000o0 != null) {
                    long j3 = ((j + ((long) i)) * 100) / j2;
                    if (o000000o == null || !o000000o.O000000o) {
                        o00000o0.O000000o(j3);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i;
            }
        }
    }

    private static void O000000o(O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            final O00Ooo00 O00000o = o00000Oo.O00000o();
            if (O00000o != null) {
                O00000o.O0000o();
            }
            String O000000o = o00000Oo.O000000o();
            String O00000Oo = o00000Oo.O00000Oo();
            if (TextUtils.isEmpty(O000000o) || TextUtils.isEmpty(O00000Oo)) {
                if (o00000Oo.O00000oO().O000000o) {
                    if (O00000o != null) {
                        O00000o.O0000oO();
                    }
                } else if (O00000o != null) {
                    O00000o.O0000oO0();
                }
                return;
            }
            File file = new File(O000000o);
            if (file.exists()) {
                File file2 = new File(O00000Oo);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                AnonymousClass1 anonymousClass1 = new O00000o0() {
                    public void O000000o() {
                        if (O00000o != null) {
                            O00000o.O0000oO0();
                        }
                    }

                    public void O000000o(long j) {
                        try {
                            if (O00000o != null) {
                                O00000o.O000000o(j);
                            }
                        } catch (Exception unused) {
                        }
                    }
                };
                try {
                    if (o00000Oo.O00000oO().O000000o && O00000o != null) {
                        O00000o.O0000oO();
                    }
                    O000000o(file, file2, anonymousClass1, o00000Oo);
                    if (o00000Oo.O00000oO().O000000o) {
                        if (O00000o != null) {
                            O00000o.O0000oO();
                        }
                    } else if (O00000o != null) {
                        O00000o.O00000Oo(o00000Oo.O00000o0());
                    }
                } catch (Throwable unused) {
                    if (o00000Oo.O00000oO().O000000o) {
                        if (O00000o != null) {
                            O00000o.O0000oO();
                        }
                    } else if (O00000o != null) {
                        O00000o.O0000oO0();
                    }
                }
                return;
            }
            if (o00000Oo.O00000oO().O000000o) {
                if (O00000o != null) {
                    O00000o.O0000oO();
                }
            } else if (O00000o != null) {
                O00000o.O0000oO0();
            }
        }
    }

    private static void O000000o(File file) {
        file = file.getParentFile();
        if (!file.exists()) {
            O000000o(file);
            file.mkdir();
        }
    }

    private static void O000000o(File file, File file2, O00000o0 o00000o0, O00000Oo o00000Oo) throws Exception {
        Exception e;
        long j;
        FileInputStream fileInputStream;
        CheckedInputStream checkedInputStream;
        ZipInputStream zipInputStream;
        StringBuffer stringBuffer = new StringBuffer();
        O000000o O00000oO = o00000Oo.O00000oO();
        long j2 = 0;
        if (o00000o0 != null) {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
                ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
                while (true) {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry != null) {
                        if (O00000oO != null && O00000oO.O000000o) {
                            zipInputStream2.closeEntry();
                            zipInputStream2.close();
                            checkedInputStream2.close();
                            fileInputStream2.close();
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            if (!O000000o(nextEntry.getName())) {
                                o00000o0.O000000o();
                                break;
                            } else {
                                stringBuffer.append(nextEntry.getName());
                                stringBuffer.append(";");
                            }
                        }
                        long size = j2 + nextEntry.getSize();
                        try {
                            zipInputStream2.closeEntry();
                            j2 = size;
                        } catch (Exception e2) {
                            e = e2;
                            j2 = size;
                            e.printStackTrace();
                            j = j2;
                            fileInputStream = new FileInputStream(file);
                            checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                            zipInputStream = new ZipInputStream(checkedInputStream);
                            O000000o(file2, zipInputStream, j, o00000o0, O00000oO);
                            zipInputStream.close();
                            checkedInputStream.close();
                            fileInputStream.close();
                        }
                    }
                }
                o00000Oo.O000000o(stringBuffer.toString());
                zipInputStream2.close();
                checkedInputStream2.close();
                fileInputStream2.close();
            } catch (Exception e3) {
                e = e3;
            }
        }
        j = j2;
        fileInputStream = new FileInputStream(file);
        checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
        zipInputStream = new ZipInputStream(checkedInputStream);
        O000000o(file2, zipInputStream, j, o00000o0, O00000oO);
        zipInputStream.close();
        checkedInputStream.close();
        fileInputStream.close();
    }

    private static void O000000o(File file, ZipInputStream zipInputStream, long j, O00000o0 o00000o0, O000000o o000000o) throws Exception {
        O000000o o000000o2 = o000000o;
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            if (o000000o2 == null || !o000000o2.O000000o) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(file.getPath());
                stringBuilder.append(File.separator);
                stringBuilder.append(nextEntry.getName());
                String stringBuilder2 = stringBuilder.toString();
                if (O000000o(nextEntry.getName())) {
                    File file2 = new File(stringBuilder2);
                    O000000o(file2);
                    if (nextEntry.isDirectory()) {
                        file2.mkdirs();
                    } else {
                        i += O000000o(file2, zipInputStream, (long) i, j, o00000o0, o000000o2);
                    }
                    zipInputStream.closeEntry();
                } else {
                    if (o00000o0 != null) {
                        o00000o0.O000000o();
                    }
                    return;
                }
            }
            zipInputStream.closeEntry();
            return;
        }
    }

    private static boolean O000000o(String str) {
        return (str.contains("..") || str.contains(HttpUtils.PATHS_SEPARATOR) || str.contains("\\") || str.contains("%")) ? false : true;
    }

    public void O000000o() {
        if (this.O000000o != null) {
            this.O000000o.O00000oo();
        }
    }

    public void O00000Oo() {
        if (this.O000000o != null) {
            O000000o(this.O000000o);
        }
    }
}
