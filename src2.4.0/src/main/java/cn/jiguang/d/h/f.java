package cn.jiguang.d.h;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.google.zxing.common.StringUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class f {
    public static File a(Context context, String str) {
        if (context != null) {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                return new File(filesDir, str);
            }
        }
        return null;
    }

    public static File a(File[] fileArr) {
        File file = null;
        if (fileArr != null) {
            if (fileArr.length == 0) {
                return null;
            }
            for (File file2 : fileArr) {
                if (file2.lastModified() > (file != null ? file.lastModified() : 0)) {
                    file = file2;
                }
            }
        }
        return file;
    }

    public static ArrayList<String> a(InputStream inputStream) {
        Closeable bufferedReader;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, HttpUtils.ENCODING_UTF_8), 2048);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    readLine = readLine.trim();
                    if (!"".equals(readLine)) {
                        arrayList.add(readLine);
                    }
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    th = th2;
                    cn.jiguang.g.f.a(bufferedReader);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            cn.jiguang.g.f.a(bufferedReader);
            throw th;
        }
        cn.jiguang.g.f.a(bufferedReader);
        return arrayList;
    }

    public static void a(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static void a(File file, ZipOutputStream zipOutputStream, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str.trim().length() == 0 ? "" : File.separator);
        stringBuilder.append(file.getName());
        String str2 = new String(stringBuilder.toString().getBytes("8859_1"), StringUtils.GB2312);
        int i = 0;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    a(listFiles[i], zipOutputStream, str2);
                    i++;
                }
            }
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(str2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read != -1) {
                zipOutputStream.write(bArr, 0, read);
            } else {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            a(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public static boolean a(File file, Object obj) {
        Throwable th;
        if (file == null || file.isDirectory()) {
            return false;
        }
        Closeable objectOutputStream;
        Closeable closeable = null;
        try {
            e(file);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        } catch (Throwable th2) {
            th = th2;
            cn.jiguang.g.f.a(closeable);
            throw th;
        }
        try {
            objectOutputStream.writeObject(obj);
            cn.jiguang.g.f.a(objectOutputStream);
            return true;
        } catch (Throwable th3) {
            th = th3;
            closeable = objectOutputStream;
            cn.jiguang.g.f.a(closeable);
            throw th;
        }
    }

    public static boolean a(File file, String str) {
        byte[] bytes;
        if (str != null) {
            try {
                bytes = str.getBytes(HttpUtils.ENCODING_UTF_8);
            } catch (Throwable unused) {
                return false;
            }
        }
        bytes = null;
        return a(file, bytes);
    }

    private static boolean a(File file, byte[] bArr) {
        Throwable th;
        if (file == null || file.isDirectory()) {
            return false;
        }
        Closeable closeable = null;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.g.f.a(closeable);
                throw th;
            }
        }
        e(file);
        Closeable fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            cn.jiguang.g.f.a(fileOutputStream);
            return true;
        } catch (Throwable th3) {
            th = th3;
            closeable = fileOutputStream;
            cn.jiguang.g.f.a(closeable);
            throw th;
        }
    }

    public static File[] a(File file, FileFilter fileFilter) {
        return (file != null && file.exists() && file.isDirectory()) ? file.listFiles(fileFilter) : null;
    }

    public static File[] a(File file, boolean z) {
        return (file != null && file.exists() && file.isDirectory()) ? file.listFiles(new g(z)) : null;
    }

    public static File[] a(String str, boolean z) {
        try {
            return a(new File(str), z);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(File file) {
        byte[] f = f(file);
        if (f == null) {
            return null;
        }
        try {
            return new String(f, HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:18:0x002a, code skipped:
            return null;
     */
    public static java.lang.Object c(java.io.File r3) {
        /*
        r0 = 0;
        if (r3 == 0) goto L_0x002a;
    L_0x0003:
        r1 = r3.exists();
        if (r1 == 0) goto L_0x002a;
    L_0x0009:
        r1 = r3.isDirectory();
        if (r1 == 0) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r1 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x0025 }
        r2 = new java.io.FileInputStream;	 Catch:{ all -> 0x0025 }
        r2.<init>(r3);	 Catch:{ all -> 0x0025 }
        r1.<init>(r2);	 Catch:{ all -> 0x0025 }
        r3 = r1.readObject();	 Catch:{ all -> 0x0022 }
        cn.jiguang.g.f.a(r1);
        return r3;
    L_0x0022:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0026;
    L_0x0025:
        r3 = move-exception;
    L_0x0026:
        cn.jiguang.g.f.a(r0);
        throw r3;
    L_0x002a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.h.f.c(java.io.File):java.lang.Object");
    }

    public static void d(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        d(file2);
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    private static void e(File file) {
        if (file != null && !file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (Throwable unused) {
            }
        }
    }

    private static byte[] f(File file) {
        Throwable th;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                cn.jiguang.g.f.a(fileInputStream);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                cn.jiguang.g.f.a(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            cn.jiguang.g.f.a(fileInputStream);
            throw th;
        }
    }
}
