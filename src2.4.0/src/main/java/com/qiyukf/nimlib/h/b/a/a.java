package com.qiyukf.nimlib.h.b.a;

import com.qiyukf.nimlib.h.b.d;
import com.qiyukf.nimlib.h.c.c.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class a extends com.qiyukf.basesdk.b.b.b.a {
    private d b;

    public a(d dVar) {
        this.b = dVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(ByteBuffer byteBuffer, List<Object> list) {
        byteBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.remaining() > 0) {
            try {
                com.qiyukf.nimlib.a.d.a.a a = this.b.a(byteBuffer);
                if (a != null) {
                    list.add(a);
                } else {
                    return;
                }
            } catch (g e) {
                e.printStackTrace();
                com.qiyukf.basesdk.a.a.a("netty", "on decode exception");
                byteBuffer.clear();
                this.a.f().e();
            }
        }
    }

    public final void h() {
        super.h();
        this.b.b();
    }
}
