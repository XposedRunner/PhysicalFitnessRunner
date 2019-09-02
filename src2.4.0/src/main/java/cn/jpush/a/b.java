package cn.jpush.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class b extends JResponse {
    int a;
    long b;
    String c;

    public b(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String getName() {
        return "MessagePush";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return false;
    }

    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        this.a = ByteBufferUtils.get(byteBuffer, this).byteValue();
        this.b = ByteBufferUtils.getLong(byteBuffer, this);
        this.c = ProtocolUtil.getTlv2(byteBuffer, this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[MessagePush] - msgType:");
        stringBuilder.append(this.a);
        stringBuilder.append(", msgId:");
        stringBuilder.append(this.b);
        stringBuilder.append(", msgContent:");
        stringBuilder.append(this.c);
        stringBuilder.append(" - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    public final void writeBody() {
        super.writeBody();
        writeInt1(this.a);
        writeLong8(this.b);
        writeTlv2(this.c);
    }
}
