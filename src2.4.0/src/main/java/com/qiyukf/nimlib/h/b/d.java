package com.qiyukf.nimlib.h.b;

import android.content.Context;
import android.support.v4.media.TransportMediator;
import com.qiyukf.basesdk.sdk.ResponseCode;
import com.qiyukf.nimlib.h.c.c.e;
import com.qiyukf.nimlib.h.c.c.f;
import com.qiyukf.nimlib.h.c.c.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.zip.Deflater;

public final class d {
    private Context a;
    private b b;
    private boolean c;
    private com.qiyukf.nimlib.a.c.a.a d;
    private a e;
    private c f;
    private d g;

    public interface b {
        void a();

        void a(com.qiyukf.nimlib.a.c.a.a aVar, boolean z);
    }

    private class a {
        private final byte[] b;
        private final com.qiyukf.nimlib.h.c.a.a c = new com.qiyukf.nimlib.h.c.a.a(this.b);
        private final com.qiyukf.nimlib.h.c.a.a d = new com.qiyukf.nimlib.h.c.a.a(this.b);

        a() {
            byte[] bArr = new byte[16];
            new SecureRandom(SecureRandom.getSeed(32)).nextBytes(bArr);
            this.b = bArr;
        }

        public final void a(byte[] bArr, int i, int i2) {
            this.d.a(bArr, i, i2);
        }
    }

    private class c {
        private final a b;
        private final PublicKey c;

        public c(a aVar, PublicKey publicKey) {
            this.b = aVar;
            this.c = publicKey;
        }

        public final com.qiyukf.nimlib.a.c.a.a a(com.qiyukf.nimlib.a.c.a.a aVar) {
            byte[] bArr;
            if (aVar == null) {
                bArr = null;
            } else {
                com.qiyukf.nimlib.h.c.c.b bVar = new com.qiyukf.nimlib.h.c.c.b();
                bVar.b(this.b.b);
                bVar.a(d.a(aVar, false).b());
                bArr = com.qiyukf.nimlib.h.c.a.b.a(this.c, bVar.b().array(), 0, bVar.a());
            }
            com.qiyukf.nimlib.h.a.b.a aVar2 = new com.qiyukf.nimlib.h.a.b.a(d.this.e.a, bArr);
            return new com.qiyukf.nimlib.a.c.a.a(aVar2.a(), aVar2.b().b());
        }

        public final com.qiyukf.nimlib.h.c.c.b a(com.qiyukf.nimlib.a.c.a.a aVar, boolean z) {
            com.qiyukf.nimlib.h.c.c.b a = d.a(aVar, true);
            StringBuilder stringBuilder = new StringBuilder("send ");
            stringBuilder.append(aVar.a);
            com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
            if (!z) {
                this.b.c.a(a.b().array(), 0, a.a());
            }
            return a;
        }
    }

    private class d {
        private final a b;
        private final byte[] c = new byte[4];
        private int d;

        d(a aVar) {
            this.b = aVar;
            this.d = -1;
        }

        /* Access modifiers changed, original: final */
        public final void a() {
            this.d = -1;
        }

        /* Access modifiers changed, original: final */
        public final byte[] a(ByteBuffer byteBuffer) {
            if (this.d <= 5) {
                if (byteBuffer.remaining() < 4) {
                    return null;
                }
                byteBuffer.get(this.c);
                this.b.a(this.c, 0, 4);
                byte[] bArr = this.c;
                int i = 1;
                int i2 = 0;
                int i3 = i2;
                byte b;
                do {
                    b = bArr[i2];
                    i3 += (b & TransportMediator.KEYCODE_MEDIA_PAUSE) * i;
                    i <<= 7;
                    i2++;
                } while ((b & 128) != 0);
                this.d = i3;
                if (this.d <= 5) {
                    this.d = -1;
                    throw new g();
                }
                this.d += com.qiyukf.nimlib.h.c.c.d.b(this.d);
            }
            com.qiyukf.basesdk.a.a.b("core", String.format("received packetSize: %d, readableBytes: %d", new Object[]{Integer.valueOf(this.d), Integer.valueOf(byteBuffer.remaining())}));
            int i4 = this.d - 4;
            if (byteBuffer.remaining() < i4) {
                return null;
            }
            byte[] bArr2 = new byte[this.d];
            System.arraycopy(this.c, 0, bArr2, 0, 4);
            byteBuffer.get(bArr2, 4, i4);
            this.b.a(bArr2, 4, i4);
            this.d = -1;
            return bArr2;
        }
    }

    public d(Context context, b bVar) {
        this.a = context.getApplicationContext();
        this.b = bVar;
        c();
    }

    static /* synthetic */ com.qiyukf.nimlib.h.c.c.b a(com.qiyukf.nimlib.a.c.a.a aVar, boolean z) {
        com.qiyukf.nimlib.h.c.c.b bVar = new com.qiyukf.nimlib.h.c.c.b();
        int limit = aVar.b.limit();
        ByteBuffer byteBuffer = aVar.b;
        if (z && limit >= 1024 && !aVar.a.c()) {
            ByteBuffer byteBuffer2 = aVar.b;
            byte[] array = byteBuffer2.array();
            int position = byteBuffer2.position();
            int limit2 = byteBuffer2.limit() - byteBuffer2.position();
            byte[] bArr = new byte[(((limit2 + 4) + (limit2 / 1000)) + 12)];
            Deflater deflater = new Deflater();
            deflater.setInput(array, position, limit2);
            deflater.finish();
            limit = deflater.deflate(bArr);
            deflater.end();
            byteBuffer = ByteBuffer.allocate(limit + 4);
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putInt(limit2);
            byteBuffer.put(bArr, 0, limit);
            byteBuffer.flip();
            limit = byteBuffer.limit();
            aVar.a.e();
        }
        com.qiyukf.nimlib.h.c.a aVar2 = aVar.a;
        int i = 5;
        if (aVar.a.d()) {
            i = 7;
        }
        aVar2.a(i + limit);
        bVar.a(aVar.a);
        bVar.a(byteBuffer);
        return bVar;
    }

    private void c() {
        this.e = a.a(this.a);
        this.f = null;
        this.g = null;
        this.c = false;
    }

    public final com.qiyukf.nimlib.a.d.a.a a(ByteBuffer byteBuffer) {
        if (this.g == null) {
            return null;
        }
        byte[] a = this.g.a(byteBuffer);
        if (a == null) {
            return null;
        }
        f fVar = new f(a);
        com.qiyukf.nimlib.h.c.b.a aVar = new com.qiyukf.nimlib.h.c.a();
        fVar.a(aVar);
        StringBuilder stringBuilder = new StringBuilder("received ");
        stringBuilder.append(aVar);
        com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
        if (aVar.c()) {
            f fVar2 = new f(e.a(fVar));
            aVar.f();
            fVar = fVar2;
        }
        com.qiyukf.nimlib.a.d.a.a aVar2 = new com.qiyukf.nimlib.a.d.a.a();
        aVar2.a = aVar;
        aVar2.b = fVar;
        if (aVar2.a.g() == (byte) 1 && aVar2.a.h() == (byte) 1) {
            com.qiyukf.nimlib.h.a.c.a aVar3 = new com.qiyukf.nimlib.h.a.c.a();
            aVar3.a(aVar2.a);
            short e = aVar3.e();
            if (e == (short) 201) {
                try {
                    aVar3.a(aVar2.b);
                    a.a(aVar3.f(), aVar3.g(), aVar3.h());
                    c();
                    StringBuilder stringBuilder2 = new StringBuilder("public key updated to: ");
                    stringBuilder2.append(aVar3.f());
                    com.qiyukf.basesdk.a.a.a("core", stringBuilder2.toString());
                    if (this.b != null) {
                        this.b.a(this.d, true);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (e != ResponseCode.RES_SUCCESS) {
                stringBuilder = new StringBuilder("Handshake fail[code=");
                stringBuilder.append(aVar3.a().j());
                stringBuilder.append("]");
                com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
                a.a();
                if (this.b != null) {
                    this.b.a();
                }
            } else if (this.b != null) {
                this.b.a(this.d, false);
            }
            this.d = null;
            return null;
        } else if (aVar2.a.i() >= (short) 0 && aVar2.a.k() >= (byte) 0) {
            return aVar2;
        } else {
            throw new g("invalid headers, connection may be corrupted");
        }
    }

    public final com.qiyukf.nimlib.h.c.c.b a(com.qiyukf.nimlib.a.c.a.a aVar) {
        if (this.c) {
            return this.f.a(aVar, false);
        }
        this.c = true;
        this.d = aVar;
        return this.f.a(this.f.a(aVar), true);
    }

    public final void a() {
        a aVar = new a();
        this.f = new c(aVar, this.e.b);
        this.g = new d(aVar);
        this.c = false;
    }

    public final void b() {
        if (this.g != null) {
            this.g.a();
        }
    }
}
