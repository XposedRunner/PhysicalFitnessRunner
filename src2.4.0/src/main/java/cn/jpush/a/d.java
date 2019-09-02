package cn.jpush.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class d extends JResponse {
    String a;
    long b = -1;

    public d(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
    }

    public final String a() {
        return this.a;
    }

    public final String getName() {
        return "TagaliasResponse";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return getCommand() == 10;
    }

    public final void parseBody() {
        super.parseBody();
        if (this.code <= 0) {
            this.a = ProtocolUtil.getTlv2(this.body, this);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[TagaliasResponse] - action:");
        stringBuilder.append(this.a);
        stringBuilder.append(" - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    public final void writeBody() {
        super.writeBody();
    }
}
