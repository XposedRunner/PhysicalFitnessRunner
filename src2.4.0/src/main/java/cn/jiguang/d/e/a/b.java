package cn.jiguang.d.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.d.e.a.a.c;
import java.nio.ByteBuffer;

public final class b extends JResponse {
    public b(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
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
