package cn.jiguang.d.e.a;

import android.support.v4.view.PointerIconCompat;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.a;
import cn.jiguang.d.e.a.a.c;
import java.nio.ByteBuffer;

public final class e extends JResponse {
    int a;
    int b;
    String c;
    int d;
    int e;
    String f;

    public e(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final int a() {
        return this.d;
    }

    public final String getName() {
        return "LoginResponse";
    }

    public final int getSid() {
        return this.a;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.e = -1;
        if (this.code == 0) {
            this.a = ByteBufferUtils.getInt(byteBuffer, this);
            this.b = ByteBufferUtils.getShort(byteBuffer, this);
            this.c = ProtocolUtil.getTlv2(byteBuffer, this);
            this.d = ByteBufferUtils.getInt(byteBuffer, this);
            try {
                this.e = byteBuffer.get();
            } catch (Throwable unused) {
            }
        } else if (this.code == PointerIconCompat.TYPE_NO_DROP) {
            this.f = ProtocolUtil.getTlv2(byteBuffer, this);
            a.a(this.f);
        }
        cn.jiguang.d.a.a.a(this.e);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[LoginResponse] - sid:");
        stringBuilder.append(this.a);
        stringBuilder.append(", serverVersion:");
        stringBuilder.append(this.b);
        stringBuilder.append(", sessionKey:");
        stringBuilder.append(this.c);
        stringBuilder.append(", serverTime:");
        stringBuilder.append(this.d);
        stringBuilder.append(", idc:");
        stringBuilder.append(this.e);
        stringBuilder.append(", connectInfo:");
        stringBuilder.append(this.f);
        stringBuilder.append(" - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeInt4(this.a);
        writeInt2(this.b);
        writeTlv2(this.c);
        writeInt4(this.d);
    }
}
