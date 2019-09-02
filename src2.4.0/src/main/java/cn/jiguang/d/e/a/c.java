package cn.jiguang.d.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class c extends JResponse {
    long a;
    String b;

    public c(cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final long a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String getName() {
        return "CtrlResponse";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return false;
    }

    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.a = ByteBufferUtils.getLong(byteBuffer, this);
        this.b = ProtocolUtil.getTlv2(byteBuffer, this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[CtrlResponse] - senderId:");
        stringBuilder.append(this.a);
        stringBuilder.append(", msgContent:");
        stringBuilder.append(this.b);
        stringBuilder.append(" - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeLong8(this.a);
        writeTlv2(this.b);
    }
}
