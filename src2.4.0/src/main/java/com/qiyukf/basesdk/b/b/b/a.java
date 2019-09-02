package com.qiyukf.basesdk.b.b.b;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class a extends com.qiyukf.basesdk.b.b.c.a {
    private ByteBuffer b;

    protected a() {
    }

    private void b(ByteBuffer byteBuffer, List<Object> list) {
        while (byteBuffer.remaining() > 0) {
            try {
                int size = list.size();
                int remaining = byteBuffer.remaining();
                a(byteBuffer, list);
                if (size == list.size()) {
                    if (remaining == byteBuffer.remaining()) {
                        return;
                    }
                } else if (remaining == byteBuffer.remaining()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(getClass().getSimpleName());
                    stringBuilder.append(".decode() did not read anything but decoded a message.");
                    throw new b(stringBuilder.toString());
                }
            } catch (b e) {
                throw e;
            } catch (Throwable th) {
                b bVar = new b(th);
            }
        }
    }

    public final void a(Object obj) {
        if (obj instanceof ByteBuffer) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            try {
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                byteBuffer.flip();
                if (this.b == null) {
                    this.b = byteBuffer;
                } else {
                    if (this.b.capacity() - this.b.limit() < byteBuffer.remaining()) {
                        int remaining = byteBuffer.remaining();
                        ByteBuffer byteBuffer2 = this.b;
                        this.b = ByteBuffer.allocate(byteBuffer2.remaining() + remaining);
                        this.b.put(byteBuffer2);
                        this.b.flip();
                    }
                    this.b.position(this.b.limit()).limit(this.b.capacity());
                    this.b.put(byteBuffer);
                    this.b.flip();
                }
                b(this.b, arrayList);
                if (this.b != null && this.b.remaining() <= 0) {
                    this.b = null;
                }
                int size = arrayList.size();
                while (i < size) {
                    super.a(arrayList.get(i));
                    i++;
                }
            } catch (b e) {
                throw e;
            } catch (Throwable th) {
                if (this.b != null && this.b.remaining() <= 0) {
                    this.b = null;
                }
                int size2 = arrayList.size();
                while (i < size2) {
                    super.a(arrayList.get(i));
                    i++;
                }
            }
        } else {
            super.a(obj);
        }
    }

    public abstract void a(ByteBuffer byteBuffer, List<Object> list);

    public void h() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int size;
        try {
            ByteBuffer byteBuffer;
            if (this.b != null) {
                b(this.b, arrayList);
                byteBuffer = this.b;
            } else {
                byteBuffer = ByteBuffer.allocate(0);
            }
            a(byteBuffer, arrayList);
            if (this.b != null) {
                this.b = null;
            }
            size = arrayList.size();
            while (i < size) {
                super.a(arrayList.get(i));
                i++;
            }
            super.h();
        } catch (b e) {
            throw e;
        } catch (Exception e2) {
            throw new b(e2);
        } catch (Throwable th) {
            if (this.b != null) {
                this.b = null;
            }
            size = arrayList.size();
            while (i < size) {
                super.a(arrayList.get(i));
                i++;
            }
            super.h();
        }
    }

    public final void i() {
        super.i();
    }
}
