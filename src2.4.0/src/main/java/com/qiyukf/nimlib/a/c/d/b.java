package com.qiyukf.nimlib.a.c.d;

import com.qiyukf.nimlib.a.c.a;
import com.qiyukf.nimlib.h.c.c.d;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    private List<String> a = new ArrayList(1);

    public final void a(String str, SessionTypeEnum sessionTypeEnum) {
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        if (sessionTypeEnum == SessionTypeEnum.P2P) {
            str2 = "p2p|";
        } else if (sessionTypeEnum == SessionTypeEnum.Team) {
            str2 = "team|";
        } else {
            throw new IllegalArgumentException("only support p2p and team.");
        }
        stringBuilder.append(str2);
        stringBuilder.append(str);
        this.a.add(stringBuilder.toString());
    }

    public final com.qiyukf.nimlib.h.c.c.b b() {
        com.qiyukf.nimlib.h.c.c.b bVar = new com.qiyukf.nimlib.h.c.c.b();
        d.a(bVar, this.a);
        return bVar;
    }

    public final byte c() {
        return (byte) 7;
    }

    public final byte d() {
        return (byte) 9;
    }
}
