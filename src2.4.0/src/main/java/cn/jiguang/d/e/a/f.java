package cn.jiguang.d.e.a;

import android.support.v4.view.PointerIconCompat;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.ByteBufferUtils;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.c.a;
import cn.jiguang.d.e.a.a.c;
import java.nio.ByteBuffer;

public final class f extends JResponse {
    long a;
    String b;
    String c;
    String d;
    String e;
    String f;

    public f(c cVar, ByteBuffer byteBuffer) {
        super((Object) cVar, byteBuffer);
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final long getJuid() {
        return this.a;
    }

    public final String getName() {
        return "RegisterResponse";
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean isNeedParseeErrorMsg() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void parseBody() {
        super.parseBody();
        ByteBuffer byteBuffer = this.body;
        if (this.code == 0) {
            this.a = ByteBufferUtils.getLong(byteBuffer, this);
            this.b = ProtocolUtil.getTlv2(byteBuffer, this);
            this.c = ProtocolUtil.getTlv2(byteBuffer, this);
        } else if (this.code == 1007) {
            this.e = ProtocolUtil.getTlv2(byteBuffer, this);
        } else {
            if (this.code == PointerIconCompat.TYPE_NO_DROP) {
                this.f = ProtocolUtil.getTlv2(byteBuffer, this);
                a.a(this.f);
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("[RegisterResponse] - juid:");
        stringBuilder.append(this.a);
        stringBuilder.append(", password:");
        stringBuilder.append(this.b);
        stringBuilder.append(", regId:");
        stringBuilder.append(this.c);
        stringBuilder.append(", deviceId:");
        stringBuilder.append(this.d);
        stringBuilder.append(", connectInfo:");
        stringBuilder.append(this.f);
        stringBuilder.append(" - ");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: protected|final */
    public final void writeBody() {
        super.writeBody();
        writeLong8(this.a);
        writeTlv2(this.b);
        writeTlv2(this.c);
        writeTlv2(this.d);
    }
}
