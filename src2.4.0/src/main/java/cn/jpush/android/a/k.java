package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JResponse;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.a.b;
import cn.jpush.android.a;
import cn.jpush.android.d.g;
import cn.jpush.android.data.c;
import cn.jpush.android.service.ServiceInterface;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public final class k {
    public static long a(Context context, long j, JResponse jResponse) {
        b bVar = (b) jResponse;
        int a = bVar.a();
        long b = bVar.b();
        long longValue = bVar.getRid().longValue();
        long uid = JCoreInterface.getUid();
        byte b2 = (byte) a;
        int sid = JCoreInterface.getSid();
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(1);
        outputDataUtil.writeU8(4);
        outputDataUtil.writeU64(longValue);
        outputDataUtil.writeU32((long) sid);
        outputDataUtil.writeU64(uid);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(b2);
        outputDataUtil.writeU64(b);
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        JCoreInterface.sendData(a.e, a.a, 4, outputDataUtil.toByteArray());
        long b3 = bVar.b();
        a = bVar.a();
        String c = bVar.c();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c));
        try {
            String readLine = lineNumberReader.readLine();
            if (readLine == null) {
                return -1;
            }
            String readLine2 = lineNumberReader.readLine();
            if (readLine2 == null) {
                return -1;
            }
            int length = (readLine.length() + readLine2.length()) + 2;
            c = c.length() > length + 1 ? c.substring(length) : "";
            if (a == 0 || a == 2) {
                Context context2 = context;
                try {
                    cn.jpush.android.d.k kVar = new cn.jpush.android.d.k("PushMessageProcessor", "Time to process received msg.");
                    if (!(TextUtils.isEmpty(readLine) || TextUtils.isEmpty(readLine2) || TextUtils.isEmpty(c))) {
                        a(context2, readLine, readLine2, c, b3, (byte) 0);
                    }
                    kVar.a();
                } catch (Exception unused) {
                }
            } else if (a == 20) {
                return n.a(context, c, 0, -1);
            } else {
                JCoreInterface.processCtrlReport(a);
            }
            return jResponse.getRid().longValue();
        } catch (IOException unused2) {
            return -1;
        }
    }

    public static void a(Context context, String str, String str2, String str3, long j, byte b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        cn.jpush.android.data.a a = i.a(context, str3, str, str2, stringBuilder.toString());
        if (a != null && !g.a(context, new c(a))) {
            a.e = b;
            int i = 0;
            if (str2 == null || !str2.equalsIgnoreCase("7fef6a7d76c782b1f0eda446b2c6c40a")) {
                i = a.f ? a.b == 4 ? 3 : 1 : 2;
            } else {
                i.a(context, a);
            }
            new StringBuilder().append(j);
            if (!((2 & i) == 0 || (TextUtils.isEmpty(a.j) && TextUtils.isEmpty(a.n)))) {
                cn.jpush.android.d.a.a(context, (cn.jpush.android.data.b) a);
            }
            if (!((1 & i) == 0 || ServiceInterface.d(context))) {
                if (cn.jpush.android.d.a.c(context)) {
                    a.i = true;
                    i.a(context, a);
                } else {
                    e.a(a.c, 986, null, context);
                }
            }
        }
    }
}
