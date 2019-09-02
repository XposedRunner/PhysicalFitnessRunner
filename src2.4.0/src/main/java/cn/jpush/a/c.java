package cn.jpush.a;

import cn.jiguang.api.JRequest;
import cn.jiguang.api.utils.ProtocolUtil;
import java.nio.ByteBuffer;

public final class c extends JRequest {
    String a;
    String b;

    public c(int i, int i2, long j, String str, String str2) {
        super(i, i2, j);
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String getName() {
        return "TagaliasRequest";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    public final void parseBody() {
        ByteBuffer byteBuffer = this.body;
        this.a = ProtocolUtil.getTlv2(byteBuffer);
        this.b = ProtocolUtil.getTlv2(byteBuffer);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[TagaliasRequest] - appKey:");
        stringBuilder.append(this.a);
        stringBuilder.append(", action:");
        stringBuilder.append(this.b);
        stringBuilder.append(" - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    public final void writeBody() {
        writeTlv2(this.a);
        writeTlv2(this.b);
    }
}
