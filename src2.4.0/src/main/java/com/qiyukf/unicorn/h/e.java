package com.qiyukf.unicorn.h;

import android.support.v4.util.LruCache;
import android.util.Base64;
import android.util.SparseArray;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.nimlib.e.b;
import com.qiyukf.nimlib.i.c;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.f.a.d;
import com.qiyukf.unicorn.f.a.d.n;
import com.qiyukf.unicorn.f.a.f;

public final class e {
    private LruCache<String, SparseArray<n>> a;

    private static class a {
        private static e a = new e();
    }

    private e() {
        this.a = new LruCache(5);
    }

    /* synthetic */ e(byte b) {
        this();
    }

    public final void a(long j, String str, n nVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(nVar.c());
        String stringBuilder2 = stringBuilder.toString();
        SparseArray sparseArray = (SparseArray) this.a.get(stringBuilder2);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.a.put(stringBuilder2, sparseArray);
        }
        sparseArray.put(nVar.e(), nVar);
        if (sparseArray.size() == nVar.d()) {
            this.a.remove(stringBuilder2);
            stringBuilder = new StringBuilder();
            for (int i = 0; i < sparseArray.size(); i++) {
                stringBuilder.append(((n) sparseArray.get(i)).f());
            }
            d a = f.a().parse(new String(Base64.decode(stringBuilder.toString(), 0)));
            if (a != null) {
                if (nVar.a() == 1) {
                    c.a(MessageBuilder.createCustomReceivedMessage(str, SessionTypeEnum.Ysf, nVar.b(), a, j));
                    return;
                }
                b.a(MessageBuilder.createCustomReceivedNotification(str, (com.qiyukf.unicorn.f.a.e) a, j));
            }
        }
    }
}
