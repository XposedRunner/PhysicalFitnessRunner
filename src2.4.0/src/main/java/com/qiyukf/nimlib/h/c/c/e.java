package com.qiyukf.nimlib.h.c.c;

import java.nio.ByteBuffer;
import java.util.zip.Inflater;

public final class e {
    public static ByteBuffer a(f fVar) {
        int e = fVar.e();
        if (e < 0 || e >= 10485760) {
            StringBuilder stringBuilder = new StringBuilder("invalid uncompress len:");
            stringBuilder.append(e);
            throw new g(stringBuilder.toString());
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(e);
            Inflater inflater = new Inflater();
            ByteBuffer b = fVar.b();
            inflater.setInput(b.array(), b.position(), b.limit() - b.position());
            allocate.position(inflater.inflate(allocate.array()));
            inflater.end();
            allocate.flip();
            return allocate;
        } catch (Exception unused) {
            throw new g("uncompress error");
        }
    }
}
