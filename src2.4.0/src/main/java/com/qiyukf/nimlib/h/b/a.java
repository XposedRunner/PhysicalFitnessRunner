package com.qiyukf.nimlib.h.b;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.nimlib.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;

public final class a {
    int a;
    PublicKey b;

    public static a a(Context context) {
        a aVar = new a();
        File file = new File(b());
        try {
            InputStream fileInputStream = file.exists() ? new FileInputStream(file) : null;
            if (fileInputStream == null || !aVar.a(fileInputStream, true)) {
                aVar.a(context.getAssets().open(a(true)), false);
            }
        } catch (Exception unused) {
        }
        return aVar;
    }

    private static String a(boolean z) {
        if (!d.e()) {
            return d.b() ? z ? "keystore_unicorn2" : "bbgsvirgin2" : z ? "keystore_unicorn" : "bbgsvirgin";
        } else {
            Object obj = (d.e() && com.qiyukf.basesdk.a.d().test) ? 1 : null;
            return obj != null ? "bbgsvirgin3" : "bbgsvirgin4";
        }
    }

    public static void a() {
        c();
    }

    public static void a(int i, byte[] bArr, long j) {
        if (bArr != null && a(bArr, j)) {
            try {
                bArr = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(bArr), new BigInteger("10001", 16))).getEncoded();
                ByteBuffer allocate = ByteBuffer.allocate(12 + bArr.length);
                allocate.putLong(j);
                allocate.putInt(i);
                allocate.put(bArr);
                File file = new File(b());
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(b()));
                fileOutputStream.write(allocate.array(), 0, allocate.capacity());
                fileOutputStream.close();
            } catch (Exception e) {
                c();
                e.printStackTrace();
            }
        }
    }

    private boolean a(InputStream inputStream, boolean z) {
        byte[] bArr = new byte[256];
        try {
            int read = inputStream.read(bArr);
            long j = 0;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (z) {
                j = wrap.getLong();
                read -= 8;
            }
            this.a = wrap.getInt();
            if (this.a < 0) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                return false;
            }
            byte[] bArr2 = new byte[(read - 4)];
            wrap.get(bArr2);
            this.b = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
            if (!z || a(((RSAPublicKey) this.b).getModulus().toByteArray(), j)) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                return true;
            }
            c();
            this.b = null;
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            return false;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused5) {
            }
            throw th;
        }
    }

    private static boolean a(byte[] bArr, long j) {
        if (bArr == null) {
            return false;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, bArr.length);
        return j == crc32.getValue();
    }

    private static String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.qiyukf.nimlib.a.b);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(a(false));
        return stringBuilder.toString();
    }

    private static void c() {
        new File(b()).delete();
    }
}
