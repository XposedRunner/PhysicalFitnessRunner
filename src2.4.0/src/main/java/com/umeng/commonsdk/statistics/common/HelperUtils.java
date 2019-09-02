package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class HelperUtils {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String TAG = "helper";

    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(bytes);
            bytes = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bytes[i])}));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    public static boolean checkStrLen(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && str.length() <= i) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String getFileMD5(File file) {
        byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        try {
            if (!file.isFile()) {
                return "";
            }
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    BigInteger bigInteger = new BigInteger(1, instance.digest());
                    return String.format("%1$032x", new Object[]{bigInteger});
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMD5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString((b & 255) | -256).substring(6));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            MLog.i(TAG, "getMD5 error", e);
            return "";
        }
    }

    public static String getUmengMD5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(255 & b));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            MLog.i(TAG, "getMD5 error", e);
            return "";
        }
    }

    public static String readFile(File file) {
        Throwable th;
        InputStream fileInputStream;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    String str = new String(bArr);
                    safeClose(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    safeClose(fileInputStream);
                    throw th;
                }
            }
            safeClose(null);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            safeClose(fileInputStream);
            throw th;
        }
    }

    public static byte[] readStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static String subStr(String str, int i) {
        Throwable e;
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String substring = str.substring(0, str.length() < i ? str.length() : i);
                try {
                    int length = substring.getBytes("UTF-8").length;
                    String str3 = substring;
                    int i2 = i;
                    while (length > i) {
                        i2--;
                        try {
                            str2 = str.substring(0, i2 > str.length() ? str.length() : i2);
                            str3 = str2;
                            length = str2.getBytes("UTF-8").length;
                        } catch (Exception e2) {
                            e = e2;
                            str2 = str3;
                            MLog.e(e);
                            return str2;
                        }
                    }
                    return str3;
                } catch (Exception e3) {
                    e = e3;
                    str2 = substring;
                    MLog.e(e);
                    return str2;
                }
            }
        } catch (Exception e4) {
            e = e4;
            MLog.e(e);
            return str2;
        }
        return str2;
    }

    public static void writeFile(File file, String str) throws IOException {
        writeFile(file, str.getBytes());
    }

    public static void writeFile(File file, byte[] bArr) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            safeClose(fileOutputStream);
        }
    }
}
