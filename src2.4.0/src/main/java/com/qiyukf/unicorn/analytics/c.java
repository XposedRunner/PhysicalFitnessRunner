package com.qiyukf.unicorn.analytics;

import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.basesdk.c.b;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

final class c {
    private static String a(File file) {
        return a(file, file.length());
    }

    private static String a(File file, long j) {
        IOException e;
        Throwable th;
        if (file == null || !file.exists()) {
            return null;
        }
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                long length = file.length() - j;
                j = 0;
                if (length >= 0) {
                    j = length;
                }
                byte[] bArr = new byte[((int) (file.length() - j))];
                fileInputStream.skip(j);
                fileInputStream.read(bArr);
                String str = new String(bArr, HttpUtils.ENCODING_UTF_8);
                a(fileInputStream);
                return str;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    a(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    a(fileInputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            a(fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            a(fileInputStream);
            throw th;
        }
    }

    public static void a() {
        com.qiyukf.basesdk.a.c a = a.a();
        if (a != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.a());
            stringBuilder.append("analytics/");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    a.a(a.a, "auto upload log start");
                    int i = 0;
                    int length = listFiles.length;
                    int i2 = 0;
                    while (i < length) {
                        File file2 = listFiles[i];
                        if (b.a(file2.getName())) {
                            if (file2.isDirectory()) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(file2.getPath());
                                stringBuilder2.append("/msg.log");
                                File file3 = new File(stringBuilder2.toString());
                                if (file3.exists()) {
                                    JSONObject a2 = b.a(a(file3));
                                    long c = b.c(a2, "time");
                                    String e = b.e(a2, "stack");
                                    String e2 = b.e(a2, "type");
                                    String e3 = b.e(a2, "version");
                                    int b = b.b(a2, "count");
                                    if (!TextUtils.isEmpty(e)) {
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append(file2.getPath());
                                        stringBuilder2.append("/log.log");
                                        if (com.qiyukf.unicorn.f.c.a(e3, e2, e, a(new File(stringBuilder2.toString())), b, c) == 200) {
                                            i2++;
                                            b(file2);
                                            b.a(file2.getName(), System.currentTimeMillis());
                                        }
                                    }
                                }
                            }
                            b(file2);
                        }
                        i++;
                    }
                    String str = a.a;
                    stringBuilder = new StringBuilder("auto upload ");
                    stringBuilder.append(i2);
                    stringBuilder.append(" logs");
                    a.a(str, stringBuilder.toString());
                }
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(String str, Throwable th, b bVar) {
        IOException e;
        Throwable th2;
        Closeable closeable = null;
        Closeable bufferedWriter;
        try {
            JSONObject a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("msg.log");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                a = b.a(a(file));
                b.a(a, "count", b.b(a, "count") + 1);
            } else {
                a = null;
            }
            if (a == null) {
                a = new JSONObject();
                b.a(a, "time", System.currentTimeMillis());
                b.a(a, "stack", Log.getStackTraceString(th).trim());
                b.a(a, "type", bVar.toString());
                b.a(a, "version", "4.5.2");
                b.a(a, "count", 1);
            }
            Closeable bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                bufferedWriter2.write(a.toString());
                bufferedWriter2.flush();
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("log.log");
                file = new File(stringBuilder.toString());
                if (!file.exists()) {
                    str = a(new File(a.a().b()), 51200);
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                    try {
                        bufferedWriter.write(str);
                        bufferedWriter.flush();
                        closeable = bufferedWriter;
                    } catch (IOException e2) {
                        e = e2;
                        closeable = bufferedWriter2;
                        try {
                            e.printStackTrace();
                            a(closeable);
                            a(bufferedWriter);
                        } catch (Throwable th3) {
                            th2 = th3;
                            a(closeable);
                            a(bufferedWriter);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        closeable = bufferedWriter2;
                        a(closeable);
                        a(bufferedWriter);
                        throw th2;
                    }
                }
                str = a.a;
                StringBuilder stringBuilder2 = new StringBuilder("save error log: ");
                stringBuilder2.append(th.getMessage());
                a.a(str, stringBuilder2.toString());
                a(bufferedWriter2);
                a(closeable);
            } catch (IOException e3) {
                e = e3;
                bufferedWriter = closeable;
                closeable = bufferedWriter2;
                e.printStackTrace();
                a(closeable);
                a(bufferedWriter);
            } catch (Throwable th5) {
                th2 = th5;
                bufferedWriter = closeable;
                closeable = bufferedWriter2;
                a(closeable);
                a(bufferedWriter);
                throw th2;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedWriter = null;
            e.printStackTrace();
            a(closeable);
            a(bufferedWriter);
        } catch (Throwable th6) {
            th2 = th6;
            bufferedWriter = null;
            a(closeable);
            a(bufferedWriter);
            throw th2;
        }
    }

    public static void b() {
        com.qiyukf.basesdk.a.c a = a.a();
        if (a != null) {
            a.a(a.a, "invite upload log start");
            File file = new File(a.b());
            if (file.exists()) {
                int a2 = com.qiyukf.unicorn.f.c.a("4.5.2", b.invite.toString(), "INVITE", a(file, 1048576), 0, System.currentTimeMillis());
                String str = a.a;
                StringBuilder stringBuilder = new StringBuilder("invite upload log ");
                stringBuilder.append(a2 == 200 ? "success" : "fail");
                a.a(str, stringBuilder.toString());
                return;
            }
            a.a(a.a, "invite upload log cancel because log file not exist");
        }
    }

    private static void b(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File b : listFiles) {
                    b(b);
                }
            }
            file.delete();
            return;
        }
        file.delete();
    }
}
