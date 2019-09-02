package cn.jpush.a;

import cn.jiguang.api.JResponse;
import java.nio.ByteBuffer;

public final class a extends JResponse {
    public a(Object obj, ByteBuffer byteBuffer) {
        super(obj, byteBuffer);
    }

    public final String getName() {
        return "CommonResponse";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    public final void parseBody() {
        super.parseBody();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[CommonResponse] - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    public final void writeBody() {
        super.writeBody();
    }
}
