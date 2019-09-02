package cn.jiguang.d.e.a;

import cn.jiguang.api.JResponse;
import cn.jiguang.d.e.a.a.c;
import java.nio.ByteBuffer;

public final class g extends JResponse {
    public g(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final String getName() {
        return "UserCtrlResponse";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    public final void parseBody() {
        super.parseBody();
    }

    public final void writeBody() {
        super.writeBody();
    }
}
