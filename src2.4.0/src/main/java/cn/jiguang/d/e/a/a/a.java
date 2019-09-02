package cn.jiguang.d.e.a.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JResponse;
import cn.jiguang.d.e.a.b;
import cn.jiguang.d.e.a.c;
import cn.jiguang.d.e.a.d;
import cn.jiguang.d.e.a.e;
import cn.jiguang.d.e.a.f;
import cn.jiguang.d.e.a.g;
import java.nio.ByteBuffer;

public final class a {
    public static JResponse a(c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            return null;
        }
        switch (cVar.c) {
            case 0:
                return new f(cVar, byteBuffer);
            case 1:
                return new e(cVar, byteBuffer);
            case 19:
                return new cn.jiguang.d.e.a.a(cVar, byteBuffer);
            case 25:
                return new c(cVar, byteBuffer);
            case 26:
                return new g(cVar, byteBuffer);
            case 30:
            case 32:
                return new b(cVar, byteBuffer);
            default:
                return null;
        }
    }

    public static JResponse a(byte[] bArr) {
        d b = b(bArr);
        return b != null ? a(b.a(), b.b()) : null;
    }

    public static d a(byte[] bArr, String str) {
        String str2;
        if (bArr.length < 20) {
            str2 = "JCommands";
            str = "Error: received body-length short than common head-length, return null";
        } else {
            byte[] bArr2 = new byte[20];
            System.arraycopy(bArr, 0, bArr2, 0, 20);
            c cVar = new c(false, bArr2);
            int i = cVar.a - 20;
            if (i < 0 || bArr.length < 20) {
                str2 = "JCommands";
                str = "Error: totalBytes length error with no encrypted, return null";
            } else {
                ByteBuffer wrap;
                byte[] bArr3 = new byte[i];
                System.arraycopy(bArr, 20, bArr3, 0, i);
                if (TextUtils.isEmpty(str)) {
                    System.arraycopy(bArr, 20, bArr3, 0, i);
                    wrap = ByteBuffer.wrap(bArr3);
                } else {
                    try {
                        wrap = ByteBuffer.wrap(cn.jiguang.d.h.a.a.b(str, bArr3));
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return new d(cVar, wrap);
            }
        }
        cn.jiguang.e.c.c(str2, str);
        return null;
    }

    public static boolean a(Context context, byte[] bArr) {
        try {
            d b = b(bArr);
            if (b != null) {
                long c = cn.jiguang.d.a.d.c(context);
                long j = b.a().f;
                if (c == 0 || j == 0 || c == j) {
                    cn.jiguang.d.d.b.a();
                    cn.jiguang.d.d.b.a(context, b.a(), b.b());
                } else {
                    cn.jiguang.d.f.a.a().a(context, j, bArr);
                }
                return true;
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("dispatchMessage error:");
            stringBuilder.append(th.getMessage());
            cn.jiguang.e.c.c("JCommands", stringBuilder.toString());
        }
        return false;
    }

    public static d b(byte[] bArr) {
        if (bArr.length < 20) {
            cn.jiguang.e.c.c("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        int i = bArr2[0] & 128;
        c cVar = new c(false, bArr2);
        int i2 = cVar.a - 20;
        if (i2 < 0 || bArr.length < 20) {
            cn.jiguang.e.c.c("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        ByteBuffer wrap;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 20, bArr3, 0, i2);
        if (i > 0) {
            try {
                wrap = ByteBuffer.wrap(cn.jiguang.d.h.a.a.b(cn.jiguang.d.h.a.a.b(), bArr3));
            } catch (Exception unused) {
                return null;
            }
        }
        System.arraycopy(bArr, 20, bArr3, 0, i2);
        wrap = ByteBuffer.wrap(bArr3);
        return new d(cVar, wrap);
    }
}
