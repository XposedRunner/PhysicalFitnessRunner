package com.qiyukf.basesdk.a;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

final class b {
    static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    private static final SimpleDateFormat b = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private static final Set<String> c;

    static {
        HashSet hashSet = new HashSet();
        c = hashSet;
        hashSet.add("tmp_u_");
        c.add("tmp_c_");
    }

    static long a(File file) {
        IOException e;
        IOException iOException;
        StringBuilder stringBuilder;
        Throwable th;
        long length = file.length();
        Closeable randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            long j = length - 1;
            long j2 = 0;
            while (j2 <= j) {
                try {
                    long j3 = (j2 + j) / 2;
                    randomAccessFile.seek(j3);
                    short readShort = randomAccessFile.readShort();
                    if ((readShort >> 8) == 0) {
                        j = j3 - 1;
                    } else if ((readShort & 255) == 0) {
                        length = j3 + 1;
                        a(randomAccessFile);
                        return length;
                    } else {
                        j2 = j3 + 1;
                    }
                } catch (IOException e2) {
                    e = e2;
                    iOException = e;
                    try {
                        stringBuilder = new StringBuilder("init log file error: ");
                        stringBuilder.append(iOException);
                        Log.i("log", stringBuilder.toString());
                        a(randomAccessFile);
                        return length;
                    } catch (Throwable th2) {
                        th = th2;
                        a(randomAccessFile);
                        throw th;
                    }
                }
            }
            if (j2 == 0) {
                length = 0;
            }
            a(randomAccessFile);
            return length;
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
            iOException = e;
            stringBuilder = new StringBuilder("init log file error: ");
            stringBuilder.append(iOException);
            Log.i("log", stringBuilder.toString());
            a(randomAccessFile);
            return length;
        } catch (Throwable th22) {
            th = th22;
            randomAccessFile = null;
            a(randomAccessFile);
            throw th;
        }
    }

    static String a(String str, long j, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.format(new Date(j)));
        stringBuilder.append(": ");
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        if (th != null) {
            stringBuilder.append(Log.getStackTraceString(th));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    static MappedByteBuffer a(File file, long j, long j2) {
        IOException e;
        Throwable th;
        Object obj = (!file.exists() || file.length() < j + j2) ? 1 : null;
        Closeable randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            long j3 = j + j2;
            try {
                randomAccessFile.setLength(j3);
                if (randomAccessFile.length() < j3) {
                    a(randomAccessFile);
                    return null;
                }
                if (obj != null) {
                    a((RandomAccessFile) randomAccessFile, j, j2);
                }
                MappedByteBuffer map = randomAccessFile.getChannel().map(MapMode.READ_WRITE, j, j2);
                a(randomAccessFile);
                return map;
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    a(randomAccessFile);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    a(randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
            e.printStackTrace();
            a(randomAccessFile);
            return null;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            a(randomAccessFile);
            throw th;
        }
    }

    static Calendar a() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance;
    }

    private static void a(BufferedWriter bufferedWriter, String str) {
        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.flush();
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

    private static void a(File file, File file2, File file3) {
        Closeable bufferedReader;
        String readLine;
        long d;
        String readLine2;
        long d2;
        IOException e;
        BufferedWriter bufferedWriter;
        Throwable th;
        Closeable closeable = -1;
        Closeable closeable2 = null;
        if (file2 != null) {
            try {
                if (file2.exists()) {
                    bufferedReader = new BufferedReader(new FileReader(file2));
                    try {
                        readLine = bufferedReader.readLine();
                        d = d(readLine);
                        if (file3 == null && file3.exists()) {
                            closeable = new BufferedReader(new FileReader(file3));
                            try {
                                readLine2 = closeable.readLine();
                                d2 = d(readLine2);
                            } catch (IOException e2) {
                                e = e2;
                                bufferedWriter = null;
                                closeable2 = bufferedReader;
                                try {
                                    e.printStackTrace();
                                    a(closeable2);
                                    a(closeable);
                                    a(r9);
                                    d(file2);
                                    d(file3);
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = closeable2;
                                    closeable2 = bufferedWriter;
                                    a(bufferedReader);
                                    a(closeable);
                                    a(closeable2);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                a(bufferedReader);
                                a(closeable);
                                a(closeable2);
                                throw th;
                            }
                        }
                        d2 = -1;
                        closeable = null;
                        readLine2 = closeable;
                        bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                        while (true) {
                            if (d >= 0 && d2 < 0) {
                                break;
                            } else if (d != 0 || d2 < 0 || (d > 0 && d <= d2)) {
                                a(bufferedWriter, readLine);
                                readLine = bufferedReader.readLine();
                                d = d(readLine);
                            } else if (d2 == 0 || d < 0 || (d2 > 0 && d > d2)) {
                                try {
                                    a(bufferedWriter, readLine2);
                                    readLine2 = closeable.readLine();
                                    d2 = d(readLine2);
                                } catch (IOException e3) {
                                    e = e3;
                                    closeable2 = bufferedReader;
                                    e.printStackTrace();
                                    a(closeable2);
                                    a(closeable);
                                    a(r9);
                                    d(file2);
                                    d(file3);
                                } catch (Throwable th4) {
                                    th = th4;
                                    closeable2 = bufferedWriter;
                                    a(bufferedReader);
                                    a(closeable);
                                    a(closeable2);
                                    throw th;
                                }
                            }
                        }
                        a(bufferedReader);
                    } catch (IOException e4) {
                        e = e4;
                        closeable = null;
                        bufferedWriter = closeable;
                        closeable2 = bufferedReader;
                        e.printStackTrace();
                        a(closeable2);
                        a(closeable);
                        a(r9);
                        d(file2);
                        d(file3);
                    } catch (Throwable th5) {
                        th = th5;
                        closeable = null;
                        a(bufferedReader);
                        a(closeable);
                        a(closeable2);
                        throw th;
                    }
                    a(closeable);
                    a(r9);
                    d(file2);
                    d(file3);
                }
            } catch (IOException e5) {
                e = e5;
                closeable = null;
                bufferedWriter = closeable;
                e.printStackTrace();
                a(closeable2);
                a(closeable);
                a(r9);
                d(file2);
                d(file3);
            } catch (Throwable th6) {
                th = th6;
                closeable = null;
                bufferedReader = closeable;
                a(bufferedReader);
                a(closeable);
                a(closeable2);
                throw th;
            }
        }
        d = -1;
        bufferedReader = null;
        readLine = bufferedReader;
        if (file3 == null) {
        }
        d2 = -1;
        closeable = null;
        readLine2 = closeable;
        bufferedWriter = new BufferedWriter(new FileWriter(file, true));
        while (true) {
            if (d >= 0) {
            }
            if (d != 0) {
            }
            a(bufferedWriter, readLine);
            readLine = bufferedReader.readLine();
            d = d(readLine);
        }
        a(bufferedReader);
        a(closeable);
        a(r9);
        d(file2);
        d(file3);
    }

    private static void a(RandomAccessFile randomAccessFile, long j, long j2) {
        randomAccessFile.seek(j);
        byte[] bArr = new byte[65536];
        int i = 0;
        while (true) {
            long j3 = (long) i;
            if (j3 < j2) {
                randomAccessFile.write(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, j2 - j3));
                i += 65536;
            } else {
                randomAccessFile.seek(0);
                return;
            }
        }
    }

    static void a(String str) {
        IOException e;
        Throwable th;
        Throwable th2;
        File file = new File(str);
        if (file.length() >= 8388608) {
            Closeable fileInputStream;
            Closeable fileOutputStream;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".tmp");
            File file2 = new File(stringBuilder.toString());
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        channel.position(file.length() - 4194304);
                        fileOutputStream.getChannel().transferFrom(channel, 0, 4194304);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    fileOutputStream = null;
                    e = iOException;
                    try {
                        e.printStackTrace();
                        a(fileInputStream);
                        a(fileOutputStream);
                        file2.renameTo(file);
                    } catch (Throwable th3) {
                        th = th3;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    fileOutputStream = null;
                    th = th2;
                    a(fileInputStream);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (IOException e4) {
                fileOutputStream = null;
                e = e4;
                fileInputStream = fileOutputStream;
                e.printStackTrace();
                a(fileInputStream);
                a(fileOutputStream);
                file2.renameTo(file);
            } catch (Throwable th5) {
                th2 = th5;
                fileInputStream = null;
                fileOutputStream = fileInputStream;
                th = th2;
                a(fileInputStream);
                a(fileOutputStream);
                throw th;
            }
            a(fileInputStream);
            a(fileOutputStream);
            if (file2.exists() && file.delete()) {
                file2.renameTo(file);
            }
        }
    }

    private static void a(String str, final boolean z) {
        final Calendar a = a();
        File file = new File(str);
        File[] listFiles = file.getParentFile().listFiles(new FileFilter() {
            public final boolean accept(File file) {
                long b = b.c(file);
                return z ? b > 0 : b > 0 && b < a.getTimeInMillis();
            }
        });
        if (listFiles.length != 0) {
            List asList = Arrays.asList(listFiles);
            Collections.sort(asList, new Comparator<File>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    long b = b.c((File) obj) - b.c((File) obj2);
                    return b > 0 ? 1 : b < 0 ? -1 : 0;
                }
            });
            int i = 0;
            while (i < asList.size()) {
                if (i == asList.size() - 1) {
                    a(file, (File) asList.get(i), null);
                    return;
                }
                File file2 = (File) asList.get(i);
                int i2 = i + 1;
                File file3 = (File) asList.get(i2);
                if (c(file2) == c(file3)) {
                    a(file, file2, file3);
                    i += 2;
                } else {
                    a(file, file2, null);
                    i = i2;
                }
            }
        }
    }

    static void b(String str) {
        a(str, false);
    }

    private static long c(File file) {
        long j = -1;
        if (file.isDirectory()) {
            return -1;
        }
        String name = file.getName();
        if (name.length() < 8) {
            return -1;
        }
        String substring = name.substring(0, name.length() - 8);
        if (!c.contains(substring)) {
            return -1;
        }
        try {
            j = a.parse(name.substring(substring.length())).getTime();
        } catch (ParseException unused) {
        }
        return j;
    }

    static void c(String str) {
        a(str, true);
    }

    private static long d(String str) {
        if (str == null) {
            return -1;
        }
        if (!TextUtils.isEmpty(str) && str.charAt(0) == 0) {
            return -1;
        }
        long j = 0;
        int indexOf = str.indexOf(": ");
        if (indexOf == 18) {
            try {
                j = b.parse(str.substring(0, indexOf)).getTime();
            } catch (ParseException unused) {
            }
        }
        return j;
    }

    private static boolean d(File file) {
        return file != null && file.exists() && file.delete();
    }
}
