package com.taobao.dp.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    public static byte[] unZip(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
            while (zipInputStream.getNextEntry() != null) {
                byte[] bArr3 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = zipInputStream.read(bArr3, 0, bArr3.length);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr3 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    bArr2 = bArr3;
                } catch (Exception unused) {
                    return bArr3;
                }
            }
            zipInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception unused2) {
        }
        return bArr2;
    }

    public static byte[] zip(byte[] bArr) {
        Exception e;
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            ZipEntry zipEntry = new ZipEntry("zip");
            zipEntry.setSize((long) bArr.length);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(bArr);
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return bArr;
            } catch (Exception e2) {
                Exception exception = e2;
                bArr2 = bArr;
                e = exception;
                e.printStackTrace();
                return bArr2;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bArr2;
        }
    }
}
